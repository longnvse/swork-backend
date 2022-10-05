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
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.base.AccountEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.account.service.model.AccountEntry",
        service = AopService.class
)
public class AccountEntryLocalServiceImpl
        extends AccountEntryLocalServiceBaseImpl {

    @Indexable(type = IndexableType.REINDEX)
    public AccountEntry addAccountEntry(long creatorId,
                                        String username,
                                        String password,
                                        String fullName,
                                        String email,
                                        Integer phoneNumber,
                                        String address,
                                        ServiceContext serviceContext) throws PwdEncryptorException {
        AccountEntry entry =
                createAccountEntry(counterLocalService.increment(AccountEntry.class.getName()));

        createModifierAudit(
                creatorId,
                entry,
                new Date(),
                serviceContext
        );

        entry.setUsername(username);
        entry.setPassword(password);
        entry.setFullName(fullName);
        entry.setEmail(email);
        entry.setPhoneNumber(phoneNumber);
        entry.setAddress(address);

        return addAccountEntry(entry);

    }

    @Indexable(type = IndexableType.REINDEX)
    public AccountEntry updateAccountEntry(long creatorId,
                                           long accountId,
                                           String fullName,
                                           String email,
                                           Integer phoneNumber,
                                           String address,
                                           ServiceContext serviceContext) {
        AccountEntry entry = fetchAccountEntry(accountId);

        updateModifierAudit(
                entry,
                new Date(),
                serviceContext
        );

        entry.setFullName(fullName);
        entry.setEmail(email);
        entry.setPhoneNumber(phoneNumber);
        entry.setAddress(address);

        return updateAccountEntry(entry);
    }

    public AccountEntry getAccount(String username) {
        AccountEntry entry = accountEntryPersistence.fetchByU(username);

        if (Validator.isNotNull(entry)) {
            return entry;
        }

        return accountEntryPersistence.fetchByEmail(username);
    }


    private void createModifierAudit(long creatorId,
                                     AccountEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setCreatorId(creatorId);

        updateModifierAudit(entry, current, serviceContext);
    }

    private void updateModifierAudit(AccountEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {
        entry.setModifiedDate(serviceContext.getModifiedDate(current));
    }
}