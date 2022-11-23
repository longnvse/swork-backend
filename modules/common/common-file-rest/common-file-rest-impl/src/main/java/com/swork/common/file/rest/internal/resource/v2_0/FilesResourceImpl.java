package com.swork.common.file.rest.internal.resource.v2_0;

import com.swork.common.file.rest.resource.v2_0.FilesResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author ninhvv
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/files.properties",
	scope = ServiceScope.PROTOTYPE, service = FilesResource.class
)
public class FilesResourceImpl extends BaseFilesResourceImpl {
}