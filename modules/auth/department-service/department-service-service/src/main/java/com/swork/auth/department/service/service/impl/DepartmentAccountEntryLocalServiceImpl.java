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
import com.swork.auth.department.service.model.DepartmentAccountEntry;
import com.swork.auth.department.service.service.base.DepartmentAccountEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.swork.auth.department.service.model.DepartmentAccountEntry",
	service = AopService.class
)
public class DepartmentAccountEntryLocalServiceImpl
	extends DepartmentAccountEntryLocalServiceBaseImpl {
	public DepartmentAccountEntry addDepartmentAccountEntry(
													 long departmentId,
													 long accountId,
													 long companyId) {

		DepartmentAccountEntry entry = createDepartmentAccountEntry(counterLocalService.increment(DepartmentAccountEntry.class.getName()));

		entry.setExternalReferenceCode(UUID.randomUUID().toString());
		entry.setCompanyId(companyId);
		entry.setAccountId(accountId);
		entry.setDepartmentId(departmentId);
		return addDepartmentAccountEntry(entry);
	}

	public List<DepartmentAccountEntry> getByDepartmentId(long departmentId){
		return departmentAccountEntryPersistence.findByDepartmentId(departmentId);
	}

	public void deleteByDepartmentId(long departmentId){
		departmentAccountEntryPersistence.removeByDepartmentId(departmentId);
	}


}