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

import com.swork.core.resource.service.model.TeamMemberEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the team member entry service. This utility wraps <code>com.swork.core.resource.service.service.persistence.impl.TeamMemberEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamMemberEntryPersistence
 * @generated
 */
public class TeamMemberEntryUtil {

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
	public static void clearCache(TeamMemberEntry teamMemberEntry) {
		getPersistence().clearCache(teamMemberEntry);
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
	public static Map<Serializable, TeamMemberEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TeamMemberEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TeamMemberEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TeamMemberEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TeamMemberEntry update(TeamMemberEntry teamMemberEntry) {
		return getPersistence().update(teamMemberEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TeamMemberEntry update(
		TeamMemberEntry teamMemberEntry, ServiceContext serviceContext) {

		return getPersistence().update(teamMemberEntry, serviceContext);
	}

	/**
	 * Returns all the team member entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching team member entries
	 */
	public static List<TeamMemberEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the team member entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @return the range of matching team member entries
	 */
	public static List<TeamMemberEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the team member entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team member entries
	 */
	public static List<TeamMemberEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team member entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team member entries
	 */
	public static List<TeamMemberEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public static TeamMemberEntry findByUuid_First(
			String uuid, OrderByComparator<TeamMemberEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public static TeamMemberEntry fetchByUuid_First(
		String uuid, OrderByComparator<TeamMemberEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public static TeamMemberEntry findByUuid_Last(
			String uuid, OrderByComparator<TeamMemberEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public static TeamMemberEntry fetchByUuid_Last(
		String uuid, OrderByComparator<TeamMemberEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the team member entries before and after the current team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param teamMemberId the primary key of the current team member entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	public static TeamMemberEntry[] findByUuid_PrevAndNext(
			long teamMemberId, String uuid,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			teamMemberId, uuid, orderByComparator);
	}

	/**
	 * Removes all the team member entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of team member entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching team member entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching team member entries
	 */
	public static List<TeamMemberEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @return the range of matching team member entries
	 */
	public static List<TeamMemberEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team member entries
	 */
	public static List<TeamMemberEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team member entries
	 */
	public static List<TeamMemberEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public static TeamMemberEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public static TeamMemberEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public static TeamMemberEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public static TeamMemberEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the team member entries before and after the current team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param teamMemberId the primary key of the current team member entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	public static TeamMemberEntry[] findByUuid_C_PrevAndNext(
			long teamMemberId, String uuid, long companyId,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			teamMemberId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the team member entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching team member entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @return the matching team member entries
	 */
	public static List<TeamMemberEntry> findByTeam(
		long teamId, Boolean isAdmin) {

		return getPersistence().findByTeam(teamId, isAdmin);
	}

	/**
	 * Returns a range of all the team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @return the range of matching team member entries
	 */
	public static List<TeamMemberEntry> findByTeam(
		long teamId, Boolean isAdmin, int start, int end) {

		return getPersistence().findByTeam(teamId, isAdmin, start, end);
	}

	/**
	 * Returns an ordered range of all the team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team member entries
	 */
	public static List<TeamMemberEntry> findByTeam(
		long teamId, Boolean isAdmin, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return getPersistence().findByTeam(
			teamId, isAdmin, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team member entries
	 */
	public static List<TeamMemberEntry> findByTeam(
		long teamId, Boolean isAdmin, int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTeam(
			teamId, isAdmin, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public static TeamMemberEntry findByTeam_First(
			long teamId, Boolean isAdmin,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().findByTeam_First(
			teamId, isAdmin, orderByComparator);
	}

	/**
	 * Returns the first team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public static TeamMemberEntry fetchByTeam_First(
		long teamId, Boolean isAdmin,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return getPersistence().fetchByTeam_First(
			teamId, isAdmin, orderByComparator);
	}

	/**
	 * Returns the last team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public static TeamMemberEntry findByTeam_Last(
			long teamId, Boolean isAdmin,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().findByTeam_Last(
			teamId, isAdmin, orderByComparator);
	}

	/**
	 * Returns the last team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public static TeamMemberEntry fetchByTeam_Last(
		long teamId, Boolean isAdmin,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return getPersistence().fetchByTeam_Last(
			teamId, isAdmin, orderByComparator);
	}

	/**
	 * Returns the team member entries before and after the current team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamMemberId the primary key of the current team member entry
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	public static TeamMemberEntry[] findByTeam_PrevAndNext(
			long teamMemberId, long teamId, Boolean isAdmin,
			OrderByComparator<TeamMemberEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().findByTeam_PrevAndNext(
			teamMemberId, teamId, isAdmin, orderByComparator);
	}

	/**
	 * Removes all the team member entries where teamId = &#63; and isAdmin = &#63; from the database.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 */
	public static void removeByTeam(long teamId, Boolean isAdmin) {
		getPersistence().removeByTeam(teamId, isAdmin);
	}

	/**
	 * Returns the number of team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @return the number of matching team member entries
	 */
	public static int countByTeam(long teamId, Boolean isAdmin) {
		return getPersistence().countByTeam(teamId, isAdmin);
	}

	/**
	 * Returns the team member entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchTeamMemberEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public static TeamMemberEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the team member entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public static TeamMemberEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the team member entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public static TeamMemberEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the team member entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the team member entry that was removed
	 */
	public static TeamMemberEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of team member entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching team member entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the team member entry in the entity cache if it is enabled.
	 *
	 * @param teamMemberEntry the team member entry
	 */
	public static void cacheResult(TeamMemberEntry teamMemberEntry) {
		getPersistence().cacheResult(teamMemberEntry);
	}

	/**
	 * Caches the team member entries in the entity cache if it is enabled.
	 *
	 * @param teamMemberEntries the team member entries
	 */
	public static void cacheResult(List<TeamMemberEntry> teamMemberEntries) {
		getPersistence().cacheResult(teamMemberEntries);
	}

	/**
	 * Creates a new team member entry with the primary key. Does not add the team member entry to the database.
	 *
	 * @param teamMemberId the primary key for the new team member entry
	 * @return the new team member entry
	 */
	public static TeamMemberEntry create(long teamMemberId) {
		return getPersistence().create(teamMemberId);
	}

	/**
	 * Removes the team member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamMemberId the primary key of the team member entry
	 * @return the team member entry that was removed
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	public static TeamMemberEntry remove(long teamMemberId)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().remove(teamMemberId);
	}

	public static TeamMemberEntry updateImpl(TeamMemberEntry teamMemberEntry) {
		return getPersistence().updateImpl(teamMemberEntry);
	}

	/**
	 * Returns the team member entry with the primary key or throws a <code>NoSuchTeamMemberEntryException</code> if it could not be found.
	 *
	 * @param teamMemberId the primary key of the team member entry
	 * @return the team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	public static TeamMemberEntry findByPrimaryKey(long teamMemberId)
		throws com.swork.core.resource.service.exception.
			NoSuchTeamMemberEntryException {

		return getPersistence().findByPrimaryKey(teamMemberId);
	}

	/**
	 * Returns the team member entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamMemberId the primary key of the team member entry
	 * @return the team member entry, or <code>null</code> if a team member entry with the primary key could not be found
	 */
	public static TeamMemberEntry fetchByPrimaryKey(long teamMemberId) {
		return getPersistence().fetchByPrimaryKey(teamMemberId);
	}

	/**
	 * Returns all the team member entries.
	 *
	 * @return the team member entries
	 */
	public static List<TeamMemberEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the team member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @return the range of team member entries
	 */
	public static List<TeamMemberEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the team member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of team member entries
	 */
	public static List<TeamMemberEntry> findAll(
		int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the team member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team member entries
	 * @param end the upper bound of the range of team member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of team member entries
	 */
	public static List<TeamMemberEntry> findAll(
		int start, int end,
		OrderByComparator<TeamMemberEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the team member entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of team member entries.
	 *
	 * @return the number of team member entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TeamMemberEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TeamMemberEntryPersistence _persistence;

}