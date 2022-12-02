package com.swork.core.project.rest.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import com.swork.core.project.rest.dto.v1_0.Chart;
import com.swork.core.project.rest.internal.service.DashboardService;
import com.swork.core.project.rest.resource.v1_0.ChartResource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Long Hip
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/chart.properties",
        scope = ServiceScope.PROTOTYPE, service = ChartResource.class
)
public class ChartResourceImpl extends BaseChartResourceImpl {

    @Override
    public Page<Chart> getDashboardStatusWork(Long projectId) {
        return Page.of(dashboardService.getDashboardStatusTask(getUserToken().getBusinessId(), projectId));

    }

    @Override
    public Page<Chart> getDashboardTeamInout(Long projectId) {
        return Page.of(dashboardService.getDashboardTeamInout(getUserToken().getBusinessId(), projectId));

    }

    @Override
    public Page<Chart> getDashboardBurnDownWork(Long projectId) {
        return Page.of(dashboardService.getDashboardBurnDown(getUserToken().getBusinessId(), projectId));

    }

    @Override
    public Page<Chart> getDashboardResourceProject(Long projectId) {
        return Page.of(dashboardService.getDashboardResourceProject(getUserToken().getBusinessId(), projectId));

    }

    private UserTokenModel getUserToken() {
        return tokenHelper.getUserToken(contextHttpServletRequest);
    }

    @Reference
    private CommonTokenHelper tokenHelper;

    @Reference
    private DashboardService dashboardService;
}