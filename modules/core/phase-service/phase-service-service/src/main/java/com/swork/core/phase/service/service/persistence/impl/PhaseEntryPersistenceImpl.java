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

package com.swork.core.phase.service.service.persistence.impl;

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

import com.swork.core.phase.service.exception.NoSuchPhaseEntryException;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.model.PhaseEntryTable;
import com.swork.core.phase.service.model.impl.PhaseEntryImpl;
import com.swork.core.phase.service.model.impl.PhaseEntryModelImpl;
import com.swork.core.phase.service.service.persistence.PhaseEntryPersistence;
import com.swork.core.phase.service.service.persistence.PhaseEntryUtil;
import com.swork.core.phase.service.service.persistence.impl.constants.SW_PHASEPersistenceConstants;

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
 * The persistence implementation for the phase entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {PhaseEntryPersistence.class, BasePersistence.class})
public class PhaseEntryPersistenceImpl
	extends BasePersistenceImpl<PhaseEntry> implements PhaseEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhaseEntryUtil</code> to access the phase entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhaseEntryImpl.class.getName();

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
	 * Returns all the phase entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phase entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator,
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

		List<PhaseEntry> list = null;

		if (useFinderCache) {
			list = (List<PhaseEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PhaseEntry phaseEntry : list) {
					if (!uuid.equals(phaseEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_PHASEENTRY_WHERE);

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
				sb.append(PhaseEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PhaseEntry>)QueryUtil.list(
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
	 * Returns the first phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry findByUuid_First(
			String uuid, OrderByComparator<PhaseEntry> orderByComparator)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = fetchByUuid_First(uuid, orderByComparator);

		if (phaseEntry != null) {
			return phaseEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPhaseEntryException(sb.toString());
	}

	/**
	 * Returns the first phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByUuid_First(
		String uuid, OrderByComparator<PhaseEntry> orderByComparator) {

		List<PhaseEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry findByUuid_Last(
			String uuid, OrderByComparator<PhaseEntry> orderByComparator)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (phaseEntry != null) {
			return phaseEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPhaseEntryException(sb.toString());
	}

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByUuid_Last(
		String uuid, OrderByComparator<PhaseEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PhaseEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phase entries before and after the current phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param phaseId the primary key of the current phase entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	@Override
	public PhaseEntry[] findByUuid_PrevAndNext(
			long phaseId, String uuid,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws NoSuchPhaseEntryException {

		uuid = Objects.toString(uuid, "");

		PhaseEntry phaseEntry = findByPrimaryKey(phaseId);

		Session session = null;

		try {
			session = openSession();

			PhaseEntry[] array = new PhaseEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, phaseEntry, uuid, orderByComparator, true);

			array[1] = phaseEntry;

			array[2] = getByUuid_PrevAndNext(
				session, phaseEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhaseEntry getByUuid_PrevAndNext(
		Session session, PhaseEntry phaseEntry, String uuid,
		OrderByComparator<PhaseEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PHASEENTRY_WHERE);

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
			sb.append(PhaseEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(phaseEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PhaseEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phase entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PhaseEntry phaseEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(phaseEntry);
		}
	}

	/**
	 * Returns the number of phase entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching phase entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PHASEENTRY_WHERE);

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
		"phaseEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(phaseEntry.uuid IS NULL OR phaseEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the phase entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = fetchByUUID_G(uuid, groupId);

		if (phaseEntry == null) {
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

			throw new NoSuchPhaseEntryException(sb.toString());
		}

		return phaseEntry;
	}

	/**
	 * Returns the phase entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the phase entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByUUID_G(
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

		if (result instanceof PhaseEntry) {
			PhaseEntry phaseEntry = (PhaseEntry)result;

			if (!Objects.equals(uuid, phaseEntry.getUuid()) ||
				(groupId != phaseEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PHASEENTRY_WHERE);

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

				List<PhaseEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					PhaseEntry phaseEntry = list.get(0);

					result = phaseEntry;

					cacheResult(phaseEntry);
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
			return (PhaseEntry)result;
		}
	}

	/**
	 * Removes the phase entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the phase entry that was removed
	 */
	@Override
	public PhaseEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = findByUUID_G(uuid, groupId);

		return remove(phaseEntry);
	}

	/**
	 * Returns the number of phase entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching phase entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PHASEENTRY_WHERE);

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
		"phaseEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(phaseEntry.uuid IS NULL OR phaseEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"phaseEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator,
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

		List<PhaseEntry> list = null;

		if (useFinderCache) {
			list = (List<PhaseEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PhaseEntry phaseEntry : list) {
					if (!uuid.equals(phaseEntry.getUuid()) ||
						(companyId != phaseEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PHASEENTRY_WHERE);

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
				sb.append(PhaseEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PhaseEntry>)QueryUtil.list(
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
	 * Returns the first phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (phaseEntry != null) {
			return phaseEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPhaseEntryException(sb.toString());
	}

	/**
	 * Returns the first phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PhaseEntry> orderByComparator) {

		List<PhaseEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (phaseEntry != null) {
			return phaseEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPhaseEntryException(sb.toString());
	}

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PhaseEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PhaseEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phase entries before and after the current phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param phaseId the primary key of the current phase entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	@Override
	public PhaseEntry[] findByUuid_C_PrevAndNext(
			long phaseId, String uuid, long companyId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws NoSuchPhaseEntryException {

		uuid = Objects.toString(uuid, "");

		PhaseEntry phaseEntry = findByPrimaryKey(phaseId);

		Session session = null;

		try {
			session = openSession();

			PhaseEntry[] array = new PhaseEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, phaseEntry, uuid, companyId, orderByComparator, true);

			array[1] = phaseEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, phaseEntry, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhaseEntry getByUuid_C_PrevAndNext(
		Session session, PhaseEntry phaseEntry, String uuid, long companyId,
		OrderByComparator<PhaseEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PHASEENTRY_WHERE);

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
			sb.append(PhaseEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(phaseEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PhaseEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phase entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PhaseEntry phaseEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(phaseEntry);
		}
	}

	/**
	 * Returns the number of phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching phase entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PHASEENTRY_WHERE);

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
		"phaseEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(phaseEntry.uuid IS NULL OR phaseEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"phaseEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByP_;
	private FinderPath _finderPathWithoutPaginationFindByP_;
	private FinderPath _finderPathCountByP_;

	/**
	 * Returns all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByP_(long businessId, long projectId) {
		return findByP_(
			businessId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByP_(
		long businessId, long projectId, int start, int end) {

		return findByP_(businessId, projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByP_(
		long businessId, long projectId, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return findByP_(
			businessId, projectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phase entries
	 */
	@Override
	public List<PhaseEntry> findByP_(
		long businessId, long projectId, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_;
				finderArgs = new Object[] {businessId, projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_;
			finderArgs = new Object[] {
				businessId, projectId, start, end, orderByComparator
			};
		}

		List<PhaseEntry> list = null;

		if (useFinderCache) {
			list = (List<PhaseEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PhaseEntry phaseEntry : list) {
					if ((businessId != phaseEntry.getBusinessId()) ||
						(projectId != phaseEntry.getProjectId())) {

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

			sb.append(_SQL_SELECT_PHASEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P__BUSINESSID_2);

			sb.append(_FINDER_COLUMN_P__PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PhaseEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(projectId);

				list = (List<PhaseEntry>)QueryUtil.list(
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
	 * Returns the first phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry findByP__First(
			long businessId, long projectId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = fetchByP__First(
			businessId, projectId, orderByComparator);

		if (phaseEntry != null) {
			return phaseEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchPhaseEntryException(sb.toString());
	}

	/**
	 * Returns the first phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByP__First(
		long businessId, long projectId,
		OrderByComparator<PhaseEntry> orderByComparator) {

		List<PhaseEntry> list = findByP_(
			businessId, projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry findByP__Last(
			long businessId, long projectId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = fetchByP__Last(
			businessId, projectId, orderByComparator);

		if (phaseEntry != null) {
			return phaseEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchPhaseEntryException(sb.toString());
	}

	/**
	 * Returns the last phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByP__Last(
		long businessId, long projectId,
		OrderByComparator<PhaseEntry> orderByComparator) {

		int count = countByP_(businessId, projectId);

		if (count == 0) {
			return null;
		}

		List<PhaseEntry> list = findByP_(
			businessId, projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phase entries before and after the current phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param phaseId the primary key of the current phase entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	@Override
	public PhaseEntry[] findByP__PrevAndNext(
			long phaseId, long businessId, long projectId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = findByPrimaryKey(phaseId);

		Session session = null;

		try {
			session = openSession();

			PhaseEntry[] array = new PhaseEntryImpl[3];

			array[0] = getByP__PrevAndNext(
				session, phaseEntry, businessId, projectId, orderByComparator,
				true);

			array[1] = phaseEntry;

			array[2] = getByP__PrevAndNext(
				session, phaseEntry, businessId, projectId, orderByComparator,
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

	protected PhaseEntry getByP__PrevAndNext(
		Session session, PhaseEntry phaseEntry, long businessId, long projectId,
		OrderByComparator<PhaseEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PHASEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_P__BUSINESSID_2);

		sb.append(_FINDER_COLUMN_P__PROJECTID_2);

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
			sb.append(PhaseEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessId);

		queryPos.add(projectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(phaseEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PhaseEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phase entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	@Override
	public void removeByP_(long businessId, long projectId) {
		for (PhaseEntry phaseEntry :
				findByP_(
					businessId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(phaseEntry);
		}
	}

	/**
	 * Returns the number of phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching phase entries
	 */
	@Override
	public int countByP_(long businessId, long projectId) {
		FinderPath finderPath = _finderPathCountByP_;

		Object[] finderArgs = new Object[] {businessId, projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PHASEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P__BUSINESSID_2);

			sb.append(_FINDER_COLUMN_P__PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(projectId);

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

	private static final String _FINDER_COLUMN_P__BUSINESSID_2 =
		"phaseEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_P__PROJECTID_2 =
		"phaseEntry.projectId = ?";

	private FinderPath _finderPathFetchByB_P_N;
	private FinderPath _finderPathCountByB_P_N;

	/**
	 * Returns the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry findByB_P_N(
			long businessId, long projectId, String phaseName)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = fetchByB_P_N(businessId, projectId, phaseName);

		if (phaseEntry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("businessId=");
			sb.append(businessId);

			sb.append(", projectId=");
			sb.append(projectId);

			sb.append(", phaseName=");
			sb.append(phaseName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPhaseEntryException(sb.toString());
		}

		return phaseEntry;
	}

	/**
	 * Returns the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByB_P_N(
		long businessId, long projectId, String phaseName) {

		return fetchByB_P_N(businessId, projectId, phaseName, true);
	}

	/**
	 * Returns the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByB_P_N(
		long businessId, long projectId, String phaseName,
		boolean useFinderCache) {

		phaseName = Objects.toString(phaseName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {businessId, projectId, phaseName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByB_P_N, finderArgs);
		}

		if (result instanceof PhaseEntry) {
			PhaseEntry phaseEntry = (PhaseEntry)result;

			if ((businessId != phaseEntry.getBusinessId()) ||
				(projectId != phaseEntry.getProjectId()) ||
				!Objects.equals(phaseName, phaseEntry.getPhaseName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_PHASEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_P_N_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_P_N_PROJECTID_2);

			boolean bindPhaseName = false;

			if (phaseName.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_P_N_PHASENAME_3);
			}
			else {
				bindPhaseName = true;

				sb.append(_FINDER_COLUMN_B_P_N_PHASENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(projectId);

				if (bindPhaseName) {
					queryPos.add(phaseName);
				}

				List<PhaseEntry> list = query.list();

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
									businessId, projectId, phaseName
								};
							}

							_log.warn(
								"PhaseEntryPersistenceImpl.fetchByB_P_N(long, long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PhaseEntry phaseEntry = list.get(0);

					result = phaseEntry;

					cacheResult(phaseEntry);
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
			return (PhaseEntry)result;
		}
	}

	/**
	 * Removes the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the phase entry that was removed
	 */
	@Override
	public PhaseEntry removeByB_P_N(
			long businessId, long projectId, String phaseName)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = findByB_P_N(businessId, projectId, phaseName);

		return remove(phaseEntry);
	}

	/**
	 * Returns the number of phase entries where businessId = &#63; and projectId = &#63; and phaseName = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the number of matching phase entries
	 */
	@Override
	public int countByB_P_N(long businessId, long projectId, String phaseName) {
		phaseName = Objects.toString(phaseName, "");

		FinderPath finderPath = _finderPathCountByB_P_N;

		Object[] finderArgs = new Object[] {businessId, projectId, phaseName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PHASEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_P_N_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_P_N_PROJECTID_2);

			boolean bindPhaseName = false;

			if (phaseName.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_P_N_PHASENAME_3);
			}
			else {
				bindPhaseName = true;

				sb.append(_FINDER_COLUMN_B_P_N_PHASENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(projectId);

				if (bindPhaseName) {
					queryPos.add(phaseName);
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
		"phaseEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_P_N_PROJECTID_2 =
		"phaseEntry.projectId = ? AND ";

	private static final String _FINDER_COLUMN_B_P_N_PHASENAME_2 =
		"phaseEntry.phaseName = ?";

	private static final String _FINDER_COLUMN_B_P_N_PHASENAME_3 =
		"(phaseEntry.phaseName IS NULL OR phaseEntry.phaseName = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the phase entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = fetchByC_ERC(companyId, externalReferenceCode);

		if (phaseEntry == null) {
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

			throw new NoSuchPhaseEntryException(sb.toString());
		}

		return phaseEntry;
	}

	/**
	 * Returns the phase entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the phase entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	@Override
	public PhaseEntry fetchByC_ERC(
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

		if (result instanceof PhaseEntry) {
			PhaseEntry phaseEntry = (PhaseEntry)result;

			if ((companyId != phaseEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					phaseEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PHASEENTRY_WHERE);

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

				List<PhaseEntry> list = query.list();

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
								"PhaseEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PhaseEntry phaseEntry = list.get(0);

					result = phaseEntry;

					cacheResult(phaseEntry);
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
			return (PhaseEntry)result;
		}
	}

	/**
	 * Removes the phase entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the phase entry that was removed
	 */
	@Override
	public PhaseEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = findByC_ERC(companyId, externalReferenceCode);

		return remove(phaseEntry);
	}

	/**
	 * Returns the number of phase entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching phase entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PHASEENTRY_WHERE);

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
		"phaseEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"phaseEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(phaseEntry.externalReferenceCode IS NULL OR phaseEntry.externalReferenceCode = '')";

	public PhaseEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PhaseEntry.class);

		setModelImplClass(PhaseEntryImpl.class);
		setModelPKClass(long.class);

		setTable(PhaseEntryTable.INSTANCE);
	}

	/**
	 * Caches the phase entry in the entity cache if it is enabled.
	 *
	 * @param phaseEntry the phase entry
	 */
	@Override
	public void cacheResult(PhaseEntry phaseEntry) {
		entityCache.putResult(
			PhaseEntryImpl.class, phaseEntry.getPrimaryKey(), phaseEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {phaseEntry.getUuid(), phaseEntry.getGroupId()},
			phaseEntry);

		finderCache.putResult(
			_finderPathFetchByB_P_N,
			new Object[] {
				phaseEntry.getBusinessId(), phaseEntry.getProjectId(),
				phaseEntry.getPhaseName()
			},
			phaseEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				phaseEntry.getCompanyId(), phaseEntry.getExternalReferenceCode()
			},
			phaseEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the phase entries in the entity cache if it is enabled.
	 *
	 * @param phaseEntries the phase entries
	 */
	@Override
	public void cacheResult(List<PhaseEntry> phaseEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (phaseEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PhaseEntry phaseEntry : phaseEntries) {
			if (entityCache.getResult(
					PhaseEntryImpl.class, phaseEntry.getPrimaryKey()) == null) {

				cacheResult(phaseEntry);
			}
		}
	}

	/**
	 * Clears the cache for all phase entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhaseEntryImpl.class);

		finderCache.clearCache(PhaseEntryImpl.class);
	}

	/**
	 * Clears the cache for the phase entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhaseEntry phaseEntry) {
		entityCache.removeResult(PhaseEntryImpl.class, phaseEntry);
	}

	@Override
	public void clearCache(List<PhaseEntry> phaseEntries) {
		for (PhaseEntry phaseEntry : phaseEntries) {
			entityCache.removeResult(PhaseEntryImpl.class, phaseEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PhaseEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PhaseEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PhaseEntryModelImpl phaseEntryModelImpl) {

		Object[] args = new Object[] {
			phaseEntryModelImpl.getUuid(), phaseEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, phaseEntryModelImpl);

		args = new Object[] {
			phaseEntryModelImpl.getBusinessId(),
			phaseEntryModelImpl.getProjectId(),
			phaseEntryModelImpl.getPhaseName()
		};

		finderCache.putResult(_finderPathCountByB_P_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByB_P_N, args, phaseEntryModelImpl);

		args = new Object[] {
			phaseEntryModelImpl.getCompanyId(),
			phaseEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, phaseEntryModelImpl);
	}

	/**
	 * Creates a new phase entry with the primary key. Does not add the phase entry to the database.
	 *
	 * @param phaseId the primary key for the new phase entry
	 * @return the new phase entry
	 */
	@Override
	public PhaseEntry create(long phaseId) {
		PhaseEntry phaseEntry = new PhaseEntryImpl();

		phaseEntry.setNew(true);
		phaseEntry.setPrimaryKey(phaseId);

		String uuid = PortalUUIDUtil.generate();

		phaseEntry.setUuid(uuid);

		phaseEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return phaseEntry;
	}

	/**
	 * Removes the phase entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry that was removed
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	@Override
	public PhaseEntry remove(long phaseId) throws NoSuchPhaseEntryException {
		return remove((Serializable)phaseId);
	}

	/**
	 * Removes the phase entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phase entry
	 * @return the phase entry that was removed
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	@Override
	public PhaseEntry remove(Serializable primaryKey)
		throws NoSuchPhaseEntryException {

		Session session = null;

		try {
			session = openSession();

			PhaseEntry phaseEntry = (PhaseEntry)session.get(
				PhaseEntryImpl.class, primaryKey);

			if (phaseEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhaseEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(phaseEntry);
		}
		catch (NoSuchPhaseEntryException noSuchEntityException) {
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
	protected PhaseEntry removeImpl(PhaseEntry phaseEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phaseEntry)) {
				phaseEntry = (PhaseEntry)session.get(
					PhaseEntryImpl.class, phaseEntry.getPrimaryKeyObj());
			}

			if (phaseEntry != null) {
				session.delete(phaseEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (phaseEntry != null) {
			clearCache(phaseEntry);
		}

		return phaseEntry;
	}

	@Override
	public PhaseEntry updateImpl(PhaseEntry phaseEntry) {
		boolean isNew = phaseEntry.isNew();

		if (!(phaseEntry instanceof PhaseEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phaseEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(phaseEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phaseEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PhaseEntry implementation " +
					phaseEntry.getClass());
		}

		PhaseEntryModelImpl phaseEntryModelImpl =
			(PhaseEntryModelImpl)phaseEntry;

		if (Validator.isNull(phaseEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			phaseEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (phaseEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				phaseEntry.setCreateDate(date);
			}
			else {
				phaseEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!phaseEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				phaseEntry.setModifiedDate(date);
			}
			else {
				phaseEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(phaseEntry);
			}
			else {
				phaseEntry = (PhaseEntry)session.merge(phaseEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PhaseEntryImpl.class, phaseEntryModelImpl, false, true);

		cacheUniqueFindersCache(phaseEntryModelImpl);

		if (isNew) {
			phaseEntry.setNew(false);
		}

		phaseEntry.resetOriginalValues();

		return phaseEntry;
	}

	/**
	 * Returns the phase entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phase entry
	 * @return the phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	@Override
	public PhaseEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhaseEntryException {

		PhaseEntry phaseEntry = fetchByPrimaryKey(primaryKey);

		if (phaseEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhaseEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return phaseEntry;
	}

	/**
	 * Returns the phase entry with the primary key or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	@Override
	public PhaseEntry findByPrimaryKey(long phaseId)
		throws NoSuchPhaseEntryException {

		return findByPrimaryKey((Serializable)phaseId);
	}

	/**
	 * Returns the phase entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry, or <code>null</code> if a phase entry with the primary key could not be found
	 */
	@Override
	public PhaseEntry fetchByPrimaryKey(long phaseId) {
		return fetchByPrimaryKey((Serializable)phaseId);
	}

	/**
	 * Returns all the phase entries.
	 *
	 * @return the phase entries
	 */
	@Override
	public List<PhaseEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phase entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of phase entries
	 */
	@Override
	public List<PhaseEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phase entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phase entries
	 */
	@Override
	public List<PhaseEntry> findAll(
		int start, int end, OrderByComparator<PhaseEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phase entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phase entries
	 */
	@Override
	public List<PhaseEntry> findAll(
		int start, int end, OrderByComparator<PhaseEntry> orderByComparator,
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

		List<PhaseEntry> list = null;

		if (useFinderCache) {
			list = (List<PhaseEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PHASEENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PHASEENTRY;

				sql = sql.concat(PhaseEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PhaseEntry>)QueryUtil.list(
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
	 * Removes all the phase entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PhaseEntry phaseEntry : findAll()) {
			remove(phaseEntry);
		}
	}

	/**
	 * Returns the number of phase entries.
	 *
	 * @return the number of phase entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PHASEENTRY);

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
		return "phaseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PHASEENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PhaseEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the phase entry persistence.
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

		_finderPathWithPaginationFindByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "projectId"}, true);

		_finderPathWithoutPaginationFindByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "projectId"}, true);

		_finderPathCountByP_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "projectId"}, false);

		_finderPathFetchByB_P_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByB_P_N",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"businessId", "projectId", "phaseName"}, true);

		_finderPathCountByB_P_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_P_N",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"businessId", "projectId", "phaseName"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setPhaseEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPhaseEntryUtilPersistence(null);

		entityCache.removeCache(PhaseEntryImpl.class.getName());
	}

	private void _setPhaseEntryUtilPersistence(
		PhaseEntryPersistence phaseEntryPersistence) {

		try {
			Field field = PhaseEntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, phaseEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_PHASEPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_PHASEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_PHASEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PHASEENTRY =
		"SELECT phaseEntry FROM PhaseEntry phaseEntry";

	private static final String _SQL_SELECT_PHASEENTRY_WHERE =
		"SELECT phaseEntry FROM PhaseEntry phaseEntry WHERE ";

	private static final String _SQL_COUNT_PHASEENTRY =
		"SELECT COUNT(phaseEntry) FROM PhaseEntry phaseEntry";

	private static final String _SQL_COUNT_PHASEENTRY_WHERE =
		"SELECT COUNT(phaseEntry) FROM PhaseEntry phaseEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "phaseEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PhaseEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PhaseEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PhaseEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PhaseEntryModelArgumentsResolver _phaseEntryModelArgumentsResolver;

}