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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.swork.common.file.exception.NoSuchFileManagerEntryException;
import com.swork.common.file.model.FileManagerEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the file manager entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileManagerEntryUtil
 * @generated
 */
@ProviderType
public interface FileManagerEntryPersistence
	extends BasePersistence<FileManagerEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FileManagerEntryUtil} to access the file manager entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching file manager entries
	 */
	public java.util.List<FileManagerEntry> findByUuid(String uuid);

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
	public java.util.List<FileManagerEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<FileManagerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

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
	public java.util.List<FileManagerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

	/**
	 * Returns the file manager entries before and after the current file manager entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current file manager entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	public FileManagerEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Removes all the file manager entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of file manager entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching file manager entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the file manager entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the file manager entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the file manager entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the file manager entry that was removed
	 */
	public FileManagerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the number of file manager entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching file manager entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching file manager entries
	 */
	public java.util.List<FileManagerEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<FileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<FileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

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
	public java.util.List<FileManagerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the first file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the last file manager entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

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
	public FileManagerEntry[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Removes all the file manager entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of file manager entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching file manager entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the file manager entry where fileId = &#63; and businessId = &#63; or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByF_B(long fileId, long businessId)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the file manager entry where fileId = &#63; and businessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByF_B(long fileId, long businessId);

	/**
	 * Returns the file manager entry where fileId = &#63; and businessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByF_B(
		long fileId, long businessId, boolean useFinderCache);

	/**
	 * Removes the file manager entry where fileId = &#63; and businessId = &#63; from the database.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the file manager entry that was removed
	 */
	public FileManagerEntry removeByF_B(long fileId, long businessId)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the number of file manager entries where fileId = &#63; and businessId = &#63;.
	 *
	 * @param fileId the file ID
	 * @param businessId the business ID
	 * @return the number of matching file manager entries
	 */
	public int countByF_B(long fileId, long businessId);

	/**
	 * Returns all the file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the matching file manager entries
	 */
	public java.util.List<FileManagerEntry> findByB_PID(
		long businessId, Long projectId);

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
	public java.util.List<FileManagerEntry> findByB_PID(
		long businessId, Long projectId, int start, int end);

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
	public java.util.List<FileManagerEntry> findByB_PID(
		long businessId, Long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

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
	public java.util.List<FileManagerEntry> findByB_PID(
		long businessId, Long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByB_PID_First(
			long businessId, Long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByB_PID_First(
		long businessId, Long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByB_PID_Last(
			long businessId, Long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByB_PID_Last(
		long businessId, Long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

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
	public FileManagerEntry[] findByB_PID_PrevAndNext(
			long id, long businessId, Long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Removes all the file manager entries where businessId = &#63; and projectId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 */
	public void removeByB_PID(long businessId, Long projectId);

	/**
	 * Returns the number of file manager entries where businessId = &#63; and projectId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param projectId the project ID
	 * @return the number of matching file manager entries
	 */
	public int countByB_PID(long businessId, Long projectId);

	/**
	 * Returns all the file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the matching file manager entries
	 */
	public java.util.List<FileManagerEntry> findByB_PHID(
		long businessId, Long phaseId);

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
	public java.util.List<FileManagerEntry> findByB_PHID(
		long businessId, Long phaseId, int start, int end);

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
	public java.util.List<FileManagerEntry> findByB_PHID(
		long businessId, Long phaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

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
	public java.util.List<FileManagerEntry> findByB_PHID(
		long businessId, Long phaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByB_PHID_First(
			long businessId, Long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByB_PHID_First(
		long businessId, Long phaseId,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByB_PHID_Last(
			long businessId, Long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByB_PHID_Last(
		long businessId, Long phaseId,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

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
	public FileManagerEntry[] findByB_PHID_PrevAndNext(
			long id, long businessId, Long phaseId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Removes all the file manager entries where businessId = &#63; and phaseId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 */
	public void removeByB_PHID(long businessId, Long phaseId);

	/**
	 * Returns the number of file manager entries where businessId = &#63; and phaseId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param phaseId the phase ID
	 * @return the number of matching file manager entries
	 */
	public int countByB_PHID(long businessId, Long phaseId);

	/**
	 * Returns all the file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @return the matching file manager entries
	 */
	public java.util.List<FileManagerEntry> findByB_WID(
		long businessId, Long workId);

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
	public java.util.List<FileManagerEntry> findByB_WID(
		long businessId, Long workId, int start, int end);

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
	public java.util.List<FileManagerEntry> findByB_WID(
		long businessId, Long workId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

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
	public java.util.List<FileManagerEntry> findByB_WID(
		long businessId, Long workId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByB_WID_First(
			long businessId, Long workId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the first file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByB_WID_First(
		long businessId, Long workId,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByB_WID_Last(
			long businessId, Long workId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the last file manager entry in the ordered set where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByB_WID_Last(
		long businessId, Long workId,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

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
	public FileManagerEntry[] findByB_WID_PrevAndNext(
			long id, long businessId, Long workId,
			com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
				orderByComparator)
		throws NoSuchFileManagerEntryException;

	/**
	 * Removes all the file manager entries where businessId = &#63; and workId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 */
	public void removeByB_WID(long businessId, Long workId);

	/**
	 * Returns the number of file manager entries where businessId = &#63; and workId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param workId the work ID
	 * @return the number of matching file manager entries
	 */
	public int countByB_WID(long businessId, Long workId);

	/**
	 * Returns the file manager entry where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching file manager entry
	 * @throws NoSuchFileManagerEntryException if a matching file manager entry could not be found
	 */
	public FileManagerEntry findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the file manager entry where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public FileManagerEntry fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the file manager entry where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the file manager entry that was removed
	 */
	public FileManagerEntry removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the number of file manager entries where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching file manager entries
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the file manager entry in the entity cache if it is enabled.
	 *
	 * @param fileManagerEntry the file manager entry
	 */
	public void cacheResult(FileManagerEntry fileManagerEntry);

	/**
	 * Caches the file manager entries in the entity cache if it is enabled.
	 *
	 * @param fileManagerEntries the file manager entries
	 */
	public void cacheResult(
		java.util.List<FileManagerEntry> fileManagerEntries);

	/**
	 * Creates a new file manager entry with the primary key. Does not add the file manager entry to the database.
	 *
	 * @param id the primary key for the new file manager entry
	 * @return the new file manager entry
	 */
	public FileManagerEntry create(long id);

	/**
	 * Removes the file manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry that was removed
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	public FileManagerEntry remove(long id)
		throws NoSuchFileManagerEntryException;

	public FileManagerEntry updateImpl(FileManagerEntry fileManagerEntry);

	/**
	 * Returns the file manager entry with the primary key or throws a <code>NoSuchFileManagerEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry
	 * @throws NoSuchFileManagerEntryException if a file manager entry with the primary key could not be found
	 */
	public FileManagerEntry findByPrimaryKey(long id)
		throws NoSuchFileManagerEntryException;

	/**
	 * Returns the file manager entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry, or <code>null</code> if a file manager entry with the primary key could not be found
	 */
	public FileManagerEntry fetchByPrimaryKey(long id);

	/**
	 * Returns all the file manager entries.
	 *
	 * @return the file manager entries
	 */
	public java.util.List<FileManagerEntry> findAll();

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
	public java.util.List<FileManagerEntry> findAll(int start, int end);

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
	public java.util.List<FileManagerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator);

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
	public java.util.List<FileManagerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileManagerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the file manager entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of file manager entries.
	 *
	 * @return the number of file manager entries
	 */
	public int countAll();

}