package com.swork.common.file.rest.internal.resource.v2_0;

import com.swork.common.file.rest.resource.v2_0.FileManagerResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author ninhvv
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/file-manager.properties",
	scope = ServiceScope.PROTOTYPE, service = FileManagerResource.class
)
public class FileManagerResourceImpl extends BaseFileManagerResourceImpl {
}