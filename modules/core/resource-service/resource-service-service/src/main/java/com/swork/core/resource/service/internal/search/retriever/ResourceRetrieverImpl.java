package com.swork.core.resource.service.internal.search.retriever;

import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.swork.core.resource.service.constant.SearchFields;
import com.swork.core.resource.service.model.ResourceEntry;
import com.swork.core.resource.service.retriever.ResourceRetriever;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
        scope = ServiceScope.PROTOTYPE, service = ResourceRetriever.class
)
public class ResourceRetrieverImpl implements ResourceRetriever {


    @Override
    public Document[] getByTypeAndParent(long customerId,
                                         String typeResource,
                                         Long taskId,
                                         Long phaseId,
                                         Long projectId, ServiceContext serviceContext) throws SearchException {
        SearchContext searchContext = new SearchContext();

        searchContext.setCompanyId(serviceContext.getCompanyId());
        searchContext.setSorts(new Sort(Field.NAME, Sort.STRING_TYPE, false));

        BooleanQuery booleanQuery = buildQuery(customerId, typeResource, taskId, phaseId, projectId);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return hits.getDocs();
    }

    private BooleanQuery buildQuery(long customerId,
                                    String typeResource,
                                    Long taskId,
                                    Long phaseId,
                                    Long projectId) {
        TermFilter customerFilter = new TermFilter(SearchFields.BUSINESS_ID, Long.toString(customerId));
        TermFilter resourceTypeFilter = new TermFilter(SearchFields.TYPE_RESOURCE, typeResource.trim().toLowerCase());

        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(customerFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(resourceTypeFilter, BooleanClauseOccur.MUST);

        return buildBooleanQueryByParent(booleanFilter, taskId, phaseId, projectId);
    }

    private BooleanQuery buildBooleanQueryByParent(BooleanFilter booleanFilter,
                                                   Long taskId,
                                                   Long phaseId,
                                                   Long projectId) {
        BooleanQuery booleanQuery = new BooleanQueryImpl();
        booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, ResourceEntry.class.getName());
        booleanQuery.setPreBooleanFilter(booleanFilter);

        if (GetterUtil.getLong(taskId) != 0) {
            booleanQuery.addRequiredTerm(SearchFields.WORK_ID, taskId);
        }

        if (GetterUtil.getLong(phaseId) != 0) {
            booleanQuery.addRequiredTerm(SearchFields.PHASE_ID, phaseId);
        }

        if (GetterUtil.getLong(projectId) != 0) {
            booleanQuery.addRequiredTerm(SearchFields.PROJECT_ID, projectId);
        }

        return booleanQuery;
    }
}
