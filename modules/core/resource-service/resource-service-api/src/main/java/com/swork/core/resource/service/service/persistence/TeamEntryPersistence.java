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

import com.swork.core.resource.service.exception.NoSuchTeamEntryException;
import com.swork.core.resource.service.model.TeamEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the team entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamEntryUtil
 * @generated
 */
@ProviderType
public interface TeamEntryPersistence extends BasePersistence<TeamEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TeamEntryUtil} to access the team entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the team entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching team entries
	 */
	public java.util.List<TeamEntry> findByUuid(String uuid);

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
	public java.util.List<TeamEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<TeamEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

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
	public java.util.List<TeamEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the first team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

	/**
	 * Returns the team entries before and after the current team entry in the ordered set where uuid = &#63;.
	 *
	 * @param teamId the primary key of the current team entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	public TeamEntry[] findByUuid_PrevAndNext(
			long teamId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Removes all the team entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of team entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching team entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the team entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the team entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the team entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the team entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the team entry that was removed
	 */
	public TeamEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the number of team entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching team entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching team entries
	 */
	public java.util.List<TeamEntry> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<TeamEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<TeamEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

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
	public java.util.List<TeamEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the first team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the last team entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

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
	public TeamEntry[] findByUuid_C_PrevAndNext(
			long teamId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Removes all the team entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of team entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching team entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the team entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching team entries
	 */
	public java.util.List<TeamEntry> findByB_C(long businessId, String name);

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
	public java.util.List<TeamEntry> findByB_C(
		long businessId, String name, int start, int end);

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
	public java.util.List<TeamEntry> findByB_C(
		long businessId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

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
	public java.util.List<TeamEntry> findByB_C(
		long businessId, String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByB_C_First(
			long businessId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByB_C_First(
		long businessId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByB_C_Last(
			long businessId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByB_C_Last(
		long businessId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

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
	public TeamEntry[] findByB_C_PrevAndNext(
			long teamId, long businessId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Removes all the team entries where businessId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 */
	public void removeByB_C(long businessId, String name);

	/**
	 * Returns the number of team entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the number of matching team entries
	 */
	public int countByB_C(long businessId, String name);

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and projectId = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByB_N_P(long businessId, String name, Long projectId)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByB_N_P(long businessId, String name, Long projectId);

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByB_N_P(
		long businessId, String name, Long projectId, boolean useFinderCache);

	/**
	 * Removes the team entry where businessId = &#63; and name = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the team entry that was removed
	 */
	public TeamEntry removeByB_N_P(long businessId, String name, Long projectId)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the number of team entries where businessId = &#63; and name = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param projectId the project ID
	 * @return the number of matching team entries
	 */
	public int countByB_N_P(long businessId, String name, Long projectId);

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByB_N_PH(long businessId, String name, Long phaseId)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByB_N_PH(long businessId, String name, Long phaseId);

	/**
	 * Returns the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByB_N_PH(
		long businessId, String name, Long phaseId, boolean useFinderCache);

	/**
	 * Removes the team entry where businessId = &#63; and name = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the team entry that was removed
	 */
	public TeamEntry removeByB_N_PH(long businessId, String name, Long phaseId)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the number of team entries where businessId = &#63; and name = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param phaseId the phase ID
	 * @return the number of matching team entries
	 */
	public int countByB_N_PH(long businessId, String name, Long phaseId);

	/**
	 * Returns all the team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the matching team entries
	 */
	public java.util.List<TeamEntry> findByB_PH(long businessId, Long phaseId);

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
	public java.util.List<TeamEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end);

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
	public java.util.List<TeamEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

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
	public java.util.List<TeamEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByB_PH_First(
			long businessId, Long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByB_PH_First(
		long businessId, Long phaseId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByB_PH_Last(
			long businessId, Long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByB_PH_Last(
		long businessId, Long phaseId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

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
	public TeamEntry[] findByB_PH_PrevAndNext(
			long teamId, long businessId, Long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Removes all the team entries where businessId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 */
	public void removeByB_PH(long businessId, Long phaseId);

	/**
	 * Returns the number of team entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the number of matching team entries
	 */
	public int countByB_PH(long businessId, Long phaseId);

	/**
	 * Returns all the team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching team entries
	 */
	public java.util.List<TeamEntry> findByB_P(long businessId, Long projectId);

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
	public java.util.List<TeamEntry> findByB_P(
		long businessId, Long projectId, int start, int end);

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
	public java.util.List<TeamEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

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
	public java.util.List<TeamEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByB_P_First(
			long businessId, Long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the first team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByB_P_First(
		long businessId, Long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByB_P_Last(
			long businessId, Long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the last team entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByB_P_Last(
		long businessId, Long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

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
	public TeamEntry[] findByB_P_PrevAndNext(
			long teamId, long businessId, Long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
				orderByComparator)
		throws NoSuchTeamEntryException;

	/**
	 * Removes all the team entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	public void removeByB_P(long businessId, Long projectId);

	/**
	 * Returns the number of team entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching team entries
	 */
	public int countByB_P(long businessId, Long projectId);

	/**
	 * Returns the team entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team entry
	 * @throws NoSuchTeamEntryException if a matching team entry could not be found
	 */
	public TeamEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the team entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Returns the team entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team entry, or <code>null</code> if a matching team entry could not be found
	 */
	public TeamEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the team entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the team entry that was removed
	 */
	public TeamEntry removeByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the number of team entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching team entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the team entry in the entity cache if it is enabled.
	 *
	 * @param teamEntry the team entry
	 */
	public void cacheResult(TeamEntry teamEntry);

	/**
	 * Caches the team entries in the entity cache if it is enabled.
	 *
	 * @param teamEntries the team entries
	 */
	public void cacheResult(java.util.List<TeamEntry> teamEntries);

	/**
	 * Creates a new team entry with the primary key. Does not add the team entry to the database.
	 *
	 * @param teamId the primary key for the new team entry
	 * @return the new team entry
	 */
	public TeamEntry create(long teamId);

	/**
	 * Removes the team entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry that was removed
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	public TeamEntry remove(long teamId) throws NoSuchTeamEntryException;

	public TeamEntry updateImpl(TeamEntry teamEntry);

	/**
	 * Returns the team entry with the primary key or throws a <code>NoSuchTeamEntryException</code> if it could not be found.
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry
	 * @throws NoSuchTeamEntryException if a team entry with the primary key could not be found
	 */
	public TeamEntry findByPrimaryKey(long teamId)
		throws NoSuchTeamEntryException;

	/**
	 * Returns the team entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teamId the primary key of the team entry
	 * @return the team entry, or <code>null</code> if a team entry with the primary key could not be found
	 */
	public TeamEntry fetchByPrimaryKey(long teamId);

	/**
	 * Returns all the team entries.
	 *
	 * @return the team entries
	 */
	public java.util.List<TeamEntry> findAll();

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
	public java.util.List<TeamEntry> findAll(int start, int end);

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
	public java.util.List<TeamEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator);

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
	public java.util.List<TeamEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the team entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of team entries.
	 *
	 * @return the number of team entries
	 */
	public int countAll();

}