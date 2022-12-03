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

package com.swork.core.work.service.service.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.swork.core.project.service.constant.Type;
import com.swork.core.work.service.mapper.model.WorkMapperModel;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.service.WorkMemberEntryLocalService;
import com.swork.core.work.service.service.base.WorkEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.core.work.service.model.WorkEntry",
        service = AopService.class
)
public class WorkEntryLocalServiceImpl extends WorkEntryLocalServiceBaseImpl {

    private static final String PENDING = "pending";

    @Indexable(type = IndexableType.REINDEX)
    public WorkEntry addWorkEntry(long businessId,
                                  long creatorId,
                                  WorkMapperModel model,
                                  ServiceContext serviceContext) {
        WorkEntry entry = createWorkEntry(counterLocalService.increment(WorkEntry.class.getName()));

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                new Date(),
                serviceContext
        );

        setDataEntry(entry, model);
        entry.setStatus(PENDING);
        entry.setProjectId(model.getProjectId());
        entry.setPhaseId(model.getPhaseId());

        return addWorkEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public WorkEntry updateWorkEntry(long creatorId,
                                     long workId,
                                     WorkMapperModel model,
                                     ServiceContext serviceContext) {
        WorkEntry entry = fetchWorkEntry(workId);

        updateModifierAudit(
                creatorId,
                entry,
                new Date(),
                serviceContext
        );

        workMemberEntryLocalService.deleteByWorkId(workId);

        setDataEntry(entry, model);

        return updateWorkEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public WorkEntry updateStatus(long creatorId,
                                  long workId,
                                  String status,
                                  ServiceContext serviceContext) {

        WorkEntry entry = fetchWorkEntry(workId);

        updateModifierAudit(
                creatorId,
                entry,
                new Date(),
                serviceContext
        );

        entry.setStatus(status);

        return updateWorkEntry(entry);

    }

    @Indexable(type = IndexableType.REINDEX)
    public WorkEntry updateProcessWorkEntry(long creatorId,
                                            long workId,
                                            long process,
                                              ServiceContext serviceContext) {

        WorkEntry entry = fetchWorkEntry(workId);

        updateModifierAudit(
                creatorId,
                entry,
                new Date(),
                serviceContext
        );

        entry.setProgress(process);

        return updateWorkEntry(entry);

    }



    private void setDataEntry(WorkEntry entry, WorkMapperModel model) {
        entry.setName(model.getName());
        entry.setStartDate(model.getStartDate());
        entry.setEndDate(model.getEndDate());
        entry.setDescription(model.getDescription());
        entry.setProgressType(model.getProgressType());
        entry.setIncompleteAmount(model.getIncompleteAmount());
        entry.setUnit(model.getUnit());
        entry.setParentId(model.getParentId());

        addMember(entry.getWorkId(), model);
    }

    private void addMember(long workId, WorkMapperModel model) {
        model.getManages()
                .forEach(manage -> workMemberEntryLocalService
                        .addWorkMemberEntry(
                                workId,
                                manage,
                                Type.MANAGE.getValue()));

        model.getHandles()
                .forEach(handle -> workMemberEntryLocalService
                        .addWorkMemberEntry(
                                workId,
                                handle,
                                Type.HANDLE.getValue()));

        model.getParticipates()
                .forEach(participate -> workMemberEntryLocalService
                        .addWorkMemberEntry(
                                workId,
                                participate,
                                Type.PARTICIPATE.getValue()));
    }

    public WorkEntry findByP_Name(long projectId,
                                  String name) {
        return workEntryPersistence.fetchByProjectAndName(
                projectId,
                name.trim().replaceAll("\\s+", StringPool.BLANK));
    }

    public List<WorkEntry> findByProjectId(long projectId) {
        return workEntryPersistence.findByProjectId(projectId);
    }

    public List<WorkEntry> findByPhaseId(long phaseId) {
        return workEntryPersistence.findByPhaseId(phaseId);
    }

    public WorkEntry findByPID_Name(long businessId,
                                    long parentId,
                                    String name) {
        return workEntryPersistence.fetchByParentIdAndName(
                businessId,
                parentId,
                name.trim().replaceAll("\\s+", StringPool.BLANK));
    }

    public List<WorkEntry> findByParentId(long businessId, long parentId) {
        return workEntryPersistence.findByParentId(businessId, parentId);
    }

    @Indexable(type = IndexableType.REINDEX)
    public WorkEntry updateProgress(long workId, long progress) {
        WorkEntry workEntry = fetchWorkEntry(workId);

        if (Validator.isNotNull(workEntry)) {
            workEntry.setProgress(progress);
        }

        return updateWorkEntry(workEntry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public WorkEntry reportProgressByAmount(long creatorId,
                                            long workId,
                                            double completeAmount,
                                            ServiceContext serviceContext) {
        WorkEntry workEntry = fetchWorkEntry(workId);

        updateModifierAudit(
                creatorId,
                workEntry,
                new Date(),
                serviceContext
        );

        if (Validator.isNotNull(workEntry)) {
            workEntry.setCompleteAmount(completeAmount);
            if (workEntry.getIncompleteAmount() != 0) {
                workEntry.setProgress((long) Math.ceil(completeAmount * 100 / workEntry.getIncompleteAmount()));
            }
        }

        return updateWorkEntry(workEntry);
    }

    private void createModifierAudit(long businessId,
                                     long creatorId,
                                     WorkEntry entry,
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
                                     WorkEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setModifiedId(serviceContext.getUserId());
        entry.setModifiedId(modifiedId);
    }


    @Reference
    private WorkMemberEntryLocalService workMemberEntryLocalService;
}