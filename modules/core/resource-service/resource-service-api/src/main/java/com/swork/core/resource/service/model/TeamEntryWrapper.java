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

package com.swork.core.resource.service.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TeamEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamEntry
 * @generated
 */
public class TeamEntryWrapper
	extends BaseModelWrapper<TeamEntry>
	implements ModelWrapper<TeamEntry>, TeamEntry {

	public TeamEntryWrapper(TeamEntry teamEntry) {
		super(teamEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("teamId", getTeamId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("accountId", getAccountId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("businessId", getBusinessId());
		attributes.put("modifiedId", getModifiedId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("isActive", getIsActive());
		attributes.put("phaseId", getPhaseId());
		attributes.put("projectId", getProjectId());
		attributes.put("totalIncoming", getTotalIncoming());
		attributes.put("totalSpending", getTotalSpending());

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

		Long teamId = (Long)attributes.get("teamId");

		if (teamId != null) {
			setTeamId(teamId);
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

		Long modifiedId = (Long)attributes.get("modifiedId");

		if (modifiedId != null) {
			setModifiedId(modifiedId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Long phaseId = (Long)attributes.get("phaseId");

		if (phaseId != null) {
			setPhaseId(phaseId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long totalIncoming = (Long)attributes.get("totalIncoming");

		if (totalIncoming != null) {
			setTotalIncoming(totalIncoming);
		}

		Long totalSpending = (Long)attributes.get("totalSpending");

		if (totalSpending != null) {
			setTotalSpending(totalSpending);
		}
	}

	@Override
	public TeamEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account ID of this team entry.
	 *
	 * @return the account ID of this team entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the business ID of this team entry.
	 *
	 * @return the business ID of this team entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the company ID of this team entry.
	 *
	 * @return the company ID of this team entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this team entry.
	 *
	 * @return the create date of this team entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this team entry.
	 *
	 * @return the description of this team entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the external reference code of this team entry.
	 *
	 * @return the external reference code of this team entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this team entry.
	 *
	 * @return the group ID of this team entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is active of this team entry.
	 *
	 * @return the is active of this team entry
	 */
	@Override
	public Boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the modified date of this team entry.
	 *
	 * @return the modified date of this team entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified ID of this team entry.
	 *
	 * @return the modified ID of this team entry
	 */
	@Override
	public long getModifiedId() {
		return model.getModifiedId();
	}

	/**
	 * Returns the name of this team entry.
	 *
	 * @return the name of this team entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the phase ID of this team entry.
	 *
	 * @return the phase ID of this team entry
	 */
	@Override
	public Long getPhaseId() {
		return model.getPhaseId();
	}

	/**
	 * Returns the primary key of this team entry.
	 *
	 * @return the primary key of this team entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this team entry.
	 *
	 * @return the project ID of this team entry
	 */
	@Override
	public Long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the team ID of this team entry.
	 *
	 * @return the team ID of this team entry
	 */
	@Override
	public long getTeamId() {
		return model.getTeamId();
	}

	/**
	 * Returns the total incoming of this team entry.
	 *
	 * @return the total incoming of this team entry
	 */
	@Override
	public Long getTotalIncoming() {
		return model.getTotalIncoming();
	}

	/**
	 * Returns the total spending of this team entry.
	 *
	 * @return the total spending of this team entry
	 */
	@Override
	public Long getTotalSpending() {
		return model.getTotalSpending();
	}

	/**
	 * Returns the uuid of this team entry.
	 *
	 * @return the uuid of this team entry
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
	 * Sets the account ID of this team entry.
	 *
	 * @param accountId the account ID of this team entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the business ID of this team entry.
	 *
	 * @param businessId the business ID of this team entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the company ID of this team entry.
	 *
	 * @param companyId the company ID of this team entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this team entry.
	 *
	 * @param createDate the create date of this team entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this team entry.
	 *
	 * @param description the description of this team entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the external reference code of this team entry.
	 *
	 * @param externalReferenceCode the external reference code of this team entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this team entry.
	 *
	 * @param groupId the group ID of this team entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is active of this team entry.
	 *
	 * @param isActive the is active of this team entry
	 */
	@Override
	public void setIsActive(Boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the modified date of this team entry.
	 *
	 * @param modifiedDate the modified date of this team entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified ID of this team entry.
	 *
	 * @param modifiedId the modified ID of this team entry
	 */
	@Override
	public void setModifiedId(long modifiedId) {
		model.setModifiedId(modifiedId);
	}

	/**
	 * Sets the name of this team entry.
	 *
	 * @param name the name of this team entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the phase ID of this team entry.
	 *
	 * @param phaseId the phase ID of this team entry
	 */
	@Override
	public void setPhaseId(Long phaseId) {
		model.setPhaseId(phaseId);
	}

	/**
	 * Sets the primary key of this team entry.
	 *
	 * @param primaryKey the primary key of this team entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this team entry.
	 *
	 * @param projectId the project ID of this team entry
	 */
	@Override
	public void setProjectId(Long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the team ID of this team entry.
	 *
	 * @param teamId the team ID of this team entry
	 */
	@Override
	public void setTeamId(long teamId) {
		model.setTeamId(teamId);
	}

	/**
	 * Sets the total incoming of this team entry.
	 *
	 * @param totalIncoming the total incoming of this team entry
	 */
	@Override
	public void setTotalIncoming(Long totalIncoming) {
		model.setTotalIncoming(totalIncoming);
	}

	/**
	 * Sets the total spending of this team entry.
	 *
	 * @param totalSpending the total spending of this team entry
	 */
	@Override
	public void setTotalSpending(Long totalSpending) {
		model.setTotalSpending(totalSpending);
	}

	/**
	 * Sets the uuid of this team entry.
	 *
	 * @param uuid the uuid of this team entry
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
	protected TeamEntryWrapper wrap(TeamEntry teamEntry) {
		return new TeamEntryWrapper(teamEntry);
	}

}