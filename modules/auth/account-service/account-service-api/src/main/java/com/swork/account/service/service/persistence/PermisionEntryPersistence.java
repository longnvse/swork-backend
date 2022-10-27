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

import com.swork.account.service.exception.NoSuchPermisionEntryException;
import com.swork.account.service.model.PermisionEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the permision entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermisionEntryUtil
 * @generated
 */
@ProviderType
public interface PermisionEntryPersistence
	extends BasePersistence<PermisionEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PermisionEntryUtil} to access the permision entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the permision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching permision entries
	 */
	public java.util.List<PermisionEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the permision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permision entries
	 * @param end the upper bound of the range of permision entries (not inclusive)
	 * @return the range of matching permision entries
	 */
	public java.util.List<PermisionEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the permision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permision entries
	 * @param end the upper bound of the range of permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permision entries
	 */
	public java.util.List<PermisionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permision entries
	 * @param end the upper bound of the range of permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permision entries
	 */
	public java.util.List<PermisionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision entry
	 * @throws NoSuchPermisionEntryException if a matching permision entry could not be found
	 */
	public PermisionEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
				orderByComparator)
		throws NoSuchPermisionEntryException;

	/**
	 * Returns the first permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision entry, or <code>null</code> if a matching permision entry could not be found
	 */
	public PermisionEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
			orderByComparator);

	/**
	 * Returns the last permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision entry
	 * @throws NoSuchPermisionEntryException if a matching permision entry could not be found
	 */
	public PermisionEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
				orderByComparator)
		throws NoSuchPermisionEntryException;

	/**
	 * Returns the last permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision entry, or <code>null</code> if a matching permision entry could not be found
	 */
	public PermisionEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
			orderByComparator);

	/**
	 * Returns the permision entries before and after the current permision entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current permision entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permision entry
	 * @throws NoSuchPermisionEntryException if a permision entry with the primary key could not be found
	 */
	public PermisionEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
				orderByComparator)
		throws NoSuchPermisionEntryException;

	/**
	 * Removes all the permision entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of permision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching permision entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching permision entries
	 */
	public java.util.List<PermisionEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permision entries
	 * @param end the upper bound of the range of permision entries (not inclusive)
	 * @return the range of matching permision entries
	 */
	public java.util.List<PermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permision entries
	 * @param end the upper bound of the range of permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permision entries
	 */
	public java.util.List<PermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permision entries
	 * @param end the upper bound of the range of permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permision entries
	 */
	public java.util.List<PermisionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision entry
	 * @throws NoSuchPermisionEntryException if a matching permision entry could not be found
	 */
	public PermisionEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
				orderByComparator)
		throws NoSuchPermisionEntryException;

	/**
	 * Returns the first permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision entry, or <code>null</code> if a matching permision entry could not be found
	 */
	public PermisionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
			orderByComparator);

	/**
	 * Returns the last permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision entry
	 * @throws NoSuchPermisionEntryException if a matching permision entry could not be found
	 */
	public PermisionEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
				orderByComparator)
		throws NoSuchPermisionEntryException;

	/**
	 * Returns the last permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision entry, or <code>null</code> if a matching permision entry could not be found
	 */
	public PermisionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
			orderByComparator);

	/**
	 * Returns the permision entries before and after the current permision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current permision entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permision entry
	 * @throws NoSuchPermisionEntryException if a permision entry with the primary key could not be found
	 */
	public PermisionEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
				orderByComparator)
		throws NoSuchPermisionEntryException;

	/**
	 * Removes all the permision entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of permision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching permision entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the permision entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPermisionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permision entry
	 * @throws NoSuchPermisionEntryException if a matching permision entry could not be found
	 */
	public PermisionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermisionEntryException;

	/**
	 * Returns the permision entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permision entry, or <code>null</code> if a matching permision entry could not be found
	 */
	public PermisionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the permision entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching permision entry, or <code>null</code> if a matching permision entry could not be found
	 */
	public PermisionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the permision entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the permision entry that was removed
	 */
	public PermisionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermisionEntryException;

	/**
	 * Returns the number of permision entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching permision entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the permision entry in the entity cache if it is enabled.
	 *
	 * @param permisionEntry the permision entry
	 */
	public void cacheResult(PermisionEntry permisionEntry);

	/**
	 * Caches the permision entries in the entity cache if it is enabled.
	 *
	 * @param permisionEntries the permision entries
	 */
	public void cacheResult(java.util.List<PermisionEntry> permisionEntries);

	/**
	 * Creates a new permision entry with the primary key. Does not add the permision entry to the database.
	 *
	 * @param id the primary key for the new permision entry
	 * @return the new permision entry
	 */
	public PermisionEntry create(long id);

	/**
	 * Removes the permision entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the permision entry
	 * @return the permision entry that was removed
	 * @throws NoSuchPermisionEntryException if a permision entry with the primary key could not be found
	 */
	public PermisionEntry remove(long id) throws NoSuchPermisionEntryException;

	public PermisionEntry updateImpl(PermisionEntry permisionEntry);

	/**
	 * Returns the permision entry with the primary key or throws a <code>NoSuchPermisionEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the permision entry
	 * @return the permision entry
	 * @throws NoSuchPermisionEntryException if a permision entry with the primary key could not be found
	 */
	public PermisionEntry findByPrimaryKey(long id)
		throws NoSuchPermisionEntryException;

	/**
	 * Returns the permision entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the permision entry
	 * @return the permision entry, or <code>null</code> if a permision entry with the primary key could not be found
	 */
	public PermisionEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the permision entries.
	 *
	 * @return the permision entries
	 */
	public java.util.List<PermisionEntry> findAll();

	/**
	 * Returns a range of all the permision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permision entries
	 * @param end the upper bound of the range of permision entries (not inclusive)
	 * @return the range of permision entries
	 */
	public java.util.List<PermisionEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the permision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permision entries
	 * @param end the upper bound of the range of permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permision entries
	 */
	public java.util.List<PermisionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermisionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permision entries
	 * @param end the upper bound of the range of permision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of permision entries
	 */
	public java.util.List<PermisionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the permision entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of permision entries.
	 *
	 * @return the number of permision entries
	 */
	public int countAll();

}