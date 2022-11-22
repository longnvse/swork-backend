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

	private FinderPath _finderPathWithPaginationFindByB_P;
	private FinderPath _finderPathWithoutPaginationFindByB_P;
	private FinderPath _finderPathCountByB_P;

	/**
	 * Returns all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_P(long businessId, Long projectId) {
		return findByB_P(
			businessId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_P(
		long businessId, Long projectId, int start, int end) {

		return findByB_P(businessId, projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByB_P(
			businessId, projectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_P;
				finderArgs = new Object[] {businessId, projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_P;
			finderArgs = new Object[] {
				businessId, projectId, start, end, orderByComparator
			};
		}

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if ((businessId != workEntry.getBusinessId()) ||
						!Objects.equals(projectId, workEntry.getProjectId())) {

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

			sb.append(_FINDER_COLUMN_B_P_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_P_PROJECTID_2);

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
	 * Returns the first work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByB_P_First(
			long businessId, Long projectId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByB_P_First(
			businessId, projectId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByB_P_First(
		long businessId, Long projectId,
		OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByB_P(
			businessId, projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByB_P_Last(
			long businessId, Long projectId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByB_P_Last(
			businessId, projectId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByB_P_Last(
		long businessId, Long projectId,
		OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByB_P(businessId, projectId);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByB_P(
			businessId, projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByB_P_PrevAndNext(
			long workId, long businessId, Long projectId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByB_P_PrevAndNext(
				session, workEntry, businessId, projectId, orderByComparator,
				true);

			array[1] = workEntry;

			array[2] = getByB_P_PrevAndNext(
				session, workEntry, businessId, projectId, orderByComparator,
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

	protected WorkEntry getByB_P_PrevAndNext(
		Session session, WorkEntry workEntry, long businessId, Long projectId,
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

		sb.append(_FINDER_COLUMN_B_P_BUSINESSID_2);

		sb.append(_FINDER_COLUMN_B_P_PROJECTID_2);

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
	 * Removes all the work entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	@Override
	public void removeByB_P(long businessId, Long projectId) {
		for (WorkEntry workEntry :
				findByB_P(
					businessId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching work entries
	 */
	@Override
	public int countByB_P(long businessId, Long projectId) {
		FinderPath finderPath = _finderPathCountByB_P;

		Object[] finderArgs = new Object[] {businessId, projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_P_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_P_PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

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

	private static final String _FINDER_COLUMN_B_P_BUSINESSID_2 =
		"workEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_P_PROJECTID_2 =
		"workEntry.projectId = ?";

	private FinderPath _finderPathWithPaginationFindByB_PH;
	private FinderPath _finderPathWithoutPaginationFindByB_PH;
	private FinderPath _finderPathCountByB_PH;

	/**
	 * Returns all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_PH(long businessId, Long phaseId) {
		return findByB_PH(
			businessId, phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end) {

		return findByB_PH(businessId, phaseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByB_PH(
			businessId, phaseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_PH;
				finderArgs = new Object[] {businessId, phaseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_PH;
			finderArgs = new Object[] {
				businessId, phaseId, start, end, orderByComparator
			};
		}

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if ((businessId != workEntry.getBusinessId()) ||
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

			sb.append(_FINDER_COLUMN_B_PH_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PH_PHASEID_2);

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
	 * Returns the first work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByB_PH_First(
			long businessId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByB_PH_First(
			businessId, phaseId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByB_PH_First(
		long businessId, Long phaseId,
		OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByB_PH(
			businessId, phaseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByB_PH_Last(
			long businessId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByB_PH_Last(
			businessId, phaseId, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByB_PH_Last(
		long businessId, Long phaseId,
		OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByB_PH(businessId, phaseId);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByB_PH(
			businessId, phaseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByB_PH_PrevAndNext(
			long workId, long businessId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByB_PH_PrevAndNext(
				session, workEntry, businessId, phaseId, orderByComparator,
				true);

			array[1] = workEntry;

			array[2] = getByB_PH_PrevAndNext(
				session, workEntry, businessId, phaseId, orderByComparator,
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

	protected WorkEntry getByB_PH_PrevAndNext(
		Session session, WorkEntry workEntry, long businessId, Long phaseId,
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

		sb.append(_FINDER_COLUMN_B_PH_BUSINESSID_2);

		sb.append(_FINDER_COLUMN_B_PH_PHASEID_2);

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
	 * Removes all the work entries where businessId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 */
	@Override
	public void removeByB_PH(long businessId, Long phaseId) {
		for (WorkEntry workEntry :
				findByB_PH(
					businessId, phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the number of matching work entries
	 */
	@Override
	public int countByB_PH(long businessId, Long phaseId) {
		FinderPath finderPath = _finderPathCountByB_PH;

		Object[] finderArgs = new Object[] {businessId, phaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_PH_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PH_PHASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

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

	private static final String _FINDER_COLUMN_B_PH_BUSINESSID_2 =
		"workEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_PH_PHASEID_2 =
		"workEntry.phaseId = ?";

	private FinderPath _finderPathWithPaginationFindByB_PID;
	private FinderPath _finderPathWithoutPaginationFindByB_PID;
	private FinderPath _finderPathCountByB_PID;

	/**
	 * Returns all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_PID(long businessId, Long parentId) {
		return findByB_PID(
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
	public List<WorkEntry> findByB_PID(
		long businessId, Long parentId, int start, int end) {

		return findByB_PID(businessId, parentId, start, end, null);
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
	public List<WorkEntry> findByB_PID(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByB_PID(
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
	public List<WorkEntry> findByB_PID(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_PID;
				finderArgs = new Object[] {businessId, parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_PID;
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

			sb.append(_FINDER_COLUMN_B_PID_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PID_PARENTID_2);

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
	public WorkEntry findByB_PID_First(
			long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByB_PID_First(
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
	public WorkEntry fetchByB_PID_First(
		long businessId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByB_PID(
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
	public WorkEntry findByB_PID_Last(
			long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByB_PID_Last(
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
	public WorkEntry fetchByB_PID_Last(
		long businessId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByB_PID(businessId, parentId);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByB_PID(
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
	public WorkEntry[] findByB_PID_PrevAndNext(
			long workId, long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByB_PID_PrevAndNext(
				session, workEntry, businessId, parentId, orderByComparator,
				true);

			array[1] = workEntry;

			array[2] = getByB_PID_PrevAndNext(
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

	protected WorkEntry getByB_PID_PrevAndNext(
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

		sb.append(_FINDER_COLUMN_B_PID_BUSINESSID_2);

		sb.append(_FINDER_COLUMN_B_PID_PARENTID_2);

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
	public void removeByB_PID(long businessId, Long parentId) {
		for (WorkEntry workEntry :
				findByB_PID(
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
	public int countByB_PID(long businessId, Long parentId) {
		FinderPath finderPath = _finderPathCountByB_PID;

		Object[] finderArgs = new Object[] {businessId, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_PID_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PID_PARENTID_2);

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

	private static final String _FINDER_COLUMN_B_PID_BUSINESSID_2 =
		"workEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_PID_PARENTID_2 =
		"workEntry.parentId = ?";

	private FinderPath _finderPathWithPaginationFindByB_P_C;
	private FinderPath _finderPathWithoutPaginationFindByB_P_C;
	private FinderPath _finderPathCountByB_P_C;

	/**
	 * Returns all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @return the matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode) {

		return findByB_P_C(
			businessId, parentReferenceCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode, int start, int end) {

		return findByB_P_C(businessId, parentReferenceCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return findByB_P_C(
			businessId, parentReferenceCode, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	@Override
	public List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		parentReferenceCode = Objects.toString(parentReferenceCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_P_C;
				finderArgs = new Object[] {businessId, parentReferenceCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_P_C;
			finderArgs = new Object[] {
				businessId, parentReferenceCode, start, end, orderByComparator
			};
		}

		List<WorkEntry> list = null;

		if (useFinderCache) {
			list = (List<WorkEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkEntry workEntry : list) {
					if ((businessId != workEntry.getBusinessId()) ||
						!parentReferenceCode.equals(
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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_P_C_BUSINESSID_2);

			boolean bindParentReferenceCode = false;

			if (parentReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_P_C_PARENTREFERENCECODE_3);
			}
			else {
				bindParentReferenceCode = true;

				sb.append(_FINDER_COLUMN_B_P_C_PARENTREFERENCECODE_2);
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

				queryPos.add(businessId);

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
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByB_P_C_First(
			long businessId, String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByB_P_C_First(
			businessId, parentReferenceCode, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", parentReferenceCode=");
		sb.append(parentReferenceCode);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByB_P_C_First(
		long businessId, String parentReferenceCode,
		OrderByComparator<WorkEntry> orderByComparator) {

		List<WorkEntry> list = findByB_P_C(
			businessId, parentReferenceCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByB_P_C_Last(
			long businessId, String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByB_P_C_Last(
			businessId, parentReferenceCode, orderByComparator);

		if (workEntry != null) {
			return workEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", parentReferenceCode=");
		sb.append(parentReferenceCode);

		sb.append("}");

		throw new NoSuchWorkEntryException(sb.toString());
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByB_P_C_Last(
		long businessId, String parentReferenceCode,
		OrderByComparator<WorkEntry> orderByComparator) {

		int count = countByB_P_C(businessId, parentReferenceCode);

		if (count == 0) {
			return null;
		}

		List<WorkEntry> list = findByB_P_C(
			businessId, parentReferenceCode, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	@Override
	public WorkEntry[] findByB_P_C_PrevAndNext(
			long workId, long businessId, String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws NoSuchWorkEntryException {

		parentReferenceCode = Objects.toString(parentReferenceCode, "");

		WorkEntry workEntry = findByPrimaryKey(workId);

		Session session = null;

		try {
			session = openSession();

			WorkEntry[] array = new WorkEntryImpl[3];

			array[0] = getByB_P_C_PrevAndNext(
				session, workEntry, businessId, parentReferenceCode,
				orderByComparator, true);

			array[1] = workEntry;

			array[2] = getByB_P_C_PrevAndNext(
				session, workEntry, businessId, parentReferenceCode,
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

	protected WorkEntry getByB_P_C_PrevAndNext(
		Session session, WorkEntry workEntry, long businessId,
		String parentReferenceCode,
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

		sb.append(_FINDER_COLUMN_B_P_C_BUSINESSID_2);

		boolean bindParentReferenceCode = false;

		if (parentReferenceCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_B_P_C_PARENTREFERENCECODE_3);
		}
		else {
			bindParentReferenceCode = true;

			sb.append(_FINDER_COLUMN_B_P_C_PARENTREFERENCECODE_2);
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

		queryPos.add(businessId);

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
	 * Removes all the work entries where businessId = &#63; and parentReferenceCode = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 */
	@Override
	public void removeByB_P_C(long businessId, String parentReferenceCode) {
		for (WorkEntry workEntry :
				findByB_P_C(
					businessId, parentReferenceCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(workEntry);
		}
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @return the number of matching work entries
	 */
	@Override
	public int countByB_P_C(long businessId, String parentReferenceCode) {
		parentReferenceCode = Objects.toString(parentReferenceCode, "");

		FinderPath finderPath = _finderPathCountByB_P_C;

		Object[] finderArgs = new Object[] {businessId, parentReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_P_C_BUSINESSID_2);

			boolean bindParentReferenceCode = false;

			if (parentReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_P_C_PARENTREFERENCECODE_3);
			}
			else {
				bindParentReferenceCode = true;

				sb.append(_FINDER_COLUMN_B_P_C_PARENTREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

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

	private static final String _FINDER_COLUMN_B_P_C_BUSINESSID_2 =
		"workEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_P_C_PARENTREFERENCECODE_2 =
		"workEntry.parentReferenceCode = ?";

	private static final String _FINDER_COLUMN_B_P_C_PARENTREFERENCECODE_3 =
		"(workEntry.parentReferenceCode IS NULL OR workEntry.parentReferenceCode = '')";

	private FinderPath _finderPathFetchByB_P_N;
	private FinderPath _finderPathCountByB_P_N;

	/**
	 * Returns the work entry where businessId = &#63; and projectId = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByB_P_N(long businessId, Long projectId, String name)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByB_P_N(businessId, projectId, name);

		if (workEntry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("businessId=");
			sb.append(businessId);

			sb.append(", projectId=");
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
	 * Returns the work entry where businessId = &#63; and projectId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByB_P_N(
		long businessId, Long projectId, String name) {

		return fetchByB_P_N(businessId, projectId, name, true);
	}

	/**
	 * Returns the work entry where businessId = &#63; and projectId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByB_P_N(
		long businessId, Long projectId, String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {businessId, projectId, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByB_P_N, finderArgs);
		}

		if (result instanceof WorkEntry) {
			WorkEntry workEntry = (WorkEntry)result;

			if ((businessId != workEntry.getBusinessId()) ||
				!Objects.equals(projectId, workEntry.getProjectId()) ||
				!Objects.equals(name, workEntry.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_P_N_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_P_N_PROJECTID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_P_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_P_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(projectId.longValue());

				if (bindName) {
					queryPos.add(name);
				}

				List<WorkEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByB_P_N, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									businessId, projectId, name
								};
							}

							_log.warn(
								"WorkEntryPersistenceImpl.fetchByB_P_N(long, Long, String, boolean) with parameters (" +
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
	 * Removes the work entry where businessId = &#63; and projectId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the work entry that was removed
	 */
	@Override
	public WorkEntry removeByB_P_N(long businessId, Long projectId, String name)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByB_P_N(businessId, projectId, name);

		return remove(workEntry);
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and projectId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the number of matching work entries
	 */
	@Override
	public int countByB_P_N(long businessId, Long projectId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByB_P_N;

		Object[] finderArgs = new Object[] {businessId, projectId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_P_N_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_P_N_PROJECTID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_P_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_P_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

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

	private static final String _FINDER_COLUMN_B_P_N_BUSINESSID_2 =
		"workEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_P_N_PROJECTID_2 =
		"workEntry.projectId = ? AND ";

	private static final String _FINDER_COLUMN_B_P_N_NAME_2 =
		"workEntry.name = ?";

	private static final String _FINDER_COLUMN_B_P_N_NAME_3 =
		"(workEntry.name IS NULL OR workEntry.name = '')";

	private FinderPath _finderPathFetchByB_P_C_N;
	private FinderPath _finderPathCountByB_P_C_N;

	/**
	 * Returns the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	@Override
	public WorkEntry findByB_P_C_N(
			long businessId, String parentReferenceCode, String name)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = fetchByB_P_C_N(
			businessId, parentReferenceCode, name);

		if (workEntry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("businessId=");
			sb.append(businessId);

			sb.append(", parentReferenceCode=");
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
	 * Returns the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByB_P_C_N(
		long businessId, String parentReferenceCode, String name) {

		return fetchByB_P_C_N(businessId, parentReferenceCode, name, true);
	}

	/**
	 * Returns the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Override
	public WorkEntry fetchByB_P_C_N(
		long businessId, String parentReferenceCode, String name,
		boolean useFinderCache) {

		parentReferenceCode = Objects.toString(parentReferenceCode, "");
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {businessId, parentReferenceCode, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByB_P_C_N, finderArgs);
		}

		if (result instanceof WorkEntry) {
			WorkEntry workEntry = (WorkEntry)result;

			if ((businessId != workEntry.getBusinessId()) ||
				!Objects.equals(
					parentReferenceCode, workEntry.getParentReferenceCode()) ||
				!Objects.equals(name, workEntry.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_P_C_N_BUSINESSID_2);

			boolean bindParentReferenceCode = false;

			if (parentReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_P_C_N_PARENTREFERENCECODE_3);
			}
			else {
				bindParentReferenceCode = true;

				sb.append(_FINDER_COLUMN_B_P_C_N_PARENTREFERENCECODE_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_P_C_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_P_C_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

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
							_finderPathFetchByB_P_C_N, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									businessId, parentReferenceCode, name
								};
							}

							_log.warn(
								"WorkEntryPersistenceImpl.fetchByB_P_C_N(long, String, String, boolean) with parameters (" +
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
	 * Removes the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the work entry that was removed
	 */
	@Override
	public WorkEntry removeByB_P_C_N(
			long businessId, String parentReferenceCode, String name)
		throws NoSuchWorkEntryException {

		WorkEntry workEntry = findByB_P_C_N(
			businessId, parentReferenceCode, name);

		return remove(workEntry);
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and parentReferenceCode = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the number of matching work entries
	 */
	@Override
	public int countByB_P_C_N(
		long businessId, String parentReferenceCode, String name) {

		parentReferenceCode = Objects.toString(parentReferenceCode, "");
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByB_P_C_N;

		Object[] finderArgs = new Object[] {
			businessId, parentReferenceCode, name
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_WORKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_P_C_N_BUSINESSID_2);

			boolean bindParentReferenceCode = false;

			if (parentReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_P_C_N_PARENTREFERENCECODE_3);
			}
			else {
				bindParentReferenceCode = true;

				sb.append(_FINDER_COLUMN_B_P_C_N_PARENTREFERENCECODE_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_P_C_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_P_C_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

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

	private static final String _FINDER_COLUMN_B_P_C_N_BUSINESSID_2 =
		"workEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_P_C_N_PARENTREFERENCECODE_2 =
		"workEntry.parentReferenceCode = ? AND ";

	private static final String _FINDER_COLUMN_B_P_C_N_PARENTREFERENCECODE_3 =
		"(workEntry.parentReferenceCode IS NULL OR workEntry.parentReferenceCode = '') AND ";

	private static final String _FINDER_COLUMN_B_P_C_N_NAME_2 =
		"workEntry.name = ?";

	private static final String _FINDER_COLUMN_B_P_C_N_NAME_3 =
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
			_finderPathFetchByB_P_N,
			new Object[] {
				workEntry.getBusinessId(), workEntry.getProjectId(),
				workEntry.getName()
			},
			workEntry);

		finderCache.putResult(
			_finderPathFetchByB_P_C_N,
			new Object[] {
				workEntry.getBusinessId(), workEntry.getParentReferenceCode(),
				workEntry.getName()
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
			workEntryModelImpl.getProjectId(), workEntryModelImpl.getName()
		};

		finderCache.putResult(_finderPathCountByB_P_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByB_P_N, args, workEntryModelImpl);

		args = new Object[] {
			workEntryModelImpl.getBusinessId(),
			workEntryModelImpl.getParentReferenceCode(),
			workEntryModelImpl.getName()
		};

		finderCache.putResult(_finderPathCountByB_P_C_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByB_P_C_N, args, workEntryModelImpl);

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

		_finderPathWithPaginationFindByB_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "projectId"}, true);

		_finderPathWithoutPaginationFindByB_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_P",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "projectId"}, true);

		_finderPathCountByB_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_P",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "projectId"}, false);

		_finderPathWithPaginationFindByB_PH = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_PH",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "phaseId"}, true);

		_finderPathWithoutPaginationFindByB_PH = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_PH",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "phaseId"}, true);

		_finderPathCountByB_PH = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_PH",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "phaseId"}, false);

		_finderPathWithPaginationFindByB_PID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_PID",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "parentId"}, true);

		_finderPathWithoutPaginationFindByB_PID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_PID",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "parentId"}, true);

		_finderPathCountByB_PID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_PID",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "parentId"}, false);

		_finderPathWithPaginationFindByB_P_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_P_C",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "parentReferenceCode"}, true);

		_finderPathWithoutPaginationFindByB_P_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_P_C",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"businessId", "parentReferenceCode"}, true);

		_finderPathCountByB_P_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_P_C",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"businessId", "parentReferenceCode"}, false);

		_finderPathFetchByB_P_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByB_P_N",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"businessId", "projectId", "name"}, true);

		_finderPathCountByB_P_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_P_N",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"businessId", "projectId", "name"}, false);

		_finderPathFetchByB_P_C_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByB_P_C_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"businessId", "parentReferenceCode", "name"}, true);

		_finderPathCountByB_P_C_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_P_C_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"businessId", "parentReferenceCode", "name"}, false);

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