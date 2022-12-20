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

package com.swork.common.comment.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.common.comment.service.model.CommentEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the comment entry service. This utility wraps <code>com.swork.common.comment.service.service.persistence.impl.CommentEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentEntryPersistence
 * @generated
 */
public class CommentEntryUtil {

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
	public static void clearCache(CommentEntry commentEntry) {
		getPersistence().clearCache(commentEntry);
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
	public static Map<Serializable, CommentEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CommentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CommentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CommentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CommentEntry update(CommentEntry commentEntry) {
		return getPersistence().update(commentEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CommentEntry update(
		CommentEntry commentEntry, ServiceContext serviceContext) {

		return getPersistence().update(commentEntry, serviceContext);
	}

	/**
	 * Returns all the comment entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching comment entries
	 */
	public static List<CommentEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the comment entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of matching comment entries
	 */
	public static List<CommentEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the comment entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment entries
	 */
	public static List<CommentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comment entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comment entries
	 */
	public static List<CommentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public static CommentEntry findByUuid_First(
			String uuid, OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public static CommentEntry fetchByUuid_First(
		String uuid, OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public static CommentEntry findByUuid_Last(
			String uuid, OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public static CommentEntry fetchByUuid_Last(
		String uuid, OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the comment entries before and after the current comment entry in the ordered set where uuid = &#63;.
	 *
	 * @param commentId the primary key of the current comment entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public static CommentEntry[] findByUuid_PrevAndNext(
			long commentId, String uuid,
			OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			commentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the comment entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of comment entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching comment entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the comment entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCommentEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public static CommentEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the comment entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public static CommentEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the comment entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public static CommentEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the comment entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the comment entry that was removed
	 */
	public static CommentEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of comment entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching comment entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching comment entries
	 */
	public static List<CommentEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of matching comment entries
	 */
	public static List<CommentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment entries
	 */
	public static List<CommentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comment entries
	 */
	public static List<CommentEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public static CommentEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public static CommentEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public static CommentEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public static CommentEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the comment entries before and after the current comment entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commentId the primary key of the current comment entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public static CommentEntry[] findByUuid_C_PrevAndNext(
			long commentId, String uuid, long companyId,
			OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			commentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the comment entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of comment entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching comment entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the comment entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching comment entries
	 */
	public static List<CommentEntry> findByPID(long parentId) {
		return getPersistence().findByPID(parentId);
	}

	/**
	 * Returns a range of all the comment entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of matching comment entries
	 */
	public static List<CommentEntry> findByPID(
		long parentId, int start, int end) {

		return getPersistence().findByPID(parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the comment entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment entries
	 */
	public static List<CommentEntry> findByPID(
		long parentId, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().findByPID(
			parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comment entries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comment entries
	 */
	public static List<CommentEntry> findByPID(
		long parentId, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPID(
			parentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public static CommentEntry findByPID_First(
			long parentId, OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByPID_First(parentId, orderByComparator);
	}

	/**
	 * Returns the first comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public static CommentEntry fetchByPID_First(
		long parentId, OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().fetchByPID_First(parentId, orderByComparator);
	}

	/**
	 * Returns the last comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public static CommentEntry findByPID_Last(
			long parentId, OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByPID_Last(parentId, orderByComparator);
	}

	/**
	 * Returns the last comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public static CommentEntry fetchByPID_Last(
		long parentId, OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().fetchByPID_Last(parentId, orderByComparator);
	}

	/**
	 * Returns the comment entries before and after the current comment entry in the ordered set where parentId = &#63;.
	 *
	 * @param commentId the primary key of the current comment entry
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public static CommentEntry[] findByPID_PrevAndNext(
			long commentId, long parentId,
			OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByPID_PrevAndNext(
			commentId, parentId, orderByComparator);
	}

	/**
	 * Removes all the comment entries where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	public static void removeByPID(long parentId) {
		getPersistence().removeByPID(parentId);
	}

	/**
	 * Returns the number of comment entries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching comment entries
	 */
	public static int countByPID(long parentId) {
		return getPersistence().countByPID(parentId);
	}

	/**
	 * Returns all the comment entries where classPkId = &#63; and classPKName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPKName the class pk name
	 * @return the matching comment entries
	 */
	public static List<CommentEntry> findByPKID_PKName(
		long classPkId, String classPKName) {

		return getPersistence().findByPKID_PKName(classPkId, classPKName);
	}

	/**
	 * Returns a range of all the comment entries where classPkId = &#63; and classPKName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPKName the class pk name
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of matching comment entries
	 */
	public static List<CommentEntry> findByPKID_PKName(
		long classPkId, String classPKName, int start, int end) {

		return getPersistence().findByPKID_PKName(
			classPkId, classPKName, start, end);
	}

	/**
	 * Returns an ordered range of all the comment entries where classPkId = &#63; and classPKName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPKName the class pk name
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment entries
	 */
	public static List<CommentEntry> findByPKID_PKName(
		long classPkId, String classPKName, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().findByPKID_PKName(
			classPkId, classPKName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comment entries where classPkId = &#63; and classPKName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param classPkId the class pk ID
	 * @param classPKName the class pk name
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comment entries
	 */
	public static List<CommentEntry> findByPKID_PKName(
		long classPkId, String classPKName, int start, int end,
		OrderByComparator<CommentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPKID_PKName(
			classPkId, classPKName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first comment entry in the ordered set where classPkId = &#63; and classPKName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPKName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public static CommentEntry findByPKID_PKName_First(
			long classPkId, String classPKName,
			OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByPKID_PKName_First(
			classPkId, classPKName, orderByComparator);
	}

	/**
	 * Returns the first comment entry in the ordered set where classPkId = &#63; and classPKName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPKName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public static CommentEntry fetchByPKID_PKName_First(
		long classPkId, String classPKName,
		OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().fetchByPKID_PKName_First(
			classPkId, classPKName, orderByComparator);
	}

	/**
	 * Returns the last comment entry in the ordered set where classPkId = &#63; and classPKName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPKName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry
	 * @throws NoSuchCommentEntryException if a matching comment entry could not be found
	 */
	public static CommentEntry findByPKID_PKName_Last(
			long classPkId, String classPKName,
			OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByPKID_PKName_Last(
			classPkId, classPKName, orderByComparator);
	}

	/**
	 * Returns the last comment entry in the ordered set where classPkId = &#63; and classPKName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPKName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	public static CommentEntry fetchByPKID_PKName_Last(
		long classPkId, String classPKName,
		OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().fetchByPKID_PKName_Last(
			classPkId, classPKName, orderByComparator);
	}

	/**
	 * Returns the comment entries before and after the current comment entry in the ordered set where classPkId = &#63; and classPKName = &#63;.
	 *
	 * @param commentId the primary key of the current comment entry
	 * @param classPkId the class pk ID
	 * @param classPKName the class pk name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public static CommentEntry[] findByPKID_PKName_PrevAndNext(
			long commentId, long classPkId, String classPKName,
			OrderByComparator<CommentEntry> orderByComparator)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByPKID_PKName_PrevAndNext(
			commentId, classPkId, classPKName, orderByComparator);
	}

	/**
	 * Removes all the comment entries where classPkId = &#63; and classPKName = &#63; from the database.
	 *
	 * @param classPkId the class pk ID
	 * @param classPKName the class pk name
	 */
	public static void removeByPKID_PKName(long classPkId, String classPKName) {
		getPersistence().removeByPKID_PKName(classPkId, classPKName);
	}

	/**
	 * Returns the number of comment entries where classPkId = &#63; and classPKName = &#63;.
	 *
	 * @param classPkId the class pk ID
	 * @param classPKName the class pk name
	 * @return the number of matching comment entries
	 */
	public static int countByPKID_PKName(long classPkId, String classPKName) {
		return getPersistence().countByPKID_PKName(classPkId, classPKName);
	}

	/**
	 * Caches the comment entry in the entity cache if it is enabled.
	 *
	 * @param commentEntry the comment entry
	 */
	public static void cacheResult(CommentEntry commentEntry) {
		getPersistence().cacheResult(commentEntry);
	}

	/**
	 * Caches the comment entries in the entity cache if it is enabled.
	 *
	 * @param commentEntries the comment entries
	 */
	public static void cacheResult(List<CommentEntry> commentEntries) {
		getPersistence().cacheResult(commentEntries);
	}

	/**
	 * Creates a new comment entry with the primary key. Does not add the comment entry to the database.
	 *
	 * @param commentId the primary key for the new comment entry
	 * @return the new comment entry
	 */
	public static CommentEntry create(long commentId) {
		return getPersistence().create(commentId);
	}

	/**
	 * Removes the comment entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentId the primary key of the comment entry
	 * @return the comment entry that was removed
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public static CommentEntry remove(long commentId)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().remove(commentId);
	}

	public static CommentEntry updateImpl(CommentEntry commentEntry) {
		return getPersistence().updateImpl(commentEntry);
	}

	/**
	 * Returns the comment entry with the primary key or throws a <code>NoSuchCommentEntryException</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment entry
	 * @return the comment entry
	 * @throws NoSuchCommentEntryException if a comment entry with the primary key could not be found
	 */
	public static CommentEntry findByPrimaryKey(long commentId)
		throws com.swork.common.comment.service.exception.
			NoSuchCommentEntryException {

		return getPersistence().findByPrimaryKey(commentId);
	}

	/**
	 * Returns the comment entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment entry
	 * @return the comment entry, or <code>null</code> if a comment entry with the primary key could not be found
	 */
	public static CommentEntry fetchByPrimaryKey(long commentId) {
		return getPersistence().fetchByPrimaryKey(commentId);
	}

	/**
	 * Returns all the comment entries.
	 *
	 * @return the comment entries
	 */
	public static List<CommentEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the comment entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of comment entries
	 */
	public static List<CommentEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the comment entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comment entries
	 */
	public static List<CommentEntry> findAll(
		int start, int end, OrderByComparator<CommentEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comment entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comment entries
	 */
	public static List<CommentEntry> findAll(
		int start, int end, OrderByComparator<CommentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the comment entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of comment entries.
	 *
	 * @return the number of comment entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CommentEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CommentEntryPersistence _persistence;

}