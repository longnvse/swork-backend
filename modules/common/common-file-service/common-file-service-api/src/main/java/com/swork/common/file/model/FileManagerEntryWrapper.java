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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FileManagerEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileManagerEntry
 * @generated
 */
public class FileManagerEntryWrapper
	extends BaseModelWrapper<FileManagerEntry>
	implements FileManagerEntry, ModelWrapper<FileManagerEntry> {

	public FileManagerEntryWrapper(FileManagerEntry fileManagerEntry) {
		super(fileManagerEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("accountId", getAccountId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("businessId", getBusinessId());
		attributes.put("fileId", getFileId());
		attributes.put("fileType", getFileType());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("mimeType", getMimeType());
		attributes.put("moduleId", getModuleId());
		attributes.put("appId", getAppId());
		attributes.put("projectId", getProjectId());
		attributes.put("phaseId", getPhaseId());
		attributes.put("workId", getWorkId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String externalReferenceCode = (String)attributes.get(
			"externalReferenceCode");

		if (externalReferenceCode != null) {
			setExternalReferenceCode(externalReferenceCode);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String fileType = (String)attributes.get("fileType");

		if (fileType != null) {
			setFileType(fileType);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Long fileSize = (Long)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		String mimeType = (String)attributes.get("mimeType");

		if (mimeType != null) {
			setMimeType(mimeType);
		}

		String moduleId = (String)attributes.get("moduleId");

		if (moduleId != null) {
			setModuleId(moduleId);
		}

		String appId = (String)attributes.get("appId");

		if (appId != null) {
			setAppId(appId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long phaseId = (Long)attributes.get("phaseId");

		if (phaseId != null) {
			setPhaseId(phaseId);
		}

		Long workId = (Long)attributes.get("workId");

		if (workId != null) {
			setWorkId(workId);
		}
	}

	@Override
	public FileManagerEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account ID of this file manager entry.
	 *
	 * @return the account ID of this file manager entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the app ID of this file manager entry.
	 *
	 * @return the app ID of this file manager entry
	 */
	@Override
	public String getAppId() {
		return model.getAppId();
	}

	/**
	 * Returns the business ID of this file manager entry.
	 *
	 * @return the business ID of this file manager entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the company ID of this file manager entry.
	 *
	 * @return the company ID of this file manager entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this file manager entry.
	 *
	 * @return the create date of this file manager entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external reference code of this file manager entry.
	 *
	 * @return the external reference code of this file manager entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the file ID of this file manager entry.
	 *
	 * @return the file ID of this file manager entry
	 */
	@Override
	public long getFileId() {
		return model.getFileId();
	}

	/**
	 * Returns the file name of this file manager entry.
	 *
	 * @return the file name of this file manager entry
	 */
	@Override
	public String getFileName() {
		return model.getFileName();
	}

	/**
	 * Returns the file size of this file manager entry.
	 *
	 * @return the file size of this file manager entry
	 */
	@Override
	public Long getFileSize() {
		return model.getFileSize();
	}

	/**
	 * Returns the file type of this file manager entry.
	 *
	 * @return the file type of this file manager entry
	 */
	@Override
	public String getFileType() {
		return model.getFileType();
	}

	/**
	 * Returns the group ID of this file manager entry.
	 *
	 * @return the group ID of this file manager entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this file manager entry.
	 *
	 * @return the ID of this file manager entry
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the mime type of this file manager entry.
	 *
	 * @return the mime type of this file manager entry
	 */
	@Override
	public String getMimeType() {
		return model.getMimeType();
	}

	/**
	 * Returns the modified date of this file manager entry.
	 *
	 * @return the modified date of this file manager entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the module ID of this file manager entry.
	 *
	 * @return the module ID of this file manager entry
	 */
	@Override
	public String getModuleId() {
		return model.getModuleId();
	}

	/**
	 * Returns the phase ID of this file manager entry.
	 *
	 * @return the phase ID of this file manager entry
	 */
	@Override
	public Long getPhaseId() {
		return model.getPhaseId();
	}

	/**
	 * Returns the primary key of this file manager entry.
	 *
	 * @return the primary key of this file manager entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this file manager entry.
	 *
	 * @return the project ID of this file manager entry
	 */
	@Override
	public Long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the uuid of this file manager entry.
	 *
	 * @return the uuid of this file manager entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work ID of this file manager entry.
	 *
	 * @return the work ID of this file manager entry
	 */
	@Override
	public Long getWorkId() {
		return model.getWorkId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the account ID of this file manager entry.
	 *
	 * @param accountId the account ID of this file manager entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the app ID of this file manager entry.
	 *
	 * @param appId the app ID of this file manager entry
	 */
	@Override
	public void setAppId(String appId) {
		model.setAppId(appId);
	}

	/**
	 * Sets the business ID of this file manager entry.
	 *
	 * @param businessId the business ID of this file manager entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the company ID of this file manager entry.
	 *
	 * @param companyId the company ID of this file manager entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this file manager entry.
	 *
	 * @param createDate the create date of this file manager entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external reference code of this file manager entry.
	 *
	 * @param externalReferenceCode the external reference code of this file manager entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the file ID of this file manager entry.
	 *
	 * @param fileId the file ID of this file manager entry
	 */
	@Override
	public void setFileId(long fileId) {
		model.setFileId(fileId);
	}

	/**
	 * Sets the file name of this file manager entry.
	 *
	 * @param fileName the file name of this file manager entry
	 */
	@Override
	public void setFileName(String fileName) {
		model.setFileName(fileName);
	}

	/**
	 * Sets the file size of this file manager entry.
	 *
	 * @param fileSize the file size of this file manager entry
	 */
	@Override
	public void setFileSize(Long fileSize) {
		model.setFileSize(fileSize);
	}

	/**
	 * Sets the file type of this file manager entry.
	 *
	 * @param fileType the file type of this file manager entry
	 */
	@Override
	public void setFileType(String fileType) {
		model.setFileType(fileType);
	}

	/**
	 * Sets the group ID of this file manager entry.
	 *
	 * @param groupId the group ID of this file manager entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this file manager entry.
	 *
	 * @param id the ID of this file manager entry
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the mime type of this file manager entry.
	 *
	 * @param mimeType the mime type of this file manager entry
	 */
	@Override
	public void setMimeType(String mimeType) {
		model.setMimeType(mimeType);
	}

	/**
	 * Sets the modified date of this file manager entry.
	 *
	 * @param modifiedDate the modified date of this file manager entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the module ID of this file manager entry.
	 *
	 * @param moduleId the module ID of this file manager entry
	 */
	@Override
	public void setModuleId(String moduleId) {
		model.setModuleId(moduleId);
	}

	/**
	 * Sets the phase ID of this file manager entry.
	 *
	 * @param phaseId the phase ID of this file manager entry
	 */
	@Override
	public void setPhaseId(Long phaseId) {
		model.setPhaseId(phaseId);
	}

	/**
	 * Sets the primary key of this file manager entry.
	 *
	 * @param primaryKey the primary key of this file manager entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this file manager entry.
	 *
	 * @param projectId the project ID of this file manager entry
	 */
	@Override
	public void setProjectId(Long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the uuid of this file manager entry.
	 *
	 * @param uuid the uuid of this file manager entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work ID of this file manager entry.
	 *
	 * @param workId the work ID of this file manager entry
	 */
	@Override
	public void setWorkId(Long workId) {
		model.setWorkId(workId);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected FileManagerEntryWrapper wrap(FileManagerEntry fileManagerEntry) {
		return new FileManagerEntryWrapper(fileManagerEntry);
	}

}