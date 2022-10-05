package com.swork.common.token.model;

public class UserTokenModel {
    private String username;
    private String fullName;
    private String email;
    private long accountId;
    private AccountTokenModel account;

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

    public AccountTokenModel getAccount() {
        return account;
    }

    public void setAccount(AccountTokenModel account) {
        this.account = account;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}