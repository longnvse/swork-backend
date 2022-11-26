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

import com.swork.core.resource.service.model.TeamEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TeamEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TeamEntryCacheModel
	implements CacheModel<TeamEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TeamEntryCacheModel)) {
			return false;
		}

		TeamEntryCacheModel teamEntryCacheModel = (TeamEntryCacheModel)object;

		if (teamId == teamEntryCacheModel.teamId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, teamId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", teamId=");
		sb.append(teamId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", businessId=");
		sb.append(businessId);
		sb.append(", modifiedId=");
		sb.append(modifiedId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", phaseId=");
		sb.append(phaseId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", totalIncoming=");
		sb.append(totalIncoming);
		sb.append(", totalSpending=");
		sb.append(totalSpending);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TeamEntry toEntityModel() {
		TeamEntryImpl teamEntryImpl = new TeamEntryImpl();

		if (uuid == null) {
			teamEntryImpl.setUuid("");
		}
		else {
			teamEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			teamEntryImpl.setExternalReferenceCode("");
		}
		else {
			teamEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		teamEntryImpl.setTeamId(teamId);
		teamEntryImpl.setGroupId(groupId);
		teamEntryImpl.setCompanyId(companyId);
		teamEntryImpl.setAccountId(accountId);

		if (createDate == Long.MIN_VALUE) {
			teamEntryImpl.setCreateDate(null);
		}
		else {
			teamEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			teamEntryImpl.setModifiedDate(null);
		}
		else {
			teamEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		teamEntryImpl.setBusinessId(businessId);
		teamEntryImpl.setModifiedId(modifiedId);

		if (name == null) {
			teamEntryImpl.setName("");
		}
		else {
			teamEntryImpl.setName(name);
		}

		if (description == null) {
			teamEntryImpl.setDescription("");
		}
		else {
			teamEntryImpl.setDescription(description);
		}

		teamEntryImpl.setIsActive(isActive);
		teamEntryImpl.setPhaseId(phaseId);
		teamEntryImpl.setProjectId(projectId);
		teamEntryImpl.setTotalIncoming(totalIncoming);
		teamEntryImpl.setTotalSpending(totalSpending);

		teamEntryImpl.resetOriginalValues();

		return teamEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		teamId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		accountId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		businessId = objectInput.readLong();

		modifiedId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		isActive = objectInput.readBoolean();

		phaseId = objectInput.readLong();

		projectId = objectInput.readLong();

		totalIncoming = objectInput.readLong();

		totalSpending = objectInput.readLong();
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

		objectOutput.writeLong(teamId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(accountId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(businessId);

		objectOutput.writeLong(modifiedId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(isActive);

		objectOutput.writeLong(phaseId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(totalIncoming);

		objectOutput.writeLong(totalSpending);
	}

	public String uuid;
	public String externalReferenceCode;
	public long teamId;
	public long groupId;
	public long companyId;
	public long accountId;
	public long createDate;
	public long modifiedDate;
	public long businessId;
	public long modifiedId;
	public String name;
	public String description;
	public boolean isActive;
	public long phaseId;
	public long projectId;
	public long totalIncoming;
	public long totalSpending;

}