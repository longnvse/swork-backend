package com.swork.core.project.service.internal.service;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface ProjectService {
    void updateProgress(long projectId);
}
