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

package com.swork.account.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.account.service.exception.NoSuchAccountPermissionEntryException;
import com.swork.account.service.model.AccountPermissionEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the account permission entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountPermissionEntryUtil
 * @generated
 */
@ProviderType
public interface AccountPermissionEntryPersistence
	extends BasePersistence<AccountPermissionEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AccountPermissionEntryUtil} to access the account permission entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the account permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account permission entries
	 */
	public java.util.List<AccountPermissionEntry> findByUuid(String uuid);

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
	public java.util.List<AccountPermissionEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AccountPermissionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermissionEntry>
			orderByComparator);

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
	public java.util.List<AccountPermissionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermissionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException;

	/**
	 * Returns the first account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermissionEntry>
			orderByComparator);

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException;

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermissionEntry>
			orderByComparator);

	/**
	 * Returns the account permission entries before and after the current account permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current account permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	public AccountPermissionEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException;

	/**
	 * Removes all the account permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of account permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account permission entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account permission entries
	 */
	public java.util.List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermissionEntry>
			orderByComparator);

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
	public java.util.List<AccountPermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermissionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException;

	/**
	 * Returns the first account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermissionEntry>
			orderByComparator);

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException;

	/**
	 * Returns the last account permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermissionEntry>
			orderByComparator);

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
	public AccountPermissionEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermissionEntry> orderByComparator)
		throws NoSuchAccountPermissionEntryException;

	/**
	 * Removes all the account permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of account permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account permission entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the account permission entry where accountId = &#63; or throws a <code>NoSuchAccountPermissionEntryException</code> if it could not be found.
	 *
	 * @param accountId the account ID
	 * @return the matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry findByAccountId(long accountId)
		throws NoSuchAccountPermissionEntryException;

	/**
	 * Returns the account permission entry where accountId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param accountId the account ID
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry fetchByAccountId(long accountId);

	/**
	 * Returns the account permission entry where accountId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param accountId the account ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry fetchByAccountId(
		long accountId, boolean useFinderCache);

	/**
	 * Removes the account permission entry where accountId = &#63; from the database.
	 *
	 * @param accountId the account ID
	 * @return the account permission entry that was removed
	 */
	public AccountPermissionEntry removeByAccountId(long accountId)
		throws NoSuchAccountPermissionEntryException;

	/**
	 * Returns the number of account permission entries where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the number of matching account permission entries
	 */
	public int countByAccountId(long accountId);

	/**
	 * Returns the account permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAccountPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAccountPermissionEntryException;

	/**
	 * Returns the account permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the account permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account permission entry, or <code>null</code> if a matching account permission entry could not be found
	 */
	public AccountPermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the account permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the account permission entry that was removed
	 */
	public AccountPermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAccountPermissionEntryException;

	/**
	 * Returns the number of account permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching account permission entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the account permission entry in the entity cache if it is enabled.
	 *
	 * @param accountPermissionEntry the account permission entry
	 */
	public void cacheResult(AccountPermissionEntry accountPermissionEntry);

	/**
	 * Caches the account permission entries in the entity cache if it is enabled.
	 *
	 * @param accountPermissionEntries the account permission entries
	 */
	public void cacheResult(
		java.util.List<AccountPermissionEntry> accountPermissionEntries);

	/**
	 * Creates a new account permission entry with the primary key. Does not add the account permission entry to the database.
	 *
	 * @param id the primary key for the new account permission entry
	 * @return the new account permission entry
	 */
	public AccountPermissionEntry create(long id);

	/**
	 * Removes the account permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry that was removed
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	public AccountPermissionEntry remove(long id)
		throws NoSuchAccountPermissionEntryException;

	public AccountPermissionEntry updateImpl(
		AccountPermissionEntry accountPermissionEntry);

	/**
	 * Returns the account permission entry with the primary key or throws a <code>NoSuchAccountPermissionEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry
	 * @throws NoSuchAccountPermissionEntryException if a account permission entry with the primary key could not be found
	 */
	public AccountPermissionEntry findByPrimaryKey(long id)
		throws NoSuchAccountPermissionEntryException;

	/**
	 * Returns the account permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the account permission entry
	 * @return the account permission entry, or <code>null</code> if a account permission entry with the primary key could not be found
	 */
	public AccountPermissionEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the account permission entries.
	 *
	 * @return the account permission entries
	 */
	public java.util.List<AccountPermissionEntry> findAll();

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
	public java.util.List<AccountPermissionEntry> findAll(int start, int end);

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
	public java.util.List<AccountPermissionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermissionEntry>
			orderByComparator);

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
	public java.util.List<AccountPermissionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermissionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the account permission entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of account permission entries.
	 *
	 * @return the number of account permission entries
	 */
	public int countAll();

}