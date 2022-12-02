package com.swork.core.work.service.internal.impl;

import com.swork.core.work.service.internal.service.WorkService;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.service.WorkEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
        scope = ServiceScope.PROTOTYPE, service = WorkService.class
)
public class WorkServiceImpl implements WorkService {
    private static final String MANUAL = "manual";
    private static final String BY_AMOUNT = "byAmount";

    @Override
    public void updateProgress(long workId) {
        WorkEntry workEntry = localService.fetchWorkEntry(workId);

        switch (workEntry.getProgressType()) {
            case MANUAL:
                return;
            case BY_AMOUNT:

        }

    }

    @Reference
    private WorkEntryLocalService localService;
}
