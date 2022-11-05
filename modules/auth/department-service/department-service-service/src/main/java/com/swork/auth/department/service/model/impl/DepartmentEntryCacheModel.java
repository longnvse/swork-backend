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

package com.swork.auth.department.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.auth.department.service.model.DepartmentEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DepartmentEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DepartmentEntryCacheModel
	implements CacheModel<DepartmentEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DepartmentEntryCacheModel)) {
			return false;
		}

		DepartmentEntryCacheModel departmentEntryCacheModel =
			(DepartmentEntryCacheModel)object;

		if (departmentId == departmentEntryCacheModel.departmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, departmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedId=");
		sb.append(modifiedId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", businessId=");
		sb.append(businessId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DepartmentEntry toEntityModel() {
		DepartmentEntryImpl departmentEntryImpl = new DepartmentEntryImpl();

		if (uuid == null) {
			departmentEntryImpl.setUuid("");
		}
		else {
			departmentEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			departmentEntryImpl.setExternalReferenceCode("");
		}
		else {
			departmentEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		departmentEntryImpl.setDepartmentId(departmentId);
		departmentEntryImpl.setGroupId(groupId);
		departmentEntryImpl.setCompanyId(companyId);
		departmentEntryImpl.setAccountId(accountId);

		if (createDate == Long.MIN_VALUE) {
			departmentEntryImpl.setCreateDate(null);
		}
		else {
			departmentEntryImpl.setCreateDate(new Date(createDate));
		}

		departmentEntryImpl.setModifiedId(modifiedId);

		if (modifiedDate == Long.MIN_VALUE) {
			departmentEntryImpl.setModifiedDate(null);
		}
		else {
			departmentEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		departmentEntryImpl.setBusinessId(businessId);

		if (name == null) {
			departmentEntryImpl.setName("");
		}
		else {
			departmentEntryImpl.setName(name);
		}

		departmentEntryImpl.resetOriginalValues();

		return departmentEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		departmentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		accountId = objectInput.readLong();
		createDate = objectInput.readLong();

		modifiedId = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		businessId = objectInput.readLong();
		name = objectInput.readUTF();
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

		objectOutput.writeLong(departmentId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(accountId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(modifiedId);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(businessId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long departmentId;
	public long groupId;
	public long companyId;
	public long accountId;
	public long createDate;
	public long modifiedId;
	public long modifiedDate;
	public long businessId;
	public String name;

}