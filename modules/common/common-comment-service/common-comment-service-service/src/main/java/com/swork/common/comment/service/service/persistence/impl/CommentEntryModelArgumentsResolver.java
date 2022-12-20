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

package com.swork.common.comment.service.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import com.swork.common.comment.service.model.CommentEntryTable;
import com.swork.common.comment.service.model.impl.CommentEntryImpl;
import com.swork.common.comment.service.model.impl.CommentEntryModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from CommentEntry.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	immediate = true,
	service = {
		CommentEntryModelArgumentsResolver.class, ArgumentsResolver.class
	}
)
public class CommentEntryModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		CommentEntryModelImpl commentEntryModelImpl =
			(CommentEntryModelImpl)baseModel;

		long columnBitmask = commentEntryModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(commentEntryModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					commentEntryModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(CommentEntryPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(commentEntryModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return CommentEntryImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return CommentEntryTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		CommentEntryModelImpl commentEntryModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = commentEntryModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = commentEntryModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= CommentEntryModelImpl.getColumnBitmask(
			"modifiedDate");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}