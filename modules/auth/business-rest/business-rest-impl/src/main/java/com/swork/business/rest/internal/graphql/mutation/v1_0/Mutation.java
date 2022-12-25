package com.swork.business.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import com.swork.business.rest.dto.v1_0.Business;
import com.swork.business.rest.resource.v1_0.BusinessResource;

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

	public static void setBusinessResourceComponentServiceObjects(
		ComponentServiceObjects<BusinessResource>
			businessResourceComponentServiceObjects) {

		_businessResourceComponentServiceObjects =
			businessResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Create a new Business")
	public Business createBusiness(@GraphQLName("business") Business business)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.postBusiness(business));
	}

	@GraphQLField
	public Response createBusinessBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.postBusinessBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Delete an business")
	public boolean deleteBusiness(@GraphQLName("businessId") Long businessId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.deleteBusiness(businessId));

		return true;
	}

	@GraphQLField
	public Response deleteBusinessBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.deleteBusinessBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Update an Business")
	public Business updateBusiness(
			@GraphQLName("businessId") Long businessId,
			@GraphQLName("business") Business business)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.putBusiness(
				businessId, business));
	}

	@GraphQLField
	public Response updateBusinessBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.putBusinessBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Update an Business")
	public boolean approvalBusiness(
			@GraphQLName("businessId") Long businessId,
			@GraphQLName("status") String status)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_businessResourceComponentServiceObjects,
			this::_populateResourceContext,
			businessResource -> businessResource.approvalBusiness(
				businessId, status));

		return true;
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

	private void _populateResourceContext(BusinessResource businessResource)
		throws Exception {

		businessResource.setContextAcceptLanguage(_acceptLanguage);
		businessResource.setContextCompany(_company);
		businessResource.setContextHttpServletRequest(_httpServletRequest);
		businessResource.setContextHttpServletResponse(_httpServletResponse);
		businessResource.setContextUriInfo(_uriInfo);
		businessResource.setContextUser(_user);
		businessResource.setGroupLocalService(_groupLocalService);
		businessResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<BusinessResource>
		_businessResourceComponentServiceObjects;

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