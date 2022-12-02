package com.swork.core.project.rest.client.serdes.v1_0;

import com.swork.core.project.rest.client.dto.v1_0.ValueChart;
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
public class ValueChartSerDes {

	public static ValueChart toDTO(String json) {
		ValueChartJSONParser valueChartJSONParser = new ValueChartJSONParser();

		return valueChartJSONParser.parseToDTO(json);
	}

	public static ValueChart[] toDTOs(String json) {
		ValueChartJSONParser valueChartJSONParser = new ValueChartJSONParser();

		return valueChartJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ValueChart valueChart) {
		if (valueChart == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (valueChart.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append(valueChart.getName());
		}

		if (valueChart.getNameString() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nameString\": ");

			sb.append("\"");

			sb.append(_escape(valueChart.getNameString()));

			sb.append("\"");
		}

		if (valueChart.getValue() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"value\": ");

			sb.append(valueChart.getValue());
		}

		if (valueChart.getValueDouble() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valueDouble\": ");

			sb.append(valueChart.getValueDouble());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ValueChartJSONParser valueChartJSONParser = new ValueChartJSONParser();

		return valueChartJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ValueChart valueChart) {
		if (valueChart == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (valueChart.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(valueChart.getName()));
		}

		if (valueChart.getNameString() == null) {
			map.put("nameString", null);
		}
		else {
			map.put("nameString", String.valueOf(valueChart.getNameString()));
		}

		if (valueChart.getValue() == null) {
			map.put("value", null);
		}
		else {
			map.put("value", String.valueOf(valueChart.getValue()));
		}

		if (valueChart.getValueDouble() == null) {
			map.put("valueDouble", null);
		}
		else {
			map.put("valueDouble", String.valueOf(valueChart.getValueDouble()));
		}

		return map;
	}

	public static class ValueChartJSONParser
		extends BaseJSONParser<ValueChart> {

		@Override
		protected ValueChart createDTO() {
			return new ValueChart();
		}

		@Override
		protected ValueChart[] createDTOArray(int size) {
			return new ValueChart[size];
		}

		@Override
		protected void setField(
			ValueChart valueChart, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					valueChart.setName(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nameString")) {
				if (jsonParserFieldValue != null) {
					valueChart.setNameString((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "value")) {
				if (jsonParserFieldValue != null) {
					valueChart.setValue(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "valueDouble")) {
				if (jsonParserFieldValue != null) {
					valueChart.setValueDouble(
						Double.valueOf((String)jsonParserFieldValue));
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