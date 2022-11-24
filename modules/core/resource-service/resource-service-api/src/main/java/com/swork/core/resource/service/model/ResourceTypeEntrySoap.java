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

package com.swork.core.resource.service.model;

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
public class ResourceTypeEntrySoap implements Serializable {

	public static ResourceTypeEntrySoap toSoapModel(ResourceTypeEntry model) {
		ResourceTypeEntrySoap soapModel = new ResourceTypeEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setResourceTypeId(model.getResourceTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBusinessId(model.getBusinessId());
		soapModel.setModifiedId(model.getModifiedId());
		soapModel.setName(model.getName());
		soapModel.setUnit(model.getUnit());
		soapModel.setParentId(model.getParentId());

		return soapModel;
	}

	public static ResourceTypeEntrySoap[] toSoapModels(
		ResourceTypeEntry[] models) {

		ResourceTypeEntrySoap[] soapModels =
			new ResourceTypeEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ResourceTypeEntrySoap[][] toSoapModels(
		ResourceTypeEntry[][] models) {

		ResourceTypeEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ResourceTypeEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ResourceTypeEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ResourceTypeEntrySoap[] toSoapModels(
		List<ResourceTypeEntry> models) {

		List<ResourceTypeEntrySoap> soapModels =
			new ArrayList<ResourceTypeEntrySoap>(models.size());

		for (ResourceTypeEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ResourceTypeEntrySoap[soapModels.size()]);
	}

	public ResourceTypeEntrySoap() {
	}

	public long getPrimaryKey() {
		return _resourceTypeId;
	}

	public void setPrimaryKey(long pk) {
		setResourceTypeId(pk);
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

	public long getResourceTypeId() {
		return _resourceTypeId;
	}

	public void setResourceTypeId(long resourceTypeId) {
		_resourceTypeId = resourceTypeId;
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

	public long getBusinessId() {
		return _businessId;
	}

	public void setBusinessId(long businessId) {
		_businessId = businessId;
	}

	public long getModifiedId() {
		return _modifiedId;
	}

	public void setModifiedId(long modifiedId) {
		_modifiedId = modifiedId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getUnit() {
		return _unit;
	}

	public void setUnit(String unit) {
		_unit = unit;
	}

	public Long getParentId() {
		return _parentId;
	}

	public void setParentId(Long parentId) {
		_parentId = parentId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _resourceTypeId;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _businessId;
	private long _modifiedId;
	private String _name;
	private String _unit;
	private Long _parentId;

}