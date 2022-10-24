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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProjectEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEntry
 * @generated
 */
public class ProjectEntryWrapper
	extends BaseModelWrapper<ProjectEntry>
	implements ModelWrapper<ProjectEntry>, ProjectEntry {

	public ProjectEntryWrapper(ProjectEntry projectEntry) {
		super(projectEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectId", getProjectId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("accountId", getAccountId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedId", getModifiedId());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("budget", getBudget());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("progress", getProgress());
		attributes.put("actualTime", getActualTime());
		attributes.put("actualStart", getActualStart());
		attributes.put("progressType", getProgressType());
		attributes.put("businessId", getBusinessId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
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

		Long modifiedId = (Long)attributes.get("modifiedId");

		if (modifiedId != null) {
			setModifiedId(modifiedId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long budget = (Long)attributes.get("budget");

		if (budget != null) {
			setBudget(budget);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer progress = (Integer)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		Date actualTime = (Date)attributes.get("actualTime");

		if (actualTime != null) {
			setActualTime(actualTime);
		}

		Date actualStart = (Date)attributes.get("actualStart");

		if (actualStart != null) {
			setActualStart(actualStart);
		}

		String progressType = (String)attributes.get("progressType");

		if (progressType != null) {
			setProgressType(progressType);
		}

		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
		}
	}

	@Override
	public ProjectEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account ID of this project entry.
	 *
	 * @return the account ID of this project entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the actual start of this project entry.
	 *
	 * @return the actual start of this project entry
	 */
	@Override
	public Date getActualStart() {
		return model.getActualStart();
	}

	/**
	 * Returns the actual time of this project entry.
	 *
	 * @return the actual time of this project entry
	 */
	@Override
	public Date getActualTime() {
		return model.getActualTime();
	}

	/**
	 * Returns the budget of this project entry.
	 *
	 * @return the budget of this project entry
	 */
	@Override
	public long getBudget() {
		return model.getBudget();
	}

	/**
	 * Returns the business ID of this project entry.
	 *
	 * @return the business ID of this project entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the code of this project entry.
	 *
	 * @return the code of this project entry
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this project entry.
	 *
	 * @return the company ID of this project entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this project entry.
	 *
	 * @return the create date of this project entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this project entry.
	 *
	 * @return the description of this project entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end date of this project entry.
	 *
	 * @return the end date of this project entry
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this project entry.
	 *
	 * @return the group ID of this project entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this project entry.
	 *
	 * @return the modified date of this project entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified ID of this project entry.
	 *
	 * @return the modified ID of this project entry
	 */
	@Override
	public long getModifiedId() {
		return model.getModifiedId();
	}

	/**
	 * Returns the name of this project entry.
	 *
	 * @return the name of this project entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this project entry.
	 *
	 * @return the primary key of this project entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progress of this project entry.
	 *
	 * @return the progress of this project entry
	 */
	@Override
	public Integer getProgress() {
		return model.getProgress();
	}

	/**
	 * Returns the progress type of this project entry.
	 *
	 * @return the progress type of this project entry
	 */
	@Override
	public String getProgressType() {
		return model.getProgressType();
	}

	/**
	 * Returns the project ID of this project entry.
	 *
	 * @return the project ID of this project entry
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the start date of this project entry.
	 *
	 * @return the start date of this project entry
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this project entry.
	 *
	 * @return the status of this project entry
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user name of this project entry.
	 *
	 * @return the user name of this project entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the uuid of this project entry.
	 *
	 * @return the uuid of this project entry
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
	 * Sets the account ID of this project entry.
	 *
	 * @param accountId the account ID of this project entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the actual start of this project entry.
	 *
	 * @param actualStart the actual start of this project entry
	 */
	@Override
	public void setActualStart(Date actualStart) {
		model.setActualStart(actualStart);
	}

	/**
	 * Sets the actual time of this project entry.
	 *
	 * @param actualTime the actual time of this project entry
	 */
	@Override
	public void setActualTime(Date actualTime) {
		model.setActualTime(actualTime);
	}

	/**
	 * Sets the budget of this project entry.
	 *
	 * @param budget the budget of this project entry
	 */
	@Override
	public void setBudget(long budget) {
		model.setBudget(budget);
	}

	/**
	 * Sets the business ID of this project entry.
	 *
	 * @param businessId the business ID of this project entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the code of this project entry.
	 *
	 * @param code the code of this project entry
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this project entry.
	 *
	 * @param companyId the company ID of this project entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this project entry.
	 *
	 * @param createDate the create date of this project entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this project entry.
	 *
	 * @param description the description of this project entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end date of this project entry.
	 *
	 * @param endDate the end date of this project entry
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this project entry.
	 *
	 * @param groupId the group ID of this project entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this project entry.
	 *
	 * @param modifiedDate the modified date of this project entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified ID of this project entry.
	 *
	 * @param modifiedId the modified ID of this project entry
	 */
	@Override
	public void setModifiedId(long modifiedId) {
		model.setModifiedId(modifiedId);
	}

	/**
	 * Sets the name of this project entry.
	 *
	 * @param name the name of this project entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this project entry.
	 *
	 * @param primaryKey the primary key of this project entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progress of this project entry.
	 *
	 * @param progress the progress of this project entry
	 */
	@Override
	public void setProgress(Integer progress) {
		model.setProgress(progress);
	}

	/**
	 * Sets the progress type of this project entry.
	 *
	 * @param progressType the progress type of this project entry
	 */
	@Override
	public void setProgressType(String progressType) {
		model.setProgressType(progressType);
	}

	/**
	 * Sets the project ID of this project entry.
	 *
	 * @param projectId the project ID of this project entry
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the start date of this project entry.
	 *
	 * @param startDate the start date of this project entry
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this project entry.
	 *
	 * @param status the status of this project entry
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user name of this project entry.
	 *
	 * @param userName the user name of this project entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the uuid of this project entry.
	 *
	 * @param uuid the uuid of this project entry
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
	protected ProjectEntryWrapper wrap(ProjectEntry projectEntry) {
		return new ProjectEntryWrapper(projectEntry);
	}

}