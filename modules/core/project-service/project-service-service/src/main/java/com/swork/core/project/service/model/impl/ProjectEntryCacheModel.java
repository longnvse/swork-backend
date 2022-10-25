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

package com.swork.core.project.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.core.project.service.model.ProjectEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProjectEntryCacheModel
	implements CacheModel<ProjectEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectEntryCacheModel)) {
			return false;
		}

		ProjectEntryCacheModel projectEntryCacheModel =
			(ProjectEntryCacheModel)object;

		if (projectId == projectEntryCacheModel.projectId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", projectId=");
		sb.append(projectId);
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
		sb.append(", modifiedId=");
		sb.append(modifiedId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", budget=");
		sb.append(budget);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", progress=");
		sb.append(progress);
		sb.append(", actualTime=");
		sb.append(actualTime);
		sb.append(", actualStart=");
		sb.append(actualStart);
		sb.append(", progressType=");
		sb.append(progressType);
		sb.append(", businessId=");
		sb.append(businessId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectEntry toEntityModel() {
		ProjectEntryImpl projectEntryImpl = new ProjectEntryImpl();

		if (uuid == null) {
			projectEntryImpl.setUuid("");
		}
		else {
			projectEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			projectEntryImpl.setExternalReferenceCode("");
		}
		else {
			projectEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		projectEntryImpl.setProjectId(projectId);
		projectEntryImpl.setGroupId(groupId);
		projectEntryImpl.setCompanyId(companyId);
		projectEntryImpl.setAccountId(accountId);

		if (createDate == Long.MIN_VALUE) {
			projectEntryImpl.setCreateDate(null);
		}
		else {
			projectEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectEntryImpl.setModifiedDate(null);
		}
		else {
			projectEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectEntryImpl.setModifiedId(modifiedId);

		if (name == null) {
			projectEntryImpl.setName("");
		}
		else {
			projectEntryImpl.setName(name);
		}

		if (code == null) {
			projectEntryImpl.setCode("");
		}
		else {
			projectEntryImpl.setCode(code);
		}

		if (startDate == Long.MIN_VALUE) {
			projectEntryImpl.setStartDate(null);
		}
		else {
			projectEntryImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			projectEntryImpl.setEndDate(null);
		}
		else {
			projectEntryImpl.setEndDate(new Date(endDate));
		}

		projectEntryImpl.setBudget(budget);

		if (description == null) {
			projectEntryImpl.setDescription("");
		}
		else {
			projectEntryImpl.setDescription(description);
		}

		if (status == null) {
			projectEntryImpl.setStatus("");
		}
		else {
			projectEntryImpl.setStatus(status);
		}

		projectEntryImpl.setProgress(progress);

		if (actualTime == Long.MIN_VALUE) {
			projectEntryImpl.setActualTime(null);
		}
		else {
			projectEntryImpl.setActualTime(new Date(actualTime));
		}

		if (actualStart == Long.MIN_VALUE) {
			projectEntryImpl.setActualStart(null);
		}
		else {
			projectEntryImpl.setActualStart(new Date(actualStart));
		}

		if (progressType == null) {
			projectEntryImpl.setProgressType("");
		}
		else {
			projectEntryImpl.setProgressType(progressType);
		}

		projectEntryImpl.setBusinessId(businessId);

		projectEntryImpl.resetOriginalValues();

		return projectEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		projectId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		accountId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedId = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		budget = objectInput.readLong();
		description = objectInput.readUTF();
		status = objectInput.readUTF();

		progress = objectInput.readInt();
		actualTime = objectInput.readLong();
		actualStart = objectInput.readLong();
		progressType = objectInput.readUTF();

		businessId = objectInput.readLong();
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

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(accountId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeLong(budget);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeInt(progress);
		objectOutput.writeLong(actualTime);
		objectOutput.writeLong(actualStart);

		if (progressType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(progressType);
		}

		objectOutput.writeLong(businessId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long projectId;
	public long groupId;
	public long companyId;
	public long accountId;
	public long createDate;
	public long modifiedDate;
	public long modifiedId;
	public String name;
	public String code;
	public long startDate;
	public long endDate;
	public long budget;
	public String description;
	public String status;
	public int progress;
	public long actualTime;
	public long actualStart;
	public String progressType;
	public long businessId;

}