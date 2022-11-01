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

package com.swork.account.service.service.impl;

import com.liferay.portal.aop.AopService;

import com.swork.account.service.model.AccountPermisionEntry;
import com.swork.account.service.model.AccountPermissionEntry;
import com.swork.account.service.model.PermissionDetailEntry;
import com.swork.account.service.service.AccountPermissionEntryLocalService;
import com.swork.account.service.service.base.PermissionDetailEntryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.swork.account.service.model.PermissionDetailEntry",
	service = AopService.class
)
public class PermissionDetailEntryLocalServiceImpl
	extends PermissionDetailEntryLocalServiceBaseImpl {
	public List<PermissionDetailEntry> getByAccountId(long accountId){
		AccountPermissionEntry entry =accountPermissionEntryLocalService.getByAccountId(accountId);
		System.out.print("xxx"+entry.toString());
		long permissionId=entry.getPermissionId();
		return permissionDetailEntryPersistence.findByPermissionId(permissionId);
	}
	@Reference
	AccountPermissionEntryLocalService accountPermissionEntryLocalService;
}