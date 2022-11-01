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

package com.swork.account.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.account.service.model.AccountPermissionEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AccountPermissionEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AccountPermissionEntryCacheModel
	implements CacheModel<AccountPermissionEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AccountPermissionEntryCacheModel)) {
			return false;
		}

		AccountPermissionEntryCacheModel accountPermissionEntryCacheModel =
			(AccountPermissionEntryCacheModel)object;

		if (id == accountPermissionEntryCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", permissionId=");
		sb.append(permissionId);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AccountPermissionEntry toEntityModel() {
		AccountPermissionEntryImpl accountPermissionEntryImpl =
			new AccountPermissionEntryImpl();

		if (uuid == null) {
			accountPermissionEntryImpl.setUuid("");
		}
		else {
			accountPermissionEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			accountPermissionEntryImpl.setExternalReferenceCode("");
		}
		else {
			accountPermissionEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		accountPermissionEntryImpl.setId(id);
		accountPermissionEntryImpl.setCompanyId(companyId);
		accountPermissionEntryImpl.setPermissionId(permissionId);
		accountPermissionEntryImpl.setAccountId(accountId);

		accountPermissionEntryImpl.resetOriginalValues();

		return accountPermissionEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		id = objectInput.readLong();

		companyId = objectInput.readLong();

		permissionId = objectInput.readLong();

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

		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(permissionId);

		objectOutput.writeLong(accountId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long id;
	public long companyId;
	public long permissionId;
	public long accountId;

}