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

import com.swork.checklist.service.exception.NoSuchChecklistHandlerEntryException;
import com.swork.checklist.service.model.ChecklistHandlerEntry;
import com.swork.checklist.service.model.ChecklistHandlerEntryTable;
import com.swork.checklist.service.model.impl.ChecklistHandlerEntryImpl;
import com.swork.checklist.service.model.impl.ChecklistHandlerEntryModelImpl;
import com.swork.checklist.service.service.persistence.ChecklistHandlerEntryPersistence;
import com.swork.checklist.service.service.persistence.ChecklistHandlerEntryUtil;
import com.swork.checklist.service.service.persistence.impl.constants.SW_CHECKLISTPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the checklist handler entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {ChecklistHandlerEntryPersistence.class, BasePersistence.class}
)
public class ChecklistHandlerEntryPersistenceImpl
	extends BasePersistenceImpl<ChecklistHandlerEntry>
	implements ChecklistHandlerEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChecklistHandlerEntryUtil</code> to access the checklist handler entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChecklistHandlerEntryImpl.class.getName();

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
	 * Returns all the checklist handler entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the checklist handler entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @return the range of matching checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the checklist handler entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checklist handler entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator,
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

		List<ChecklistHandlerEntry> list = null;

		if (useFinderCache) {
			list = (List<ChecklistHandlerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ChecklistHandlerEntry checklistHandlerEntry : list) {
					if (!uuid.equals(checklistHandlerEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_CHECKLISTHANDLERENTRY_WHERE);

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
				sb.append(ChecklistHandlerEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ChecklistHandlerEntry>)QueryUtil.list(
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
	 * Returns the first checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	@Override
	public ChecklistHandlerEntry findByUuid_First(
			String uuid,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException {

		ChecklistHandlerEntry checklistHandlerEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (checklistHandlerEntry != null) {
			return checklistHandlerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchChecklistHandlerEntryException(sb.toString());
	}

	/**
	 * Returns the first checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	@Override
	public ChecklistHandlerEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		List<ChecklistHandlerEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	@Override
	public ChecklistHandlerEntry findByUuid_Last(
			String uuid,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException {

		ChecklistHandlerEntry checklistHandlerEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (checklistHandlerEntry != null) {
			return checklistHandlerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchChecklistHandlerEntryException(sb.toString());
	}

	/**
	 * Returns the last checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	@Override
	public ChecklistHandlerEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ChecklistHandlerEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the checklist handler entries before and after the current checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param checklistHandlerId the primary key of the current checklist handler entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	@Override
	public ChecklistHandlerEntry[] findByUuid_PrevAndNext(
			long checklistHandlerId, String uuid,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException {

		uuid = Objects.toString(uuid, "");

		ChecklistHandlerEntry checklistHandlerEntry = findByPrimaryKey(
			checklistHandlerId);

		Session session = null;

		try {
			session = openSession();

			ChecklistHandlerEntry[] array = new ChecklistHandlerEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, checklistHandlerEntry, uuid, orderByComparator, true);

			array[1] = checklistHandlerEntry;

			array[2] = getByUuid_PrevAndNext(
				session, checklistHandlerEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChecklistHandlerEntry getByUuid_PrevAndNext(
		Session session, ChecklistHandlerEntry checklistHandlerEntry,
		String uuid, OrderByComparator<ChecklistHandlerEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_CHECKLISTHANDLERENTRY_WHERE);

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
			sb.append(ChecklistHandlerEntryModelImpl.ORDER_BY_JPQL);
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
						checklistHandlerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChecklistHandlerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the checklist handler entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ChecklistHandlerEntry checklistHandlerEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(checklistHandlerEntry);
		}
	}

	/**
	 * Returns the number of checklist handler entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching checklist handler entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHECKLISTHANDLERENTRY_WHERE);

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
		"checklistHandlerEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(checklistHandlerEntry.uuid IS NULL OR checklistHandlerEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the checklist handler entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchChecklistHandlerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	@Override
	public ChecklistHandlerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchChecklistHandlerEntryException {

		ChecklistHandlerEntry checklistHandlerEntry = fetchByUUID_G(
			uuid, groupId);

		if (checklistHandlerEntry == null) {
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

			throw new NoSuchChecklistHandlerEntryException(sb.toString());
		}

		return checklistHandlerEntry;
	}

	/**
	 * Returns the checklist handler entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	@Override
	public ChecklistHandlerEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the checklist handler entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	@Override
	public ChecklistHandlerEntry fetchByUUID_G(
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

		if (result instanceof ChecklistHandlerEntry) {
			ChecklistHandlerEntry checklistHandlerEntry =
				(ChecklistHandlerEntry)result;

			if (!Objects.equals(uuid, checklistHandlerEntry.getUuid()) ||
				(groupId != checklistHandlerEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CHECKLISTHANDLERENTRY_WHERE);

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

				List<ChecklistHandlerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ChecklistHandlerEntry checklistHandlerEntry = list.get(0);

					result = checklistHandlerEntry;

					cacheResult(checklistHandlerEntry);
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
			return (ChecklistHandlerEntry)result;
		}
	}

	/**
	 * Removes the checklist handler entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the checklist handler entry that was removed
	 */
	@Override
	public ChecklistHandlerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchChecklistHandlerEntryException {

		ChecklistHandlerEntry checklistHandlerEntry = findByUUID_G(
			uuid, groupId);

		return remove(checklistHandlerEntry);
	}

	/**
	 * Returns the number of checklist handler entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching checklist handler entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHECKLISTHANDLERENTRY_WHERE);

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
		"checklistHandlerEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(checklistHandlerEntry.uuid IS NULL OR checklistHandlerEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"checklistHandlerEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindBycheckListId;
	private FinderPath _finderPathWithoutPaginationFindBycheckListId;
	private FinderPath _finderPathCountBycheckListId;

	/**
	 * Returns all the checklist handler entries where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @return the matching checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findBycheckListId(Long checkListId) {
		return findBycheckListId(
			checkListId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the checklist handler entries where checkListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param checkListId the check list ID
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @return the range of matching checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findBycheckListId(
		Long checkListId, int start, int end) {

		return findBycheckListId(checkListId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the checklist handler entries where checkListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param checkListId the check list ID
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findBycheckListId(
		Long checkListId, int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		return findBycheckListId(
			checkListId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checklist handler entries where checkListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param checkListId the check list ID
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findBycheckListId(
		Long checkListId, int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycheckListId;
				finderArgs = new Object[] {checkListId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycheckListId;
			finderArgs = new Object[] {
				checkListId, start, end, orderByComparator
			};
		}

		List<ChecklistHandlerEntry> list = null;

		if (useFinderCache) {
			list = (List<ChecklistHandlerEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ChecklistHandlerEntry checklistHandlerEntry : list) {
					if (!Objects.equals(
							checkListId,
							checklistHandlerEntry.getCheckListId())) {

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

			sb.append(_SQL_SELECT_CHECKLISTHANDLERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_CHECKLISTID_CHECKLISTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ChecklistHandlerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(checkListId.longValue());

				list = (List<ChecklistHandlerEntry>)QueryUtil.list(
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
	 * Returns the first checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	@Override
	public ChecklistHandlerEntry findBycheckListId_First(
			Long checkListId,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException {

		ChecklistHandlerEntry checklistHandlerEntry = fetchBycheckListId_First(
			checkListId, orderByComparator);

		if (checklistHandlerEntry != null) {
			return checklistHandlerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("checkListId=");
		sb.append(checkListId);

		sb.append("}");

		throw new NoSuchChecklistHandlerEntryException(sb.toString());
	}

	/**
	 * Returns the first checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	@Override
	public ChecklistHandlerEntry fetchBycheckListId_First(
		Long checkListId,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		List<ChecklistHandlerEntry> list = findBycheckListId(
			checkListId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	@Override
	public ChecklistHandlerEntry findBycheckListId_Last(
			Long checkListId,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException {

		ChecklistHandlerEntry checklistHandlerEntry = fetchBycheckListId_Last(
			checkListId, orderByComparator);

		if (checklistHandlerEntry != null) {
			return checklistHandlerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("checkListId=");
		sb.append(checkListId);

		sb.append("}");

		throw new NoSuchChecklistHandlerEntryException(sb.toString());
	}

	/**
	 * Returns the last checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	@Override
	public ChecklistHandlerEntry fetchBycheckListId_Last(
		Long checkListId,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		int count = countBycheckListId(checkListId);

		if (count == 0) {
			return null;
		}

		List<ChecklistHandlerEntry> list = findBycheckListId(
			checkListId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the checklist handler entries before and after the current checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checklistHandlerId the primary key of the current checklist handler entry
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	@Override
	public ChecklistHandlerEntry[] findBycheckListId_PrevAndNext(
			long checklistHandlerId, Long checkListId,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException {

		ChecklistHandlerEntry checklistHandlerEntry = findByPrimaryKey(
			checklistHandlerId);

		Session session = null;

		try {
			session = openSession();

			ChecklistHandlerEntry[] array = new ChecklistHandlerEntryImpl[3];

			array[0] = getBycheckListId_PrevAndNext(
				session, checklistHandlerEntry, checkListId, orderByComparator,
				true);

			array[1] = checklistHandlerEntry;

			array[2] = getBycheckListId_PrevAndNext(
				session, checklistHandlerEntry, checkListId, orderByComparator,
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

	protected ChecklistHandlerEntry getBycheckListId_PrevAndNext(
		Session session, ChecklistHandlerEntry checklistHandlerEntry,
		Long checkListId,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_CHECKLISTHANDLERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_CHECKLISTID_CHECKLISTID_2);

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
			sb.append(ChecklistHandlerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(checkListId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						checklistHandlerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChecklistHandlerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the checklist handler entries where checkListId = &#63; from the database.
	 *
	 * @param checkListId the check list ID
	 */
	@Override
	public void removeBycheckListId(Long checkListId) {
		for (ChecklistHandlerEntry checklistHandlerEntry :
				findBycheckListId(
					checkListId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(checklistHandlerEntry);
		}
	}

	/**
	 * Returns the number of checklist handler entries where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @return the number of matching checklist handler entries
	 */
	@Override
	public int countBycheckListId(Long checkListId) {
		FinderPath finderPath = _finderPathCountBycheckListId;

		Object[] finderArgs = new Object[] {checkListId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHECKLISTHANDLERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_CHECKLISTID_CHECKLISTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(checkListId.longValue());

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

	private static final String _FINDER_COLUMN_CHECKLISTID_CHECKLISTID_2 =
		"checklistHandlerEntry.checkListId = ?";

	public ChecklistHandlerEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ChecklistHandlerEntry.class);

		setModelImplClass(ChecklistHandlerEntryImpl.class);
		setModelPKClass(long.class);

		setTable(ChecklistHandlerEntryTable.INSTANCE);
	}

	/**
	 * Caches the checklist handler entry in the entity cache if it is enabled.
	 *
	 * @param checklistHandlerEntry the checklist handler entry
	 */
	@Override
	public void cacheResult(ChecklistHandlerEntry checklistHandlerEntry) {
		entityCache.putResult(
			ChecklistHandlerEntryImpl.class,
			checklistHandlerEntry.getPrimaryKey(), checklistHandlerEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				checklistHandlerEntry.getUuid(),
				checklistHandlerEntry.getGroupId()
			},
			checklistHandlerEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the checklist handler entries in the entity cache if it is enabled.
	 *
	 * @param checklistHandlerEntries the checklist handler entries
	 */
	@Override
	public void cacheResult(
		List<ChecklistHandlerEntry> checklistHandlerEntries) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (checklistHandlerEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ChecklistHandlerEntry checklistHandlerEntry :
				checklistHandlerEntries) {

			if (entityCache.getResult(
					ChecklistHandlerEntryImpl.class,
					checklistHandlerEntry.getPrimaryKey()) == null) {

				cacheResult(checklistHandlerEntry);
			}
		}
	}

	/**
	 * Clears the cache for all checklist handler entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChecklistHandlerEntryImpl.class);

		finderCache.clearCache(ChecklistHandlerEntryImpl.class);
	}

	/**
	 * Clears the cache for the checklist handler entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChecklistHandlerEntry checklistHandlerEntry) {
		entityCache.removeResult(
			ChecklistHandlerEntryImpl.class, checklistHandlerEntry);
	}

	@Override
	public void clearCache(
		List<ChecklistHandlerEntry> checklistHandlerEntries) {

		for (ChecklistHandlerEntry checklistHandlerEntry :
				checklistHandlerEntries) {

			entityCache.removeResult(
				ChecklistHandlerEntryImpl.class, checklistHandlerEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ChecklistHandlerEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ChecklistHandlerEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ChecklistHandlerEntryModelImpl checklistHandlerEntryModelImpl) {

		Object[] args = new Object[] {
			checklistHandlerEntryModelImpl.getUuid(),
			checklistHandlerEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, checklistHandlerEntryModelImpl);
	}

	/**
	 * Creates a new checklist handler entry with the primary key. Does not add the checklist handler entry to the database.
	 *
	 * @param checklistHandlerId the primary key for the new checklist handler entry
	 * @return the new checklist handler entry
	 */
	@Override
	public ChecklistHandlerEntry create(long checklistHandlerId) {
		ChecklistHandlerEntry checklistHandlerEntry =
			new ChecklistHandlerEntryImpl();

		checklistHandlerEntry.setNew(true);
		checklistHandlerEntry.setPrimaryKey(checklistHandlerId);

		String uuid = PortalUUIDUtil.generate();

		checklistHandlerEntry.setUuid(uuid);

		return checklistHandlerEntry;
	}

	/**
	 * Removes the checklist handler entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry that was removed
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	@Override
	public ChecklistHandlerEntry remove(long checklistHandlerId)
		throws NoSuchChecklistHandlerEntryException {

		return remove((Serializable)checklistHandlerId);
	}

	/**
	 * Removes the checklist handler entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the checklist handler entry
	 * @return the checklist handler entry that was removed
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	@Override
	public ChecklistHandlerEntry remove(Serializable primaryKey)
		throws NoSuchChecklistHandlerEntryException {

		Session session = null;

		try {
			session = openSession();

			ChecklistHandlerEntry checklistHandlerEntry =
				(ChecklistHandlerEntry)session.get(
					ChecklistHandlerEntryImpl.class, primaryKey);

			if (checklistHandlerEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChecklistHandlerEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(checklistHandlerEntry);
		}
		catch (NoSuchChecklistHandlerEntryException noSuchEntityException) {
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
	protected ChecklistHandlerEntry removeImpl(
		ChecklistHandlerEntry checklistHandlerEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(checklistHandlerEntry)) {
				checklistHandlerEntry = (ChecklistHandlerEntry)session.get(
					ChecklistHandlerEntryImpl.class,
					checklistHandlerEntry.getPrimaryKeyObj());
			}

			if (checklistHandlerEntry != null) {
				session.delete(checklistHandlerEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (checklistHandlerEntry != null) {
			clearCache(checklistHandlerEntry);
		}

		return checklistHandlerEntry;
	}

	@Override
	public ChecklistHandlerEntry updateImpl(
		ChecklistHandlerEntry checklistHandlerEntry) {

		boolean isNew = checklistHandlerEntry.isNew();

		if (!(checklistHandlerEntry instanceof
				ChecklistHandlerEntryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(checklistHandlerEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					checklistHandlerEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in checklistHandlerEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ChecklistHandlerEntry implementation " +
					checklistHandlerEntry.getClass());
		}

		ChecklistHandlerEntryModelImpl checklistHandlerEntryModelImpl =
			(ChecklistHandlerEntryModelImpl)checklistHandlerEntry;

		if (Validator.isNull(checklistHandlerEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			checklistHandlerEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(checklistHandlerEntry);
			}
			else {
				checklistHandlerEntry = (ChecklistHandlerEntry)session.merge(
					checklistHandlerEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ChecklistHandlerEntryImpl.class, checklistHandlerEntryModelImpl,
			false, true);

		cacheUniqueFindersCache(checklistHandlerEntryModelImpl);

		if (isNew) {
			checklistHandlerEntry.setNew(false);
		}

		checklistHandlerEntry.resetOriginalValues();

		return checklistHandlerEntry;
	}

	/**
	 * Returns the checklist handler entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the checklist handler entry
	 * @return the checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	@Override
	public ChecklistHandlerEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChecklistHandlerEntryException {

		ChecklistHandlerEntry checklistHandlerEntry = fetchByPrimaryKey(
			primaryKey);

		if (checklistHandlerEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChecklistHandlerEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return checklistHandlerEntry;
	}

	/**
	 * Returns the checklist handler entry with the primary key or throws a <code>NoSuchChecklistHandlerEntryException</code> if it could not be found.
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	@Override
	public ChecklistHandlerEntry findByPrimaryKey(long checklistHandlerId)
		throws NoSuchChecklistHandlerEntryException {

		return findByPrimaryKey((Serializable)checklistHandlerId);
	}

	/**
	 * Returns the checklist handler entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry, or <code>null</code> if a checklist handler entry with the primary key could not be found
	 */
	@Override
	public ChecklistHandlerEntry fetchByPrimaryKey(long checklistHandlerId) {
		return fetchByPrimaryKey((Serializable)checklistHandlerId);
	}

	/**
	 * Returns all the checklist handler entries.
	 *
	 * @return the checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the checklist handler entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @return the range of checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the checklist handler entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findAll(
		int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the checklist handler entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of checklist handler entries
	 */
	@Override
	public List<ChecklistHandlerEntry> findAll(
		int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator,
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

		List<ChecklistHandlerEntry> list = null;

		if (useFinderCache) {
			list = (List<ChecklistHandlerEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHECKLISTHANDLERENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHECKLISTHANDLERENTRY;

				sql = sql.concat(ChecklistHandlerEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ChecklistHandlerEntry>)QueryUtil.list(
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
	 * Removes all the checklist handler entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ChecklistHandlerEntry checklistHandlerEntry : findAll()) {
			remove(checklistHandlerEntry);
		}
	}

	/**
	 * Returns the number of checklist handler entries.
	 *
	 * @return the number of checklist handler entries
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
					_SQL_COUNT_CHECKLISTHANDLERENTRY);

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
		return "checklistHandlerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CHECKLISTHANDLERENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChecklistHandlerEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the checklist handler entry persistence.
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

		_finderPathWithPaginationFindBycheckListId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycheckListId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"checkListId"}, true);

		_finderPathWithoutPaginationFindBycheckListId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycheckListId",
			new String[] {Long.class.getName()}, new String[] {"checkListId"},
			true);

		_finderPathCountBycheckListId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycheckListId",
			new String[] {Long.class.getName()}, new String[] {"checkListId"},
			false);

		_setChecklistHandlerEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setChecklistHandlerEntryUtilPersistence(null);

		entityCache.removeCache(ChecklistHandlerEntryImpl.class.getName());
	}

	private void _setChecklistHandlerEntryUtilPersistence(
		ChecklistHandlerEntryPersistence checklistHandlerEntryPersistence) {

		try {
			Field field = ChecklistHandlerEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, checklistHandlerEntryPersistence);
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

	private static final String _SQL_SELECT_CHECKLISTHANDLERENTRY =
		"SELECT checklistHandlerEntry FROM ChecklistHandlerEntry checklistHandlerEntry";

	private static final String _SQL_SELECT_CHECKLISTHANDLERENTRY_WHERE =
		"SELECT checklistHandlerEntry FROM ChecklistHandlerEntry checklistHandlerEntry WHERE ";

	private static final String _SQL_COUNT_CHECKLISTHANDLERENTRY =
		"SELECT COUNT(checklistHandlerEntry) FROM ChecklistHandlerEntry checklistHandlerEntry";

	private static final String _SQL_COUNT_CHECKLISTHANDLERENTRY_WHERE =
		"SELECT COUNT(checklistHandlerEntry) FROM ChecklistHandlerEntry checklistHandlerEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"checklistHandlerEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ChecklistHandlerEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ChecklistHandlerEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ChecklistHandlerEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ChecklistHandlerEntryModelArgumentsResolver
		_checklistHandlerEntryModelArgumentsResolver;

}