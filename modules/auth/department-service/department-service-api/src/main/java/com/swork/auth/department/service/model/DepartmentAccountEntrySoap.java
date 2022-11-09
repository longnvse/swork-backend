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
public class DepartmentAccountEntrySoap implements Serializable {

	public static DepartmentAccountEntrySoap toSoapModel(
		DepartmentAccountEntry model) {

		DepartmentAccountEntrySoap soapModel = new DepartmentAccountEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setDepartmentAccountId(model.getDepartmentAccountId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setAccountId(model.getAccountId());

		return soapModel;
	}

	public static DepartmentAccountEntrySoap[] toSoapModels(
		DepartmentAccountEntry[] models) {

		DepartmentAccountEntrySoap[] soapModels =
			new DepartmentAccountEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DepartmentAccountEntrySoap[][] toSoapModels(
		DepartmentAccountEntry[][] models) {

		DepartmentAccountEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DepartmentAccountEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DepartmentAccountEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DepartmentAccountEntrySoap[] toSoapModels(
		List<DepartmentAccountEntry> models) {

		List<DepartmentAccountEntrySoap> soapModels =
			new ArrayList<DepartmentAccountEntrySoap>(models.size());

		for (DepartmentAccountEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DepartmentAccountEntrySoap[soapModels.size()]);
	}

	public DepartmentAccountEntrySoap() {
	}

	public long getPrimaryKey() {
		return _departmentAccountId;
	}

	public void setPrimaryKey(long pk) {
		setDepartmentAccountId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getExternalReferenceCode() {
		return _externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		_externalReferenceCode = externalReferenceCode;
	}

	public long getDepartmentAccountId() {
		return _departmentAccountId;
	}

	public void setDepartmentAccountId(long departmentAccountId) {
		_departmentAccountId = departmentAccountId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _departmentAccountId;
	private long _groupId;
	private long _companyId;
	private long _departmentId;
	private long _accountId;

}