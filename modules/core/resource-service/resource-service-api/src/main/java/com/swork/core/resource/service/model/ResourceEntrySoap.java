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
public class ResourceEntrySoap implements Serializable {

	public static ResourceEntrySoap toSoapModel(ResourceEntry model) {
		ResourceEntrySoap soapModel = new ResourceEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setResourceId(model.getResourceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBusinessId(model.getBusinessId());
		soapModel.setModifiedId(model.getModifiedId());
		soapModel.setWorkId(model.getWorkId());
		soapModel.setPhaseId(model.getPhaseId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setResourceTypeId(model.getResourceTypeId());
		soapModel.setResourceTypeName(model.getResourceTypeName());
		soapModel.setTeamId(model.getTeamId());
		soapModel.setTeamName(model.getTeamName());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setUnit(model.getUnit());
		soapModel.setDateResource(model.getDateResource());
		soapModel.setTotalAmount(model.getTotalAmount());

		return soapModel;
	}

	public static ResourceEntrySoap[] toSoapModels(ResourceEntry[] models) {
		ResourceEntrySoap[] soapModels = new ResourceEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ResourceEntrySoap[][] toSoapModels(ResourceEntry[][] models) {
		ResourceEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ResourceEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ResourceEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ResourceEntrySoap[] toSoapModels(List<ResourceEntry> models) {
		List<ResourceEntrySoap> soapModels = new ArrayList<ResourceEntrySoap>(
			models.size());

		for (ResourceEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ResourceEntrySoap[soapModels.size()]);
	}

	public ResourceEntrySoap() {
	}

	public long getPrimaryKey() {
		return _resourceId;
	}

	public void setPrimaryKey(long pk) {
		setResourceId(pk);
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

	public long getResourceId() {
		return _resourceId;
	}

	public void setResourceId(long resourceId) {
		_resourceId = resourceId;
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

	public Long getWorkId() {
		return _workId;
	}

	public void setWorkId(Long workId) {
		_workId = workId;
	}

	public Long getPhaseId() {
		return _phaseId;
	}

	public void setPhaseId(Long phaseId) {
		_phaseId = phaseId;
	}

	public Long getProjectId() {
		return _projectId;
	}

	public void setProjectId(Long projectId) {
		_projectId = projectId;
	}

	public long getResourceTypeId() {
		return _resourceTypeId;
	}

	public void setResourceTypeId(long resourceTypeId) {
		_resourceTypeId = resourceTypeId;
	}

	public String getResourceTypeName() {
		return _resourceTypeName;
	}

	public void setResourceTypeName(String resourceTypeName) {
		_resourceTypeName = resourceTypeName;
	}

	public long getTeamId() {
		return _teamId;
	}

	public void setTeamId(long teamId) {
		_teamId = teamId;
	}

	public String getTeamName() {
		return _teamName;
	}

	public void setTeamName(String teamName) {
		_teamName = teamName;
	}

	public double getQuantity() {
		return _quantity;
	}

	public void setQuantity(double quantity) {
		_quantity = quantity;
	}

	public String getUnit() {
		return _unit;
	}

	public void setUnit(String unit) {
		_unit = unit;
	}

	public Date getDateResource() {
		return _dateResource;
	}

	public void setDateResource(Date dateResource) {
		_dateResource = dateResource;
	}

	public Long getTotalAmount() {
		return _totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		_totalAmount = totalAmount;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _resourceId;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _businessId;
	private long _modifiedId;
	private Long _workId;
	private Long _phaseId;
	private Long _projectId;
	private long _resourceTypeId;
	private String _resourceTypeName;
	private long _teamId;
	private String _teamName;
	private double _quantity;
	private String _unit;
	private Date _dateResource;
	private Long _totalAmount;

}