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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WorkEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkEntry
 * @generated
 */
public class WorkEntryWrapper
	extends BaseModelWrapper<WorkEntry>
	implements ModelWrapper<WorkEntry>, WorkEntry {

	public WorkEntryWrapper(WorkEntry workEntry) {
		super(workEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("workId", getWorkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("accountId", getAccountId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedId", getModifiedId());
		attributes.put("businessId", getBusinessId());
		attributes.put("projectId", getProjectId());
		attributes.put("phaseId", getPhaseId());
		attributes.put("parentId", getParentId());
		attributes.put("parentReferenceCode", getParentReferenceCode());
		attributes.put("progress", getProgress());
		attributes.put("name", getName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("actualStartDate", getActualStartDate());
		attributes.put("actualEndDate", getActualEndDate());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("percentage", getPercentage());
		attributes.put("progressType", getProgressType());
		attributes.put("unit", getUnit());
		attributes.put("incompleteTask", getIncompleteTask());
		attributes.put("complete", getComplete());

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

		Long workId = (Long)attributes.get("workId");

		if (workId != null) {
			setWorkId(workId);
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

		Long modifiedId = (Long)attributes.get("modifiedId");

		if (modifiedId != null) {
			setModifiedId(modifiedId);
		}

		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long phaseId = (Long)attributes.get("phaseId");

		if (phaseId != null) {
			setPhaseId(phaseId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String parentReferenceCode = (String)attributes.get(
			"parentReferenceCode");

		if (parentReferenceCode != null) {
			setParentReferenceCode(parentReferenceCode);
		}

		Long progress = (Long)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date actualStartDate = (Date)attributes.get("actualStartDate");

		if (actualStartDate != null) {
			setActualStartDate(actualStartDate);
		}

		Date actualEndDate = (Date)attributes.get("actualEndDate");

		if (actualEndDate != null) {
			setActualEndDate(actualEndDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Double percentage = (Double)attributes.get("percentage");

		if (percentage != null) {
			setPercentage(percentage);
		}

		String progressType = (String)attributes.get("progressType");

		if (progressType != null) {
			setProgressType(progressType);
		}

		String unit = (String)attributes.get("unit");

		if (unit != null) {
			setUnit(unit);
		}

		Double incompleteTask = (Double)attributes.get("incompleteTask");

		if (incompleteTask != null) {
			setIncompleteTask(incompleteTask);
		}

		Double complete = (Double)attributes.get("complete");

		if (complete != null) {
			setComplete(complete);
		}
	}

	@Override
	public WorkEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account ID of this work entry.
	 *
	 * @return the account ID of this work entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the actual end date of this work entry.
	 *
	 * @return the actual end date of this work entry
	 */
	@Override
	public Date getActualEndDate() {
		return model.getActualEndDate();
	}

	/**
	 * Returns the actual start date of this work entry.
	 *
	 * @return the actual start date of this work entry
	 */
	@Override
	public Date getActualStartDate() {
		return model.getActualStartDate();
	}

	/**
	 * Returns the business ID of this work entry.
	 *
	 * @return the business ID of this work entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the company ID of this work entry.
	 *
	 * @return the company ID of this work entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the complete of this work entry.
	 *
	 * @return the complete of this work entry
	 */
	@Override
	public double getComplete() {
		return model.getComplete();
	}

	/**
	 * Returns the create date of this work entry.
	 *
	 * @return the create date of this work entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this work entry.
	 *
	 * @return the description of this work entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end date of this work entry.
	 *
	 * @return the end date of this work entry
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the external reference code of this work entry.
	 *
	 * @return the external reference code of this work entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this work entry.
	 *
	 * @return the group ID of this work entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the incomplete task of this work entry.
	 *
	 * @return the incomplete task of this work entry
	 */
	@Override
	public double getIncompleteTask() {
		return model.getIncompleteTask();
	}

	/**
	 * Returns the modified date of this work entry.
	 *
	 * @return the modified date of this work entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified ID of this work entry.
	 *
	 * @return the modified ID of this work entry
	 */
	@Override
	public long getModifiedId() {
		return model.getModifiedId();
	}

	/**
	 * Returns the name of this work entry.
	 *
	 * @return the name of this work entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent ID of this work entry.
	 *
	 * @return the parent ID of this work entry
	 */
	@Override
	public Long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the parent reference code of this work entry.
	 *
	 * @return the parent reference code of this work entry
	 */
	@Override
	public String getParentReferenceCode() {
		return model.getParentReferenceCode();
	}

	/**
	 * Returns the percentage of this work entry.
	 *
	 * @return the percentage of this work entry
	 */
	@Override
	public double getPercentage() {
		return model.getPercentage();
	}

	/**
	 * Returns the phase ID of this work entry.
	 *
	 * @return the phase ID of this work entry
	 */
	@Override
	public Long getPhaseId() {
		return model.getPhaseId();
	}

	/**
	 * Returns the primary key of this work entry.
	 *
	 * @return the primary key of this work entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progress of this work entry.
	 *
	 * @return the progress of this work entry
	 */
	@Override
	public long getProgress() {
		return model.getProgress();
	}

	/**
	 * Returns the progress type of this work entry.
	 *
	 * @return the progress type of this work entry
	 */
	@Override
	public String getProgressType() {
		return model.getProgressType();
	}

	/**
	 * Returns the project ID of this work entry.
	 *
	 * @return the project ID of this work entry
	 */
	@Override
	public Long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the start date of this work entry.
	 *
	 * @return the start date of this work entry
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this work entry.
	 *
	 * @return the status of this work entry
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the unit of this work entry.
	 *
	 * @return the unit of this work entry
	 */
	@Override
	public String getUnit() {
		return model.getUnit();
	}

	/**
	 * Returns the uuid of this work entry.
	 *
	 * @return the uuid of this work entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work ID of this work entry.
	 *
	 * @return the work ID of this work entry
	 */
	@Override
	public long getWorkId() {
		return model.getWorkId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the account ID of this work entry.
	 *
	 * @param accountId the account ID of this work entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the actual end date of this work entry.
	 *
	 * @param actualEndDate the actual end date of this work entry
	 */
	@Override
	public void setActualEndDate(Date actualEndDate) {
		model.setActualEndDate(actualEndDate);
	}

	/**
	 * Sets the actual start date of this work entry.
	 *
	 * @param actualStartDate the actual start date of this work entry
	 */
	@Override
	public void setActualStartDate(Date actualStartDate) {
		model.setActualStartDate(actualStartDate);
	}

	/**
	 * Sets the business ID of this work entry.
	 *
	 * @param businessId the business ID of this work entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the company ID of this work entry.
	 *
	 * @param companyId the company ID of this work entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the complete of this work entry.
	 *
	 * @param complete the complete of this work entry
	 */
	@Override
	public void setComplete(double complete) {
		model.setComplete(complete);
	}

	/**
	 * Sets the create date of this work entry.
	 *
	 * @param createDate the create date of this work entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this work entry.
	 *
	 * @param description the description of this work entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end date of this work entry.
	 *
	 * @param endDate the end date of this work entry
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the external reference code of this work entry.
	 *
	 * @param externalReferenceCode the external reference code of this work entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this work entry.
	 *
	 * @param groupId the group ID of this work entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the incomplete task of this work entry.
	 *
	 * @param incompleteTask the incomplete task of this work entry
	 */
	@Override
	public void setIncompleteTask(double incompleteTask) {
		model.setIncompleteTask(incompleteTask);
	}

	/**
	 * Sets the modified date of this work entry.
	 *
	 * @param modifiedDate the modified date of this work entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified ID of this work entry.
	 *
	 * @param modifiedId the modified ID of this work entry
	 */
	@Override
	public void setModifiedId(long modifiedId) {
		model.setModifiedId(modifiedId);
	}

	/**
	 * Sets the name of this work entry.
	 *
	 * @param name the name of this work entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent ID of this work entry.
	 *
	 * @param parentId the parent ID of this work entry
	 */
	@Override
	public void setParentId(Long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the parent reference code of this work entry.
	 *
	 * @param parentReferenceCode the parent reference code of this work entry
	 */
	@Override
	public void setParentReferenceCode(String parentReferenceCode) {
		model.setParentReferenceCode(parentReferenceCode);
	}

	/**
	 * Sets the percentage of this work entry.
	 *
	 * @param percentage the percentage of this work entry
	 */
	@Override
	public void setPercentage(double percentage) {
		model.setPercentage(percentage);
	}

	/**
	 * Sets the phase ID of this work entry.
	 *
	 * @param phaseId the phase ID of this work entry
	 */
	@Override
	public void setPhaseId(Long phaseId) {
		model.setPhaseId(phaseId);
	}

	/**
	 * Sets the primary key of this work entry.
	 *
	 * @param primaryKey the primary key of this work entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progress of this work entry.
	 *
	 * @param progress the progress of this work entry
	 */
	@Override
	public void setProgress(long progress) {
		model.setProgress(progress);
	}

	/**
	 * Sets the progress type of this work entry.
	 *
	 * @param progressType the progress type of this work entry
	 */
	@Override
	public void setProgressType(String progressType) {
		model.setProgressType(progressType);
	}

	/**
	 * Sets the project ID of this work entry.
	 *
	 * @param projectId the project ID of this work entry
	 */
	@Override
	public void setProjectId(Long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the start date of this work entry.
	 *
	 * @param startDate the start date of this work entry
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this work entry.
	 *
	 * @param status the status of this work entry
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the unit of this work entry.
	 *
	 * @param unit the unit of this work entry
	 */
	@Override
	public void setUnit(String unit) {
		model.setUnit(unit);
	}

	/**
	 * Sets the uuid of this work entry.
	 *
	 * @param uuid the uuid of this work entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work ID of this work entry.
	 *
	 * @param workId the work ID of this work entry
	 */
	@Override
	public void setWorkId(long workId) {
		model.setWorkId(workId);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected WorkEntryWrapper wrap(WorkEntry workEntry) {
		return new WorkEntryWrapper(workEntry);
	}

}