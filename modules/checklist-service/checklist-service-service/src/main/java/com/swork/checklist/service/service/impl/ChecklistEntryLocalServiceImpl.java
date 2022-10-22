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

package com.swork.checklist.service.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.checklist.service.mapper.model.ChecklistMapperModel;
import com.swork.checklist.service.model.ChecklistEntry;
import com.swork.checklist.service.model.ChecklistHandlerEntry;
import com.swork.checklist.service.service.ChecklistHandlerEntryLocalService;
import com.swork.checklist.service.service.base.ChecklistEntryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.checklist.service.model.ChecklistEntry",
        service = AopService.class
)
public class ChecklistEntryLocalServiceImpl
        extends ChecklistEntryLocalServiceBaseImpl {
    @Indexable(type = IndexableType.REINDEX)
    public ChecklistEntry addCheckListEntry(long userId,
                                            ChecklistMapperModel model,
									  ServiceContext serviceContext) {
        // tao checklist entry thi co id r
        ChecklistEntry checklistEntry = createChecklistEntry(counterLocalService.increment(ChecklistEntry.class.getName()));


        createModifierAudit(
                checklistEntry,
                userLocalService.fetchUser(userId),
                serviceContext);

        checklistEntry.setName(model.getName());
        checklistEntry.setStartDate(model.getStartDate());
        checklistEntry.setEndDate(model.getEndDate());
        checklistEntry.setTaskId(model.getTaskId());
        checklistEntry.setStatus(model.getStatus());
            //duyet het tat ca handlers lay accountId de truyen
        Arrays.stream(model.getHandlers()).forEach(accountId -> checklistHandlerEntryLocalService.addCheckListHandlerEntry(checklistEntry.getChecklistId(), accountId));

        return addChecklistEntry(checklistEntry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public ChecklistEntry updateCheckListEntry(long userId,
                                               long checklistId,
                                               ChecklistMapperModel model,
                                               ServiceContext serviceContext) {
        ChecklistEntry checklistEntry = fetchChecklistEntry(checklistId);

        updateModifierAudit(
                checklistEntry,
                userLocalService.fetchUser(userId),
                serviceContext);

        checklistEntry.setName(model.getName());
        checklistEntry.setStartDate(model.getStartDate());
        checklistEntry.setEndDate(model.getEndDate());
//
        checklistEntry.setStatus(model.getStatus());

        checklistHandlerEntryLocalService.deleteByChecklistId(checklistId);
        Arrays.stream(model.getHandlers()).forEach(accountId -> checklistHandlerEntryLocalService.addCheckListHandlerEntry(checklistEntry.getChecklistId(), accountId));


        return updateChecklistEntry(checklistEntry);
    }

    public ChecklistEntry changeStatus(Long userId, Long checkListId, Boolean status, ServiceContext serviceContext) {
        ChecklistEntry checklistEntry = fetchChecklistEntry(checkListId);
        checklistEntry.setStatus(status);
        updateModifierAudit(
                checklistEntry,
                userLocalService.fetchUser(userId),
                serviceContext);

        return updateChecklistEntry(checklistEntry);
    }

    public ChecklistEntry findByName(String name) {
        return checklistEntryPersistence.fetchByName(name);
    }

    private void createModifierAudit(ChecklistEntry entry,
                                     User user,
                                     ServiceContext serviceContext) {
        Date current = new Date();

        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));

        updateModifierAudit(entry, user, serviceContext);
    }

    private void updateModifierAudit(ChecklistEntry entry,
                                     User user,
                                     ServiceContext serviceContext) {
        Date current = new Date();

        if (user != null) {
            entry.setUserName(user.getFullName());
            entry.setUserUuid(user.getUserUuid());
        }

        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setUserId(serviceContext.getUserId());
    }


    @Reference
    ChecklistHandlerEntryLocalService checklistHandlerEntryLocalService;
}