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
 * The table class for the &quot;SW_PermissionDetail&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PermissionDetailEntry
 * @generated
 */
public class PermissionDetailEntryTable
	extends BaseTable<PermissionDetailEntryTable> {

	public static final PermissionDetailEntryTable INSTANCE =
		new PermissionDetailEntryTable();

	public final Column<PermissionDetailEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PermissionDetailEntryTable, String>
		externalReferenceCode = createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PermissionDetailEntryTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PermissionDetailEntryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PermissionDetailEntryTable, Long> permissionId =
		createColumn(
			"permissionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PermissionDetailEntryTable, String> actionCode =
		createColumn(
			"actionCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PermissionDetailEntryTable() {
		super("SW_PermissionDetail", PermissionDetailEntryTable::new);
	}

}