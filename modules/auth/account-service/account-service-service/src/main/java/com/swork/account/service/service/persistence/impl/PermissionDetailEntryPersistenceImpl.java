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

package com.swork.account.service.service.persistence.impl;

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

import com.swork.account.service.exception.NoSuchPermissionDetailEntryException;
import com.swork.account.service.model.PermissionDetailEntry;
import com.swork.account.service.model.PermissionDetailEntryTable;
import com.swork.account.service.model.impl.PermissionDetailEntryImpl;
import com.swork.account.service.model.impl.PermissionDetailEntryModelImpl;
import com.swork.account.service.service.persistence.PermissionDetailEntryPersistence;
import com.swork.account.service.service.persistence.PermissionDetailEntryUtil;
import com.swork.account.service.service.persistence.impl.constants.SW_ACCOUNTPersistenceConstants;

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
 * The persistence implementation for the permission detail entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {PermissionDetailEntryPersistence.class, BasePersistence.class}
)
public class PermissionDetailEntryPersistenceImpl
	extends BasePersistenceImpl<PermissionDetailEntry>
	implements PermissionDetailEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PermissionDetailEntryUtil</code> to access the permission detail entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PermissionDetailEntryImpl.class.getName();

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
	 * Returns all the permission detail entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permission detail entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @return the range of matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the permission detail entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PermissionDetailEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the permission detail entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PermissionDetailEntry> orderByComparator,
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

		List<PermissionDetailEntry> list = null;

		if (useFinderCache) {
			list = (List<PermissionDetailEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PermissionDetailEntry permissionDetailEntry : list) {
					if (!uuid.equals(permissionDetailEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_PERMISSIONDETAILENTRY_WHERE);

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
				sb.append(PermissionDetailEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PermissionDetailEntry>)QueryUtil.list(
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
	 * Returns the first permission detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry findByUuid_First(
			String uuid,
			OrderByComparator<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException {

		PermissionDetailEntry permissionDetailEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (permissionDetailEntry != null) {
			return permissionDetailEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPermissionDetailEntryException(sb.toString());
	}

	/**
	 * Returns the first permission detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<PermissionDetailEntry> orderByComparator) {

		List<PermissionDetailEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last permission detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry findByUuid_Last(
			String uuid,
			OrderByComparator<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException {

		PermissionDetailEntry permissionDetailEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (permissionDetailEntry != null) {
			return permissionDetailEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPermissionDetailEntryException(sb.toString());
	}

	/**
	 * Returns the last permission detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<PermissionDetailEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PermissionDetailEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the permission detail entries before and after the current permission detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current permission detail entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	@Override
	public PermissionDetailEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException {

		uuid = Objects.toString(uuid, "");

		PermissionDetailEntry permissionDetailEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PermissionDetailEntry[] array = new PermissionDetailEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, permissionDetailEntry, uuid, orderByComparator, true);

			array[1] = permissionDetailEntry;

			array[2] = getByUuid_PrevAndNext(
				session, permissionDetailEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PermissionDetailEntry getByUuid_PrevAndNext(
		Session session, PermissionDetailEntry permissionDetailEntry,
		String uuid, OrderByComparator<PermissionDetailEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_PERMISSIONDETAILENTRY_WHERE);

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
			sb.append(PermissionDetailEntryModelImpl.ORDER_BY_JPQL);
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
						permissionDetailEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PermissionDetailEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the permission detail entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PermissionDetailEntry permissionDetailEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(permissionDetailEntry);
		}
	}

	/**
	 * Returns the number of permission detail entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching permission detail entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERMISSIONDETAILENTRY_WHERE);

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
		"permissionDetailEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(permissionDetailEntry.uuid IS NULL OR permissionDetailEntry.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the permission detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permission detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @return the range of matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the permission detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PermissionDetailEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the permission detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PermissionDetailEntry> orderByComparator,
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

		List<PermissionDetailEntry> list = null;

		if (useFinderCache) {
			list = (List<PermissionDetailEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PermissionDetailEntry permissionDetailEntry : list) {
					if (!uuid.equals(permissionDetailEntry.getUuid()) ||
						(companyId != permissionDetailEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PERMISSIONDETAILENTRY_WHERE);

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
				sb.append(PermissionDetailEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PermissionDetailEntry>)QueryUtil.list(
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
	 * Returns the first permission detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException {

		PermissionDetailEntry permissionDetailEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (permissionDetailEntry != null) {
			return permissionDetailEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPermissionDetailEntryException(sb.toString());
	}

	/**
	 * Returns the first permission detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PermissionDetailEntry> orderByComparator) {

		List<PermissionDetailEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last permission detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException {

		PermissionDetailEntry permissionDetailEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (permissionDetailEntry != null) {
			return permissionDetailEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPermissionDetailEntryException(sb.toString());
	}

	/**
	 * Returns the last permission detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PermissionDetailEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PermissionDetailEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the permission detail entries before and after the current permission detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current permission detail entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	@Override
	public PermissionDetailEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException {

		uuid = Objects.toString(uuid, "");

		PermissionDetailEntry permissionDetailEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PermissionDetailEntry[] array = new PermissionDetailEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, permissionDetailEntry, uuid, companyId,
				orderByComparator, true);

			array[1] = permissionDetailEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, permissionDetailEntry, uuid, companyId,
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

	protected PermissionDetailEntry getByUuid_C_PrevAndNext(
		Session session, PermissionDetailEntry permissionDetailEntry,
		String uuid, long companyId,
		OrderByComparator<PermissionDetailEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_PERMISSIONDETAILENTRY_WHERE);

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
			sb.append(PermissionDetailEntryModelImpl.ORDER_BY_JPQL);
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
						permissionDetailEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PermissionDetailEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the permission detail entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PermissionDetailEntry permissionDetailEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(permissionDetailEntry);
		}
	}

	/**
	 * Returns the number of permission detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching permission detail entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERMISSIONDETAILENTRY_WHERE);

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
		"permissionDetailEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(permissionDetailEntry.uuid IS NULL OR permissionDetailEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"permissionDetailEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByPermissionId;
	private FinderPath _finderPathWithoutPaginationFindByPermissionId;
	private FinderPath _finderPathCountByPermissionId;

	/**
	 * Returns all the permission detail entries where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @return the matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByPermissionId(long permissionId) {
		return findByPermissionId(
			permissionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permission detail entries where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @return the range of matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByPermissionId(
		long permissionId, int start, int end) {

		return findByPermissionId(permissionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the permission detail entries where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByPermissionId(
		long permissionId, int start, int end,
		OrderByComparator<PermissionDetailEntry> orderByComparator) {

		return findByPermissionId(
			permissionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the permission detail entries where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findByPermissionId(
		long permissionId, int start, int end,
		OrderByComparator<PermissionDetailEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPermissionId;
				finderArgs = new Object[] {permissionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPermissionId;
			finderArgs = new Object[] {
				permissionId, start, end, orderByComparator
			};
		}

		List<PermissionDetailEntry> list = null;

		if (useFinderCache) {
			list = (List<PermissionDetailEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PermissionDetailEntry permissionDetailEntry : list) {
					if (permissionId !=
							permissionDetailEntry.getPermissionId()) {

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

			sb.append(_SQL_SELECT_PERMISSIONDETAILENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PERMISSIONID_PERMISSIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PermissionDetailEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(permissionId);

				list = (List<PermissionDetailEntry>)QueryUtil.list(
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
	 * Returns the first permission detail entry in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry findByPermissionId_First(
			long permissionId,
			OrderByComparator<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException {

		PermissionDetailEntry permissionDetailEntry = fetchByPermissionId_First(
			permissionId, orderByComparator);

		if (permissionDetailEntry != null) {
			return permissionDetailEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("permissionId=");
		sb.append(permissionId);

		sb.append("}");

		throw new NoSuchPermissionDetailEntryException(sb.toString());
	}

	/**
	 * Returns the first permission detail entry in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry fetchByPermissionId_First(
		long permissionId,
		OrderByComparator<PermissionDetailEntry> orderByComparator) {

		List<PermissionDetailEntry> list = findByPermissionId(
			permissionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last permission detail entry in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry findByPermissionId_Last(
			long permissionId,
			OrderByComparator<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException {

		PermissionDetailEntry permissionDetailEntry = fetchByPermissionId_Last(
			permissionId, orderByComparator);

		if (permissionDetailEntry != null) {
			return permissionDetailEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("permissionId=");
		sb.append(permissionId);

		sb.append("}");

		throw new NoSuchPermissionDetailEntryException(sb.toString());
	}

	/**
	 * Returns the last permission detail entry in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry fetchByPermissionId_Last(
		long permissionId,
		OrderByComparator<PermissionDetailEntry> orderByComparator) {

		int count = countByPermissionId(permissionId);

		if (count == 0) {
			return null;
		}

		List<PermissionDetailEntry> list = findByPermissionId(
			permissionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the permission detail entries before and after the current permission detail entry in the ordered set where permissionId = &#63;.
	 *
	 * @param id the primary key of the current permission detail entry
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	@Override
	public PermissionDetailEntry[] findByPermissionId_PrevAndNext(
			long id, long permissionId,
			OrderByComparator<PermissionDetailEntry> orderByComparator)
		throws NoSuchPermissionDetailEntryException {

		PermissionDetailEntry permissionDetailEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PermissionDetailEntry[] array = new PermissionDetailEntryImpl[3];

			array[0] = getByPermissionId_PrevAndNext(
				session, permissionDetailEntry, permissionId, orderByComparator,
				true);

			array[1] = permissionDetailEntry;

			array[2] = getByPermissionId_PrevAndNext(
				session, permissionDetailEntry, permissionId, orderByComparator,
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

	protected PermissionDetailEntry getByPermissionId_PrevAndNext(
		Session session, PermissionDetailEntry permissionDetailEntry,
		long permissionId,
		OrderByComparator<PermissionDetailEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_PERMISSIONDETAILENTRY_WHERE);

		sb.append(_FINDER_COLUMN_PERMISSIONID_PERMISSIONID_2);

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
			sb.append(PermissionDetailEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(permissionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						permissionDetailEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PermissionDetailEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the permission detail entries where permissionId = &#63; from the database.
	 *
	 * @param permissionId the permission ID
	 */
	@Override
	public void removeByPermissionId(long permissionId) {
		for (PermissionDetailEntry permissionDetailEntry :
				findByPermissionId(
					permissionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(permissionDetailEntry);
		}
	}

	/**
	 * Returns the number of permission detail entries where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @return the number of matching permission detail entries
	 */
	@Override
	public int countByPermissionId(long permissionId) {
		FinderPath finderPath = _finderPathCountByPermissionId;

		Object[] finderArgs = new Object[] {permissionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERMISSIONDETAILENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PERMISSIONID_PERMISSIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(permissionId);

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

	private static final String _FINDER_COLUMN_PERMISSIONID_PERMISSIONID_2 =
		"permissionDetailEntry.permissionId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the permission detail entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPermissionDetailEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermissionDetailEntryException {

		PermissionDetailEntry permissionDetailEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (permissionDetailEntry == null) {
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

			throw new NoSuchPermissionDetailEntryException(sb.toString());
		}

		return permissionDetailEntry;
	}

	/**
	 * Returns the permission detail entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the permission detail entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching permission detail entry, or <code>null</code> if a matching permission detail entry could not be found
	 */
	@Override
	public PermissionDetailEntry fetchByC_ERC(
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

		if (result instanceof PermissionDetailEntry) {
			PermissionDetailEntry permissionDetailEntry =
				(PermissionDetailEntry)result;

			if ((companyId != permissionDetailEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					permissionDetailEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PERMISSIONDETAILENTRY_WHERE);

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

				List<PermissionDetailEntry> list = query.list();

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
								"PermissionDetailEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PermissionDetailEntry permissionDetailEntry = list.get(0);

					result = permissionDetailEntry;

					cacheResult(permissionDetailEntry);
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
			return (PermissionDetailEntry)result;
		}
	}

	/**
	 * Removes the permission detail entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the permission detail entry that was removed
	 */
	@Override
	public PermissionDetailEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermissionDetailEntryException {

		PermissionDetailEntry permissionDetailEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(permissionDetailEntry);
	}

	/**
	 * Returns the number of permission detail entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching permission detail entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERMISSIONDETAILENTRY_WHERE);

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
		"permissionDetailEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"permissionDetailEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(permissionDetailEntry.externalReferenceCode IS NULL OR permissionDetailEntry.externalReferenceCode = '')";

	public PermissionDetailEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PermissionDetailEntry.class);

		setModelImplClass(PermissionDetailEntryImpl.class);
		setModelPKClass(long.class);

		setTable(PermissionDetailEntryTable.INSTANCE);
	}

	/**
	 * Caches the permission detail entry in the entity cache if it is enabled.
	 *
	 * @param permissionDetailEntry the permission detail entry
	 */
	@Override
	public void cacheResult(PermissionDetailEntry permissionDetailEntry) {
		entityCache.putResult(
			PermissionDetailEntryImpl.class,
			permissionDetailEntry.getPrimaryKey(), permissionDetailEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				permissionDetailEntry.getCompanyId(),
				permissionDetailEntry.getExternalReferenceCode()
			},
			permissionDetailEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the permission detail entries in the entity cache if it is enabled.
	 *
	 * @param permissionDetailEntries the permission detail entries
	 */
	@Override
	public void cacheResult(
		List<PermissionDetailEntry> permissionDetailEntries) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (permissionDetailEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PermissionDetailEntry permissionDetailEntry :
				permissionDetailEntries) {

			if (entityCache.getResult(
					PermissionDetailEntryImpl.class,
					permissionDetailEntry.getPrimaryKey()) == null) {

				cacheResult(permissionDetailEntry);
			}
		}
	}

	/**
	 * Clears the cache for all permission detail entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PermissionDetailEntryImpl.class);

		finderCache.clearCache(PermissionDetailEntryImpl.class);
	}

	/**
	 * Clears the cache for the permission detail entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PermissionDetailEntry permissionDetailEntry) {
		entityCache.removeResult(
			PermissionDetailEntryImpl.class, permissionDetailEntry);
	}

	@Override
	public void clearCache(
		List<PermissionDetailEntry> permissionDetailEntries) {

		for (PermissionDetailEntry permissionDetailEntry :
				permissionDetailEntries) {

			entityCache.removeResult(
				PermissionDetailEntryImpl.class, permissionDetailEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PermissionDetailEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				PermissionDetailEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PermissionDetailEntryModelImpl permissionDetailEntryModelImpl) {

		Object[] args = new Object[] {
			permissionDetailEntryModelImpl.getCompanyId(),
			permissionDetailEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, permissionDetailEntryModelImpl);
	}

	/**
	 * Creates a new permission detail entry with the primary key. Does not add the permission detail entry to the database.
	 *
	 * @param id the primary key for the new permission detail entry
	 * @return the new permission detail entry
	 */
	@Override
	public PermissionDetailEntry create(long id) {
		PermissionDetailEntry permissionDetailEntry =
			new PermissionDetailEntryImpl();

		permissionDetailEntry.setNew(true);
		permissionDetailEntry.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		permissionDetailEntry.setUuid(uuid);

		permissionDetailEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return permissionDetailEntry;
	}

	/**
	 * Removes the permission detail entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the permission detail entry
	 * @return the permission detail entry that was removed
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	@Override
	public PermissionDetailEntry remove(long id)
		throws NoSuchPermissionDetailEntryException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the permission detail entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the permission detail entry
	 * @return the permission detail entry that was removed
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	@Override
	public PermissionDetailEntry remove(Serializable primaryKey)
		throws NoSuchPermissionDetailEntryException {

		Session session = null;

		try {
			session = openSession();

			PermissionDetailEntry permissionDetailEntry =
				(PermissionDetailEntry)session.get(
					PermissionDetailEntryImpl.class, primaryKey);

			if (permissionDetailEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPermissionDetailEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(permissionDetailEntry);
		}
		catch (NoSuchPermissionDetailEntryException noSuchEntityException) {
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
	protected PermissionDetailEntry removeImpl(
		PermissionDetailEntry permissionDetailEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(permissionDetailEntry)) {
				permissionDetailEntry = (PermissionDetailEntry)session.get(
					PermissionDetailEntryImpl.class,
					permissionDetailEntry.getPrimaryKeyObj());
			}

			if (permissionDetailEntry != null) {
				session.delete(permissionDetailEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (permissionDetailEntry != null) {
			clearCache(permissionDetailEntry);
		}

		return permissionDetailEntry;
	}

	@Override
	public PermissionDetailEntry updateImpl(
		PermissionDetailEntry permissionDetailEntry) {

		boolean isNew = permissionDetailEntry.isNew();

		if (!(permissionDetailEntry instanceof
				PermissionDetailEntryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(permissionDetailEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					permissionDetailEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in permissionDetailEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PermissionDetailEntry implementation " +
					permissionDetailEntry.getClass());
		}

		PermissionDetailEntryModelImpl permissionDetailEntryModelImpl =
			(PermissionDetailEntryModelImpl)permissionDetailEntry;

		if (Validator.isNull(permissionDetailEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			permissionDetailEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(permissionDetailEntry);
			}
			else {
				permissionDetailEntry = (PermissionDetailEntry)session.merge(
					permissionDetailEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PermissionDetailEntryImpl.class, permissionDetailEntryModelImpl,
			false, true);

		cacheUniqueFindersCache(permissionDetailEntryModelImpl);

		if (isNew) {
			permissionDetailEntry.setNew(false);
		}

		permissionDetailEntry.resetOriginalValues();

		return permissionDetailEntry;
	}

	/**
	 * Returns the permission detail entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the permission detail entry
	 * @return the permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	@Override
	public PermissionDetailEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPermissionDetailEntryException {

		PermissionDetailEntry permissionDetailEntry = fetchByPrimaryKey(
			primaryKey);

		if (permissionDetailEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPermissionDetailEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return permissionDetailEntry;
	}

	/**
	 * Returns the permission detail entry with the primary key or throws a <code>NoSuchPermissionDetailEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the permission detail entry
	 * @return the permission detail entry
	 * @throws NoSuchPermissionDetailEntryException if a permission detail entry with the primary key could not be found
	 */
	@Override
	public PermissionDetailEntry findByPrimaryKey(long id)
		throws NoSuchPermissionDetailEntryException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the permission detail entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the permission detail entry
	 * @return the permission detail entry, or <code>null</code> if a permission detail entry with the primary key could not be found
	 */
	@Override
	public PermissionDetailEntry fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the permission detail entries.
	 *
	 * @return the permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permission detail entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @return the range of permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the permission detail entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findAll(
		int start, int end,
		OrderByComparator<PermissionDetailEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the permission detail entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission detail entries
	 * @param end the upper bound of the range of permission detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of permission detail entries
	 */
	@Override
	public List<PermissionDetailEntry> findAll(
		int start, int end,
		OrderByComparator<PermissionDetailEntry> orderByComparator,
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

		List<PermissionDetailEntry> list = null;

		if (useFinderCache) {
			list = (List<PermissionDetailEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERMISSIONDETAILENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERMISSIONDETAILENTRY;

				sql = sql.concat(PermissionDetailEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PermissionDetailEntry>)QueryUtil.list(
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
	 * Removes all the permission detail entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PermissionDetailEntry permissionDetailEntry : findAll()) {
			remove(permissionDetailEntry);
		}
	}

	/**
	 * Returns the number of permission detail entries.
	 *
	 * @return the number of permission detail entries
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
					_SQL_COUNT_PERMISSIONDETAILENTRY);

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
		return _SQL_SELECT_PERMISSIONDETAILENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PermissionDetailEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the permission detail entry persistence.
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

		_finderPathWithPaginationFindByPermissionId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPermissionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"permissionId"}, true);

		_finderPathWithoutPaginationFindByPermissionId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPermissionId",
			new String[] {Long.class.getName()}, new String[] {"permissionId"},
			true);

		_finderPathCountByPermissionId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPermissionId",
			new String[] {Long.class.getName()}, new String[] {"permissionId"},
			false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setPermissionDetailEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPermissionDetailEntryUtilPersistence(null);

		entityCache.removeCache(PermissionDetailEntryImpl.class.getName());
	}

	private void _setPermissionDetailEntryUtilPersistence(
		PermissionDetailEntryPersistence permissionDetailEntryPersistence) {

		try {
			Field field = PermissionDetailEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, permissionDetailEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_ACCOUNTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_ACCOUNTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_ACCOUNTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PERMISSIONDETAILENTRY =
		"SELECT permissionDetailEntry FROM PermissionDetailEntry permissionDetailEntry";

	private static final String _SQL_SELECT_PERMISSIONDETAILENTRY_WHERE =
		"SELECT permissionDetailEntry FROM PermissionDetailEntry permissionDetailEntry WHERE ";

	private static final String _SQL_COUNT_PERMISSIONDETAILENTRY =
		"SELECT COUNT(permissionDetailEntry) FROM PermissionDetailEntry permissionDetailEntry";

	private static final String _SQL_COUNT_PERMISSIONDETAILENTRY_WHERE =
		"SELECT COUNT(permissionDetailEntry) FROM PermissionDetailEntry permissionDetailEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"permissionDetailEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PermissionDetailEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PermissionDetailEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PermissionDetailEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PermissionDetailEntryModelArgumentsResolver
		_permissionDetailEntryModelArgumentsResolver;

}