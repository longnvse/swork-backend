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

package com.swork.core.resource.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.core.resource.service.model.TeamMemberEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TeamMemberEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TeamMemberEntryCacheModel
	implements CacheModel<TeamMemberEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TeamMemberEntryCacheModel)) {
			return false;
		}

		TeamMemberEntryCacheModel teamMemberEntryCacheModel =
			(TeamMemberEntryCacheModel)object;

		if (teamMemberTaskId == teamMemberEntryCacheModel.teamMemberTaskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, teamMemberTaskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", teamMemberTaskId=");
		sb.append(teamMemberTaskId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", memberName=");
		sb.append(memberName);
		sb.append(", isAdmin=");
		sb.append(isAdmin);
		sb.append(", teamId=");
		sb.append(teamId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TeamMemberEntry toEntityModel() {
		TeamMemberEntryImpl teamMemberEntryImpl = new TeamMemberEntryImpl();

		if (uuid == null) {
			teamMemberEntryImpl.setUuid("");
		}
		else {
			teamMemberEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			teamMemberEntryImpl.setExternalReferenceCode("");
		}
		else {
			teamMemberEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		teamMemberEntryImpl.setTeamMemberTaskId(teamMemberTaskId);
		teamMemberEntryImpl.setCompanyId(companyId);
		teamMemberEntryImpl.setMemberId(memberId);

		if (memberName == null) {
			teamMemberEntryImpl.setMemberName("");
		}
		else {
			teamMemberEntryImpl.setMemberName(memberName);
		}

		teamMemberEntryImpl.setIsAdmin(isAdmin);
		teamMemberEntryImpl.setTeamId(teamId);

		teamMemberEntryImpl.resetOriginalValues();

		return teamMemberEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		teamMemberTaskId = objectInput.readLong();

		companyId = objectInput.readLong();

		memberId = objectInput.readLong();
		memberName = objectInput.readUTF();

		isAdmin = objectInput.readBoolean();

		teamId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (externalReferenceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalReferenceCode);
		}

		objectOutput.writeLong(teamMemberTaskId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(memberId);

		if (memberName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberName);
		}

		objectOutput.writeBoolean(isAdmin);

		objectOutput.writeLong(teamId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long teamMemberTaskId;
	public long companyId;
	public long memberId;
	public String memberName;
	public boolean isAdmin;
	public long teamId;

}