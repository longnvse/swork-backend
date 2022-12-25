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

package com.swork.auth.login.service.service.persistence.impl;

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

import com.swork.auth.login.service.exception.NoSuchTokenEntryException;
import com.swork.auth.login.service.model.TokenEntry;
import com.swork.auth.login.service.model.TokenEntryTable;
import com.swork.auth.login.service.model.impl.TokenEntryImpl;
import com.swork.auth.login.service.model.impl.TokenEntryModelImpl;
import com.swork.auth.login.service.service.persistence.TokenEntryPersistence;
import com.swork.auth.login.service.service.persistence.TokenEntryUtil;
import com.swork.auth.login.service.service.persistence.impl.constants.SW_LOGINPersistenceConstants;

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
 * The persistence implementation for the token entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {TokenEntryPersistence.class, BasePersistence.class})
public class TokenEntryPersistenceImpl
	extends BasePersistenceImpl<TokenEntry> implements TokenEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TokenEntryUtil</code> to access the token entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TokenEntryImpl.class.getName();

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
	 * Returns all the token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching token entries
	 */
	@Override
	public List<TokenEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the token entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of token entries
	 * @param end the upper bound of the range of token entries (not inclusive)
	 * @return the range of matching token entries
	 */
	@Override
	public List<TokenEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the token entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of token entries
	 * @param end the upper bound of the range of token entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching token entries
	 */
	@Override
	public List<TokenEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TokenEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the token entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of token entries
	 * @param end the upper bound of the range of token entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching token entries
	 */
	@Override
	public List<TokenEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TokenEntry> orderByComparator,
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

		List<TokenEntry> list = null;

		if (useFinderCache) {
			list = (List<TokenEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (TokenEntry tokenEntry : list) {
					if (!uuid.equals(tokenEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_TOKENENTRY_WHERE);

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
				sb.append(TokenEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TokenEntry>)QueryUtil.list(
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
	 * Returns the first token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	@Override
	public TokenEntry findByUuid_First(
			String uuid, OrderByComparator<TokenEntry> orderByComparator)
		throws NoSuchTokenEntryException {

		TokenEntry tokenEntry = fetchByUuid_First(uuid, orderByComparator);

		if (tokenEntry != null) {
			return tokenEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTokenEntryException(sb.toString());
	}

	/**
	 * Returns the first token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	@Override
	public TokenEntry fetchByUuid_First(
		String uuid, OrderByComparator<TokenEntry> orderByComparator) {

		List<TokenEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	@Override
	public TokenEntry findByUuid_Last(
			String uuid, OrderByComparator<TokenEntry> orderByComparator)
		throws NoSuchTokenEntryException {

		TokenEntry tokenEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (tokenEntry != null) {
			return tokenEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTokenEntryException(sb.toString());
	}

	/**
	 * Returns the last token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	@Override
	public TokenEntry fetchByUuid_Last(
		String uuid, OrderByComparator<TokenEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TokenEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the token entries before and after the current token entry in the ordered set where uuid = &#63;.
	 *
	 * @param tokenId the primary key of the current token entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next token entry
	 * @throws NoSuchTokenEntryException if a token entry with the primary key could not be found
	 */
	@Override
	public TokenEntry[] findByUuid_PrevAndNext(
			long tokenId, String uuid,
			OrderByComparator<TokenEntry> orderByComparator)
		throws NoSuchTokenEntryException {

		uuid = Objects.toString(uuid, "");

		TokenEntry tokenEntry = findByPrimaryKey(tokenId);

		Session session = null;

		try {
			session = openSession();

			TokenEntry[] array = new TokenEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, tokenEntry, uuid, orderByComparator, true);

			array[1] = tokenEntry;

			array[2] = getByUuid_PrevAndNext(
				session, tokenEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TokenEntry getByUuid_PrevAndNext(
		Session session, TokenEntry tokenEntry, String uuid,
		OrderByComparator<TokenEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TOKENENTRY_WHERE);

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
			sb.append(TokenEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tokenEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TokenEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the token entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TokenEntry tokenEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tokenEntry);
		}
	}

	/**
	 * Returns the number of token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching token entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TOKENENTRY_WHERE);

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
		"tokenEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(tokenEntry.uuid IS NULL OR tokenEntry.uuid = '')";

	private FinderPath _finderPathFetchByR_T;
	private FinderPath _finderPathCountByR_T;

	/**
	 * Returns the token entry where refreshToken = &#63; or throws a <code>NoSuchTokenEntryException</code> if it could not be found.
	 *
	 * @param refreshToken the refresh token
	 * @return the matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	@Override
	public TokenEntry findByR_T(String refreshToken)
		throws NoSuchTokenEntryException {

		TokenEntry tokenEntry = fetchByR_T(refreshToken);

		if (tokenEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("refreshToken=");
			sb.append(refreshToken);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTokenEntryException(sb.toString());
		}

		return tokenEntry;
	}

	/**
	 * Returns the token entry where refreshToken = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param refreshToken the refresh token
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	@Override
	public TokenEntry fetchByR_T(String refreshToken) {
		return fetchByR_T(refreshToken, true);
	}

	/**
	 * Returns the token entry where refreshToken = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param refreshToken the refresh token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	@Override
	public TokenEntry fetchByR_T(String refreshToken, boolean useFinderCache) {
		refreshToken = Objects.toString(refreshToken, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {refreshToken};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByR_T, finderArgs);
		}

		if (result instanceof TokenEntry) {
			TokenEntry tokenEntry = (TokenEntry)result;

			if (!Objects.equals(refreshToken, tokenEntry.getRefreshToken())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_TOKENENTRY_WHERE);

			boolean bindRefreshToken = false;

			if (refreshToken.isEmpty()) {
				sb.append(_FINDER_COLUMN_R_T_REFRESHTOKEN_3);
			}
			else {
				bindRefreshToken = true;

				sb.append(_FINDER_COLUMN_R_T_REFRESHTOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRefreshToken) {
					queryPos.add(refreshToken);
				}

				List<TokenEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByR_T, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {refreshToken};
							}

							_log.warn(
								"TokenEntryPersistenceImpl.fetchByR_T(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TokenEntry tokenEntry = list.get(0);

					result = tokenEntry;

					cacheResult(tokenEntry);
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
			return (TokenEntry)result;
		}
	}

	/**
	 * Removes the token entry where refreshToken = &#63; from the database.
	 *
	 * @param refreshToken the refresh token
	 * @return the token entry that was removed
	 */
	@Override
	public TokenEntry removeByR_T(String refreshToken)
		throws NoSuchTokenEntryException {

		TokenEntry tokenEntry = findByR_T(refreshToken);

		return remove(tokenEntry);
	}

	/**
	 * Returns the number of token entries where refreshToken = &#63;.
	 *
	 * @param refreshToken the refresh token
	 * @return the number of matching token entries
	 */
	@Override
	public int countByR_T(String refreshToken) {
		refreshToken = Objects.toString(refreshToken, "");

		FinderPath finderPath = _finderPathCountByR_T;

		Object[] finderArgs = new Object[] {refreshToken};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TOKENENTRY_WHERE);

			boolean bindRefreshToken = false;

			if (refreshToken.isEmpty()) {
				sb.append(_FINDER_COLUMN_R_T_REFRESHTOKEN_3);
			}
			else {
				bindRefreshToken = true;

				sb.append(_FINDER_COLUMN_R_T_REFRESHTOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRefreshToken) {
					queryPos.add(refreshToken);
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

	private static final String _FINDER_COLUMN_R_T_REFRESHTOKEN_2 =
		"tokenEntry.refreshToken = ?";

	private static final String _FINDER_COLUMN_R_T_REFRESHTOKEN_3 =
		"(tokenEntry.refreshToken IS NULL OR tokenEntry.refreshToken = '')";

	private FinderPath _finderPathFetchByU_N;
	private FinderPath _finderPathCountByU_N;

	/**
	 * Returns the token entry where userName = &#63; or throws a <code>NoSuchTokenEntryException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	@Override
	public TokenEntry findByU_N(String userName)
		throws NoSuchTokenEntryException {

		TokenEntry tokenEntry = fetchByU_N(userName);

		if (tokenEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userName=");
			sb.append(userName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTokenEntryException(sb.toString());
		}

		return tokenEntry;
	}

	/**
	 * Returns the token entry where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	@Override
	public TokenEntry fetchByU_N(String userName) {
		return fetchByU_N(userName, true);
	}

	/**
	 * Returns the token entry where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	@Override
	public TokenEntry fetchByU_N(String userName, boolean useFinderCache) {
		userName = Objects.toString(userName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByU_N, finderArgs);
		}

		if (result instanceof TokenEntry) {
			TokenEntry tokenEntry = (TokenEntry)result;

			if (!Objects.equals(userName, tokenEntry.getUserName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_TOKENENTRY_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				sb.append(_FINDER_COLUMN_U_N_USERNAME_3);
			}
			else {
				bindUserName = true;

				sb.append(_FINDER_COLUMN_U_N_USERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserName) {
					queryPos.add(userName);
				}

				List<TokenEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByU_N, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userName};
							}

							_log.warn(
								"TokenEntryPersistenceImpl.fetchByU_N(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TokenEntry tokenEntry = list.get(0);

					result = tokenEntry;

					cacheResult(tokenEntry);
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
			return (TokenEntry)result;
		}
	}

	/**
	 * Removes the token entry where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the token entry that was removed
	 */
	@Override
	public TokenEntry removeByU_N(String userName)
		throws NoSuchTokenEntryException {

		TokenEntry tokenEntry = findByU_N(userName);

		return remove(tokenEntry);
	}

	/**
	 * Returns the number of token entries where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching token entries
	 */
	@Override
	public int countByU_N(String userName) {
		userName = Objects.toString(userName, "");

		FinderPath finderPath = _finderPathCountByU_N;

		Object[] finderArgs = new Object[] {userName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TOKENENTRY_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				sb.append(_FINDER_COLUMN_U_N_USERNAME_3);
			}
			else {
				bindUserName = true;

				sb.append(_FINDER_COLUMN_U_N_USERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserName) {
					queryPos.add(userName);
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

	private static final String _FINDER_COLUMN_U_N_USERNAME_2 =
		"tokenEntry.userName = ?";

	private static final String _FINDER_COLUMN_U_N_USERNAME_3 =
		"(tokenEntry.userName IS NULL OR tokenEntry.userName = '')";

	public TokenEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TokenEntry.class);

		setModelImplClass(TokenEntryImpl.class);
		setModelPKClass(long.class);

		setTable(TokenEntryTable.INSTANCE);
	}

	/**
	 * Caches the token entry in the entity cache if it is enabled.
	 *
	 * @param tokenEntry the token entry
	 */
	@Override
	public void cacheResult(TokenEntry tokenEntry) {
		entityCache.putResult(
			TokenEntryImpl.class, tokenEntry.getPrimaryKey(), tokenEntry);

		finderCache.putResult(
			_finderPathFetchByR_T, new Object[] {tokenEntry.getRefreshToken()},
			tokenEntry);

		finderCache.putResult(
			_finderPathFetchByU_N, new Object[] {tokenEntry.getUserName()},
			tokenEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the token entries in the entity cache if it is enabled.
	 *
	 * @param tokenEntries the token entries
	 */
	@Override
	public void cacheResult(List<TokenEntry> tokenEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tokenEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TokenEntry tokenEntry : tokenEntries) {
			if (entityCache.getResult(
					TokenEntryImpl.class, tokenEntry.getPrimaryKey()) == null) {

				cacheResult(tokenEntry);
			}
		}
	}

	/**
	 * Clears the cache for all token entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TokenEntryImpl.class);

		finderCache.clearCache(TokenEntryImpl.class);
	}

	/**
	 * Clears the cache for the token entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TokenEntry tokenEntry) {
		entityCache.removeResult(TokenEntryImpl.class, tokenEntry);
	}

	@Override
	public void clearCache(List<TokenEntry> tokenEntries) {
		for (TokenEntry tokenEntry : tokenEntries) {
			entityCache.removeResult(TokenEntryImpl.class, tokenEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TokenEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TokenEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TokenEntryModelImpl tokenEntryModelImpl) {

		Object[] args = new Object[] {tokenEntryModelImpl.getRefreshToken()};

		finderCache.putResult(_finderPathCountByR_T, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByR_T, args, tokenEntryModelImpl);

		args = new Object[] {tokenEntryModelImpl.getUserName()};

		finderCache.putResult(_finderPathCountByU_N, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByU_N, args, tokenEntryModelImpl);
	}

	/**
	 * Creates a new token entry with the primary key. Does not add the token entry to the database.
	 *
	 * @param tokenId the primary key for the new token entry
	 * @return the new token entry
	 */
	@Override
	public TokenEntry create(long tokenId) {
		TokenEntry tokenEntry = new TokenEntryImpl();

		tokenEntry.setNew(true);
		tokenEntry.setPrimaryKey(tokenId);

		String uuid = PortalUUIDUtil.generate();

		tokenEntry.setUuid(uuid);

		return tokenEntry;
	}

	/**
	 * Removes the token entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tokenId the primary key of the token entry
	 * @return the token entry that was removed
	 * @throws NoSuchTokenEntryException if a token entry with the primary key could not be found
	 */
	@Override
	public TokenEntry remove(long tokenId) throws NoSuchTokenEntryException {
		return remove((Serializable)tokenId);
	}

	/**
	 * Removes the token entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the token entry
	 * @return the token entry that was removed
	 * @throws NoSuchTokenEntryException if a token entry with the primary key could not be found
	 */
	@Override
	public TokenEntry remove(Serializable primaryKey)
		throws NoSuchTokenEntryException {

		Session session = null;

		try {
			session = openSession();

			TokenEntry tokenEntry = (TokenEntry)session.get(
				TokenEntryImpl.class, primaryKey);

			if (tokenEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTokenEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tokenEntry);
		}
		catch (NoSuchTokenEntryException noSuchEntityException) {
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
	protected TokenEntry removeImpl(TokenEntry tokenEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tokenEntry)) {
				tokenEntry = (TokenEntry)session.get(
					TokenEntryImpl.class, tokenEntry.getPrimaryKeyObj());
			}

			if (tokenEntry != null) {
				session.delete(tokenEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tokenEntry != null) {
			clearCache(tokenEntry);
		}

		return tokenEntry;
	}

	@Override
	public TokenEntry updateImpl(TokenEntry tokenEntry) {
		boolean isNew = tokenEntry.isNew();

		if (!(tokenEntry instanceof TokenEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tokenEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tokenEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tokenEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TokenEntry implementation " +
					tokenEntry.getClass());
		}

		TokenEntryModelImpl tokenEntryModelImpl =
			(TokenEntryModelImpl)tokenEntry;

		if (Validator.isNull(tokenEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			tokenEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tokenEntry);
			}
			else {
				tokenEntry = (TokenEntry)session.merge(tokenEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TokenEntryImpl.class, tokenEntryModelImpl, false, true);

		cacheUniqueFindersCache(tokenEntryModelImpl);

		if (isNew) {
			tokenEntry.setNew(false);
		}

		tokenEntry.resetOriginalValues();

		return tokenEntry;
	}

	/**
	 * Returns the token entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the token entry
	 * @return the token entry
	 * @throws NoSuchTokenEntryException if a token entry with the primary key could not be found
	 */
	@Override
	public TokenEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTokenEntryException {

		TokenEntry tokenEntry = fetchByPrimaryKey(primaryKey);

		if (tokenEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTokenEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tokenEntry;
	}

	/**
	 * Returns the token entry with the primary key or throws a <code>NoSuchTokenEntryException</code> if it could not be found.
	 *
	 * @param tokenId the primary key of the token entry
	 * @return the token entry
	 * @throws NoSuchTokenEntryException if a token entry with the primary key could not be found
	 */
	@Override
	public TokenEntry findByPrimaryKey(long tokenId)
		throws NoSuchTokenEntryException {

		return findByPrimaryKey((Serializable)tokenId);
	}

	/**
	 * Returns the token entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tokenId the primary key of the token entry
	 * @return the token entry, or <code>null</code> if a token entry with the primary key could not be found
	 */
	@Override
	public TokenEntry fetchByPrimaryKey(long tokenId) {
		return fetchByPrimaryKey((Serializable)tokenId);
	}

	/**
	 * Returns all the token entries.
	 *
	 * @return the token entries
	 */
	@Override
	public List<TokenEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the token entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of token entries
	 * @param end the upper bound of the range of token entries (not inclusive)
	 * @return the range of token entries
	 */
	@Override
	public List<TokenEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the token entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of token entries
	 * @param end the upper bound of the range of token entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of token entries
	 */
	@Override
	public List<TokenEntry> findAll(
		int start, int end, OrderByComparator<TokenEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the token entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of token entries
	 * @param end the upper bound of the range of token entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of token entries
	 */
	@Override
	public List<TokenEntry> findAll(
		int start, int end, OrderByComparator<TokenEntry> orderByComparator,
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

		List<TokenEntry> list = null;

		if (useFinderCache) {
			list = (List<TokenEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TOKENENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TOKENENTRY;

				sql = sql.concat(TokenEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TokenEntry>)QueryUtil.list(
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
	 * Removes all the token entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TokenEntry tokenEntry : findAll()) {
			remove(tokenEntry);
		}
	}

	/**
	 * Returns the number of token entries.
	 *
	 * @return the number of token entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TOKENENTRY);

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
		return "tokenId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TOKENENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TokenEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the token entry persistence.
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

		_finderPathFetchByR_T = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByR_T",
			new String[] {String.class.getName()},
			new String[] {"refreshToken"}, true);

		_finderPathCountByR_T = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_T",
			new String[] {String.class.getName()},
			new String[] {"refreshToken"}, false);

		_finderPathFetchByU_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByU_N",
			new String[] {String.class.getName()}, new String[] {"userName"},
			true);

		_finderPathCountByU_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_N",
			new String[] {String.class.getName()}, new String[] {"userName"},
			false);

		_setTokenEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTokenEntryUtilPersistence(null);

		entityCache.removeCache(TokenEntryImpl.class.getName());
	}

	private void _setTokenEntryUtilPersistence(
		TokenEntryPersistence tokenEntryPersistence) {

		try {
			Field field = TokenEntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, tokenEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SW_LOGINPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SW_LOGINPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SW_LOGINPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TOKENENTRY =
		"SELECT tokenEntry FROM TokenEntry tokenEntry";

	private static final String _SQL_SELECT_TOKENENTRY_WHERE =
		"SELECT tokenEntry FROM TokenEntry tokenEntry WHERE ";

	private static final String _SQL_COUNT_TOKENENTRY =
		"SELECT COUNT(tokenEntry) FROM TokenEntry tokenEntry";

	private static final String _SQL_COUNT_TOKENENTRY_WHERE =
		"SELECT COUNT(tokenEntry) FROM TokenEntry tokenEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tokenEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TokenEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TokenEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TokenEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private TokenEntryModelArgumentsResolver _tokenEntryModelArgumentsResolver;

}