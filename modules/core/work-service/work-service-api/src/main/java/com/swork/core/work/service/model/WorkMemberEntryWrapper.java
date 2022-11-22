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

package com.swork.core.work.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WorkMemberEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkMemberEntry
 * @generated
 */
public class WorkMemberEntryWrapper
	extends BaseModelWrapper<WorkMemberEntry>
	implements ModelWrapper<WorkMemberEntry>, WorkMemberEntry {

	public WorkMemberEntryWrapper(WorkMemberEntry workMemberEntry) {
		super(workMemberEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workMemberId", getWorkMemberId());
		attributes.put("workId", getWorkId());
		attributes.put("memberId", getMemberId());
		attributes.put("memberType", getMemberType());
		attributes.put("memberReferenceCode", getMemberReferenceCode());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workMemberId = (Long)attributes.get("workMemberId");

		if (workMemberId != null) {
			setWorkMemberId(workMemberId);
		}

		Long workId = (Long)attributes.get("workId");

		if (workId != null) {
			setWorkId(workId);
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
	public WorkMemberEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the member ID of this work member entry.
	 *
	 * @return the member ID of this work member entry
	 */
	@Override
	public long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the member reference code of this work member entry.
	 *
	 * @return the member reference code of this work member entry
	 */
	@Override
	public String getMemberReferenceCode() {
		return model.getMemberReferenceCode();
	}

	/**
	 * Returns the member type of this work member entry.
	 *
	 * @return the member type of this work member entry
	 */
	@Override
	public String getMemberType() {
		return model.getMemberType();
	}

	/**
	 * Returns the primary key of this work member entry.
	 *
	 * @return the primary key of this work member entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this work member entry.
	 *
	 * @return the type of this work member entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the work ID of this work member entry.
	 *
	 * @return the work ID of this work member entry
	 */
	@Override
	public long getWorkId() {
		return model.getWorkId();
	}

	/**
	 * Returns the work member ID of this work member entry.
	 *
	 * @return the work member ID of this work member entry
	 */
	@Override
	public long getWorkMemberId() {
		return model.getWorkMemberId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the member ID of this work member entry.
	 *
	 * @param memberId the member ID of this work member entry
	 */
	@Override
	public void setMemberId(long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the member reference code of this work member entry.
	 *
	 * @param memberReferenceCode the member reference code of this work member entry
	 */
	@Override
	public void setMemberReferenceCode(String memberReferenceCode) {
		model.setMemberReferenceCode(memberReferenceCode);
	}

	/**
	 * Sets the member type of this work member entry.
	 *
	 * @param memberType the member type of this work member entry
	 */
	@Override
	public void setMemberType(String memberType) {
		model.setMemberType(memberType);
	}

	/**
	 * Sets the primary key of this work member entry.
	 *
	 * @param primaryKey the primary key of this work member entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this work member entry.
	 *
	 * @param type the type of this work member entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the work ID of this work member entry.
	 *
	 * @param workId the work ID of this work member entry
	 */
	@Override
	public void setWorkId(long workId) {
		model.setWorkId(workId);
	}

	/**
	 * Sets the work member ID of this work member entry.
	 *
	 * @param workMemberId the work member ID of this work member entry
	 */
	@Override
	public void setWorkMemberId(long workMemberId) {
		model.setWorkMemberId(workMemberId);
	}

	@Override
	protected WorkMemberEntryWrapper wrap(WorkMemberEntry workMemberEntry) {
		return new WorkMemberEntryWrapper(workMemberEntry);
	}

}