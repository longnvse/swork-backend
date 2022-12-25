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

import com.swork.auth.department.service.model.DepartmentEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the department entry service. This utility wraps <code>com.swork.auth.department.service.service.persistence.impl.DepartmentEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentEntryPersistence
 * @generated
 */
public class DepartmentEntryUtil {

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
	public static void clearCache(DepartmentEntry departmentEntry) {
		getPersistence().clearCache(departmentEntry);
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
	public static Map<Serializable, DepartmentEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DepartmentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DepartmentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DepartmentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DepartmentEntry update(DepartmentEntry departmentEntry) {
		return getPersistence().update(departmentEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DepartmentEntry update(
		DepartmentEntry departmentEntry, ServiceContext serviceContext) {

		return getPersistence().update(departmentEntry, serviceContext);
	}

	/**
	 * Returns all the department entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching department entries
	 */
	public static List<DepartmentEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByUuid_First(
			String uuid, OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUuid_First(
		String uuid, OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByUuid_Last(
			String uuid, OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the department entries before and after the current department entry in the ordered set where uuid = &#63;.
	 *
	 * @param departmentId the primary key of the current department entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry[] findByUuid_PrevAndNext(
			long departmentId, String uuid,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			departmentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the department entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of department entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching department entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the department entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the department entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the department entry that was removed
	 */
	public static DepartmentEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of department entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching department entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching department entries
	 */
	public static List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching department entries
	 */
	public static List<DepartmentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the department entries before and after the current department entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param departmentId the primary key of the current department entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry[] findByUuid_C_PrevAndNext(
			long departmentId, String uuid, long companyId,
			OrderByComparator<DepartmentEntry> orderByComparator)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			departmentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the department entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of department entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching department entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the department entry where name = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByName(String name)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the department entry where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the department entry where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByName(
		String name, boolean useFinderCache) {

		return getPersistence().fetchByName(name, useFinderCache);
	}

	/**
	 * Removes the department entry where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the department entry that was removed
	 */
	public static DepartmentEntry removeByName(String name)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of department entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching department entries
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department entry
	 * @throws NoSuchDepartmentEntryException if a matching department entry could not be found
	 */
	public static DepartmentEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the department entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department entry, or <code>null</code> if a matching department entry could not be found
	 */
	public static DepartmentEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the department entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the department entry that was removed
	 */
	public static DepartmentEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of department entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching department entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the department entry in the entity cache if it is enabled.
	 *
	 * @param departmentEntry the department entry
	 */
	public static void cacheResult(DepartmentEntry departmentEntry) {
		getPersistence().cacheResult(departmentEntry);
	}

	/**
	 * Caches the department entries in the entity cache if it is enabled.
	 *
	 * @param departmentEntries the department entries
	 */
	public static void cacheResult(List<DepartmentEntry> departmentEntries) {
		getPersistence().cacheResult(departmentEntries);
	}

	/**
	 * Creates a new department entry with the primary key. Does not add the department entry to the database.
	 *
	 * @param departmentId the primary key for the new department entry
	 * @return the new department entry
	 */
	public static DepartmentEntry create(long departmentId) {
		return getPersistence().create(departmentId);
	}

	/**
	 * Removes the department entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry that was removed
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry remove(long departmentId)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().remove(departmentId);
	}

	public static DepartmentEntry updateImpl(DepartmentEntry departmentEntry) {
		return getPersistence().updateImpl(departmentEntry);
	}

	/**
	 * Returns the department entry with the primary key or throws a <code>NoSuchDepartmentEntryException</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry
	 * @throws NoSuchDepartmentEntryException if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry findByPrimaryKey(long departmentId)
		throws com.swork.auth.department.service.exception.
			NoSuchDepartmentEntryException {

		return getPersistence().findByPrimaryKey(departmentId);
	}

	/**
	 * Returns the department entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the department entry
	 * @return the department entry, or <code>null</code> if a department entry with the primary key could not be found
	 */
	public static DepartmentEntry fetchByPrimaryKey(long departmentId) {
		return getPersistence().fetchByPrimaryKey(departmentId);
	}

	/**
	 * Returns all the department entries.
	 *
	 * @return the department entries
	 */
	public static List<DepartmentEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @return the range of department entries
	 */
	public static List<DepartmentEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of department entries
	 */
	public static List<DepartmentEntry> findAll(
		int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department entries
	 * @param end the upper bound of the range of department entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of department entries
	 */
	public static List<DepartmentEntry> findAll(
		int start, int end,
		OrderByComparator<DepartmentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the department entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of department entries.
	 *
	 * @return the number of department entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DepartmentEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DepartmentEntryPersistence _persistence;

}