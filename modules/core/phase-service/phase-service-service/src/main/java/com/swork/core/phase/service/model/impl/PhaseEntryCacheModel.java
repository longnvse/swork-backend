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

package com.swork.core.phase.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.core.phase.service.model.PhaseEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PhaseEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PhaseEntryCacheModel
	implements CacheModel<PhaseEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PhaseEntryCacheModel)) {
			return false;
		}

		PhaseEntryCacheModel phaseEntryCacheModel =
			(PhaseEntryCacheModel)object;

		if (phaseId == phaseEntryCacheModel.phaseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, phaseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", phaseId=");
		sb.append(phaseId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", businessId=");
		sb.append(businessId);
		sb.append(", modifiedId=");
		sb.append(modifiedId);
		sb.append(", phaseName=");
		sb.append(phaseName);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", description=");
		sb.append(description);
		sb.append(", progress=");
		sb.append(progress);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PhaseEntry toEntityModel() {
		PhaseEntryImpl phaseEntryImpl = new PhaseEntryImpl();

		if (uuid == null) {
			phaseEntryImpl.setUuid("");
		}
		else {
			phaseEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			phaseEntryImpl.setExternalReferenceCode("");
		}
		else {
			phaseEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		phaseEntryImpl.setPhaseId(phaseId);
		phaseEntryImpl.setGroupId(groupId);
		phaseEntryImpl.setCompanyId(companyId);
		phaseEntryImpl.setCreatorId(creatorId);

		if (createDate == Long.MIN_VALUE) {
			phaseEntryImpl.setCreateDate(null);
		}
		else {
			phaseEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			phaseEntryImpl.setModifiedDate(null);
		}
		else {
			phaseEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		phaseEntryImpl.setBusinessId(businessId);
		phaseEntryImpl.setModifiedId(modifiedId);

		if (phaseName == null) {
			phaseEntryImpl.setPhaseName("");
		}
		else {
			phaseEntryImpl.setPhaseName(phaseName);
		}

		if (startDate == Long.MIN_VALUE) {
			phaseEntryImpl.setStartDate(null);
		}
		else {
			phaseEntryImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			phaseEntryImpl.setEndDate(null);
		}
		else {
			phaseEntryImpl.setEndDate(new Date(endDate));
		}

		if (status == null) {
			phaseEntryImpl.setStatus("");
		}
		else {
			phaseEntryImpl.setStatus(status);
		}

		if (description == null) {
			phaseEntryImpl.setDescription("");
		}
		else {
			phaseEntryImpl.setDescription(description);
		}

		phaseEntryImpl.setProgress(progress);
		phaseEntryImpl.setProjectId(projectId);

		phaseEntryImpl.resetOriginalValues();

		return phaseEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		phaseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		creatorId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		businessId = objectInput.readLong();

		modifiedId = objectInput.readLong();
		phaseName = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		status = objectInput.readUTF();
		description = objectInput.readUTF();

		progress = objectInput.readLong();

		projectId = objectInput.readLong();
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

		objectOutput.writeLong(phaseId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(creatorId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(businessId);

		objectOutput.writeLong(modifiedId);

		if (phaseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phaseName);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(progress);

		objectOutput.writeLong(projectId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long phaseId;
	public long groupId;
	public long companyId;
	public long creatorId;
	public long createDate;
	public long modifiedDate;
	public long businessId;
	public long modifiedId;
	public String phaseName;
	public long startDate;
	public long endDate;
	public String status;
	public String description;
	public long progress;
	public long projectId;

}