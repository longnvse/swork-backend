package com.swork.common.token.model;

public class UserTokenModel {
    private String username;
    private String fullName;
    private String email;
    private String role;
    private long accountId;
    private long businessId;
    private long[] departmentIds;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public long[] getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(long[] departmentIds) {
        this.departmentIds = departmentIds;
    }
}