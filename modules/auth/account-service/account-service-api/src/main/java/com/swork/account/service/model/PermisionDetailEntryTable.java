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

package com.swork.account.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;SW_PermisionDetail&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PermisionDetailEntry
 * @generated
 */
public class PermisionDetailEntryTable
	extends BaseTable<PermisionDetailEntryTable> {

	public static final PermisionDetailEntryTable INSTANCE =
		new PermisionDetailEntryTable();

	public final Column<PermisionDetailEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PermisionDetailEntryTable, String>
		externalReferenceCode = createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PermisionDetailEntryTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PermisionDetailEntryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PermisionDetailEntryTable, Long> permisionId =
		createColumn(
			"permisionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PermisionDetailEntryTable, String> actionCode =
		createColumn(
			"actionCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PermisionDetailEntryTable() {
		super("SW_PermisionDetail", PermisionDetailEntryTable::new);
	}

}