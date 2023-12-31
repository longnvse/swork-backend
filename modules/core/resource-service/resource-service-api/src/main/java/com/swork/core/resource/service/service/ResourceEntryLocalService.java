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

package com.swork.core.resource.service.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.swork.core.resource.service.mapper.model.ResourceMapperModel;
import com.swork.core.resource.service.model.ResourceEntry;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ResourceEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ResourceEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.swork.core.resource.service.service.impl.ResourceEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the resource entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ResourceEntryLocalServiceUtil} if injection and service tracking are not available.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ResourceEntry addResourceEntry(
		long businessId, long creatorId, Long workId, Long phaseId,
		Long projectId, ResourceMapperModel model,
		ServiceContext serviceContext);

	/**
	 * Adds the resource entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceEntry the resource entry
	 * @return the resource entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ResourceEntry addResourceEntry(ResourceEntry resourceEntry);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new resource entry with the primary key. Does not add the resource entry to the database.
	 *
	 * @param resourceId the primary key for the new resource entry
	 * @return the new resource entry
	 */
	@Transactional(enabled = false)
	public ResourceEntry createResourceEntry(long resourceId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the resource entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry that was removed
	 * @throws PortalException if a resource entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ResourceEntry deleteResourceEntry(long resourceId)
		throws PortalException;

	/**
	 * Deletes the resource entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceEntry the resource entry
	 * @return the resource entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ResourceEntry deleteResourceEntry(ResourceEntry resourceEntry);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceEntryModelImpl</code>.
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
	public ResourceEntry fetchResourceEntry(long resourceId);

	/**
	 * Returns the resource entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource entry's external reference code
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ResourceEntry fetchResourceEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchResourceEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ResourceEntry fetchResourceEntryByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the resource entry matching the UUID and group.
	 *
	 * @param uuid the resource entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ResourceEntry fetchResourceEntryByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ResourceEntry> getByObjectGroupId(long businessId, long teamId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ResourceEntry> getByParentId(
		long businessId, long workId, long phaseId, long projectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ResourceEntry> getByPhaseId(long businessId, long phaseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ResourceEntry> getByProjectId(long businessId, long projectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ResourceEntry> getByTaskId(long businessId, long workId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

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
	 * Returns a range of all the resource entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @return the range of resource entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ResourceEntry> getResourceEntries(int start, int end);

	/**
	 * Returns all the resource entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource entries
	 * @param companyId the primary key of the company
	 * @return the matching resource entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ResourceEntry> getResourceEntriesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of resource entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of resource entries
	 * @param end the upper bound of the range of resource entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching resource entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ResourceEntry> getResourceEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator);

	/**
	 * Returns the number of resource entries.
	 *
	 * @return the number of resource entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getResourceEntriesCount();

	/**
	 * Returns the resource entry with the primary key.
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry
	 * @throws PortalException if a resource entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ResourceEntry getResourceEntry(long resourceId)
		throws PortalException;

	/**
	 * Returns the resource entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource entry's external reference code
	 * @return the matching resource entry
	 * @throws PortalException if a matching resource entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ResourceEntry getResourceEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException;

	/**
	 * Returns the resource entry matching the UUID and group.
	 *
	 * @param uuid the resource entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource entry
	 * @throws PortalException if a matching resource entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ResourceEntry getResourceEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public ResourceEntry updateResourceEntry(
		long creatorId, long resourceId, ResourceMapperModel model,
		ServiceContext serviceContext);

	/**
	 * Updates the resource entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceEntry the resource entry
	 * @return the resource entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ResourceEntry updateResourceEntry(ResourceEntry resourceEntry);

}