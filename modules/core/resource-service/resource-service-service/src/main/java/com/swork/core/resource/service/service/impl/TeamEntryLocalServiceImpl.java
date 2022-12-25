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

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.core.resource.service.mapper.model.TeamMapperModel;
import com.swork.core.resource.service.model.TeamEntry;
import com.swork.core.resource.service.service.TeamMemberEntryLocalService;
import com.swork.core.resource.service.service.base.TeamEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.core.resource.service.model.TeamEntry",
        service = AopService.class
)
public class TeamEntryLocalServiceImpl extends TeamEntryLocalServiceBaseImpl {
    @Indexable(type = IndexableType.REINDEX)
    public TeamEntry addTeamEntry(long businessId,
                                  long creatorId,
                                  TeamMapperModel model,
                                  ServiceContext serviceContext) {
        TeamEntry entry = createTeamEntry(
                counterLocalService.increment(TeamEntry.class.getName()));

        Date current = new Date();

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                current,
                serviceContext);

        entry.setName(model.getName());
        entry.setDescription(model.getDescription());
        entry.setIsActive(model.getActive());

        entry.setPhaseId(model.getPhaseId());
        entry.setProjectId(model.getProjectId());
        entry.setTotalIncoming(GetterUtil.DEFAULT_LONG);
        entry.setTotalSpending(GetterUtil.DEFAULT_LONG);

        memberLocalService.addTeamMemberEntries(
                serviceContext.getCompanyId(),
                entry.getTeamId(),
                model.getAdmins(),
                true
        );

        memberLocalService.addTeamMemberEntries(
                serviceContext.getCompanyId(),
                entry.getTeamId(),
                model.getMembers(),
                false
        );

        return addTeamEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public TeamEntry updateTeamEntry(long creator,
                                     long teamId,
                                     TeamMapperModel model,
                                     ServiceContext serviceContext) {
        TeamEntry entry = fetchTeamEntry(teamId);

        Date current = new Date();

        updateModifierAudit(
                creator,
                entry,
                current,
                serviceContext);

        entry.setName(model.getName());
        entry.setDescription(model.getDescription());
        entry.setIsActive(model.getActive());

        memberLocalService.updateTeamMemberEntries(
                serviceContext.getCompanyId(),
                entry.getTeamId(),
                model.getAdmins(),
                true
        );

        memberLocalService.updateTeamMemberEntries(
                serviceContext.getCompanyId(),
                entry.getTeamId(),
                model.getMembers(),
                false
        );

        return updateTeamEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public void deleteByPhaseId(long businessId, long phaseId) {
        teamEntryPersistence.removeByB_PH(businessId, phaseId);
    }

    @Indexable(type = IndexableType.REINDEX)
    public void deleteByProjectId(long businessId, long projectId) {
        teamEntryPersistence.removeByB_P(businessId, projectId);
    }

    public List<TeamEntry> getByPhaseId(long businessId, long phaseId) {
        return teamEntryPersistence.findByB_PH(businessId, phaseId);
    }

    public List<TeamEntry> getByProjectId(long businessId, long projectId) {
        return teamEntryPersistence.findByB_P(businessId, projectId);
    }

    public int countCodeDb(long businessId, String code) {
        return teamEntryPersistence.countByB_C(businessId, code);
    }

    public TeamEntry findNameByProjectId(long businessId,
                                         String name,
                                         long projectId) {
        return teamEntryPersistence.fetchByB_N_P(businessId, name.trim().replaceAll("\\s+", StringPool.SPACE), projectId);
    }

    public TeamEntry findNameByPhaseId(long businessId,
                                       String name,
                                       long phaseId) {
        return teamEntryPersistence.fetchByB_N_PH(businessId, name.trim().replaceAll("\\s+", StringPool.SPACE), phaseId);
    }


    @Indexable(type = IndexableType.REINDEX)
    public TeamEntry addTotalIncoming(long objectGroupId, long totalIncoming) {
        TeamEntry teamEntry = fetchTeamEntry(objectGroupId);

        if (Validator.isNotNull(teamEntry)) {
            Long oldTotalIncoming = teamEntry.getTotalIncoming();

            teamEntry.setTotalIncoming(oldTotalIncoming + totalIncoming);
            return updateTeamEntry(teamEntry);
        }

        return null;
    }

    @Indexable(type = IndexableType.REINDEX)
    public TeamEntry addTotalSpending(long objectGroupId, long totalSpending) {
        TeamEntry teamEntry = fetchTeamEntry(objectGroupId);

        if (Validator.isNotNull(teamEntry)) {
            Long oldTotalSpending = teamEntry.getTotalSpending();

            teamEntry.setTotalSpending(oldTotalSpending + totalSpending);
            return updateTeamEntry(teamEntry);
        }

        return null;
    }

    private void createModifierAudit(long businessId,
                                     long creatorId,
                                     TeamEntry entry,
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

    private void updateModifierAudit(long modifiedId,
                                     TeamEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {


        if (GetterUtil.getBoolean(entry.getIsActive(), true)) {
            entry.setModifiedDate(serviceContext.getModifiedDate(current));
        }

        entry.setModifiedId(modifiedId);
    }

    @Reference
    private TeamMemberEntryLocalService memberLocalService;

}