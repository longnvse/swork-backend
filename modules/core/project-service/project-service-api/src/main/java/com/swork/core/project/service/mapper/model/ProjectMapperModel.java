package com.swork.core.project.service.mapper.model;

import java.util.Date;

public class ProjectMapperModel {
    private String externalReferenceCode;
    private String code;
    private String name;
    private Date startDate;
    private Date endDate;
    private Long budget;
    private String description;
    private String status;
    private Integer progress;
    private Date actualStartDate;
    private Date actualEndDate;
    private String progressType;
    private ProjectMembersMapperModel manages;
    private ProjectMembersMapperModel handles;
    private ProjectMembersMapperModel participates;

    public String getExternalReferenceCode() {
        return externalReferenceCode;
    }

    public void setExternalReferenceCode(String externalReferenceCode) {
        this.externalReferenceCode = externalReferenceCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }


    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public String getProgressType() {
        return progressType;
    }

    public void setProgressType(String progressType) {
        this.progressType = progressType;
    }

    public ProjectMembersMapperModel getManages() {
        return manages;
    }

    public void setManages(ProjectMembersMapperModel manages) {
        this.manages = manages;
    }

    public ProjectMembersMapperModel getHandles() {
        return handles;
    }

    public void setHandles(ProjectMembersMapperModel handles) {
        this.handles = handles;
    }

    public ProjectMembersMapperModel getParticipates() {
        return participates;
    }

    public void setParticipates(ProjectMembersMapperModel participates) {
        this.participates = participates;
    }
}
