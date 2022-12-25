package com.swork.core.project.service.internal.impl;

import com.liferay.portal.kernel.util.Validator;
import com.swork.core.project.service.internal.service.ProjectService;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.service.WorkEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.List;

@Component(
        scope = ServiceScope.PROTOTYPE,
        service = ProjectService.class
)
public class ProjectServiceImpl implements ProjectService {

    @Override
    public void updateProgress(long projectId) {
        ProjectEntry projectEntry = localService.fetchProjectEntry(projectId);

        if (Validator.isNull(projectEntry)) {
            return;
        }

        List<WorkEntry> workEntries = workEntryLocalService.findByProjectId(projectId,true);

        long progress = workEntryLocalService.calcProgress(workEntries, projectEntry.getProgressType());

        localService.updateProgress(projectId, progress);

    }

    @Reference
    private ProjectEntryLocalService localService;

    @Reference
    private WorkEntryLocalService workEntryLocalService;
}
