package com.swork.core.phase.rest.internal.resource.v1_0;

import com.swork.core.phase.rest.resource.v1_0.PhaseResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Long Hip
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/phase.properties",
	scope = ServiceScope.PROTOTYPE, service = PhaseResource.class
)
public class PhaseResourceImpl extends BasePhaseResourceImpl {
}