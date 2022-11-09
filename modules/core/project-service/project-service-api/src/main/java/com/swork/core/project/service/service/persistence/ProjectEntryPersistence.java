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

package com.swork.core.project.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.core.project.service.exception.NoSuchProjectEntryException;
import com.swork.core.project.service.model.ProjectEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the project entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEntryUtil
 * @generated
 */
@ProviderType
public interface ProjectEntryPersistence extends BasePersistence<ProjectEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectEntryUtil} to access the project entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the project entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project entries
	 */
	public java.util.List<ProjectEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the project entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @return the range of matching project entries
	 */
	public java.util.List<ProjectEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the project entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project entries
	 */
	public java.util.List<ProjectEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project entries
	 */
	public java.util.List<ProjectEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public ProjectEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
				orderByComparator)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the first project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator);

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public ProjectEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
				orderByComparator)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator);

	/**
	 * Returns the project entries before and after the current project entry in the ordered set where uuid = &#63;.
	 *
	 * @param projectId the primary key of the current project entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	public ProjectEntry[] findByUuid_PrevAndNext(
			long projectId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
				orderByComparator)
		throws NoSuchProjectEntryException;

	/**
	 * Removes all the project entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of project entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the project entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public ProjectEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the project entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the project entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the project entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project entry that was removed
	 */
	public ProjectEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the number of project entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project entries
	 */
	public java.util.List<ProjectEntry> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @return the range of matching project entries
	 */
	public java.util.List<ProjectEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project entries
	 */
	public java.util.List<ProjectEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project entries
	 */
	public java.util.List<ProjectEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public ProjectEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
				orderByComparator)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the first project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator);

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public ProjectEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
				orderByComparator)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator);

	/**
	 * Returns the project entries before and after the current project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectId the primary key of the current project entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	public ProjectEntry[] findByUuid_C_PrevAndNext(
			long projectId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
				orderByComparator)
		throws NoSuchProjectEntryException;

	/**
	 * Removes all the project entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the project entry where businessId = &#63; and name = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public ProjectEntry findByP_N(long businessId, String name)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the project entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByP_N(long businessId, String name);

	/**
	 * Returns the project entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByP_N(
		long businessId, String name, boolean useFinderCache);

	/**
	 * Removes the project entry where businessId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the project entry that was removed
	 */
	public ProjectEntry removeByP_N(long businessId, String name)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the number of project entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the number of matching project entries
	 */
	public int countByP_N(long businessId, String name);

	/**
	 * Returns the project entry where businessId = &#63; and code = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public ProjectEntry findByP_C(long businessId, String code)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the project entry where businessId = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByP_C(long businessId, String code);

	/**
	 * Returns the project entry where businessId = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByP_C(
		long businessId, String code, boolean useFinderCache);

	/**
	 * Removes the project entry where businessId = &#63; and code = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the project entry that was removed
	 */
	public ProjectEntry removeByP_C(long businessId, String code)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the number of project entries where businessId = &#63; and code = &#63;.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the number of matching project entries
	 */
	public int countByP_C(long businessId, String code);

	/**
	 * Returns all the project entries where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @return the matching project entries
	 */
	public java.util.List<ProjectEntry> findByB_(long businessId);

	/**
	 * Returns a range of all the project entries where businessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @return the range of matching project entries
	 */
	public java.util.List<ProjectEntry> findByB_(
		long businessId, int start, int end);

	/**
	 * Returns an ordered range of all the project entries where businessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project entries
	 */
	public java.util.List<ProjectEntry> findByB_(
		long businessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project entries where businessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project entries
	 */
	public java.util.List<ProjectEntry> findByB_(
		long businessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public ProjectEntry findByB__First(
			long businessId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
				orderByComparator)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the first project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByB__First(
		long businessId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator);

	/**
	 * Returns the last project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public ProjectEntry findByB__Last(
			long businessId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
				orderByComparator)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the last project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByB__Last(
		long businessId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator);

	/**
	 * Returns the project entries before and after the current project entry in the ordered set where businessId = &#63;.
	 *
	 * @param projectId the primary key of the current project entry
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	public ProjectEntry[] findByB__PrevAndNext(
			long projectId, long businessId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
				orderByComparator)
		throws NoSuchProjectEntryException;

	/**
	 * Removes all the project entries where businessId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 */
	public void removeByB_(long businessId);

	/**
	 * Returns the number of project entries where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @return the number of matching project entries
	 */
	public int countByB_(long businessId);

	/**
	 * Returns the project entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public ProjectEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the project entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the project entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public ProjectEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the project entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the project entry that was removed
	 */
	public ProjectEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the number of project entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching project entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the project entry in the entity cache if it is enabled.
	 *
	 * @param projectEntry the project entry
	 */
	public void cacheResult(ProjectEntry projectEntry);

	/**
	 * Caches the project entries in the entity cache if it is enabled.
	 *
	 * @param projectEntries the project entries
	 */
	public void cacheResult(java.util.List<ProjectEntry> projectEntries);

	/**
	 * Creates a new project entry with the primary key. Does not add the project entry to the database.
	 *
	 * @param projectId the primary key for the new project entry
	 * @return the new project entry
	 */
	public ProjectEntry create(long projectId);

	/**
	 * Removes the project entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry that was removed
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	public ProjectEntry remove(long projectId)
		throws NoSuchProjectEntryException;

	public ProjectEntry updateImpl(ProjectEntry projectEntry);

	/**
	 * Returns the project entry with the primary key or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	public ProjectEntry findByPrimaryKey(long projectId)
		throws NoSuchProjectEntryException;

	/**
	 * Returns the project entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry, or <code>null</code> if a project entry with the primary key could not be found
	 */
	public ProjectEntry fetchByPrimaryKey(long projectId);

	/**
	 * Returns all the project entries.
	 *
	 * @return the project entries
	 */
	public java.util.List<ProjectEntry> findAll();

	/**
	 * Returns a range of all the project entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @return the range of project entries
	 */
	public java.util.List<ProjectEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the project entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project entries
	 */
	public java.util.List<ProjectEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project entries
	 */
	public java.util.List<ProjectEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the project entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of project entries.
	 *
	 * @return the number of project entries
	 */
	public int countAll();

}