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

import java.util.Date;

/**
 * The table class for the &quot;SW_Department&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentEntry
 * @generated
 */
public class DepartmentEntryTable extends BaseTable<DepartmentEntryTable> {

	public static final DepartmentEntryTable INSTANCE =
		new DepartmentEntryTable();

	public final Column<DepartmentEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DepartmentEntryTable, Long> departmentId = createColumn(
		"departmentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DepartmentEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentEntryTable, Long> accountId = createColumn(
		"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DepartmentEntryTable, Long> modifiedId = createColumn(
		"modifiedId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DepartmentEntryTable, Long> businessId = createColumn(
		"businessId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentEntryTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DepartmentEntryTable() {
		super("SW_Department", DepartmentEntryTable::new);
	}

}