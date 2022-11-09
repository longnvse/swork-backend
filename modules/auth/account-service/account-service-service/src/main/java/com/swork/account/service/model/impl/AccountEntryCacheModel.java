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

import com.swork.account.service.model.AccountEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AccountEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AccountEntryCacheModel
	implements CacheModel<AccountEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AccountEntryCacheModel)) {
			return false;
		}

		AccountEntryCacheModel accountEntryCacheModel =
			(AccountEntryCacheModel)object;

		if (accountId == accountEntryCacheModel.accountId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, accountId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", username=");
		sb.append(username);
		sb.append(", password=");
		sb.append(password);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", email=");
		sb.append(email);
		sb.append(", address=");
		sb.append(address);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", businessId=");
		sb.append(businessId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AccountEntry toEntityModel() {
		AccountEntryImpl accountEntryImpl = new AccountEntryImpl();

		if (uuid == null) {
			accountEntryImpl.setUuid("");
		}
		else {
			accountEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			accountEntryImpl.setExternalReferenceCode("");
		}
		else {
			accountEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		accountEntryImpl.setAccountId(accountId);
		accountEntryImpl.setGroupId(groupId);
		accountEntryImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			accountEntryImpl.setCreateDate(null);
		}
		else {
			accountEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			accountEntryImpl.setModifiedDate(null);
		}
		else {
			accountEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		accountEntryImpl.setCreatorId(creatorId);

		if (username == null) {
			accountEntryImpl.setUsername("");
		}
		else {
			accountEntryImpl.setUsername(username);
		}

		if (password == null) {
			accountEntryImpl.setPassword("");
		}
		else {
			accountEntryImpl.setPassword(password);
		}

		if (fullName == null) {
			accountEntryImpl.setFullName("");
		}
		else {
			accountEntryImpl.setFullName(fullName);
		}

		if (phoneNumber == null) {
			accountEntryImpl.setPhoneNumber("");
		}
		else {
			accountEntryImpl.setPhoneNumber(phoneNumber);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			accountEntryImpl.setDateOfBirth(null);
		}
		else {
			accountEntryImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (email == null) {
			accountEntryImpl.setEmail("");
		}
		else {
			accountEntryImpl.setEmail(email);
		}

		if (address == null) {
			accountEntryImpl.setAddress("");
		}
		else {
			accountEntryImpl.setAddress(address);
		}

		accountEntryImpl.setDepartmentId(departmentId);

		if (status == null) {
			accountEntryImpl.setStatus("");
		}
		else {
			accountEntryImpl.setStatus(status);
		}

		accountEntryImpl.setBusinessId(businessId);

		accountEntryImpl.resetOriginalValues();

		return accountEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		accountId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		creatorId = objectInput.readLong();
		username = objectInput.readUTF();
		password = objectInput.readUTF();
		fullName = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();
		email = objectInput.readUTF();
		address = objectInput.readUTF();

		departmentId = objectInput.readLong();
		status = objectInput.readUTF();

		businessId = objectInput.readLong();
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

		objectOutput.writeLong(accountId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(creatorId);

		if (username == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(username);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		objectOutput.writeLong(dateOfBirth);

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeLong(departmentId);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(businessId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long accountId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long creatorId;
	public String username;
	public String password;
	public String fullName;
	public String phoneNumber;
	public long dateOfBirth;
	public String email;
	public String address;
	public long departmentId;
	public String status;
	public long businessId;

}