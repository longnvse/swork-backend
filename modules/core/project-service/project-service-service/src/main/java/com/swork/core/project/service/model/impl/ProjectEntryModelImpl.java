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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.model.ProjectEntryModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ProjectEntry service. Represents a row in the &quot;SW_Project&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProjectEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEntryImpl
 * @generated
 */
public class ProjectEntryModelImpl
	extends BaseModelImpl<ProjectEntry> implements ProjectEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project entry model instance should use the <code>ProjectEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "SW_Project";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"projectId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"accountId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"modifiedId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"code_", Types.VARCHAR}, {"startDate", Types.TIMESTAMP},
		{"endDate", Types.TIMESTAMP}, {"budget", Types.BIGINT},
		{"description", Types.VARCHAR}, {"status", Types.VARCHAR},
		{"progress", Types.INTEGER}, {"actualStartDate", Types.TIMESTAMP},
		{"actualEndDate", Types.TIMESTAMP}, {"progressType", Types.VARCHAR},
		{"businessId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("accountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("endDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("budget", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("progress", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("actualStartDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("actualEndDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("progressType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("businessId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SW_Project (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,projectId LONG not null primary key,groupId LONG,companyId LONG,accountId LONG,createDate DATE null,modifiedDate DATE null,modifiedId LONG,name VARCHAR(100) null,code_ VARCHAR(75) null,startDate DATE null,endDate DATE null,budget LONG,description VARCHAR(500) null,status VARCHAR(75) null,progress INTEGER,actualStartDate DATE null,actualEndDate DATE null,progressType VARCHAR(75) null,businessId LONG)";

	public static final String TABLE_SQL_DROP = "drop table SW_Project";

	public static final String ORDER_BY_JPQL =
		" ORDER BY projectEntry.projectId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SW_Project.projectId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long BUSINESSID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CODE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROJECTID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public ProjectEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _projectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectEntry.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProjectEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProjectEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProjectEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProjectEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProjectEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProjectEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProjectEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProjectEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ProjectEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ProjectEntry.class.getClassLoader(), ProjectEntry.class,
			ModelWrapper.class);

		try {
			Constructor<ProjectEntry> constructor =
				(Constructor<ProjectEntry>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<ProjectEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ProjectEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProjectEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ProjectEntry, Object>>();
		Map<String, BiConsumer<ProjectEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ProjectEntry, ?>>();

		attributeGetterFunctions.put("uuid", ProjectEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<ProjectEntry, String>)ProjectEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode", ProjectEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<ProjectEntry, String>)
				ProjectEntry::setExternalReferenceCode);
		attributeGetterFunctions.put("projectId", ProjectEntry::getProjectId);
		attributeSetterBiConsumers.put(
			"projectId",
			(BiConsumer<ProjectEntry, Long>)ProjectEntry::setProjectId);
		attributeGetterFunctions.put("groupId", ProjectEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ProjectEntry, Long>)ProjectEntry::setGroupId);
		attributeGetterFunctions.put("companyId", ProjectEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProjectEntry, Long>)ProjectEntry::setCompanyId);
		attributeGetterFunctions.put("accountId", ProjectEntry::getAccountId);
		attributeSetterBiConsumers.put(
			"accountId",
			(BiConsumer<ProjectEntry, Long>)ProjectEntry::setAccountId);
		attributeGetterFunctions.put("createDate", ProjectEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProjectEntry, Date>)ProjectEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ProjectEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProjectEntry, Date>)ProjectEntry::setModifiedDate);
		attributeGetterFunctions.put("modifiedId", ProjectEntry::getModifiedId);
		attributeSetterBiConsumers.put(
			"modifiedId",
			(BiConsumer<ProjectEntry, Long>)ProjectEntry::setModifiedId);
		attributeGetterFunctions.put("name", ProjectEntry::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<ProjectEntry, String>)ProjectEntry::setName);
		attributeGetterFunctions.put("code", ProjectEntry::getCode);
		attributeSetterBiConsumers.put(
			"code", (BiConsumer<ProjectEntry, String>)ProjectEntry::setCode);
		attributeGetterFunctions.put("startDate", ProjectEntry::getStartDate);
		attributeSetterBiConsumers.put(
			"startDate",
			(BiConsumer<ProjectEntry, Date>)ProjectEntry::setStartDate);
		attributeGetterFunctions.put("endDate", ProjectEntry::getEndDate);
		attributeSetterBiConsumers.put(
			"endDate",
			(BiConsumer<ProjectEntry, Date>)ProjectEntry::setEndDate);
		attributeGetterFunctions.put("budget", ProjectEntry::getBudget);
		attributeSetterBiConsumers.put(
			"budget", (BiConsumer<ProjectEntry, Long>)ProjectEntry::setBudget);
		attributeGetterFunctions.put(
			"description", ProjectEntry::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<ProjectEntry, String>)ProjectEntry::setDescription);
		attributeGetterFunctions.put("status", ProjectEntry::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<ProjectEntry, String>)ProjectEntry::setStatus);
		attributeGetterFunctions.put("progress", ProjectEntry::getProgress);
		attributeSetterBiConsumers.put(
			"progress",
			(BiConsumer<ProjectEntry, Integer>)ProjectEntry::setProgress);
		attributeGetterFunctions.put(
			"actualStartDate", ProjectEntry::getActualStartDate);
		attributeSetterBiConsumers.put(
			"actualStartDate",
			(BiConsumer<ProjectEntry, Date>)ProjectEntry::setActualStartDate);
		attributeGetterFunctions.put(
			"actualEndDate", ProjectEntry::getActualEndDate);
		attributeSetterBiConsumers.put(
			"actualEndDate",
			(BiConsumer<ProjectEntry, Date>)ProjectEntry::setActualEndDate);
		attributeGetterFunctions.put(
			"progressType", ProjectEntry::getProgressType);
		attributeSetterBiConsumers.put(
			"progressType",
			(BiConsumer<ProjectEntry, String>)ProjectEntry::setProgressType);
		attributeGetterFunctions.put("businessId", ProjectEntry::getBusinessId);
		attributeSetterBiConsumers.put(
			"businessId",
			(BiConsumer<ProjectEntry, Long>)ProjectEntry::setBusinessId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public String getExternalReferenceCode() {
		if (_externalReferenceCode == null) {
			return "";
		}
		else {
			return _externalReferenceCode;
		}
	}

	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_externalReferenceCode = externalReferenceCode;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalExternalReferenceCode() {
		return getColumnOriginalValue("externalReferenceCode");
	}

	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_projectId = projectId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_accountId = accountId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getModifiedId() {
		return _modifiedId;
	}

	@Override
	public void setModifiedId(long modifiedId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedId = modifiedId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalName() {
		return getColumnOriginalValue("name");
	}

	@Override
	public String getCode() {
		if (_code == null) {
			return "";
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_code = code;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalCode() {
		return getColumnOriginalValue("code_");
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_startDate = startDate;
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_endDate = endDate;
	}

	@Override
	public long getBudget() {
		return _budget;
	}

	@Override
	public void setBudget(long budget) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_budget = budget;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@Override
	public Integer getProgress() {
		return _progress;
	}

	@Override
	public void setProgress(Integer progress) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_progress = progress;
	}

	@Override
	public Date getActualStartDate() {
		return _actualStartDate;
	}

	@Override
	public void setActualStartDate(Date actualStartDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_actualStartDate = actualStartDate;
	}

	@Override
	public Date getActualEndDate() {
		return _actualEndDate;
	}

	@Override
	public void setActualEndDate(Date actualEndDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_actualEndDate = actualEndDate;
	}

	@Override
	public String getProgressType() {
		if (_progressType == null) {
			return "";
		}
		else {
			return _progressType;
		}
	}

	@Override
	public void setProgressType(String progressType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_progressType = progressType;
	}

	@Override
	public long getBusinessId() {
		return _businessId;
	}

	@Override
	public void setBusinessId(long businessId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_businessId = businessId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalBusinessId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("businessId"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ProjectEntry.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ProjectEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProjectEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProjectEntry>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProjectEntryImpl projectEntryImpl = new ProjectEntryImpl();

		projectEntryImpl.setUuid(getUuid());
		projectEntryImpl.setExternalReferenceCode(getExternalReferenceCode());
		projectEntryImpl.setProjectId(getProjectId());
		projectEntryImpl.setGroupId(getGroupId());
		projectEntryImpl.setCompanyId(getCompanyId());
		projectEntryImpl.setAccountId(getAccountId());
		projectEntryImpl.setCreateDate(getCreateDate());
		projectEntryImpl.setModifiedDate(getModifiedDate());
		projectEntryImpl.setModifiedId(getModifiedId());
		projectEntryImpl.setName(getName());
		projectEntryImpl.setCode(getCode());
		projectEntryImpl.setStartDate(getStartDate());
		projectEntryImpl.setEndDate(getEndDate());
		projectEntryImpl.setBudget(getBudget());
		projectEntryImpl.setDescription(getDescription());
		projectEntryImpl.setStatus(getStatus());
		projectEntryImpl.setProgress(getProgress());
		projectEntryImpl.setActualStartDate(getActualStartDate());
		projectEntryImpl.setActualEndDate(getActualEndDate());
		projectEntryImpl.setProgressType(getProgressType());
		projectEntryImpl.setBusinessId(getBusinessId());

		projectEntryImpl.resetOriginalValues();

		return projectEntryImpl;
	}

	@Override
	public ProjectEntry cloneWithOriginalValues() {
		ProjectEntryImpl projectEntryImpl = new ProjectEntryImpl();

		projectEntryImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		projectEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		projectEntryImpl.setProjectId(
			this.<Long>getColumnOriginalValue("projectId"));
		projectEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		projectEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		projectEntryImpl.setAccountId(
			this.<Long>getColumnOriginalValue("accountId"));
		projectEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		projectEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		projectEntryImpl.setModifiedId(
			this.<Long>getColumnOriginalValue("modifiedId"));
		projectEntryImpl.setName(this.<String>getColumnOriginalValue("name"));
		projectEntryImpl.setCode(this.<String>getColumnOriginalValue("code_"));
		projectEntryImpl.setStartDate(
			this.<Date>getColumnOriginalValue("startDate"));
		projectEntryImpl.setEndDate(
			this.<Date>getColumnOriginalValue("endDate"));
		projectEntryImpl.setBudget(this.<Long>getColumnOriginalValue("budget"));
		projectEntryImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		projectEntryImpl.setStatus(
			this.<String>getColumnOriginalValue("status"));
		projectEntryImpl.setProgress(
			this.<Integer>getColumnOriginalValue("progress"));
		projectEntryImpl.setActualStartDate(
			this.<Date>getColumnOriginalValue("actualStartDate"));
		projectEntryImpl.setActualEndDate(
			this.<Date>getColumnOriginalValue("actualEndDate"));
		projectEntryImpl.setProgressType(
			this.<String>getColumnOriginalValue("progressType"));
		projectEntryImpl.setBusinessId(
			this.<Long>getColumnOriginalValue("businessId"));

		return projectEntryImpl;
	}

	@Override
	public int compareTo(ProjectEntry projectEntry) {
		long primaryKey = projectEntry.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectEntry)) {
			return false;
		}

		ProjectEntry projectEntry = (ProjectEntry)object;

		long primaryKey = projectEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ProjectEntry> toCacheModel() {
		ProjectEntryCacheModel projectEntryCacheModel =
			new ProjectEntryCacheModel();

		projectEntryCacheModel.uuid = getUuid();

		String uuid = projectEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			projectEntryCacheModel.uuid = null;
		}

		projectEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			projectEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			projectEntryCacheModel.externalReferenceCode = null;
		}

		projectEntryCacheModel.projectId = getProjectId();

		projectEntryCacheModel.groupId = getGroupId();

		projectEntryCacheModel.companyId = getCompanyId();

		projectEntryCacheModel.accountId = getAccountId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			projectEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			projectEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			projectEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			projectEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		projectEntryCacheModel.modifiedId = getModifiedId();

		projectEntryCacheModel.name = getName();

		String name = projectEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			projectEntryCacheModel.name = null;
		}

		projectEntryCacheModel.code = getCode();

		String code = projectEntryCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			projectEntryCacheModel.code = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			projectEntryCacheModel.startDate = startDate.getTime();
		}
		else {
			projectEntryCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			projectEntryCacheModel.endDate = endDate.getTime();
		}
		else {
			projectEntryCacheModel.endDate = Long.MIN_VALUE;
		}

		projectEntryCacheModel.budget = getBudget();

		projectEntryCacheModel.description = getDescription();

		String description = projectEntryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			projectEntryCacheModel.description = null;
		}

		projectEntryCacheModel.status = getStatus();

		String status = projectEntryCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			projectEntryCacheModel.status = null;
		}

		Integer progress = getProgress();

		if (progress != null) {
			projectEntryCacheModel.progress = progress;
		}

		Date actualStartDate = getActualStartDate();

		if (actualStartDate != null) {
			projectEntryCacheModel.actualStartDate = actualStartDate.getTime();
		}
		else {
			projectEntryCacheModel.actualStartDate = Long.MIN_VALUE;
		}

		Date actualEndDate = getActualEndDate();

		if (actualEndDate != null) {
			projectEntryCacheModel.actualEndDate = actualEndDate.getTime();
		}
		else {
			projectEntryCacheModel.actualEndDate = Long.MIN_VALUE;
		}

		projectEntryCacheModel.progressType = getProgressType();

		String progressType = projectEntryCacheModel.progressType;

		if ((progressType != null) && (progressType.length() == 0)) {
			projectEntryCacheModel.progressType = null;
		}

		projectEntryCacheModel.businessId = getBusinessId();

		return projectEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProjectEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProjectEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((ProjectEntry)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ProjectEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ProjectEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ProjectEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ProjectEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _projectId;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedId;
	private String _name;
	private String _code;
	private Date _startDate;
	private Date _endDate;
	private long _budget;
	private String _description;
	private String _status;
	private Integer _progress;
	private Date _actualStartDate;
	private Date _actualEndDate;
	private String _progressType;
	private long _businessId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ProjectEntry, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ProjectEntry)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put(
			"externalReferenceCode", _externalReferenceCode);
		_columnOriginalValues.put("projectId", _projectId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("accountId", _accountId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("modifiedId", _modifiedId);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("code_", _code);
		_columnOriginalValues.put("startDate", _startDate);
		_columnOriginalValues.put("endDate", _endDate);
		_columnOriginalValues.put("budget", _budget);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("progress", _progress);
		_columnOriginalValues.put("actualStartDate", _actualStartDate);
		_columnOriginalValues.put("actualEndDate", _actualEndDate);
		_columnOriginalValues.put("progressType", _progressType);
		_columnOriginalValues.put("businessId", _businessId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("code_", "code");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("externalReferenceCode", 2L);

		columnBitmasks.put("projectId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("accountId", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("modifiedId", 256L);

		columnBitmasks.put("name", 512L);

		columnBitmasks.put("code_", 1024L);

		columnBitmasks.put("startDate", 2048L);

		columnBitmasks.put("endDate", 4096L);

		columnBitmasks.put("budget", 8192L);

		columnBitmasks.put("description", 16384L);

		columnBitmasks.put("status", 32768L);

		columnBitmasks.put("progress", 65536L);

		columnBitmasks.put("actualStartDate", 131072L);

		columnBitmasks.put("actualEndDate", 262144L);

		columnBitmasks.put("progressType", 524288L);

		columnBitmasks.put("businessId", 1048576L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProjectEntry _escapedModel;

}