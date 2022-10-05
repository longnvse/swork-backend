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

package com.swork.business.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;SW_Business&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BusinessEntry
 * @generated
 */
public class BusinessEntryTable extends BaseTable<BusinessEntryTable> {

	public static final BusinessEntryTable INSTANCE = new BusinessEntryTable();

	public final Column<BusinessEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, Long> businessId = createColumn(
		"businessId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BusinessEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, Long> accountId = createColumn(
		"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, Long> creatorId = createColumn(
		"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, String> customerName = createColumn(
		"customerName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, String> phoneNumber = createColumn(
		"phoneNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, String> businessAddress =
		createColumn(
			"businessAddress", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, String> fieldOperations =
		createColumn(
			"fieldOperations", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, Long> logoId = createColumn(
		"logoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BusinessEntryTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private BusinessEntryTable() {
		super("SW_Business", BusinessEntryTable::new);
	}

}