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

package com.swork.auth.department.service.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.swork.auth.department.service.exception.NoSuchDepartmentEntryException;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.model.DepartmentEntryTable;
import com.swork.auth.department.service.model.impl.DepartmentEntryImpl;
import com.swork.auth.department.service.model.impl.DepartmentEntryModelImpl;
import com.swork.auth.department.service.service.persistence.DepartmentEntryPersistence;
import com.swork.auth.department.service.service.persistence.DepartmentEntryUtil;
import com.swork.auth.department.service.service.persistence.impl.constants.SW_DEPARTMENTPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the department entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DepartmentEntryPersistence.class, BasePersistence.class})
public class DepartmentEntryPersistenceImpl
	extends BasePersistenceImpl<DepartmentEntry>
	implements DepartmentEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DepartmentEntryUtil</code> to access the department entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DepartmentEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the department entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching department entries
	 */
	@Override
	public List<DepartmentEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of matching department entries
	 */
	@Override
	public List<DepartmentEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department entries
	 */
	@Override
	public List<DepartmentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department entries
	 */
	@Override
	public List<DepartmentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<DepartmentEntry> list = null;

		if (useFinderCache) {
			list = (List<DepartmentEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DepartmentEntry departmentEntry : list) {
					if (!uuid.equals(departmentEntry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DEPARTMENTENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DepartmentEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<DepartmentEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry findByUuid_First(
			String uuid, OrderByComparator<DepartmentEntry> orderByComparator)
		throws NoSuchDepartmentEntryException {

		DepartmentEntry departmentEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (departmentEntry != null) {
			return departmentEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDepartmentEntryException(sb.toString());
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry fetchByUuid_First(
		String uuid, OrderByComparator<DepartmentEntry> orderByComparator) {

		List<DepartmentEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry findByUuid_Last(
			String uuid, OrderByComparator<DepartmentEntry> orderByComparator)
		throws NoSuchDepartmentEntryException {

		DepartmentEntry departmentEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (departmentEntry != null) {
			return departmentEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDepartmentEntryException(sb.toString());
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DepartmentEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DepartmentEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the department entries before and after the current department entry in the ordered set where uuid = &#63;.
	 *
	 * @param departmentId the primary key of the current department entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	@Override
	public DepartmentEntry[] findByUuid_PrevAndNext(
			long departmentId, String uuid,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws NoSuchDepartmentEntryException {

		uuid = Objects.toString(uuid, "");

		DepartmentEntry departmentEntry = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			DepartmentEntry[] array = new DepartmentEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, departmentEntry, uuid, orderByComparator, true);

			array[1] = departmentEntry;

			array[2] = getByUuid_PrevAndNext(
				session, departmentEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DepartmentEntry getByUuid_PrevAndNext(
		Session session, DepartmentEntry departmentEntry, String uuid,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DEPARTMENTENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DepartmentEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						departmentEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DepartmentEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the department entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DepartmentEntry departmentEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(departmentEntry);
		}
	}

	/**
	 * Returns the number of department entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching department entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEPARTMENTENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"departmentEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(departmentEntry.uuid IS NULL OR departmentEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDepartmentEntryException {

		DepartmentEntry departmentEntry = fetchByUUID_G(uuid, groupId);

		if (departmentEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDepartmentEntryException(sb.toString());
		}

		return departmentEntry;
	}

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof DepartmentEntry) {
			DepartmentEntry departmentEntry = (DepartmentEntry)result;

			if (!Objects.equals(uuid, departmentEntry.getUuid()) ||
				(groupId != departmentEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEPARTMENTENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<DepartmentEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DepartmentEntry departmentEntry = list.get(0);

					result = departmentEntry;

					cacheResult(departmentEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DepartmentEntry)result;
		}
	}

	/**
	 * Removes the department entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the department entry that was removed
	 */
	@Override
	public DepartmentEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDepartmentEntryException {

		DepartmentEntry departmentEntry = findByUUID_G(uuid, groupId);

		return remove(departmentEntry);
	}

	/**
	 * Returns the number of department entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching department entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEPARTMENTENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"departmentEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(departmentEntry.uuid IS NULL OR departmentEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"departmentEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching department entries
	 */
	@Override
	public List<DepartmentEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of matching department entries
	 */
	@Override
	public List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department entries
	 */
	@Override
	public List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department entries
	 */
	@Override
	public List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<DepartmentEntry> list = null;

		if (useFinderCache) {
			list = (List<DepartmentEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DepartmentEntry departmentEntry : list) {
					if (!uuid.equals(departmentEntry.getUuid()) ||
						(companyId != departmentEntry.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DEPARTMENTENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DepartmentEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<DepartmentEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws NoSuchDepartmentEntryException {

		DepartmentEntry departmentEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (departmentEntry != null) {
			return departmentEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDepartmentEntryException(sb.toString());
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		List<DepartmentEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws NoSuchDepartmentEntryException {

		DepartmentEntry departmentEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (departmentEntry != null) {
			return departmentEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDepartmentEntryException(sb.toString());
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DepartmentEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the department entries before and after the current department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the primary key of the current department entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	@Override
	public DepartmentEntry[] findByUuid_C_PrevAndNext(
			long departmentId, String uuid, long companyId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws NoSuchDepartmentEntryException {

		uuid = Objects.toString(uuid, "");

		DepartmentEntry departmentEntry = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			DepartmentEntry[] array = new DepartmentEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, departmentEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = departmentEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, departmentEntry, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DepartmentEntry getByUuid_C_PrevAndNext(
		Session session, DepartmentEntry departmentEntry, String uuid,
		long companyId, OrderByComparator<DepartmentEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DEPARTMENTENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DepartmentEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						departmentEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DepartmentEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the department entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DepartmentEntry departmentEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(departmentEntry);
		}
	}

	/**
	 * Returns the number of department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching department entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEPARTMENTENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"departmentEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(departmentEntry.uuid IS NULL OR departmentEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"departmentEntry.companyId = ?";

	private FinderPath _finderPathFetchByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns the department entry where name = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry findByName(String name)
		throws NoSuchDepartmentEntryException {

		DepartmentEntry departmentEntry = fetchByName(name);

		if (departmentEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDepartmentEntryException(sb.toString());
		}

		return departmentEntry;
	}

	/**
	 * Returns the department entry where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the department entry where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry fetchByName(String name, boolean useFinderCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByName, finderArgs);
		}

		if (result instanceof DepartmentEntry) {
			DepartmentEntry departmentEntry = (DepartmentEntry)result;

			if (!Objects.equals(name, departmentEntry.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DEPARTMENTENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				List<DepartmentEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"DepartmentEntryPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DepartmentEntry departmentEntry = list.get(0);

					result = departmentEntry;

					cacheResult(departmentEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DepartmentEntry)result;
		}
	}

	/**
	 * Removes the department entry where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the department entry that was removed
	 */
	@Override
	public DepartmentEntry removeByName(String name)
		throws NoSuchDepartmentEntryException {

		DepartmentEntry departmentEntry = findByName(name);

		return remove(departmentEntry);
	}

	/**
	 * Returns the number of department entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching department entries
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEPARTMENTENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"departmentEntry.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(departmentEntry.name IS NULL OR departmentEntry.name = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDepartmentEntryException {

		DepartmentEntry departmentEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (departmentEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", externalReferenceCode=");
			sb.append(externalReferenceCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDepartmentEntryException(sb.toString());
		}

		return departmentEntry;
	}

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	@Override
	public DepartmentEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, externalReferenceCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_ERC, finderArgs);
		}

		if (result instanceof DepartmentEntry) {
			DepartmentEntry departmentEntry = (DepartmentEntry)result;

			if ((companyId != departmentEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					departmentEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEPARTMENTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				List<DepartmentEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_ERC, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									companyId, externalReferenceCode
								};
							}

							_log.warn(
								"DepartmentEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DepartmentEntry departmentEntry = list.get(0);

					result = departmentEntry;

					cacheResult(departmentEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DepartmentEntry)result;
		}
	}

	/**
	 * Removes the department entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the department entry that was removed
	 */
	@Override
	public DepartmentEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDepartmentEntryException {

		DepartmentEntry departmentEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(departmentEntry);
	}

	/**
	 * Returns the number of department entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching department entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEPARTMENTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_ERC_COMPANYID_2 =
		"departmentEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"departmentEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(departmentEntry.externalReferenceCode IS NULL OR departmentEntry.externalReferenceCode = '')";

	public DepartmentEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DepartmentEntry.class);

		setModelImplClass(DepartmentEntryImpl.class);
		setModelPKClass(long.class);

		setTable(DepartmentEntryTable.INSTANCE);
	}

	/**
	 * Caches the department entry in the entity cache if it is enabled.
	 *
	 * @param departmentEntry the department entry
	 */
	@Override
	public void cacheResult(DepartmentEntry departmentEntry) {
		entityCache.putResult(
			DepartmentEntryImpl.class, departmentEntry.getPrimaryKey(),
			departmentEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				departmentEntry.getUuid(), departmentEntry.getGroupId()
			},
			departmentEntry);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {departmentEntry.getName()},
			departmentEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				departmentEntry.getCompanyId(),
				departmentEntry.getExternalReferenceCode()
			},
			departmentEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the department entries in the entity cache if it is enabled.
	 *
	 * @param departmentEntries the department entries
	 */
	@Override
	public void cacheResult(List<DepartmentEntry> departmentEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (departmentEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DepartmentEntry departmentEntry : departmentEntries) {
			if (entityCache.getResult(
					DepartmentEntryImpl.class,
					departmentEntry.getPrimaryKey()) == null) {

				cacheResult(departmentEntry);
			}
		}
	}

	/**
	 * Clears the cache for all department entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DepartmentEntryImpl.class);

		finderCache.clearCache(DepartmentEntryImpl.class);
	}

	/**
	 * Clears the cache for the department entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DepartmentEntry departmentEntry) {
		entityCache.removeResult(DepartmentEntryImpl.class, departmentEntry);
	}

	@Override
	public void clearCache(List<DepartmentEntry> departmentEntries) {
		for (DepartmentEntry departmentEntry : departmentEntries) {
			entityCache.removeResult(
				DepartmentEntryImpl.class, departmentEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DepartmentEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DepartmentEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DepartmentEntryModelImpl departmentEntryModelImpl) {

		Object[] args = new Object[] {
			departmentEntryModelImpl.getUuid(),
			departmentEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, departmentEntryModelImpl);

		args = new Object[] {departmentEntryModelImpl.getName()};

		finderCache.putResult(_finderPathCountByName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByName, args, departmentEntryModelImpl);

		args = new Object[] {
			departmentEntryModelImpl.getCompanyId(),
			departmentEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, departmentEntryModelImpl);
	}

	/**
	 * Creates a new department entry with the primary key. Does not add the department entry to the database.
	 *
	 * @param departmentId the primary key for the new department entry
	 * @return the new department entry
	 */
	@Override
	public DepartmentEntry create(long departmentId) {
		DepartmentEntry departmentEntry = new DepartmentEntryImpl();

		departmentEntry.setNew(true);
		departmentEntry.setPrimaryKey(departmentId);

		String uuid = PortalUUIDUtil.generate();

		departmentEntry.setUuid(uuid);

		departmentEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return departmentEntry;
	}

	/**
	 * Removes the department entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry that was removed
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	@Override
	public DepartmentEntry remove(long departmentId)
		throws NoSuchDepartmentEntryException {

		return remove((Serializable)departmentId);
	}

	/**
	 * Removes the department entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the department entry
	 * @return the department entry that was removed
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	@Override
	public DepartmentEntry remove(Serializable primaryKey)
		throws NoSuchDepartmentEntryException {

		Session session = null;

		try {
			session = openSession();

			DepartmentEntry departmentEntry = (DepartmentEntry)session.get(
				DepartmentEntryImpl.class, primaryKey);

			if (departmentEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDepartmentEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(departmentEntry);
		}
		catch (NoSuchDepartmentEntryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DepartmentEntry removeImpl(DepartmentEntry departmentEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(departmentEntry)) {
				departmentEntry = (DepartmentEntry)session.get(
					DepartmentEntryImpl.class,
					departmentEntry.getPrimaryKeyObj());
			}

			if (departmentEntry != null) {
				session.delete(departmentEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (departmentEntry != null) {
			clearCache(departmentEntry);
		}

		return departmentEntry;
	}

	@Override
	public DepartmentEntry updateImpl(DepartmentEntry departmentEntry) {
		boolean isNew = departmentEntry.isNew();

		if (!(departmentEntry instanceof DepartmentEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(departmentEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					departmentEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in departmentEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DepartmentEntry implementation " +
					departmentEntry.getClass());
		}

		DepartmentEntryModelImpl departmentEntryModelImpl =
			(DepartmentEntryModelImpl)departmentEntry;

		if (Validator.isNull(departmentEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			departmentEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (departmentEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				departmentEntry.setCreateDate(date);
			}
			else {
				departmentEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!departmentEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				departmentEntry.setModifiedDate(date);
			}
			else {
				departmentEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(departmentEntry);
			}
			else {
				departmentEntry = (DepartmentEntry)session.merge(
					departmentEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DepartmentEntryImpl.class, departmentEntryModelImpl, false, true);

		cacheUniqueFindersCache(departmentEntryModelImpl);

		if (isNew) {
			departmentEntry.setNew(false);
		}

		departmentEntry.resetOriginalValues();

		return departmentEntry;
	}

	/**
	 * Returns the department entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the department entry
	 * @return the department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	@Override
	public DepartmentEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDepartmentEntryException {

		DepartmentEntry departmentEntry = fetchByPrimaryKey(primaryKey);

		if (departmentEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDepartmentEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return departmentEntry;
	}

	/**
	 * Returns the department entry with the primary key or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	@Override
	public DepartmentEntry findByPrimaryKey(long departmentId)
		throws NoSuchDepartmentEntryException {

		return findByPrimaryKey((Serializable)departmentId);
	}

	/**
	 * Returns the department entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry, or <code>null</code> if a department entry with the primary key could not be found
	 */
	@Override
	public DepartmentEntry fetchByPrimaryKey(long departmentId) {
		return fetchByPrimaryKey((Serializable)departmentId);
	}

	/**
	 * Returns all the department entries.
	 *
	 * @return the department entries
	 */
	@Override
	public List<DepartmentEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of department entries
	 */
	@Override
	public List<DepartmentEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of department entries
	 */
	@Override
	public List<DepartmentEntry> findAll(
		int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of department entries
	 */
	@Override
	public List<DepartmentEntry> findAll(
		int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DepartmentEntry> list = null;

		if (useFinderCache) {
			list = (List<DepartmentEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEPARTMENTENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEPARTMENTENTRY;

				sql = sql.concat(DepartmentEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DepartmentEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the department entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DepartmentEntry departmentEntry : findAll()) {
			remove(departmentEntry);
		}
	}

	/**
	 * Returns the number of department entries.
	 *
	 * @return the number of department entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DEPARTMENTENTRY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "departmentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEPARTMENTENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DepartmentEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the department entry persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathFetchByName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setDepartmentEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDepartmentEntryUtilPersistence(null);

		entityCache.removeCache(DepartmentEntryImpl.class.getName());
	}

	private void _setDepartmentEntryUtilPersistence(
		DepartmentEntryPersistence departmentEntryPersistence) {

		try {
			Field field = DepartmentEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, departmentEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_DEPARTMENTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_DEPARTMENTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_DEPARTMENTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DEPARTMENTENTRY =
		"SELECT departmentEntry FROM DepartmentEntry departmentEntry";

	private static final String _SQL_SELECT_DEPARTMENTENTRY_WHERE =
		"SELECT departmentEntry FROM DepartmentEntry departmentEntry WHERE ";

	private static final String _SQL_COUNT_DEPARTMENTENTRY =
		"SELECT COUNT(departmentEntry) FROM DepartmentEntry departmentEntry";

	private static final String _SQL_COUNT_DEPARTMENTENTRY_WHERE =
		"SELECT COUNT(departmentEntry) FROM DepartmentEntry departmentEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "departmentEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DepartmentEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DepartmentEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DepartmentEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DepartmentEntryModelArgumentsResolver
		_departmentEntryModelArgumentsResolver;

}