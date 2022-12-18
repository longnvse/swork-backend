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

package com.swork.common.comment.service.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CommentEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentEntry
 * @generated
 */
public class CommentEntryWrapper
	extends BaseModelWrapper<CommentEntry>
	implements CommentEntry, ModelWrapper<CommentEntry> {

	public CommentEntryWrapper(CommentEntry commentEntry) {
		super(commentEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("commentId", getCommentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("accountId", getAccountId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("businessId", getBusinessId());
		attributes.put("content", getContent());
		attributes.put("parentId", getParentId());
		attributes.put("classPkId", getClassPkId());
		attributes.put("classPKName", getClassPKName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long commentId = (Long)attributes.get("commentId");

		if (commentId != null) {
			setCommentId(commentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Long classPkId = (Long)attributes.get("classPkId");

		if (classPkId != null) {
			setClassPkId(classPkId);
		}

		String classPKName = (String)attributes.get("classPKName");

		if (classPKName != null) {
			setClassPKName(classPKName);
		}
	}

	@Override
	public CommentEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account ID of this comment entry.
	 *
	 * @return the account ID of this comment entry
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the business ID of this comment entry.
	 *
	 * @return the business ID of this comment entry
	 */
	@Override
	public long getBusinessId() {
		return model.getBusinessId();
	}

	/**
	 * Returns the class pk ID of this comment entry.
	 *
	 * @return the class pk ID of this comment entry
	 */
	@Override
	public long getClassPkId() {
		return model.getClassPkId();
	}

	/**
	 * Returns the class pk name of this comment entry.
	 *
	 * @return the class pk name of this comment entry
	 */
	@Override
	public String getClassPKName() {
		return model.getClassPKName();
	}

	/**
	 * Returns the comment ID of this comment entry.
	 *
	 * @return the comment ID of this comment entry
	 */
	@Override
	public long getCommentId() {
		return model.getCommentId();
	}

	/**
	 * Returns the company ID of this comment entry.
	 *
	 * @return the company ID of this comment entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this comment entry.
	 *
	 * @return the content of this comment entry
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the create date of this comment entry.
	 *
	 * @return the create date of this comment entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this comment entry.
	 *
	 * @return the group ID of this comment entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this comment entry.
	 *
	 * @return the modified date of this comment entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the parent ID of this comment entry.
	 *
	 * @return the parent ID of this comment entry
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this comment entry.
	 *
	 * @return the primary key of this comment entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this comment entry.
	 *
	 * @return the uuid of this comment entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the account ID of this comment entry.
	 *
	 * @param accountId the account ID of this comment entry
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the business ID of this comment entry.
	 *
	 * @param businessId the business ID of this comment entry
	 */
	@Override
	public void setBusinessId(long businessId) {
		model.setBusinessId(businessId);
	}

	/**
	 * Sets the class pk ID of this comment entry.
	 *
	 * @param classPkId the class pk ID of this comment entry
	 */
	@Override
	public void setClassPkId(long classPkId) {
		model.setClassPkId(classPkId);
	}

	/**
	 * Sets the class pk name of this comment entry.
	 *
	 * @param classPKName the class pk name of this comment entry
	 */
	@Override
	public void setClassPKName(String classPKName) {
		model.setClassPKName(classPKName);
	}

	/**
	 * Sets the comment ID of this comment entry.
	 *
	 * @param commentId the comment ID of this comment entry
	 */
	@Override
	public void setCommentId(long commentId) {
		model.setCommentId(commentId);
	}

	/**
	 * Sets the company ID of this comment entry.
	 *
	 * @param companyId the company ID of this comment entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this comment entry.
	 *
	 * @param content the content of this comment entry
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the create date of this comment entry.
	 *
	 * @param createDate the create date of this comment entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this comment entry.
	 *
	 * @param groupId the group ID of this comment entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this comment entry.
	 *
	 * @param modifiedDate the modified date of this comment entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the parent ID of this comment entry.
	 *
	 * @param parentId the parent ID of this comment entry
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this comment entry.
	 *
	 * @param primaryKey the primary key of this comment entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this comment entry.
	 *
	 * @param uuid the uuid of this comment entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CommentEntryWrapper wrap(CommentEntry commentEntry) {
		return new CommentEntryWrapper(commentEntry);
	}

}