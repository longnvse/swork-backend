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

import com.swork.core.resource.service.exception.NoSuchResourceTypeEntryException;
import com.swork.core.resource.service.model.ResourceTypeEntry;
import com.swork.core.resource.service.model.ResourceTypeEntryTable;
import com.swork.core.resource.service.model.impl.ResourceTypeEntryImpl;
import com.swork.core.resource.service.model.impl.ResourceTypeEntryModelImpl;
import com.swork.core.resource.service.service.persistence.ResourceTypeEntryPersistence;
import com.swork.core.resource.service.service.persistence.ResourceTypeEntryUtil;
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
 * The persistence implementation for the resource type entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {ResourceTypeEntryPersistence.class, BasePersistence.class}
)
public class ResourceTypeEntryPersistenceImpl
	extends BasePersistenceImpl<ResourceTypeEntry>
	implements ResourceTypeEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ResourceTypeEntryUtil</code> to access the resource type entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ResourceTypeEntryImpl.class.getName();

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
	 * Returns all the resource type entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource type entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @return the range of matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource type entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource type entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator,
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

		List<ResourceTypeEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceTypeEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceTypeEntry resourceTypeEntry : list) {
					if (!uuid.equals(resourceTypeEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_RESOURCETYPEENTRY_WHERE);

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
				sb.append(ResourceTypeEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ResourceTypeEntry>)QueryUtil.list(
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
	 * Returns the first resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry findByUuid_First(
			String uuid, OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (resourceTypeEntry != null) {
			return resourceTypeEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchResourceTypeEntryException(sb.toString());
	}

	/**
	 * Returns the first resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByUuid_First(
		String uuid, OrderByComparator<ResourceTypeEntry> orderByComparator) {

		List<ResourceTypeEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry findByUuid_Last(
			String uuid, OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (resourceTypeEntry != null) {
			return resourceTypeEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchResourceTypeEntryException(sb.toString());
	}

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ResourceTypeEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ResourceTypeEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource type entries before and after the current resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param resourceTypeId the primary key of the current resource type entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource type entry
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	@Override
	public ResourceTypeEntry[] findByUuid_PrevAndNext(
			long resourceTypeId, String uuid,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws NoSuchResourceTypeEntryException {

		uuid = Objects.toString(uuid, "");

		ResourceTypeEntry resourceTypeEntry = findByPrimaryKey(resourceTypeId);

		Session session = null;

		try {
			session = openSession();

			ResourceTypeEntry[] array = new ResourceTypeEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, resourceTypeEntry, uuid, orderByComparator, true);

			array[1] = resourceTypeEntry;

			array[2] = getByUuid_PrevAndNext(
				session, resourceTypeEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ResourceTypeEntry getByUuid_PrevAndNext(
		Session session, ResourceTypeEntry resourceTypeEntry, String uuid,
		OrderByComparator<ResourceTypeEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCETYPEENTRY_WHERE);

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
			sb.append(ResourceTypeEntryModelImpl.ORDER_BY_JPQL);
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
						resourceTypeEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceTypeEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource type entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ResourceTypeEntry resourceTypeEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(resourceTypeEntry);
		}
	}

	/**
	 * Returns the number of resource type entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching resource type entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RESOURCETYPEENTRY_WHERE);

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
		"resourceTypeEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(resourceTypeEntry.uuid IS NULL OR resourceTypeEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the resource type entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = fetchByUUID_G(uuid, groupId);

		if (resourceTypeEntry == null) {
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

			throw new NoSuchResourceTypeEntryException(sb.toString());
		}

		return resourceTypeEntry;
	}

	/**
	 * Returns the resource type entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the resource type entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByUUID_G(
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

		if (result instanceof ResourceTypeEntry) {
			ResourceTypeEntry resourceTypeEntry = (ResourceTypeEntry)result;

			if (!Objects.equals(uuid, resourceTypeEntry.getUuid()) ||
				(groupId != resourceTypeEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RESOURCETYPEENTRY_WHERE);

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

				List<ResourceTypeEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ResourceTypeEntry resourceTypeEntry = list.get(0);

					result = resourceTypeEntry;

					cacheResult(resourceTypeEntry);
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
			return (ResourceTypeEntry)result;
		}
	}

	/**
	 * Removes the resource type entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the resource type entry that was removed
	 */
	@Override
	public ResourceTypeEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = findByUUID_G(uuid, groupId);

		return remove(resourceTypeEntry);
	}

	/**
	 * Returns the number of resource type entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching resource type entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCETYPEENTRY_WHERE);

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
		"resourceTypeEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(resourceTypeEntry.uuid IS NULL OR resourceTypeEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"resourceTypeEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @return the range of matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator,
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

		List<ResourceTypeEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceTypeEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceTypeEntry resourceTypeEntry : list) {
					if (!uuid.equals(resourceTypeEntry.getUuid()) ||
						(companyId != resourceTypeEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_RESOURCETYPEENTRY_WHERE);

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
				sb.append(ResourceTypeEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ResourceTypeEntry>)QueryUtil.list(
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
	 * Returns the first resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (resourceTypeEntry != null) {
			return resourceTypeEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchResourceTypeEntryException(sb.toString());
	}

	/**
	 * Returns the first resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		List<ResourceTypeEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (resourceTypeEntry != null) {
			return resourceTypeEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchResourceTypeEntryException(sb.toString());
	}

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ResourceTypeEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource type entries before and after the current resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param resourceTypeId the primary key of the current resource type entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource type entry
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	@Override
	public ResourceTypeEntry[] findByUuid_C_PrevAndNext(
			long resourceTypeId, String uuid, long companyId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws NoSuchResourceTypeEntryException {

		uuid = Objects.toString(uuid, "");

		ResourceTypeEntry resourceTypeEntry = findByPrimaryKey(resourceTypeId);

		Session session = null;

		try {
			session = openSession();

			ResourceTypeEntry[] array = new ResourceTypeEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, resourceTypeEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = resourceTypeEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, resourceTypeEntry, uuid, companyId, orderByComparator,
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

	protected ResourceTypeEntry getByUuid_C_PrevAndNext(
		Session session, ResourceTypeEntry resourceTypeEntry, String uuid,
		long companyId, OrderByComparator<ResourceTypeEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCETYPEENTRY_WHERE);

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
			sb.append(ResourceTypeEntryModelImpl.ORDER_BY_JPQL);
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
						resourceTypeEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceTypeEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource type entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ResourceTypeEntry resourceTypeEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(resourceTypeEntry);
		}
	}

	/**
	 * Returns the number of resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching resource type entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCETYPEENTRY_WHERE);

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
		"resourceTypeEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(resourceTypeEntry.uuid IS NULL OR resourceTypeEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"resourceTypeEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByB_PT;
	private FinderPath _finderPathWithoutPaginationFindByB_PT;
	private FinderPath _finderPathCountByB_PT;

	/**
	 * Returns all the resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByB_PT(long businessId, Long parentId) {
		return findByB_PT(
			businessId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @return the range of matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByB_PT(
		long businessId, Long parentId, int start, int end) {

		return findByB_PT(businessId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByB_PT(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return findByB_PT(
			businessId, parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findByB_PT(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_PT;
				finderArgs = new Object[] {businessId, parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_PT;
			finderArgs = new Object[] {
				businessId, parentId, start, end, orderByComparator
			};
		}

		List<ResourceTypeEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceTypeEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceTypeEntry resourceTypeEntry : list) {
					if ((businessId != resourceTypeEntry.getBusinessId()) ||
						!Objects.equals(
							parentId, resourceTypeEntry.getParentId())) {

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

			sb.append(_SQL_SELECT_RESOURCETYPEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_PT_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PT_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceTypeEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				queryPos.add(parentId.longValue());

				list = (List<ResourceTypeEntry>)QueryUtil.list(
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
	 * Returns the first resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry findByB_PT_First(
			long businessId, Long parentId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = fetchByB_PT_First(
			businessId, parentId, orderByComparator);

		if (resourceTypeEntry != null) {
			return resourceTypeEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchResourceTypeEntryException(sb.toString());
	}

	/**
	 * Returns the first resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByB_PT_First(
		long businessId, Long parentId,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		List<ResourceTypeEntry> list = findByB_PT(
			businessId, parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry findByB_PT_Last(
			long businessId, Long parentId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = fetchByB_PT_Last(
			businessId, parentId, orderByComparator);

		if (resourceTypeEntry != null) {
			return resourceTypeEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append(", parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchResourceTypeEntryException(sb.toString());
	}

	/**
	 * Returns the last resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByB_PT_Last(
		long businessId, Long parentId,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		int count = countByB_PT(businessId, parentId);

		if (count == 0) {
			return null;
		}

		List<ResourceTypeEntry> list = findByB_PT(
			businessId, parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resource type entries before and after the current resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param resourceTypeId the primary key of the current resource type entry
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource type entry
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	@Override
	public ResourceTypeEntry[] findByB_PT_PrevAndNext(
			long resourceTypeId, long businessId, Long parentId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = findByPrimaryKey(resourceTypeId);

		Session session = null;

		try {
			session = openSession();

			ResourceTypeEntry[] array = new ResourceTypeEntryImpl[3];

			array[0] = getByB_PT_PrevAndNext(
				session, resourceTypeEntry, businessId, parentId,
				orderByComparator, true);

			array[1] = resourceTypeEntry;

			array[2] = getByB_PT_PrevAndNext(
				session, resourceTypeEntry, businessId, parentId,
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

	protected ResourceTypeEntry getByB_PT_PrevAndNext(
		Session session, ResourceTypeEntry resourceTypeEntry, long businessId,
		Long parentId, OrderByComparator<ResourceTypeEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCETYPEENTRY_WHERE);

		sb.append(_FINDER_COLUMN_B_PT_BUSINESSID_2);

		sb.append(_FINDER_COLUMN_B_PT_PARENTID_2);

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
			sb.append(ResourceTypeEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						resourceTypeEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceTypeEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource type entries where businessId = &#63; and parentId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByB_PT(long businessId, Long parentId) {
		for (ResourceTypeEntry resourceTypeEntry :
				findByB_PT(
					businessId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(resourceTypeEntry);
		}
	}

	/**
	 * Returns the number of resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the number of matching resource type entries
	 */
	@Override
	public int countByB_PT(long businessId, Long parentId) {
		FinderPath finderPath = _finderPathCountByB_PT;

		Object[] finderArgs = new Object[] {businessId, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCETYPEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_PT_BUSINESSID_2);

			sb.append(_FINDER_COLUMN_B_PT_PARENTID_2);

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

	private static final String _FINDER_COLUMN_B_PT_BUSINESSID_2 =
		"resourceTypeEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_PT_PARENTID_2 =
		"resourceTypeEntry.parentId = ?";

	private FinderPath _finderPathFetchByB_N;
	private FinderPath _finderPathCountByB_N;

	/**
	 * Returns the resource type entry where businessId = &#63; and name = &#63; or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry findByB_N(long businessId, String name)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = fetchByB_N(businessId, name);

		if (resourceTypeEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("businessId=");
			sb.append(businessId);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchResourceTypeEntryException(sb.toString());
		}

		return resourceTypeEntry;
	}

	/**
	 * Returns the resource type entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByB_N(long businessId, String name) {
		return fetchByB_N(businessId, name, true);
	}

	/**
	 * Returns the resource type entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByB_N(
		long businessId, String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {businessId, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByB_N, finderArgs);
		}

		if (result instanceof ResourceTypeEntry) {
			ResourceTypeEntry resourceTypeEntry = (ResourceTypeEntry)result;

			if ((businessId != resourceTypeEntry.getBusinessId()) ||
				!Objects.equals(name, resourceTypeEntry.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RESOURCETYPEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_N_BUSINESSID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_N_NAME_2);
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

				List<ResourceTypeEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByB_N, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {businessId, name};
							}

							_log.warn(
								"ResourceTypeEntryPersistenceImpl.fetchByB_N(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ResourceTypeEntry resourceTypeEntry = list.get(0);

					result = resourceTypeEntry;

					cacheResult(resourceTypeEntry);
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
			return (ResourceTypeEntry)result;
		}
	}

	/**
	 * Removes the resource type entry where businessId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the resource type entry that was removed
	 */
	@Override
	public ResourceTypeEntry removeByB_N(long businessId, String name)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = findByB_N(businessId, name);

		return remove(resourceTypeEntry);
	}

	/**
	 * Returns the number of resource type entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the number of matching resource type entries
	 */
	@Override
	public int countByB_N(long businessId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByB_N;

		Object[] finderArgs = new Object[] {businessId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCETYPEENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B_N_BUSINESSID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_B_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_B_N_NAME_2);
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

	private static final String _FINDER_COLUMN_B_N_BUSINESSID_2 =
		"resourceTypeEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_B_N_NAME_2 =
		"resourceTypeEntry.name = ?";

	private static final String _FINDER_COLUMN_B_N_NAME_3 =
		"(resourceTypeEntry.name IS NULL OR resourceTypeEntry.name = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the resource type entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (resourceTypeEntry == null) {
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

			throw new NoSuchResourceTypeEntryException(sb.toString());
		}

		return resourceTypeEntry;
	}

	/**
	 * Returns the resource type entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the resource type entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByC_ERC(
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

		if (result instanceof ResourceTypeEntry) {
			ResourceTypeEntry resourceTypeEntry = (ResourceTypeEntry)result;

			if ((companyId != resourceTypeEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					resourceTypeEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RESOURCETYPEENTRY_WHERE);

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

				List<ResourceTypeEntry> list = query.list();

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
								"ResourceTypeEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ResourceTypeEntry resourceTypeEntry = list.get(0);

					result = resourceTypeEntry;

					cacheResult(resourceTypeEntry);
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
			return (ResourceTypeEntry)result;
		}
	}

	/**
	 * Removes the resource type entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the resource type entry that was removed
	 */
	@Override
	public ResourceTypeEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(resourceTypeEntry);
	}

	/**
	 * Returns the number of resource type entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching resource type entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCETYPEENTRY_WHERE);

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
		"resourceTypeEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"resourceTypeEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(resourceTypeEntry.externalReferenceCode IS NULL OR resourceTypeEntry.externalReferenceCode = '')";

	public ResourceTypeEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ResourceTypeEntry.class);

		setModelImplClass(ResourceTypeEntryImpl.class);
		setModelPKClass(long.class);

		setTable(ResourceTypeEntryTable.INSTANCE);
	}

	/**
	 * Caches the resource type entry in the entity cache if it is enabled.
	 *
	 * @param resourceTypeEntry the resource type entry
	 */
	@Override
	public void cacheResult(ResourceTypeEntry resourceTypeEntry) {
		entityCache.putResult(
			ResourceTypeEntryImpl.class, resourceTypeEntry.getPrimaryKey(),
			resourceTypeEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				resourceTypeEntry.getUuid(), resourceTypeEntry.getGroupId()
			},
			resourceTypeEntry);

		finderCache.putResult(
			_finderPathFetchByB_N,
			new Object[] {
				resourceTypeEntry.getBusinessId(), resourceTypeEntry.getName()
			},
			resourceTypeEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				resourceTypeEntry.getCompanyId(),
				resourceTypeEntry.getExternalReferenceCode()
			},
			resourceTypeEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the resource type entries in the entity cache if it is enabled.
	 *
	 * @param resourceTypeEntries the resource type entries
	 */
	@Override
	public void cacheResult(List<ResourceTypeEntry> resourceTypeEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (resourceTypeEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ResourceTypeEntry resourceTypeEntry : resourceTypeEntries) {
			if (entityCache.getResult(
					ResourceTypeEntryImpl.class,
					resourceTypeEntry.getPrimaryKey()) == null) {

				cacheResult(resourceTypeEntry);
			}
		}
	}

	/**
	 * Clears the cache for all resource type entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ResourceTypeEntryImpl.class);

		finderCache.clearCache(ResourceTypeEntryImpl.class);
	}

	/**
	 * Clears the cache for the resource type entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ResourceTypeEntry resourceTypeEntry) {
		entityCache.removeResult(
			ResourceTypeEntryImpl.class, resourceTypeEntry);
	}

	@Override
	public void clearCache(List<ResourceTypeEntry> resourceTypeEntries) {
		for (ResourceTypeEntry resourceTypeEntry : resourceTypeEntries) {
			entityCache.removeResult(
				ResourceTypeEntryImpl.class, resourceTypeEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ResourceTypeEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ResourceTypeEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ResourceTypeEntryModelImpl resourceTypeEntryModelImpl) {

		Object[] args = new Object[] {
			resourceTypeEntryModelImpl.getUuid(),
			resourceTypeEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, resourceTypeEntryModelImpl);

		args = new Object[] {
			resourceTypeEntryModelImpl.getBusinessId(),
			resourceTypeEntryModelImpl.getName()
		};

		finderCache.putResult(_finderPathCountByB_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByB_N, args, resourceTypeEntryModelImpl);

		args = new Object[] {
			resourceTypeEntryModelImpl.getCompanyId(),
			resourceTypeEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, resourceTypeEntryModelImpl);
	}

	/**
	 * Creates a new resource type entry with the primary key. Does not add the resource type entry to the database.
	 *
	 * @param resourceTypeId the primary key for the new resource type entry
	 * @return the new resource type entry
	 */
	@Override
	public ResourceTypeEntry create(long resourceTypeId) {
		ResourceTypeEntry resourceTypeEntry = new ResourceTypeEntryImpl();

		resourceTypeEntry.setNew(true);
		resourceTypeEntry.setPrimaryKey(resourceTypeId);

		String uuid = PortalUUIDUtil.generate();

		resourceTypeEntry.setUuid(uuid);

		resourceTypeEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return resourceTypeEntry;
	}

	/**
	 * Removes the resource type entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry that was removed
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	@Override
	public ResourceTypeEntry remove(long resourceTypeId)
		throws NoSuchResourceTypeEntryException {

		return remove((Serializable)resourceTypeId);
	}

	/**
	 * Removes the resource type entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resource type entry
	 * @return the resource type entry that was removed
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	@Override
	public ResourceTypeEntry remove(Serializable primaryKey)
		throws NoSuchResourceTypeEntryException {

		Session session = null;

		try {
			session = openSession();

			ResourceTypeEntry resourceTypeEntry =
				(ResourceTypeEntry)session.get(
					ResourceTypeEntryImpl.class, primaryKey);

			if (resourceTypeEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResourceTypeEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(resourceTypeEntry);
		}
		catch (NoSuchResourceTypeEntryException noSuchEntityException) {
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
	protected ResourceTypeEntry removeImpl(
		ResourceTypeEntry resourceTypeEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(resourceTypeEntry)) {
				resourceTypeEntry = (ResourceTypeEntry)session.get(
					ResourceTypeEntryImpl.class,
					resourceTypeEntry.getPrimaryKeyObj());
			}

			if (resourceTypeEntry != null) {
				session.delete(resourceTypeEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (resourceTypeEntry != null) {
			clearCache(resourceTypeEntry);
		}

		return resourceTypeEntry;
	}

	@Override
	public ResourceTypeEntry updateImpl(ResourceTypeEntry resourceTypeEntry) {
		boolean isNew = resourceTypeEntry.isNew();

		if (!(resourceTypeEntry instanceof ResourceTypeEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(resourceTypeEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					resourceTypeEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in resourceTypeEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ResourceTypeEntry implementation " +
					resourceTypeEntry.getClass());
		}

		ResourceTypeEntryModelImpl resourceTypeEntryModelImpl =
			(ResourceTypeEntryModelImpl)resourceTypeEntry;

		if (Validator.isNull(resourceTypeEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			resourceTypeEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (resourceTypeEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				resourceTypeEntry.setCreateDate(date);
			}
			else {
				resourceTypeEntry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!resourceTypeEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				resourceTypeEntry.setModifiedDate(date);
			}
			else {
				resourceTypeEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(resourceTypeEntry);
			}
			else {
				resourceTypeEntry = (ResourceTypeEntry)session.merge(
					resourceTypeEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ResourceTypeEntryImpl.class, resourceTypeEntryModelImpl, false,
			true);

		cacheUniqueFindersCache(resourceTypeEntryModelImpl);

		if (isNew) {
			resourceTypeEntry.setNew(false);
		}

		resourceTypeEntry.resetOriginalValues();

		return resourceTypeEntry;
	}

	/**
	 * Returns the resource type entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resource type entry
	 * @return the resource type entry
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	@Override
	public ResourceTypeEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResourceTypeEntryException {

		ResourceTypeEntry resourceTypeEntry = fetchByPrimaryKey(primaryKey);

		if (resourceTypeEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResourceTypeEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return resourceTypeEntry;
	}

	/**
	 * Returns the resource type entry with the primary key or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	@Override
	public ResourceTypeEntry findByPrimaryKey(long resourceTypeId)
		throws NoSuchResourceTypeEntryException {

		return findByPrimaryKey((Serializable)resourceTypeId);
	}

	/**
	 * Returns the resource type entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry, or <code>null</code> if a resource type entry with the primary key could not be found
	 */
	@Override
	public ResourceTypeEntry fetchByPrimaryKey(long resourceTypeId) {
		return fetchByPrimaryKey((Serializable)resourceTypeId);
	}

	/**
	 * Returns all the resource type entries.
	 *
	 * @return the resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resource type entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @return the range of resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the resource type entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findAll(
		int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resource type entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> findAll(
		int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator,
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

		List<ResourceTypeEntry> list = null;

		if (useFinderCache) {
			list = (List<ResourceTypeEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RESOURCETYPEENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RESOURCETYPEENTRY;

				sql = sql.concat(ResourceTypeEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ResourceTypeEntry>)QueryUtil.list(
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
	 * Removes all the resource type entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ResourceTypeEntry resourceTypeEntry : findAll()) {
			remove(resourceTypeEntry);
		}
	}

	/**
	 * Returns the number of resource type entries.
	 *
	 * @return the number of resource type entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RESOURCETYPEENTRY);

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
		return "resourceTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RESOURCETYPEENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ResourceTypeEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the resource type entry persistence.
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

		_finderPathWithPaginationFindByB_PT = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_PT",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"businessId", "parentId"}, true);

		_finderPathWithoutPaginationFindByB_PT = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_PT",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "parentId"}, true);

		_finderPathCountByB_PT = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_PT",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"businessId", "parentId"}, false);

		_finderPathFetchByB_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByB_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"businessId", "name"}, true);

		_finderPathCountByB_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"businessId", "name"}, false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setResourceTypeEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setResourceTypeEntryUtilPersistence(null);

		entityCache.removeCache(ResourceTypeEntryImpl.class.getName());
	}

	private void _setResourceTypeEntryUtilPersistence(
		ResourceTypeEntryPersistence resourceTypeEntryPersistence) {

		try {
			Field field = ResourceTypeEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, resourceTypeEntryPersistence);
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

	private static final String _SQL_SELECT_RESOURCETYPEENTRY =
		"SELECT resourceTypeEntry FROM ResourceTypeEntry resourceTypeEntry";

	private static final String _SQL_SELECT_RESOURCETYPEENTRY_WHERE =
		"SELECT resourceTypeEntry FROM ResourceTypeEntry resourceTypeEntry WHERE ";

	private static final String _SQL_COUNT_RESOURCETYPEENTRY =
		"SELECT COUNT(resourceTypeEntry) FROM ResourceTypeEntry resourceTypeEntry";

	private static final String _SQL_COUNT_RESOURCETYPEENTRY_WHERE =
		"SELECT COUNT(resourceTypeEntry) FROM ResourceTypeEntry resourceTypeEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "resourceTypeEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ResourceTypeEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ResourceTypeEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ResourceTypeEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ResourceTypeEntryModelArgumentsResolver
		_resourceTypeEntryModelArgumentsResolver;

}