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

package com.swork.core.phase.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;SW_PhaseManage&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PhaseManageEntry
 * @generated
 */
public class PhaseManageEntryTable extends BaseTable<PhaseManageEntryTable> {

	public static final PhaseManageEntryTable INSTANCE =
		new PhaseManageEntryTable();

	public final Column<PhaseManageEntryTable, Long> phaseManageId =
		createColumn(
			"phaseManageId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PhaseManageEntryTable, Long> phaseId = createColumn(
		"phaseId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhaseManageEntryTable, Long> accountId = createColumn(
		"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private PhaseManageEntryTable() {
		super("SW_PhaseManage", PhaseManageEntryTable::new);
	}

}