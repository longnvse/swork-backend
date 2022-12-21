package com.swork.notification.rest.internal.resource.v2_0;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import com.swork.notification.rest.dto.v2_0.Notification;
import com.swork.notification.rest.internal.service.NotificationService;
import com.swork.notification.rest.resource.v2_0.NotificationResource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collections;

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

        return 0;
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

}