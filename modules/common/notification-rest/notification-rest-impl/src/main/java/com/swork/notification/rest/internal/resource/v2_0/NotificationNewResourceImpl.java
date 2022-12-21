package com.swork.notification.rest.internal.resource.v2_0;

import com.swork.notification.rest.resource.v2_0.NotificationNewResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author longnv
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/notification-new.properties",
	scope = ServiceScope.PROTOTYPE, service = NotificationNewResource.class
)
public class NotificationNewResourceImpl
	extends BaseNotificationNewResourceImpl {
}