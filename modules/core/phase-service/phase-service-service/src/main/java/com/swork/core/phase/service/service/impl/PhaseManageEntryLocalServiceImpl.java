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
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.swork.core.phase.service.model.PhaseManageEntry;
import com.swork.core.phase.service.service.base.PhaseManageEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.core.phase.service.model.PhaseManageEntry",
        service = AopService.class
)
public class PhaseManageEntryLocalServiceImpl
        extends PhaseManageEntryLocalServiceBaseImpl {
    @Transactional(
            isolation = Isolation.PORTAL,
            rollbackFor = {PortalException.class, SystemException.class})
    @Indexable(type = IndexableType.REINDEX)
    public PhaseManageEntry addPhaseManage(long phaseId,
                                           long accountId) {

        PhaseManageEntry entry =
                createPhaseManageEntry(
                        counterLocalService
                                .increment(PhaseManageEntry.class.getName()));

        entry.setPhaseId(phaseId);
        entry.setAccountId(accountId);

        return addPhaseManageEntry(entry);
    }

    public List<PhaseManageEntry> findByPhaseId(long phaseId) {
        return phaseManageEntryPersistence.findByP_(phaseId);
    }

    public void deleteByPhaseId(long phaseId) {
        phaseManageEntryPersistence.removeByP_(phaseId);
    }
}