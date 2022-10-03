package com.swork.common.token.model;

public class AccountTokenModel {
    private long accountId;
    private String [] roles;
    public EmployeeTokenModel employee;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public EmployeeTokenModel getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeTokenModel employee) {
        this.employee = employee;
    }
}
