package com.swork.core.resource.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import com.swork.core.resource.rest.dto.v1_0.Resource;
import com.swork.core.resource.rest.dto.v1_0.Team;
import com.swork.core.resource.rest.resource.v1_0.ResourceResource;
import com.swork.core.resource.rest.resource.v1_0.TeamResource;

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

	public static void setResourceResourceComponentServiceObjects(
		ComponentServiceObjects<ResourceResource>
			resourceResourceComponentServiceObjects) {

		_resourceResourceComponentServiceObjects =
			resourceResourceComponentServiceObjects;
	}

	public static void setTeamResourceComponentServiceObjects(
		ComponentServiceObjects<TeamResource>
			teamResourceComponentServiceObjects) {

		_teamResourceComponentServiceObjects =
			teamResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {totalMoneyInProject(phaseId: ___, projectId: ___, typeResource: ___, workId: ___){}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get list ResourceTypes")
	public Long totalMoneyInProject(
			@GraphQLName("typeResource") String typeResource,
			@GraphQLName("workId") Long workId,
			@GraphQLName("phaseId") Long phaseId,
			@GraphQLName("projectId") Long projectId)
		throws Exception {

		return _applyComponentServiceObjects(
			_resourceResourceComponentServiceObjects,
			this::_populateResourceContext,
			resourceResource -> resourceResource.getTotalMoneyInProject(
				typeResource, workId, phaseId, projectId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {resource(filter: ___, page: ___, pageSize: ___, phaseId: ___, projectId: ___, search: ___, sorts: ___, teamId: ___, workId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get List Resource")
	public ResourcePage resource(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("phaseId") Long phaseId,
			@GraphQLName("workId") Long workId,
			@GraphQLName("teamId") Long teamId,
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_resourceResourceComponentServiceObjects,
			this::_populateResourceContext,
			resourceResource -> new ResourcePage(
				resourceResource.getResourcePages(
					projectId, phaseId, workId, teamId, search,
					_filterBiFunction.apply(resourceResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(resourceResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {resource(id: ___){id, externalReferenceCode, resourceTypeName, type, teamId, teamName, quantity, unit, creator, parentName, dateResource, totalAmount, workId, phaseId, projectId, creatorId}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get a Resource")
	public Resource resource(@GraphQLName("id") Long id) throws Exception {
		return _applyComponentServiceObjects(
			_resourceResourceComponentServiceObjects,
			this::_populateResourceContext,
			resourceResource -> resourceResource.getResource(id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {team(filter: ___, page: ___, pageSize: ___, phaseId: ___, projectId: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get List Teams")
	public TeamPage team(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("phaseId") Long phaseId,
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_teamResourceComponentServiceObjects,
			this::_populateResourceContext,
			teamResource -> new TeamPage(
				teamResource.getTeamPages(
					projectId, phaseId, search,
					_filterBiFunction.apply(teamResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(teamResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {team(teamId: ___){id, externalReferenceCode, name, description, isActive, admins, members, quantityMember, resources, phaseId, phaseName, projectId, projectName, creator, createDate, modifiedDate, totalIncoming, totalSpending}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get a ResourceType")
	public Team team(@GraphQLName("teamId") Long teamId) throws Exception {
		return _applyComponentServiceObjects(
			_teamResourceComponentServiceObjects,
			this::_populateResourceContext,
			teamResource -> teamResource.getTeam(teamId));
	}

	@GraphQLTypeExtension(Resource.class)
	public class GetTeamTypeExtension {

		public GetTeamTypeExtension(Resource resource) {
			_resource = resource;
		}

		@GraphQLField(description = "Get a ResourceType")
		public Team team() throws Exception {
			return _applyComponentServiceObjects(
				_teamResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				teamResource -> teamResource.getTeam(_resource.getTeamId()));
		}

		private Resource _resource;

	}

	@GraphQLName("ResourcePage")
	public class ResourcePage {

		public ResourcePage(Page resourcePage) {
			actions = resourcePage.getActions();

			items = resourcePage.getItems();
			lastPage = resourcePage.getLastPage();
			page = resourcePage.getPage();
			pageSize = resourcePage.getPageSize();
			totalCount = resourcePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Resource> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("TeamPage")
	public class TeamPage {

		public TeamPage(Page teamPage) {
			actions = teamPage.getActions();

			items = teamPage.getItems();
			lastPage = teamPage.getLastPage();
			page = teamPage.getPage();
			pageSize = teamPage.getPageSize();
			totalCount = teamPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Team> items;

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

	private void _populateResourceContext(ResourceResource resourceResource)
		throws Exception {

		resourceResource.setContextAcceptLanguage(_acceptLanguage);
		resourceResource.setContextCompany(_company);
		resourceResource.setContextHttpServletRequest(_httpServletRequest);
		resourceResource.setContextHttpServletResponse(_httpServletResponse);
		resourceResource.setContextUriInfo(_uriInfo);
		resourceResource.setContextUser(_user);
		resourceResource.setGroupLocalService(_groupLocalService);
		resourceResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(TeamResource teamResource)
		throws Exception {

		teamResource.setContextAcceptLanguage(_acceptLanguage);
		teamResource.setContextCompany(_company);
		teamResource.setContextHttpServletRequest(_httpServletRequest);
		teamResource.setContextHttpServletResponse(_httpServletResponse);
		teamResource.setContextUriInfo(_uriInfo);
		teamResource.setContextUser(_user);
		teamResource.setGroupLocalService(_groupLocalService);
		teamResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<ResourceResource>
		_resourceResourceComponentServiceObjects;
	private static ComponentServiceObjects<TeamResource>
		_teamResourceComponentServiceObjects;

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