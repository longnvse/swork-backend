package com.swork.core.resource.service.mapper.model;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.GetterUtil;

public class ResourceTypeMapperModel {
    String name;
    String unit;

    Long parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = GetterUtil.getString(name).trim().replaceAll("\\s+", StringPool.SPACE);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = GetterUtil.getString(unit).trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
