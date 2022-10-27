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

package com.swork.account.service.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PwdEncryptorException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.model.AccountPermisionEntry;
import com.swork.account.service.service.base.AccountPermisionEntryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.account.service.model.AccountPermisionEntry",
        service = AopService.class
)
public class AccountPermisionEntryLocalServiceImpl
        extends AccountPermisionEntryLocalServiceBaseImpl {
    public AccountPermisionEntry addAccountPermisionEntry(long permisionId,long accountId,ServiceContext serviceContext) throws PwdEncryptorException {
        AccountPermisionEntry entry =
                createAccountPermisionEntry(counterLocalService.increment(AccountPermisionEntry.class.getName()));
        entry.setPermisionId(permisionId);
        entry.setAccountId(accountId);
        entry.setCompanyId(serviceContext.getCompanyId());

        return addAccountPermisionEntry(entry);

    }



}