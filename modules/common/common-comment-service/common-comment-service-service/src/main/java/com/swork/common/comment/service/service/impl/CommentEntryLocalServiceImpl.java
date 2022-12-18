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

package com.swork.common.comment.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.swork.common.comment.service.model.CommentEntry;
import com.swork.common.comment.service.service.base.CommentEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.common.comment.service.model.CommentEntry",
        service = AopService.class
)
public class CommentEntryLocalServiceImpl
        extends CommentEntryLocalServiceBaseImpl {
    @Indexable(type = IndexableType.REINDEX)
    public CommentEntry addCommentEntry(long businessId,
                                        long creatorId,
                                        String content,
                                        Long parentId,
                                        long classPkId,
                                        String classPkName,
                                        ServiceContext serviceContext) {
        CommentEntry entry = createCommentEntry(counterLocalService.increment(CommentEntry.class.getName()));

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                new Date(),
                serviceContext
        );

        entry.setContent(content);
        entry.setParentId(GetterUtil.getLong(parentId));
        entry.setClassPkId(classPkId);
        entry.setClassPKName(classPkName);

        return addCommentEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public CommentEntry updateCommentEntry(long commentId,
                                           String content,
                                           ServiceContext serviceContext) {
        CommentEntry entry = fetchCommentEntry(commentId);

        updateModifierAudit(
                entry,
                new Date(),
                serviceContext
        );

        entry.setContent(content);

        return updateCommentEntry(entry);
    }

    public List<CommentEntry> getByParentId(long parentId) {
        return commentEntryPersistence.findByPID(parentId);
    }

    private void createModifierAudit(long businessId,
                                     long creatorId,
                                     CommentEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setBusinessId(businessId);
        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setAccountId(creatorId);

        updateModifierAudit(entry, current, serviceContext);
    }

    private void updateModifierAudit(CommentEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {
        entry.setModifiedDate(serviceContext.getModifiedDate(current));
    }

}