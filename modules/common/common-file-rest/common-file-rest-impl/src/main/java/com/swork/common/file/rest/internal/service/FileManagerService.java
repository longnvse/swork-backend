package com.swork.common.file.rest.internal.service;

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


    @Reference
    private FileManagerMapper mapper;

    @Reference
    private FileManagerEntryLocalService fileManagerEntryLocalService;

    @Reference
    protected Queries queries;

    @Reference
    private FileManagerRetriever fileManagerRetriever;
}
