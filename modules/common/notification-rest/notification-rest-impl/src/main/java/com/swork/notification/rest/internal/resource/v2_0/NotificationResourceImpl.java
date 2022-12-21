package com.swork.notification.rest.internal.resource.v2_0;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import com.swork.notification.rest.dto.v2_0.Notification;
import com.swork.notification.rest.internal.mapper.NotificationMapper;
import com.swork.notification.rest.internal.service.NotificationService;
import com.swork.notification.rest.resource.v2_0.NotificationResource;
import com.swork.notification.service.model.NotificationEntry;
import com.swork.notification.service.service.NotificationEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author longnv
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v2_0/notification.properties",
        scope = ServiceScope.PROTOTYPE, service = NotificationResource.class
)
public class NotificationResourceImpl extends BaseNotificationResourceImpl {

    @Override
    public Integer getCountNotification(String category,
                                        String status)
            throws Exception {

        return notificationService.countNotificationByStartAndType(
                getServiceContext().getCompanyId(),
                getUserToken().getAccountId(),
                getUserToken().getBusinessId(),
                category,
                status);
    }

    @Override
    public Page<Notification> getNotification(String category,
                                              String status,
                                              Pagination pagination)
            throws Exception {

        return notificationService.getNotification(
                pagination,
                getUserToken().getBusinessId(),
                getUserToken().getAccountId(),
                category,
                status,
                getServiceContext());
    }

    @Override
    public void approvalAllStatusByReceiver(Long receiverId,
                                            Notification notification)
            throws Exception {
    }

    @Override
    public Notification approvalStatus(Long id,
                                       Notification notification)
            throws Exception {


        return notificationMapper.mapNotificationFromEntry(
                notificationEntryLocalService.updateStatusNotification(
                        getUserToken().getAccountId(),
                        id,
                        notification.getStatus().getValue(),
                        getServiceContext()));
    }

    public ServiceContext getServiceContext() {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());

        return serviceContext;
    }

    private UserTokenModel getUserToken() {
        return tokenHelper.getUserToken(contextHttpServletRequest);
    }

    @Reference
    private CommonTokenHelper tokenHelper;

    @Reference
    private NotificationService notificationService;

    @Reference
    private NotificationEntryLocalService notificationEntryLocalService;

    @Reference
    private NotificationMapper notificationMapper;

}