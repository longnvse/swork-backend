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
import com.liferay.portal.kernel.model.User;
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
    public FileManagerEntry addFileManager(long customerId,
                                           long userId,
                                           FileManagerMapperModel model,
                                           ServiceContext serviceContext) {

        FileManagerEntry entry = createFileManagerEntry(
                counterLocalService.increment(FileManagerEntry.class.getName()));

        Date current = new Date();

        createModifierAudit(
                customerId,
                userId,
                entry,
                current,
                userLocalService.fetchUser(serviceContext.getUserId()),
                serviceContext);

        addFileManagerData(entry, model);

        return addFileManagerEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public FileManagerEntry updateFileManager(long fileManagerId,
                                              FileManagerMapperModel model,
                                              ServiceContext serviceContext) {

        FileManagerEntry entry = fileManagerEntryPersistence.fetchByPrimaryKey(fileManagerId);

        addFileManagerData(entry, model);

        return updateFileManagerEntry(entry);

    }

    public FileManagerEntry getFileManagerEntryByFileId(long fileId,
                                                        long customerId) {

        return fileManagerEntryPersistence.fetchByF_C(fileId, customerId);
    }

    private void addFileManagerData(FileManagerEntry entry,
                                    FileManagerMapperModel model) {

        entry.setFileId(model.getFileId());
        entry.setParentCode(model.getParentCode());
        entry.setFileType(model.getFileType());
        entry.setType(model.getType());
        entry.setPkType(model.getPkType());
        entry.setFileName(model.getFileName());
        entry.setFileSize(model.getFileSize());
        entry.setModuleId(model.getModuleId());
        entry.setAppId(model.getAppId());
    }

    private void createModifierAudit(long customerId,
                                     long creatorId,
                                     FileManagerEntry entry,
                                     Date current,
                                     User user,
                                     ServiceContext serviceContext) {

        entry.setCustomerId(customerId);
        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setExternalReferenceCode(UUID.randomUUID().toString());

        updateModifierAudit(creatorId, entry, current, user, serviceContext);
    }

    private void updateModifierAudit(long creatorId,
                                     FileManagerEntry entry,
                                     Date current,
                                     User user,
                                     ServiceContext serviceContext) {

        if (user != null) {
            entry.setUserName(user.getFullName());
            entry.setUserUuid(user.getUserUuid());
        }

        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setUserId(serviceContext.getUserId());
        entry.setCreatorId(creatorId);
    }

}