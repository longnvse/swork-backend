package com.swork.core.resource.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.search.generic.MatchQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.core.resource.rest.dto.v1_0.ResourceType;
import com.swork.core.resource.rest.internal.mapper.ResourceTypeMapper;
import com.swork.core.resource.service.constant.SearchFields;
import com.swork.core.resource.service.mapper.model.ResourceTypeMapperModel;
import com.swork.core.resource.service.model.ResourceTypeEntry;
import com.swork.core.resource.service.retriever.ResourceRetriever;
import com.swork.core.resource.service.service.ResourceTypeEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        service = ResourceTypeService.class
)
public class ResourceTypeService {
    public Page<ResourceType> getResourceTypePages(long businessId,
                                                   String search,
                                                   Filter filter,
                                                   Pagination pagination,
                                                   Sort[] sorts,
                                                   ServiceContext serviceContext) throws Exception {
        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {

                    TermsFilter termsFilter = new TermsFilter(SearchFields.BUSINESS_ID);
                    termsFilter.addValues(String.valueOf(businessId));
                    termsFilter.addValues(String.valueOf(GetterUtil.DEFAULT_LONG));


                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();
                    booleanFilter.add(termsFilter, BooleanClauseOccur.MUST);

                    if (Validator.isNull(search) || search.isBlank()) {
                        MatchQuery parentTypeIdFilter =
                                new MatchQuery(SearchFields.PARENT_ID, String.valueOf(GetterUtil.DEFAULT_LONG));
                        booleanQuery.add(parentTypeIdFilter, BooleanClauseOccur.MUST);

                    }
                },
                filter,
                ResourceTypeEntry.class.getName(),
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
                            localService.getResourceTypeEntry(id)
                    );
                }
        );

    }

    public JSONObject getResourceTypeByParentResource(long businessId,
                                                      Long taskId,
                                                      Long phaseId,
                                                      Long projectId,
                                                      ServiceContext serviceContext) throws SearchException, ParseException {
        Set<Long> setResourceTypeId = resourceRetriever.setOfResourceTypeByParentId(businessId, taskId, phaseId, projectId, serviceContext);

        List<ResourceType> resourceTypeList = setResourceTypeId.stream().map(this::getResourceType).collect(Collectors.toList());

        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

        jsonObject.put("resourceTypes", resourceTypeList);

        return jsonObject;

    }

    public long getTotalMoneyByResourceParentId(long businessId,
                                                long resourceTypeId,
                                                Long taskId,
                                                Long phaseId,
                                                Long projectId,
                                                ServiceContext serviceContext) throws SearchException, ParseException {
        Document[] resourceTypes =
                resourceRetriever.getByResourceTypeIdAndParentId(businessId, resourceTypeId, taskId, phaseId, projectId, serviceContext);

        return Arrays
                .stream(resourceTypes)
                .reduce(
                        0L,
                        (total, document) -> total + GetterUtil.getLong(document.get(SearchFields.TOTAL_AMOUNT)),
                        Long::sum);
    }

    public ResourceType postResourceType(long businessId,
                                         long creatorId,
                                         ResourceType dto,
                                         ServiceContext context) {
        ResourceTypeMapperModel model =
                mapper.mapDTOToMapperModel(dto);

        ResourceTypeEntry entry =
                localService.addResourceTypeEntry(businessId, creatorId, model, context);

        return mapper.mapEntryToDTO(entry);
    }

    public ResourceType putResourceType(long creatorId,
                                        long resourceTypeId,
                                        ResourceType dto,
                                        ServiceContext context) {
        ResourceTypeMapperModel model =
                mapper.mapDTOToMapperModel(dto);

        ResourceTypeEntry entry =
                localService.updateResourceTypeEntry(creatorId, resourceTypeId, model, context);

        return mapper.mapEntryToDTO(entry);
    }

    public ResourceType getResourceType(long resourceTypeId) {

        ResourceTypeEntry entry =
                localService.fetchResourceTypeEntry(resourceTypeId);

        return mapper.mapEntryToDTO(entry);
    }

    public void deleteResourceType(long resourceTypeId) throws PortalException {
        localService.deleteResourceTypeEntry(resourceTypeId);
    }

    @Reference
    private ResourceTypeEntryLocalService localService;

    @Reference
    private ResourceTypeMapper mapper;

    @Reference
    private ResourceRetriever resourceRetriever;
}
