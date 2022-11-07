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

package com.swork.auth.department.service.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.auth.department.service.exception.NoSuchDepartmentEntryException;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.service.base.DepartmentEntryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.swork.auth.department.service.model.DepartmentEntry",
	service = AopService.class
)
public class DepartmentEntryLocalServiceImpl
	extends DepartmentEntryLocalServiceBaseImpl {
	public DepartmentEntry addDepartmentEntry(long accountId,
											  long businessId,
											  String name,
											  ServiceContext serviceContext) {

		DepartmentEntry entry = createDepartmentEntry(counterLocalService.increment(DepartmentEntry.class.getName()));

		Date current = new Date();

		createModifierAudit(
				accountId,
				entry,
				current,
				serviceContext
		);

		entry.setExternalReferenceCode(UUID.randomUUID().toString());

		entry.setBusinessId(businessId);
		entry.setName(name);
		return addDepartmentEntry(entry);
	}

	//    @Indexable(type = IndexableType.REINDEX)
	public DepartmentEntry updateDepartmentEntry(long accountId,
												 long departmentId,
												 long businessId,
												 String name,
												 ServiceContext serviceContext) {

		DepartmentEntry entry = fetchDepartmentEntry(departmentId);

		Date current = new Date();

		updateModifierAudit(
				accountId,
				entry,
				current,
				serviceContext
		);


		entry.setBusinessId(businessId);
		entry.setName(name);
		return updateDepartmentEntry(entry);
	}

	public DepartmentEntry getById(long id) throws PortalException {
		return departmentEntryLocalService.getDepartmentEntry(id);
	}

	public DepartmentEntry findByName(String name) throws NoSuchDepartmentEntryException, NoSuchDepartmentEntryException {
		return departmentEntryPersistence.findByName(name);
	}

	public void deleteByID(long id) throws NoSuchDepartmentEntryException {
		departmentEntryPersistence.remove(id);
	}


	private void createModifierAudit(long accountId,
									 DepartmentEntry entry,
									 Date current,
									 ServiceContext serviceContext) {

		entry.setGroupId(serviceContext.getScopeGroupId());
		entry.setCompanyId(serviceContext.getCompanyId());
		entry.setCreateDate(serviceContext.getCreateDate(current));
		entry.setAccountId(accountId);

		updateModifierAudit(accountId, entry, current, serviceContext);
	}

	private void updateModifierAudit(
			long modifierId,
			DepartmentEntry entry,
			Date current,
			ServiceContext serviceContext) {
		entry.setModifiedDate(serviceContext.getModifiedDate(current));
		entry.setModifiedId(modifierId);
	}

}