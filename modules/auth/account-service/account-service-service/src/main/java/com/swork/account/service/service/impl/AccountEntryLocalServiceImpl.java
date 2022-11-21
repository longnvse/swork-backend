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

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.constant.Role;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.base.AccountEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.UUID;

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
                                        long businessId,
                                        String username,
                                        String password,
                                        String fullName,
                                        Date dateOfBirth,
                                        String email,
                                        String phoneNumber,
                                        String address,
                                        ServiceContext serviceContext) {
        AccountEntry entry =
                createAccountEntry(counterLocalService.increment(AccountEntry.class.getName()));

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                new Date(),
                serviceContext
        );

        entry.setUsername(username);
        entry.setPassword(password);
        entry.setFullName(fullName);
        entry.setDateOfBirth(dateOfBirth);
        entry.setEmail(email);
        entry.setPhoneNumber(phoneNumber);
        entry.setAddress(address);
        entry.setRole(Role.USER.getValue());
        return addAccountEntry(entry);

    }

    @Indexable(type = IndexableType.REINDEX)
    public AccountEntry addAccountAdmin(long creatorId,
                                        long businessId,
                                        String email,
                                        String password,
                                        ServiceContext serviceContext) {
        AccountEntry entry =
                createAccountEntry(counterLocalService.increment(AccountEntry.class.getName()));

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                new Date(),
                serviceContext
        );

        entry.setFullName("Admin");
        entry.setEmail(email);
        entry.setPassword(password);
        entry.setRole(Role.ADMIN.getValue());

        return addAccountEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public AccountEntry addAccountSuperAdmin(String username,
                                             String email,
                                             String password,
                                             ServiceContext serviceContext) {
        AccountEntry entry =
                createAccountEntry(counterLocalService.increment(AccountEntry.class.getName()));

        createModifierAudit(
                GetterUtil.DEFAULT_LONG,
                GetterUtil.DEFAULT_LONG,
                entry,
                new Date(),
                serviceContext
        );

        entry.setFullName("Admin");
        entry.setEmail(email);
        entry.setPassword(password);
        entry.setRole(Role.SUPER_ADMIN.getValue());

        return addAccountEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public AccountEntry updateAccountEntry(long creatorId,
                                           long accountId,
                                           String fullName,
                                           Date dateOfBirth,
                                           String email,
                                           String phoneNumber,
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
        entry.setDateOfBirth(dateOfBirth);

        return updateAccountEntry(entry);
    }

    public AccountEntry getAccount(String username) {
        AccountEntry entry = accountEntryPersistence.fetchByUsername(username);

        if (Validator.isNotNull(entry)) {
            return entry;
        }

        return accountEntryPersistence.fetchByEmail(username);
    }

    @Indexable(type = IndexableType.REINDEX)
    public AccountEntry updateStatus(long accountId, String status, ServiceContext serviceContext) {
        AccountEntry entry = fetchAccountEntry(accountId);

        updateModifierAudit(entry, new Date(), serviceContext);

        entry.setStatus(status);

        return updateAccountEntry(entry);
    }

    public AccountEntry findByEmail(String email) {
        return accountEntryPersistence.fetchByEmail(email.trim().replaceAll("\\s+", StringPool.BLANK));
    }

    public AccountEntry findByPhone(String phoneNumber) {
        return accountEntryPersistence.fetchByPhone(phoneNumber.trim().replaceAll("\\s+", StringPool.BLANK));
    }


    private void createModifierAudit(long businessId,
                                     long creatorId,
                                     AccountEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setCreatorId(creatorId);
        entry.setBusinessId(businessId);
        entry.setExternalReferenceCode(UUID.randomUUID().toString());
        entry.setStatus("active");

        updateModifierAudit(entry, current, serviceContext);
    }

    private void updateModifierAudit(AccountEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {
        entry.setModifiedDate(serviceContext.getModifiedDate(current));
    }
}