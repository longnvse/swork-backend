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

package com.swork.notification.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NotificationEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationEntryLocalService
 * @generated
 */
public class NotificationEntryLocalServiceWrapper
	implements NotificationEntryLocalService,
			   ServiceWrapper<NotificationEntryLocalService> {

	public NotificationEntryLocalServiceWrapper(
		NotificationEntryLocalService notificationEntryLocalService) {

		_notificationEntryLocalService = notificationEntryLocalService;
	}

	@Override
	public com.swork.notification.service.model.NotificationEntry
		addNotification(
			long businessId, long creatorId, String category, String name,
			String description, String status, long receiverId, long subjectId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _notificationEntryLocalService.addNotification(
			businessId, creatorId, category, name, description, status,
			receiverId, subjectId, serviceContext);
	}

	/**
	 * Adds the notification entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotificationEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param notificationEntry the notification entry
	 * @return the notification entry that was added
	 */
	@Override
	public com.swork.notification.service.model.NotificationEntry
		addNotificationEntry(
			com.swork.notification.service.model.NotificationEntry
				notificationEntry) {

		return _notificationEntryLocalService.addNotificationEntry(
			notificationEntry);
	}

	@Override
	public int countByReceiverAndStatus(long receiverId, String status) {
		return _notificationEntryLocalService.countByReceiverAndStatus(
			receiverId, status);
	}

	/**
	 * Creates a new notification entry with the primary key. Does not add the notification entry to the database.
	 *
	 * @param id the primary key for the new notification entry
	 * @return the new notification entry
	 */
	@Override
	public com.swork.notification.service.model.NotificationEntry
		createNotificationEntry(long id) {

		return _notificationEntryLocalService.createNotificationEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the notification entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotificationEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry that was removed
	 * @throws PortalException if a notification entry with the primary key could not be found
	 */
	@Override
	public com.swork.notification.service.model.NotificationEntry
			deleteNotificationEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationEntryLocalService.deleteNotificationEntry(id);
	}

	/**
	 * Deletes the notification entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotificationEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param notificationEntry the notification entry
	 * @return the notification entry that was removed
	 */
	@Override
	public com.swork.notification.service.model.NotificationEntry
		deleteNotificationEntry(
			com.swork.notification.service.model.NotificationEntry
				notificationEntry) {

		return _notificationEntryLocalService.deleteNotificationEntry(
			notificationEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _notificationEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _notificationEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _notificationEntryLocalService.dynamicQuery();
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

		return _notificationEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.notification.service.model.impl.NotificationEntryModelImpl</code>.
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

		return _notificationEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.notification.service.model.impl.NotificationEntryModelImpl</code>.
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

		return _notificationEntryLocalService.dynamicQuery(
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

		return _notificationEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _notificationEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.notification.service.model.NotificationEntry
		fetchNotificationEntry(long id) {

		return _notificationEntryLocalService.fetchNotificationEntry(id);
	}

	/**
	 * Returns the notification entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the notification entry's external reference code
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public com.swork.notification.service.model.NotificationEntry
		fetchNotificationEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _notificationEntryLocalService.
			fetchNotificationEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchNotificationEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.notification.service.model.NotificationEntry
		fetchNotificationEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _notificationEntryLocalService.
			fetchNotificationEntryByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the notification entry matching the UUID and group.
	 *
	 * @param uuid the notification entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	@Override
	public com.swork.notification.service.model.NotificationEntry
		fetchNotificationEntryByUuidAndGroupId(String uuid, long groupId) {

		return _notificationEntryLocalService.
			fetchNotificationEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List
		<com.swork.notification.service.model.NotificationEntry> findByReceiver(
			long receiverId) {

		return _notificationEntryLocalService.findByReceiver(receiverId);
	}

	@Override
	public java.util.List
		<com.swork.notification.service.model.NotificationEntry>
			findByReceiverAndStatus(long receiverId, String status) {

		return _notificationEntryLocalService.findByReceiverAndStatus(
			receiverId, status);
	}

	@Override
	public java.util.List
		<com.swork.notification.service.model.NotificationEntry>
			findBySubjectId(long subjectId) {

		return _notificationEntryLocalService.findBySubjectId(subjectId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _notificationEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _notificationEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _notificationEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the notification entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.notification.service.model.impl.NotificationEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of notification entries
	 */
	@Override
	public java.util.List
		<com.swork.notification.service.model.NotificationEntry>
			getNotificationEntries(int start, int end) {

		return _notificationEntryLocalService.getNotificationEntries(
			start, end);
	}

	/**
	 * Returns all the notification entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the notification entries
	 * @param companyId the primary key of the company
	 * @return the matching notification entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.swork.notification.service.model.NotificationEntry>
			getNotificationEntriesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _notificationEntryLocalService.
			getNotificationEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of notification entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the notification entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching notification entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.swork.notification.service.model.NotificationEntry>
			getNotificationEntriesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.swork.notification.service.model.NotificationEntry>
						orderByComparator) {

		return _notificationEntryLocalService.
			getNotificationEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of notification entries.
	 *
	 * @return the number of notification entries
	 */
	@Override
	public int getNotificationEntriesCount() {
		return _notificationEntryLocalService.getNotificationEntriesCount();
	}

	/**
	 * Returns the notification entry with the primary key.
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry
	 * @throws PortalException if a notification entry with the primary key could not be found
	 */
	@Override
	public com.swork.notification.service.model.NotificationEntry
			getNotificationEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationEntryLocalService.getNotificationEntry(id);
	}

	/**
	 * Returns the notification entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the notification entry's external reference code
	 * @return the matching notification entry
	 * @throws PortalException if a matching notification entry could not be found
	 */
	@Override
	public com.swork.notification.service.model.NotificationEntry
			getNotificationEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationEntryLocalService.
			getNotificationEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the notification entry matching the UUID and group.
	 *
	 * @param uuid the notification entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching notification entry
	 * @throws PortalException if a matching notification entry could not be found
	 */
	@Override
	public com.swork.notification.service.model.NotificationEntry
			getNotificationEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationEntryLocalService.
			getNotificationEntryByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _notificationEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notificationEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the notification entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotificationEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param notificationEntry the notification entry
	 * @return the notification entry that was updated
	 */
	@Override
	public com.swork.notification.service.model.NotificationEntry
		updateNotificationEntry(
			com.swork.notification.service.model.NotificationEntry
				notificationEntry) {

		return _notificationEntryLocalService.updateNotificationEntry(
			notificationEntry);
	}

	@Override
	public com.swork.notification.service.model.NotificationEntry
		updateStatusNotification(
			long creatorId, long notificationId, String status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _notificationEntryLocalService.updateStatusNotification(
			creatorId, notificationId, status, serviceContext);
	}

	@Override
	public NotificationEntryLocalService getWrappedService() {
		return _notificationEntryLocalService;
	}

	@Override
	public void setWrappedService(
		NotificationEntryLocalService notificationEntryLocalService) {

		_notificationEntryLocalService = notificationEntryLocalService;
	}

	private NotificationEntryLocalService _notificationEntryLocalService;

}