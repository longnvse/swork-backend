package com.swork.account.rest.client.dto.v1_0;

import com.swork.account.rest.client.function.UnsafeSupplier;
import com.swork.account.rest.client.serdes.v1_0.PermissionDetailSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class PermissionDetail implements Cloneable, Serializable {

	public static PermissionDetail toDTO(String json) {
		return PermissionDetailSerDes.toDTO(json);
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public void setActionCode(
		UnsafeSupplier<String, Exception> actionCodeUnsafeSupplier) {

		try {
			actionCode = actionCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String actionCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public void setPermissionId(
		UnsafeSupplier<Long, Exception> permissionIdUnsafeSupplier) {

		try {
			permissionId = permissionIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long permissionId;

	@Override
	public PermissionDetail clone() throws CloneNotSupportedException {
		return (PermissionDetail)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PermissionDetail)) {
			return false;
		}

		PermissionDetail permissionDetail = (PermissionDetail)object;

		return Objects.equals(toString(), permissionDetail.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return PermissionDetailSerDes.toJSON(this);
	}

}