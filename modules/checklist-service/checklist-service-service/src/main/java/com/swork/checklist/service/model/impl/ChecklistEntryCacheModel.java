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

package com.swork.checklist.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.checklist.service.model.ChecklistEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChecklistEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChecklistEntryCacheModel
	implements CacheModel<ChecklistEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChecklistEntryCacheModel)) {
			return false;
		}

		ChecklistEntryCacheModel checklistEntryCacheModel =
			(ChecklistEntryCacheModel)object;

		if (checklistId == checklistEntryCacheModel.checklistId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, checklistId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", checklistId=");
		sb.append(checklistId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChecklistEntry toEntityModel() {
		ChecklistEntryImpl checklistEntryImpl = new ChecklistEntryImpl();

		if (uuid == null) {
			checklistEntryImpl.setUuid("");
		}
		else {
			checklistEntryImpl.setUuid(uuid);
		}

		checklistEntryImpl.setChecklistId(checklistId);
		checklistEntryImpl.setGroupId(groupId);
		checklistEntryImpl.setCompanyId(companyId);
		checklistEntryImpl.setUserId(userId);

		if (userName == null) {
			checklistEntryImpl.setUserName("");
		}
		else {
			checklistEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			checklistEntryImpl.setCreateDate(null);
		}
		else {
			checklistEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			checklistEntryImpl.setModifiedDate(null);
		}
		else {
			checklistEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			checklistEntryImpl.setName("");
		}
		else {
			checklistEntryImpl.setName(name);
		}

		checklistEntryImpl.setTaskId(taskId);
		checklistEntryImpl.setStatus(status);

		checklistEntryImpl.resetOriginalValues();

		return checklistEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		checklistId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		taskId = objectInput.readLong();

		status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(checklistId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(taskId);

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long checklistId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long taskId;
	public boolean status;

}