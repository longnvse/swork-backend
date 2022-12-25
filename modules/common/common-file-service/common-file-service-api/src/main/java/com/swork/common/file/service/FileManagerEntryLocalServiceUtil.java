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

package com.swork.common.file.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.common.file.model.FileManagerEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FileManagerEntry. This utility wraps
 * <code>com.swork.common.file.service.impl.FileManagerEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FileManagerEntryLocalService
 * @generated
 */
public class FileManagerEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.common.file.service.impl.FileManagerEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static FileManagerEntry addFileManager(
		long businessId, long creatorId, Long projectId, Long phaseId,
		Long workId,
		com.swork.common.file.mapper.model.FileManagerMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addFileManager(
			businessId, creatorId, projectId, phaseId, workId, model,
			serviceContext);
	}

	/**
	 * Adds the file manager entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileManagerEntry the file manager entry
	 * @return the file manager entry that was added
	 */
	public static FileManagerEntry addFileManagerEntry(
		FileManagerEntry fileManagerEntry) {

		return getService().addFileManagerEntry(fileManagerEntry);
	}

	public static int countByPhaseId(long businessId, long phaseId) {
		return getService().countByPhaseId(businessId, phaseId);
	}

	public static int countByProjectId(long businessId, long projectId) {
		return getService().countByProjectId(businessId, projectId);
	}

	public static int countByWorkId(long businessId, long workId) {
		return getService().countByWorkId(businessId, workId);
	}

	/**
	 * Creates a new file manager entry with the primary key. Does not add the file manager entry to the database.
	 *
	 * @param id the primary key for the new file manager entry
	 * @return the new file manager entry
	 */
	public static FileManagerEntry createFileManagerEntry(long id) {
		return getService().createFileManagerEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the file manager entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileManagerEntry the file manager entry
	 * @return the file manager entry that was removed
	 */
	public static FileManagerEntry deleteFileManagerEntry(
		FileManagerEntry fileManagerEntry) {

		return getService().deleteFileManagerEntry(fileManagerEntry);
	}

	/**
	 * Deletes the file manager entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry that was removed
	 * @throws PortalException if a file manager entry with the primary key could not be found
	 */
	public static FileManagerEntry deleteFileManagerEntry(long id)
		throws PortalException {

		return getService().deleteFileManagerEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.common.file.model.impl.FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.common.file.model.impl.FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static FileManagerEntry fetchFileManagerEntry(long id) {
		return getService().fetchFileManagerEntry(id);
	}

	/**
	 * Returns the file manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the file manager entry's external reference code
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchFileManagerEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchFileManagerEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchFileManagerEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static FileManagerEntry fetchFileManagerEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchFileManagerEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the file manager entry matching the UUID and group.
	 *
	 * @param uuid the file manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	public static FileManagerEntry fetchFileManagerEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFileManagerEntryByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns a range of all the file manager entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.common.file.model.impl.FileManagerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @return the range of file manager entries
	 */
	public static List<FileManagerEntry> getFileManagerEntries(
		int start, int end) {

		return getService().getFileManagerEntries(start, end);
	}

	/**
	 * Returns all the file manager entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the file manager entries
	 * @param companyId the primary key of the company
	 * @return the matching file manager entries, or an empty list if no matches were found
	 */
	public static List<FileManagerEntry>
		getFileManagerEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getFileManagerEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of file manager entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the file manager entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of file manager entries
	 * @param end the upper bound of the range of file manager entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching file manager entries, or an empty list if no matches were found
	 */
	public static List<FileManagerEntry>
		getFileManagerEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<FileManagerEntry> orderByComparator) {

		return getService().getFileManagerEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of file manager entries.
	 *
	 * @return the number of file manager entries
	 */
	public static int getFileManagerEntriesCount() {
		return getService().getFileManagerEntriesCount();
	}

	/**
	 * Returns the file manager entry with the primary key.
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry
	 * @throws PortalException if a file manager entry with the primary key could not be found
	 */
	public static FileManagerEntry getFileManagerEntry(long id)
		throws PortalException {

		return getService().getFileManagerEntry(id);
	}

	/**
	 * Returns the file manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the file manager entry's external reference code
	 * @return the matching file manager entry
	 * @throws PortalException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry getFileManagerEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getFileManagerEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	public static FileManagerEntry getFileManagerEntryByFileId(
		long fileId, long businessId) {

		return getService().getFileManagerEntryByFileId(fileId, businessId);
	}

	/**
	 * Returns the file manager entry matching the UUID and group.
	 *
	 * @param uuid the file manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file manager entry
	 * @throws PortalException if a matching file manager entry could not be found
	 */
	public static FileManagerEntry getFileManagerEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFileManagerEntryByUuidAndGroupId(uuid, groupId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the file manager entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileManagerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileManagerEntry the file manager entry
	 * @return the file manager entry that was updated
	 */
	public static FileManagerEntry updateFileManagerEntry(
		FileManagerEntry fileManagerEntry) {

		return getService().updateFileManagerEntry(fileManagerEntry);
	}

	public static FileManagerEntry updateFileName(
		long fileManagerId, String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateFileName(fileManagerId, name, serviceContext);
	}

	public static FileManagerEntryLocalService getService() {
		return _service;
	}

	private static volatile FileManagerEntryLocalService _service;

}