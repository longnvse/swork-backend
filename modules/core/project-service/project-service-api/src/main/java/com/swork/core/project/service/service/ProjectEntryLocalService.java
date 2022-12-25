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

package com.swork.core.project.service.service;

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

import com.swork.core.project.service.mapper.model.ProjectMapperModel;
import com.swork.core.project.service.model.ProjectEntry;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ProjectEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ProjectEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.swork.core.project.service.service.impl.ProjectEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the project entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ProjectEntryLocalServiceUtil} if injection and service tracking are not available.
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Transactional(
		isolation = Isolation.PORTAL,
		rollbackFor = {PortalException.class, SystemException.class}
	)
	public ProjectEntry addProject(
		long businessId, long creatorId, ProjectMapperModel model,
		ServiceContext serviceContext);

	/**
	 * Adds the project entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEntry the project entry
	 * @return the project entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ProjectEntry addProjectEntry(ProjectEntry projectEntry);

	@Indexable(type = IndexableType.REINDEX)
	public ProjectEntry approvalProject(
		long creatorId, long projectId, String status,
		ServiceContext serviceContext);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new project entry with the primary key. Does not add the project entry to the database.
	 *
	 * @param projectId the primary key for the new project entry
	 * @return the new project entry
	 */
	@Transactional(enabled = false)
	public ProjectEntry createProjectEntry(long projectId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the project entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry that was removed
	 * @throws PortalException if a project entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ProjectEntry deleteProjectEntry(long projectId)
		throws PortalException;

	/**
	 * Deletes the project entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEntry the project entry
	 * @return the project entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ProjectEntry deleteProjectEntry(ProjectEntry projectEntry);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectEntryModelImpl</code>.
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
	public ProjectEntry fetchProjectEntry(long projectId);

	/**
	 * Returns the project entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the project entry's external reference code
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectEntry fetchProjectEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchProjectEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectEntry fetchProjectEntryByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the project entry matching the UUID and group.
	 *
	 * @param uuid the project entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project entry, or <code>null</code> if a matching project entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectEntry fetchProjectEntryByUuidAndGroupId(
		String uuid, long groupId);

	public List<ProjectEntry> findByBusinessId(long businessId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectEntry getByCode(long businessId, String projectCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectEntry getByName(long businessId, String projectName);

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
	 * Returns a range of all the project entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.project.service.model.impl.ProjectEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @return the range of project entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProjectEntry> getProjectEntries(int start, int end);

	/**
	 * Returns all the project entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the project entries
	 * @param companyId the primary key of the company
	 * @return the matching project entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProjectEntry> getProjectEntriesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of project entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the project entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of project entries
	 * @param end the upper bound of the range of project entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching project entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProjectEntry> getProjectEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectEntry> orderByComparator);

	/**
	 * Returns the number of project entries.
	 *
	 * @return the number of project entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProjectEntriesCount();

	/**
	 * Returns the project entry with the primary key.
	 *
	 * @param projectId the primary key of the project entry
	 * @return the project entry
	 * @throws PortalException if a project entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectEntry getProjectEntry(long projectId) throws PortalException;

	/**
	 * Returns the project entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the project entry's external reference code
	 * @return the matching project entry
	 * @throws PortalException if a matching project entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectEntry getProjectEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException;

	/**
	 * Returns the project entry matching the UUID and group.
	 *
	 * @param uuid the project entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project entry
	 * @throws PortalException if a matching project entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectEntry getProjectEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public ProjectEntry updateActualDate(
		long creatorId, long projectId, Date actualStartDate,
		Date actualEndDate, ServiceContext serviceContext);

	@Indexable(type = IndexableType.REINDEX)
	public ProjectEntry updateDate(
		long creatorId, long projectId, Date startDate, Date endDate,
		ServiceContext serviceContext);

	@Indexable(type = IndexableType.REINDEX)
	public ProjectEntry updateDescription(
		long creatorId, long projectId, String description,
		ServiceContext serviceContext);

	@Indexable(type = IndexableType.REINDEX)
	public ProjectEntry updateMember(
		long creatorId, long projectId, ProjectMapperModel model,
		ServiceContext serviceContext);

	@Indexable(type = IndexableType.REINDEX)
	public ProjectEntry updateProgress(long projectId, long progress);

	@Indexable(type = IndexableType.REINDEX)
	@Transactional(
		isolation = Isolation.PORTAL,
		rollbackFor = {PortalException.class, SystemException.class}
	)
	public ProjectEntry updateProject(
		long creatorId, long projectId, ProjectMapperModel model,
		ServiceContext serviceContext);

	/**
	 * Updates the project entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEntry the project entry
	 * @return the project entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ProjectEntry updateProjectEntry(ProjectEntry projectEntry);

}