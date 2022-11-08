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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.core.phase.service.model.PhaseManageEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the phase manage entry service. This utility wraps <code>com.swork.core.phase.service.service.persistence.impl.PhaseManageEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhaseManageEntryPersistence
 * @generated
 */
public class PhaseManageEntryUtil {

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
	public static void clearCache(PhaseManageEntry phaseManageEntry) {
		getPersistence().clearCache(phaseManageEntry);
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
	public static Map<Serializable, PhaseManageEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PhaseManageEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhaseManageEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhaseManageEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PhaseManageEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PhaseManageEntry update(PhaseManageEntry phaseManageEntry) {
		return getPersistence().update(phaseManageEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PhaseManageEntry update(
		PhaseManageEntry phaseManageEntry, ServiceContext serviceContext) {

		return getPersistence().update(phaseManageEntry, serviceContext);
	}

	/**
	 * Returns all the phase manage entries where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @return the matching phase manage entries
	 */
	public static List<PhaseManageEntry> findByP_(long phaseId) {
		return getPersistence().findByP_(phaseId);
	}

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
	public static List<PhaseManageEntry> findByP_(
		long phaseId, int start, int end) {

		return getPersistence().findByP_(phaseId, start, end);
	}

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
	public static List<PhaseManageEntry> findByP_(
		long phaseId, int start, int end,
		OrderByComparator<PhaseManageEntry> orderByComparator) {

		return getPersistence().findByP_(
			phaseId, start, end, orderByComparator);
	}

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
	public static List<PhaseManageEntry> findByP_(
		long phaseId, int start, int end,
		OrderByComparator<PhaseManageEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_(
			phaseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a matching phase manage entry could not be found
	 */
	public static PhaseManageEntry findByP__First(
			long phaseId, OrderByComparator<PhaseManageEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseManageEntryException {

		return getPersistence().findByP__First(phaseId, orderByComparator);
	}

	/**
	 * Returns the first phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phase manage entry, or <code>null</code> if a matching phase manage entry could not be found
	 */
	public static PhaseManageEntry fetchByP__First(
		long phaseId, OrderByComparator<PhaseManageEntry> orderByComparator) {

		return getPersistence().fetchByP__First(phaseId, orderByComparator);
	}

	/**
	 * Returns the last phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a matching phase manage entry could not be found
	 */
	public static PhaseManageEntry findByP__Last(
			long phaseId, OrderByComparator<PhaseManageEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseManageEntryException {

		return getPersistence().findByP__Last(phaseId, orderByComparator);
	}

	/**
	 * Returns the last phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phase manage entry, or <code>null</code> if a matching phase manage entry could not be found
	 */
	public static PhaseManageEntry fetchByP__Last(
		long phaseId, OrderByComparator<PhaseManageEntry> orderByComparator) {

		return getPersistence().fetchByP__Last(phaseId, orderByComparator);
	}

	/**
	 * Returns the phase manage entries before and after the current phase manage entry in the ordered set where phaseId = &#63;.
	 *
	 * @param phaseManageId the primary key of the current phase manage entry
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a phase manage entry with the primary key could not be found
	 */
	public static PhaseManageEntry[] findByP__PrevAndNext(
			long phaseManageId, long phaseId,
			OrderByComparator<PhaseManageEntry> orderByComparator)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseManageEntryException {

		return getPersistence().findByP__PrevAndNext(
			phaseManageId, phaseId, orderByComparator);
	}

	/**
	 * Removes all the phase manage entries where phaseId = &#63; from the database.
	 *
	 * @param phaseId the phase ID
	 */
	public static void removeByP_(long phaseId) {
		getPersistence().removeByP_(phaseId);
	}

	/**
	 * Returns the number of phase manage entries where phaseId = &#63;.
	 *
	 * @param phaseId the phase ID
	 * @return the number of matching phase manage entries
	 */
	public static int countByP_(long phaseId) {
		return getPersistence().countByP_(phaseId);
	}

	/**
	 * Caches the phase manage entry in the entity cache if it is enabled.
	 *
	 * @param phaseManageEntry the phase manage entry
	 */
	public static void cacheResult(PhaseManageEntry phaseManageEntry) {
		getPersistence().cacheResult(phaseManageEntry);
	}

	/**
	 * Caches the phase manage entries in the entity cache if it is enabled.
	 *
	 * @param phaseManageEntries the phase manage entries
	 */
	public static void cacheResult(List<PhaseManageEntry> phaseManageEntries) {
		getPersistence().cacheResult(phaseManageEntries);
	}

	/**
	 * Creates a new phase manage entry with the primary key. Does not add the phase manage entry to the database.
	 *
	 * @param phaseManageId the primary key for the new phase manage entry
	 * @return the new phase manage entry
	 */
	public static PhaseManageEntry create(long phaseManageId) {
		return getPersistence().create(phaseManageId);
	}

	/**
	 * Removes the phase manage entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry that was removed
	 * @throws NoSuchPhaseManageEntryException if a phase manage entry with the primary key could not be found
	 */
	public static PhaseManageEntry remove(long phaseManageId)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseManageEntryException {

		return getPersistence().remove(phaseManageId);
	}

	public static PhaseManageEntry updateImpl(
		PhaseManageEntry phaseManageEntry) {

		return getPersistence().updateImpl(phaseManageEntry);
	}

	/**
	 * Returns the phase manage entry with the primary key or throws a <code>NoSuchPhaseManageEntryException</code> if it could not be found.
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry
	 * @throws NoSuchPhaseManageEntryException if a phase manage entry with the primary key could not be found
	 */
	public static PhaseManageEntry findByPrimaryKey(long phaseManageId)
		throws com.swork.core.phase.service.exception.
			NoSuchPhaseManageEntryException {

		return getPersistence().findByPrimaryKey(phaseManageId);
	}

	/**
	 * Returns the phase manage entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phaseManageId the primary key of the phase manage entry
	 * @return the phase manage entry, or <code>null</code> if a phase manage entry with the primary key could not be found
	 */
	public static PhaseManageEntry fetchByPrimaryKey(long phaseManageId) {
		return getPersistence().fetchByPrimaryKey(phaseManageId);
	}

	/**
	 * Returns all the phase manage entries.
	 *
	 * @return the phase manage entries
	 */
	public static List<PhaseManageEntry> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PhaseManageEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PhaseManageEntry> findAll(
		int start, int end,
		OrderByComparator<PhaseManageEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PhaseManageEntry> findAll(
		int start, int end,
		OrderByComparator<PhaseManageEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the phase manage entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of phase manage entries.
	 *
	 * @return the number of phase manage entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhaseManageEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PhaseManageEntryPersistence _persistence;

}