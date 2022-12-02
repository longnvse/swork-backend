package com.swork.core.project.service.mapper.model;

import java.util.HashMap;

public class ChartMapperModel {

    private String obj;
    private ChartObjMapperModel[] chartMapperModels;

    private Long[] valueArray;
    private Double[] doubleArray;
    private Long sum;

    private HashMap<String , Long> hashMap;

    private ValueArrayStringMapperModel[] valueArrayStringMapperModels;

    private String unit ;

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public ChartObjMapperModel[] getChartMapperModels() {
        return chartMapperModels;
    }

    public void setChartMapperModels(ChartObjMapperModel[] chartMapperModels) {
        this.chartMapperModels = chartMapperModels;
    }

    public Long[] getValueArray() {
        return valueArray;
    }

    public void setValueArray(Long[] valueArray) {
        this.valueArray = valueArray;
    }

    public Double[] getDoubleArray() {
        return doubleArray;
    }

    public void setDoubleArray(Double[] doubleArray) {
        this.doubleArray = doubleArray;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public HashMap<String, Long> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, Long> hashMap) {
        this.hashMap = hashMap;
    }

    public ValueArrayStringMapperModel[] getValueArrayStringMapperModels() {
        return valueArrayStringMapperModels;
    }

    public void setValueArrayStringMapperModels(ValueArrayStringMapperModel[] valueArrayStringMapperModels) {
        this.valueArrayStringMapperModels = valueArrayStringMapperModels;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
