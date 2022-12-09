package com.swork.common.file.rest.internal.service;

import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.search.query.Queries;
import com.swork.common.file.mapper.model.FileManagerMapperModel;
import com.swork.common.file.model.FileManagerEntry;
import com.swork.common.file.rest.dto.v2_0.FileManager;
import com.swork.common.file.rest.internal.mapper.FileManagerMapper;
import com.swork.common.file.retriver.FileManagerRetriever;
import com.swork.common.file.service.FileManagerEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = FileManagerService.class)
public class FileManagerService {

    public FileManager postFileManager(long customerId,
                                       long userId,
                                       FileManager fileManager,
                                       ServiceContext serviceContext) {

        FileManagerMapperModel model =
                mapper.mapFromFileManagerMapperModelToFileManager(fileManager);

        FileManagerEntry fileManagerEntry = fileManagerEntryLocalService.addFileManager(customerId, userId, model, serviceContext);

        return mapper.mapFromFileManagerToFileManagerEntry(fileManagerEntry);
    }

    public List<FileManager> getAllDGFileManager(long customerId, String parentCode) {

        List<FileManagerMapperModel> fromList =
                fileManagerRetriever.getAllDGFileManager(
                        customerId, parentCode);

        return mapper.mapFromFileManagerToFileManagerMapperModelList(fromList);

    }

    private List<Long> getAllFileId(long customerId,
                                    String parentCode) {

        return fileManagerRetriever.getAllFileId(customerId, parentCode);
    }

    public void deleteFileManagerOfParent(long customerId,
                                          String parentCode) {
        List<Long> list = getAllFileId(customerId, parentCode);

        list.stream().forEach(l -> {
            FileManagerEntry fileManagerEntry = fileManagerEntryLocalService.getFileManagerEntryByFileId(l, customerId);

            try {
                fileManagerEntryLocalService.deleteFileManagerEntry(fileManagerEntry.getId());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            try {
                dlFileEntryLocalService.deleteDLFileEntry(l);
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @Reference
    private FileManagerMapper mapper;

    @Reference
    private FileManagerEntryLocalService fileManagerEntryLocalService;

    @Reference
    protected Queries queries;

    @Reference
    private FileManagerRetriever fileManagerRetriever;

    @Reference
    private DLFileEntryLocalService dlFileEntryLocalService ;
}
