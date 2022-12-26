package com.swork.notification.rest.internal.service;

import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.notification.rest.dto.v2_0.Notification;
import com.swork.notification.rest.internal.mapper.NotificationMapper;
import com.swork.notification.service.constant.SearchFields;
import com.swork.notification.service.model.NotificationEntry;
import com.swork.notification.service.service.NotificationEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = NotificationService.class)

public class NotificationService {
    private static final String NoRead = "noRead";

    public Page<Notification> getNotification(Pagination pagination,
                                              long businessId,
                                              long employeeId,
                                              String category,
                                              String status,
                                              ServiceContext serviceContext) throws SearchException {
        List<Notification> list =
                notificationMapper.mapNotificationListFromNotificationDocuments(
                        searchNotificationByStatusAndType(
                                serviceContext.getCompanyId(),
                                employeeId,
                                businessId,
                                category,
                                status,
                                pagination.getStartPosition(),
                                pagination.getEndPosition()));

        int total =
                countNotificationByStartAndType(
                        serviceContext.getCompanyId(),
                        employeeId,
                        businessId,
                        category,
                        status);

        return Page.of(list, pagination, total);
    }

    public Document[] searchNotificationByStatusAndType(long companyId,
                                                        long receiverId,
                                                        long businessId,
                                                        String category,
                                                        String status,
                                                        int start,
                                                        int end) throws SearchException {

        SearchContext searchContext = new SearchContext();
        Sort sort = new Sort();
        sort.setFieldName((SearchFields.TIME + "_Number_sortable"));
        sort.setType(3);
        sort.setReverse(true);
        searchContext.setSorts(sort);
        searchContext.setCompanyId(companyId);
        searchContext.setStart(start);
        searchContext.setEnd(end);


        BooleanQuery booleanQuery = buildQueryTypeAndStatus(receiverId, businessId, category, status);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return hits.getDocs();
    }

    public int countNotificationByStartAndType(long companyId,
                                               long receiverId,
                                               long businessId,
                                               String category,
                                               String status) throws SearchException {
        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(companyId);
        BooleanQuery booleanQuery = buildQueryTypeAndStatus(receiverId, businessId, category, "noRed");

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return hits.getDocs().length;
    }

    public int countNotificationStatus(long companyId,
                                       long receiverId,
                                       long businessId,
                                       String category) throws SearchException {
        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(companyId);

        BooleanQuery booleanQuery = buildQuery(receiverId, businessId, category);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return hits.getDocs().length;
    }

    public Document[] searchNotificationByStatus(long companyId,
                                                 long receiverId,
                                                 long businessId,
                                                 String category) throws SearchException {

        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(companyId);
        Sort sort = new Sort();
        sort.setFieldName((SearchFields.TIME + "_Number_sortable"));
        sort.setType(3);
        sort.setReverse(true);
        searchContext.setSorts(sort);

        BooleanQuery booleanQuery = buildQuery(receiverId, businessId, category);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return hits.getDocs();
    }

    private BooleanQuery buildQuery(long receiverId,
                                    long businessId,
                                    String category) {

        TermFilter receiverFilter = new TermFilter(SearchFields.RECEIVER_ID, Long.toString(receiverId));
        TermFilter businessIdFilter = new TermFilter(SearchFields.BUSINESS_ID, Long.toString(businessId));
        TermFilter statusReadFilter = new TermFilter(SearchFields.STATUS, NoRead);

        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(receiverFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(businessIdFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(statusReadFilter, BooleanClauseOccur.MUST);

        if (Validator.isNotNull(category)) {
            TermFilter categoryFilter = new TermFilter(SearchFields.CATEGORY, category);
            booleanFilter.add(categoryFilter, BooleanClauseOccur.MUST);
        }

        BooleanQuery booleanQuery = new BooleanQueryImpl();
        booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, NotificationEntry.class.getName());
        booleanQuery.setPreBooleanFilter(booleanFilter);

        return booleanQuery;
    }

    private BooleanQuery buildQueryTypeAndStatus(long receiverId,
                                                 long businessId,
                                                 String category,
                                                 String status) {

        TermFilter receiverFilter = new TermFilter(SearchFields.RECEIVER_ID, Long.toString(receiverId));
        TermFilter businessIdFilter = new TermFilter(SearchFields.BUSINESS_ID, Long.toString(businessId));

        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(receiverFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(businessIdFilter, BooleanClauseOccur.MUST);
        if (Validator.isNotNull(category)) {
            String[] categoryArray = category.split(" ");
            BooleanFilter categoryBooleanFilter = new BooleanFilter();
            for (String cate : categoryArray) {
                TermFilter categoryFilter = new TermFilter(SearchFields.CATEGORY, cate);
                categoryBooleanFilter.add(categoryFilter, BooleanClauseOccur.SHOULD);
            }
            booleanFilter.add(categoryBooleanFilter, BooleanClauseOccur.MUST);
        }

        if (Validator.isNotNull(status)) {
            TermFilter statusFilter = new TermFilter(SearchFields.STATUS, status);
            booleanFilter.add(statusFilter, BooleanClauseOccur.MUST);
        }

        BooleanQuery booleanQuery = new BooleanQueryImpl();
        booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, NotificationEntry.class.getName());
        booleanQuery.setPreBooleanFilter(booleanFilter);

        return booleanQuery;
    }

    @Reference
    private NotificationMapper notificationMapper;

    @Reference
    private NotificationEntryLocalService notificationEntryLocalService;

}
