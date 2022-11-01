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

package com.swork.account.service.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.account.service.model.PermissionEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PermissionEntry. This utility wraps
 * <code>com.swork.account.service.service.impl.PermissionEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PermissionEntryLocalService
 * @generated
 */
public class PermissionEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.swork.account.service.service.impl.PermissionEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the permission entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permissionEntry the permission entry
	 * @return the permission entry that was added
	 */
	public static PermissionEntry addPermissionEntry(
		PermissionEntry permissionEntry) {

		return getService().addPermissionEntry(permissionEntry);
	}

	/**
	 * Creates a new permission entry with the primary key. Does not add the permission entry to the database.
	 *
	 * @param id the primary key for the new permission entry
	 * @return the new permission entry
	 */
	public static PermissionEntry createPermissionEntry(long id) {
		return getService().createPermissionEntry(id);
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
	 * Deletes the permission entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the permission entry
	 * @return the permission entry that was removed
	 * @throws PortalException if a permission entry with the primary key could not be found
	 */
	public static PermissionEntry deletePermissionEntry(long id)
		throws PortalException {

		return getService().deletePermissionEntry(id);
	}

	/**
	 * Deletes the permission entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permissionEntry the permission entry
	 * @return the permission entry that was removed
	 */
	public static PermissionEntry deletePermissionEntry(
		PermissionEntry permissionEntry) {

		return getService().deletePermissionEntry(permissionEntry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermissionEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermissionEntryModelImpl</code>.
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

	public static PermissionEntry fetchPermissionEntry(long id) {
		return getService().fetchPermissionEntry(id);
	}

	/**
	 * Returns the permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the permission entry's external reference code
	 * @return the matching permission entry, or <code>null</code> if a matching permission entry could not be found
	 */
	public static PermissionEntry fetchPermissionEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchPermissionEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchPermissionEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	public static PermissionEntry fetchPermissionEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return getService().fetchPermissionEntryByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the permission entry with the matching UUID and company.
	 *
	 * @param uuid the permission entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching permission entry, or <code>null</code> if a matching permission entry could not be found
	 */
	public static PermissionEntry fetchPermissionEntryByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchPermissionEntryByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns a range of all the permission entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.account.service.model.impl.PermissionEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission entries
	 * @param end the upper bound of the range of permission entries (not inclusive)
	 * @return the range of permission entries
	 */
	public static List<PermissionEntry> getPermissionEntries(
		int start, int end) {

		return getService().getPermissionEntries(start, end);
	}

	/**
	 * Returns the number of permission entries.
	 *
	 * @return the number of permission entries
	 */
	public static int getPermissionEntriesCount() {
		return getService().getPermissionEntriesCount();
	}

	/**
	 * Returns the permission entry with the primary key.
	 *
	 * @param id the primary key of the permission entry
	 * @return the permission entry
	 * @throws PortalException if a permission entry with the primary key could not be found
	 */
	public static PermissionEntry getPermissionEntry(long id)
		throws PortalException {

		return getService().getPermissionEntry(id);
	}

	/**
	 * Returns the permission entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the permission entry's external reference code
	 * @return the matching permission entry
	 * @throws PortalException if a matching permission entry could not be found
	 */
	public static PermissionEntry getPermissionEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return getService().getPermissionEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the permission entry with the matching UUID and company.
	 *
	 * @param uuid the permission entry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching permission entry
	 * @throws PortalException if a matching permission entry could not be found
	 */
	public static PermissionEntry getPermissionEntryByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getPermissionEntryByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the permission entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PermissionEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param permissionEntry the permission entry
	 * @return the permission entry that was updated
	 */
	public static PermissionEntry updatePermissionEntry(
		PermissionEntry permissionEntry) {

		return getService().updatePermissionEntry(permissionEntry);
	}

	public static PermissionEntryLocalService getService() {
		return _service;
	}

	private static volatile PermissionEntryLocalService _service;

}