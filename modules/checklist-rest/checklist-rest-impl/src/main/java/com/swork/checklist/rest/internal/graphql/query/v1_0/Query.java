package com.swork.checklist.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import com.swork.checklist.rest.dto.v1_0.CheckList;
import com.swork.checklist.rest.resource.v1_0.CheckListResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author adm
 * @generated
 */
@Generated("")
public class Query {

	public static void setCheckListResourceComponentServiceObjects(
		ComponentServiceObjects<CheckListResource>
			checkListResourceComponentServiceObjects) {

		_checkListResourceComponentServiceObjects =
			checkListResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {checklists{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CheckListPage checklists() throws Exception {
		return _applyComponentServiceObjects(
			_checkListResourceComponentServiceObjects,
			this::_populateResourceContext,
			checkListResource -> new CheckListPage(
				checkListResource.getChecklists()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {checkListById(cid: ___){checkListId, name, startDate, endDate, taskId, status, CheckListHandler}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CheckList checkListById(@GraphQLName("cid") Long cid)
		throws Exception {

		return _applyComponentServiceObjects(
			_checkListResourceComponentServiceObjects,
			this::_populateResourceContext,
			checkListResource -> checkListResource.getCheckListById(cid));
	}

	@GraphQLName("CheckListPage")
	public class CheckListPage {

		public CheckListPage(Page checkListPage) {
			actions = checkListPage.getActions();

			items = checkListPage.getItems();
			lastPage = checkListPage.getLastPage();
			page = checkListPage.getPage();
			pageSize = checkListPage.getPageSize();
			totalCount = checkListPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<CheckList> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}