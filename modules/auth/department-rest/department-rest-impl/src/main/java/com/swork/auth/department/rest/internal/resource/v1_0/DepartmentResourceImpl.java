package com.swork.auth.department.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.auth.department.rest.dto.v1_0.Department;
import com.swork.auth.department.rest.internal.service.DepartmentService;
import com.swork.auth.department.rest.internal.validator.DepartmentValidator;
import com.swork.auth.department.rest.resource.v1_0.DepartmentResource;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Long Hip
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/department.properties",
	scope = ServiceScope.PROTOTYPE, service = DepartmentResource.class
)
public class DepartmentResourceImpl extends BaseDepartmentResourceImpl {
	@Override
	public Page<Department> getDepartmentPages(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		return service.getDepartmentsPage(
				getUserToken().getBusinessId(),
				search,
				filter,
				pagination,
				sorts,
				getServiceContext());
	}

	@Override
	public Department postDepartment(Department department) throws Exception {
		validator.validatorForPostBusiness(department);
		return service.postDepartment(
				getUserToken().getBusinessId(),
				getUserToken().getAccountId(),
				department,
				getServiceContext());
	}

	@Override
	public void deleteDepartment(Long id) throws Exception {
		validator.validatorDepartmentIsExists(id);
		service.deleteById(id);
	}

	@Override
	public Department getById(Long id) throws Exception {
		validator.validatorDepartmentIsExists(id);
		return service.geById(id);
	}

	@Override
	public Department updateDepartment(Long id, Department department) throws Exception {
		validator.validatorFieldsForUpdateDepartment(id,department);
		return service.updateDepartment(getUserToken().getAccountId(),id,department,getServiceContext());
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
//		getUserToken().
					//account //department //business
	}

	@Reference
	private CommonTokenHelper tokenHelper;

	@Reference
	private DepartmentValidator validator;


	@Reference
	DepartmentService service;
}