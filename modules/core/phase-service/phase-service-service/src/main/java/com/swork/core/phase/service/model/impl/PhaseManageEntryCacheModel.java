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

package com.swork.core.phase.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.swork.core.phase.service.model.PhaseManageEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PhaseManageEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PhaseManageEntryCacheModel
	implements CacheModel<PhaseManageEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PhaseManageEntryCacheModel)) {
			return false;
		}

		PhaseManageEntryCacheModel phaseManageEntryCacheModel =
			(PhaseManageEntryCacheModel)object;

		if (phaseManageId == phaseManageEntryCacheModel.phaseManageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, phaseManageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{phaseManageId=");
		sb.append(phaseManageId);
		sb.append(", phaseId=");
		sb.append(phaseId);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PhaseManageEntry toEntityModel() {
		PhaseManageEntryImpl phaseManageEntryImpl = new PhaseManageEntryImpl();

		phaseManageEntryImpl.setPhaseManageId(phaseManageId);
		phaseManageEntryImpl.setPhaseId(phaseId);
		phaseManageEntryImpl.setAccountId(accountId);

		phaseManageEntryImpl.resetOriginalValues();

		return phaseManageEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		phaseManageId = objectInput.readLong();

		phaseId = objectInput.readLong();

		accountId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(phaseManageId);

		objectOutput.writeLong(phaseId);

		objectOutput.writeLong(accountId);
	}

	public long phaseManageId;
	public long phaseId;
	public long accountId;

}