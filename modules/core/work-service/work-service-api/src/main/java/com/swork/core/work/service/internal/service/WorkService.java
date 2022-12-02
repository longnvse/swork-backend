package com.swork.core.work.service.internal.service;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface WorkService {
    void updateProgress(long workId);
}
