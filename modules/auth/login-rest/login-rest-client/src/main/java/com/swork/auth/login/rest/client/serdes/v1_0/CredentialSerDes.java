package com.swork.auth.login.rest.client.serdes.v1_0;

import com.swork.auth.login.rest.client.dto.v1_0.Credential;
import com.swork.auth.login.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class CredentialSerDes {

	public static Credential toDTO(String json) {
		CredentialJSONParser credentialJSONParser = new CredentialJSONParser();

		return credentialJSONParser.parseToDTO(json);
	}

	public static Credential[] toDTOs(String json) {
		CredentialJSONParser credentialJSONParser = new CredentialJSONParser();

		return credentialJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Credential credential) {
		if (credential == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (credential.getAccessToken() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accessToken\": ");

			sb.append("\"");

			sb.append(_escape(credential.getAccessToken()));

			sb.append("\"");
		}

		if (credential.getAccountId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountId\": ");

			sb.append(credential.getAccountId());
		}

		if (credential.getPassword() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"password\": ");

			sb.append("\"");

			sb.append(_escape(credential.getPassword()));

			sb.append("\"");
		}

		if (credential.getRefreshToken() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"refreshToken\": ");

			sb.append("\"");

			sb.append(_escape(credential.getRefreshToken()));

			sb.append("\"");
		}

		if (credential.getRememberMe() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"rememberMe\": ");

			sb.append(credential.getRememberMe());
		}

		if (credential.getTokenType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tokenType\": ");

			sb.append("\"");

			sb.append(_escape(credential.getTokenType()));

			sb.append("\"");
		}

		if (credential.getUsername() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"username\": ");

			sb.append("\"");

			sb.append(_escape(credential.getUsername()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CredentialJSONParser credentialJSONParser = new CredentialJSONParser();

		return credentialJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Credential credential) {
		if (credential == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (credential.getAccessToken() == null) {
			map.put("accessToken", null);
		}
		else {
			map.put("accessToken", String.valueOf(credential.getAccessToken()));
		}

		if (credential.getAccountId() == null) {
			map.put("accountId", null);
		}
		else {
			map.put("accountId", String.valueOf(credential.getAccountId()));
		}

		if (credential.getPassword() == null) {
			map.put("password", null);
		}
		else {
			map.put("password", String.valueOf(credential.getPassword()));
		}

		if (credential.getRefreshToken() == null) {
			map.put("refreshToken", null);
		}
		else {
			map.put(
				"refreshToken", String.valueOf(credential.getRefreshToken()));
		}

		if (credential.getRememberMe() == null) {
			map.put("rememberMe", null);
		}
		else {
			map.put("rememberMe", String.valueOf(credential.getRememberMe()));
		}

		if (credential.getTokenType() == null) {
			map.put("tokenType", null);
		}
		else {
			map.put("tokenType", String.valueOf(credential.getTokenType()));
		}

		if (credential.getUsername() == null) {
			map.put("username", null);
		}
		else {
			map.put("username", String.valueOf(credential.getUsername()));
		}

		return map;
	}

	public static class CredentialJSONParser
		extends BaseJSONParser<Credential> {

		@Override
		protected Credential createDTO() {
			return new Credential();
		}

		@Override
		protected Credential[] createDTOArray(int size) {
			return new Credential[size];
		}

		@Override
		protected void setField(
			Credential credential, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "accessToken")) {
				if (jsonParserFieldValue != null) {
					credential.setAccessToken((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "accountId")) {
				if (jsonParserFieldValue != null) {
					credential.setAccountId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "password")) {
				if (jsonParserFieldValue != null) {
					credential.setPassword((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "refreshToken")) {
				if (jsonParserFieldValue != null) {
					credential.setRefreshToken((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "rememberMe")) {
				if (jsonParserFieldValue != null) {
					credential.setRememberMe((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tokenType")) {
				if (jsonParserFieldValue != null) {
					credential.setTokenType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "username")) {
				if (jsonParserFieldValue != null) {
					credential.setUsername((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}