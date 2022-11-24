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
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.swork.core.resource.service.model.TeamMemberEntry;
import com.swork.core.resource.service.model.TeamMemberEntryModel;

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
 * The base model implementation for the TeamMemberEntry service. Represents a row in the &quot;SW_TeamMember&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TeamMemberEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TeamMemberEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamMemberEntryImpl
 * @generated
 */
public class TeamMemberEntryModelImpl
	extends BaseModelImpl<TeamMemberEntry> implements TeamMemberEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a team member entry model instance should use the <code>TeamMemberEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "SW_TeamMember";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"teamMemberId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"memberId", Types.BIGINT}, {"memberName", Types.VARCHAR},
		{"isAdmin", Types.BOOLEAN}, {"teamId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("teamMemberId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("memberId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("memberName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isAdmin", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("teamId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SW_TeamMember (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,teamMemberId LONG not null primary key,companyId LONG,memberId LONG,memberName VARCHAR(100) null,isAdmin BOOLEAN,teamId LONG)";

	public static final String TABLE_SQL_DROP = "drop table SW_TeamMember";

	public static final String ORDER_BY_JPQL =
		" ORDER BY teamMemberEntry.teamMemberId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SW_TeamMember.teamMemberId ASC";

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
	public static final long ISADMIN_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TEAMID_COLUMN_BITMASK = 8L;

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
	public static final long TEAMMEMBERID_COLUMN_BITMASK = 32L;

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

	public TeamMemberEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _teamMemberId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTeamMemberId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _teamMemberId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TeamMemberEntry.class;
	}

	@Override
	public String getModelClassName() {
		return TeamMemberEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TeamMemberEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TeamMemberEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TeamMemberEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TeamMemberEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TeamMemberEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TeamMemberEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TeamMemberEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TeamMemberEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TeamMemberEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TeamMemberEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TeamMemberEntry.class.getClassLoader(), TeamMemberEntry.class,
			ModelWrapper.class);

		try {
			Constructor<TeamMemberEntry> constructor =
				(Constructor<TeamMemberEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<TeamMemberEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TeamMemberEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TeamMemberEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<TeamMemberEntry, Object>>();
		Map<String, BiConsumer<TeamMemberEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TeamMemberEntry, ?>>();

		attributeGetterFunctions.put("uuid", TeamMemberEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<TeamMemberEntry, String>)TeamMemberEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode", TeamMemberEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<TeamMemberEntry, String>)
				TeamMemberEntry::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"teamMemberId", TeamMemberEntry::getTeamMemberId);
		attributeSetterBiConsumers.put(
			"teamMemberId",
			(BiConsumer<TeamMemberEntry, Long>)
				TeamMemberEntry::setTeamMemberId);
		attributeGetterFunctions.put(
			"companyId", TeamMemberEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TeamMemberEntry, Long>)TeamMemberEntry::setCompanyId);
		attributeGetterFunctions.put("memberId", TeamMemberEntry::getMemberId);
		attributeSetterBiConsumers.put(
			"memberId",
			(BiConsumer<TeamMemberEntry, Long>)TeamMemberEntry::setMemberId);
		attributeGetterFunctions.put(
			"memberName", TeamMemberEntry::getMemberName);
		attributeSetterBiConsumers.put(
			"memberName",
			(BiConsumer<TeamMemberEntry, String>)
				TeamMemberEntry::setMemberName);
		attributeGetterFunctions.put("isAdmin", TeamMemberEntry::getIsAdmin);
		attributeSetterBiConsumers.put(
			"isAdmin",
			(BiConsumer<TeamMemberEntry, Boolean>)TeamMemberEntry::setIsAdmin);
		attributeGetterFunctions.put("teamId", TeamMemberEntry::getTeamId);
		attributeSetterBiConsumers.put(
			"teamId",
			(BiConsumer<TeamMemberEntry, Long>)TeamMemberEntry::setTeamId);

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
	public long getTeamMemberId() {
		return _teamMemberId;
	}

	@Override
	public void setTeamMemberId(long teamMemberId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_teamMemberId = teamMemberId;
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
	public Long getMemberId() {
		return _memberId;
	}

	@Override
	public void setMemberId(Long memberId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_memberId = memberId;
	}

	@Override
	public String getMemberName() {
		if (_memberName == null) {
			return "";
		}
		else {
			return _memberName;
		}
	}

	@Override
	public void setMemberName(String memberName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_memberName = memberName;
	}

	@Override
	public Boolean getIsAdmin() {
		return _isAdmin;
	}

	@Override
	public void setIsAdmin(Boolean isAdmin) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isAdmin = isAdmin;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Boolean getOriginalIsAdmin() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("isAdmin"));
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalTeamId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("teamId"));
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
			getCompanyId(), TeamMemberEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TeamMemberEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TeamMemberEntry>
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
		TeamMemberEntryImpl teamMemberEntryImpl = new TeamMemberEntryImpl();

		teamMemberEntryImpl.setUuid(getUuid());
		teamMemberEntryImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		teamMemberEntryImpl.setTeamMemberId(getTeamMemberId());
		teamMemberEntryImpl.setCompanyId(getCompanyId());
		teamMemberEntryImpl.setMemberId(getMemberId());
		teamMemberEntryImpl.setMemberName(getMemberName());
		teamMemberEntryImpl.setIsAdmin(getIsAdmin());
		teamMemberEntryImpl.setTeamId(getTeamId());

		teamMemberEntryImpl.resetOriginalValues();

		return teamMemberEntryImpl;
	}

	@Override
	public TeamMemberEntry cloneWithOriginalValues() {
		TeamMemberEntryImpl teamMemberEntryImpl = new TeamMemberEntryImpl();

		teamMemberEntryImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		teamMemberEntryImpl.setExternalReferenceCode(
			this.<String>getColumnOriginalValue("externalReferenceCode"));
		teamMemberEntryImpl.setTeamMemberId(
			this.<Long>getColumnOriginalValue("teamMemberId"));
		teamMemberEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		teamMemberEntryImpl.setMemberId(
			this.<Long>getColumnOriginalValue("memberId"));
		teamMemberEntryImpl.setMemberName(
			this.<String>getColumnOriginalValue("memberName"));
		teamMemberEntryImpl.setIsAdmin(
			this.<Boolean>getColumnOriginalValue("isAdmin"));
		teamMemberEntryImpl.setTeamId(
			this.<Long>getColumnOriginalValue("teamId"));

		return teamMemberEntryImpl;
	}

	@Override
	public int compareTo(TeamMemberEntry teamMemberEntry) {
		long primaryKey = teamMemberEntry.getPrimaryKey();

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

		if (!(object instanceof TeamMemberEntry)) {
			return false;
		}

		TeamMemberEntry teamMemberEntry = (TeamMemberEntry)object;

		long primaryKey = teamMemberEntry.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<TeamMemberEntry> toCacheModel() {
		TeamMemberEntryCacheModel teamMemberEntryCacheModel =
			new TeamMemberEntryCacheModel();

		teamMemberEntryCacheModel.uuid = getUuid();

		String uuid = teamMemberEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			teamMemberEntryCacheModel.uuid = null;
		}

		teamMemberEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			teamMemberEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			teamMemberEntryCacheModel.externalReferenceCode = null;
		}

		teamMemberEntryCacheModel.teamMemberId = getTeamMemberId();

		teamMemberEntryCacheModel.companyId = getCompanyId();

		Long memberId = getMemberId();

		if (memberId != null) {
			teamMemberEntryCacheModel.memberId = memberId;
		}

		teamMemberEntryCacheModel.memberName = getMemberName();

		String memberName = teamMemberEntryCacheModel.memberName;

		if ((memberName != null) && (memberName.length() == 0)) {
			teamMemberEntryCacheModel.memberName = null;
		}

		Boolean isAdmin = getIsAdmin();

		if (isAdmin != null) {
			teamMemberEntryCacheModel.isAdmin = isAdmin;
		}

		teamMemberEntryCacheModel.teamId = getTeamId();

		return teamMemberEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TeamMemberEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TeamMemberEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TeamMemberEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((TeamMemberEntry)this);

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
		Map<String, Function<TeamMemberEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TeamMemberEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TeamMemberEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TeamMemberEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TeamMemberEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _teamMemberId;
	private long _companyId;
	private Long _memberId;
	private String _memberName;
	private Boolean _isAdmin;
	private long _teamId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<TeamMemberEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((TeamMemberEntry)this);
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
		_columnOriginalValues.put("teamMemberId", _teamMemberId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("memberId", _memberId);
		_columnOriginalValues.put("memberName", _memberName);
		_columnOriginalValues.put("isAdmin", _isAdmin);
		_columnOriginalValues.put("teamId", _teamId);
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

		columnBitmasks.put("teamMemberId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("memberId", 16L);

		columnBitmasks.put("memberName", 32L);

		columnBitmasks.put("isAdmin", 64L);

		columnBitmasks.put("teamId", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private TeamMemberEntry _escapedModel;

}