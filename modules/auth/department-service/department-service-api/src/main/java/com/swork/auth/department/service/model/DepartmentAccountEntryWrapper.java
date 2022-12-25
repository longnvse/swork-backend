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

package com.swork.auth.department.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DepartmentAccountEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentAccountEntry
 * @generated
 */
public class DepartmentAccountEntryWrapper
	extends BaseModelWrapper<DepartmentAccountEntry>
	implements DepartmentAccountEntry, ModelWrapper<DepartmentAccountEntry> {

	public DepartmentAccountEntryWrapper(
		DepartmentAccountEntry departmentAccountEntry) {

		super(departmentAccountEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("departmentAccountId", getDepartmentAccountId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("accountId", getAccountId());

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

		Long departmentAccountId = (Long)attributes.get("departmentAccountId");

		if (departmentAccountId != null) {
			setDepartmentAccountId(departmentAccountId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}
	}

	@Override
	public DepartmentAccountEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account ID of this department account entry.
	 *
	 * @return the account ID of this department account entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the company ID of this department account entry.
	 *
	 * @return the company ID of this department account entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the department account ID of this department account entry.
	 *
	 * @return the department account ID of this department account entry
	 */
	@Override
	public long getDepartmentAccountId() {
		return model.getDepartmentAccountId();
	}

	/**
	 * Returns the department ID of this department account entry.
	 *
	 * @return the department ID of this department account entry
	 */
	@Override
	public long getDepartmentId() {
		return model.getDepartmentId();
	}

	/**
	 * Returns the external reference code of this department account entry.
	 *
	 * @return the external reference code of this department account entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this department account entry.
	 *
	 * @return the group ID of this department account entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this department account entry.
	 *
	 * @return the primary key of this department account entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this department account entry.
	 *
	 * @return the uuid of this department account entry
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
	 * Sets the account ID of this department account entry.
	 *
	 * @param accountId the account ID of this department account entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the company ID of this department account entry.
	 *
	 * @param companyId the company ID of this department account entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the department account ID of this department account entry.
	 *
	 * @param departmentAccountId the department account ID of this department account entry
	 */
	@Override
	public void setDepartmentAccountId(long departmentAccountId) {
		model.setDepartmentAccountId(departmentAccountId);
	}

	/**
	 * Sets the department ID of this department account entry.
	 *
	 * @param departmentId the department ID of this department account entry
	 */
	@Override
	public void setDepartmentId(long departmentId) {
		model.setDepartmentId(departmentId);
	}

	/**
	 * Sets the external reference code of this department account entry.
	 *
	 * @param externalReferenceCode the external reference code of this department account entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this department account entry.
	 *
	 * @param groupId the group ID of this department account entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this department account entry.
	 *
	 * @param primaryKey the primary key of this department account entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this department account entry.
	 *
	 * @param uuid the uuid of this department account entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected DepartmentAccountEntryWrapper wrap(
		DepartmentAccountEntry departmentAccountEntry) {

		return new DepartmentAccountEntryWrapper(departmentAccountEntry);
	}

}