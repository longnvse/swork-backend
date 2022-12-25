package com.swork.core.phase.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import com.swork.core.phase.rest.dto.v1_0.Phase;
import com.swork.core.phase.rest.resource.v1_0.PhaseResource;

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

	public static void setPhaseResourceComponentServiceObjects(
		ComponentServiceObjects<PhaseResource>
			phaseResourceComponentServiceObjects) {

		_phaseResourceComponentServiceObjects =
			phaseResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Create a new Phase")
	public boolean createPhase(@GraphQLName("phase") Phase phase)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_phaseResourceComponentServiceObjects,
			this::_populateResourceContext,
			phaseResource -> phaseResource.postPhase(phase));

		return true;
	}

	@GraphQLField
	public Response createPhaseBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_phaseResourceComponentServiceObjects,
			this::_populateResourceContext,
			phaseResource -> phaseResource.postPhaseBatch(callbackURL, object));
	}

	@GraphQLField(description = "Delete an Phase")
	public boolean deletePhase(@GraphQLName("phaseId") Long phaseId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_phaseResourceComponentServiceObjects,
			this::_populateResourceContext,
			phaseResource -> phaseResource.deletePhase(phaseId));

		return true;
	}

	@GraphQLField
	public Response deletePhaseBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_phaseResourceComponentServiceObjects,
			this::_populateResourceContext,
			phaseResource -> phaseResource.deletePhaseBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Update a Phase")
	public boolean updatePhase(
			@GraphQLName("phaseId") Long phaseId,
			@GraphQLName("phase") Phase phase)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_phaseResourceComponentServiceObjects,
			this::_populateResourceContext,
			phaseResource -> phaseResource.putPhase(phaseId, phase));

		return true;
	}

	@GraphQLField
	public Response updatePhaseBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_phaseResourceComponentServiceObjects,
			this::_populateResourceContext,
			phaseResource -> phaseResource.putPhaseBatch(callbackURL, object));
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

	private void _populateResourceContext(PhaseResource phaseResource)
		throws Exception {

		phaseResource.setContextAcceptLanguage(_acceptLanguage);
		phaseResource.setContextCompany(_company);
		phaseResource.setContextHttpServletRequest(_httpServletRequest);
		phaseResource.setContextHttpServletResponse(_httpServletResponse);
		phaseResource.setContextUriInfo(_uriInfo);
		phaseResource.setContextUser(_user);
		phaseResource.setGroupLocalService(_groupLocalService);
		phaseResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<PhaseResource>
		_phaseResourceComponentServiceObjects;

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