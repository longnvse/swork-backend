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

package com.swork.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.service.model.PetEntry;
import com.swork.service.service.base.PetEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.service.model.PetEntry",
        service = AopService.class
)
public class PetEntryLocalServiceImpl extends PetEntryLocalServiceBaseImpl {

    @Indexable(type = IndexableType.REINDEX)
    public PetEntry addPetEntry(long userId,
                                String name,
                                Long price,
                                ServiceContext serviceContext) {

        PetEntry petEntry = createPetEntry(counterLocalService.increment(PetEntry.class.getName()));

        createModifierAudit(
                petEntry,
                userLocalService.fetchUser(userId),
                serviceContext);

        petEntry.setName(name);
        petEntry.setPrice(price);

        return addPetEntry(petEntry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public PetEntry updatePetEntry(long userId,
                                   long petId,
                                   String name,
                                   Long price,
                                   ServiceContext serviceContext) {
        PetEntry petEntry = fetchPetEntry(petId);

        updateModifierAudit(
                petEntry,
                userLocalService.fetchUser(userId),
                serviceContext);

        petEntry.setName(name);
        petEntry.setPrice(price);

        return updatePetEntry(petEntry);
    }

    public List<PetEntry> getByPrice(long price) {
        return petEntryPersistence.findByPrice(price);
    }


    private void createModifierAudit(PetEntry entry,
                                     User user,
                                     ServiceContext serviceContext) {
        Date current = new Date();

        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));

        updateModifierAudit(entry, user, serviceContext);
    }

    private void updateModifierAudit(PetEntry entry,
                                     User user,
                                     ServiceContext serviceContext) {
        Date current = new Date();

        if (user != null) {
            entry.setUserName(user.getFullName());
            entry.setUserUuid(user.getUserUuid());
        }

        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setUserId(serviceContext.getUserId());
    }

}