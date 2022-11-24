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

import java.util.Date;

/**
 * The table class for the &quot;SW_Work&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see WorkEntry
 * @generated
 */
public class WorkEntryTable extends BaseTable<WorkEntryTable> {

	public static final WorkEntryTable INSTANCE = new WorkEntryTable();

	public final Column<WorkEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Long> workId = createColumn(
		"workId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<WorkEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Long> accountId = createColumn(
		"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Long> modifiedId = createColumn(
		"modifiedId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Long> businessId = createColumn(
		"businessId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Long> phaseId = createColumn(
		"phaseId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Long> parentId = createColumn(
		"parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, String> parentReferenceCode =
		createColumn(
			"parentReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Long> progress = createColumn(
		"progress", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Date> actualStartDate = createColumn(
		"actualStartDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Date> actualEndDate = createColumn(
		"actualEndDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Double> percentage = createColumn(
		"percentage", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, String> progressType = createColumn(
		"progressType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, String> unit = createColumn(
		"unit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Double> incompleteTask = createColumn(
		"incompleteTask", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<WorkEntryTable, Double> complete = createColumn(
		"complete", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private WorkEntryTable() {
		super("SW_Work", WorkEntryTable::new);
	}

}