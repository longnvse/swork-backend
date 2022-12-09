package com.swork.common.file.rest.internal.mapper;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.swork.common.file.mapper.model.FileManagerMapperModel;
import com.swork.common.file.model.FileManagerEntry;
import com.swork.common.file.rest.dto.v2_0.FileManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = FileManagerMapper.class)
public class FileManagerMapper {

    public FileManager mapFromFileManagerToFileManagerEntry(FileManagerEntry from) {
        FileManager to = new FileManager();

        to.setFileId(from.getFileId());
        to.setParentCode(from.getParentCode());
        to.setFileType(from.getFileType());
        to.setFileName(from.getFileName());
        to.setFileSize(from.getFileSize());

        return to;
    }


    public FileManagerMapperModel mapFromFileManagerMapperModelToFileManager(FileManager from) {
        FileManagerMapperModel to = new FileManagerMapperModel();

        DLFileEntry fileEntry = dlFileEntryLocalService.fetchDLFileEntry(from.getFileId());

        to.setFileId(from.getFileId());
        to.setParentCode(from.getParentCode());
        to.setFileType(fileEntry.getExtension());
        to.setFileName(fileEntry.getTitle());
        to.setFileSize(String.valueOf(fileEntry.getSize()));
        to.setModuleId(from.getMetadata().getModuleId());
        to.setAppId(from.getMetadata().getAppId());

        return to;
    }

    public FileManager mapFromFileManagerToFileManagerMapperModel(FileManagerMapperModel from) {

        FileManager to = new FileManager();

        to.setFileId(from.getFileId());
        to.setParentCode(from.getParentCode());
        to.setFileType(from.getFileType());
        to.setFileName(from.getFileName());
        to.setFileSize(from.getFileSize());

        return to;
    }

    public List<FileManager> mapFromFileManagerToFileManagerMapperModelList(List<FileManagerMapperModel> fromList) {

        List<FileManager> to = new ArrayList<>();

        fromList.forEach(fileManagerMapperModel -> to.add(mapFromFileManagerToFileManagerMapperModel(fileManagerMapperModel)));

        return to;
    }


    @Reference
    private DLFileEntryLocalService dlFileEntryLocalService;
}
