package com.swork.core.phase.service.internal.impl;

import com.liferay.portal.kernel.util.Validator;
import com.swork.core.phase.service.internal.service.PhaseService;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.service.PhaseEntryLocalService;
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
        service = PhaseService.class
)
public class PhaseServiceImpl implements PhaseService {
    @Override
    public void updateProgress(long phaseId) {
        PhaseEntry phaseEntry = localService.fetchPhaseEntry(phaseId);

        if (Validator.isNull(phaseEntry)) {
            return;
        }

        ProjectEntry projectEntry = projectEntryLocalService.fetchProjectEntry(phaseEntry.getProjectId());

        if (Validator.isNull(projectEntry)) {
            return;
        }

        List<WorkEntry> workEntries = workEntryLocalService.findByPhaseId(phaseId);

        long progress = workEntryLocalService.calcProgress(workEntries, projectEntry.getProgressType());

        localService.updateProgress(phaseId, progress);

    }

    @Reference
    private ProjectEntryLocalService projectEntryLocalService;
    @Reference
    private WorkEntryLocalService workEntryLocalService;
    @Reference
    private PhaseEntryLocalService localService;
}
