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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.checklist.service.model.ChecklistHandlerEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the checklist handler entry service. This utility wraps <code>com.swork.checklist.service.service.persistence.impl.ChecklistHandlerEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistHandlerEntryPersistence
 * @generated
 */
public class ChecklistHandlerEntryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ChecklistHandlerEntry checklistHandlerEntry) {
		getPersistence().clearCache(checklistHandlerEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ChecklistHandlerEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChecklistHandlerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChecklistHandlerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChecklistHandlerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ChecklistHandlerEntry update(
		ChecklistHandlerEntry checklistHandlerEntry) {

		return getPersistence().update(checklistHandlerEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ChecklistHandlerEntry update(
		ChecklistHandlerEntry checklistHandlerEntry,
		ServiceContext serviceContext) {

		return getPersistence().update(checklistHandlerEntry, serviceContext);
	}

	/**
	 * Returns all the checklist handler entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching checklist handler entries
	 */
	public static List<ChecklistHandlerEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ChecklistHandlerEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ChecklistHandlerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ChecklistHandlerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry findByUuid_First(
			String uuid,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistHandlerEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry findByUuid_Last(
			String uuid,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistHandlerEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the checklist handler entries before and after the current checklist handler entry in the ordered set where uuid = &#63;.
	 *
	 * @param checklistHandlerId the primary key of the current checklist handler entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	public static ChecklistHandlerEntry[] findByUuid_PrevAndNext(
			long checklistHandlerId, String uuid,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistHandlerEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			checklistHandlerId, uuid, orderByComparator);
	}

	/**
	 * Removes all the checklist handler entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of checklist handler entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching checklist handler entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the checklist handler entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchChecklistHandlerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistHandlerEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the checklist handler entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the checklist handler entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the checklist handler entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the checklist handler entry that was removed
	 */
	public static ChecklistHandlerEntry removeByUUID_G(
			String uuid, long groupId)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistHandlerEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of checklist handler entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching checklist handler entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the checklist handler entries where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @return the matching checklist handler entries
	 */
	public static List<ChecklistHandlerEntry> findBycheckListId(
		Long checkListId) {

		return getPersistence().findBycheckListId(checkListId);
	}

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
	public static List<ChecklistHandlerEntry> findBycheckListId(
		Long checkListId, int start, int end) {

		return getPersistence().findBycheckListId(checkListId, start, end);
	}

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
	public static List<ChecklistHandlerEntry> findBycheckListId(
		Long checkListId, int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		return getPersistence().findBycheckListId(
			checkListId, start, end, orderByComparator);
	}

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
	public static List<ChecklistHandlerEntry> findBycheckListId(
		Long checkListId, int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycheckListId(
			checkListId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry findBycheckListId_First(
			Long checkListId,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistHandlerEntryException {

		return getPersistence().findBycheckListId_First(
			checkListId, orderByComparator);
	}

	/**
	 * Returns the first checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry fetchBycheckListId_First(
		Long checkListId,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		return getPersistence().fetchBycheckListId_First(
			checkListId, orderByComparator);
	}

	/**
	 * Returns the last checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry findBycheckListId_Last(
			Long checkListId,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistHandlerEntryException {

		return getPersistence().findBycheckListId_Last(
			checkListId, orderByComparator);
	}

	/**
	 * Returns the last checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist handler entry, or <code>null</code> if a matching checklist handler entry could not be found
	 */
	public static ChecklistHandlerEntry fetchBycheckListId_Last(
		Long checkListId,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		return getPersistence().fetchBycheckListId_Last(
			checkListId, orderByComparator);
	}

	/**
	 * Returns the checklist handler entries before and after the current checklist handler entry in the ordered set where checkListId = &#63;.
	 *
	 * @param checklistHandlerId the primary key of the current checklist handler entry
	 * @param checkListId the check list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	public static ChecklistHandlerEntry[] findBycheckListId_PrevAndNext(
			long checklistHandlerId, Long checkListId,
			OrderByComparator<ChecklistHandlerEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistHandlerEntryException {

		return getPersistence().findBycheckListId_PrevAndNext(
			checklistHandlerId, checkListId, orderByComparator);
	}

	/**
	 * Removes all the checklist handler entries where checkListId = &#63; from the database.
	 *
	 * @param checkListId the check list ID
	 */
	public static void removeBycheckListId(Long checkListId) {
		getPersistence().removeBycheckListId(checkListId);
	}

	/**
	 * Returns the number of checklist handler entries where checkListId = &#63;.
	 *
	 * @param checkListId the check list ID
	 * @return the number of matching checklist handler entries
	 */
	public static int countBycheckListId(Long checkListId) {
		return getPersistence().countBycheckListId(checkListId);
	}

	/**
	 * Caches the checklist handler entry in the entity cache if it is enabled.
	 *
	 * @param checklistHandlerEntry the checklist handler entry
	 */
	public static void cacheResult(
		ChecklistHandlerEntry checklistHandlerEntry) {

		getPersistence().cacheResult(checklistHandlerEntry);
	}

	/**
	 * Caches the checklist handler entries in the entity cache if it is enabled.
	 *
	 * @param checklistHandlerEntries the checklist handler entries
	 */
	public static void cacheResult(
		List<ChecklistHandlerEntry> checklistHandlerEntries) {

		getPersistence().cacheResult(checklistHandlerEntries);
	}

	/**
	 * Creates a new checklist handler entry with the primary key. Does not add the checklist handler entry to the database.
	 *
	 * @param checklistHandlerId the primary key for the new checklist handler entry
	 * @return the new checklist handler entry
	 */
	public static ChecklistHandlerEntry create(long checklistHandlerId) {
		return getPersistence().create(checklistHandlerId);
	}

	/**
	 * Removes the checklist handler entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry that was removed
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	public static ChecklistHandlerEntry remove(long checklistHandlerId)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistHandlerEntryException {

		return getPersistence().remove(checklistHandlerId);
	}

	public static ChecklistHandlerEntry updateImpl(
		ChecklistHandlerEntry checklistHandlerEntry) {

		return getPersistence().updateImpl(checklistHandlerEntry);
	}

	/**
	 * Returns the checklist handler entry with the primary key or throws a <code>NoSuchChecklistHandlerEntryException</code> if it could not be found.
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry
	 * @throws NoSuchChecklistHandlerEntryException if a checklist handler entry with the primary key could not be found
	 */
	public static ChecklistHandlerEntry findByPrimaryKey(
			long checklistHandlerId)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistHandlerEntryException {

		return getPersistence().findByPrimaryKey(checklistHandlerId);
	}

	/**
	 * Returns the checklist handler entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checklistHandlerId the primary key of the checklist handler entry
	 * @return the checklist handler entry, or <code>null</code> if a checklist handler entry with the primary key could not be found
	 */
	public static ChecklistHandlerEntry fetchByPrimaryKey(
		long checklistHandlerId) {

		return getPersistence().fetchByPrimaryKey(checklistHandlerId);
	}

	/**
	 * Returns all the checklist handler entries.
	 *
	 * @return the checklist handler entries
	 */
	public static List<ChecklistHandlerEntry> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ChecklistHandlerEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ChecklistHandlerEntry> findAll(
		int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ChecklistHandlerEntry> findAll(
		int start, int end,
		OrderByComparator<ChecklistHandlerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the checklist handler entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of checklist handler entries.
	 *
	 * @return the number of checklist handler entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChecklistHandlerEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ChecklistHandlerEntryPersistence _persistence;

}