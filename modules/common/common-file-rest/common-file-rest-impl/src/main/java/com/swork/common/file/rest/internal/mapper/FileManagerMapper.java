package com.swork.common.file.rest.internal.mapper;

import com.swork.common.file.mapper.model.FileManagerMapperModel;
import com.swork.common.file.model.FileManagerEntry;
import com.swork.common.file.rest.dto.v2_0.FileManager;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = FileManagerMapper.class)
public class FileManagerMapper {

    public FileManager mapFromFileManagerToFileManagerEntry(FileManagerEntry from) {
        FileManager to = new FileManager();

        to.setFileId(from.getFileId());
        to.setParentCode(from.getParentCode());
        to.setFileType(from.getFileType());
        to.setType(from.getType());
        to.setPkType(from.getPkType());
        to.setFileName(from.getFileName());
        to.setFileSize(from.getFileSize());

        return to;
    }

//    public DGFileManager mapDgFileManagerFromDLFileEntry(DLFileEntry entry) {
//        DGFileManager to = new DGFileManager();
//
//        to.setFileId(entry.getFileEntryId());
//        to.setFileName(dg_fileUtil.getExtractFileName(entry.getTitle()));
//        to.setMineType(entry.getMimeType());
//        to.setFileType(entry.getExtension());
//        to.setFileSize(String.valueOf(entry.getSize()));
//
//        return to;
//    }

    public FileManagerMapperModel mapFromFileManagerMapperModelToFileManager(FileManager from) {
        FileManagerMapperModel to = new FileManagerMapperModel();

//        DLFileEntry dlFileEntry = _dlFileEntryLocalService.fetchDLFileEntry(from.getFileId());

        to.setFileId(from.getFileId());
        to.setParentCode(from.getParentCode());
//        to.setFileType(dlFileEntry.getExtension());
        to.setType(from.getType());
        to.setPkType(from.getPkType());
//        to.setFileName(dlFileEntry.getTitle());
//        to.setFileSize(String.valueOf(dlFileEntry.getSize()));
        to.setModuleId(from.getMetadata().getModuleId());
        to.setAppId(from.getMetadata().getAppId());

        return to;
    }

    public FileManager mapFromFileManagerToFileManagerMapperModel(FileManagerMapperModel from) {

        FileManager to = new FileManager();

        to.setFileId(from.getFileId());
        to.setParentCode(from.getParentCode());
        to.setFileType(from.getFileType());
        to.setType(from.getType());
        to.setPkType(from.getPkType());
        to.setFileName(from.getFileName());
        to.setFileSize(from.getFileSize());

        return to;
    }

//    public List<DGFileManager> mapFromDGFileManagerToDGFileManagerMapperModelList(List<FileManagerMapperModel> fromList) {
//
//        List<DGFileManager> to = new ArrayList<>();
//
//        fromList.forEach(fileManagerMapperModel -> to.add(mapFromDGFileManagerToDGFileManagerMapperModel(fileManagerMapperModel)));
//
//        return to;
//    }
//
//    @Reference
//    private DLFileEntryLocalService _dlFileEntryLocalService;

}
