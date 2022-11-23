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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FileManagerEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileManagerEntryLocalService
 * @generated
 */
public class FileManagerEntryLocalServiceWrapper
	implements FileManagerEntryLocalService,
			   ServiceWrapper<FileManagerEntryLocalService> {

	public FileManagerEntryLocalServiceWrapper(
		FileManagerEntryLocalService fileManagerEntryLocalService) {

		_fileManagerEntryLocalService = fileManagerEntryLocalService;
	}

	@Override
	public com.swork.common.file.model.FileManagerEntry addFileManager(
		long customerId, long userId,
		com.swork.common.file.mapper.model.FileManagerMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _fileManagerEntryLocalService.addFileManager(
			customerId, userId, model, serviceContext);
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
	@Override
	public com.swork.common.file.model.FileManagerEntry addFileManagerEntry(
		com.swork.common.file.model.FileManagerEntry fileManagerEntry) {

		return _fileManagerEntryLocalService.addFileManagerEntry(
			fileManagerEntry);
	}

	/**
	 * Creates a new file manager entry with the primary key. Does not add the file manager entry to the database.
	 *
	 * @param id the primary key for the new file manager entry
	 * @return the new file manager entry
	 */
	@Override
	public com.swork.common.file.model.FileManagerEntry createFileManagerEntry(
		long id) {

		return _fileManagerEntryLocalService.createFileManagerEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileManagerEntryLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.swork.common.file.model.FileManagerEntry deleteFileManagerEntry(
		com.swork.common.file.model.FileManagerEntry fileManagerEntry) {

		return _fileManagerEntryLocalService.deleteFileManagerEntry(
			fileManagerEntry);
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
	@Override
	public com.swork.common.file.model.FileManagerEntry deleteFileManagerEntry(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileManagerEntryLocalService.deleteFileManagerEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileManagerEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fileManagerEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fileManagerEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fileManagerEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _fileManagerEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _fileManagerEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _fileManagerEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _fileManagerEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _fileManagerEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.common.file.model.FileManagerEntry fetchFileManagerEntry(
		long id) {

		return _fileManagerEntryLocalService.fetchFileManagerEntry(id);
	}

	/**
	 * Returns the file manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the file manager entry's external reference code
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public com.swork.common.file.model.FileManagerEntry
		fetchFileManagerEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _fileManagerEntryLocalService.
			fetchFileManagerEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchFileManagerEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.common.file.model.FileManagerEntry
		fetchFileManagerEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _fileManagerEntryLocalService.
			fetchFileManagerEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the file manager entry matching the UUID and group.
	 *
	 * @param uuid the file manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file manager entry, or <code>null</code> if a matching file manager entry could not be found
	 */
	@Override
	public com.swork.common.file.model.FileManagerEntry
		fetchFileManagerEntryByUuidAndGroupId(String uuid, long groupId) {

		return _fileManagerEntryLocalService.
			fetchFileManagerEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fileManagerEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _fileManagerEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
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
	@Override
	public java.util.List<com.swork.common.file.model.FileManagerEntry>
		getFileManagerEntries(int start, int end) {

		return _fileManagerEntryLocalService.getFileManagerEntries(start, end);
	}

	/**
	 * Returns all the file manager entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the file manager entries
	 * @param companyId the primary key of the company
	 * @return the matching file manager entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.common.file.model.FileManagerEntry>
		getFileManagerEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _fileManagerEntryLocalService.
			getFileManagerEntriesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.swork.common.file.model.FileManagerEntry>
		getFileManagerEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.swork.common.file.model.FileManagerEntry>
					orderByComparator) {

		return _fileManagerEntryLocalService.
			getFileManagerEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of file manager entries.
	 *
	 * @return the number of file manager entries
	 */
	@Override
	public int getFileManagerEntriesCount() {
		return _fileManagerEntryLocalService.getFileManagerEntriesCount();
	}

	/**
	 * Returns the file manager entry with the primary key.
	 *
	 * @param id the primary key of the file manager entry
	 * @return the file manager entry
	 * @throws PortalException if a file manager entry with the primary key could not be found
	 */
	@Override
	public com.swork.common.file.model.FileManagerEntry getFileManagerEntry(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileManagerEntryLocalService.getFileManagerEntry(id);
	}

	/**
	 * Returns the file manager entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the file manager entry's external reference code
	 * @return the matching file manager entry
	 * @throws PortalException if a matching file manager entry could not be found
	 */
	@Override
	public com.swork.common.file.model.FileManagerEntry
			getFileManagerEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileManagerEntryLocalService.
			getFileManagerEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	@Override
	public com.swork.common.file.model.FileManagerEntry
		getFileManagerEntryByFileId(long fileId, long customerId) {

		return _fileManagerEntryLocalService.getFileManagerEntryByFileId(
			fileId, customerId);
	}

	/**
	 * Returns the file manager entry matching the UUID and group.
	 *
	 * @param uuid the file manager entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching file manager entry
	 * @throws PortalException if a matching file manager entry could not be found
	 */
	@Override
	public com.swork.common.file.model.FileManagerEntry
			getFileManagerEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileManagerEntryLocalService.
			getFileManagerEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fileManagerEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fileManagerEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fileManagerEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.swork.common.file.model.FileManagerEntry updateFileManager(
		long fileManagerId,
		com.swork.common.file.mapper.model.FileManagerMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _fileManagerEntryLocalService.updateFileManager(
			fileManagerId, model, serviceContext);
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
	@Override
	public com.swork.common.file.model.FileManagerEntry updateFileManagerEntry(
		com.swork.common.file.model.FileManagerEntry fileManagerEntry) {

		return _fileManagerEntryLocalService.updateFileManagerEntry(
			fileManagerEntry);
	}

	@Override
	public FileManagerEntryLocalService getWrappedService() {
		return _fileManagerEntryLocalService;
	}

	@Override
	public void setWrappedService(
		FileManagerEntryLocalService fileManagerEntryLocalService) {

		_fileManagerEntryLocalService = fileManagerEntryLocalService;
	}

	private FileManagerEntryLocalService _fileManagerEntryLocalService;

}