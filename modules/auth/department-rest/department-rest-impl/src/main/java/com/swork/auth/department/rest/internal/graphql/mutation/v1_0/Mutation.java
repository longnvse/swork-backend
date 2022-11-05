package com.swork.auth.department.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import com.swork.auth.department.rest.dto.v1_0.Department;
import com.swork.auth.department.rest.resource.v1_0.DepartmentResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setDepartmentResourceComponentServiceObjects(
		ComponentServiceObjects<DepartmentResource>
			departmentResourceComponentServiceObjects) {

		_departmentResourceComponentServiceObjects =
			departmentResourceComponentServiceObjects;
	}

	@GraphQLField
	public Department createDepartment(
			@GraphQLName("department") Department department)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.postDepartment(
				department));
	}

	@GraphQLField
	public Response createDepartmentBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.postDepartmentBatch(
				callbackURL, object));
	}

	@GraphQLField
	public boolean deleteDepartment(@GraphQLName("id") Long id)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.deleteDepartment(id));

		return true;
	}

	@GraphQLField
	public Response deleteDepartmentBatch(
			@GraphQLName("id") Long id,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.deleteDepartmentBatch(
				id, callbackURL, object));
	}

	@GraphQLField
	public Department updateDepartment(
			@GraphQLName("id") Long id,
			@GraphQLName("department") Department department)
		throws Exception {

		return _applyComponentServiceObjects(
			_departmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			departmentResource -> departmentResource.updateDepartment(
				id, department));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(DepartmentResource departmentResource)
		throws Exception {

		departmentResource.setContextAcceptLanguage(_acceptLanguage);
		departmentResource.setContextCompany(_company);
		departmentResource.setContextHttpServletRequest(_httpServletRequest);
		departmentResource.setContextHttpServletResponse(_httpServletResponse);
		departmentResource.setContextUriInfo(_uriInfo);
		departmentResource.setContextUser(_user);
		departmentResource.setGroupLocalService(_groupLocalService);
		departmentResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<DepartmentResource>
		_departmentResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}