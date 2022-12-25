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

package com.swork.core.work.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.core.work.service.model.WorkEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the work entry service. This utility wraps <code>com.swork.core.work.service.service.persistence.impl.WorkEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkEntryPersistence
 * @generated
 */
public class WorkEntryUtil {

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
	public static void clearCache(WorkEntry workEntry) {
		getPersistence().clearCache(workEntry);
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
	public static Map<Serializable, WorkEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkEntry update(WorkEntry workEntry) {
		return getPersistence().update(workEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkEntry update(
		WorkEntry workEntry, ServiceContext serviceContext) {

		return getPersistence().update(workEntry, serviceContext);
	}

	/**
	 * Returns all the work entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the work entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByUuid_First(
			String uuid, OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByUuid_First(
		String uuid, OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByUuid_Last(
			String uuid, OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByUuid_Last(
		String uuid, OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where uuid = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByUuid_PrevAndNext(
			long workId, String uuid,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			workId, uuid, orderByComparator);
	}

	/**
	 * Removes all the work entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of work entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the work entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the work entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the work entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the work entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work entry that was removed
	 */
	public static WorkEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of work entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByUuid_C_PrevAndNext(
			long workId, String uuid, long companyId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			workId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the work entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the work entries where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByProjectId(Long projectId) {
		return getPersistence().findByProjectId(projectId);
	}

	/**
	 * Returns a range of all the work entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByProjectId(
		Long projectId, int start, int end) {

		return getPersistence().findByProjectId(projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByProjectId(
		Long projectId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByProjectId(
		Long projectId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByProjectId_First(
			Long projectId, OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByProjectId_First(
		Long projectId, OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByProjectId_Last(
			Long projectId, OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByProjectId_Last(
		Long projectId, OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where projectId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByProjectId_PrevAndNext(
			long workId, Long projectId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectId_PrevAndNext(
			workId, projectId, orderByComparator);
	}

	/**
	 * Removes all the work entries where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public static void removeByProjectId(Long projectId) {
		getPersistence().removeByProjectId(projectId);
	}

	/**
	 * Returns the number of work entries where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching work entries
	 */
	public static int countByProjectId(Long projectId) {
		return getPersistence().countByProjectId(projectId);
	}

	/**
	 * Returns all the work entries where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByProjectId_ParentId(
		Long projectId, Long parentId) {

		return getPersistence().findByProjectId_ParentId(projectId, parentId);
	}

	/**
	 * Returns a range of all the work entries where projectId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByProjectId_ParentId(
		Long projectId, Long parentId, int start, int end) {

		return getPersistence().findByProjectId_ParentId(
			projectId, parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByProjectId_ParentId(
		Long projectId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByProjectId_ParentId(
			projectId, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByProjectId_ParentId(
		Long projectId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProjectId_ParentId(
			projectId, parentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByProjectId_ParentId_First(
			Long projectId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectId_ParentId_First(
			projectId, parentId, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByProjectId_ParentId_First(
		Long projectId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByProjectId_ParentId_First(
			projectId, parentId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByProjectId_ParentId_Last(
			Long projectId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectId_ParentId_Last(
			projectId, parentId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByProjectId_ParentId_Last(
		Long projectId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByProjectId_ParentId_Last(
			projectId, parentId, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where projectId = &#63; and parentId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByProjectId_ParentId_PrevAndNext(
			long workId, Long projectId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectId_ParentId_PrevAndNext(
			workId, projectId, parentId, orderByComparator);
	}

	/**
	 * Removes all the work entries where projectId = &#63; and parentId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 */
	public static void removeByProjectId_ParentId(
		Long projectId, Long parentId) {

		getPersistence().removeByProjectId_ParentId(projectId, parentId);
	}

	/**
	 * Returns the number of work entries where projectId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param parentId the parent ID
	 * @return the number of matching work entries
	 */
	public static int countByProjectId_ParentId(Long projectId, Long parentId) {
		return getPersistence().countByProjectId_ParentId(projectId, parentId);
	}

	/**
	 * Returns all the work entries where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByProjectAndPhase(
		Long projectId, Long phaseId) {

		return getPersistence().findByProjectAndPhase(projectId, phaseId);
	}

	/**
	 * Returns a range of all the work entries where projectId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByProjectAndPhase(
		Long projectId, Long phaseId, int start, int end) {

		return getPersistence().findByProjectAndPhase(
			projectId, phaseId, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByProjectAndPhase(
		Long projectId, Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByProjectAndPhase(
			projectId, phaseId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByProjectAndPhase(
		Long projectId, Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProjectAndPhase(
			projectId, phaseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByProjectAndPhase_First(
			Long projectId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectAndPhase_First(
			projectId, phaseId, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByProjectAndPhase_First(
		Long projectId, Long phaseId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByProjectAndPhase_First(
			projectId, phaseId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByProjectAndPhase_Last(
			Long projectId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectAndPhase_Last(
			projectId, phaseId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByProjectAndPhase_Last(
		Long projectId, Long phaseId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByProjectAndPhase_Last(
			projectId, phaseId, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByProjectAndPhase_PrevAndNext(
			long workId, Long projectId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectAndPhase_PrevAndNext(
			workId, projectId, phaseId, orderByComparator);
	}

	/**
	 * Removes all the work entries where projectId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 */
	public static void removeByProjectAndPhase(Long projectId, Long phaseId) {
		getPersistence().removeByProjectAndPhase(projectId, phaseId);
	}

	/**
	 * Returns the number of work entries where projectId = &#63; and phaseId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @return the number of matching work entries
	 */
	public static int countByProjectAndPhase(Long projectId, Long phaseId) {
		return getPersistence().countByProjectAndPhase(projectId, phaseId);
	}

	/**
	 * Returns all the work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId) {

		return getPersistence().findByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId);
	}

	/**
	 * Returns a range of all the work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId, int start, int end) {

		return getPersistence().findByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByProjectId_PhaseId_ParentId_First(
			Long projectId, Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectId_PhaseId_ParentId_First(
			projectId, phaseId, parentId, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByProjectId_PhaseId_ParentId_First(
		Long projectId, Long phaseId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByProjectId_PhaseId_ParentId_First(
			projectId, phaseId, parentId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByProjectId_PhaseId_ParentId_Last(
			Long projectId, Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectId_PhaseId_ParentId_Last(
			projectId, phaseId, parentId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByProjectId_PhaseId_ParentId_Last(
		Long projectId, Long phaseId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByProjectId_PhaseId_ParentId_Last(
			projectId, phaseId, parentId, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByProjectId_PhaseId_ParentId_PrevAndNext(
			long workId, Long projectId, Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectId_PhaseId_ParentId_PrevAndNext(
			workId, projectId, phaseId, parentId, orderByComparator);
	}

	/**
	 * Removes all the work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 */
	public static void removeByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId) {

		getPersistence().removeByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId);
	}

	/**
	 * Returns the number of work entries where projectId = &#63; and phaseId = &#63; and parentId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @return the number of matching work entries
	 */
	public static int countByProjectId_PhaseId_ParentId(
		Long projectId, Long phaseId, Long parentId) {

		return getPersistence().countByProjectId_PhaseId_ParentId(
			projectId, phaseId, parentId);
	}

	/**
	 * Returns all the work entries where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByPhaseId(Long phaseId) {
		return getPersistence().findByPhaseId(phaseId);
	}

	/**
	 * Returns a range of all the work entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByPhaseId(
		Long phaseId, int start, int end) {

		return getPersistence().findByPhaseId(phaseId, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByPhaseId(
		Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByPhaseId(
			phaseId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByPhaseId(
		Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPhaseId(
			phaseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByPhaseId_First(
			Long phaseId, OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByPhaseId_First(phaseId, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByPhaseId_First(
		Long phaseId, OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByPhaseId_First(
			phaseId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByPhaseId_Last(
			Long phaseId, OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByPhaseId_Last(phaseId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByPhaseId_Last(
		Long phaseId, OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByPhaseId_Last(phaseId, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where phaseId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByPhaseId_PrevAndNext(
			long workId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByPhaseId_PrevAndNext(
			workId, phaseId, orderByComparator);
	}

	/**
	 * Removes all the work entries where phaseId = &#63; from the database.
	 *
	 * @param phaseId the phase ID
	 */
	public static void removeByPhaseId(Long phaseId) {
		getPersistence().removeByPhaseId(phaseId);
	}

	/**
	 * Returns the number of work entries where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @return the number of matching work entries
	 */
	public static int countByPhaseId(Long phaseId) {
		return getPersistence().countByPhaseId(phaseId);
	}

	/**
	 * Returns all the work entries where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByPhaseId_ParentId(
		Long phaseId, Long parentId) {

		return getPersistence().findByPhaseId_ParentId(phaseId, parentId);
	}

	/**
	 * Returns a range of all the work entries where phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByPhaseId_ParentId(
		Long phaseId, Long parentId, int start, int end) {

		return getPersistence().findByPhaseId_ParentId(
			phaseId, parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByPhaseId_ParentId(
		Long phaseId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByPhaseId_ParentId(
			phaseId, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where phaseId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByPhaseId_ParentId(
		Long phaseId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPhaseId_ParentId(
			phaseId, parentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByPhaseId_ParentId_First(
			Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByPhaseId_ParentId_First(
			phaseId, parentId, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByPhaseId_ParentId_First(
		Long phaseId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByPhaseId_ParentId_First(
			phaseId, parentId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByPhaseId_ParentId_Last(
			Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByPhaseId_ParentId_Last(
			phaseId, parentId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByPhaseId_ParentId_Last(
		Long phaseId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByPhaseId_ParentId_Last(
			phaseId, parentId, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByPhaseId_ParentId_PrevAndNext(
			long workId, Long phaseId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByPhaseId_ParentId_PrevAndNext(
			workId, phaseId, parentId, orderByComparator);
	}

	/**
	 * Removes all the work entries where phaseId = &#63; and parentId = &#63; from the database.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 */
	public static void removeByPhaseId_ParentId(Long phaseId, Long parentId) {
		getPersistence().removeByPhaseId_ParentId(phaseId, parentId);
	}

	/**
	 * Returns the number of work entries where phaseId = &#63; and parentId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param parentId the parent ID
	 * @return the number of matching work entries
	 */
	public static int countByPhaseId_ParentId(Long phaseId, Long parentId) {
		return getPersistence().countByPhaseId_ParentId(phaseId, parentId);
	}

	/**
	 * Returns all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByParentId(
		long businessId, Long parentId) {

		return getPersistence().findByParentId(businessId, parentId);
	}

	/**
	 * Returns a range of all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByParentId(
		long businessId, Long parentId, int start, int end) {

		return getPersistence().findByParentId(
			businessId, parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByParentId(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByParentId(
			businessId, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByParentId(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentId(
			businessId, parentId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByParentId_First(
			long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByParentId_First(
			businessId, parentId, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByParentId_First(
		long businessId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByParentId_First(
			businessId, parentId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByParentId_Last(
			long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByParentId_Last(
			businessId, parentId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByParentId_Last(
		long businessId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByParentId_Last(
			businessId, parentId, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByParentId_PrevAndNext(
			long workId, long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByParentId_PrevAndNext(
			workId, businessId, parentId, orderByComparator);
	}

	/**
	 * Removes all the work entries where businessId = &#63; and parentId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 */
	public static void removeByParentId(long businessId, Long parentId) {
		getPersistence().removeByParentId(businessId, parentId);
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the number of matching work entries
	 */
	public static int countByParentId(long businessId, Long parentId) {
		return getPersistence().countByParentId(businessId, parentId);
	}

	/**
	 * Returns the work entry where businessId = &#63; and parentId = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByParentIdAndName(
			long businessId, Long parentId, String name)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByParentIdAndName(
			businessId, parentId, name);
	}

	/**
	 * Returns the work entry where businessId = &#63; and parentId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByParentIdAndName(
		long businessId, Long parentId, String name) {

		return getPersistence().fetchByParentIdAndName(
			businessId, parentId, name);
	}

	/**
	 * Returns the work entry where businessId = &#63; and parentId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByParentIdAndName(
		long businessId, Long parentId, String name, boolean useFinderCache) {

		return getPersistence().fetchByParentIdAndName(
			businessId, parentId, name, useFinderCache);
	}

	/**
	 * Removes the work entry where businessId = &#63; and parentId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @return the work entry that was removed
	 */
	public static WorkEntry removeByParentIdAndName(
			long businessId, Long parentId, String name)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().removeByParentIdAndName(
			businessId, parentId, name);
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and parentId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param name the name
	 * @return the number of matching work entries
	 */
	public static int countByParentIdAndName(
		long businessId, Long parentId, String name) {

		return getPersistence().countByParentIdAndName(
			businessId, parentId, name);
	}

	/**
	 * Returns all the work entries where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByParentCode(String parentReferenceCode) {
		return getPersistence().findByParentCode(parentReferenceCode);
	}

	/**
	 * Returns a range of all the work entries where parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByParentCode(
		String parentReferenceCode, int start, int end) {

		return getPersistence().findByParentCode(
			parentReferenceCode, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByParentCode(
		String parentReferenceCode, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByParentCode(
			parentReferenceCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByParentCode(
		String parentReferenceCode, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentCode(
			parentReferenceCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByParentCode_First(
			String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByParentCode_First(
			parentReferenceCode, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByParentCode_First(
		String parentReferenceCode,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByParentCode_First(
			parentReferenceCode, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByParentCode_Last(
			String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByParentCode_Last(
			parentReferenceCode, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByParentCode_Last(
		String parentReferenceCode,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByParentCode_Last(
			parentReferenceCode, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where parentReferenceCode = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByParentCode_PrevAndNext(
			long workId, String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByParentCode_PrevAndNext(
			workId, parentReferenceCode, orderByComparator);
	}

	/**
	 * Removes all the work entries where parentReferenceCode = &#63; from the database.
	 *
	 * @param parentReferenceCode the parent reference code
	 */
	public static void removeByParentCode(String parentReferenceCode) {
		getPersistence().removeByParentCode(parentReferenceCode);
	}

	/**
	 * Returns the number of work entries where parentReferenceCode = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @return the number of matching work entries
	 */
	public static int countByParentCode(String parentReferenceCode) {
		return getPersistence().countByParentCode(parentReferenceCode);
	}

	/**
	 * Returns the work entry where projectId = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param projectId the project ID
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByProjectAndName(Long projectId, String name)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByProjectAndName(projectId, name);
	}

	/**
	 * Returns the work entry where projectId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectId the project ID
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByProjectAndName(Long projectId, String name) {
		return getPersistence().fetchByProjectAndName(projectId, name);
	}

	/**
	 * Returns the work entry where projectId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectId the project ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByProjectAndName(
		Long projectId, String name, boolean useFinderCache) {

		return getPersistence().fetchByProjectAndName(
			projectId, name, useFinderCache);
	}

	/**
	 * Removes the work entry where projectId = &#63; and name = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param name the name
	 * @return the work entry that was removed
	 */
	public static WorkEntry removeByProjectAndName(Long projectId, String name)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().removeByProjectAndName(projectId, name);
	}

	/**
	 * Returns the number of work entries where projectId = &#63; and name = &#63;.
	 *
	 * @param projectId the project ID
	 * @param name the name
	 * @return the number of matching work entries
	 */
	public static int countByProjectAndName(Long projectId, String name) {
		return getPersistence().countByProjectAndName(projectId, name);
	}

	/**
	 * Returns the work entry where parentReferenceCode = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByParentCodeAndName(
			String parentReferenceCode, String name)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByParentCodeAndName(
			parentReferenceCode, name);
	}

	/**
	 * Returns the work entry where parentReferenceCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByParentCodeAndName(
		String parentReferenceCode, String name) {

		return getPersistence().fetchByParentCodeAndName(
			parentReferenceCode, name);
	}

	/**
	 * Returns the work entry where parentReferenceCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByParentCodeAndName(
		String parentReferenceCode, String name, boolean useFinderCache) {

		return getPersistence().fetchByParentCodeAndName(
			parentReferenceCode, name, useFinderCache);
	}

	/**
	 * Removes the work entry where parentReferenceCode = &#63; and name = &#63; from the database.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the work entry that was removed
	 */
	public static WorkEntry removeByParentCodeAndName(
			String parentReferenceCode, String name)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().removeByParentCodeAndName(
			parentReferenceCode, name);
	}

	/**
	 * Returns the number of work entries where parentReferenceCode = &#63; and name = &#63;.
	 *
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the number of matching work entries
	 */
	public static int countByParentCodeAndName(
		String parentReferenceCode, String name) {

		return getPersistence().countByParentCodeAndName(
			parentReferenceCode, name);
	}

	/**
	 * Returns the work entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the work entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the work entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the work entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the work entry that was removed
	 */
	public static WorkEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of work entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching work entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the work entry in the entity cache if it is enabled.
	 *
	 * @param workEntry the work entry
	 */
	public static void cacheResult(WorkEntry workEntry) {
		getPersistence().cacheResult(workEntry);
	}

	/**
	 * Caches the work entries in the entity cache if it is enabled.
	 *
	 * @param workEntries the work entries
	 */
	public static void cacheResult(List<WorkEntry> workEntries) {
		getPersistence().cacheResult(workEntries);
	}

	/**
	 * Creates a new work entry with the primary key. Does not add the work entry to the database.
	 *
	 * @param workId the primary key for the new work entry
	 * @return the new work entry
	 */
	public static WorkEntry create(long workId) {
		return getPersistence().create(workId);
	}

	/**
	 * Removes the work entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry that was removed
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry remove(long workId)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().remove(workId);
	}

	public static WorkEntry updateImpl(WorkEntry workEntry) {
		return getPersistence().updateImpl(workEntry);
	}

	/**
	 * Returns the work entry with the primary key or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry findByPrimaryKey(long workId)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByPrimaryKey(workId);
	}

	/**
	 * Returns the work entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry, or <code>null</code> if a work entry with the primary key could not be found
	 */
	public static WorkEntry fetchByPrimaryKey(long workId) {
		return getPersistence().fetchByPrimaryKey(workId);
	}

	/**
	 * Returns all the work entries.
	 *
	 * @return the work entries
	 */
	public static List<WorkEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the work entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of work entries
	 */
	public static List<WorkEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the work entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work entries
	 */
	public static List<WorkEntry> findAll(
		int start, int end, OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work entries
	 */
	public static List<WorkEntry> findAll(
		int start, int end, OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the work entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work entries.
	 *
	 * @return the number of work entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile WorkEntryPersistence _persistence;

}