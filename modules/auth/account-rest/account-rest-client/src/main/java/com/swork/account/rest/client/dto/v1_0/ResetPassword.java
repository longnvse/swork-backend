package com.swork.account.rest.client.dto.v1_0;

import com.swork.account.rest.client.function.UnsafeSupplier;
import com.swork.account.rest.client.serdes.v1_0.ResetPasswordSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class ResetPassword implements Cloneable, Serializable {

	public static ResetPassword toDTO(String json) {
		return ResetPasswordSerDes.toDTO(json);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail(
		UnsafeSupplier<String, Exception> emailUnsafeSupplier) {

		try {
			email = emailUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUsername(
		UnsafeSupplier<String, Exception> usernameUnsafeSupplier) {

		try {
			username = usernameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String username;

	@Override
	public ResetPassword clone() throws CloneNotSupportedException {
		return (ResetPassword)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ResetPassword)) {
			return false;
		}

		ResetPassword resetPassword = (ResetPassword)object;

		return Objects.equals(toString(), resetPassword.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ResetPasswordSerDes.toJSON(this);
	}

}