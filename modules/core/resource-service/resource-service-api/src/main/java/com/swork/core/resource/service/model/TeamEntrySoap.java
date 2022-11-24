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
public class TeamEntrySoap implements Serializable {

	public static TeamEntrySoap toSoapModel(TeamEntry model) {
		TeamEntrySoap soapModel = new TeamEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setTeamId(model.getTeamId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBusinessId(model.getBusinessId());
		soapModel.setModifiedId(model.getModifiedId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setPhaseId(model.getPhaseId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setTotalIncoming(model.getTotalIncoming());
		soapModel.setTotalSpending(model.getTotalSpending());

		return soapModel;
	}

	public static TeamEntrySoap[] toSoapModels(TeamEntry[] models) {
		TeamEntrySoap[] soapModels = new TeamEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TeamEntrySoap[][] toSoapModels(TeamEntry[][] models) {
		TeamEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TeamEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TeamEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TeamEntrySoap[] toSoapModels(List<TeamEntry> models) {
		List<TeamEntrySoap> soapModels = new ArrayList<TeamEntrySoap>(
			models.size());

		for (TeamEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TeamEntrySoap[soapModels.size()]);
	}

	public TeamEntrySoap() {
	}

	public long getPrimaryKey() {
		return _teamId;
	}

	public void setPrimaryKey(long pk) {
		setTeamId(pk);
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

	public long getTeamId() {
		return _teamId;
	}

	public void setTeamId(long teamId) {
		_teamId = teamId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Boolean getIsActive() {
		return _isActive;
	}

	public void setIsActive(Boolean isActive) {
		_isActive = isActive;
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

	public Long getTotalIncoming() {
		return _totalIncoming;
	}

	public void setTotalIncoming(Long totalIncoming) {
		_totalIncoming = totalIncoming;
	}

	public Long getTotalSpending() {
		return _totalSpending;
	}

	public void setTotalSpending(Long totalSpending) {
		_totalSpending = totalSpending;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _teamId;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _businessId;
	private long _modifiedId;
	private String _name;
	private String _description;
	private Boolean _isActive;
	private Long _phaseId;
	private Long _projectId;
	private Long _totalIncoming;
	private Long _totalSpending;

}