package com.swork.common.file.rest.internal.resource.v2_0;

import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.swork.common.file.rest.dto.v2_0.FileData;
import com.swork.common.file.rest.dto.v2_0.FileRes;
import com.swork.common.file.rest.dto.v2_0.FileUpdate;
import com.swork.common.file.rest.dto.v2_0.Metadata;
import com.swork.common.file.rest.internal.service.CommonFileHepper;
import com.swork.common.file.rest.internal.service.FileManagerService;
import com.swork.common.file.rest.resource.v2_0.FilesResource;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Arrays;

/**
 * @author ninhvv
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v2_0/files.properties",
        scope = ServiceScope.PROTOTYPE, service = FilesResource.class
)
public class FilesResourceImpl extends BaseFilesResourceImpl {
    private static final String METADATA_KEY = "metadata";

    @Override
    public FileRes postFile(MultipartBody multipartBody) throws Exception {
        Metadata metadata = multipartBody.getValueAsInstance(METADATA_KEY, Metadata.class);

        FileEntry fileEntry = commonFileHepper.uploadFile(
                getServiceContext().getScopeGroupId(),
                getUserToken().getBusinessId(),
                getUserToken().getFullName(),
                metadata.getModuleId(),
                metadata.getModuleId(),
                multipartBody,
                getServiceContext());

        FileRes fileRes = new FileRes();

        fileRes.setId(fileEntry.getFileEntryId());
        fileRes.setFileName(fileEntry.getFileName());
        fileRes.setFileSize(String.valueOf(fileEntry.getSize()));
        fileRes.setMimeType(String.valueOf(fileEntry.getExtension()));
        fileRes.setMetadata(metadata);

        return fileRes;
    }

    @Override
    public FileData getFileById(Long fileId)
            throws Exception {
        FileEntry entry = dlAppService.getFileEntry(fileId);
        FileData to = new FileData();

        to.setData(Arrays.toString(entry.getContentStream().readAllBytes()));
        to.setFileType("." + entry.getExtension());
        to.setSize(entry.getSize());
        to.setTitle(entry.getTitle());


        return to;
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
    DLAppService dlAppService;

    @Reference
    private FileManagerService fileManagerService;

}