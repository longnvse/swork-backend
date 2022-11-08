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

package com.swork.core.project.service.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ProjectMemberEntry service. Represents a row in the &quot;SW_ProjectMember&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectMemberEntryModel
 * @generated
 */
@ImplementationClassName(
	"com.swork.core.project.service.model.impl.ProjectMemberEntryImpl"
)
@ProviderType
public interface ProjectMemberEntry
	extends PersistedModel, ProjectMemberEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.swork.core.project.service.model.impl.ProjectMemberEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProjectMemberEntry, Long>
		PROJECT_MEMBER_ID_ACCESSOR = new Accessor<ProjectMemberEntry, Long>() {

			@Override
			public Long get(ProjectMemberEntry projectMemberEntry) {
				return projectMemberEntry.getProjectMemberId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ProjectMemberEntry> getTypeClass() {
				return ProjectMemberEntry.class;
			}

		};

}