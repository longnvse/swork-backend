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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the WorkEntry service. Represents a row in the &quot;SW_Work&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.swork.core.work.service.model.impl.WorkEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.swork.core.work.service.model.impl.WorkEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkEntry
 * @generated
 */
@ProviderType
public interface WorkEntryModel
	extends BaseModel<WorkEntry>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a work entry model instance should use the {@link WorkEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this work entry.
	 *
	 * @return the primary key of this work entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this work entry.
	 *
	 * @param primaryKey the primary key of this work entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this work entry.
	 *
	 * @return the uuid of this work entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this work entry.
	 *
	 * @param uuid the uuid of this work entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this work entry.
	 *
	 * @return the external reference code of this work entry
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this work entry.
	 *
	 * @param externalReferenceCode the external reference code of this work entry
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the work ID of this work entry.
	 *
	 * @return the work ID of this work entry
	 */
	public long getWorkId();

	/**
	 * Sets the work ID of this work entry.
	 *
	 * @param workId the work ID of this work entry
	 */
	public void setWorkId(long workId);

	/**
	 * Returns the group ID of this work entry.
	 *
	 * @return the group ID of this work entry
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this work entry.
	 *
	 * @param groupId the group ID of this work entry
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this work entry.
	 *
	 * @return the company ID of this work entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this work entry.
	 *
	 * @param companyId the company ID of this work entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the account ID of this work entry.
	 *
	 * @return the account ID of this work entry
	 */
	public long getAccountId();

	/**
	 * Sets the account ID of this work entry.
	 *
	 * @param accountId the account ID of this work entry
	 */
	public void setAccountId(long accountId);

	/**
	 * Returns the create date of this work entry.
	 *
	 * @return the create date of this work entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this work entry.
	 *
	 * @param createDate the create date of this work entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this work entry.
	 *
	 * @return the modified date of this work entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this work entry.
	 *
	 * @param modifiedDate the modified date of this work entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified ID of this work entry.
	 *
	 * @return the modified ID of this work entry
	 */
	public long getModifiedId();

	/**
	 * Sets the modified ID of this work entry.
	 *
	 * @param modifiedId the modified ID of this work entry
	 */
	public void setModifiedId(long modifiedId);

	/**
	 * Returns the business ID of this work entry.
	 *
	 * @return the business ID of this work entry
	 */
	public long getBusinessId();

	/**
	 * Sets the business ID of this work entry.
	 *
	 * @param businessId the business ID of this work entry
	 */
	public void setBusinessId(long businessId);

	/**
	 * Returns the project ID of this work entry.
	 *
	 * @return the project ID of this work entry
	 */
	public Long getProjectId();

	/**
	 * Sets the project ID of this work entry.
	 *
	 * @param projectId the project ID of this work entry
	 */
	public void setProjectId(Long projectId);

	/**
	 * Returns the phase ID of this work entry.
	 *
	 * @return the phase ID of this work entry
	 */
	public Long getPhaseId();

	/**
	 * Sets the phase ID of this work entry.
	 *
	 * @param phaseId the phase ID of this work entry
	 */
	public void setPhaseId(Long phaseId);

	/**
	 * Returns the parent ID of this work entry.
	 *
	 * @return the parent ID of this work entry
	 */
	public Long getParentId();

	/**
	 * Sets the parent ID of this work entry.
	 *
	 * @param parentId the parent ID of this work entry
	 */
	public void setParentId(Long parentId);

	/**
	 * Returns the parent reference code of this work entry.
	 *
	 * @return the parent reference code of this work entry
	 */
	@AutoEscape
	public String getParentReferenceCode();

	/**
	 * Sets the parent reference code of this work entry.
	 *
	 * @param parentReferenceCode the parent reference code of this work entry
	 */
	public void setParentReferenceCode(String parentReferenceCode);

	/**
	 * Returns the progress of this work entry.
	 *
	 * @return the progress of this work entry
	 */
	public long getProgress();

	/**
	 * Sets the progress of this work entry.
	 *
	 * @param progress the progress of this work entry
	 */
	public void setProgress(long progress);

	/**
	 * Returns the name of this work entry.
	 *
	 * @return the name of this work entry
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this work entry.
	 *
	 * @param name the name of this work entry
	 */
	public void setName(String name);

	/**
	 * Returns the start date of this work entry.
	 *
	 * @return the start date of this work entry
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this work entry.
	 *
	 * @param startDate the start date of this work entry
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this work entry.
	 *
	 * @return the end date of this work entry
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this work entry.
	 *
	 * @param endDate the end date of this work entry
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the actual start date of this work entry.
	 *
	 * @return the actual start date of this work entry
	 */
	public Date getActualStartDate();

	/**
	 * Sets the actual start date of this work entry.
	 *
	 * @param actualStartDate the actual start date of this work entry
	 */
	public void setActualStartDate(Date actualStartDate);

	/**
	 * Returns the actual end date of this work entry.
	 *
	 * @return the actual end date of this work entry
	 */
	public Date getActualEndDate();

	/**
	 * Sets the actual end date of this work entry.
	 *
	 * @param actualEndDate the actual end date of this work entry
	 */
	public void setActualEndDate(Date actualEndDate);

	/**
	 * Returns the description of this work entry.
	 *
	 * @return the description of this work entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this work entry.
	 *
	 * @param description the description of this work entry
	 */
	public void setDescription(String description);

	/**
	 * Returns the status of this work entry.
	 *
	 * @return the status of this work entry
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this work entry.
	 *
	 * @param status the status of this work entry
	 */
	public void setStatus(String status);

	/**
	 * Returns the percentage of this work entry.
	 *
	 * @return the percentage of this work entry
	 */
	public double getPercentage();

	/**
	 * Sets the percentage of this work entry.
	 *
	 * @param percentage the percentage of this work entry
	 */
	public void setPercentage(double percentage);

	/**
	 * Returns the progress type of this work entry.
	 *
	 * @return the progress type of this work entry
	 */
	@AutoEscape
	public String getProgressType();

	/**
	 * Sets the progress type of this work entry.
	 *
	 * @param progressType the progress type of this work entry
	 */
	public void setProgressType(String progressType);

	/**
	 * Returns the unit of this work entry.
	 *
	 * @return the unit of this work entry
	 */
	@AutoEscape
	public String getUnit();

	/**
	 * Sets the unit of this work entry.
	 *
	 * @param unit the unit of this work entry
	 */
	public void setUnit(String unit);

	/**
	 * Returns the incomplete task of this work entry.
	 *
	 * @return the incomplete task of this work entry
	 */
	public double getIncompleteTask();

	/**
	 * Sets the incomplete task of this work entry.
	 *
	 * @param incompleteTask the incomplete task of this work entry
	 */
	public void setIncompleteTask(double incompleteTask);

	/**
	 * Returns the complete of this work entry.
	 *
	 * @return the complete of this work entry
	 */
	public double getComplete();

	/**
	 * Sets the complete of this work entry.
	 *
	 * @param complete the complete of this work entry
	 */
	public void setComplete(double complete);

	@Override
	public WorkEntry cloneWithOriginalValues();

}