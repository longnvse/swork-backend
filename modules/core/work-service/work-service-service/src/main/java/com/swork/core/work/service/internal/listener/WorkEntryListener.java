package com.swork.core.work.service.internal.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.util.GetterUtil;
import com.swork.core.phase.service.internal.service.PhaseService;
import com.swork.core.project.service.internal.service.ProjectService;
import com.swork.core.work.service.internal.service.WorkService;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.service.WorkEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class WorkEntryListener extends BaseModelListener<WorkEntry> {
    @Override
    public void onAfterCreate(WorkEntry model) throws ModelListenerException {
        updateParentProgress(model);
    }

    @Override
    public void onAfterUpdate(WorkEntry originalModel, WorkEntry model) throws ModelListenerException {
        if (!originalModel.getProgressType().equals(model.getProgressType())) {
            if (model.getProgressType().equalsIgnoreCase("proportionDate")) {
                workService.updateProgress(model.getWorkId());
            } else if (model.getProgressType().equalsIgnoreCase("byAmount")) {
                long progress = (long) (model.getCompleteAmount() * 100 / model.getIncompleteAmount());
                localService.updateProgress(model.getWorkId(), progress);
            } else {
                localService.updateProgress(model.getWorkId(), GetterUtil.DEFAULT_LONG);
            }
        } else {
            updateParentProgress(model);
        }
    }

    @Override
    public void onAfterRemove(WorkEntry model) throws ModelListenerException {
        updateParentProgress(model);
    }

    private void updateParentProgress(WorkEntry workEntry) {
        long parentId = GetterUtil.getLong(workEntry.getParentId());

        if (parentId != 0) {
            workService.updateProgress(parentId);
            return;
        }

        //update progress phase, project here
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
    private WorkService workService;
    @Reference
    private ProjectService projectService;
    @Reference
    private PhaseService phaseService;
    @Reference
    private WorkEntryLocalService localService;
}
