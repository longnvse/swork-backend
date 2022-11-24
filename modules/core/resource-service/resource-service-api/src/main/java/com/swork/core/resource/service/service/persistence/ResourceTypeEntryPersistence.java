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

import com.swork.core.resource.service.exception.NoSuchResourceTypeEntryException;
import com.swork.core.resource.service.model.ResourceTypeEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the resource type entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceTypeEntryUtil
 * @generated
 */
@ProviderType
public interface ResourceTypeEntryPersistence
	extends BasePersistence<ResourceTypeEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResourceTypeEntryUtil} to access the resource type entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the resource type entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching resource type entries
	 */
	public java.util.List<ResourceTypeEntry> findByUuid(String uuid);

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
	public java.util.List<ResourceTypeEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ResourceTypeEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator);

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
	public java.util.List<ResourceTypeEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
				orderByComparator)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the first resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator);

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
				orderByComparator)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator);

	/**
	 * Returns the resource type entries before and after the current resource type entry in the ordered set where uuid = &#63;.
	 *
	 * @param resourceTypeId the primary key of the current resource type entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource type entry
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	public ResourceTypeEntry[] findByUuid_PrevAndNext(
			long resourceTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
				orderByComparator)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Removes all the resource type entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of resource type entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching resource type entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the resource type entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the resource type entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the resource type entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the resource type entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the resource type entry that was removed
	 */
	public ResourceTypeEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the number of resource type entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching resource type entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching resource type entries
	 */
	public java.util.List<ResourceTypeEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ResourceTypeEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ResourceTypeEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator);

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
	public java.util.List<ResourceTypeEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
				orderByComparator)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the first resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator);

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
				orderByComparator)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the last resource type entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator);

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
	public ResourceTypeEntry[] findByUuid_C_PrevAndNext(
			long resourceTypeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
				orderByComparator)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Removes all the resource type entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of resource type entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching resource type entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the matching resource type entries
	 */
	public java.util.List<ResourceTypeEntry> findByB_PT(
		long businessId, Long parentId);

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
	public java.util.List<ResourceTypeEntry> findByB_PT(
		long businessId, Long parentId, int start, int end);

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
	public java.util.List<ResourceTypeEntry> findByB_PT(
		long businessId, Long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator);

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
	public java.util.List<ResourceTypeEntry> findByB_PT(
		long businessId, Long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry findByB_PT_First(
			long businessId, Long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
				orderByComparator)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the first resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByB_PT_First(
		long businessId, Long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator);

	/**
	 * Returns the last resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry findByB_PT_Last(
			long businessId, Long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
				orderByComparator)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the last resource type entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByB_PT_Last(
		long businessId, Long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator);

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
	public ResourceTypeEntry[] findByB_PT_PrevAndNext(
			long resourceTypeId, long businessId, Long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
				orderByComparator)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Removes all the resource type entries where businessId = &#63; and parentId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 */
	public void removeByB_PT(long businessId, Long parentId);

	/**
	 * Returns the number of resource type entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the number of matching resource type entries
	 */
	public int countByB_PT(long businessId, Long parentId);

	/**
	 * Returns the resource type entry where businessId = &#63; and name = &#63; or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry findByB_N(long businessId, String name)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the resource type entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByB_N(long businessId, String name);

	/**
	 * Returns the resource type entry where businessId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByB_N(
		long businessId, String name, boolean useFinderCache);

	/**
	 * Removes the resource type entry where businessId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the resource type entry that was removed
	 */
	public ResourceTypeEntry removeByB_N(long businessId, String name)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the number of resource type entries where businessId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param name the name
	 * @return the number of matching resource type entries
	 */
	public int countByB_N(long businessId, String name);

	/**
	 * Returns the resource type entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching resource type entry
	 * @throws NoSuchResourceTypeEntryException if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the resource type entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the resource type entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	public ResourceTypeEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the resource type entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the resource type entry that was removed
	 */
	public ResourceTypeEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the number of resource type entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching resource type entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the resource type entry in the entity cache if it is enabled.
	 *
	 * @param resourceTypeEntry the resource type entry
	 */
	public void cacheResult(ResourceTypeEntry resourceTypeEntry);

	/**
	 * Caches the resource type entries in the entity cache if it is enabled.
	 *
	 * @param resourceTypeEntries the resource type entries
	 */
	public void cacheResult(
		java.util.List<ResourceTypeEntry> resourceTypeEntries);

	/**
	 * Creates a new resource type entry with the primary key. Does not add the resource type entry to the database.
	 *
	 * @param resourceTypeId the primary key for the new resource type entry
	 * @return the new resource type entry
	 */
	public ResourceTypeEntry create(long resourceTypeId);

	/**
	 * Removes the resource type entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry that was removed
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	public ResourceTypeEntry remove(long resourceTypeId)
		throws NoSuchResourceTypeEntryException;

	public ResourceTypeEntry updateImpl(ResourceTypeEntry resourceTypeEntry);

	/**
	 * Returns the resource type entry with the primary key or throws a <code>NoSuchResourceTypeEntryException</code> if it could not be found.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry
	 * @throws NoSuchResourceTypeEntryException if a resource type entry with the primary key could not be found
	 */
	public ResourceTypeEntry findByPrimaryKey(long resourceTypeId)
		throws NoSuchResourceTypeEntryException;

	/**
	 * Returns the resource type entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry, or <code>null</code> if a resource type entry with the primary key could not be found
	 */
	public ResourceTypeEntry fetchByPrimaryKey(long resourceTypeId);

	/**
	 * Returns all the resource type entries.
	 *
	 * @return the resource type entries
	 */
	public java.util.List<ResourceTypeEntry> findAll();

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
	public java.util.List<ResourceTypeEntry> findAll(int start, int end);

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
	public java.util.List<ResourceTypeEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator);

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
	public java.util.List<ResourceTypeEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceTypeEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the resource type entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of resource type entries.
	 *
	 * @return the number of resource type entries
	 */
	public int countAll();

}