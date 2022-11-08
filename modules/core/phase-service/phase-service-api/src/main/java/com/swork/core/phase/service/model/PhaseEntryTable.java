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

import java.util.Date;

/**
 * The table class for the &quot;SW_Phase&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PhaseEntry
 * @generated
 */
public class PhaseEntryTable extends BaseTable<PhaseEntryTable> {

	public static final PhaseEntryTable INSTANCE = new PhaseEntryTable();

	public final Column<PhaseEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, Long> phaseId = createColumn(
		"phaseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PhaseEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, Long> creatorId = createColumn(
		"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, Long> businessId = createColumn(
		"businessId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, Long> modifiedId = createColumn(
		"modifiedId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, String> phaseName = createColumn(
		"phaseName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, Long> progress = createColumn(
		"progress", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PhaseEntryTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private PhaseEntryTable() {
		super("SW_Phase", PhaseEntryTable::new);
	}

}