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

package com.swork.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.service.model.PetEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PetEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PetEntryCacheModel
	implements CacheModel<PetEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PetEntryCacheModel)) {
			return false;
		}

		PetEntryCacheModel petEntryCacheModel = (PetEntryCacheModel)object;

		if (petId == petEntryCacheModel.petId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, petId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", petId=");
		sb.append(petId);
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
		sb.append(", price=");
		sb.append(price);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PetEntry toEntityModel() {
		PetEntryImpl petEntryImpl = new PetEntryImpl();

		if (uuid == null) {
			petEntryImpl.setUuid("");
		}
		else {
			petEntryImpl.setUuid(uuid);
		}

		petEntryImpl.setPetId(petId);
		petEntryImpl.setGroupId(groupId);
		petEntryImpl.setCompanyId(companyId);
		petEntryImpl.setUserId(userId);

		if (userName == null) {
			petEntryImpl.setUserName("");
		}
		else {
			petEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			petEntryImpl.setCreateDate(null);
		}
		else {
			petEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			petEntryImpl.setModifiedDate(null);
		}
		else {
			petEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			petEntryImpl.setName("");
		}
		else {
			petEntryImpl.setName(name);
		}

		petEntryImpl.setPrice(price);

		petEntryImpl.resetOriginalValues();

		return petEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		petId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		price = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(petId);

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

		objectOutput.writeLong(price);
	}

	public String uuid;
	public long petId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long price;

}