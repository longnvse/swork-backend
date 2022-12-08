package com.swork.core.project.service.internal.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.swork.core.phase.service.internal.service.PhaseService;
import com.swork.core.project.service.internal.service.ProjectService;
import com.swork.core.project.service.model.ProjectEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
    }

    @Reference
    private ProjectService service;
    @Reference
    private PhaseService phaseService;
}
