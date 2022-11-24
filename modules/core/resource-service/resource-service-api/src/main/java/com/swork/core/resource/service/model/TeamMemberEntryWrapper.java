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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TeamMemberEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamMemberEntry
 * @generated
 */
public class TeamMemberEntryWrapper
	extends BaseModelWrapper<TeamMemberEntry>
	implements ModelWrapper<TeamMemberEntry>, TeamMemberEntry {

	public TeamMemberEntryWrapper(TeamMemberEntry teamMemberEntry) {
		super(teamMemberEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("teamMemberId", getTeamMemberId());
		attributes.put("companyId", getCompanyId());
		attributes.put("memberId", getMemberId());
		attributes.put("memberName", getMemberName());
		attributes.put("isAdmin", getIsAdmin());
		attributes.put("teamId", getTeamId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String externalReferenceCode = (String)attributes.get(
			"externalReferenceCode");

		if (externalReferenceCode != null) {
			setExternalReferenceCode(externalReferenceCode);
		}

		Long teamMemberId = (Long)attributes.get("teamMemberId");

		if (teamMemberId != null) {
			setTeamMemberId(teamMemberId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		String memberName = (String)attributes.get("memberName");

		if (memberName != null) {
			setMemberName(memberName);
		}

		Boolean isAdmin = (Boolean)attributes.get("isAdmin");

		if (isAdmin != null) {
			setIsAdmin(isAdmin);
		}

		Long teamId = (Long)attributes.get("teamId");

		if (teamId != null) {
			setTeamId(teamId);
		}
	}

	@Override
	public TeamMemberEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this team member entry.
	 *
	 * @return the company ID of this team member entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the external reference code of this team member entry.
	 *
	 * @return the external reference code of this team member entry
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the is admin of this team member entry.
	 *
	 * @return the is admin of this team member entry
	 */
	@Override
	public Boolean getIsAdmin() {
		return model.getIsAdmin();
	}

	/**
	 * Returns the member ID of this team member entry.
	 *
	 * @return the member ID of this team member entry
	 */
	@Override
	public Long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the member name of this team member entry.
	 *
	 * @return the member name of this team member entry
	 */
	@Override
	public String getMemberName() {
		return model.getMemberName();
	}

	/**
	 * Returns the primary key of this team member entry.
	 *
	 * @return the primary key of this team member entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the team ID of this team member entry.
	 *
	 * @return the team ID of this team member entry
	 */
	@Override
	public long getTeamId() {
		return model.getTeamId();
	}

	/**
	 * Returns the team member ID of this team member entry.
	 *
	 * @return the team member ID of this team member entry
	 */
	@Override
	public long getTeamMemberId() {
		return model.getTeamMemberId();
	}

	/**
	 * Returns the uuid of this team member entry.
	 *
	 * @return the uuid of this team member entry
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
	 * Sets the company ID of this team member entry.
	 *
	 * @param companyId the company ID of this team member entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the external reference code of this team member entry.
	 *
	 * @param externalReferenceCode the external reference code of this team member entry
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the is admin of this team member entry.
	 *
	 * @param isAdmin the is admin of this team member entry
	 */
	@Override
	public void setIsAdmin(Boolean isAdmin) {
		model.setIsAdmin(isAdmin);
	}

	/**
	 * Sets the member ID of this team member entry.
	 *
	 * @param memberId the member ID of this team member entry
	 */
	@Override
	public void setMemberId(Long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the member name of this team member entry.
	 *
	 * @param memberName the member name of this team member entry
	 */
	@Override
	public void setMemberName(String memberName) {
		model.setMemberName(memberName);
	}

	/**
	 * Sets the primary key of this team member entry.
	 *
	 * @param primaryKey the primary key of this team member entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the team ID of this team member entry.
	 *
	 * @param teamId the team ID of this team member entry
	 */
	@Override
	public void setTeamId(long teamId) {
		model.setTeamId(teamId);
	}

	/**
	 * Sets the team member ID of this team member entry.
	 *
	 * @param teamMemberId the team member ID of this team member entry
	 */
	@Override
	public void setTeamMemberId(long teamMemberId) {
		model.setTeamMemberId(teamMemberId);
	}

	/**
	 * Sets the uuid of this team member entry.
	 *
	 * @param uuid the uuid of this team member entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected TeamMemberEntryWrapper wrap(TeamMemberEntry teamMemberEntry) {
		return new TeamMemberEntryWrapper(teamMemberEntry);
	}

}