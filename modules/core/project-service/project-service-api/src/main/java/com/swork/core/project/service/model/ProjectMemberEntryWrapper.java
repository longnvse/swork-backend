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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProjectMemberEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectMemberEntry
 * @generated
 */
public class ProjectMemberEntryWrapper
	extends BaseModelWrapper<ProjectMemberEntry>
	implements ModelWrapper<ProjectMemberEntry>, ProjectMemberEntry {

	public ProjectMemberEntryWrapper(ProjectMemberEntry projectMemberEntry) {
		super(projectMemberEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectMemberId", getProjectMemberId());
		attributes.put("projectId", getProjectId());
		attributes.put("memberId", getMemberId());
		attributes.put("memberType", getMemberType());
		attributes.put("memberReferenceCode", getMemberReferenceCode());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectMemberId = (Long)attributes.get("projectMemberId");

		if (projectMemberId != null) {
			setProjectMemberId(projectMemberId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		String memberType = (String)attributes.get("memberType");

		if (memberType != null) {
			setMemberType(memberType);
		}

		String memberReferenceCode = (String)attributes.get(
			"memberReferenceCode");

		if (memberReferenceCode != null) {
			setMemberReferenceCode(memberReferenceCode);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public ProjectMemberEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the member ID of this project member entry.
	 *
	 * @return the member ID of this project member entry
	 */
	@Override
	public long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the member reference code of this project member entry.
	 *
	 * @return the member reference code of this project member entry
	 */
	@Override
	public String getMemberReferenceCode() {
		return model.getMemberReferenceCode();
	}

	/**
	 * Returns the member type of this project member entry.
	 *
	 * @return the member type of this project member entry
	 */
	@Override
	public String getMemberType() {
		return model.getMemberType();
	}

	/**
	 * Returns the primary key of this project member entry.
	 *
	 * @return the primary key of this project member entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this project member entry.
	 *
	 * @return the project ID of this project member entry
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the project member ID of this project member entry.
	 *
	 * @return the project member ID of this project member entry
	 */
	@Override
	public long getProjectMemberId() {
		return model.getProjectMemberId();
	}

	/**
	 * Returns the type of this project member entry.
	 *
	 * @return the type of this project member entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the member ID of this project member entry.
	 *
	 * @param memberId the member ID of this project member entry
	 */
	@Override
	public void setMemberId(long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the member reference code of this project member entry.
	 *
	 * @param memberReferenceCode the member reference code of this project member entry
	 */
	@Override
	public void setMemberReferenceCode(String memberReferenceCode) {
		model.setMemberReferenceCode(memberReferenceCode);
	}

	/**
	 * Sets the member type of this project member entry.
	 *
	 * @param memberType the member type of this project member entry
	 */
	@Override
	public void setMemberType(String memberType) {
		model.setMemberType(memberType);
	}

	/**
	 * Sets the primary key of this project member entry.
	 *
	 * @param primaryKey the primary key of this project member entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this project member entry.
	 *
	 * @param projectId the project ID of this project member entry
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the project member ID of this project member entry.
	 *
	 * @param projectMemberId the project member ID of this project member entry
	 */
	@Override
	public void setProjectMemberId(long projectMemberId) {
		model.setProjectMemberId(projectMemberId);
	}

	/**
	 * Sets the type of this project member entry.
	 *
	 * @param type the type of this project member entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected ProjectMemberEntryWrapper wrap(
		ProjectMemberEntry projectMemberEntry) {

		return new ProjectMemberEntryWrapper(projectMemberEntry);
	}

}