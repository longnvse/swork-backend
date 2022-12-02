package com.swork.core.project.rest.client.serdes.v1_0;

import com.swork.core.project.rest.client.dto.v1_0.Chart;
import com.swork.core.project.rest.client.dto.v1_0.ValueArrayString;
import com.swork.core.project.rest.client.dto.v1_0.ValueChart;
import com.swork.core.project.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class ChartSerDes {

	public static Chart toDTO(String json) {
		ChartJSONParser chartJSONParser = new ChartJSONParser();

		return chartJSONParser.parseToDTO(json);
	}

	public static Chart[] toDTOs(String json) {
		ChartJSONParser chartJSONParser = new ChartJSONParser();

		return chartJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Chart chart) {
		if (chart == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (chart.getDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(chart.getDate()));

			sb.append("\"");
		}

		if (chart.getObj() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"obj\": ");

			sb.append("\"");

			sb.append(_escape(chart.getObj()));

			sb.append("\"");
		}

		if (chart.getSum() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sum\": ");

			sb.append(chart.getSum());
		}

		if (chart.getSumDouble() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sumDouble\": ");

			sb.append(chart.getSumDouble());
		}

		if (chart.getUnit() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"unit\": ");

			sb.append("\"");

			sb.append(_escape(chart.getUnit()));

			sb.append("\"");
		}

		if (chart.getValueArrayDoubles() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valueArrayDoubles\": ");

			sb.append("[");

			for (int i = 0; i < chart.getValueArrayDoubles().length; i++) {
				sb.append(chart.getValueArrayDoubles()[i]);

				if ((i + 1) < chart.getValueArrayDoubles().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (chart.getValueArrayStrings() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valueArrayStrings\": ");

			sb.append("[");

			for (int i = 0; i < chart.getValueArrayStrings().length; i++) {
				sb.append(String.valueOf(chart.getValueArrayStrings()[i]));

				if ((i + 1) < chart.getValueArrayStrings().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (chart.getValueArrays() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valueArrays\": ");

			sb.append("[");

			for (int i = 0; i < chart.getValueArrays().length; i++) {
				sb.append(chart.getValueArrays()[i]);

				if ((i + 1) < chart.getValueArrays().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (chart.getValueCharts() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valueCharts\": ");

			sb.append("[");

			for (int i = 0; i < chart.getValueCharts().length; i++) {
				sb.append(String.valueOf(chart.getValueCharts()[i]));

				if ((i + 1) < chart.getValueCharts().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ChartJSONParser chartJSONParser = new ChartJSONParser();

		return chartJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Chart chart) {
		if (chart == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (chart.getDate() == null) {
			map.put("date", null);
		}
		else {
			map.put("date", liferayToJSONDateFormat.format(chart.getDate()));
		}

		if (chart.getObj() == null) {
			map.put("obj", null);
		}
		else {
			map.put("obj", String.valueOf(chart.getObj()));
		}

		if (chart.getSum() == null) {
			map.put("sum", null);
		}
		else {
			map.put("sum", String.valueOf(chart.getSum()));
		}

		if (chart.getSumDouble() == null) {
			map.put("sumDouble", null);
		}
		else {
			map.put("sumDouble", String.valueOf(chart.getSumDouble()));
		}

		if (chart.getUnit() == null) {
			map.put("unit", null);
		}
		else {
			map.put("unit", String.valueOf(chart.getUnit()));
		}

		if (chart.getValueArrayDoubles() == null) {
			map.put("valueArrayDoubles", null);
		}
		else {
			map.put(
				"valueArrayDoubles",
				String.valueOf(chart.getValueArrayDoubles()));
		}

		if (chart.getValueArrayStrings() == null) {
			map.put("valueArrayStrings", null);
		}
		else {
			map.put(
				"valueArrayStrings",
				String.valueOf(chart.getValueArrayStrings()));
		}

		if (chart.getValueArrays() == null) {
			map.put("valueArrays", null);
		}
		else {
			map.put("valueArrays", String.valueOf(chart.getValueArrays()));
		}

		if (chart.getValueCharts() == null) {
			map.put("valueCharts", null);
		}
		else {
			map.put("valueCharts", String.valueOf(chart.getValueCharts()));
		}

		return map;
	}

	public static class ChartJSONParser extends BaseJSONParser<Chart> {

		@Override
		protected Chart createDTO() {
			return new Chart();
		}

		@Override
		protected Chart[] createDTOArray(int size) {
			return new Chart[size];
		}

		@Override
		protected void setField(
			Chart chart, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "date")) {
				if (jsonParserFieldValue != null) {
					chart.setDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "obj")) {
				if (jsonParserFieldValue != null) {
					chart.setObj((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "sum")) {
				if (jsonParserFieldValue != null) {
					chart.setSum(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "sumDouble")) {
				if (jsonParserFieldValue != null) {
					chart.setSumDouble(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "unit")) {
				if (jsonParserFieldValue != null) {
					chart.setUnit((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "valueArrayDoubles")) {
				if (jsonParserFieldValue != null) {
					chart.setValueArrayDoubles((Double[])jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "valueArrayStrings")) {
				if (jsonParserFieldValue != null) {
					chart.setValueArrayStrings(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ValueArrayStringSerDes.toDTO(
								(String)object)
						).toArray(
							size -> new ValueArrayString[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "valueArrays")) {
				if (jsonParserFieldValue != null) {
					chart.setValueArrays(
						toLongs((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "valueCharts")) {
				if (jsonParserFieldValue != null) {
					chart.setValueCharts(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ValueChartSerDes.toDTO((String)object)
						).toArray(
							size -> new ValueChart[size]
						));
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