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

package com.swork.core.resource.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.core.resource.service.mapper.model.ResourceTypeMapperModel;
import com.swork.core.resource.service.model.ResourceTypeEntry;
import com.swork.core.resource.service.service.base.ResourceTypeEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.core.resource.service.model.ResourceTypeEntry",
        service = AopService.class
)
public class ResourceTypeEntryLocalServiceImpl
        extends ResourceTypeEntryLocalServiceBaseImpl {
    @Indexable(type = IndexableType.REINDEX)
    public ResourceTypeEntry addResourceTypeEntry(long businessId,
                                                  long creatorId,
                                                  ResourceTypeMapperModel model,
                                                  ServiceContext serviceContext) {
        ResourceTypeEntry entry = createResourceTypeEntry(
                counterLocalService.increment(ResourceTypeEntry.class.getName()));

        Date current = new Date();

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                current,
                serviceContext);

        entry.setName(model.getName());
        entry.setUnit(model.getUnit());
        entry.setParentId(model.getParentTypeId());

        return addResourceTypeEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public ResourceTypeEntry updateResourceTypeEntry(long creatorId,
                                                     long okrIntervalConfigEntryId,
                                                     ResourceTypeMapperModel model,
                                                     ServiceContext serviceContext) {
        ResourceTypeEntry entry = fetchResourceTypeEntry(okrIntervalConfigEntryId);

        Date current = new Date();

        updateModifierAudit(
                creatorId,
                entry,
                current,
                serviceContext);

        entry.setName(model.getName());
        entry.setUnit(model.getUnit());
        entry.setParentId(model.getParentTypeId());

        return updateResourceTypeEntry(entry);
    }

    private static final long DEFAULT_CUSTOMER_ID = GetterUtil.DEFAULT_LONG;

    public ResourceTypeEntry findByName(long businessId, String name) {
        ResourceTypeEntry resourceTypeEntryDefault =
                resourceTypeEntryPersistence.fetchByB_N(DEFAULT_CUSTOMER_ID, name.trim().replaceAll("\\s+", " "));

        if (Validator.isNotNull(resourceTypeEntryDefault)) {
            return resourceTypeEntryDefault;
        }

        return resourceTypeEntryPersistence.fetchByB_N(businessId, name.trim().replaceAll("\\s+", " "));
    }

    public List<ResourceTypeEntry> getChildren(long businessId, long parentId) {
        return resourceTypeEntryPersistence.findByB_PT(businessId, parentId);
    }

    private void createModifierAudit(long businessId,
                                     long creatorId,
                                     ResourceTypeEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setBusinessId(businessId);
        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setExternalReferenceCode(UUID.randomUUID().toString());
        entry.setAccountId(creatorId);

        updateModifierAudit(creatorId, entry, current, serviceContext);
    }

    private void updateModifierAudit(long creatorId,
                                     ResourceTypeEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {


        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setModifiedId(creatorId);
    }
}