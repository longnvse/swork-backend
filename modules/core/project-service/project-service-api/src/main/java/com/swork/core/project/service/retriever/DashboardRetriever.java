package com.swork.core.project.service.retriever;

import com.swork.core.project.service.mapper.model.ChartMapperModel;
import org.osgi.annotation.versioning.ProviderType;

import java.util.List;
import java.util.Map;

@ProviderType
public interface DashboardRetriever {
    List<ChartMapperModel> getStatusTask(long businessId, long projectId);

    List<ChartMapperModel> getTeamInOut(long businessId, long projectId);

    Map<String, Double> getProjectResource(long businessId, long projectId);

    ChartMapperModel getBurnDownTask(long businessId,
                                     long projectId,
                                     String status,
                                     Boolean checkStatus);
}
