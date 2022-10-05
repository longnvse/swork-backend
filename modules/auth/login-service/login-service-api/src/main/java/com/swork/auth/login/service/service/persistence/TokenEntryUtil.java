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

package com.swork.auth.login.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.auth.login.service.model.TokenEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the token entry service. This utility wraps <code>com.swork.auth.login.service.service.persistence.impl.TokenEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenEntryPersistence
 * @generated
 */
public class TokenEntryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TokenEntry tokenEntry) {
		getPersistence().clearCache(tokenEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TokenEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TokenEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TokenEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TokenEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TokenEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TokenEntry update(TokenEntry tokenEntry) {
		return getPersistence().update(tokenEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TokenEntry update(
		TokenEntry tokenEntry, ServiceContext serviceContext) {

		return getPersistence().update(tokenEntry, serviceContext);
	}

	/**
	 * Returns all the token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching token entries
	 */
	public static List<TokenEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<TokenEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<TokenEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TokenEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<TokenEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TokenEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	public static TokenEntry findByUuid_First(
			String uuid, OrderByComparator<TokenEntry> orderByComparator)
		throws com.swork.auth.login.service.exception.
			NoSuchTokenEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public static TokenEntry fetchByUuid_First(
		String uuid, OrderByComparator<TokenEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	public static TokenEntry findByUuid_Last(
			String uuid, OrderByComparator<TokenEntry> orderByComparator)
		throws com.swork.auth.login.service.exception.
			NoSuchTokenEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public static TokenEntry fetchByUuid_Last(
		String uuid, OrderByComparator<TokenEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static TokenEntry[] findByUuid_PrevAndNext(
			long tokenId, String uuid,
			OrderByComparator<TokenEntry> orderByComparator)
		throws com.swork.auth.login.service.exception.
			NoSuchTokenEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			tokenId, uuid, orderByComparator);
	}

	/**
	 * Removes all the token entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching token entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the token entry where refreshToken = &#63; or throws a <code>NoSuchTokenEntryException</code> if it could not be found.
	 *
	 * @param refreshToken the refresh token
	 * @return the matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	public static TokenEntry findByR_T(String refreshToken)
		throws com.swork.auth.login.service.exception.
			NoSuchTokenEntryException {

		return getPersistence().findByR_T(refreshToken);
	}

	/**
	 * Returns the token entry where refreshToken = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param refreshToken the refresh token
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public static TokenEntry fetchByR_T(String refreshToken) {
		return getPersistence().fetchByR_T(refreshToken);
	}

	/**
	 * Returns the token entry where refreshToken = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param refreshToken the refresh token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public static TokenEntry fetchByR_T(
		String refreshToken, boolean useFinderCache) {

		return getPersistence().fetchByR_T(refreshToken, useFinderCache);
	}

	/**
	 * Removes the token entry where refreshToken = &#63; from the database.
	 *
	 * @param refreshToken the refresh token
	 * @return the token entry that was removed
	 */
	public static TokenEntry removeByR_T(String refreshToken)
		throws com.swork.auth.login.service.exception.
			NoSuchTokenEntryException {

		return getPersistence().removeByR_T(refreshToken);
	}

	/**
	 * Returns the number of token entries where refreshToken = &#63;.
	 *
	 * @param refreshToken the refresh token
	 * @return the number of matching token entries
	 */
	public static int countByR_T(String refreshToken) {
		return getPersistence().countByR_T(refreshToken);
	}

	/**
	 * Returns the token entry where userName = &#63; or throws a <code>NoSuchTokenEntryException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	public static TokenEntry findByU_N(String userName)
		throws com.swork.auth.login.service.exception.
			NoSuchTokenEntryException {

		return getPersistence().findByU_N(userName);
	}

	/**
	 * Returns the token entry where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public static TokenEntry fetchByU_N(String userName) {
		return getPersistence().fetchByU_N(userName);
	}

	/**
	 * Returns the token entry where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public static TokenEntry fetchByU_N(
		String userName, boolean useFinderCache) {

		return getPersistence().fetchByU_N(userName, useFinderCache);
	}

	/**
	 * Removes the token entry where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the token entry that was removed
	 */
	public static TokenEntry removeByU_N(String userName)
		throws com.swork.auth.login.service.exception.
			NoSuchTokenEntryException {

		return getPersistence().removeByU_N(userName);
	}

	/**
	 * Returns the number of token entries where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching token entries
	 */
	public static int countByU_N(String userName) {
		return getPersistence().countByU_N(userName);
	}

	/**
	 * Caches the token entry in the entity cache if it is enabled.
	 *
	 * @param tokenEntry the token entry
	 */
	public static void cacheResult(TokenEntry tokenEntry) {
		getPersistence().cacheResult(tokenEntry);
	}

	/**
	 * Caches the token entries in the entity cache if it is enabled.
	 *
	 * @param tokenEntries the token entries
	 */
	public static void cacheResult(List<TokenEntry> tokenEntries) {
		getPersistence().cacheResult(tokenEntries);
	}

	/**
	 * Creates a new token entry with the primary key. Does not add the token entry to the database.
	 *
	 * @param tokenId the primary key for the new token entry
	 * @return the new token entry
	 */
	public static TokenEntry create(long tokenId) {
		return getPersistence().create(tokenId);
	}

	/**
	 * Removes the token entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tokenId the primary key of the token entry
	 * @return the token entry that was removed
	 * @throws NoSuchTokenEntryException if a token entry with the primary key could not be found
	 */
	public static TokenEntry remove(long tokenId)
		throws com.swork.auth.login.service.exception.
			NoSuchTokenEntryException {

		return getPersistence().remove(tokenId);
	}

	public static TokenEntry updateImpl(TokenEntry tokenEntry) {
		return getPersistence().updateImpl(tokenEntry);
	}

	/**
	 * Returns the token entry with the primary key or throws a <code>NoSuchTokenEntryException</code> if it could not be found.
	 *
	 * @param tokenId the primary key of the token entry
	 * @return the token entry
	 * @throws NoSuchTokenEntryException if a token entry with the primary key could not be found
	 */
	public static TokenEntry findByPrimaryKey(long tokenId)
		throws com.swork.auth.login.service.exception.
			NoSuchTokenEntryException {

		return getPersistence().findByPrimaryKey(tokenId);
	}

	/**
	 * Returns the token entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tokenId the primary key of the token entry
	 * @return the token entry, or <code>null</code> if a token entry with the primary key could not be found
	 */
	public static TokenEntry fetchByPrimaryKey(long tokenId) {
		return getPersistence().fetchByPrimaryKey(tokenId);
	}

	/**
	 * Returns all the token entries.
	 *
	 * @return the token entries
	 */
	public static List<TokenEntry> findAll() {
		return getPersistence().findAll();
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
	public static List<TokenEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<TokenEntry> findAll(
		int start, int end, OrderByComparator<TokenEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<TokenEntry> findAll(
		int start, int end, OrderByComparator<TokenEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the token entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of token entries.
	 *
	 * @return the number of token entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TokenEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TokenEntryPersistence _persistence;

}