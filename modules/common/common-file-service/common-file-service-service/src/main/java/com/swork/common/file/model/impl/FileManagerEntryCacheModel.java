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
		StringBundler sb = new StringBundler(39);

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
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", businessId=");
		sb.append(businessId);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", fileType=");
		sb.append(fileType);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", mimeType=");
		sb.append(mimeType);
		sb.append(", moduleId=");
		sb.append(moduleId);
		sb.append(", appId=");
		sb.append(appId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", phaseId=");
		sb.append(phaseId);
		sb.append(", workId=");
		sb.append(workId);
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
		fileManagerEntryImpl.setAccountId(accountId);

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

		fileManagerEntryImpl.setBusinessId(businessId);
		fileManagerEntryImpl.setFileId(fileId);

		if (fileType == null) {
			fileManagerEntryImpl.setFileType("");
		}
		else {
			fileManagerEntryImpl.setFileType(fileType);
		}

		if (fileName == null) {
			fileManagerEntryImpl.setFileName("");
		}
		else {
			fileManagerEntryImpl.setFileName(fileName);
		}

		fileManagerEntryImpl.setFileSize(fileSize);

		if (mimeType == null) {
			fileManagerEntryImpl.setMimeType("");
		}
		else {
			fileManagerEntryImpl.setMimeType(mimeType);
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

		fileManagerEntryImpl.setProjectId(projectId);
		fileManagerEntryImpl.setPhaseId(phaseId);
		fileManagerEntryImpl.setWorkId(workId);

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

		accountId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		businessId = objectInput.readLong();

		fileId = objectInput.readLong();
		fileType = objectInput.readUTF();
		fileName = objectInput.readUTF();

		fileSize = objectInput.readLong();
		mimeType = objectInput.readUTF();
		moduleId = objectInput.readUTF();
		appId = objectInput.readUTF();

		projectId = objectInput.readLong();

		phaseId = objectInput.readLong();

		workId = objectInput.readLong();
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
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(businessId);

		objectOutput.writeLong(fileId);

		if (fileType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileType);
		}

		if (fileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		objectOutput.writeLong(fileSize);

		if (mimeType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mimeType);
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

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(phaseId);

		objectOutput.writeLong(workId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long id;
	public long groupId;
	public long companyId;
	public long accountId;
	public long createDate;
	public long modifiedDate;
	public long businessId;
	public long fileId;
	public String fileType;
	public String fileName;
	public long fileSize;
	public String mimeType;
	public String moduleId;
	public String appId;
	public long projectId;
	public long phaseId;
	public long workId;

}