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

@ProviderType
public interface ResourceRetriever {
    Document[] getByTypeAndParent(long customerId,
                                  String typeResource,
                                  Long taskId,
                                  Long phaseId,
                                  Long projectId,
                                  ServiceContext serviceContext) throws ParseException, SearchException;
}
