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

package com.swork.notification.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.notification.service.model.NotificationEntry;
import com.swork.notification.service.service.base.NotificationEntryLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.swork.notification.service.model.NotificationEntry",
        service = AopService.class
)
public class NotificationEntryLocalServiceImpl
        extends NotificationEntryLocalServiceBaseImpl {

    @Indexable(type = IndexableType.REINDEX)
    public NotificationEntry addNotification(long businessId,
                                             long creatorId,
                                             String category,
                                             String name,
                                             String description,
                                             String status,
                                             long receiverId,
                                             long subjectId,
                                             ServiceContext serviceContext) {
        NotificationEntry entry =
                createNotificationEntry(
                        counterLocalService
                                .increment(NotificationEntry.class.getName()));

        Date currentDate = new Date();

        createModifierAudit(
                businessId,
                creatorId,
                entry,
                currentDate,
                serviceContext);

        entry.setCategory(category);
        entry.setName(name);
        entry.setDescription(description);
        entry.setStatus(status);
        entry.setReceiverId(receiverId);
        entry.setSubjectId(subjectId);

        return addNotificationEntry(entry);
    }

    @Indexable(type = IndexableType.REINDEX)
    public NotificationEntry updateStatusNotification(long creatorId,
                                                      long notificationId,
                                                      String status,
                                                      ServiceContext serviceContext) {

        NotificationEntry entry = fetchNotificationEntry(notificationId);

        Date currentDate = new Date();

        updateModifierAudit(
                creatorId,
                entry,
                currentDate,
                serviceContext);

        entry.setStatus(status);

        return updateNotificationEntry(entry);

    }

    public List<NotificationEntry> findByReceiver(long receiverId) {
        return notificationEntryPersistence.findByR_V(receiverId);
    }

    public List<NotificationEntry> findByReceiverAndStatus(long receiverId, String status) {
        return notificationEntryPersistence.findByR_S(receiverId, status);
    }

    public List<NotificationEntry> findBySubjectId(long subjectId) {
        return notificationEntryPersistence.findByS_(subjectId);
    }

    private void createModifierAudit(long businessId,
                                     long creatorId,
                                     NotificationEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setGroupId(serviceContext.getScopeGroupId());
        entry.setCompanyId(serviceContext.getCompanyId());
        entry.setCreateDate(serviceContext.getCreateDate(current));
        entry.setAccountId(creatorId);
        entry.setBusinessId(businessId);
        entry.setExternalReferenceCode(UUID.randomUUID().toString());

        updateModifierAudit(creatorId, entry, current, serviceContext);
    }

    private void updateModifierAudit(long editorId,
                                     NotificationEntry entry,
                                     Date current,
                                     ServiceContext serviceContext) {

        entry.setModifiedDate(serviceContext.getModifiedDate(current));
        entry.setEditorId(editorId);
    }

}