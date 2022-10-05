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

import com.swork.business.service.mapper.model.BusinessMapperModel;
import com.swork.business.service.model.BusinessEntry;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for BusinessEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see BusinessEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface BusinessEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.swork.business.service.service.impl.BusinessEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the business entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link BusinessEntryLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public BusinessEntry addBusinessEntry(BusinessEntry businessEntry);

	@Indexable(type = IndexableType.REINDEX)
	public BusinessEntry addBusinessEntry(
		long creatorId, BusinessMapperModel model,
		ServiceContext serviceContext);

	/**
	 * Creates a new business entry with the primary key. Does not add the business entry to the database.
	 *
	 * @param businessId the primary key for the new business entry
	 * @return the new business entry
	 */
	@Transactional(enabled = false)
	public BusinessEntry createBusinessEntry(long businessId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public BusinessEntry deleteBusinessEntry(BusinessEntry businessEntry);

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
	@Indexable(type = IndexableType.DELETE)
	public BusinessEntry deleteBusinessEntry(long businessId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.business.service.model.impl.BusinessEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.swork.business.service.model.impl.BusinessEntryModelImpl</code>.
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
	public BusinessEntry fetchBusinessEntry(long businessId);

	/**
	 * Returns the business entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the business entry's external reference code
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BusinessEntry fetchBusinessEntryByExternalReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link #fetchBusinessEntryByExternalReferenceCode(long, String)}
	 */
	@Deprecated
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BusinessEntry fetchBusinessEntryByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the business entry matching the UUID and group.
	 *
	 * @param uuid the business entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching business entry, or <code>null</code> if a matching business entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BusinessEntry fetchBusinessEntryByUuidAndGroupId(
		String uuid, long groupId);

	public BusinessEntry findByEmail(String email);

	public BusinessEntry findByName(String name);

	public BusinessEntry findByPhoneNumber(String phoneNumber);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BusinessEntry> getBusinessEntries(int start, int end);

	/**
	 * Returns all the business entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the business entries
	 * @param companyId the primary key of the company
	 * @return the matching business entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BusinessEntry> getBusinessEntriesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BusinessEntry> getBusinessEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BusinessEntry> orderByComparator);

	/**
	 * Returns the number of business entries.
	 *
	 * @return the number of business entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBusinessEntriesCount();

	/**
	 * Returns the business entry with the primary key.
	 *
	 * @param businessId the primary key of the business entry
	 * @return the business entry
	 * @throws PortalException if a business entry with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BusinessEntry getBusinessEntry(long businessId)
		throws PortalException;

	/**
	 * Returns the business entry with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the business entry's external reference code
	 * @return the matching business entry
	 * @throws PortalException if a matching business entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BusinessEntry getBusinessEntryByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException;

	/**
	 * Returns the business entry matching the UUID and group.
	 *
	 * @param uuid the business entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching business entry
	 * @throws PortalException if a matching business entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BusinessEntry getBusinessEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	 * Updates the business entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BusinessEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param businessEntry the business entry
	 * @return the business entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public BusinessEntry updateBusinessEntry(BusinessEntry businessEntry);

	@Indexable(type = IndexableType.REINDEX)
	public BusinessEntry updateBusinessEntry(
		long modifiedId, long businessId, BusinessMapperModel model,
		ServiceContext serviceContext);

}