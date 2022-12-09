package com.swork.common.file.internal.retriever;

import com.swork.common.file.mapper.model.FileManagerMapperModel;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = FileManagerMapper.class)
public class FileManagerMapper {

    public FileManagerMapperModel mapperFileManagerMapperModel(long fileId,
                                                               String parentCode,
                                                               String fileType,
                                                               String fileName,
                                                               String fileSize) {

        FileManagerMapperModel to = new FileManagerMapperModel();

        to.setFileId(fileId);
        to.setParentCode(parentCode);
        to.setFileType(fileType);
        to.setFileName(fileName);
        to.setFileSize(fileSize);

        return to;
    }

}
