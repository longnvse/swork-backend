package com.swork.core.work.rest.internal.service;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.core.work.rest.dto.v1_0.Work;
import com.swork.core.work.rest.internal.mapper.WorkMapper;
import com.swork.core.work.service.constant.SearchFields;
import com.swork.core.work.service.mapper.model.WorkMapperModel;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.service.WorkEntryLocalService;
import com.swork.core.work.service.service.WorkMemberEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

@Component(
        immediate = true,
        service = WorkService.class
)
public class WorkService {

    public Page<Work> getWorkPages(long businessId,
                                   Long projectId,
                                   Long phaseId,
                                   Boolean isTree,
                                   String search,
                                   Filter filter,
                                   Pagination pagination,
                                   Sort[] sorts,
                                   ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {

                    TermFilter businessIdFilter =
                            new TermFilter(SearchFields.BUSINESS_ID, String.valueOf(businessId));
                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(businessIdFilter, BooleanClauseOccur.MUST);
                    if (GetterUtil.getBoolean(isTree)) {
                        TermFilter parentIdFilter =
                                new TermFilter(SearchFields.PARENT_ID, String.valueOf(GetterUtil.DEFAULT_LONG));
                        booleanFilter.add(parentIdFilter, BooleanClauseOccur.MUST);

                    }

                    if (Validator.isNotNull(projectId)) {
                        TermFilter projectIdFilter =
                                new TermFilter(SearchFields.PROJECT_ID, String.valueOf(projectId));

                        booleanFilter.add(projectIdFilter, BooleanClauseOccur.MUST);
                    }
                    if (Validator.isNotNull(phaseId)) {
                        TermFilter phaseIdFilter =
                                new TermFilter(SearchFields.PHASE_ID, String.valueOf(phaseId));

                        booleanFilter.add(phaseIdFilter, BooleanClauseOccur.MUST);
                    }
                },
                filter,
                WorkEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long workId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapDTOFromEntry(localService.getWorkEntry(workId), GetterUtil.getBoolean(isTree));
                });
    }

    public Work postWork(long businessId,
                         long creatorId,
                         Work project,
                         ServiceContext serviceContext) {

        WorkMapperModel workMapperModel = mapper.mapModelFromDTO(serviceContext.getCompanyId(), project);

        WorkEntry entry = localService.addWorkEntry(businessId, creatorId, workMapperModel, serviceContext);

        return mapper.mapDTOFromEntry(entry, false);
    }

    public Work putWork(long creatorId,
                        long workId,
                        Work project,
                        ServiceContext serviceContext) {

        WorkMapperModel workMapperModel = mapper.mapModelFromDTO(serviceContext.getCompanyId(), project);

        WorkEntry entry = localService.updateWorkEntry(creatorId, workId, workMapperModel, serviceContext);

        return mapper.mapDTOFromEntry(entry, false);
    }

    public Work getWork(long workId) {
        WorkEntry entry = localService.fetchWorkEntry(workId);

        return mapper.mapDTOFromEntry(entry, true);
    }

    public void deleteWork(long workId) throws PortalException {
        memberEntryLocalService.deleteByWorkId(workId);
        localService.deleteWorkEntry(workId);
    }

    public void updateStatus(long creatorId,
                             long workId,
                             String status,
                             ServiceContext serviceContext) {
        localService.updateStatus(creatorId, workId, status, serviceContext);
    }

    public void reportProgressByAmount(long creatorId,
                                       long workId,
                                       double completeAmount,
                                       ServiceContext serviceContext) {
        localService.reportProgressByAmount(
                creatorId,
                workId,
                completeAmount,
                serviceContext
        );
    }

    @Reference
    private WorkMapper mapper;

    @Reference
    private WorkEntryLocalService localService;

    @Reference
    private WorkMemberEntryLocalService memberEntryLocalService;
}
