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
public class AccountPermissionEntrySoap implements Serializable {

	public static AccountPermissionEntrySoap toSoapModel(
		AccountPermissionEntry model) {

		AccountPermissionEntrySoap soapModel = new AccountPermissionEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setPermissionId(model.getPermissionId());
		soapModel.setAccountId(model.getAccountId());

		return soapModel;
	}

	public static AccountPermissionEntrySoap[] toSoapModels(
		AccountPermissionEntry[] models) {

		AccountPermissionEntrySoap[] soapModels =
			new AccountPermissionEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AccountPermissionEntrySoap[][] toSoapModels(
		AccountPermissionEntry[][] models) {

		AccountPermissionEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AccountPermissionEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AccountPermissionEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AccountPermissionEntrySoap[] toSoapModels(
		List<AccountPermissionEntry> models) {

		List<AccountPermissionEntrySoap> soapModels =
			new ArrayList<AccountPermissionEntrySoap>(models.size());

		for (AccountPermissionEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new AccountPermissionEntrySoap[soapModels.size()]);
	}

	public AccountPermissionEntrySoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getPermissionId() {
		return _permissionId;
	}

	public void setPermissionId(long permissionId) {
		_permissionId = permissionId;
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _id;
	private long _companyId;
	private long _permissionId;
	private long _accountId;

}