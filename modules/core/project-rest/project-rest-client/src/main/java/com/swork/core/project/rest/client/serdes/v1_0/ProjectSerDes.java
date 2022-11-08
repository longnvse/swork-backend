package com.swork.core.project.rest.client.serdes.v1_0;

import com.swork.core.project.rest.client.dto.v1_0.Handle;
import com.swork.core.project.rest.client.dto.v1_0.Manage;
import com.swork.core.project.rest.client.dto.v1_0.Participate;
import com.swork.core.project.rest.client.dto.v1_0.Project;
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
public class ProjectSerDes {

	public static Project toDTO(String json) {
		ProjectJSONParser projectJSONParser = new ProjectJSONParser();

		return projectJSONParser.parseToDTO(json);
	}

	public static Project[] toDTOs(String json) {
		ProjectJSONParser projectJSONParser = new ProjectJSONParser();

		return projectJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Project project) {
		if (project == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (project.getActualEndDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actualEndDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(project.getActualEndDate()));

			sb.append("\"");
		}

		if (project.getActualStartDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actualStartDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(project.getActualStartDate()));

			sb.append("\"");
		}

		if (project.getBudget() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"budget\": ");

			sb.append(project.getBudget());
		}

		if (project.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append("\"");

			sb.append(_escape(project.getCode()));

			sb.append("\"");
		}

		if (project.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(project.getDescription()));

			sb.append("\"");
		}

		if (project.getEndDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"endDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(project.getEndDate()));

			sb.append("\"");
		}

		if (project.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(project.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (project.getHandles() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"handles\": ");

			sb.append("[");

			for (int i = 0; i < project.getHandles().length; i++) {
				sb.append(String.valueOf(project.getHandles()[i]));

				if ((i + 1) < project.getHandles().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (project.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(project.getId());
		}

		if (project.getManages() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"manages\": ");

			sb.append("[");

			for (int i = 0; i < project.getManages().length; i++) {
				sb.append(String.valueOf(project.getManages()[i]));

				if ((i + 1) < project.getManages().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (project.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(project.getName()));

			sb.append("\"");
		}

		if (project.getParticipates() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"participates\": ");

			sb.append("[");

			for (int i = 0; i < project.getParticipates().length; i++) {
				sb.append(String.valueOf(project.getParticipates()[i]));

				if ((i + 1) < project.getParticipates().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (project.getProgress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progress\": ");

			sb.append(project.getProgress());
		}

		if (project.getProgressType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progressType\": ");

			sb.append("\"");

			sb.append(_escape(project.getProgressType()));

			sb.append("\"");
		}

		if (project.getStartDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(project.getStartDate()));

			sb.append("\"");
		}

		if (project.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(project.getStatus());

			sb.append("\"");
		}

		if (project.getUnit() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"unit\": ");

			sb.append("\"");

			sb.append(_escape(project.getUnit()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProjectJSONParser projectJSONParser = new ProjectJSONParser();

		return projectJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Project project) {
		if (project == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (project.getActualEndDate() == null) {
			map.put("actualEndDate", null);
		}
		else {
			map.put(
				"actualEndDate",
				liferayToJSONDateFormat.format(project.getActualEndDate()));
		}

		if (project.getActualStartDate() == null) {
			map.put("actualStartDate", null);
		}
		else {
			map.put(
				"actualStartDate",
				liferayToJSONDateFormat.format(project.getActualStartDate()));
		}

		if (project.getBudget() == null) {
			map.put("budget", null);
		}
		else {
			map.put("budget", String.valueOf(project.getBudget()));
		}

		if (project.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(project.getCode()));
		}

		if (project.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(project.getDescription()));
		}

		if (project.getEndDate() == null) {
			map.put("endDate", null);
		}
		else {
			map.put(
				"endDate",
				liferayToJSONDateFormat.format(project.getEndDate()));
		}

		if (project.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(project.getExternalReferenceCode()));
		}

		if (project.getHandles() == null) {
			map.put("handles", null);
		}
		else {
			map.put("handles", String.valueOf(project.getHandles()));
		}

		if (project.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(project.getId()));
		}

		if (project.getManages() == null) {
			map.put("manages", null);
		}
		else {
			map.put("manages", String.valueOf(project.getManages()));
		}

		if (project.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(project.getName()));
		}

		if (project.getParticipates() == null) {
			map.put("participates", null);
		}
		else {
			map.put("participates", String.valueOf(project.getParticipates()));
		}

		if (project.getProgress() == null) {
			map.put("progress", null);
		}
		else {
			map.put("progress", String.valueOf(project.getProgress()));
		}

		if (project.getProgressType() == null) {
			map.put("progressType", null);
		}
		else {
			map.put("progressType", String.valueOf(project.getProgressType()));
		}

		if (project.getStartDate() == null) {
			map.put("startDate", null);
		}
		else {
			map.put(
				"startDate",
				liferayToJSONDateFormat.format(project.getStartDate()));
		}

		if (project.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(project.getStatus()));
		}

		if (project.getUnit() == null) {
			map.put("unit", null);
		}
		else {
			map.put("unit", String.valueOf(project.getUnit()));
		}

		return map;
	}

	public static class ProjectJSONParser extends BaseJSONParser<Project> {

		@Override
		protected Project createDTO() {
			return new Project();
		}

		@Override
		protected Project[] createDTOArray(int size) {
			return new Project[size];
		}

		@Override
		protected void setField(
			Project project, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "actualEndDate")) {
				if (jsonParserFieldValue != null) {
					project.setActualEndDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "actualStartDate")) {
				if (jsonParserFieldValue != null) {
					project.setActualStartDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "budget")) {
				if (jsonParserFieldValue != null) {
					project.setBudget(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					project.setCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					project.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "endDate")) {
				if (jsonParserFieldValue != null) {
					project.setEndDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					project.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "handles")) {
				if (jsonParserFieldValue != null) {
					project.setHandles(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> HandleSerDes.toDTO((String)object)
						).toArray(
							size -> new Handle[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					project.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "manages")) {
				if (jsonParserFieldValue != null) {
					project.setManages(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ManageSerDes.toDTO((String)object)
						).toArray(
							size -> new Manage[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					project.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "participates")) {
				if (jsonParserFieldValue != null) {
					project.setParticipates(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ParticipateSerDes.toDTO((String)object)
						).toArray(
							size -> new Participate[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "progress")) {
				if (jsonParserFieldValue != null) {
					project.setProgress(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "progressType")) {
				if (jsonParserFieldValue != null) {
					project.setProgressType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "startDate")) {
				if (jsonParserFieldValue != null) {
					project.setStartDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					project.setStatus(
						Project.Status.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "unit")) {
				if (jsonParserFieldValue != null) {
					project.setUnit((String)jsonParserFieldValue);
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