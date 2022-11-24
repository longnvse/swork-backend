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

package com.swork.core.resource.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.core.resource.service.model.TeamEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the team entry service. This utility wraps <code>com.swork.core.resource.service.service.persistence.impl.TeamEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamEntryPersistence
 * @generated
 */
public class TeamEntryUtil {

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
	public static void clearCache(TeamEntry teamEntry) {
		getPersistence().clearCache(teamEntry);
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
	public static Map<Serializable, TeamEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TeamEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TeamEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TeamEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TeamEntry update(TeamEntry teamEntry) {
		return getPersistence().update(teamEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TeamEntry update(
		TeamEntry teamEntry, ServiceContext serviceContext) {

		return getPersistence().update(teamEntry, serviceContext);
	}

	/**
	 * Returns all the team entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching team entries
	 */
	public static List<TeamEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the team entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of matching team entries
	 */
	public static List<TeamEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the team entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team entries
	 */
	public static List<TeamEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team entries
	 */
	public static List<TeamEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByUuid_First(
			String uuid, OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByUuid_First(
		String uuid, OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByUuid_Last(
			String uuid, OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByUuid_Last(
		String uuid, OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the team entries before and after the current team entry in the ordered set where uuid = &#63;.
	 *
	 * @param teamId the primary key of the current team entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	public static TeamEntry[] findByUuid_PrevAndNext(
			long teamId, String uuid,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			teamId, uuid, orderByComparator);
	}

	/**
	 * Removes all the team entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of team entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching team entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the team entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the team entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the team entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the team entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the team entry that was removed
	 */
	public static TeamEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of team entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching team entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching team entries
	 */
	public static List<TeamEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of matching team entries
	 */
	public static List<TeamEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team entries
	 */
	public static List<TeamEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team entries
	 */
	public static List<TeamEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the team entries before and after the current team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param teamId the primary key of the current team entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	public static TeamEntry[] findByUuid_C_PrevAndNext(
			long teamId, String uuid, long companyId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			teamId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the team entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching team entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the team entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching team entries
	 */
	public static List<TeamEntry> findByB_C(long businessId, String name) {
		return getPersistence().findByB_C(businessId, name);
	}

	/**
	 * Returns a range of all the team entries where businessId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of matching team entries
	 */
	public static List<TeamEntry> findByB_C(
		long businessId, String name, int start, int end) {

		return getPersistence().findByB_C(businessId, name, start, end);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team entries
	 */
	public static List<TeamEntry> findByB_C(
		long businessId, String name, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().findByB_C(
			businessId, name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team entries
	 */
	public static List<TeamEntry> findByB_C(
		long businessId, String name, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_C(
			businessId, name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByB_C_First(
			long businessId, String name,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByB_C_First(
			businessId, name, orderByComparator);
	}

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByB_C_First(
		long businessId, String name,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().fetchByB_C_First(
			businessId, name, orderByComparator);
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByB_C_Last(
			long businessId, String name,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByB_C_Last(
			businessId, name, orderByComparator);
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByB_C_Last(
		long businessId, String name,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().fetchByB_C_Last(
			businessId, name, orderByComparator);
	}

	/**
	 * Returns the team entries before and after the current team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param teamId the primary key of the current team entry
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	public static TeamEntry[] findByB_C_PrevAndNext(
			long teamId, long businessId, String name,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByB_C_PrevAndNext(
			teamId, businessId, name, orderByComparator);
	}

	/**
	 * Removes all the team entries where businessId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 */
	public static void removeByB_C(long businessId, String name) {
		getPersistence().removeByB_C(businessId, name);
	}

	/**
	 * Returns the number of team entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the number of matching team entries
	 */
	public static int countByB_C(long businessId, String name) {
		return getPersistence().countByB_C(businessId, name);
	}

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and projectId = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByB_N_P(
			long businessId, String name, Long projectId)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByB_N_P(businessId, name, projectId);
	}

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByB_N_P(
		long businessId, String name, Long projectId) {

		return getPersistence().fetchByB_N_P(businessId, name, projectId);
	}

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByB_N_P(
		long businessId, String name, Long projectId, boolean useFinderCache) {

		return getPersistence().fetchByB_N_P(
			businessId, name, projectId, useFinderCache);
	}

	/**
	 * Removes the team entry where businessId = &#63; and name = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the team entry that was removed
	 */
	public static TeamEntry removeByB_N_P(
			long businessId, String name, Long projectId)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().removeByB_N_P(businessId, name, projectId);
	}

	/**
	 * Returns the number of team entries where businessId = &#63; and name = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the number of matching team entries
	 */
	public static int countByB_N_P(
		long businessId, String name, Long projectId) {

		return getPersistence().countByB_N_P(businessId, name, projectId);
	}

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByB_N_PH(
			long businessId, String name, Long phaseId)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByB_N_PH(businessId, name, phaseId);
	}

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByB_N_PH(
		long businessId, String name, Long phaseId) {

		return getPersistence().fetchByB_N_PH(businessId, name, phaseId);
	}

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByB_N_PH(
		long businessId, String name, Long phaseId, boolean useFinderCache) {

		return getPersistence().fetchByB_N_PH(
			businessId, name, phaseId, useFinderCache);
	}

	/**
	 * Removes the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the team entry that was removed
	 */
	public static TeamEntry removeByB_N_PH(
			long businessId, String name, Long phaseId)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().removeByB_N_PH(businessId, name, phaseId);
	}

	/**
	 * Returns the number of team entries where businessId = &#63; and name = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the number of matching team entries
	 */
	public static int countByB_N_PH(
		long businessId, String name, Long phaseId) {

		return getPersistence().countByB_N_PH(businessId, name, phaseId);
	}

	/**
	 * Returns all the team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the matching team entries
	 */
	public static List<TeamEntry> findByB_PH(long businessId, Long phaseId) {
		return getPersistence().findByB_PH(businessId, phaseId);
	}

	/**
	 * Returns a range of all the team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of matching team entries
	 */
	public static List<TeamEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end) {

		return getPersistence().findByB_PH(businessId, phaseId, start, end);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team entries
	 */
	public static List<TeamEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().findByB_PH(
			businessId, phaseId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team entries
	 */
	public static List<TeamEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_PH(
			businessId, phaseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByB_PH_First(
			long businessId, Long phaseId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByB_PH_First(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByB_PH_First(
		long businessId, Long phaseId,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().fetchByB_PH_First(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByB_PH_Last(
			long businessId, Long phaseId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByB_PH_Last(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByB_PH_Last(
		long businessId, Long phaseId,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().fetchByB_PH_Last(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the team entries before and after the current team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param teamId the primary key of the current team entry
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	public static TeamEntry[] findByB_PH_PrevAndNext(
			long teamId, long businessId, Long phaseId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByB_PH_PrevAndNext(
			teamId, businessId, phaseId, orderByComparator);
	}

	/**
	 * Removes all the team entries where businessId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 */
	public static void removeByB_PH(long businessId, Long phaseId) {
		getPersistence().removeByB_PH(businessId, phaseId);
	}

	/**
	 * Returns the number of team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the number of matching team entries
	 */
	public static int countByB_PH(long businessId, Long phaseId) {
		return getPersistence().countByB_PH(businessId, phaseId);
	}

	/**
	 * Returns all the team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching team entries
	 */
	public static List<TeamEntry> findByB_P(long businessId, Long projectId) {
		return getPersistence().findByB_P(businessId, projectId);
	}

	/**
	 * Returns a range of all the team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of matching team entries
	 */
	public static List<TeamEntry> findByB_P(
		long businessId, Long projectId, int start, int end) {

		return getPersistence().findByB_P(businessId, projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team entries
	 */
	public static List<TeamEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().findByB_P(
			businessId, projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team entries
	 */
	public static List<TeamEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<TeamEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_P(
			businessId, projectId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByB_P_First(
			long businessId, Long projectId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByB_P_First(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByB_P_First(
		long businessId, Long projectId,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().fetchByB_P_First(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByB_P_Last(
			long businessId, Long projectId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByB_P_Last(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByB_P_Last(
		long businessId, Long projectId,
		OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().fetchByB_P_Last(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the team entries before and after the current team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param teamId the primary key of the current team entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	public static TeamEntry[] findByB_P_PrevAndNext(
			long teamId, long businessId, Long projectId,
			OrderByComparator<TeamEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByB_P_PrevAndNext(
			teamId, businessId, projectId, orderByComparator);
	}

	/**
	 * Removes all the team entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	public static void removeByB_P(long businessId, Long projectId) {
		getPersistence().removeByB_P(businessId, projectId);
	}

	/**
	 * Returns the number of team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching team entries
	 */
	public static int countByB_P(long businessId, Long projectId) {
		return getPersistence().countByB_P(businessId, projectId);
	}

	/**
	 * Returns the team entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public static TeamEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the team entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the team entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public static TeamEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the team entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the team entry that was removed
	 */
	public static TeamEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of team entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching team entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the team entry in the entity cache if it is enabled.
	 *
	 * @param teamEntry the team entry
	 */
	public static void cacheResult(TeamEntry teamEntry) {
		getPersistence().cacheResult(teamEntry);
	}

	/**
	 * Caches the team entries in the entity cache if it is enabled.
	 *
	 * @param teamEntries the team entries
	 */
	public static void cacheResult(List<TeamEntry> teamEntries) {
		getPersistence().cacheResult(teamEntries);
	}

	/**
	 * Creates a new team entry with the primary key. Does not add the team entry to the database.
	 *
	 * @param teamId the primary key for the new team entry
	 * @return the new team entry
	 */
	public static TeamEntry create(long teamId) {
		return getPersistence().create(teamId);
	}

	/**
	 * Removes the team entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry that was removed
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	public static TeamEntry remove(long teamId)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().remove(teamId);
	}

	public static TeamEntry updateImpl(TeamEntry teamEntry) {
		return getPersistence().updateImpl(teamEntry);
	}

	/**
	 * Returns the team entry with the primary key or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	public static TeamEntry findByPrimaryKey(long teamId)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamEntryException {

		return getPersistence().findByPrimaryKey(teamId);
	}

	/**
	 * Returns the team entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry, or <code>null</code> if a team entry with the primary key could not be found
	 */
	public static TeamEntry fetchByPrimaryKey(long teamId) {
		return getPersistence().fetchByPrimaryKey(teamId);
	}

	/**
	 * Returns all the team entries.
	 *
	 * @return the team entries
	 */
	public static List<TeamEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the team entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @return the range of team entries
	 */
	public static List<TeamEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the team entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of team entries
	 */
	public static List<TeamEntry> findAll(
		int start, int end, OrderByComparator<TeamEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team entries
	 * @param end the upper bound of the range of team entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of team entries
	 */
	public static List<TeamEntry> findAll(
		int start, int end, OrderByComparator<TeamEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the team entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of team entries.
	 *
	 * @return the number of team entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TeamEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TeamEntryPersistence _persistence;

}