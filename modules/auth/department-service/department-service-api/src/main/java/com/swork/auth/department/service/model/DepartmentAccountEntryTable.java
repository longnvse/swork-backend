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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;SW_DepartmentAccount&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentAccountEntry
 * @generated
 */
public class DepartmentAccountEntryTable
	extends BaseTable<DepartmentAccountEntryTable> {

	public static final DepartmentAccountEntryTable INSTANCE =
		new DepartmentAccountEntryTable();

	public final Column<DepartmentAccountEntryTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentAccountEntryTable, String>
		externalReferenceCode = createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DepartmentAccountEntryTable, Long> departmentAccountId =
		createColumn(
			"departmentAccountId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DepartmentAccountEntryTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentAccountEntryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentAccountEntryTable, Long> departmentId =
		createColumn(
			"departmentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentAccountEntryTable, Long> accountId =
		createColumn(
			"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DepartmentAccountEntryTable() {
		super("SW_DepartmentAccount", DepartmentAccountEntryTable::new);
	}

}