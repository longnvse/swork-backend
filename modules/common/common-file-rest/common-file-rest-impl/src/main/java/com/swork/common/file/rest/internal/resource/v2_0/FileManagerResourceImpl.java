package com.swork.common.file.rest.internal.resource.v2_0;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.swork.common.file.rest.dto.v2_0.FileManager;
import com.swork.common.file.rest.internal.service.CommonFileHepper;
import com.swork.common.file.rest.internal.service.FileManagerService;
import com.swork.common.file.rest.resource.v2_0.FileManagerResource;

import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collections;

/**
 * @author ninhvv
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v2_0/file-manager.properties",
	scope = ServiceScope.PROTOTYPE, service = FileManagerResource.class
)
public class FileManagerResourceImpl extends BaseFileManagerResourceImpl {

	@Override
	public Page<FileManager> getAllFileManager(String parentCode)
			throws Exception {

		return Page.of(fileManagerService.getAllDGFileManager(getUserToken().getBusinessId(),parentCode));
	}

	@Override
	public FileManager postFileManager(FileManager fileManager)
			throws Exception {

		return fileManagerService.postFileManager(
				getUserToken().getBusinessId(),
				getUserToken().getAccountId(),
				fileManager,getServiceContext());
	}


	public ServiceContext getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(1L);
		serviceContext.setScopeGroupId(contextUser.getGroupId());

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		return serviceContext;
	}


	private UserTokenModel getUserToken() {
		return commonTokenHelper.getUserToken(contextHttpServletRequest);
	}

	@Reference
	private CommonTokenHelper commonTokenHelper;
	@Reference
	private CommonFileHepper commonFileHepper;
	@Reference
	private FileManagerService fileManagerService;

}