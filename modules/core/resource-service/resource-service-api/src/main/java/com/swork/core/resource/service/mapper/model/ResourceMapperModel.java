package com.swork.core.resource.service.mapper.model;

import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Date;

public class ResourceMapperModel {
    double quantity;
    long resourceTypeId;
    String resourceTypeName;
    Long teamId;
    String teamName;
    String unit;

    Long creatorId;
    Long resourceId;
    Date dateResource;
    Long totalAmount;

    public ResourceMapperModel() {
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = GetterUtil.getLong(totalAmount);
    }

    public Date getDateResource() {
        return dateResource;
    }

    public void setDateResource(Date dateResource) {
        this.dateResource = dateResource;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public long getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
