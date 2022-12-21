package com.swork.notification.rest.internal.mapper;

import com.liferay.account.model.AccountEntry;
import com.liferay.account.service.AccountEntryLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.notification.rest.dto.v2_0.Notification;
import com.swork.notification.service.model.NotificationEntry;
import com.swork.notification.service.service.NotificationEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component(immediate = true, service = NotificationMapper.class)
public class NotificationMapper {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    public Notification mapNotificationFromEntry(NotificationEntry entry) {
        Notification to = new Notification();

        to.setId(entry.getId());
        to.setExternalReferenceCode(entry.getExternalReferenceCode());

        to.setStatus(Notification.Status.create(entry.getStatus()));
        to.setCategory(entry.getCategory());
        to.setName(entry.getName());
        to.setDescription(entry.getDescription());
        to.setCreateDate(entry.getCreateDate());
        to.setReceiverId(entry.getReceiverId());
        to.setReceiverName(getReceiverName(entry.getReceiverId()));
        to.setSubjectId(entry.getSubjectId());
        to.setCreateDate(GetterUtil.getDate(entry.getCreateDate(),sdf));

        return to;
    }

    private Notification mapNotificationFromDocument(Document from) {

        Notification to = new Notification();

        long id = GetterUtil.getLong(from.get(Field.ENTRY_CLASS_PK));

        NotificationEntry entry = notificationEntryLocalService.fetchNotificationEntry(id);

        if (Validator.isNotNull(entry)) {
            to.setId(entry.getId());
            to.setName(entry.getName());
            to.setExternalReferenceCode(entry.getExternalReferenceCode());
            to.setStatus(Notification.Status.create(entry.getStatus()));
            to.setCategory(entry.getCategory());
            to.setDescription(entry.getDescription());
            to.setCreateDate(entry.getCreateDate());
            to.setReceiverId(entry.getReceiverId());
            to.setReceiverName(getReceiverName(entry.getReceiverId()));
            to.setSubjectId(entry.getSubjectId());
            to.setCreateDate(GetterUtil.getDate(entry.getCreateDate(),sdf));
        }

        return to;
    }

    public List<Notification> mapNotificationListFromNotificationDocuments(Document[] from) {
        return Arrays.stream(from)
                .map(this::mapNotificationFromDocument)
                .collect(Collectors
                        .toCollection(
                                ArrayList::new));
    }

    private String getReceiverName(long receiverId) {
        AccountEntry entry = accountEntryLocalService.fetchAccountEntry(receiverId);
        if (Validator.isNotNull(entry)) {
            return entry.getName();
        }
        return "";
    }

    @Reference
    private AccountEntryLocalService accountEntryLocalService;

    @Reference
    private NotificationEntryLocalService notificationEntryLocalService;


}
