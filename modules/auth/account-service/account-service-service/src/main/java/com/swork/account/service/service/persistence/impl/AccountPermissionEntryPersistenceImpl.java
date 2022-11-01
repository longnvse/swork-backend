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

import com.swork.account.service.exception.NoSuchAccountPermissionEntryException;
import com.swork.account.service.model.AccountPermissionEntry;
import com.swork.account.service.model.AccountPermissionEntryTable;
import com.swork.account.service.model.impl.AccountPermissionEntryImpl;
import com.swork.account.service.model.impl.AccountPermissionEntryModelImpl;
import com.swork.account.service.service.persistence.AccountPermissionEntryPersistence;
import com.swork.account.service.service.persistence.AccountPermissionEntryUtil;
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
 * The persistence implementation for the account permission entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {AccountPermissionEntryPersistence.class, BasePersistence.class}
)
public class AccountPermissionEntryPersistenceImpl
	extends BasePersistenceImpl<AccountPermissionEntry>
	implements AccountPermissionEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AccountPermissionEntryUtil</code> to access the account permission entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AccountPermissionEntryImpl.class.getName();

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
	 * Returns all the account permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the account permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @return the range of matching account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the account permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the account permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator,
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

		List<AccountPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<AccountPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AccountPermissionEntry accountPermissionEntry : list) {
					if (!uuid.equals(accountPermissionEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_ACCOUNTPERMISSIONENTRY_WHERE);

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
				sb.append(AccountPermissionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AccountPermissionEntry>)QueryUtil.list(
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
	 * Returns the first account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry findByUuid_First(
			String uuid,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException {

		AccountPermissionEntry accountPermissionEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (accountPermissionEntry != null) {
			return accountPermissionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAccountPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		List<AccountPermissionEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry findByUuid_Last(
			String uuid,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException {

		AccountPermissionEntry accountPermissionEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (accountPermissionEntry != null) {
			return accountPermissionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAccountPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AccountPermissionEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the account permission entries before and after the current account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current account permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	@Override
	public AccountPermissionEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException {

		uuid = Objects.toString(uuid, "");

		AccountPermissionEntry accountPermissionEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AccountPermissionEntry[] array = new AccountPermissionEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, accountPermissionEntry, uuid, orderByComparator, true);

			array[1] = accountPermissionEntry;

			array[2] = getByUuid_PrevAndNext(
				session, accountPermissionEntry, uuid, orderByComparator,
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

	protected AccountPermissionEntry getByUuid_PrevAndNext(
		Session session, AccountPermissionEntry accountPermissionEntry,
		String uuid,
		OrderByComparator<AccountPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_ACCOUNTPERMISSIONENTRY_WHERE);

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
			sb.append(AccountPermissionEntryModelImpl.ORDER_BY_JPQL);
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
						accountPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AccountPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the account permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AccountPermissionEntry accountPermissionEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(accountPermissionEntry);
		}
	}

	/**
	 * Returns the number of account permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account permission entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACCOUNTPERMISSIONENTRY_WHERE);

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
		"accountPermissionEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(accountPermissionEntry.uuid IS NULL OR accountPermissionEntry.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @return the range of matching account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator,
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

		List<AccountPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<AccountPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AccountPermissionEntry accountPermissionEntry : list) {
					if (!uuid.equals(accountPermissionEntry.getUuid()) ||
						(companyId != accountPermissionEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ACCOUNTPERMISSIONENTRY_WHERE);

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
				sb.append(AccountPermissionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AccountPermissionEntry>)QueryUtil.list(
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
	 * Returns the first account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException {

		AccountPermissionEntry accountPermissionEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (accountPermissionEntry != null) {
			return accountPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAccountPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the first account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		List<AccountPermissionEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException {

		AccountPermissionEntry accountPermissionEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (accountPermissionEntry != null) {
			return accountPermissionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAccountPermissionEntryException(sb.toString());
	}

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AccountPermissionEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the account permission entries before and after the current account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current account permission entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	@Override
	public AccountPermissionEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException {

		uuid = Objects.toString(uuid, "");

		AccountPermissionEntry accountPermissionEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AccountPermissionEntry[] array = new AccountPermissionEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, accountPermissionEntry, uuid, companyId,
				orderByComparator, true);

			array[1] = accountPermissionEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, accountPermissionEntry, uuid, companyId,
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

	protected AccountPermissionEntry getByUuid_C_PrevAndNext(
		Session session, AccountPermissionEntry accountPermissionEntry,
		String uuid, long companyId,
		OrderByComparator<AccountPermissionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_ACCOUNTPERMISSIONENTRY_WHERE);

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
			sb.append(AccountPermissionEntryModelImpl.ORDER_BY_JPQL);
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
						accountPermissionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AccountPermissionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the account permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AccountPermissionEntry accountPermissionEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(accountPermissionEntry);
		}
	}

	/**
	 * Returns the number of account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account permission entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACCOUNTPERMISSIONENTRY_WHERE);

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
		"accountPermissionEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(accountPermissionEntry.uuid IS NULL OR accountPermissionEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"accountPermissionEntry.companyId = ?";

	private FinderPath _finderPathFetchByAccountId;
	private FinderPath _finderPathCountByAccountId;

	/**
	 * Returns the account permission entry where accountId = &#63; or throws a <code>NoSuchAccountPermissionEntryException</code> if it could not be found.
	 *
	 * @param accountId the account ID
	 * @return the matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry findByAccountId(long accountId)
		throws NoSuchAccountPermissionEntryException {

		AccountPermissionEntry accountPermissionEntry = fetchByAccountId(
			accountId);

		if (accountPermissionEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("accountId=");
			sb.append(accountId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAccountPermissionEntryException(sb.toString());
		}

		return accountPermissionEntry;
	}

	/**
	 * Returns the account permission entry where accountId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param accountId the account ID
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry fetchByAccountId(long accountId) {
		return fetchByAccountId(accountId, true);
	}

	/**
	 * Returns the account permission entry where accountId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param accountId the account ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry fetchByAccountId(
		long accountId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {accountId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByAccountId, finderArgs);
		}

		if (result instanceof AccountPermissionEntry) {
			AccountPermissionEntry accountPermissionEntry =
				(AccountPermissionEntry)result;

			if (accountId != accountPermissionEntry.getAccountId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ACCOUNTPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(accountId);

				List<AccountPermissionEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByAccountId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {accountId};
							}

							_log.warn(
								"AccountPermissionEntryPersistenceImpl.fetchByAccountId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AccountPermissionEntry accountPermissionEntry = list.get(0);

					result = accountPermissionEntry;

					cacheResult(accountPermissionEntry);
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
			return (AccountPermissionEntry)result;
		}
	}

	/**
	 * Removes the account permission entry where accountId = &#63; from the database.
	 *
	 * @param accountId the account ID
	 * @return the account permission entry that was removed
	 */
	@Override
	public AccountPermissionEntry removeByAccountId(long accountId)
		throws NoSuchAccountPermissionEntryException {

		AccountPermissionEntry accountPermissionEntry = findByAccountId(
			accountId);

		return remove(accountPermissionEntry);
	}

	/**
	 * Returns the number of account permission entries where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the number of matching account permission entries
	 */
	@Override
	public int countByAccountId(long accountId) {
		FinderPath finderPath = _finderPathCountByAccountId;

		Object[] finderArgs = new Object[] {accountId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACCOUNTPERMISSIONENTRY_WHERE);

			sb.append(_FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(accountId);

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

	private static final String _FINDER_COLUMN_ACCOUNTID_ACCOUNTID_2 =
		"accountPermissionEntry.accountId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the account permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAccountPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAccountPermissionEntryException {

		AccountPermissionEntry accountPermissionEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (accountPermissionEntry == null) {
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

			throw new NoSuchAccountPermissionEntryException(sb.toString());
		}

		return accountPermissionEntry;
	}

	/**
	 * Returns the account permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the account permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	@Override
	public AccountPermissionEntry fetchByC_ERC(
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

		if (result instanceof AccountPermissionEntry) {
			AccountPermissionEntry accountPermissionEntry =
				(AccountPermissionEntry)result;

			if ((companyId != accountPermissionEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					accountPermissionEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ACCOUNTPERMISSIONENTRY_WHERE);

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

				List<AccountPermissionEntry> list = query.list();

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
								"AccountPermissionEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AccountPermissionEntry accountPermissionEntry = list.get(0);

					result = accountPermissionEntry;

					cacheResult(accountPermissionEntry);
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
			return (AccountPermissionEntry)result;
		}
	}

	/**
	 * Removes the account permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the account permission entry that was removed
	 */
	@Override
	public AccountPermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAccountPermissionEntryException {

		AccountPermissionEntry accountPermissionEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(accountPermissionEntry);
	}

	/**
	 * Returns the number of account permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching account permission entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACCOUNTPERMISSIONENTRY_WHERE);

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
		"accountPermissionEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"accountPermissionEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(accountPermissionEntry.externalReferenceCode IS NULL OR accountPermissionEntry.externalReferenceCode = '')";

	public AccountPermissionEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AccountPermissionEntry.class);

		setModelImplClass(AccountPermissionEntryImpl.class);
		setModelPKClass(long.class);

		setTable(AccountPermissionEntryTable.INSTANCE);
	}

	/**
	 * Caches the account permission entry in the entity cache if it is enabled.
	 *
	 * @param accountPermissionEntry the account permission entry
	 */
	@Override
	public void cacheResult(AccountPermissionEntry accountPermissionEntry) {
		entityCache.putResult(
			AccountPermissionEntryImpl.class,
			accountPermissionEntry.getPrimaryKey(), accountPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByAccountId,
			new Object[] {accountPermissionEntry.getAccountId()},
			accountPermissionEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				accountPermissionEntry.getCompanyId(),
				accountPermissionEntry.getExternalReferenceCode()
			},
			accountPermissionEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the account permission entries in the entity cache if it is enabled.
	 *
	 * @param accountPermissionEntries the account permission entries
	 */
	@Override
	public void cacheResult(
		List<AccountPermissionEntry> accountPermissionEntries) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (accountPermissionEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AccountPermissionEntry accountPermissionEntry :
				accountPermissionEntries) {

			if (entityCache.getResult(
					AccountPermissionEntryImpl.class,
					accountPermissionEntry.getPrimaryKey()) == null) {

				cacheResult(accountPermissionEntry);
			}
		}
	}

	/**
	 * Clears the cache for all account permission entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AccountPermissionEntryImpl.class);

		finderCache.clearCache(AccountPermissionEntryImpl.class);
	}

	/**
	 * Clears the cache for the account permission entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AccountPermissionEntry accountPermissionEntry) {
		entityCache.removeResult(
			AccountPermissionEntryImpl.class, accountPermissionEntry);
	}

	@Override
	public void clearCache(
		List<AccountPermissionEntry> accountPermissionEntries) {

		for (AccountPermissionEntry accountPermissionEntry :
				accountPermissionEntries) {

			entityCache.removeResult(
				AccountPermissionEntryImpl.class, accountPermissionEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AccountPermissionEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				AccountPermissionEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AccountPermissionEntryModelImpl accountPermissionEntryModelImpl) {

		Object[] args = new Object[] {
			accountPermissionEntryModelImpl.getAccountId()
		};

		finderCache.putResult(
			_finderPathCountByAccountId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByAccountId, args, accountPermissionEntryModelImpl);

		args = new Object[] {
			accountPermissionEntryModelImpl.getCompanyId(),
			accountPermissionEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, accountPermissionEntryModelImpl);
	}

	/**
	 * Creates a new account permission entry with the primary key. Does not add the account permission entry to the database.
	 *
	 * @param id the primary key for the new account permission entry
	 * @return the new account permission entry
	 */
	@Override
	public AccountPermissionEntry create(long id) {
		AccountPermissionEntry accountPermissionEntry =
			new AccountPermissionEntryImpl();

		accountPermissionEntry.setNew(true);
		accountPermissionEntry.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		accountPermissionEntry.setUuid(uuid);

		accountPermissionEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return accountPermissionEntry;
	}

	/**
	 * Removes the account permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry that was removed
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	@Override
	public AccountPermissionEntry remove(long id)
		throws NoSuchAccountPermissionEntryException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the account permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the account permission entry
	 * @return the account permission entry that was removed
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	@Override
	public AccountPermissionEntry remove(Serializable primaryKey)
		throws NoSuchAccountPermissionEntryException {

		Session session = null;

		try {
			session = openSession();

			AccountPermissionEntry accountPermissionEntry =
				(AccountPermissionEntry)session.get(
					AccountPermissionEntryImpl.class, primaryKey);

			if (accountPermissionEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAccountPermissionEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(accountPermissionEntry);
		}
		catch (NoSuchAccountPermissionEntryException noSuchEntityException) {
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
	protected AccountPermissionEntry removeImpl(
		AccountPermissionEntry accountPermissionEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(accountPermissionEntry)) {
				accountPermissionEntry = (AccountPermissionEntry)session.get(
					AccountPermissionEntryImpl.class,
					accountPermissionEntry.getPrimaryKeyObj());
			}

			if (accountPermissionEntry != null) {
				session.delete(accountPermissionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (accountPermissionEntry != null) {
			clearCache(accountPermissionEntry);
		}

		return accountPermissionEntry;
	}

	@Override
	public AccountPermissionEntry updateImpl(
		AccountPermissionEntry accountPermissionEntry) {

		boolean isNew = accountPermissionEntry.isNew();

		if (!(accountPermissionEntry instanceof
				AccountPermissionEntryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(accountPermissionEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					accountPermissionEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in accountPermissionEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AccountPermissionEntry implementation " +
					accountPermissionEntry.getClass());
		}

		AccountPermissionEntryModelImpl accountPermissionEntryModelImpl =
			(AccountPermissionEntryModelImpl)accountPermissionEntry;

		if (Validator.isNull(accountPermissionEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			accountPermissionEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(accountPermissionEntry);
			}
			else {
				accountPermissionEntry = (AccountPermissionEntry)session.merge(
					accountPermissionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AccountPermissionEntryImpl.class, accountPermissionEntryModelImpl,
			false, true);

		cacheUniqueFindersCache(accountPermissionEntryModelImpl);

		if (isNew) {
			accountPermissionEntry.setNew(false);
		}

		accountPermissionEntry.resetOriginalValues();

		return accountPermissionEntry;
	}

	/**
	 * Returns the account permission entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the account permission entry
	 * @return the account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	@Override
	public AccountPermissionEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAccountPermissionEntryException {

		AccountPermissionEntry accountPermissionEntry = fetchByPrimaryKey(
			primaryKey);

		if (accountPermissionEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAccountPermissionEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return accountPermissionEntry;
	}

	/**
	 * Returns the account permission entry with the primary key or throws a <code>NoSuchAccountPermissionEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	@Override
	public AccountPermissionEntry findByPrimaryKey(long id)
		throws NoSuchAccountPermissionEntryException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the account permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry, or <code>null</code> if a account permission entry with the primary key could not be found
	 */
	@Override
	public AccountPermissionEntry fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the account permission entries.
	 *
	 * @return the account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the account permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @return the range of account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the account permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the account permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permission entries
	 * @param end the upper bound of the range of account permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of account permission entries
	 */
	@Override
	public List<AccountPermissionEntry> findAll(
		int start, int end,
		OrderByComparator<AccountPermissionEntry> orderByComparator,
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

		List<AccountPermissionEntry> list = null;

		if (useFinderCache) {
			list = (List<AccountPermissionEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ACCOUNTPERMISSIONENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ACCOUNTPERMISSIONENTRY;

				sql = sql.concat(AccountPermissionEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AccountPermissionEntry>)QueryUtil.list(
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
	 * Removes all the account permission entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AccountPermissionEntry accountPermissionEntry : findAll()) {
			remove(accountPermissionEntry);
		}
	}

	/**
	 * Returns the number of account permission entries.
	 *
	 * @return the number of account permission entries
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
					_SQL_COUNT_ACCOUNTPERMISSIONENTRY);

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
		return _SQL_SELECT_ACCOUNTPERMISSIONENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AccountPermissionEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the account permission entry persistence.
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

		_finderPathFetchByAccountId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByAccountId",
			new String[] {Long.class.getName()}, new String[] {"accountId"},
			true);

		_finderPathCountByAccountId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAccountId",
			new String[] {Long.class.getName()}, new String[] {"accountId"},
			false);

		_finderPathFetchByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, true);

		_finderPathCountByC_ERC = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "externalReferenceCode"}, false);

		_setAccountPermissionEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAccountPermissionEntryUtilPersistence(null);

		entityCache.removeCache(AccountPermissionEntryImpl.class.getName());
	}

	private void _setAccountPermissionEntryUtilPersistence(
		AccountPermissionEntryPersistence accountPermissionEntryPersistence) {

		try {
			Field field = AccountPermissionEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, accountPermissionEntryPersistence);
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

	private static final String _SQL_SELECT_ACCOUNTPERMISSIONENTRY =
		"SELECT accountPermissionEntry FROM AccountPermissionEntry accountPermissionEntry";

	private static final String _SQL_SELECT_ACCOUNTPERMISSIONENTRY_WHERE =
		"SELECT accountPermissionEntry FROM AccountPermissionEntry accountPermissionEntry WHERE ";

	private static final String _SQL_COUNT_ACCOUNTPERMISSIONENTRY =
		"SELECT COUNT(accountPermissionEntry) FROM AccountPermissionEntry accountPermissionEntry";

	private static final String _SQL_COUNT_ACCOUNTPERMISSIONENTRY_WHERE =
		"SELECT COUNT(accountPermissionEntry) FROM AccountPermissionEntry accountPermissionEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"accountPermissionEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AccountPermissionEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AccountPermissionEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AccountPermissionEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AccountPermissionEntryModelArgumentsResolver
		_accountPermissionEntryModelArgumentsResolver;

}