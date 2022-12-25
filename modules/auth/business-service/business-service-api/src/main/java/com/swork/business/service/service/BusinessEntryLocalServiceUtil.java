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

package com.swork.business.service.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.business.service.model.BusinessEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BusinessEntry. This utility wraps
 * <code>com.swork.business.service.service.impl.BusinessEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BusinessEntryLocalService
 * @generated
 */
public class BusinessEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.business.service.service.impl.BusinessEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the business entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BusinessEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param businessEntry the business entry
	 * @return the business entry that was added
	 */
	public static BusinessEntry addBusinessEntry(BusinessEntry businessEntry) {
		return getService().addBusinessEntry(businessEntry);
	}

	public static BusinessEntry addBusinessEntry(
		long creatorId,
		com.swork.business.service.mapper.model.BusinessMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addBusinessEntry(creatorId, model, serviceContext);
	}

	/**
	 * Creates a new business entry with the primary key. Does not add the business entry to the database.
	 *
	 * @param businessId the primary key for the new business entry
	 * @return the new business entry
	 */
	public static BusinessEntry createBusinessEntry(long businessId) {
		return getService().createBusinessEntry(businessId);
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
	 * Deletes the business entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BusinessEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param businessEntry the business entry
	 * @return the business entry that was removed
	 */
	public static BusinessEntry deleteBusinessEntry(
		BusinessEntry businessEntry) {

		return getService().deleteBusinessEntry(businessEntry);
	}

	/**
	 * Deletes the business entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BusinessEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry that was removed
	 * @throws PortalException if a business entry with the primary key could not be found
	 */
	public static BusinessEntry deleteBusinessEntry(long businessId)
		throws PortalException {

		return getService().deleteBusinessEntry(businessId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.business.service.model.impl.BusinessEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.business.service.model.impl.BusinessEntryModelImpl</code>.
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

	public static BusinessEntry fetchBusinessEntry(long businessId) {
		return getService().fetchBusinessEntry(businessId);
	}

	/**
	 * Returns the business entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the business entry's external reference code
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchBusinessEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchBusinessEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchBusinessEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static BusinessEntry fetchBusinessEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchBusinessEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the business entry matching the UUID and group.
	 *
	 * @param uuid the business entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	public static BusinessEntry fetchBusinessEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchBusinessEntryByUuidAndGroupId(uuid, groupId);
	}

	public static BusinessEntry findByEmail(String email) {
		return getService().findByEmail(email);
	}

	public static BusinessEntry findByName(String name) {
		return getService().findByName(name);
	}

	public static BusinessEntry findByPhoneNumber(String phoneNumber) {
		return getService().findByPhoneNumber(phoneNumber);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the business entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.business.service.model.impl.BusinessEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @return the range of business entries
	 */
	public static List<BusinessEntry> getBusinessEntries(int start, int end) {
		return getService().getBusinessEntries(start, end);
	}

	/**
	 * Returns all the business entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the business entries
	 * @param companyId the primary key of the company
	 * @return the matching business entries, or an empty list if no matches were found
	 */
	public static List<BusinessEntry> getBusinessEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getBusinessEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of business entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the business entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of business entries
	 * @param end the upper bound of the range of business entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching business entries, or an empty list if no matches were found
	 */
	public static List<BusinessEntry> getBusinessEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator) {

		return getService().getBusinessEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of business entries.
	 *
	 * @return the number of business entries
	 */
	public static int getBusinessEntriesCount() {
		return getService().getBusinessEntriesCount();
	}

	/**
	 * Returns the business entry with the primary key.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry
	 * @throws PortalException if a business entry with the primary key could not be found
	 */
	public static BusinessEntry getBusinessEntry(long businessId)
		throws PortalException {

		return getService().getBusinessEntry(businessId);
	}

	/**
	 * Returns the business entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the business entry's external reference code
	 * @return the matching business entry
	 * @throws PortalException if a matching business entry could not be found
	 */
	public static BusinessEntry getBusinessEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getBusinessEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the business entry matching the UUID and group.
	 *
	 * @param uuid the business entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching business entry
	 * @throws PortalException if a matching business entry could not be found
	 */
	public static BusinessEntry getBusinessEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getBusinessEntryByUuidAndGroupId(uuid, groupId);
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
	 * Updates the business entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BusinessEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param businessEntry the business entry
	 * @return the business entry that was updated
	 */
	public static BusinessEntry updateBusinessEntry(
		BusinessEntry businessEntry) {

		return getService().updateBusinessEntry(businessEntry);
	}

	public static BusinessEntry updateBusinessEntry(
		long modifiedId, long businessId,
		com.swork.business.service.mapper.model.BusinessMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateBusinessEntry(
			modifiedId, businessId, model, serviceContext);
	}

	public static BusinessEntry updateStatus(
		long creatorId, long businessId, String status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateStatus(
			creatorId, businessId, status, serviceContext);
	}

	public static BusinessEntryLocalService getService() {
		return _service;
	}

	private static volatile BusinessEntryLocalService _service;

}