package com.swork.business.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.business.rest.dto.v1_0.Business;
import com.swork.business.rest.internal.odata.v1_0.BusinessEntityIndexModel;
import com.swork.business.rest.internal.service.BusinessService;
import com.swork.business.rest.internal.validator.BusinessValidator;
import com.swork.business.rest.resource.v1_0.BusinessResource;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @author Long Hip
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/business.properties",
        scope = ServiceScope.PROTOTYPE, service = BusinessResource.class
)
public class BusinessResourceImpl extends BaseBusinessResourceImpl {
    private final EntityModel businessEntityIndexModel = new BusinessEntityIndexModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
        return businessEntityIndexModel;
    }

    @Override
    public Page<Business> getbusinessPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
        return service.getBusinessPages(
                search,
                filter,
                pagination,
                sorts,
                getServiceContext()
        );
    }

    @Override
    public Business postBusiness(Business business) throws Exception {
        validator.validatorForPostBusiness(business);

        return service.postBusiness(
                getUserToken().getAccountId(),
                business,
                getServiceContext()
        );
    }

    @Override
    public void deleteBusiness(Long businessId) throws Exception {
        validator.validatorBusinessIsExists(businessId);

        service.deleteBusiness(businessId);
    }

    @Override
    public Business getBusiness(Long businessId) throws Exception {
        validator.validatorBusinessIsExists(businessId);

        return service.getBusiness(businessId);
    }

    @Override
    public Business putBusiness(Long businessId, Business business) throws Exception {
        validator.validatorForPutBusiness(businessId, business);

        return service.putBusiness(
                getUserToken().getAccountId(),
                businessId,
                business,
                getServiceContext()
        );
    }

    @Override
    public void approvalBusiness(Long businessId, String status) throws Exception {
        validator.validatorBusinessIsExists(businessId);

        service.approvalBusiness(
                getUserToken().getAccountId(),
                businessId,
                status,
                getServiceContext()
        );
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
    private BusinessService service;

    @Reference
    private BusinessValidator validator;

    @Reference
    private CommonTokenHelper tokenHelper;
}