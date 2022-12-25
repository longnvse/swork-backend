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

package com.swork.common.file.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.common.file.model.FileManagerEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the file manager entry service. This utility wraps <code>com.swork.common.file.service.persistence.impl.FileManagerEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileManagerEntryPersistence
 * @generated
 */
public class FileManagerEntryUtil {

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
	public static void clearCache(FileManagerEntry fileManagerEntry) {
		getPersistence().clearCache(fileManagerEntry);
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
	public static Map<Serializable, FileManagerEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FileManagerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FileManagerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FileManagerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FileManagerEntry update(FileManagerEntry fileManagerEntry) {
		return getPersistence().update(fileManagerEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FileManagerEntry update(
		FileManagerEntry fileManagerEntry, ServiceContext serviceContext) {

		return getPersistence().update(fileManagerEntry, serviceContext);
	}

	/**
	 * Returns all the file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file manager entries
	 */
	public static List<FileManagerEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file manager entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByUuid_First(
			String uuid, OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByUuid_First(
		String uuid, OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByUuid_Last(
			String uuid, OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByUuid_Last(
		String uuid, OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the file manager entries before and after the current file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current file manager entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	public static FileManagerEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the file manager entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file manager entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the file manager entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByUUID_G(String uuid, long groupId)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the file manager entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file manager entry that was removed
	 */
	public static FileManagerEntry removeByUUID_G(String uuid, long groupId)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of file manager entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file manager entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file manager entries
	 */
	public static List<FileManagerEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the file manager entries before and after the current file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current file manager entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	public static FileManagerEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the file manager entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file manager entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the file manager entry where fileId = &#63; and businessId = &#63; or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByF_B(long fileId, long businessId)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByF_B(fileId, businessId);
	}

	/**
	 * Returns the file manager entry where fileId = &#63; and businessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByF_B(long fileId, long businessId) {
		return getPersistence().fetchByF_B(fileId, businessId);
	}

	/**
	 * Returns the file manager entry where fileId = &#63; and businessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByF_B(
		long fileId, long businessId, boolean useFinderCache) {

		return getPersistence().fetchByF_B(fileId, businessId, useFinderCache);
	}

	/**
	 * Removes the file manager entry where fileId = &#63; and businessId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the file manager entry that was removed
	 */
	public static FileManagerEntry removeByF_B(long fileId, long businessId)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().removeByF_B(fileId, businessId);
	}

	/**
	 * Returns the number of file manager entries where fileId = &#63; and businessId = &#63;.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the number of matching file manager entries
	 */
	public static int countByF_B(long fileId, long businessId) {
		return getPersistence().countByF_B(fileId, businessId);
	}

	/**
	 * Returns all the file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_PID(
		long businessId, Long projectId) {

		return getPersistence().findByB_PID(businessId, projectId);
	}

	/**
	 * Returns a range of all the file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_PID(
		long businessId, Long projectId, int start, int end) {

		return getPersistence().findByB_PID(businessId, projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_PID(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().findByB_PID(
			businessId, projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_PID(
		long businessId, Long projectId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_PID(
			businessId, projectId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByB_PID_First(
			long businessId, Long projectId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByB_PID_First(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByB_PID_First(
		long businessId, Long projectId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().fetchByB_PID_First(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByB_PID_Last(
			long businessId, Long projectId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByB_PID_Last(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByB_PID_Last(
		long businessId, Long projectId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().fetchByB_PID_Last(
			businessId, projectId, orderByComparator);
	}

	/**
	 * Returns the file manager entries before and after the current file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param id the primary key of the current file manager entry
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	public static FileManagerEntry[] findByB_PID_PrevAndNext(
			long id, long businessId, Long projectId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByB_PID_PrevAndNext(
			id, businessId, projectId, orderByComparator);
	}

	/**
	 * Removes all the file manager entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	public static void removeByB_PID(long businessId, Long projectId) {
		getPersistence().removeByB_PID(businessId, projectId);
	}

	/**
	 * Returns the number of file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching file manager entries
	 */
	public static int countByB_PID(long businessId, Long projectId) {
		return getPersistence().countByB_PID(businessId, projectId);
	}

	/**
	 * Returns all the file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_PHID(
		long businessId, Long phaseId) {

		return getPersistence().findByB_PHID(businessId, phaseId);
	}

	/**
	 * Returns a range of all the file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_PHID(
		long businessId, Long phaseId, int start, int end) {

		return getPersistence().findByB_PHID(businessId, phaseId, start, end);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_PHID(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().findByB_PHID(
			businessId, phaseId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_PHID(
		long businessId, Long phaseId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_PHID(
			businessId, phaseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByB_PHID_First(
			long businessId, Long phaseId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByB_PHID_First(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByB_PHID_First(
		long businessId, Long phaseId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().fetchByB_PHID_First(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByB_PHID_Last(
			long businessId, Long phaseId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByB_PHID_Last(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByB_PHID_Last(
		long businessId, Long phaseId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().fetchByB_PHID_Last(
			businessId, phaseId, orderByComparator);
	}

	/**
	 * Returns the file manager entries before and after the current file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param id the primary key of the current file manager entry
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	public static FileManagerEntry[] findByB_PHID_PrevAndNext(
			long id, long businessId, Long phaseId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByB_PHID_PrevAndNext(
			id, businessId, phaseId, orderByComparator);
	}

	/**
	 * Removes all the file manager entries where businessId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 */
	public static void removeByB_PHID(long businessId, Long phaseId) {
		getPersistence().removeByB_PHID(businessId, phaseId);
	}

	/**
	 * Returns the number of file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the number of matching file manager entries
	 */
	public static int countByB_PHID(long businessId, Long phaseId) {
		return getPersistence().countByB_PHID(businessId, phaseId);
	}

	/**
	 * Returns all the file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @return the matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_WID(
		long businessId, Long workId) {

		return getPersistence().findByB_WID(businessId, workId);
	}

	/**
	 * Returns a range of all the file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_WID(
		long businessId, Long workId, int start, int end) {

		return getPersistence().findByB_WID(businessId, workId, start, end);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_WID(
		long businessId, Long workId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().findByB_WID(
			businessId, workId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file manager entries
	 */
	public static List<FileManagerEntry> findByB_WID(
		long businessId, Long workId, int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByB_WID(
			businessId, workId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByB_WID_First(
			long businessId, Long workId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByB_WID_First(
			businessId, workId, orderByComparator);
	}

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByB_WID_First(
		long businessId, Long workId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().fetchByB_WID_First(
			businessId, workId, orderByComparator);
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByB_WID_Last(
			long businessId, Long workId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByB_WID_Last(
			businessId, workId, orderByComparator);
	}

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByB_WID_Last(
		long businessId, Long workId,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().fetchByB_WID_Last(
			businessId, workId, orderByComparator);
	}

	/**
	 * Returns the file manager entries before and after the current file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param id the primary key of the current file manager entry
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	public static FileManagerEntry[] findByB_WID_PrevAndNext(
			long id, long businessId, Long workId,
			OrderByComparator<FileManagerEntry> orderByComparator)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByB_WID_PrevAndNext(
			id, businessId, workId, orderByComparator);
	}

	/**
	 * Removes all the file manager entries where businessId = &#63; and workId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 */
	public static void removeByB_WID(long businessId, Long workId) {
		getPersistence().removeByB_WID(businessId, workId);
	}

	/**
	 * Returns the number of file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @return the number of matching file manager entries
	 */
	public static int countByB_WID(long businessId, Long workId) {
		return getPersistence().countByB_WID(businessId, workId);
	}

	/**
	 * Returns the file manager entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the file manager entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the file manager entry that was removed
	 */
	public static FileManagerEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of file manager entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching file manager entries
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the file manager entry in the entity cache if it is enabled.
	 *
	 * @param fileManagerEntry the file manager entry
	 */
	public static void cacheResult(FileManagerEntry fileManagerEntry) {
		getPersistence().cacheResult(fileManagerEntry);
	}

	/**
	 * Caches the file manager entries in the entity cache if it is enabled.
	 *
	 * @param fileManagerEntries the file manager entries
	 */
	public static void cacheResult(List<FileManagerEntry> fileManagerEntries) {
		getPersistence().cacheResult(fileManagerEntries);
	}

	/**
	 * Creates a new file manager entry with the primary key. Does not add the file manager entry to the database.
	 *
	 * @param id the primary key for the new file manager entry
	 * @return the new file manager entry
	 */
	public static FileManagerEntry create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the file manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry that was removed
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	public static FileManagerEntry remove(long id)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().remove(id);
	}

	public static FileManagerEntry updateImpl(
		FileManagerEntry fileManagerEntry) {

		return getPersistence().updateImpl(fileManagerEntry);
	}

	/**
	 * Returns the file manager entry with the primary key or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	public static FileManagerEntry findByPrimaryKey(long id)
		throws com.swork.common.file.exception.NoSuchFileManagerEntryException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the file manager entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry, or <code>null</code> if a file manager entry with the primary key could not be found
	 */
	public static FileManagerEntry fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the file manager entries.
	 *
	 * @return the file manager entries
	 */
	public static List<FileManagerEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of file manager entries
	 */
	public static List<FileManagerEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file manager entries
	 */
	public static List<FileManagerEntry> findAll(
		int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file manager entries
	 */
	public static List<FileManagerEntry> findAll(
		int start, int end,
		OrderByComparator<FileManagerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the file manager entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of file manager entries.
	 *
	 * @return the number of file manager entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FileManagerEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FileManagerEntryPersistence _persistence;

}