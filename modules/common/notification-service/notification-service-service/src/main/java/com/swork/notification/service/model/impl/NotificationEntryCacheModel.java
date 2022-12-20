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

package com.swork.notification.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.notification.service.model.NotificationEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NotificationEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NotificationEntryCacheModel
	implements CacheModel<NotificationEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NotificationEntryCacheModel)) {
			return false;
		}

		NotificationEntryCacheModel notificationEntryCacheModel =
			(NotificationEntryCacheModel)object;

		if (id == notificationEntryCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", editorId=");
		sb.append(editorId);
		sb.append(", category=");
		sb.append(category);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", receiverId=");
		sb.append(receiverId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NotificationEntry toEntityModel() {
		NotificationEntryImpl notificationEntryImpl =
			new NotificationEntryImpl();

		if (uuid == null) {
			notificationEntryImpl.setUuid("");
		}
		else {
			notificationEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			notificationEntryImpl.setExternalReferenceCode("");
		}
		else {
			notificationEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		notificationEntryImpl.setId(id);
		notificationEntryImpl.setGroupId(groupId);
		notificationEntryImpl.setCompanyId(companyId);
		notificationEntryImpl.setAccountId(accountId);

		if (userName == null) {
			notificationEntryImpl.setUserName("");
		}
		else {
			notificationEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			notificationEntryImpl.setCreateDate(null);
		}
		else {
			notificationEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			notificationEntryImpl.setModifiedDate(null);
		}
		else {
			notificationEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		notificationEntryImpl.setEditorId(editorId);

		if (category == null) {
			notificationEntryImpl.setCategory("");
		}
		else {
			notificationEntryImpl.setCategory(category);
		}

		if (name == null) {
			notificationEntryImpl.setName("");
		}
		else {
			notificationEntryImpl.setName(name);
		}

		if (description == null) {
			notificationEntryImpl.setDescription("");
		}
		else {
			notificationEntryImpl.setDescription(description);
		}

		if (status == null) {
			notificationEntryImpl.setStatus("");
		}
		else {
			notificationEntryImpl.setStatus(status);
		}

		notificationEntryImpl.setReceiverId(receiverId);
		notificationEntryImpl.setProjectId(projectId);

		notificationEntryImpl.resetOriginalValues();

		return notificationEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		accountId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		editorId = objectInput.readLong();
		category = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		status = objectInput.readUTF();

		receiverId = objectInput.readLong();

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

		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(accountId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(editorId);

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}

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

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(receiverId);

		objectOutput.writeLong(projectId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long id;
	public long groupId;
	public long companyId;
	public long accountId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long editorId;
	public String category;
	public String name;
	public String description;
	public String status;
	public long receiverId;
	public long projectId;

}