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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BusinessEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BusinessEntryLocalService
 * @generated
 */
public class BusinessEntryLocalServiceWrapper
	implements BusinessEntryLocalService,
			   ServiceWrapper<BusinessEntryLocalService> {

	public BusinessEntryLocalServiceWrapper(
		BusinessEntryLocalService businessEntryLocalService) {

		_businessEntryLocalService = businessEntryLocalService;
	}

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
	@Override
	public com.swork.business.service.model.BusinessEntry addBusinessEntry(
		com.swork.business.service.model.BusinessEntry businessEntry) {

		return _businessEntryLocalService.addBusinessEntry(businessEntry);
	}

	@Override
	public com.swork.business.service.model.BusinessEntry addBusinessEntry(
		long creatorId,
		com.swork.business.service.mapper.model.BusinessMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _businessEntryLocalService.addBusinessEntry(
			creatorId, model, serviceContext);
	}

	/**
	 * Creates a new business entry with the primary key. Does not add the business entry to the database.
	 *
	 * @param businessId the primary key for the new business entry
	 * @return the new business entry
	 */
	@Override
	public com.swork.business.service.model.BusinessEntry createBusinessEntry(
		long businessId) {

		return _businessEntryLocalService.createBusinessEntry(businessId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _businessEntryLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.swork.business.service.model.BusinessEntry deleteBusinessEntry(
		com.swork.business.service.model.BusinessEntry businessEntry) {

		return _businessEntryLocalService.deleteBusinessEntry(businessEntry);
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
	@Override
	public com.swork.business.service.model.BusinessEntry deleteBusinessEntry(
			long businessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _businessEntryLocalService.deleteBusinessEntry(businessId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _businessEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _businessEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _businessEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _businessEntryLocalService.dynamicQuery();
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

		return _businessEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _businessEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _businessEntryLocalService.dynamicQuery(
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

		return _businessEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _businessEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.swork.business.service.model.BusinessEntry fetchBusinessEntry(
		long businessId) {

		return _businessEntryLocalService.fetchBusinessEntry(businessId);
	}

	/**
	 * Returns the business entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the business entry's external reference code
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public com.swork.business.service.model.BusinessEntry
		fetchBusinessEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _businessEntryLocalService.
			fetchBusinessEntryByExternalReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchBusinessEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public com.swork.business.service.model.BusinessEntry
		fetchBusinessEntryByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _businessEntryLocalService.fetchBusinessEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the business entry matching the UUID and group.
	 *
	 * @param uuid the business entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Override
	public com.swork.business.service.model.BusinessEntry
		fetchBusinessEntryByUuidAndGroupId(String uuid, long groupId) {

		return _businessEntryLocalService.fetchBusinessEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.swork.business.service.model.BusinessEntry findByEmail(
		String email) {

		return _businessEntryLocalService.findByEmail(email);
	}

	@Override
	public com.swork.business.service.model.BusinessEntry findByName(
		String name) {

		return _businessEntryLocalService.findByName(name);
	}

	@Override
	public com.swork.business.service.model.BusinessEntry findByPhoneNumber(
		String phoneNumber) {

		return _businessEntryLocalService.findByPhoneNumber(phoneNumber);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _businessEntryLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<com.swork.business.service.model.BusinessEntry>
		getBusinessEntries(int start, int end) {

		return _businessEntryLocalService.getBusinessEntries(start, end);
	}

	/**
	 * Returns all the business entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the business entries
	 * @param companyId the primary key of the company
	 * @return the matching business entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.swork.business.service.model.BusinessEntry>
		getBusinessEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _businessEntryLocalService.getBusinessEntriesByUuidAndCompanyId(
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
	@Override
	public java.util.List<com.swork.business.service.model.BusinessEntry>
		getBusinessEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.swork.business.service.model.BusinessEntry>
					orderByComparator) {

		return _businessEntryLocalService.getBusinessEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of business entries.
	 *
	 * @return the number of business entries
	 */
	@Override
	public int getBusinessEntriesCount() {
		return _businessEntryLocalService.getBusinessEntriesCount();
	}

	/**
	 * Returns the business entry with the primary key.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry
	 * @throws PortalException if a business entry with the primary key could not be found
	 */
	@Override
	public com.swork.business.service.model.BusinessEntry getBusinessEntry(
			long businessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _businessEntryLocalService.getBusinessEntry(businessId);
	}

	/**
	 * Returns the business entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the business entry's external reference code
	 * @return the matching business entry
	 * @throws PortalException if a matching business entry could not be found
	 */
	@Override
	public com.swork.business.service.model.BusinessEntry
			getBusinessEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _businessEntryLocalService.
			getBusinessEntryByExternalReferenceCode(
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
	@Override
	public com.swork.business.service.model.BusinessEntry
			getBusinessEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _businessEntryLocalService.getBusinessEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _businessEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _businessEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _businessEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _businessEntryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.swork.business.service.model.BusinessEntry updateBusinessEntry(
		com.swork.business.service.model.BusinessEntry businessEntry) {

		return _businessEntryLocalService.updateBusinessEntry(businessEntry);
	}

	@Override
	public com.swork.business.service.model.BusinessEntry updateBusinessEntry(
		long modifiedId, long businessId,
		com.swork.business.service.mapper.model.BusinessMapperModel model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _businessEntryLocalService.updateBusinessEntry(
			modifiedId, businessId, model, serviceContext);
	}

	@Override
	public com.swork.business.service.model.BusinessEntry updateStatus(
		long creatorId, long businessId, String status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _businessEntryLocalService.updateStatus(
			creatorId, businessId, status, serviceContext);
	}

	@Override
	public BusinessEntryLocalService getWrappedService() {
		return _businessEntryLocalService;
	}

	@Override
	public void setWrappedService(
		BusinessEntryLocalService businessEntryLocalService) {

		_businessEntryLocalService = businessEntryLocalService;
	}

	private BusinessEntryLocalService _businessEntryLocalService;

}