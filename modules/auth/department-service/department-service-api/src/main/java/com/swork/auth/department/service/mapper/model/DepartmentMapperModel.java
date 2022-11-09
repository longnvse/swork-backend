package com.swork.auth.department.service.mapper.model;

import com.liferay.portal.kernel.util.Validator;

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
        if (Validator.isNull(accounts)) {
            this.accounts = new Long[]{};
            return;
        }

        this.accounts = accounts;

    }
}
