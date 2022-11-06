package com.swork.core.project.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import com.swork.core.project.rest.dto.v1_0.Project;
import com.swork.core.project.rest.resource.v1_0.ProjectResource;

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

	public static void setProjectResourceComponentServiceObjects(
		ComponentServiceObjects<ProjectResource>
			projectResourceComponentServiceObjects) {

		_projectResourceComponentServiceObjects =
			projectResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Create a new Project")
	public Project createProject(@GraphQLName("project") Project project)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.postProject(project));
	}

	@GraphQLField
	public Response createProjectBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.postProjectBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Delete an Project")
	public boolean deleteProject(@GraphQLName("projectId") Long projectId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.deleteProject(projectId));

		return true;
	}

	@GraphQLField
	public Response deleteProjectBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.deleteProjectBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Update a Project")
	public Project updateProject(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("project") Project project)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.putProject(projectId, project));
	}

	@GraphQLField
	public Response updateProjectBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.putProjectBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Approval a Project")
	public boolean approvalProject(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("project") Project project)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.approvalProject(
				projectId, project));

		return true;
	}

	@GraphQLField(description = "Approval a Project")
	public boolean updateDescriptionProject(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("project") Project project)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.updateDescriptionProject(
				projectId, project));

		return true;
	}

	@GraphQLField(description = "Approval a Project")
	public boolean updateDateProject(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("project") Project project)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.updateDateProject(
				projectId, project));

		return true;
	}

	@GraphQLField(description = "Approval a Project")
	public boolean updateActualDateProject(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("project") Project project)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.updateActualDateProject(
				projectId, project));

		return true;
	}

	@GraphQLField(description = "Approval a Project")
	public boolean updateMemberProject(
			@GraphQLName("projectId") Long projectId,
			@GraphQLName("project") Project project)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.updateMemberProject(
				projectId, project));

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
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}