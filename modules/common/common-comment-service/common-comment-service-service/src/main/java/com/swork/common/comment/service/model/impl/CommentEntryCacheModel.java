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

package com.swork.common.comment.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.common.comment.service.model.CommentEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CommentEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CommentEntryCacheModel
	implements CacheModel<CommentEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CommentEntryCacheModel)) {
			return false;
		}

		CommentEntryCacheModel commentEntryCacheModel =
			(CommentEntryCacheModel)object;

		if (commentId == commentEntryCacheModel.commentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, commentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", commentId=");
		sb.append(commentId);
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
		sb.append(", content=");
		sb.append(content);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", classPkId=");
		sb.append(classPkId);
		sb.append(", classPKName=");
		sb.append(classPKName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CommentEntry toEntityModel() {
		CommentEntryImpl commentEntryImpl = new CommentEntryImpl();

		if (uuid == null) {
			commentEntryImpl.setUuid("");
		}
		else {
			commentEntryImpl.setUuid(uuid);
		}

		commentEntryImpl.setCommentId(commentId);
		commentEntryImpl.setGroupId(groupId);
		commentEntryImpl.setCompanyId(companyId);
		commentEntryImpl.setAccountId(accountId);

		if (createDate == Long.MIN_VALUE) {
			commentEntryImpl.setCreateDate(null);
		}
		else {
			commentEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commentEntryImpl.setModifiedDate(null);
		}
		else {
			commentEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		commentEntryImpl.setBusinessId(businessId);

		if (content == null) {
			commentEntryImpl.setContent("");
		}
		else {
			commentEntryImpl.setContent(content);
		}

		commentEntryImpl.setParentId(parentId);
		commentEntryImpl.setClassPkId(classPkId);

		if (classPKName == null) {
			commentEntryImpl.setClassPKName("");
		}
		else {
			commentEntryImpl.setClassPKName(classPKName);
		}

		commentEntryImpl.resetOriginalValues();

		return commentEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		commentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		accountId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		businessId = objectInput.readLong();
		content = objectInput.readUTF();

		parentId = objectInput.readLong();

		classPkId = objectInput.readLong();
		classPKName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(commentId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(accountId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(businessId);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(parentId);

		objectOutput.writeLong(classPkId);

		if (classPKName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(classPKName);
		}
	}

	public String uuid;
	public long commentId;
	public long groupId;
	public long companyId;
	public long accountId;
	public long createDate;
	public long modifiedDate;
	public long businessId;
	public String content;
	public long parentId;
	public long classPkId;
	public String classPKName;

}