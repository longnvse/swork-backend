package com.swork.core.work.service.internal.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.util.GetterUtil;
import com.swork.core.work.service.internal.service.WorkService;
import com.swork.core.work.service.model.WorkEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = BaseModelListener.class
)
public class WorkEntryListener extends BaseModelListener<WorkEntry> {
    @Override
    public void onAfterUpdate(WorkEntry originalModel, WorkEntry model) throws ModelListenerException {
        if (originalModel.getProgress() != model.getProgress()) {
            long parentId = GetterUtil.getLong(model.getParentId());

            if (parentId != 0) {
                workService.updateProgress(parentId);
                return;
            }

            //update progress phase, project here
        }
    }

    @Reference
    private WorkService workService;
}
