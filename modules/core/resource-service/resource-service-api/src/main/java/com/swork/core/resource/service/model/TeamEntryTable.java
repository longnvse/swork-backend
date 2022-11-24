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

import java.util.Date;

/**
 * The table class for the &quot;SW_Team&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TeamEntry
 * @generated
 */
public class TeamEntryTable extends BaseTable<TeamEntryTable> {

	public static final TeamEntryTable INSTANCE = new TeamEntryTable();

	public final Column<TeamEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Long> teamId = createColumn(
		"teamId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TeamEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Long> accountId = createColumn(
		"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Long> businessId = createColumn(
		"businessId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Long> modifiedId = createColumn(
		"modifiedId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Long> phaseId = createColumn(
		"phaseId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Long> totalIncoming = createColumn(
		"totalIncoming", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TeamEntryTable, Long> totalSpending = createColumn(
		"totalSpending", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private TeamEntryTable() {
		super("SW_Team", TeamEntryTable::new);
	}

}