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

package com.swork.business.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.business.service.mapper.model.BusinessMapperModel;
import com.swork.business.service.model.BusinessEntry;
import com.swork.business.service.service.base.BusinessEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.business.service.model.BusinessEntry",
        service = AopService.class
)
public class BusinessEntryLocalServiceImpl
        extends BusinessEntryLocalServiceBaseImpl {
    @Indexable(type = IndexableType.REINDEX)
    public BusinessEntry addBusinessEntry(long creatorId,
                                          BusinessMapperModel model,
                                          ServiceContext serviceContext) {

        BusinessEntry entry = createBusinessEntry(counterLocalService.increment(BusinessEntry.class.getName()));

        Date current = new Date();

        createModifierAudit(
                creatorId,
                entry,
                current,
                accountEntryLocalService.fetchAccountEntry(creatorId),
                serviceContext
        );

        entry.setExternalReferenceCode(UUID.randomUUID().toString());

        entry.setName(model.getName());
        entry.setCustomerName(model.getCustomerName());
        entry.setPhoneNumber(model.getPhoneNumber());
        entry.setEmail(model.getEmail());
        entry.setBusinessAddress(model.getBusinessAddress());
        entry.setFieldOperations(model.getFieldOperations());

        return addBusinessEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public BusinessEntry updateBusinessEntry(long modifiedId,
                                             long businessId,
                                             BusinessMapperModel model,
                                             ServiceContext serviceContext) {

        BusinessEntry entry = fetchBusinessEntry(businessId);

        Date current = new Date();

        updateModifierAudit(
                entry,
                current,
                accountEntryLocalService.fetchAccountEntry(modifiedId),
                serviceContext
        );

        entry.setName(model.getName());
        entry.setCustomerName(model.getCustomerName());
        entry.setPhoneNumber(model.getPhoneNumber());
        entry.setEmail(model.getEmail());
        entry.setBusinessAddress(model.getBusinessAddress());
        entry.setFieldOperations(model.getFieldOperations());

        return addBusinessEntry(entry);
    }

    public BusinessEntry findByPhoneNumber(String phoneNumber) {
        return businessEntryPersistence.fetchByPhone(phoneNumber);
    }

    public BusinessEntry findByEmail(String email) {
        return businessEntryPersistence.fetchByEmail(email);
    }

    public BusinessEntry findByName(String name) {
        return businessEntryPersistence.fetchByName(name);
    }


    private void createModifierAudit(long creatorId,
                                     BusinessEntry entry,
                                     Date current,
                                     AccountEntry account,
                                     ServiceContext serviceContext) {

        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setCreatorId(creatorId);

        updateModifierAudit(entry, current, account, serviceContext);
    }

    private void updateModifierAudit(BusinessEntry entry,
                                     Date current,
                                     AccountEntry account,
                                     ServiceContext serviceContext) {
        if (account != null) {
            entry.setUserName(account.getUsername());
            entry.setAccountId(account.getAccountId());
        }

        entry.setModifiedDate(serviceContext.getModifiedDate(current));
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}