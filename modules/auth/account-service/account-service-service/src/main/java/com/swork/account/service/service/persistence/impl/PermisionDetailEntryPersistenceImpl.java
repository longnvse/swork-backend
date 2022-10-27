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

import com.swork.account.service.exception.NoSuchPermisionDetailEntryException;
import com.swork.account.service.model.PermisionDetailEntry;
import com.swork.account.service.model.PermisionDetailEntryTable;
import com.swork.account.service.model.impl.PermisionDetailEntryImpl;
import com.swork.account.service.model.impl.PermisionDetailEntryModelImpl;
import com.swork.account.service.service.persistence.PermisionDetailEntryPersistence;
import com.swork.account.service.service.persistence.PermisionDetailEntryUtil;
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
 * The persistence implementation for the permision detail entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {PermisionDetailEntryPersistence.class, BasePersistence.class}
)
public class PermisionDetailEntryPersistenceImpl
	extends BasePersistenceImpl<PermisionDetailEntry>
	implements PermisionDetailEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PermisionDetailEntryUtil</code> to access the permision detail entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PermisionDetailEntryImpl.class.getName();

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
	 * Returns all the permision detail entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permision detail entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permision detail entries
	 * @param end the upper bound of the range of permision detail entries (not inclusive)
	 * @return the range of matching permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the permision detail entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permision detail entries
	 * @param end the upper bound of the range of permision detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PermisionDetailEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the permision detail entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permision detail entries
	 * @param end the upper bound of the range of permision detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PermisionDetailEntry> orderByComparator,
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

		List<PermisionDetailEntry> list = null;

		if (useFinderCache) {
			list = (List<PermisionDetailEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PermisionDetailEntry permisionDetailEntry : list) {
					if (!uuid.equals(permisionDetailEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_PERMISIONDETAILENTRY_WHERE);

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
				sb.append(PermisionDetailEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PermisionDetailEntry>)QueryUtil.list(
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
	 * Returns the first permision detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a matching permision detail entry could not be found
	 */
	@Override
	public PermisionDetailEntry findByUuid_First(
			String uuid,
			OrderByComparator<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException {

		PermisionDetailEntry permisionDetailEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (permisionDetailEntry != null) {
			return permisionDetailEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPermisionDetailEntryException(sb.toString());
	}

	/**
	 * Returns the first permision detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	@Override
	public PermisionDetailEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<PermisionDetailEntry> orderByComparator) {

		List<PermisionDetailEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last permision detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a matching permision detail entry could not be found
	 */
	@Override
	public PermisionDetailEntry findByUuid_Last(
			String uuid,
			OrderByComparator<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException {

		PermisionDetailEntry permisionDetailEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (permisionDetailEntry != null) {
			return permisionDetailEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPermisionDetailEntryException(sb.toString());
	}

	/**
	 * Returns the last permision detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	@Override
	public PermisionDetailEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<PermisionDetailEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PermisionDetailEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the permision detail entries before and after the current permision detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current permision detail entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a permision detail entry with the primary key could not be found
	 */
	@Override
	public PermisionDetailEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException {

		uuid = Objects.toString(uuid, "");

		PermisionDetailEntry permisionDetailEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PermisionDetailEntry[] array = new PermisionDetailEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, permisionDetailEntry, uuid, orderByComparator, true);

			array[1] = permisionDetailEntry;

			array[2] = getByUuid_PrevAndNext(
				session, permisionDetailEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PermisionDetailEntry getByUuid_PrevAndNext(
		Session session, PermisionDetailEntry permisionDetailEntry, String uuid,
		OrderByComparator<PermisionDetailEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_PERMISIONDETAILENTRY_WHERE);

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
			sb.append(PermisionDetailEntryModelImpl.ORDER_BY_JPQL);
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
						permisionDetailEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PermisionDetailEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the permision detail entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PermisionDetailEntry permisionDetailEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(permisionDetailEntry);
		}
	}

	/**
	 * Returns the number of permision detail entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching permision detail entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERMISIONDETAILENTRY_WHERE);

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
		"permisionDetailEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(permisionDetailEntry.uuid IS NULL OR permisionDetailEntry.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the permision detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permision detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permision detail entries
	 * @param end the upper bound of the range of permision detail entries (not inclusive)
	 * @return the range of matching permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the permision detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permision detail entries
	 * @param end the upper bound of the range of permision detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PermisionDetailEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the permision detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permision detail entries
	 * @param end the upper bound of the range of permision detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PermisionDetailEntry> orderByComparator,
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

		List<PermisionDetailEntry> list = null;

		if (useFinderCache) {
			list = (List<PermisionDetailEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (PermisionDetailEntry permisionDetailEntry : list) {
					if (!uuid.equals(permisionDetailEntry.getUuid()) ||
						(companyId != permisionDetailEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PERMISIONDETAILENTRY_WHERE);

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
				sb.append(PermisionDetailEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PermisionDetailEntry>)QueryUtil.list(
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
	 * Returns the first permision detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a matching permision detail entry could not be found
	 */
	@Override
	public PermisionDetailEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException {

		PermisionDetailEntry permisionDetailEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (permisionDetailEntry != null) {
			return permisionDetailEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPermisionDetailEntryException(sb.toString());
	}

	/**
	 * Returns the first permision detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	@Override
	public PermisionDetailEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PermisionDetailEntry> orderByComparator) {

		List<PermisionDetailEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last permision detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a matching permision detail entry could not be found
	 */
	@Override
	public PermisionDetailEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException {

		PermisionDetailEntry permisionDetailEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (permisionDetailEntry != null) {
			return permisionDetailEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPermisionDetailEntryException(sb.toString());
	}

	/**
	 * Returns the last permision detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	@Override
	public PermisionDetailEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PermisionDetailEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PermisionDetailEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the permision detail entries before and after the current permision detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current permision detail entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a permision detail entry with the primary key could not be found
	 */
	@Override
	public PermisionDetailEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException {

		uuid = Objects.toString(uuid, "");

		PermisionDetailEntry permisionDetailEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PermisionDetailEntry[] array = new PermisionDetailEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, permisionDetailEntry, uuid, companyId,
				orderByComparator, true);

			array[1] = permisionDetailEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, permisionDetailEntry, uuid, companyId,
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

	protected PermisionDetailEntry getByUuid_C_PrevAndNext(
		Session session, PermisionDetailEntry permisionDetailEntry, String uuid,
		long companyId,
		OrderByComparator<PermisionDetailEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_PERMISIONDETAILENTRY_WHERE);

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
			sb.append(PermisionDetailEntryModelImpl.ORDER_BY_JPQL);
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
						permisionDetailEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PermisionDetailEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the permision detail entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PermisionDetailEntry permisionDetailEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(permisionDetailEntry);
		}
	}

	/**
	 * Returns the number of permision detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching permision detail entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERMISIONDETAILENTRY_WHERE);

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
		"permisionDetailEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(permisionDetailEntry.uuid IS NULL OR permisionDetailEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"permisionDetailEntry.companyId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the permision detail entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPermisionDetailEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a matching permision detail entry could not be found
	 */
	@Override
	public PermisionDetailEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermisionDetailEntryException {

		PermisionDetailEntry permisionDetailEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (permisionDetailEntry == null) {
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

			throw new NoSuchPermisionDetailEntryException(sb.toString());
		}

		return permisionDetailEntry;
	}

	/**
	 * Returns the permision detail entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	@Override
	public PermisionDetailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the permision detail entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	@Override
	public PermisionDetailEntry fetchByC_ERC(
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

		if (result instanceof PermisionDetailEntry) {
			PermisionDetailEntry permisionDetailEntry =
				(PermisionDetailEntry)result;

			if ((companyId != permisionDetailEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					permisionDetailEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PERMISIONDETAILENTRY_WHERE);

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

				List<PermisionDetailEntry> list = query.list();

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
								"PermisionDetailEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PermisionDetailEntry permisionDetailEntry = list.get(0);

					result = permisionDetailEntry;

					cacheResult(permisionDetailEntry);
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
			return (PermisionDetailEntry)result;
		}
	}

	/**
	 * Removes the permision detail entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the permision detail entry that was removed
	 */
	@Override
	public PermisionDetailEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermisionDetailEntryException {

		PermisionDetailEntry permisionDetailEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(permisionDetailEntry);
	}

	/**
	 * Returns the number of permision detail entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching permision detail entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERMISIONDETAILENTRY_WHERE);

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
		"permisionDetailEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"permisionDetailEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(permisionDetailEntry.externalReferenceCode IS NULL OR permisionDetailEntry.externalReferenceCode = '')";

	public PermisionDetailEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PermisionDetailEntry.class);

		setModelImplClass(PermisionDetailEntryImpl.class);
		setModelPKClass(long.class);

		setTable(PermisionDetailEntryTable.INSTANCE);
	}

	/**
	 * Caches the permision detail entry in the entity cache if it is enabled.
	 *
	 * @param permisionDetailEntry the permision detail entry
	 */
	@Override
	public void cacheResult(PermisionDetailEntry permisionDetailEntry) {
		entityCache.putResult(
			PermisionDetailEntryImpl.class,
			permisionDetailEntry.getPrimaryKey(), permisionDetailEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				permisionDetailEntry.getCompanyId(),
				permisionDetailEntry.getExternalReferenceCode()
			},
			permisionDetailEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the permision detail entries in the entity cache if it is enabled.
	 *
	 * @param permisionDetailEntries the permision detail entries
	 */
	@Override
	public void cacheResult(List<PermisionDetailEntry> permisionDetailEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (permisionDetailEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PermisionDetailEntry permisionDetailEntry :
				permisionDetailEntries) {

			if (entityCache.getResult(
					PermisionDetailEntryImpl.class,
					permisionDetailEntry.getPrimaryKey()) == null) {

				cacheResult(permisionDetailEntry);
			}
		}
	}

	/**
	 * Clears the cache for all permision detail entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PermisionDetailEntryImpl.class);

		finderCache.clearCache(PermisionDetailEntryImpl.class);
	}

	/**
	 * Clears the cache for the permision detail entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PermisionDetailEntry permisionDetailEntry) {
		entityCache.removeResult(
			PermisionDetailEntryImpl.class, permisionDetailEntry);
	}

	@Override
	public void clearCache(List<PermisionDetailEntry> permisionDetailEntries) {
		for (PermisionDetailEntry permisionDetailEntry :
				permisionDetailEntries) {

			entityCache.removeResult(
				PermisionDetailEntryImpl.class, permisionDetailEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PermisionDetailEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				PermisionDetailEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PermisionDetailEntryModelImpl permisionDetailEntryModelImpl) {

		Object[] args = new Object[] {
			permisionDetailEntryModelImpl.getCompanyId(),
			permisionDetailEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, permisionDetailEntryModelImpl);
	}

	/**
	 * Creates a new permision detail entry with the primary key. Does not add the permision detail entry to the database.
	 *
	 * @param id the primary key for the new permision detail entry
	 * @return the new permision detail entry
	 */
	@Override
	public PermisionDetailEntry create(long id) {
		PermisionDetailEntry permisionDetailEntry =
			new PermisionDetailEntryImpl();

		permisionDetailEntry.setNew(true);
		permisionDetailEntry.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		permisionDetailEntry.setUuid(uuid);

		permisionDetailEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return permisionDetailEntry;
	}

	/**
	 * Removes the permision detail entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the permision detail entry
	 * @return the permision detail entry that was removed
	 * @throws NoSuchPermisionDetailEntryException if a permision detail entry with the primary key could not be found
	 */
	@Override
	public PermisionDetailEntry remove(long id)
		throws NoSuchPermisionDetailEntryException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the permision detail entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the permision detail entry
	 * @return the permision detail entry that was removed
	 * @throws NoSuchPermisionDetailEntryException if a permision detail entry with the primary key could not be found
	 */
	@Override
	public PermisionDetailEntry remove(Serializable primaryKey)
		throws NoSuchPermisionDetailEntryException {

		Session session = null;

		try {
			session = openSession();

			PermisionDetailEntry permisionDetailEntry =
				(PermisionDetailEntry)session.get(
					PermisionDetailEntryImpl.class, primaryKey);

			if (permisionDetailEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPermisionDetailEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(permisionDetailEntry);
		}
		catch (NoSuchPermisionDetailEntryException noSuchEntityException) {
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
	protected PermisionDetailEntry removeImpl(
		PermisionDetailEntry permisionDetailEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(permisionDetailEntry)) {
				permisionDetailEntry = (PermisionDetailEntry)session.get(
					PermisionDetailEntryImpl.class,
					permisionDetailEntry.getPrimaryKeyObj());
			}

			if (permisionDetailEntry != null) {
				session.delete(permisionDetailEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (permisionDetailEntry != null) {
			clearCache(permisionDetailEntry);
		}

		return permisionDetailEntry;
	}

	@Override
	public PermisionDetailEntry updateImpl(
		PermisionDetailEntry permisionDetailEntry) {

		boolean isNew = permisionDetailEntry.isNew();

		if (!(permisionDetailEntry instanceof PermisionDetailEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(permisionDetailEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					permisionDetailEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in permisionDetailEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PermisionDetailEntry implementation " +
					permisionDetailEntry.getClass());
		}

		PermisionDetailEntryModelImpl permisionDetailEntryModelImpl =
			(PermisionDetailEntryModelImpl)permisionDetailEntry;

		if (Validator.isNull(permisionDetailEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			permisionDetailEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(permisionDetailEntry);
			}
			else {
				permisionDetailEntry = (PermisionDetailEntry)session.merge(
					permisionDetailEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PermisionDetailEntryImpl.class, permisionDetailEntryModelImpl,
			false, true);

		cacheUniqueFindersCache(permisionDetailEntryModelImpl);

		if (isNew) {
			permisionDetailEntry.setNew(false);
		}

		permisionDetailEntry.resetOriginalValues();

		return permisionDetailEntry;
	}

	/**
	 * Returns the permision detail entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the permision detail entry
	 * @return the permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a permision detail entry with the primary key could not be found
	 */
	@Override
	public PermisionDetailEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPermisionDetailEntryException {

		PermisionDetailEntry permisionDetailEntry = fetchByPrimaryKey(
			primaryKey);

		if (permisionDetailEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPermisionDetailEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return permisionDetailEntry;
	}

	/**
	 * Returns the permision detail entry with the primary key or throws a <code>NoSuchPermisionDetailEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the permision detail entry
	 * @return the permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a permision detail entry with the primary key could not be found
	 */
	@Override
	public PermisionDetailEntry findByPrimaryKey(long id)
		throws NoSuchPermisionDetailEntryException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the permision detail entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the permision detail entry
	 * @return the permision detail entry, or <code>null</code> if a permision detail entry with the primary key could not be found
	 */
	@Override
	public PermisionDetailEntry fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the permision detail entries.
	 *
	 * @return the permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permision detail entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permision detail entries
	 * @param end the upper bound of the range of permision detail entries (not inclusive)
	 * @return the range of permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the permision detail entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permision detail entries
	 * @param end the upper bound of the range of permision detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findAll(
		int start, int end,
		OrderByComparator<PermisionDetailEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the permision detail entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionDetailEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permision detail entries
	 * @param end the upper bound of the range of permision detail entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of permision detail entries
	 */
	@Override
	public List<PermisionDetailEntry> findAll(
		int start, int end,
		OrderByComparator<PermisionDetailEntry> orderByComparator,
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

		List<PermisionDetailEntry> list = null;

		if (useFinderCache) {
			list = (List<PermisionDetailEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERMISIONDETAILENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERMISIONDETAILENTRY;

				sql = sql.concat(PermisionDetailEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PermisionDetailEntry>)QueryUtil.list(
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
	 * Removes all the permision detail entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PermisionDetailEntry permisionDetailEntry : findAll()) {
			remove(permisionDetailEntry);
		}
	}

	/**
	 * Returns the number of permision detail entries.
	 *
	 * @return the number of permision detail entries
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
					_SQL_COUNT_PERMISIONDETAILENTRY);

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
		return _SQL_SELECT_PERMISIONDETAILENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PermisionDetailEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the permision detail entry persistence.
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

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setPermisionDetailEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPermisionDetailEntryUtilPersistence(null);

		entityCache.removeCache(PermisionDetailEntryImpl.class.getName());
	}

	private void _setPermisionDetailEntryUtilPersistence(
		PermisionDetailEntryPersistence permisionDetailEntryPersistence) {

		try {
			Field field = PermisionDetailEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, permisionDetailEntryPersistence);
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

	private static final String _SQL_SELECT_PERMISIONDETAILENTRY =
		"SELECT permisionDetailEntry FROM PermisionDetailEntry permisionDetailEntry";

	private static final String _SQL_SELECT_PERMISIONDETAILENTRY_WHERE =
		"SELECT permisionDetailEntry FROM PermisionDetailEntry permisionDetailEntry WHERE ";

	private static final String _SQL_COUNT_PERMISIONDETAILENTRY =
		"SELECT COUNT(permisionDetailEntry) FROM PermisionDetailEntry permisionDetailEntry";

	private static final String _SQL_COUNT_PERMISIONDETAILENTRY_WHERE =
		"SELECT COUNT(permisionDetailEntry) FROM PermisionDetailEntry permisionDetailEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"permisionDetailEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PermisionDetailEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PermisionDetailEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PermisionDetailEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PermisionDetailEntryModelArgumentsResolver
		_permisionDetailEntryModelArgumentsResolver;

}