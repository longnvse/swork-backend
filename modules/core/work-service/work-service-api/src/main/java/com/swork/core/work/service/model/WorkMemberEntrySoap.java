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
public class WorkMemberEntrySoap implements Serializable {

	public static WorkMemberEntrySoap toSoapModel(WorkMemberEntry model) {
		WorkMemberEntrySoap soapModel = new WorkMemberEntrySoap();

		soapModel.setWorkMemberId(model.getWorkMemberId());
		soapModel.setWorkId(model.getWorkId());
		soapModel.setMemberId(model.getMemberId());
		soapModel.setMemberType(model.getMemberType());
		soapModel.setMemberReferenceCode(model.getMemberReferenceCode());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static WorkMemberEntrySoap[] toSoapModels(WorkMemberEntry[] models) {
		WorkMemberEntrySoap[] soapModels =
			new WorkMemberEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkMemberEntrySoap[][] toSoapModels(
		WorkMemberEntry[][] models) {

		WorkMemberEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new WorkMemberEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkMemberEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkMemberEntrySoap[] toSoapModels(
		List<WorkMemberEntry> models) {

		List<WorkMemberEntrySoap> soapModels =
			new ArrayList<WorkMemberEntrySoap>(models.size());

		for (WorkMemberEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkMemberEntrySoap[soapModels.size()]);
	}

	public WorkMemberEntrySoap() {
	}

	public long getPrimaryKey() {
		return _workMemberId;
	}

	public void setPrimaryKey(long pk) {
		setWorkMemberId(pk);
	}

	public long getWorkMemberId() {
		return _workMemberId;
	}

	public void setWorkMemberId(long workMemberId) {
		_workMemberId = workMemberId;
	}

	public long getWorkId() {
		return _workId;
	}

	public void setWorkId(long workId) {
		_workId = workId;
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
	}

	public String getMemberType() {
		return _memberType;
	}

	public void setMemberType(String memberType) {
		_memberType = memberType;
	}

	public String getMemberReferenceCode() {
		return _memberReferenceCode;
	}

	public void setMemberReferenceCode(String memberReferenceCode) {
		_memberReferenceCode = memberReferenceCode;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private long _workMemberId;
	private long _workId;
	private long _memberId;
	private String _memberType;
	private String _memberReferenceCode;
	private String _type;

}