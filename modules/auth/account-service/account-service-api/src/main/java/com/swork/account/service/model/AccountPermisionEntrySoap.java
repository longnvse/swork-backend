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
public class AccountPermisionEntrySoap implements Serializable {

	public static AccountPermisionEntrySoap toSoapModel(
		AccountPermisionEntry model) {

		AccountPermisionEntrySoap soapModel = new AccountPermisionEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setPermisionId(model.getPermisionId());
		soapModel.setAccountId(model.getAccountId());

		return soapModel;
	}

	public static AccountPermisionEntrySoap[] toSoapModels(
		AccountPermisionEntry[] models) {

		AccountPermisionEntrySoap[] soapModels =
			new AccountPermisionEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AccountPermisionEntrySoap[][] toSoapModels(
		AccountPermisionEntry[][] models) {

		AccountPermisionEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AccountPermisionEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AccountPermisionEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AccountPermisionEntrySoap[] toSoapModels(
		List<AccountPermisionEntry> models) {

		List<AccountPermisionEntrySoap> soapModels =
			new ArrayList<AccountPermisionEntrySoap>(models.size());

		for (AccountPermisionEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new AccountPermisionEntrySoap[soapModels.size()]);
	}

	public AccountPermisionEntrySoap() {
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

	public long getPermisionId() {
		return _permisionId;
	}

	public void setPermisionId(long permisionId) {
		_permisionId = permisionId;
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
	private long _permisionId;
	private long _accountId;

}