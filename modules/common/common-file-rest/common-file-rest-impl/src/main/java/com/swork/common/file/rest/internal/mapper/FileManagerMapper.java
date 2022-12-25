package com.swork.common.file.rest.internal.mapper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.swork.common.file.helper.api.CommonFileHelper;
import com.swork.common.file.mapper.model.FileManagerMapperModel;
import com.swork.common.file.model.FileManagerEntry;
import com.swork.common.file.rest.dto.v1_0.FileManager;
import com.swork.common.file.rest.dto.v1_0.Metadata;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = FileManagerMapper.class)
public class FileManagerMapper {

    public FileManager mapEntryToDTO(FileManagerEntry from, ThemeDisplay themeDisplay) throws PortalException {
        FileManager to = new FileManager();

        to.setFileId(from.getId());
        to.setFileType(from.getFileType());
        to.setFileName(from.getFileName());
        to.setFileSize(from.getFileSize());
        to.setCreatorId(from.getAccountId());
        to.setCreateDate(from.getCreateDate());
        to.setMineType(from.getMimeType());
        to.setUrlDownload(commonFileHelper.getDownloadUrl(from.getFileId(), themeDisplay));

        return to;
    }

    public FileManagerMapperModel mapFileToMapperModel(FileEntry from, Metadata metadata) {
        FileManagerMapperModel to = new FileManagerMapperModel();

        to.setFileId(from.getFileEntryId());
        to.setFileType(from.getExtension());
        to.setFileName(from.getTitle());
        to.setFileSize(from.getSize());
        to.setMimeType(from.getMimeType());
        to.setModuleId(metadata.getModuleId());
        to.setAppId(metadata.getAppId());

        return to;
    }

    @Reference
    private CommonFileHelper commonFileHelper;
}
