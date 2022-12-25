package com.swork.core.project.service.mapper;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.swork.core.project.service.mapper.model.ChartMapperModel;
import com.swork.core.project.service.mapper.model.ChartObjMapperModel;
import org.osgi.service.component.annotations.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

@Component(immediate = true, service = DashboardMapper.class)
public class DashboardMapper {

    public List<ChartMapperModel> mapStatusTask(Map<String, Long> hashMap) {

        List<ChartMapperModel> list = new ArrayList<>();

        for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
            ChartMapperModel chartMapperModel = new ChartMapperModel();
            chartMapperModel.setObj(entry.getKey());
            chartMapperModel.setSum(entry.getValue());
            list.add(chartMapperModel);
        }

        return list;
    }

    public List<ChartMapperModel> mapTeam(Map<String, Double> hashMapThu,
                                          Map<String, Double> hashMapChi,
                                          Long budget) {

        List<ChartMapperModel> list = new ArrayList<>();

        hashMapThu.remove("0");
        hashMapChi.remove("0");

        for (Map.Entry<String, Double> entry : hashMapChi.entrySet()) {
            ChartMapperModel chartMapperModel = new ChartMapperModel();
            chartMapperModel.setObj(entry.getKey());

            double dChi = entry.getValue();
            List<ChartObjMapperModel> chartObjMapperModelList = new ArrayList<>();

            ChartObjMapperModel modelChi = new ChartObjMapperModel();
            modelChi.setNameString("Chi");
            if (budget == 0) {
                modelChi.setValueDouble(0);
            } else {
                modelChi.setValueDouble(dChi);
            }

            ChartObjMapperModel modelThu = new ChartObjMapperModel();
            modelThu.setNameString("Thu");
            modelThu.setValueDouble(0);
            if (hashMapThu.containsKey(entry.getKey())) {

                double dThu = hashMapThu.get(entry.getKey());
                if (budget > 0) {
                    modelThu.setValueDouble(dThu);
                }

                hashMapThu.remove(entry.getKey());

            }

            chartObjMapperModelList.add(modelChi);
            chartObjMapperModelList.add(modelThu);

            chartMapperModel.setChartMapperModels(chartObjMapperModelList.toArray(new ChartObjMapperModel[0]));
            list.add(chartMapperModel);
        }

        for (Map.Entry<String, Double> entry : hashMapThu.entrySet()) {

            ChartMapperModel chartMapperModel = new ChartMapperModel();
            chartMapperModel.setObj(entry.getKey());

            double dThu = entry.getValue();
            List<ChartObjMapperModel> chartObjMapperModelList = new ArrayList<>();

            ChartObjMapperModel modelThu = new ChartObjMapperModel();
            modelThu.setNameString("Thu");
            if (budget == 0) {
                modelThu.setValueDouble(0);
            } else {
                modelThu.setValueDouble(dThu);
            }

            ChartObjMapperModel modelChi = new ChartObjMapperModel();
            modelChi.setNameString("Chi");
            modelChi.setValueDouble(0);

            chartObjMapperModelList.add(modelChi);
            chartObjMapperModelList.add(modelThu);

            chartMapperModel.setChartMapperModels(chartObjMapperModelList.toArray(new ChartObjMapperModel[0]));
            list.add(chartMapperModel);
        }

        return list;
    }

    DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("yyyyMMdd");
    DateTimeFormatter formatterDayLocalDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ChartMapperModel mapChartMapperModelNew(SortedMap<String, Long> treeMap,
                                                   String unit) {

        ChartMapperModel model = new ChartMapperModel();

        List<ChartObjMapperModel> chartObjMapperModelList = new ArrayList<>();

        Long valueHistory = GetterUtil.DEFAULT_LONG;

        for (Map.Entry<String, Long> entry : treeMap.entrySet()) {

            ChartObjMapperModel chartObjMapperModel = new ChartObjMapperModel();
            chartObjMapperModel.setValue(entry.getValue() + valueHistory);
            chartObjMapperModel.setNameString(getNameString(entry.getKey(), unit));
            chartObjMapperModelList.add(chartObjMapperModel);

            valueHistory = chartObjMapperModel.getValue();
        }

        model.setChartMapperModels(chartObjMapperModelList
                .toArray(new ChartObjMapperModel[0]));

        model.setUnit(unit);

        return model;
    }

    private String getNameString(String date, String unit) {

        switch (unit) {
            case "day":
                LocalDate localDate = LocalDate.parse(date, formatterDay);
                return localDate.format(formatterDayLocalDate);
            case "week":
            case "precious":
            case "month":
                return date.substring(4) + "/" + date.substring(0, 4);
            case "year":
                return date;
            default:
                return StringPool.BLANK;
        }

    }

}
