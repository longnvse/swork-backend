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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChecklistEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistEntry
 * @generated
 */
public class ChecklistEntryWrapper
	extends BaseModelWrapper<ChecklistEntry>
	implements ChecklistEntry, ModelWrapper<ChecklistEntry> {

	public ChecklistEntryWrapper(ChecklistEntry checklistEntry) {
		super(checklistEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("checklistId", getChecklistId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("taskId", getTaskId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long checklistId = (Long)attributes.get("checklistId");

		if (checklistId != null) {
			setChecklistId(checklistId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public ChecklistEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the checklist ID of this checklist entry.
	 *
	 * @return the checklist ID of this checklist entry
	 */
	@Override
	public long getChecklistId() {
		return model.getChecklistId();
	}

	/**
	 * Returns the company ID of this checklist entry.
	 *
	 * @return the company ID of this checklist entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this checklist entry.
	 *
	 * @return the create date of this checklist entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this checklist entry.
	 *
	 * @return the group ID of this checklist entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this checklist entry.
	 *
	 * @return the modified date of this checklist entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this checklist entry.
	 *
	 * @return the name of this checklist entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this checklist entry.
	 *
	 * @return the primary key of this checklist entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this checklist entry.
	 *
	 * @return the status of this checklist entry
	 */
	@Override
	public Boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the task ID of this checklist entry.
	 *
	 * @return the task ID of this checklist entry
	 */
	@Override
	public Long getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the user ID of this checklist entry.
	 *
	 * @return the user ID of this checklist entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this checklist entry.
	 *
	 * @return the user name of this checklist entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this checklist entry.
	 *
	 * @return the user uuid of this checklist entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this checklist entry.
	 *
	 * @return the uuid of this checklist entry
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
	 * Sets the checklist ID of this checklist entry.
	 *
	 * @param checklistId the checklist ID of this checklist entry
	 */
	@Override
	public void setChecklistId(long checklistId) {
		model.setChecklistId(checklistId);
	}

	/**
	 * Sets the company ID of this checklist entry.
	 *
	 * @param companyId the company ID of this checklist entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this checklist entry.
	 *
	 * @param createDate the create date of this checklist entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this checklist entry.
	 *
	 * @param groupId the group ID of this checklist entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this checklist entry.
	 *
	 * @param modifiedDate the modified date of this checklist entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this checklist entry.
	 *
	 * @param name the name of this checklist entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this checklist entry.
	 *
	 * @param primaryKey the primary key of this checklist entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this checklist entry.
	 *
	 * @param status the status of this checklist entry
	 */
	@Override
	public void setStatus(Boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the task ID of this checklist entry.
	 *
	 * @param taskId the task ID of this checklist entry
	 */
	@Override
	public void setTaskId(Long taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the user ID of this checklist entry.
	 *
	 * @param userId the user ID of this checklist entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this checklist entry.
	 *
	 * @param userName the user name of this checklist entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this checklist entry.
	 *
	 * @param userUuid the user uuid of this checklist entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this checklist entry.
	 *
	 * @param uuid the uuid of this checklist entry
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
	protected ChecklistEntryWrapper wrap(ChecklistEntry checklistEntry) {
		return new ChecklistEntryWrapper(checklistEntry);
	}

}