package com.swork.auth.login.rest.dto.v1_0;

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
@GraphQLName(
	description = "CredentialRefresh model", value = "CredentialRefresh"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "CredentialRefresh")
public class CredentialRefresh implements Serializable {

	public static CredentialRefresh toDTO(String json) {
		return ObjectMapperUtil.readValue(CredentialRefresh.class, json);
	}

	public static CredentialRefresh unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(CredentialRefresh.class, json);
	}

	@Schema
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@JsonIgnore
	public void setAccessToken(
		UnsafeSupplier<String, Exception> accessTokenUnsafeSupplier) {

		try {
			accessToken = accessTokenUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String accessToken;

	@Schema
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@JsonIgnore
	public void setRefreshToken(
		UnsafeSupplier<String, Exception> refreshTokenUnsafeSupplier) {

		try {
			refreshToken = refreshTokenUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String refreshToken;

	@Schema
	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@JsonIgnore
	public void setTokenType(
		UnsafeSupplier<String, Exception> tokenTypeUnsafeSupplier) {

		try {
			tokenType = tokenTypeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String tokenType;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CredentialRefresh)) {
			return false;
		}

		CredentialRefresh credentialRefresh = (CredentialRefresh)object;

		return Objects.equals(toString(), credentialRefresh.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (accessToken != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accessToken\": ");

			sb.append("\"");

			sb.append(_escape(accessToken));

			sb.append("\"");
		}

		if (refreshToken != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"refreshToken\": ");

			sb.append("\"");

			sb.append(_escape(refreshToken));

			sb.append("\"");
		}

		if (tokenType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tokenType\": ");

			sb.append("\"");

			sb.append(_escape(tokenType));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.swork.auth.login.rest.dto.v1_0.CredentialRefresh",
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