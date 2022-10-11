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

package com.swork.checklist.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.checklist.service.exception.NoSuchChecklistEntryException;
import com.swork.checklist.service.model.ChecklistEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the checklist entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistEntryUtil
 * @generated
 */
@ProviderType
public interface ChecklistEntryPersistence
	extends BasePersistence<ChecklistEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChecklistEntryUtil} to access the checklist entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the checklist entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching checklist entries
	 */
	public java.util.List<ChecklistEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the checklist entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @return the range of matching checklist entries
	 */
	public java.util.List<ChecklistEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the checklist entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checklist entries
	 */
	public java.util.List<ChecklistEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the checklist entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checklist entries
	 */
	public java.util.List<ChecklistEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	public ChecklistEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
				orderByComparator)
		throws NoSuchChecklistEntryException;

	/**
	 * Returns the first checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public ChecklistEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
			orderByComparator);

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	public ChecklistEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
				orderByComparator)
		throws NoSuchChecklistEntryException;

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public ChecklistEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
			orderByComparator);

	/**
	 * Returns the checklist entries before and after the current checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param checklistId the primary key of the current checklist entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checklist entry
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	public ChecklistEntry[] findByUuid_PrevAndNext(
			long checklistId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
				orderByComparator)
		throws NoSuchChecklistEntryException;

	/**
	 * Removes all the checklist entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of checklist entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching checklist entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the checklist entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchChecklistEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	public ChecklistEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchChecklistEntryException;

	/**
	 * Returns the checklist entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public ChecklistEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the checklist entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public ChecklistEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the checklist entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the checklist entry that was removed
	 */
	public ChecklistEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchChecklistEntryException;

	/**
	 * Returns the number of checklist entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching checklist entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching checklist entries
	 */
	public java.util.List<ChecklistEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @return the range of matching checklist entries
	 */
	public java.util.List<ChecklistEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checklist entries
	 */
	public java.util.List<ChecklistEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checklist entries
	 */
	public java.util.List<ChecklistEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	public ChecklistEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
				orderByComparator)
		throws NoSuchChecklistEntryException;

	/**
	 * Returns the first checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public ChecklistEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
			orderByComparator);

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	public ChecklistEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
				orderByComparator)
		throws NoSuchChecklistEntryException;

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public ChecklistEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
			orderByComparator);

	/**
	 * Returns the checklist entries before and after the current checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param checklistId the primary key of the current checklist entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checklist entry
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	public ChecklistEntry[] findByUuid_C_PrevAndNext(
			long checklistId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
				orderByComparator)
		throws NoSuchChecklistEntryException;

	/**
	 * Removes all the checklist entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching checklist entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the checklist entry in the entity cache if it is enabled.
	 *
	 * @param checklistEntry the checklist entry
	 */
	public void cacheResult(ChecklistEntry checklistEntry);

	/**
	 * Caches the checklist entries in the entity cache if it is enabled.
	 *
	 * @param checklistEntries the checklist entries
	 */
	public void cacheResult(java.util.List<ChecklistEntry> checklistEntries);

	/**
	 * Creates a new checklist entry with the primary key. Does not add the checklist entry to the database.
	 *
	 * @param checklistId the primary key for the new checklist entry
	 * @return the new checklist entry
	 */
	public ChecklistEntry create(long checklistId);

	/**
	 * Removes the checklist entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry that was removed
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	public ChecklistEntry remove(long checklistId)
		throws NoSuchChecklistEntryException;

	public ChecklistEntry updateImpl(ChecklistEntry checklistEntry);

	/**
	 * Returns the checklist entry with the primary key or throws a <code>NoSuchChecklistEntryException</code> if it could not be found.
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	public ChecklistEntry findByPrimaryKey(long checklistId)
		throws NoSuchChecklistEntryException;

	/**
	 * Returns the checklist entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry, or <code>null</code> if a checklist entry with the primary key could not be found
	 */
	public ChecklistEntry fetchByPrimaryKey(long checklistId);

	/**
	 * Returns all the checklist entries.
	 *
	 * @return the checklist entries
	 */
	public java.util.List<ChecklistEntry> findAll();

	/**
	 * Returns a range of all the checklist entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @return the range of checklist entries
	 */
	public java.util.List<ChecklistEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the checklist entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of checklist entries
	 */
	public java.util.List<ChecklistEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the checklist entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist entries
	 * @param end the upper bound of the range of checklist entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of checklist entries
	 */
	public java.util.List<ChecklistEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the checklist entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of checklist entries.
	 *
	 * @return the number of checklist entries
	 */
	public int countAll();

}