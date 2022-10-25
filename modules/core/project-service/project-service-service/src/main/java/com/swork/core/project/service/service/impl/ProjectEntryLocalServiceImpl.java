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

package com.swork.core.project.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.account.service.model.AccountEntry;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.base.ProjectEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.core.project.service.model.ProjectEntry",
        service = AopService.class
)
public class ProjectEntryLocalServiceImpl
        extends ProjectEntryLocalServiceBaseImpl {

    private void createModifierAudit(long businessId,
                                     long creatorId,
                                     ProjectEntry entry,
                                     Date current,
                                     AccountEntry account,
                                     ServiceContext serviceContext) {

        entry.setBusinessId(businessId);
        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setAccountId(account.getAccountId());

        updateModifierAudit(creatorId, entry, current, account, serviceContext);
    }

    private void updateModifierAudit(long modifiedId,
                                     ProjectEntry entry,
                                     Date current,
                                     AccountEntry account,
                                     ServiceContext serviceContext) {

        if (account != null) {
            entry.setUserName(account.getUsername());
        }

        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setModifiedId(serviceContext.getUserId());
        entry.setModifiedId(modifiedId);
    }
}