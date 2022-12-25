package com.swork.auth.login.rest.client.dto.v1_0;

import com.swork.auth.login.rest.client.function.UnsafeSupplier;
import com.swork.auth.login.rest.client.serdes.v1_0.ExceptionTypeSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class ExceptionType implements Cloneable, Serializable {

	public static ExceptionType toDTO(String json) {
		return ExceptionTypeSerDes.toDTO(json);
	}

	public Status getStatus() {
		return status;
	}

	public String getStatusAsString() {
		if (status == null) {
			return null;
		}

		return status.toString();
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<Status, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Status status;

	@Override
	public ExceptionType clone() throws CloneNotSupportedException {
		return (ExceptionType)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExceptionType)) {
			return false;
		}

		ExceptionType exceptionType = (ExceptionType)object;

		return Objects.equals(toString(), exceptionType.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ExceptionTypeSerDes.toJSON(this);
	}

	public static enum Status {

		BAD_REQUEST("BadRequest"), AUTH("Auth"), RESOURCE("Resource");

		public static Status create(String value) {
			for (Status status : values()) {
				if (Objects.equals(status.getValue(), value) ||
					Objects.equals(status.name(), value)) {

					return status;
				}
			}

			return null;
		}

		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Status(String value) {
			_value = value;
		}

		private final String _value;

	}

}