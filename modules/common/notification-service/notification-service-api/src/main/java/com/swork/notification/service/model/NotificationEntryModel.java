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

package com.swork.notification.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the NotificationEntry service. Represents a row in the &quot;SW_Notification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.swork.notification.service.model.impl.NotificationEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.swork.notification.service.model.impl.NotificationEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationEntry
 * @generated
 */
@ProviderType
public interface NotificationEntryModel
	extends BaseModel<NotificationEntry>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a notification entry model instance should use the {@link NotificationEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this notification entry.
	 *
	 * @return the primary key of this notification entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this notification entry.
	 *
	 * @param primaryKey the primary key of this notification entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this notification entry.
	 *
	 * @return the uuid of this notification entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this notification entry.
	 *
	 * @param uuid the uuid of this notification entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this notification entry.
	 *
	 * @return the external reference code of this notification entry
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this notification entry.
	 *
	 * @param externalReferenceCode the external reference code of this notification entry
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the ID of this notification entry.
	 *
	 * @return the ID of this notification entry
	 */
	public long getId();

	/**
	 * Sets the ID of this notification entry.
	 *
	 * @param id the ID of this notification entry
	 */
	public void setId(long id);

	/**
	 * Returns the group ID of this notification entry.
	 *
	 * @return the group ID of this notification entry
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this notification entry.
	 *
	 * @param groupId the group ID of this notification entry
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this notification entry.
	 *
	 * @return the company ID of this notification entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this notification entry.
	 *
	 * @param companyId the company ID of this notification entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the account ID of this notification entry.
	 *
	 * @return the account ID of this notification entry
	 */
	public long getAccountId();

	/**
	 * Sets the account ID of this notification entry.
	 *
	 * @param accountId the account ID of this notification entry
	 */
	public void setAccountId(long accountId);

	/**
	 * Returns the user name of this notification entry.
	 *
	 * @return the user name of this notification entry
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this notification entry.
	 *
	 * @param userName the user name of this notification entry
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this notification entry.
	 *
	 * @return the create date of this notification entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this notification entry.
	 *
	 * @param createDate the create date of this notification entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this notification entry.
	 *
	 * @return the modified date of this notification entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this notification entry.
	 *
	 * @param modifiedDate the modified date of this notification entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the editor ID of this notification entry.
	 *
	 * @return the editor ID of this notification entry
	 */
	public long getEditorId();

	/**
	 * Sets the editor ID of this notification entry.
	 *
	 * @param editorId the editor ID of this notification entry
	 */
	public void setEditorId(long editorId);

	/**
	 * Returns the category of this notification entry.
	 *
	 * @return the category of this notification entry
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this notification entry.
	 *
	 * @param category the category of this notification entry
	 */
	public void setCategory(String category);

	/**
	 * Returns the name of this notification entry.
	 *
	 * @return the name of this notification entry
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this notification entry.
	 *
	 * @param name the name of this notification entry
	 */
	public void setName(String name);

	/**
	 * Returns the description of this notification entry.
	 *
	 * @return the description of this notification entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this notification entry.
	 *
	 * @param description the description of this notification entry
	 */
	public void setDescription(String description);

	/**
	 * Returns the status of this notification entry.
	 *
	 * @return the status of this notification entry
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this notification entry.
	 *
	 * @param status the status of this notification entry
	 */
	public void setStatus(String status);

	/**
	 * Returns the receiver ID of this notification entry.
	 *
	 * @return the receiver ID of this notification entry
	 */
	public long getReceiverId();

	/**
	 * Sets the receiver ID of this notification entry.
	 *
	 * @param receiverId the receiver ID of this notification entry
	 */
	public void setReceiverId(long receiverId);

	/**
	 * Returns the subject ID of this notification entry.
	 *
	 * @return the subject ID of this notification entry
	 */
	public long getSubjectId();

	/**
	 * Sets the subject ID of this notification entry.
	 *
	 * @param subjectId the subject ID of this notification entry
	 */
	public void setSubjectId(long subjectId);

	@Override
	public NotificationEntry cloneWithOriginalValues();

}