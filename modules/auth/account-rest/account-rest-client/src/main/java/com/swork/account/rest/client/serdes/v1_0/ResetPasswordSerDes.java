package com.swork.account.rest.client.serdes.v1_0;

import com.swork.account.rest.client.dto.v1_0.ResetPassword;
import com.swork.account.rest.client.json.BaseJSONParser;

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
public class ResetPasswordSerDes {

	public static ResetPassword toDTO(String json) {
		ResetPasswordJSONParser resetPasswordJSONParser =
			new ResetPasswordJSONParser();

		return resetPasswordJSONParser.parseToDTO(json);
	}

	public static ResetPassword[] toDTOs(String json) {
		ResetPasswordJSONParser resetPasswordJSONParser =
			new ResetPasswordJSONParser();

		return resetPasswordJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ResetPassword resetPassword) {
		if (resetPassword == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (resetPassword.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(resetPassword.getEmail()));

			sb.append("\"");
		}

		if (resetPassword.getUsername() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"username\": ");

			sb.append("\"");

			sb.append(_escape(resetPassword.getUsername()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ResetPasswordJSONParser resetPasswordJSONParser =
			new ResetPasswordJSONParser();

		return resetPasswordJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ResetPassword resetPassword) {
		if (resetPassword == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (resetPassword.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(resetPassword.getEmail()));
		}

		if (resetPassword.getUsername() == null) {
			map.put("username", null);
		}
		else {
			map.put("username", String.valueOf(resetPassword.getUsername()));
		}

		return map;
	}

	public static class ResetPasswordJSONParser
		extends BaseJSONParser<ResetPassword> {

		@Override
		protected ResetPassword createDTO() {
			return new ResetPassword();
		}

		@Override
		protected ResetPassword[] createDTOArray(int size) {
			return new ResetPassword[size];
		}

		@Override
		protected void setField(
			ResetPassword resetPassword, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					resetPassword.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "username")) {
				if (jsonParserFieldValue != null) {
					resetPassword.setUsername((String)jsonParserFieldValue);
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