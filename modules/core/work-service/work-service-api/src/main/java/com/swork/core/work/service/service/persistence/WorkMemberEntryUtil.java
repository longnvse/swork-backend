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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.core.work.service.model.WorkMemberEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the work member entry service. This utility wraps <code>com.swork.core.work.service.service.persistence.impl.WorkMemberEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkMemberEntryPersistence
 * @generated
 */
public class WorkMemberEntryUtil {

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
	public static void clearCache(WorkMemberEntry workMemberEntry) {
		getPersistence().clearCache(workMemberEntry);
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
	public static Map<Serializable, WorkMemberEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkMemberEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkMemberEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkMemberEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkMemberEntry update(WorkMemberEntry workMemberEntry) {
		return getPersistence().update(workMemberEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkMemberEntry update(
		WorkMemberEntry workMemberEntry, ServiceContext serviceContext) {

		return getPersistence().update(workMemberEntry, serviceContext);
	}

	/**
	 * Returns all the work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the matching work member entries
	 */
	public static List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type) {

		return getPersistence().findByW_MT_T(workId, memberType, type);
	}

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
	public static List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type, int start, int end) {

		return getPersistence().findByW_MT_T(
			workId, memberType, type, start, end);
	}

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
	public static List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return getPersistence().findByW_MT_T(
			workId, memberType, type, start, end, orderByComparator);
	}

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
	public static List<WorkMemberEntry> findByW_MT_T(
		long workId, String memberType, String type, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByW_MT_T(
			workId, memberType, type, start, end, orderByComparator,
			useFinderCache);
	}

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
	public static WorkMemberEntry findByW_MT_T_First(
			long workId, String memberType, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws com.swork.core.work.service.exception.
			NoSuchWorkMemberEntryException {

		return getPersistence().findByW_MT_T_First(
			workId, memberType, type, orderByComparator);
	}

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public static WorkMemberEntry fetchByW_MT_T_First(
		long workId, String memberType, String type,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return getPersistence().fetchByW_MT_T_First(
			workId, memberType, type, orderByComparator);
	}

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
	public static WorkMemberEntry findByW_MT_T_Last(
			long workId, String memberType, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws com.swork.core.work.service.exception.
			NoSuchWorkMemberEntryException {

		return getPersistence().findByW_MT_T_Last(
			workId, memberType, type, orderByComparator);
	}

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public static WorkMemberEntry fetchByW_MT_T_Last(
		long workId, String memberType, String type,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return getPersistence().fetchByW_MT_T_Last(
			workId, memberType, type, orderByComparator);
	}

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
	public static WorkMemberEntry[] findByW_MT_T_PrevAndNext(
			long workMemberId, long workId, String memberType, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws com.swork.core.work.service.exception.
			NoSuchWorkMemberEntryException {

		return getPersistence().findByW_MT_T_PrevAndNext(
			workMemberId, workId, memberType, type, orderByComparator);
	}

	/**
	 * Removes all the work member entries where workId = &#63; and memberType = &#63; and type = &#63; from the database.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 */
	public static void removeByW_MT_T(
		long workId, String memberType, String type) {

		getPersistence().removeByW_MT_T(workId, memberType, type);
	}

	/**
	 * Returns the number of work member entries where workId = &#63; and memberType = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param memberType the member type
	 * @param type the type
	 * @return the number of matching work member entries
	 */
	public static int countByW_MT_T(
		long workId, String memberType, String type) {

		return getPersistence().countByW_MT_T(workId, memberType, type);
	}

	/**
	 * Returns all the work member entries where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @return the matching work member entries
	 */
	public static List<WorkMemberEntry> findByW_T_(long workId, String type) {
		return getPersistence().findByW_T_(workId, type);
	}

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
	public static List<WorkMemberEntry> findByW_T_(
		long workId, String type, int start, int end) {

		return getPersistence().findByW_T_(workId, type, start, end);
	}

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
	public static List<WorkMemberEntry> findByW_T_(
		long workId, String type, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return getPersistence().findByW_T_(
			workId, type, start, end, orderByComparator);
	}

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
	public static List<WorkMemberEntry> findByW_T_(
		long workId, String type, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByW_T_(
			workId, type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	public static WorkMemberEntry findByW_T__First(
			long workId, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws com.swork.core.work.service.exception.
			NoSuchWorkMemberEntryException {

		return getPersistence().findByW_T__First(
			workId, type, orderByComparator);
	}

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public static WorkMemberEntry fetchByW_T__First(
		long workId, String type,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return getPersistence().fetchByW_T__First(
			workId, type, orderByComparator);
	}

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	public static WorkMemberEntry findByW_T__Last(
			long workId, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws com.swork.core.work.service.exception.
			NoSuchWorkMemberEntryException {

		return getPersistence().findByW_T__Last(
			workId, type, orderByComparator);
	}

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public static WorkMemberEntry fetchByW_T__Last(
		long workId, String type,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return getPersistence().fetchByW_T__Last(
			workId, type, orderByComparator);
	}

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
	public static WorkMemberEntry[] findByW_T__PrevAndNext(
			long workMemberId, long workId, String type,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws com.swork.core.work.service.exception.
			NoSuchWorkMemberEntryException {

		return getPersistence().findByW_T__PrevAndNext(
			workMemberId, workId, type, orderByComparator);
	}

	/**
	 * Removes all the work member entries where workId = &#63; and type = &#63; from the database.
	 *
	 * @param workId the work ID
	 * @param type the type
	 */
	public static void removeByW_T_(long workId, String type) {
		getPersistence().removeByW_T_(workId, type);
	}

	/**
	 * Returns the number of work member entries where workId = &#63; and type = &#63;.
	 *
	 * @param workId the work ID
	 * @param type the type
	 * @return the number of matching work member entries
	 */
	public static int countByW_T_(long workId, String type) {
		return getPersistence().countByW_T_(workId, type);
	}

	/**
	 * Returns all the work member entries where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @return the matching work member entries
	 */
	public static List<WorkMemberEntry> findByW_(long workId) {
		return getPersistence().findByW_(workId);
	}

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
	public static List<WorkMemberEntry> findByW_(
		long workId, int start, int end) {

		return getPersistence().findByW_(workId, start, end);
	}

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
	public static List<WorkMemberEntry> findByW_(
		long workId, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return getPersistence().findByW_(workId, start, end, orderByComparator);
	}

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
	public static List<WorkMemberEntry> findByW_(
		long workId, int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByW_(
			workId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	public static WorkMemberEntry findByW__First(
			long workId, OrderByComparator<WorkMemberEntry> orderByComparator)
		throws com.swork.core.work.service.exception.
			NoSuchWorkMemberEntryException {

		return getPersistence().findByW__First(workId, orderByComparator);
	}

	/**
	 * Returns the first work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public static WorkMemberEntry fetchByW__First(
		long workId, OrderByComparator<WorkMemberEntry> orderByComparator) {

		return getPersistence().fetchByW__First(workId, orderByComparator);
	}

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry
	 * @throws NoSuchWorkMemberEntryException if a matching work member entry could not be found
	 */
	public static WorkMemberEntry findByW__Last(
			long workId, OrderByComparator<WorkMemberEntry> orderByComparator)
		throws com.swork.core.work.service.exception.
			NoSuchWorkMemberEntryException {

		return getPersistence().findByW__Last(workId, orderByComparator);
	}

	/**
	 * Returns the last work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work member entry, or <code>null</code> if a matching work member entry could not be found
	 */
	public static WorkMemberEntry fetchByW__Last(
		long workId, OrderByComparator<WorkMemberEntry> orderByComparator) {

		return getPersistence().fetchByW__Last(workId, orderByComparator);
	}

	/**
	 * Returns the work member entries before and after the current work member entry in the ordered set where workId = &#63;.
	 *
	 * @param workMemberId the primary key of the current work member entry
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work member entry
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	public static WorkMemberEntry[] findByW__PrevAndNext(
			long workMemberId, long workId,
			OrderByComparator<WorkMemberEntry> orderByComparator)
		throws com.swork.core.work.service.exception.
			NoSuchWorkMemberEntryException {

		return getPersistence().findByW__PrevAndNext(
			workMemberId, workId, orderByComparator);
	}

	/**
	 * Removes all the work member entries where workId = &#63; from the database.
	 *
	 * @param workId the work ID
	 */
	public static void removeByW_(long workId) {
		getPersistence().removeByW_(workId);
	}

	/**
	 * Returns the number of work member entries where workId = &#63;.
	 *
	 * @param workId the work ID
	 * @return the number of matching work member entries
	 */
	public static int countByW_(long workId) {
		return getPersistence().countByW_(workId);
	}

	/**
	 * Caches the work member entry in the entity cache if it is enabled.
	 *
	 * @param workMemberEntry the work member entry
	 */
	public static void cacheResult(WorkMemberEntry workMemberEntry) {
		getPersistence().cacheResult(workMemberEntry);
	}

	/**
	 * Caches the work member entries in the entity cache if it is enabled.
	 *
	 * @param workMemberEntries the work member entries
	 */
	public static void cacheResult(List<WorkMemberEntry> workMemberEntries) {
		getPersistence().cacheResult(workMemberEntries);
	}

	/**
	 * Creates a new work member entry with the primary key. Does not add the work member entry to the database.
	 *
	 * @param workMemberId the primary key for the new work member entry
	 * @return the new work member entry
	 */
	public static WorkMemberEntry create(long workMemberId) {
		return getPersistence().create(workMemberId);
	}

	/**
	 * Removes the work member entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workMemberId the primary key of the work member entry
	 * @return the work member entry that was removed
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	public static WorkMemberEntry remove(long workMemberId)
		throws com.swork.core.work.service.exception.
			NoSuchWorkMemberEntryException {

		return getPersistence().remove(workMemberId);
	}

	public static WorkMemberEntry updateImpl(WorkMemberEntry workMemberEntry) {
		return getPersistence().updateImpl(workMemberEntry);
	}

	/**
	 * Returns the work member entry with the primary key or throws a <code>NoSuchWorkMemberEntryException</code> if it could not be found.
	 *
	 * @param workMemberId the primary key of the work member entry
	 * @return the work member entry
	 * @throws NoSuchWorkMemberEntryException if a work member entry with the primary key could not be found
	 */
	public static WorkMemberEntry findByPrimaryKey(long workMemberId)
		throws com.swork.core.work.service.exception.
			NoSuchWorkMemberEntryException {

		return getPersistence().findByPrimaryKey(workMemberId);
	}

	/**
	 * Returns the work member entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workMemberId the primary key of the work member entry
	 * @return the work member entry, or <code>null</code> if a work member entry with the primary key could not be found
	 */
	public static WorkMemberEntry fetchByPrimaryKey(long workMemberId) {
		return getPersistence().fetchByPrimaryKey(workMemberId);
	}

	/**
	 * Returns all the work member entries.
	 *
	 * @return the work member entries
	 */
	public static List<WorkMemberEntry> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<WorkMemberEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<WorkMemberEntry> findAll(
		int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<WorkMemberEntry> findAll(
		int start, int end,
		OrderByComparator<WorkMemberEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the work member entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work member entries.
	 *
	 * @return the number of work member entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkMemberEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile WorkMemberEntryPersistence _persistence;

}