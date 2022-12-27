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

package com.swork.core.work.service.service.persistence.impl;

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

import com.swork.core.work.service.exception.NoSuchWorkEntryException;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.model.WorkEntryTable;
import com.swork.core.work.service.model.impl.WorkEntryImpl;
import com.swork.core.work.service.model.impl.WorkEntryModelImpl;
import com.swork.core.work.service.service.persistence.WorkEntryPersistence;
import com.swork.core.work.service.service.persistence.WorkEntryUtil;
import com.swork.core.work.service.service.persistence.impl.constants.SW_WORKPersistenceConstants;

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
 * The persistence implementation for the work entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {WorkEntryPersistence.class, BasePersistence.class})
public class WorkEntryPersistenceImpl
	extends BasePersistenceImpl<WorkEntry> implements WorkEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WorkEntryUtil</code> to access the work entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WorkEntryImpl.class.getName();

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
	 * Returns all the work entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
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

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if (!uuid.equals(workEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

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
				sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<WorkEntry>)QueryUtil.list(
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
	 * Returns the first work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByUuid_First(
			String uuid, OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByUuid_First(uuid, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByUuid_First(
		String uuid, OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByUuid_Last(
			String uuid, OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByUuid_Last(
		String uuid, OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where uuid = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByUuid_PrevAndNext(
			long workId, String uuid,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		uuid = Objects.toString(uuid, "");

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, workEntry, uuid, orderByComparator, true);

			array[1] = workEntry;

			array[2] = getByUuid_PrevAndNext(
				session, workEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkEntry getByUuid_PrevAndNext(
		Session session, WorkEntry workEntry, String uuid,
		OrderByComparator<WorkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKENTRY_WHERE);

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
			sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(workEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (WorkEntry workEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

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
		"workEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(workEntry.uuid IS NULL OR workEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the work entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByUUID_G(uuid, groupId);

		if (workEntry == null) {
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

			throw new NoSuchWorkEntryException(sb.toString());
		}

		return workEntry;
	}

	/**
	 * Returns the work entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the work entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByUUID_G(
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

		if (result instanceof WorkEntry) {
			WorkEntry workEntry = (WorkEntry)result;

			if (!Objects.equals(uuid, workEntry.getUuid()) ||
				(groupId != workEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

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

				List<WorkEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					WorkEntry workEntry = list.get(0);

					result = workEntry;

					cacheResult(workEntry);
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
			return (WorkEntry)result;
		}
	}

	/**
	 * Removes the work entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work entry that was removed
	 */
	@Override
	public WorkEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByUUID_G(uuid, groupId);

		return remove(workEntry);
	}

	/**
	 * Returns the number of work entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

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
		"workEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(workEntry.uuid IS NULL OR workEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"workEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
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

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if (!uuid.equals(workEntry.getUuid()) ||
						(companyId != workEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

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
				sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<WorkEntry>)QueryUtil.list(
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
	 * Returns the first work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByUuid_C_PrevAndNext(
			long workId, String uuid, long companyId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		uuid = Objects.toString(uuid, "");

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, workEntry, uuid, companyId, orderByComparator, true);

			array[1] = workEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, workEntry, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkEntry getByUuid_C_PrevAndNext(
		Session session, WorkEntry workEntry, String uuid, long companyId,
		OrderByComparator<WorkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_WORKENTRY_WHERE);

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
			sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(workEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (WorkEntry workEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

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
		"workEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(workEntry.uuid IS NULL OR workEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"workEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProjectId;
	private FinderPath _finderPathWithoutPaginationFindByProjectId;
	private FinderPath _finderPathCountByProjectId;

	/**
	 * Returns all the work entries where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId(Long projectId) {
		return findByProjectId(
			projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId(Long projectId, int start, int end) {
		return findByProjectId(projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId(
		Long projectId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByProjectId(projectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId(
		Long projectId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProjectId;
				finderArgs = new Object[] {projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProjectId;
			finderArgs = new Object[] {
				projectId, start, end, orderByComparator
			};
		}

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if (!Objects.equals(projectId, workEntry.getProjectId())) {
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

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId.longValue());

				list = (List<WorkEntry>)QueryUtil.list(
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
	 * Returns the first work entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByProjectId_First(
			Long projectId, OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByProjectId_First(
			projectId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByProjectId_First(
		Long projectId, OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByProjectId(
			projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByProjectId_Last(
			Long projectId, OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByProjectId_Last(
			projectId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByProjectId_Last(
		Long projectId, OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByProjectId(projectId);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByProjectId(
			projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where projectId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByProjectId_PrevAndNext(
			long workId, Long projectId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByProjectId_PrevAndNext(
				session, workEntry, projectId, orderByComparator, true);

			array[1] = workEntry;

			array[2] = getByProjectId_PrevAndNext(
				session, workEntry, projectId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkEntry getByProjectId_PrevAndNext(
		Session session, WorkEntry workEntry, Long projectId,
		OrderByComparator<WorkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKENTRY_WHERE);

		sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

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
			sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work entries where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByProjectId(Long projectId) {
		for (WorkEntry workEntry :
				findByProjectId(
					projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching work entries
	 */
	@Override
	public int countByProjectId(Long projectId) {
		FinderPath finderPath = _finderPathCountByProjectId;

		Object[] finderArgs = new Object[] {projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId.longValue());

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

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 =
		"workEntry.projectId = ?";

	private FinderPath _finderPathWithPaginationFindByProjectId_ParentId;
	private FinderPath _finderPathWithoutPaginationFindByProjectId_ParentId;
	private FinderPath _finderPathCountByProjectId_ParentId;

	/**
	 * Returns all the work entries where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId_ParentId(
		Long projectId, Long parentId) {

		return findByProjectId_ParentId(
			projectId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where projectId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId_ParentId(
		Long projectId, Long parentId, int start, int end) {

		return findByProjectId_ParentId(projectId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId_ParentId(
		Long projectId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByProjectId_ParentId(
			projectId, parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId_ParentId(
		Long projectId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProjectId_ParentId;
				finderArgs = new Object[] {projectId, parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProjectId_ParentId;
			finderArgs = new Object[] {
				projectId, parentId, start, end, orderByComparator
			};
		}

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if (!Objects.equals(projectId, workEntry.getProjectId()) ||
						!Objects.equals(parentId, workEntry.getParentId())) {

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

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PARENTID_PROJECTID_2);

			sb.append(_FINDER_COLUMN_PROJECTID_PARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId.longValue());

				queryPos.add(parentId.longValue());

				list = (List<WorkEntry>)QueryUtil.list(
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
	 * Returns the first work entry in the ordered set where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByProjectId_ParentId_First(
			Long projectId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByProjectId_ParentId_First(
			projectId, parentId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByProjectId_ParentId_First(
		Long projectId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByProjectId_ParentId(
			projectId, parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByProjectId_ParentId_Last(
			Long projectId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByProjectId_ParentId_Last(
			projectId, parentId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByProjectId_ParentId_Last(
		Long projectId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByProjectId_ParentId(projectId, parentId);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByProjectId_ParentId(
			projectId, parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where projectId = &#63; and parentId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByProjectId_ParentId_PrevAndNext(
			long workId, Long projectId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByProjectId_ParentId_PrevAndNext(
				session, workEntry, projectId, parentId, orderByComparator,
				true);

			array[1] = workEntry;

			array[2] = getByProjectId_ParentId_PrevAndNext(
				session, workEntry, projectId, parentId, orderByComparator,
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

	protected WorkEntry getByProjectId_ParentId_PrevAndNext(
		Session session, WorkEntry workEntry, Long projectId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_WORKENTRY_WHERE);

		sb.append(_FINDER_COLUMN_PROJECTID_PARENTID_PROJECTID_2);

		sb.append(_FINDER_COLUMN_PROJECTID_PARENTID_PARENTID_2);

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
			sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId.longValue());

		queryPos.add(parentId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work entries where projectId = &#63; and parentId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByProjectId_ParentId(Long projectId, Long parentId) {
		for (WorkEntry workEntry :
				findByProjectId_ParentId(
					projectId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @return the number of matching work entries
	 */
	@Override
	public int countByProjectId_ParentId(Long projectId, Long parentId) {
		FinderPath finderPath = _finderPathCountByProjectId_ParentId;

		Object[] finderArgs = new Object[] {projectId, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PARENTID_PROJECTID_2);

			sb.append(_FINDER_COLUMN_PROJECTID_PARENTID_PARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId.longValue());

				queryPos.add(parentId.longValue());

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

	private static final String _FINDER_COLUMN_PROJECTID_PARENTID_PROJECTID_2 =
		"workEntry.projectId = ? AND ";

	private static final String _FINDER_COLUMN_PROJECTID_PARENTID_PARENTID_2 =
		"workEntry.parentId = ?";

	private FinderPath _finderPathWithPaginationFindByProjectAndPhase;
	private FinderPath _finderPathWithoutPaginationFindByProjectAndPhase;
	private FinderPath _finderPathCountByProjectAndPhase;

	/**
	 * Returns all the work entries where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectAndPhase(Long projectId, Long phaseId) {
		return findByProjectAndPhase(
			projectId, phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where projectId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectAndPhase(
		Long projectId, Long phaseId, int start, int end) {

		return findByProjectAndPhase(projectId, phaseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectAndPhase(
		Long projectId, Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByProjectAndPhase(
			projectId, phaseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectAndPhase(
		Long projectId, Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProjectAndPhase;
				finderArgs = new Object[] {projectId, phaseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProjectAndPhase;
			finderArgs = new Object[] {
				projectId, phaseId, start, end, orderByComparator
			};
		}

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if (!Objects.equals(projectId, workEntry.getProjectId()) ||
						!Objects.equals(phaseId, workEntry.getPhaseId())) {

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

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTANDPHASE_PROJECTID_2);

			sb.append(_FINDER_COLUMN_PROJECTANDPHASE_PHASEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId.longValue());

				queryPos.add(phaseId.longValue());

				list = (List<WorkEntry>)QueryUtil.list(
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
	 * Returns the first work entry in the ordered set where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByProjectAndPhase_First(
			Long projectId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByProjectAndPhase_First(
			projectId, phaseId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByProjectAndPhase_First(
		Long projectId, Long phaseId,
		OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByProjectAndPhase(
			projectId, phaseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByProjectAndPhase_Last(
			Long projectId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByProjectAndPhase_Last(
			projectId, phaseId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByProjectAndPhase_Last(
		Long projectId, Long phaseId,
		OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByProjectAndPhase(projectId, phaseId);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByProjectAndPhase(
			projectId, phaseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByProjectAndPhase_PrevAndNext(
			long workId, Long projectId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByProjectAndPhase_PrevAndNext(
				session, workEntry, projectId, phaseId, orderByComparator,
				true);

			array[1] = workEntry;

			array[2] = getByProjectAndPhase_PrevAndNext(
				session, workEntry, projectId, phaseId, orderByComparator,
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

	protected WorkEntry getByProjectAndPhase_PrevAndNext(
		Session session, WorkEntry workEntry, Long projectId, Long phaseId,
		OrderByComparator<WorkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_WORKENTRY_WHERE);

		sb.append(_FINDER_COLUMN_PROJECTANDPHASE_PROJECTID_2);

		sb.append(_FINDER_COLUMN_PROJECTANDPHASE_PHASEID_2);

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
			sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId.longValue());

		queryPos.add(phaseId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work entries where projectId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 */
	@Override
	public void removeByProjectAndPhase(Long projectId, Long phaseId) {
		for (WorkEntry workEntry :
				findByProjectAndPhase(
					projectId, phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @return the number of matching work entries
	 */
	@Override
	public int countByProjectAndPhase(Long projectId, Long phaseId) {
		FinderPath finderPath = _finderPathCountByProjectAndPhase;

		Object[] finderArgs = new Object[] {projectId, phaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTANDPHASE_PROJECTID_2);

			sb.append(_FINDER_COLUMN_PROJECTANDPHASE_PHASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId.longValue());

				queryPos.add(phaseId.longValue());

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

	private static final String _FINDER_COLUMN_PROJECTANDPHASE_PROJECTID_2 =
		"workEntry.projectId = ? AND ";

	private static final String _FINDER_COLUMN_PROJECTANDPHASE_PHASEID_2 =
		"workEntry.phaseId = ?";

	private FinderPath
		_finderPathWithPaginationFindByProjectId_PhaseId_ParentId;
	private FinderPath
		_finderPathWithoutPaginationFindByProjectId_PhaseId_ParentId;
	private FinderPath _finderPathCountByProjectId_PhaseId_ParentId;

	/**
	 * Returns all the work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId) {

		return findByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId, int start, int end) {

		return findByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProjectId_PhaseId_ParentId;
				finderArgs = new Object[] {projectId, phaseId, parentId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByProjectId_PhaseId_ParentId;
			finderArgs = new Object[] {
				projectId, phaseId, parentId, start, end, orderByComparator
			};
		}

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if (!Objects.equals(projectId, workEntry.getProjectId()) ||
						!Objects.equals(phaseId, workEntry.getPhaseId()) ||
						!Objects.equals(parentId, workEntry.getParentId())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PROJECTID_2);

			sb.append(_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PHASEID_2);

			sb.append(_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId.longValue());

				queryPos.add(phaseId.longValue());

				queryPos.add(parentId.longValue());

				list = (List<WorkEntry>)QueryUtil.list(
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
	 * Returns the first work entry in the ordered set where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByProjectId_PhaseId_ParentId_First(
			Long projectId, Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByProjectId_PhaseId_ParentId_First(
			projectId, phaseId, parentId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByProjectId_PhaseId_ParentId_First(
		Long projectId, Long phaseId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByProjectId_PhaseId_ParentId_Last(
			Long projectId, Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByProjectId_PhaseId_ParentId_Last(
			projectId, phaseId, parentId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByProjectId_PhaseId_ParentId_Last(
		Long projectId, Long phaseId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByProjectId_PhaseId_ParentId_PrevAndNext(
			long workId, Long projectId, Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByProjectId_PhaseId_ParentId_PrevAndNext(
				session, workEntry, projectId, phaseId, parentId,
				orderByComparator, true);

			array[1] = workEntry;

			array[2] = getByProjectId_PhaseId_ParentId_PrevAndNext(
				session, workEntry, projectId, phaseId, parentId,
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

	protected WorkEntry getByProjectId_PhaseId_ParentId_PrevAndNext(
		Session session, WorkEntry workEntry, Long projectId, Long phaseId,
		Long parentId, OrderByComparator<WorkEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_WORKENTRY_WHERE);

		sb.append(_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PROJECTID_2);

		sb.append(_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PHASEID_2);

		sb.append(_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PARENTID_2);

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
			sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId.longValue());

		queryPos.add(phaseId.longValue());

		queryPos.add(parentId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId) {

		for (WorkEntry workEntry :
				findByProjectId_PhaseId_ParentId(
					projectId, phaseId, parentId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @return the number of matching work entries
	 */
	@Override
	public int countByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId) {

		FinderPath finderPath = _finderPathCountByProjectId_PhaseId_ParentId;

		Object[] finderArgs = new Object[] {projectId, phaseId, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PROJECTID_2);

			sb.append(_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PHASEID_2);

			sb.append(_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId.longValue());

				queryPos.add(phaseId.longValue());

				queryPos.add(parentId.longValue());

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

	private static final String
		_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PROJECTID_2 =
			"workEntry.projectId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PHASEID_2 =
			"workEntry.phaseId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROJECTID_PHASEID_PARENTID_PARENTID_2 =
			"workEntry.parentId = ?";

	private FinderPath _finderPathWithPaginationFindByPhaseId;
	private FinderPath _finderPathWithoutPaginationFindByPhaseId;
	private FinderPath _finderPathCountByPhaseId;

	/**
	 * Returns all the work entries where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByPhaseId(Long phaseId) {
		return findByPhaseId(
			phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByPhaseId(Long phaseId, int start, int end) {
		return findByPhaseId(phaseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByPhaseId(
		Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByPhaseId(phaseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByPhaseId(
		Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPhaseId;
				finderArgs = new Object[] {phaseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPhaseId;
			finderArgs = new Object[] {phaseId, start, end, orderByComparator};
		}

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if (!Objects.equals(phaseId, workEntry.getPhaseId())) {
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

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PHASEID_PHASEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(phaseId.longValue());

				list = (List<WorkEntry>)QueryUtil.list(
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
	 * Returns the first work entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByPhaseId_First(
			Long phaseId, OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByPhaseId_First(phaseId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByPhaseId_First(
		Long phaseId, OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByPhaseId(phaseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByPhaseId_Last(
			Long phaseId, OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByPhaseId_Last(phaseId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByPhaseId_Last(
		Long phaseId, OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByPhaseId(phaseId);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByPhaseId(
			phaseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where phaseId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByPhaseId_PrevAndNext(
			long workId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByPhaseId_PrevAndNext(
				session, workEntry, phaseId, orderByComparator, true);

			array[1] = workEntry;

			array[2] = getByPhaseId_PrevAndNext(
				session, workEntry, phaseId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkEntry getByPhaseId_PrevAndNext(
		Session session, WorkEntry workEntry, Long phaseId,
		OrderByComparator<WorkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKENTRY_WHERE);

		sb.append(_FINDER_COLUMN_PHASEID_PHASEID_2);

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
			sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(phaseId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work entries where phaseId = &#63; from the database.
	 *
	 * @param phaseId the phase ID
	 */
	@Override
	public void removeByPhaseId(Long phaseId) {
		for (WorkEntry workEntry :
				findByPhaseId(
					phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @return the number of matching work entries
	 */
	@Override
	public int countByPhaseId(Long phaseId) {
		FinderPath finderPath = _finderPathCountByPhaseId;

		Object[] finderArgs = new Object[] {phaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PHASEID_PHASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(phaseId.longValue());

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

	private static final String _FINDER_COLUMN_PHASEID_PHASEID_2 =
		"workEntry.phaseId = ?";

	private FinderPath _finderPathWithPaginationFindByPhaseId_ParentId;
	private FinderPath _finderPathWithoutPaginationFindByPhaseId_ParentId;
	private FinderPath _finderPathCountByPhaseId_ParentId;

	/**
	 * Returns all the work entries where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByPhaseId_ParentId(Long phaseId, Long parentId) {
		return findByPhaseId_ParentId(
			phaseId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByPhaseId_ParentId(
		Long phaseId, Long parentId, int start, int end) {

		return findByPhaseId_ParentId(phaseId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByPhaseId_ParentId(
		Long phaseId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByPhaseId_ParentId(
			phaseId, parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByPhaseId_ParentId(
		Long phaseId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPhaseId_ParentId;
				finderArgs = new Object[] {phaseId, parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPhaseId_ParentId;
			finderArgs = new Object[] {
				phaseId, parentId, start, end, orderByComparator
			};
		}

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if (!Objects.equals(phaseId, workEntry.getPhaseId()) ||
						!Objects.equals(parentId, workEntry.getParentId())) {

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

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PHASEID_PARENTID_PHASEID_2);

			sb.append(_FINDER_COLUMN_PHASEID_PARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(phaseId.longValue());

				queryPos.add(parentId.longValue());

				list = (List<WorkEntry>)QueryUtil.list(
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
	 * Returns the first work entry in the ordered set where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByPhaseId_ParentId_First(
			Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByPhaseId_ParentId_First(
			phaseId, parentId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phaseId=");
		sb.append(phaseId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByPhaseId_ParentId_First(
		Long phaseId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByPhaseId_ParentId(
			phaseId, parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByPhaseId_ParentId_Last(
			Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByPhaseId_ParentId_Last(
			phaseId, parentId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("phaseId=");
		sb.append(phaseId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByPhaseId_ParentId_Last(
		Long phaseId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByPhaseId_ParentId(phaseId, parentId);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByPhaseId_ParentId(
			phaseId, parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByPhaseId_ParentId_PrevAndNext(
			long workId, Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByPhaseId_ParentId_PrevAndNext(
				session, workEntry, phaseId, parentId, orderByComparator, true);

			array[1] = workEntry;

			array[2] = getByPhaseId_ParentId_PrevAndNext(
				session, workEntry, phaseId, parentId, orderByComparator,
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

	protected WorkEntry getByPhaseId_ParentId_PrevAndNext(
		Session session, WorkEntry workEntry, Long phaseId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_WORKENTRY_WHERE);

		sb.append(_FINDER_COLUMN_PHASEID_PARENTID_PHASEID_2);

		sb.append(_FINDER_COLUMN_PHASEID_PARENTID_PARENTID_2);

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
			sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(phaseId.longValue());

		queryPos.add(parentId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work entries where phaseId = &#63; and parentId = &#63; from the database.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByPhaseId_ParentId(Long phaseId, Long parentId) {
		for (WorkEntry workEntry :
				findByPhaseId_ParentId(
					phaseId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @return the number of matching work entries
	 */
	@Override
	public int countByPhaseId_ParentId(Long phaseId, Long parentId) {
		FinderPath finderPath = _finderPathCountByPhaseId_ParentId;

		Object[] finderArgs = new Object[] {phaseId, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PHASEID_PARENTID_PHASEID_2);

			sb.append(_FINDER_COLUMN_PHASEID_PARENTID_PARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(phaseId.longValue());

				queryPos.add(parentId.longValue());

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

	private static final String _FINDER_COLUMN_PHASEID_PARENTID_PHASEID_2 =
		"workEntry.phaseId = ? AND ";

	private static final String _FINDER_COLUMN_PHASEID_PARENTID_PARENTID_2 =
		"workEntry.parentId = ?";

	private FinderPath _finderPathWithPaginationFindByParentId;
	private FinderPath _finderPathWithoutPaginationFindByParentId;
	private FinderPath _finderPathCountByParentId;

	/**
	 * Returns all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByParentId(long businessId, Long parentId) {
		return findByParentId(
			businessId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByParentId(
		long businessId, Long parentId, int start, int end) {

		return findByParentId(businessId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByParentId(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByParentId(
			businessId, parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByParentId(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParentId;
				finderArgs = new Object[] {businessId, parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentId;
			finderArgs = new Object[] {
				businessId, parentId, start, end, orderByComparator
			};
		}

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if ((businessId != workEntry.getBusinessId()) ||
						!Objects.equals(parentId, workEntry.getParentId())) {

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

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PARENTID_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(parentId.longValue());

				list = (List<WorkEntry>)QueryUtil.list(
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
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByParentId_First(
			long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByParentId_First(
			businessId, parentId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByParentId_First(
		long businessId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByParentId(
			businessId, parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByParentId_Last(
			long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByParentId_Last(
			businessId, parentId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByParentId_Last(
		long businessId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByParentId(businessId, parentId);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByParentId(
			businessId, parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByParentId_PrevAndNext(
			long workId, long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByParentId_PrevAndNext(
				session, workEntry, businessId, parentId, orderByComparator,
				true);

			array[1] = workEntry;

			array[2] = getByParentId_PrevAndNext(
				session, workEntry, businessId, parentId, orderByComparator,
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

	protected WorkEntry getByParentId_PrevAndNext(
		Session session, WorkEntry workEntry, long businessId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_WORKENTRY_WHERE);

		sb.append(_FINDER_COLUMN_PARENTID_BUSINESSID_2);

		sb.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

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
			sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessId);

		queryPos.add(parentId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work entries where businessId = &#63; and parentId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByParentId(long businessId, Long parentId) {
		for (WorkEntry workEntry :
				findByParentId(
					businessId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the number of matching work entries
	 */
	@Override
	public int countByParentId(long businessId, Long parentId) {
		FinderPath finderPath = _finderPathCountByParentId;

		Object[] finderArgs = new Object[] {businessId, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PARENTID_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(parentId.longValue());

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

	private static final String _FINDER_COLUMN_PARENTID_BUSINESSID_2 =
		"workEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 =
		"workEntry.parentId = ?";

	private FinderPath _finderPathFetchByParentIdAndName;
	private FinderPath _finderPathCountByParentIdAndName;

	/**
	 * Returns the work entry where businessId = &#63; and parentId = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByParentIdAndName(
			long businessId, Long parentId, String name)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByParentIdAndName(
			businessId, parentId, name);

		if (workEntry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("businessId=");
			sb.append(businessId);

			sb.append(", parentId=");
			sb.append(parentId);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchWorkEntryException(sb.toString());
		}

		return workEntry;
	}

	/**
	 * Returns the work entry where businessId = &#63; and parentId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByParentIdAndName(
		long businessId, Long parentId, String name) {

		return fetchByParentIdAndName(businessId, parentId, name, true);
	}

	/**
	 * Returns the work entry where businessId = &#63; and parentId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByParentIdAndName(
		long businessId, Long parentId, String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {businessId, parentId, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByParentIdAndName, finderArgs);
		}

		if (result instanceof WorkEntry) {
			WorkEntry workEntry = (WorkEntry)result;

			if ((businessId != workEntry.getBusinessId()) ||
				!Objects.equals(parentId, workEntry.getParentId()) ||
				!Objects.equals(name, workEntry.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PARENTIDANDNAME_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_PARENTIDANDNAME_PARENTID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTIDANDNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_PARENTIDANDNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(parentId.longValue());

				if (bindName) {
					queryPos.add(name);
				}

				List<WorkEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByParentIdAndName, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									businessId, parentId, name
								};
							}

							_log.warn(
								"WorkEntryPersistenceImpl.fetchByParentIdAndName(long, Long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WorkEntry workEntry = list.get(0);

					result = workEntry;

					cacheResult(workEntry);
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
			return (WorkEntry)result;
		}
	}

	/**
	 * Removes the work entry where businessId = &#63; and parentId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @return the work entry that was removed
	 */
	@Override
	public WorkEntry removeByParentIdAndName(
			long businessId, Long parentId, String name)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByParentIdAndName(businessId, parentId, name);

		return remove(workEntry);
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and parentId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @return the number of matching work entries
	 */
	@Override
	public int countByParentIdAndName(
		long businessId, Long parentId, String name) {

		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByParentIdAndName;

		Object[] finderArgs = new Object[] {businessId, parentId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PARENTIDANDNAME_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_PARENTIDANDNAME_PARENTID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTIDANDNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_PARENTIDANDNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(parentId.longValue());

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

	private static final String _FINDER_COLUMN_PARENTIDANDNAME_BUSINESSID_2 =
		"workEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_PARENTIDANDNAME_PARENTID_2 =
		"workEntry.parentId = ? AND ";

	private static final String _FINDER_COLUMN_PARENTIDANDNAME_NAME_2 =
		"workEntry.name = ?";

	private static final String _FINDER_COLUMN_PARENTIDANDNAME_NAME_3 =
		"(workEntry.name IS NULL OR workEntry.name = '')";

	private FinderPath _finderPathWithPaginationFindByParentCode;
	private FinderPath _finderPathWithoutPaginationFindByParentCode;
	private FinderPath _finderPathCountByParentCode;

	/**
	 * Returns all the work entries where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByParentCode(String parentReferenceCode) {
		return findByParentCode(
			parentReferenceCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByParentCode(
		String parentReferenceCode, int start, int end) {

		return findByParentCode(parentReferenceCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByParentCode(
		String parentReferenceCode, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByParentCode(
			parentReferenceCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByParentCode(
		String parentReferenceCode, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		parentReferenceCode = Objects.toString(parentReferenceCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParentCode;
				finderArgs = new Object[] {parentReferenceCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentCode;
			finderArgs = new Object[] {
				parentReferenceCode, start, end, orderByComparator
			};
		}

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if (!parentReferenceCode.equals(
							workEntry.getParentReferenceCode())) {

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

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			boolean bindParentReferenceCode = false;

			if (parentReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTCODE_PARENTREFERENCECODE_3);
			}
			else {
				bindParentReferenceCode = true;

				sb.append(_FINDER_COLUMN_PARENTCODE_PARENTREFERENCECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParentReferenceCode) {
					queryPos.add(parentReferenceCode);
				}

				list = (List<WorkEntry>)QueryUtil.list(
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
	 * Returns the first work entry in the ordered set where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByParentCode_First(
			String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByParentCode_First(
			parentReferenceCode, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentReferenceCode=");
		sb.append(parentReferenceCode);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByParentCode_First(
		String parentReferenceCode,
		OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByParentCode(
			parentReferenceCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByParentCode_Last(
			String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByParentCode_Last(
			parentReferenceCode, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentReferenceCode=");
		sb.append(parentReferenceCode);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByParentCode_Last(
		String parentReferenceCode,
		OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByParentCode(parentReferenceCode);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByParentCode(
			parentReferenceCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where parentReferenceCode = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByParentCode_PrevAndNext(
			long workId, String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		parentReferenceCode = Objects.toString(parentReferenceCode, "");

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByParentCode_PrevAndNext(
				session, workEntry, parentReferenceCode, orderByComparator,
				true);

			array[1] = workEntry;

			array[2] = getByParentCode_PrevAndNext(
				session, workEntry, parentReferenceCode, orderByComparator,
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

	protected WorkEntry getByParentCode_PrevAndNext(
		Session session, WorkEntry workEntry, String parentReferenceCode,
		OrderByComparator<WorkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKENTRY_WHERE);

		boolean bindParentReferenceCode = false;

		if (parentReferenceCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_PARENTCODE_PARENTREFERENCECODE_3);
		}
		else {
			bindParentReferenceCode = true;

			sb.append(_FINDER_COLUMN_PARENTCODE_PARENTREFERENCECODE_2);
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
			sb.append(WorkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindParentReferenceCode) {
			queryPos.add(parentReferenceCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(workEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work entries where parentReferenceCode = &#63; from the database.
	 *
	 * @param parentReferenceCode the parent reference code
	 */
	@Override
	public void removeByParentCode(String parentReferenceCode) {
		for (WorkEntry workEntry :
				findByParentCode(
					parentReferenceCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @return the number of matching work entries
	 */
	@Override
	public int countByParentCode(String parentReferenceCode) {
		parentReferenceCode = Objects.toString(parentReferenceCode, "");

		FinderPath finderPath = _finderPathCountByParentCode;

		Object[] finderArgs = new Object[] {parentReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			boolean bindParentReferenceCode = false;

			if (parentReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTCODE_PARENTREFERENCECODE_3);
			}
			else {
				bindParentReferenceCode = true;

				sb.append(_FINDER_COLUMN_PARENTCODE_PARENTREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParentReferenceCode) {
					queryPos.add(parentReferenceCode);
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

	private static final String
		_FINDER_COLUMN_PARENTCODE_PARENTREFERENCECODE_2 =
			"workEntry.parentReferenceCode = ?";

	private static final String
		_FINDER_COLUMN_PARENTCODE_PARENTREFERENCECODE_3 =
			"(workEntry.parentReferenceCode IS NULL OR workEntry.parentReferenceCode = '')";

	private FinderPath _finderPathFetchByProjectAndName;
	private FinderPath _finderPathCountByProjectAndName;

	/**
	 * Returns the work entry where projectId = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param projectId the project ID
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByProjectAndName(Long projectId, String name)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByProjectAndName(projectId, name);

		if (workEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("projectId=");
			sb.append(projectId);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchWorkEntryException(sb.toString());
		}

		return workEntry;
	}

	/**
	 * Returns the work entry where projectId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectId the project ID
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByProjectAndName(Long projectId, String name) {
		return fetchByProjectAndName(projectId, name, true);
	}

	/**
	 * Returns the work entry where projectId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectId the project ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByProjectAndName(
		Long projectId, String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {projectId, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProjectAndName, finderArgs);
		}

		if (result instanceof WorkEntry) {
			WorkEntry workEntry = (WorkEntry)result;

			if (!Objects.equals(projectId, workEntry.getProjectId()) ||
				!Objects.equals(name, workEntry.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTANDNAME_PROJECTID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_PROJECTANDNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_PROJECTANDNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId.longValue());

				if (bindName) {
					queryPos.add(name);
				}

				List<WorkEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProjectAndName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {projectId, name};
							}

							_log.warn(
								"WorkEntryPersistenceImpl.fetchByProjectAndName(Long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WorkEntry workEntry = list.get(0);

					result = workEntry;

					cacheResult(workEntry);
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
			return (WorkEntry)result;
		}
	}

	/**
	 * Removes the work entry where projectId = &#63; and name = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param name the name
	 * @return the work entry that was removed
	 */
	@Override
	public WorkEntry removeByProjectAndName(Long projectId, String name)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByProjectAndName(projectId, name);

		return remove(workEntry);
	}

	/**
	 * Returns the number of work entries where projectId = &#63; and name = &#63;.
	 *
	 * @param projectId the project ID
	 * @param name the name
	 * @return the number of matching work entries
	 */
	@Override
	public int countByProjectAndName(Long projectId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByProjectAndName;

		Object[] finderArgs = new Object[] {projectId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTANDNAME_PROJECTID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_PROJECTANDNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_PROJECTANDNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId.longValue());

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

	private static final String _FINDER_COLUMN_PROJECTANDNAME_PROJECTID_2 =
		"workEntry.projectId = ? AND ";

	private static final String _FINDER_COLUMN_PROJECTANDNAME_NAME_2 =
		"workEntry.name = ?";

	private static final String _FINDER_COLUMN_PROJECTANDNAME_NAME_3 =
		"(workEntry.name IS NULL OR workEntry.name = '')";

	private FinderPath _finderPathFetchByParentCodeAndName;
	private FinderPath _finderPathCountByParentCodeAndName;

	/**
	 * Returns the work entry where parentReferenceCode = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByParentCodeAndName(
			String parentReferenceCode, String name)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByParentCodeAndName(
			parentReferenceCode, name);

		if (workEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("parentReferenceCode=");
			sb.append(parentReferenceCode);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchWorkEntryException(sb.toString());
		}

		return workEntry;
	}

	/**
	 * Returns the work entry where parentReferenceCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByParentCodeAndName(
		String parentReferenceCode, String name) {

		return fetchByParentCodeAndName(parentReferenceCode, name, true);
	}

	/**
	 * Returns the work entry where parentReferenceCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByParentCodeAndName(
		String parentReferenceCode, String name, boolean useFinderCache) {

		parentReferenceCode = Objects.toString(parentReferenceCode, "");
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {parentReferenceCode, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByParentCodeAndName, finderArgs);
		}

		if (result instanceof WorkEntry) {
			WorkEntry workEntry = (WorkEntry)result;

			if (!Objects.equals(
					parentReferenceCode, workEntry.getParentReferenceCode()) ||
				!Objects.equals(name, workEntry.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			boolean bindParentReferenceCode = false;

			if (parentReferenceCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARENTCODEANDNAME_PARENTREFERENCECODE_3);
			}
			else {
				bindParentReferenceCode = true;

				sb.append(
					_FINDER_COLUMN_PARENTCODEANDNAME_PARENTREFERENCECODE_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTCODEANDNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_PARENTCODEANDNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParentReferenceCode) {
					queryPos.add(parentReferenceCode);
				}

				if (bindName) {
					queryPos.add(name);
				}

				List<WorkEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByParentCodeAndName, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									parentReferenceCode, name
								};
							}

							_log.warn(
								"WorkEntryPersistenceImpl.fetchByParentCodeAndName(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WorkEntry workEntry = list.get(0);

					result = workEntry;

					cacheResult(workEntry);
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
			return (WorkEntry)result;
		}
	}

	/**
	 * Removes the work entry where parentReferenceCode = &#63; and name = &#63; from the database.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the work entry that was removed
	 */
	@Override
	public WorkEntry removeByParentCodeAndName(
			String parentReferenceCode, String name)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByParentCodeAndName(
			parentReferenceCode, name);

		return remove(workEntry);
	}

	/**
	 * Returns the number of work entries where parentReferenceCode = &#63; and name = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the number of matching work entries
	 */
	@Override
	public int countByParentCodeAndName(
		String parentReferenceCode, String name) {

		parentReferenceCode = Objects.toString(parentReferenceCode, "");
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByParentCodeAndName;

		Object[] finderArgs = new Object[] {parentReferenceCode, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			boolean bindParentReferenceCode = false;

			if (parentReferenceCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PARENTCODEANDNAME_PARENTREFERENCECODE_3);
			}
			else {
				bindParentReferenceCode = true;

				sb.append(
					_FINDER_COLUMN_PARENTCODEANDNAME_PARENTREFERENCECODE_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_PARENTCODEANDNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_PARENTCODEANDNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindParentReferenceCode) {
					queryPos.add(parentReferenceCode);
				}

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

	private static final String
		_FINDER_COLUMN_PARENTCODEANDNAME_PARENTREFERENCECODE_2 =
			"workEntry.parentReferenceCode = ? AND ";

	private static final String
		_FINDER_COLUMN_PARENTCODEANDNAME_PARENTREFERENCECODE_3 =
			"(workEntry.parentReferenceCode IS NULL OR workEntry.parentReferenceCode = '') AND ";

	private static final String _FINDER_COLUMN_PARENTCODEANDNAME_NAME_2 =
		"workEntry.name = ?";

	private static final String _FINDER_COLUMN_PARENTCODEANDNAME_NAME_3 =
		"(workEntry.name IS NULL OR workEntry.name = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the work entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByC_ERC(companyId, externalReferenceCode);

		if (workEntry == null) {
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

			throw new NoSuchWorkEntryException(sb.toString());
		}

		return workEntry;
	}

	/**
	 * Returns the work entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the work entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByC_ERC(
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

		if (result instanceof WorkEntry) {
			WorkEntry workEntry = (WorkEntry)result;

			if ((companyId != workEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					workEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

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

				List<WorkEntry> list = query.list();

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
								"WorkEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WorkEntry workEntry = list.get(0);

					result = workEntry;

					cacheResult(workEntry);
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
			return (WorkEntry)result;
		}
	}

	/**
	 * Removes the work entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the work entry that was removed
	 */
	@Override
	public WorkEntry removeByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByC_ERC(companyId, externalReferenceCode);

		return remove(workEntry);
	}

	/**
	 * Returns the number of work entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching work entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

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
		"workEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"workEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(workEntry.externalReferenceCode IS NULL OR workEntry.externalReferenceCode = '')";

	public WorkEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(WorkEntry.class);

		setModelImplClass(WorkEntryImpl.class);
		setModelPKClass(long.class);

		setTable(WorkEntryTable.INSTANCE);
	}

	/**
	 * Caches the work entry in the entity cache if it is enabled.
	 *
	 * @param workEntry the work entry
	 */
	@Override
	public void cacheResult(WorkEntry workEntry) {
		entityCache.putResult(
			WorkEntryImpl.class, workEntry.getPrimaryKey(), workEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {workEntry.getUuid(), workEntry.getGroupId()},
			workEntry);

		finderCache.putResult(
			_finderPathFetchByParentIdAndName,
			new Object[] {
				workEntry.getBusinessId(), workEntry.getParentId(),
				workEntry.getName()
			},
			workEntry);

		finderCache.putResult(
			_finderPathFetchByProjectAndName,
			new Object[] {workEntry.getProjectId(), workEntry.getName()},
			workEntry);

		finderCache.putResult(
			_finderPathFetchByParentCodeAndName,
			new Object[] {
				workEntry.getParentReferenceCode(), workEntry.getName()
			},
			workEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				workEntry.getCompanyId(), workEntry.getExternalReferenceCode()
			},
			workEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the work entries in the entity cache if it is enabled.
	 *
	 * @param workEntries the work entries
	 */
	@Override
	public void cacheResult(List<WorkEntry> workEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (workEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (WorkEntry workEntry : workEntries) {
			if (entityCache.getResult(
					WorkEntryImpl.class, workEntry.getPrimaryKey()) == null) {

				cacheResult(workEntry);
			}
		}
	}

	/**
	 * Clears the cache for all work entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkEntryImpl.class);

		finderCache.clearCache(WorkEntryImpl.class);
	}

	/**
	 * Clears the cache for the work entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkEntry workEntry) {
		entityCache.removeResult(WorkEntryImpl.class, workEntry);
	}

	@Override
	public void clearCache(List<WorkEntry> workEntries) {
		for (WorkEntry workEntry : workEntries) {
			entityCache.removeResult(WorkEntryImpl.class, workEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(WorkEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(WorkEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		WorkEntryModelImpl workEntryModelImpl) {

		Object[] args = new Object[] {
			workEntryModelImpl.getUuid(), workEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, workEntryModelImpl);

		args = new Object[] {
			workEntryModelImpl.getBusinessId(),
			workEntryModelImpl.getParentId(), workEntryModelImpl.getName()
		};

		finderCache.putResult(
			_finderPathCountByParentIdAndName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByParentIdAndName, args, workEntryModelImpl);

		args = new Object[] {
			workEntryModelImpl.getProjectId(), workEntryModelImpl.getName()
		};

		finderCache.putResult(
			_finderPathCountByProjectAndName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProjectAndName, args, workEntryModelImpl);

		args = new Object[] {
			workEntryModelImpl.getParentReferenceCode(),
			workEntryModelImpl.getName()
		};

		finderCache.putResult(
			_finderPathCountByParentCodeAndName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByParentCodeAndName, args, workEntryModelImpl);

		args = new Object[] {
			workEntryModelImpl.getCompanyId(),
			workEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, workEntryModelImpl);
	}

	/**
	 * Creates a new work entry with the primary key. Does not add the work entry to the database.
	 *
	 * @param workId the primary key for the new work entry
	 * @return the new work entry
	 */
	@Override
	public WorkEntry create(long workId) {
		WorkEntry workEntry = new WorkEntryImpl();

		workEntry.setNew(true);
		workEntry.setPrimaryKey(workId);

		String uuid = PortalUUIDUtil.generate();

		workEntry.setUuid(uuid);

		workEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return workEntry;
	}

	/**
	 * Removes the work entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry that was removed
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry remove(long workId) throws NoSuchWorkEntryException {
		return remove((Serializable)workId);
	}

	/**
	 * Removes the work entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work entry
	 * @return the work entry that was removed
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry remove(Serializable primaryKey)
		throws NoSuchWorkEntryException {

		Session session = null;

		try {
			session = openSession();

			WorkEntry workEntry = (WorkEntry)session.get(
				WorkEntryImpl.class, primaryKey);

			if (workEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(workEntry);
		}
		catch (NoSuchWorkEntryException noSuchEntityException) {
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
	protected WorkEntry removeImpl(WorkEntry workEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workEntry)) {
				workEntry = (WorkEntry)session.get(
					WorkEntryImpl.class, workEntry.getPrimaryKeyObj());
			}

			if (workEntry != null) {
				session.delete(workEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (workEntry != null) {
			clearCache(workEntry);
		}

		return workEntry;
	}

	@Override
	public WorkEntry updateImpl(WorkEntry workEntry) {
		boolean isNew = workEntry.isNew();

		if (!(workEntry instanceof WorkEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(workEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkEntry implementation " +
					workEntry.getClass());
		}

		WorkEntryModelImpl workEntryModelImpl = (WorkEntryModelImpl)workEntry;

		if (Validator.isNull(workEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			workEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (workEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				workEntry.setCreateDate(date);
			}
			else {
				workEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!workEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				workEntry.setModifiedDate(date);
			}
			else {
				workEntry.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(workEntry);
			}
			else {
				workEntry = (WorkEntry)session.merge(workEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			WorkEntryImpl.class, workEntryModelImpl, false, true);

		cacheUniqueFindersCache(workEntryModelImpl);

		if (isNew) {
			workEntry.setNew(false);
		}

		workEntry.resetOriginalValues();

		return workEntry;
	}

	/**
	 * Returns the work entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work entry
	 * @return the work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByPrimaryKey(primaryKey);

		if (workEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return workEntry;
	}

	/**
	 * Returns the work entry with the primary key or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry findByPrimaryKey(long workId)
		throws NoSuchWorkEntryException {

		return findByPrimaryKey((Serializable)workId);
	}

	/**
	 * Returns the work entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry, or <code>null</code> if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry fetchByPrimaryKey(long workId) {
		return fetchByPrimaryKey((Serializable)workId);
	}

	/**
	 * Returns all the work entries.
	 *
	 * @return the work entries
	 */
	@Override
	public List<WorkEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of work entries
	 */
	@Override
	public List<WorkEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work entries
	 */
	@Override
	public List<WorkEntry> findAll(
		int start, int end, OrderByComparator<WorkEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work entries
	 */
	@Override
	public List<WorkEntry> findAll(
		int start, int end, OrderByComparator<WorkEntry> orderByComparator,
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

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WORKENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WORKENTRY;

				sql = sql.concat(WorkEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WorkEntry>)QueryUtil.list(
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
	 * Removes all the work entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkEntry workEntry : findAll()) {
			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries.
	 *
	 * @return the number of work entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WORKENTRY);

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
		return "workId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WORKENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work entry persistence.
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

		_finderPathWithPaginationFindByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"projectId"}, true);

		_finderPathWithoutPaginationFindByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectId",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			true);

		_finderPathCountByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectId",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			false);

		_finderPathWithPaginationFindByProjectId_ParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectId_ParentId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"projectId", "parentId"}, true);

		_finderPathWithoutPaginationFindByProjectId_ParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProjectId_ParentId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"projectId", "parentId"}, true);

		_finderPathCountByProjectId_ParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProjectId_ParentId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"projectId", "parentId"}, false);

		_finderPathWithPaginationFindByProjectAndPhase = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectAndPhase",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"projectId", "phaseId"}, true);

		_finderPathWithoutPaginationFindByProjectAndPhase = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectAndPhase",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"projectId", "phaseId"}, true);

		_finderPathCountByProjectAndPhase = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectAndPhase",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"projectId", "phaseId"}, false);

		_finderPathWithPaginationFindByProjectId_PhaseId_ParentId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByProjectId_PhaseId_ParentId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"projectId", "phaseId", "parentId"}, true);

		_finderPathWithoutPaginationFindByProjectId_PhaseId_ParentId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByProjectId_PhaseId_ParentId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {"projectId", "phaseId", "parentId"}, true);

		_finderPathCountByProjectId_PhaseId_ParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProjectId_PhaseId_ParentId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"projectId", "phaseId", "parentId"}, false);

		_finderPathWithPaginationFindByPhaseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPhaseId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"phaseId"}, true);

		_finderPathWithoutPaginationFindByPhaseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPhaseId",
			new String[] {Long.class.getName()}, new String[] {"phaseId"},
			true);

		_finderPathCountByPhaseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhaseId",
			new String[] {Long.class.getName()}, new String[] {"phaseId"},
			false);

		_finderPathWithPaginationFindByPhaseId_ParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPhaseId_ParentId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"phaseId", "parentId"}, true);

		_finderPathWithoutPaginationFindByPhaseId_ParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPhaseId_ParentId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"phaseId", "parentId"}, true);

		_finderPathCountByPhaseId_ParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPhaseId_ParentId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"phaseId", "parentId"}, false);

		_finderPathWithPaginationFindByParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "parentId"}, true);

		_finderPathWithoutPaginationFindByParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "parentId"}, true);

		_finderPathCountByParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "parentId"}, false);

		_finderPathFetchByParentIdAndName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByParentIdAndName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"businessId", "parentId", "name"}, true);

		_finderPathCountByParentIdAndName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentIdAndName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"businessId", "parentId", "name"}, false);

		_finderPathWithPaginationFindByParentCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parentReferenceCode"}, true);

		_finderPathWithoutPaginationFindByParentCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentCode",
			new String[] {String.class.getName()},
			new String[] {"parentReferenceCode"}, true);

		_finderPathCountByParentCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentCode",
			new String[] {String.class.getName()},
			new String[] {"parentReferenceCode"}, false);

		_finderPathFetchByProjectAndName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProjectAndName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"projectId", "name"}, true);

		_finderPathCountByProjectAndName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectAndName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"projectId", "name"}, false);

		_finderPathFetchByParentCodeAndName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByParentCodeAndName",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"parentReferenceCode", "name"}, true);

		_finderPathCountByParentCodeAndName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentCodeAndName",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"parentReferenceCode", "name"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setWorkEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setWorkEntryUtilPersistence(null);

		entityCache.removeCache(WorkEntryImpl.class.getName());
	}

	private void _setWorkEntryUtilPersistence(
		WorkEntryPersistence workEntryPersistence) {

		try {
			Field field = WorkEntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, workEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_WORKPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_WORKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_WORKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_WORKENTRY =
		"SELECT workEntry FROM WorkEntry workEntry";

	private static final String _SQL_SELECT_WORKENTRY_WHERE =
		"SELECT workEntry FROM WorkEntry workEntry WHERE ";

	private static final String _SQL_COUNT_WORKENTRY =
		"SELECT COUNT(workEntry) FROM WorkEntry workEntry";

	private static final String _SQL_COUNT_WORKENTRY_WHERE =
		"SELECT COUNT(workEntry) FROM WorkEntry workEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "workEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WorkEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WorkEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WorkEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private WorkEntryModelArgumentsResolver _workEntryModelArgumentsResolver;

}