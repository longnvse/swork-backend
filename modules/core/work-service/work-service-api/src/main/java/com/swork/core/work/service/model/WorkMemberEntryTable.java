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

package com.swork.core.work.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;SW_WorkMember&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see WorkMemberEntry
 * @generated
 */
public class WorkMemberEntryTable extends BaseTable<WorkMemberEntryTable> {

	public static final WorkMemberEntryTable INSTANCE =
		new WorkMemberEntryTable();

	public final Column<WorkMemberEntryTable, Long> workMemberId = createColumn(
		"workMemberId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<WorkMemberEntryTable, Long> workId = createColumn(
		"workId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkMemberEntryTable, Long> memberId = createColumn(
		"memberId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkMemberEntryTable, String> memberType = createColumn(
		"memberType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkMemberEntryTable, String> memberReferenceCode =
		createColumn(
			"memberReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<WorkMemberEntryTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private WorkMemberEntryTable() {
		super("SW_WorkMember", WorkMemberEntryTable::new);
	}

}