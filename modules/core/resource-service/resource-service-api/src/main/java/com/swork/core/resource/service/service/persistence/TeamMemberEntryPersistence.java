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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.core.resource.service.exception.NoSuchTeamMemberEntryException;
import com.swork.core.resource.service.model.TeamMemberEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the team member entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamMemberEntryUtil
 * @generated
 */
@ProviderType
public interface TeamMemberEntryPersistence
	extends BasePersistence<TeamMemberEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TeamMemberEntryUtil} to access the team member entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the team member entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching team member entries
	 */
	public java.util.List<TeamMemberEntry> findByUuid(String uuid);

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
	public java.util.List<TeamMemberEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<TeamMemberEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator);

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
	public java.util.List<TeamMemberEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public TeamMemberEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
				orderByComparator)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Returns the first team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public TeamMemberEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator);

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public TeamMemberEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
				orderByComparator)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public TeamMemberEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator);

	/**
	 * Returns the team member entries before and after the current team member entry in the ordered set where uuid = &#63;.
	 *
	 * @param teamMemberTaskId the primary key of the current team member entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	public TeamMemberEntry[] findByUuid_PrevAndNext(
			long teamMemberTaskId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
				orderByComparator)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Removes all the team member entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of team member entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching team member entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching team member entries
	 */
	public java.util.List<TeamMemberEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<TeamMemberEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<TeamMemberEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator);

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
	public java.util.List<TeamMemberEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public TeamMemberEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
				orderByComparator)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Returns the first team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public TeamMemberEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator);

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public TeamMemberEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
				orderByComparator)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Returns the last team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public TeamMemberEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator);

	/**
	 * Returns the team member entries before and after the current team member entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param teamMemberTaskId the primary key of the current team member entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	public TeamMemberEntry[] findByUuid_C_PrevAndNext(
			long teamMemberTaskId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
				orderByComparator)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Removes all the team member entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of team member entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching team member entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @return the matching team member entries
	 */
	public java.util.List<TeamMemberEntry> findByTeam(
		long teamId, Boolean isAdmin);

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
	public java.util.List<TeamMemberEntry> findByTeam(
		long teamId, Boolean isAdmin, int start, int end);

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
	public java.util.List<TeamMemberEntry> findByTeam(
		long teamId, Boolean isAdmin, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator);

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
	public java.util.List<TeamMemberEntry> findByTeam(
		long teamId, Boolean isAdmin, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public TeamMemberEntry findByTeam_First(
			long teamId, Boolean isAdmin,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
				orderByComparator)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Returns the first team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public TeamMemberEntry fetchByTeam_First(
		long teamId, Boolean isAdmin,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator);

	/**
	 * Returns the last team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public TeamMemberEntry findByTeam_Last(
			long teamId, Boolean isAdmin,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
				orderByComparator)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Returns the last team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public TeamMemberEntry fetchByTeam_Last(
		long teamId, Boolean isAdmin,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator);

	/**
	 * Returns the team member entries before and after the current team member entry in the ordered set where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamMemberTaskId the primary key of the current team member entry
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	public TeamMemberEntry[] findByTeam_PrevAndNext(
			long teamMemberTaskId, long teamId, Boolean isAdmin,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
				orderByComparator)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Removes all the team member entries where teamId = &#63; and isAdmin = &#63; from the database.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 */
	public void removeByTeam(long teamId, Boolean isAdmin);

	/**
	 * Returns the number of team member entries where teamId = &#63; and isAdmin = &#63;.
	 *
	 * @param teamId the team ID
	 * @param isAdmin the is admin
	 * @return the number of matching team member entries
	 */
	public int countByTeam(long teamId, Boolean isAdmin);

	/**
	 * Returns the team member entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchTeamMemberEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team member entry
	 * @throws NoSuchTeamMemberEntryException if a matching team member entry could not be found
	 */
	public TeamMemberEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Returns the team member entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public TeamMemberEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the team member entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team member entry, or <code>null</code> if a matching team member entry could not be found
	 */
	public TeamMemberEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the team member entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the team member entry that was removed
	 */
	public TeamMemberEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Returns the number of team member entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching team member entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the team member entry in the entity cache if it is enabled.
	 *
	 * @param teamMemberEntry the team member entry
	 */
	public void cacheResult(TeamMemberEntry teamMemberEntry);

	/**
	 * Caches the team member entries in the entity cache if it is enabled.
	 *
	 * @param teamMemberEntries the team member entries
	 */
	public void cacheResult(java.util.List<TeamMemberEntry> teamMemberEntries);

	/**
	 * Creates a new team member entry with the primary key. Does not add the team member entry to the database.
	 *
	 * @param teamMemberTaskId the primary key for the new team member entry
	 * @return the new team member entry
	 */
	public TeamMemberEntry create(long teamMemberTaskId);

	/**
	 * Removes the team member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamMemberTaskId the primary key of the team member entry
	 * @return the team member entry that was removed
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	public TeamMemberEntry remove(long teamMemberTaskId)
		throws NoSuchTeamMemberEntryException;

	public TeamMemberEntry updateImpl(TeamMemberEntry teamMemberEntry);

	/**
	 * Returns the team member entry with the primary key or throws a <code>NoSuchTeamMemberEntryException</code> if it could not be found.
	 *
	 * @param teamMemberTaskId the primary key of the team member entry
	 * @return the team member entry
	 * @throws NoSuchTeamMemberEntryException if a team member entry with the primary key could not be found
	 */
	public TeamMemberEntry findByPrimaryKey(long teamMemberTaskId)
		throws NoSuchTeamMemberEntryException;

	/**
	 * Returns the team member entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamMemberTaskId the primary key of the team member entry
	 * @return the team member entry, or <code>null</code> if a team member entry with the primary key could not be found
	 */
	public TeamMemberEntry fetchByPrimaryKey(long teamMemberTaskId);

	/**
	 * Returns all the team member entries.
	 *
	 * @return the team member entries
	 */
	public java.util.List<TeamMemberEntry> findAll();

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
	public java.util.List<TeamMemberEntry> findAll(int start, int end);

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
	public java.util.List<TeamMemberEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator);

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
	public java.util.List<TeamMemberEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMemberEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the team member entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of team member entries.
	 *
	 * @return the number of team member entries
	 */
	public int countAll();

}