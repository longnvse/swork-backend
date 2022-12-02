package com.swork.core.project.rest.internal.mapper;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.core.project.rest.dto.v1_0.Chart;
import com.swork.core.project.rest.dto.v1_0.ValueChart;
import com.swork.core.project.service.mapper.model.ChartMapperModel;
import com.swork.core.resource.service.model.TeamEntry;
import com.swork.core.resource.service.service.TeamEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component(immediate = true, service = DashboardMapper.class)
public class DashboardMapper {
    public List<Chart> mapChartStatusTask(List<ChartMapperModel> list) {

        List<Chart> chartList = new ArrayList<>();

        list.forEach(chartObjMapperModel -> {
            Chart chart = new Chart();
            chart.setObj(chartObjMapperModel.getObj());
            chart.setSum(chartObjMapperModel.getSum());

            chartList.add(chart);
        });


        return chartList;
    }

    public List<Chart> mapChartTeam(List<ChartMapperModel> list) {

        List<Chart> chartList = new ArrayList<>();

        list.forEach(chartMapperModel -> {
            Chart chart = new Chart();

            long teamId = GetterUtil.getLong(chartMapperModel.getObj());

            TeamEntry teamEntry = teamEntryLocalService.fetchTeamEntry(teamId);

            if (Validator.isNotNull(teamEntry)) {
                chart.setObj(teamEntry.getName());
            }

            List<ValueChart> valueChartList = new ArrayList<>();

            Arrays.stream(chartMapperModel.getChartMapperModels()).forEach(chartObjMapperModel -> {

                ValueChart valueChart = new ValueChart();
                valueChart.setNameString(chartObjMapperModel.getNameString());
                valueChart.setValueDouble(chartObjMapperModel.getValueDouble());

                valueChartList.add(valueChart);
            });

            chart.setValueCharts(valueChartList.toArray(new ValueChart[0]));

            chartList.add(chart);
        });


        return chartList;
    }

    public List<Chart> mapChartBurnDown(ChartMapperModel model,
                                        ChartMapperModel modelApproved) {

        List<Chart> chartList = new ArrayList<>();

        Chart chart = new Chart();
        chart.setObj("Total");
        chart.setUnit(model.getUnit());
        List<ValueChart> valueChartList = new ArrayList<>();

        if (Validator.isNotNull(model.getChartMapperModels())) {
            Arrays.stream(model.getChartMapperModels()).forEach(chartObjMapperModel -> {
                ValueChart valueChart = new ValueChart();
                valueChart.setNameString(chartObjMapperModel.getNameString());
                valueChart.setValue(chartObjMapperModel.getValue());

                valueChartList.add(valueChart);
            });
        }
        chart.setValueCharts(valueChartList.toArray(new ValueChart[0]));
        chartList.add(chart);

        Chart chartApproved = new Chart();
        chartApproved.setObj("Approved");
        chartApproved.setUnit(modelApproved.getUnit());
        List<ValueChart> valueChartList1 = new ArrayList<>();

        if (Validator.isNotNull(modelApproved.getChartMapperModels())) {
            Arrays.stream(modelApproved.getChartMapperModels()).forEach(chartObjMapperModel -> {
                ValueChart valueChart = new ValueChart();
                valueChart.setNameString(chartObjMapperModel.getNameString());
                valueChart.setValue(chartObjMapperModel.getValue());

                valueChartList1.add(valueChart);
            });
        }
        chartApproved.setValueCharts(valueChartList1.toArray(new ValueChart[0]));
        chartList.add(chartApproved);

        return chartList;
    }

    @Reference
    private TeamEntryLocalService teamEntryLocalService;

}
