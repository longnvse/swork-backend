package com.swork.core.work.service.internal.impl;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.core.phase.service.internal.service.PhaseService;
import com.swork.core.project.service.internal.service.ProjectService;
import com.swork.core.work.service.internal.service.WorkService;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.service.WorkEntryLocalService;
import com.swork.core.work.service.service.WorkMemberEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.List;

@Component(
        scope = ServiceScope.PROTOTYPE, service = WorkService.class
)
public class WorkServiceImpl implements WorkService {
    private static final String BY_PROPORTION = "byProportion";

    @Override
    public void updateProgress(long workId) {
        WorkEntry workEntry = localService.fetchWorkEntry(workId);

        if (Validator.isNull(workEntry)) {
            return;
        }

        if (workEntry.getProgressType().equalsIgnoreCase(BY_PROPORTION)) {
            List<WorkEntry> workEntries = localService.findByParentId(workEntry.getBusinessId(), workId);

            long progress = workEntries
                    .stream()
                    .reduce(
                            GetterUtil.DEFAULT_LONG,
                            (prevProgress, workChildren) -> prevProgress + workChildren.getProgress() * workChildren.getProportion(),
                            Long::sum);

            localService.updateProgress(workId, progress);
            return;
        }

        long projectId = GetterUtil.getLong(workEntry.getProjectId());

        if (projectId != 0) {
            projectService.updateProgress(projectId);
        }

        long phaseId = GetterUtil.getLong(workEntry.getPhaseId());

        if (phaseId != 0) {
            phaseService.updateProgress(phaseId);
        }
    }
    @Reference
    private WorkEntryLocalService localService;
    @Reference
    private ProjectService projectService;
    @Reference
    private PhaseService phaseService;
}
