package com.swork.core.work.rest.internal.graphql.query.v1_0;

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
import com.liferay.portal.vulcan.pagination.Pagination;

import com.swork.core.work.rest.dto.v1_0.Work;
import com.swork.core.work.rest.resource.v1_0.WorkResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author longnv
 * @generated
 */
@Generated("")
public class Query {

	public static void setWorkResourceComponentServiceObjects(
		ComponentServiceObjects<WorkResource>
			workResourceComponentServiceObjects) {

		_workResourceComponentServiceObjects =
			workResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {works(filter: ___, isTree: ___, page: ___, pageSize: ___, parentId: ___, phaseId: ___, projectId: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Work. Results can be paginated, filtered, searched, and sorted."
	)
	public WorkPage works(
			@GraphQLName("isTree") Boolean isTree,
			@GraphQLName("search") String search,
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("phaseId") Long phaseId,
			@GraphQLName("parentId") Long parentId,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_workResourceComponentServiceObjects,
			this::_populateResourceContext,
			workResource -> new WorkPage(
				workResource.getWorksPage(
					isTree, search, projectId, phaseId, parentId,
					_filterBiFunction.apply(workResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(workResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {work(workId: ___){id, externalReferenceCode, projectId, phaseId, progress, name, startDate, endDate, actualStartDate, actualEndDate, parentName, parentId, projectName, phaseName, description, status, manages, participates, handles, percentage, progressType, unit, incompleteAmount, complete, descriptionProgress, parentStatus, commentNumber, attachNumber, createDate, modifiedDate, works}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get an Work")
	public Work work(@GraphQLName("workId") Long workId) throws Exception {
		return _applyComponentServiceObjects(
			_workResourceComponentServiceObjects,
			this::_populateResourceContext,
			workResource -> workResource.getWork(workId));
	}

	@GraphQLName("WorkPage")
	public class WorkPage {

		public WorkPage(Page workPage) {
			actions = workPage.getActions();

			items = workPage.getItems();
			lastPage = workPage.getLastPage();
			page = workPage.getPage();
			pageSize = workPage.getPageSize();
			totalCount = workPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Work> items;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}