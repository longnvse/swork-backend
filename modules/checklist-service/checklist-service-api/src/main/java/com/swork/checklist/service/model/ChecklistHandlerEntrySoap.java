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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ChecklistHandlerEntrySoap implements Serializable {

	public static ChecklistHandlerEntrySoap toSoapModel(
		ChecklistHandlerEntry model) {

		ChecklistHandlerEntrySoap soapModel = new ChecklistHandlerEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setChecklistHandlerId(model.getChecklistHandlerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCheckListId(model.getCheckListId());
		soapModel.setAccId(model.getAccId());

		return soapModel;
	}

	public static ChecklistHandlerEntrySoap[] toSoapModels(
		ChecklistHandlerEntry[] models) {

		ChecklistHandlerEntrySoap[] soapModels =
			new ChecklistHandlerEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChecklistHandlerEntrySoap[][] toSoapModels(
		ChecklistHandlerEntry[][] models) {

		ChecklistHandlerEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ChecklistHandlerEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChecklistHandlerEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChecklistHandlerEntrySoap[] toSoapModels(
		List<ChecklistHandlerEntry> models) {

		List<ChecklistHandlerEntrySoap> soapModels =
			new ArrayList<ChecklistHandlerEntrySoap>(models.size());

		for (ChecklistHandlerEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ChecklistHandlerEntrySoap[soapModels.size()]);
	}

	public ChecklistHandlerEntrySoap() {
	}

	public long getPrimaryKey() {
		return _checklistHandlerId;
	}

	public void setPrimaryKey(long pk) {
		setChecklistHandlerId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getChecklistHandlerId() {
		return _checklistHandlerId;
	}

	public void setChecklistHandlerId(long checklistHandlerId) {
		_checklistHandlerId = checklistHandlerId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Long getCheckListId() {
		return _checkListId;
	}

	public void setCheckListId(Long checkListId) {
		_checkListId = checkListId;
	}

	public Long getAccId() {
		return _accId;
	}

	public void setAccId(Long accId) {
		_accId = accId;
	}

	private String _uuid;
	private long _checklistHandlerId;
	private long _groupId;
	private Long _checkListId;
	private Long _accId;

}