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

import com.swork.core.project.service.model.ProjectEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the project entry service. This utility wraps <code>com.swork.core.project.service.service.persistence.impl.ProjectEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEntryPersistence
 * @generated
 */
public class ProjectEntryUtil {

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
	public static void clearCache(ProjectEntry projectEntry) {
		getPersistence().clearCache(projectEntry);
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
	public static Map<Serializable, ProjectEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProjectEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectEntry update(ProjectEntry projectEntry) {
		return getPersistence().update(projectEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectEntry update(
		ProjectEntry projectEntry, ServiceContext serviceContext) {

		return getPersistence().update(projectEntry, serviceContext);
	}

	/**
	 * Returns all the project entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project entries
	 */
	public static List<ProjectEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ProjectEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ProjectEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ProjectEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public static ProjectEntry findByUuid_First(
			String uuid, OrderByComparator<ProjectEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByUuid_First(
		String uuid, OrderByComparator<ProjectEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public static ProjectEntry findByUuid_Last(
			String uuid, OrderByComparator<ProjectEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ProjectEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the project entries before and after the current project entry in the ordered set where uuid = &#63;.
	 *
	 * @param projectId the primary key of the current project entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	public static ProjectEntry[] findByUuid_PrevAndNext(
			long projectId, String uuid,
			OrderByComparator<ProjectEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			projectId, uuid, orderByComparator);
	}

	/**
	 * Removes all the project entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of project entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the project entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public static ProjectEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the project entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the project entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the project entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project entry that was removed
	 */
	public static ProjectEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of project entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project entries
	 */
	public static List<ProjectEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<ProjectEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<ProjectEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<ProjectEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public static ProjectEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProjectEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProjectEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public static ProjectEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProjectEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last project entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProjectEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static ProjectEntry[] findByUuid_C_PrevAndNext(
			long projectId, String uuid, long companyId,
			OrderByComparator<ProjectEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			projectId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the project entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of project entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the project entry where businessId = &#63; and name = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public static ProjectEntry findByP_N(long businessId, String name)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByP_N(businessId, name);
	}

	/**
	 * Returns the project entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByP_N(long businessId, String name) {
		return getPersistence().fetchByP_N(businessId, name);
	}

	/**
	 * Returns the project entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByP_N(
		long businessId, String name, boolean useFinderCache) {

		return getPersistence().fetchByP_N(businessId, name, useFinderCache);
	}

	/**
	 * Removes the project entry where businessId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the project entry that was removed
	 */
	public static ProjectEntry removeByP_N(long businessId, String name)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().removeByP_N(businessId, name);
	}

	/**
	 * Returns the number of project entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the number of matching project entries
	 */
	public static int countByP_N(long businessId, String name) {
		return getPersistence().countByP_N(businessId, name);
	}

	/**
	 * Returns the project entry where businessId = &#63; and code = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public static ProjectEntry findByP_C(long businessId, String code)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByP_C(businessId, code);
	}

	/**
	 * Returns the project entry where businessId = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByP_C(long businessId, String code) {
		return getPersistence().fetchByP_C(businessId, code);
	}

	/**
	 * Returns the project entry where businessId = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByP_C(
		long businessId, String code, boolean useFinderCache) {

		return getPersistence().fetchByP_C(businessId, code, useFinderCache);
	}

	/**
	 * Removes the project entry where businessId = &#63; and code = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the project entry that was removed
	 */
	public static ProjectEntry removeByP_C(long businessId, String code)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().removeByP_C(businessId, code);
	}

	/**
	 * Returns the number of project entries where businessId = &#63; and code = &#63;.
	 *
	 * @param businessId the business ID
	 * @param code the code
	 * @return the number of matching project entries
	 */
	public static int countByP_C(long businessId, String code) {
		return getPersistence().countByP_C(businessId, code);
	}

	/**
	 * Returns all the project entries where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @return the matching project entries
	 */
	public static List<ProjectEntry> findByB_(long businessId) {
		return getPersistence().findByB_(businessId);
	}

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
	public static List<ProjectEntry> findByB_(
		long businessId, int start, int end) {

		return getPersistence().findByB_(businessId, start, end);
	}

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
	public static List<ProjectEntry> findByB_(
		long businessId, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator) {

		return getPersistence().findByB_(
			businessId, start, end, orderByComparator);
	}

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
	public static List<ProjectEntry> findByB_(
		long businessId, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_(
			businessId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public static ProjectEntry findByB__First(
			long businessId, OrderByComparator<ProjectEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByB__First(businessId, orderByComparator);
	}

	/**
	 * Returns the first project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByB__First(
		long businessId, OrderByComparator<ProjectEntry> orderByComparator) {

		return getPersistence().fetchByB__First(businessId, orderByComparator);
	}

	/**
	 * Returns the last project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public static ProjectEntry findByB__Last(
			long businessId, OrderByComparator<ProjectEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByB__Last(businessId, orderByComparator);
	}

	/**
	 * Returns the last project entry in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByB__Last(
		long businessId, OrderByComparator<ProjectEntry> orderByComparator) {

		return getPersistence().fetchByB__Last(businessId, orderByComparator);
	}

	/**
	 * Returns the project entries before and after the current project entry in the ordered set where businessId = &#63;.
	 *
	 * @param projectId the primary key of the current project entry
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	public static ProjectEntry[] findByB__PrevAndNext(
			long projectId, long businessId,
			OrderByComparator<ProjectEntry> orderByComparator)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByB__PrevAndNext(
			projectId, businessId, orderByComparator);
	}

	/**
	 * Removes all the project entries where businessId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 */
	public static void removeByB_(long businessId) {
		getPersistence().removeByB_(businessId);
	}

	/**
	 * Returns the number of project entries where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @return the number of matching project entries
	 */
	public static int countByB_(long businessId) {
		return getPersistence().countByB_(businessId);
	}

	/**
	 * Returns the project entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching project entry
	 * @throws NoSuchProjectEntryException if a matching project entry could not be found
	 */
	public static ProjectEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the project entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the project entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	public static ProjectEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the project entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the project entry that was removed
	 */
	public static ProjectEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of project entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching project entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the project entry in the entity cache if it is enabled.
	 *
	 * @param projectEntry the project entry
	 */
	public static void cacheResult(ProjectEntry projectEntry) {
		getPersistence().cacheResult(projectEntry);
	}

	/**
	 * Caches the project entries in the entity cache if it is enabled.
	 *
	 * @param projectEntries the project entries
	 */
	public static void cacheResult(List<ProjectEntry> projectEntries) {
		getPersistence().cacheResult(projectEntries);
	}

	/**
	 * Creates a new project entry with the primary key. Does not add the project entry to the database.
	 *
	 * @param projectId the primary key for the new project entry
	 * @return the new project entry
	 */
	public static ProjectEntry create(long projectId) {
		return getPersistence().create(projectId);
	}

	/**
	 * Removes the project entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry that was removed
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	public static ProjectEntry remove(long projectId)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().remove(projectId);
	}

	public static ProjectEntry updateImpl(ProjectEntry projectEntry) {
		return getPersistence().updateImpl(projectEntry);
	}

	/**
	 * Returns the project entry with the primary key or throws a <code>NoSuchProjectEntryException</code> if it could not be found.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry
	 * @throws NoSuchProjectEntryException if a project entry with the primary key could not be found
	 */
	public static ProjectEntry findByPrimaryKey(long projectId)
		throws com.swork.core.project.service.exception.
			NoSuchProjectEntryException {

		return getPersistence().findByPrimaryKey(projectId);
	}

	/**
	 * Returns the project entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry, or <code>null</code> if a project entry with the primary key could not be found
	 */
	public static ProjectEntry fetchByPrimaryKey(long projectId) {
		return getPersistence().fetchByPrimaryKey(projectId);
	}

	/**
	 * Returns all the project entries.
	 *
	 * @return the project entries
	 */
	public static List<ProjectEntry> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProjectEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProjectEntry> findAll(
		int start, int end, OrderByComparator<ProjectEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProjectEntry> findAll(
		int start, int end, OrderByComparator<ProjectEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the project entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of project entries.
	 *
	 * @return the number of project entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProjectEntryPersistence _persistence;

}