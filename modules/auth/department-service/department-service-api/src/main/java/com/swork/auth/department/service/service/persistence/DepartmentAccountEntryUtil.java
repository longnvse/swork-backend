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

package com.swork.auth.department.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.auth.department.service.model.DepartmentAccountEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the department account entry service. This utility wraps <code>com.swork.auth.department.service.service.persistence.impl.DepartmentAccountEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentAccountEntryPersistence
 * @generated
 */
public class DepartmentAccountEntryUtil {

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
	public static void clearCache(
		DepartmentAccountEntry departmentAccountEntry) {

		getPersistence().clearCache(departmentAccountEntry);
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
	public static Map<Serializable, DepartmentAccountEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DepartmentAccountEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DepartmentAccountEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DepartmentAccountEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DepartmentAccountEntry update(
		DepartmentAccountEntry departmentAccountEntry) {

		return getPersistence().update(departmentAccountEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DepartmentAccountEntry update(
		DepartmentAccountEntry departmentAccountEntry,
		ServiceContext serviceContext) {

		return getPersistence().update(departmentAccountEntry, serviceContext);
	}

	/**
	 * Returns all the department account entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the department account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry findByUuid_First(
			String uuid,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry fetchByUuid_First(
		String uuid,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry findByUuid_Last(
			String uuid,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry fetchByUuid_Last(
		String uuid,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the department account entries before and after the current department account entry in the ordered set where uuid = &#63;.
	 *
	 * @param departmentAccountId the primary key of the current department account entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	public static DepartmentAccountEntry[] findByUuid_PrevAndNext(
			long departmentAccountId, String uuid,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			departmentAccountId, uuid, orderByComparator);
	}

	/**
	 * Removes all the department account entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of department account entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching department account entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the department account entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDepartmentAccountEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the department account entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the department account entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the department account entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the department account entry that was removed
	 */
	public static DepartmentAccountEntry removeByUUID_G(
			String uuid, long groupId)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of department account entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching department account entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the department account entries before and after the current department account entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param departmentAccountId the primary key of the current department account entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	public static DepartmentAccountEntry[] findByUuid_C_PrevAndNext(
			long departmentAccountId, String uuid, long companyId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			departmentAccountId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the department account entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of department account entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching department account entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the department account entries where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByDepartmentId(
		long departmentId) {

		return getPersistence().findByDepartmentId(departmentId);
	}

	/**
	 * Returns a range of all the department account entries where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByDepartmentId(
		long departmentId, int start, int end) {

		return getPersistence().findByDepartmentId(departmentId, start, end);
	}

	/**
	 * Returns an ordered range of all the department account entries where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByDepartmentId(
		long departmentId, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getPersistence().findByDepartmentId(
			departmentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department account entries where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department account entries
	 */
	public static List<DepartmentAccountEntry> findByDepartmentId(
		long departmentId, int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDepartmentId(
			departmentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry findByDepartmentId_First(
			long departmentId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByDepartmentId_First(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the first department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry fetchByDepartmentId_First(
		long departmentId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getPersistence().fetchByDepartmentId_First(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the last department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry findByDepartmentId_Last(
			long departmentId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByDepartmentId_Last(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the last department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry fetchByDepartmentId_Last(
		long departmentId,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getPersistence().fetchByDepartmentId_Last(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the department account entries before and after the current department account entry in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentAccountId the primary key of the current department account entry
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	public static DepartmentAccountEntry[] findByDepartmentId_PrevAndNext(
			long departmentAccountId, long departmentId,
			OrderByComparator<DepartmentAccountEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByDepartmentId_PrevAndNext(
			departmentAccountId, departmentId, orderByComparator);
	}

	/**
	 * Removes all the department account entries where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 */
	public static void removeByDepartmentId(long departmentId) {
		getPersistence().removeByDepartmentId(departmentId);
	}

	/**
	 * Returns the number of department account entries where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching department account entries
	 */
	public static int countByDepartmentId(long departmentId) {
		return getPersistence().countByDepartmentId(departmentId);
	}

	/**
	 * Returns the department account entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDepartmentAccountEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the department account entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the department account entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	public static DepartmentAccountEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the department account entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the department account entry that was removed
	 */
	public static DepartmentAccountEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of department account entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching department account entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the department account entry in the entity cache if it is enabled.
	 *
	 * @param departmentAccountEntry the department account entry
	 */
	public static void cacheResult(
		DepartmentAccountEntry departmentAccountEntry) {

		getPersistence().cacheResult(departmentAccountEntry);
	}

	/**
	 * Caches the department account entries in the entity cache if it is enabled.
	 *
	 * @param departmentAccountEntries the department account entries
	 */
	public static void cacheResult(
		List<DepartmentAccountEntry> departmentAccountEntries) {

		getPersistence().cacheResult(departmentAccountEntries);
	}

	/**
	 * Creates a new department account entry with the primary key. Does not add the department account entry to the database.
	 *
	 * @param departmentAccountId the primary key for the new department account entry
	 * @return the new department account entry
	 */
	public static DepartmentAccountEntry create(long departmentAccountId) {
		return getPersistence().create(departmentAccountId);
	}

	/**
	 * Removes the department account entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry that was removed
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	public static DepartmentAccountEntry remove(long departmentAccountId)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().remove(departmentAccountId);
	}

	public static DepartmentAccountEntry updateImpl(
		DepartmentAccountEntry departmentAccountEntry) {

		return getPersistence().updateImpl(departmentAccountEntry);
	}

	/**
	 * Returns the department account entry with the primary key or throws a <code>NoSuchDepartmentAccountEntryException</code> if it could not be found.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry
	 * @throws NoSuchDepartmentAccountEntryException if a department account entry with the primary key could not be found
	 */
	public static DepartmentAccountEntry findByPrimaryKey(
			long departmentAccountId)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentAccountEntryException {

		return getPersistence().findByPrimaryKey(departmentAccountId);
	}

	/**
	 * Returns the department account entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry, or <code>null</code> if a department account entry with the primary key could not be found
	 */
	public static DepartmentAccountEntry fetchByPrimaryKey(
		long departmentAccountId) {

		return getPersistence().fetchByPrimaryKey(departmentAccountId);
	}

	/**
	 * Returns all the department account entries.
	 *
	 * @return the department account entries
	 */
	public static List<DepartmentAccountEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the department account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of department account entries
	 */
	public static List<DepartmentAccountEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the department account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of department account entries
	 */
	public static List<DepartmentAccountEntry> findAll(
		int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of department account entries
	 */
	public static List<DepartmentAccountEntry> findAll(
		int start, int end,
		OrderByComparator<DepartmentAccountEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the department account entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of department account entries.
	 *
	 * @return the number of department account entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DepartmentAccountEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DepartmentAccountEntryPersistence _persistence;

}