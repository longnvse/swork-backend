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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PhaseManageEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhaseManageEntry
 * @generated
 */
public class PhaseManageEntryWrapper
	extends BaseModelWrapper<PhaseManageEntry>
	implements ModelWrapper<PhaseManageEntry>, PhaseManageEntry {

	public PhaseManageEntryWrapper(PhaseManageEntry phaseManageEntry) {
		super(phaseManageEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("phaseManageId", getPhaseManageId());
		attributes.put("phaseId", getPhaseId());
		attributes.put("accountId", getAccountId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long phaseManageId = (Long)attributes.get("phaseManageId");

		if (phaseManageId != null) {
			setPhaseManageId(phaseManageId);
		}

		Long phaseId = (Long)attributes.get("phaseId");

		if (phaseId != null) {
			setPhaseId(phaseId);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}
	}

	@Override
	public PhaseManageEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account ID of this phase manage entry.
	 *
	 * @return the account ID of this phase manage entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the phase ID of this phase manage entry.
	 *
	 * @return the phase ID of this phase manage entry
	 */
	@Override
	public long getPhaseId() {
		return model.getPhaseId();
	}

	/**
	 * Returns the phase manage ID of this phase manage entry.
	 *
	 * @return the phase manage ID of this phase manage entry
	 */
	@Override
	public long getPhaseManageId() {
		return model.getPhaseManageId();
	}

	/**
	 * Returns the primary key of this phase manage entry.
	 *
	 * @return the primary key of this phase manage entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the account ID of this phase manage entry.
	 *
	 * @param accountId the account ID of this phase manage entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the phase ID of this phase manage entry.
	 *
	 * @param phaseId the phase ID of this phase manage entry
	 */
	@Override
	public void setPhaseId(long phaseId) {
		model.setPhaseId(phaseId);
	}

	/**
	 * Sets the phase manage ID of this phase manage entry.
	 *
	 * @param phaseManageId the phase manage ID of this phase manage entry
	 */
	@Override
	public void setPhaseManageId(long phaseManageId) {
		model.setPhaseManageId(phaseManageId);
	}

	/**
	 * Sets the primary key of this phase manage entry.
	 *
	 * @param primaryKey the primary key of this phase manage entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected PhaseManageEntryWrapper wrap(PhaseManageEntry phaseManageEntry) {
		return new PhaseManageEntryWrapper(phaseManageEntry);
	}

}