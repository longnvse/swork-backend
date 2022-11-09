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

import com.swork.auth.department.service.exception.NoSuchDepartmentAccountEntryException;
import com.swork.auth.department.service.model.DepartmentAccountEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the department account entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentAccountEntryUtil
 * @generated
 */
@ProviderType
public interface DepartmentAccountEntryPersistence
	extends BasePersistence<DepartmentAccountEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DepartmentAccountEntryUtil} to access the department account entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the department account entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the department account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Returns the first department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator);

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator);

	/**
	 * Returns the department account entries before and after the current department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param departmentAccountId the primary key of the current department account entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	public DepartmentAccountEntry[] findByUuid_PrevAndNext(
			long departmentAccountId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Removes all the department account entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of department account entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching department account entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the department account entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDepartmentAccountEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Returns the department account entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the department account entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the department account entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the department account entry that was removed
	 */
	public DepartmentAccountEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Returns the number of department account entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching department account entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Returns the first department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator);

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator);

	/**
	 * Returns the department account entries before and after the current department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param departmentAccountId the primary key of the current department account entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	public DepartmentAccountEntry[] findByUuid_C_PrevAndNext(
			long departmentAccountId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Removes all the department account entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching department account entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the department account entries where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByDepartmentId(
		long departmentId);

	/**
	 * Returns a range of all the department account entries where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByDepartmentId(
		long departmentId, int start, int end);

	/**
	 * Returns an ordered range of all the department account entries where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByDepartmentId(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the department account entries where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findByDepartmentId(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry findByDepartmentId_First(
			long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Returns the first department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry fetchByDepartmentId_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator);

	/**
	 * Returns the last department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry findByDepartmentId_Last(
			long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Returns the last department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry fetchByDepartmentId_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator);

	/**
	 * Returns the department account entries before and after the current department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentAccountId the primary key of the current department account entry
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	public DepartmentAccountEntry[] findByDepartmentId_PrevAndNext(
			long departmentAccountId, long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<DepartmentAccountEntry> orderByComparator)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Removes all the department account entries where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 */
	public void removeByDepartmentId(long departmentId);

	/**
	 * Returns the number of department account entries where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching department account entries
	 */
	public int countByDepartmentId(long departmentId);

	/**
	 * Returns the department account entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDepartmentAccountEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Returns the department account entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the department account entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public DepartmentAccountEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the department account entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the department account entry that was removed
	 */
	public DepartmentAccountEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Returns the number of department account entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching department account entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the department account entry in the entity cache if it is enabled.
	 *
	 * @param departmentAccountEntry the department account entry
	 */
	public void cacheResult(DepartmentAccountEntry departmentAccountEntry);

	/**
	 * Caches the department account entries in the entity cache if it is enabled.
	 *
	 * @param departmentAccountEntries the department account entries
	 */
	public void cacheResult(
		java.util.List<DepartmentAccountEntry> departmentAccountEntries);

	/**
	 * Creates a new department account entry with the primary key. Does not add the department account entry to the database.
	 *
	 * @param departmentAccountId the primary key for the new department account entry
	 * @return the new department account entry
	 */
	public DepartmentAccountEntry create(long departmentAccountId);

	/**
	 * Removes the department account entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry that was removed
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	public DepartmentAccountEntry remove(long departmentAccountId)
		throws NoSuchDepartmentAccountEntryException;

	public DepartmentAccountEntry updateImpl(
		DepartmentAccountEntry departmentAccountEntry);

	/**
	 * Returns the department account entry with the primary key or throws a <code>NoSuchDepartmentAccountEntryException</code> if it could not be found.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	public DepartmentAccountEntry findByPrimaryKey(long departmentAccountId)
		throws NoSuchDepartmentAccountEntryException;

	/**
	 * Returns the department account entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry, or <code>null</code> if a department account entry with the primary key could not be found
	 */
	public DepartmentAccountEntry fetchByPrimaryKey(long departmentAccountId);

	/**
	 * Returns all the department account entries.
	 *
	 * @return the department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findAll();

	/**
	 * Returns a range of all the department account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the department account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the department account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of department account entries
	 */
	public java.util.List<DepartmentAccountEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentAccountEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the department account entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of department account entries.
	 *
	 * @return the number of department account entries
	 */
	public int countAll();

}