package com.swork.core.project.rest.client.serdes.v1_0;

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
public class WorkSerDes {

	public static Work toDTO(String json) {
		WorkJSONParser workJSONParser = new WorkJSONParser();

		return workJSONParser.parseToDTO(json);
	}

	public static Work[] toDTOs(String json) {
		WorkJSONParser workJSONParser = new WorkJSONParser();

		return workJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Work work) {
		if (work == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (work.getEndDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"endDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(work.getEndDate()));

			sb.append("\"");
		}

		if (work.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(work.getId());
		}

		if (work.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(work.getName()));

			sb.append("\"");
		}

		if (work.getProgress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progress\": ");

			sb.append(work.getProgress());
		}

		if (work.getStartDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(work.getStartDate()));

			sb.append("\"");
		}

		if (work.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(work.getStatus()));

			sb.append("\"");
		}

		if (work.getWorks() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"works\": ");

			sb.append("[");

			for (int i = 0; i < work.getWorks().length; i++) {
				sb.append(String.valueOf(work.getWorks()[i]));

				if ((i + 1) < work.getWorks().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		WorkJSONParser workJSONParser = new WorkJSONParser();

		return workJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Work work) {
		if (work == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (work.getEndDate() == null) {
			map.put("endDate", null);
		}
		else {
			map.put(
				"endDate", liferayToJSONDateFormat.format(work.getEndDate()));
		}

		if (work.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(work.getId()));
		}

		if (work.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(work.getName()));
		}

		if (work.getProgress() == null) {
			map.put("progress", null);
		}
		else {
			map.put("progress", String.valueOf(work.getProgress()));
		}

		if (work.getStartDate() == null) {
			map.put("startDate", null);
		}
		else {
			map.put(
				"startDate",
				liferayToJSONDateFormat.format(work.getStartDate()));
		}

		if (work.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(work.getStatus()));
		}

		if (work.getWorks() == null) {
			map.put("works", null);
		}
		else {
			map.put("works", String.valueOf(work.getWorks()));
		}

		return map;
	}

	public static class WorkJSONParser extends BaseJSONParser<Work> {

		@Override
		protected Work createDTO() {
			return new Work();
		}

		@Override
		protected Work[] createDTOArray(int size) {
			return new Work[size];
		}

		@Override
		protected void setField(
			Work work, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "endDate")) {
				if (jsonParserFieldValue != null) {
					work.setEndDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					work.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					work.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "progress")) {
				if (jsonParserFieldValue != null) {
					work.setProgress(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "startDate")) {
				if (jsonParserFieldValue != null) {
					work.setStartDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					work.setStatus((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "works")) {
				if (jsonParserFieldValue != null) {
					work.setWorks(
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