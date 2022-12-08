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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.swork.core.project.service.constant.Type;
import com.swork.core.work.service.mapper.model.WorkMemberMapperModel;
import com.swork.core.work.service.model.WorkMemberEntry;
import com.swork.core.work.service.service.base.WorkMemberEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.core.work.service.model.WorkMemberEntry",
        service = AopService.class
)
public class WorkMemberEntryLocalServiceImpl
        extends WorkMemberEntryLocalServiceBaseImpl {

    @Indexable(type = IndexableType.REINDEX)
    public WorkMemberEntry addWorkMemberEntry(long workId,
                                              WorkMemberMapperModel model,
                                              String type) {
        WorkMemberEntry entry = createWorkMemberEntry(counterLocalService.increment(WorkMemberEntry.class.getName()));

        entry.setWorkId(workId);
        entry.setMemberId(model.getMemberId());
        entry.setMemberType(model.getMemberType());
        entry.setMemberReferenceCode(model.getMemberReferenceCode());
        entry.setType(type);

        return addWorkMemberEntry(entry);
    }


    public List<WorkMemberEntry> findByW_MT_T(long workId, String memberType, String type) {
        return workMemberEntryPersistence.findByW_MT_T(workId, memberType, type);
    }

    public List<WorkMemberEntry> findByW_T(long workId, String type) {
        return workMemberEntryPersistence.findByW_T_(workId, type);
    }

    public long countHandles(long workId) {
        return workMemberEntryPersistence.findByW_T_(workId, Type.HANDLE.getValue()).size();
    }

    public void deleteByWorkId(long workId) {
        workMemberEntryPersistence.removeByW_(workId);
    }

}