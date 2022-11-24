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
 * The table class for the &quot;SW_ResourceType&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceTypeEntry
 * @generated
 */
public class ResourceTypeEntryTable extends BaseTable<ResourceTypeEntryTable> {

	public static final ResourceTypeEntryTable INSTANCE =
		new ResourceTypeEntryTable();

	public final Column<ResourceTypeEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceTypeEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ResourceTypeEntryTable, Long> resourceTypeId =
		createColumn(
			"resourceTypeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ResourceTypeEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTypeEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTypeEntryTable, Long> accountId = createColumn(
		"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTypeEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ResourceTypeEntryTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ResourceTypeEntryTable, Long> businessId = createColumn(
		"businessId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTypeEntryTable, Long> modifiedId = createColumn(
		"modifiedId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ResourceTypeEntryTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceTypeEntryTable, String> unit = createColumn(
		"unit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ResourceTypeEntryTable, Long> parentId = createColumn(
		"parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ResourceTypeEntryTable() {
		super("SW_ResourceType", ResourceTypeEntryTable::new);
	}

}