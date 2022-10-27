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

import com.swork.account.service.exception.NoSuchAccountPermisionEntryException;
import com.swork.account.service.model.AccountPermisionEntry;
import com.swork.account.service.model.AccountPermisionEntryTable;
import com.swork.account.service.model.impl.AccountPermisionEntryImpl;
import com.swork.account.service.model.impl.AccountPermisionEntryModelImpl;
import com.swork.account.service.service.persistence.AccountPermisionEntryPersistence;
import com.swork.account.service.service.persistence.AccountPermisionEntryUtil;
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
 * The persistence implementation for the account permision entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {AccountPermisionEntryPersistence.class, BasePersistence.class}
)
public class AccountPermisionEntryPersistenceImpl
	extends BasePersistenceImpl<AccountPermisionEntry>
	implements AccountPermisionEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AccountPermisionEntryUtil</code> to access the account permision entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AccountPermisionEntryImpl.class.getName();

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
	 * Returns all the account permision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the account permision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @return the range of matching account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the account permision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the account permision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator,
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

		List<AccountPermisionEntry> list = null;

		if (useFinderCache) {
			list = (List<AccountPermisionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AccountPermisionEntry accountPermisionEntry : list) {
					if (!uuid.equals(accountPermisionEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_ACCOUNTPERMISIONENTRY_WHERE);

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
				sb.append(AccountPermisionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AccountPermisionEntry>)QueryUtil.list(
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
	 * Returns the first account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	@Override
	public AccountPermisionEntry findByUuid_First(
			String uuid,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException {

		AccountPermisionEntry accountPermisionEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (accountPermisionEntry != null) {
			return accountPermisionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAccountPermisionEntryException(sb.toString());
	}

	/**
	 * Returns the first account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	@Override
	public AccountPermisionEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		List<AccountPermisionEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	@Override
	public AccountPermisionEntry findByUuid_Last(
			String uuid,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException {

		AccountPermisionEntry accountPermisionEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (accountPermisionEntry != null) {
			return accountPermisionEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAccountPermisionEntryException(sb.toString());
	}

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	@Override
	public AccountPermisionEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AccountPermisionEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the account permision entries before and after the current account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current account permision entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	@Override
	public AccountPermisionEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException {

		uuid = Objects.toString(uuid, "");

		AccountPermisionEntry accountPermisionEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AccountPermisionEntry[] array = new AccountPermisionEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, accountPermisionEntry, uuid, orderByComparator, true);

			array[1] = accountPermisionEntry;

			array[2] = getByUuid_PrevAndNext(
				session, accountPermisionEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AccountPermisionEntry getByUuid_PrevAndNext(
		Session session, AccountPermisionEntry accountPermisionEntry,
		String uuid, OrderByComparator<AccountPermisionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_ACCOUNTPERMISIONENTRY_WHERE);

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
			sb.append(AccountPermisionEntryModelImpl.ORDER_BY_JPQL);
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
						accountPermisionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AccountPermisionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the account permision entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AccountPermisionEntry accountPermisionEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(accountPermisionEntry);
		}
	}

	/**
	 * Returns the number of account permision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account permision entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACCOUNTPERMISIONENTRY_WHERE);

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
		"accountPermisionEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(accountPermisionEntry.uuid IS NULL OR accountPermisionEntry.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @return the range of matching account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator,
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

		List<AccountPermisionEntry> list = null;

		if (useFinderCache) {
			list = (List<AccountPermisionEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AccountPermisionEntry accountPermisionEntry : list) {
					if (!uuid.equals(accountPermisionEntry.getUuid()) ||
						(companyId != accountPermisionEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ACCOUNTPERMISIONENTRY_WHERE);

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
				sb.append(AccountPermisionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AccountPermisionEntry>)QueryUtil.list(
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
	 * Returns the first account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	@Override
	public AccountPermisionEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException {

		AccountPermisionEntry accountPermisionEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (accountPermisionEntry != null) {
			return accountPermisionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAccountPermisionEntryException(sb.toString());
	}

	/**
	 * Returns the first account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	@Override
	public AccountPermisionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		List<AccountPermisionEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	@Override
	public AccountPermisionEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException {

		AccountPermisionEntry accountPermisionEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (accountPermisionEntry != null) {
			return accountPermisionEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAccountPermisionEntryException(sb.toString());
	}

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	@Override
	public AccountPermisionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AccountPermisionEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the account permision entries before and after the current account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current account permision entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	@Override
	public AccountPermisionEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException {

		uuid = Objects.toString(uuid, "");

		AccountPermisionEntry accountPermisionEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AccountPermisionEntry[] array = new AccountPermisionEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, accountPermisionEntry, uuid, companyId,
				orderByComparator, true);

			array[1] = accountPermisionEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, accountPermisionEntry, uuid, companyId,
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

	protected AccountPermisionEntry getByUuid_C_PrevAndNext(
		Session session, AccountPermisionEntry accountPermisionEntry,
		String uuid, long companyId,
		OrderByComparator<AccountPermisionEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_ACCOUNTPERMISIONENTRY_WHERE);

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
			sb.append(AccountPermisionEntryModelImpl.ORDER_BY_JPQL);
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
						accountPermisionEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AccountPermisionEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the account permision entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AccountPermisionEntry accountPermisionEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(accountPermisionEntry);
		}
	}

	/**
	 * Returns the number of account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account permision entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACCOUNTPERMISIONENTRY_WHERE);

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
		"accountPermisionEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(accountPermisionEntry.uuid IS NULL OR accountPermisionEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"accountPermisionEntry.companyId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the account permision entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAccountPermisionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	@Override
	public AccountPermisionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAccountPermisionEntryException {

		AccountPermisionEntry accountPermisionEntry = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (accountPermisionEntry == null) {
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

			throw new NoSuchAccountPermisionEntryException(sb.toString());
		}

		return accountPermisionEntry;
	}

	/**
	 * Returns the account permision entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	@Override
	public AccountPermisionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the account permision entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	@Override
	public AccountPermisionEntry fetchByC_ERC(
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

		if (result instanceof AccountPermisionEntry) {
			AccountPermisionEntry accountPermisionEntry =
				(AccountPermisionEntry)result;

			if ((companyId != accountPermisionEntry.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					accountPermisionEntry.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ACCOUNTPERMISIONENTRY_WHERE);

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

				List<AccountPermisionEntry> list = query.list();

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
								"AccountPermisionEntryPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AccountPermisionEntry accountPermisionEntry = list.get(0);

					result = accountPermisionEntry;

					cacheResult(accountPermisionEntry);
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
			return (AccountPermisionEntry)result;
		}
	}

	/**
	 * Removes the account permision entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the account permision entry that was removed
	 */
	@Override
	public AccountPermisionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAccountPermisionEntryException {

		AccountPermisionEntry accountPermisionEntry = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(accountPermisionEntry);
	}

	/**
	 * Returns the number of account permision entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching account permision entries
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACCOUNTPERMISIONENTRY_WHERE);

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
		"accountPermisionEntry.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"accountPermisionEntry.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(accountPermisionEntry.externalReferenceCode IS NULL OR accountPermisionEntry.externalReferenceCode = '')";

	public AccountPermisionEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AccountPermisionEntry.class);

		setModelImplClass(AccountPermisionEntryImpl.class);
		setModelPKClass(long.class);

		setTable(AccountPermisionEntryTable.INSTANCE);
	}

	/**
	 * Caches the account permision entry in the entity cache if it is enabled.
	 *
	 * @param accountPermisionEntry the account permision entry
	 */
	@Override
	public void cacheResult(AccountPermisionEntry accountPermisionEntry) {
		entityCache.putResult(
			AccountPermisionEntryImpl.class,
			accountPermisionEntry.getPrimaryKey(), accountPermisionEntry);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				accountPermisionEntry.getCompanyId(),
				accountPermisionEntry.getExternalReferenceCode()
			},
			accountPermisionEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the account permision entries in the entity cache if it is enabled.
	 *
	 * @param accountPermisionEntries the account permision entries
	 */
	@Override
	public void cacheResult(
		List<AccountPermisionEntry> accountPermisionEntries) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (accountPermisionEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AccountPermisionEntry accountPermisionEntry :
				accountPermisionEntries) {

			if (entityCache.getResult(
					AccountPermisionEntryImpl.class,
					accountPermisionEntry.getPrimaryKey()) == null) {

				cacheResult(accountPermisionEntry);
			}
		}
	}

	/**
	 * Clears the cache for all account permision entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AccountPermisionEntryImpl.class);

		finderCache.clearCache(AccountPermisionEntryImpl.class);
	}

	/**
	 * Clears the cache for the account permision entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AccountPermisionEntry accountPermisionEntry) {
		entityCache.removeResult(
			AccountPermisionEntryImpl.class, accountPermisionEntry);
	}

	@Override
	public void clearCache(
		List<AccountPermisionEntry> accountPermisionEntries) {

		for (AccountPermisionEntry accountPermisionEntry :
				accountPermisionEntries) {

			entityCache.removeResult(
				AccountPermisionEntryImpl.class, accountPermisionEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AccountPermisionEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				AccountPermisionEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AccountPermisionEntryModelImpl accountPermisionEntryModelImpl) {

		Object[] args = new Object[] {
			accountPermisionEntryModelImpl.getCompanyId(),
			accountPermisionEntryModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(_finderPathCountByC_ERC, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, accountPermisionEntryModelImpl);
	}

	/**
	 * Creates a new account permision entry with the primary key. Does not add the account permision entry to the database.
	 *
	 * @param id the primary key for the new account permision entry
	 * @return the new account permision entry
	 */
	@Override
	public AccountPermisionEntry create(long id) {
		AccountPermisionEntry accountPermisionEntry =
			new AccountPermisionEntryImpl();

		accountPermisionEntry.setNew(true);
		accountPermisionEntry.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		accountPermisionEntry.setUuid(uuid);

		accountPermisionEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return accountPermisionEntry;
	}

	/**
	 * Removes the account permision entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account permision entry
	 * @return the account permision entry that was removed
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	@Override
	public AccountPermisionEntry remove(long id)
		throws NoSuchAccountPermisionEntryException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the account permision entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the account permision entry
	 * @return the account permision entry that was removed
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	@Override
	public AccountPermisionEntry remove(Serializable primaryKey)
		throws NoSuchAccountPermisionEntryException {

		Session session = null;

		try {
			session = openSession();

			AccountPermisionEntry accountPermisionEntry =
				(AccountPermisionEntry)session.get(
					AccountPermisionEntryImpl.class, primaryKey);

			if (accountPermisionEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAccountPermisionEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(accountPermisionEntry);
		}
		catch (NoSuchAccountPermisionEntryException noSuchEntityException) {
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
	protected AccountPermisionEntry removeImpl(
		AccountPermisionEntry accountPermisionEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(accountPermisionEntry)) {
				accountPermisionEntry = (AccountPermisionEntry)session.get(
					AccountPermisionEntryImpl.class,
					accountPermisionEntry.getPrimaryKeyObj());
			}

			if (accountPermisionEntry != null) {
				session.delete(accountPermisionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (accountPermisionEntry != null) {
			clearCache(accountPermisionEntry);
		}

		return accountPermisionEntry;
	}

	@Override
	public AccountPermisionEntry updateImpl(
		AccountPermisionEntry accountPermisionEntry) {

		boolean isNew = accountPermisionEntry.isNew();

		if (!(accountPermisionEntry instanceof
				AccountPermisionEntryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(accountPermisionEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					accountPermisionEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in accountPermisionEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AccountPermisionEntry implementation " +
					accountPermisionEntry.getClass());
		}

		AccountPermisionEntryModelImpl accountPermisionEntryModelImpl =
			(AccountPermisionEntryModelImpl)accountPermisionEntry;

		if (Validator.isNull(accountPermisionEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			accountPermisionEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(accountPermisionEntry);
			}
			else {
				accountPermisionEntry = (AccountPermisionEntry)session.merge(
					accountPermisionEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AccountPermisionEntryImpl.class, accountPermisionEntryModelImpl,
			false, true);

		cacheUniqueFindersCache(accountPermisionEntryModelImpl);

		if (isNew) {
			accountPermisionEntry.setNew(false);
		}

		accountPermisionEntry.resetOriginalValues();

		return accountPermisionEntry;
	}

	/**
	 * Returns the account permision entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the account permision entry
	 * @return the account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	@Override
	public AccountPermisionEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAccountPermisionEntryException {

		AccountPermisionEntry accountPermisionEntry = fetchByPrimaryKey(
			primaryKey);

		if (accountPermisionEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAccountPermisionEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return accountPermisionEntry;
	}

	/**
	 * Returns the account permision entry with the primary key or throws a <code>NoSuchAccountPermisionEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the account permision entry
	 * @return the account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	@Override
	public AccountPermisionEntry findByPrimaryKey(long id)
		throws NoSuchAccountPermisionEntryException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the account permision entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the account permision entry
	 * @return the account permision entry, or <code>null</code> if a account permision entry with the primary key could not be found
	 */
	@Override
	public AccountPermisionEntry fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the account permision entries.
	 *
	 * @return the account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the account permision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @return the range of account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the account permision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findAll(
		int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the account permision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountPermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account permision entries
	 * @param end the upper bound of the range of account permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of account permision entries
	 */
	@Override
	public List<AccountPermisionEntry> findAll(
		int start, int end,
		OrderByComparator<AccountPermisionEntry> orderByComparator,
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

		List<AccountPermisionEntry> list = null;

		if (useFinderCache) {
			list = (List<AccountPermisionEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ACCOUNTPERMISIONENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ACCOUNTPERMISIONENTRY;

				sql = sql.concat(AccountPermisionEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AccountPermisionEntry>)QueryUtil.list(
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
	 * Removes all the account permision entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AccountPermisionEntry accountPermisionEntry : findAll()) {
			remove(accountPermisionEntry);
		}
	}

	/**
	 * Returns the number of account permision entries.
	 *
	 * @return the number of account permision entries
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
					_SQL_COUNT_ACCOUNTPERMISIONENTRY);

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
		return _SQL_SELECT_ACCOUNTPERMISIONENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AccountPermisionEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the account permision entry persistence.
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

		_setAccountPermisionEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAccountPermisionEntryUtilPersistence(null);

		entityCache.removeCache(AccountPermisionEntryImpl.class.getName());
	}

	private void _setAccountPermisionEntryUtilPersistence(
		AccountPermisionEntryPersistence accountPermisionEntryPersistence) {

		try {
			Field field = AccountPermisionEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, accountPermisionEntryPersistence);
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

	private static final String _SQL_SELECT_ACCOUNTPERMISIONENTRY =
		"SELECT accountPermisionEntry FROM AccountPermisionEntry accountPermisionEntry";

	private static final String _SQL_SELECT_ACCOUNTPERMISIONENTRY_WHERE =
		"SELECT accountPermisionEntry FROM AccountPermisionEntry accountPermisionEntry WHERE ";

	private static final String _SQL_COUNT_ACCOUNTPERMISIONENTRY =
		"SELECT COUNT(accountPermisionEntry) FROM AccountPermisionEntry accountPermisionEntry";

	private static final String _SQL_COUNT_ACCOUNTPERMISIONENTRY_WHERE =
		"SELECT COUNT(accountPermisionEntry) FROM AccountPermisionEntry accountPermisionEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"accountPermisionEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AccountPermisionEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AccountPermisionEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AccountPermisionEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AccountPermisionEntryModelArgumentsResolver
		_accountPermisionEntryModelArgumentsResolver;

}