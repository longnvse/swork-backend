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

package com.swork.core.work.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.core.work.service.model.WorkEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkEntryCacheModel
	implements CacheModel<WorkEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkEntryCacheModel)) {
			return false;
		}

		WorkEntryCacheModel workEntryCacheModel = (WorkEntryCacheModel)object;

		if (workId == workEntryCacheModel.workId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", workId=");
		sb.append(workId);
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
		sb.append(", businessId=");
		sb.append(businessId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", phaseId=");
		sb.append(phaseId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", parentReferenceCode=");
		sb.append(parentReferenceCode);
		sb.append(", progress=");
		sb.append(progress);
		sb.append(", name=");
		sb.append(name);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", actualStartDate=");
		sb.append(actualStartDate);
		sb.append(", actualEndDate=");
		sb.append(actualEndDate);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", percentage=");
		sb.append(percentage);
		sb.append(", progressType=");
		sb.append(progressType);
		sb.append(", unit=");
		sb.append(unit);
		sb.append(", incompleteTask=");
		sb.append(incompleteTask);
		sb.append(", complete=");
		sb.append(complete);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkEntry toEntityModel() {
		WorkEntryImpl workEntryImpl = new WorkEntryImpl();

		if (uuid == null) {
			workEntryImpl.setUuid("");
		}
		else {
			workEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			workEntryImpl.setExternalReferenceCode("");
		}
		else {
			workEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		workEntryImpl.setWorkId(workId);
		workEntryImpl.setGroupId(groupId);
		workEntryImpl.setCompanyId(companyId);
		workEntryImpl.setAccountId(accountId);

		if (createDate == Long.MIN_VALUE) {
			workEntryImpl.setCreateDate(null);
		}
		else {
			workEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workEntryImpl.setModifiedDate(null);
		}
		else {
			workEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		workEntryImpl.setModifiedId(modifiedId);
		workEntryImpl.setBusinessId(businessId);
		workEntryImpl.setProjectId(projectId);
		workEntryImpl.setPhaseId(phaseId);
		workEntryImpl.setParentId(parentId);

		if (parentReferenceCode == null) {
			workEntryImpl.setParentReferenceCode("");
		}
		else {
			workEntryImpl.setParentReferenceCode(parentReferenceCode);
		}

		workEntryImpl.setProgress(progress);

		if (name == null) {
			workEntryImpl.setName("");
		}
		else {
			workEntryImpl.setName(name);
		}

		if (startDate == Long.MIN_VALUE) {
			workEntryImpl.setStartDate(null);
		}
		else {
			workEntryImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			workEntryImpl.setEndDate(null);
		}
		else {
			workEntryImpl.setEndDate(new Date(endDate));
		}

		if (actualStartDate == Long.MIN_VALUE) {
			workEntryImpl.setActualStartDate(null);
		}
		else {
			workEntryImpl.setActualStartDate(new Date(actualStartDate));
		}

		if (actualEndDate == Long.MIN_VALUE) {
			workEntryImpl.setActualEndDate(null);
		}
		else {
			workEntryImpl.setActualEndDate(new Date(actualEndDate));
		}

		if (description == null) {
			workEntryImpl.setDescription("");
		}
		else {
			workEntryImpl.setDescription(description);
		}

		if (status == null) {
			workEntryImpl.setStatus("");
		}
		else {
			workEntryImpl.setStatus(status);
		}

		workEntryImpl.setPercentage(percentage);

		if (progressType == null) {
			workEntryImpl.setProgressType("");
		}
		else {
			workEntryImpl.setProgressType(progressType);
		}

		if (unit == null) {
			workEntryImpl.setUnit("");
		}
		else {
			workEntryImpl.setUnit(unit);
		}

		workEntryImpl.setIncompleteTask(incompleteTask);
		workEntryImpl.setComplete(complete);

		workEntryImpl.resetOriginalValues();

		return workEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		workId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		accountId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedId = objectInput.readLong();

		businessId = objectInput.readLong();

		projectId = objectInput.readLong();

		phaseId = objectInput.readLong();

		parentId = objectInput.readLong();
		parentReferenceCode = objectInput.readUTF();

		progress = objectInput.readLong();
		name = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		actualStartDate = objectInput.readLong();
		actualEndDate = objectInput.readLong();
		description = objectInput.readUTF();
		status = objectInput.readUTF();

		percentage = objectInput.readDouble();
		progressType = objectInput.readUTF();
		unit = objectInput.readUTF();

		incompleteTask = objectInput.readDouble();

		complete = objectInput.readDouble();
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

		objectOutput.writeLong(workId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(accountId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedId);

		objectOutput.writeLong(businessId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(phaseId);

		objectOutput.writeLong(parentId);

		if (parentReferenceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(parentReferenceCode);
		}

		objectOutput.writeLong(progress);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(actualStartDate);
		objectOutput.writeLong(actualEndDate);

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

		objectOutput.writeDouble(percentage);

		if (progressType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(progressType);
		}

		if (unit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unit);
		}

		objectOutput.writeDouble(incompleteTask);

		objectOutput.writeDouble(complete);
	}

	public String uuid;
	public String externalReferenceCode;
	public long workId;
	public long groupId;
	public long companyId;
	public long accountId;
	public long createDate;
	public long modifiedDate;
	public long modifiedId;
	public long businessId;
	public long projectId;
	public long phaseId;
	public long parentId;
	public String parentReferenceCode;
	public long progress;
	public String name;
	public long startDate;
	public long endDate;
	public long actualStartDate;
	public long actualEndDate;
	public String description;
	public String status;
	public double percentage;
	public String progressType;
	public String unit;
	public double incompleteTask;
	public double complete;

}