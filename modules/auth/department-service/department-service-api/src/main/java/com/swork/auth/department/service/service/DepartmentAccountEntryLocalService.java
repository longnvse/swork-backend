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

package com.swork.auth.department.service.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.auth.department.service.model.DepartmentAccountEntry;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DepartmentAccountEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentAccountEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DepartmentAccountEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.swork.auth.department.service.service.impl.DepartmentAccountEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the department account entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DepartmentAccountEntryLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the department account entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentAccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentAccountEntry the department account entry
	 * @return the department account entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DepartmentAccountEntry addDepartmentAccountEntry(
		DepartmentAccountEntry departmentAccountEntry);

	public DepartmentAccountEntry addDepartmentAccountEntry(
		long departmentId, long accountId, long companyId);

	/**
	 * Creates a new department account entry with the primary key. Does not add the department account entry to the database.
	 *
	 * @param departmentAccountId the primary key for the new department account entry
	 * @return the new department account entry
	 */
	@Transactional(enabled = false)
	public DepartmentAccountEntry createDepartmentAccountEntry(
		long departmentAccountId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void deleteByDepartmentId(long departmentId);

	/**
	 * Deletes the department account entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentAccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentAccountEntry the department account entry
	 * @return the department account entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DepartmentAccountEntry deleteDepartmentAccountEntry(
		DepartmentAccountEntry departmentAccountEntry);

	/**
	 * Deletes the department account entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentAccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry that was removed
	 * @throws PortalException if a department account entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DepartmentAccountEntry deleteDepartmentAccountEntry(
			long departmentAccountId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.auth.department.service.model.impl.DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.auth.department.service.model.impl.DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DepartmentAccountEntry fetchDepartmentAccountEntry(
		long departmentAccountId);

	/**
	 * Returns the department account entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the department account entry's external reference code
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DepartmentAccountEntry
		fetchDepartmentAccountEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode);

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchDepartmentAccountEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DepartmentAccountEntry fetchDepartmentAccountEntryByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the department account entry matching the UUID and group.
	 *
	 * @param uuid the department account entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching department account entry, or <code>null</code> if a matching department account entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DepartmentAccountEntry fetchDepartmentAccountEntryByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DepartmentAccountEntry getByAccountId(long accountId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DepartmentAccountEntry> getByDepartmentId(long departmentId);

	/**
	 * Returns a range of all the department account entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.auth.department.service.model.impl.DepartmentAccountEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @return the range of department account entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DepartmentAccountEntry> getDepartmentAccountEntries(
		int start, int end);

	/**
	 * Returns all the department account entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the department account entries
	 * @param companyId the primary key of the company
	 * @return the matching department account entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DepartmentAccountEntry>
		getDepartmentAccountEntriesByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of department account entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the department account entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of department account entries
	 * @param end the upper bound of the range of department account entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching department account entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DepartmentAccountEntry>
		getDepartmentAccountEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DepartmentAccountEntry> orderByComparator);

	/**
	 * Returns the number of department account entries.
	 *
	 * @return the number of department account entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDepartmentAccountEntriesCount();

	/**
	 * Returns the department account entry with the primary key.
	 *
	 * @param departmentAccountId the primary key of the department account entry
	 * @return the department account entry
	 * @throws PortalException if a department account entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DepartmentAccountEntry getDepartmentAccountEntry(
			long departmentAccountId)
		throws PortalException;

	/**
	 * Returns the department account entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the department account entry's external reference code
	 * @return the matching department account entry
	 * @throws PortalException if a matching department account entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DepartmentAccountEntry
			getDepartmentAccountEntryByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws PortalException;

	/**
	 * Returns the department account entry matching the UUID and group.
	 *
	 * @param uuid the department account entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching department account entry
	 * @throws PortalException if a matching department account entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DepartmentAccountEntry getDepartmentAccountEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the department account entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentAccountEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentAccountEntry the department account entry
	 * @return the department account entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DepartmentAccountEntry updateDepartmentAccountEntry(
		DepartmentAccountEntry departmentAccountEntry);

}