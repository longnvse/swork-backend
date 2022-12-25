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

package com.swork.auth.department.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.auth.department.service.exception.NoSuchDepartmentEntryException;
import com.swork.auth.department.service.model.DepartmentEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the department entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentEntryUtil
 * @generated
 */
@ProviderType
public interface DepartmentEntryPersistence
	extends BasePersistence<DepartmentEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DepartmentEntryUtil} to access the department entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the department entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching department entries
	 */
	public java.util.List<DepartmentEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of matching department entries
	 */
	public java.util.List<DepartmentEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department entries
	 */
	public java.util.List<DepartmentEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department entries
	 */
	public java.util.List<DepartmentEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public DepartmentEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
				orderByComparator)
		throws NoSuchDepartmentEntryException;

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public DepartmentEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
			orderByComparator);

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public DepartmentEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
				orderByComparator)
		throws NoSuchDepartmentEntryException;

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public DepartmentEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
			orderByComparator);

	/**
	 * Returns the department entries before and after the current department entry in the ordered set where uuid = &#63;.
	 *
	 * @param departmentId the primary key of the current department entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public DepartmentEntry[] findByUuid_PrevAndNext(
			long departmentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
				orderByComparator)
		throws NoSuchDepartmentEntryException;

	/**
	 * Removes all the department entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of department entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching department entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public DepartmentEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDepartmentEntryException;

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public DepartmentEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public DepartmentEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the department entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the department entry that was removed
	 */
	public DepartmentEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDepartmentEntryException;

	/**
	 * Returns the number of department entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching department entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching department entries
	 */
	public java.util.List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of matching department entries
	 */
	public java.util.List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department entries
	 */
	public java.util.List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department entries
	 */
	public java.util.List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public DepartmentEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
				orderByComparator)
		throws NoSuchDepartmentEntryException;

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public DepartmentEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
			orderByComparator);

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public DepartmentEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
				orderByComparator)
		throws NoSuchDepartmentEntryException;

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public DepartmentEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
			orderByComparator);

	/**
	 * Returns the department entries before and after the current department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the primary key of the current department entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public DepartmentEntry[] findByUuid_C_PrevAndNext(
			long departmentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
				orderByComparator)
		throws NoSuchDepartmentEntryException;

	/**
	 * Removes all the department entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching department entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the department entry where name = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public DepartmentEntry findByName(String name)
		throws NoSuchDepartmentEntryException;

	/**
	 * Returns the department entry where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public DepartmentEntry fetchByName(String name);

	/**
	 * Returns the department entry where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public DepartmentEntry fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the department entry where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the department entry that was removed
	 */
	public DepartmentEntry removeByName(String name)
		throws NoSuchDepartmentEntryException;

	/**
	 * Returns the number of department entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching department entries
	 */
	public int countByName(String name);

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public DepartmentEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDepartmentEntryException;

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public DepartmentEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public DepartmentEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the department entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the department entry that was removed
	 */
	public DepartmentEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDepartmentEntryException;

	/**
	 * Returns the number of department entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching department entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the department entry in the entity cache if it is enabled.
	 *
	 * @param departmentEntry the department entry
	 */
	public void cacheResult(DepartmentEntry departmentEntry);

	/**
	 * Caches the department entries in the entity cache if it is enabled.
	 *
	 * @param departmentEntries the department entries
	 */
	public void cacheResult(java.util.List<DepartmentEntry> departmentEntries);

	/**
	 * Creates a new department entry with the primary key. Does not add the department entry to the database.
	 *
	 * @param departmentId the primary key for the new department entry
	 * @return the new department entry
	 */
	public DepartmentEntry create(long departmentId);

	/**
	 * Removes the department entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry that was removed
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public DepartmentEntry remove(long departmentId)
		throws NoSuchDepartmentEntryException;

	public DepartmentEntry updateImpl(DepartmentEntry departmentEntry);

	/**
	 * Returns the department entry with the primary key or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public DepartmentEntry findByPrimaryKey(long departmentId)
		throws NoSuchDepartmentEntryException;

	/**
	 * Returns the department entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry, or <code>null</code> if a department entry with the primary key could not be found
	 */
	public DepartmentEntry fetchByPrimaryKey(long departmentId);

	/**
	 * Returns all the department entries.
	 *
	 * @return the department entries
	 */
	public java.util.List<DepartmentEntry> findAll();

	/**
	 * Returns a range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of department entries
	 */
	public java.util.List<DepartmentEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of department entries
	 */
	public java.util.List<DepartmentEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of department entries
	 */
	public java.util.List<DepartmentEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the department entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of department entries.
	 *
	 * @return the number of department entries
	 */
	public int countAll();

}