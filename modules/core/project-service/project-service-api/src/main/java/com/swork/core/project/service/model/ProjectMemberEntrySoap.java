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

package com.swork.core.project.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ProjectMemberEntrySoap implements Serializable {

	public static ProjectMemberEntrySoap toSoapModel(ProjectMemberEntry model) {
		ProjectMemberEntrySoap soapModel = new ProjectMemberEntrySoap();

		soapModel.setProjectMemberId(model.getProjectMemberId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setMemberId(model.getMemberId());
		soapModel.setMemberType(model.getMemberType());
		soapModel.setMemberReferenceCode(model.getMemberReferenceCode());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static ProjectMemberEntrySoap[] toSoapModels(
		ProjectMemberEntry[] models) {

		ProjectMemberEntrySoap[] soapModels =
			new ProjectMemberEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectMemberEntrySoap[][] toSoapModels(
		ProjectMemberEntry[][] models) {

		ProjectMemberEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ProjectMemberEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectMemberEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectMemberEntrySoap[] toSoapModels(
		List<ProjectMemberEntry> models) {

		List<ProjectMemberEntrySoap> soapModels =
			new ArrayList<ProjectMemberEntrySoap>(models.size());

		for (ProjectMemberEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ProjectMemberEntrySoap[soapModels.size()]);
	}

	public ProjectMemberEntrySoap() {
	}

	public long getPrimaryKey() {
		return _projectMemberId;
	}

	public void setPrimaryKey(long pk) {
		setProjectMemberId(pk);
	}

	public long getProjectMemberId() {
		return _projectMemberId;
	}

	public void setProjectMemberId(long projectMemberId) {
		_projectMemberId = projectMemberId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
	}

	public String getMemberType() {
		return _memberType;
	}

	public void setMemberType(String memberType) {
		_memberType = memberType;
	}

	public String getMemberReferenceCode() {
		return _memberReferenceCode;
	}

	public void setMemberReferenceCode(String memberReferenceCode) {
		_memberReferenceCode = memberReferenceCode;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private long _projectMemberId;
	private long _projectId;
	private long _memberId;
	private String _memberType;
	private String _memberReferenceCode;
	private String _type;

}