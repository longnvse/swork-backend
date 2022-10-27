package com.swork.account.rest.client.dto.v1_0;

import com.swork.account.rest.client.function.UnsafeSupplier;
import com.swork.account.rest.client.serdes.v1_0.AccountPermisionSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class AccountPermision implements Cloneable, Serializable {

	public static AccountPermision toDTO(String json) {
		return AccountPermisionSerDes.toDTO(json);
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setAccountId(
		UnsafeSupplier<Long, Exception> accountIdUnsafeSupplier) {

		try {
			accountId = accountIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long accountId;

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

	public Long getPermisionId() {
		return permisionId;
	}

	public void setPermisionId(Long permisionId) {
		this.permisionId = permisionId;
	}

	public void setPermisionId(
		UnsafeSupplier<Long, Exception> permisionIdUnsafeSupplier) {

		try {
			permisionId = permisionIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long permisionId;

	@Override
	public AccountPermision clone() throws CloneNotSupportedException {
		return (AccountPermision)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AccountPermision)) {
			return false;
		}

		AccountPermision accountPermision = (AccountPermision)object;

		return Objects.equals(toString(), accountPermision.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return AccountPermisionSerDes.toJSON(this);
	}

}