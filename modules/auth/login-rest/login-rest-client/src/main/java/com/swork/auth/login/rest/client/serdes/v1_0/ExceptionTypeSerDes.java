package com.swork.auth.login.rest.client.serdes.v1_0;

import com.swork.auth.login.rest.client.dto.v1_0.ExceptionType;
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
public class ExceptionTypeSerDes {

	public static ExceptionType toDTO(String json) {
		ExceptionTypeJSONParser exceptionTypeJSONParser =
			new ExceptionTypeJSONParser();

		return exceptionTypeJSONParser.parseToDTO(json);
	}

	public static ExceptionType[] toDTOs(String json) {
		ExceptionTypeJSONParser exceptionTypeJSONParser =
			new ExceptionTypeJSONParser();

		return exceptionTypeJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ExceptionType exceptionType) {
		if (exceptionType == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (exceptionType.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(exceptionType.getStatus());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ExceptionTypeJSONParser exceptionTypeJSONParser =
			new ExceptionTypeJSONParser();

		return exceptionTypeJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ExceptionType exceptionType) {
		if (exceptionType == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (exceptionType.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(exceptionType.getStatus()));
		}

		return map;
	}

	public static class ExceptionTypeJSONParser
		extends BaseJSONParser<ExceptionType> {

		@Override
		protected ExceptionType createDTO() {
			return new ExceptionType();
		}

		@Override
		protected ExceptionType[] createDTOArray(int size) {
			return new ExceptionType[size];
		}

		@Override
		protected void setField(
			ExceptionType exceptionType, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					exceptionType.setStatus(
						ExceptionType.Status.create(
							(String)jsonParserFieldValue));
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