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

package com.swork.core.project.service.model;

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
public class ProjectEntrySoap implements Serializable {

	public static ProjectEntrySoap toSoapModel(ProjectEntry model) {
		ProjectEntrySoap soapModel = new ProjectEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedId(model.getModifiedId());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setBudget(model.getBudget());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setProgress(model.getProgress());
		soapModel.setActualTime(model.getActualTime());
		soapModel.setActualStart(model.getActualStart());
		soapModel.setProgressType(model.getProgressType());
		soapModel.setBusinessId(model.getBusinessId());

		return soapModel;
	}

	public static ProjectEntrySoap[] toSoapModels(ProjectEntry[] models) {
		ProjectEntrySoap[] soapModels = new ProjectEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectEntrySoap[][] toSoapModels(ProjectEntry[][] models) {
		ProjectEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectEntrySoap[] toSoapModels(List<ProjectEntry> models) {
		List<ProjectEntrySoap> soapModels = new ArrayList<ProjectEntrySoap>(
			models.size());

		for (ProjectEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectEntrySoap[soapModels.size()]);
	}

	public ProjectEntrySoap() {
	}

	public long getPrimaryKey() {
		return _projectId;
	}

	public void setPrimaryKey(long pk) {
		setProjectId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getBudget() {
		return _budget;
	}

	public void setBudget(long budget) {
		_budget = budget;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Integer getProgress() {
		return _progress;
	}

	public void setProgress(Integer progress) {
		_progress = progress;
	}

	public Date getActualTime() {
		return _actualTime;
	}

	public void setActualTime(Date actualTime) {
		_actualTime = actualTime;
	}

	public Date getActualStart() {
		return _actualStart;
	}

	public void setActualStart(Date actualStart) {
		_actualStart = actualStart;
	}

	public String getProgressType() {
		return _progressType;
	}

	public void setProgressType(String progressType) {
		_progressType = progressType;
	}

	public long getBusinessId() {
		return _businessId;
	}

	public void setBusinessId(long businessId) {
		_businessId = businessId;
	}

	private String _uuid;
	private long _projectId;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _modifiedId;
	private String _name;
	private String _code;
	private Date _startDate;
	private Date _endDate;
	private long _budget;
	private String _description;
	private String _status;
	private Integer _progress;
	private Date _actualTime;
	private Date _actualStart;
	private String _progressType;
	private long _businessId;

}