/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.swork.account.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AccountEntrySoap implements Serializable {

	public static AccountEntrySoap toSoapModel(AccountEntry model) {
		AccountEntrySoap soapModel = new AccountEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setUsername(model.getUsername());
		soapModel.setPassword(model.getPassword());
		soapModel.setFullName(model.getFullName());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setEmail(model.getEmail());
		soapModel.setAddress(model.getAddress());
		soapModel.setDepartmentId(model.getDepartmentId());

		return soapModel;
	}

	public static AccountEntrySoap[] toSoapModels(AccountEntry[] models) {
		AccountEntrySoap[] soapModels = new AccountEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AccountEntrySoap[][] toSoapModels(AccountEntry[][] models) {
		AccountEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AccountEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AccountEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AccountEntrySoap[] toSoapModels(List<AccountEntry> models) {
		List<AccountEntrySoap> soapModels = new ArrayList<AccountEntrySoap>(
			models.size());

		for (AccountEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AccountEntrySoap[soapModels.size()]);
	}

	public AccountEntrySoap() {
	}

	public long getPrimaryKey() {
		return _accountId;
	}

	public void setPrimaryKey(long pk) {
		setAccountId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getExternalReferenceCode() {
		return _externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		_externalReferenceCode = externalReferenceCode;
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public Integer getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public Long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		_departmentId = departmentId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _accountId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creatorId;
	private String _username;
	private String _password;
	private String _fullName;
	private Integer _phoneNumber;
	private String _email;
	private String _address;
	private Long _departmentId;

}