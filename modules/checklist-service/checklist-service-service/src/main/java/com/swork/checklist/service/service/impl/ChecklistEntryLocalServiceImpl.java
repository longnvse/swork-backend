/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
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
import com.swork.checklist.service.model.ChecklistEntry;
import com.swork.checklist.service.service.base.ChecklistEntryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

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
									  String name,
									  Long taskId,
									  Boolean status,
									  ServiceContext serviceContext) {

		ChecklistEntry checklistEntry = createChecklistEntry(counterLocalService.increment(ChecklistEntry.class.getName()));

		createModifierAudit(
				checklistEntry,
				userLocalService.fetchUser(userId),
				serviceContext);

		checklistEntry.setName(name);
		checklistEntry.setTaskId(taskId);
		checklistEntry.setStatus(status);

		return addChecklistEntry(checklistEntry);
	}

	@Indexable(type = IndexableType.REINDEX)
	public ChecklistEntry updateCheckListEntry(Long userId,
											   Long cid,
											   String name,
											   Long taskId,
											   Boolean status,
											   ServiceContext serviceContext) {
		 ChecklistEntry checklistEntry = fetchChecklistEntry(cid);

		updateModifierAudit(
				checklistEntry,
				userLocalService.fetchUser(userId),
				serviceContext);

		checklistEntry.setName(name);
		checklistEntry.setTaskId(taskId);
		checklistEntry.setStatus(status);


		return updateChecklistEntry(checklistEntry);
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


}