package com.swork.core.work.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import com.swork.core.work.rest.dto.v1_0.Work;
import com.swork.core.work.rest.resource.v1_0.WorkResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author longnv
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setWorkResourceComponentServiceObjects(
		ComponentServiceObjects<WorkResource>
			workResourceComponentServiceObjects) {

		_workResourceComponentServiceObjects =
			workResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Create a new Work")
	public Work createWork(@GraphQLName("work") Work work) throws Exception {
		return _applyComponentServiceObjects(
			_workResourceComponentServiceObjects,
			this::_populateResourceContext,
			workResource -> workResource.postWork(work));
	}

	@GraphQLField
	public Response createWorkBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_workResourceComponentServiceObjects,
			this::_populateResourceContext,
			workResource -> workResource.postWorkBatch(callbackURL, object));
	}

	@GraphQLField(description = "Delete an Work")
	public boolean deleteWork(@GraphQLName("workId") Long workId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_workResourceComponentServiceObjects,
			this::_populateResourceContext,
			workResource -> workResource.deleteWork(workId));

		return true;
	}

	@GraphQLField
	public Response deleteWorkBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_workResourceComponentServiceObjects,
			this::_populateResourceContext,
			workResource -> workResource.deleteWorkBatch(callbackURL, object));
	}

	@GraphQLField(description = "Update a Work")
	public Work updateWork(
			@GraphQLName("workId") Long workId, @GraphQLName("work") Work work)
		throws Exception {

		return _applyComponentServiceObjects(
			_workResourceComponentServiceObjects,
			this::_populateResourceContext,
			workResource -> workResource.putWork(workId, work));
	}

	@GraphQLField
	public Response updateWorkBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_workResourceComponentServiceObjects,
			this::_populateResourceContext,
			workResource -> workResource.putWorkBatch(callbackURL, object));
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

	private void _populateResourceContext(WorkResource workResource)
		throws Exception {

		workResource.setContextAcceptLanguage(_acceptLanguage);
		workResource.setContextCompany(_company);
		workResource.setContextHttpServletRequest(_httpServletRequest);
		workResource.setContextHttpServletResponse(_httpServletResponse);
		workResource.setContextUriInfo(_uriInfo);
		workResource.setContextUser(_user);
		workResource.setGroupLocalService(_groupLocalService);
		workResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<WorkResource>
		_workResourceComponentServiceObjects;

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