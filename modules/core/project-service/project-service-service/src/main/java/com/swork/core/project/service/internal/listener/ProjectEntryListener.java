package com.swork.core.project.service.internal.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.core.phase.service.internal.service.PhaseService;
import com.swork.core.project.service.internal.service.ProjectService;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import com.swork.notification.service.service.NotificationEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class ProjectEntryListener extends BaseModelListener<ProjectEntry> {
    @Override
    public void onAfterUpdate(ProjectEntry originalModel, ProjectEntry model) throws ModelListenerException {
        if (!originalModel.getProgressType().equals(model.getProgressType())) {
            service.updateProgress(model.getProjectId());

            phaseService.updateProgressByProjectId(model.getProjectId());
        }
        notificationEntryLocalService.addNotification(
                model.getBusinessId(),
                model.getAccountId(),
                "PROJECT",
                "Sửa dự án",
                model.getName() + " đơợc cập nhập vào lúc " + new Date(),
                "noRed",
                model.getAccountId(),
                model.getProjectId(),getServiceContext(model));
    }

    @Override
    public void onAfterCreate(ProjectEntry model) throws ModelListenerException {
        notificationEntryLocalService.addNotification(
                model.getBusinessId(),
                model.getAccountId(),
                "PROJECT",
                "Thêm mới dự án",
                model.getName() + " đơợc tạo mới vào lúc " + new Date(),
                "noRed",
                model.getAccountId(),
                model.getProjectId(),getServiceContext(model));
    }

    private ServiceContext getServiceContext(ProjectEntry model) {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(model.getCompanyId());
        serviceContext.setScopeGroupId(model.getGroupId());

        return serviceContext;
    }

    @Reference
    private ProjectService service;
    @Reference
    private PhaseService phaseService;

    @Reference
    private NotificationEntryLocalService notificationEntryLocalService ;
}
