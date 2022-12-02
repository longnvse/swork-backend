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

package com.swork.core.work.service.model;

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
public class WorkEntrySoap implements Serializable {

	public static WorkEntrySoap toSoapModel(WorkEntry model) {
		WorkEntrySoap soapModel = new WorkEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setWorkId(model.getWorkId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedId(model.getModifiedId());
		soapModel.setBusinessId(model.getBusinessId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setPhaseId(model.getPhaseId());
		soapModel.setParentId(model.getParentId());
		soapModel.setParentReferenceCode(model.getParentReferenceCode());
		soapModel.setProgress(model.getProgress());
		soapModel.setName(model.getName());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setActualStartDate(model.getActualStartDate());
		soapModel.setActualEndDate(model.getActualEndDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setPercentage(model.getPercentage());
		soapModel.setProgressType(model.getProgressType());
		soapModel.setUnit(model.getUnit());
		soapModel.setIncompleteAmount(model.getIncompleteAmount());
		soapModel.setCompleteAmount(model.getCompleteAmount());
		soapModel.setProportion(model.getProportion());
		soapModel.setEqualProportions(model.getEqualProportions());

		return soapModel;
	}

	public static WorkEntrySoap[] toSoapModels(WorkEntry[] models) {
		WorkEntrySoap[] soapModels = new WorkEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkEntrySoap[][] toSoapModels(WorkEntry[][] models) {
		WorkEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkEntrySoap[] toSoapModels(List<WorkEntry> models) {
		List<WorkEntrySoap> soapModels = new ArrayList<WorkEntrySoap>(
			models.size());

		for (WorkEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkEntrySoap[soapModels.size()]);
	}

	public WorkEntrySoap() {
	}

	public long getPrimaryKey() {
		return _workId;
	}

	public void setPrimaryKey(long pk) {
		setWorkId(pk);
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

	public long getWorkId() {
		return _workId;
	}

	public void setWorkId(long workId) {
		_workId = workId;
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

	public long getModifiedId() {
		return _modifiedId;
	}

	public void setModifiedId(long modifiedId) {
		_modifiedId = modifiedId;
	}

	public long getBusinessId() {
		return _businessId;
	}

	public void setBusinessId(long businessId) {
		_businessId = businessId;
	}

	public Long getProjectId() {
		return _projectId;
	}

	public void setProjectId(Long projectId) {
		_projectId = projectId;
	}

	public Long getPhaseId() {
		return _phaseId;
	}

	public void setPhaseId(Long phaseId) {
		_phaseId = phaseId;
	}

	public Long getParentId() {
		return _parentId;
	}

	public void setParentId(Long parentId) {
		_parentId = parentId;
	}

	public String getParentReferenceCode() {
		return _parentReferenceCode;
	}

	public void setParentReferenceCode(String parentReferenceCode) {
		_parentReferenceCode = parentReferenceCode;
	}

	public long getProgress() {
		return _progress;
	}

	public void setProgress(long progress) {
		_progress = progress;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public Date getActualStartDate() {
		return _actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		_actualStartDate = actualStartDate;
	}

	public Date getActualEndDate() {
		return _actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		_actualEndDate = actualEndDate;
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

	public double getPercentage() {
		return _percentage;
	}

	public void setPercentage(double percentage) {
		_percentage = percentage;
	}

	public String getProgressType() {
		return _progressType;
	}

	public void setProgressType(String progressType) {
		_progressType = progressType;
	}

	public String getUnit() {
		return _unit;
	}

	public void setUnit(String unit) {
		_unit = unit;
	}

	public double getIncompleteAmount() {
		return _incompleteAmount;
	}

	public void setIncompleteAmount(double incompleteAmount) {
		_incompleteAmount = incompleteAmount;
	}

	public double getCompleteAmount() {
		return _completeAmount;
	}

	public void setCompleteAmount(double completeAmount) {
		_completeAmount = completeAmount;
	}

	public long getProportion() {
		return _proportion;
	}

	public void setProportion(long proportion) {
		_proportion = proportion;
	}

	public Boolean getEqualProportions() {
		return _equalProportions;
	}

	public void setEqualProportions(Boolean equalProportions) {
		_equalProportions = equalProportions;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _workId;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _modifiedId;
	private long _businessId;
	private Long _projectId;
	private Long _phaseId;
	private Long _parentId;
	private String _parentReferenceCode;
	private long _progress;
	private String _name;
	private Date _startDate;
	private Date _endDate;
	private Date _actualStartDate;
	private Date _actualEndDate;
	private String _description;
	private String _status;
	private double _percentage;
	private String _progressType;
	private String _unit;
	private double _incompleteAmount;
	private double _completeAmount;
	private long _proportion;
	private Boolean _equalProportions;

}