package com.swork.core.resource.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import com.swork.common.util.api.CommonUtil;
import com.swork.core.resource.rest.dto.v1_0.Resource;
import com.swork.core.resource.rest.internal.odata.v1_0.ResourceEntityModel;
import com.swork.core.resource.rest.internal.service.ResourceService;
import com.swork.core.resource.rest.internal.validator.ResourceValidator;
import com.swork.core.resource.rest.resource.v1_0.ResourceResource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @author Long Hip
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/resource.properties",
        scope = ServiceScope.PROTOTYPE, service = ResourceResource.class
)
public class ResourceResourceImpl extends BaseResourceResourceImpl {
    private final EntityModel entityModel = new ResourceEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
        return entityModel;
    }

    @Override
    public Page<Resource> getResourcePages(Long projectId, Long phaseId, Long workId, String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
        if (Validator.isNotNull(search)) {
            search = commonUtil.vnNormalize(search);
        }

        return service.getResourcePages(
                getUserToken().getBusinessId(),
                projectId,
                phaseId,
                workId,
                search,
                filter,
                pagination,
                sorts,
                getServiceContext());
    }

    @Override
    public Resource postResource(Long projectId, Long phaseId, Long workId, Resource resource) throws Exception {
        validator.validateForAdd(resource);

        return service.postResource(
                getUserToken().getBusinessId(),
                getUserToken().getAccountId(),
                projectId,
                phaseId,
                workId,
                resource,
                getServiceContext()
        );
    }

    @Override
    public void deleteResource(Long id) throws Exception {
        validator.validateExist(id);

        service.deleteResource(id);
    }

    @Override
    public Resource getResource(Long id) throws Exception {
        validator.validateExist(id);

        return service.getResource(id);
    }

    @Override
    public void putResource(Long id, Resource resource) throws Exception {
        validator.validateExist(id);
        validator.validateForAdd(resource);

        service.putResource(
                getUserToken().getAccountId(),
                id,
                resource,
                getServiceContext()
        );
    }

    @Override
    public Long getTotalMoneyInProject(String typeResource, Long workId, Long phaseId, Long projectId) throws Exception {
        return service.getTotalMoneyByTypeResource(
                getUserToken().getBusinessId(),
                typeResource,
                workId,
                phaseId,
                projectId,
                getServiceContext());
    }

    public ServiceContext getServiceContext() {

        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());

        return serviceContext;
    }

    private UserTokenModel getUserToken() {
        return tokenHelper.getUserToken(contextHttpServletRequest);
    }

    @Reference
    private CommonTokenHelper tokenHelper;

    @Reference
    private ResourceService service;
    @Reference
    private CommonUtil commonUtil;
    @Reference
    private ResourceValidator validator;
}