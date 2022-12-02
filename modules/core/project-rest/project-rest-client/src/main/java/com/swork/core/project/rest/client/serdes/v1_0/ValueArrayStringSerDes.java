package com.swork.core.project.rest.client.serdes.v1_0;

import com.swork.core.project.rest.client.dto.v1_0.ValueArrayString;
import com.swork.core.project.rest.client.json.BaseJSONParser;

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
public class ValueArrayStringSerDes {

	public static ValueArrayString toDTO(String json) {
		ValueArrayStringJSONParser valueArrayStringJSONParser =
			new ValueArrayStringJSONParser();

		return valueArrayStringJSONParser.parseToDTO(json);
	}

	public static ValueArrayString[] toDTOs(String json) {
		ValueArrayStringJSONParser valueArrayStringJSONParser =
			new ValueArrayStringJSONParser();

		return valueArrayStringJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ValueArrayString valueArrayString) {
		if (valueArrayString == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (valueArrayString.getValueArrays() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valueArrays\": ");

			sb.append("[");

			for (int i = 0; i < valueArrayString.getValueArrays().length; i++) {
				sb.append(valueArrayString.getValueArrays()[i]);

				if ((i + 1) < valueArrayString.getValueArrays().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ValueArrayStringJSONParser valueArrayStringJSONParser =
			new ValueArrayStringJSONParser();

		return valueArrayStringJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ValueArrayString valueArrayString) {
		if (valueArrayString == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (valueArrayString.getValueArrays() == null) {
			map.put("valueArrays", null);
		}
		else {
			map.put(
				"valueArrays",
				String.valueOf(valueArrayString.getValueArrays()));
		}

		return map;
	}

	public static class ValueArrayStringJSONParser
		extends BaseJSONParser<ValueArrayString> {

		@Override
		protected ValueArrayString createDTO() {
			return new ValueArrayString();
		}

		@Override
		protected ValueArrayString[] createDTOArray(int size) {
			return new ValueArrayString[size];
		}

		@Override
		protected void setField(
			ValueArrayString valueArrayString, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "valueArrays")) {
				if (jsonParserFieldValue != null) {
					valueArrayString.setValueArrays(
						toLongs((Object[])jsonParserFieldValue));
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