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

import com.swork.core.resource.service.model.ResourceTypeEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the resource type entry service. This utility wraps <code>com.swork.core.resource.service.service.persistence.impl.ResourceTypeEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceTypeEntryPersistence
 * @generated
 */
public class ResourceTypeEntryUtil {

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
	public static void clearCache(ResourceTypeEntry resourceTypeEntry) {
		getPersistence().clearCache(resourceTypeEntry);
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
	public static Map<Serializable, ResourceTypeEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ResourceTypeEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ResourceTypeEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ResourceTypeEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ResourceTypeEntry update(
		ResourceTypeEntry resourceTypeEntry) {

		return getPersistence().update(resourceTypeEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ResourceTypeEntry update(
		ResourceTypeEntry resourceTypeEntry, ServiceContext serviceContext) {

		return getPersistence().update(resourceTypeEntry, serviceContext);
	}

	/**
	 * Returns all the resource type entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the resource type entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @return the range of matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the resource type entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource type entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry findByUuid_First(
			String uuid, OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByUuid_First(
		String uuid, OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry findByUuid_Last(
			String uuid, OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByUuid_Last(
		String uuid, OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the resource type entries before and after the current resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param resourceTypeId the primary key of the current resource type entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource type entry
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	public static ResourceTypeEntry[] findByUuid_PrevAndNext(
			long resourceTypeId, String uuid,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			resourceTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the resource type entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of resource type entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching resource type entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the resource type entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the resource type entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the resource type entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the resource type entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the resource type entry that was removed
	 */
	public static ResourceTypeEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of resource type entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching resource type entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @return the range of matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the resource type entries before and after the current resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param resourceTypeId the primary key of the current resource type entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource type entry
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	public static ResourceTypeEntry[] findByUuid_C_PrevAndNext(
			long resourceTypeId, String uuid, long companyId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			resourceTypeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the resource type entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching resource type entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByB_PT(
		long businessId, Long parentId) {

		return getPersistence().findByB_PT(businessId, parentId);
	}

	/**
	 * Returns a range of all the resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @return the range of matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByB_PT(
		long businessId, Long parentId, int start, int end) {

		return getPersistence().findByB_PT(businessId, parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByB_PT(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getPersistence().findByB_PT(
			businessId, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource type entries
	 */
	public static List<ResourceTypeEntry> findByB_PT(
		long businessId, Long parentId, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_PT(
			businessId, parentId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry findByB_PT_First(
			long businessId, Long parentId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByB_PT_First(
			businessId, parentId, orderByComparator);
	}

	/**
	 * Returns the first resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByB_PT_First(
		long businessId, Long parentId,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getPersistence().fetchByB_PT_First(
			businessId, parentId, orderByComparator);
	}

	/**
	 * Returns the last resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry findByB_PT_Last(
			long businessId, Long parentId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByB_PT_Last(
			businessId, parentId, orderByComparator);
	}

	/**
	 * Returns the last resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByB_PT_Last(
		long businessId, Long parentId,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getPersistence().fetchByB_PT_Last(
			businessId, parentId, orderByComparator);
	}

	/**
	 * Returns the resource type entries before and after the current resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param resourceTypeId the primary key of the current resource type entry
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource type entry
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	public static ResourceTypeEntry[] findByB_PT_PrevAndNext(
			long resourceTypeId, long businessId, Long parentId,
			OrderByComparator<ResourceTypeEntry> orderByComparator)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByB_PT_PrevAndNext(
			resourceTypeId, businessId, parentId, orderByComparator);
	}

	/**
	 * Removes all the resource type entries where businessId = &#63; and parentId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 */
	public static void removeByB_PT(long businessId, Long parentId) {
		getPersistence().removeByB_PT(businessId, parentId);
	}

	/**
	 * Returns the number of resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the number of matching resource type entries
	 */
	public static int countByB_PT(long businessId, Long parentId) {
		return getPersistence().countByB_PT(businessId, parentId);
	}

	/**
	 * Returns the resource type entry where businessId = &#63; and name = &#63; or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry findByB_N(long businessId, String name)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByB_N(businessId, name);
	}

	/**
	 * Returns the resource type entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByB_N(long businessId, String name) {
		return getPersistence().fetchByB_N(businessId, name);
	}

	/**
	 * Returns the resource type entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByB_N(
		long businessId, String name, boolean useFinderCache) {

		return getPersistence().fetchByB_N(businessId, name, useFinderCache);
	}

	/**
	 * Removes the resource type entry where businessId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the resource type entry that was removed
	 */
	public static ResourceTypeEntry removeByB_N(long businessId, String name)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().removeByB_N(businessId, name);
	}

	/**
	 * Returns the number of resource type entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the number of matching resource type entries
	 */
	public static int countByB_N(long businessId, String name) {
		return getPersistence().countByB_N(businessId, name);
	}

	/**
	 * Returns the resource type entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource type entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource type entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public static ResourceTypeEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the resource type entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the resource type entry that was removed
	 */
	public static ResourceTypeEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of resource type entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching resource type entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the resource type entry in the entity cache if it is enabled.
	 *
	 * @param resourceTypeEntry the resource type entry
	 */
	public static void cacheResult(ResourceTypeEntry resourceTypeEntry) {
		getPersistence().cacheResult(resourceTypeEntry);
	}

	/**
	 * Caches the resource type entries in the entity cache if it is enabled.
	 *
	 * @param resourceTypeEntries the resource type entries
	 */
	public static void cacheResult(
		List<ResourceTypeEntry> resourceTypeEntries) {

		getPersistence().cacheResult(resourceTypeEntries);
	}

	/**
	 * Creates a new resource type entry with the primary key. Does not add the resource type entry to the database.
	 *
	 * @param resourceTypeId the primary key for the new resource type entry
	 * @return the new resource type entry
	 */
	public static ResourceTypeEntry create(long resourceTypeId) {
		return getPersistence().create(resourceTypeId);
	}

	/**
	 * Removes the resource type entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry that was removed
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	public static ResourceTypeEntry remove(long resourceTypeId)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().remove(resourceTypeId);
	}

	public static ResourceTypeEntry updateImpl(
		ResourceTypeEntry resourceTypeEntry) {

		return getPersistence().updateImpl(resourceTypeEntry);
	}

	/**
	 * Returns the resource type entry with the primary key or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	public static ResourceTypeEntry findByPrimaryKey(long resourceTypeId)
		throws com.swork.core.resource.service.exception.
			NoSuchResourceTypeEntryException {

		return getPersistence().findByPrimaryKey(resourceTypeId);
	}

	/**
	 * Returns the resource type entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry, or <code>null</code> if a resource type entry with the primary key could not be found
	 */
	public static ResourceTypeEntry fetchByPrimaryKey(long resourceTypeId) {
		return getPersistence().fetchByPrimaryKey(resourceTypeId);
	}

	/**
	 * Returns all the resource type entries.
	 *
	 * @return the resource type entries
	 */
	public static List<ResourceTypeEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the resource type entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @return the range of resource type entries
	 */
	public static List<ResourceTypeEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the resource type entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resource type entries
	 */
	public static List<ResourceTypeEntry> findAll(
		int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource type entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of resource type entries
	 */
	public static List<ResourceTypeEntry> findAll(
		int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the resource type entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of resource type entries.
	 *
	 * @return the number of resource type entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ResourceTypeEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ResourceTypeEntryPersistence _persistence;

}