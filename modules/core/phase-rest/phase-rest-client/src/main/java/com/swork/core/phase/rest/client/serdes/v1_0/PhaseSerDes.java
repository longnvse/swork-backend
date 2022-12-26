package com.swork.core.phase.rest.client.serdes.v1_0;

import com.swork.core.phase.rest.client.dto.v1_0.Phase;
import com.swork.core.phase.rest.client.dto.v1_0.PhaseManage;
import com.swork.core.phase.rest.client.json.BaseJSONParser;

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

		if (phase.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(phase.getDescription()));

			sb.append("\"");
		}

		if (phase.getEndDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"endDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(phase.getEndDate()));

			sb.append("\"");
		}

		if (phase.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(phase.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (phase.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(phase.getId());
		}

		if (phase.getManages() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"manages\": ");

			sb.append("[");

			for (int i = 0; i < phase.getManages().length; i++) {
				sb.append(phase.getManages()[i]);

				if ((i + 1) < phase.getManages().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
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

		if (phase.getPhaseManages() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phaseManages\": ");

			sb.append("[");

			for (int i = 0; i < phase.getPhaseManages().length; i++) {
				sb.append(String.valueOf(phase.getPhaseManages()[i]));

				if ((i + 1) < phase.getPhaseManages().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (phase.getProgress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progress\": ");

			sb.append(phase.getProgress());
		}

		if (phase.getProjectId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectId\": ");

			sb.append(phase.getProjectId());
		}

		if (phase.getProjectName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectName\": ");

			sb.append("\"");

			sb.append(_escape(phase.getProjectName()));

			sb.append("\"");
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

		if (phase.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(phase.getDescription()));
		}

		if (phase.getEndDate() == null) {
			map.put("endDate", null);
		}
		else {
			map.put(
				"endDate", liferayToJSONDateFormat.format(phase.getEndDate()));
		}

		if (phase.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(phase.getExternalReferenceCode()));
		}

		if (phase.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(phase.getId()));
		}

		if (phase.getManages() == null) {
			map.put("manages", null);
		}
		else {
			map.put("manages", String.valueOf(phase.getManages()));
		}

		if (phase.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(phase.getName()));
		}

		if (phase.getPhaseManages() == null) {
			map.put("phaseManages", null);
		}
		else {
			map.put("phaseManages", String.valueOf(phase.getPhaseManages()));
		}

		if (phase.getProgress() == null) {
			map.put("progress", null);
		}
		else {
			map.put("progress", String.valueOf(phase.getProgress()));
		}

		if (phase.getProjectId() == null) {
			map.put("projectId", null);
		}
		else {
			map.put("projectId", String.valueOf(phase.getProjectId()));
		}

		if (phase.getProjectName() == null) {
			map.put("projectName", null);
		}
		else {
			map.put("projectName", String.valueOf(phase.getProjectName()));
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

			if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					phase.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "endDate")) {
				if (jsonParserFieldValue != null) {
					phase.setEndDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					phase.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					phase.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "manages")) {
				if (jsonParserFieldValue != null) {
					phase.setManages(toLongs((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					phase.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phaseManages")) {
				if (jsonParserFieldValue != null) {
					phase.setPhaseManages(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> PhaseManageSerDes.toDTO((String)object)
						).toArray(
							size -> new PhaseManage[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "progress")) {
				if (jsonParserFieldValue != null) {
					phase.setProgress(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectId")) {
				if (jsonParserFieldValue != null) {
					phase.setProjectId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectName")) {
				if (jsonParserFieldValue != null) {
					phase.setProjectName((String)jsonParserFieldValue);
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