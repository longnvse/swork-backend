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
 * The table class for the &quot;SW_AccountPermission&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AccountPermissionEntry
 * @generated
 */
public class AccountPermissionEntryTable
	extends BaseTable<AccountPermissionEntryTable> {

	public static final AccountPermissionEntryTable INSTANCE =
		new AccountPermissionEntryTable();

	public final Column<AccountPermissionEntryTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountPermissionEntryTable, String>
		externalReferenceCode = createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AccountPermissionEntryTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AccountPermissionEntryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountPermissionEntryTable, Long> permissionId =
		createColumn(
			"permissionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountPermissionEntryTable, Long> accountId =
		createColumn(
			"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AccountPermissionEntryTable() {
		super("SW_AccountPermission", AccountPermissionEntryTable::new);
	}

}