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

package com.swork.business.service.model;

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
public class BusinessEntrySoap implements Serializable {

	public static BusinessEntrySoap toSoapModel(BusinessEntry model) {
		BusinessEntrySoap soapModel = new BusinessEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setBusinessId(model.getBusinessId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCustomerName(model.getCustomerName());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setEmail(model.getEmail());
		soapModel.setBusinessAddress(model.getBusinessAddress());
		soapModel.setName(model.getName());
		soapModel.setFieldOperations(model.getFieldOperations());
		soapModel.setLogoId(model.getLogoId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static BusinessEntrySoap[] toSoapModels(BusinessEntry[] models) {
		BusinessEntrySoap[] soapModels = new BusinessEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BusinessEntrySoap[][] toSoapModels(BusinessEntry[][] models) {
		BusinessEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BusinessEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new BusinessEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BusinessEntrySoap[] toSoapModels(List<BusinessEntry> models) {
		List<BusinessEntrySoap> soapModels = new ArrayList<BusinessEntrySoap>(
			models.size());

		for (BusinessEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BusinessEntrySoap[soapModels.size()]);
	}

	public BusinessEntrySoap() {
	}

	public long getPrimaryKey() {
		return _businessId;
	}

	public void setPrimaryKey(long pk) {
		setBusinessId(pk);
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

	public long getBusinessId() {
		return _businessId;
	}

	public void setBusinessId(long businessId) {
		_businessId = businessId;
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

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getCustomerName() {
		return _customerName;
	}

	public void setCustomerName(String customerName) {
		_customerName = customerName;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getBusinessAddress() {
		return _businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		_businessAddress = businessAddress;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getFieldOperations() {
		return _fieldOperations;
	}

	public void setFieldOperations(String fieldOperations) {
		_fieldOperations = fieldOperations;
	}

	public Long getLogoId() {
		return _logoId;
	}

	public void setLogoId(Long logoId) {
		_logoId = logoId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _businessId;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creatorId;
	private String _customerName;
	private String _phoneNumber;
	private String _email;
	private String _businessAddress;
	private String _name;
	private String _fieldOperations;
	private Long _logoId;
	private String _status;

}