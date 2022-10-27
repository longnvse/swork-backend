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

import com.swork.account.service.model.AccountPermisionEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AccountPermisionEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AccountPermisionEntryCacheModel
	implements CacheModel<AccountPermisionEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AccountPermisionEntryCacheModel)) {
			return false;
		}

		AccountPermisionEntryCacheModel accountPermisionEntryCacheModel =
			(AccountPermisionEntryCacheModel)object;

		if (id == accountPermisionEntryCacheModel.id) {
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
		sb.append(", permisionId=");
		sb.append(permisionId);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AccountPermisionEntry toEntityModel() {
		AccountPermisionEntryImpl accountPermisionEntryImpl =
			new AccountPermisionEntryImpl();

		if (uuid == null) {
			accountPermisionEntryImpl.setUuid("");
		}
		else {
			accountPermisionEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			accountPermisionEntryImpl.setExternalReferenceCode("");
		}
		else {
			accountPermisionEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		accountPermisionEntryImpl.setId(id);
		accountPermisionEntryImpl.setCompanyId(companyId);
		accountPermisionEntryImpl.setPermisionId(permisionId);
		accountPermisionEntryImpl.setAccountId(accountId);

		accountPermisionEntryImpl.resetOriginalValues();

		return accountPermisionEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		id = objectInput.readLong();

		companyId = objectInput.readLong();

		permisionId = objectInput.readLong();

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

		objectOutput.writeLong(permisionId);

		objectOutput.writeLong(accountId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long id;
	public long companyId;
	public long permisionId;
	public long accountId;

}