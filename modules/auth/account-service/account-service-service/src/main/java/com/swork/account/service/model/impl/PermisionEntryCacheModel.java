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

import com.swork.account.service.model.PermisionEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PermisionEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PermisionEntryCacheModel
	implements CacheModel<PermisionEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PermisionEntryCacheModel)) {
			return false;
		}

		PermisionEntryCacheModel permisionEntryCacheModel =
			(PermisionEntryCacheModel)object;

		if (id == permisionEntryCacheModel.id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PermisionEntry toEntityModel() {
		PermisionEntryImpl permisionEntryImpl = new PermisionEntryImpl();

		if (uuid == null) {
			permisionEntryImpl.setUuid("");
		}
		else {
			permisionEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			permisionEntryImpl.setExternalReferenceCode("");
		}
		else {
			permisionEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		permisionEntryImpl.setId(id);
		permisionEntryImpl.setCompanyId(companyId);

		if (name == null) {
			permisionEntryImpl.setName("");
		}
		else {
			permisionEntryImpl.setName(name);
		}

		permisionEntryImpl.resetOriginalValues();

		return permisionEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		id = objectInput.readLong();

		companyId = objectInput.readLong();
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

		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long id;
	public long companyId;
	public String name;

}