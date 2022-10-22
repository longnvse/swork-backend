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

package com.swork.checklist.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.checklist.service.model.ChecklistHandlerEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ChecklistHandlerEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChecklistHandlerEntryCacheModel
	implements CacheModel<ChecklistHandlerEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChecklistHandlerEntryCacheModel)) {
			return false;
		}

		ChecklistHandlerEntryCacheModel checklistHandlerEntryCacheModel =
			(ChecklistHandlerEntryCacheModel)object;

		if (checklistHandlerId ==
				checklistHandlerEntryCacheModel.checklistHandlerId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, checklistHandlerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", checklistHandlerId=");
		sb.append(checklistHandlerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", checkListId=");
		sb.append(checkListId);
		sb.append(", accId=");
		sb.append(accId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChecklistHandlerEntry toEntityModel() {
		ChecklistHandlerEntryImpl checklistHandlerEntryImpl =
			new ChecklistHandlerEntryImpl();

		if (uuid == null) {
			checklistHandlerEntryImpl.setUuid("");
		}
		else {
			checklistHandlerEntryImpl.setUuid(uuid);
		}

		checklistHandlerEntryImpl.setChecklistHandlerId(checklistHandlerId);
		checklistHandlerEntryImpl.setGroupId(groupId);
		checklistHandlerEntryImpl.setCheckListId(checkListId);
		checklistHandlerEntryImpl.setAccId(accId);

		checklistHandlerEntryImpl.resetOriginalValues();

		return checklistHandlerEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		checklistHandlerId = objectInput.readLong();

		groupId = objectInput.readLong();

		checkListId = objectInput.readLong();

		accId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(checklistHandlerId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(checkListId);

		objectOutput.writeLong(accId);
	}

	public String uuid;
	public long checklistHandlerId;
	public long groupId;
	public long checkListId;
	public long accId;

}