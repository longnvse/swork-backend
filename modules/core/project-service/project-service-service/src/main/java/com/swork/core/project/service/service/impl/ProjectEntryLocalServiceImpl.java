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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.swork.core.project.service.constant.Type;
import com.swork.core.project.service.mapper.model.ProjectMapperModel;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectMemberEntryLocalService;
import com.swork.core.project.service.service.base.ProjectEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.core.project.service.model.ProjectEntry",
        service = AopService.class
)
public class ProjectEntryLocalServiceImpl
        extends ProjectEntryLocalServiceBaseImpl {

    private static final String PENDING = "pending";
    private static final String APPROVED = "approved";
    private static final String DOING = "doing";

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public ProjectEntry addProject(long businessId,
                                   long creatorId,
                                   ProjectMapperModel model,
                                   ServiceContext serviceContext) {
        ProjectEntry entry =
                createProjectEntry(
                        counterLocalService
                                .increment(ProjectEntry.class.getName()));

        Date currentDate = new Date();

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                currentDate,
                serviceContext);

        setProjectData(entry, model);
        entry.setStatus(PENDING);
        entry.setExternalReferenceCode(UUID.randomUUID().toString());

        addMember(entry.getProjectId(), model);

        return addProjectEntry(entry);
    }

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public ProjectEntry updateProject(long creatorId,
                                      long projectId,
                                      ProjectMapperModel model,
                                      ServiceContext serviceContext) {
        ProjectEntry entry = fetchProjectEntry(projectId);

        Date currentDate = new Date();

        updateModifierAudit(
                creatorId,
                entry,
                currentDate,
                serviceContext);

        setProjectData(entry, model);

        projectMemberEntryLocalService.deleteByProjectId(projectId);

        addMember(projectId, model);

        return addProjectEntry(entry);
    }

    private void addMember(long projectId, ProjectMapperModel model) {
        model.getManages()
                .forEach(manage -> projectMemberEntryLocalService
                        .addProjectMemberEntry(
                                projectId,
                                manage,
                                Type.MANAGE.getValue()));

        model.getHandles()
                .forEach(handle -> projectMemberEntryLocalService
                        .addProjectMemberEntry(
                                projectId,
                                handle,
                                Type.HANDLE.getValue()));

        model.getParticipates()
                .forEach(participate -> projectMemberEntryLocalService
                        .addProjectMemberEntry(
                                projectId,
                                participate,
                                Type.PARTICIPATE.getValue()));

    }

    @Indexable(type = IndexableType.REINDEX)
    public ProjectEntry approvalProject(long creatorId,
                                        long projectId,
                                        String status,
                                        ServiceContext serviceContext) {

        ProjectEntry entry = fetchProjectEntry(projectId);

        Date currentDate = new Date();

        updateModifierAudit(
                creatorId,
                entry,
                currentDate,
                serviceContext);

        entry.setStatus(status);
        if (status.equals(DOING))
            entry.setActualStartDate(new Date());
        else if (status.equals(APPROVED))
            entry.setActualEndDate(new Date());

        return updateProjectEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public ProjectEntry updateDescription(long creatorId,
                                          long projectId,
                                          String description,
                                          ServiceContext serviceContext) {

        ProjectEntry entry = fetchProjectEntry(projectId);

        Date currentDate = new Date();

        updateModifierAudit(
                creatorId,
                entry,
                currentDate,
                serviceContext);

        entry.setDescription(description);

        return updateProjectEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public ProjectEntry updateDate(long creatorId,
                                   long projectId,
                                   Date startDate,
                                   Date endDate,
                                   ServiceContext serviceContext) {

        ProjectEntry entry = fetchProjectEntry(projectId);

        Date currentDate = new Date();

        updateModifierAudit(
                creatorId,
                entry,
                currentDate,
                serviceContext);

        entry.setStartDate(startDate);
        entry.setEndDate(endDate);

        return updateProjectEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public ProjectEntry updateActualDate(long creatorId,
                                         long projectId,
                                         Date actualStartDate,
                                         Date actualEndDate,
                                         ServiceContext serviceContext) {

        ProjectEntry entry = fetchProjectEntry(projectId);

        Date currentDate = new Date();

        updateModifierAudit(
                creatorId,
                entry,
                currentDate,
                serviceContext);

        entry.setActualStartDate(actualStartDate);
        entry.setActualEndDate(actualEndDate);

        return updateProjectEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public ProjectEntry updateMember(long creatorId,
                                     long projectId,
                                     ProjectMapperModel model,
                                     ServiceContext serviceContext) {

        ProjectEntry entry = fetchProjectEntry(projectId);

        Date currentDate = new Date();

        updateModifierAudit(
                creatorId,
                entry,
                currentDate,
                serviceContext);

        projectMemberEntryLocalService.deleteByProjectId(projectId);

        addMember(projectId, model);

        return updateProjectEntry(entry);
    }

    public ProjectEntry getByName(long businessId, String projectName) {
        return projectEntryPersistence.fetchByP_N(businessId, projectName);
    }

    public ProjectEntry getByCode(long businessId, String projectCode) {
        return projectEntryPersistence.fetchByP_C(businessId, projectCode);
    }

    public List<ProjectEntry> findByBusinessId(long businessId) {
        return projectEntryPersistence.findByB_(businessId);
    }

    private void setProjectData(ProjectEntry entry,
                                ProjectMapperModel model) {
        entry.setCode(model.getCode());
        entry.setName(model.getName());
        entry.setBudget(model.getBudget());
        entry.setDescription(model.getDescription());
        entry.setStartDate(model.getStartDate());
        entry.setEndDate(model.getEndDate());
        entry.setStatus(model.getStatus());
        entry.setProgress(model.getProgress());
        entry.setActualEndDate(model.getActualEndDate());
        entry.setActualStartDate(model.getActualStartDate());
        entry.setProgressType(model.getProgressType());
    }

    private void createModifierAudit(long businessId,
                                     long creatorId,
                                     ProjectEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setBusinessId(businessId);
        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setAccountId(creatorId);

        updateModifierAudit(creatorId, entry, current, serviceContext);
    }

    private void updateModifierAudit(long modifiedId,
                                     ProjectEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setModifiedId(serviceContext.getUserId());
        entry.setModifiedId(modifiedId);
    }

    @Reference
    private ProjectMemberEntryLocalService projectMemberEntryLocalService;
}