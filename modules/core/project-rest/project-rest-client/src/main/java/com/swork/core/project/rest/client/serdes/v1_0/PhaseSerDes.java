package com.swork.core.project.rest.client.serdes.v1_0;

import com.swork.core.project.rest.client.dto.v1_0.Phase;
import com.swork.core.project.rest.client.dto.v1_0.Work;
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
public class PhaseSerDes {

	public static Phase toDTO(String json) {
		PhaseJSONParser phaseJSONParser = new PhaseJSONParser();

		return phaseJSONParser.parseToDTO(json);
	}

	public static Phase[] toDTOs(String json) {
		PhaseJSONParser phaseJSONParser = new PhaseJSONParser();

		return phaseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Phase phase) {
		if (phase == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (phase.getEndDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"endDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(phase.getEndDate()));

			sb.append("\"");
		}

		if (phase.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(phase.getId());
		}

		if (phase.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(phase.getName()));

			sb.append("\"");
		}

		if (phase.getProgress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progress\": ");

			sb.append(phase.getProgress());
		}

		if (phase.getStartDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(phase.getStartDate()));

			sb.append("\"");
		}

		if (phase.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(phase.getStatus()));

			sb.append("\"");
		}

		if (phase.getWorks() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"works\": ");

			sb.append("[");

			for (int i = 0; i < phase.getWorks().length; i++) {
				sb.append(String.valueOf(phase.getWorks()[i]));

				if ((i + 1) < phase.getWorks().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PhaseJSONParser phaseJSONParser = new PhaseJSONParser();

		return phaseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Phase phase) {
		if (phase == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (phase.getEndDate() == null) {
			map.put("endDate", null);
		}
		else {
			map.put(
				"endDate", liferayToJSONDateFormat.format(phase.getEndDate()));
		}

		if (phase.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(phase.getId()));
		}

		if (phase.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(phase.getName()));
		}

		if (phase.getProgress() == null) {
			map.put("progress", null);
		}
		else {
			map.put("progress", String.valueOf(phase.getProgress()));
		}

		if (phase.getStartDate() == null) {
			map.put("startDate", null);
		}
		else {
			map.put(
				"startDate",
				liferayToJSONDateFormat.format(phase.getStartDate()));
		}

		if (phase.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(phase.getStatus()));
		}

		if (phase.getWorks() == null) {
			map.put("works", null);
		}
		else {
			map.put("works", String.valueOf(phase.getWorks()));
		}

		return map;
	}

	public static class PhaseJSONParser extends BaseJSONParser<Phase> {

		@Override
		protected Phase createDTO() {
			return new Phase();
		}

		@Override
		protected Phase[] createDTOArray(int size) {
			return new Phase[size];
		}

		@Override
		protected void setField(
			Phase phase, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "endDate")) {
				if (jsonParserFieldValue != null) {
					phase.setEndDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					phase.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					phase.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "progress")) {
				if (jsonParserFieldValue != null) {
					phase.setProgress(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "startDate")) {
				if (jsonParserFieldValue != null) {
					phase.setStartDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					phase.setStatus((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "works")) {
				if (jsonParserFieldValue != null) {
					phase.setWorks(
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