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

package com.swork.notification.service.model.impl;

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

import com.swork.notification.service.model.NotificationEntry;
import com.swork.notification.service.model.NotificationEntryModel;

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
 * The base model implementation for the NotificationEntry service. Represents a row in the &quot;SW_Notification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>NotificationEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NotificationEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationEntryImpl
 * @generated
 */
public class NotificationEntryModelImpl
	extends BaseModelImpl<NotificationEntry> implements NotificationEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a notification entry model instance should use the <code>NotificationEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "SW_Notification";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"id_", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"accountId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"editorId", Types.BIGINT},
		{"category", Types.VARCHAR}, {"name", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"status", Types.VARCHAR},
		{"receiverId", Types.BIGINT}, {"subjectId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("accountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("editorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("category", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("receiverId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("subjectId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SW_Notification (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,accountId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,editorId LONG,category VARCHAR(75) null,name VARCHAR(75) null,description VARCHAR(75) null,status VARCHAR(75) null,receiverId LONG,subjectId LONG)";

	public static final String TABLE_SQL_DROP = "drop table SW_Notification";

	public static final String ORDER_BY_JPQL =
		" ORDER BY notificationEntry.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SW_Notification.id_ ASC";

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
	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long RECEIVERID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SUBJECTID_COLUMN_BITMASK = 32L;

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
	public static final long ID_COLUMN_BITMASK = 128L;

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

	public NotificationEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return NotificationEntry.class;
	}

	@Override
	public String getModelClassName() {
		return NotificationEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<NotificationEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<NotificationEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NotificationEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((NotificationEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<NotificationEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<NotificationEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(NotificationEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<NotificationEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<NotificationEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, NotificationEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			NotificationEntry.class.getClassLoader(), NotificationEntry.class,
			ModelWrapper.class);

		try {
			Constructor<NotificationEntry> constructor =
				(Constructor<NotificationEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<NotificationEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<NotificationEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<NotificationEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<NotificationEntry, Object>>();
		Map<String, BiConsumer<NotificationEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<NotificationEntry, ?>>();

		attributeGetterFunctions.put("uuid", NotificationEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<NotificationEntry, String>)NotificationEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode",
			NotificationEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<NotificationEntry, String>)
				NotificationEntry::setExternalReferenceCode);
		attributeGetterFunctions.put("id", NotificationEntry::getId);
		attributeSetterBiConsumers.put(
			"id",
			(BiConsumer<NotificationEntry, Long>)NotificationEntry::setId);
		attributeGetterFunctions.put("groupId", NotificationEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<NotificationEntry, Long>)NotificationEntry::setGroupId);
		attributeGetterFunctions.put(
			"companyId", NotificationEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<NotificationEntry, Long>)
				NotificationEntry::setCompanyId);
		attributeGetterFunctions.put(
			"accountId", NotificationEntry::getAccountId);
		attributeSetterBiConsumers.put(
			"accountId",
			(BiConsumer<NotificationEntry, Long>)
				NotificationEntry::setAccountId);
		attributeGetterFunctions.put(
			"userName", NotificationEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<NotificationEntry, String>)
				NotificationEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", NotificationEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<NotificationEntry, Date>)
				NotificationEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", NotificationEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<NotificationEntry, Date>)
				NotificationEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"editorId", NotificationEntry::getEditorId);
		attributeSetterBiConsumers.put(
			"editorId",
			(BiConsumer<NotificationEntry, Long>)
				NotificationEntry::setEditorId);
		attributeGetterFunctions.put(
			"category", NotificationEntry::getCategory);
		attributeSetterBiConsumers.put(
			"category",
			(BiConsumer<NotificationEntry, String>)
				NotificationEntry::setCategory);
		attributeGetterFunctions.put("name", NotificationEntry::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<NotificationEntry, String>)NotificationEntry::setName);
		attributeGetterFunctions.put(
			"description", NotificationEntry::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<NotificationEntry, String>)
				NotificationEntry::setDescription);
		attributeGetterFunctions.put("status", NotificationEntry::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<NotificationEntry, String>)
				NotificationEntry::setStatus);
		attributeGetterFunctions.put(
			"receiverId", NotificationEntry::getReceiverId);
		attributeSetterBiConsumers.put(
			"receiverId",
			(BiConsumer<NotificationEntry, Long>)
				NotificationEntry::setReceiverId);
		attributeGetterFunctions.put(
			"subjectId", NotificationEntry::getSubjectId);
		attributeSetterBiConsumers.put(
			"subjectId",
			(BiConsumer<NotificationEntry, Long>)
				NotificationEntry::setSubjectId);

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
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
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
	public long getEditorId() {
		return _editorId;
	}

	@Override
	public void setEditorId(long editorId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_editorId = editorId;
	}

	@Override
	public String getCategory() {
		if (_category == null) {
			return "";
		}
		else {
			return _category;
		}
	}

	@Override
	public void setCategory(String category) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_category = category;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalStatus() {
		return getColumnOriginalValue("status");
	}

	@Override
	public long getReceiverId() {
		return _receiverId;
	}

	@Override
	public void setReceiverId(long receiverId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_receiverId = receiverId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalReceiverId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("receiverId"));
	}

	@Override
	public long getSubjectId() {
		return _subjectId;
	}

	@Override
	public void setSubjectId(long subjectId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_subjectId = subjectId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalSubjectId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("subjectId"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(NotificationEntry.class.getName()));
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
			getCompanyId(), NotificationEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NotificationEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, NotificationEntry>
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
		NotificationEntryImpl notificationEntryImpl =
			new NotificationEntryImpl();

		notificationEntryImpl.setUuid(getUuid());
		notificationEntryImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		notificationEntryImpl.setId(getId());
		notificationEntryImpl.setGroupId(getGroupId());
		notificationEntryImpl.setCompanyId(getCompanyId());
		notificationEntryImpl.setAccountId(getAccountId());
		notificationEntryImpl.setUserName(getUserName());
		notificationEntryImpl.setCreateDate(getCreateDate());
		notificationEntryImpl.setModifiedDate(getModifiedDate());
		notificationEntryImpl.setEditorId(getEditorId());
		notificationEntryImpl.setCategory(getCategory());
		notificationEntryImpl.setName(getName());
		notificationEntryImpl.setDescription(getDescription());
		notificationEntryImpl.setStatus(getStatus());
		notificationEntryImpl.setReceiverId(getReceiverId());
		notificationEntryImpl.setSubjectId(getSubjectId());

		notificationEntryImpl.resetOriginalValues();

		return notificationEntryImpl;
	}

	@Override
	public NotificationEntry cloneWithOriginalValues() {
		NotificationEntryImpl notificationEntryImpl =
			new NotificationEntryImpl();

		notificationEntryImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		notificationEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		notificationEntryImpl.setId(this.<Long>getColumnOriginalValue("id_"));
		notificationEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		notificationEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		notificationEntryImpl.setAccountId(
			this.<Long>getColumnOriginalValue("accountId"));
		notificationEntryImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		notificationEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		notificationEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		notificationEntryImpl.setEditorId(
			this.<Long>getColumnOriginalValue("editorId"));
		notificationEntryImpl.setCategory(
			this.<String>getColumnOriginalValue("category"));
		notificationEntryImpl.setName(
			this.<String>getColumnOriginalValue("name"));
		notificationEntryImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		notificationEntryImpl.setStatus(
			this.<String>getColumnOriginalValue("status"));
		notificationEntryImpl.setReceiverId(
			this.<Long>getColumnOriginalValue("receiverId"));
		notificationEntryImpl.setSubjectId(
			this.<Long>getColumnOriginalValue("subjectId"));

		return notificationEntryImpl;
	}

	@Override
	public int compareTo(NotificationEntry notificationEntry) {
		long primaryKey = notificationEntry.getPrimaryKey();

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

		if (!(object instanceof NotificationEntry)) {
			return false;
		}

		NotificationEntry notificationEntry = (NotificationEntry)object;

		long primaryKey = notificationEntry.getPrimaryKey();

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
	public CacheModel<NotificationEntry> toCacheModel() {
		NotificationEntryCacheModel notificationEntryCacheModel =
			new NotificationEntryCacheModel();

		notificationEntryCacheModel.uuid = getUuid();

		String uuid = notificationEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			notificationEntryCacheModel.uuid = null;
		}

		notificationEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			notificationEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			notificationEntryCacheModel.externalReferenceCode = null;
		}

		notificationEntryCacheModel.id = getId();

		notificationEntryCacheModel.groupId = getGroupId();

		notificationEntryCacheModel.companyId = getCompanyId();

		notificationEntryCacheModel.accountId = getAccountId();

		notificationEntryCacheModel.userName = getUserName();

		String userName = notificationEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			notificationEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			notificationEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			notificationEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			notificationEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			notificationEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		notificationEntryCacheModel.editorId = getEditorId();

		notificationEntryCacheModel.category = getCategory();

		String category = notificationEntryCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			notificationEntryCacheModel.category = null;
		}

		notificationEntryCacheModel.name = getName();

		String name = notificationEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			notificationEntryCacheModel.name = null;
		}

		notificationEntryCacheModel.description = getDescription();

		String description = notificationEntryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			notificationEntryCacheModel.description = null;
		}

		notificationEntryCacheModel.status = getStatus();

		String status = notificationEntryCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			notificationEntryCacheModel.status = null;
		}

		notificationEntryCacheModel.receiverId = getReceiverId();

		notificationEntryCacheModel.subjectId = getSubjectId();

		return notificationEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<NotificationEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<NotificationEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NotificationEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(NotificationEntry)this);

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
		Map<String, Function<NotificationEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<NotificationEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NotificationEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((NotificationEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, NotificationEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _editorId;
	private String _category;
	private String _name;
	private String _description;
	private String _status;
	private long _receiverId;
	private long _subjectId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<NotificationEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((NotificationEntry)this);
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
		_columnOriginalValues.put("id_", _id);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("accountId", _accountId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("editorId", _editorId);
		_columnOriginalValues.put("category", _category);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("receiverId", _receiverId);
		_columnOriginalValues.put("subjectId", _subjectId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("id_", "id");

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

		columnBitmasks.put("id_", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("accountId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("editorId", 512L);

		columnBitmasks.put("category", 1024L);

		columnBitmasks.put("name", 2048L);

		columnBitmasks.put("description", 4096L);

		columnBitmasks.put("status", 8192L);

		columnBitmasks.put("receiverId", 16384L);

		columnBitmasks.put("subjectId", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private NotificationEntry _escapedModel;

}