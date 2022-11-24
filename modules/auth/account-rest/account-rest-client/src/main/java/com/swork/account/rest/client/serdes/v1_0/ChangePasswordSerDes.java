package com.swork.account.rest.client.serdes.v1_0;

import com.swork.account.rest.client.dto.v1_0.ChangePassword;
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
public class ChangePasswordSerDes {

	public static ChangePassword toDTO(String json) {
		ChangePasswordJSONParser changePasswordJSONParser =
			new ChangePasswordJSONParser();

		return changePasswordJSONParser.parseToDTO(json);
	}

	public static ChangePassword[] toDTOs(String json) {
		ChangePasswordJSONParser changePasswordJSONParser =
			new ChangePasswordJSONParser();

		return changePasswordJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ChangePassword changePassword) {
		if (changePassword == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (changePassword.getNewPassword() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"newPassword\": ");

			sb.append("\"");

			sb.append(_escape(changePassword.getNewPassword()));

			sb.append("\"");
		}

		if (changePassword.getNewPasswordRepeat() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"newPasswordRepeat\": ");

			sb.append("\"");

			sb.append(_escape(changePassword.getNewPasswordRepeat()));

			sb.append("\"");
		}

		if (changePassword.getOldPassword() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"oldPassword\": ");

			sb.append("\"");

			sb.append(_escape(changePassword.getOldPassword()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ChangePasswordJSONParser changePasswordJSONParser =
			new ChangePasswordJSONParser();

		return changePasswordJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ChangePassword changePassword) {
		if (changePassword == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (changePassword.getNewPassword() == null) {
			map.put("newPassword", null);
		}
		else {
			map.put(
				"newPassword", String.valueOf(changePassword.getNewPassword()));
		}

		if (changePassword.getNewPasswordRepeat() == null) {
			map.put("newPasswordRepeat", null);
		}
		else {
			map.put(
				"newPasswordRepeat",
				String.valueOf(changePassword.getNewPasswordRepeat()));
		}

		if (changePassword.getOldPassword() == null) {
			map.put("oldPassword", null);
		}
		else {
			map.put(
				"oldPassword", String.valueOf(changePassword.getOldPassword()));
		}

		return map;
	}

	public static class ChangePasswordJSONParser
		extends BaseJSONParser<ChangePassword> {

		@Override
		protected ChangePassword createDTO() {
			return new ChangePassword();
		}

		@Override
		protected ChangePassword[] createDTOArray(int size) {
			return new ChangePassword[size];
		}

		@Override
		protected void setField(
			ChangePassword changePassword, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "newPassword")) {
				if (jsonParserFieldValue != null) {
					changePassword.setNewPassword((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "newPasswordRepeat")) {
				if (jsonParserFieldValue != null) {
					changePassword.setNewPasswordRepeat(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "oldPassword")) {
				if (jsonParserFieldValue != null) {
					changePassword.setOldPassword((String)jsonParserFieldValue);
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