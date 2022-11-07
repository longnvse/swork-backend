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
public class PhaseManageEntrySoap implements Serializable {

	public static PhaseManageEntrySoap toSoapModel(PhaseManageEntry model) {
		PhaseManageEntrySoap soapModel = new PhaseManageEntrySoap();

		soapModel.setPhaseManageId(model.getPhaseManageId());
		soapModel.setPhaseId(model.getPhaseId());
		soapModel.setAccountId(model.getAccountId());

		return soapModel;
	}

	public static PhaseManageEntrySoap[] toSoapModels(
		PhaseManageEntry[] models) {

		PhaseManageEntrySoap[] soapModels =
			new PhaseManageEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhaseManageEntrySoap[][] toSoapModels(
		PhaseManageEntry[][] models) {

		PhaseManageEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PhaseManageEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhaseManageEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhaseManageEntrySoap[] toSoapModels(
		List<PhaseManageEntry> models) {

		List<PhaseManageEntrySoap> soapModels =
			new ArrayList<PhaseManageEntrySoap>(models.size());

		for (PhaseManageEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhaseManageEntrySoap[soapModels.size()]);
	}

	public PhaseManageEntrySoap() {
	}

	public long getPrimaryKey() {
		return _phaseManageId;
	}

	public void setPrimaryKey(long pk) {
		setPhaseManageId(pk);
	}

	public long getPhaseManageId() {
		return _phaseManageId;
	}

	public void setPhaseManageId(long phaseManageId) {
		_phaseManageId = phaseManageId;
	}

	public long getPhaseId() {
		return _phaseId;
	}

	public void setPhaseId(long phaseId) {
		_phaseId = phaseId;
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	private long _phaseManageId;
	private long _phaseId;
	private long _accountId;

}