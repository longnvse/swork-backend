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

package com.swork.core.phase.service.model;

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
public class PhaseEntrySoap implements Serializable {

	public static PhaseEntrySoap toSoapModel(PhaseEntry model) {
		PhaseEntrySoap soapModel = new PhaseEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setPhaseId(model.getPhaseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBusinessId(model.getBusinessId());
		soapModel.setModifiedId(model.getModifiedId());
		soapModel.setPhaseName(model.getPhaseName());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setDescription(model.getDescription());
		soapModel.setProgress(model.getProgress());
		soapModel.setProjectId(model.getProjectId());

		return soapModel;
	}

	public static PhaseEntrySoap[] toSoapModels(PhaseEntry[] models) {
		PhaseEntrySoap[] soapModels = new PhaseEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhaseEntrySoap[][] toSoapModels(PhaseEntry[][] models) {
		PhaseEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhaseEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhaseEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhaseEntrySoap[] toSoapModels(List<PhaseEntry> models) {
		List<PhaseEntrySoap> soapModels = new ArrayList<PhaseEntrySoap>(
			models.size());

		for (PhaseEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhaseEntrySoap[soapModels.size()]);
	}

	public PhaseEntrySoap() {
	}

	public long getPrimaryKey() {
		return _phaseId;
	}

	public void setPrimaryKey(long pk) {
		setPhaseId(pk);
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

	public long getPhaseId() {
		return _phaseId;
	}

	public void setPhaseId(long phaseId) {
		_phaseId = phaseId;
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

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
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

	public String getPhaseName() {
		return _phaseName;
	}

	public void setPhaseName(String phaseName) {
		_phaseName = phaseName;
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

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getProgress() {
		return _progress;
	}

	public void setProgress(long progress) {
		_progress = progress;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _phaseId;
	private long _groupId;
	private long _companyId;
	private long _creatorId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _businessId;
	private long _modifiedId;
	private String _phaseName;
	private Date _startDate;
	private Date _endDate;
	private String _status;
	private String _description;
	private long _progress;
	private long _projectId;

}