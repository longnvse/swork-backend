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
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.swork.core.project.service.mapper.model.ProjectMemberMapperModel;
import com.swork.core.project.service.model.ProjectMemberEntry;
import com.swork.core.project.service.service.base.ProjectMemberEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.core.project.service.model.ProjectMemberEntry",
        service = AopService.class
)
public class ProjectMemberEntryLocalServiceImpl
        extends ProjectMemberEntryLocalServiceBaseImpl {

    @Indexable(type = IndexableType.REINDEX)
    public ProjectMemberEntry addProjectMemberEntry(long projectId,
                                                    ProjectMemberMapperModel model,
                                                    String type) {
        ProjectMemberEntry entry = createProjectMemberEntry(counterLocalService.increment(ProjectMemberEntry.class.getName()));

        entry.setProjectId(projectId);
        entry.setMemberId(model.getMemberId());
        entry.setMemberType(model.getMemberType());
        entry.setMemberReferenceCode(model.getMemberReferenceCode());
        entry.setType(type);

        return addProjectMemberEntry(entry);
    }

    public List<ProjectMemberEntry> findByP_MT_T(long projectId, String memberType, String type) {
        return projectMemberEntryPersistence.findByP_T_MT(projectId, memberType, type);
    }

    public List<ProjectMemberEntry> findByP_T(long projectId, String type) {
        return projectMemberEntryPersistence.findByP_T_(projectId, type);
    }

    public void deleteByProjectId(long projectId) {
        projectMemberEntryPersistence.removeByP_(projectId);
    }

}