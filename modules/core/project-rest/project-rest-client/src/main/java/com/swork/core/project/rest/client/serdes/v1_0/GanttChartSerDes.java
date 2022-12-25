package com.swork.core.project.rest.client.serdes.v1_0;

import com.swork.core.project.rest.client.dto.v1_0.GanttChart;
import com.swork.core.project.rest.client.dto.v1_0.Phase;
import com.swork.core.project.rest.client.dto.v1_0.Work;
import com.swork.core.project.rest.client.json.BaseJSONParser;

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
public class GanttChartSerDes {

	public static GanttChart toDTO(String json) {
		GanttChartJSONParser ganttChartJSONParser = new GanttChartJSONParser();

		return ganttChartJSONParser.parseToDTO(json);
	}

	public static GanttChart[] toDTOs(String json) {
		GanttChartJSONParser ganttChartJSONParser = new GanttChartJSONParser();

		return ganttChartJSONParser.parseToDTOs(json);
	}

	public static String toJSON(GanttChart ganttChart) {
		if (ganttChart == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (ganttChart.getPhases() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phases\": ");

			sb.append("[");

			for (int i = 0; i < ganttChart.getPhases().length; i++) {
				sb.append(String.valueOf(ganttChart.getPhases()[i]));

				if ((i + 1) < ganttChart.getPhases().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (ganttChart.getWorks() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"works\": ");

			sb.append("[");

			for (int i = 0; i < ganttChart.getWorks().length; i++) {
				sb.append(String.valueOf(ganttChart.getWorks()[i]));

				if ((i + 1) < ganttChart.getWorks().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		GanttChartJSONParser ganttChartJSONParser = new GanttChartJSONParser();

		return ganttChartJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(GanttChart ganttChart) {
		if (ganttChart == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (ganttChart.getPhases() == null) {
			map.put("phases", null);
		}
		else {
			map.put("phases", String.valueOf(ganttChart.getPhases()));
		}

		if (ganttChart.getWorks() == null) {
			map.put("works", null);
		}
		else {
			map.put("works", String.valueOf(ganttChart.getWorks()));
		}

		return map;
	}

	public static class GanttChartJSONParser
		extends BaseJSONParser<GanttChart> {

		@Override
		protected GanttChart createDTO() {
			return new GanttChart();
		}

		@Override
		protected GanttChart[] createDTOArray(int size) {
			return new GanttChart[size];
		}

		@Override
		protected void setField(
			GanttChart ganttChart, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "phases")) {
				if (jsonParserFieldValue != null) {
					ganttChart.setPhases(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> PhaseSerDes.toDTO((String)object)
						).toArray(
							size -> new Phase[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "works")) {
				if (jsonParserFieldValue != null) {
					ganttChart.setWorks(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> WorkSerDes.toDTO((String)object)
						).toArray(
							size -> new Work[size]
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