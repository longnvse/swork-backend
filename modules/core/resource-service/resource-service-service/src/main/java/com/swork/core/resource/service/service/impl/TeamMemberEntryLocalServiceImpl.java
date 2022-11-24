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
import com.swork.core.resource.service.mapper.model.TeamMemberMapperModel;
import com.swork.core.resource.service.mapper.model.TeamMembersMapperModel;
import com.swork.core.resource.service.model.TeamMemberEntry;
import com.swork.core.resource.service.service.base.TeamMemberEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.core.resource.service.model.TeamMemberEntry",
        service = AopService.class
)
public class TeamMemberEntryLocalServiceImpl
        extends TeamMemberEntryLocalServiceBaseImpl {
    @Indexable(type = IndexableType.REINDEX)
    public TeamMemberEntry addTeamMemberEntries(long companyId,
                                                long teamId,
                                                TeamMemberMapperModel model,
                                                boolean isAdmin) {
        TeamMemberEntry entry =
                createTeamMemberEntry(counterLocalService.increment(TeamMemberEntry.class.getName()));

        entry.setCompanyId(companyId);
        entry.setMemberId(model.getMemberId());
        entry.setMemberName(model.getMemberName());
        entry.setIsAdmin(isAdmin);
        entry.setTeamId(teamId);

        return addTeamMemberEntry(entry);
    }

    public void addTeamMemberEntries(long companyId,
                                     long teamId,
                                     TeamMembersMapperModel models,
                                     boolean isAdmin) {
        models.forEach(model -> addTeamMemberEntries(companyId, teamId, model, isAdmin));
    }

    public void updateTeamMemberEntries(long companyId,
                                        long teamId,
                                        TeamMembersMapperModel model,
                                        boolean isAdmin) {
        if (isAdmin) {
            deleteAdminByTeamId(teamId);
        } else {
            deleteMemberByTeamId(teamId);
        }

        addTeamMemberEntries(companyId, teamId, model, isAdmin);

    }

    @Indexable(type = IndexableType.REINDEX)
    public void deleteMemberByTeamId(long teamId) {
        teamMemberEntryPersistence.removeByTeam(teamId, false);
    }

    @Indexable(type = IndexableType.REINDEX)
    public void deleteAdminByTeamId(long teamId) {
        teamMemberEntryPersistence.removeByTeam(teamId, true);
    }

    public List<TeamMemberEntry> getMembersByTeamId(long teamId) {
        return teamMemberEntryPersistence.findByTeam(teamId, false);
    }

    public List<TeamMemberEntry> getAdminsByTeamId(long teamId) {
        return teamMemberEntryPersistence.findByTeam(teamId, true);
    }
}