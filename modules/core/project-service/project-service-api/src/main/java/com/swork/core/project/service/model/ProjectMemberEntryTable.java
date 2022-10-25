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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;SW_ProjectMember&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectMemberEntry
 * @generated
 */
public class ProjectMemberEntryTable
	extends BaseTable<ProjectMemberEntryTable> {

	public static final ProjectMemberEntryTable INSTANCE =
		new ProjectMemberEntryTable();

	public final Column<ProjectMemberEntryTable, Long> projectMemberId =
		createColumn(
			"projectMemberId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProjectMemberEntryTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectMemberEntryTable, Long> memberId = createColumn(
		"memberId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectMemberEntryTable, String> memberType =
		createColumn(
			"memberType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectMemberEntryTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProjectMemberEntryTable() {
		super("SW_ProjectMember", ProjectMemberEntryTable::new);
	}

}