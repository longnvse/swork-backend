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

package com.swork.core.resource.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.core.resource.service.model.ResourceTypeEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ResourceTypeEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ResourceTypeEntryCacheModel
	implements CacheModel<ResourceTypeEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ResourceTypeEntryCacheModel)) {
			return false;
		}

		ResourceTypeEntryCacheModel resourceTypeEntryCacheModel =
			(ResourceTypeEntryCacheModel)object;

		if (resourceTypeId == resourceTypeEntryCacheModel.resourceTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, resourceTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", resourceTypeId=");
		sb.append(resourceTypeId);
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
		sb.append(", modifiedId=");
		sb.append(modifiedId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", unit=");
		sb.append(unit);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ResourceTypeEntry toEntityModel() {
		ResourceTypeEntryImpl resourceTypeEntryImpl =
			new ResourceTypeEntryImpl();

		if (uuid == null) {
			resourceTypeEntryImpl.setUuid("");
		}
		else {
			resourceTypeEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			resourceTypeEntryImpl.setExternalReferenceCode("");
		}
		else {
			resourceTypeEntryImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		resourceTypeEntryImpl.setResourceTypeId(resourceTypeId);
		resourceTypeEntryImpl.setGroupId(groupId);
		resourceTypeEntryImpl.setCompanyId(companyId);
		resourceTypeEntryImpl.setAccountId(accountId);

		if (createDate == Long.MIN_VALUE) {
			resourceTypeEntryImpl.setCreateDate(null);
		}
		else {
			resourceTypeEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			resourceTypeEntryImpl.setModifiedDate(null);
		}
		else {
			resourceTypeEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		resourceTypeEntryImpl.setBusinessId(businessId);
		resourceTypeEntryImpl.setModifiedId(modifiedId);

		if (name == null) {
			resourceTypeEntryImpl.setName("");
		}
		else {
			resourceTypeEntryImpl.setName(name);
		}

		if (unit == null) {
			resourceTypeEntryImpl.setUnit("");
		}
		else {
			resourceTypeEntryImpl.setUnit(unit);
		}

		resourceTypeEntryImpl.setParentId(parentId);

		resourceTypeEntryImpl.resetOriginalValues();

		return resourceTypeEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		resourceTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		accountId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		businessId = objectInput.readLong();

		modifiedId = objectInput.readLong();
		name = objectInput.readUTF();
		unit = objectInput.readUTF();

		parentId = objectInput.readLong();
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

		objectOutput.writeLong(resourceTypeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(accountId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(businessId);

		objectOutput.writeLong(modifiedId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (unit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unit);
		}

		objectOutput.writeLong(parentId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long resourceTypeId;
	public long groupId;
	public long companyId;
	public long accountId;
	public long createDate;
	public long modifiedDate;
	public long businessId;
	public long modifiedId;
	public String name;
	public String unit;
	public long parentId;

}