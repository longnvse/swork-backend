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

package com.swork.common.file.model.impl;

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

import com.swork.common.file.model.FileManagerEntry;
import com.swork.common.file.model.FileManagerEntryModel;

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
 * The base model implementation for the FileManagerEntry service. Represents a row in the &quot;SW_FileManager&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FileManagerEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FileManagerEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileManagerEntryImpl
 * @generated
 */
public class FileManagerEntryModelImpl
	extends BaseModelImpl<FileManagerEntry> implements FileManagerEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a file manager entry model instance should use the <code>FileManagerEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "SW_FileManager";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"id_", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"accountId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"businessId", Types.BIGINT}, {"fileId", Types.BIGINT},
		{"fileType", Types.VARCHAR}, {"fileName", Types.VARCHAR},
		{"fileSize", Types.BIGINT}, {"mimeType", Types.VARCHAR},
		{"moduleId", Types.VARCHAR}, {"appId", Types.VARCHAR},
		{"projectId", Types.BIGINT}, {"phaseId", Types.BIGINT},
		{"workId", Types.BIGINT}
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
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("businessId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileSize", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("mimeType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("moduleId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("appId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("phaseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("workId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SW_FileManager (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,accountId LONG,createDate DATE null,modifiedDate DATE null,businessId LONG,fileId LONG,fileType VARCHAR(75) null,fileName VARCHAR(75) null,fileSize LONG,mimeType VARCHAR(75) null,moduleId VARCHAR(75) null,appId VARCHAR(75) null,projectId LONG,phaseId LONG,workId LONG)";

	public static final String TABLE_SQL_DROP = "drop table SW_FileManager";

	public static final String ORDER_BY_JPQL =
		" ORDER BY fileManagerEntry.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SW_FileManager.id_ ASC";

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
	public static final long FILEID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 16L;

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
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long WORKID_COLUMN_BITMASK = 256L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 512L;

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

	public FileManagerEntryModelImpl() {
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
		return FileManagerEntry.class;
	}

	@Override
	public String getModelClassName() {
		return FileManagerEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FileManagerEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FileManagerEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileManagerEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((FileManagerEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FileManagerEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FileManagerEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FileManagerEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FileManagerEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FileManagerEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, FileManagerEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			FileManagerEntry.class.getClassLoader(), FileManagerEntry.class,
			ModelWrapper.class);

		try {
			Constructor<FileManagerEntry> constructor =
				(Constructor<FileManagerEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<FileManagerEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<FileManagerEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<FileManagerEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<FileManagerEntry, Object>>();
		Map<String, BiConsumer<FileManagerEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<FileManagerEntry, ?>>();

		attributeGetterFunctions.put("uuid", FileManagerEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<FileManagerEntry, String>)FileManagerEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode",
			FileManagerEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<FileManagerEntry, String>)
				FileManagerEntry::setExternalReferenceCode);
		attributeGetterFunctions.put("id", FileManagerEntry::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<FileManagerEntry, Long>)FileManagerEntry::setId);
		attributeGetterFunctions.put("groupId", FileManagerEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<FileManagerEntry, Long>)FileManagerEntry::setGroupId);
		attributeGetterFunctions.put(
			"companyId", FileManagerEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<FileManagerEntry, Long>)FileManagerEntry::setCompanyId);
		attributeGetterFunctions.put(
			"accountId", FileManagerEntry::getAccountId);
		attributeSetterBiConsumers.put(
			"accountId",
			(BiConsumer<FileManagerEntry, Long>)FileManagerEntry::setAccountId);
		attributeGetterFunctions.put(
			"createDate", FileManagerEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<FileManagerEntry, Date>)
				FileManagerEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", FileManagerEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<FileManagerEntry, Date>)
				FileManagerEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"businessId", FileManagerEntry::getBusinessId);
		attributeSetterBiConsumers.put(
			"businessId",
			(BiConsumer<FileManagerEntry, Long>)
				FileManagerEntry::setBusinessId);
		attributeGetterFunctions.put("fileId", FileManagerEntry::getFileId);
		attributeSetterBiConsumers.put(
			"fileId",
			(BiConsumer<FileManagerEntry, Long>)FileManagerEntry::setFileId);
		attributeGetterFunctions.put("fileType", FileManagerEntry::getFileType);
		attributeSetterBiConsumers.put(
			"fileType",
			(BiConsumer<FileManagerEntry, String>)
				FileManagerEntry::setFileType);
		attributeGetterFunctions.put("fileName", FileManagerEntry::getFileName);
		attributeSetterBiConsumers.put(
			"fileName",
			(BiConsumer<FileManagerEntry, String>)
				FileManagerEntry::setFileName);
		attributeGetterFunctions.put("fileSize", FileManagerEntry::getFileSize);
		attributeSetterBiConsumers.put(
			"fileSize",
			(BiConsumer<FileManagerEntry, Long>)FileManagerEntry::setFileSize);
		attributeGetterFunctions.put("mimeType", FileManagerEntry::getMimeType);
		attributeSetterBiConsumers.put(
			"mimeType",
			(BiConsumer<FileManagerEntry, String>)
				FileManagerEntry::setMimeType);
		attributeGetterFunctions.put("moduleId", FileManagerEntry::getModuleId);
		attributeSetterBiConsumers.put(
			"moduleId",
			(BiConsumer<FileManagerEntry, String>)
				FileManagerEntry::setModuleId);
		attributeGetterFunctions.put("appId", FileManagerEntry::getAppId);
		attributeSetterBiConsumers.put(
			"appId",
			(BiConsumer<FileManagerEntry, String>)FileManagerEntry::setAppId);
		attributeGetterFunctions.put(
			"projectId", FileManagerEntry::getProjectId);
		attributeSetterBiConsumers.put(
			"projectId",
			(BiConsumer<FileManagerEntry, Long>)FileManagerEntry::setProjectId);
		attributeGetterFunctions.put("phaseId", FileManagerEntry::getPhaseId);
		attributeSetterBiConsumers.put(
			"phaseId",
			(BiConsumer<FileManagerEntry, Long>)FileManagerEntry::setPhaseId);
		attributeGetterFunctions.put("workId", FileManagerEntry::getWorkId);
		attributeSetterBiConsumers.put(
			"workId",
			(BiConsumer<FileManagerEntry, Long>)FileManagerEntry::setWorkId);

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
	public long getFileId() {
		return _fileId;
	}

	@Override
	public void setFileId(long fileId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileId = fileId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalFileId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("fileId"));
	}

	@Override
	public String getFileType() {
		if (_fileType == null) {
			return "";
		}
		else {
			return _fileType;
		}
	}

	@Override
	public void setFileType(String fileType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileType = fileType;
	}

	@Override
	public String getFileName() {
		if (_fileName == null) {
			return "";
		}
		else {
			return _fileName;
		}
	}

	@Override
	public void setFileName(String fileName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileName = fileName;
	}

	@Override
	public Long getFileSize() {
		return _fileSize;
	}

	@Override
	public void setFileSize(Long fileSize) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileSize = fileSize;
	}

	@Override
	public String getMimeType() {
		if (_mimeType == null) {
			return "";
		}
		else {
			return _mimeType;
		}
	}

	@Override
	public void setMimeType(String mimeType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mimeType = mimeType;
	}

	@Override
	public String getModuleId() {
		if (_moduleId == null) {
			return "";
		}
		else {
			return _moduleId;
		}
	}

	@Override
	public void setModuleId(String moduleId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_moduleId = moduleId;
	}

	@Override
	public String getAppId() {
		if (_appId == null) {
			return "";
		}
		else {
			return _appId;
		}
	}

	@Override
	public void setAppId(String appId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_appId = appId;
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
	public Long getWorkId() {
		return _workId;
	}

	@Override
	public void setWorkId(Long workId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_workId = workId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Long getOriginalWorkId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("workId"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(FileManagerEntry.class.getName()));
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
			getCompanyId(), FileManagerEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FileManagerEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, FileManagerEntry>
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
		FileManagerEntryImpl fileManagerEntryImpl = new FileManagerEntryImpl();

		fileManagerEntryImpl.setUuid(getUuid());
		fileManagerEntryImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		fileManagerEntryImpl.setId(getId());
		fileManagerEntryImpl.setGroupId(getGroupId());
		fileManagerEntryImpl.setCompanyId(getCompanyId());
		fileManagerEntryImpl.setAccountId(getAccountId());
		fileManagerEntryImpl.setCreateDate(getCreateDate());
		fileManagerEntryImpl.setModifiedDate(getModifiedDate());
		fileManagerEntryImpl.setBusinessId(getBusinessId());
		fileManagerEntryImpl.setFileId(getFileId());
		fileManagerEntryImpl.setFileType(getFileType());
		fileManagerEntryImpl.setFileName(getFileName());
		fileManagerEntryImpl.setFileSize(getFileSize());
		fileManagerEntryImpl.setMimeType(getMimeType());
		fileManagerEntryImpl.setModuleId(getModuleId());
		fileManagerEntryImpl.setAppId(getAppId());
		fileManagerEntryImpl.setProjectId(getProjectId());
		fileManagerEntryImpl.setPhaseId(getPhaseId());
		fileManagerEntryImpl.setWorkId(getWorkId());

		fileManagerEntryImpl.resetOriginalValues();

		return fileManagerEntryImpl;
	}

	@Override
	public FileManagerEntry cloneWithOriginalValues() {
		FileManagerEntryImpl fileManagerEntryImpl = new FileManagerEntryImpl();

		fileManagerEntryImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		fileManagerEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		fileManagerEntryImpl.setId(this.<Long>getColumnOriginalValue("id_"));
		fileManagerEntryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		fileManagerEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		fileManagerEntryImpl.setAccountId(
			this.<Long>getColumnOriginalValue("accountId"));
		fileManagerEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		fileManagerEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		fileManagerEntryImpl.setBusinessId(
			this.<Long>getColumnOriginalValue("businessId"));
		fileManagerEntryImpl.setFileId(
			this.<Long>getColumnOriginalValue("fileId"));
		fileManagerEntryImpl.setFileType(
			this.<String>getColumnOriginalValue("fileType"));
		fileManagerEntryImpl.setFileName(
			this.<String>getColumnOriginalValue("fileName"));
		fileManagerEntryImpl.setFileSize(
			this.<Long>getColumnOriginalValue("fileSize"));
		fileManagerEntryImpl.setMimeType(
			this.<String>getColumnOriginalValue("mimeType"));
		fileManagerEntryImpl.setModuleId(
			this.<String>getColumnOriginalValue("moduleId"));
		fileManagerEntryImpl.setAppId(
			this.<String>getColumnOriginalValue("appId"));
		fileManagerEntryImpl.setProjectId(
			this.<Long>getColumnOriginalValue("projectId"));
		fileManagerEntryImpl.setPhaseId(
			this.<Long>getColumnOriginalValue("phaseId"));
		fileManagerEntryImpl.setWorkId(
			this.<Long>getColumnOriginalValue("workId"));

		return fileManagerEntryImpl;
	}

	@Override
	public int compareTo(FileManagerEntry fileManagerEntry) {
		long primaryKey = fileManagerEntry.getPrimaryKey();

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

		if (!(object instanceof FileManagerEntry)) {
			return false;
		}

		FileManagerEntry fileManagerEntry = (FileManagerEntry)object;

		long primaryKey = fileManagerEntry.getPrimaryKey();

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
	public CacheModel<FileManagerEntry> toCacheModel() {
		FileManagerEntryCacheModel fileManagerEntryCacheModel =
			new FileManagerEntryCacheModel();

		fileManagerEntryCacheModel.uuid = getUuid();

		String uuid = fileManagerEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			fileManagerEntryCacheModel.uuid = null;
		}

		fileManagerEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			fileManagerEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			fileManagerEntryCacheModel.externalReferenceCode = null;
		}

		fileManagerEntryCacheModel.id = getId();

		fileManagerEntryCacheModel.groupId = getGroupId();

		fileManagerEntryCacheModel.companyId = getCompanyId();

		fileManagerEntryCacheModel.accountId = getAccountId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			fileManagerEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			fileManagerEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			fileManagerEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			fileManagerEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		fileManagerEntryCacheModel.businessId = getBusinessId();

		fileManagerEntryCacheModel.fileId = getFileId();

		fileManagerEntryCacheModel.fileType = getFileType();

		String fileType = fileManagerEntryCacheModel.fileType;

		if ((fileType != null) && (fileType.length() == 0)) {
			fileManagerEntryCacheModel.fileType = null;
		}

		fileManagerEntryCacheModel.fileName = getFileName();

		String fileName = fileManagerEntryCacheModel.fileName;

		if ((fileName != null) && (fileName.length() == 0)) {
			fileManagerEntryCacheModel.fileName = null;
		}

		Long fileSize = getFileSize();

		if (fileSize != null) {
			fileManagerEntryCacheModel.fileSize = fileSize;
		}

		fileManagerEntryCacheModel.mimeType = getMimeType();

		String mimeType = fileManagerEntryCacheModel.mimeType;

		if ((mimeType != null) && (mimeType.length() == 0)) {
			fileManagerEntryCacheModel.mimeType = null;
		}

		fileManagerEntryCacheModel.moduleId = getModuleId();

		String moduleId = fileManagerEntryCacheModel.moduleId;

		if ((moduleId != null) && (moduleId.length() == 0)) {
			fileManagerEntryCacheModel.moduleId = null;
		}

		fileManagerEntryCacheModel.appId = getAppId();

		String appId = fileManagerEntryCacheModel.appId;

		if ((appId != null) && (appId.length() == 0)) {
			fileManagerEntryCacheModel.appId = null;
		}

		Long projectId = getProjectId();

		if (projectId != null) {
			fileManagerEntryCacheModel.projectId = projectId;
		}

		Long phaseId = getPhaseId();

		if (phaseId != null) {
			fileManagerEntryCacheModel.phaseId = phaseId;
		}

		Long workId = getWorkId();

		if (workId != null) {
			fileManagerEntryCacheModel.workId = workId;
		}

		return fileManagerEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FileManagerEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FileManagerEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileManagerEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(FileManagerEntry)this);

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
		Map<String, Function<FileManagerEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<FileManagerEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileManagerEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((FileManagerEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, FileManagerEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _accountId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _businessId;
	private long _fileId;
	private String _fileType;
	private String _fileName;
	private Long _fileSize;
	private String _mimeType;
	private String _moduleId;
	private String _appId;
	private Long _projectId;
	private Long _phaseId;
	private Long _workId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<FileManagerEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((FileManagerEntry)this);
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
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("businessId", _businessId);
		_columnOriginalValues.put("fileId", _fileId);
		_columnOriginalValues.put("fileType", _fileType);
		_columnOriginalValues.put("fileName", _fileName);
		_columnOriginalValues.put("fileSize", _fileSize);
		_columnOriginalValues.put("mimeType", _mimeType);
		_columnOriginalValues.put("moduleId", _moduleId);
		_columnOriginalValues.put("appId", _appId);
		_columnOriginalValues.put("projectId", _projectId);
		_columnOriginalValues.put("phaseId", _phaseId);
		_columnOriginalValues.put("workId", _workId);
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

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("businessId", 256L);

		columnBitmasks.put("fileId", 512L);

		columnBitmasks.put("fileType", 1024L);

		columnBitmasks.put("fileName", 2048L);

		columnBitmasks.put("fileSize", 4096L);

		columnBitmasks.put("mimeType", 8192L);

		columnBitmasks.put("moduleId", 16384L);

		columnBitmasks.put("appId", 32768L);

		columnBitmasks.put("projectId", 65536L);

		columnBitmasks.put("phaseId", 131072L);

		columnBitmasks.put("workId", 262144L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private FileManagerEntry _escapedModel;

}