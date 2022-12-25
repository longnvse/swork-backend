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

package com.swork.common.file.model;

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
public class FileManagerEntrySoap implements Serializable {

	public static FileManagerEntrySoap toSoapModel(FileManagerEntry model) {
		FileManagerEntrySoap soapModel = new FileManagerEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBusinessId(model.getBusinessId());
		soapModel.setFileId(model.getFileId());
		soapModel.setFileType(model.getFileType());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileSize(model.getFileSize());
		soapModel.setMimeType(model.getMimeType());
		soapModel.setModuleId(model.getModuleId());
		soapModel.setAppId(model.getAppId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setPhaseId(model.getPhaseId());
		soapModel.setWorkId(model.getWorkId());

		return soapModel;
	}

	public static FileManagerEntrySoap[] toSoapModels(
		FileManagerEntry[] models) {

		FileManagerEntrySoap[] soapModels =
			new FileManagerEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FileManagerEntrySoap[][] toSoapModels(
		FileManagerEntry[][] models) {

		FileManagerEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new FileManagerEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new FileManagerEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FileManagerEntrySoap[] toSoapModels(
		List<FileManagerEntry> models) {

		List<FileManagerEntrySoap> soapModels =
			new ArrayList<FileManagerEntrySoap>(models.size());

		for (FileManagerEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FileManagerEntrySoap[soapModels.size()]);
	}

	public FileManagerEntrySoap() {
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

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFileType() {
		return _fileType;
	}

	public void setFileType(String fileType) {
		_fileType = fileType;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public Long getFileSize() {
		return _fileSize;
	}

	public void setFileSize(Long fileSize) {
		_fileSize = fileSize;
	}

	public String getMimeType() {
		return _mimeType;
	}

	public void setMimeType(String mimeType) {
		_mimeType = mimeType;
	}

	public String getModuleId() {
		return _moduleId;
	}

	public void setModuleId(String moduleId) {
		_moduleId = moduleId;
	}

	public String getAppId() {
		return _appId;
	}

	public void setAppId(String appId) {
		_appId = appId;
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

	public Long getWorkId() {
		return _workId;
	}

	public void setWorkId(Long workId) {
		_workId = workId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _businessId;
	private long _fileId;
	private String _fileType;
	private String _fileName;
	private Long _fileSize;
	private String _mimeType;
	private String _moduleId;
	private String _appId;
	private Long _projectId;
	private Long _phaseId;
	private Long _workId;

}