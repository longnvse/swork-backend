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

package com.swork.account.service.model.impl;

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

import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.model.AccountEntryModel;

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
 * The base model implementation for the AccountEntry service. Represents a row in the &quot;SW_AccountEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AccountEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AccountEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryImpl
 * @generated
 */
public class AccountEntryModelImpl
	extends BaseModelImpl<AccountEntry> implements AccountEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a account entry model instance should use the <code>AccountEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "SW_AccountEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"accountId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"creatorId", Types.BIGINT},
		{"username", Types.VARCHAR}, {"password_", Types.VARCHAR},
		{"fullName", Types.VARCHAR}, {"phoneNumber", Types.INTEGER},
		{"email", Types.VARCHAR}, {"address", Types.VARCHAR},
		{"departmentId", Types.BIGINT}, {"businessId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("accountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("creatorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("username", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("password_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fullName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phoneNumber", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("departmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("businessId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SW_AccountEntry (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,accountId LONG not null primary key,groupId LONG,companyId LONG,createDate DATE null,modifiedDate DATE null,creatorId LONG,username VARCHAR(75) null,password_ VARCHAR(75) null,fullName VARCHAR(75) null,phoneNumber INTEGER,email VARCHAR(75) null,address VARCHAR(75) null,departmentId LONG,businessId LONG)";

	public static final String TABLE_SQL_DROP = "drop table SW_AccountEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY accountEntry.accountId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SW_AccountEntry.accountId ASC";

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
	public static final long EMAIL_COLUMN_BITMASK = 2L;

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
	public static final long USERNAME_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ACCOUNTID_COLUMN_BITMASK = 64L;

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

	public AccountEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _accountId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAccountId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _accountId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AccountEntry.class;
	}

	@Override
	public String getModelClassName() {
		return AccountEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AccountEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AccountEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AccountEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AccountEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AccountEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AccountEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AccountEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AccountEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AccountEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AccountEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AccountEntry.class.getClassLoader(), AccountEntry.class,
			ModelWrapper.class);

		try {
			Constructor<AccountEntry> constructor =
				(Constructor<AccountEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<AccountEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AccountEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AccountEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AccountEntry, Object>>();
		Map<String, BiConsumer<AccountEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AccountEntry, ?>>();

		attributeGetterFunctions.put("uuid", AccountEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<AccountEntry, String>)AccountEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode", AccountEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<AccountEntry, String>)
				AccountEntry::setExternalReferenceCode);
		attributeGetterFunctions.put("accountId", AccountEntry::getAccountId);
		attributeSetterBiConsumers.put(
			"accountId",
			(BiConsumer<AccountEntry, Long>)AccountEntry::setAccountId);
		attributeGetterFunctions.put("groupId", AccountEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<AccountEntry, Long>)AccountEntry::setGroupId);
		attributeGetterFunctions.put("companyId", AccountEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<AccountEntry, Long>)AccountEntry::setCompanyId);
		attributeGetterFunctions.put("createDate", AccountEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<AccountEntry, Date>)AccountEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", AccountEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<AccountEntry, Date>)AccountEntry::setModifiedDate);
		attributeGetterFunctions.put("creatorId", AccountEntry::getCreatorId);
		attributeSetterBiConsumers.put(
			"creatorId",
			(BiConsumer<AccountEntry, Long>)AccountEntry::setCreatorId);
		attributeGetterFunctions.put("username", AccountEntry::getUsername);
		attributeSetterBiConsumers.put(
			"username",
			(BiConsumer<AccountEntry, String>)AccountEntry::setUsername);
		attributeGetterFunctions.put("password", AccountEntry::getPassword);
		attributeSetterBiConsumers.put(
			"password",
			(BiConsumer<AccountEntry, String>)AccountEntry::setPassword);
		attributeGetterFunctions.put("fullName", AccountEntry::getFullName);
		attributeSetterBiConsumers.put(
			"fullName",
			(BiConsumer<AccountEntry, String>)AccountEntry::setFullName);
		attributeGetterFunctions.put(
			"phoneNumber", AccountEntry::getPhoneNumber);
		attributeSetterBiConsumers.put(
			"phoneNumber",
			(BiConsumer<AccountEntry, Integer>)AccountEntry::setPhoneNumber);
		attributeGetterFunctions.put("email", AccountEntry::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<AccountEntry, String>)AccountEntry::setEmail);
		attributeGetterFunctions.put("address", AccountEntry::getAddress);
		attributeSetterBiConsumers.put(
			"address",
			(BiConsumer<AccountEntry, String>)AccountEntry::setAddress);
		attributeGetterFunctions.put(
			"departmentId", AccountEntry::getDepartmentId);
		attributeSetterBiConsumers.put(
			"departmentId",
			(BiConsumer<AccountEntry, Long>)AccountEntry::setDepartmentId);
		attributeGetterFunctions.put("businessId", AccountEntry::getBusinessId);
		attributeSetterBiConsumers.put(
			"businessId",
			(BiConsumer<AccountEntry, Long>)AccountEntry::setBusinessId);

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
	public long getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(long creatorId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_creatorId = creatorId;
	}

	@Override
	public String getUsername() {
		if (_username == null) {
			return "";
		}
		else {
			return _username;
		}
	}

	@Override
	public void setUsername(String username) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_username = username;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUsername() {
		return getColumnOriginalValue("username");
	}

	@Override
	public String getPassword() {
		if (_password == null) {
			return "";
		}
		else {
			return _password;
		}
	}

	@Override
	public void setPassword(String password) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_password = password;
	}

	@Override
	public String getFullName() {
		if (_fullName == null) {
			return "";
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fullName = fullName;
	}

	@Override
	public Integer getPhoneNumber() {
		return _phoneNumber;
	}

	@Override
	public void setPhoneNumber(Integer phoneNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_phoneNumber = phoneNumber;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalEmail() {
		return getColumnOriginalValue("email");
	}

	@Override
	public String getAddress() {
		if (_address == null) {
			return "";
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_address = address;
	}

	@Override
	public Long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(Long departmentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_departmentId = departmentId;
	}

	@Override
	public Long getBusinessId() {
		return _businessId;
	}

	@Override
	public void setBusinessId(Long businessId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_businessId = businessId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(AccountEntry.class.getName()));
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
			getCompanyId(), AccountEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AccountEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AccountEntry>
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
		AccountEntryImpl accountEntryImpl = new AccountEntryImpl();

		accountEntryImpl.setUuid(getUuid());
		accountEntryImpl.setExternalReferenceCode(getExternalReferenceCode());
		accountEntryImpl.setAccountId(getAccountId());
		accountEntryImpl.setGroupId(getGroupId());
		accountEntryImpl.setCompanyId(getCompanyId());
		accountEntryImpl.setCreateDate(getCreateDate());
		accountEntryImpl.setModifiedDate(getModifiedDate());
		accountEntryImpl.setCreatorId(getCreatorId());
		accountEntryImpl.setUsername(getUsername());
		accountEntryImpl.setPassword(getPassword());
		accountEntryImpl.setFullName(getFullName());
		accountEntryImpl.setPhoneNumber(getPhoneNumber());
		accountEntryImpl.setEmail(getEmail());
		accountEntryImpl.setAddress(getAddress());
		accountEntryImpl.setDepartmentId(getDepartmentId());
		accountEntryImpl.setBusinessId(getBusinessId());

		accountEntryImpl.resetOriginalValues();

		return accountEntryImpl;
	}

	@Override
	public AccountEntry cloneWithOriginalValues() {
		AccountEntryImpl accountEntryImpl = new AccountEntryImpl();

		accountEntryImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		accountEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		accountEntryImpl.setAccountId(
			this.<Long>getColumnOriginalValue("accountId"));
		accountEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		accountEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		accountEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		accountEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		accountEntryImpl.setCreatorId(
			this.<Long>getColumnOriginalValue("creatorId"));
		accountEntryImpl.setUsername(
			this.<String>getColumnOriginalValue("username"));
		accountEntryImpl.setPassword(
			this.<String>getColumnOriginalValue("password_"));
		accountEntryImpl.setFullName(
			this.<String>getColumnOriginalValue("fullName"));
		accountEntryImpl.setPhoneNumber(
			this.<Integer>getColumnOriginalValue("phoneNumber"));
		accountEntryImpl.setEmail(this.<String>getColumnOriginalValue("email"));
		accountEntryImpl.setAddress(
			this.<String>getColumnOriginalValue("address"));
		accountEntryImpl.setDepartmentId(
			this.<Long>getColumnOriginalValue("departmentId"));
		accountEntryImpl.setBusinessId(
			this.<Long>getColumnOriginalValue("businessId"));

		return accountEntryImpl;
	}

	@Override
	public int compareTo(AccountEntry accountEntry) {
		long primaryKey = accountEntry.getPrimaryKey();

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

		if (!(object instanceof AccountEntry)) {
			return false;
		}

		AccountEntry accountEntry = (AccountEntry)object;

		long primaryKey = accountEntry.getPrimaryKey();

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
	public CacheModel<AccountEntry> toCacheModel() {
		AccountEntryCacheModel accountEntryCacheModel =
			new AccountEntryCacheModel();

		accountEntryCacheModel.uuid = getUuid();

		String uuid = accountEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			accountEntryCacheModel.uuid = null;
		}

		accountEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			accountEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			accountEntryCacheModel.externalReferenceCode = null;
		}

		accountEntryCacheModel.accountId = getAccountId();

		accountEntryCacheModel.groupId = getGroupId();

		accountEntryCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			accountEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			accountEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			accountEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			accountEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		accountEntryCacheModel.creatorId = getCreatorId();

		accountEntryCacheModel.username = getUsername();

		String username = accountEntryCacheModel.username;

		if ((username != null) && (username.length() == 0)) {
			accountEntryCacheModel.username = null;
		}

		accountEntryCacheModel.password = getPassword();

		String password = accountEntryCacheModel.password;

		if ((password != null) && (password.length() == 0)) {
			accountEntryCacheModel.password = null;
		}

		accountEntryCacheModel.fullName = getFullName();

		String fullName = accountEntryCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			accountEntryCacheModel.fullName = null;
		}

		Integer phoneNumber = getPhoneNumber();

		if (phoneNumber != null) {
			accountEntryCacheModel.phoneNumber = phoneNumber;
		}

		accountEntryCacheModel.email = getEmail();

		String email = accountEntryCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			accountEntryCacheModel.email = null;
		}

		accountEntryCacheModel.address = getAddress();

		String address = accountEntryCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			accountEntryCacheModel.address = null;
		}

		Long departmentId = getDepartmentId();

		if (departmentId != null) {
			accountEntryCacheModel.departmentId = departmentId;
		}

		Long businessId = getBusinessId();

		if (businessId != null) {
			accountEntryCacheModel.businessId = businessId;
		}

		return accountEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AccountEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AccountEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AccountEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((AccountEntry)this);

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
		Map<String, Function<AccountEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AccountEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AccountEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AccountEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AccountEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _accountId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _creatorId;
	private String _username;
	private String _password;
	private String _fullName;
	private Integer _phoneNumber;
	private String _email;
	private String _address;
	private Long _departmentId;
	private Long _businessId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<AccountEntry, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((AccountEntry)this);
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
		_columnOriginalValues.put("accountId", _accountId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("creatorId", _creatorId);
		_columnOriginalValues.put("username", _username);
		_columnOriginalValues.put("password_", _password);
		_columnOriginalValues.put("fullName", _fullName);
		_columnOriginalValues.put("phoneNumber", _phoneNumber);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("address", _address);
		_columnOriginalValues.put("departmentId", _departmentId);
		_columnOriginalValues.put("businessId", _businessId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("password_", "password");

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

		columnBitmasks.put("accountId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("creatorId", 128L);

		columnBitmasks.put("username", 256L);

		columnBitmasks.put("password_", 512L);

		columnBitmasks.put("fullName", 1024L);

		columnBitmasks.put("phoneNumber", 2048L);

		columnBitmasks.put("email", 4096L);

		columnBitmasks.put("address", 8192L);

		columnBitmasks.put("departmentId", 16384L);

		columnBitmasks.put("businessId", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private AccountEntry _escapedModel;

}