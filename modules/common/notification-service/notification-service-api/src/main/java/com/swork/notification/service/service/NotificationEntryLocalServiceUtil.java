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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.notification.service.model.NotificationEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for NotificationEntry. This utility wraps
 * <code>com.swork.notification.service.service.impl.NotificationEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationEntryLocalService
 * @generated
 */
public class NotificationEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.notification.service.service.impl.NotificationEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static NotificationEntry addNotification(
		long businessId, long creatorId, String category, String name,
		String description, String status, long receiverId,
		long projectActiveId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addNotification(
			businessId, creatorId, category, name, description, status,
			receiverId, projectActiveId, serviceContext);
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
	public static NotificationEntry addNotificationEntry(
		NotificationEntry notificationEntry) {

		return getService().addNotificationEntry(notificationEntry);
	}

	/**
	 * Creates a new notification entry with the primary key. Does not add the notification entry to the database.
	 *
	 * @param id the primary key for the new notification entry
	 * @return the new notification entry
	 */
	public static NotificationEntry createNotificationEntry(long id) {
		return getService().createNotificationEntry(id);
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
	public static NotificationEntry deleteNotificationEntry(long id)
		throws PortalException {

		return getService().deleteNotificationEntry(id);
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
	public static NotificationEntry deleteNotificationEntry(
		NotificationEntry notificationEntry) {

		return getService().deleteNotificationEntry(notificationEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.notification.service.model.impl.NotificationEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.notification.service.model.impl.NotificationEntryModelImpl</code>.
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

	public static NotificationEntry fetchNotificationEntry(long id) {
		return getService().fetchNotificationEntry(id);
	}

	/**
	 * Returns the notification entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the notification entry's external reference code
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry
		fetchNotificationEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchNotificationEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchNotificationEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static NotificationEntry fetchNotificationEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchNotificationEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the notification entry matching the UUID and group.
	 *
	 * @param uuid the notification entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching notification entry, or <code>null</code> if a matching notification entry could not be found
	 */
	public static NotificationEntry fetchNotificationEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchNotificationEntryByUuidAndGroupId(
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

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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
	public static List<NotificationEntry> getNotificationEntries(
		int start, int end) {

		return getService().getNotificationEntries(start, end);
	}

	/**
	 * Returns all the notification entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the notification entries
	 * @param companyId the primary key of the company
	 * @return the matching notification entries, or an empty list if no matches were found
	 */
	public static List<NotificationEntry>
		getNotificationEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getNotificationEntriesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<NotificationEntry>
		getNotificationEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<NotificationEntry> orderByComparator) {

		return getService().getNotificationEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of notification entries.
	 *
	 * @return the number of notification entries
	 */
	public static int getNotificationEntriesCount() {
		return getService().getNotificationEntriesCount();
	}

	/**
	 * Returns the notification entry with the primary key.
	 *
	 * @param id the primary key of the notification entry
	 * @return the notification entry
	 * @throws PortalException if a notification entry with the primary key could not be found
	 */
	public static NotificationEntry getNotificationEntry(long id)
		throws PortalException {

		return getService().getNotificationEntry(id);
	}

	/**
	 * Returns the notification entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the notification entry's external reference code
	 * @return the matching notification entry
	 * @throws PortalException if a matching notification entry could not be found
	 */
	public static NotificationEntry getNotificationEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getNotificationEntryByExternalReferenceCode(
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
	public static NotificationEntry getNotificationEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getNotificationEntryByUuidAndGroupId(uuid, groupId);
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
	 * Updates the notification entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotificationEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param notificationEntry the notification entry
	 * @return the notification entry that was updated
	 */
	public static NotificationEntry updateNotificationEntry(
		NotificationEntry notificationEntry) {

		return getService().updateNotificationEntry(notificationEntry);
	}

	public static NotificationEntry updateStatusNotification(
		long creatorId, long notificationId, String status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateStatusNotification(
			creatorId, notificationId, status, serviceContext);
	}

	public static NotificationEntryLocalService getService() {
		return _service;
	}

	private static volatile NotificationEntryLocalService _service;

}