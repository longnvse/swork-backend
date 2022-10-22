package com.swork.checklist.service.mapper.model;

import java.util.Date;
import java.util.List;

public class ChecklistMapperModel {
    private String name;
    private Date startDate;
    private Date endDate;
    private Long taskId;
    private Boolean status;

    private Long[] handlers;

    public Long[] getHandlers() {
        return handlers;
    }

    public void setHandlers(Long[] handlers) {
        this.handlers = handlers;
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

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
