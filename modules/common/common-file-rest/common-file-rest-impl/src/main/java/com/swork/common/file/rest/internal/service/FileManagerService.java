package com.swork.common.file.rest.internal.service;

import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.common.file.model.FileManagerEntry;
import com.swork.common.file.rest.dto.v2_0.FileManager;
import com.swork.common.file.rest.internal.mapper.FileManagerMapper;
import com.swork.common.file.service.FileManagerEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = FileManagerService.class)
public class FileManagerService {

    public FileManager postFileManager(long customerId,
                                       long userId,
                                       FileManager fileManager,
                                       ServiceContext serviceContext) throws Exception {

        FileManagerEntry entry =
                fileManagerEntryLocalService.addFileManager(
                        customerId,
                        userId,
                        mapper.mapFromFileManagerMapperModelToFileManager(fileManager),
                        serviceContext);


        return mapper.mapFromFileManagerToFileManagerEntry(entry);
    }

//    public List<FileManager> getAllFileManagerByPkType(long customerId,
//                                                           String parentCode,
//                                                           String pkType) {
//
//        List<FileManagerMapperModel> fromList = _retriever.getAllDGFileManagerByPKType(
//                customerId, parentCode, pkType);
//
//        return _mapper.mapFromDGFileManagerToDGFileManagerMapperModelList(fromList);
//    }
//
//    public List<FileManager> getAllFileManager(long customerId,
//                                               String parentCode) {
//
//        List<FileManagerMapperModel> fromList = _retriever.getAllDGFileManager(
//                customerId, parentCode);
//
//        return _mapper.mapFromDGFileManagerToDGFileManagerMapperModelList(fromList);
//    }

//    private List<Long> getAllFileId(long customerId,
//                                    String parentCode) {
//
//        return _retriever.getAllFileId(customerId, parentCode);
//    }

//    public FileManager getFileManagerByFileId(long fileId) {
//
//        return mapper.mapFileManagerFromDLFileEntry(
//                _dlFileEntryLocalService.fetchDLFileEntry(fileId)
//        );
//    }

//    public void deleteFileId(long fileId, long customerId) throws Exception {
//
//        _dlFileEntryLocalService.deleteDLFileEntry(fileId);
//
//        DGFileManagerEntry dgFileManagerEntry = _dgFileManagerEntryLocalService.
//                getDGFileManagerEntryByFileId(fileId, customerId);
//
//        if (dgFileManagerEntry == null) return;
//
//        _dgFileManagerEntryLocalService.deleteDGFileManagerEntry(dgFileManagerEntry.getFileManagerId());
//
//    }

//    public void deleteFileManagerOfParent(long customerId,
//                                          String parentCode) {
//        List<Long> list = getAllFileId(customerId, parentCode);
//
//        list.stream().forEach(l -> {
//            DGFileManagerEntry dgFileManagerEntry = _dgFileManagerEntryLocalService.
//                    getDGFileManagerEntryByFileId(l, customerId);
//
//            try {
//                _dgFileManagerEntryLocalService.deleteDGFileManagerEntry(dgFileManagerEntry.getFileManagerId());
//            } catch (PortalException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                _dlFileEntryLocalService.deleteDLFileEntry(l);
//            } catch (PortalException e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }

    @Reference
    private FileManagerMapper mapper;


    @Reference
    private FileManagerEntryLocalService fileManagerEntryLocalService;


}
