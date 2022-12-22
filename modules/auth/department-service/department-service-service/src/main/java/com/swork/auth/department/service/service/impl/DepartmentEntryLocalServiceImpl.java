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

package com.swork.auth.department.service.service.impl;


import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.swork.auth.department.service.mapper.model.DepartmentMapperModel;
import com.swork.auth.department.service.model.DepartmentAccountEntry;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.service.DepartmentAccountEntryLocalService;
import com.swork.auth.department.service.service.base.DepartmentEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
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
    @Indexable(type = IndexableType.REINDEX)
    public DepartmentEntry addDepartmentEntry(long businessId,
                                              long creatorId,
                                              DepartmentMapperModel model,
                                              ServiceContext serviceContext) {

        DepartmentEntry entry = createDepartmentEntry(counterLocalService.increment(DepartmentEntry.class.getName()));

        Date current = new Date();

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                current,
                serviceContext
        );

        entry.setExternalReferenceCode(UUID.randomUUID().toString());
        entry.setName(model.getName());

        Arrays
                .stream(model.getAccounts())
                .forEach(accountId ->
                        departmentAccountEntryLocalService.addDepartmentAccountEntry(
                                entry.getDepartmentId(),
                                accountId,
                                serviceContext.getCompanyId()));

        return addDepartmentEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public DepartmentEntry updateDepartmentEntry(long modifiedId,
                                                 long departmentId,
                                                 DepartmentMapperModel model,
                                                 ServiceContext serviceContext) {
        DepartmentEntry entry = fetchDepartmentEntry(departmentId);

        Date current = new Date();

        updateModifierAudit(
                modifiedId,
                entry,
                current,
                serviceContext
        );
        entry.setName(model.getName());

        departmentAccountEntryLocalService.deleteByDepartmentId(departmentId);
        Arrays
                .stream(model.getAccounts())
                .forEach(accountId ->
                        departmentAccountEntryLocalService.addDepartmentAccountEntry(
                                entry.getDepartmentId(),
                                accountId,
                                serviceContext.getCompanyId()));

        return updateDepartmentEntry(entry);
    }

    public DepartmentEntry getById(long id) throws PortalException {
        return departmentEntryLocalService.getDepartmentEntry(id);
    }

    public DepartmentEntry findByName(String name) {
        return departmentEntryPersistence.fetchByName(name);
    }

    public DepartmentEntry findByAccount(long accountId) {
        DepartmentAccountEntry departmentAccountEntry = departmentAccountEntryLocalService.getByAccountId(accountId);

        if (Validator.isNotNull(departmentAccountEntry)) {
            return fetchDepartmentEntry(departmentAccountEntry.getDepartmentId());
        }

        return null;
    }

    private void createModifierAudit(long businessId,
                                     long accountId,
                                     DepartmentEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setAccountId(accountId);
        entry.setBusinessId(businessId);

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

    @Reference
    DepartmentAccountEntryLocalService departmentAccountEntryLocalService;

}