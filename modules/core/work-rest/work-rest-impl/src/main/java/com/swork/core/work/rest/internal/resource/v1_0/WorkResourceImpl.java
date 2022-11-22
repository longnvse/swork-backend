package com.swork.core.work.rest.internal.resource.v1_0;

import com.swork.core.work.rest.resource.v1_0.WorkResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author longnv
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/work.properties",
	scope = ServiceScope.PROTOTYPE, service = WorkResource.class
)
public class WorkResourceImpl extends BaseWorkResourceImpl {
}