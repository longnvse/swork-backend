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
public class PermissionEntrySoap implements Serializable {

	public static PermissionEntrySoap toSoapModel(PermissionEntry model) {
		PermissionEntrySoap soapModel = new PermissionEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static PermissionEntrySoap[] toSoapModels(PermissionEntry[] models) {
		PermissionEntrySoap[] soapModels =
			new PermissionEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PermissionEntrySoap[][] toSoapModels(
		PermissionEntry[][] models) {

		PermissionEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PermissionEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PermissionEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PermissionEntrySoap[] toSoapModels(
		List<PermissionEntry> models) {

		List<PermissionEntrySoap> soapModels =
			new ArrayList<PermissionEntrySoap>(models.size());

		for (PermissionEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PermissionEntrySoap[soapModels.size()]);
	}

	public PermissionEntrySoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _id;
	private long _companyId;
	private String _name;

}