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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AccountPermisionEntry service. Represents a row in the &quot;SW_AcccountPermision&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AccountPermisionEntryModel
 * @generated
 */
@ImplementationClassName(
	"com.swork.account.service.model.impl.AccountPermisionEntryImpl"
)
@ProviderType
public interface AccountPermisionEntry
	extends AccountPermisionEntryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.swork.account.service.model.impl.AccountPermisionEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AccountPermisionEntry, Long> ID_ACCESSOR =
		new Accessor<AccountPermisionEntry, Long>() {

			@Override
			public Long get(AccountPermisionEntry accountPermisionEntry) {
				return accountPermisionEntry.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AccountPermisionEntry> getTypeClass() {
				return AccountPermisionEntry.class;
			}

		};

}