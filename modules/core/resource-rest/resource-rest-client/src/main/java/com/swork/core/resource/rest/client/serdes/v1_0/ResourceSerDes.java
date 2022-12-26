package com.swork.core.resource.rest.client.serdes.v1_0;

import com.swork.core.resource.rest.client.dto.v1_0.Resource;
import com.swork.core.resource.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class ResourceSerDes {

	public static Resource toDTO(String json) {
		ResourceJSONParser resourceJSONParser = new ResourceJSONParser();

		return resourceJSONParser.parseToDTO(json);
	}

	public static Resource[] toDTOs(String json) {
		ResourceJSONParser resourceJSONParser = new ResourceJSONParser();

		return resourceJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Resource resource) {
		if (resource == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (resource.getCreator() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append("\"");

			sb.append(_escape(resource.getCreator()));

			sb.append("\"");
		}

		if (resource.getCreatorId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorId\": ");

			sb.append(resource.getCreatorId());
		}

		if (resource.getDateResource() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateResource\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(resource.getDateResource()));

			sb.append("\"");
		}

		if (resource.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(resource.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (resource.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(resource.getId());
		}

		if (resource.getParentName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentName\": ");

			sb.append("\"");

			sb.append(_escape(resource.getParentName()));

			sb.append("\"");
		}

		if (resource.getPhaseId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phaseId\": ");

			sb.append(resource.getPhaseId());
		}

		if (resource.getProjectId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectId\": ");

			sb.append(resource.getProjectId());
		}

		if (resource.getQuantity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"quantity\": ");

			sb.append(resource.getQuantity());
		}

		if (resource.getResourceTypeName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"resourceTypeName\": ");

			sb.append("\"");

			sb.append(_escape(resource.getResourceTypeName()));

			sb.append("\"");
		}

		if (resource.getTeamId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"teamId\": ");

			sb.append(resource.getTeamId());
		}

		if (resource.getTeamName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"teamName\": ");

			sb.append("\"");

			sb.append(_escape(resource.getTeamName()));

			sb.append("\"");
		}

		if (resource.getTotalAmount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalAmount\": ");

			sb.append(resource.getTotalAmount());
		}

		if (resource.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(_escape(resource.getType()));

			sb.append("\"");
		}

		if (resource.getUnit() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"unit\": ");

			sb.append("\"");

			sb.append(_escape(resource.getUnit()));

			sb.append("\"");
		}

		if (resource.getWorkId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"workId\": ");

			sb.append(resource.getWorkId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ResourceJSONParser resourceJSONParser = new ResourceJSONParser();

		return resourceJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Resource resource) {
		if (resource == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (resource.getCreator() == null) {
			map.put("creator", null);
		}
		else {
			map.put("creator", String.valueOf(resource.getCreator()));
		}

		if (resource.getCreatorId() == null) {
			map.put("creatorId", null);
		}
		else {
			map.put("creatorId", String.valueOf(resource.getCreatorId()));
		}

		if (resource.getDateResource() == null) {
			map.put("dateResource", null);
		}
		else {
			map.put(
				"dateResource",
				liferayToJSONDateFormat.format(resource.getDateResource()));
		}

		if (resource.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(resource.getExternalReferenceCode()));
		}

		if (resource.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(resource.getId()));
		}

		if (resource.getParentName() == null) {
			map.put("parentName", null);
		}
		else {
			map.put("parentName", String.valueOf(resource.getParentName()));
		}

		if (resource.getPhaseId() == null) {
			map.put("phaseId", null);
		}
		else {
			map.put("phaseId", String.valueOf(resource.getPhaseId()));
		}

		if (resource.getProjectId() == null) {
			map.put("projectId", null);
		}
		else {
			map.put("projectId", String.valueOf(resource.getProjectId()));
		}

		if (resource.getQuantity() == null) {
			map.put("quantity", null);
		}
		else {
			map.put("quantity", String.valueOf(resource.getQuantity()));
		}

		if (resource.getResourceTypeName() == null) {
			map.put("resourceTypeName", null);
		}
		else {
			map.put(
				"resourceTypeName",
				String.valueOf(resource.getResourceTypeName()));
		}

		if (resource.getTeamId() == null) {
			map.put("teamId", null);
		}
		else {
			map.put("teamId", String.valueOf(resource.getTeamId()));
		}

		if (resource.getTeamName() == null) {
			map.put("teamName", null);
		}
		else {
			map.put("teamName", String.valueOf(resource.getTeamName()));
		}

		if (resource.getTotalAmount() == null) {
			map.put("totalAmount", null);
		}
		else {
			map.put("totalAmount", String.valueOf(resource.getTotalAmount()));
		}

		if (resource.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(resource.getType()));
		}

		if (resource.getUnit() == null) {
			map.put("unit", null);
		}
		else {
			map.put("unit", String.valueOf(resource.getUnit()));
		}

		if (resource.getWorkId() == null) {
			map.put("workId", null);
		}
		else {
			map.put("workId", String.valueOf(resource.getWorkId()));
		}

		return map;
	}

	public static class ResourceJSONParser extends BaseJSONParser<Resource> {

		@Override
		protected Resource createDTO() {
			return new Resource();
		}

		@Override
		protected Resource[] createDTOArray(int size) {
			return new Resource[size];
		}

		@Override
		protected void setField(
			Resource resource, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "creator")) {
				if (jsonParserFieldValue != null) {
					resource.setCreator((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creatorId")) {
				if (jsonParserFieldValue != null) {
					resource.setCreatorId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateResource")) {
				if (jsonParserFieldValue != null) {
					resource.setDateResource(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					resource.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					resource.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentName")) {
				if (jsonParserFieldValue != null) {
					resource.setParentName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phaseId")) {
				if (jsonParserFieldValue != null) {
					resource.setPhaseId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectId")) {
				if (jsonParserFieldValue != null) {
					resource.setProjectId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "quantity")) {
				if (jsonParserFieldValue != null) {
					resource.setQuantity(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "resourceTypeName")) {
				if (jsonParserFieldValue != null) {
					resource.setResourceTypeName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "teamId")) {
				if (jsonParserFieldValue != null) {
					resource.setTeamId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "teamName")) {
				if (jsonParserFieldValue != null) {
					resource.setTeamName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalAmount")) {
				if (jsonParserFieldValue != null) {
					resource.setTotalAmount(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					resource.setType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "unit")) {
				if (jsonParserFieldValue != null) {
					resource.setUnit((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "workId")) {
				if (jsonParserFieldValue != null) {
					resource.setWorkId(
						Long.valueOf((String)jsonParserFieldValue));
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