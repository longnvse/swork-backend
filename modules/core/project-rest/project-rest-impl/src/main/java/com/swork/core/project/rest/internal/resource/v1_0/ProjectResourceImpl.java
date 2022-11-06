package com.swork.core.project.rest.internal.resource.v1_0;

import com.swork.core.project.rest.resource.v1_0.ProjectResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Long Hip
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/project.properties",
	scope = ServiceScope.PROTOTYPE, service = ProjectResource.class
)
public class ProjectResourceImpl extends BaseProjectResourceImpl {
}