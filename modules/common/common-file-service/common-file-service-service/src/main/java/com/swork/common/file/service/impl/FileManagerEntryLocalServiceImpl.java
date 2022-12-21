/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.swork.common.file.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.common.file.mapper.model.FileManagerMapperModel;
import com.swork.common.file.model.FileManagerEntry;
import com.swork.common.file.service.base.FileManagerEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.common.file.model.FileManagerEntry",
        service = AopService.class
)
public class FileManagerEntryLocalServiceImpl
        extends FileManagerEntryLocalServiceBaseImpl {
    @Indexable(type = IndexableType.REINDEX)
    public FileManagerEntry addFileManager(long businessId,
                                           long creatorId,
                                           Long projectId,
                                           Long phaseId,
                                           Long workId,
                                           FileManagerMapperModel model,
                                           ServiceContext serviceContext) {

        FileManagerEntry entry = createFileManagerEntry(
                counterLocalService.increment(FileManagerEntry.class.getName()));

        Date current = new Date();

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                current,
                serviceContext);

        entry.setProjectId(projectId);
        entry.setPhaseId(phaseId);
        entry.setWorkId(workId);

        addFileManagerData(entry, model);

        return addFileManagerEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public FileManagerEntry updateFileName(long fileManagerId,
                                           String name,
                                           ServiceContext serviceContext) {

        FileManagerEntry entry = fileManagerEntryPersistence.fetchByPrimaryKey(fileManagerId);

        entry.setFileName(name);

        return updateFileManagerEntry(entry);
    }

    public FileManagerEntry getFileManagerEntryByFileId(long fileId,
                                                        long businessId) {

        return fileManagerEntryPersistence.fetchByF_C(fileId, businessId);
    }

    private void addFileManagerData(FileManagerEntry entry,
                                    FileManagerMapperModel model) {

        entry.setFileId(model.getFileId());
        entry.setFileType(model.getFileType());
        entry.setFileName(model.getFileName());
        entry.setFileSize(model.getFileSize());
        entry.setMimeType(model.getMimeType());
        entry.setModuleId(model.getModuleId());
        entry.setAppId(model.getAppId());
    }

    private void createModifierAudit(long businessId,
                                     long creatorId,
                                     FileManagerEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setBusinessId(businessId);
        entry.setAccountId(creatorId);
        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setExternalReferenceCode(UUID.randomUUID().toString());
        entry.setModifiedDate(serviceContext.getCreateDate(current));
    }

}