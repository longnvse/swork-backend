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

package com.swork.core.resource.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;SW_TeamMember&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TeamMemberEntry
 * @generated
 */
public class TeamMemberEntryTable extends BaseTable<TeamMemberEntryTable> {

	public static final TeamMemberEntryTable INSTANCE =
		new TeamMemberEntryTable();

	public final Column<TeamMemberEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TeamMemberEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TeamMemberEntryTable, Long> teamMemberTaskId =
		createColumn(
			"teamMemberTaskId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TeamMemberEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TeamMemberEntryTable, Long> memberId = createColumn(
		"memberId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TeamMemberEntryTable, String> memberName = createColumn(
		"memberName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TeamMemberEntryTable, Boolean> isAdmin = createColumn(
		"isAdmin", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<TeamMemberEntryTable, Long> teamId = createColumn(
		"teamId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private TeamMemberEntryTable() {
		super("SW_TeamMember", TeamMemberEntryTable::new);
	}

}