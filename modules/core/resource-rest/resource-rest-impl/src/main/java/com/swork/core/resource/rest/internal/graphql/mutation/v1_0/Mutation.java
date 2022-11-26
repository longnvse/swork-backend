package com.swork.core.resource.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import com.swork.core.resource.rest.dto.v1_0.Resource;
import com.swork.core.resource.rest.dto.v1_0.Team;
import com.swork.core.resource.rest.resource.v1_0.ResourceResource;
import com.swork.core.resource.rest.resource.v1_0.TeamResource;

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

	@GraphQLField(description = "Create new a Resource")
	public Resource createResource(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("phaseId") Long phaseId,
			@GraphQLName("workId") Long workId,
			@GraphQLName("resource") Resource resource)
		throws Exception {

		return _applyComponentServiceObjects(
			_resourceResourceComponentServiceObjects,
			this::_populateResourceContext,
			resourceResource -> resourceResource.postResource(
				projectId, phaseId, workId, resource));
	}

	@GraphQLField
	public Response createResourceBatch(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("phaseId") Long phaseId,
			@GraphQLName("workId") Long workId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_resourceResourceComponentServiceObjects,
			this::_populateResourceContext,
			resourceResource -> resourceResource.postResourceBatch(
				projectId, phaseId, workId, callbackURL, object));
	}

	@GraphQLField(description = "Delete a Resource")
	public boolean deleteResource(@GraphQLName("id") Long id) throws Exception {
		_applyVoidComponentServiceObjects(
			_resourceResourceComponentServiceObjects,
			this::_populateResourceContext,
			resourceResource -> resourceResource.deleteResource(id));

		return true;
	}

	@GraphQLField
	public Response deleteResourceBatch(
			@GraphQLName("id") Long id,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_resourceResourceComponentServiceObjects,
			this::_populateResourceContext,
			resourceResource -> resourceResource.deleteResourceBatch(
				id, callbackURL, object));
	}

	@GraphQLField(description = "Create new a Resource")
	public boolean updateResource(
			@GraphQLName("id") Long id,
			@GraphQLName("resource") Resource resource)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_resourceResourceComponentServiceObjects,
			this::_populateResourceContext,
			resourceResource -> resourceResource.putResource(id, resource));

		return true;
	}

	@GraphQLField
	public Response updateResourceBatch(
			@GraphQLName("id") Long id,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_resourceResourceComponentServiceObjects,
			this::_populateResourceContext,
			resourceResource -> resourceResource.putResourceBatch(
				id, callbackURL, object));
	}

	@GraphQLField(description = "Create new a Team")
	public Team createTeam(@GraphQLName("team") Team team) throws Exception {
		return _applyComponentServiceObjects(
			_teamResourceComponentServiceObjects,
			this::_populateResourceContext,
			teamResource -> teamResource.postTeam(team));
	}

	@GraphQLField
	public Response createTeamBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_teamResourceComponentServiceObjects,
			this::_populateResourceContext,
			teamResource -> teamResource.postTeamBatch(callbackURL, object));
	}

	@GraphQLField(description = "Delete a ResourceType")
	public boolean deleteTeam(@GraphQLName("teamId") Long teamId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_teamResourceComponentServiceObjects,
			this::_populateResourceContext,
			teamResource -> teamResource.deleteTeam(teamId));

		return true;
	}

	@GraphQLField
	public Response deleteTeamBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_teamResourceComponentServiceObjects,
			this::_populateResourceContext,
			teamResource -> teamResource.deleteTeamBatch(callbackURL, object));
	}

	@GraphQLField(description = "Create new a ResourceType")
	public Team updateTeam(
			@GraphQLName("teamId") Long teamId, @GraphQLName("team") Team team)
		throws Exception {

		return _applyComponentServiceObjects(
			_teamResourceComponentServiceObjects,
			this::_populateResourceContext,
			teamResource -> teamResource.putTeam(teamId, team));
	}

	@GraphQLField
	public Response updateTeamBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_teamResourceComponentServiceObjects,
			this::_populateResourceContext,
			teamResource -> teamResource.putTeamBatch(callbackURL, object));
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
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}