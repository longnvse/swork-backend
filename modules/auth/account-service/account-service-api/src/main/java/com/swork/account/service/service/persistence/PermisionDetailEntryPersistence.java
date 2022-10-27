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

import com.swork.account.service.exception.NoSuchPermisionDetailEntryException;
import com.swork.account.service.model.PermisionDetailEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the permision detail entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermisionDetailEntryUtil
 * @generated
 */
@ProviderType
public interface PermisionDetailEntryPersistence
	extends BasePersistence<PermisionDetailEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PermisionDetailEntryUtil} to access the permision detail entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the permision detail entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching permision detail entries
	 */
	public java.util.List<PermisionDetailEntry> findByUuid(String uuid);

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
	public java.util.List<PermisionDetailEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<PermisionDetailEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionDetailEntry>
			orderByComparator);

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
	public java.util.List<PermisionDetailEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionDetailEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first permision detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a matching permision detail entry could not be found
	 */
	public PermisionDetailEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException;

	/**
	 * Returns the first permision detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	public PermisionDetailEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionDetailEntry>
			orderByComparator);

	/**
	 * Returns the last permision detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a matching permision detail entry could not be found
	 */
	public PermisionDetailEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException;

	/**
	 * Returns the last permision detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	public PermisionDetailEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionDetailEntry>
			orderByComparator);

	/**
	 * Returns the permision detail entries before and after the current permision detail entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current permision detail entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a permision detail entry with the primary key could not be found
	 */
	public PermisionDetailEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException;

	/**
	 * Removes all the permision detail entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of permision detail entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching permision detail entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the permision detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching permision detail entries
	 */
	public java.util.List<PermisionDetailEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<PermisionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<PermisionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionDetailEntry>
			orderByComparator);

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
	public java.util.List<PermisionDetailEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionDetailEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first permision detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a matching permision detail entry could not be found
	 */
	public PermisionDetailEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException;

	/**
	 * Returns the first permision detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	public PermisionDetailEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionDetailEntry>
			orderByComparator);

	/**
	 * Returns the last permision detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a matching permision detail entry could not be found
	 */
	public PermisionDetailEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException;

	/**
	 * Returns the last permision detail entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	public PermisionDetailEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionDetailEntry>
			orderByComparator);

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
	public PermisionDetailEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PermisionDetailEntry> orderByComparator)
		throws NoSuchPermisionDetailEntryException;

	/**
	 * Removes all the permision detail entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of permision detail entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching permision detail entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the permision detail entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPermisionDetailEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a matching permision detail entry could not be found
	 */
	public PermisionDetailEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermisionDetailEntryException;

	/**
	 * Returns the permision detail entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	public PermisionDetailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the permision detail entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching permision detail entry, or <code>null</code> if a matching permision detail entry could not be found
	 */
	public PermisionDetailEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the permision detail entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the permision detail entry that was removed
	 */
	public PermisionDetailEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermisionDetailEntryException;

	/**
	 * Returns the number of permision detail entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching permision detail entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the permision detail entry in the entity cache if it is enabled.
	 *
	 * @param permisionDetailEntry the permision detail entry
	 */
	public void cacheResult(PermisionDetailEntry permisionDetailEntry);

	/**
	 * Caches the permision detail entries in the entity cache if it is enabled.
	 *
	 * @param permisionDetailEntries the permision detail entries
	 */
	public void cacheResult(
		java.util.List<PermisionDetailEntry> permisionDetailEntries);

	/**
	 * Creates a new permision detail entry with the primary key. Does not add the permision detail entry to the database.
	 *
	 * @param id the primary key for the new permision detail entry
	 * @return the new permision detail entry
	 */
	public PermisionDetailEntry create(long id);

	/**
	 * Removes the permision detail entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the permision detail entry
	 * @return the permision detail entry that was removed
	 * @throws NoSuchPermisionDetailEntryException if a permision detail entry with the primary key could not be found
	 */
	public PermisionDetailEntry remove(long id)
		throws NoSuchPermisionDetailEntryException;

	public PermisionDetailEntry updateImpl(
		PermisionDetailEntry permisionDetailEntry);

	/**
	 * Returns the permision detail entry with the primary key or throws a <code>NoSuchPermisionDetailEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the permision detail entry
	 * @return the permision detail entry
	 * @throws NoSuchPermisionDetailEntryException if a permision detail entry with the primary key could not be found
	 */
	public PermisionDetailEntry findByPrimaryKey(long id)
		throws NoSuchPermisionDetailEntryException;

	/**
	 * Returns the permision detail entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the permision detail entry
	 * @return the permision detail entry, or <code>null</code> if a permision detail entry with the primary key could not be found
	 */
	public PermisionDetailEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the permision detail entries.
	 *
	 * @return the permision detail entries
	 */
	public java.util.List<PermisionDetailEntry> findAll();

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
	public java.util.List<PermisionDetailEntry> findAll(int start, int end);

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
	public java.util.List<PermisionDetailEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionDetailEntry>
			orderByComparator);

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
	public java.util.List<PermisionDetailEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermisionDetailEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the permision detail entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of permision detail entries.
	 *
	 * @return the number of permision detail entries
	 */
	public int countAll();

}