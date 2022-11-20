package com.swork.core.project.rest.internal.graphql.query.v1_0;

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

import com.swork.core.project.rest.dto.v1_0.Project;
import com.swork.core.project.rest.resource.v1_0.ProjectResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Query {

	public static void setProjectResourceComponentServiceObjects(
		ComponentServiceObjects<ProjectResource>
			projectResourceComponentServiceObjects) {

		_projectResourceComponentServiceObjects =
			projectResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {projects(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___, type: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the Project. Results can be paginated, filtered, searched, and sorted."
	)
	public ProjectPage projects(
			@GraphQLName("type") String type,
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> new ProjectPage(
				projectResource.getProjectsPage(
					type, search,
					_filterBiFunction.apply(projectResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(projectResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {project(projectId: ___){id, externalReferenceCode, name, code, budget, description, startDate, endDate, status, progress, manages, handles, participates, actualStartDate, actualEndDate, progressType}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get an Project")
	public Project project(@GraphQLName("projectId") Long projectId)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.getProject(projectId));
	}

	@GraphQLName("ProjectPage")
	public class ProjectPage {

		public ProjectPage(Page projectPage) {
			actions = projectPage.getActions();

			items = projectPage.getItems();
			lastPage = projectPage.getLastPage();
			page = projectPage.getPage();
			pageSize = projectPage.getPageSize();
			totalCount = projectPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Project> items;

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

	private void _populateResourceContext(ProjectResource projectResource)
		throws Exception {

		projectResource.setContextAcceptLanguage(_acceptLanguage);
		projectResource.setContextCompany(_company);
		projectResource.setContextHttpServletRequest(_httpServletRequest);
		projectResource.setContextHttpServletResponse(_httpServletResponse);
		projectResource.setContextUriInfo(_uriInfo);
		projectResource.setContextUser(_user);
		projectResource.setGroupLocalService(_groupLocalService);
		projectResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<ProjectResource>
		_projectResourceComponentServiceObjects;

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