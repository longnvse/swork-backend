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

package com.swork.core.project.service.service.persistence.impl;

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

import com.swork.core.project.service.exception.NoSuchProjectEntryException;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.model.ProjectEntryTable;
import com.swork.core.project.service.model.impl.ProjectEntryImpl;
import com.swork.core.project.service.model.impl.ProjectEntryModelImpl;
import com.swork.core.project.service.service.persistence.ProjectEntryPersistence;
import com.swork.core.project.service.service.persistence.ProjectEntryUtil;
import com.swork.core.project.service.service.persistence.impl.constants.SW_PROJECTPersistenceConstants;

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
 * The persistence implementation for the project entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ProjectEntryPersistence.class, BasePersistence.class})
public class ProjectEntryPersistenceImpl
	extends BasePersistenceImpl<ProjectEntry>
	implements ProjectEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProjectEntryUtil</code> to access the project entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProjectEntryImpl.class.getName();

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
	 * Returns all the project entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project entries
	 */
	@Override
	public List<ProjectEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @return the range of matching project entries
	 */
	@Override
	public List<ProjectEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project entries
	 */
	@Override
	public List<ProjectEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project entries
	 */
	@Override
	public List<ProjectEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator,
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

		List<ProjectEntry> list = null;

		if (useFinderCache) {
			list = (List<ProjectEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectEntry projectEntry : list) {
					if (!uuid.equals(projectEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_PROJECTENTRY_WHERE);

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
				sb.append(ProjectEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProjectEntry>)QueryUtil.list(
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
	 * Returns the first project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry findByUuid_First(
			String uuid, OrderByComparator<ProjectEntry> orderByComparator)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = fetchByUuid_First(uuid, orderByComparator);

		if (projectEntry != null) {
			return projectEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProjectEntryException(sb.toString());
	}

	/**
	 * Returns the first project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByUuid_First(
		String uuid, OrderByComparator<ProjectEntry> orderByComparator) {

		List<ProjectEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry findByUuid_Last(
			String uuid, OrderByComparator<ProjectEntry> orderByComparator)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (projectEntry != null) {
			return projectEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProjectEntryException(sb.toString());
	}

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ProjectEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project entries before and after the current project entry in the ordered set where uuid = &#63;.
	 *
	 * @param projectId the primary key of the current project entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	@Override
	public ProjectEntry[] findByUuid_PrevAndNext(
			long projectId, String uuid,
			OrderByComparator<ProjectEntry> orderByComparator)
		throws NoSuchProjectEntryException {

		uuid = Objects.toString(uuid, "");

		ProjectEntry projectEntry = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			ProjectEntry[] array = new ProjectEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, projectEntry, uuid, orderByComparator, true);

			array[1] = projectEntry;

			array[2] = getByUuid_PrevAndNext(
				session, projectEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectEntry getByUuid_PrevAndNext(
		Session session, ProjectEntry projectEntry, String uuid,
		OrderByComparator<ProjectEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROJECTENTRY_WHERE);

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
			sb.append(ProjectEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(projectEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectEntry projectEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(projectEntry);
		}
	}

	/**
	 * Returns the number of project entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTENTRY_WHERE);

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
		"projectEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(projectEntry.uuid IS NULL OR projectEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the project entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = fetchByUUID_G(uuid, groupId);

		if (projectEntry == null) {
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

			throw new NoSuchProjectEntryException(sb.toString());
		}

		return projectEntry;
	}

	/**
	 * Returns the project entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the project entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByUUID_G(
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

		if (result instanceof ProjectEntry) {
			ProjectEntry projectEntry = (ProjectEntry)result;

			if (!Objects.equals(uuid, projectEntry.getUuid()) ||
				(groupId != projectEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROJECTENTRY_WHERE);

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

				List<ProjectEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProjectEntry projectEntry = list.get(0);

					result = projectEntry;

					cacheResult(projectEntry);
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
			return (ProjectEntry)result;
		}
	}

	/**
	 * Removes the project entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project entry that was removed
	 */
	@Override
	public ProjectEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = findByUUID_G(uuid, groupId);

		return remove(projectEntry);
	}

	/**
	 * Returns the number of project entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROJECTENTRY_WHERE);

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
		"projectEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(projectEntry.uuid IS NULL OR projectEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"projectEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project entries
	 */
	@Override
	public List<ProjectEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @return the range of matching project entries
	 */
	@Override
	public List<ProjectEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project entries
	 */
	@Override
	public List<ProjectEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project entries
	 */
	@Override
	public List<ProjectEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator,
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

		List<ProjectEntry> list = null;

		if (useFinderCache) {
			list = (List<ProjectEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectEntry projectEntry : list) {
					if (!uuid.equals(projectEntry.getUuid()) ||
						(companyId != projectEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROJECTENTRY_WHERE);

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
				sb.append(ProjectEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProjectEntry>)QueryUtil.list(
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
	 * Returns the first project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProjectEntry> orderByComparator)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (projectEntry != null) {
			return projectEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProjectEntryException(sb.toString());
	}

	/**
	 * Returns the first project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProjectEntry> orderByComparator) {

		List<ProjectEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProjectEntry> orderByComparator)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (projectEntry != null) {
			return projectEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProjectEntryException(sb.toString());
	}

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProjectEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProjectEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project entries before and after the current project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectId the primary key of the current project entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	@Override
	public ProjectEntry[] findByUuid_C_PrevAndNext(
			long projectId, String uuid, long companyId,
			OrderByComparator<ProjectEntry> orderByComparator)
		throws NoSuchProjectEntryException {

		uuid = Objects.toString(uuid, "");

		ProjectEntry projectEntry = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			ProjectEntry[] array = new ProjectEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, projectEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = projectEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, projectEntry, uuid, companyId, orderByComparator,
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

	protected ProjectEntry getByUuid_C_PrevAndNext(
		Session session, ProjectEntry projectEntry, String uuid, long companyId,
		OrderByComparator<ProjectEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROJECTENTRY_WHERE);

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
			sb.append(ProjectEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(projectEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProjectEntry projectEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(projectEntry);
		}
	}

	/**
	 * Returns the number of project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROJECTENTRY_WHERE);

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
		"projectEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(projectEntry.uuid IS NULL OR projectEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"projectEntry.companyId = ?";

	private FinderPath _finderPathFetchByP_N;
	private FinderPath _finderPathCountByP_N;

	/**
	 * Returns the project entry where businessId = &#63; and name = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry findByP_N(long businessId, String name)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = fetchByP_N(businessId, name);

		if (projectEntry == null) {
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

			throw new NoSuchProjectEntryException(sb.toString());
		}

		return projectEntry;
	}

	/**
	 * Returns the project entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByP_N(long businessId, String name) {
		return fetchByP_N(businessId, name, true);
	}

	/**
	 * Returns the project entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByP_N(
		long businessId, String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {businessId, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByP_N, finderArgs);
		}

		if (result instanceof ProjectEntry) {
			ProjectEntry projectEntry = (ProjectEntry)result;

			if ((businessId != projectEntry.getBusinessId()) ||
				!Objects.equals(name, projectEntry.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROJECTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_N_BUSINESSID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_P_N_NAME_2);
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

				List<ProjectEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByP_N, finderArgs, list);
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
								"ProjectEntryPersistenceImpl.fetchByP_N(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectEntry projectEntry = list.get(0);

					result = projectEntry;

					cacheResult(projectEntry);
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
			return (ProjectEntry)result;
		}
	}

	/**
	 * Removes the project entry where businessId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the project entry that was removed
	 */
	@Override
	public ProjectEntry removeByP_N(long businessId, String name)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = findByP_N(businessId, name);

		return remove(projectEntry);
	}

	/**
	 * Returns the number of project entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the number of matching project entries
	 */
	@Override
	public int countByP_N(long businessId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByP_N;

		Object[] finderArgs = new Object[] {businessId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROJECTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_N_BUSINESSID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_P_N_NAME_2);
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

	private static final String _FINDER_COLUMN_P_N_BUSINESSID_2 =
		"projectEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_P_N_NAME_2 =
		"projectEntry.name = ?";

	private static final String _FINDER_COLUMN_P_N_NAME_3 =
		"(projectEntry.name IS NULL OR projectEntry.name = '')";

	private FinderPath _finderPathFetchByP_C;
	private FinderPath _finderPathCountByP_C;

	/**
	 * Returns the project entry where businessId = &#63; and code = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry findByP_C(long businessId, String code)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = fetchByP_C(businessId, code);

		if (projectEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("businessId=");
			sb.append(businessId);

			sb.append(", code=");
			sb.append(code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProjectEntryException(sb.toString());
		}

		return projectEntry;
	}

	/**
	 * Returns the project entry where businessId = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByP_C(long businessId, String code) {
		return fetchByP_C(businessId, code, true);
	}

	/**
	 * Returns the project entry where businessId = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByP_C(
		long businessId, String code, boolean useFinderCache) {

		code = Objects.toString(code, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {businessId, code};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByP_C, finderArgs);
		}

		if (result instanceof ProjectEntry) {
			ProjectEntry projectEntry = (ProjectEntry)result;

			if ((businessId != projectEntry.getBusinessId()) ||
				!Objects.equals(code, projectEntry.getCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROJECTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_C_BUSINESSID_2);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_C_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_P_C_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				if (bindCode) {
					queryPos.add(code);
				}

				List<ProjectEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByP_C, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {businessId, code};
							}

							_log.warn(
								"ProjectEntryPersistenceImpl.fetchByP_C(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectEntry projectEntry = list.get(0);

					result = projectEntry;

					cacheResult(projectEntry);
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
			return (ProjectEntry)result;
		}
	}

	/**
	 * Removes the project entry where businessId = &#63; and code = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the project entry that was removed
	 */
	@Override
	public ProjectEntry removeByP_C(long businessId, String code)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = findByP_C(businessId, code);

		return remove(projectEntry);
	}

	/**
	 * Returns the number of project entries where businessId = &#63; and code = &#63;.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the number of matching project entries
	 */
	@Override
	public int countByP_C(long businessId, String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByP_C;

		Object[] finderArgs = new Object[] {businessId, code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROJECTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_P_C_BUSINESSID_2);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_P_C_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_P_C_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				if (bindCode) {
					queryPos.add(code);
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

	private static final String _FINDER_COLUMN_P_C_BUSINESSID_2 =
		"projectEntry.businessId = ? AND ";

	private static final String _FINDER_COLUMN_P_C_CODE_2 =
		"projectEntry.code = ?";

	private static final String _FINDER_COLUMN_P_C_CODE_3 =
		"(projectEntry.code IS NULL OR projectEntry.code = '')";

	private FinderPath _finderPathWithPaginationFindByB_;
	private FinderPath _finderPathWithoutPaginationFindByB_;
	private FinderPath _finderPathCountByB_;

	/**
	 * Returns all the project entries where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @return the matching project entries
	 */
	@Override
	public List<ProjectEntry> findByB_(long businessId) {
		return findByB_(businessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project entries where businessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @return the range of matching project entries
	 */
	@Override
	public List<ProjectEntry> findByB_(long businessId, int start, int end) {
		return findByB_(businessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project entries where businessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project entries
	 */
	@Override
	public List<ProjectEntry> findByB_(
		long businessId, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator) {

		return findByB_(businessId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project entries where businessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project entries
	 */
	@Override
	public List<ProjectEntry> findByB_(
		long businessId, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByB_;
				finderArgs = new Object[] {businessId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByB_;
			finderArgs = new Object[] {
				businessId, start, end, orderByComparator
			};
		}

		List<ProjectEntry> list = null;

		if (useFinderCache) {
			list = (List<ProjectEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectEntry projectEntry : list) {
					if (businessId != projectEntry.getBusinessId()) {
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

			sb.append(_SQL_SELECT_PROJECTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B__BUSINESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

				list = (List<ProjectEntry>)QueryUtil.list(
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
	 * Returns the first project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry findByB__First(
			long businessId, OrderByComparator<ProjectEntry> orderByComparator)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = fetchByB__First(
			businessId, orderByComparator);

		if (projectEntry != null) {
			return projectEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append("}");

		throw new NoSuchProjectEntryException(sb.toString());
	}

	/**
	 * Returns the first project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByB__First(
		long businessId, OrderByComparator<ProjectEntry> orderByComparator) {

		List<ProjectEntry> list = findByB_(businessId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry findByB__Last(
			long businessId, OrderByComparator<ProjectEntry> orderByComparator)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = fetchByB__Last(
			businessId, orderByComparator);

		if (projectEntry != null) {
			return projectEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessId=");
		sb.append(businessId);

		sb.append("}");

		throw new NoSuchProjectEntryException(sb.toString());
	}

	/**
	 * Returns the last project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByB__Last(
		long businessId, OrderByComparator<ProjectEntry> orderByComparator) {

		int count = countByB_(businessId);

		if (count == 0) {
			return null;
		}

		List<ProjectEntry> list = findByB_(
			businessId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project entries before and after the current project entry in the ordered set where businessId = &#63;.
	 *
	 * @param projectId the primary key of the current project entry
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	@Override
	public ProjectEntry[] findByB__PrevAndNext(
			long projectId, long businessId,
			OrderByComparator<ProjectEntry> orderByComparator)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			ProjectEntry[] array = new ProjectEntryImpl[3];

			array[0] = getByB__PrevAndNext(
				session, projectEntry, businessId, orderByComparator, true);

			array[1] = projectEntry;

			array[2] = getByB__PrevAndNext(
				session, projectEntry, businessId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectEntry getByB__PrevAndNext(
		Session session, ProjectEntry projectEntry, long businessId,
		OrderByComparator<ProjectEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROJECTENTRY_WHERE);

		sb.append(_FINDER_COLUMN_B__BUSINESSID_2);

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
			sb.append(ProjectEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(projectEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project entries where businessId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 */
	@Override
	public void removeByB_(long businessId) {
		for (ProjectEntry projectEntry :
				findByB_(
					businessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(projectEntry);
		}
	}

	/**
	 * Returns the number of project entries where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @return the number of matching project entries
	 */
	@Override
	public int countByB_(long businessId) {
		FinderPath finderPath = _finderPathCountByB_;

		Object[] finderArgs = new Object[] {businessId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTENTRY_WHERE);

			sb.append(_FINDER_COLUMN_B__BUSINESSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessId);

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

	private static final String _FINDER_COLUMN_B__BUSINESSID_2 =
		"projectEntry.businessId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the project entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (projectEntry == null) {
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

			throw new NoSuchProjectEntryException(sb.toString());
		}

		return projectEntry;
	}

	/**
	 * Returns the project entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the project entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Override
	public ProjectEntry fetchByC_ERC(
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

		if (result instanceof ProjectEntry) {
			ProjectEntry projectEntry = (ProjectEntry)result;

			if ((companyId != projectEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					projectEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROJECTENTRY_WHERE);

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

				List<ProjectEntry> list = query.list();

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
								"ProjectEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectEntry projectEntry = list.get(0);

					result = projectEntry;

					cacheResult(projectEntry);
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
			return (ProjectEntry)result;
		}
	}

	/**
	 * Removes the project entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the project entry that was removed
	 */
	@Override
	public ProjectEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(projectEntry);
	}

	/**
	 * Returns the number of project entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching project entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROJECTENTRY_WHERE);

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
		"projectEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"projectEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(projectEntry.externalReferenceCode IS NULL OR projectEntry.externalReferenceCode = '')";

	public ProjectEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProjectEntry.class);

		setModelImplClass(ProjectEntryImpl.class);
		setModelPKClass(long.class);

		setTable(ProjectEntryTable.INSTANCE);
	}

	/**
	 * Caches the project entry in the entity cache if it is enabled.
	 *
	 * @param projectEntry the project entry
	 */
	@Override
	public void cacheResult(ProjectEntry projectEntry) {
		entityCache.putResult(
			ProjectEntryImpl.class, projectEntry.getPrimaryKey(), projectEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {projectEntry.getUuid(), projectEntry.getGroupId()},
			projectEntry);

		finderCache.putResult(
			_finderPathFetchByP_N,
			new Object[] {projectEntry.getBusinessId(), projectEntry.getName()},
			projectEntry);

		finderCache.putResult(
			_finderPathFetchByP_C,
			new Object[] {projectEntry.getBusinessId(), projectEntry.getCode()},
			projectEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				projectEntry.getCompanyId(),
				projectEntry.getExternalReferenceCode()
			},
			projectEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the project entries in the entity cache if it is enabled.
	 *
	 * @param projectEntries the project entries
	 */
	@Override
	public void cacheResult(List<ProjectEntry> projectEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (projectEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProjectEntry projectEntry : projectEntries) {
			if (entityCache.getResult(
					ProjectEntryImpl.class, projectEntry.getPrimaryKey()) ==
						null) {

				cacheResult(projectEntry);
			}
		}
	}

	/**
	 * Clears the cache for all project entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectEntryImpl.class);

		finderCache.clearCache(ProjectEntryImpl.class);
	}

	/**
	 * Clears the cache for the project entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectEntry projectEntry) {
		entityCache.removeResult(ProjectEntryImpl.class, projectEntry);
	}

	@Override
	public void clearCache(List<ProjectEntry> projectEntries) {
		for (ProjectEntry projectEntry : projectEntries) {
			entityCache.removeResult(ProjectEntryImpl.class, projectEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProjectEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProjectEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectEntryModelImpl projectEntryModelImpl) {

		Object[] args = new Object[] {
			projectEntryModelImpl.getUuid(), projectEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, projectEntryModelImpl);

		args = new Object[] {
			projectEntryModelImpl.getBusinessId(),
			projectEntryModelImpl.getName()
		};

		finderCache.putResult(_finderPathCountByP_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByP_N, args, projectEntryModelImpl);

		args = new Object[] {
			projectEntryModelImpl.getBusinessId(),
			projectEntryModelImpl.getCode()
		};

		finderCache.putResult(_finderPathCountByP_C, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByP_C, args, projectEntryModelImpl);

		args = new Object[] {
			projectEntryModelImpl.getCompanyId(),
			projectEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, projectEntryModelImpl);
	}

	/**
	 * Creates a new project entry with the primary key. Does not add the project entry to the database.
	 *
	 * @param projectId the primary key for the new project entry
	 * @return the new project entry
	 */
	@Override
	public ProjectEntry create(long projectId) {
		ProjectEntry projectEntry = new ProjectEntryImpl();

		projectEntry.setNew(true);
		projectEntry.setPrimaryKey(projectId);

		String uuid = PortalUUIDUtil.generate();

		projectEntry.setUuid(uuid);

		projectEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return projectEntry;
	}

	/**
	 * Removes the project entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry that was removed
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	@Override
	public ProjectEntry remove(long projectId)
		throws NoSuchProjectEntryException {

		return remove((Serializable)projectId);
	}

	/**
	 * Removes the project entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project entry
	 * @return the project entry that was removed
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	@Override
	public ProjectEntry remove(Serializable primaryKey)
		throws NoSuchProjectEntryException {

		Session session = null;

		try {
			session = openSession();

			ProjectEntry projectEntry = (ProjectEntry)session.get(
				ProjectEntryImpl.class, primaryKey);

			if (projectEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(projectEntry);
		}
		catch (NoSuchProjectEntryException noSuchEntityException) {
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
	protected ProjectEntry removeImpl(ProjectEntry projectEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectEntry)) {
				projectEntry = (ProjectEntry)session.get(
					ProjectEntryImpl.class, projectEntry.getPrimaryKeyObj());
			}

			if (projectEntry != null) {
				session.delete(projectEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (projectEntry != null) {
			clearCache(projectEntry);
		}

		return projectEntry;
	}

	@Override
	public ProjectEntry updateImpl(ProjectEntry projectEntry) {
		boolean isNew = projectEntry.isNew();

		if (!(projectEntry instanceof ProjectEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					projectEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectEntry implementation " +
					projectEntry.getClass());
		}

		ProjectEntryModelImpl projectEntryModelImpl =
			(ProjectEntryModelImpl)projectEntry;

		if (Validator.isNull(projectEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (projectEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				projectEntry.setCreateDate(date);
			}
			else {
				projectEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!projectEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				projectEntry.setModifiedDate(date);
			}
			else {
				projectEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(projectEntry);
			}
			else {
				projectEntry = (ProjectEntry)session.merge(projectEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProjectEntryImpl.class, projectEntryModelImpl, false, true);

		cacheUniqueFindersCache(projectEntryModelImpl);

		if (isNew) {
			projectEntry.setNew(false);
		}

		projectEntry.resetOriginalValues();

		return projectEntry;
	}

	/**
	 * Returns the project entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project entry
	 * @return the project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	@Override
	public ProjectEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectEntryException {

		ProjectEntry projectEntry = fetchByPrimaryKey(primaryKey);

		if (projectEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return projectEntry;
	}

	/**
	 * Returns the project entry with the primary key or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	@Override
	public ProjectEntry findByPrimaryKey(long projectId)
		throws NoSuchProjectEntryException {

		return findByPrimaryKey((Serializable)projectId);
	}

	/**
	 * Returns the project entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry, or <code>null</code> if a project entry with the primary key could not be found
	 */
	@Override
	public ProjectEntry fetchByPrimaryKey(long projectId) {
		return fetchByPrimaryKey((Serializable)projectId);
	}

	/**
	 * Returns all the project entries.
	 *
	 * @return the project entries
	 */
	@Override
	public List<ProjectEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @return the range of project entries
	 */
	@Override
	public List<ProjectEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project entries
	 */
	@Override
	public List<ProjectEntry> findAll(
		int start, int end, OrderByComparator<ProjectEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project entries
	 */
	@Override
	public List<ProjectEntry> findAll(
		int start, int end, OrderByComparator<ProjectEntry> orderByComparator,
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

		List<ProjectEntry> list = null;

		if (useFinderCache) {
			list = (List<ProjectEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROJECTENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTENTRY;

				sql = sql.concat(ProjectEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProjectEntry>)QueryUtil.list(
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
	 * Removes all the project entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectEntry projectEntry : findAll()) {
			remove(projectEntry);
		}
	}

	/**
	 * Returns the number of project entries.
	 *
	 * @return the number of project entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROJECTENTRY);

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
		return "projectId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROJECTENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProjectEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project entry persistence.
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

		_finderPathFetchByP_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByP_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"businessId", "name"}, true);

		_finderPathCountByP_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_N",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"businessId", "name"}, false);

		_finderPathFetchByP_C = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByP_C",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"businessId", "code_"}, true);

		_finderPathCountByP_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_C",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"businessId", "code_"}, false);

		_finderPathWithPaginationFindByB_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"businessId"}, true);

		_finderPathWithoutPaginationFindByB_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_",
			new String[] {Long.class.getName()}, new String[] {"businessId"},
			true);

		_finderPathCountByB_ = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_",
			new String[] {Long.class.getName()}, new String[] {"businessId"},
			false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setProjectEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProjectEntryUtilPersistence(null);

		entityCache.removeCache(ProjectEntryImpl.class.getName());
	}

	private void _setProjectEntryUtilPersistence(
		ProjectEntryPersistence projectEntryPersistence) {

		try {
			Field field = ProjectEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, projectEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_PROJECTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_PROJECTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_PROJECTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PROJECTENTRY =
		"SELECT projectEntry FROM ProjectEntry projectEntry";

	private static final String _SQL_SELECT_PROJECTENTRY_WHERE =
		"SELECT projectEntry FROM ProjectEntry projectEntry WHERE ";

	private static final String _SQL_COUNT_PROJECTENTRY =
		"SELECT COUNT(projectEntry) FROM ProjectEntry projectEntry";

	private static final String _SQL_COUNT_PROJECTENTRY_WHERE =
		"SELECT COUNT(projectEntry) FROM ProjectEntry projectEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "projectEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProjectEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProjectEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProjectEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "code"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ProjectEntryModelArgumentsResolver
		_projectEntryModelArgumentsResolver;

}