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

import com.swork.auth.department.service.exception.NoSuchDepartmentAccountEntryException;
import com.swork.auth.department.service.model.DepartmentAccountEntry;
import com.swork.auth.department.service.model.DepartmentAccountEntryTable;
import com.swork.auth.department.service.model.impl.DepartmentAccountEntryImpl;
import com.swork.auth.department.service.model.impl.DepartmentAccountEntryModelImpl;
import com.swork.auth.department.service.service.persistence.DepartmentAccountEntryPersistence;
import com.swork.auth.department.service.service.persistence.DepartmentAccountEntryUtil;
import com.swork.auth.department.service.service.persistence.impl.constants.SW_DEPARTMENTPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the department account entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {DepartmentAccountEntryPersistence.class, BasePersistence.class}
)
public class DepartmentAccountEntryPersistenceImpl
	extends BasePersistenceImpl<DepartmentAccountEntry>
	implements DepartmentAccountEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DepartmentAccountEntryUtil</code> to access the department account entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DepartmentAccountEntryImpl.class.getName();

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
	 * Returns all the department account entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the department account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
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

		List<DepartmentAccountEntry> list = null;

		if (useFinderCache) {
			list = (List<DepartmentAccountEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DepartmentAccountEntry departmentAccountEntry : list) {
					if (!uuid.equals(departmentAccountEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_DEPARTMENTACCOUNTENTRY_WHERE);

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
				sb.append(DepartmentAccountEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DepartmentAccountEntry>)QueryUtil.list(
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
	 * Returns the first department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry findByUuid_First(
			String uuid,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (departmentAccountEntry != null) {
			return departmentAccountEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDepartmentAccountEntryException(sb.toString());
	}

	/**
	 * Returns the first department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		List<DepartmentAccountEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (departmentAccountEntry != null) {
			return departmentAccountEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDepartmentAccountEntryException(sb.toString());
	}

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DepartmentAccountEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the department account entries before and after the current department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param departmentAccountId the primary key of the current department account entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	@Override
	public DepartmentAccountEntry[] findByUuid_PrevAndNext(
			long departmentAccountId, String uuid,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		uuid = Objects.toString(uuid, "");

		DepartmentAccountEntry departmentAccountEntry = findByPrimaryKey(
			departmentAccountId);

		Session session = null;

		try {
			session = openSession();

			DepartmentAccountEntry[] array = new DepartmentAccountEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, departmentAccountEntry, uuid, orderByComparator, true);

			array[1] = departmentAccountEntry;

			array[2] = getByUuid_PrevAndNext(
				session, departmentAccountEntry, uuid, orderByComparator,
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

	protected DepartmentAccountEntry getByUuid_PrevAndNext(
		Session session, DepartmentAccountEntry departmentAccountEntry,
		String uuid,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DEPARTMENTACCOUNTENTRY_WHERE);

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
			sb.append(DepartmentAccountEntryModelImpl.ORDER_BY_JPQL);
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
						departmentAccountEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DepartmentAccountEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the department account entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DepartmentAccountEntry departmentAccountEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(departmentAccountEntry);
		}
	}

	/**
	 * Returns the number of department account entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching department account entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEPARTMENTACCOUNTENTRY_WHERE);

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
		"departmentAccountEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(departmentAccountEntry.uuid IS NULL OR departmentAccountEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the department account entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDepartmentAccountEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = fetchByUUID_G(
			uuid, groupId);

		if (departmentAccountEntry == null) {
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

			throw new NoSuchDepartmentAccountEntryException(sb.toString());
		}

		return departmentAccountEntry;
	}

	/**
	 * Returns the department account entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the department account entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByUUID_G(
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

		if (result instanceof DepartmentAccountEntry) {
			DepartmentAccountEntry departmentAccountEntry =
				(DepartmentAccountEntry)result;

			if (!Objects.equals(uuid, departmentAccountEntry.getUuid()) ||
				(groupId != departmentAccountEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEPARTMENTACCOUNTENTRY_WHERE);

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

				List<DepartmentAccountEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DepartmentAccountEntry departmentAccountEntry = list.get(0);

					result = departmentAccountEntry;

					cacheResult(departmentAccountEntry);
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
			return (DepartmentAccountEntry)result;
		}
	}

	/**
	 * Removes the department account entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the department account entry that was removed
	 */
	@Override
	public DepartmentAccountEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = findByUUID_G(
			uuid, groupId);

		return remove(departmentAccountEntry);
	}

	/**
	 * Returns the number of department account entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching department account entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEPARTMENTACCOUNTENTRY_WHERE);

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
		"departmentAccountEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(departmentAccountEntry.uuid IS NULL OR departmentAccountEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"departmentAccountEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
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

		List<DepartmentAccountEntry> list = null;

		if (useFinderCache) {
			list = (List<DepartmentAccountEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DepartmentAccountEntry departmentAccountEntry : list) {
					if (!uuid.equals(departmentAccountEntry.getUuid()) ||
						(companyId != departmentAccountEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DEPARTMENTACCOUNTENTRY_WHERE);

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
				sb.append(DepartmentAccountEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<DepartmentAccountEntry>)QueryUtil.list(
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
	 * Returns the first department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (departmentAccountEntry != null) {
			return departmentAccountEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDepartmentAccountEntryException(sb.toString());
	}

	/**
	 * Returns the first department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		List<DepartmentAccountEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (departmentAccountEntry != null) {
			return departmentAccountEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDepartmentAccountEntryException(sb.toString());
	}

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DepartmentAccountEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the department account entries before and after the current department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param departmentAccountId the primary key of the current department account entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	@Override
	public DepartmentAccountEntry[] findByUuid_C_PrevAndNext(
			long departmentAccountId, String uuid, long companyId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		uuid = Objects.toString(uuid, "");

		DepartmentAccountEntry departmentAccountEntry = findByPrimaryKey(
			departmentAccountId);

		Session session = null;

		try {
			session = openSession();

			DepartmentAccountEntry[] array = new DepartmentAccountEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, departmentAccountEntry, uuid, companyId,
				orderByComparator, true);

			array[1] = departmentAccountEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, departmentAccountEntry, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DepartmentAccountEntry getByUuid_C_PrevAndNext(
		Session session, DepartmentAccountEntry departmentAccountEntry,
		String uuid, long companyId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DEPARTMENTACCOUNTENTRY_WHERE);

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
			sb.append(DepartmentAccountEntryModelImpl.ORDER_BY_JPQL);
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
						departmentAccountEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DepartmentAccountEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the department account entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DepartmentAccountEntry departmentAccountEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(departmentAccountEntry);
		}
	}

	/**
	 * Returns the number of department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching department account entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEPARTMENTACCOUNTENTRY_WHERE);

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
		"departmentAccountEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(departmentAccountEntry.uuid IS NULL OR departmentAccountEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"departmentAccountEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByDepartmentId;
	private FinderPath _finderPathWithoutPaginationFindByDepartmentId;
	private FinderPath _finderPathCountByDepartmentId;

	/**
	 * Returns all the department account entries where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByDepartmentId(long departmentId) {
		return findByDepartmentId(
			departmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the department account entries where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByDepartmentId(
		long departmentId, int start, int end) {

		return findByDepartmentId(departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the department account entries where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByDepartmentId(
		long departmentId, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return findByDepartmentId(
			departmentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the department account entries where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByDepartmentId(
		long departmentId, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDepartmentId;
				finderArgs = new Object[] {departmentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDepartmentId;
			finderArgs = new Object[] {
				departmentId, start, end, orderByComparator
			};
		}

		List<DepartmentAccountEntry> list = null;

		if (useFinderCache) {
			list = (List<DepartmentAccountEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DepartmentAccountEntry departmentAccountEntry : list) {
					if (departmentId !=
							departmentAccountEntry.getDepartmentId()) {

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

			sb.append(_SQL_SELECT_DEPARTMENTACCOUNTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DepartmentAccountEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(departmentId);

				list = (List<DepartmentAccountEntry>)QueryUtil.list(
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
	 * Returns the first department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry findByDepartmentId_First(
			long departmentId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry =
			fetchByDepartmentId_First(departmentId, orderByComparator);

		if (departmentAccountEntry != null) {
			return departmentAccountEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("departmentId=");
		sb.append(departmentId);

		sb.append("}");

		throw new NoSuchDepartmentAccountEntryException(sb.toString());
	}

	/**
	 * Returns the first department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByDepartmentId_First(
		long departmentId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		List<DepartmentAccountEntry> list = findByDepartmentId(
			departmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry findByDepartmentId_Last(
			long departmentId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry =
			fetchByDepartmentId_Last(departmentId, orderByComparator);

		if (departmentAccountEntry != null) {
			return departmentAccountEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("departmentId=");
		sb.append(departmentId);

		sb.append("}");

		throw new NoSuchDepartmentAccountEntryException(sb.toString());
	}

	/**
	 * Returns the last department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByDepartmentId_Last(
		long departmentId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		int count = countByDepartmentId(departmentId);

		if (count == 0) {
			return null;
		}

		List<DepartmentAccountEntry> list = findByDepartmentId(
			departmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the department account entries before and after the current department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentAccountId the primary key of the current department account entry
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	@Override
	public DepartmentAccountEntry[] findByDepartmentId_PrevAndNext(
			long departmentAccountId, long departmentId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = findByPrimaryKey(
			departmentAccountId);

		Session session = null;

		try {
			session = openSession();

			DepartmentAccountEntry[] array = new DepartmentAccountEntryImpl[3];

			array[0] = getByDepartmentId_PrevAndNext(
				session, departmentAccountEntry, departmentId,
				orderByComparator, true);

			array[1] = departmentAccountEntry;

			array[2] = getByDepartmentId_PrevAndNext(
				session, departmentAccountEntry, departmentId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DepartmentAccountEntry getByDepartmentId_PrevAndNext(
		Session session, DepartmentAccountEntry departmentAccountEntry,
		long departmentId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DEPARTMENTACCOUNTENTRY_WHERE);

		sb.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

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
			sb.append(DepartmentAccountEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(departmentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						departmentAccountEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DepartmentAccountEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the department account entries where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 */
	@Override
	public void removeByDepartmentId(long departmentId) {
		for (DepartmentAccountEntry departmentAccountEntry :
				findByDepartmentId(
					departmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(departmentAccountEntry);
		}
	}

	/**
	 * Returns the number of department account entries where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching department account entries
	 */
	@Override
	public int countByDepartmentId(long departmentId) {
		FinderPath finderPath = _finderPathCountByDepartmentId;

		Object[] finderArgs = new Object[] {departmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEPARTMENTACCOUNTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(departmentId);

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

	private static final String _FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2 =
		"departmentAccountEntry.departmentId = ?";

	private FinderPath _finderPathWithPaginationFindByAccountId;
	private FinderPath _finderPathWithoutPaginationFindByAccountId;
	private FinderPath _finderPathCountByAccountId;

	/**
	 * Returns all the department account entries where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByAccountId(long accountId) {
		return findByAccountId(
			accountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the department account entries where accountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param accountId the account ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByAccountId(
		long accountId, int start, int end) {

		return findByAccountId(accountId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the department account entries where accountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param accountId the account ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByAccountId(
		long accountId, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return findByAccountId(accountId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the department account entries where accountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param accountId the account ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findByAccountId(
		long accountId, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAccountId;
				finderArgs = new Object[] {accountId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAccountId;
			finderArgs = new Object[] {
				accountId, start, end, orderByComparator
			};
		}

		List<DepartmentAccountEntry> list = null;

		if (useFinderCache) {
			list = (List<DepartmentAccountEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DepartmentAccountEntry departmentAccountEntry : list) {
					if (accountId != departmentAccountEntry.getAccountId()) {
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

			sb.append(_SQL_SELECT_DEPARTMENTACCOUNTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DepartmentAccountEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(accountId);

				list = (List<DepartmentAccountEntry>)QueryUtil.list(
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
	 * Returns the first department account entry in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry findByAccountId_First(
			long accountId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = fetchByAccountId_First(
			accountId, orderByComparator);

		if (departmentAccountEntry != null) {
			return departmentAccountEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("accountId=");
		sb.append(accountId);

		sb.append("}");

		throw new NoSuchDepartmentAccountEntryException(sb.toString());
	}

	/**
	 * Returns the first department account entry in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByAccountId_First(
		long accountId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		List<DepartmentAccountEntry> list = findByAccountId(
			accountId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last department account entry in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry findByAccountId_Last(
			long accountId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = fetchByAccountId_Last(
			accountId, orderByComparator);

		if (departmentAccountEntry != null) {
			return departmentAccountEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("accountId=");
		sb.append(accountId);

		sb.append("}");

		throw new NoSuchDepartmentAccountEntryException(sb.toString());
	}

	/**
	 * Returns the last department account entry in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByAccountId_Last(
		long accountId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		int count = countByAccountId(accountId);

		if (count == 0) {
			return null;
		}

		List<DepartmentAccountEntry> list = findByAccountId(
			accountId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the department account entries before and after the current department account entry in the ordered set where accountId = &#63;.
	 *
	 * @param departmentAccountId the primary key of the current department account entry
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	@Override
	public DepartmentAccountEntry[] findByAccountId_PrevAndNext(
			long departmentAccountId, long accountId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = findByPrimaryKey(
			departmentAccountId);

		Session session = null;

		try {
			session = openSession();

			DepartmentAccountEntry[] array = new DepartmentAccountEntryImpl[3];

			array[0] = getByAccountId_PrevAndNext(
				session, departmentAccountEntry, accountId, orderByComparator,
				true);

			array[1] = departmentAccountEntry;

			array[2] = getByAccountId_PrevAndNext(
				session, departmentAccountEntry, accountId, orderByComparator,
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

	protected DepartmentAccountEntry getByAccountId_PrevAndNext(
		Session session, DepartmentAccountEntry departmentAccountEntry,
		long accountId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_DEPARTMENTACCOUNTENTRY_WHERE);

		sb.append(_FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2);

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
			sb.append(DepartmentAccountEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(accountId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						departmentAccountEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DepartmentAccountEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the department account entries where accountId = &#63; from the database.
	 *
	 * @param accountId the account ID
	 */
	@Override
	public void removeByAccountId(long accountId) {
		for (DepartmentAccountEntry departmentAccountEntry :
				findByAccountId(
					accountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(departmentAccountEntry);
		}
	}

	/**
	 * Returns the number of department account entries where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the number of matching department account entries
	 */
	@Override
	public int countByAccountId(long accountId) {
		FinderPath finderPath = _finderPathCountByAccountId;

		Object[] finderArgs = new Object[] {accountId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEPARTMENTACCOUNTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(accountId);

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

	private static final String _FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2 =
		"departmentAccountEntry.accountId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the department account entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDepartmentAccountEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (departmentAccountEntry == null) {
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

			throw new NoSuchDepartmentAccountEntryException(sb.toString());
		}

		return departmentAccountEntry;
	}

	/**
	 * Returns the department account entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the department account entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByC_ERC(
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

		if (result instanceof DepartmentAccountEntry) {
			DepartmentAccountEntry departmentAccountEntry =
				(DepartmentAccountEntry)result;

			if ((companyId != departmentAccountEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					departmentAccountEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEPARTMENTACCOUNTENTRY_WHERE);

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

				List<DepartmentAccountEntry> list = query.list();

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
								"DepartmentAccountEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DepartmentAccountEntry departmentAccountEntry = list.get(0);

					result = departmentAccountEntry;

					cacheResult(departmentAccountEntry);
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
			return (DepartmentAccountEntry)result;
		}
	}

	/**
	 * Removes the department account entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the department account entry that was removed
	 */
	@Override
	public DepartmentAccountEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(departmentAccountEntry);
	}

	/**
	 * Returns the number of department account entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching department account entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEPARTMENTACCOUNTENTRY_WHERE);

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
		"departmentAccountEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"departmentAccountEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(departmentAccountEntry.externalReferenceCode IS NULL OR departmentAccountEntry.externalReferenceCode = '')";

	public DepartmentAccountEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DepartmentAccountEntry.class);

		setModelImplClass(DepartmentAccountEntryImpl.class);
		setModelPKClass(long.class);

		setTable(DepartmentAccountEntryTable.INSTANCE);
	}

	/**
	 * Caches the department account entry in the entity cache if it is enabled.
	 *
	 * @param departmentAccountEntry the department account entry
	 */
	@Override
	public void cacheResult(DepartmentAccountEntry departmentAccountEntry) {
		entityCache.putResult(
			DepartmentAccountEntryImpl.class,
			departmentAccountEntry.getPrimaryKey(), departmentAccountEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				departmentAccountEntry.getUuid(),
				departmentAccountEntry.getGroupId()
			},
			departmentAccountEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				departmentAccountEntry.getCompanyId(),
				departmentAccountEntry.getExternalReferenceCode()
			},
			departmentAccountEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the department account entries in the entity cache if it is enabled.
	 *
	 * @param departmentAccountEntries the department account entries
	 */
	@Override
	public void cacheResult(
		List<DepartmentAccountEntry> departmentAccountEntries) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (departmentAccountEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DepartmentAccountEntry departmentAccountEntry :
				departmentAccountEntries) {

			if (entityCache.getResult(
					DepartmentAccountEntryImpl.class,
					departmentAccountEntry.getPrimaryKey()) == null) {

				cacheResult(departmentAccountEntry);
			}
		}
	}

	/**
	 * Clears the cache for all department account entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DepartmentAccountEntryImpl.class);

		finderCache.clearCache(DepartmentAccountEntryImpl.class);
	}

	/**
	 * Clears the cache for the department account entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DepartmentAccountEntry departmentAccountEntry) {
		entityCache.removeResult(
			DepartmentAccountEntryImpl.class, departmentAccountEntry);
	}

	@Override
	public void clearCache(
		List<DepartmentAccountEntry> departmentAccountEntries) {

		for (DepartmentAccountEntry departmentAccountEntry :
				departmentAccountEntries) {

			entityCache.removeResult(
				DepartmentAccountEntryImpl.class, departmentAccountEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DepartmentAccountEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DepartmentAccountEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DepartmentAccountEntryModelImpl departmentAccountEntryModelImpl) {

		Object[] args = new Object[] {
			departmentAccountEntryModelImpl.getUuid(),
			departmentAccountEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, departmentAccountEntryModelImpl);

		args = new Object[] {
			departmentAccountEntryModelImpl.getCompanyId(),
			departmentAccountEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, departmentAccountEntryModelImpl);
	}

	/**
	 * Creates a new department account entry with the primary key. Does not add the department account entry to the database.
	 *
	 * @param departmentAccountId the primary key for the new department account entry
	 * @return the new department account entry
	 */
	@Override
	public DepartmentAccountEntry create(long departmentAccountId) {
		DepartmentAccountEntry departmentAccountEntry =
			new DepartmentAccountEntryImpl();

		departmentAccountEntry.setNew(true);
		departmentAccountEntry.setPrimaryKey(departmentAccountId);

		String uuid = PortalUUIDUtil.generate();

		departmentAccountEntry.setUuid(uuid);

		departmentAccountEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return departmentAccountEntry;
	}

	/**
	 * Removes the department account entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry that was removed
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	@Override
	public DepartmentAccountEntry remove(long departmentAccountId)
		throws NoSuchDepartmentAccountEntryException {

		return remove((Serializable)departmentAccountId);
	}

	/**
	 * Removes the department account entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the department account entry
	 * @return the department account entry that was removed
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	@Override
	public DepartmentAccountEntry remove(Serializable primaryKey)
		throws NoSuchDepartmentAccountEntryException {

		Session session = null;

		try {
			session = openSession();

			DepartmentAccountEntry departmentAccountEntry =
				(DepartmentAccountEntry)session.get(
					DepartmentAccountEntryImpl.class, primaryKey);

			if (departmentAccountEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDepartmentAccountEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(departmentAccountEntry);
		}
		catch (NoSuchDepartmentAccountEntryException noSuchEntityException) {
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
	protected DepartmentAccountEntry removeImpl(
		DepartmentAccountEntry departmentAccountEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(departmentAccountEntry)) {
				departmentAccountEntry = (DepartmentAccountEntry)session.get(
					DepartmentAccountEntryImpl.class,
					departmentAccountEntry.getPrimaryKeyObj());
			}

			if (departmentAccountEntry != null) {
				session.delete(departmentAccountEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (departmentAccountEntry != null) {
			clearCache(departmentAccountEntry);
		}

		return departmentAccountEntry;
	}

	@Override
	public DepartmentAccountEntry updateImpl(
		DepartmentAccountEntry departmentAccountEntry) {

		boolean isNew = departmentAccountEntry.isNew();

		if (!(departmentAccountEntry instanceof
				DepartmentAccountEntryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(departmentAccountEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					departmentAccountEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in departmentAccountEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DepartmentAccountEntry implementation " +
					departmentAccountEntry.getClass());
		}

		DepartmentAccountEntryModelImpl departmentAccountEntryModelImpl =
			(DepartmentAccountEntryModelImpl)departmentAccountEntry;

		if (Validator.isNull(departmentAccountEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			departmentAccountEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(departmentAccountEntry);
			}
			else {
				departmentAccountEntry = (DepartmentAccountEntry)session.merge(
					departmentAccountEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DepartmentAccountEntryImpl.class, departmentAccountEntryModelImpl,
			false, true);

		cacheUniqueFindersCache(departmentAccountEntryModelImpl);

		if (isNew) {
			departmentAccountEntry.setNew(false);
		}

		departmentAccountEntry.resetOriginalValues();

		return departmentAccountEntry;
	}

	/**
	 * Returns the department account entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the department account entry
	 * @return the department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	@Override
	public DepartmentAccountEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDepartmentAccountEntryException {

		DepartmentAccountEntry departmentAccountEntry = fetchByPrimaryKey(
			primaryKey);

		if (departmentAccountEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDepartmentAccountEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return departmentAccountEntry;
	}

	/**
	 * Returns the department account entry with the primary key or throws a <code>NoSuchDepartmentAccountEntryException</code> if it could not be found.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	@Override
	public DepartmentAccountEntry findByPrimaryKey(long departmentAccountId)
		throws NoSuchDepartmentAccountEntryException {

		return findByPrimaryKey((Serializable)departmentAccountId);
	}

	/**
	 * Returns the department account entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry, or <code>null</code> if a department account entry with the primary key could not be found
	 */
	@Override
	public DepartmentAccountEntry fetchByPrimaryKey(long departmentAccountId) {
		return fetchByPrimaryKey((Serializable)departmentAccountId);
	}

	/**
	 * Returns all the department account entries.
	 *
	 * @return the department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the department account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the department account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findAll(
		int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the department account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of department account entries
	 */
	@Override
	public List<DepartmentAccountEntry> findAll(
		int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
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

		List<DepartmentAccountEntry> list = null;

		if (useFinderCache) {
			list = (List<DepartmentAccountEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEPARTMENTACCOUNTENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEPARTMENTACCOUNTENTRY;

				sql = sql.concat(DepartmentAccountEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DepartmentAccountEntry>)QueryUtil.list(
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
	 * Removes all the department account entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DepartmentAccountEntry departmentAccountEntry : findAll()) {
			remove(departmentAccountEntry);
		}
	}

	/**
	 * Returns the number of department account entries.
	 *
	 * @return the number of department account entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_DEPARTMENTACCOUNTENTRY);

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
		return "departmentAccountId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEPARTMENTACCOUNTENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DepartmentAccountEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the department account entry persistence.
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

		_finderPathWithPaginationFindByDepartmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartmentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"departmentId"}, true);

		_finderPathWithoutPaginationFindByDepartmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartmentId",
			new String[] {Long.class.getName()}, new String[] {"departmentId"},
			true);

		_finderPathCountByDepartmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartmentId",
			new String[] {Long.class.getName()}, new String[] {"departmentId"},
			false);

		_finderPathWithPaginationFindByAccountId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAccountId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"accountId"}, true);

		_finderPathWithoutPaginationFindByAccountId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAccountId",
			new String[] {Long.class.getName()}, new String[] {"accountId"},
			true);

		_finderPathCountByAccountId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAccountId",
			new String[] {Long.class.getName()}, new String[] {"accountId"},
			false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setDepartmentAccountEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDepartmentAccountEntryUtilPersistence(null);

		entityCache.removeCache(DepartmentAccountEntryImpl.class.getName());
	}

	private void _setDepartmentAccountEntryUtilPersistence(
		DepartmentAccountEntryPersistence departmentAccountEntryPersistence) {

		try {
			Field field = DepartmentAccountEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, departmentAccountEntryPersistence);
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

	private static final String _SQL_SELECT_DEPARTMENTACCOUNTENTRY =
		"SELECT departmentAccountEntry FROM DepartmentAccountEntry departmentAccountEntry";

	private static final String _SQL_SELECT_DEPARTMENTACCOUNTENTRY_WHERE =
		"SELECT departmentAccountEntry FROM DepartmentAccountEntry departmentAccountEntry WHERE ";

	private static final String _SQL_COUNT_DEPARTMENTACCOUNTENTRY =
		"SELECT COUNT(departmentAccountEntry) FROM DepartmentAccountEntry departmentAccountEntry";

	private static final String _SQL_COUNT_DEPARTMENTACCOUNTENTRY_WHERE =
		"SELECT COUNT(departmentAccountEntry) FROM DepartmentAccountEntry departmentAccountEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"departmentAccountEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DepartmentAccountEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DepartmentAccountEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DepartmentAccountEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DepartmentAccountEntryModelArgumentsResolver
		_departmentAccountEntryModelArgumentsResolver;

}