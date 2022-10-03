package com.swork.common.token.model;

public class UserTokenModel {
  private long userId;
  private String screenName;
  private String fullName;
  private String email;
  private long customerId;
  private String customer;
  private long employeeId;
  private long accountId;
  private AccountTokenModel account;

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
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

  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }

  public AccountTokenModel getAccount() {
    return account;
  }

  public void setAccount(AccountTokenModel account) {
    this.account = account;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(long employeeId) {
    this.employeeId = employeeId;
  }

  public long getAccountId() {
    return accountId;
  }

  public void setAccountId(long accountId) {
    this.accountId = accountId;
  }
}