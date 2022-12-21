package com.swork.notification.rest.internal.graphql.mutation.v2_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import com.swork.notification.rest.dto.v2_0.Notification;
import com.swork.notification.rest.resource.v2_0.NotificationResource;

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
public class Mutation {

	public static void setNotificationResourceComponentServiceObjects(
		ComponentServiceObjects<NotificationResource>
			notificationResourceComponentServiceObjects) {

		_notificationResourceComponentServiceObjects =
			notificationResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Update all Notification by receiverId and")
	public boolean approvalAllStatusByReceiver(
			@GraphQLName("receiverId") Long receiverId,
			@GraphQLName("notification") Notification notification)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_notificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			notificationResource ->
				notificationResource.approvalAllStatusByReceiver(
					receiverId, notification));

		return true;
	}

	@GraphQLField(description = "Update a Notification")
	public Notification approvalStatus(
			@GraphQLName("id") Long id,
			@GraphQLName("notification") Notification notification)
		throws Exception {

		return _applyComponentServiceObjects(
			_notificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			notificationResource -> notificationResource.approvalStatus(
				id, notification));
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

	private void _populateResourceContext(
			NotificationResource notificationResource)
		throws Exception {

		notificationResource.setContextAcceptLanguage(_acceptLanguage);
		notificationResource.setContextCompany(_company);
		notificationResource.setContextHttpServletRequest(_httpServletRequest);
		notificationResource.setContextHttpServletResponse(
			_httpServletResponse);
		notificationResource.setContextUriInfo(_uriInfo);
		notificationResource.setContextUser(_user);
		notificationResource.setGroupLocalService(_groupLocalService);
		notificationResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<NotificationResource>
		_notificationResourceComponentServiceObjects;

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