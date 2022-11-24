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

package com.swork.core.resource.service.model;

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
public class TeamMemberEntrySoap implements Serializable {

	public static TeamMemberEntrySoap toSoapModel(TeamMemberEntry model) {
		TeamMemberEntrySoap soapModel = new TeamMemberEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setTeamMemberId(model.getTeamMemberId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setMemberId(model.getMemberId());
		soapModel.setMemberName(model.getMemberName());
		soapModel.setIsAdmin(model.getIsAdmin());
		soapModel.setTeamId(model.getTeamId());

		return soapModel;
	}

	public static TeamMemberEntrySoap[] toSoapModels(TeamMemberEntry[] models) {
		TeamMemberEntrySoap[] soapModels =
			new TeamMemberEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TeamMemberEntrySoap[][] toSoapModels(
		TeamMemberEntry[][] models) {

		TeamMemberEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TeamMemberEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TeamMemberEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TeamMemberEntrySoap[] toSoapModels(
		List<TeamMemberEntry> models) {

		List<TeamMemberEntrySoap> soapModels =
			new ArrayList<TeamMemberEntrySoap>(models.size());

		for (TeamMemberEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TeamMemberEntrySoap[soapModels.size()]);
	}

	public TeamMemberEntrySoap() {
	}

	public long getPrimaryKey() {
		return _teamMemberId;
	}

	public void setPrimaryKey(long pk) {
		setTeamMemberId(pk);
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

	public long getTeamMemberId() {
		return _teamMemberId;
	}

	public void setTeamMemberId(long teamMemberId) {
		_teamMemberId = teamMemberId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Long getMemberId() {
		return _memberId;
	}

	public void setMemberId(Long memberId) {
		_memberId = memberId;
	}

	public String getMemberName() {
		return _memberName;
	}

	public void setMemberName(String memberName) {
		_memberName = memberName;
	}

	public Boolean getIsAdmin() {
		return _isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		_isAdmin = isAdmin;
	}

	public long getTeamId() {
		return _teamId;
	}

	public void setTeamId(long teamId) {
		_teamId = teamId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _teamMemberId;
	private long _companyId;
	private Long _memberId;
	private String _memberName;
	private Boolean _isAdmin;
	private long _teamId;

}