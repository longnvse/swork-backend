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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PhaseEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhaseEntry
 * @generated
 */
public class PhaseEntryWrapper
	extends BaseModelWrapper<PhaseEntry>
	implements ModelWrapper<PhaseEntry>, PhaseEntry {

	public PhaseEntryWrapper(PhaseEntry phaseEntry) {
		super(phaseEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("phaseId", getPhaseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("businessId", getBusinessId());
		attributes.put("modifiedId", getModifiedId());
		attributes.put("phaseName", getPhaseName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());
		attributes.put("progress", getProgress());
		attributes.put("projectId", getProjectId());

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

		Long phaseId = (Long)attributes.get("phaseId");

		if (phaseId != null) {
			setPhaseId(phaseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
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

		Long modifiedId = (Long)attributes.get("modifiedId");

		if (modifiedId != null) {
			setModifiedId(modifiedId);
		}

		String phaseName = (String)attributes.get("phaseName");

		if (phaseName != null) {
			setPhaseName(phaseName);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long progress = (Long)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}
	}

	@Override
	public PhaseEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the business ID of this phase entry.
	 *
	 * @return the business ID of this phase entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the company ID of this phase entry.
	 *
	 * @return the company ID of this phase entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this phase entry.
	 *
	 * @return the create date of this phase entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this phase entry.
	 *
	 * @return the creator ID of this phase entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the description of this phase entry.
	 *
	 * @return the description of this phase entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end date of this phase entry.
	 *
	 * @return the end date of this phase entry
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the external reference code of this phase entry.
	 *
	 * @return the external reference code of this phase entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this phase entry.
	 *
	 * @return the group ID of this phase entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this phase entry.
	 *
	 * @return the modified date of this phase entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified ID of this phase entry.
	 *
	 * @return the modified ID of this phase entry
	 */
	@Override
	public long getModifiedId() {
		return model.getModifiedId();
	}

	/**
	 * Returns the phase ID of this phase entry.
	 *
	 * @return the phase ID of this phase entry
	 */
	@Override
	public long getPhaseId() {
		return model.getPhaseId();
	}

	/**
	 * Returns the phase name of this phase entry.
	 *
	 * @return the phase name of this phase entry
	 */
	@Override
	public String getPhaseName() {
		return model.getPhaseName();
	}

	/**
	 * Returns the primary key of this phase entry.
	 *
	 * @return the primary key of this phase entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progress of this phase entry.
	 *
	 * @return the progress of this phase entry
	 */
	@Override
	public long getProgress() {
		return model.getProgress();
	}

	/**
	 * Returns the project ID of this phase entry.
	 *
	 * @return the project ID of this phase entry
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the start date of this phase entry.
	 *
	 * @return the start date of this phase entry
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this phase entry.
	 *
	 * @return the status of this phase entry
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this phase entry.
	 *
	 * @return the uuid of this phase entry
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
	 * Sets the business ID of this phase entry.
	 *
	 * @param businessId the business ID of this phase entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the company ID of this phase entry.
	 *
	 * @param companyId the company ID of this phase entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this phase entry.
	 *
	 * @param createDate the create date of this phase entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this phase entry.
	 *
	 * @param creatorId the creator ID of this phase entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the description of this phase entry.
	 *
	 * @param description the description of this phase entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end date of this phase entry.
	 *
	 * @param endDate the end date of this phase entry
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the external reference code of this phase entry.
	 *
	 * @param externalReferenceCode the external reference code of this phase entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this phase entry.
	 *
	 * @param groupId the group ID of this phase entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this phase entry.
	 *
	 * @param modifiedDate the modified date of this phase entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified ID of this phase entry.
	 *
	 * @param modifiedId the modified ID of this phase entry
	 */
	@Override
	public void setModifiedId(long modifiedId) {
		model.setModifiedId(modifiedId);
	}

	/**
	 * Sets the phase ID of this phase entry.
	 *
	 * @param phaseId the phase ID of this phase entry
	 */
	@Override
	public void setPhaseId(long phaseId) {
		model.setPhaseId(phaseId);
	}

	/**
	 * Sets the phase name of this phase entry.
	 *
	 * @param phaseName the phase name of this phase entry
	 */
	@Override
	public void setPhaseName(String phaseName) {
		model.setPhaseName(phaseName);
	}

	/**
	 * Sets the primary key of this phase entry.
	 *
	 * @param primaryKey the primary key of this phase entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progress of this phase entry.
	 *
	 * @param progress the progress of this phase entry
	 */
	@Override
	public void setProgress(long progress) {
		model.setProgress(progress);
	}

	/**
	 * Sets the project ID of this phase entry.
	 *
	 * @param projectId the project ID of this phase entry
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the start date of this phase entry.
	 *
	 * @param startDate the start date of this phase entry
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this phase entry.
	 *
	 * @param status the status of this phase entry
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this phase entry.
	 *
	 * @param uuid the uuid of this phase entry
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
	protected PhaseEntryWrapper wrap(PhaseEntry phaseEntry) {
		return new PhaseEntryWrapper(phaseEntry);
	}

}