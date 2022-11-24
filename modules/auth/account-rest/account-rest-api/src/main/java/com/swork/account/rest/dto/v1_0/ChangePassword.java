package com.swork.account.rest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
@GraphQLName("ChangePassword")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "ChangePassword")
public class ChangePassword implements Serializable {

	public static ChangePassword toDTO(String json) {
		return ObjectMapperUtil.readValue(ChangePassword.class, json);
	}

	public static ChangePassword unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(ChangePassword.class, json);
	}

	@Schema
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@JsonIgnore
	public void setNewPassword(
		UnsafeSupplier<String, Exception> newPasswordUnsafeSupplier) {

		try {
			newPassword = newPasswordUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String newPassword;

	@Schema
	public String getNewPasswordRepeat() {
		return newPasswordRepeat;
	}

	public void setNewPasswordRepeat(String newPasswordRepeat) {
		this.newPasswordRepeat = newPasswordRepeat;
	}

	@JsonIgnore
	public void setNewPasswordRepeat(
		UnsafeSupplier<String, Exception> newPasswordRepeatUnsafeSupplier) {

		try {
			newPasswordRepeat = newPasswordRepeatUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String newPasswordRepeat;

	@Schema
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	@JsonIgnore
	public void setOldPassword(
		UnsafeSupplier<String, Exception> oldPasswordUnsafeSupplier) {

		try {
			oldPassword = oldPasswordUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String oldPassword;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (newPassword != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"newPassword\": ");

			sb.append("\"");

			sb.append(_escape(newPassword));

			sb.append("\"");
		}

		if (newPasswordRepeat != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"newPasswordRepeat\": ");

			sb.append("\"");

			sb.append(_escape(newPasswordRepeat));

			sb.append("\"");
		}

		if (oldPassword != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"oldPassword\": ");

			sb.append("\"");

			sb.append(_escape(oldPassword));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.swork.account.rest.dto.v1_0.ChangePassword",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}