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

package com.swork.notification.service.model;

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
public class NotificationEntrySoap implements Serializable {

	public static NotificationEntrySoap toSoapModel(NotificationEntry model) {
		NotificationEntrySoap soapModel = new NotificationEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEditorId(model.getEditorId());
		soapModel.setCategory(model.getCategory());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setReceiverId(model.getReceiverId());
		soapModel.setProjectId(model.getProjectId());

		return soapModel;
	}

	public static NotificationEntrySoap[] toSoapModels(
		NotificationEntry[] models) {

		NotificationEntrySoap[] soapModels =
			new NotificationEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NotificationEntrySoap[][] toSoapModels(
		NotificationEntry[][] models) {

		NotificationEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new NotificationEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new NotificationEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NotificationEntrySoap[] toSoapModels(
		List<NotificationEntry> models) {

		List<NotificationEntrySoap> soapModels =
			new ArrayList<NotificationEntrySoap>(models.size());

		for (NotificationEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NotificationEntrySoap[soapModels.size()]);
	}

	public NotificationEntrySoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	public long getEditorId() {
		return _editorId;
	}

	public void setEditorId(long editorId) {
		_editorId = editorId;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
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

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public long getReceiverId() {
		return _receiverId;
	}

	public void setReceiverId(long receiverId) {
		_receiverId = receiverId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _editorId;
	private String _category;
	private String _name;
	private String _description;
	private String _status;
	private long _receiverId;
	private long _projectId;

}