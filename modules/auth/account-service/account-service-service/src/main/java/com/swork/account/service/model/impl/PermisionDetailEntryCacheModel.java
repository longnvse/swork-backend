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

import com.swork.account.service.model.PermisionDetailEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PermisionDetailEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PermisionDetailEntryCacheModel
	implements CacheModel<PermisionDetailEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PermisionDetailEntryCacheModel)) {
			return false;
		}

		PermisionDetailEntryCacheModel permisionDetailEntryCacheModel =
			(PermisionDetailEntryCacheModel)object;

		if (id == permisionDetailEntryCacheModel.id) {
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
		sb.append(", actionCode=");
		sb.append(actionCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PermisionDetailEntry toEntityModel() {
		PermisionDetailEntryImpl permisionDetailEntryImpl =
			new PermisionDetailEntryImpl();

		if (uuid == null) {
			permisionDetailEntryImpl.setUuid("");
		}
		else {
			permisionDetailEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			permisionDetailEntryImpl.setExternalReferenceCode("");
		}
		else {
			permisionDetailEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		permisionDetailEntryImpl.setId(id);
		permisionDetailEntryImpl.setCompanyId(companyId);
		permisionDetailEntryImpl.setPermisionId(permisionId);

		if (actionCode == null) {
			permisionDetailEntryImpl.setActionCode("");
		}
		else {
			permisionDetailEntryImpl.setActionCode(actionCode);
		}

		permisionDetailEntryImpl.resetOriginalValues();

		return permisionDetailEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		id = objectInput.readLong();

		companyId = objectInput.readLong();

		permisionId = objectInput.readLong();
		actionCode = objectInput.readUTF();
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

		if (actionCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actionCode);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long id;
	public long companyId;
	public long permisionId;
	public String actionCode;

}