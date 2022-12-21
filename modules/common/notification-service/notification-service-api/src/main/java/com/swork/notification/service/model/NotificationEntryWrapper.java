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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NotificationEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationEntry
 * @generated
 */
public class NotificationEntryWrapper
	extends BaseModelWrapper<NotificationEntry>
	implements ModelWrapper<NotificationEntry>, NotificationEntry {

	public NotificationEntryWrapper(NotificationEntry notificationEntry) {
		super(notificationEntry);
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
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("editorId", getEditorId());
		attributes.put("businessId", getBusinessId());
		attributes.put("category", getCategory());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("receiverId", getReceiverId());
		attributes.put("subjectId", getSubjectId());

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

		Long editorId = (Long)attributes.get("editorId");

		if (editorId != null) {
			setEditorId(editorId);
		}

		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long receiverId = (Long)attributes.get("receiverId");

		if (receiverId != null) {
			setReceiverId(receiverId);
		}

		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}
	}

	@Override
	public NotificationEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account ID of this notification entry.
	 *
	 * @return the account ID of this notification entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the business ID of this notification entry.
	 *
	 * @return the business ID of this notification entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the category of this notification entry.
	 *
	 * @return the category of this notification entry
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the company ID of this notification entry.
	 *
	 * @return the company ID of this notification entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this notification entry.
	 *
	 * @return the create date of this notification entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this notification entry.
	 *
	 * @return the description of this notification entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the editor ID of this notification entry.
	 *
	 * @return the editor ID of this notification entry
	 */
	@Override
	public long getEditorId() {
		return model.getEditorId();
	}

	/**
	 * Returns the external reference code of this notification entry.
	 *
	 * @return the external reference code of this notification entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this notification entry.
	 *
	 * @return the group ID of this notification entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this notification entry.
	 *
	 * @return the ID of this notification entry
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this notification entry.
	 *
	 * @return the modified date of this notification entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this notification entry.
	 *
	 * @return the name of this notification entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this notification entry.
	 *
	 * @return the primary key of this notification entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the receiver ID of this notification entry.
	 *
	 * @return the receiver ID of this notification entry
	 */
	@Override
	public long getReceiverId() {
		return model.getReceiverId();
	}

	/**
	 * Returns the status of this notification entry.
	 *
	 * @return the status of this notification entry
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the subject ID of this notification entry.
	 *
	 * @return the subject ID of this notification entry
	 */
	@Override
	public long getSubjectId() {
		return model.getSubjectId();
	}

	/**
	 * Returns the user name of this notification entry.
	 *
	 * @return the user name of this notification entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the uuid of this notification entry.
	 *
	 * @return the uuid of this notification entry
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
	 * Sets the account ID of this notification entry.
	 *
	 * @param accountId the account ID of this notification entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the business ID of this notification entry.
	 *
	 * @param businessId the business ID of this notification entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the category of this notification entry.
	 *
	 * @param category the category of this notification entry
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the company ID of this notification entry.
	 *
	 * @param companyId the company ID of this notification entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this notification entry.
	 *
	 * @param createDate the create date of this notification entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this notification entry.
	 *
	 * @param description the description of this notification entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the editor ID of this notification entry.
	 *
	 * @param editorId the editor ID of this notification entry
	 */
	@Override
	public void setEditorId(long editorId) {
		model.setEditorId(editorId);
	}

	/**
	 * Sets the external reference code of this notification entry.
	 *
	 * @param externalReferenceCode the external reference code of this notification entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this notification entry.
	 *
	 * @param groupId the group ID of this notification entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this notification entry.
	 *
	 * @param id the ID of this notification entry
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified date of this notification entry.
	 *
	 * @param modifiedDate the modified date of this notification entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this notification entry.
	 *
	 * @param name the name of this notification entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this notification entry.
	 *
	 * @param primaryKey the primary key of this notification entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the receiver ID of this notification entry.
	 *
	 * @param receiverId the receiver ID of this notification entry
	 */
	@Override
	public void setReceiverId(long receiverId) {
		model.setReceiverId(receiverId);
	}

	/**
	 * Sets the status of this notification entry.
	 *
	 * @param status the status of this notification entry
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the subject ID of this notification entry.
	 *
	 * @param subjectId the subject ID of this notification entry
	 */
	@Override
	public void setSubjectId(long subjectId) {
		model.setSubjectId(subjectId);
	}

	/**
	 * Sets the user name of this notification entry.
	 *
	 * @param userName the user name of this notification entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the uuid of this notification entry.
	 *
	 * @param uuid the uuid of this notification entry
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
	protected NotificationEntryWrapper wrap(
		NotificationEntry notificationEntry) {

		return new NotificationEntryWrapper(notificationEntry);
	}

}