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

package com.swork.core.resource.service.model.impl;

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

import com.swork.core.resource.service.model.TeamEntry;
import com.swork.core.resource.service.model.TeamEntryModel;

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
 * The base model implementation for the TeamEntry service. Represents a row in the &quot;SW_Team&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TeamEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TeamEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamEntryImpl
 * @generated
 */
public class TeamEntryModelImpl
	extends BaseModelImpl<TeamEntry> implements TeamEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a team entry model instance should use the <code>TeamEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "SW_Team";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"teamId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"accountId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"businessId", Types.BIGINT}, {"modifiedId", Types.BIGINT},
		{"name", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"isActive", Types.BOOLEAN}, {"phaseId", Types.BIGINT},
		{"projectId", Types.BIGINT}, {"totalIncoming", Types.BIGINT},
		{"totalSpending", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("teamId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("accountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("businessId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isActive", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("phaseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalIncoming", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalSpending", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SW_Team (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,teamId LONG not null primary key,groupId LONG,companyId LONG,accountId LONG,createDate DATE null,modifiedDate DATE null,businessId LONG,modifiedId LONG,name VARCHAR(75) null,description VARCHAR(75) null,isActive BOOLEAN,phaseId LONG,projectId LONG,totalIncoming LONG,totalSpending LONG)";

	public static final String TABLE_SQL_DROP = "drop table SW_Team";

	public static final String ORDER_BY_JPQL = " ORDER BY teamEntry.teamId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY SW_Team.teamId ASC";

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
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PHASEID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROJECTID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TEAMID_COLUMN_BITMASK = 256L;

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

	public TeamEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _teamId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTeamId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _teamId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TeamEntry.class;
	}

	@Override
	public String getModelClassName() {
		return TeamEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TeamEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TeamEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TeamEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((TeamEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TeamEntry, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TeamEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TeamEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TeamEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TeamEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TeamEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TeamEntry.class.getClassLoader(), TeamEntry.class,
			ModelWrapper.class);

		try {
			Constructor<TeamEntry> constructor =
				(Constructor<TeamEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<TeamEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TeamEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TeamEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TeamEntry, Object>>();
		Map<String, BiConsumer<TeamEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TeamEntry, ?>>();

		attributeGetterFunctions.put("uuid", TeamEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<TeamEntry, String>)TeamEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode", TeamEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<TeamEntry, String>)TeamEntry::setExternalReferenceCode);
		attributeGetterFunctions.put("teamId", TeamEntry::getTeamId);
		attributeSetterBiConsumers.put(
			"teamId", (BiConsumer<TeamEntry, Long>)TeamEntry::setTeamId);
		attributeGetterFunctions.put("groupId", TeamEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<TeamEntry, Long>)TeamEntry::setGroupId);
		attributeGetterFunctions.put("companyId", TeamEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<TeamEntry, Long>)TeamEntry::setCompanyId);
		attributeGetterFunctions.put("accountId", TeamEntry::getAccountId);
		attributeSetterBiConsumers.put(
			"accountId", (BiConsumer<TeamEntry, Long>)TeamEntry::setAccountId);
		attributeGetterFunctions.put("createDate", TeamEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TeamEntry, Date>)TeamEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TeamEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TeamEntry, Date>)TeamEntry::setModifiedDate);
		attributeGetterFunctions.put("businessId", TeamEntry::getBusinessId);
		attributeSetterBiConsumers.put(
			"businessId",
			(BiConsumer<TeamEntry, Long>)TeamEntry::setBusinessId);
		attributeGetterFunctions.put("modifiedId", TeamEntry::getModifiedId);
		attributeSetterBiConsumers.put(
			"modifiedId",
			(BiConsumer<TeamEntry, Long>)TeamEntry::setModifiedId);
		attributeGetterFunctions.put("name", TeamEntry::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<TeamEntry, String>)TeamEntry::setName);
		attributeGetterFunctions.put("description", TeamEntry::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<TeamEntry, String>)TeamEntry::setDescription);
		attributeGetterFunctions.put("isActive", TeamEntry::getIsActive);
		attributeSetterBiConsumers.put(
			"isActive", (BiConsumer<TeamEntry, Boolean>)TeamEntry::setIsActive);
		attributeGetterFunctions.put("phaseId", TeamEntry::getPhaseId);
		attributeSetterBiConsumers.put(
			"phaseId", (BiConsumer<TeamEntry, Long>)TeamEntry::setPhaseId);
		attributeGetterFunctions.put("projectId", TeamEntry::getProjectId);
		attributeSetterBiConsumers.put(
			"projectId", (BiConsumer<TeamEntry, Long>)TeamEntry::setProjectId);
		attributeGetterFunctions.put(
			"totalIncoming", TeamEntry::getTotalIncoming);
		attributeSetterBiConsumers.put(
			"totalIncoming",
			(BiConsumer<TeamEntry, Long>)TeamEntry::setTotalIncoming);
		attributeGetterFunctions.put(
			"totalSpending", TeamEntry::getTotalSpending);
		attributeSetterBiConsumers.put(
			"totalSpending",
			(BiConsumer<TeamEntry, Long>)TeamEntry::setTotalSpending);

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
	public long getTeamId() {
		return _teamId;
	}

	@Override
	public void setTeamId(long teamId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_teamId = teamId;
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
	public Boolean getIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(Boolean isActive) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isActive = isActive;
	}

	@Override
	public Long getPhaseId() {
		return _phaseId;
	}

	@Override
	public void setPhaseId(Long phaseId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_phaseId = phaseId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Long getOriginalPhaseId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("phaseId"));
	}

	@Override
	public Long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(Long projectId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_projectId = projectId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Long getOriginalProjectId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("projectId"));
	}

	@Override
	public Long getTotalIncoming() {
		return _totalIncoming;
	}

	@Override
	public void setTotalIncoming(Long totalIncoming) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_totalIncoming = totalIncoming;
	}

	@Override
	public Long getTotalSpending() {
		return _totalSpending;
	}

	@Override
	public void setTotalSpending(Long totalSpending) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_totalSpending = totalSpending;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(TeamEntry.class.getName()));
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
			getCompanyId(), TeamEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TeamEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TeamEntry>
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
		TeamEntryImpl teamEntryImpl = new TeamEntryImpl();

		teamEntryImpl.setUuid(getUuid());
		teamEntryImpl.setExternalReferenceCode(getExternalReferenceCode());
		teamEntryImpl.setTeamId(getTeamId());
		teamEntryImpl.setGroupId(getGroupId());
		teamEntryImpl.setCompanyId(getCompanyId());
		teamEntryImpl.setAccountId(getAccountId());
		teamEntryImpl.setCreateDate(getCreateDate());
		teamEntryImpl.setModifiedDate(getModifiedDate());
		teamEntryImpl.setBusinessId(getBusinessId());
		teamEntryImpl.setModifiedId(getModifiedId());
		teamEntryImpl.setName(getName());
		teamEntryImpl.setDescription(getDescription());
		teamEntryImpl.setIsActive(getIsActive());
		teamEntryImpl.setPhaseId(getPhaseId());
		teamEntryImpl.setProjectId(getProjectId());
		teamEntryImpl.setTotalIncoming(getTotalIncoming());
		teamEntryImpl.setTotalSpending(getTotalSpending());

		teamEntryImpl.resetOriginalValues();

		return teamEntryImpl;
	}

	@Override
	public TeamEntry cloneWithOriginalValues() {
		TeamEntryImpl teamEntryImpl = new TeamEntryImpl();

		teamEntryImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		teamEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		teamEntryImpl.setTeamId(this.<Long>getColumnOriginalValue("teamId"));
		teamEntryImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		teamEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		teamEntryImpl.setAccountId(
			this.<Long>getColumnOriginalValue("accountId"));
		teamEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		teamEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		teamEntryImpl.setBusinessId(
			this.<Long>getColumnOriginalValue("businessId"));
		teamEntryImpl.setModifiedId(
			this.<Long>getColumnOriginalValue("modifiedId"));
		teamEntryImpl.setName(this.<String>getColumnOriginalValue("name"));
		teamEntryImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		teamEntryImpl.setIsActive(
			this.<Boolean>getColumnOriginalValue("isActive"));
		teamEntryImpl.setPhaseId(this.<Long>getColumnOriginalValue("phaseId"));
		teamEntryImpl.setProjectId(
			this.<Long>getColumnOriginalValue("projectId"));
		teamEntryImpl.setTotalIncoming(
			this.<Long>getColumnOriginalValue("totalIncoming"));
		teamEntryImpl.setTotalSpending(
			this.<Long>getColumnOriginalValue("totalSpending"));

		return teamEntryImpl;
	}

	@Override
	public int compareTo(TeamEntry teamEntry) {
		long primaryKey = teamEntry.getPrimaryKey();

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

		if (!(object instanceof TeamEntry)) {
			return false;
		}

		TeamEntry teamEntry = (TeamEntry)object;

		long primaryKey = teamEntry.getPrimaryKey();

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
	public CacheModel<TeamEntry> toCacheModel() {
		TeamEntryCacheModel teamEntryCacheModel = new TeamEntryCacheModel();

		teamEntryCacheModel.uuid = getUuid();

		String uuid = teamEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			teamEntryCacheModel.uuid = null;
		}

		teamEntryCacheModel.externalReferenceCode = getExternalReferenceCode();

		String externalReferenceCode =
			teamEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			teamEntryCacheModel.externalReferenceCode = null;
		}

		teamEntryCacheModel.teamId = getTeamId();

		teamEntryCacheModel.groupId = getGroupId();

		teamEntryCacheModel.companyId = getCompanyId();

		teamEntryCacheModel.accountId = getAccountId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			teamEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			teamEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			teamEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			teamEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		teamEntryCacheModel.businessId = getBusinessId();

		teamEntryCacheModel.modifiedId = getModifiedId();

		teamEntryCacheModel.name = getName();

		String name = teamEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			teamEntryCacheModel.name = null;
		}

		teamEntryCacheModel.description = getDescription();

		String description = teamEntryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			teamEntryCacheModel.description = null;
		}

		Boolean isActive = getIsActive();

		if (isActive != null) {
			teamEntryCacheModel.isActive = isActive;
		}

		Long phaseId = getPhaseId();

		if (phaseId != null) {
			teamEntryCacheModel.phaseId = phaseId;
		}

		Long projectId = getProjectId();

		if (projectId != null) {
			teamEntryCacheModel.projectId = projectId;
		}

		Long totalIncoming = getTotalIncoming();

		if (totalIncoming != null) {
			teamEntryCacheModel.totalIncoming = totalIncoming;
		}

		Long totalSpending = getTotalSpending();

		if (totalSpending != null) {
			teamEntryCacheModel.totalSpending = totalSpending;
		}

		return teamEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TeamEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TeamEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TeamEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((TeamEntry)this);

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
		Map<String, Function<TeamEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TeamEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TeamEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TeamEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TeamEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _teamId;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _businessId;
	private long _modifiedId;
	private String _name;
	private String _description;
	private Boolean _isActive;
	private Long _phaseId;
	private Long _projectId;
	private Long _totalIncoming;
	private Long _totalSpending;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<TeamEntry, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((TeamEntry)this);
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
		_columnOriginalValues.put("teamId", _teamId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("accountId", _accountId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("businessId", _businessId);
		_columnOriginalValues.put("modifiedId", _modifiedId);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("isActive", _isActive);
		_columnOriginalValues.put("phaseId", _phaseId);
		_columnOriginalValues.put("projectId", _projectId);
		_columnOriginalValues.put("totalIncoming", _totalIncoming);
		_columnOriginalValues.put("totalSpending", _totalSpending);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

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

		columnBitmasks.put("teamId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("accountId", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("businessId", 256L);

		columnBitmasks.put("modifiedId", 512L);

		columnBitmasks.put("name", 1024L);

		columnBitmasks.put("description", 2048L);

		columnBitmasks.put("isActive", 4096L);

		columnBitmasks.put("phaseId", 8192L);

		columnBitmasks.put("projectId", 16384L);

		columnBitmasks.put("totalIncoming", 32768L);

		columnBitmasks.put("totalSpending", 65536L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private TeamEntry _escapedModel;

}