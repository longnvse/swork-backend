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

import com.swork.checklist.service.exception.NoSuchChecklistHandlerEntryException;
import com.swork.checklist.service.model.ChecklistHandlerEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the checklist handler entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistHandlerEntryUtil
 * @generated
 */
@ProviderType
public interface ChecklistHandlerEntryPersistence
	extends BasePersistence<ChecklistHandlerEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChecklistHandlerEntryUtil} to access the checklist handler entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the checklist handler entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the checklist handler entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @return the range of matching checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the checklist handler entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistHandlerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the checklist handler entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistHandlerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	public ChecklistHandlerEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException;

	/**
	 * Returns the first checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public ChecklistHandlerEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistHandlerEntry>
			orderByComparator);

	/**
	 * Returns the last checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	public ChecklistHandlerEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException;

	/**
	 * Returns the last checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public ChecklistHandlerEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistHandlerEntry>
			orderByComparator);

	/**
	 * Returns the checklist handler entries before and after the current checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param checklistHandlerId the primary key of the current checklist handler entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	public ChecklistHandlerEntry[] findByUuid_PrevAndNext(
			long checklistHandlerId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException;

	/**
	 * Removes all the checklist handler entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of checklist handler entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching checklist handler entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the checklist handler entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchChecklistHandlerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	public ChecklistHandlerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchChecklistHandlerEntryException;

	/**
	 * Returns the checklist handler entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public ChecklistHandlerEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the checklist handler entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public ChecklistHandlerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the checklist handler entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the checklist handler entry that was removed
	 */
	public ChecklistHandlerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchChecklistHandlerEntryException;

	/**
	 * Returns the number of checklist handler entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching checklist handler entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the checklist handler entries where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @return the matching checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findBycheckListId(
		Long checkListId);

	/**
	 * Returns a range of all the checklist handler entries where checkListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param checkListId the check list ID
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @return the range of matching checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findBycheckListId(
		Long checkListId, int start, int end);

	/**
	 * Returns an ordered range of all the checklist handler entries where checkListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param checkListId the check list ID
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findBycheckListId(
		Long checkListId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistHandlerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the checklist handler entries where checkListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param checkListId the check list ID
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findBycheckListId(
		Long checkListId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistHandlerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	public ChecklistHandlerEntry findBycheckListId_First(
			Long checkListId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException;

	/**
	 * Returns the first checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public ChecklistHandlerEntry fetchBycheckListId_First(
		Long checkListId,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistHandlerEntry>
			orderByComparator);

	/**
	 * Returns the last checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	public ChecklistHandlerEntry findBycheckListId_Last(
			Long checkListId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException;

	/**
	 * Returns the last checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public ChecklistHandlerEntry fetchBycheckListId_Last(
		Long checkListId,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistHandlerEntry>
			orderByComparator);

	/**
	 * Returns the checklist handler entries before and after the current checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checklistHandlerId the primary key of the current checklist handler entry
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	public ChecklistHandlerEntry[] findBycheckListId_PrevAndNext(
			long checklistHandlerId, Long checkListId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ChecklistHandlerEntry> orderByComparator)
		throws NoSuchChecklistHandlerEntryException;

	/**
	 * Removes all the checklist handler entries where checkListId = &#63; from the database.
	 *
	 * @param checkListId the check list ID
	 */
	public void removeBycheckListId(Long checkListId);

	/**
	 * Returns the number of checklist handler entries where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @return the number of matching checklist handler entries
	 */
	public int countBycheckListId(Long checkListId);

	/**
	 * Caches the checklist handler entry in the entity cache if it is enabled.
	 *
	 * @param checklistHandlerEntry the checklist handler entry
	 */
	public void cacheResult(ChecklistHandlerEntry checklistHandlerEntry);

	/**
	 * Caches the checklist handler entries in the entity cache if it is enabled.
	 *
	 * @param checklistHandlerEntries the checklist handler entries
	 */
	public void cacheResult(
		java.util.List<ChecklistHandlerEntry> checklistHandlerEntries);

	/**
	 * Creates a new checklist handler entry with the primary key. Does not add the checklist handler entry to the database.
	 *
	 * @param checklistHandlerId the primary key for the new checklist handler entry
	 * @return the new checklist handler entry
	 */
	public ChecklistHandlerEntry create(long checklistHandlerId);

	/**
	 * Removes the checklist handler entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry that was removed
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	public ChecklistHandlerEntry remove(long checklistHandlerId)
		throws NoSuchChecklistHandlerEntryException;

	public ChecklistHandlerEntry updateImpl(
		ChecklistHandlerEntry checklistHandlerEntry);

	/**
	 * Returns the checklist handler entry with the primary key or throws a <code>NoSuchChecklistHandlerEntryException</code> if it could not be found.
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	public ChecklistHandlerEntry findByPrimaryKey(long checklistHandlerId)
		throws NoSuchChecklistHandlerEntryException;

	/**
	 * Returns the checklist handler entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry, or <code>null</code> if a checklist handler entry with the primary key could not be found
	 */
	public ChecklistHandlerEntry fetchByPrimaryKey(long checklistHandlerId);

	/**
	 * Returns all the checklist handler entries.
	 *
	 * @return the checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findAll();

	/**
	 * Returns a range of all the checklist handler entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @return the range of checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the checklist handler entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistHandlerEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the checklist handler entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChecklistHandlerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checklist handler entries
	 * @param end the upper bound of the range of checklist handler entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of checklist handler entries
	 */
	public java.util.List<ChecklistHandlerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChecklistHandlerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the checklist handler entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of checklist handler entries.
	 *
	 * @return the number of checklist handler entries
	 */
	public int countAll();

}