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
import com.swork.core.resource.service.mapper.model.ResourceMapperModel;
import com.swork.core.resource.service.model.ResourceEntry;
import com.swork.core.resource.service.service.base.ResourceEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.core.resource.service.model.ResourceEntry",
        service = AopService.class
)
public class ResourceEntryLocalServiceImpl
        extends ResourceEntryLocalServiceBaseImpl {
    @Indexable(type = IndexableType.REINDEX)
    public ResourceEntry addResourceEntry(long businessId,
                                          long creatorId,
                                          Long workId,
                                          Long phaseId,
                                          Long projectId,
                                          ResourceMapperModel model,
                                          ServiceContext serviceContext) {
        ResourceEntry entry = createResourceEntry(
                counterLocalService.increment(ResourceEntry.class.getName()));

        Date current = new Date();

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                current,
                serviceContext);

        entry.setWorkId(workId);
        entry.setPhaseId(phaseId);
        entry.setProjectId(projectId);
        setDataEntry(entry, model);

        return addResourceEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public ResourceEntry updateResourceEntry(long creatorId,
                                             long resourceId,
                                             ResourceMapperModel model,
                                             ServiceContext serviceContext) {
        ResourceEntry entry = fetchResourceEntry(resourceId);

        updateModifierAudit(
                creatorId,
                entry,
                new Date(),
                serviceContext
        );

        setDataEntry(entry, model);

        return updateResourceEntry(entry);
    }

    private void setDataEntry(ResourceEntry entry, ResourceMapperModel model) {
        entry.setResourceTypeName(model.getResourceTypeName());
        entry.setTeamId(model.getTeamId());
        entry.setTeamName(model.getTeamName());
        entry.setQuantity(model.getQuantity());
        entry.setUnit(model.getUnit());
        entry.setDateResource(model.getDateResource());
        entry.setTotalAmount(model.getTotalAmount());
        entry.setType(model.getType());
    }

    public List<ResourceEntry> getByParentId(long businessId, long workId, long phaseId, long projectId) {
        return resourceEntryPersistence.findByB_W_PH_P(businessId, workId, phaseId, projectId);
    }

    public List<ResourceEntry> getByTaskId(long businessId, long workId) {
        return resourceEntryPersistence.findByB_W(businessId, workId);
    }

    public List<ResourceEntry> getByPhaseId(long businessId, long phaseId) {
        return resourceEntryPersistence.findByB_PH(businessId, phaseId);
    }

    public List<ResourceEntry> getByProjectId(long businessId, long projectId) {
        return resourceEntryPersistence.findByB_P(businessId, projectId);
    }

    public List<ResourceEntry> getByObjectGroupId(long businessId, long teamId) {
        return resourceEntryPersistence.findByB_Team(businessId, teamId);
    }

    private void createModifierAudit(long businessId,
                                     long creatorId,
                                     ResourceEntry entry,
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
                                     ResourceEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {


        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setModifiedId(creatorId);
    }
}