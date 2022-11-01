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
public class PermissionDetailEntrySoap implements Serializable {

	public static PermissionDetailEntrySoap toSoapModel(
		PermissionDetailEntry model) {

		PermissionDetailEntrySoap soapModel = new PermissionDetailEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setPermissionId(model.getPermissionId());
		soapModel.setActionCode(model.getActionCode());

		return soapModel;
	}

	public static PermissionDetailEntrySoap[] toSoapModels(
		PermissionDetailEntry[] models) {

		PermissionDetailEntrySoap[] soapModels =
			new PermissionDetailEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PermissionDetailEntrySoap[][] toSoapModels(
		PermissionDetailEntry[][] models) {

		PermissionDetailEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PermissionDetailEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PermissionDetailEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PermissionDetailEntrySoap[] toSoapModels(
		List<PermissionDetailEntry> models) {

		List<PermissionDetailEntrySoap> soapModels =
			new ArrayList<PermissionDetailEntrySoap>(models.size());

		for (PermissionDetailEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new PermissionDetailEntrySoap[soapModels.size()]);
	}

	public PermissionDetailEntrySoap() {
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

	public String getActionCode() {
		return _actionCode;
	}

	public void setActionCode(String actionCode) {
		_actionCode = actionCode;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _id;
	private long _companyId;
	private long _permissionId;
	private String _actionCode;

}