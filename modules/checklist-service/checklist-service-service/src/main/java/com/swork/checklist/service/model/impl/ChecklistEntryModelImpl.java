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

package com.swork.checklist.service.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.swork.checklist.service.model.ChecklistEntry;
import com.swork.checklist.service.model.ChecklistEntryModel;
import com.swork.checklist.service.model.ChecklistEntrySoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ChecklistEntry service. Represents a row in the &quot;SW_CHECKLIST_ChecklistEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ChecklistEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChecklistEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistEntryImpl
 * @generated
 */
@JSON(strict = true)
public class ChecklistEntryModelImpl
	extends BaseModelImpl<ChecklistEntry> implements ChecklistEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a checklist entry model instance should use the <code>ChecklistEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "SW_CHECKLIST_ChecklistEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"checklistId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"taskId", Types.BIGINT},
		{"status", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("checklistId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("taskId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SW_CHECKLIST_ChecklistEntry (uuid_ VARCHAR(75) null,checklistId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,taskId LONG,status BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table SW_CHECKLIST_ChecklistEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY checklistEntry.checklistId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SW_CHECKLIST_ChecklistEntry.checklistId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CHECKLISTID_COLUMN_BITMASK = 8L;

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

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static ChecklistEntry toModel(ChecklistEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ChecklistEntry model = new ChecklistEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setChecklistId(soapModel.getChecklistId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setTaskId(soapModel.getTaskId());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<ChecklistEntry> toModels(
		ChecklistEntrySoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<ChecklistEntry> models = new ArrayList<ChecklistEntry>(
			soapModels.length);

		for (ChecklistEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ChecklistEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _checklistId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setChecklistId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _checklistId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ChecklistEntry.class;
	}

	@Override
	public String getModelClassName() {
		return ChecklistEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ChecklistEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ChecklistEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChecklistEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ChecklistEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ChecklistEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ChecklistEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ChecklistEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ChecklistEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ChecklistEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ChecklistEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ChecklistEntry.class.getClassLoader(), ChecklistEntry.class,
			ModelWrapper.class);

		try {
			Constructor<ChecklistEntry> constructor =
				(Constructor<ChecklistEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<ChecklistEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ChecklistEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ChecklistEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ChecklistEntry, Object>>();
		Map<String, BiConsumer<ChecklistEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ChecklistEntry, ?>>();

		attributeGetterFunctions.put("uuid", ChecklistEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ChecklistEntry, String>)ChecklistEntry::setUuid);
		attributeGetterFunctions.put(
			"checklistId", ChecklistEntry::getChecklistId);
		attributeSetterBiConsumers.put(
			"checklistId",
			(BiConsumer<ChecklistEntry, Long>)ChecklistEntry::setChecklistId);
		attributeGetterFunctions.put("groupId", ChecklistEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ChecklistEntry, Long>)ChecklistEntry::setGroupId);
		attributeGetterFunctions.put("companyId", ChecklistEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ChecklistEntry, Long>)ChecklistEntry::setCompanyId);
		attributeGetterFunctions.put("userId", ChecklistEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ChecklistEntry, Long>)ChecklistEntry::setUserId);
		attributeGetterFunctions.put("userName", ChecklistEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ChecklistEntry, String>)ChecklistEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", ChecklistEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ChecklistEntry, Date>)ChecklistEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ChecklistEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ChecklistEntry, Date>)ChecklistEntry::setModifiedDate);
		attributeGetterFunctions.put("name", ChecklistEntry::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<ChecklistEntry, String>)ChecklistEntry::setName);
		attributeGetterFunctions.put("taskId", ChecklistEntry::getTaskId);
		attributeSetterBiConsumers.put(
			"taskId",
			(BiConsumer<ChecklistEntry, Long>)ChecklistEntry::setTaskId);
		attributeGetterFunctions.put("status", ChecklistEntry::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<ChecklistEntry, Boolean>)ChecklistEntry::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
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

	@JSON
	@Override
	public long getChecklistId() {
		return _checklistId;
	}

	@Override
	public void setChecklistId(long checklistId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_checklistId = checklistId;
	}

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public Long getTaskId() {
		return _taskId;
	}

	@Override
	public void setTaskId(Long taskId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_taskId = taskId;
	}

	@JSON
	@Override
	public Boolean getStatus() {
		return _status;
	}

	@Override
	public void setStatus(Boolean status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ChecklistEntry.class.getName()));
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
			getCompanyId(), ChecklistEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ChecklistEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ChecklistEntry>
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
		ChecklistEntryImpl checklistEntryImpl = new ChecklistEntryImpl();

		checklistEntryImpl.setUuid(getUuid());
		checklistEntryImpl.setChecklistId(getChecklistId());
		checklistEntryImpl.setGroupId(getGroupId());
		checklistEntryImpl.setCompanyId(getCompanyId());
		checklistEntryImpl.setUserId(getUserId());
		checklistEntryImpl.setUserName(getUserName());
		checklistEntryImpl.setCreateDate(getCreateDate());
		checklistEntryImpl.setModifiedDate(getModifiedDate());
		checklistEntryImpl.setName(getName());
		checklistEntryImpl.setTaskId(getTaskId());
		checklistEntryImpl.setStatus(getStatus());

		checklistEntryImpl.resetOriginalValues();

		return checklistEntryImpl;
	}

	@Override
	public ChecklistEntry cloneWithOriginalValues() {
		ChecklistEntryImpl checklistEntryImpl = new ChecklistEntryImpl();

		checklistEntryImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		checklistEntryImpl.setChecklistId(
			this.<Long>getColumnOriginalValue("checklistId"));
		checklistEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		checklistEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		checklistEntryImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		checklistEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		checklistEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		checklistEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		checklistEntryImpl.setName(this.<String>getColumnOriginalValue("name"));
		checklistEntryImpl.setTaskId(
			this.<Long>getColumnOriginalValue("taskId"));
		checklistEntryImpl.setStatus(
			this.<Boolean>getColumnOriginalValue("status"));

		return checklistEntryImpl;
	}

	@Override
	public int compareTo(ChecklistEntry checklistEntry) {
		long primaryKey = checklistEntry.getPrimaryKey();

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

		if (!(object instanceof ChecklistEntry)) {
			return false;
		}

		ChecklistEntry checklistEntry = (ChecklistEntry)object;

		long primaryKey = checklistEntry.getPrimaryKey();

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
	public CacheModel<ChecklistEntry> toCacheModel() {
		ChecklistEntryCacheModel checklistEntryCacheModel =
			new ChecklistEntryCacheModel();

		checklistEntryCacheModel.uuid = getUuid();

		String uuid = checklistEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			checklistEntryCacheModel.uuid = null;
		}

		checklistEntryCacheModel.checklistId = getChecklistId();

		checklistEntryCacheModel.groupId = getGroupId();

		checklistEntryCacheModel.companyId = getCompanyId();

		checklistEntryCacheModel.userId = getUserId();

		checklistEntryCacheModel.userName = getUserName();

		String userName = checklistEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			checklistEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			checklistEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			checklistEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			checklistEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			checklistEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		checklistEntryCacheModel.name = getName();

		String name = checklistEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			checklistEntryCacheModel.name = null;
		}

		Long taskId = getTaskId();

		if (taskId != null) {
			checklistEntryCacheModel.taskId = taskId;
		}

		Boolean status = getStatus();

		if (status != null) {
			checklistEntryCacheModel.status = status;
		}

		return checklistEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ChecklistEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ChecklistEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChecklistEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((ChecklistEntry)this);

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
		Map<String, Function<ChecklistEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ChecklistEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChecklistEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ChecklistEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ChecklistEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _checklistId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private Long _taskId;
	private Boolean _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ChecklistEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ChecklistEntry)this);
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
		_columnOriginalValues.put("checklistId", _checklistId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("taskId", _taskId);
		_columnOriginalValues.put("status", _status);
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

		columnBitmasks.put("checklistId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("name", 256L);

		columnBitmasks.put("taskId", 512L);

		columnBitmasks.put("status", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ChecklistEntry _escapedModel;

}