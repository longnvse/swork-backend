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

package com.swork.auth.login.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;SW_TokenEntry&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TokenEntry
 * @generated
 */
public class TokenEntryTable extends BaseTable<TokenEntryTable> {

	public static final TokenEntryTable INSTANCE = new TokenEntryTable();

	public final Column<TokenEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, Long> tokenId = createColumn(
		"tokenId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TokenEntryTable, Long> accountId = createColumn(
		"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, Long> businessId = createColumn(
		"businessId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, String> refreshToken = createColumn(
		"refreshToken", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, Date> expiryDate = createColumn(
		"expiryDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, Date> issuedDate = createColumn(
		"issuedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, Date> refreshedDate = createColumn(
		"refreshedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, String> userAgent = createColumn(
		"userAgent", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, String> clientIp = createColumn(
		"clientIp", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, Date> firstLoginDate = createColumn(
		"firstLoginDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, String> sessionId = createColumn(
		"sessionId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TokenEntryTable, Boolean> remember = createColumn(
		"remember", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private TokenEntryTable() {
		super("SW_TokenEntry", TokenEntryTable::new);
	}

}