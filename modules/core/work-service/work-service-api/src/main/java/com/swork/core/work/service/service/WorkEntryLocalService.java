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

package com.swork.core.work.service.service;

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

import com.swork.core.work.service.mapper.model.WorkMapperModel;
import com.swork.core.work.service.model.WorkEntry;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for WorkEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface WorkEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.swork.core.work.service.service.impl.WorkEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the work entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link WorkEntryLocalServiceUtil} if injection and service tracking are not available.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public WorkEntry addWorkEntry(
		long businessId, long creatorId, WorkMapperModel model,
		ServiceContext serviceContext);

	/**
	 * Adds the work entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workEntry the work entry
	 * @return the work entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public WorkEntry addWorkEntry(WorkEntry workEntry);

	public long calcProgress(List<WorkEntry> workEntries, String progressType);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new work entry with the primary key. Does not add the work entry to the database.
	 *
	 * @param workId the primary key for the new work entry
	 * @return the new work entry
	 */
	@Transactional(enabled = false)
	public WorkEntry createWorkEntry(long workId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the work entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry that was removed
	 * @throws PortalException if a work entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public WorkEntry deleteWorkEntry(long workId) throws PortalException;

	/**
	 * Deletes the work entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workEntry the work entry
	 * @return the work entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public WorkEntry deleteWorkEntry(WorkEntry workEntry);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.work.service.model.impl.WorkEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.work.service.model.impl.WorkEntryModelImpl</code>.
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
	public WorkEntry fetchWorkEntry(long workId);

	/**
	 * Returns the work entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the work entry's external reference code
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkEntry fetchWorkEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchWorkEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkEntry fetchWorkEntryByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the work entry matching the UUID and group.
	 *
	 * @param uuid the work entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work entry, or <code>null</code> if a matching work entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkEntry fetchWorkEntryByUuidAndGroupId(String uuid, long groupId);

	public WorkEntry findByP_Name(long projectId, String name);

	public List<WorkEntry> findByParentId(long businessId, long parentId);

	public List<WorkEntry> findByPhaseId(long phaseId, boolean hasChildren);

	public WorkEntry findByPID_Name(
		long businessId, long parentId, String name);

	public List<WorkEntry> findByProjectId(long projectId, boolean hasChildren);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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
	 * Returns a range of all the work entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.work.service.model.impl.WorkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @return the range of work entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WorkEntry> getWorkEntries(int start, int end);

	/**
	 * Returns all the work entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the work entries
	 * @param companyId the primary key of the company
	 * @return the matching work entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WorkEntry> getWorkEntriesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of work entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the work entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of work entries
	 * @param end the upper bound of the range of work entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching work entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<WorkEntry> getWorkEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkEntry> orderByComparator);

	/**
	 * Returns the number of work entries.
	 *
	 * @return the number of work entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getWorkEntriesCount();

	/**
	 * Returns the work entry with the primary key.
	 *
	 * @param workId the primary key of the work entry
	 * @return the work entry
	 * @throws PortalException if a work entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkEntry getWorkEntry(long workId) throws PortalException;

	/**
	 * Returns the work entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the work entry's external reference code
	 * @return the matching work entry
	 * @throws PortalException if a matching work entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkEntry getWorkEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException;

	/**
	 * Returns the work entry matching the UUID and group.
	 *
	 * @param uuid the work entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work entry
	 * @throws PortalException if a matching work entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkEntry getWorkEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public WorkEntry reportProgressByAmount(
		long creatorId, long workId, double completeAmount,
		ServiceContext serviceContext);

	@Indexable(type = IndexableType.REINDEX)
	public WorkEntry updateDateWorkEntry(
		long creatorId, long workId, Date startDate, Date endDate,
		ServiceContext serviceContext);

	@Indexable(type = IndexableType.REINDEX)
	public WorkEntry updateProcessWorkEntry(
		long creatorId, long workId, long progress,
		ServiceContext serviceContext);

	@Indexable(type = IndexableType.REINDEX)
	public WorkEntry updateProgress(long workId, long progress);

	@Indexable(type = IndexableType.REINDEX)
	public WorkEntry updateStatus(
		long creatorId, long workId, String status,
		ServiceContext serviceContext);

	@Indexable(type = IndexableType.REINDEX)
	public WorkEntry updateWorkEntry(
		long creatorId, long workId, WorkMapperModel model,
		ServiceContext serviceContext);

	/**
	 * Updates the work entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workEntry the work entry
	 * @return the work entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public WorkEntry updateWorkEntry(WorkEntry workEntry);

}