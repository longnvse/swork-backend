package com.swork.checklist.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import com.swork.checklist.rest.dto.v1_0.CheckList;
import com.swork.checklist.rest.resource.v1_0.CheckListResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author adm
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setCheckListResourceComponentServiceObjects(
		ComponentServiceObjects<CheckListResource>
			checkListResourceComponentServiceObjects) {

		_checkListResourceComponentServiceObjects =
			checkListResourceComponentServiceObjects;
	}

	@GraphQLField
	public CheckList createCheckList(
			@GraphQLName("checkList") CheckList checkList)
		throws Exception {

		return _applyComponentServiceObjects(
			_checkListResourceComponentServiceObjects,
			this::_populateResourceContext,
			checkListResource -> checkListResource.postCheckList(checkList));
	}

	@GraphQLField
	public Response createCheckListBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_checkListResourceComponentServiceObjects,
			this::_populateResourceContext,
			checkListResource -> checkListResource.postCheckListBatch(
				callbackURL, object));
	}

	@GraphQLField
	public boolean deleteCheckList(@GraphQLName("cid") Long cid)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_checkListResourceComponentServiceObjects,
			this::_populateResourceContext,
			checkListResource -> checkListResource.deleteCheckList(cid));

		return true;
	}

	@GraphQLField
	public Response deleteCheckListBatch(
			@GraphQLName("cid") Long cid,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_checkListResourceComponentServiceObjects,
			this::_populateResourceContext,
			checkListResource -> checkListResource.deleteCheckListBatch(
				cid, callbackURL, object));
	}

	@GraphQLField
	public CheckList updateCheckList(
			@GraphQLName("cid") Long cid,
			@GraphQLName("checkList") CheckList checkList)
		throws Exception {

		return _applyComponentServiceObjects(
			_checkListResourceComponentServiceObjects,
			this::_populateResourceContext,
			checkListResource -> checkListResource.updateCheckList(
				cid, checkList));
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

	private void _populateResourceContext(CheckListResource checkListResource)
		throws Exception {

		checkListResource.setContextAcceptLanguage(_acceptLanguage);
		checkListResource.setContextCompany(_company);
		checkListResource.setContextHttpServletRequest(_httpServletRequest);
		checkListResource.setContextHttpServletResponse(_httpServletResponse);
		checkListResource.setContextUriInfo(_uriInfo);
		checkListResource.setContextUser(_user);
		checkListResource.setGroupLocalService(_groupLocalService);
		checkListResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<CheckListResource>
		_checkListResourceComponentServiceObjects;

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