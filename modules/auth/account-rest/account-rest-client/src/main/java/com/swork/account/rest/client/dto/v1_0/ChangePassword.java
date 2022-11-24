package com.swork.account.rest.client.dto.v1_0;

import com.swork.account.rest.client.function.UnsafeSupplier;
import com.swork.account.rest.client.serdes.v1_0.ChangePasswordSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class ChangePassword implements Cloneable, Serializable {

	public static ChangePassword toDTO(String json) {
		return ChangePasswordSerDes.toDTO(json);
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setNewPassword(
		UnsafeSupplier<String, Exception> newPasswordUnsafeSupplier) {

		try {
			newPassword = newPasswordUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String newPassword;

	public String getNewPasswordRepeat() {
		return newPasswordRepeat;
	}

	public void setNewPasswordRepeat(String newPasswordRepeat) {
		this.newPasswordRepeat = newPasswordRepeat;
	}

	public void setNewPasswordRepeat(
		UnsafeSupplier<String, Exception> newPasswordRepeatUnsafeSupplier) {

		try {
			newPasswordRepeat = newPasswordRepeatUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String newPasswordRepeat;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setOldPassword(
		UnsafeSupplier<String, Exception> oldPasswordUnsafeSupplier) {

		try {
			oldPassword = oldPasswordUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String oldPassword;

	@Override
	public ChangePassword clone() throws CloneNotSupportedException {
		return (ChangePassword)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChangePassword)) {
			return false;
		}

		ChangePassword changePassword = (ChangePassword)object;

		return Objects.equals(toString(), changePassword.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ChangePasswordSerDes.toJSON(this);
	}

}