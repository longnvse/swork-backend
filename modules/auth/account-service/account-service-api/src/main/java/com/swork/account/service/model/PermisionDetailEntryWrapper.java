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

package com.swork.account.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PermisionDetailEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermisionDetailEntry
 * @generated
 */
public class PermisionDetailEntryWrapper
	extends BaseModelWrapper<PermisionDetailEntry>
	implements ModelWrapper<PermisionDetailEntry>, PermisionDetailEntry {

	public PermisionDetailEntryWrapper(
		PermisionDetailEntry permisionDetailEntry) {

		super(permisionDetailEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("permisionId", getPermisionId());
		attributes.put("actionCode", getActionCode());

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

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long permisionId = (Long)attributes.get("permisionId");

		if (permisionId != null) {
			setPermisionId(permisionId);
		}

		String actionCode = (String)attributes.get("actionCode");

		if (actionCode != null) {
			setActionCode(actionCode);
		}
	}

	@Override
	public PermisionDetailEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the action code of this permision detail entry.
	 *
	 * @return the action code of this permision detail entry
	 */
	@Override
	public String getActionCode() {
		return model.getActionCode();
	}

	/**
	 * Returns the company ID of this permision detail entry.
	 *
	 * @return the company ID of this permision detail entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the external reference code of this permision detail entry.
	 *
	 * @return the external reference code of this permision detail entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the ID of this permision detail entry.
	 *
	 * @return the ID of this permision detail entry
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the permision ID of this permision detail entry.
	 *
	 * @return the permision ID of this permision detail entry
	 */
	@Override
	public long getPermisionId() {
		return model.getPermisionId();
	}

	/**
	 * Returns the primary key of this permision detail entry.
	 *
	 * @return the primary key of this permision detail entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this permision detail entry.
	 *
	 * @return the uuid of this permision detail entry
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
	 * Sets the action code of this permision detail entry.
	 *
	 * @param actionCode the action code of this permision detail entry
	 */
	@Override
	public void setActionCode(String actionCode) {
		model.setActionCode(actionCode);
	}

	/**
	 * Sets the company ID of this permision detail entry.
	 *
	 * @param companyId the company ID of this permision detail entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the external reference code of this permision detail entry.
	 *
	 * @param externalReferenceCode the external reference code of this permision detail entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the ID of this permision detail entry.
	 *
	 * @param id the ID of this permision detail entry
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the permision ID of this permision detail entry.
	 *
	 * @param permisionId the permision ID of this permision detail entry
	 */
	@Override
	public void setPermisionId(long permisionId) {
		model.setPermisionId(permisionId);
	}

	/**
	 * Sets the primary key of this permision detail entry.
	 *
	 * @param primaryKey the primary key of this permision detail entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this permision detail entry.
	 *
	 * @param uuid the uuid of this permision detail entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PermisionDetailEntryWrapper wrap(
		PermisionDetailEntry permisionDetailEntry) {

		return new PermisionDetailEntryWrapper(permisionDetailEntry);
	}

}