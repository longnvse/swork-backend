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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChecklistHandlerEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistHandlerEntry
 * @generated
 */
public class ChecklistHandlerEntryWrapper
	extends BaseModelWrapper<ChecklistHandlerEntry>
	implements ChecklistHandlerEntry, ModelWrapper<ChecklistHandlerEntry> {

	public ChecklistHandlerEntryWrapper(
		ChecklistHandlerEntry checklistHandlerEntry) {

		super(checklistHandlerEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("checklistHandlerId", getChecklistHandlerId());
		attributes.put("groupId", getGroupId());
		attributes.put("checkListId", getCheckListId());
		attributes.put("accId", getAccId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long checklistHandlerId = (Long)attributes.get("checklistHandlerId");

		if (checklistHandlerId != null) {
			setChecklistHandlerId(checklistHandlerId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long checkListId = (Long)attributes.get("checkListId");

		if (checkListId != null) {
			setCheckListId(checkListId);
		}

		Long accId = (Long)attributes.get("accId");

		if (accId != null) {
			setAccId(accId);
		}
	}

	@Override
	public ChecklistHandlerEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the acc ID of this checklist handler entry.
	 *
	 * @return the acc ID of this checklist handler entry
	 */
	@Override
	public Long getAccId() {
		return model.getAccId();
	}

	/**
	 * Returns the checklist handler ID of this checklist handler entry.
	 *
	 * @return the checklist handler ID of this checklist handler entry
	 */
	@Override
	public long getChecklistHandlerId() {
		return model.getChecklistHandlerId();
	}

	/**
	 * Returns the check list ID of this checklist handler entry.
	 *
	 * @return the check list ID of this checklist handler entry
	 */
	@Override
	public Long getCheckListId() {
		return model.getCheckListId();
	}

	/**
	 * Returns the group ID of this checklist handler entry.
	 *
	 * @return the group ID of this checklist handler entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this checklist handler entry.
	 *
	 * @return the primary key of this checklist handler entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this checklist handler entry.
	 *
	 * @return the uuid of this checklist handler entry
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
	 * Sets the acc ID of this checklist handler entry.
	 *
	 * @param accId the acc ID of this checklist handler entry
	 */
	@Override
	public void setAccId(Long accId) {
		model.setAccId(accId);
	}

	/**
	 * Sets the checklist handler ID of this checklist handler entry.
	 *
	 * @param checklistHandlerId the checklist handler ID of this checklist handler entry
	 */
	@Override
	public void setChecklistHandlerId(long checklistHandlerId) {
		model.setChecklistHandlerId(checklistHandlerId);
	}

	/**
	 * Sets the check list ID of this checklist handler entry.
	 *
	 * @param checkListId the check list ID of this checklist handler entry
	 */
	@Override
	public void setCheckListId(Long checkListId) {
		model.setCheckListId(checkListId);
	}

	/**
	 * Sets the group ID of this checklist handler entry.
	 *
	 * @param groupId the group ID of this checklist handler entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this checklist handler entry.
	 *
	 * @param primaryKey the primary key of this checklist handler entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this checklist handler entry.
	 *
	 * @param uuid the uuid of this checklist handler entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ChecklistHandlerEntryWrapper wrap(
		ChecklistHandlerEntry checklistHandlerEntry) {

		return new ChecklistHandlerEntryWrapper(checklistHandlerEntry);
	}

}