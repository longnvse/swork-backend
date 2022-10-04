package com.swork.auth.login.rest.client.serdes.v1_0;

import com.swork.auth.login.rest.client.dto.v1_0.CredentialRefresh;
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
public class CredentialRefreshSerDes {

	public static CredentialRefresh toDTO(String json) {
		CredentialRefreshJSONParser credentialRefreshJSONParser =
			new CredentialRefreshJSONParser();

		return credentialRefreshJSONParser.parseToDTO(json);
	}

	public static CredentialRefresh[] toDTOs(String json) {
		CredentialRefreshJSONParser credentialRefreshJSONParser =
			new CredentialRefreshJSONParser();

		return credentialRefreshJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CredentialRefresh credentialRefresh) {
		if (credentialRefresh == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (credentialRefresh.getAccessToken() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accessToken\": ");

			sb.append("\"");

			sb.append(_escape(credentialRefresh.getAccessToken()));

			sb.append("\"");
		}

		if (credentialRefresh.getRefreshToken() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"refreshToken\": ");

			sb.append("\"");

			sb.append(_escape(credentialRefresh.getRefreshToken()));

			sb.append("\"");
		}

		if (credentialRefresh.getTokenType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tokenType\": ");

			sb.append("\"");

			sb.append(_escape(credentialRefresh.getTokenType()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CredentialRefreshJSONParser credentialRefreshJSONParser =
			new CredentialRefreshJSONParser();

		return credentialRefreshJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		CredentialRefresh credentialRefresh) {

		if (credentialRefresh == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (credentialRefresh.getAccessToken() == null) {
			map.put("accessToken", null);
		}
		else {
			map.put(
				"accessToken",
				String.valueOf(credentialRefresh.getAccessToken()));
		}

		if (credentialRefresh.getRefreshToken() == null) {
			map.put("refreshToken", null);
		}
		else {
			map.put(
				"refreshToken",
				String.valueOf(credentialRefresh.getRefreshToken()));
		}

		if (credentialRefresh.getTokenType() == null) {
			map.put("tokenType", null);
		}
		else {
			map.put(
				"tokenType", String.valueOf(credentialRefresh.getTokenType()));
		}

		return map;
	}

	public static class CredentialRefreshJSONParser
		extends BaseJSONParser<CredentialRefresh> {

		@Override
		protected CredentialRefresh createDTO() {
			return new CredentialRefresh();
		}

		@Override
		protected CredentialRefresh[] createDTOArray(int size) {
			return new CredentialRefresh[size];
		}

		@Override
		protected void setField(
			CredentialRefresh credentialRefresh, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "accessToken")) {
				if (jsonParserFieldValue != null) {
					credentialRefresh.setAccessToken(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "refreshToken")) {
				if (jsonParserFieldValue != null) {
					credentialRefresh.setRefreshToken(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tokenType")) {
				if (jsonParserFieldValue != null) {
					credentialRefresh.setTokenType(
						(String)jsonParserFieldValue);
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