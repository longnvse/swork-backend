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

package com.swork.core.phase.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.core.phase.service.model.PhaseEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the phase entry service. This utility wraps <code>com.swork.core.phase.service.service.persistence.impl.PhaseEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhaseEntryPersistence
 * @generated
 */
public class PhaseEntryUtil {

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
	public static void clearCache(PhaseEntry phaseEntry) {
		getPersistence().clearCache(phaseEntry);
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
	public static Map<Serializable, PhaseEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PhaseEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhaseEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhaseEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PhaseEntry update(PhaseEntry phaseEntry) {
		return getPersistence().update(phaseEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PhaseEntry update(
		PhaseEntry phaseEntry, ServiceContext serviceContext) {

		return getPersistence().update(phaseEntry, serviceContext);
	}

	/**
	 * Returns all the phase entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching phase entries
	 */
	public static List<PhaseEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the phase entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of matching phase entries
	 */
	public static List<PhaseEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phase entries
	 */
	public static List<PhaseEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phase entries
	 */
	public static List<PhaseEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public static PhaseEntry findByUuid_First(
			String uuid, OrderByComparator<PhaseEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByUuid_First(
		String uuid, OrderByComparator<PhaseEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public static PhaseEntry findByUuid_Last(
			String uuid, OrderByComparator<PhaseEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByUuid_Last(
		String uuid, OrderByComparator<PhaseEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the phase entries before and after the current phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param phaseId the primary key of the current phase entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	public static PhaseEntry[] findByUuid_PrevAndNext(
			long phaseId, String uuid,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			phaseId, uuid, orderByComparator);
	}

	/**
	 * Removes all the phase entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of phase entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching phase entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the phase entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public static PhaseEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the phase entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the phase entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the phase entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the phase entry that was removed
	 */
	public static PhaseEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of phase entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching phase entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching phase entries
	 */
	public static List<PhaseEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of matching phase entries
	 */
	public static List<PhaseEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phase entries
	 */
	public static List<PhaseEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phase entries
	 */
	public static List<PhaseEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public static PhaseEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public static PhaseEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the phase entries before and after the current phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param phaseId the primary key of the current phase entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	public static PhaseEntry[] findByUuid_C_PrevAndNext(
			long phaseId, String uuid, long companyId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			phaseId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the phase entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching phase entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching phase entries
	 */
	public static List<PhaseEntry> findByP_(long businessId, long projectId) {
		return getPersistence().findByP_(businessId, projectId);
	}

	/**
	 * Returns a range of all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of matching phase entries
	 */
	public static List<PhaseEntry> findByP_(
		long businessId, long projectId, int start, int end) {

		return getPersistence().findByP_(businessId, projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phase entries
	 */
	public static List<PhaseEntry> findByP_(
		long businessId, long projectId, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return getPersistence().findByP_(
			businessId, projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phase entries
	 */
	public static List<PhaseEntry> findByP_(
		long businessId, long projectId, int start, int end,
		OrderByComparator<PhaseEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_(
			businessId, projectId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public static PhaseEntry findByP__First(
			long businessId, long projectId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByP__First(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the first phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByP__First(
		long businessId, long projectId,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return getPersistence().fetchByP__First(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the last phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public static PhaseEntry findByP__Last(
			long businessId, long projectId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByP__Last(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the last phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByP__Last(
		long businessId, long projectId,
		OrderByComparator<PhaseEntry> orderByComparator) {

		return getPersistence().fetchByP__Last(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the phase entries before and after the current phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param phaseId the primary key of the current phase entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	public static PhaseEntry[] findByP__PrevAndNext(
			long phaseId, long businessId, long projectId,
			OrderByComparator<PhaseEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByP__PrevAndNext(
			phaseId, businessId, projectId, orderByComparator);
	}

	/**
	 * Removes all the phase entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	public static void removeByP_(long businessId, long projectId) {
		getPersistence().removeByP_(businessId, projectId);
	}

	/**
	 * Returns the number of phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching phase entries
	 */
	public static int countByP_(long businessId, long projectId) {
		return getPersistence().countByP_(businessId, projectId);
	}

	/**
	 * Returns the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public static PhaseEntry findByB_P_N(
			long businessId, long projectId, String phaseName)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByB_P_N(businessId, projectId, phaseName);
	}

	/**
	 * Returns the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByB_P_N(
		long businessId, long projectId, String phaseName) {

		return getPersistence().fetchByB_P_N(businessId, projectId, phaseName);
	}

	/**
	 * Returns the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByB_P_N(
		long businessId, long projectId, String phaseName,
		boolean useFinderCache) {

		return getPersistence().fetchByB_P_N(
			businessId, projectId, phaseName, useFinderCache);
	}

	/**
	 * Removes the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the phase entry that was removed
	 */
	public static PhaseEntry removeByB_P_N(
			long businessId, long projectId, String phaseName)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().removeByB_P_N(businessId, projectId, phaseName);
	}

	/**
	 * Returns the number of phase entries where businessId = &#63; and projectId = &#63; and phaseName = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the number of matching phase entries
	 */
	public static int countByB_P_N(
		long businessId, long projectId, String phaseName) {

		return getPersistence().countByB_P_N(businessId, projectId, phaseName);
	}

	/**
	 * Returns the phase entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public static PhaseEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the phase entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the phase entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public static PhaseEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the phase entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the phase entry that was removed
	 */
	public static PhaseEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of phase entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching phase entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the phase entry in the entity cache if it is enabled.
	 *
	 * @param phaseEntry the phase entry
	 */
	public static void cacheResult(PhaseEntry phaseEntry) {
		getPersistence().cacheResult(phaseEntry);
	}

	/**
	 * Caches the phase entries in the entity cache if it is enabled.
	 *
	 * @param phaseEntries the phase entries
	 */
	public static void cacheResult(List<PhaseEntry> phaseEntries) {
		getPersistence().cacheResult(phaseEntries);
	}

	/**
	 * Creates a new phase entry with the primary key. Does not add the phase entry to the database.
	 *
	 * @param phaseId the primary key for the new phase entry
	 * @return the new phase entry
	 */
	public static PhaseEntry create(long phaseId) {
		return getPersistence().create(phaseId);
	}

	/**
	 * Removes the phase entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry that was removed
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	public static PhaseEntry remove(long phaseId)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().remove(phaseId);
	}

	public static PhaseEntry updateImpl(PhaseEntry phaseEntry) {
		return getPersistence().updateImpl(phaseEntry);
	}

	/**
	 * Returns the phase entry with the primary key or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	public static PhaseEntry findByPrimaryKey(long phaseId)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseEntryException {

		return getPersistence().findByPrimaryKey(phaseId);
	}

	/**
	 * Returns the phase entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry, or <code>null</code> if a phase entry with the primary key could not be found
	 */
	public static PhaseEntry fetchByPrimaryKey(long phaseId) {
		return getPersistence().fetchByPrimaryKey(phaseId);
	}

	/**
	 * Returns all the phase entries.
	 *
	 * @return the phase entries
	 */
	public static List<PhaseEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the phase entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of phase entries
	 */
	public static List<PhaseEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the phase entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phase entries
	 */
	public static List<PhaseEntry> findAll(
		int start, int end, OrderByComparator<PhaseEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phase entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phase entries
	 */
	public static List<PhaseEntry> findAll(
		int start, int end, OrderByComparator<PhaseEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the phase entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of phase entries.
	 *
	 * @return the number of phase entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhaseEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PhaseEntryPersistence _persistence;

}