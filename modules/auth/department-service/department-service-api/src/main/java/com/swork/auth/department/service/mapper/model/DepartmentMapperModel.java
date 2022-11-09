package com.swork.auth.department.service.mapper.model;

public class DepartmentMapperModel {
    private Long businessId;
    private String name;

    private Long[] accounts;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Long[] accounts) {
        this.accounts = accounts;
    }
}
