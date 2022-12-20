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

package com.swork.common.comment.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;SW_Comment&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CommentEntry
 * @generated
 */
public class CommentEntryTable extends BaseTable<CommentEntryTable> {

	public static final CommentEntryTable INSTANCE = new CommentEntryTable();

	public final Column<CommentEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentEntryTable, Long> commentId = createColumn(
		"commentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CommentEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentEntryTable, Long> accountId = createColumn(
		"accountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommentEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommentEntryTable, Long> businessId = createColumn(
		"businessId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentEntryTable, String> content = createColumn(
		"content", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentEntryTable, Long> parentId = createColumn(
		"parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentEntryTable, Long> classPkId = createColumn(
		"classPkId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentEntryTable, String> classPKName = createColumn(
		"classPKName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CommentEntryTable() {
		super("SW_Comment", CommentEntryTable::new);
	}

}