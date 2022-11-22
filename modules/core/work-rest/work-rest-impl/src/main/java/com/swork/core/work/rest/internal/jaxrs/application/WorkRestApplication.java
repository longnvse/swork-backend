package com.swork.core.work.rest.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author longnv
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false", "osgi.jaxrs.application.base=/swork/work-rest",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=WorkRest"
	},
	service = Application.class
)
@Generated("")
public class WorkRestApplication extends Application {
}