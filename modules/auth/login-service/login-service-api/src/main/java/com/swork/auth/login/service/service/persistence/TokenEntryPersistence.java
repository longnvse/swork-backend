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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.auth.login.service.exception.NoSuchTokenEntryException;
import com.swork.auth.login.service.model.TokenEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the token entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenEntryUtil
 * @generated
 */
@ProviderType
public interface TokenEntryPersistence extends BasePersistence<TokenEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TokenEntryUtil} to access the token entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching token entries
	 */
	public java.util.List<TokenEntry> findByUuid(String uuid);

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
	public java.util.List<TokenEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<TokenEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TokenEntry>
			orderByComparator);

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
	public java.util.List<TokenEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TokenEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	public TokenEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TokenEntry>
				orderByComparator)
		throws NoSuchTokenEntryException;

	/**
	 * Returns the first token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public TokenEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TokenEntry>
			orderByComparator);

	/**
	 * Returns the last token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	public TokenEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TokenEntry>
				orderByComparator)
		throws NoSuchTokenEntryException;

	/**
	 * Returns the last token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public TokenEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TokenEntry>
			orderByComparator);

	/**
	 * Returns the token entries before and after the current token entry in the ordered set where uuid = &#63;.
	 *
	 * @param tokenId the primary key of the current token entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next token entry
	 * @throws NoSuchTokenEntryException if a token entry with the primary key could not be found
	 */
	public TokenEntry[] findByUuid_PrevAndNext(
			long tokenId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TokenEntry>
				orderByComparator)
		throws NoSuchTokenEntryException;

	/**
	 * Removes all the token entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching token entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the token entry where refreshToken = &#63; or throws a <code>NoSuchTokenEntryException</code> if it could not be found.
	 *
	 * @param refreshToken the refresh token
	 * @return the matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	public TokenEntry findByR_T(String refreshToken)
		throws NoSuchTokenEntryException;

	/**
	 * Returns the token entry where refreshToken = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param refreshToken the refresh token
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public TokenEntry fetchByR_T(String refreshToken);

	/**
	 * Returns the token entry where refreshToken = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param refreshToken the refresh token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public TokenEntry fetchByR_T(String refreshToken, boolean useFinderCache);

	/**
	 * Removes the token entry where refreshToken = &#63; from the database.
	 *
	 * @param refreshToken the refresh token
	 * @return the token entry that was removed
	 */
	public TokenEntry removeByR_T(String refreshToken)
		throws NoSuchTokenEntryException;

	/**
	 * Returns the number of token entries where refreshToken = &#63;.
	 *
	 * @param refreshToken the refresh token
	 * @return the number of matching token entries
	 */
	public int countByR_T(String refreshToken);

	/**
	 * Returns the token entry where userName = &#63; or throws a <code>NoSuchTokenEntryException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching token entry
	 * @throws NoSuchTokenEntryException if a matching token entry could not be found
	 */
	public TokenEntry findByU_N(String userName)
		throws NoSuchTokenEntryException;

	/**
	 * Returns the token entry where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public TokenEntry fetchByU_N(String userName);

	/**
	 * Returns the token entry where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching token entry, or <code>null</code> if a matching token entry could not be found
	 */
	public TokenEntry fetchByU_N(String userName, boolean useFinderCache);

	/**
	 * Removes the token entry where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the token entry that was removed
	 */
	public TokenEntry removeByU_N(String userName)
		throws NoSuchTokenEntryException;

	/**
	 * Returns the number of token entries where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching token entries
	 */
	public int countByU_N(String userName);

	/**
	 * Caches the token entry in the entity cache if it is enabled.
	 *
	 * @param tokenEntry the token entry
	 */
	public void cacheResult(TokenEntry tokenEntry);

	/**
	 * Caches the token entries in the entity cache if it is enabled.
	 *
	 * @param tokenEntries the token entries
	 */
	public void cacheResult(java.util.List<TokenEntry> tokenEntries);

	/**
	 * Creates a new token entry with the primary key. Does not add the token entry to the database.
	 *
	 * @param tokenId the primary key for the new token entry
	 * @return the new token entry
	 */
	public TokenEntry create(long tokenId);

	/**
	 * Removes the token entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tokenId the primary key of the token entry
	 * @return the token entry that was removed
	 * @throws NoSuchTokenEntryException if a token entry with the primary key could not be found
	 */
	public TokenEntry remove(long tokenId) throws NoSuchTokenEntryException;

	public TokenEntry updateImpl(TokenEntry tokenEntry);

	/**
	 * Returns the token entry with the primary key or throws a <code>NoSuchTokenEntryException</code> if it could not be found.
	 *
	 * @param tokenId the primary key of the token entry
	 * @return the token entry
	 * @throws NoSuchTokenEntryException if a token entry with the primary key could not be found
	 */
	public TokenEntry findByPrimaryKey(long tokenId)
		throws NoSuchTokenEntryException;

	/**
	 * Returns the token entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tokenId the primary key of the token entry
	 * @return the token entry, or <code>null</code> if a token entry with the primary key could not be found
	 */
	public TokenEntry fetchByPrimaryKey(long tokenId);

	/**
	 * Returns all the token entries.
	 *
	 * @return the token entries
	 */
	public java.util.List<TokenEntry> findAll();

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
	public java.util.List<TokenEntry> findAll(int start, int end);

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
	public java.util.List<TokenEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TokenEntry>
			orderByComparator);

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
	public java.util.List<TokenEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TokenEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the token entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of token entries.
	 *
	 * @return the number of token entries
	 */
	public int countAll();

}