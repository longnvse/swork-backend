package com.swork.core.resource.service.mapper.model;

import com.liferay.portal.kernel.util.GetterUtil;

public class TeamMapperModel {
    String name;
    String description;
    Boolean isActive;
    Long phaseId;
    Long projectId;
    TeamMembersMapperModel admins;
    TeamMembersMapperModel members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim().replaceAll("\\s+", " ");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Long phaseId) {
        this.phaseId = GetterUtil.getLong(phaseId);
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = GetterUtil.getLong(projectId);
    }

    public TeamMembersMapperModel getMembers() {
        return members;
    }

    public void setMembers(TeamMembersMapperModel members) {
        this.members = members;
    }

    public TeamMembersMapperModel getAdmins() {
        return admins;
    }

    public void setAdmins(TeamMembersMapperModel admins) {
        this.admins = admins;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = GetterUtil.getBoolean(active);
    }

}
