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

import com.liferay.portal.kernel.exception.PwdEncryptorException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.account.service.model.AccountPermisionEntry;
import com.swork.account.service.model.AccountPermissionEntry;
import com.swork.account.service.service.base.AccountPermissionEntryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.swork.account.service.model.AccountPermissionEntry",
	service = AopService.class
)
public class AccountPermissionEntryLocalServiceImpl
	extends AccountPermissionEntryLocalServiceBaseImpl {
	public AccountPermissionEntry addAccountPermissionEntry(long permissionId, long accountId, ServiceContext serviceContext) throws PwdEncryptorException {
		AccountPermissionEntry entry =
				createAccountPermissionEntry(counterLocalService.increment(AccountPermisionEntry.class.getName()));
		entry.setPermissionId(permissionId);
		entry.setAccountId(accountId);
		entry.setCompanyId(serviceContext.getCompanyId());

		return addAccountPermissionEntry(entry);

	}

	public AccountPermissionEntry getByAccountId(long accountId){
		return accountPermissionEntryPersistence.fetchByAccountId(accountId);
	}
}