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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.core.project.service.model.ProjectMemberEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the project member entry service. This utility wraps <code>com.swork.core.project.service.service.persistence.impl.ProjectMemberEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectMemberEntryPersistence
 * @generated
 */
public class ProjectMemberEntryUtil {

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
	public static void clearCache(ProjectMemberEntry projectMemberEntry) {
		getPersistence().clearCache(projectMemberEntry);
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
	public static Map<Serializable, ProjectMemberEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProjectMemberEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectMemberEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectMemberEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectMemberEntry update(
		ProjectMemberEntry projectMemberEntry) {

		return getPersistence().update(projectMemberEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectMemberEntry update(
		ProjectMemberEntry projectMemberEntry, ServiceContext serviceContext) {

		return getPersistence().update(projectMemberEntry, serviceContext);
	}

	/**
	 * Returns all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the matching project member entries
	 */
	public static List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type) {

		return getPersistence().findByP_T_MT(projectId, memberType, type);
	}

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
	public static List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type, int start, int end) {

		return getPersistence().findByP_T_MT(
			projectId, memberType, type, start, end);
	}

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
	public static List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type, int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return getPersistence().findByP_T_MT(
			projectId, memberType, type, start, end, orderByComparator);
	}

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
	public static List<ProjectMemberEntry> findByP_T_MT(
		long projectId, String memberType, String type, int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_T_MT(
			projectId, memberType, type, start, end, orderByComparator,
			useFinderCache);
	}

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
	public static ProjectMemberEntry findByP_T_MT_First(
			long projectId, String memberType, String type,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectMemberEntryException {

		return getPersistence().findByP_T_MT_First(
			projectId, memberType, type, orderByComparator);
	}

	/**
	 * Returns the first project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	public static ProjectMemberEntry fetchByP_T_MT_First(
		long projectId, String memberType, String type,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return getPersistence().fetchByP_T_MT_First(
			projectId, memberType, type, orderByComparator);
	}

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
	public static ProjectMemberEntry findByP_T_MT_Last(
			long projectId, String memberType, String type,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectMemberEntryException {

		return getPersistence().findByP_T_MT_Last(
			projectId, memberType, type, orderByComparator);
	}

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	public static ProjectMemberEntry fetchByP_T_MT_Last(
		long projectId, String memberType, String type,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return getPersistence().fetchByP_T_MT_Last(
			projectId, memberType, type, orderByComparator);
	}

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
	public static ProjectMemberEntry[] findByP_T_MT_PrevAndNext(
			long projectMemberId, long projectId, String memberType,
			String type,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectMemberEntryException {

		return getPersistence().findByP_T_MT_PrevAndNext(
			projectMemberId, projectId, memberType, type, orderByComparator);
	}

	/**
	 * Removes all the project member entries where projectId = &#63; and memberType = &#63; and type = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 */
	public static void removeByP_T_MT(
		long projectId, String memberType, String type) {

		getPersistence().removeByP_T_MT(projectId, memberType, type);
	}

	/**
	 * Returns the number of project member entries where projectId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param projectId the project ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the number of matching project member entries
	 */
	public static int countByP_T_MT(
		long projectId, String memberType, String type) {

		return getPersistence().countByP_T_MT(projectId, memberType, type);
	}

	/**
	 * Returns all the project member entries where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project member entries
	 */
	public static List<ProjectMemberEntry> findByP_(long projectId) {
		return getPersistence().findByP_(projectId);
	}

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
	public static List<ProjectMemberEntry> findByP_(
		long projectId, int start, int end) {

		return getPersistence().findByP_(projectId, start, end);
	}

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
	public static List<ProjectMemberEntry> findByP_(
		long projectId, int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return getPersistence().findByP_(
			projectId, start, end, orderByComparator);
	}

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
	public static List<ProjectMemberEntry> findByP_(
		long projectId, int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_(
			projectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	public static ProjectMemberEntry findByP__First(
			long projectId,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectMemberEntryException {

		return getPersistence().findByP__First(projectId, orderByComparator);
	}

	/**
	 * Returns the first project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	public static ProjectMemberEntry fetchByP__First(
		long projectId,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return getPersistence().fetchByP__First(projectId, orderByComparator);
	}

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry
	 * @throws NoSuchProjectMemberEntryException if a matching project member entry could not be found
	 */
	public static ProjectMemberEntry findByP__Last(
			long projectId,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectMemberEntryException {

		return getPersistence().findByP__Last(projectId, orderByComparator);
	}

	/**
	 * Returns the last project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project member entry, or <code>null</code> if a matching project member entry could not be found
	 */
	public static ProjectMemberEntry fetchByP__Last(
		long projectId,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return getPersistence().fetchByP__Last(projectId, orderByComparator);
	}

	/**
	 * Returns the project member entries before and after the current project member entry in the ordered set where projectId = &#63;.
	 *
	 * @param projectMemberId the primary key of the current project member entry
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project member entry
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	public static ProjectMemberEntry[] findByP__PrevAndNext(
			long projectMemberId, long projectId,
			OrderByComparator<ProjectMemberEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectMemberEntryException {

		return getPersistence().findByP__PrevAndNext(
			projectMemberId, projectId, orderByComparator);
	}

	/**
	 * Removes all the project member entries where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public static void removeByP_(long projectId) {
		getPersistence().removeByP_(projectId);
	}

	/**
	 * Returns the number of project member entries where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project member entries
	 */
	public static int countByP_(long projectId) {
		return getPersistence().countByP_(projectId);
	}

	/**
	 * Caches the project member entry in the entity cache if it is enabled.
	 *
	 * @param projectMemberEntry the project member entry
	 */
	public static void cacheResult(ProjectMemberEntry projectMemberEntry) {
		getPersistence().cacheResult(projectMemberEntry);
	}

	/**
	 * Caches the project member entries in the entity cache if it is enabled.
	 *
	 * @param projectMemberEntries the project member entries
	 */
	public static void cacheResult(
		List<ProjectMemberEntry> projectMemberEntries) {

		getPersistence().cacheResult(projectMemberEntries);
	}

	/**
	 * Creates a new project member entry with the primary key. Does not add the project member entry to the database.
	 *
	 * @param projectMemberId the primary key for the new project member entry
	 * @return the new project member entry
	 */
	public static ProjectMemberEntry create(long projectMemberId) {
		return getPersistence().create(projectMemberId);
	}

	/**
	 * Removes the project member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry that was removed
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	public static ProjectMemberEntry remove(long projectMemberId)
		throws com.swork.core.project.service.exception.
			NoSuchProjectMemberEntryException {

		return getPersistence().remove(projectMemberId);
	}

	public static ProjectMemberEntry updateImpl(
		ProjectMemberEntry projectMemberEntry) {

		return getPersistence().updateImpl(projectMemberEntry);
	}

	/**
	 * Returns the project member entry with the primary key or throws a <code>NoSuchProjectMemberEntryException</code> if it could not be found.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry
	 * @throws NoSuchProjectMemberEntryException if a project member entry with the primary key could not be found
	 */
	public static ProjectMemberEntry findByPrimaryKey(long projectMemberId)
		throws com.swork.core.project.service.exception.
			NoSuchProjectMemberEntryException {

		return getPersistence().findByPrimaryKey(projectMemberId);
	}

	/**
	 * Returns the project member entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectMemberId the primary key of the project member entry
	 * @return the project member entry, or <code>null</code> if a project member entry with the primary key could not be found
	 */
	public static ProjectMemberEntry fetchByPrimaryKey(long projectMemberId) {
		return getPersistence().fetchByPrimaryKey(projectMemberId);
	}

	/**
	 * Returns all the project member entries.
	 *
	 * @return the project member entries
	 */
	public static List<ProjectMemberEntry> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProjectMemberEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProjectMemberEntry> findAll(
		int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProjectMemberEntry> findAll(
		int start, int end,
		OrderByComparator<ProjectMemberEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the project member entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of project member entries.
	 *
	 * @return the number of project member entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectMemberEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProjectMemberEntryPersistence _persistence;

}