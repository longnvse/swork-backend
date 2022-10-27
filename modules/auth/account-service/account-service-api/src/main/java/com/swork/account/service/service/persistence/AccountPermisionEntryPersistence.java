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

import com.swork.account.service.exception.NoSuchAccountPermisionEntryException;
import com.swork.account.service.model.AccountPermisionEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the account permision entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountPermisionEntryUtil
 * @generated
 */
@ProviderType
public interface AccountPermisionEntryPersistence
	extends BasePersistence<AccountPermisionEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AccountPermisionEntryUtil} to access the account permision entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the account permision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account permision entries
	 */
	public java.util.List<AccountPermisionEntry> findByUuid(String uuid);

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
	public java.util.List<AccountPermisionEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AccountPermisionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermisionEntry>
			orderByComparator);

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
	public java.util.List<AccountPermisionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermisionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	public AccountPermisionEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException;

	/**
	 * Returns the first account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public AccountPermisionEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermisionEntry>
			orderByComparator);

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	public AccountPermisionEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException;

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public AccountPermisionEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermisionEntry>
			orderByComparator);

	/**
	 * Returns the account permision entries before and after the current account permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current account permision entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	public AccountPermisionEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException;

	/**
	 * Removes all the account permision entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of account permision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account permision entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account permision entries
	 */
	public java.util.List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermisionEntry>
			orderByComparator);

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
	public java.util.List<AccountPermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermisionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	public AccountPermisionEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException;

	/**
	 * Returns the first account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public AccountPermisionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermisionEntry>
			orderByComparator);

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	public AccountPermisionEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException;

	/**
	 * Returns the last account permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public AccountPermisionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermisionEntry>
			orderByComparator);

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
	public AccountPermisionEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountPermisionEntry> orderByComparator)
		throws NoSuchAccountPermisionEntryException;

	/**
	 * Removes all the account permision entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of account permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account permision entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the account permision entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchAccountPermisionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a matching account permision entry could not be found
	 */
	public AccountPermisionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAccountPermisionEntryException;

	/**
	 * Returns the account permision entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public AccountPermisionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the account permision entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account permision entry, or <code>null</code> if a matching account permision entry could not be found
	 */
	public AccountPermisionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the account permision entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the account permision entry that was removed
	 */
	public AccountPermisionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchAccountPermisionEntryException;

	/**
	 * Returns the number of account permision entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching account permision entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the account permision entry in the entity cache if it is enabled.
	 *
	 * @param accountPermisionEntry the account permision entry
	 */
	public void cacheResult(AccountPermisionEntry accountPermisionEntry);

	/**
	 * Caches the account permision entries in the entity cache if it is enabled.
	 *
	 * @param accountPermisionEntries the account permision entries
	 */
	public void cacheResult(
		java.util.List<AccountPermisionEntry> accountPermisionEntries);

	/**
	 * Creates a new account permision entry with the primary key. Does not add the account permision entry to the database.
	 *
	 * @param id the primary key for the new account permision entry
	 * @return the new account permision entry
	 */
	public AccountPermisionEntry create(long id);

	/**
	 * Removes the account permision entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account permision entry
	 * @return the account permision entry that was removed
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	public AccountPermisionEntry remove(long id)
		throws NoSuchAccountPermisionEntryException;

	public AccountPermisionEntry updateImpl(
		AccountPermisionEntry accountPermisionEntry);

	/**
	 * Returns the account permision entry with the primary key or throws a <code>NoSuchAccountPermisionEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the account permision entry
	 * @return the account permision entry
	 * @throws NoSuchAccountPermisionEntryException if a account permision entry with the primary key could not be found
	 */
	public AccountPermisionEntry findByPrimaryKey(long id)
		throws NoSuchAccountPermisionEntryException;

	/**
	 * Returns the account permision entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the account permision entry
	 * @return the account permision entry, or <code>null</code> if a account permision entry with the primary key could not be found
	 */
	public AccountPermisionEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the account permision entries.
	 *
	 * @return the account permision entries
	 */
	public java.util.List<AccountPermisionEntry> findAll();

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
	public java.util.List<AccountPermisionEntry> findAll(int start, int end);

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
	public java.util.List<AccountPermisionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermisionEntry>
			orderByComparator);

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
	public java.util.List<AccountPermisionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountPermisionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the account permision entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of account permision entries.
	 *
	 * @return the number of account permision entries
	 */
	public int countAll();

}