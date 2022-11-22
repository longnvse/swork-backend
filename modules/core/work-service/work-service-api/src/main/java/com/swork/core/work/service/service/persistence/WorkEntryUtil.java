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
	 * Returns all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByB_P(long businessId, Long projectId) {
		return getPersistence().findByB_P(businessId, projectId);
	}

	/**
	 * Returns a range of all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByB_P(
		long businessId, Long projectId, int start, int end) {

		return getPersistence().findByB_P(businessId, projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByB_P(
			businessId, projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_P(
			businessId, projectId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByB_P_First(
			long businessId, Long projectId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_P_First(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByB_P_First(
		long businessId, Long projectId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByB_P_First(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByB_P_Last(
			long businessId, Long projectId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_P_Last(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByB_P_Last(
		long businessId, Long projectId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByB_P_Last(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByB_P_PrevAndNext(
			long workId, long businessId, Long projectId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_P_PrevAndNext(
			workId, businessId, projectId, orderByComparator);
	}

	/**
	 * Removes all the work entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	public static void removeByB_P(long businessId, Long projectId) {
		getPersistence().removeByB_P(businessId, projectId);
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching work entries
	 */
	public static int countByB_P(long businessId, Long projectId) {
		return getPersistence().countByB_P(businessId, projectId);
	}

	/**
	 * Returns all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByB_PH(long businessId, Long phaseId) {
		return getPersistence().findByB_PH(businessId, phaseId);
	}

	/**
	 * Returns a range of all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end) {

		return getPersistence().findByB_PH(businessId, phaseId, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByB_PH(
			businessId, phaseId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_PH(
			businessId, phaseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByB_PH_First(
			long businessId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_PH_First(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByB_PH_First(
		long businessId, Long phaseId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByB_PH_First(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByB_PH_Last(
			long businessId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_PH_Last(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByB_PH_Last(
		long businessId, Long phaseId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByB_PH_Last(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByB_PH_PrevAndNext(
			long workId, long businessId, Long phaseId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_PH_PrevAndNext(
			workId, businessId, phaseId, orderByComparator);
	}

	/**
	 * Removes all the work entries where businessId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 */
	public static void removeByB_PH(long businessId, Long phaseId) {
		getPersistence().removeByB_PH(businessId, phaseId);
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the number of matching work entries
	 */
	public static int countByB_PH(long businessId, Long phaseId) {
		return getPersistence().countByB_PH(businessId, phaseId);
	}

	/**
	 * Returns all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByB_PID(long businessId, Long parentId) {
		return getPersistence().findByB_PID(businessId, parentId);
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
	public static List<WorkEntry> findByB_PID(
		long businessId, Long parentId, int start, int end) {

		return getPersistence().findByB_PID(businessId, parentId, start, end);
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
	public static List<WorkEntry> findByB_PID(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByB_PID(
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
	public static List<WorkEntry> findByB_PID(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_PID(
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
	public static WorkEntry findByB_PID_First(
			long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_PID_First(
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
	public static WorkEntry fetchByB_PID_First(
		long businessId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByB_PID_First(
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
	public static WorkEntry findByB_PID_Last(
			long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_PID_Last(
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
	public static WorkEntry fetchByB_PID_Last(
		long businessId, Long parentId,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByB_PID_Last(
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
	public static WorkEntry[] findByB_PID_PrevAndNext(
			long workId, long businessId, Long parentId,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_PID_PrevAndNext(
			workId, businessId, parentId, orderByComparator);
	}

	/**
	 * Removes all the work entries where businessId = &#63; and parentId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 */
	public static void removeByB_PID(long businessId, Long parentId) {
		getPersistence().removeByB_PID(businessId, parentId);
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the number of matching work entries
	 */
	public static int countByB_PID(long businessId, Long parentId) {
		return getPersistence().countByB_PID(businessId, parentId);
	}

	/**
	 * Returns all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @return the matching work entries
	 */
	public static List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode) {

		return getPersistence().findByB_P_C(businessId, parentReferenceCode);
	}

	/**
	 * Returns a range of all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public static List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode, int start, int end) {

		return getPersistence().findByB_P_C(
			businessId, parentReferenceCode, start, end);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().findByB_P_C(
			businessId, parentReferenceCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public static List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_P_C(
			businessId, parentReferenceCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByB_P_C_First(
			long businessId, String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_P_C_First(
			businessId, parentReferenceCode, orderByComparator);
	}

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByB_P_C_First(
		long businessId, String parentReferenceCode,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByB_P_C_First(
			businessId, parentReferenceCode, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByB_P_C_Last(
			long businessId, String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_P_C_Last(
			businessId, parentReferenceCode, orderByComparator);
	}

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByB_P_C_Last(
		long businessId, String parentReferenceCode,
		OrderByComparator<WorkEntry> orderByComparator) {

		return getPersistence().fetchByB_P_C_Last(
			businessId, parentReferenceCode, orderByComparator);
	}

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public static WorkEntry[] findByB_P_C_PrevAndNext(
			long workId, long businessId, String parentReferenceCode,
			OrderByComparator<WorkEntry> orderByComparator)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_P_C_PrevAndNext(
			workId, businessId, parentReferenceCode, orderByComparator);
	}

	/**
	 * Removes all the work entries where businessId = &#63; and parentReferenceCode = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 */
	public static void removeByB_P_C(
		long businessId, String parentReferenceCode) {

		getPersistence().removeByB_P_C(businessId, parentReferenceCode);
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @return the number of matching work entries
	 */
	public static int countByB_P_C(
		long businessId, String parentReferenceCode) {

		return getPersistence().countByB_P_C(businessId, parentReferenceCode);
	}

	/**
	 * Returns the work entry where businessId = &#63; and projectId = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByB_P_N(
			long businessId, Long projectId, String name)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_P_N(businessId, projectId, name);
	}

	/**
	 * Returns the work entry where businessId = &#63; and projectId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByB_P_N(
		long businessId, Long projectId, String name) {

		return getPersistence().fetchByB_P_N(businessId, projectId, name);
	}

	/**
	 * Returns the work entry where businessId = &#63; and projectId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByB_P_N(
		long businessId, Long projectId, String name, boolean useFinderCache) {

		return getPersistence().fetchByB_P_N(
			businessId, projectId, name, useFinderCache);
	}

	/**
	 * Removes the work entry where businessId = &#63; and projectId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the work entry that was removed
	 */
	public static WorkEntry removeByB_P_N(
			long businessId, Long projectId, String name)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().removeByB_P_N(businessId, projectId, name);
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and projectId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the number of matching work entries
	 */
	public static int countByB_P_N(
		long businessId, Long projectId, String name) {

		return getPersistence().countByB_P_N(businessId, projectId, name);
	}

	/**
	 * Returns the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public static WorkEntry findByB_P_C_N(
			long businessId, String parentReferenceCode, String name)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().findByB_P_C_N(
			businessId, parentReferenceCode, name);
	}

	/**
	 * Returns the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByB_P_C_N(
		long businessId, String parentReferenceCode, String name) {

		return getPersistence().fetchByB_P_C_N(
			businessId, parentReferenceCode, name);
	}

	/**
	 * Returns the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public static WorkEntry fetchByB_P_C_N(
		long businessId, String parentReferenceCode, String name,
		boolean useFinderCache) {

		return getPersistence().fetchByB_P_C_N(
			businessId, parentReferenceCode, name, useFinderCache);
	}

	/**
	 * Removes the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the work entry that was removed
	 */
	public static WorkEntry removeByB_P_C_N(
			long businessId, String parentReferenceCode, String name)
		throws com.swork.core.work.service.exception.NoSuchWorkEntryException {

		return getPersistence().removeByB_P_C_N(
			businessId, parentReferenceCode, name);
	}

	/**
	 * Returns the number of work entries where businessId = &#63; and parentReferenceCode = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the number of matching work entries
	 */
	public static int countByB_P_C_N(
		long businessId, String parentReferenceCode, String name) {

		return getPersistence().countByB_P_C_N(
			businessId, parentReferenceCode, name);
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