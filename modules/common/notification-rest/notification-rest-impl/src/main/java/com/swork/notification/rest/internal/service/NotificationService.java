package com.swork.notification.rest.internal.service;

import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.notification.rest.dto.v2_0.Notification;
import com.swork.notification.rest.internal.mapper.NotificationMapper;
import com.swork.notification.service.model.NotificationEntry;
import com.swork.notification.service.service.NotificationEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = NotificationService.class)

public class NotificationService {
    private static final String NoRead = "noRead";

    public Page<Notification> getNotification(Pagination pagination,
                                              long businessId,
                                              long employeeId,
                                              String category,
                                              String status,
                                              ServiceContext serviceContext) throws SearchException {
        List<Notification> list = new ArrayList<>();

        List<NotificationEntry> entryList = notificationEntryLocalService.findByReceiver(employeeId);

        entryList.forEach(entry -> {
            list.add(notificationMapper.mapNotificationFromEntry(entry));

        });

        int total =
                countNotificationByStartAndType(
                        serviceContext.getCompanyId(),
                        employeeId,
                        businessId,
                        category,
                        status);

        return Page.of(list, pagination, list.size());
    }

    public int countNotificationByStartAndType(long companyId,
                                               long receiverId,
                                               long businessId,
                                               String category,
                                               String status) throws SearchException {

        int count = notificationEntryLocalService.countByReceiverAndStatus(receiverId, "noRead");

        return count;
    }

    @Reference
    private NotificationMapper notificationMapper;

    @Reference
    private NotificationEntryLocalService notificationEntryLocalService;

}
