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

package com.swork.core.work.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.core.work.service.exception.NoSuchWorkEntryException;
import com.swork.core.work.service.model.WorkEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkEntryUtil
 * @generated
 */
@ProviderType
public interface WorkEntryPersistence extends BasePersistence<WorkEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkEntryUtil} to access the work entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work entries
	 */
	public java.util.List<WorkEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the work entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public java.util.List<WorkEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the first work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where uuid = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public WorkEntry[] findByUuid_PrevAndNext(
			long workId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Removes all the work entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of work entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the work entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the work entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the work entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the work entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work entry that was removed
	 */
	public WorkEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the number of work entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work entries
	 */
	public java.util.List<WorkEntry> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public java.util.List<WorkEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the first work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the last work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public WorkEntry[] findByUuid_C_PrevAndNext(
			long workId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Removes all the work entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of work entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching work entries
	 */
	public java.util.List<WorkEntry> findByB_P(long businessId, Long projectId);

	/**
	 * Returns a range of all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_P(
		long businessId, Long projectId, int start, int end);

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_P(
		long businessId, Long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByB_P_First(
			long businessId, Long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_P_First(
		long businessId, Long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByB_P_Last(
			long businessId, Long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_P_Last(
		long businessId, Long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public WorkEntry[] findByB_P_PrevAndNext(
			long workId, long businessId, Long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Removes all the work entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	public void removeByB_P(long businessId, Long projectId);

	/**
	 * Returns the number of work entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching work entries
	 */
	public int countByB_P(long businessId, Long projectId);

	/**
	 * Returns all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the matching work entries
	 */
	public java.util.List<WorkEntry> findByB_PH(long businessId, Long phaseId);

	/**
	 * Returns a range of all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end);

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_PH(
		long businessId, Long phaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByB_PH_First(
			long businessId, Long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_PH_First(
		long businessId, Long phaseId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByB_PH_Last(
			long businessId, Long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_PH_Last(
		long businessId, Long phaseId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public WorkEntry[] findByB_PH_PrevAndNext(
			long workId, long businessId, Long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Removes all the work entries where businessId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 */
	public void removeByB_PH(long businessId, Long phaseId);

	/**
	 * Returns the number of work entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the number of matching work entries
	 */
	public int countByB_PH(long businessId, Long phaseId);

	/**
	 * Returns all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the matching work entries
	 */
	public java.util.List<WorkEntry> findByB_PID(
		long businessId, Long parentId);

	/**
	 * Returns a range of all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_PID(
		long businessId, Long parentId, int start, int end);

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_PID(
		long businessId, Long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_PID(
		long businessId, Long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByB_PID_First(
			long businessId, Long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_PID_First(
		long businessId, Long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByB_PID_Last(
			long businessId, Long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_PID_Last(
		long businessId, Long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and parentId = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public WorkEntry[] findByB_PID_PrevAndNext(
			long workId, long businessId, Long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Removes all the work entries where businessId = &#63; and parentId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 */
	public void removeByB_PID(long businessId, Long parentId);

	/**
	 * Returns the number of work entries where businessId = &#63; and parentId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentId the parent ID
	 * @return the number of matching work entries
	 */
	public int countByB_PID(long businessId, Long parentId);

	/**
	 * Returns all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @return the matching work entries
	 */
	public java.util.List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode);

	/**
	 * Returns a range of all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode, int start, int end);

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work entries
	 */
	public java.util.List<WorkEntry> findByB_P_C(
		long businessId, String parentReferenceCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByB_P_C_First(
			long businessId, String parentReferenceCode,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the first work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_P_C_First(
		long businessId, String parentReferenceCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByB_P_C_Last(
			long businessId, String parentReferenceCode,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the last work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_P_C_Last(
		long businessId, String parentReferenceCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns the work entries before and after the current work entry in the ordered set where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param workId the primary key of the current work entry
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public WorkEntry[] findByB_P_C_PrevAndNext(
			long workId, long businessId, String parentReferenceCode,
			com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
				orderByComparator)
		throws NoSuchWorkEntryException;

	/**
	 * Removes all the work entries where businessId = &#63; and parentReferenceCode = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 */
	public void removeByB_P_C(long businessId, String parentReferenceCode);

	/**
	 * Returns the number of work entries where businessId = &#63; and parentReferenceCode = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @return the number of matching work entries
	 */
	public int countByB_P_C(long businessId, String parentReferenceCode);

	/**
	 * Returns the work entry where businessId = &#63; and projectId = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByB_P_N(long businessId, Long projectId, String name)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the work entry where businessId = &#63; and projectId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_P_N(long businessId, Long projectId, String name);

	/**
	 * Returns the work entry where businessId = &#63; and projectId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_P_N(
		long businessId, Long projectId, String name, boolean useFinderCache);

	/**
	 * Removes the work entry where businessId = &#63; and projectId = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the work entry that was removed
	 */
	public WorkEntry removeByB_P_N(long businessId, Long projectId, String name)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the number of work entries where businessId = &#63; and projectId = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param name the name
	 * @return the number of matching work entries
	 */
	public int countByB_P_N(long businessId, Long projectId, String name);

	/**
	 * Returns the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByB_P_C_N(
			long businessId, String parentReferenceCode, String name)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_P_C_N(
		long businessId, String parentReferenceCode, String name);

	/**
	 * Returns the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByB_P_C_N(
		long businessId, String parentReferenceCode, String name,
		boolean useFinderCache);

	/**
	 * Removes the work entry where businessId = &#63; and parentReferenceCode = &#63; and name = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the work entry that was removed
	 */
	public WorkEntry removeByB_P_C_N(
			long businessId, String parentReferenceCode, String name)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the number of work entries where businessId = &#63; and parentReferenceCode = &#63; and name = &#63;.
	 *
	 * @param businessId the business ID
	 * @param parentReferenceCode the parent reference code
	 * @param name the name
	 * @return the number of matching work entries
	 */
	public int countByB_P_C_N(
		long businessId, String parentReferenceCode, String name);

	/**
	 * Returns the work entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching work entry
	 * @throws NoSuchWorkEntryException if a matching work entry could not be found
	 */
	public WorkEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the work entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Returns the work entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	public WorkEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the work entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the work entry that was removed
	 */
	public WorkEntry removeByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the number of work entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching work entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the work entry in the entity cache if it is enabled.
	 *
	 * @param workEntry the work entry
	 */
	public void cacheResult(WorkEntry workEntry);

	/**
	 * Caches the work entries in the entity cache if it is enabled.
	 *
	 * @param workEntries the work entries
	 */
	public void cacheResult(java.util.List<WorkEntry> workEntries);

	/**
	 * Creates a new work entry with the primary key. Does not add the work entry to the database.
	 *
	 * @param workId the primary key for the new work entry
	 * @return the new work entry
	 */
	public WorkEntry create(long workId);

	/**
	 * Removes the work entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry that was removed
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public WorkEntry remove(long workId) throws NoSuchWorkEntryException;

	public WorkEntry updateImpl(WorkEntry workEntry);

	/**
	 * Returns the work entry with the primary key or throws a <code>NoSuchWorkEntryException</code> if it could not be found.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry
	 * @throws NoSuchWorkEntryException if a work entry with the primary key could not be found
	 */
	public WorkEntry findByPrimaryKey(long workId)
		throws NoSuchWorkEntryException;

	/**
	 * Returns the work entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry, or <code>null</code> if a work entry with the primary key could not be found
	 */
	public WorkEntry fetchByPrimaryKey(long workId);

	/**
	 * Returns all the work entries.
	 *
	 * @return the work entries
	 */
	public java.util.List<WorkEntry> findAll();

	/**
	 * Returns a range of all the work entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of work entries
	 */
	public java.util.List<WorkEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work entries
	 */
	public java.util.List<WorkEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work entries
	 */
	public java.util.List<WorkEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work entries.
	 *
	 * @return the number of work entries
	 */
	public int countAll();

}