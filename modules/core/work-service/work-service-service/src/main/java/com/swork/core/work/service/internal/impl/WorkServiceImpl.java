package com.swork.core.work.service.internal.impl;

import com.swork.core.work.service.internal.service.WorkService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
        scope = ServiceScope.PROTOTYPE, service = WorkService.class
)
public class WorkServiceImpl implements WorkService {
    @Override
    public void updateProgress(long workId) {

    }
}
