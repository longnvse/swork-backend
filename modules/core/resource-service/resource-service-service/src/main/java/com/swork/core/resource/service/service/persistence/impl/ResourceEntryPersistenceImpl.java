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

import com.swork.core.resource.service.exception.NoSuchResourceEntryException;
import com.swork.core.resource.service.model.ResourceEntry;
import com.swork.core.resource.service.model.ResourceEntryTable;
import com.swork.core.resource.service.model.impl.ResourceEntryImpl;
import com.swork.core.resource.service.model.impl.ResourceEntryModelImpl;
import com.swork.core.resource.service.service.persistence.ResourceEntryPersistence;
import com.swork.core.resource.service.service.persistence.ResourceEntryUtil;
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
 * The persistence implementation for the resource entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ResourceEntryPersistence.class, BasePersistence.class})
public class ResourceEntryPersistenceImpl
	extends BasePersistenceImpl<ResourceEntry>
	implements ResourceEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ResourceEntryUtil</code> to access the resource entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ResourceEntryImpl.class.getName();

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
	 * Returns all the resource entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
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

		List<ResourceEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceEntry resourceEntry : list) {
					if (!uuid.equals(resourceEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

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
				sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ResourceEntry>)QueryUtil.list(
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
	 * Returns the first resource entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByUuid_First(
			String uuid, OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the first resource entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByUuid_First(
		String uuid, OrderByComparator<ResourceEntry> orderByComparator) {

		List<ResourceEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByUuid_Last(
			String uuid, OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the last resource entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ResourceEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ResourceEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where uuid = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry[] findByUuid_PrevAndNext(
			long resourceId, String uuid,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		uuid = Objects.toString(uuid, "");

		ResourceEntry resourceEntry = findByPrimaryKey(resourceId);

		Session session = null;

		try {
			session = openSession();

			ResourceEntry[] array = new ResourceEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, resourceEntry, uuid, orderByComparator, true);

			array[1] = resourceEntry;

			array[2] = getByUuid_PrevAndNext(
				session, resourceEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ResourceEntry getByUuid_PrevAndNext(
		Session session, ResourceEntry resourceEntry, String uuid,
		OrderByComparator<ResourceEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

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
			sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
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
						resourceEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ResourceEntry resourceEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(resourceEntry);
		}
	}

	/**
	 * Returns the number of resource entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching resource entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RESOURCEENTRY_WHERE);

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
		"resourceEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(resourceEntry.uuid IS NULL OR resourceEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the resource entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchResourceEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByUUID_G(uuid, groupId);

		if (resourceEntry == null) {
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

			throw new NoSuchResourceEntryException(sb.toString());
		}

		return resourceEntry;
	}

	/**
	 * Returns the resource entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the resource entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByUUID_G(
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

		if (result instanceof ResourceEntry) {
			ResourceEntry resourceEntry = (ResourceEntry)result;

			if (!Objects.equals(uuid, resourceEntry.getUuid()) ||
				(groupId != resourceEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

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

				List<ResourceEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ResourceEntry resourceEntry = list.get(0);

					result = resourceEntry;

					cacheResult(resourceEntry);
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
			return (ResourceEntry)result;
		}
	}

	/**
	 * Removes the resource entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the resource entry that was removed
	 */
	@Override
	public ResourceEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = findByUUID_G(uuid, groupId);

		return remove(resourceEntry);
	}

	/**
	 * Returns the number of resource entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching resource entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCEENTRY_WHERE);

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
		"resourceEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(resourceEntry.uuid IS NULL OR resourceEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"resourceEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the resource entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
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

		List<ResourceEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceEntry resourceEntry : list) {
					if (!uuid.equals(resourceEntry.getUuid()) ||
						(companyId != resourceEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

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
				sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ResourceEntry>)QueryUtil.list(
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
	 * Returns the first resource entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the first resource entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		List<ResourceEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the last resource entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ResourceEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry[] findByUuid_C_PrevAndNext(
			long resourceId, String uuid, long companyId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		uuid = Objects.toString(uuid, "");

		ResourceEntry resourceEntry = findByPrimaryKey(resourceId);

		Session session = null;

		try {
			session = openSession();

			ResourceEntry[] array = new ResourceEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, resourceEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = resourceEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, resourceEntry, uuid, companyId, orderByComparator,
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

	protected ResourceEntry getByUuid_C_PrevAndNext(
		Session session, ResourceEntry resourceEntry, String uuid,
		long companyId, OrderByComparator<ResourceEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

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
			sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
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
						resourceEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ResourceEntry resourceEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(resourceEntry);
		}
	}

	/**
	 * Returns the number of resource entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching resource entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCEENTRY_WHERE);

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
		"resourceEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(resourceEntry.uuid IS NULL OR resourceEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"resourceEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByB_W;
	private FinderPath _finderPathWithoutPaginationFindByB_W;
	private FinderPath _finderPathCountByB_W;

	/**
	 * Returns all the resource entries where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @return the matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_W(long businessId, Long workId) {
		return findByB_W(
			businessId, workId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_W(
		long businessId, Long workId, int start, int end) {

		return findByB_W(businessId, workId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_W(
		long businessId, Long workId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return findByB_W(
			businessId, workId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_W(
		long businessId, Long workId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_W;
				finderArgs = new Object[] {businessId, workId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_W;
			finderArgs = new Object[] {
				businessId, workId, start, end, orderByComparator
			};
		}

		List<ResourceEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceEntry resourceEntry : list) {
					if ((businessId != resourceEntry.getBusinessId()) ||
						!Objects.equals(workId, resourceEntry.getWorkId())) {

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

			sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_W_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_W_WORKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(workId.longValue());

				list = (List<ResourceEntry>)QueryUtil.list(
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
	 * Returns the first resource entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByB_W_First(
			long businessId, Long workId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByB_W_First(
			businessId, workId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", workId=");
		sb.append(workId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByB_W_First(
		long businessId, Long workId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		List<ResourceEntry> list = findByB_W(
			businessId, workId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByB_W_Last(
			long businessId, Long workId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByB_W_Last(
			businessId, workId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", workId=");
		sb.append(workId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByB_W_Last(
		long businessId, Long workId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		int count = countByB_W(businessId, workId);

		if (count == 0) {
			return null;
		}

		List<ResourceEntry> list = findByB_W(
			businessId, workId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry[] findByB_W_PrevAndNext(
			long resourceId, long businessId, Long workId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = findByPrimaryKey(resourceId);

		Session session = null;

		try {
			session = openSession();

			ResourceEntry[] array = new ResourceEntryImpl[3];

			array[0] = getByB_W_PrevAndNext(
				session, resourceEntry, businessId, workId, orderByComparator,
				true);

			array[1] = resourceEntry;

			array[2] = getByB_W_PrevAndNext(
				session, resourceEntry, businessId, workId, orderByComparator,
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

	protected ResourceEntry getByB_W_PrevAndNext(
		Session session, ResourceEntry resourceEntry, long businessId,
		Long workId, OrderByComparator<ResourceEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_B_W_BUSINESSID_2);

		sb.append(_FINDER_COLUMN_B_W_WORKID_2);

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
			sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessId);

		queryPos.add(workId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						resourceEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource entries where businessId = &#63; and workId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 */
	@Override
	public void removeByB_W(long businessId, Long workId) {
		for (ResourceEntry resourceEntry :
				findByB_W(
					businessId, workId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(resourceEntry);
		}
	}

	/**
	 * Returns the number of resource entries where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @return the number of matching resource entries
	 */
	@Override
	public int countByB_W(long businessId, Long workId) {
		FinderPath finderPath = _finderPathCountByB_W;

		Object[] finderArgs = new Object[] {businessId, workId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_W_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_W_WORKID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(workId.longValue());

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

	private static final String _FINDER_COLUMN_B_W_BUSINESSID_2 =
		"resourceEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_W_WORKID_2 =
		"resourceEntry.workId = ?";

	private FinderPath _finderPathWithPaginationFindByB_PH;
	private FinderPath _finderPathWithoutPaginationFindByB_PH;
	private FinderPath _finderPathCountByB_PH;

	/**
	 * Returns all the resource entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_PH(long businessId, Long phaseId) {
		return findByB_PH(
			businessId, phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end) {

		return findByB_PH(businessId, phaseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return findByB_PH(
			businessId, phaseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
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

		List<ResourceEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceEntry resourceEntry : list) {
					if ((businessId != resourceEntry.getBusinessId()) ||
						!Objects.equals(phaseId, resourceEntry.getPhaseId())) {

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

			sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_PH_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PH_PHASEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(phaseId.longValue());

				list = (List<ResourceEntry>)QueryUtil.list(
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
	 * Returns the first resource entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByB_PH_First(
			long businessId, Long phaseId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByB_PH_First(
			businessId, phaseId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByB_PH_First(
		long businessId, Long phaseId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		List<ResourceEntry> list = findByB_PH(
			businessId, phaseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByB_PH_Last(
			long businessId, Long phaseId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByB_PH_Last(
			businessId, phaseId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByB_PH_Last(
		long businessId, Long phaseId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		int count = countByB_PH(businessId, phaseId);

		if (count == 0) {
			return null;
		}

		List<ResourceEntry> list = findByB_PH(
			businessId, phaseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry[] findByB_PH_PrevAndNext(
			long resourceId, long businessId, Long phaseId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = findByPrimaryKey(resourceId);

		Session session = null;

		try {
			session = openSession();

			ResourceEntry[] array = new ResourceEntryImpl[3];

			array[0] = getByB_PH_PrevAndNext(
				session, resourceEntry, businessId, phaseId, orderByComparator,
				true);

			array[1] = resourceEntry;

			array[2] = getByB_PH_PrevAndNext(
				session, resourceEntry, businessId, phaseId, orderByComparator,
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

	protected ResourceEntry getByB_PH_PrevAndNext(
		Session session, ResourceEntry resourceEntry, long businessId,
		Long phaseId, OrderByComparator<ResourceEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

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
			sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						resourceEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource entries where businessId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 */
	@Override
	public void removeByB_PH(long businessId, Long phaseId) {
		for (ResourceEntry resourceEntry :
				findByB_PH(
					businessId, phaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(resourceEntry);
		}
	}

	/**
	 * Returns the number of resource entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the number of matching resource entries
	 */
	@Override
	public int countByB_PH(long businessId, Long phaseId) {
		FinderPath finderPath = _finderPathCountByB_PH;

		Object[] finderArgs = new Object[] {businessId, phaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCEENTRY_WHERE);

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
		"resourceEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_PH_PHASEID_2 =
		"resourceEntry.phaseId = ?";

	private FinderPath _finderPathWithPaginationFindByB_P;
	private FinderPath _finderPathWithoutPaginationFindByB_P;
	private FinderPath _finderPathCountByB_P;

	/**
	 * Returns all the resource entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_P(long businessId, Long projectId) {
		return findByB_P(
			businessId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_P(
		long businessId, Long projectId, int start, int end) {

		return findByB_P(businessId, projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return findByB_P(
			businessId, projectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
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

		List<ResourceEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceEntry resourceEntry : list) {
					if ((businessId != resourceEntry.getBusinessId()) ||
						!Objects.equals(
							projectId, resourceEntry.getProjectId())) {

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

			sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_P_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_P_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(projectId.longValue());

				list = (List<ResourceEntry>)QueryUtil.list(
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
	 * Returns the first resource entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByB_P_First(
			long businessId, Long projectId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByB_P_First(
			businessId, projectId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByB_P_First(
		long businessId, Long projectId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		List<ResourceEntry> list = findByB_P(
			businessId, projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByB_P_Last(
			long businessId, Long projectId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByB_P_Last(
			businessId, projectId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByB_P_Last(
		long businessId, Long projectId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		int count = countByB_P(businessId, projectId);

		if (count == 0) {
			return null;
		}

		List<ResourceEntry> list = findByB_P(
			businessId, projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry[] findByB_P_PrevAndNext(
			long resourceId, long businessId, Long projectId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = findByPrimaryKey(resourceId);

		Session session = null;

		try {
			session = openSession();

			ResourceEntry[] array = new ResourceEntryImpl[3];

			array[0] = getByB_P_PrevAndNext(
				session, resourceEntry, businessId, projectId,
				orderByComparator, true);

			array[1] = resourceEntry;

			array[2] = getByB_P_PrevAndNext(
				session, resourceEntry, businessId, projectId,
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

	protected ResourceEntry getByB_P_PrevAndNext(
		Session session, ResourceEntry resourceEntry, long businessId,
		Long projectId, OrderByComparator<ResourceEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

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
			sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						resourceEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	@Override
	public void removeByB_P(long businessId, Long projectId) {
		for (ResourceEntry resourceEntry :
				findByB_P(
					businessId, projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(resourceEntry);
		}
	}

	/**
	 * Returns the number of resource entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching resource entries
	 */
	@Override
	public int countByB_P(long businessId, Long projectId) {
		FinderPath finderPath = _finderPathCountByB_P;

		Object[] finderArgs = new Object[] {businessId, projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCEENTRY_WHERE);

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
		"resourceEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_P_PROJECTID_2 =
		"resourceEntry.projectId = ?";

	private FinderPath _finderPathWithPaginationFindByB_Team;
	private FinderPath _finderPathWithoutPaginationFindByB_Team;
	private FinderPath _finderPathCountByB_Team;

	/**
	 * Returns all the resource entries where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @return the matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_Team(long businessId, long teamId) {
		return findByB_Team(
			businessId, teamId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource entries where businessId = &#63; and teamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_Team(
		long businessId, long teamId, int start, int end) {

		return findByB_Team(businessId, teamId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and teamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_Team(
		long businessId, long teamId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return findByB_Team(
			businessId, teamId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and teamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_Team(
		long businessId, long teamId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_Team;
				finderArgs = new Object[] {businessId, teamId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_Team;
			finderArgs = new Object[] {
				businessId, teamId, start, end, orderByComparator
			};
		}

		List<ResourceEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceEntry resourceEntry : list) {
					if ((businessId != resourceEntry.getBusinessId()) ||
						(teamId != resourceEntry.getTeamId())) {

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

			sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_TEAM_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_TEAM_TEAMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(teamId);

				list = (List<ResourceEntry>)QueryUtil.list(
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
	 * Returns the first resource entry in the ordered set where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByB_Team_First(
			long businessId, long teamId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByB_Team_First(
			businessId, teamId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", teamId=");
		sb.append(teamId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByB_Team_First(
		long businessId, long teamId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		List<ResourceEntry> list = findByB_Team(
			businessId, teamId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByB_Team_Last(
			long businessId, long teamId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByB_Team_Last(
			businessId, teamId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", teamId=");
		sb.append(teamId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByB_Team_Last(
		long businessId, long teamId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		int count = countByB_Team(businessId, teamId);

		if (count == 0) {
			return null;
		}

		List<ResourceEntry> list = findByB_Team(
			businessId, teamId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where businessId = &#63; and teamId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry[] findByB_Team_PrevAndNext(
			long resourceId, long businessId, long teamId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = findByPrimaryKey(resourceId);

		Session session = null;

		try {
			session = openSession();

			ResourceEntry[] array = new ResourceEntryImpl[3];

			array[0] = getByB_Team_PrevAndNext(
				session, resourceEntry, businessId, teamId, orderByComparator,
				true);

			array[1] = resourceEntry;

			array[2] = getByB_Team_PrevAndNext(
				session, resourceEntry, businessId, teamId, orderByComparator,
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

	protected ResourceEntry getByB_Team_PrevAndNext(
		Session session, ResourceEntry resourceEntry, long businessId,
		long teamId, OrderByComparator<ResourceEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_B_TEAM_BUSINESSID_2);

		sb.append(_FINDER_COLUMN_B_TEAM_TEAMID_2);

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
			sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessId);

		queryPos.add(teamId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						resourceEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource entries where businessId = &#63; and teamId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 */
	@Override
	public void removeByB_Team(long businessId, long teamId) {
		for (ResourceEntry resourceEntry :
				findByB_Team(
					businessId, teamId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(resourceEntry);
		}
	}

	/**
	 * Returns the number of resource entries where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @return the number of matching resource entries
	 */
	@Override
	public int countByB_Team(long businessId, long teamId) {
		FinderPath finderPath = _finderPathCountByB_Team;

		Object[] finderArgs = new Object[] {businessId, teamId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_TEAM_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_TEAM_TEAMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(teamId);

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

	private static final String _FINDER_COLUMN_B_TEAM_BUSINESSID_2 =
		"resourceEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_TEAM_TEAMID_2 =
		"resourceEntry.teamId = ?";

	private FinderPath _finderPathWithPaginationFindByB_W_PH_P;
	private FinderPath _finderPathWithoutPaginationFindByB_W_PH_P;
	private FinderPath _finderPathCountByB_W_PH_P;

	/**
	 * Returns all the resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @return the matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId) {

		return findByB_W_PH_P(
			businessId, workId, phaseId, projectId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId, int start,
		int end) {

		return findByB_W_PH_P(
			businessId, workId, phaseId, projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId, int start,
		int end, OrderByComparator<ResourceEntry> orderByComparator) {

		return findByB_W_PH_P(
			businessId, workId, phaseId, projectId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	@Override
	public List<ResourceEntry> findByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId, int start,
		int end, OrderByComparator<ResourceEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_W_PH_P;
				finderArgs = new Object[] {
					businessId, workId, phaseId, projectId
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_W_PH_P;
			finderArgs = new Object[] {
				businessId, workId, phaseId, projectId, start, end,
				orderByComparator
			};
		}

		List<ResourceEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceEntry resourceEntry : list) {
					if ((businessId != resourceEntry.getBusinessId()) ||
						!Objects.equals(workId, resourceEntry.getWorkId()) ||
						!Objects.equals(phaseId, resourceEntry.getPhaseId()) ||
						!Objects.equals(
							projectId, resourceEntry.getProjectId())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_W_PH_P_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_W_PH_P_WORKID_2);

			sb.append(_FINDER_COLUMN_B_W_PH_P_PHASEID_2);

			sb.append(_FINDER_COLUMN_B_W_PH_P_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(workId.longValue());

				queryPos.add(phaseId.longValue());

				queryPos.add(projectId.longValue());

				list = (List<ResourceEntry>)QueryUtil.list(
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
	 * Returns the first resource entry in the ordered set where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByB_W_PH_P_First(
			long businessId, Long workId, Long phaseId, Long projectId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByB_W_PH_P_First(
			businessId, workId, phaseId, projectId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", workId=");
		sb.append(workId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByB_W_PH_P_First(
		long businessId, Long workId, Long phaseId, Long projectId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		List<ResourceEntry> list = findByB_W_PH_P(
			businessId, workId, phaseId, projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByB_W_PH_P_Last(
			long businessId, Long workId, Long phaseId, Long projectId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByB_W_PH_P_Last(
			businessId, workId, phaseId, projectId, orderByComparator);

		if (resourceEntry != null) {
			return resourceEntry;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", workId=");
		sb.append(workId);

		sb.append(", phaseId=");
		sb.append(phaseId);

		sb.append(", projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchResourceEntryException(sb.toString());
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByB_W_PH_P_Last(
		long businessId, Long workId, Long phaseId, Long projectId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		int count = countByB_W_PH_P(businessId, workId, phaseId, projectId);

		if (count == 0) {
			return null;
		}

		List<ResourceEntry> list = findByB_W_PH_P(
			businessId, workId, phaseId, projectId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry[] findByB_W_PH_P_PrevAndNext(
			long resourceId, long businessId, Long workId, Long phaseId,
			Long projectId, OrderByComparator<ResourceEntry> orderByComparator)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = findByPrimaryKey(resourceId);

		Session session = null;

		try {
			session = openSession();

			ResourceEntry[] array = new ResourceEntryImpl[3];

			array[0] = getByB_W_PH_P_PrevAndNext(
				session, resourceEntry, businessId, workId, phaseId, projectId,
				orderByComparator, true);

			array[1] = resourceEntry;

			array[2] = getByB_W_PH_P_PrevAndNext(
				session, resourceEntry, businessId, workId, phaseId, projectId,
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

	protected ResourceEntry getByB_W_PH_P_PrevAndNext(
		Session session, ResourceEntry resourceEntry, long businessId,
		Long workId, Long phaseId, Long projectId,
		OrderByComparator<ResourceEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_B_W_PH_P_BUSINESSID_2);

		sb.append(_FINDER_COLUMN_B_W_PH_P_WORKID_2);

		sb.append(_FINDER_COLUMN_B_W_PH_P_PHASEID_2);

		sb.append(_FINDER_COLUMN_B_W_PH_P_PROJECTID_2);

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
			sb.append(ResourceEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessId);

		queryPos.add(workId.longValue());

		queryPos.add(phaseId.longValue());

		queryPos.add(projectId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						resourceEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 */
	@Override
	public void removeByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId) {

		for (ResourceEntry resourceEntry :
				findByB_W_PH_P(
					businessId, workId, phaseId, projectId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(resourceEntry);
		}
	}

	/**
	 * Returns the number of resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @return the number of matching resource entries
	 */
	@Override
	public int countByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId) {

		FinderPath finderPath = _finderPathCountByB_W_PH_P;

		Object[] finderArgs = new Object[] {
			businessId, workId, phaseId, projectId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_RESOURCEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_W_PH_P_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_W_PH_P_WORKID_2);

			sb.append(_FINDER_COLUMN_B_W_PH_P_PHASEID_2);

			sb.append(_FINDER_COLUMN_B_W_PH_P_PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(workId.longValue());

				queryPos.add(phaseId.longValue());

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

	private static final String _FINDER_COLUMN_B_W_PH_P_BUSINESSID_2 =
		"resourceEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_W_PH_P_WORKID_2 =
		"resourceEntry.workId = ? AND ";

	private static final String _FINDER_COLUMN_B_W_PH_P_PHASEID_2 =
		"resourceEntry.phaseId = ? AND ";

	private static final String _FINDER_COLUMN_B_W_PH_P_PROJECTID_2 =
		"resourceEntry.projectId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the resource entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchResourceEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (resourceEntry == null) {
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

			throw new NoSuchResourceEntryException(sb.toString());
		}

		return resourceEntry;
	}

	/**
	 * Returns the resource entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the resource entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchByC_ERC(
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

		if (result instanceof ResourceEntry) {
			ResourceEntry resourceEntry = (ResourceEntry)result;

			if ((companyId != resourceEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					resourceEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RESOURCEENTRY_WHERE);

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

				List<ResourceEntry> list = query.list();

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
								"ResourceEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ResourceEntry resourceEntry = list.get(0);

					result = resourceEntry;

					cacheResult(resourceEntry);
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
			return (ResourceEntry)result;
		}
	}

	/**
	 * Removes the resource entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the resource entry that was removed
	 */
	@Override
	public ResourceEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(resourceEntry);
	}

	/**
	 * Returns the number of resource entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching resource entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCEENTRY_WHERE);

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
		"resourceEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"resourceEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(resourceEntry.externalReferenceCode IS NULL OR resourceEntry.externalReferenceCode = '')";

	public ResourceEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ResourceEntry.class);

		setModelImplClass(ResourceEntryImpl.class);
		setModelPKClass(long.class);

		setTable(ResourceEntryTable.INSTANCE);
	}

	/**
	 * Caches the resource entry in the entity cache if it is enabled.
	 *
	 * @param resourceEntry the resource entry
	 */
	@Override
	public void cacheResult(ResourceEntry resourceEntry) {
		entityCache.putResult(
			ResourceEntryImpl.class, resourceEntry.getPrimaryKey(),
			resourceEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {resourceEntry.getUuid(), resourceEntry.getGroupId()},
			resourceEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				resourceEntry.getCompanyId(),
				resourceEntry.getExternalReferenceCode()
			},
			resourceEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the resource entries in the entity cache if it is enabled.
	 *
	 * @param resourceEntries the resource entries
	 */
	@Override
	public void cacheResult(List<ResourceEntry> resourceEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (resourceEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ResourceEntry resourceEntry : resourceEntries) {
			if (entityCache.getResult(
					ResourceEntryImpl.class, resourceEntry.getPrimaryKey()) ==
						null) {

				cacheResult(resourceEntry);
			}
		}
	}

	/**
	 * Clears the cache for all resource entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ResourceEntryImpl.class);

		finderCache.clearCache(ResourceEntryImpl.class);
	}

	/**
	 * Clears the cache for the resource entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ResourceEntry resourceEntry) {
		entityCache.removeResult(ResourceEntryImpl.class, resourceEntry);
	}

	@Override
	public void clearCache(List<ResourceEntry> resourceEntries) {
		for (ResourceEntry resourceEntry : resourceEntries) {
			entityCache.removeResult(ResourceEntryImpl.class, resourceEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ResourceEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ResourceEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ResourceEntryModelImpl resourceEntryModelImpl) {

		Object[] args = new Object[] {
			resourceEntryModelImpl.getUuid(),
			resourceEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, resourceEntryModelImpl);

		args = new Object[] {
			resourceEntryModelImpl.getCompanyId(),
			resourceEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, resourceEntryModelImpl);
	}

	/**
	 * Creates a new resource entry with the primary key. Does not add the resource entry to the database.
	 *
	 * @param resourceId the primary key for the new resource entry
	 * @return the new resource entry
	 */
	@Override
	public ResourceEntry create(long resourceId) {
		ResourceEntry resourceEntry = new ResourceEntryImpl();

		resourceEntry.setNew(true);
		resourceEntry.setPrimaryKey(resourceId);

		String uuid = PortalUUIDUtil.generate();

		resourceEntry.setUuid(uuid);

		resourceEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return resourceEntry;
	}

	/**
	 * Removes the resource entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry that was removed
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry remove(long resourceId)
		throws NoSuchResourceEntryException {

		return remove((Serializable)resourceId);
	}

	/**
	 * Removes the resource entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resource entry
	 * @return the resource entry that was removed
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry remove(Serializable primaryKey)
		throws NoSuchResourceEntryException {

		Session session = null;

		try {
			session = openSession();

			ResourceEntry resourceEntry = (ResourceEntry)session.get(
				ResourceEntryImpl.class, primaryKey);

			if (resourceEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResourceEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(resourceEntry);
		}
		catch (NoSuchResourceEntryException noSuchEntityException) {
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
	protected ResourceEntry removeImpl(ResourceEntry resourceEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(resourceEntry)) {
				resourceEntry = (ResourceEntry)session.get(
					ResourceEntryImpl.class, resourceEntry.getPrimaryKeyObj());
			}

			if (resourceEntry != null) {
				session.delete(resourceEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (resourceEntry != null) {
			clearCache(resourceEntry);
		}

		return resourceEntry;
	}

	@Override
	public ResourceEntry updateImpl(ResourceEntry resourceEntry) {
		boolean isNew = resourceEntry.isNew();

		if (!(resourceEntry instanceof ResourceEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(resourceEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					resourceEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in resourceEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ResourceEntry implementation " +
					resourceEntry.getClass());
		}

		ResourceEntryModelImpl resourceEntryModelImpl =
			(ResourceEntryModelImpl)resourceEntry;

		if (Validator.isNull(resourceEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			resourceEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (resourceEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				resourceEntry.setCreateDate(date);
			}
			else {
				resourceEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!resourceEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				resourceEntry.setModifiedDate(date);
			}
			else {
				resourceEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(resourceEntry);
			}
			else {
				resourceEntry = (ResourceEntry)session.merge(resourceEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ResourceEntryImpl.class, resourceEntryModelImpl, false, true);

		cacheUniqueFindersCache(resourceEntryModelImpl);

		if (isNew) {
			resourceEntry.setNew(false);
		}

		resourceEntry.resetOriginalValues();

		return resourceEntry;
	}

	/**
	 * Returns the resource entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resource entry
	 * @return the resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResourceEntryException {

		ResourceEntry resourceEntry = fetchByPrimaryKey(primaryKey);

		if (resourceEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResourceEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return resourceEntry;
	}

	/**
	 * Returns the resource entry with the primary key or throws a <code>NoSuchResourceEntryException</code> if it could not be found.
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry findByPrimaryKey(long resourceId)
		throws NoSuchResourceEntryException {

		return findByPrimaryKey((Serializable)resourceId);
	}

	/**
	 * Returns the resource entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry, or <code>null</code> if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry fetchByPrimaryKey(long resourceId) {
		return fetchByPrimaryKey((Serializable)resourceId);
	}

	/**
	 * Returns all the resource entries.
	 *
	 * @return the resource entries
	 */
	@Override
	public List<ResourceEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of resource entries
	 */
	@Override
	public List<ResourceEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resource entries
	 */
	@Override
	public List<ResourceEntry> findAll(
		int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of resource entries
	 */
	@Override
	public List<ResourceEntry> findAll(
		int start, int end, OrderByComparator<ResourceEntry> orderByComparator,
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

		List<ResourceEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RESOURCEENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RESOURCEENTRY;

				sql = sql.concat(ResourceEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ResourceEntry>)QueryUtil.list(
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
	 * Removes all the resource entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ResourceEntry resourceEntry : findAll()) {
			remove(resourceEntry);
		}
	}

	/**
	 * Returns the number of resource entries.
	 *
	 * @return the number of resource entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RESOURCEENTRY);

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
		return "resourceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RESOURCEENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ResourceEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the resource entry persistence.
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

		_finderPathWithPaginationFindByB_W = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_W",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "workId"}, true);

		_finderPathWithoutPaginationFindByB_W = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_W",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "workId"}, true);

		_finderPathCountByB_W = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_W",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "workId"}, false);

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

		_finderPathWithPaginationFindByB_Team = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_Team",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "teamId"}, true);

		_finderPathWithoutPaginationFindByB_Team = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_Team",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "teamId"}, true);

		_finderPathCountByB_Team = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_Team",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "teamId"}, false);

		_finderPathWithPaginationFindByB_W_PH_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_W_PH_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "workId", "phaseId", "projectId"},
			true);

		_finderPathWithoutPaginationFindByB_W_PH_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_W_PH_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			new String[] {"businessId", "workId", "phaseId", "projectId"},
			true);

		_finderPathCountByB_W_PH_P = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_W_PH_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			new String[] {"businessId", "workId", "phaseId", "projectId"},
			false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setResourceEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setResourceEntryUtilPersistence(null);

		entityCache.removeCache(ResourceEntryImpl.class.getName());
	}

	private void _setResourceEntryUtilPersistence(
		ResourceEntryPersistence resourceEntryPersistence) {

		try {
			Field field = ResourceEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, resourceEntryPersistence);
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

	private static final String _SQL_SELECT_RESOURCEENTRY =
		"SELECT resourceEntry FROM ResourceEntry resourceEntry";

	private static final String _SQL_SELECT_RESOURCEENTRY_WHERE =
		"SELECT resourceEntry FROM ResourceEntry resourceEntry WHERE ";

	private static final String _SQL_COUNT_RESOURCEENTRY =
		"SELECT COUNT(resourceEntry) FROM ResourceEntry resourceEntry";

	private static final String _SQL_COUNT_RESOURCEENTRY_WHERE =
		"SELECT COUNT(resourceEntry) FROM ResourceEntry resourceEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "resourceEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ResourceEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ResourceEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ResourceEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ResourceEntryModelArgumentsResolver
		_resourceEntryModelArgumentsResolver;

}