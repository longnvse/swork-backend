package com.swork.common.file.rest.internal.resource.v2_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.swork.common.file.rest.dto.v2_0.FileManager;
import com.swork.common.file.rest.dto.v2_0.Metadata;
import com.swork.common.file.rest.internal.service.CommonFileHepper;
import com.swork.common.file.rest.internal.service.FileManagerService;
import com.swork.common.file.rest.resource.v2_0.FileManagerResource;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.io.IOException;

/**
 * @author ninhvv
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v2_0/file-manager.properties",
        scope = ServiceScope.PROTOTYPE, service = FileManagerResource.class
)
public class FileManagerResourceImpl extends BaseFileManagerResourceImpl {

    private static final String METADATA_KEY = "metadata";

    @Override
    public Page<FileManager> getAllFileManager(String parentCode)
            throws Exception {

        return Page.of(fileManagerService.getAllDGFileManager(getUserToken().getBusinessId(), parentCode));
    }

    @Override
    public void postFile(Long classPkId, String classPkName, MultipartBody multipartBody) throws PortalException, IOException {
        Metadata metadata = multipartBody.getValueAsInstance(METADATA_KEY, Metadata.class);

        FileEntry fileEntry = commonFileHepper.uploadFile(
                getServiceContext().getScopeGroupId(),
                getUserToken().getBusinessId(),
                getUserToken().getFullName(),
                classPkName,
                String.valueOf(classPkId),
                multipartBody,
                getServiceContext());


    }

    @Override
    public void deleteFileManager(Long fileId) throws PortalException {
        fileManagerService.deleteFile(fileId);
    }

    public FileManager postFileManager(FileManager fileManager)
            throws Exception {

        return fileManagerService.postFileManager(
                getUserToken().getBusinessId(),
                getUserToken().getAccountId(),
                fileManager,
                getThemeDisplay(),
                getServiceContext());
    }

    public ThemeDisplay getThemeDisplay() {

        ThemeDisplay themeDisplay = new ThemeDisplay();
        String remoteHost = contextHttpServletRequest.getServerName();
        if (StringUtil.equals(remoteHost, "localhost"))
            themeDisplay.setPortalURL("http://localhost:8080");
        else
            themeDisplay.setPortalURL("https" + "://" + remoteHost);

        return themeDisplay;
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