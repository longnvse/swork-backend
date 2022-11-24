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

import com.swork.core.resource.service.model.ResourceTypeEntry;
import com.swork.core.resource.service.service.ResourceTypeEntryLocalService;
import com.swork.core.resource.service.service.ResourceTypeEntryLocalServiceUtil;
import com.swork.core.resource.service.service.persistence.ResourceEntryPersistence;
import com.swork.core.resource.service.service.persistence.ResourceTypeEntryPersistence;
import com.swork.core.resource.service.service.persistence.TeamEntryPersistence;
import com.swork.core.resource.service.service.persistence.TeamMemberEntryPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the resource type entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.swork.core.resource.service.service.impl.ResourceTypeEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.swork.core.resource.service.service.impl.ResourceTypeEntryLocalServiceImpl
 * @generated
 */
public abstract class ResourceTypeEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   ResourceTypeEntryLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ResourceTypeEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ResourceTypeEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the resource type entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceTypeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceTypeEntry the resource type entry
	 * @return the resource type entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ResourceTypeEntry addResourceTypeEntry(
		ResourceTypeEntry resourceTypeEntry) {

		resourceTypeEntry.setNew(true);

		return resourceTypeEntryPersistence.update(resourceTypeEntry);
	}

	/**
	 * Creates a new resource type entry with the primary key. Does not add the resource type entry to the database.
	 *
	 * @param resourceTypeId the primary key for the new resource type entry
	 * @return the new resource type entry
	 */
	@Override
	@Transactional(enabled = false)
	public ResourceTypeEntry createResourceTypeEntry(long resourceTypeId) {
		return resourceTypeEntryPersistence.create(resourceTypeId);
	}

	/**
	 * Deletes the resource type entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceTypeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry that was removed
	 * @throws PortalException if a resource type entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ResourceTypeEntry deleteResourceTypeEntry(long resourceTypeId)
		throws PortalException {

		return resourceTypeEntryPersistence.remove(resourceTypeId);
	}

	/**
	 * Deletes the resource type entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceTypeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceTypeEntry the resource type entry
	 * @return the resource type entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ResourceTypeEntry deleteResourceTypeEntry(
		ResourceTypeEntry resourceTypeEntry) {

		return resourceTypeEntryPersistence.remove(resourceTypeEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return resourceTypeEntryPersistence.dslQuery(dslQuery);
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
			ResourceTypeEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return resourceTypeEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceTypeEntryModelImpl</code>.
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

		return resourceTypeEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceTypeEntryModelImpl</code>.
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

		return resourceTypeEntryPersistence.findWithDynamicQuery(
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
		return resourceTypeEntryPersistence.countWithDynamicQuery(dynamicQuery);
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

		return resourceTypeEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ResourceTypeEntry fetchResourceTypeEntry(long resourceTypeId) {
		return resourceTypeEntryPersistence.fetchByPrimaryKey(resourceTypeId);
	}

	/**
	 * Returns the resource type entry matching the UUID and group.
	 *
	 * @param uuid the resource type entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchResourceTypeEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return resourceTypeEntryPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the resource type entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource type entry's external reference code
	 * @return the matching resource type entry, or <code>null</code> if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry fetchResourceTypeEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		return resourceTypeEntryPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchResourceTypeEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Override
	public ResourceTypeEntry fetchResourceTypeEntryByReferenceCode(
		long companyId, String externalReferenceCode) {

		return fetchResourceTypeEntryByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource type entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the resource type entry's external reference code
	 * @return the matching resource type entry
	 * @throws PortalException if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry getResourceTypeEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException {

		return resourceTypeEntryPersistence.findByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the resource type entry with the primary key.
	 *
	 * @param resourceTypeId the primary key of the resource type entry
	 * @return the resource type entry
	 * @throws PortalException if a resource type entry with the primary key could not be found
	 */
	@Override
	public ResourceTypeEntry getResourceTypeEntry(long resourceTypeId)
		throws PortalException {

		return resourceTypeEntryPersistence.findByPrimaryKey(resourceTypeId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			resourceTypeEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ResourceTypeEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("resourceTypeId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			resourceTypeEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ResourceTypeEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"resourceTypeId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			resourceTypeEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ResourceTypeEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("resourceTypeId");
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
			new ActionableDynamicQuery.PerformActionMethod
				<ResourceTypeEntry>() {

				@Override
				public void performAction(ResourceTypeEntry resourceTypeEntry)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, resourceTypeEntry);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(ResourceTypeEntry.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return resourceTypeEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return resourceTypeEntryLocalService.deleteResourceTypeEntry(
			(ResourceTypeEntry)persistedModel);
	}

	@Override
	public BasePersistence<ResourceTypeEntry> getBasePersistence() {
		return resourceTypeEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return resourceTypeEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the resource type entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource type entries
	 * @param companyId the primary key of the company
	 * @return the matching resource type entries, or an empty list if no matches were found
	 */
	@Override
	public List<ResourceTypeEntry> getResourceTypeEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return resourceTypeEntryPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of resource type entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource type entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching resource type entries, or an empty list if no matches were found
	 */
	@Override
	public List<ResourceTypeEntry> getResourceTypeEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceTypeEntry> orderByComparator) {

		return resourceTypeEntryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the resource type entry matching the UUID and group.
	 *
	 * @param uuid the resource type entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource type entry
	 * @throws PortalException if a matching resource type entry could not be found
	 */
	@Override
	public ResourceTypeEntry getResourceTypeEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return resourceTypeEntryPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the resource type entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.core.resource.service.model.impl.ResourceTypeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource type entries
	 * @param end the upper bound of the range of resource type entries (not inclusive)
	 * @return the range of resource type entries
	 */
	@Override
	public List<ResourceTypeEntry> getResourceTypeEntries(int start, int end) {
		return resourceTypeEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of resource type entries.
	 *
	 * @return the number of resource type entries
	 */
	@Override
	public int getResourceTypeEntriesCount() {
		return resourceTypeEntryPersistence.countAll();
	}

	/**
	 * Updates the resource type entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceTypeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceTypeEntry the resource type entry
	 * @return the resource type entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ResourceTypeEntry updateResourceTypeEntry(
		ResourceTypeEntry resourceTypeEntry) {

		return resourceTypeEntryPersistence.update(resourceTypeEntry);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ResourceTypeEntryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		resourceTypeEntryLocalService = (ResourceTypeEntryLocalService)aopProxy;

		_setLocalServiceUtilService(resourceTypeEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ResourceTypeEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ResourceTypeEntry.class;
	}

	protected String getModelClassName() {
		return ResourceTypeEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				resourceTypeEntryPersistence.getDataSource();

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
		ResourceTypeEntryLocalService resourceTypeEntryLocalService) {

		try {
			Field field =
				ResourceTypeEntryLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, resourceTypeEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ResourceEntryPersistence resourceEntryPersistence;

	protected ResourceTypeEntryLocalService resourceTypeEntryLocalService;

	@Reference
	protected ResourceTypeEntryPersistence resourceTypeEntryPersistence;

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