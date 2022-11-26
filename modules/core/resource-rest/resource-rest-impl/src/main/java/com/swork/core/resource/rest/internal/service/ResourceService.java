package com.swork.core.resource.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.core.resource.rest.dto.v1_0.Resource;
import com.swork.core.resource.rest.internal.mapper.ResourceMapper;
import com.swork.core.resource.service.constant.SearchFields;
import com.swork.core.resource.service.mapper.model.ResourceMapperModel;
import com.swork.core.resource.service.model.ResourceEntry;
import com.swork.core.resource.service.retriever.ResourceRetriever;
import com.swork.core.resource.service.service.ResourceEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.Collections;

@Component(immediate = true, service = ResourceService.class)
public class ResourceService {
    public Page<Resource> getResourcePages(long businessId,
                                           Long projectId,
                                           Long phaseId,
                                           Long workId,
                                           String search,
                                           Filter filter,
                                           Pagination pagination,
                                           Sort[] sorts,
                                           ServiceContext serviceContext) throws Exception {


        if (Validator.isNull(sorts) || sorts.length == GetterUtil.DEFAULT_INTEGER) {
            sorts = new Sort[]{new Sort(SearchFields.getDateSortable(SearchFields.DATE_RESOURCE), true)};
        }

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                    TermFilter businessIdFilter =
                            new TermFilter(SearchFields.BUSINESS_ID, String.valueOf(businessId));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();
                    booleanFilter.add(businessIdFilter, BooleanClauseOccur.MUST);

                    if (Validator.isNotNull(projectId)) {
                        TermFilter projectIdIdFilter =
                                new TermFilter(SearchFields.PROJECT_ID, String.valueOf(projectId));

                        booleanFilter.add(projectIdIdFilter, BooleanClauseOccur.MUST);
                    }

                    if (Validator.isNotNull(phaseId)) {
                        TermFilter phaseIdIdFilter =
                                new TermFilter(SearchFields.PHASE_ID, String.valueOf(phaseId));

                        booleanFilter.add(phaseIdIdFilter, BooleanClauseOccur.MUST);
                    }

                    if (Validator.isNotNull(workId)) {
                        TermFilter phaseIdIdFilter =
                                new TermFilter(SearchFields.WORK_ID, String.valueOf(workId));

                        booleanFilter.add(phaseIdIdFilter, BooleanClauseOccur.MUST);
                    }
                },
                filter,
                ResourceEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK
                ),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long id = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapEntryToDTO(
                            localService.getResourceEntry(id)
                    );
                }
        );

    }


    public Resource postResource(long businessId,
                                 long creatorId,
                                 Long projectId,
                                 Long phaseId,
                                 Long workId,
                                 Resource resource,
                                 ServiceContext serviceContext) {
        ResourceMapperModel model = mapper.mapDTOToMapperModel(resource);
        ResourceEntry resourceEntry = localService.addResourceEntry(
                businessId,
                creatorId,
                workId,
                phaseId,
                projectId,
                model,
                serviceContext);

        return mapper.mapEntryToDTO(resourceEntry);
    }


    public void putResource(long creatorId,
                            long resourceId,
                            Resource resource,
                            ServiceContext serviceContext) {

        ResourceMapperModel model = mapper.mapDTOToMapperModel(resource);

        localService.updateResourceEntry(
                creatorId,
                resourceId,
                model,
                serviceContext);

    }

    public void deleteResource(long resourceId) throws PortalException {
        localService.deleteResourceEntry(resourceId);
    }

    public Resource getResource(long resourceId) {

        return mapper.mapEntryToDTO(localService.fetchResourceEntry(resourceId));
    }

    public long getTotalMoneyByTypeResource(long businessId,
                                            String typeResource,
                                            Long taskId,
                                            Long phaseId,
                                            Long projectId,
                                            ServiceContext serviceContext) throws SearchException, ParseException {
        Document[] resourceTypes =
                resourceRetriever.getByTypeAndParent(businessId, typeResource, taskId, phaseId, projectId, serviceContext);

        return Arrays
                .stream(resourceTypes)
                .reduce(
                        0L,
                        (total, document) -> total + GetterUtil.getLong(document.get(SearchFields.TOTAL_AMOUNT)),
                        Long::sum);
    }

    @Reference
    private ResourceEntryLocalService localService;

    @Reference
    private ResourceMapper mapper;

    @Reference
    private ResourceRetriever resourceRetriever;
}
