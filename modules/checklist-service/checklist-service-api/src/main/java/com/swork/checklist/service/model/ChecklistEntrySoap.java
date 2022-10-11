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

package com.swork.checklist.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.swork.checklist.service.service.http.ChecklistEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ChecklistEntrySoap implements Serializable {

	public static ChecklistEntrySoap toSoapModel(ChecklistEntry model) {
		ChecklistEntrySoap soapModel = new ChecklistEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setChecklistId(model.getChecklistId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setTaskId(model.getTaskId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ChecklistEntrySoap[] toSoapModels(ChecklistEntry[] models) {
		ChecklistEntrySoap[] soapModels = new ChecklistEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChecklistEntrySoap[][] toSoapModels(
		ChecklistEntry[][] models) {

		ChecklistEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ChecklistEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChecklistEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChecklistEntrySoap[] toSoapModels(
		List<ChecklistEntry> models) {

		List<ChecklistEntrySoap> soapModels = new ArrayList<ChecklistEntrySoap>(
			models.size());

		for (ChecklistEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChecklistEntrySoap[soapModels.size()]);
	}

	public ChecklistEntrySoap() {
	}

	public long getPrimaryKey() {
		return _checklistId;
	}

	public void setPrimaryKey(long pk) {
		setChecklistId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getChecklistId() {
		return _checklistId;
	}

	public void setChecklistId(long checklistId) {
		_checklistId = checklistId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Long getTaskId() {
		return _taskId;
	}

	public void setTaskId(Long taskId) {
		_taskId = taskId;
	}

	public Boolean getStatus() {
		return _status;
	}

	public void setStatus(Boolean status) {
		_status = status;
	}

	private String _uuid;
	private long _checklistId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private Long _taskId;
	private Boolean _status;

}