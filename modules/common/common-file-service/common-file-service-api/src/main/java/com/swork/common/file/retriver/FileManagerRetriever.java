package com.swork.common.file.retriver;

import com.swork.common.file.mapper.model.FileManagerMapperModel;
import org.osgi.annotation.versioning.ProviderType;

import java.util.List;

@ProviderType
public interface FileManagerRetriever {
    List<FileManagerMapperModel> getAllDGFileManagerByPKType(long customerId ,
                                                             String parentCode ,
                                                             String pkType);

    List<Long> getAllFileId(long customerId ,
                            String parentCode );


    List<FileManagerMapperModel> getAllDGFileManager(long customerId ,
                                                     String parentCode );

}
