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

import com.swork.core.resource.service.exception.NoSuchTeamMemberEntryException;
import com.swork.core.resource.service.model.TeamMemberEntry;
import com.swork.core.resource.service.model.TeamMemberEntryTable;
import com.swork.core.resource.service.model.impl.TeamMemberEntryImpl;
import com.swork.core.resource.service.model.impl.TeamMemberEntryModelImpl;
import com.swork.core.resource.service.service.persistence.TeamMemberEntryPersistence;
import com.swork.core.resource.service.service.persistence.TeamMemberEntryUtil;
import com.swork.core.resource.service.service.persistence.impl.constants.SW_RESOURCEPersistenceConstants;

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
 * The persistence implementation for the team member entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {TeamMemberEntryPersistence.class, BasePersistence.class})
public class TeamMemberEntryPersistenceImpl
	extends BasePersistenceImpl<TeamMemberEntry>
	implements TeamMemberEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TeamMemberEntryUtil</code> to access the team member entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TeamMemberEntryImpl.class.getName();

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
	 * Returns all the team member entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team member entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @return the range of matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the team member entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team member entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator,
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

		List<TeamMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<TeamMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TeamMemberEntry teamMemberEntry : list) {
					if (!uuid.equals(teamMemberEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_TEAMMEMBERENTRY_WHERE);

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
				sb.append(TeamMemberEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TeamMemberEntry>)QueryUtil.list(
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
	 * Returns the first team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry findByUuid_First(
			String uuid, OrderByComparator<TeamMemberEntry> orderByComparator)
		throws NoSuchTeamMemberEntryException {

		TeamMemberEntry teamMemberEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (teamMemberEntry != null) {
			return teamMemberEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTeamMemberEntryException(sb.toString());
	}

	/**
	 * Returns the first team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry fetchByUuid_First(
		String uuid, OrderByComparator<TeamMemberEntry> orderByComparator) {

		List<TeamMemberEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry findByUuid_Last(
			String uuid, OrderByComparator<TeamMemberEntry> orderByComparator)
		throws NoSuchTeamMemberEntryException {

		TeamMemberEntry teamMemberEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (teamMemberEntry != null) {
			return teamMemberEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTeamMemberEntryException(sb.toString());
	}

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry fetchByUuid_Last(
		String uuid, OrderByComparator<TeamMemberEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TeamMemberEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the team member entries before and after the current team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param teamMemberId the primary key of the current team member entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	@Override
	public TeamMemberEntry[] findByUuid_PrevAndNext(
			long teamMemberId, String uuid,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws NoSuchTeamMemberEntryException {

		uuid = Objects.toString(uuid, "");

		TeamMemberEntry teamMemberEntry = findByPrimaryKey(teamMemberId);

		Session session = null;

		try {
			session = openSession();

			TeamMemberEntry[] array = new TeamMemberEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, teamMemberEntry, uuid, orderByComparator, true);

			array[1] = teamMemberEntry;

			array[2] = getByUuid_PrevAndNext(
				session, teamMemberEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TeamMemberEntry getByUuid_PrevAndNext(
		Session session, TeamMemberEntry teamMemberEntry, String uuid,
		OrderByComparator<TeamMemberEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_TEAMMEMBERENTRY_WHERE);

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
			sb.append(TeamMemberEntryModelImpl.ORDER_BY_JPQL);
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
						teamMemberEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TeamMemberEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team member entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TeamMemberEntry teamMemberEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(teamMemberEntry);
		}
	}

	/**
	 * Returns the number of team member entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching team member entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TEAMMEMBERENTRY_WHERE);

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
		"teamMemberEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(teamMemberEntry.uuid IS NULL OR teamMemberEntry.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @return the range of matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator,
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

		List<TeamMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<TeamMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TeamMemberEntry teamMemberEntry : list) {
					if (!uuid.equals(teamMemberEntry.getUuid()) ||
						(companyId != teamMemberEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TEAMMEMBERENTRY_WHERE);

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
				sb.append(TeamMemberEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TeamMemberEntry>)QueryUtil.list(
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
	 * Returns the first team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws NoSuchTeamMemberEntryException {

		TeamMemberEntry teamMemberEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (teamMemberEntry != null) {
			return teamMemberEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTeamMemberEntryException(sb.toString());
	}

	/**
	 * Returns the first team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		List<TeamMemberEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws NoSuchTeamMemberEntryException {

		TeamMemberEntry teamMemberEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (teamMemberEntry != null) {
			return teamMemberEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTeamMemberEntryException(sb.toString());
	}

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TeamMemberEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the team member entries before and after the current team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param teamMemberId the primary key of the current team member entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	@Override
	public TeamMemberEntry[] findByUuid_C_PrevAndNext(
			long teamMemberId, String uuid, long companyId,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws NoSuchTeamMemberEntryException {

		uuid = Objects.toString(uuid, "");

		TeamMemberEntry teamMemberEntry = findByPrimaryKey(teamMemberId);

		Session session = null;

		try {
			session = openSession();

			TeamMemberEntry[] array = new TeamMemberEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, teamMemberEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = teamMemberEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, teamMemberEntry, uuid, companyId, orderByComparator,
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

	protected TeamMemberEntry getByUuid_C_PrevAndNext(
		Session session, TeamMemberEntry teamMemberEntry, String uuid,
		long companyId, OrderByComparator<TeamMemberEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_TEAMMEMBERENTRY_WHERE);

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
			sb.append(TeamMemberEntryModelImpl.ORDER_BY_JPQL);
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
						teamMemberEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TeamMemberEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team member entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TeamMemberEntry teamMemberEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(teamMemberEntry);
		}
	}

	/**
	 * Returns the number of team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching team member entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEAMMEMBERENTRY_WHERE);

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
		"teamMemberEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(teamMemberEntry.uuid IS NULL OR teamMemberEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"teamMemberEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTeam;
	private FinderPath _finderPathWithoutPaginationFindByTeam;
	private FinderPath _finderPathCountByTeam;

	/**
	 * Returns all the team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @return the matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByTeam(long teamId, Boolean isAdmin) {
		return findByTeam(
			teamId, isAdmin, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @return the range of matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByTeam(
		long teamId, Boolean isAdmin, int start, int end) {

		return findByTeam(teamId, isAdmin, start, end, null);
	}

	/**
	 * Returns an ordered range of all the team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByTeam(
		long teamId, Boolean isAdmin, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return findByTeam(teamId, isAdmin, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team member entries
	 */
	@Override
	public List<TeamMemberEntry> findByTeam(
		long teamId, Boolean isAdmin, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTeam;
				finderArgs = new Object[] {teamId, isAdmin};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTeam;
			finderArgs = new Object[] {
				teamId, isAdmin, start, end, orderByComparator
			};
		}

		List<TeamMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<TeamMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TeamMemberEntry teamMemberEntry : list) {
					if ((teamId != teamMemberEntry.getTeamId()) ||
						!Objects.equals(
							isAdmin, teamMemberEntry.getIsAdmin())) {

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

			sb.append(_SQL_SELECT_TEAMMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_TEAM_TEAMID_2);

			sb.append(_FINDER_COLUMN_TEAM_ISADMIN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TeamMemberEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(teamId);

				queryPos.add(isAdmin.booleanValue());

				list = (List<TeamMemberEntry>)QueryUtil.list(
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
	 * Returns the first team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry findByTeam_First(
			long teamId, Boolean isAdmin,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws NoSuchTeamMemberEntryException {

		TeamMemberEntry teamMemberEntry = fetchByTeam_First(
			teamId, isAdmin, orderByComparator);

		if (teamMemberEntry != null) {
			return teamMemberEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("teamId=");
		sb.append(teamId);

		sb.append(", isAdmin=");
		sb.append(isAdmin);

		sb.append("}");

		throw new NoSuchTeamMemberEntryException(sb.toString());
	}

	/**
	 * Returns the first team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry fetchByTeam_First(
		long teamId, Boolean isAdmin,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		List<TeamMemberEntry> list = findByTeam(
			teamId, isAdmin, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry findByTeam_Last(
			long teamId, Boolean isAdmin,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws NoSuchTeamMemberEntryException {

		TeamMemberEntry teamMemberEntry = fetchByTeam_Last(
			teamId, isAdmin, orderByComparator);

		if (teamMemberEntry != null) {
			return teamMemberEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("teamId=");
		sb.append(teamId);

		sb.append(", isAdmin=");
		sb.append(isAdmin);

		sb.append("}");

		throw new NoSuchTeamMemberEntryException(sb.toString());
	}

	/**
	 * Returns the last team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry fetchByTeam_Last(
		long teamId, Boolean isAdmin,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		int count = countByTeam(teamId, isAdmin);

		if (count == 0) {
			return null;
		}

		List<TeamMemberEntry> list = findByTeam(
			teamId, isAdmin, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the team member entries before and after the current team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamMemberId the primary key of the current team member entry
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	@Override
	public TeamMemberEntry[] findByTeam_PrevAndNext(
			long teamMemberId, long teamId, Boolean isAdmin,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws NoSuchTeamMemberEntryException {

		TeamMemberEntry teamMemberEntry = findByPrimaryKey(teamMemberId);

		Session session = null;

		try {
			session = openSession();

			TeamMemberEntry[] array = new TeamMemberEntryImpl[3];

			array[0] = getByTeam_PrevAndNext(
				session, teamMemberEntry, teamId, isAdmin, orderByComparator,
				true);

			array[1] = teamMemberEntry;

			array[2] = getByTeam_PrevAndNext(
				session, teamMemberEntry, teamId, isAdmin, orderByComparator,
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

	protected TeamMemberEntry getByTeam_PrevAndNext(
		Session session, TeamMemberEntry teamMemberEntry, long teamId,
		Boolean isAdmin, OrderByComparator<TeamMemberEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_TEAMMEMBERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_TEAM_TEAMID_2);

		sb.append(_FINDER_COLUMN_TEAM_ISADMIN_2);

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
			sb.append(TeamMemberEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(teamId);

		queryPos.add(isAdmin.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						teamMemberEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TeamMemberEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team member entries where teamId = &#63; and isAdmin = &#63; from the database.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 */
	@Override
	public void removeByTeam(long teamId, Boolean isAdmin) {
		for (TeamMemberEntry teamMemberEntry :
				findByTeam(
					teamId, isAdmin, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(teamMemberEntry);
		}
	}

	/**
	 * Returns the number of team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @return the number of matching team member entries
	 */
	@Override
	public int countByTeam(long teamId, Boolean isAdmin) {
		FinderPath finderPath = _finderPathCountByTeam;

		Object[] finderArgs = new Object[] {teamId, isAdmin};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEAMMEMBERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_TEAM_TEAMID_2);

			sb.append(_FINDER_COLUMN_TEAM_ISADMIN_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(teamId);

				queryPos.add(isAdmin.booleanValue());

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

	private static final String _FINDER_COLUMN_TEAM_TEAMID_2 =
		"teamMemberEntry.teamId = ? AND ";

	private static final String _FINDER_COLUMN_TEAM_ISADMIN_2 =
		"teamMemberEntry.isAdmin = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the team member entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchTeamMemberEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchTeamMemberEntryException {

		TeamMemberEntry teamMemberEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (teamMemberEntry == null) {
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

			throw new NoSuchTeamMemberEntryException(sb.toString());
		}

		return teamMemberEntry;
	}

	/**
	 * Returns the team member entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the team member entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	@Override
	public TeamMemberEntry fetchByC_ERC(
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

		if (result instanceof TeamMemberEntry) {
			TeamMemberEntry teamMemberEntry = (TeamMemberEntry)result;

			if ((companyId != teamMemberEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					teamMemberEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TEAMMEMBERENTRY_WHERE);

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

				List<TeamMemberEntry> list = query.list();

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
								"TeamMemberEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TeamMemberEntry teamMemberEntry = list.get(0);

					result = teamMemberEntry;

					cacheResult(teamMemberEntry);
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
			return (TeamMemberEntry)result;
		}
	}

	/**
	 * Removes the team member entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the team member entry that was removed
	 */
	@Override
	public TeamMemberEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchTeamMemberEntryException {

		TeamMemberEntry teamMemberEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(teamMemberEntry);
	}

	/**
	 * Returns the number of team member entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching team member entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TEAMMEMBERENTRY_WHERE);

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
		"teamMemberEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"teamMemberEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(teamMemberEntry.externalReferenceCode IS NULL OR teamMemberEntry.externalReferenceCode = '')";

	public TeamMemberEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TeamMemberEntry.class);

		setModelImplClass(TeamMemberEntryImpl.class);
		setModelPKClass(long.class);

		setTable(TeamMemberEntryTable.INSTANCE);
	}

	/**
	 * Caches the team member entry in the entity cache if it is enabled.
	 *
	 * @param teamMemberEntry the team member entry
	 */
	@Override
	public void cacheResult(TeamMemberEntry teamMemberEntry) {
		entityCache.putResult(
			TeamMemberEntryImpl.class, teamMemberEntry.getPrimaryKey(),
			teamMemberEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				teamMemberEntry.getCompanyId(),
				teamMemberEntry.getExternalReferenceCode()
			},
			teamMemberEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the team member entries in the entity cache if it is enabled.
	 *
	 * @param teamMemberEntries the team member entries
	 */
	@Override
	public void cacheResult(List<TeamMemberEntry> teamMemberEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (teamMemberEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TeamMemberEntry teamMemberEntry : teamMemberEntries) {
			if (entityCache.getResult(
					TeamMemberEntryImpl.class,
					teamMemberEntry.getPrimaryKey()) == null) {

				cacheResult(teamMemberEntry);
			}
		}
	}

	/**
	 * Clears the cache for all team member entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TeamMemberEntryImpl.class);

		finderCache.clearCache(TeamMemberEntryImpl.class);
	}

	/**
	 * Clears the cache for the team member entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TeamMemberEntry teamMemberEntry) {
		entityCache.removeResult(TeamMemberEntryImpl.class, teamMemberEntry);
	}

	@Override
	public void clearCache(List<TeamMemberEntry> teamMemberEntries) {
		for (TeamMemberEntry teamMemberEntry : teamMemberEntries) {
			entityCache.removeResult(
				TeamMemberEntryImpl.class, teamMemberEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TeamMemberEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TeamMemberEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TeamMemberEntryModelImpl teamMemberEntryModelImpl) {

		Object[] args = new Object[] {
			teamMemberEntryModelImpl.getCompanyId(),
			teamMemberEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, teamMemberEntryModelImpl);
	}

	/**
	 * Creates a new team member entry with the primary key. Does not add the team member entry to the database.
	 *
	 * @param teamMemberId the primary key for the new team member entry
	 * @return the new team member entry
	 */
	@Override
	public TeamMemberEntry create(long teamMemberId) {
		TeamMemberEntry teamMemberEntry = new TeamMemberEntryImpl();

		teamMemberEntry.setNew(true);
		teamMemberEntry.setPrimaryKey(teamMemberId);

		String uuid = PortalUUIDUtil.generate();

		teamMemberEntry.setUuid(uuid);

		teamMemberEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return teamMemberEntry;
	}

	/**
	 * Removes the team member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamMemberId the primary key of the team member entry
	 * @return the team member entry that was removed
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	@Override
	public TeamMemberEntry remove(long teamMemberId)
		throws NoSuchTeamMemberEntryException {

		return remove((Serializable)teamMemberId);
	}

	/**
	 * Removes the team member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the team member entry
	 * @return the team member entry that was removed
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	@Override
	public TeamMemberEntry remove(Serializable primaryKey)
		throws NoSuchTeamMemberEntryException {

		Session session = null;

		try {
			session = openSession();

			TeamMemberEntry teamMemberEntry = (TeamMemberEntry)session.get(
				TeamMemberEntryImpl.class, primaryKey);

			if (teamMemberEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTeamMemberEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(teamMemberEntry);
		}
		catch (NoSuchTeamMemberEntryException noSuchEntityException) {
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
	protected TeamMemberEntry removeImpl(TeamMemberEntry teamMemberEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(teamMemberEntry)) {
				teamMemberEntry = (TeamMemberEntry)session.get(
					TeamMemberEntryImpl.class,
					teamMemberEntry.getPrimaryKeyObj());
			}

			if (teamMemberEntry != null) {
				session.delete(teamMemberEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (teamMemberEntry != null) {
			clearCache(teamMemberEntry);
		}

		return teamMemberEntry;
	}

	@Override
	public TeamMemberEntry updateImpl(TeamMemberEntry teamMemberEntry) {
		boolean isNew = teamMemberEntry.isNew();

		if (!(teamMemberEntry instanceof TeamMemberEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(teamMemberEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					teamMemberEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in teamMemberEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TeamMemberEntry implementation " +
					teamMemberEntry.getClass());
		}

		TeamMemberEntryModelImpl teamMemberEntryModelImpl =
			(TeamMemberEntryModelImpl)teamMemberEntry;

		if (Validator.isNull(teamMemberEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			teamMemberEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(teamMemberEntry);
			}
			else {
				teamMemberEntry = (TeamMemberEntry)session.merge(
					teamMemberEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TeamMemberEntryImpl.class, teamMemberEntryModelImpl, false, true);

		cacheUniqueFindersCache(teamMemberEntryModelImpl);

		if (isNew) {
			teamMemberEntry.setNew(false);
		}

		teamMemberEntry.resetOriginalValues();

		return teamMemberEntry;
	}

	/**
	 * Returns the team member entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the team member entry
	 * @return the team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	@Override
	public TeamMemberEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTeamMemberEntryException {

		TeamMemberEntry teamMemberEntry = fetchByPrimaryKey(primaryKey);

		if (teamMemberEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTeamMemberEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return teamMemberEntry;
	}

	/**
	 * Returns the team member entry with the primary key or throws a <code>NoSuchTeamMemberEntryException</code> if it could not be found.
	 *
	 * @param teamMemberId the primary key of the team member entry
	 * @return the team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	@Override
	public TeamMemberEntry findByPrimaryKey(long teamMemberId)
		throws NoSuchTeamMemberEntryException {

		return findByPrimaryKey((Serializable)teamMemberId);
	}

	/**
	 * Returns the team member entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamMemberId the primary key of the team member entry
	 * @return the team member entry, or <code>null</code> if a team member entry with the primary key could not be found
	 */
	@Override
	public TeamMemberEntry fetchByPrimaryKey(long teamMemberId) {
		return fetchByPrimaryKey((Serializable)teamMemberId);
	}

	/**
	 * Returns all the team member entries.
	 *
	 * @return the team member entries
	 */
	@Override
	public List<TeamMemberEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @return the range of team member entries
	 */
	@Override
	public List<TeamMemberEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the team member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of team member entries
	 */
	@Override
	public List<TeamMemberEntry> findAll(
		int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of team member entries
	 */
	@Override
	public List<TeamMemberEntry> findAll(
		int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator,
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

		List<TeamMemberEntry> list = null;

		if (useFinderCache) {
			list = (List<TeamMemberEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TEAMMEMBERENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TEAMMEMBERENTRY;

				sql = sql.concat(TeamMemberEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TeamMemberEntry>)QueryUtil.list(
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
	 * Removes all the team member entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TeamMemberEntry teamMemberEntry : findAll()) {
			remove(teamMemberEntry);
		}
	}

	/**
	 * Returns the number of team member entries.
	 *
	 * @return the number of team member entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TEAMMEMBERENTRY);

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
		return "teamMemberId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TEAMMEMBERENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TeamMemberEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the team member entry persistence.
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

		_finderPathWithPaginationFindByTeam = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTeam",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"teamId", "isAdmin"}, true);

		_finderPathWithoutPaginationFindByTeam = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTeam",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"teamId", "isAdmin"}, true);

		_finderPathCountByTeam = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTeam",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"teamId", "isAdmin"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setTeamMemberEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTeamMemberEntryUtilPersistence(null);

		entityCache.removeCache(TeamMemberEntryImpl.class.getName());
	}

	private void _setTeamMemberEntryUtilPersistence(
		TeamMemberEntryPersistence teamMemberEntryPersistence) {

		try {
			Field field = TeamMemberEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, teamMemberEntryPersistence);
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

	private static final String _SQL_SELECT_TEAMMEMBERENTRY =
		"SELECT teamMemberEntry FROM TeamMemberEntry teamMemberEntry";

	private static final String _SQL_SELECT_TEAMMEMBERENTRY_WHERE =
		"SELECT teamMemberEntry FROM TeamMemberEntry teamMemberEntry WHERE ";

	private static final String _SQL_COUNT_TEAMMEMBERENTRY =
		"SELECT COUNT(teamMemberEntry) FROM TeamMemberEntry teamMemberEntry";

	private static final String _SQL_COUNT_TEAMMEMBERENTRY_WHERE =
		"SELECT COUNT(teamMemberEntry) FROM TeamMemberEntry teamMemberEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "teamMemberEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TeamMemberEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TeamMemberEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TeamMemberEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private TeamMemberEntryModelArgumentsResolver
		_teamMemberEntryModelArgumentsResolver;

}