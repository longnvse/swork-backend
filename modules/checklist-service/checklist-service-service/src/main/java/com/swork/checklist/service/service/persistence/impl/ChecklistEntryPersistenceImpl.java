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

package com.swork.checklist.service.service.persistence.impl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.swork.checklist.service.exception.NoSuchChecklistEntryException;
import com.swork.checklist.service.model.ChecklistEntry;
import com.swork.checklist.service.model.ChecklistEntryTable;
import com.swork.checklist.service.model.impl.ChecklistEntryImpl;
import com.swork.checklist.service.model.impl.ChecklistEntryModelImpl;
import com.swork.checklist.service.service.persistence.ChecklistEntryPersistence;
import com.swork.checklist.service.service.persistence.ChecklistEntryUtil;
import com.swork.checklist.service.service.persistence.impl.constants.SW_CHECKLISTPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the checklist entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ChecklistEntryPersistence.class, BasePersistence.class})
public class ChecklistEntryPersistenceImpl
	extends BasePersistenceImpl<ChecklistEntry>
	implements ChecklistEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChecklistEntryUtil</code> to access the checklist entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChecklistEntryImpl.class.getName();

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
	 * Returns all the checklist entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching checklist entries
	 */
	@Override
	public List<ChecklistEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the checklist entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @return the range of matching checklist entries
	 */
	@Override
	public List<ChecklistEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the checklist entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checklist entries
	 */
	@Override
	public List<ChecklistEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checklist entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checklist entries
	 */
	@Override
	public List<ChecklistEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator,
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

		List<ChecklistEntry> list = null;

		if (useFinderCache) {
			list = (List<ChecklistEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ChecklistEntry checklistEntry : list) {
					if (!uuid.equals(checklistEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_CHECKLISTENTRY_WHERE);

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
				sb.append(ChecklistEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ChecklistEntry>)QueryUtil.list(
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
	 * Returns the first checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	@Override
	public ChecklistEntry findByUuid_First(
			String uuid, OrderByComparator<ChecklistEntry> orderByComparator)
		throws NoSuchChecklistEntryException {

		ChecklistEntry checklistEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (checklistEntry != null) {
			return checklistEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchChecklistEntryException(sb.toString());
	}

	/**
	 * Returns the first checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	@Override
	public ChecklistEntry fetchByUuid_First(
		String uuid, OrderByComparator<ChecklistEntry> orderByComparator) {

		List<ChecklistEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	@Override
	public ChecklistEntry findByUuid_Last(
			String uuid, OrderByComparator<ChecklistEntry> orderByComparator)
		throws NoSuchChecklistEntryException {

		ChecklistEntry checklistEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (checklistEntry != null) {
			return checklistEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchChecklistEntryException(sb.toString());
	}

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	@Override
	public ChecklistEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ChecklistEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ChecklistEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the checklist entries before and after the current checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param checklistId the primary key of the current checklist entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checklist entry
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	@Override
	public ChecklistEntry[] findByUuid_PrevAndNext(
			long checklistId, String uuid,
			OrderByComparator<ChecklistEntry> orderByComparator)
		throws NoSuchChecklistEntryException {

		uuid = Objects.toString(uuid, "");

		ChecklistEntry checklistEntry = findByPrimaryKey(checklistId);

		Session session = null;

		try {
			session = openSession();

			ChecklistEntry[] array = new ChecklistEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, checklistEntry, uuid, orderByComparator, true);

			array[1] = checklistEntry;

			array[2] = getByUuid_PrevAndNext(
				session, checklistEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChecklistEntry getByUuid_PrevAndNext(
		Session session, ChecklistEntry checklistEntry, String uuid,
		OrderByComparator<ChecklistEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHECKLISTENTRY_WHERE);

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
			sb.append(ChecklistEntryModelImpl.ORDER_BY_JPQL);
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
						checklistEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChecklistEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the checklist entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ChecklistEntry checklistEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(checklistEntry);
		}
	}

	/**
	 * Returns the number of checklist entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching checklist entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHECKLISTENTRY_WHERE);

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
		"checklistEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(checklistEntry.uuid IS NULL OR checklistEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the checklist entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchChecklistEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	@Override
	public ChecklistEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchChecklistEntryException {

		ChecklistEntry checklistEntry = fetchByUUID_G(uuid, groupId);

		if (checklistEntry == null) {
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

			throw new NoSuchChecklistEntryException(sb.toString());
		}

		return checklistEntry;
	}

	/**
	 * Returns the checklist entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	@Override
	public ChecklistEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the checklist entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	@Override
	public ChecklistEntry fetchByUUID_G(
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

		if (result instanceof ChecklistEntry) {
			ChecklistEntry checklistEntry = (ChecklistEntry)result;

			if (!Objects.equals(uuid, checklistEntry.getUuid()) ||
				(groupId != checklistEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CHECKLISTENTRY_WHERE);

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

				List<ChecklistEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ChecklistEntry checklistEntry = list.get(0);

					result = checklistEntry;

					cacheResult(checklistEntry);
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
			return (ChecklistEntry)result;
		}
	}

	/**
	 * Removes the checklist entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the checklist entry that was removed
	 */
	@Override
	public ChecklistEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchChecklistEntryException {

		ChecklistEntry checklistEntry = findByUUID_G(uuid, groupId);

		return remove(checklistEntry);
	}

	/**
	 * Returns the number of checklist entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching checklist entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHECKLISTENTRY_WHERE);

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
		"checklistEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(checklistEntry.uuid IS NULL OR checklistEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"checklistEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching checklist entries
	 */
	@Override
	public List<ChecklistEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @return the range of matching checklist entries
	 */
	@Override
	public List<ChecklistEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checklist entries
	 */
	@Override
	public List<ChecklistEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checklist entries
	 */
	@Override
	public List<ChecklistEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator,
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

		List<ChecklistEntry> list = null;

		if (useFinderCache) {
			list = (List<ChecklistEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ChecklistEntry checklistEntry : list) {
					if (!uuid.equals(checklistEntry.getUuid()) ||
						(companyId != checklistEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CHECKLISTENTRY_WHERE);

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
				sb.append(ChecklistEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ChecklistEntry>)QueryUtil.list(
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
	 * Returns the first checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	@Override
	public ChecklistEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ChecklistEntry> orderByComparator)
		throws NoSuchChecklistEntryException {

		ChecklistEntry checklistEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (checklistEntry != null) {
			return checklistEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchChecklistEntryException(sb.toString());
	}

	/**
	 * Returns the first checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	@Override
	public ChecklistEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		List<ChecklistEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	@Override
	public ChecklistEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ChecklistEntry> orderByComparator)
		throws NoSuchChecklistEntryException {

		ChecklistEntry checklistEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (checklistEntry != null) {
			return checklistEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchChecklistEntryException(sb.toString());
	}

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	@Override
	public ChecklistEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ChecklistEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the checklist entries before and after the current checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param checklistId the primary key of the current checklist entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checklist entry
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	@Override
	public ChecklistEntry[] findByUuid_C_PrevAndNext(
			long checklistId, String uuid, long companyId,
			OrderByComparator<ChecklistEntry> orderByComparator)
		throws NoSuchChecklistEntryException {

		uuid = Objects.toString(uuid, "");

		ChecklistEntry checklistEntry = findByPrimaryKey(checklistId);

		Session session = null;

		try {
			session = openSession();

			ChecklistEntry[] array = new ChecklistEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, checklistEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = checklistEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, checklistEntry, uuid, companyId, orderByComparator,
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

	protected ChecklistEntry getByUuid_C_PrevAndNext(
		Session session, ChecklistEntry checklistEntry, String uuid,
		long companyId, OrderByComparator<ChecklistEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_CHECKLISTENTRY_WHERE);

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
			sb.append(ChecklistEntryModelImpl.ORDER_BY_JPQL);
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
						checklistEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChecklistEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the checklist entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ChecklistEntry checklistEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(checklistEntry);
		}
	}

	/**
	 * Returns the number of checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching checklist entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHECKLISTENTRY_WHERE);

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
		"checklistEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(checklistEntry.uuid IS NULL OR checklistEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"checklistEntry.companyId = ?";

	public ChecklistEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ChecklistEntry.class);

		setModelImplClass(ChecklistEntryImpl.class);
		setModelPKClass(long.class);

		setTable(ChecklistEntryTable.INSTANCE);
	}

	/**
	 * Caches the checklist entry in the entity cache if it is enabled.
	 *
	 * @param checklistEntry the checklist entry
	 */
	@Override
	public void cacheResult(ChecklistEntry checklistEntry) {
		entityCache.putResult(
			ChecklistEntryImpl.class, checklistEntry.getPrimaryKey(),
			checklistEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				checklistEntry.getUuid(), checklistEntry.getGroupId()
			},
			checklistEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the checklist entries in the entity cache if it is enabled.
	 *
	 * @param checklistEntries the checklist entries
	 */
	@Override
	public void cacheResult(List<ChecklistEntry> checklistEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (checklistEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ChecklistEntry checklistEntry : checklistEntries) {
			if (entityCache.getResult(
					ChecklistEntryImpl.class, checklistEntry.getPrimaryKey()) ==
						null) {

				cacheResult(checklistEntry);
			}
		}
	}

	/**
	 * Clears the cache for all checklist entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChecklistEntryImpl.class);

		finderCache.clearCache(ChecklistEntryImpl.class);
	}

	/**
	 * Clears the cache for the checklist entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChecklistEntry checklistEntry) {
		entityCache.removeResult(ChecklistEntryImpl.class, checklistEntry);
	}

	@Override
	public void clearCache(List<ChecklistEntry> checklistEntries) {
		for (ChecklistEntry checklistEntry : checklistEntries) {
			entityCache.removeResult(ChecklistEntryImpl.class, checklistEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ChecklistEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ChecklistEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ChecklistEntryModelImpl checklistEntryModelImpl) {

		Object[] args = new Object[] {
			checklistEntryModelImpl.getUuid(),
			checklistEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, checklistEntryModelImpl);
	}

	/**
	 * Creates a new checklist entry with the primary key. Does not add the checklist entry to the database.
	 *
	 * @param checklistId the primary key for the new checklist entry
	 * @return the new checklist entry
	 */
	@Override
	public ChecklistEntry create(long checklistId) {
		ChecklistEntry checklistEntry = new ChecklistEntryImpl();

		checklistEntry.setNew(true);
		checklistEntry.setPrimaryKey(checklistId);

		String uuid = PortalUUIDUtil.generate();

		checklistEntry.setUuid(uuid);

		checklistEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return checklistEntry;
	}

	/**
	 * Removes the checklist entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry that was removed
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	@Override
	public ChecklistEntry remove(long checklistId)
		throws NoSuchChecklistEntryException {

		return remove((Serializable)checklistId);
	}

	/**
	 * Removes the checklist entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the checklist entry
	 * @return the checklist entry that was removed
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	@Override
	public ChecklistEntry remove(Serializable primaryKey)
		throws NoSuchChecklistEntryException {

		Session session = null;

		try {
			session = openSession();

			ChecklistEntry checklistEntry = (ChecklistEntry)session.get(
				ChecklistEntryImpl.class, primaryKey);

			if (checklistEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChecklistEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(checklistEntry);
		}
		catch (NoSuchChecklistEntryException noSuchEntityException) {
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
	protected ChecklistEntry removeImpl(ChecklistEntry checklistEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(checklistEntry)) {
				checklistEntry = (ChecklistEntry)session.get(
					ChecklistEntryImpl.class,
					checklistEntry.getPrimaryKeyObj());
			}

			if (checklistEntry != null) {
				session.delete(checklistEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (checklistEntry != null) {
			clearCache(checklistEntry);
		}

		return checklistEntry;
	}

	@Override
	public ChecklistEntry updateImpl(ChecklistEntry checklistEntry) {
		boolean isNew = checklistEntry.isNew();

		if (!(checklistEntry instanceof ChecklistEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(checklistEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					checklistEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in checklistEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ChecklistEntry implementation " +
					checklistEntry.getClass());
		}

		ChecklistEntryModelImpl checklistEntryModelImpl =
			(ChecklistEntryModelImpl)checklistEntry;

		if (Validator.isNull(checklistEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			checklistEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (checklistEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				checklistEntry.setCreateDate(date);
			}
			else {
				checklistEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!checklistEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				checklistEntry.setModifiedDate(date);
			}
			else {
				checklistEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(checklistEntry);
			}
			else {
				checklistEntry = (ChecklistEntry)session.merge(checklistEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ChecklistEntryImpl.class, checklistEntryModelImpl, false, true);

		cacheUniqueFindersCache(checklistEntryModelImpl);

		if (isNew) {
			checklistEntry.setNew(false);
		}

		checklistEntry.resetOriginalValues();

		return checklistEntry;
	}

	/**
	 * Returns the checklist entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the checklist entry
	 * @return the checklist entry
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	@Override
	public ChecklistEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChecklistEntryException {

		ChecklistEntry checklistEntry = fetchByPrimaryKey(primaryKey);

		if (checklistEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChecklistEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return checklistEntry;
	}

	/**
	 * Returns the checklist entry with the primary key or throws a <code>NoSuchChecklistEntryException</code> if it could not be found.
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	@Override
	public ChecklistEntry findByPrimaryKey(long checklistId)
		throws NoSuchChecklistEntryException {

		return findByPrimaryKey((Serializable)checklistId);
	}

	/**
	 * Returns the checklist entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry, or <code>null</code> if a checklist entry with the primary key could not be found
	 */
	@Override
	public ChecklistEntry fetchByPrimaryKey(long checklistId) {
		return fetchByPrimaryKey((Serializable)checklistId);
	}

	/**
	 * Returns all the checklist entries.
	 *
	 * @return the checklist entries
	 */
	@Override
	public List<ChecklistEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the checklist entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @return the range of checklist entries
	 */
	@Override
	public List<ChecklistEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the checklist entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of checklist entries
	 */
	@Override
	public List<ChecklistEntry> findAll(
		int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checklist entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of checklist entries
	 */
	@Override
	public List<ChecklistEntry> findAll(
		int start, int end, OrderByComparator<ChecklistEntry> orderByComparator,
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

		List<ChecklistEntry> list = null;

		if (useFinderCache) {
			list = (List<ChecklistEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHECKLISTENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHECKLISTENTRY;

				sql = sql.concat(ChecklistEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ChecklistEntry>)QueryUtil.list(
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
	 * Removes all the checklist entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ChecklistEntry checklistEntry : findAll()) {
			remove(checklistEntry);
		}
	}

	/**
	 * Returns the number of checklist entries.
	 *
	 * @return the number of checklist entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHECKLISTENTRY);

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
		return "checklistId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CHECKLISTENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChecklistEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the checklist entry persistence.
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

		_setChecklistEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setChecklistEntryUtilPersistence(null);

		entityCache.removeCache(ChecklistEntryImpl.class.getName());
	}

	private void _setChecklistEntryUtilPersistence(
		ChecklistEntryPersistence checklistEntryPersistence) {

		try {
			Field field = ChecklistEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, checklistEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_CHECKLISTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_CHECKLISTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_CHECKLISTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CHECKLISTENTRY =
		"SELECT checklistEntry FROM ChecklistEntry checklistEntry";

	private static final String _SQL_SELECT_CHECKLISTENTRY_WHERE =
		"SELECT checklistEntry FROM ChecklistEntry checklistEntry WHERE ";

	private static final String _SQL_COUNT_CHECKLISTENTRY =
		"SELECT COUNT(checklistEntry) FROM ChecklistEntry checklistEntry";

	private static final String _SQL_COUNT_CHECKLISTENTRY_WHERE =
		"SELECT COUNT(checklistEntry) FROM ChecklistEntry checklistEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "checklistEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ChecklistEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ChecklistEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ChecklistEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ChecklistEntryModelArgumentsResolver
		_checklistEntryModelArgumentsResolver;

}