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
import com.swork.checklist.service.mapper.model.ChecklistHandlerMapperModel;
import com.swork.checklist.service.model.ChecklistEntry;
import com.swork.checklist.service.model.ChecklistHandlerEntry;
import com.swork.checklist.service.service.ChecklistHandlerEntryLocalService;
import com.swork.checklist.service.service.base.ChecklistHandlerEntryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.checklist.service.model.ChecklistHandlerEntry",
        service = AopService.class
)
public class ChecklistHandlerEntryLocalServiceImpl
        extends ChecklistHandlerEntryLocalServiceBaseImpl {
    @Indexable(type = IndexableType.REINDEX)
    public ChecklistHandlerEntry addCheckListHandlerEntry(
            Long checkListId,
            Long accId
    ) {

        ChecklistHandlerEntry checklistHandlerEntry = createChecklistHandlerEntry(counterLocalService.increment(ChecklistHandlerEntry.class.getName()));

        checklistHandlerEntry.setCheckListId(checkListId);
        checklistHandlerEntry.setAccId(accId);

        return addChecklistHandlerEntry(checklistHandlerEntry);
    }

    public List<ChecklistHandlerEntry>  getByCheckListId(long checkListId){
        return checklistHandlerEntryPersistence.findBycheckListId(checkListId);
    }

    public void deleteByChecklistId(long checklistId){
        checklistHandlerEntryPersistence.removeBycheckListId(checklistId);
    }


}