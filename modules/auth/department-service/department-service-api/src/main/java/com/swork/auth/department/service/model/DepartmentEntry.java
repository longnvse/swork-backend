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

package com.swork.auth.department.service.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DepartmentEntry service. Represents a row in the &quot;SW_Department&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentEntryModel
 * @generated
 */
@ImplementationClassName(
	"com.swork.auth.department.service.model.impl.DepartmentEntryImpl"
)
@ProviderType
public interface DepartmentEntry extends DepartmentEntryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.swork.auth.department.service.model.impl.DepartmentEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DepartmentEntry, Long> DEPARTMENT_ID_ACCESSOR =
		new Accessor<DepartmentEntry, Long>() {

			@Override
			public Long get(DepartmentEntry departmentEntry) {
				return departmentEntry.getDepartmentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DepartmentEntry> getTypeClass() {
				return DepartmentEntry.class;
			}

		};

}