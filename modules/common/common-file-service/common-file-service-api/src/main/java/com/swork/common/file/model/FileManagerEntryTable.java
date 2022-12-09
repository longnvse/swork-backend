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

package com.swork.common.file.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;SW_FileManager&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FileManagerEntry
 * @generated
 */
public class FileManagerEntryTable extends BaseTable<FileManagerEntryTable> {

	public static final FileManagerEntryTable INSTANCE =
		new FileManagerEntryTable();

	public final Column<FileManagerEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, String> externalReferenceCode =
		createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FileManagerEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, Long> customerId = createColumn(
		"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, Long> creatorId = createColumn(
		"creatorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, Long> fileId = createColumn(
		"fileId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, String> parentCode =
		createColumn(
			"parentCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, String> fileType = createColumn(
		"fileType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, String> pkType = createColumn(
		"pkType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, String> fileName = createColumn(
		"fileName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, String> fileSize = createColumn(
		"fileSize", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, String> moduleId = createColumn(
		"moduleId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileManagerEntryTable, String> appId = createColumn(
		"appId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FileManagerEntryTable() {
		super("SW_FileManager", FileManagerEntryTable::new);
	}

}