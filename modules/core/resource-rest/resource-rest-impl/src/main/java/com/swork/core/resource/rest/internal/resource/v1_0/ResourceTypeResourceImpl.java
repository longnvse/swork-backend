package com.swork.core.resource.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import com.swork.common.util.api.CommonUtil;
import com.swork.core.resource.rest.dto.v1_0.ResourceType;
import com.swork.core.resource.rest.internal.service.ResourceTypeService;
import com.swork.core.resource.rest.internal.validator.ResourceTypeValidator;
import com.swork.core.resource.rest.resource.v1_0.ResourceTypeResource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Long Hip
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/resource-type.properties",
        scope = ServiceScope.PROTOTYPE, service = ResourceTypeResource.class
)
public class ResourceTypeResourceImpl extends BaseResourceTypeResourceImpl {

    @Override
    public Page<ResourceType> getResourceTypePages(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
        if (Validator.isNotNull(search)) {
            search = commonUtil.vnNormalize(search);
        }

        return service.getResourceTypePages(
                getUserToken().getBusinessId(),
                search,
                filter,
                pagination,
                sorts,
                getServiceContext());
    }

    @Override
    public ResourceType postResourceType(ResourceType resourceType) throws Exception {
        validator.validateForAdd(
                getUserToken().getBusinessId(),
                resourceType);

        return service.postResourceType(
                getUserToken().getBusinessId(),
                getUserToken().getAccountId(),
                resourceType,
                getServiceContext());
    }

    @Override
    public void deleteResourceType(Long id) throws Exception {
        validator.validateExist(id);
        service.deleteResourceType(id);
    }

    @Override
    public ResourceType getResourceType(Long id) throws Exception {
        validator.validateExist(id);
        return service.getResourceType(id);
    }

    @Override
    public ResourceType putResourceType(Long id, ResourceType resourceType) throws Exception {
        validator.validateForUpdate(
                getUserToken().getBusinessId(),
                id,
                resourceType);

        return service.putResourceType(
                getUserToken().getAccountId(),
                id,
                resourceType,
                getServiceContext());
    }

    @Override
    public Object getResourceTypesFromResources(Long workId, Long phaseId, Long projectId) throws Exception {
        return service.getResourceTypeByParentResource(
                getUserToken().getBusinessId(),
                workId,
                phaseId,
                projectId,
                getServiceContext()
        );
    }

    @Override
    public Long getTotalMoneyInProject(Long resourceTypeId, Long workId, Long phaseId, Long projectId) throws Exception {
        return service.getTotalMoneyByResourceParentId(
                getUserToken().getBusinessId(),
                resourceTypeId,
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
    private ResourceTypeService service;
    @Reference
    private CommonUtil commonUtil;

    @Reference
    private ResourceTypeValidator validator;
}