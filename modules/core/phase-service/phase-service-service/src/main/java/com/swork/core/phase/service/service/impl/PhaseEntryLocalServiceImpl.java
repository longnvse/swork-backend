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

package com.swork.core.phase.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.Validator;
import com.swork.common.util.api.CommonUtil;
import com.swork.core.phase.service.mapper.model.PhaseMapperModel;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.service.PhaseManageEntryLocalService;
import com.swork.core.phase.service.service.base.PhaseEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.core.phase.service.model.PhaseEntry",
        service = AopService.class
)
public class PhaseEntryLocalServiceImpl extends PhaseEntryLocalServiceBaseImpl {

    private static final String ACTIVE = "active";
    private static final String PENDING = "pending";
    private static final String CLOSED = "closed";

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public PhaseEntry addPhase(long businessId,
                               long creatorId,
                               PhaseMapperModel model,
                               ServiceContext serviceContext) {

        PhaseEntry entry =
                createPhaseEntry(
                        counterLocalService
                                .increment(PhaseEntry.class.getName()));

        Date currentDate = new Date();

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                currentDate,
                serviceContext);

        updatePhaseData(entry, model);
        entry.setProjectId(model.getProjectId());

        Arrays.stream(model.getManages())
                .forEach(accountId -> phaseManageEntryLocalService.addPhaseManage(entry.getPhaseId(), accountId));

        return addPhaseEntry(entry);
    }

    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public PhaseEntry updatePhase(long creatorId,
                                  long phaseId,
                                  PhaseMapperModel model,
                                  ServiceContext serviceContext) throws PortalException {

        PhaseEntry entry = getPhaseEntry(phaseId);

        Date currentDate = new Date();

        updateModifierAudit(
                creatorId,
                entry,
                currentDate,
                serviceContext);

        updatePhaseData(entry, model);

        phaseManageEntryLocalService.deleteByPhaseId(phaseId);

        Arrays.stream(model.getManages())
                .forEach(accountId -> phaseManageEntryLocalService.addPhaseManage(entry.getPhaseId(), accountId));

        return updatePhaseEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public PhaseEntry updateProgress(long phaseId, long progress) {
        PhaseEntry entry = fetchPhaseEntry(phaseId);

        if (Validator.isNotNull(entry)) {
            entry.setProgress(progress);

            if (!entry.getStatus().equals(ACTIVE)) {
                entry.setStatus(ACTIVE);
            }

            if (progress >= 100) {
                entry.setStatus(CLOSED);
            }
        }

        return updatePhaseEntry(entry);
    }

    public List<PhaseEntry> findByProjectId(long projectId) {
        return phaseEntryPersistence.findByP_(projectId);
    }

    public PhaseEntry getByPhaseName(long businessId, long projectId, String phaseName) {
        return phaseEntryPersistence.fetchByB_P_N(businessId, projectId, phaseName);
    }

    private void updatePhaseData(PhaseEntry entry,
                                 PhaseMapperModel model) {

        entry.setPhaseName(model.getName());
        entry.setStartDate(commonUtil.getStartOfDate(model.getStartDate()));
        entry.setEndDate(commonUtil.getEndOfDate(model.getEndDate()));
        entry.setStatus(model.getStatus());
        entry.setDescription(model.getDescription());
        entry.setProgress(model.getProgress());
    }

    @Indexable(type = IndexableType.REINDEX)
    public PhaseEntry updateDate(long creatorId,
                                 long phaseId,
                                 Date startDate,
                                 Date endDate,
                                 ServiceContext serviceContext) {
        PhaseEntry phaseEntry = fetchPhaseEntry(phaseId);

        updateModifierAudit(
                creatorId,
                phaseEntry,
                new Date(),
                serviceContext
        );

        phaseEntry.setStartDate(commonUtil.getStartOfDate(startDate));
        phaseEntry.setEndDate(commonUtil.getEndOfDate(endDate));

        return updatePhaseEntry(phaseEntry);
    }

    private void createModifierAudit(long businessId,
                                     long creatorId,
                                     PhaseEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setBusinessId(businessId);
        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setCreatorId(creatorId);

        updateModifierAudit(creatorId, entry, current, serviceContext);
    }

    private void updateModifierAudit(long modifiedId,
                                     PhaseEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setModifiedId(serviceContext.getUserId());
        entry.setModifiedId(modifiedId);
    }

    @Reference
    private PhaseManageEntryLocalService phaseManageEntryLocalService;
    @Reference
    private CommonUtil commonUtil;
}