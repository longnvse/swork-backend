package com.swork.core.work.rest.client.serdes.v1_0;

import com.swork.core.work.rest.client.dto.v1_0.Handle;
import com.swork.core.work.rest.client.dto.v1_0.Manage;
import com.swork.core.work.rest.client.dto.v1_0.Participate;
import com.swork.core.work.rest.client.dto.v1_0.Work;
import com.swork.core.work.rest.client.json.BaseJSONParser;

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
 * @author longnv
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

		if (work.getActualEndDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actualEndDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(work.getActualEndDate()));

			sb.append("\"");
		}

		if (work.getActualStartDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actualStartDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(work.getActualStartDate()));

			sb.append("\"");
		}

		if (work.getComplete() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"complete\": ");

			sb.append(work.getComplete());
		}

		if (work.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(work.getDescription()));

			sb.append("\"");
		}

		if (work.getDescriptionProgress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"descriptionProgress\": ");

			sb.append("\"");

			sb.append(_escape(work.getDescriptionProgress()));

			sb.append("\"");
		}

		if (work.getEndDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"endDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(work.getEndDate()));

			sb.append("\"");
		}

		if (work.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(work.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (work.getHandles() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"handles\": ");

			sb.append("[");

			for (int i = 0; i < work.getHandles().length; i++) {
				sb.append(String.valueOf(work.getHandles()[i]));

				if ((i + 1) < work.getHandles().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (work.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(work.getId());
		}

		if (work.getIncompleteAmount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"incompleteAmount\": ");

			sb.append(work.getIncompleteAmount());
		}

		if (work.getManages() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"manages\": ");

			sb.append("[");

			for (int i = 0; i < work.getManages().length; i++) {
				sb.append(String.valueOf(work.getManages()[i]));

				if ((i + 1) < work.getManages().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
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

		if (work.getParentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append(work.getParentId());
		}

		if (work.getParentName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentName\": ");

			sb.append("\"");

			sb.append(_escape(work.getParentName()));

			sb.append("\"");
		}

		if (work.getParentStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentStatus\": ");

			sb.append("\"");

			sb.append(work.getParentStatus());

			sb.append("\"");
		}

		if (work.getParticipates() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"participates\": ");

			sb.append("[");

			for (int i = 0; i < work.getParticipates().length; i++) {
				sb.append(String.valueOf(work.getParticipates()[i]));

				if ((i + 1) < work.getParticipates().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (work.getPercentage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"percentage\": ");

			sb.append(work.getPercentage());
		}

		if (work.getPhaseId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phaseId\": ");

			sb.append(work.getPhaseId());
		}

		if (work.getPhaseName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phaseName\": ");

			sb.append("\"");

			sb.append(_escape(work.getPhaseName()));

			sb.append("\"");
		}

		if (work.getProgress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progress\": ");

			sb.append(work.getProgress());
		}

		if (work.getProgressType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progressType\": ");

			sb.append("\"");

			sb.append(work.getProgressType());

			sb.append("\"");
		}

		if (work.getProjectId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectId\": ");

			sb.append(work.getProjectId());
		}

		if (work.getProjectName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectName\": ");

			sb.append("\"");

			sb.append(_escape(work.getProjectName()));

			sb.append("\"");
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

			sb.append(work.getStatus());

			sb.append("\"");
		}

		if (work.getUnit() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"unit\": ");

			sb.append("\"");

			sb.append(_escape(work.getUnit()));

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

		if (work.getActualEndDate() == null) {
			map.put("actualEndDate", null);
		}
		else {
			map.put(
				"actualEndDate",
				liferayToJSONDateFormat.format(work.getActualEndDate()));
		}

		if (work.getActualStartDate() == null) {
			map.put("actualStartDate", null);
		}
		else {
			map.put(
				"actualStartDate",
				liferayToJSONDateFormat.format(work.getActualStartDate()));
		}

		if (work.getComplete() == null) {
			map.put("complete", null);
		}
		else {
			map.put("complete", String.valueOf(work.getComplete()));
		}

		if (work.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(work.getDescription()));
		}

		if (work.getDescriptionProgress() == null) {
			map.put("descriptionProgress", null);
		}
		else {
			map.put(
				"descriptionProgress",
				String.valueOf(work.getDescriptionProgress()));
		}

		if (work.getEndDate() == null) {
			map.put("endDate", null);
		}
		else {
			map.put(
				"endDate", liferayToJSONDateFormat.format(work.getEndDate()));
		}

		if (work.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(work.getExternalReferenceCode()));
		}

		if (work.getHandles() == null) {
			map.put("handles", null);
		}
		else {
			map.put("handles", String.valueOf(work.getHandles()));
		}

		if (work.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(work.getId()));
		}

		if (work.getIncompleteAmount() == null) {
			map.put("incompleteAmount", null);
		}
		else {
			map.put(
				"incompleteAmount", String.valueOf(work.getIncompleteAmount()));
		}

		if (work.getManages() == null) {
			map.put("manages", null);
		}
		else {
			map.put("manages", String.valueOf(work.getManages()));
		}

		if (work.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(work.getName()));
		}

		if (work.getParentId() == null) {
			map.put("parentId", null);
		}
		else {
			map.put("parentId", String.valueOf(work.getParentId()));
		}

		if (work.getParentName() == null) {
			map.put("parentName", null);
		}
		else {
			map.put("parentName", String.valueOf(work.getParentName()));
		}

		if (work.getParentStatus() == null) {
			map.put("parentStatus", null);
		}
		else {
			map.put("parentStatus", String.valueOf(work.getParentStatus()));
		}

		if (work.getParticipates() == null) {
			map.put("participates", null);
		}
		else {
			map.put("participates", String.valueOf(work.getParticipates()));
		}

		if (work.getPercentage() == null) {
			map.put("percentage", null);
		}
		else {
			map.put("percentage", String.valueOf(work.getPercentage()));
		}

		if (work.getPhaseId() == null) {
			map.put("phaseId", null);
		}
		else {
			map.put("phaseId", String.valueOf(work.getPhaseId()));
		}

		if (work.getPhaseName() == null) {
			map.put("phaseName", null);
		}
		else {
			map.put("phaseName", String.valueOf(work.getPhaseName()));
		}

		if (work.getProgress() == null) {
			map.put("progress", null);
		}
		else {
			map.put("progress", String.valueOf(work.getProgress()));
		}

		if (work.getProgressType() == null) {
			map.put("progressType", null);
		}
		else {
			map.put("progressType", String.valueOf(work.getProgressType()));
		}

		if (work.getProjectId() == null) {
			map.put("projectId", null);
		}
		else {
			map.put("projectId", String.valueOf(work.getProjectId()));
		}

		if (work.getProjectName() == null) {
			map.put("projectName", null);
		}
		else {
			map.put("projectName", String.valueOf(work.getProjectName()));
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

		if (work.getUnit() == null) {
			map.put("unit", null);
		}
		else {
			map.put("unit", String.valueOf(work.getUnit()));
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

			if (Objects.equals(jsonParserFieldName, "actualEndDate")) {
				if (jsonParserFieldValue != null) {
					work.setActualEndDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "actualStartDate")) {
				if (jsonParserFieldValue != null) {
					work.setActualStartDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "complete")) {
				if (jsonParserFieldValue != null) {
					work.setComplete(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					work.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "descriptionProgress")) {

				if (jsonParserFieldValue != null) {
					work.setDescriptionProgress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "endDate")) {
				if (jsonParserFieldValue != null) {
					work.setEndDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					work.setExternalReferenceCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "handles")) {
				if (jsonParserFieldValue != null) {
					work.setHandles(
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
					work.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "incompleteAmount")) {
				if (jsonParserFieldValue != null) {
					work.setIncompleteAmount(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "manages")) {
				if (jsonParserFieldValue != null) {
					work.setManages(
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
					work.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentId")) {
				if (jsonParserFieldValue != null) {
					work.setParentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentName")) {
				if (jsonParserFieldValue != null) {
					work.setParentName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentStatus")) {
				if (jsonParserFieldValue != null) {
					work.setParentStatus(
						Work.ParentStatus.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "participates")) {
				if (jsonParserFieldValue != null) {
					work.setParticipates(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ParticipateSerDes.toDTO((String)object)
						).toArray(
							size -> new Participate[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "percentage")) {
				if (jsonParserFieldValue != null) {
					work.setPercentage(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phaseId")) {
				if (jsonParserFieldValue != null) {
					work.setPhaseId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phaseName")) {
				if (jsonParserFieldValue != null) {
					work.setPhaseName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "progress")) {
				if (jsonParserFieldValue != null) {
					work.setProgress(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "progressType")) {
				if (jsonParserFieldValue != null) {
					work.setProgressType(
						Work.ProgressType.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectId")) {
				if (jsonParserFieldValue != null) {
					work.setProjectId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectName")) {
				if (jsonParserFieldValue != null) {
					work.setProjectName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "startDate")) {
				if (jsonParserFieldValue != null) {
					work.setStartDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					work.setStatus(
						Work.Status.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "unit")) {
				if (jsonParserFieldValue != null) {
					work.setUnit((String)jsonParserFieldValue);
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