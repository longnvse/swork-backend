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

package com.swork.core.resource.service.service.persistence.impl;

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

import com.swork.core.resource.service.exception.NoSuchTeamEntryException;
import com.swork.core.resource.service.model.TeamEntry;
import com.swork.core.resource.service.model.TeamEntryTable;
import com.swork.core.resource.service.model.impl.TeamEntryImpl;
import com.swork.core.resource.service.model.impl.TeamEntryModelImpl;
import com.swork.core.resource.service.service.persistence.TeamEntryPersistence;
import com.swork.core.resource.service.service.persistence.TeamEntryUtil;
import com.swork.core.resource.service.service.persistence.impl.constants.SW_RESOURCEPersistenceConstants;

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
 * The persistence implementation for the team entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {TeamEntryPersistence.class, BasePersistence.class})
public class TeamEntryPersistenceImpl
	extends BasePersistenceImpl<TeamEntry> implements TeamEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TeamEntryUtil</code> to access the team entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TeamEntryImpl.class.getName();

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
	 * Returns all the team entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching team entries
	 */
	@Override
	public List<TeamEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the team entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator,
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

		List<TeamEntry> list = null;

		if (useFinderCache) {
			list = (List<TeamEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TeamEntry teamEntry : list) {
					if (!uuid.equals(teamEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

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
				sb.append(TeamEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TeamEntry>)QueryUtil.list(
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
	 * Returns the first team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByUuid_First(
			String uuid, OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByUuid_First(uuid, orderByComparator);

		if (teamEntry != null) {
			return teamEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTeamEntryException(sb.toString());
	}

	/**
	 * Returns the first team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByUuid_First(
		String uuid, OrderByComparator<TeamEntry> orderByComparator) {

		List<TeamEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByUuid_Last(
			String uuid, OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (teamEntry != null) {
			return teamEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTeamEntryException(sb.toString());
	}

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByUuid_Last(
		String uuid, OrderByComparator<TeamEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TeamEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the team entries before and after the current team entry in the ordered set where uuid = &#63;.
	 *
	 * @param teamId the primary key of the current team entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	@Override
	public TeamEntry[] findByUuid_PrevAndNext(
			long teamId, String uuid,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		uuid = Objects.toString(uuid, "");

		TeamEntry teamEntry = findByPrimaryKey(teamId);

		Session session = null;

		try {
			session = openSession();

			TeamEntry[] array = new TeamEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, teamEntry, uuid, orderByComparator, true);

			array[1] = teamEntry;

			array[2] = getByUuid_PrevAndNext(
				session, teamEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TeamEntry getByUuid_PrevAndNext(
		Session session, TeamEntry teamEntry, String uuid,
		OrderByComparator<TeamEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

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
			sb.append(TeamEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(teamEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TeamEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TeamEntry teamEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(teamEntry);
		}
	}

	/**
	 * Returns the number of team entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching team entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TEAMENTRY_WHERE);

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
		"teamEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(teamEntry.uuid IS NULL OR teamEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the team entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByUUID_G(uuid, groupId);

		if (teamEntry == null) {
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

			throw new NoSuchTeamEntryException(sb.toString());
		}

		return teamEntry;
	}

	/**
	 * Returns the team entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the team entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByUUID_G(
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

		if (result instanceof TeamEntry) {
			TeamEntry teamEntry = (TeamEntry)result;

			if (!Objects.equals(uuid, teamEntry.getUuid()) ||
				(groupId != teamEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

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

				List<TeamEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TeamEntry teamEntry = list.get(0);

					result = teamEntry;

					cacheResult(teamEntry);
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
			return (TeamEntry)result;
		}
	}

	/**
	 * Removes the team entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the team entry that was removed
	 */
	@Override
	public TeamEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = findByUUID_G(uuid, groupId);

		return remove(teamEntry);
	}

	/**
	 * Returns the number of team entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching team entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEAMENTRY_WHERE);

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
		"teamEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(teamEntry.uuid IS NULL OR teamEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"teamEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching team entries
	 */
	@Override
	public List<TeamEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator,
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

		List<TeamEntry> list = null;

		if (useFinderCache) {
			list = (List<TeamEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TeamEntry teamEntry : list) {
					if (!uuid.equals(teamEntry.getUuid()) ||
						(companyId != teamEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

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
				sb.append(TeamEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TeamEntry>)QueryUtil.list(
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
	 * Returns the first team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (teamEntry != null) {
			return teamEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTeamEntryException(sb.toString());
	}

	/**
	 * Returns the first team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TeamEntry> orderByComparator) {

		List<TeamEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (teamEntry != null) {
			return teamEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTeamEntryException(sb.toString());
	}

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TeamEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TeamEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the team entries before and after the current team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param teamId the primary key of the current team entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	@Override
	public TeamEntry[] findByUuid_C_PrevAndNext(
			long teamId, String uuid, long companyId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		uuid = Objects.toString(uuid, "");

		TeamEntry teamEntry = findByPrimaryKey(teamId);

		Session session = null;

		try {
			session = openSession();

			TeamEntry[] array = new TeamEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, teamEntry, uuid, companyId, orderByComparator, true);

			array[1] = teamEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, teamEntry, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TeamEntry getByUuid_C_PrevAndNext(
		Session session, TeamEntry teamEntry, String uuid, long companyId,
		OrderByComparator<TeamEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

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
			sb.append(TeamEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(teamEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TeamEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TeamEntry teamEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(teamEntry);
		}
	}

	/**
	 * Returns the number of team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching team entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEAMENTRY_WHERE);

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
		"teamEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(teamEntry.uuid IS NULL OR teamEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"teamEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByB_C;
	private FinderPath _finderPathWithoutPaginationFindByB_C;
	private FinderPath _finderPathCountByB_C;

	/**
	 * Returns all the team entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_C(long businessId, String name) {
		return findByB_C(
			businessId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team entries where businessId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_C(
		long businessId, String name, int start, int end) {

		return findByB_C(businessId, name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_C(
		long businessId, String name, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return findByB_C(businessId, name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_C(
		long businessId, String name, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_C;
				finderArgs = new Object[] {businessId, name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_C;
			finderArgs = new Object[] {
				businessId, name, start, end, orderByComparator
			};
		}

		List<TeamEntry> list = null;

		if (useFinderCache) {
			list = (List<TeamEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TeamEntry teamEntry : list) {
					if ((businessId != teamEntry.getBusinessId()) ||
						!name.equals(teamEntry.getName())) {

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

			sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_C_BUSINESSID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_C_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_C_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TeamEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<TeamEntry>)QueryUtil.list(
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
	 * Returns the first team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByB_C_First(
			long businessId, String name,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByB_C_First(
			businessId, name, orderByComparator);

		if (teamEntry != null) {
			return teamEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchTeamEntryException(sb.toString());
	}

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByB_C_First(
		long businessId, String name,
		OrderByComparator<TeamEntry> orderByComparator) {

		List<TeamEntry> list = findByB_C(
			businessId, name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByB_C_Last(
			long businessId, String name,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByB_C_Last(
			businessId, name, orderByComparator);

		if (teamEntry != null) {
			return teamEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchTeamEntryException(sb.toString());
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByB_C_Last(
		long businessId, String name,
		OrderByComparator<TeamEntry> orderByComparator) {

		int count = countByB_C(businessId, name);

		if (count == 0) {
			return null;
		}

		List<TeamEntry> list = findByB_C(
			businessId, name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the team entries before and after the current team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param teamId the primary key of the current team entry
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	@Override
	public TeamEntry[] findByB_C_PrevAndNext(
			long teamId, long businessId, String name,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		name = Objects.toString(name, "");

		TeamEntry teamEntry = findByPrimaryKey(teamId);

		Session session = null;

		try {
			session = openSession();

			TeamEntry[] array = new TeamEntryImpl[3];

			array[0] = getByB_C_PrevAndNext(
				session, teamEntry, businessId, name, orderByComparator, true);

			array[1] = teamEntry;

			array[2] = getByB_C_PrevAndNext(
				session, teamEntry, businessId, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TeamEntry getByB_C_PrevAndNext(
		Session session, TeamEntry teamEntry, long businessId, String name,
		OrderByComparator<TeamEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

		sb.append(_FINDER_COLUMN_B_C_BUSINESSID_2);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_B_C_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_B_C_NAME_2);
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
			sb.append(TeamEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessId);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(teamEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TeamEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team entries where businessId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 */
	@Override
	public void removeByB_C(long businessId, String name) {
		for (TeamEntry teamEntry :
				findByB_C(
					businessId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(teamEntry);
		}
	}

	/**
	 * Returns the number of team entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the number of matching team entries
	 */
	@Override
	public int countByB_C(long businessId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByB_C;

		Object[] finderArgs = new Object[] {businessId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEAMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_C_BUSINESSID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_C_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_C_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

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

	private static final String _FINDER_COLUMN_B_C_BUSINESSID_2 =
		"teamEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_C_NAME_2 =
		"teamEntry.name = ?";

	private static final String _FINDER_COLUMN_B_C_NAME_3 =
		"(teamEntry.name IS NULL OR teamEntry.name = '')";

	private FinderPath _finderPathFetchByB_N_P;
	private FinderPath _finderPathCountByB_N_P;

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and projectId = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByB_N_P(long businessId, String name, Long projectId)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByB_N_P(businessId, name, projectId);

		if (teamEntry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("businessId=");
			sb.append(businessId);

			sb.append(", name=");
			sb.append(name);

			sb.append(", projectId=");
			sb.append(projectId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTeamEntryException(sb.toString());
		}

		return teamEntry;
	}

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByB_N_P(
		long businessId, String name, Long projectId) {

		return fetchByB_N_P(businessId, name, projectId, true);
	}

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByB_N_P(
		long businessId, String name, Long projectId, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {businessId, name, projectId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByB_N_P, finderArgs);
		}

		if (result instanceof TeamEntry) {
			TeamEntry teamEntry = (TeamEntry)result;

			if ((businessId != teamEntry.getBusinessId()) ||
				!Objects.equals(name, teamEntry.getName()) ||
				!Objects.equals(projectId, teamEntry.getProjectId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_N_P_BUSINESSID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_N_P_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_N_P_NAME_2);
			}

			sb.append(_FINDER_COLUMN_B_N_P_PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(projectId.longValue());

				List<TeamEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByB_N_P, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									businessId, name, projectId
								};
							}

							_log.warn(
								"TeamEntryPersistenceImpl.fetchByB_N_P(long, String, Long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TeamEntry teamEntry = list.get(0);

					result = teamEntry;

					cacheResult(teamEntry);
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
			return (TeamEntry)result;
		}
	}

	/**
	 * Removes the team entry where businessId = &#63; and name = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the team entry that was removed
	 */
	@Override
	public TeamEntry removeByB_N_P(long businessId, String name, Long projectId)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = findByB_N_P(businessId, name, projectId);

		return remove(teamEntry);
	}

	/**
	 * Returns the number of team entries where businessId = &#63; and name = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the number of matching team entries
	 */
	@Override
	public int countByB_N_P(long businessId, String name, Long projectId) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByB_N_P;

		Object[] finderArgs = new Object[] {businessId, name, projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TEAMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_N_P_BUSINESSID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_N_P_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_N_P_NAME_2);
			}

			sb.append(_FINDER_COLUMN_B_N_P_PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				if (bindName) {
					queryPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_B_N_P_BUSINESSID_2 =
		"teamEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_N_P_NAME_2 =
		"teamEntry.name = ? AND ";

	private static final String _FINDER_COLUMN_B_N_P_NAME_3 =
		"(teamEntry.name IS NULL OR teamEntry.name = '') AND ";

	private static final String _FINDER_COLUMN_B_N_P_PROJECTID_2 =
		"teamEntry.projectId = ?";

	private FinderPath _finderPathFetchByB_N_PH;
	private FinderPath _finderPathCountByB_N_PH;

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByB_N_PH(long businessId, String name, Long phaseId)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByB_N_PH(businessId, name, phaseId);

		if (teamEntry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("businessId=");
			sb.append(businessId);

			sb.append(", name=");
			sb.append(name);

			sb.append(", phaseId=");
			sb.append(phaseId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTeamEntryException(sb.toString());
		}

		return teamEntry;
	}

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByB_N_PH(long businessId, String name, Long phaseId) {
		return fetchByB_N_PH(businessId, name, phaseId, true);
	}

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByB_N_PH(
		long businessId, String name, Long phaseId, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {businessId, name, phaseId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByB_N_PH, finderArgs);
		}

		if (result instanceof TeamEntry) {
			TeamEntry teamEntry = (TeamEntry)result;

			if ((businessId != teamEntry.getBusinessId()) ||
				!Objects.equals(name, teamEntry.getName()) ||
				!Objects.equals(phaseId, teamEntry.getPhaseId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_N_PH_BUSINESSID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_N_PH_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_N_PH_NAME_2);
			}

			sb.append(_FINDER_COLUMN_B_N_PH_PHASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(phaseId.longValue());

				List<TeamEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByB_N_PH, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									businessId, name, phaseId
								};
							}

							_log.warn(
								"TeamEntryPersistenceImpl.fetchByB_N_PH(long, String, Long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TeamEntry teamEntry = list.get(0);

					result = teamEntry;

					cacheResult(teamEntry);
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
			return (TeamEntry)result;
		}
	}

	/**
	 * Removes the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the team entry that was removed
	 */
	@Override
	public TeamEntry removeByB_N_PH(long businessId, String name, Long phaseId)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = findByB_N_PH(businessId, name, phaseId);

		return remove(teamEntry);
	}

	/**
	 * Returns the number of team entries where businessId = &#63; and name = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the number of matching team entries
	 */
	@Override
	public int countByB_N_PH(long businessId, String name, Long phaseId) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByB_N_PH;

		Object[] finderArgs = new Object[] {businessId, name, phaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TEAMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_N_PH_BUSINESSID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_N_PH_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_N_PH_NAME_2);
			}

			sb.append(_FINDER_COLUMN_B_N_PH_PHASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				if (bindName) {
					queryPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_B_N_PH_BUSINESSID_2 =
		"teamEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_N_PH_NAME_2 =
		"teamEntry.name = ? AND ";

	private static final String _FINDER_COLUMN_B_N_PH_NAME_3 =
		"(teamEntry.name IS NULL OR teamEntry.name = '') AND ";

	private static final String _FINDER_COLUMN_B_N_PH_PHASEID_2 =
		"teamEntry.phaseId = ?";

	private FinderPath _finderPathWithPaginationFindByB_PH;
	private FinderPath _finderPathWithoutPaginationFindByB_PH;
	private FinderPath _finderPathCountByB_PH;

	/**
	 * Returns all the team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_PH(long businessId, Long phaseId) {
		return findByB_PH(
			businessId, phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end) {

		return findByB_PH(businessId, phaseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return findByB_PH(
			businessId, phaseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator,
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

		List<TeamEntry> list = null;

		if (useFinderCache) {
			list = (List<TeamEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TeamEntry teamEntry : list) {
					if ((businessId != teamEntry.getBusinessId()) ||
						!Objects.equals(phaseId, teamEntry.getPhaseId())) {

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

			sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_PH_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PH_PHASEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TeamEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(phaseId.longValue());

				list = (List<TeamEntry>)QueryUtil.list(
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
	 * Returns the first team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByB_PH_First(
			long businessId, Long phaseId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByB_PH_First(
			businessId, phaseId, orderByComparator);

		if (teamEntry != null) {
			return teamEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchTeamEntryException(sb.toString());
	}

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByB_PH_First(
		long businessId, Long phaseId,
		OrderByComparator<TeamEntry> orderByComparator) {

		List<TeamEntry> list = findByB_PH(
			businessId, phaseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByB_PH_Last(
			long businessId, Long phaseId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByB_PH_Last(
			businessId, phaseId, orderByComparator);

		if (teamEntry != null) {
			return teamEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchTeamEntryException(sb.toString());
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByB_PH_Last(
		long businessId, Long phaseId,
		OrderByComparator<TeamEntry> orderByComparator) {

		int count = countByB_PH(businessId, phaseId);

		if (count == 0) {
			return null;
		}

		List<TeamEntry> list = findByB_PH(
			businessId, phaseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the team entries before and after the current team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param teamId the primary key of the current team entry
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	@Override
	public TeamEntry[] findByB_PH_PrevAndNext(
			long teamId, long businessId, Long phaseId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = findByPrimaryKey(teamId);

		Session session = null;

		try {
			session = openSession();

			TeamEntry[] array = new TeamEntryImpl[3];

			array[0] = getByB_PH_PrevAndNext(
				session, teamEntry, businessId, phaseId, orderByComparator,
				true);

			array[1] = teamEntry;

			array[2] = getByB_PH_PrevAndNext(
				session, teamEntry, businessId, phaseId, orderByComparator,
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

	protected TeamEntry getByB_PH_PrevAndNext(
		Session session, TeamEntry teamEntry, long businessId, Long phaseId,
		OrderByComparator<TeamEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

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
			sb.append(TeamEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(teamEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TeamEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team entries where businessId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 */
	@Override
	public void removeByB_PH(long businessId, Long phaseId) {
		for (TeamEntry teamEntry :
				findByB_PH(
					businessId, phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(teamEntry);
		}
	}

	/**
	 * Returns the number of team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the number of matching team entries
	 */
	@Override
	public int countByB_PH(long businessId, Long phaseId) {
		FinderPath finderPath = _finderPathCountByB_PH;

		Object[] finderArgs = new Object[] {businessId, phaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEAMENTRY_WHERE);

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
		"teamEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_PH_PHASEID_2 =
		"teamEntry.phaseId = ?";

	private FinderPath _finderPathWithPaginationFindByB_P;
	private FinderPath _finderPathWithoutPaginationFindByB_P;
	private FinderPath _finderPathCountByB_P;

	/**
	 * Returns all the team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_P(long businessId, Long projectId) {
		return findByB_P(
			businessId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_P(
		long businessId, Long projectId, int start, int end) {

		return findByB_P(businessId, projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return findByB_P(
			businessId, projectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team entries
	 */
	@Override
	public List<TeamEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator,
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

		List<TeamEntry> list = null;

		if (useFinderCache) {
			list = (List<TeamEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TeamEntry teamEntry : list) {
					if ((businessId != teamEntry.getBusinessId()) ||
						!Objects.equals(projectId, teamEntry.getProjectId())) {

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

			sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_P_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_P_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TeamEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(projectId.longValue());

				list = (List<TeamEntry>)QueryUtil.list(
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
	 * Returns the first team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByB_P_First(
			long businessId, Long projectId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByB_P_First(
			businessId, projectId, orderByComparator);

		if (teamEntry != null) {
			return teamEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchTeamEntryException(sb.toString());
	}

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByB_P_First(
		long businessId, Long projectId,
		OrderByComparator<TeamEntry> orderByComparator) {

		List<TeamEntry> list = findByB_P(
			businessId, projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByB_P_Last(
			long businessId, Long projectId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByB_P_Last(
			businessId, projectId, orderByComparator);

		if (teamEntry != null) {
			return teamEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchTeamEntryException(sb.toString());
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByB_P_Last(
		long businessId, Long projectId,
		OrderByComparator<TeamEntry> orderByComparator) {

		int count = countByB_P(businessId, projectId);

		if (count == 0) {
			return null;
		}

		List<TeamEntry> list = findByB_P(
			businessId, projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the team entries before and after the current team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the primary key of the current team entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	@Override
	public TeamEntry[] findByB_P_PrevAndNext(
			long teamId, long businessId, Long projectId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = findByPrimaryKey(teamId);

		Session session = null;

		try {
			session = openSession();

			TeamEntry[] array = new TeamEntryImpl[3];

			array[0] = getByB_P_PrevAndNext(
				session, teamEntry, businessId, projectId, orderByComparator,
				true);

			array[1] = teamEntry;

			array[2] = getByB_P_PrevAndNext(
				session, teamEntry, businessId, projectId, orderByComparator,
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

	protected TeamEntry getByB_P_PrevAndNext(
		Session session, TeamEntry teamEntry, long businessId, Long projectId,
		OrderByComparator<TeamEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

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
			sb.append(TeamEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(teamEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TeamEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	@Override
	public void removeByB_P(long businessId, Long projectId) {
		for (TeamEntry teamEntry :
				findByB_P(
					businessId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(teamEntry);
		}
	}

	/**
	 * Returns the number of team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching team entries
	 */
	@Override
	public int countByB_P(long businessId, Long projectId) {
		FinderPath finderPath = _finderPathCountByB_P;

		Object[] finderArgs = new Object[] {businessId, projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEAMENTRY_WHERE);

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
		"teamEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_P_PROJECTID_2 =
		"teamEntry.projectId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the team entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	@Override
	public TeamEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByC_ERC(companyId, externalReferenceCode);

		if (teamEntry == null) {
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

			throw new NoSuchTeamEntryException(sb.toString());
		}

		return teamEntry;
	}

	/**
	 * Returns the team entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the team entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	@Override
	public TeamEntry fetchByC_ERC(
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

		if (result instanceof TeamEntry) {
			TeamEntry teamEntry = (TeamEntry)result;

			if ((companyId != teamEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					teamEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TEAMENTRY_WHERE);

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

				List<TeamEntry> list = query.list();

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
								"TeamEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TeamEntry teamEntry = list.get(0);

					result = teamEntry;

					cacheResult(teamEntry);
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
			return (TeamEntry)result;
		}
	}

	/**
	 * Removes the team entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the team entry that was removed
	 */
	@Override
	public TeamEntry removeByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = findByC_ERC(companyId, externalReferenceCode);

		return remove(teamEntry);
	}

	/**
	 * Returns the number of team entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching team entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEAMENTRY_WHERE);

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
		"teamEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"teamEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(teamEntry.externalReferenceCode IS NULL OR teamEntry.externalReferenceCode = '')";

	public TeamEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TeamEntry.class);

		setModelImplClass(TeamEntryImpl.class);
		setModelPKClass(long.class);

		setTable(TeamEntryTable.INSTANCE);
	}

	/**
	 * Caches the team entry in the entity cache if it is enabled.
	 *
	 * @param teamEntry the team entry
	 */
	@Override
	public void cacheResult(TeamEntry teamEntry) {
		entityCache.putResult(
			TeamEntryImpl.class, teamEntry.getPrimaryKey(), teamEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {teamEntry.getUuid(), teamEntry.getGroupId()},
			teamEntry);

		finderCache.putResult(
			_finderPathFetchByB_N_P,
			new Object[] {
				teamEntry.getBusinessId(), teamEntry.getName(),
				teamEntry.getProjectId()
			},
			teamEntry);

		finderCache.putResult(
			_finderPathFetchByB_N_PH,
			new Object[] {
				teamEntry.getBusinessId(), teamEntry.getName(),
				teamEntry.getPhaseId()
			},
			teamEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				teamEntry.getCompanyId(), teamEntry.getExternalReferenceCode()
			},
			teamEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the team entries in the entity cache if it is enabled.
	 *
	 * @param teamEntries the team entries
	 */
	@Override
	public void cacheResult(List<TeamEntry> teamEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (teamEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TeamEntry teamEntry : teamEntries) {
			if (entityCache.getResult(
					TeamEntryImpl.class, teamEntry.getPrimaryKey()) == null) {

				cacheResult(teamEntry);
			}
		}
	}

	/**
	 * Clears the cache for all team entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TeamEntryImpl.class);

		finderCache.clearCache(TeamEntryImpl.class);
	}

	/**
	 * Clears the cache for the team entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TeamEntry teamEntry) {
		entityCache.removeResult(TeamEntryImpl.class, teamEntry);
	}

	@Override
	public void clearCache(List<TeamEntry> teamEntries) {
		for (TeamEntry teamEntry : teamEntries) {
			entityCache.removeResult(TeamEntryImpl.class, teamEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TeamEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TeamEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TeamEntryModelImpl teamEntryModelImpl) {

		Object[] args = new Object[] {
			teamEntryModelImpl.getUuid(), teamEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, teamEntryModelImpl);

		args = new Object[] {
			teamEntryModelImpl.getBusinessId(), teamEntryModelImpl.getName(),
			teamEntryModelImpl.getProjectId()
		};

		finderCache.putResult(_finderPathCountByB_N_P, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByB_N_P, args, teamEntryModelImpl);

		args = new Object[] {
			teamEntryModelImpl.getBusinessId(), teamEntryModelImpl.getName(),
			teamEntryModelImpl.getPhaseId()
		};

		finderCache.putResult(_finderPathCountByB_N_PH, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByB_N_PH, args, teamEntryModelImpl);

		args = new Object[] {
			teamEntryModelImpl.getCompanyId(),
			teamEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, teamEntryModelImpl);
	}

	/**
	 * Creates a new team entry with the primary key. Does not add the team entry to the database.
	 *
	 * @param teamId the primary key for the new team entry
	 * @return the new team entry
	 */
	@Override
	public TeamEntry create(long teamId) {
		TeamEntry teamEntry = new TeamEntryImpl();

		teamEntry.setNew(true);
		teamEntry.setPrimaryKey(teamId);

		String uuid = PortalUUIDUtil.generate();

		teamEntry.setUuid(uuid);

		teamEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return teamEntry;
	}

	/**
	 * Removes the team entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry that was removed
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	@Override
	public TeamEntry remove(long teamId) throws NoSuchTeamEntryException {
		return remove((Serializable)teamId);
	}

	/**
	 * Removes the team entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the team entry
	 * @return the team entry that was removed
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	@Override
	public TeamEntry remove(Serializable primaryKey)
		throws NoSuchTeamEntryException {

		Session session = null;

		try {
			session = openSession();

			TeamEntry teamEntry = (TeamEntry)session.get(
				TeamEntryImpl.class, primaryKey);

			if (teamEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTeamEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(teamEntry);
		}
		catch (NoSuchTeamEntryException noSuchEntityException) {
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
	protected TeamEntry removeImpl(TeamEntry teamEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(teamEntry)) {
				teamEntry = (TeamEntry)session.get(
					TeamEntryImpl.class, teamEntry.getPrimaryKeyObj());
			}

			if (teamEntry != null) {
				session.delete(teamEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (teamEntry != null) {
			clearCache(teamEntry);
		}

		return teamEntry;
	}

	@Override
	public TeamEntry updateImpl(TeamEntry teamEntry) {
		boolean isNew = teamEntry.isNew();

		if (!(teamEntry instanceof TeamEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(teamEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(teamEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in teamEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TeamEntry implementation " +
					teamEntry.getClass());
		}

		TeamEntryModelImpl teamEntryModelImpl = (TeamEntryModelImpl)teamEntry;

		if (Validator.isNull(teamEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			teamEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (teamEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				teamEntry.setCreateDate(date);
			}
			else {
				teamEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!teamEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				teamEntry.setModifiedDate(date);
			}
			else {
				teamEntry.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(teamEntry);
			}
			else {
				teamEntry = (TeamEntry)session.merge(teamEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TeamEntryImpl.class, teamEntryModelImpl, false, true);

		cacheUniqueFindersCache(teamEntryModelImpl);

		if (isNew) {
			teamEntry.setNew(false);
		}

		teamEntry.resetOriginalValues();

		return teamEntry;
	}

	/**
	 * Returns the team entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the team entry
	 * @return the team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	@Override
	public TeamEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTeamEntryException {

		TeamEntry teamEntry = fetchByPrimaryKey(primaryKey);

		if (teamEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTeamEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return teamEntry;
	}

	/**
	 * Returns the team entry with the primary key or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	@Override
	public TeamEntry findByPrimaryKey(long teamId)
		throws NoSuchTeamEntryException {

		return findByPrimaryKey((Serializable)teamId);
	}

	/**
	 * Returns the team entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry, or <code>null</code> if a team entry with the primary key could not be found
	 */
	@Override
	public TeamEntry fetchByPrimaryKey(long teamId) {
		return fetchByPrimaryKey((Serializable)teamId);
	}

	/**
	 * Returns all the team entries.
	 *
	 * @return the team entries
	 */
	@Override
	public List<TeamEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of team entries
	 */
	@Override
	public List<TeamEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the team entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of team entries
	 */
	@Override
	public List<TeamEntry> findAll(
		int start, int end, OrderByComparator<TeamEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of team entries
	 */
	@Override
	public List<TeamEntry> findAll(
		int start, int end, OrderByComparator<TeamEntry> orderByComparator,
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

		List<TeamEntry> list = null;

		if (useFinderCache) {
			list = (List<TeamEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TEAMENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TEAMENTRY;

				sql = sql.concat(TeamEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TeamEntry>)QueryUtil.list(
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
	 * Removes all the team entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TeamEntry teamEntry : findAll()) {
			remove(teamEntry);
		}
	}

	/**
	 * Returns the number of team entries.
	 *
	 * @return the number of team entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TEAMENTRY);

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
		return "teamId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TEAMENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TeamEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the team entry persistence.
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

		_finderPathWithPaginationFindByB_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_C",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "name"}, true);

		_finderPathWithoutPaginationFindByB_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_C",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"businessId", "name"}, true);

		_finderPathCountByB_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_C",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"businessId", "name"}, false);

		_finderPathFetchByB_N_P = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByB_N_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"businessId", "name", "projectId"}, true);

		_finderPathCountByB_N_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_N_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"businessId", "name", "projectId"}, false);

		_finderPathFetchByB_N_PH = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByB_N_PH",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"businessId", "name", "phaseId"}, true);

		_finderPathCountByB_N_PH = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_N_PH",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"businessId", "name", "phaseId"}, false);

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

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setTeamEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTeamEntryUtilPersistence(null);

		entityCache.removeCache(TeamEntryImpl.class.getName());
	}

	private void _setTeamEntryUtilPersistence(
		TeamEntryPersistence teamEntryPersistence) {

		try {
			Field field = TeamEntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, teamEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_RESOURCEPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_RESOURCEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_RESOURCEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TEAMENTRY =
		"SELECT teamEntry FROM TeamEntry teamEntry";

	private static final String _SQL_SELECT_TEAMENTRY_WHERE =
		"SELECT teamEntry FROM TeamEntry teamEntry WHERE ";

	private static final String _SQL_COUNT_TEAMENTRY =
		"SELECT COUNT(teamEntry) FROM TeamEntry teamEntry";

	private static final String _SQL_COUNT_TEAMENTRY_WHERE =
		"SELECT COUNT(teamEntry) FROM TeamEntry teamEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "teamEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TeamEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TeamEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TeamEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private TeamEntryModelArgumentsResolver _teamEntryModelArgumentsResolver;

}