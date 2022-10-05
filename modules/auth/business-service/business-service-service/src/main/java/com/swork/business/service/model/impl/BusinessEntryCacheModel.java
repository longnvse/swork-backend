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

package com.swork.business.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.business.service.model.BusinessEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BusinessEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BusinessEntryCacheModel
	implements CacheModel<BusinessEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BusinessEntryCacheModel)) {
			return false;
		}

		BusinessEntryCacheModel businessEntryCacheModel =
			(BusinessEntryCacheModel)object;

		if (businessId == businessEntryCacheModel.businessId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, businessId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", businessId=");
		sb.append(businessId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", customerName=");
		sb.append(customerName);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", businessAddress=");
		sb.append(businessAddress);
		sb.append(", name=");
		sb.append(name);
		sb.append(", fieldOperations=");
		sb.append(fieldOperations);
		sb.append(", logoId=");
		sb.append(logoId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BusinessEntry toEntityModel() {
		BusinessEntryImpl businessEntryImpl = new BusinessEntryImpl();

		if (uuid == null) {
			businessEntryImpl.setUuid("");
		}
		else {
			businessEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			businessEntryImpl.setExternalReferenceCode("");
		}
		else {
			businessEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		businessEntryImpl.setBusinessId(businessId);
		businessEntryImpl.setGroupId(groupId);
		businessEntryImpl.setCompanyId(companyId);
		businessEntryImpl.setAccountId(accountId);

		if (userName == null) {
			businessEntryImpl.setUserName("");
		}
		else {
			businessEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			businessEntryImpl.setCreateDate(null);
		}
		else {
			businessEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			businessEntryImpl.setModifiedDate(null);
		}
		else {
			businessEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		businessEntryImpl.setCreatorId(creatorId);

		if (customerName == null) {
			businessEntryImpl.setCustomerName("");
		}
		else {
			businessEntryImpl.setCustomerName(customerName);
		}

		if (phoneNumber == null) {
			businessEntryImpl.setPhoneNumber("");
		}
		else {
			businessEntryImpl.setPhoneNumber(phoneNumber);
		}

		if (email == null) {
			businessEntryImpl.setEmail("");
		}
		else {
			businessEntryImpl.setEmail(email);
		}

		if (businessAddress == null) {
			businessEntryImpl.setBusinessAddress("");
		}
		else {
			businessEntryImpl.setBusinessAddress(businessAddress);
		}

		if (name == null) {
			businessEntryImpl.setName("");
		}
		else {
			businessEntryImpl.setName(name);
		}

		if (fieldOperations == null) {
			businessEntryImpl.setFieldOperations("");
		}
		else {
			businessEntryImpl.setFieldOperations(fieldOperations);
		}

		businessEntryImpl.setLogoId(logoId);

		if (status == null) {
			businessEntryImpl.setStatus("");
		}
		else {
			businessEntryImpl.setStatus(status);
		}

		businessEntryImpl.resetOriginalValues();

		return businessEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		businessId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		accountId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		creatorId = objectInput.readLong();
		customerName = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		businessAddress = objectInput.readUTF();
		name = objectInput.readUTF();
		fieldOperations = objectInput.readUTF();

		logoId = objectInput.readLong();
		status = objectInput.readUTF();
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

		objectOutput.writeLong(businessId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(accountId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(creatorId);

		if (customerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customerName);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (businessAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessAddress);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (fieldOperations == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fieldOperations);
		}

		objectOutput.writeLong(logoId);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public String uuid;
	public String externalReferenceCode;
	public long businessId;
	public long groupId;
	public long companyId;
	public long accountId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long creatorId;
	public String customerName;
	public String phoneNumber;
	public String email;
	public String businessAddress;
	public String name;
	public String fieldOperations;
	public long logoId;
	public String status;

}