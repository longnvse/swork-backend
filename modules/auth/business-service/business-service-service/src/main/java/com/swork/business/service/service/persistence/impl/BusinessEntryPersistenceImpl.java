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

package com.swork.business.service.service.persistence.impl;

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

import com.swork.business.service.exception.NoSuchBusinessEntryException;
import com.swork.business.service.model.BusinessEntry;
import com.swork.business.service.model.BusinessEntryTable;
import com.swork.business.service.model.impl.BusinessEntryImpl;
import com.swork.business.service.model.impl.BusinessEntryModelImpl;
import com.swork.business.service.service.persistence.BusinessEntryPersistence;
import com.swork.business.service.service.persistence.BusinessEntryUtil;
import com.swork.business.service.service.persistence.impl.constants.SW_BUSINESSPersistenceConstants;

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
 * The persistence implementation for the business entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {BusinessEntryPersistence.class, BasePersistence.class})
public class BusinessEntryPersistenceImpl
	extends BasePersistenceImpl<BusinessEntry>
	implements BusinessEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BusinessEntryUtil</code> to access the business entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BusinessEntryImpl.class.getName();

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
	 * Returns all the business entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching business entries
	 */
	@Override
	public List<BusinessEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the business entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @return the range of matching business entries
	 */
	@Override
	public List<BusinessEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business entries
	 */
	@Override
	public List<BusinessEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching business entries
	 */
	@Override
	public List<BusinessEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator,
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

		List<BusinessEntry> list = null;

		if (useFinderCache) {
			list = (List<BusinessEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (BusinessEntry businessEntry : list) {
					if (!uuid.equals(businessEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_BUSINESSENTRY_WHERE);

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
				sb.append(BusinessEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<BusinessEntry>)QueryUtil.list(
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
	 * Returns the first business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry findByUuid_First(
			String uuid, OrderByComparator<BusinessEntry> orderByComparator)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (businessEntry != null) {
			return businessEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBusinessEntryException(sb.toString());
	}

	/**
	 * Returns the first business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByUuid_First(
		String uuid, OrderByComparator<BusinessEntry> orderByComparator) {

		List<BusinessEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry findByUuid_Last(
			String uuid, OrderByComparator<BusinessEntry> orderByComparator)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (businessEntry != null) {
			return businessEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBusinessEntryException(sb.toString());
	}

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByUuid_Last(
		String uuid, OrderByComparator<BusinessEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BusinessEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the business entries before and after the current business entry in the ordered set where uuid = &#63;.
	 *
	 * @param businessId the primary key of the current business entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next business entry
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	@Override
	public BusinessEntry[] findByUuid_PrevAndNext(
			long businessId, String uuid,
			OrderByComparator<BusinessEntry> orderByComparator)
		throws NoSuchBusinessEntryException {

		uuid = Objects.toString(uuid, "");

		BusinessEntry businessEntry = findByPrimaryKey(businessId);

		Session session = null;

		try {
			session = openSession();

			BusinessEntry[] array = new BusinessEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, businessEntry, uuid, orderByComparator, true);

			array[1] = businessEntry;

			array[2] = getByUuid_PrevAndNext(
				session, businessEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusinessEntry getByUuid_PrevAndNext(
		Session session, BusinessEntry businessEntry, String uuid,
		OrderByComparator<BusinessEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BUSINESSENTRY_WHERE);

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
			sb.append(BusinessEntryModelImpl.ORDER_BY_JPQL);
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
						businessEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BusinessEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the business entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BusinessEntry businessEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(businessEntry);
		}
	}

	/**
	 * Returns the number of business entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching business entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUSINESSENTRY_WHERE);

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
		"businessEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(businessEntry.uuid IS NULL OR businessEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the business entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = fetchByUUID_G(uuid, groupId);

		if (businessEntry == null) {
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

			throw new NoSuchBusinessEntryException(sb.toString());
		}

		return businessEntry;
	}

	/**
	 * Returns the business entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the business entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByUUID_G(
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

		if (result instanceof BusinessEntry) {
			BusinessEntry businessEntry = (BusinessEntry)result;

			if (!Objects.equals(uuid, businessEntry.getUuid()) ||
				(groupId != businessEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BUSINESSENTRY_WHERE);

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

				List<BusinessEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					BusinessEntry businessEntry = list.get(0);

					result = businessEntry;

					cacheResult(businessEntry);
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
			return (BusinessEntry)result;
		}
	}

	/**
	 * Removes the business entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the business entry that was removed
	 */
	@Override
	public BusinessEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = findByUUID_G(uuid, groupId);

		return remove(businessEntry);
	}

	/**
	 * Returns the number of business entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching business entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BUSINESSENTRY_WHERE);

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
		"businessEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(businessEntry.uuid IS NULL OR businessEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"businessEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching business entries
	 */
	@Override
	public List<BusinessEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @return the range of matching business entries
	 */
	@Override
	public List<BusinessEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business entries
	 */
	@Override
	public List<BusinessEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching business entries
	 */
	@Override
	public List<BusinessEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator,
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

		List<BusinessEntry> list = null;

		if (useFinderCache) {
			list = (List<BusinessEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (BusinessEntry businessEntry : list) {
					if (!uuid.equals(businessEntry.getUuid()) ||
						(companyId != businessEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BUSINESSENTRY_WHERE);

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
				sb.append(BusinessEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<BusinessEntry>)QueryUtil.list(
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
	 * Returns the first business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BusinessEntry> orderByComparator)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (businessEntry != null) {
			return businessEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBusinessEntryException(sb.toString());
	}

	/**
	 * Returns the first business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BusinessEntry> orderByComparator) {

		List<BusinessEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BusinessEntry> orderByComparator)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (businessEntry != null) {
			return businessEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBusinessEntryException(sb.toString());
	}

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BusinessEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<BusinessEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the business entries before and after the current business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param businessId the primary key of the current business entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next business entry
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	@Override
	public BusinessEntry[] findByUuid_C_PrevAndNext(
			long businessId, String uuid, long companyId,
			OrderByComparator<BusinessEntry> orderByComparator)
		throws NoSuchBusinessEntryException {

		uuid = Objects.toString(uuid, "");

		BusinessEntry businessEntry = findByPrimaryKey(businessId);

		Session session = null;

		try {
			session = openSession();

			BusinessEntry[] array = new BusinessEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, businessEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = businessEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, businessEntry, uuid, companyId, orderByComparator,
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

	protected BusinessEntry getByUuid_C_PrevAndNext(
		Session session, BusinessEntry businessEntry, String uuid,
		long companyId, OrderByComparator<BusinessEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_BUSINESSENTRY_WHERE);

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
			sb.append(BusinessEntryModelImpl.ORDER_BY_JPQL);
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
						businessEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BusinessEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the business entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (BusinessEntry businessEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(businessEntry);
		}
	}

	/**
	 * Returns the number of business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching business entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BUSINESSENTRY_WHERE);

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
		"businessEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(businessEntry.uuid IS NULL OR businessEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"businessEntry.companyId = ?";

	private FinderPath _finderPathFetchByPhone;
	private FinderPath _finderPathCountByPhone;

	/**
	 * Returns the business entry where phoneNumber = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param phoneNumber the phone number
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry findByPhone(String phoneNumber)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = fetchByPhone(phoneNumber);

		if (businessEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("phoneNumber=");
			sb.append(phoneNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBusinessEntryException(sb.toString());
		}

		return businessEntry;
	}

	/**
	 * Returns the business entry where phoneNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param phoneNumber the phone number
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByPhone(String phoneNumber) {
		return fetchByPhone(phoneNumber, true);
	}

	/**
	 * Returns the business entry where phoneNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param phoneNumber the phone number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByPhone(
		String phoneNumber, boolean useFinderCache) {

		phoneNumber = Objects.toString(phoneNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {phoneNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByPhone, finderArgs);
		}

		if (result instanceof BusinessEntry) {
			BusinessEntry businessEntry = (BusinessEntry)result;

			if (!Objects.equals(phoneNumber, businessEntry.getPhoneNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_BUSINESSENTRY_WHERE);

			boolean bindPhoneNumber = false;

			if (phoneNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_PHONE_PHONENUMBER_3);
			}
			else {
				bindPhoneNumber = true;

				sb.append(_FINDER_COLUMN_PHONE_PHONENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPhoneNumber) {
					queryPos.add(phoneNumber);
				}

				List<BusinessEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPhone, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {phoneNumber};
							}

							_log.warn(
								"BusinessEntryPersistenceImpl.fetchByPhone(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					BusinessEntry businessEntry = list.get(0);

					result = businessEntry;

					cacheResult(businessEntry);
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
			return (BusinessEntry)result;
		}
	}

	/**
	 * Removes the business entry where phoneNumber = &#63; from the database.
	 *
	 * @param phoneNumber the phone number
	 * @return the business entry that was removed
	 */
	@Override
	public BusinessEntry removeByPhone(String phoneNumber)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = findByPhone(phoneNumber);

		return remove(businessEntry);
	}

	/**
	 * Returns the number of business entries where phoneNumber = &#63;.
	 *
	 * @param phoneNumber the phone number
	 * @return the number of matching business entries
	 */
	@Override
	public int countByPhone(String phoneNumber) {
		phoneNumber = Objects.toString(phoneNumber, "");

		FinderPath finderPath = _finderPathCountByPhone;

		Object[] finderArgs = new Object[] {phoneNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUSINESSENTRY_WHERE);

			boolean bindPhoneNumber = false;

			if (phoneNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_PHONE_PHONENUMBER_3);
			}
			else {
				bindPhoneNumber = true;

				sb.append(_FINDER_COLUMN_PHONE_PHONENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPhoneNumber) {
					queryPos.add(phoneNumber);
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

	private static final String _FINDER_COLUMN_PHONE_PHONENUMBER_2 =
		"businessEntry.phoneNumber = ?";

	private static final String _FINDER_COLUMN_PHONE_PHONENUMBER_3 =
		"(businessEntry.phoneNumber IS NULL OR businessEntry.phoneNumber = '')";

	private FinderPath _finderPathFetchByEmail;
	private FinderPath _finderPathCountByEmail;

	/**
	 * Returns the business entry where email = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry findByEmail(String email)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = fetchByEmail(email);

		if (businessEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("email=");
			sb.append(email);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBusinessEntryException(sb.toString());
		}

		return businessEntry;
	}

	/**
	 * Returns the business entry where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByEmail(String email) {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the business entry where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByEmail(String email, boolean useFinderCache) {
		email = Objects.toString(email, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {email};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByEmail, finderArgs);
		}

		if (result instanceof BusinessEntry) {
			BusinessEntry businessEntry = (BusinessEntry)result;

			if (!Objects.equals(email, businessEntry.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_BUSINESSENTRY_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				List<BusinessEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmail, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {email};
							}

							_log.warn(
								"BusinessEntryPersistenceImpl.fetchByEmail(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					BusinessEntry businessEntry = list.get(0);

					result = businessEntry;

					cacheResult(businessEntry);
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
			return (BusinessEntry)result;
		}
	}

	/**
	 * Removes the business entry where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the business entry that was removed
	 */
	@Override
	public BusinessEntry removeByEmail(String email)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = findByEmail(email);

		return remove(businessEntry);
	}

	/**
	 * Returns the number of business entries where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching business entries
	 */
	@Override
	public int countByEmail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByEmail;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUSINESSENTRY_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
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

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 =
		"businessEntry.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(businessEntry.email IS NULL OR businessEntry.email = '')";

	private FinderPath _finderPathFetchByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns the business entry where name = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry findByName(String name)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = fetchByName(name);

		if (businessEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBusinessEntryException(sb.toString());
		}

		return businessEntry;
	}

	/**
	 * Returns the business entry where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the business entry where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByName(String name, boolean useFinderCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByName, finderArgs);
		}

		if (result instanceof BusinessEntry) {
			BusinessEntry businessEntry = (BusinessEntry)result;

			if (!Objects.equals(name, businessEntry.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_BUSINESSENTRY_WHERE);

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

				List<BusinessEntry> list = query.list();

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
								"BusinessEntryPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					BusinessEntry businessEntry = list.get(0);

					result = businessEntry;

					cacheResult(businessEntry);
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
			return (BusinessEntry)result;
		}
	}

	/**
	 * Removes the business entry where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the business entry that was removed
	 */
	@Override
	public BusinessEntry removeByName(String name)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = findByName(name);

		return remove(businessEntry);
	}

	/**
	 * Returns the number of business entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching business entries
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUSINESSENTRY_WHERE);

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
		"businessEntry.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(businessEntry.name IS NULL OR businessEntry.name = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the business entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (businessEntry == null) {
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

			throw new NoSuchBusinessEntryException(sb.toString());
		}

		return businessEntry;
	}

	/**
	 * Returns the business entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the business entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public BusinessEntry fetchByC_ERC(
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

		if (result instanceof BusinessEntry) {
			BusinessEntry businessEntry = (BusinessEntry)result;

			if ((companyId != businessEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					businessEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BUSINESSENTRY_WHERE);

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

				List<BusinessEntry> list = query.list();

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
								"BusinessEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					BusinessEntry businessEntry = list.get(0);

					result = businessEntry;

					cacheResult(businessEntry);
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
			return (BusinessEntry)result;
		}
	}

	/**
	 * Removes the business entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the business entry that was removed
	 */
	@Override
	public BusinessEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(businessEntry);
	}

	/**
	 * Returns the number of business entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching business entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BUSINESSENTRY_WHERE);

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
		"businessEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"businessEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(businessEntry.externalReferenceCode IS NULL OR businessEntry.externalReferenceCode = '')";

	public BusinessEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BusinessEntry.class);

		setModelImplClass(BusinessEntryImpl.class);
		setModelPKClass(long.class);

		setTable(BusinessEntryTable.INSTANCE);
	}

	/**
	 * Caches the business entry in the entity cache if it is enabled.
	 *
	 * @param businessEntry the business entry
	 */
	@Override
	public void cacheResult(BusinessEntry businessEntry) {
		entityCache.putResult(
			BusinessEntryImpl.class, businessEntry.getPrimaryKey(),
			businessEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {businessEntry.getUuid(), businessEntry.getGroupId()},
			businessEntry);

		finderCache.putResult(
			_finderPathFetchByPhone,
			new Object[] {businessEntry.getPhoneNumber()}, businessEntry);

		finderCache.putResult(
			_finderPathFetchByEmail, new Object[] {businessEntry.getEmail()},
			businessEntry);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {businessEntry.getName()},
			businessEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				businessEntry.getCompanyId(),
				businessEntry.getExternalReferenceCode()
			},
			businessEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the business entries in the entity cache if it is enabled.
	 *
	 * @param businessEntries the business entries
	 */
	@Override
	public void cacheResult(List<BusinessEntry> businessEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (businessEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BusinessEntry businessEntry : businessEntries) {
			if (entityCache.getResult(
					BusinessEntryImpl.class, businessEntry.getPrimaryKey()) ==
						null) {

				cacheResult(businessEntry);
			}
		}
	}

	/**
	 * Clears the cache for all business entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BusinessEntryImpl.class);

		finderCache.clearCache(BusinessEntryImpl.class);
	}

	/**
	 * Clears the cache for the business entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BusinessEntry businessEntry) {
		entityCache.removeResult(BusinessEntryImpl.class, businessEntry);
	}

	@Override
	public void clearCache(List<BusinessEntry> businessEntries) {
		for (BusinessEntry businessEntry : businessEntries) {
			entityCache.removeResult(BusinessEntryImpl.class, businessEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BusinessEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BusinessEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BusinessEntryModelImpl businessEntryModelImpl) {

		Object[] args = new Object[] {
			businessEntryModelImpl.getUuid(),
			businessEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, businessEntryModelImpl);

		args = new Object[] {businessEntryModelImpl.getPhoneNumber()};

		finderCache.putResult(_finderPathCountByPhone, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByPhone, args, businessEntryModelImpl);

		args = new Object[] {businessEntryModelImpl.getEmail()};

		finderCache.putResult(_finderPathCountByEmail, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByEmail, args, businessEntryModelImpl);

		args = new Object[] {businessEntryModelImpl.getName()};

		finderCache.putResult(_finderPathCountByName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByName, args, businessEntryModelImpl);

		args = new Object[] {
			businessEntryModelImpl.getCompanyId(),
			businessEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, businessEntryModelImpl);
	}

	/**
	 * Creates a new business entry with the primary key. Does not add the business entry to the database.
	 *
	 * @param businessId the primary key for the new business entry
	 * @return the new business entry
	 */
	@Override
	public BusinessEntry create(long businessId) {
		BusinessEntry businessEntry = new BusinessEntryImpl();

		businessEntry.setNew(true);
		businessEntry.setPrimaryKey(businessId);

		String uuid = PortalUUIDUtil.generate();

		businessEntry.setUuid(uuid);

		businessEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return businessEntry;
	}

	/**
	 * Removes the business entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry that was removed
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	@Override
	public BusinessEntry remove(long businessId)
		throws NoSuchBusinessEntryException {

		return remove((Serializable)businessId);
	}

	/**
	 * Removes the business entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the business entry
	 * @return the business entry that was removed
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	@Override
	public BusinessEntry remove(Serializable primaryKey)
		throws NoSuchBusinessEntryException {

		Session session = null;

		try {
			session = openSession();

			BusinessEntry businessEntry = (BusinessEntry)session.get(
				BusinessEntryImpl.class, primaryKey);

			if (businessEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusinessEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(businessEntry);
		}
		catch (NoSuchBusinessEntryException noSuchEntityException) {
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
	protected BusinessEntry removeImpl(BusinessEntry businessEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(businessEntry)) {
				businessEntry = (BusinessEntry)session.get(
					BusinessEntryImpl.class, businessEntry.getPrimaryKeyObj());
			}

			if (businessEntry != null) {
				session.delete(businessEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (businessEntry != null) {
			clearCache(businessEntry);
		}

		return businessEntry;
	}

	@Override
	public BusinessEntry updateImpl(BusinessEntry businessEntry) {
		boolean isNew = businessEntry.isNew();

		if (!(businessEntry instanceof BusinessEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(businessEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					businessEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in businessEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BusinessEntry implementation " +
					businessEntry.getClass());
		}

		BusinessEntryModelImpl businessEntryModelImpl =
			(BusinessEntryModelImpl)businessEntry;

		if (Validator.isNull(businessEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			businessEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (businessEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				businessEntry.setCreateDate(date);
			}
			else {
				businessEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!businessEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				businessEntry.setModifiedDate(date);
			}
			else {
				businessEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(businessEntry);
			}
			else {
				businessEntry = (BusinessEntry)session.merge(businessEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BusinessEntryImpl.class, businessEntryModelImpl, false, true);

		cacheUniqueFindersCache(businessEntryModelImpl);

		if (isNew) {
			businessEntry.setNew(false);
		}

		businessEntry.resetOriginalValues();

		return businessEntry;
	}

	/**
	 * Returns the business entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the business entry
	 * @return the business entry
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	@Override
	public BusinessEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusinessEntryException {

		BusinessEntry businessEntry = fetchByPrimaryKey(primaryKey);

		if (businessEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusinessEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return businessEntry;
	}

	/**
	 * Returns the business entry with the primary key or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	@Override
	public BusinessEntry findByPrimaryKey(long businessId)
		throws NoSuchBusinessEntryException {

		return findByPrimaryKey((Serializable)businessId);
	}

	/**
	 * Returns the business entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry, or <code>null</code> if a business entry with the primary key could not be found
	 */
	@Override
	public BusinessEntry fetchByPrimaryKey(long businessId) {
		return fetchByPrimaryKey((Serializable)businessId);
	}

	/**
	 * Returns all the business entries.
	 *
	 * @return the business entries
	 */
	@Override
	public List<BusinessEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the business entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @return the range of business entries
	 */
	@Override
	public List<BusinessEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the business entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of business entries
	 */
	@Override
	public List<BusinessEntry> findAll(
		int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the business entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of business entries
	 */
	@Override
	public List<BusinessEntry> findAll(
		int start, int end, OrderByComparator<BusinessEntry> orderByComparator,
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

		List<BusinessEntry> list = null;

		if (useFinderCache) {
			list = (List<BusinessEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BUSINESSENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BUSINESSENTRY;

				sql = sql.concat(BusinessEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BusinessEntry>)QueryUtil.list(
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
	 * Removes all the business entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BusinessEntry businessEntry : findAll()) {
			remove(businessEntry);
		}
	}

	/**
	 * Returns the number of business entries.
	 *
	 * @return the number of business entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BUSINESSENTRY);

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
		return "businessId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BUSINESSENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BusinessEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the business entry persistence.
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

		_finderPathFetchByPhone = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPhone",
			new String[] {String.class.getName()}, new String[] {"phoneNumber"},
			true);

		_finderPathCountByPhone = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhone",
			new String[] {String.class.getName()}, new String[] {"phoneNumber"},
			false);

		_finderPathFetchByEmail = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			true);

		_finderPathCountByEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			false);

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

		_setBusinessEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBusinessEntryUtilPersistence(null);

		entityCache.removeCache(BusinessEntryImpl.class.getName());
	}

	private void _setBusinessEntryUtilPersistence(
		BusinessEntryPersistence businessEntryPersistence) {

		try {
			Field field = BusinessEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, businessEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_BUSINESSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_BUSINESSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_BUSINESSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BUSINESSENTRY =
		"SELECT businessEntry FROM BusinessEntry businessEntry";

	private static final String _SQL_SELECT_BUSINESSENTRY_WHERE =
		"SELECT businessEntry FROM BusinessEntry businessEntry WHERE ";

	private static final String _SQL_COUNT_BUSINESSENTRY =
		"SELECT COUNT(businessEntry) FROM BusinessEntry businessEntry";

	private static final String _SQL_COUNT_BUSINESSENTRY_WHERE =
		"SELECT COUNT(businessEntry) FROM BusinessEntry businessEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "businessEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BusinessEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BusinessEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BusinessEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private BusinessEntryModelArgumentsResolver
		_businessEntryModelArgumentsResolver;

}