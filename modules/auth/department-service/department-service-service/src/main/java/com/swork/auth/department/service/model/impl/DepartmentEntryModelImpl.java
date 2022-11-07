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

package com.swork.auth.department.service.model.impl;

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

import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.model.DepartmentEntryModel;

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
 * The base model implementation for the DepartmentEntry service. Represents a row in the &quot;SW_Department&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DepartmentEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DepartmentEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentEntryImpl
 * @generated
 */
public class DepartmentEntryModelImpl
	extends BaseModelImpl<DepartmentEntry> implements DepartmentEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a department entry model instance should use the <code>DepartmentEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "SW_Department";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"departmentId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"accountId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedId", Types.BIGINT},
		{"modifiedDate", Types.TIMESTAMP}, {"businessId", Types.BIGINT},
		{"name", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("departmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("accountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("businessId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SW_Department (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,departmentId LONG not null primary key,groupId LONG,companyId LONG,accountId LONG,createDate DATE null,modifiedId LONG,modifiedDate DATE null,businessId LONG,name VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table SW_Department";

	public static final String ORDER_BY_JPQL =
		" ORDER BY departmentEntry.departmentId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SW_Department.departmentId ASC";

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
	public static final long NAME_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DEPARTMENTID_COLUMN_BITMASK = 32L;

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

	public DepartmentEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _departmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDepartmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _departmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DepartmentEntry.class;
	}

	@Override
	public String getModelClassName() {
		return DepartmentEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DepartmentEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DepartmentEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DepartmentEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DepartmentEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DepartmentEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DepartmentEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DepartmentEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DepartmentEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DepartmentEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DepartmentEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DepartmentEntry.class.getClassLoader(), DepartmentEntry.class,
			ModelWrapper.class);

		try {
			Constructor<DepartmentEntry> constructor =
				(Constructor<DepartmentEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<DepartmentEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DepartmentEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DepartmentEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<DepartmentEntry, Object>>();
		Map<String, BiConsumer<DepartmentEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DepartmentEntry, ?>>();

		attributeGetterFunctions.put("uuid", DepartmentEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<DepartmentEntry, String>)DepartmentEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode", DepartmentEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<DepartmentEntry, String>)
				DepartmentEntry::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"departmentId", DepartmentEntry::getDepartmentId);
		attributeSetterBiConsumers.put(
			"departmentId",
			(BiConsumer<DepartmentEntry, Long>)
				DepartmentEntry::setDepartmentId);
		attributeGetterFunctions.put("groupId", DepartmentEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DepartmentEntry, Long>)DepartmentEntry::setGroupId);
		attributeGetterFunctions.put(
			"companyId", DepartmentEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DepartmentEntry, Long>)DepartmentEntry::setCompanyId);
		attributeGetterFunctions.put(
			"accountId", DepartmentEntry::getAccountId);
		attributeSetterBiConsumers.put(
			"accountId",
			(BiConsumer<DepartmentEntry, Long>)DepartmentEntry::setAccountId);
		attributeGetterFunctions.put(
			"createDate", DepartmentEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DepartmentEntry, Date>)DepartmentEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedId", DepartmentEntry::getModifiedId);
		attributeSetterBiConsumers.put(
			"modifiedId",
			(BiConsumer<DepartmentEntry, Long>)DepartmentEntry::setModifiedId);
		attributeGetterFunctions.put(
			"modifiedDate", DepartmentEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DepartmentEntry, Date>)
				DepartmentEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"businessId", DepartmentEntry::getBusinessId);
		attributeSetterBiConsumers.put(
			"businessId",
			(BiConsumer<DepartmentEntry, Long>)DepartmentEntry::setBusinessId);
		attributeGetterFunctions.put("name", DepartmentEntry::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<DepartmentEntry, String>)DepartmentEntry::setName);

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
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_departmentId = departmentId;
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
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(DepartmentEntry.class.getName()));
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
			getCompanyId(), DepartmentEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DepartmentEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DepartmentEntry>
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
		DepartmentEntryImpl departmentEntryImpl = new DepartmentEntryImpl();

		departmentEntryImpl.setUuid(getUuid());
		departmentEntryImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		departmentEntryImpl.setDepartmentId(getDepartmentId());
		departmentEntryImpl.setGroupId(getGroupId());
		departmentEntryImpl.setCompanyId(getCompanyId());
		departmentEntryImpl.setAccountId(getAccountId());
		departmentEntryImpl.setCreateDate(getCreateDate());
		departmentEntryImpl.setModifiedId(getModifiedId());
		departmentEntryImpl.setModifiedDate(getModifiedDate());
		departmentEntryImpl.setBusinessId(getBusinessId());
		departmentEntryImpl.setName(getName());

		departmentEntryImpl.resetOriginalValues();

		return departmentEntryImpl;
	}

	@Override
	public DepartmentEntry cloneWithOriginalValues() {
		DepartmentEntryImpl departmentEntryImpl = new DepartmentEntryImpl();

		departmentEntryImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		departmentEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		departmentEntryImpl.setDepartmentId(
			this.<Long>getColumnOriginalValue("departmentId"));
		departmentEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		departmentEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		departmentEntryImpl.setAccountId(
			this.<Long>getColumnOriginalValue("accountId"));
		departmentEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		departmentEntryImpl.setModifiedId(
			this.<Long>getColumnOriginalValue("modifiedId"));
		departmentEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		departmentEntryImpl.setBusinessId(
			this.<Long>getColumnOriginalValue("businessId"));
		departmentEntryImpl.setName(
			this.<String>getColumnOriginalValue("name"));

		return departmentEntryImpl;
	}

	@Override
	public int compareTo(DepartmentEntry departmentEntry) {
		long primaryKey = departmentEntry.getPrimaryKey();

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

		if (!(object instanceof DepartmentEntry)) {
			return false;
		}

		DepartmentEntry departmentEntry = (DepartmentEntry)object;

		long primaryKey = departmentEntry.getPrimaryKey();

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
	public CacheModel<DepartmentEntry> toCacheModel() {
		DepartmentEntryCacheModel departmentEntryCacheModel =
			new DepartmentEntryCacheModel();

		departmentEntryCacheModel.uuid = getUuid();

		String uuid = departmentEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			departmentEntryCacheModel.uuid = null;
		}

		departmentEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			departmentEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			departmentEntryCacheModel.externalReferenceCode = null;
		}

		departmentEntryCacheModel.departmentId = getDepartmentId();

		departmentEntryCacheModel.groupId = getGroupId();

		departmentEntryCacheModel.companyId = getCompanyId();

		departmentEntryCacheModel.accountId = getAccountId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			departmentEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			departmentEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		departmentEntryCacheModel.modifiedId = getModifiedId();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			departmentEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			departmentEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		departmentEntryCacheModel.businessId = getBusinessId();

		departmentEntryCacheModel.name = getName();

		String name = departmentEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			departmentEntryCacheModel.name = null;
		}

		return departmentEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DepartmentEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DepartmentEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DepartmentEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DepartmentEntry)this);

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
		Map<String, Function<DepartmentEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DepartmentEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DepartmentEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DepartmentEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DepartmentEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _departmentId;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private Date _createDate;
	private long _modifiedId;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _businessId;
	private String _name;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DepartmentEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DepartmentEntry)this);
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
		_columnOriginalValues.put("departmentId", _departmentId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("accountId", _accountId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedId", _modifiedId);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("businessId", _businessId);
		_columnOriginalValues.put("name", _name);
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

		columnBitmasks.put("departmentId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("accountId", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedId", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("businessId", 512L);

		columnBitmasks.put("name", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DepartmentEntry _escapedModel;

}