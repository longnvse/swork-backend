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

package com.swork.core.resource.service.service.base;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.swork.core.resource.service.model.ResourceEntry;
import com.swork.core.resource.service.service.ResourceEntryLocalService;
import com.swork.core.resource.service.service.ResourceEntryLocalServiceUtil;
import com.swork.core.resource.service.service.persistence.ResourceEntryPersistence;
import com.swork.core.resource.service.service.persistence.TeamEntryPersistence;
import com.swork.core.resource.service.service.persistence.TeamMemberEntryPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the resource entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.swork.core.resource.service.service.impl.ResourceEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.swork.core.resource.service.service.impl.ResourceEntryLocalServiceImpl
 * @generated
 */
public abstract class ResourceEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, ResourceEntryLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ResourceEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ResourceEntryLocalServiceUtil</code>.
	 */

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
	@Override
	public ResourceEntry addResourceEntry(ResourceEntry resourceEntry) {
		resourceEntry.setNew(true);

		return resourceEntryPersistence.update(resourceEntry);
	}

	/**
	 * Creates a new resource entry with the primary key. Does not add the resource entry to the database.
	 *
	 * @param resourceId the primary key for the new resource entry
	 * @return the new resource entry
	 */
	@Override
	@Transactional(enabled = false)
	public ResourceEntry createResourceEntry(long resourceId) {
		return resourceEntryPersistence.create(resourceId);
	}

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
	@Override
	public ResourceEntry deleteResourceEntry(long resourceId)
		throws PortalException {

		return resourceEntryPersistence.remove(resourceId);
	}

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
	@Override
	public ResourceEntry deleteResourceEntry(ResourceEntry resourceEntry) {
		return resourceEntryPersistence.remove(resourceEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return resourceEntryPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ResourceEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return resourceEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return resourceEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return resourceEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return resourceEntryPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return resourceEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ResourceEntry fetchResourceEntry(long resourceId) {
		return resourceEntryPersistence.fetchByPrimaryKey(resourceId);
	}

	/**
	 * Returns the resource entry matching the UUID and group.
	 *
	 * @param uuid the resource entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchResourceEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return resourceEntryPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the resource entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource entry's external reference code
	 * @return the matching resource entry, or <code>null</code> if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry fetchResourceEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return resourceEntryPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchResourceEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public ResourceEntry fetchResourceEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return fetchResourceEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource entry's external reference code
	 * @return the matching resource entry
	 * @throws PortalException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry getResourceEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return resourceEntryPersistence.findByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource entry with the primary key.
	 *
	 * @param resourceId the primary key of the resource entry
	 * @return the resource entry
	 * @throws PortalException if a resource entry with the primary key could not be found
	 */
	@Override
	public ResourceEntry getResourceEntry(long resourceId)
		throws PortalException {

		return resourceEntryPersistence.findByPrimaryKey(resourceId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(resourceEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ResourceEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("resourceId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			resourceEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ResourceEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("resourceId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(resourceEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ResourceEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("resourceId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ResourceEntry>() {

				@Override
				public void performAction(ResourceEntry resourceEntry)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, resourceEntry);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(ResourceEntry.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return resourceEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return resourceEntryLocalService.deleteResourceEntry(
			(ResourceEntry)persistedModel);
	}

	@Override
	public BasePersistence<ResourceEntry> getBasePersistence() {
		return resourceEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return resourceEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the resource entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource entries
	 * @param companyId the primary key of the company
	 * @return the matching resource entries, or an empty list if no matches were found
	 */
	@Override
	public List<ResourceEntry> getResourceEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return resourceEntryPersistence.findByUuid_C(uuid, companyId);
	}

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
	@Override
	public List<ResourceEntry> getResourceEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceEntry> orderByComparator) {

		return resourceEntryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the resource entry matching the UUID and group.
	 *
	 * @param uuid the resource entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource entry
	 * @throws PortalException if a matching resource entry could not be found
	 */
	@Override
	public ResourceEntry getResourceEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return resourceEntryPersistence.findByUUID_G(uuid, groupId);
	}

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
	@Override
	public List<ResourceEntry> getResourceEntries(int start, int end) {
		return resourceEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of resource entries.
	 *
	 * @return the number of resource entries
	 */
	@Override
	public int getResourceEntriesCount() {
		return resourceEntryPersistence.countAll();
	}

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
	@Override
	public ResourceEntry updateResourceEntry(ResourceEntry resourceEntry) {
		return resourceEntryPersistence.update(resourceEntry);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ResourceEntryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		resourceEntryLocalService = (ResourceEntryLocalService)aopProxy;

		_setLocalServiceUtilService(resourceEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ResourceEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ResourceEntry.class;
	}

	protected String getModelClassName() {
		return ResourceEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = resourceEntryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		ResourceEntryLocalService resourceEntryLocalService) {

		try {
			Field field = ResourceEntryLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, resourceEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected ResourceEntryLocalService resourceEntryLocalService;

	@Reference
	protected ResourceEntryPersistence resourceEntryPersistence;

	@Reference
	protected TeamEntryPersistence teamEntryPersistence;

	@Reference
	protected TeamMemberEntryPersistence teamMemberEntryPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}