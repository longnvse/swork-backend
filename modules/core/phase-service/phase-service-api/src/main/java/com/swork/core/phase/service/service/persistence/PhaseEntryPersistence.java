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

package com.swork.core.phase.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.core.phase.service.exception.NoSuchPhaseEntryException;
import com.swork.core.phase.service.model.PhaseEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the phase entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhaseEntryUtil
 * @generated
 */
@ProviderType
public interface PhaseEntryPersistence extends BasePersistence<PhaseEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhaseEntryUtil} to access the phase entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the phase entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching phase entries
	 */
	public java.util.List<PhaseEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the phase entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of matching phase entries
	 */
	public java.util.List<PhaseEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phase entries
	 */
	public java.util.List<PhaseEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phase entries
	 */
	public java.util.List<PhaseEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public PhaseEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
				orderByComparator)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the first phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator);

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public PhaseEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
				orderByComparator)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator);

	/**
	 * Returns the phase entries before and after the current phase entry in the ordered set where uuid = &#63;.
	 *
	 * @param phaseId the primary key of the current phase entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	public PhaseEntry[] findByUuid_PrevAndNext(
			long phaseId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
				orderByComparator)
		throws NoSuchPhaseEntryException;

	/**
	 * Removes all the phase entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of phase entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching phase entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the phase entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public PhaseEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the phase entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the phase entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the phase entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the phase entry that was removed
	 */
	public PhaseEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the number of phase entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching phase entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching phase entries
	 */
	public java.util.List<PhaseEntry> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of matching phase entries
	 */
	public java.util.List<PhaseEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phase entries
	 */
	public java.util.List<PhaseEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phase entries
	 */
	public java.util.List<PhaseEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public PhaseEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
				orderByComparator)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the first phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator);

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public PhaseEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
				orderByComparator)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the last phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator);

	/**
	 * Returns the phase entries before and after the current phase entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param phaseId the primary key of the current phase entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	public PhaseEntry[] findByUuid_C_PrevAndNext(
			long phaseId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
				orderByComparator)
		throws NoSuchPhaseEntryException;

	/**
	 * Removes all the phase entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of phase entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching phase entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching phase entries
	 */
	public java.util.List<PhaseEntry> findByP_(long businessId, long projectId);

	/**
	 * Returns a range of all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of matching phase entries
	 */
	public java.util.List<PhaseEntry> findByP_(
		long businessId, long projectId, int start, int end);

	/**
	 * Returns an ordered range of all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phase entries
	 */
	public java.util.List<PhaseEntry> findByP_(
		long businessId, long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phase entries
	 */
	public java.util.List<PhaseEntry> findByP_(
		long businessId, long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public PhaseEntry findByP__First(
			long businessId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
				orderByComparator)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the first phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByP__First(
		long businessId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator);

	/**
	 * Returns the last phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public PhaseEntry findByP__Last(
			long businessId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
				orderByComparator)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the last phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByP__Last(
		long businessId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator);

	/**
	 * Returns the phase entries before and after the current phase entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param phaseId the primary key of the current phase entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	public PhaseEntry[] findByP__PrevAndNext(
			long phaseId, long businessId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
				orderByComparator)
		throws NoSuchPhaseEntryException;

	/**
	 * Removes all the phase entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	public void removeByP_(long businessId, long projectId);

	/**
	 * Returns the number of phase entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching phase entries
	 */
	public int countByP_(long businessId, long projectId);

	/**
	 * Returns the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public PhaseEntry findByB_P_N(
			long businessId, long projectId, String phaseName)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByB_P_N(
		long businessId, long projectId, String phaseName);

	/**
	 * Returns the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByB_P_N(
		long businessId, long projectId, String phaseName,
		boolean useFinderCache);

	/**
	 * Removes the phase entry where businessId = &#63; and projectId = &#63; and phaseName = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the phase entry that was removed
	 */
	public PhaseEntry removeByB_P_N(
			long businessId, long projectId, String phaseName)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the number of phase entries where businessId = &#63; and projectId = &#63; and phaseName = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param phaseName the phase name
	 * @return the number of matching phase entries
	 */
	public int countByB_P_N(long businessId, long projectId, String phaseName);

	/**
	 * Returns the phase entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phase entry
	 * @throws NoSuchPhaseEntryException if a matching phase entry could not be found
	 */
	public PhaseEntry findByC_ERC(long companyId, String externalReferenceCode)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the phase entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the phase entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching phase entry, or <code>null</code> if a matching phase entry could not be found
	 */
	public PhaseEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the phase entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the phase entry that was removed
	 */
	public PhaseEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the number of phase entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching phase entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the phase entry in the entity cache if it is enabled.
	 *
	 * @param phaseEntry the phase entry
	 */
	public void cacheResult(PhaseEntry phaseEntry);

	/**
	 * Caches the phase entries in the entity cache if it is enabled.
	 *
	 * @param phaseEntries the phase entries
	 */
	public void cacheResult(java.util.List<PhaseEntry> phaseEntries);

	/**
	 * Creates a new phase entry with the primary key. Does not add the phase entry to the database.
	 *
	 * @param phaseId the primary key for the new phase entry
	 * @return the new phase entry
	 */
	public PhaseEntry create(long phaseId);

	/**
	 * Removes the phase entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry that was removed
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	public PhaseEntry remove(long phaseId) throws NoSuchPhaseEntryException;

	public PhaseEntry updateImpl(PhaseEntry phaseEntry);

	/**
	 * Returns the phase entry with the primary key or throws a <code>NoSuchPhaseEntryException</code> if it could not be found.
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry
	 * @throws NoSuchPhaseEntryException if a phase entry with the primary key could not be found
	 */
	public PhaseEntry findByPrimaryKey(long phaseId)
		throws NoSuchPhaseEntryException;

	/**
	 * Returns the phase entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phaseId the primary key of the phase entry
	 * @return the phase entry, or <code>null</code> if a phase entry with the primary key could not be found
	 */
	public PhaseEntry fetchByPrimaryKey(long phaseId);

	/**
	 * Returns all the phase entries.
	 *
	 * @return the phase entries
	 */
	public java.util.List<PhaseEntry> findAll();

	/**
	 * Returns a range of all the phase entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @return the range of phase entries
	 */
	public java.util.List<PhaseEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the phase entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phase entries
	 */
	public java.util.List<PhaseEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phase entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase entries
	 * @param end the upper bound of the range of phase entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phase entries
	 */
	public java.util.List<PhaseEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the phase entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of phase entries.
	 *
	 * @return the number of phase entries
	 */
	public int countAll();

}