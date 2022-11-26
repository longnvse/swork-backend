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

import com.swork.core.resource.service.model.ResourceEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the resource entry service. This utility wraps <code>com.swork.core.resource.service.service.persistence.impl.ResourceEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceEntryPersistence
 * @generated
 */
public class ResourceEntryUtil {

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
	public static void clearCache(ResourceEntry resourceEntry) {
		getPersistence().clearCache(resourceEntry);
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
	public static Map<Serializable, ResourceEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ResourceEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ResourceEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ResourceEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ResourceEntry update(ResourceEntry resourceEntry) {
		return getPersistence().update(resourceEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ResourceEntry update(
		ResourceEntry resourceEntry, ServiceContext serviceContext) {

		return getPersistence().update(resourceEntry, serviceContext);
	}

	/**
	 * Returns all the resource entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching resource entries
	 */
	public static List<ResourceEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the resource entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	public static List<ResourceEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the resource entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByUuid_First(
			String uuid, OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first resource entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByUuid_First(
		String uuid, OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByUuid_Last(
			String uuid, OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where uuid = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	public static ResourceEntry[] findByUuid_PrevAndNext(
			long resourceId, String uuid,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			resourceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the resource entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of resource entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching resource entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the resource entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchResourceEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the resource entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the resource entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the resource entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the resource entry that was removed
	 */
	public static ResourceEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of resource entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching resource entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the resource entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching resource entries
	 */
	public static List<ResourceEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the resource entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	public static List<ResourceEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first resource entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	public static ResourceEntry[] findByUuid_C_PrevAndNext(
			long resourceId, String uuid, long companyId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			resourceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the resource entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of resource entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching resource entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the resource entries where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @return the matching resource entries
	 */
	public static List<ResourceEntry> findByB_W(long businessId, Long workId) {
		return getPersistence().findByB_W(businessId, workId);
	}

	/**
	 * Returns a range of all the resource entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_W(
		long businessId, Long workId, int start, int end) {

		return getPersistence().findByB_W(businessId, workId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_W(
		long businessId, Long workId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().findByB_W(
			businessId, workId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_W(
		long businessId, Long workId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_W(
			businessId, workId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByB_W_First(
			long businessId, Long workId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_W_First(
			businessId, workId, orderByComparator);
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByB_W_First(
		long businessId, Long workId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByB_W_First(
			businessId, workId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByB_W_Last(
			long businessId, Long workId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_W_Last(
			businessId, workId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByB_W_Last(
		long businessId, Long workId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByB_W_Last(
			businessId, workId, orderByComparator);
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	public static ResourceEntry[] findByB_W_PrevAndNext(
			long resourceId, long businessId, Long workId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_W_PrevAndNext(
			resourceId, businessId, workId, orderByComparator);
	}

	/**
	 * Removes all the resource entries where businessId = &#63; and workId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 */
	public static void removeByB_W(long businessId, Long workId) {
		getPersistence().removeByB_W(businessId, workId);
	}

	/**
	 * Returns the number of resource entries where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @return the number of matching resource entries
	 */
	public static int countByB_W(long businessId, Long workId) {
		return getPersistence().countByB_W(businessId, workId);
	}

	/**
	 * Returns all the resource entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the matching resource entries
	 */
	public static List<ResourceEntry> findByB_PH(
		long businessId, Long phaseId) {

		return getPersistence().findByB_PH(businessId, phaseId);
	}

	/**
	 * Returns a range of all the resource entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end) {

		return getPersistence().findByB_PH(businessId, phaseId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().findByB_PH(
			businessId, phaseId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_PH(
			businessId, phaseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByB_PH_First(
			long businessId, Long phaseId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_PH_First(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByB_PH_First(
		long businessId, Long phaseId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByB_PH_First(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByB_PH_Last(
			long businessId, Long phaseId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_PH_Last(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByB_PH_Last(
		long businessId, Long phaseId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByB_PH_Last(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	public static ResourceEntry[] findByB_PH_PrevAndNext(
			long resourceId, long businessId, Long phaseId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_PH_PrevAndNext(
			resourceId, businessId, phaseId, orderByComparator);
	}

	/**
	 * Removes all the resource entries where businessId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 */
	public static void removeByB_PH(long businessId, Long phaseId) {
		getPersistence().removeByB_PH(businessId, phaseId);
	}

	/**
	 * Returns the number of resource entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the number of matching resource entries
	 */
	public static int countByB_PH(long businessId, Long phaseId) {
		return getPersistence().countByB_PH(businessId, phaseId);
	}

	/**
	 * Returns all the resource entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching resource entries
	 */
	public static List<ResourceEntry> findByB_P(
		long businessId, Long projectId) {

		return getPersistence().findByB_P(businessId, projectId);
	}

	/**
	 * Returns a range of all the resource entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_P(
		long businessId, Long projectId, int start, int end) {

		return getPersistence().findByB_P(businessId, projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().findByB_P(
			businessId, projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_P(
			businessId, projectId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByB_P_First(
			long businessId, Long projectId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_P_First(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByB_P_First(
		long businessId, Long projectId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByB_P_First(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByB_P_Last(
			long businessId, Long projectId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_P_Last(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByB_P_Last(
		long businessId, Long projectId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByB_P_Last(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	public static ResourceEntry[] findByB_P_PrevAndNext(
			long resourceId, long businessId, Long projectId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_P_PrevAndNext(
			resourceId, businessId, projectId, orderByComparator);
	}

	/**
	 * Removes all the resource entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	public static void removeByB_P(long businessId, Long projectId) {
		getPersistence().removeByB_P(businessId, projectId);
	}

	/**
	 * Returns the number of resource entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching resource entries
	 */
	public static int countByB_P(long businessId, Long projectId) {
		return getPersistence().countByB_P(businessId, projectId);
	}

	/**
	 * Returns all the resource entries where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @return the matching resource entries
	 */
	public static List<ResourceEntry> findByB_Team(
		long businessId, long teamId) {

		return getPersistence().findByB_Team(businessId, teamId);
	}

	/**
	 * Returns a range of all the resource entries where businessId = &#63; and teamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_Team(
		long businessId, long teamId, int start, int end) {

		return getPersistence().findByB_Team(businessId, teamId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and teamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_Team(
		long businessId, long teamId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().findByB_Team(
			businessId, teamId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and teamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_Team(
		long businessId, long teamId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_Team(
			businessId, teamId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByB_Team_First(
			long businessId, long teamId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_Team_First(
			businessId, teamId, orderByComparator);
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByB_Team_First(
		long businessId, long teamId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByB_Team_First(
			businessId, teamId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByB_Team_Last(
			long businessId, long teamId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_Team_Last(
			businessId, teamId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByB_Team_Last(
		long businessId, long teamId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByB_Team_Last(
			businessId, teamId, orderByComparator);
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where businessId = &#63; and teamId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	public static ResourceEntry[] findByB_Team_PrevAndNext(
			long resourceId, long businessId, long teamId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_Team_PrevAndNext(
			resourceId, businessId, teamId, orderByComparator);
	}

	/**
	 * Removes all the resource entries where businessId = &#63; and teamId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 */
	public static void removeByB_Team(long businessId, long teamId) {
		getPersistence().removeByB_Team(businessId, teamId);
	}

	/**
	 * Returns the number of resource entries where businessId = &#63; and teamId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param teamId the team ID
	 * @return the number of matching resource entries
	 */
	public static int countByB_Team(long businessId, long teamId) {
		return getPersistence().countByB_Team(businessId, teamId);
	}

	/**
	 * Returns all the resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @return the matching resource entries
	 */
	public static List<ResourceEntry> findByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId) {

		return getPersistence().findByB_W_PH_P(
			businessId, workId, phaseId, projectId);
	}

	/**
	 * Returns a range of all the resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId, int start,
		int end) {

		return getPersistence().findByB_W_PH_P(
			businessId, workId, phaseId, projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId, int start,
		int end, OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().findByB_W_PH_P(
			businessId, workId, phaseId, projectId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource entries
	 */
	public static List<ResourceEntry> findByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId, int start,
		int end, OrderByComparator<ResourceEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_W_PH_P(
			businessId, workId, phaseId, projectId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByB_W_PH_P_First(
			long businessId, Long workId, Long phaseId, Long projectId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_W_PH_P_First(
			businessId, workId, phaseId, projectId, orderByComparator);
	}

	/**
	 * Returns the first resource entry in the ordered set where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByB_W_PH_P_First(
		long businessId, Long workId, Long phaseId, Long projectId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByB_W_PH_P_First(
			businessId, workId, phaseId, projectId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByB_W_PH_P_Last(
			long businessId, Long workId, Long phaseId, Long projectId,
			OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_W_PH_P_Last(
			businessId, workId, phaseId, projectId, orderByComparator);
	}

	/**
	 * Returns the last resource entry in the ordered set where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByB_W_PH_P_Last(
		long businessId, Long workId, Long phaseId, Long projectId,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().fetchByB_W_PH_P_Last(
			businessId, workId, phaseId, projectId, orderByComparator);
	}

	/**
	 * Returns the resource entries before and after the current resource entry in the ordered set where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param resourceId the primary key of the current resource entry
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	public static ResourceEntry[] findByB_W_PH_P_PrevAndNext(
			long resourceId, long businessId, Long workId, Long phaseId,
			Long projectId, OrderByComparator<ResourceEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByB_W_PH_P_PrevAndNext(
			resourceId, businessId, workId, phaseId, projectId,
			orderByComparator);
	}

	/**
	 * Removes all the resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 */
	public static void removeByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId) {

		getPersistence().removeByB_W_PH_P(
			businessId, workId, phaseId, projectId);
	}

	/**
	 * Returns the number of resource entries where businessId = &#63; and workId = &#63; and phaseId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param phaseId the phase ID
	 * @param projectId the project ID
	 * @return the number of matching resource entries
	 */
	public static int countByB_W_PH_P(
		long businessId, Long workId, Long phaseId, Long projectId) {

		return getPersistence().countByB_W_PH_P(
			businessId, workId, phaseId, projectId);
	}

	/**
	 * Returns the resource entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchResourceEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching resource entry
	 * @throws NoSuchResourceEntryException if a matching resource entry could not be found
	 */
	public static ResourceEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	public static ResourceEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the resource entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the resource entry that was removed
	 */
	public static ResourceEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of resource entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching resource entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the resource entry in the entity cache if it is enabled.
	 *
	 * @param resourceEntry the resource entry
	 */
	public static void cacheResult(ResourceEntry resourceEntry) {
		getPersistence().cacheResult(resourceEntry);
	}

	/**
	 * Caches the resource entries in the entity cache if it is enabled.
	 *
	 * @param resourceEntries the resource entries
	 */
	public static void cacheResult(List<ResourceEntry> resourceEntries) {
		getPersistence().cacheResult(resourceEntries);
	}

	/**
	 * Creates a new resource entry with the primary key. Does not add the resource entry to the database.
	 *
	 * @param resourceId the primary key for the new resource entry
	 * @return the new resource entry
	 */
	public static ResourceEntry create(long resourceId) {
		return getPersistence().create(resourceId);
	}

	/**
	 * Removes the resource entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry that was removed
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	public static ResourceEntry remove(long resourceId)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().remove(resourceId);
	}

	public static ResourceEntry updateImpl(ResourceEntry resourceEntry) {
		return getPersistence().updateImpl(resourceEntry);
	}

	/**
	 * Returns the resource entry with the primary key or throws a <code>NoSuchResourceEntryException</code> if it could not be found.
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry
	 * @throws NoSuchResourceEntryException if a resource entry with the primary key could not be found
	 */
	public static ResourceEntry findByPrimaryKey(long resourceId)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceEntryException {

		return getPersistence().findByPrimaryKey(resourceId);
	}

	/**
	 * Returns the resource entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry, or <code>null</code> if a resource entry with the primary key could not be found
	 */
	public static ResourceEntry fetchByPrimaryKey(long resourceId) {
		return getPersistence().fetchByPrimaryKey(resourceId);
	}

	/**
	 * Returns all the resource entries.
	 *
	 * @return the resource entries
	 */
	public static List<ResourceEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the resource entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of resource entries
	 */
	public static List<ResourceEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the resource entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resource entries
	 */
	public static List<ResourceEntry> findAll(
		int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of resource entries
	 */
	public static List<ResourceEntry> findAll(
		int start, int end, OrderByComparator<ResourceEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the resource entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of resource entries.
	 *
	 * @return the number of resource entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ResourceEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ResourceEntryPersistence _persistence;

}