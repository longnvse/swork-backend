package com.swork.core.resource.service.retriever;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.core.resource.service.mapper.model.ResourceMapperModel;
import org.osgi.annotation.versioning.ProviderType;

import java.util.List;
import java.util.Set;

@ProviderType
public interface ResourceRetriever {

    List<ResourceMapperModel> getResourceByProjectOrPhase(long customerId,
                                                          Long projectId,
                                                          Long phaseId,
                                                          String search,
                                                          Filter filter,
                                                          Pagination pagination,
                                                          Sort[] sorts,
                                                          ServiceContext serviceContext) throws SearchException, ParseException;

    int countTasks(long companyId,
                   long customerId,
                   Long projectId,
                   Long phaseId,
                   String keyword,
                   Filter filter) throws SearchException, ParseException;

    Long ValueResourceType(long customerId,
                           Long projectId,
                           Long phaseId,
                           String code,
                           Boolean checkStatus);

    Long ValueObjectGroup(long customerId,
                          Long projectId,
                          Long phaseId);

    Set<Long> setOfResourceTypeByParentId(long customerId,
                                          Long taskId,
                                          Long phaseId,
                                          Long projectId,
                                          ServiceContext serviceContext) throws ParseException, SearchException;

    Document[] getByResourceTypeIdAndParentId(long customerId,
                                              long resourceTypeId,
                                              Long taskId,
                                              Long phaseId,
                                              Long projectId,
                                              ServiceContext serviceContext) throws ParseException, SearchException;
}
