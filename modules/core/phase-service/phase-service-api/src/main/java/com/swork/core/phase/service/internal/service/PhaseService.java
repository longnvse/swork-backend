package com.swork.core.phase.service.internal.service;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface PhaseService {
    void updateProgress(long phaseId);
}
