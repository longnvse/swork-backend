package com.swork.core.project.rest.internal.service;


import com.swork.core.project.rest.dto.v1_0.Chart;
import com.swork.core.project.rest.internal.mapper.DashboardMapper;
import com.swork.core.project.service.retriever.DashboardRetriever;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component(immediate = true, service = DashboardService.class)
public class DashboardService {

    public List<Chart> getDashboardStatusTask(long businessId, long projectId) {

        return dashboardMapper.mapChartStatusTask(dashboardRetriever
                .getStatusTask(businessId, projectId));
    }

    public List<Chart> getDashboardTeamInout(long businessId, long projectId) {

        return dashboardMapper.mapChartTeam(
                dashboardRetriever.getTeamInOut(businessId, projectId));
    }

    public List<Chart> getDashboardBurnDown(long businessId, long projectId) {

        return dashboardMapper.mapChartBurnDown(
                dashboardRetriever.getBurnDownTask(businessId, projectId, null, false),
                dashboardRetriever.getBurnDownTask(businessId, projectId, "approved", true)
        );
    }

    public List<Chart> getDashboardResourceProject(long businessId,
                                                   Long projectId) {

        List<Chart> chartList = new ArrayList<>();

        Map<String, Double> hashMap = dashboardRetriever.getProjectResource(businessId, projectId);

        for (Map.Entry<String, Double> entry : hashMap.entrySet()) {
            Chart chart = new Chart();
            chart.setObj(entry.getKey());
            chart.setSumDouble(entry.getValue());
            chartList.add(chart);
        }

        return chartList;
    }

    @Reference
    private DashboardMapper dashboardMapper;

    @Reference
    private DashboardRetriever dashboardRetriever;
}
