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

import com.swork.core.project.service.exception.NoSuchProjectMemberEntryException;
import com.swork.core.project.service.model.ProjectMemberEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the project member entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectMemberEntryUtil
 * @generated
 */
@ProviderType
public interface ProjectMemberEntryPersistence
	extends BasePersistence<ProjectMemberEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectMemberEntryUtil} to access the project member entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the matching project member entries
	 */
	public java.util.List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type);

	/**
	 * Returns a range of all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @return the range of matching project member entries
	 */
	public java.util.List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type, int start, int end);

	/**
	 * Returns an ordered range of all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project member entries
	 */
	public java.util.List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project member entries
	 */
	public java.util.List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	public ProjectMemberEntry findByP_T_MT_First(
			long projectId, String memberType, String type,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
				orderByComparator)
		throws NoSuchProjectMemberEntryException;

	/**
	 * Returns the first project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	public ProjectMemberEntry fetchByP_T_MT_First(
		long projectId, String memberType, String type,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
			orderByComparator);

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	public ProjectMemberEntry findByP_T_MT_Last(
			long projectId, String memberType, String type,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
				orderByComparator)
		throws NoSuchProjectMemberEntryException;

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	public ProjectMemberEntry fetchByP_T_MT_Last(
		long projectId, String memberType, String type,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
			orderByComparator);

	/**
	 * Returns the project member entries before and after the current project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectMemberId the primary key of the current project member entry
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project member entry
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	public ProjectMemberEntry[] findByP_T_MT_PrevAndNext(
			long projectMemberId, long projectId, String memberType,
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
				orderByComparator)
		throws NoSuchProjectMemberEntryException;

	/**
	 * Removes all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 */
	public void removeByP_T_MT(long projectId, String memberType, String type);

	/**
	 * Returns the number of project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the number of matching project member entries
	 */
	public int countByP_T_MT(long projectId, String memberType, String type);

	/**
	 * Returns all the project member entries where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project member entries
	 */
	public java.util.List<ProjectMemberEntry> findByP_(long projectId);

	/**
	 * Returns a range of all the project member entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @return the range of matching project member entries
	 */
	public java.util.List<ProjectMemberEntry> findByP_(
		long projectId, int start, int end);

	/**
	 * Returns an ordered range of all the project member entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project member entries
	 */
	public java.util.List<ProjectMemberEntry> findByP_(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project member entries where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project member entries
	 */
	public java.util.List<ProjectMemberEntry> findByP_(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	public ProjectMemberEntry findByP__First(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
				orderByComparator)
		throws NoSuchProjectMemberEntryException;

	/**
	 * Returns the first project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	public ProjectMemberEntry fetchByP__First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
			orderByComparator);

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	public ProjectMemberEntry findByP__Last(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
				orderByComparator)
		throws NoSuchProjectMemberEntryException;

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	public ProjectMemberEntry fetchByP__Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
			orderByComparator);

	/**
	 * Returns the project member entries before and after the current project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectMemberId the primary key of the current project member entry
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project member entry
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	public ProjectMemberEntry[] findByP__PrevAndNext(
			long projectMemberId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
				orderByComparator)
		throws NoSuchProjectMemberEntryException;

	/**
	 * Removes all the project member entries where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public void removeByP_(long projectId);

	/**
	 * Returns the number of project member entries where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project member entries
	 */
	public int countByP_(long projectId);

	/**
	 * Caches the project member entry in the entity cache if it is enabled.
	 *
	 * @param projectMemberEntry the project member entry
	 */
	public void cacheResult(ProjectMemberEntry projectMemberEntry);

	/**
	 * Caches the project member entries in the entity cache if it is enabled.
	 *
	 * @param projectMemberEntries the project member entries
	 */
	public void cacheResult(
		java.util.List<ProjectMemberEntry> projectMemberEntries);

	/**
	 * Creates a new project member entry with the primary key. Does not add the project member entry to the database.
	 *
	 * @param projectMemberId the primary key for the new project member entry
	 * @return the new project member entry
	 */
	public ProjectMemberEntry create(long projectMemberId);

	/**
	 * Removes the project member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry that was removed
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	public ProjectMemberEntry remove(long projectMemberId)
		throws NoSuchProjectMemberEntryException;

	public ProjectMemberEntry updateImpl(ProjectMemberEntry projectMemberEntry);

	/**
	 * Returns the project member entry with the primary key or throws a <code>NoSuchProjectMemberEntryException</code> if it could not be found.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	public ProjectMemberEntry findByPrimaryKey(long projectMemberId)
		throws NoSuchProjectMemberEntryException;

	/**
	 * Returns the project member entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry, or <code>null</code> if a project member entry with the primary key could not be found
	 */
	public ProjectMemberEntry fetchByPrimaryKey(long projectMemberId);

	/**
	 * Returns all the project member entries.
	 *
	 * @return the project member entries
	 */
	public java.util.List<ProjectMemberEntry> findAll();

	/**
	 * Returns a range of all the project member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @return the range of project member entries
	 */
	public java.util.List<ProjectMemberEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the project member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project member entries
	 */
	public java.util.List<ProjectMemberEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project member entries
	 * @param end the upper bound of the range of project member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project member entries
	 */
	public java.util.List<ProjectMemberEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectMemberEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the project member entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of project member entries.
	 *
	 * @return the number of project member entries
	 */
	public int countAll();

}