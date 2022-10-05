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

package com.swork.business.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.business.service.exception.NoSuchBusinessEntryException;
import com.swork.business.service.model.BusinessEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the business entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessEntryUtil
 * @generated
 */
@ProviderType
public interface BusinessEntryPersistence
	extends BasePersistence<BusinessEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusinessEntryUtil} to access the business entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the business entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching business entries
	 */
	public java.util.List<BusinessEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the business entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @return the range of matching business entries
	 */
	public java.util.List<BusinessEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business entries
	 */
	public java.util.List<BusinessEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching business entries
	 */
	public java.util.List<BusinessEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public BusinessEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
				orderByComparator)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the first business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
			orderByComparator);

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public BusinessEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
				orderByComparator)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
			orderByComparator);

	/**
	 * Returns the business entries before and after the current business entry in the ordered set where uuid = &#63;.
	 *
	 * @param businessId the primary key of the current business entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next business entry
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	public BusinessEntry[] findByUuid_PrevAndNext(
			long businessId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
				orderByComparator)
		throws NoSuchBusinessEntryException;

	/**
	 * Removes all the business entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of business entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching business entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the business entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public BusinessEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the business entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the business entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the business entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the business entry that was removed
	 */
	public BusinessEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the number of business entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching business entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching business entries
	 */
	public java.util.List<BusinessEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @return the range of matching business entries
	 */
	public java.util.List<BusinessEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business entries
	 */
	public java.util.List<BusinessEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching business entries
	 */
	public java.util.List<BusinessEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public BusinessEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
				orderByComparator)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the first business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
			orderByComparator);

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public BusinessEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
				orderByComparator)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the last business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
			orderByComparator);

	/**
	 * Returns the business entries before and after the current business entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param businessId the primary key of the current business entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next business entry
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	public BusinessEntry[] findByUuid_C_PrevAndNext(
			long businessId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
				orderByComparator)
		throws NoSuchBusinessEntryException;

	/**
	 * Removes all the business entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of business entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching business entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the business entry where phoneNumber = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param phoneNumber the phone number
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public BusinessEntry findByPhone(String phoneNumber)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the business entry where phoneNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param phoneNumber the phone number
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByPhone(String phoneNumber);

	/**
	 * Returns the business entry where phoneNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param phoneNumber the phone number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByPhone(
		String phoneNumber, boolean useFinderCache);

	/**
	 * Removes the business entry where phoneNumber = &#63; from the database.
	 *
	 * @param phoneNumber the phone number
	 * @return the business entry that was removed
	 */
	public BusinessEntry removeByPhone(String phoneNumber)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the number of business entries where phoneNumber = &#63;.
	 *
	 * @param phoneNumber the phone number
	 * @return the number of matching business entries
	 */
	public int countByPhone(String phoneNumber);

	/**
	 * Returns the business entry where email = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public BusinessEntry findByEmail(String email)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the business entry where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByEmail(String email);

	/**
	 * Returns the business entry where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByEmail(String email, boolean useFinderCache);

	/**
	 * Removes the business entry where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the business entry that was removed
	 */
	public BusinessEntry removeByEmail(String email)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the number of business entries where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching business entries
	 */
	public int countByEmail(String email);

	/**
	 * Returns the business entry where name = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public BusinessEntry findByName(String name)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the business entry where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByName(String name);

	/**
	 * Returns the business entry where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the business entry where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the business entry that was removed
	 */
	public BusinessEntry removeByName(String name)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the number of business entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching business entries
	 */
	public int countByName(String name);

	/**
	 * Returns the business entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching business entry
	 * @throws NoSuchBusinessEntryException if a matching business entry could not be found
	 */
	public BusinessEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the business entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the business entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public BusinessEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the business entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the business entry that was removed
	 */
	public BusinessEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the number of business entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching business entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the business entry in the entity cache if it is enabled.
	 *
	 * @param businessEntry the business entry
	 */
	public void cacheResult(BusinessEntry businessEntry);

	/**
	 * Caches the business entries in the entity cache if it is enabled.
	 *
	 * @param businessEntries the business entries
	 */
	public void cacheResult(java.util.List<BusinessEntry> businessEntries);

	/**
	 * Creates a new business entry with the primary key. Does not add the business entry to the database.
	 *
	 * @param businessId the primary key for the new business entry
	 * @return the new business entry
	 */
	public BusinessEntry create(long businessId);

	/**
	 * Removes the business entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry that was removed
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	public BusinessEntry remove(long businessId)
		throws NoSuchBusinessEntryException;

	public BusinessEntry updateImpl(BusinessEntry businessEntry);

	/**
	 * Returns the business entry with the primary key or throws a <code>NoSuchBusinessEntryException</code> if it could not be found.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry
	 * @throws NoSuchBusinessEntryException if a business entry with the primary key could not be found
	 */
	public BusinessEntry findByPrimaryKey(long businessId)
		throws NoSuchBusinessEntryException;

	/**
	 * Returns the business entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry, or <code>null</code> if a business entry with the primary key could not be found
	 */
	public BusinessEntry fetchByPrimaryKey(long businessId);

	/**
	 * Returns all the business entries.
	 *
	 * @return the business entries
	 */
	public java.util.List<BusinessEntry> findAll();

	/**
	 * Returns a range of all the business entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @return the range of business entries
	 */
	public java.util.List<BusinessEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the business entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of business entries
	 */
	public java.util.List<BusinessEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the business entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of business entries
	 */
	public java.util.List<BusinessEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusinessEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the business entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of business entries.
	 *
	 * @return the number of business entries
	 */
	public int countAll();

}