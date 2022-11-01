package com.swork.account.service.mapper.model;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

@Component(
        immediate = true,
        service = AccountMapperModel.class
)
public class AccountMapperModel {
    private long id;
    private Date createDate;
    private String username;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String[] actionCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getActionCode() {
        return actionCode;
    }

    public void setActionCode(String[] actionCode) {
        this.actionCode = actionCode;
    }
}
