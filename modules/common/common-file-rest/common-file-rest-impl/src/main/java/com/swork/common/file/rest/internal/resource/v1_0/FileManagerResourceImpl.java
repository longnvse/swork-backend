package com.swork.common.file.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.common.file.helper.api.CommonFileHelper;
import com.swork.common.file.rest.dto.v1_0.FileManager;
import com.swork.common.file.rest.internal.service.FileManagerService;
import com.swork.common.file.rest.internal.validator.FileValidator;
import com.swork.common.file.rest.resource.v1_0.FileManagerResource;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.validation.constraints.NotNull;

/**
 * @author longnv
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/file-manager.properties",
        scope = ServiceScope.PROTOTYPE, service = FileManagerResource.class
)
public class FileManagerResourceImpl extends BaseFileManagerResourceImpl {

    @Override
    public Page<FileManager> getFileManagerPages(Long projectId,
                                                 Long phaseId,
                                                 Long workId,
                                                 String moduleId,
                                                 String appId,
                                                 String search,
                                                 Filter filter,
                                                 Pagination pagination,
                                                 Sort[] sorts) throws Exception {


        return service.getFileManagerPages(
                getUserToken().getBusinessId(),
                projectId,
                phaseId,
                workId,
                moduleId,
                appId,
                search,
                filter,
                pagination,
                sorts,
                getThemeDisplay(),
                getServiceContext()
        );
    }

    @Override
    public void postFile(Long projectId, Long phaseId, Long workId, MultipartBody multipartBody) throws Exception {
        fileValidator.validateForPostFile(multipartBody);

        service.postFileManager(
                getUserToken().getBusinessId(),
                getUserToken().getAccountId(),
                projectId,
                phaseId,
                workId,
                multipartBody,
                getServiceContext()
        );
    }

    @Override
    public void deleteFileManagers(@NotNull Long[] fileIds) throws Exception {
        service.deleteFiles(fileIds);
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

    private ThemeDisplay getThemeDisplay() {
        return commonFileHelper.getThemeDisplay(contextHttpServletRequest);
    }


    private UserTokenModel getUserToken() {
        return commonTokenHelper.getUserToken(contextHttpServletRequest);
    }

    @Reference
    private CommonTokenHelper commonTokenHelper;
    @Reference
    private CommonFileHelper commonFileHelper;
    @Reference
    private FileManagerService service;
    @Reference
    private FileValidator fileValidator;
}