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

package com.swork.common.comment.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommentEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CommentEntryLocalService
 * @generated
 */
public class CommentEntryLocalServiceWrapper
	implements CommentEntryLocalService,
			   ServiceWrapper<CommentEntryLocalService> {

	public CommentEntryLocalServiceWrapper(
		CommentEntryLocalService commentEntryLocalService) {

		_commentEntryLocalService = commentEntryLocalService;
	}

	/**
	 * Adds the comment entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentEntry the comment entry
	 * @return the comment entry that was added
	 */
	@Override
	public com.swork.common.comment.service.model.CommentEntry addCommentEntry(
		com.swork.common.comment.service.model.CommentEntry commentEntry) {

		return _commentEntryLocalService.addCommentEntry(commentEntry);
	}

	@Override
	public com.swork.common.comment.service.model.CommentEntry addCommentEntry(
		long businessId, long creatorId, String content, Long parentId,
		long classPkId, String classPkName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _commentEntryLocalService.addCommentEntry(
			businessId, creatorId, content, parentId, classPkId, classPkName,
			serviceContext);
	}

	/**
	 * Creates a new comment entry with the primary key. Does not add the comment entry to the database.
	 *
	 * @param commentId the primary key for the new comment entry
	 * @return the new comment entry
	 */
	@Override
	public com.swork.common.comment.service.model.CommentEntry
		createCommentEntry(long commentId) {

		return _commentEntryLocalService.createCommentEntry(commentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the comment entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentEntry the comment entry
	 * @return the comment entry that was removed
	 */
	@Override
	public com.swork.common.comment.service.model.CommentEntry
		deleteCommentEntry(
			com.swork.common.comment.service.model.CommentEntry commentEntry) {

		return _commentEntryLocalService.deleteCommentEntry(commentEntry);
	}

	/**
	 * Deletes the comment entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentId the primary key of the comment entry
	 * @return the comment entry that was removed
	 * @throws PortalException if a comment entry with the primary key could not be found
	 */
	@Override
	public com.swork.common.comment.service.model.CommentEntry
			deleteCommentEntry(long commentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentEntryLocalService.deleteCommentEntry(commentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _commentEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _commentEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commentEntryLocalService.dynamicQuery();
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

		return _commentEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.common.comment.service.model.impl.CommentEntryModelImpl</code>.
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

		return _commentEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.common.comment.service.model.impl.CommentEntryModelImpl</code>.
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

		return _commentEntryLocalService.dynamicQuery(
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

		return _commentEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _commentEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.common.comment.service.model.CommentEntry
		fetchCommentEntry(long commentId) {

		return _commentEntryLocalService.fetchCommentEntry(commentId);
	}

	/**
	 * Returns the comment entry matching the UUID and group.
	 *
	 * @param uuid the comment entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching comment entry, or <code>null</code> if a matching comment entry could not be found
	 */
	@Override
	public com.swork.common.comment.service.model.CommentEntry
		fetchCommentEntryByUuidAndGroupId(String uuid, long groupId) {

		return _commentEntryLocalService.fetchCommentEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _commentEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.swork.common.comment.service.model.CommentEntry>
		getByParentId(long parentId) {

		return _commentEntryLocalService.getByParentId(parentId);
	}

	/**
	 * Returns a range of all the comment entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.common.comment.service.model.impl.CommentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @return the range of comment entries
	 */
	@Override
	public java.util.List<com.swork.common.comment.service.model.CommentEntry>
		getCommentEntries(int start, int end) {

		return _commentEntryLocalService.getCommentEntries(start, end);
	}

	/**
	 * Returns all the comment entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the comment entries
	 * @param companyId the primary key of the company
	 * @return the matching comment entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.common.comment.service.model.CommentEntry>
		getCommentEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _commentEntryLocalService.getCommentEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of comment entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the comment entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of comment entries
	 * @param end the upper bound of the range of comment entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching comment entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.common.comment.service.model.CommentEntry>
		getCommentEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.swork.common.comment.service.model.CommentEntry>
					orderByComparator) {

		return _commentEntryLocalService.getCommentEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of comment entries.
	 *
	 * @return the number of comment entries
	 */
	@Override
	public int getCommentEntriesCount() {
		return _commentEntryLocalService.getCommentEntriesCount();
	}

	/**
	 * Returns the comment entry with the primary key.
	 *
	 * @param commentId the primary key of the comment entry
	 * @return the comment entry
	 * @throws PortalException if a comment entry with the primary key could not be found
	 */
	@Override
	public com.swork.common.comment.service.model.CommentEntry getCommentEntry(
			long commentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentEntryLocalService.getCommentEntry(commentId);
	}

	/**
	 * Returns the comment entry matching the UUID and group.
	 *
	 * @param uuid the comment entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching comment entry
	 * @throws PortalException if a matching comment entry could not be found
	 */
	@Override
	public com.swork.common.comment.service.model.CommentEntry
			getCommentEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentEntryLocalService.getCommentEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _commentEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _commentEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commentEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the comment entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentEntry the comment entry
	 * @return the comment entry that was updated
	 */
	@Override
	public com.swork.common.comment.service.model.CommentEntry
		updateCommentEntry(
			com.swork.common.comment.service.model.CommentEntry commentEntry) {

		return _commentEntryLocalService.updateCommentEntry(commentEntry);
	}

	@Override
	public com.swork.common.comment.service.model.CommentEntry
		updateCommentEntry(
			long commentId, String content,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _commentEntryLocalService.updateCommentEntry(
			commentId, content, serviceContext);
	}

	@Override
	public CommentEntryLocalService getWrappedService() {
		return _commentEntryLocalService;
	}

	@Override
	public void setWrappedService(
		CommentEntryLocalService commentEntryLocalService) {

		_commentEntryLocalService = commentEntryLocalService;
	}

	private CommentEntryLocalService _commentEntryLocalService;

}