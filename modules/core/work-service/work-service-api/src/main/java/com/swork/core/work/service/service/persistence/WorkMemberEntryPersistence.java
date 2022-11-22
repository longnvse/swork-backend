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

import com.swork.core.work.service.exception.NoSuchWorkMemberEntryException;
import com.swork.core.work.service.model.WorkMemberEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work member entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkMemberEntryUtil
 * @generated
 */
@ProviderType
public interface WorkMemberEntryPersistence
	extends BasePersistence<WorkMemberEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkMemberEntryUtil} to access the work member entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type);

	/**
	 * Returns a range of all the work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @return the range of matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type, int start, int end);

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	public WorkMemberEntry findByW_MT_T_First(
			long workId, String memberType, String type,
			com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
				orderByComparator)
		throws NoSuchWorkMemberEntryException;

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public WorkMemberEntry fetchByW_MT_T_First(
		long workId, String memberType, String type,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator);

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	public WorkMemberEntry findByW_MT_T_Last(
			long workId, String memberType, String type,
			com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
				orderByComparator)
		throws NoSuchWorkMemberEntryException;

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public WorkMemberEntry fetchByW_MT_T_Last(
		long workId, String memberType, String type,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator);

	/**
	 * Returns the work member entries before and after the current work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workMemberId the primary key of the current work member entry
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work member entry
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	public WorkMemberEntry[] findByW_MT_T_PrevAndNext(
			long workMemberId, long workId, String memberType, String type,
			com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
				orderByComparator)
		throws NoSuchWorkMemberEntryException;

	/**
	 * Removes all the work member entries where workId = &#63; and memberType = &#63; and type = &#63; from the database.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 */
	public void removeByW_MT_T(long workId, String memberType, String type);

	/**
	 * Returns the number of work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the number of matching work member entries
	 */
	public int countByW_MT_T(long workId, String memberType, String type);

	/**
	 * Returns all the work member entries where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @return the matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_T_(long workId, String type);

	/**
	 * Returns a range of all the work member entries where workId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @return the range of matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_T_(
		long workId, String type, int start, int end);

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_T_(
		long workId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_T_(
		long workId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	public WorkMemberEntry findByW_T__First(
			long workId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
				orderByComparator)
		throws NoSuchWorkMemberEntryException;

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public WorkMemberEntry fetchByW_T__First(
		long workId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator);

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	public WorkMemberEntry findByW_T__Last(
			long workId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
				orderByComparator)
		throws NoSuchWorkMemberEntryException;

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public WorkMemberEntry fetchByW_T__Last(
		long workId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator);

	/**
	 * Returns the work member entries before and after the current work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workMemberId the primary key of the current work member entry
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work member entry
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	public WorkMemberEntry[] findByW_T__PrevAndNext(
			long workMemberId, long workId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
				orderByComparator)
		throws NoSuchWorkMemberEntryException;

	/**
	 * Removes all the work member entries where workId = &#63; and type = &#63; from the database.
	 *
	 * @param workId the work ID
	 * @param type the type
	 */
	public void removeByW_T_(long workId, String type);

	/**
	 * Returns the number of work member entries where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @return the number of matching work member entries
	 */
	public int countByW_T_(long workId, String type);

	/**
	 * Returns all the work member entries where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @return the matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_(long workId);

	/**
	 * Returns a range of all the work member entries where workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @return the range of matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_(
		long workId, int start, int end);

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_(
		long workId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work member entries where workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param workId the work ID
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work member entries
	 */
	public java.util.List<WorkMemberEntry> findByW_(
		long workId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	public WorkMemberEntry findByW__First(
			long workId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
				orderByComparator)
		throws NoSuchWorkMemberEntryException;

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public WorkMemberEntry fetchByW__First(
		long workId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator);

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	public WorkMemberEntry findByW__Last(
			long workId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
				orderByComparator)
		throws NoSuchWorkMemberEntryException;

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public WorkMemberEntry fetchByW__Last(
		long workId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator);

	/**
	 * Returns the work member entries before and after the current work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workMemberId the primary key of the current work member entry
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work member entry
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	public WorkMemberEntry[] findByW__PrevAndNext(
			long workMemberId, long workId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
				orderByComparator)
		throws NoSuchWorkMemberEntryException;

	/**
	 * Removes all the work member entries where workId = &#63; from the database.
	 *
	 * @param workId the work ID
	 */
	public void removeByW_(long workId);

	/**
	 * Returns the number of work member entries where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @return the number of matching work member entries
	 */
	public int countByW_(long workId);

	/**
	 * Caches the work member entry in the entity cache if it is enabled.
	 *
	 * @param workMemberEntry the work member entry
	 */
	public void cacheResult(WorkMemberEntry workMemberEntry);

	/**
	 * Caches the work member entries in the entity cache if it is enabled.
	 *
	 * @param workMemberEntries the work member entries
	 */
	public void cacheResult(java.util.List<WorkMemberEntry> workMemberEntries);

	/**
	 * Creates a new work member entry with the primary key. Does not add the work member entry to the database.
	 *
	 * @param workMemberId the primary key for the new work member entry
	 * @return the new work member entry
	 */
	public WorkMemberEntry create(long workMemberId);

	/**
	 * Removes the work member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workMemberId the primary key of the work member entry
	 * @return the work member entry that was removed
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	public WorkMemberEntry remove(long workMemberId)
		throws NoSuchWorkMemberEntryException;

	public WorkMemberEntry updateImpl(WorkMemberEntry workMemberEntry);

	/**
	 * Returns the work member entry with the primary key or throws a <code>NoSuchWorkMemberEntryException</code> if it could not be found.
	 *
	 * @param workMemberId the primary key of the work member entry
	 * @return the work member entry
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	public WorkMemberEntry findByPrimaryKey(long workMemberId)
		throws NoSuchWorkMemberEntryException;

	/**
	 * Returns the work member entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workMemberId the primary key of the work member entry
	 * @return the work member entry, or <code>null</code> if a work member entry with the primary key could not be found
	 */
	public WorkMemberEntry fetchByPrimaryKey(long workMemberId);

	/**
	 * Returns all the work member entries.
	 *
	 * @return the work member entries
	 */
	public java.util.List<WorkMemberEntry> findAll();

	/**
	 * Returns a range of all the work member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @return the range of work member entries
	 */
	public java.util.List<WorkMemberEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work member entries
	 */
	public java.util.List<WorkMemberEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work member entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkMemberEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work member entries
	 * @param end the upper bound of the range of work member entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work member entries
	 */
	public java.util.List<WorkMemberEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkMemberEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work member entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work member entries.
	 *
	 * @return the number of work member entries
	 */
	public int countAll();

}