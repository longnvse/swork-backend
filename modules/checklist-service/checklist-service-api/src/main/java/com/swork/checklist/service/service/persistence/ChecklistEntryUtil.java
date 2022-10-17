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

import com.swork.checklist.service.model.ChecklistEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the checklist entry service. This utility wraps <code>com.swork.checklist.service.service.persistence.impl.ChecklistEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistEntryPersistence
 * @generated
 */
public class ChecklistEntryUtil {

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
	public static void clearCache(ChecklistEntry checklistEntry) {
		getPersistence().clearCache(checklistEntry);
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
	public static Map<Serializable, ChecklistEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChecklistEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChecklistEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChecklistEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ChecklistEntry update(ChecklistEntry checklistEntry) {
		return getPersistence().update(checklistEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ChecklistEntry update(
		ChecklistEntry checklistEntry, ServiceContext serviceContext) {

		return getPersistence().update(checklistEntry, serviceContext);
	}

	/**
	 * Returns all the checklist entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching checklist entries
	 */
	public static List<ChecklistEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ChecklistEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ChecklistEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ChecklistEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	public static ChecklistEntry findByUuid_First(
			String uuid, OrderByComparator<ChecklistEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public static ChecklistEntry fetchByUuid_First(
		String uuid, OrderByComparator<ChecklistEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	public static ChecklistEntry findByUuid_Last(
			String uuid, OrderByComparator<ChecklistEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public static ChecklistEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ChecklistEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the checklist entries before and after the current checklist entry in the ordered set where uuid = &#63;.
	 *
	 * @param checklistId the primary key of the current checklist entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next checklist entry
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	public static ChecklistEntry[] findByUuid_PrevAndNext(
			long checklistId, String uuid,
			OrderByComparator<ChecklistEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			checklistId, uuid, orderByComparator);
	}

	/**
	 * Removes all the checklist entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of checklist entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching checklist entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the checklist entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchChecklistEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	public static ChecklistEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the checklist entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public static ChecklistEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the checklist entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public static ChecklistEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the checklist entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the checklist entry that was removed
	 */
	public static ChecklistEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of checklist entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching checklist entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching checklist entries
	 */
	public static List<ChecklistEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<ChecklistEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<ChecklistEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<ChecklistEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	public static ChecklistEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ChecklistEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public static ChecklistEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	public static ChecklistEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ChecklistEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last checklist entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public static ChecklistEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static ChecklistEntry[] findByUuid_C_PrevAndNext(
			long checklistId, String uuid, long companyId,
			OrderByComparator<ChecklistEntry> orderByComparator)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			checklistId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the checklist entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of checklist entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching checklist entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the checklist entry where name = &#63; or throws a <code>NoSuchChecklistEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching checklist entry
	 * @throws NoSuchChecklistEntryException if a matching checklist entry could not be found
	 */
	public static ChecklistEntry findByName(String name)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the checklist entry where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public static ChecklistEntry fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the checklist entry where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching checklist entry, or <code>null</code> if a matching checklist entry could not be found
	 */
	public static ChecklistEntry fetchByName(
		String name, boolean useFinderCache) {

		return getPersistence().fetchByName(name, useFinderCache);
	}

	/**
	 * Removes the checklist entry where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the checklist entry that was removed
	 */
	public static ChecklistEntry removeByName(String name)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of checklist entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching checklist entries
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the checklist entry in the entity cache if it is enabled.
	 *
	 * @param checklistEntry the checklist entry
	 */
	public static void cacheResult(ChecklistEntry checklistEntry) {
		getPersistence().cacheResult(checklistEntry);
	}

	/**
	 * Caches the checklist entries in the entity cache if it is enabled.
	 *
	 * @param checklistEntries the checklist entries
	 */
	public static void cacheResult(List<ChecklistEntry> checklistEntries) {
		getPersistence().cacheResult(checklistEntries);
	}

	/**
	 * Creates a new checklist entry with the primary key. Does not add the checklist entry to the database.
	 *
	 * @param checklistId the primary key for the new checklist entry
	 * @return the new checklist entry
	 */
	public static ChecklistEntry create(long checklistId) {
		return getPersistence().create(checklistId);
	}

	/**
	 * Removes the checklist entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry that was removed
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	public static ChecklistEntry remove(long checklistId)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().remove(checklistId);
	}

	public static ChecklistEntry updateImpl(ChecklistEntry checklistEntry) {
		return getPersistence().updateImpl(checklistEntry);
	}

	/**
	 * Returns the checklist entry with the primary key or throws a <code>NoSuchChecklistEntryException</code> if it could not be found.
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry
	 * @throws NoSuchChecklistEntryException if a checklist entry with the primary key could not be found
	 */
	public static ChecklistEntry findByPrimaryKey(long checklistId)
		throws com.swork.checklist.service.exception.
			NoSuchChecklistEntryException {

		return getPersistence().findByPrimaryKey(checklistId);
	}

	/**
	 * Returns the checklist entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checklistId the primary key of the checklist entry
	 * @return the checklist entry, or <code>null</code> if a checklist entry with the primary key could not be found
	 */
	public static ChecklistEntry fetchByPrimaryKey(long checklistId) {
		return getPersistence().fetchByPrimaryKey(checklistId);
	}

	/**
	 * Returns all the checklist entries.
	 *
	 * @return the checklist entries
	 */
	public static List<ChecklistEntry> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ChecklistEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ChecklistEntry> findAll(
		int start, int end,
		OrderByComparator<ChecklistEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ChecklistEntry> findAll(
		int start, int end, OrderByComparator<ChecklistEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the checklist entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of checklist entries.
	 *
	 * @return the number of checklist entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChecklistEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ChecklistEntryPersistence _persistence;

}