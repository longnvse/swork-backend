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

package com.swork.core.work.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.core.work.service.model.WorkMemberEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WorkMemberEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkMemberEntryCacheModel
	implements CacheModel<WorkMemberEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkMemberEntryCacheModel)) {
			return false;
		}

		WorkMemberEntryCacheModel workMemberEntryCacheModel =
			(WorkMemberEntryCacheModel)object;

		if (workMemberId == workMemberEntryCacheModel.workMemberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workMemberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{workMemberId=");
		sb.append(workMemberId);
		sb.append(", workId=");
		sb.append(workId);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", memberType=");
		sb.append(memberType);
		sb.append(", memberReferenceCode=");
		sb.append(memberReferenceCode);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkMemberEntry toEntityModel() {
		WorkMemberEntryImpl workMemberEntryImpl = new WorkMemberEntryImpl();

		workMemberEntryImpl.setWorkMemberId(workMemberId);
		workMemberEntryImpl.setWorkId(workId);
		workMemberEntryImpl.setMemberId(memberId);

		if (memberType == null) {
			workMemberEntryImpl.setMemberType("");
		}
		else {
			workMemberEntryImpl.setMemberType(memberType);
		}

		if (memberReferenceCode == null) {
			workMemberEntryImpl.setMemberReferenceCode("");
		}
		else {
			workMemberEntryImpl.setMemberReferenceCode(memberReferenceCode);
		}

		if (type == null) {
			workMemberEntryImpl.setType("");
		}
		else {
			workMemberEntryImpl.setType(type);
		}

		workMemberEntryImpl.resetOriginalValues();

		return workMemberEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workMemberId = objectInput.readLong();

		workId = objectInput.readLong();

		memberId = objectInput.readLong();
		memberType = objectInput.readUTF();
		memberReferenceCode = objectInput.readUTF();
		type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(workMemberId);

		objectOutput.writeLong(workId);

		objectOutput.writeLong(memberId);

		if (memberType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberType);
		}

		if (memberReferenceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberReferenceCode);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public long workMemberId;
	public long workId;
	public long memberId;
	public String memberType;
	public String memberReferenceCode;
	public String type;

}