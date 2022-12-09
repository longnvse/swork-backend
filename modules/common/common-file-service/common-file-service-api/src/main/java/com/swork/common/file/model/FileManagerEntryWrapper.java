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
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customerId", getCustomerId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("fileId", getFileId());
		attributes.put("parentCode", getParentCode());
		attributes.put("fileType", getFileType());
		attributes.put("type", getType());
		attributes.put("pkType", getPkType());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("moduleId", getModuleId());
		attributes.put("appId", getAppId());

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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String parentCode = (String)attributes.get("parentCode");

		if (parentCode != null) {
			setParentCode(parentCode);
		}

		String fileType = (String)attributes.get("fileType");

		if (fileType != null) {
			setFileType(fileType);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String pkType = (String)attributes.get("pkType");

		if (pkType != null) {
			setPkType(pkType);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String fileSize = (String)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		String moduleId = (String)attributes.get("moduleId");

		if (moduleId != null) {
			setModuleId(moduleId);
		}

		String appId = (String)attributes.get("appId");

		if (appId != null) {
			setAppId(appId);
		}
	}

	@Override
	public FileManagerEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
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
	 * Returns the creator ID of this file manager entry.
	 *
	 * @return the creator ID of this file manager entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the customer ID of this file manager entry.
	 *
	 * @return the customer ID of this file manager entry
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
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
	public String getFileSize() {
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
	 * Returns the parent code of this file manager entry.
	 *
	 * @return the parent code of this file manager entry
	 */
	@Override
	public String getParentCode() {
		return model.getParentCode();
	}

	/**
	 * Returns the pk type of this file manager entry.
	 *
	 * @return the pk type of this file manager entry
	 */
	@Override
	public String getPkType() {
		return model.getPkType();
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
	 * Returns the type of this file manager entry.
	 *
	 * @return the type of this file manager entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this file manager entry.
	 *
	 * @return the user ID of this file manager entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this file manager entry.
	 *
	 * @return the user name of this file manager entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this file manager entry.
	 *
	 * @return the user uuid of this file manager entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
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

	@Override
	public void persist() {
		model.persist();
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
	 * Sets the creator ID of this file manager entry.
	 *
	 * @param creatorId the creator ID of this file manager entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the customer ID of this file manager entry.
	 *
	 * @param customerId the customer ID of this file manager entry
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
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
	public void setFileSize(String fileSize) {
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
	 * Sets the parent code of this file manager entry.
	 *
	 * @param parentCode the parent code of this file manager entry
	 */
	@Override
	public void setParentCode(String parentCode) {
		model.setParentCode(parentCode);
	}

	/**
	 * Sets the pk type of this file manager entry.
	 *
	 * @param pkType the pk type of this file manager entry
	 */
	@Override
	public void setPkType(String pkType) {
		model.setPkType(pkType);
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
	 * Sets the type of this file manager entry.
	 *
	 * @param type the type of this file manager entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this file manager entry.
	 *
	 * @param userId the user ID of this file manager entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this file manager entry.
	 *
	 * @param userName the user name of this file manager entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this file manager entry.
	 *
	 * @param userUuid the user uuid of this file manager entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
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

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected FileManagerEntryWrapper wrap(FileManagerEntry fileManagerEntry) {
		return new FileManagerEntryWrapper(fileManagerEntry);
	}

}