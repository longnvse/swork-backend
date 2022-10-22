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

package com.swork.checklist.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;SW_ChecklistHandler&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ChecklistHandlerEntry
 * @generated
 */
public class ChecklistHandlerEntryTable
	extends BaseTable<ChecklistHandlerEntryTable> {

	public static final ChecklistHandlerEntryTable INSTANCE =
		new ChecklistHandlerEntryTable();

	public final Column<ChecklistHandlerEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ChecklistHandlerEntryTable, Long> checklistHandlerId =
		createColumn(
			"checklistHandlerId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ChecklistHandlerEntryTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ChecklistHandlerEntryTable, Long> checkListId =
		createColumn(
			"checkListId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ChecklistHandlerEntryTable, Long> accId = createColumn(
		"accId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ChecklistHandlerEntryTable() {
		super("SW_ChecklistHandler", ChecklistHandlerEntryTable::new);
	}

}