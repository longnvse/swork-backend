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
 * The table class for the &quot;SW_Resource&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceEntry
 * @generated
 */
public class ResourceEntryTable extends BaseTable<ResourceEntryTable> {

	public static final ResourceEntryTable INSTANCE = new ResourceEntryTable();

	public final Column<ResourceEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Long> resourceId = createColumn(
		"resourceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ResourceEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Long> accountId = createColumn(
		"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Long> businessId = createColumn(
		"businessId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Long> modifiedId = createColumn(
		"modifiedId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Long> workId = createColumn(
		"workId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Long> phaseId = createColumn(
		"phaseId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, String> resourceTypeName =
		createColumn(
			"resourceTypeName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Long> teamId = createColumn(
		"teamId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, String> teamName = createColumn(
		"teamName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Double> quantity = createColumn(
		"quantity", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, String> unit = createColumn(
		"unit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Date> dateResource = createColumn(
		"dateResource", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ResourceEntryTable, Long> totalAmount = createColumn(
		"totalAmount", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ResourceEntryTable() {
		super("SW_Resource", ResourceEntryTable::new);
	}

}