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

package com.swork.common.file.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.common.file.model.FileManagerEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FileManagerEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FileManagerEntryCacheModel
	implements CacheModel<FileManagerEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FileManagerEntryCacheModel)) {
			return false;
		}

		FileManagerEntryCacheModel fileManagerEntryCacheModel =
			(FileManagerEntryCacheModel)object;

		if (id == fileManagerEntryCacheModel.id) {
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
		StringBundler sb = new StringBundler(41);

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
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", parentCode=");
		sb.append(parentCode);
		sb.append(", fileType=");
		sb.append(fileType);
		sb.append(", type=");
		sb.append(type);
		sb.append(", pkType=");
		sb.append(pkType);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", moduleId=");
		sb.append(moduleId);
		sb.append(", appId=");
		sb.append(appId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FileManagerEntry toEntityModel() {
		FileManagerEntryImpl fileManagerEntryImpl = new FileManagerEntryImpl();

		if (uuid == null) {
			fileManagerEntryImpl.setUuid("");
		}
		else {
			fileManagerEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			fileManagerEntryImpl.setExternalReferenceCode("");
		}
		else {
			fileManagerEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		fileManagerEntryImpl.setId(id);
		fileManagerEntryImpl.setGroupId(groupId);
		fileManagerEntryImpl.setCompanyId(companyId);
		fileManagerEntryImpl.setUserId(userId);

		if (userName == null) {
			fileManagerEntryImpl.setUserName("");
		}
		else {
			fileManagerEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			fileManagerEntryImpl.setCreateDate(null);
		}
		else {
			fileManagerEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fileManagerEntryImpl.setModifiedDate(null);
		}
		else {
			fileManagerEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		fileManagerEntryImpl.setCustomerId(customerId);
		fileManagerEntryImpl.setCreatorId(creatorId);
		fileManagerEntryImpl.setFileId(fileId);

		if (parentCode == null) {
			fileManagerEntryImpl.setParentCode("");
		}
		else {
			fileManagerEntryImpl.setParentCode(parentCode);
		}

		if (fileType == null) {
			fileManagerEntryImpl.setFileType("");
		}
		else {
			fileManagerEntryImpl.setFileType(fileType);
		}

		if (type == null) {
			fileManagerEntryImpl.setType("");
		}
		else {
			fileManagerEntryImpl.setType(type);
		}

		if (pkType == null) {
			fileManagerEntryImpl.setPkType("");
		}
		else {
			fileManagerEntryImpl.setPkType(pkType);
		}

		if (fileName == null) {
			fileManagerEntryImpl.setFileName("");
		}
		else {
			fileManagerEntryImpl.setFileName(fileName);
		}

		if (fileSize == null) {
			fileManagerEntryImpl.setFileSize("");
		}
		else {
			fileManagerEntryImpl.setFileSize(fileSize);
		}

		if (moduleId == null) {
			fileManagerEntryImpl.setModuleId("");
		}
		else {
			fileManagerEntryImpl.setModuleId(moduleId);
		}

		if (appId == null) {
			fileManagerEntryImpl.setAppId("");
		}
		else {
			fileManagerEntryImpl.setAppId(appId);
		}

		fileManagerEntryImpl.resetOriginalValues();

		return fileManagerEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();

		creatorId = objectInput.readLong();

		fileId = objectInput.readLong();
		parentCode = objectInput.readUTF();
		fileType = objectInput.readUTF();
		type = objectInput.readUTF();
		pkType = objectInput.readUTF();
		fileName = objectInput.readUTF();
		fileSize = objectInput.readUTF();
		moduleId = objectInput.readUTF();
		appId = objectInput.readUTF();
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

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(customerId);

		objectOutput.writeLong(creatorId);

		objectOutput.writeLong(fileId);

		if (parentCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(parentCode);
		}

		if (fileType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileType);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (pkType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pkType);
		}

		if (fileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (fileSize == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileSize);
		}

		if (moduleId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moduleId);
		}

		if (appId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appId);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public long creatorId;
	public long fileId;
	public String parentCode;
	public String fileType;
	public String type;
	public String pkType;
	public String fileName;
	public String fileSize;
	public String moduleId;
	public String appId;

}