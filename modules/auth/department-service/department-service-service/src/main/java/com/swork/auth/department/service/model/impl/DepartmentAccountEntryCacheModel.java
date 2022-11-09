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

import com.swork.auth.department.service.model.DepartmentAccountEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DepartmentAccountEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DepartmentAccountEntryCacheModel
	implements CacheModel<DepartmentAccountEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DepartmentAccountEntryCacheModel)) {
			return false;
		}

		DepartmentAccountEntryCacheModel departmentAccountEntryCacheModel =
			(DepartmentAccountEntryCacheModel)object;

		if (departmentAccountId ==
				departmentAccountEntryCacheModel.departmentAccountId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, departmentAccountId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", departmentAccountId=");
		sb.append(departmentAccountId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DepartmentAccountEntry toEntityModel() {
		DepartmentAccountEntryImpl departmentAccountEntryImpl =
			new DepartmentAccountEntryImpl();

		if (uuid == null) {
			departmentAccountEntryImpl.setUuid("");
		}
		else {
			departmentAccountEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			departmentAccountEntryImpl.setExternalReferenceCode("");
		}
		else {
			departmentAccountEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		departmentAccountEntryImpl.setDepartmentAccountId(departmentAccountId);
		departmentAccountEntryImpl.setGroupId(groupId);
		departmentAccountEntryImpl.setCompanyId(companyId);
		departmentAccountEntryImpl.setDepartmentId(departmentId);
		departmentAccountEntryImpl.setAccountId(accountId);

		departmentAccountEntryImpl.resetOriginalValues();

		return departmentAccountEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		departmentAccountId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		departmentId = objectInput.readLong();

		accountId = objectInput.readLong();
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

		objectOutput.writeLong(departmentAccountId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(departmentId);

		objectOutput.writeLong(accountId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long departmentAccountId;
	public long groupId;
	public long companyId;
	public long departmentId;
	public long accountId;

}