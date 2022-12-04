package com.swork.core.work.service.mapper.model;

import com.liferay.petra.string.StringPool;

import java.util.Date;

public class WorkMapperModel {
    private String externalReferenceCode;
    private String name;
    private Date startDate;
    private Date endDate;
    private String description;
    private String progressType;
    private Double incompleteAmount;
    private String unit;
    private Long projectId;
    private Long phaseId;
    private Long parentId;
    private WorkMembersMapperModel manages;
    private WorkMembersMapperModel handles;
    private WorkMembersMapperModel participates;

    public String getExternalReferenceCode() {
        return externalReferenceCode;
    }

    public void setExternalReferenceCode(String externalReferenceCode) {
        this.externalReferenceCode = externalReferenceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim().replaceAll("\\s+", StringPool.SPACE);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManages(WorkMembersMapperModel manages) {
        this.manages = manages;
    }

    public void setHandles(WorkMembersMapperModel handles) {
        this.handles = handles;
    }

    public void setParticipates(WorkMembersMapperModel participates) {
        this.participates = participates;
    }

    public WorkMembersMapperModel getManages() {
        return manages;
    }

    public WorkMembersMapperModel getHandles() {
        return handles;
    }

    public WorkMembersMapperModel getParticipates() {
        return participates;
    }

    public String getProgressType() {
        return progressType;
    }

    public void setProgressType(String progressType) {
        this.progressType = progressType;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Long phaseId) {
        this.phaseId = phaseId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Double getIncompleteAmount() {
        return incompleteAmount;
    }

    public void setIncompleteAmount(Double incompleteAmount) {
        this.incompleteAmount = incompleteAmount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
