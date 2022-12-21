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

package com.swork.notification.service.service.persistence.impl;

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

import com.swork.notification.service.exception.NoSuchNotificationEntryException;
import com.swork.notification.service.model.NotificationEntry;
import com.swork.notification.service.model.NotificationEntryTable;
import com.swork.notification.service.model.impl.NotificationEntryImpl;
import com.swork.notification.service.model.impl.NotificationEntryModelImpl;
import com.swork.notification.service.service.persistence.NotificationEntryPersistence;
import com.swork.notification.service.service.persistence.NotificationEntryUtil;
import com.swork.notification.service.service.persistence.impl.constants.NOTIFICATIONPersistenceConstants;

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
 * The persistence implementation for the notification entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {NotificationEntryPersistence.class, BasePersistence.class}
)
public class NotificationEntryPersistenceImpl
	extends BasePersistenceImpl<NotificationEntry>
	implements NotificationEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NotificationEntryUtil</code> to access the notification entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NotificationEntryImpl.class.getName();

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
	 * Returns all the notification entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notification entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator,
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

		List<NotificationEntry> list = null;

		if (useFinderCache) {
			list = (List<NotificationEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NotificationEntry notificationEntry : list) {
					if (!uuid.equals(notificationEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

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
				sb.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<NotificationEntry>)QueryUtil.list(
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
	 * Returns the first notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByUuid_First(
			String uuid, OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (notificationEntry != null) {
			return notificationEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNotificationEntryException(sb.toString());
	}

	/**
	 * Returns the first notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByUuid_First(
		String uuid, OrderByComparator<NotificationEntry> orderByComparator) {

		List<NotificationEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByUuid_Last(
			String uuid, OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (notificationEntry != null) {
			return notificationEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNotificationEntryException(sb.toString());
	}

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByUuid_Last(
		String uuid, OrderByComparator<NotificationEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<NotificationEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current notification entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	@Override
	public NotificationEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		uuid = Objects.toString(uuid, "");

		NotificationEntry notificationEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NotificationEntry[] array = new NotificationEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, notificationEntry, uuid, orderByComparator, true);

			array[1] = notificationEntry;

			array[2] = getByUuid_PrevAndNext(
				session, notificationEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected NotificationEntry getByUuid_PrevAndNext(
		Session session, NotificationEntry notificationEntry, String uuid,
		OrderByComparator<NotificationEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

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
			sb.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
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
						notificationEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NotificationEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notification entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (NotificationEntry notificationEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(notificationEntry);
		}
	}

	/**
	 * Returns the number of notification entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching notification entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NOTIFICATIONENTRY_WHERE);

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
		"notificationEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(notificationEntry.uuid IS NULL OR notificationEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the notification entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNotificationEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByUUID_G(uuid, groupId);

		if (notificationEntry == null) {
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

			throw new NoSuchNotificationEntryException(sb.toString());
		}

		return notificationEntry;
	}

	/**
	 * Returns the notification entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the notification entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByUUID_G(
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

		if (result instanceof NotificationEntry) {
			NotificationEntry notificationEntry = (NotificationEntry)result;

			if (!Objects.equals(uuid, notificationEntry.getUuid()) ||
				(groupId != notificationEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

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

				List<NotificationEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					NotificationEntry notificationEntry = list.get(0);

					result = notificationEntry;

					cacheResult(notificationEntry);
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
			return (NotificationEntry)result;
		}
	}

	/**
	 * Removes the notification entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the notification entry that was removed
	 */
	@Override
	public NotificationEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = findByUUID_G(uuid, groupId);

		return remove(notificationEntry);
	}

	/**
	 * Returns the number of notification entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching notification entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTIFICATIONENTRY_WHERE);

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
		"notificationEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(notificationEntry.uuid IS NULL OR notificationEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"notificationEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator,
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

		List<NotificationEntry> list = null;

		if (useFinderCache) {
			list = (List<NotificationEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NotificationEntry notificationEntry : list) {
					if (!uuid.equals(notificationEntry.getUuid()) ||
						(companyId != notificationEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

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
				sb.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<NotificationEntry>)QueryUtil.list(
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
	 * Returns the first notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (notificationEntry != null) {
			return notificationEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchNotificationEntryException(sb.toString());
	}

	/**
	 * Returns the first notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<NotificationEntry> orderByComparator) {

		List<NotificationEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (notificationEntry != null) {
			return notificationEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchNotificationEntryException(sb.toString());
	}

	/**
	 * Returns the last notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<NotificationEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<NotificationEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current notification entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	@Override
	public NotificationEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		uuid = Objects.toString(uuid, "");

		NotificationEntry notificationEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NotificationEntry[] array = new NotificationEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, notificationEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = notificationEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, notificationEntry, uuid, companyId, orderByComparator,
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

	protected NotificationEntry getByUuid_C_PrevAndNext(
		Session session, NotificationEntry notificationEntry, String uuid,
		long companyId, OrderByComparator<NotificationEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

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
			sb.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
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
						notificationEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NotificationEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notification entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (NotificationEntry notificationEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(notificationEntry);
		}
	}

	/**
	 * Returns the number of notification entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching notification entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTIFICATIONENTRY_WHERE);

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
		"notificationEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(notificationEntry.uuid IS NULL OR notificationEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"notificationEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByR_V;
	private FinderPath _finderPathWithoutPaginationFindByR_V;
	private FinderPath _finderPathCountByR_V;

	/**
	 * Returns all the notification entries where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @return the matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByR_V(long receiverId) {
		return findByR_V(
			receiverId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification entries where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByR_V(
		long receiverId, int start, int end) {

		return findByR_V(receiverId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification entries where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByR_V(
		long receiverId, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return findByR_V(receiverId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notification entries where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByR_V(
		long receiverId, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByR_V;
				finderArgs = new Object[] {receiverId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByR_V;
			finderArgs = new Object[] {
				receiverId, start, end, orderByComparator
			};
		}

		List<NotificationEntry> list = null;

		if (useFinderCache) {
			list = (List<NotificationEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NotificationEntry notificationEntry : list) {
					if (receiverId != notificationEntry.getReceiverId()) {
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

			sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_R_V_RECEIVERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(receiverId);

				list = (List<NotificationEntry>)QueryUtil.list(
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
	 * Returns the first notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByR_V_First(
			long receiverId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByR_V_First(
			receiverId, orderByComparator);

		if (notificationEntry != null) {
			return notificationEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("receiverId=");
		sb.append(receiverId);

		sb.append("}");

		throw new NoSuchNotificationEntryException(sb.toString());
	}

	/**
	 * Returns the first notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByR_V_First(
		long receiverId,
		OrderByComparator<NotificationEntry> orderByComparator) {

		List<NotificationEntry> list = findByR_V(
			receiverId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByR_V_Last(
			long receiverId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByR_V_Last(
			receiverId, orderByComparator);

		if (notificationEntry != null) {
			return notificationEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("receiverId=");
		sb.append(receiverId);

		sb.append("}");

		throw new NoSuchNotificationEntryException(sb.toString());
	}

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByR_V_Last(
		long receiverId,
		OrderByComparator<NotificationEntry> orderByComparator) {

		int count = countByR_V(receiverId);

		if (count == 0) {
			return null;
		}

		List<NotificationEntry> list = findByR_V(
			receiverId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where receiverId = &#63;.
	 *
	 * @param id the primary key of the current notification entry
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	@Override
	public NotificationEntry[] findByR_V_PrevAndNext(
			long id, long receiverId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NotificationEntry[] array = new NotificationEntryImpl[3];

			array[0] = getByR_V_PrevAndNext(
				session, notificationEntry, receiverId, orderByComparator,
				true);

			array[1] = notificationEntry;

			array[2] = getByR_V_PrevAndNext(
				session, notificationEntry, receiverId, orderByComparator,
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

	protected NotificationEntry getByR_V_PrevAndNext(
		Session session, NotificationEntry notificationEntry, long receiverId,
		OrderByComparator<NotificationEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_R_V_RECEIVERID_2);

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
			sb.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(receiverId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						notificationEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NotificationEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notification entries where receiverId = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 */
	@Override
	public void removeByR_V(long receiverId) {
		for (NotificationEntry notificationEntry :
				findByR_V(
					receiverId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(notificationEntry);
		}
	}

	/**
	 * Returns the number of notification entries where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @return the number of matching notification entries
	 */
	@Override
	public int countByR_V(long receiverId) {
		FinderPath finderPath = _finderPathCountByR_V;

		Object[] finderArgs = new Object[] {receiverId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NOTIFICATIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_R_V_RECEIVERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(receiverId);

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

	private static final String _FINDER_COLUMN_R_V_RECEIVERID_2 =
		"notificationEntry.receiverId = ?";

	private FinderPath _finderPathWithPaginationFindByR_S;
	private FinderPath _finderPathWithoutPaginationFindByR_S;
	private FinderPath _finderPathCountByR_S;

	/**
	 * Returns all the notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @return the matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByR_S(long receiverId, String status) {
		return findByR_S(
			receiverId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByR_S(
		long receiverId, String status, int start, int end) {

		return findByR_S(receiverId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByR_S(
		long receiverId, String status, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return findByR_S(
			receiverId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByR_S(
		long receiverId, String status, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByR_S;
				finderArgs = new Object[] {receiverId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByR_S;
			finderArgs = new Object[] {
				receiverId, status, start, end, orderByComparator
			};
		}

		List<NotificationEntry> list = null;

		if (useFinderCache) {
			list = (List<NotificationEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NotificationEntry notificationEntry : list) {
					if ((receiverId != notificationEntry.getReceiverId()) ||
						!status.equals(notificationEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_R_S_RECEIVERID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_R_S_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_R_S_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(receiverId);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<NotificationEntry>)QueryUtil.list(
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
	 * Returns the first notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByR_S_First(
			long receiverId, String status,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByR_S_First(
			receiverId, status, orderByComparator);

		if (notificationEntry != null) {
			return notificationEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("receiverId=");
		sb.append(receiverId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchNotificationEntryException(sb.toString());
	}

	/**
	 * Returns the first notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByR_S_First(
		long receiverId, String status,
		OrderByComparator<NotificationEntry> orderByComparator) {

		List<NotificationEntry> list = findByR_S(
			receiverId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByR_S_Last(
			long receiverId, String status,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByR_S_Last(
			receiverId, status, orderByComparator);

		if (notificationEntry != null) {
			return notificationEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("receiverId=");
		sb.append(receiverId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchNotificationEntryException(sb.toString());
	}

	/**
	 * Returns the last notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByR_S_Last(
		long receiverId, String status,
		OrderByComparator<NotificationEntry> orderByComparator) {

		int count = countByR_S(receiverId, status);

		if (count == 0) {
			return null;
		}

		List<NotificationEntry> list = findByR_S(
			receiverId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where receiverId = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current notification entry
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	@Override
	public NotificationEntry[] findByR_S_PrevAndNext(
			long id, long receiverId, String status,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		status = Objects.toString(status, "");

		NotificationEntry notificationEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NotificationEntry[] array = new NotificationEntryImpl[3];

			array[0] = getByR_S_PrevAndNext(
				session, notificationEntry, receiverId, status,
				orderByComparator, true);

			array[1] = notificationEntry;

			array[2] = getByR_S_PrevAndNext(
				session, notificationEntry, receiverId, status,
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

	protected NotificationEntry getByR_S_PrevAndNext(
		Session session, NotificationEntry notificationEntry, long receiverId,
		String status, OrderByComparator<NotificationEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_R_S_RECEIVERID_2);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_R_S_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_R_S_STATUS_2);
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
			sb.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(receiverId);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						notificationEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NotificationEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notification entries where receiverId = &#63; and status = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 */
	@Override
	public void removeByR_S(long receiverId, String status) {
		for (NotificationEntry notificationEntry :
				findByR_S(
					receiverId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(notificationEntry);
		}
	}

	/**
	 * Returns the number of notification entries where receiverId = &#63; and status = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param status the status
	 * @return the number of matching notification entries
	 */
	@Override
	public int countByR_S(long receiverId, String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByR_S;

		Object[] finderArgs = new Object[] {receiverId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTIFICATIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_R_S_RECEIVERID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_R_S_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_R_S_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(receiverId);

				if (bindStatus) {
					queryPos.add(status);
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

	private static final String _FINDER_COLUMN_R_S_RECEIVERID_2 =
		"notificationEntry.receiverId = ? AND ";

	private static final String _FINDER_COLUMN_R_S_STATUS_2 =
		"notificationEntry.status = ?";

	private static final String _FINDER_COLUMN_R_S_STATUS_3 =
		"(notificationEntry.status IS NULL OR notificationEntry.status = '')";

	private FinderPath _finderPathWithPaginationFindByS_;
	private FinderPath _finderPathWithoutPaginationFindByS_;
	private FinderPath _finderPathCountByS_;

	/**
	 * Returns all the notification entries where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByS_(long subjectId) {
		return findByS_(subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification entries where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByS_(
		long subjectId, int start, int end) {

		return findByS_(subjectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification entries where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByS_(
		long subjectId, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return findByS_(subjectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notification entries where subjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param subjectId the subject ID
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notification entries
	 */
	@Override
	public List<NotificationEntry> findByS_(
		long subjectId, int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByS_;
				finderArgs = new Object[] {subjectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByS_;
			finderArgs = new Object[] {
				subjectId, start, end, orderByComparator
			};
		}

		List<NotificationEntry> list = null;

		if (useFinderCache) {
			list = (List<NotificationEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NotificationEntry notificationEntry : list) {
					if (subjectId != notificationEntry.getSubjectId()) {
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

			sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_S__SUBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subjectId);

				list = (List<NotificationEntry>)QueryUtil.list(
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
	 * Returns the first notification entry in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByS__First(
			long subjectId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByS__First(
			subjectId, orderByComparator);

		if (notificationEntry != null) {
			return notificationEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchNotificationEntryException(sb.toString());
	}

	/**
	 * Returns the first notification entry in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByS__First(
		long subjectId,
		OrderByComparator<NotificationEntry> orderByComparator) {

		List<NotificationEntry> list = findByS_(
			subjectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification entry in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByS__Last(
			long subjectId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByS__Last(
			subjectId, orderByComparator);

		if (notificationEntry != null) {
			return notificationEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subjectId=");
		sb.append(subjectId);

		sb.append("}");

		throw new NoSuchNotificationEntryException(sb.toString());
	}

	/**
	 * Returns the last notification entry in the ordered set where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByS__Last(
		long subjectId,
		OrderByComparator<NotificationEntry> orderByComparator) {

		int count = countByS_(subjectId);

		if (count == 0) {
			return null;
		}

		List<NotificationEntry> list = findByS_(
			subjectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where subjectId = &#63;.
	 *
	 * @param id the primary key of the current notification entry
	 * @param subjectId the subject ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	@Override
	public NotificationEntry[] findByS__PrevAndNext(
			long id, long subjectId,
			OrderByComparator<NotificationEntry> orderByComparator)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NotificationEntry[] array = new NotificationEntryImpl[3];

			array[0] = getByS__PrevAndNext(
				session, notificationEntry, subjectId, orderByComparator, true);

			array[1] = notificationEntry;

			array[2] = getByS__PrevAndNext(
				session, notificationEntry, subjectId, orderByComparator,
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

	protected NotificationEntry getByS__PrevAndNext(
		Session session, NotificationEntry notificationEntry, long subjectId,
		OrderByComparator<NotificationEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

		sb.append(_FINDER_COLUMN_S__SUBJECTID_2);

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
			sb.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subjectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						notificationEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NotificationEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notification entries where subjectId = &#63; from the database.
	 *
	 * @param subjectId the subject ID
	 */
	@Override
	public void removeByS_(long subjectId) {
		for (NotificationEntry notificationEntry :
				findByS_(
					subjectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(notificationEntry);
		}
	}

	/**
	 * Returns the number of notification entries where subjectId = &#63;.
	 *
	 * @param subjectId the subject ID
	 * @return the number of matching notification entries
	 */
	@Override
	public int countByS_(long subjectId) {
		FinderPath finderPath = _finderPathCountByS_;

		Object[] finderArgs = new Object[] {subjectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NOTIFICATIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_S__SUBJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subjectId);

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

	private static final String _FINDER_COLUMN_S__SUBJECTID_2 =
		"notificationEntry.subjectId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the notification entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchNotificationEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching notification entry
	 * @throws NoSuchNotificationEntryException if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (notificationEntry == null) {
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

			throw new NoSuchNotificationEntryException(sb.toString());
		}

		return notificationEntry;
	}

	/**
	 * Returns the notification entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the notification entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public NotificationEntry fetchByC_ERC(
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

		if (result instanceof NotificationEntry) {
			NotificationEntry notificationEntry = (NotificationEntry)result;

			if ((companyId != notificationEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					notificationEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

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

				List<NotificationEntry> list = query.list();

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
								"NotificationEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					NotificationEntry notificationEntry = list.get(0);

					result = notificationEntry;

					cacheResult(notificationEntry);
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
			return (NotificationEntry)result;
		}
	}

	/**
	 * Removes the notification entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the notification entry that was removed
	 */
	@Override
	public NotificationEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(notificationEntry);
	}

	/**
	 * Returns the number of notification entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching notification entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTIFICATIONENTRY_WHERE);

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
		"notificationEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"notificationEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(notificationEntry.externalReferenceCode IS NULL OR notificationEntry.externalReferenceCode = '')";

	public NotificationEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(NotificationEntry.class);

		setModelImplClass(NotificationEntryImpl.class);
		setModelPKClass(long.class);

		setTable(NotificationEntryTable.INSTANCE);
	}

	/**
	 * Caches the notification entry in the entity cache if it is enabled.
	 *
	 * @param notificationEntry the notification entry
	 */
	@Override
	public void cacheResult(NotificationEntry notificationEntry) {
		entityCache.putResult(
			NotificationEntryImpl.class, notificationEntry.getPrimaryKey(),
			notificationEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				notificationEntry.getUuid(), notificationEntry.getGroupId()
			},
			notificationEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				notificationEntry.getCompanyId(),
				notificationEntry.getExternalReferenceCode()
			},
			notificationEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the notification entries in the entity cache if it is enabled.
	 *
	 * @param notificationEntries the notification entries
	 */
	@Override
	public void cacheResult(List<NotificationEntry> notificationEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (notificationEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (NotificationEntry notificationEntry : notificationEntries) {
			if (entityCache.getResult(
					NotificationEntryImpl.class,
					notificationEntry.getPrimaryKey()) == null) {

				cacheResult(notificationEntry);
			}
		}
	}

	/**
	 * Clears the cache for all notification entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NotificationEntryImpl.class);

		finderCache.clearCache(NotificationEntryImpl.class);
	}

	/**
	 * Clears the cache for the notification entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NotificationEntry notificationEntry) {
		entityCache.removeResult(
			NotificationEntryImpl.class, notificationEntry);
	}

	@Override
	public void clearCache(List<NotificationEntry> notificationEntries) {
		for (NotificationEntry notificationEntry : notificationEntries) {
			entityCache.removeResult(
				NotificationEntryImpl.class, notificationEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(NotificationEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(NotificationEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		NotificationEntryModelImpl notificationEntryModelImpl) {

		Object[] args = new Object[] {
			notificationEntryModelImpl.getUuid(),
			notificationEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, notificationEntryModelImpl);

		args = new Object[] {
			notificationEntryModelImpl.getCompanyId(),
			notificationEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, notificationEntryModelImpl);
	}

	/**
	 * Creates a new notification entry with the primary key. Does not add the notification entry to the database.
	 *
	 * @param id the primary key for the new notification entry
	 * @return the new notification entry
	 */
	@Override
	public NotificationEntry create(long id) {
		NotificationEntry notificationEntry = new NotificationEntryImpl();

		notificationEntry.setNew(true);
		notificationEntry.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		notificationEntry.setUuid(uuid);

		notificationEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return notificationEntry;
	}

	/**
	 * Removes the notification entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry that was removed
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	@Override
	public NotificationEntry remove(long id)
		throws NoSuchNotificationEntryException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the notification entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notification entry
	 * @return the notification entry that was removed
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	@Override
	public NotificationEntry remove(Serializable primaryKey)
		throws NoSuchNotificationEntryException {

		Session session = null;

		try {
			session = openSession();

			NotificationEntry notificationEntry =
				(NotificationEntry)session.get(
					NotificationEntryImpl.class, primaryKey);

			if (notificationEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificationEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(notificationEntry);
		}
		catch (NoSuchNotificationEntryException noSuchEntityException) {
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
	protected NotificationEntry removeImpl(
		NotificationEntry notificationEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notificationEntry)) {
				notificationEntry = (NotificationEntry)session.get(
					NotificationEntryImpl.class,
					notificationEntry.getPrimaryKeyObj());
			}

			if (notificationEntry != null) {
				session.delete(notificationEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (notificationEntry != null) {
			clearCache(notificationEntry);
		}

		return notificationEntry;
	}

	@Override
	public NotificationEntry updateImpl(NotificationEntry notificationEntry) {
		boolean isNew = notificationEntry.isNew();

		if (!(notificationEntry instanceof NotificationEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(notificationEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					notificationEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in notificationEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom NotificationEntry implementation " +
					notificationEntry.getClass());
		}

		NotificationEntryModelImpl notificationEntryModelImpl =
			(NotificationEntryModelImpl)notificationEntry;

		if (Validator.isNull(notificationEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			notificationEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (notificationEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				notificationEntry.setCreateDate(date);
			}
			else {
				notificationEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!notificationEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				notificationEntry.setModifiedDate(date);
			}
			else {
				notificationEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(notificationEntry);
			}
			else {
				notificationEntry = (NotificationEntry)session.merge(
					notificationEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			NotificationEntryImpl.class, notificationEntryModelImpl, false,
			true);

		cacheUniqueFindersCache(notificationEntryModelImpl);

		if (isNew) {
			notificationEntry.setNew(false);
		}

		notificationEntry.resetOriginalValues();

		return notificationEntry;
	}

	/**
	 * Returns the notification entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification entry
	 * @return the notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	@Override
	public NotificationEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotificationEntryException {

		NotificationEntry notificationEntry = fetchByPrimaryKey(primaryKey);

		if (notificationEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotificationEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return notificationEntry;
	}

	/**
	 * Returns the notification entry with the primary key or throws a <code>NoSuchNotificationEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry
	 * @throws NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 */
	@Override
	public NotificationEntry findByPrimaryKey(long id)
		throws NoSuchNotificationEntryException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the notification entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry, or <code>null</code> if a notification entry with the primary key could not be found
	 */
	@Override
	public NotificationEntry fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the notification entries.
	 *
	 * @return the notification entries
	 */
	@Override
	public List<NotificationEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of notification entries
	 */
	@Override
	public List<NotificationEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notification entries
	 */
	@Override
	public List<NotificationEntry> findAll(
		int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notification entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of notification entries
	 */
	@Override
	public List<NotificationEntry> findAll(
		int start, int end,
		OrderByComparator<NotificationEntry> orderByComparator,
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

		List<NotificationEntry> list = null;

		if (useFinderCache) {
			list = (List<NotificationEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NOTIFICATIONENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICATIONENTRY;

				sql = sql.concat(NotificationEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<NotificationEntry>)QueryUtil.list(
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
	 * Removes all the notification entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NotificationEntry notificationEntry : findAll()) {
			remove(notificationEntry);
		}
	}

	/**
	 * Returns the number of notification entries.
	 *
	 * @return the number of notification entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NOTIFICATIONENTRY);

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
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_NOTIFICATIONENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NotificationEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the notification entry persistence.
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

		_finderPathWithPaginationFindByR_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_V",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"receiverId"}, true);

		_finderPathWithoutPaginationFindByR_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_V",
			new String[] {Long.class.getName()}, new String[] {"receiverId"},
			true);

		_finderPathCountByR_V = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_V",
			new String[] {Long.class.getName()}, new String[] {"receiverId"},
			false);

		_finderPathWithPaginationFindByR_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"receiverId", "status"}, true);

		_finderPathWithoutPaginationFindByR_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_S",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"receiverId", "status"}, true);

		_finderPathCountByR_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_S",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"receiverId", "status"}, false);

		_finderPathWithPaginationFindByS_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"subjectId"}, true);

		_finderPathWithoutPaginationFindByS_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_",
			new String[] {Long.class.getName()}, new String[] {"subjectId"},
			true);

		_finderPathCountByS_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_",
			new String[] {Long.class.getName()}, new String[] {"subjectId"},
			false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setNotificationEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNotificationEntryUtilPersistence(null);

		entityCache.removeCache(NotificationEntryImpl.class.getName());
	}

	private void _setNotificationEntryUtilPersistence(
		NotificationEntryPersistence notificationEntryPersistence) {

		try {
			Field field = NotificationEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, notificationEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = NOTIFICATIONPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = NOTIFICATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = NOTIFICATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_NOTIFICATIONENTRY =
		"SELECT notificationEntry FROM NotificationEntry notificationEntry";

	private static final String _SQL_SELECT_NOTIFICATIONENTRY_WHERE =
		"SELECT notificationEntry FROM NotificationEntry notificationEntry WHERE ";

	private static final String _SQL_COUNT_NOTIFICATIONENTRY =
		"SELECT COUNT(notificationEntry) FROM NotificationEntry notificationEntry";

	private static final String _SQL_COUNT_NOTIFICATIONENTRY_WHERE =
		"SELECT COUNT(notificationEntry) FROM NotificationEntry notificationEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "notificationEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No NotificationEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No NotificationEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NotificationEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private NotificationEntryModelArgumentsResolver
		_notificationEntryModelArgumentsResolver;

}