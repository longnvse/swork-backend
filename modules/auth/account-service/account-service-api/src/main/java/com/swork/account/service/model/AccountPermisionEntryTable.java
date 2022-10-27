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
 * The table class for the &quot;SW_AcccountPermision&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AccountPermisionEntry
 * @generated
 */
public class AccountPermisionEntryTable
	extends BaseTable<AccountPermisionEntryTable> {

	public static final AccountPermisionEntryTable INSTANCE =
		new AccountPermisionEntryTable();

	public final Column<AccountPermisionEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountPermisionEntryTable, String>
		externalReferenceCode = createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AccountPermisionEntryTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AccountPermisionEntryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountPermisionEntryTable, Long> permisionId =
		createColumn(
			"permisionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountPermisionEntryTable, Long> accountId =
		createColumn(
			"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AccountPermisionEntryTable() {
		super("SW_AcccountPermision", AccountPermisionEntryTable::new);
	}

}