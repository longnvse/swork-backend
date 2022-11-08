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

import com.swork.core.phase.service.exception.NoSuchPhaseManageEntryException;
import com.swork.core.phase.service.model.PhaseManageEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the phase manage entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhaseManageEntryUtil
 * @generated
 */
@ProviderType
public interface PhaseManageEntryPersistence
	extends BasePersistence<PhaseManageEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhaseManageEntryUtil} to access the phase manage entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the phase manage entries where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @return the matching phase manage entries
	 */
	public java.util.List<PhaseManageEntry> findByP_(long phaseId);

	/**
	 * Returns a range of all the phase manage entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @return the range of matching phase manage entries
	 */
	public java.util.List<PhaseManageEntry> findByP_(
		long phaseId, int start, int end);

	/**
	 * Returns an ordered range of all the phase manage entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phase manage entries
	 */
	public java.util.List<PhaseManageEntry> findByP_(
		long phaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseManageEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phase manage entries where phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phase manage entries
	 */
	public java.util.List<PhaseManageEntry> findByP_(
		long phaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseManageEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a matching phase manage entry could not be found
	 */
	public PhaseManageEntry findByP__First(
			long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseManageEntry>
				orderByComparator)
		throws NoSuchPhaseManageEntryException;

	/**
	 * Returns the first phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase manage entry, or <code>null</code> if a matching phase manage entry could not be found
	 */
	public PhaseManageEntry fetchByP__First(
		long phaseId,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseManageEntry>
			orderByComparator);

	/**
	 * Returns the last phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a matching phase manage entry could not be found
	 */
	public PhaseManageEntry findByP__Last(
			long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseManageEntry>
				orderByComparator)
		throws NoSuchPhaseManageEntryException;

	/**
	 * Returns the last phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase manage entry, or <code>null</code> if a matching phase manage entry could not be found
	 */
	public PhaseManageEntry fetchByP__Last(
		long phaseId,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseManageEntry>
			orderByComparator);

	/**
	 * Returns the phase manage entries before and after the current phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseManageId the primary key of the current phase manage entry
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a phase manage entry with the primary key could not be found
	 */
	public PhaseManageEntry[] findByP__PrevAndNext(
			long phaseManageId, long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<PhaseManageEntry>
				orderByComparator)
		throws NoSuchPhaseManageEntryException;

	/**
	 * Removes all the phase manage entries where phaseId = &#63; from the database.
	 *
	 * @param phaseId the phase ID
	 */
	public void removeByP_(long phaseId);

	/**
	 * Returns the number of phase manage entries where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @return the number of matching phase manage entries
	 */
	public int countByP_(long phaseId);

	/**
	 * Caches the phase manage entry in the entity cache if it is enabled.
	 *
	 * @param phaseManageEntry the phase manage entry
	 */
	public void cacheResult(PhaseManageEntry phaseManageEntry);

	/**
	 * Caches the phase manage entries in the entity cache if it is enabled.
	 *
	 * @param phaseManageEntries the phase manage entries
	 */
	public void cacheResult(
		java.util.List<PhaseManageEntry> phaseManageEntries);

	/**
	 * Creates a new phase manage entry with the primary key. Does not add the phase manage entry to the database.
	 *
	 * @param phaseManageId the primary key for the new phase manage entry
	 * @return the new phase manage entry
	 */
	public PhaseManageEntry create(long phaseManageId);

	/**
	 * Removes the phase manage entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry that was removed
	 * @throws NoSuchPhaseManageEntryException if a phase manage entry with the primary key could not be found
	 */
	public PhaseManageEntry remove(long phaseManageId)
		throws NoSuchPhaseManageEntryException;

	public PhaseManageEntry updateImpl(PhaseManageEntry phaseManageEntry);

	/**
	 * Returns the phase manage entry with the primary key or throws a <code>NoSuchPhaseManageEntryException</code> if it could not be found.
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a phase manage entry with the primary key could not be found
	 */
	public PhaseManageEntry findByPrimaryKey(long phaseManageId)
		throws NoSuchPhaseManageEntryException;

	/**
	 * Returns the phase manage entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry, or <code>null</code> if a phase manage entry with the primary key could not be found
	 */
	public PhaseManageEntry fetchByPrimaryKey(long phaseManageId);

	/**
	 * Returns all the phase manage entries.
	 *
	 * @return the phase manage entries
	 */
	public java.util.List<PhaseManageEntry> findAll();

	/**
	 * Returns a range of all the phase manage entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @return the range of phase manage entries
	 */
	public java.util.List<PhaseManageEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the phase manage entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phase manage entries
	 */
	public java.util.List<PhaseManageEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseManageEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phase manage entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhaseManageEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phase manage entries
	 * @param end the upper bound of the range of phase manage entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phase manage entries
	 */
	public java.util.List<PhaseManageEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhaseManageEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the phase manage entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of phase manage entries.
	 *
	 * @return the number of phase manage entries
	 */
	public int countAll();

}