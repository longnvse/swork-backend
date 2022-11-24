package com.swork.core.resource.rest.client.serdes.v1_0;

import com.swork.core.resource.rest.client.dto.v1_0.ResourceType;
import com.swork.core.resource.rest.client.json.BaseJSONParser;

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
public class ResourceTypeSerDes {

	public static ResourceType toDTO(String json) {
		ResourceTypeJSONParser resourceTypeJSONParser =
			new ResourceTypeJSONParser();

		return resourceTypeJSONParser.parseToDTO(json);
	}

	public static ResourceType[] toDTOs(String json) {
		ResourceTypeJSONParser resourceTypeJSONParser =
			new ResourceTypeJSONParser();

		return resourceTypeJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ResourceType resourceType) {
		if (resourceType == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (resourceType.getCreator() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append("\"");

			sb.append(_escape(resourceType.getCreator()));

			sb.append("\"");
		}

		if (resourceType.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(resourceType.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (resourceType.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(resourceType.getId());
		}

		if (resourceType.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(resourceType.getName()));

			sb.append("\"");
		}

		if (resourceType.getParentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append(resourceType.getParentId());
		}

		if (resourceType.getResourceTypes() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"resourceTypes\": ");

			sb.append("[");

			for (int i = 0; i < resourceType.getResourceTypes().length; i++) {
				sb.append(String.valueOf(resourceType.getResourceTypes()[i]));

				if ((i + 1) < resourceType.getResourceTypes().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (resourceType.getUnit() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"unit\": ");

			sb.append("\"");

			sb.append(_escape(resourceType.getUnit()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ResourceTypeJSONParser resourceTypeJSONParser =
			new ResourceTypeJSONParser();

		return resourceTypeJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ResourceType resourceType) {
		if (resourceType == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (resourceType.getCreator() == null) {
			map.put("creator", null);
		}
		else {
			map.put("creator", String.valueOf(resourceType.getCreator()));
		}

		if (resourceType.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(resourceType.getExternalReferenceCode()));
		}

		if (resourceType.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(resourceType.getId()));
		}

		if (resourceType.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(resourceType.getName()));
		}

		if (resourceType.getParentId() == null) {
			map.put("parentId", null);
		}
		else {
			map.put("parentId", String.valueOf(resourceType.getParentId()));
		}

		if (resourceType.getResourceTypes() == null) {
			map.put("resourceTypes", null);
		}
		else {
			map.put(
				"resourceTypes",
				String.valueOf(resourceType.getResourceTypes()));
		}

		if (resourceType.getUnit() == null) {
			map.put("unit", null);
		}
		else {
			map.put("unit", String.valueOf(resourceType.getUnit()));
		}

		return map;
	}

	public static class ResourceTypeJSONParser
		extends BaseJSONParser<ResourceType> {

		@Override
		protected ResourceType createDTO() {
			return new ResourceType();
		}

		@Override
		protected ResourceType[] createDTOArray(int size) {
			return new ResourceType[size];
		}

		@Override
		protected void setField(
			ResourceType resourceType, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "creator")) {
				if (jsonParserFieldValue != null) {
					resourceType.setCreator((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					resourceType.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					resourceType.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					resourceType.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentId")) {
				if (jsonParserFieldValue != null) {
					resourceType.setParentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "resourceTypes")) {
				if (jsonParserFieldValue != null) {
					resourceType.setResourceTypes(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ResourceTypeSerDes.toDTO((String)object)
						).toArray(
							size -> new ResourceType[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "unit")) {
				if (jsonParserFieldValue != null) {
					resourceType.setUnit((String)jsonParserFieldValue);
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