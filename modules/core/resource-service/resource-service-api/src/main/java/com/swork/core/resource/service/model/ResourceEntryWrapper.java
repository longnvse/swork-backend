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
 * This class is a wrapper for {@link ResourceEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceEntry
 * @generated
 */
public class ResourceEntryWrapper
	extends BaseModelWrapper<ResourceEntry>
	implements ModelWrapper<ResourceEntry>, ResourceEntry {

	public ResourceEntryWrapper(ResourceEntry resourceEntry) {
		super(resourceEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("resourceId", getResourceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("accountId", getAccountId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("businessId", getBusinessId());
		attributes.put("modifiedId", getModifiedId());
		attributes.put("workId", getWorkId());
		attributes.put("phaseId", getPhaseId());
		attributes.put("projectId", getProjectId());
		attributes.put("resourceTypeName", getResourceTypeName());
		attributes.put("teamId", getTeamId());
		attributes.put("teamName", getTeamName());
		attributes.put("quantity", getQuantity());
		attributes.put("unit", getUnit());
		attributes.put("dateResource", getDateResource());
		attributes.put("totalAmount", getTotalAmount());

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

		Long resourceId = (Long)attributes.get("resourceId");

		if (resourceId != null) {
			setResourceId(resourceId);
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

		Long workId = (Long)attributes.get("workId");

		if (workId != null) {
			setWorkId(workId);
		}

		Long phaseId = (Long)attributes.get("phaseId");

		if (phaseId != null) {
			setPhaseId(phaseId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String resourceTypeName = (String)attributes.get("resourceTypeName");

		if (resourceTypeName != null) {
			setResourceTypeName(resourceTypeName);
		}

		Long teamId = (Long)attributes.get("teamId");

		if (teamId != null) {
			setTeamId(teamId);
		}

		String teamName = (String)attributes.get("teamName");

		if (teamName != null) {
			setTeamName(teamName);
		}

		Double quantity = (Double)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		String unit = (String)attributes.get("unit");

		if (unit != null) {
			setUnit(unit);
		}

		Date dateResource = (Date)attributes.get("dateResource");

		if (dateResource != null) {
			setDateResource(dateResource);
		}

		Long totalAmount = (Long)attributes.get("totalAmount");

		if (totalAmount != null) {
			setTotalAmount(totalAmount);
		}
	}

	@Override
	public ResourceEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account ID of this resource entry.
	 *
	 * @return the account ID of this resource entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the business ID of this resource entry.
	 *
	 * @return the business ID of this resource entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the company ID of this resource entry.
	 *
	 * @return the company ID of this resource entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this resource entry.
	 *
	 * @return the create date of this resource entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date resource of this resource entry.
	 *
	 * @return the date resource of this resource entry
	 */
	@Override
	public Date getDateResource() {
		return model.getDateResource();
	}

	/**
	 * Returns the external reference code of this resource entry.
	 *
	 * @return the external reference code of this resource entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this resource entry.
	 *
	 * @return the group ID of this resource entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this resource entry.
	 *
	 * @return the modified date of this resource entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified ID of this resource entry.
	 *
	 * @return the modified ID of this resource entry
	 */
	@Override
	public long getModifiedId() {
		return model.getModifiedId();
	}

	/**
	 * Returns the phase ID of this resource entry.
	 *
	 * @return the phase ID of this resource entry
	 */
	@Override
	public Long getPhaseId() {
		return model.getPhaseId();
	}

	/**
	 * Returns the primary key of this resource entry.
	 *
	 * @return the primary key of this resource entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this resource entry.
	 *
	 * @return the project ID of this resource entry
	 */
	@Override
	public Long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the quantity of this resource entry.
	 *
	 * @return the quantity of this resource entry
	 */
	@Override
	public double getQuantity() {
		return model.getQuantity();
	}

	/**
	 * Returns the resource ID of this resource entry.
	 *
	 * @return the resource ID of this resource entry
	 */
	@Override
	public long getResourceId() {
		return model.getResourceId();
	}

	/**
	 * Returns the resource type name of this resource entry.
	 *
	 * @return the resource type name of this resource entry
	 */
	@Override
	public String getResourceTypeName() {
		return model.getResourceTypeName();
	}

	/**
	 * Returns the team ID of this resource entry.
	 *
	 * @return the team ID of this resource entry
	 */
	@Override
	public long getTeamId() {
		return model.getTeamId();
	}

	/**
	 * Returns the team name of this resource entry.
	 *
	 * @return the team name of this resource entry
	 */
	@Override
	public String getTeamName() {
		return model.getTeamName();
	}

	/**
	 * Returns the total amount of this resource entry.
	 *
	 * @return the total amount of this resource entry
	 */
	@Override
	public Long getTotalAmount() {
		return model.getTotalAmount();
	}

	/**
	 * Returns the unit of this resource entry.
	 *
	 * @return the unit of this resource entry
	 */
	@Override
	public String getUnit() {
		return model.getUnit();
	}

	/**
	 * Returns the uuid of this resource entry.
	 *
	 * @return the uuid of this resource entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work ID of this resource entry.
	 *
	 * @return the work ID of this resource entry
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
	 * Sets the account ID of this resource entry.
	 *
	 * @param accountId the account ID of this resource entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the business ID of this resource entry.
	 *
	 * @param businessId the business ID of this resource entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the company ID of this resource entry.
	 *
	 * @param companyId the company ID of this resource entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this resource entry.
	 *
	 * @param createDate the create date of this resource entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date resource of this resource entry.
	 *
	 * @param dateResource the date resource of this resource entry
	 */
	@Override
	public void setDateResource(Date dateResource) {
		model.setDateResource(dateResource);
	}

	/**
	 * Sets the external reference code of this resource entry.
	 *
	 * @param externalReferenceCode the external reference code of this resource entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this resource entry.
	 *
	 * @param groupId the group ID of this resource entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this resource entry.
	 *
	 * @param modifiedDate the modified date of this resource entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified ID of this resource entry.
	 *
	 * @param modifiedId the modified ID of this resource entry
	 */
	@Override
	public void setModifiedId(long modifiedId) {
		model.setModifiedId(modifiedId);
	}

	/**
	 * Sets the phase ID of this resource entry.
	 *
	 * @param phaseId the phase ID of this resource entry
	 */
	@Override
	public void setPhaseId(Long phaseId) {
		model.setPhaseId(phaseId);
	}

	/**
	 * Sets the primary key of this resource entry.
	 *
	 * @param primaryKey the primary key of this resource entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this resource entry.
	 *
	 * @param projectId the project ID of this resource entry
	 */
	@Override
	public void setProjectId(Long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the quantity of this resource entry.
	 *
	 * @param quantity the quantity of this resource entry
	 */
	@Override
	public void setQuantity(double quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the resource ID of this resource entry.
	 *
	 * @param resourceId the resource ID of this resource entry
	 */
	@Override
	public void setResourceId(long resourceId) {
		model.setResourceId(resourceId);
	}

	/**
	 * Sets the resource type name of this resource entry.
	 *
	 * @param resourceTypeName the resource type name of this resource entry
	 */
	@Override
	public void setResourceTypeName(String resourceTypeName) {
		model.setResourceTypeName(resourceTypeName);
	}

	/**
	 * Sets the team ID of this resource entry.
	 *
	 * @param teamId the team ID of this resource entry
	 */
	@Override
	public void setTeamId(long teamId) {
		model.setTeamId(teamId);
	}

	/**
	 * Sets the team name of this resource entry.
	 *
	 * @param teamName the team name of this resource entry
	 */
	@Override
	public void setTeamName(String teamName) {
		model.setTeamName(teamName);
	}

	/**
	 * Sets the total amount of this resource entry.
	 *
	 * @param totalAmount the total amount of this resource entry
	 */
	@Override
	public void setTotalAmount(Long totalAmount) {
		model.setTotalAmount(totalAmount);
	}

	/**
	 * Sets the unit of this resource entry.
	 *
	 * @param unit the unit of this resource entry
	 */
	@Override
	public void setUnit(String unit) {
		model.setUnit(unit);
	}

	/**
	 * Sets the uuid of this resource entry.
	 *
	 * @param uuid the uuid of this resource entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work ID of this resource entry.
	 *
	 * @param workId the work ID of this resource entry
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
	protected ResourceEntryWrapper wrap(ResourceEntry resourceEntry) {
		return new ResourceEntryWrapper(resourceEntry);
	}

}