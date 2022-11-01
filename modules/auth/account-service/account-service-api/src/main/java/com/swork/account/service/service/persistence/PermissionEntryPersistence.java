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

import com.swork.account.service.exception.NoSuchPermissionEntryException;
import com.swork.account.service.model.PermissionEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the permission entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermissionEntryUtil
 * @generated
 */
@ProviderType
public interface PermissionEntryPersistence
	extends BasePersistence<PermissionEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PermissionEntryUtil} to access the permission entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching permission entries
	 */
	public java.util.List<PermissionEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permission entries
	 * @param end the upper bound of the range of permission entries (not inclusive)
	 * @return the range of matching permission entries
	 */
	public java.util.List<PermissionEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permission entries
	 * @param end the upper bound of the range of permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission entries
	 */
	public java.util.List<PermissionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permission entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of permission entries
	 * @param end the upper bound of the range of permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission entries
	 */
	public java.util.List<PermissionEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission entry
	 * @throws NoSuchPermissionEntryException if a matching permission entry could not be found
	 */
	public PermissionEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
				orderByComparator)
		throws NoSuchPermissionEntryException;

	/**
	 * Returns the first permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission entry, or <code>null</code> if a matching permission entry could not be found
	 */
	public PermissionEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
			orderByComparator);

	/**
	 * Returns the last permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission entry
	 * @throws NoSuchPermissionEntryException if a matching permission entry could not be found
	 */
	public PermissionEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
				orderByComparator)
		throws NoSuchPermissionEntryException;

	/**
	 * Returns the last permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission entry, or <code>null</code> if a matching permission entry could not be found
	 */
	public PermissionEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
			orderByComparator);

	/**
	 * Returns the permission entries before and after the current permission entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current permission entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission entry
	 * @throws NoSuchPermissionEntryException if a permission entry with the primary key could not be found
	 */
	public PermissionEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
				orderByComparator)
		throws NoSuchPermissionEntryException;

	/**
	 * Removes all the permission entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of permission entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching permission entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching permission entries
	 */
	public java.util.List<PermissionEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permission entries
	 * @param end the upper bound of the range of permission entries (not inclusive)
	 * @return the range of matching permission entries
	 */
	public java.util.List<PermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permission entries
	 * @param end the upper bound of the range of permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission entries
	 */
	public java.util.List<PermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of permission entries
	 * @param end the upper bound of the range of permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission entries
	 */
	public java.util.List<PermissionEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission entry
	 * @throws NoSuchPermissionEntryException if a matching permission entry could not be found
	 */
	public PermissionEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
				orderByComparator)
		throws NoSuchPermissionEntryException;

	/**
	 * Returns the first permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission entry, or <code>null</code> if a matching permission entry could not be found
	 */
	public PermissionEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
			orderByComparator);

	/**
	 * Returns the last permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission entry
	 * @throws NoSuchPermissionEntryException if a matching permission entry could not be found
	 */
	public PermissionEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
				orderByComparator)
		throws NoSuchPermissionEntryException;

	/**
	 * Returns the last permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission entry, or <code>null</code> if a matching permission entry could not be found
	 */
	public PermissionEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
			orderByComparator);

	/**
	 * Returns the permission entries before and after the current permission entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current permission entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission entry
	 * @throws NoSuchPermissionEntryException if a permission entry with the primary key could not be found
	 */
	public PermissionEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
				orderByComparator)
		throws NoSuchPermissionEntryException;

	/**
	 * Removes all the permission entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of permission entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching permission entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the permission entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPermissionEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permission entry
	 * @throws NoSuchPermissionEntryException if a matching permission entry could not be found
	 */
	public PermissionEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermissionEntryException;

	/**
	 * Returns the permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching permission entry, or <code>null</code> if a matching permission entry could not be found
	 */
	public PermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the permission entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching permission entry, or <code>null</code> if a matching permission entry could not be found
	 */
	public PermissionEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the permission entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the permission entry that was removed
	 */
	public PermissionEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPermissionEntryException;

	/**
	 * Returns the number of permission entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching permission entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the permission entry in the entity cache if it is enabled.
	 *
	 * @param permissionEntry the permission entry
	 */
	public void cacheResult(PermissionEntry permissionEntry);

	/**
	 * Caches the permission entries in the entity cache if it is enabled.
	 *
	 * @param permissionEntries the permission entries
	 */
	public void cacheResult(java.util.List<PermissionEntry> permissionEntries);

	/**
	 * Creates a new permission entry with the primary key. Does not add the permission entry to the database.
	 *
	 * @param id the primary key for the new permission entry
	 * @return the new permission entry
	 */
	public PermissionEntry create(long id);

	/**
	 * Removes the permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the permission entry
	 * @return the permission entry that was removed
	 * @throws NoSuchPermissionEntryException if a permission entry with the primary key could not be found
	 */
	public PermissionEntry remove(long id)
		throws NoSuchPermissionEntryException;

	public PermissionEntry updateImpl(PermissionEntry permissionEntry);

	/**
	 * Returns the permission entry with the primary key or throws a <code>NoSuchPermissionEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the permission entry
	 * @return the permission entry
	 * @throws NoSuchPermissionEntryException if a permission entry with the primary key could not be found
	 */
	public PermissionEntry findByPrimaryKey(long id)
		throws NoSuchPermissionEntryException;

	/**
	 * Returns the permission entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the permission entry
	 * @return the permission entry, or <code>null</code> if a permission entry with the primary key could not be found
	 */
	public PermissionEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the permission entries.
	 *
	 * @return the permission entries
	 */
	public java.util.List<PermissionEntry> findAll();

	/**
	 * Returns a range of all the permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission entries
	 * @param end the upper bound of the range of permission entries (not inclusive)
	 * @return the range of permission entries
	 */
	public java.util.List<PermissionEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission entries
	 * @param end the upper bound of the range of permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permission entries
	 */
	public java.util.List<PermissionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission entries
	 * @param end the upper bound of the range of permission entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of permission entries
	 */
	public java.util.List<PermissionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the permission entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of permission entries.
	 *
	 * @return the number of permission entries
	 */
	public int countAll();

}