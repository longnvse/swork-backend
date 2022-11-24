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
 * This class is a wrapper for {@link ResourceTypeEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceTypeEntry
 * @generated
 */
public class ResourceTypeEntryWrapper
	extends BaseModelWrapper<ResourceTypeEntry>
	implements ModelWrapper<ResourceTypeEntry>, ResourceTypeEntry {

	public ResourceTypeEntryWrapper(ResourceTypeEntry resourceTypeEntry) {
		super(resourceTypeEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("resourceTypeId", getResourceTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("accountId", getAccountId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("businessId", getBusinessId());
		attributes.put("modifiedId", getModifiedId());
		attributes.put("name", getName());
		attributes.put("unit", getUnit());
		attributes.put("parentId", getParentId());

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

		Long resourceTypeId = (Long)attributes.get("resourceTypeId");

		if (resourceTypeId != null) {
			setResourceTypeId(resourceTypeId);
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

		String unit = (String)attributes.get("unit");

		if (unit != null) {
			setUnit(unit);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	@Override
	public ResourceTypeEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account ID of this resource type entry.
	 *
	 * @return the account ID of this resource type entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the business ID of this resource type entry.
	 *
	 * @return the business ID of this resource type entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the company ID of this resource type entry.
	 *
	 * @return the company ID of this resource type entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this resource type entry.
	 *
	 * @return the create date of this resource type entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external reference code of this resource type entry.
	 *
	 * @return the external reference code of this resource type entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this resource type entry.
	 *
	 * @return the group ID of this resource type entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this resource type entry.
	 *
	 * @return the modified date of this resource type entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified ID of this resource type entry.
	 *
	 * @return the modified ID of this resource type entry
	 */
	@Override
	public long getModifiedId() {
		return model.getModifiedId();
	}

	/**
	 * Returns the name of this resource type entry.
	 *
	 * @return the name of this resource type entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent ID of this resource type entry.
	 *
	 * @return the parent ID of this resource type entry
	 */
	@Override
	public Long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this resource type entry.
	 *
	 * @return the primary key of this resource type entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the resource type ID of this resource type entry.
	 *
	 * @return the resource type ID of this resource type entry
	 */
	@Override
	public long getResourceTypeId() {
		return model.getResourceTypeId();
	}

	/**
	 * Returns the unit of this resource type entry.
	 *
	 * @return the unit of this resource type entry
	 */
	@Override
	public String getUnit() {
		return model.getUnit();
	}

	/**
	 * Returns the uuid of this resource type entry.
	 *
	 * @return the uuid of this resource type entry
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
	 * Sets the account ID of this resource type entry.
	 *
	 * @param accountId the account ID of this resource type entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the business ID of this resource type entry.
	 *
	 * @param businessId the business ID of this resource type entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the company ID of this resource type entry.
	 *
	 * @param companyId the company ID of this resource type entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this resource type entry.
	 *
	 * @param createDate the create date of this resource type entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external reference code of this resource type entry.
	 *
	 * @param externalReferenceCode the external reference code of this resource type entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this resource type entry.
	 *
	 * @param groupId the group ID of this resource type entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this resource type entry.
	 *
	 * @param modifiedDate the modified date of this resource type entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified ID of this resource type entry.
	 *
	 * @param modifiedId the modified ID of this resource type entry
	 */
	@Override
	public void setModifiedId(long modifiedId) {
		model.setModifiedId(modifiedId);
	}

	/**
	 * Sets the name of this resource type entry.
	 *
	 * @param name the name of this resource type entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent ID of this resource type entry.
	 *
	 * @param parentId the parent ID of this resource type entry
	 */
	@Override
	public void setParentId(Long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this resource type entry.
	 *
	 * @param primaryKey the primary key of this resource type entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the resource type ID of this resource type entry.
	 *
	 * @param resourceTypeId the resource type ID of this resource type entry
	 */
	@Override
	public void setResourceTypeId(long resourceTypeId) {
		model.setResourceTypeId(resourceTypeId);
	}

	/**
	 * Sets the unit of this resource type entry.
	 *
	 * @param unit the unit of this resource type entry
	 */
	@Override
	public void setUnit(String unit) {
		model.setUnit(unit);
	}

	/**
	 * Sets the uuid of this resource type entry.
	 *
	 * @param uuid the uuid of this resource type entry
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
	protected ResourceTypeEntryWrapper wrap(
		ResourceTypeEntry resourceTypeEntry) {

		return new ResourceTypeEntryWrapper(resourceTypeEntry);
	}

}