package com.swork.notification.rest.internal.graphql.servlet.v2_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import com.swork.notification.rest.internal.graphql.mutation.v2_0.Mutation;
import com.swork.notification.rest.internal.graphql.query.v2_0.Query;
import com.swork.notification.rest.resource.v2_0.NotificationNewResource;
import com.swork.notification.rest.resource.v2_0.NotificationResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author longnv
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setNotificationResourceComponentServiceObjects(
			_notificationResourceComponentServiceObjects);

		Query.setNotificationResourceComponentServiceObjects(
			_notificationResourceComponentServiceObjects);
		Query.setNotificationNewResourceComponentServiceObjects(
			_notificationNewResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/swork/notification-rest-graphql/v2_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<NotificationResource>
		_notificationResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<NotificationNewResource>
		_notificationNewResourceComponentServiceObjects;

}