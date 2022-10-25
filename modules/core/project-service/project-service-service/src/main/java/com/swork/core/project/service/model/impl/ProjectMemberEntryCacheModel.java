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

package com.swork.core.project.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.core.project.service.model.ProjectMemberEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProjectMemberEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProjectMemberEntryCacheModel
	implements CacheModel<ProjectMemberEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectMemberEntryCacheModel)) {
			return false;
		}

		ProjectMemberEntryCacheModel projectMemberEntryCacheModel =
			(ProjectMemberEntryCacheModel)object;

		if (projectMemberId == projectMemberEntryCacheModel.projectMemberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectMemberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{projectMemberId=");
		sb.append(projectMemberId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", memberType=");
		sb.append(memberType);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectMemberEntry toEntityModel() {
		ProjectMemberEntryImpl projectMemberEntryImpl =
			new ProjectMemberEntryImpl();

		projectMemberEntryImpl.setProjectMemberId(projectMemberId);
		projectMemberEntryImpl.setProjectId(projectId);
		projectMemberEntryImpl.setMemberId(memberId);

		if (memberType == null) {
			projectMemberEntryImpl.setMemberType("");
		}
		else {
			projectMemberEntryImpl.setMemberType(memberType);
		}

		if (type == null) {
			projectMemberEntryImpl.setType("");
		}
		else {
			projectMemberEntryImpl.setType(type);
		}

		projectMemberEntryImpl.resetOriginalValues();

		return projectMemberEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectMemberId = objectInput.readLong();

		projectId = objectInput.readLong();

		memberId = objectInput.readLong();
		memberType = objectInput.readUTF();
		type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(projectMemberId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(memberId);

		if (memberType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberType);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public long projectMemberId;
	public long projectId;
	public long memberId;
	public String memberType;
	public String type;

}