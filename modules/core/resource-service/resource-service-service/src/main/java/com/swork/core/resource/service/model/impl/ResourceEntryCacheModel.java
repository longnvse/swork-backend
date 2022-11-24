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

import com.swork.core.resource.service.model.ResourceEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ResourceEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ResourceEntryCacheModel
	implements CacheModel<ResourceEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ResourceEntryCacheModel)) {
			return false;
		}

		ResourceEntryCacheModel resourceEntryCacheModel =
			(ResourceEntryCacheModel)object;

		if (resourceId == resourceEntryCacheModel.resourceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, resourceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", resourceId=");
		sb.append(resourceId);
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
		sb.append(", workId=");
		sb.append(workId);
		sb.append(", phaseId=");
		sb.append(phaseId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", resourceTypeId=");
		sb.append(resourceTypeId);
		sb.append(", resourceTypeName=");
		sb.append(resourceTypeName);
		sb.append(", teamId=");
		sb.append(teamId);
		sb.append(", teamName=");
		sb.append(teamName);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", unit=");
		sb.append(unit);
		sb.append(", dateResource=");
		sb.append(dateResource);
		sb.append(", totalAmount=");
		sb.append(totalAmount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ResourceEntry toEntityModel() {
		ResourceEntryImpl resourceEntryImpl = new ResourceEntryImpl();

		if (uuid == null) {
			resourceEntryImpl.setUuid("");
		}
		else {
			resourceEntryImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			resourceEntryImpl.setExternalReferenceCode("");
		}
		else {
			resourceEntryImpl.setExternalReferenceCode(externalReferenceCode);
		}

		resourceEntryImpl.setResourceId(resourceId);
		resourceEntryImpl.setGroupId(groupId);
		resourceEntryImpl.setCompanyId(companyId);
		resourceEntryImpl.setAccountId(accountId);

		if (createDate == Long.MIN_VALUE) {
			resourceEntryImpl.setCreateDate(null);
		}
		else {
			resourceEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			resourceEntryImpl.setModifiedDate(null);
		}
		else {
			resourceEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		resourceEntryImpl.setBusinessId(businessId);
		resourceEntryImpl.setModifiedId(modifiedId);
		resourceEntryImpl.setWorkId(workId);
		resourceEntryImpl.setPhaseId(phaseId);
		resourceEntryImpl.setProjectId(projectId);
		resourceEntryImpl.setResourceTypeId(resourceTypeId);

		if (resourceTypeName == null) {
			resourceEntryImpl.setResourceTypeName("");
		}
		else {
			resourceEntryImpl.setResourceTypeName(resourceTypeName);
		}

		resourceEntryImpl.setTeamId(teamId);

		if (teamName == null) {
			resourceEntryImpl.setTeamName("");
		}
		else {
			resourceEntryImpl.setTeamName(teamName);
		}

		resourceEntryImpl.setQuantity(quantity);

		if (unit == null) {
			resourceEntryImpl.setUnit("");
		}
		else {
			resourceEntryImpl.setUnit(unit);
		}

		if (dateResource == Long.MIN_VALUE) {
			resourceEntryImpl.setDateResource(null);
		}
		else {
			resourceEntryImpl.setDateResource(new Date(dateResource));
		}

		resourceEntryImpl.setTotalAmount(totalAmount);

		resourceEntryImpl.resetOriginalValues();

		return resourceEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		resourceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		accountId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		businessId = objectInput.readLong();

		modifiedId = objectInput.readLong();

		workId = objectInput.readLong();

		phaseId = objectInput.readLong();

		projectId = objectInput.readLong();

		resourceTypeId = objectInput.readLong();
		resourceTypeName = objectInput.readUTF();

		teamId = objectInput.readLong();
		teamName = objectInput.readUTF();

		quantity = objectInput.readLong();
		unit = objectInput.readUTF();
		dateResource = objectInput.readLong();

		totalAmount = objectInput.readLong();
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

		objectOutput.writeLong(resourceId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(accountId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(businessId);

		objectOutput.writeLong(modifiedId);

		objectOutput.writeLong(workId);

		objectOutput.writeLong(phaseId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(resourceTypeId);

		if (resourceTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(resourceTypeName);
		}

		objectOutput.writeLong(teamId);

		if (teamName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(teamName);
		}

		objectOutput.writeLong(quantity);

		if (unit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unit);
		}

		objectOutput.writeLong(dateResource);

		objectOutput.writeLong(totalAmount);
	}

	public String uuid;
	public String externalReferenceCode;
	public long resourceId;
	public long groupId;
	public long companyId;
	public long accountId;
	public long createDate;
	public long modifiedDate;
	public long businessId;
	public long modifiedId;
	public long workId;
	public long phaseId;
	public long projectId;
	public long resourceTypeId;
	public String resourceTypeName;
	public long teamId;
	public String teamName;
	public long quantity;
	public String unit;
	public long dateResource;
	public long totalAmount;

}