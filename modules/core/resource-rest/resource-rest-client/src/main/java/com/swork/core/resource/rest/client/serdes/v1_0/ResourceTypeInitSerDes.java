package com.swork.core.resource.rest.client.serdes.v1_0;

import com.swork.core.resource.rest.client.dto.v1_0.ResourceType;
import com.swork.core.resource.rest.client.dto.v1_0.ResourceTypeInit;
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
public class ResourceTypeInitSerDes {

	public static ResourceTypeInit toDTO(String json) {
		ResourceTypeInitJSONParser resourceTypeInitJSONParser =
			new ResourceTypeInitJSONParser();

		return resourceTypeInitJSONParser.parseToDTO(json);
	}

	public static ResourceTypeInit[] toDTOs(String json) {
		ResourceTypeInitJSONParser resourceTypeInitJSONParser =
			new ResourceTypeInitJSONParser();

		return resourceTypeInitJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ResourceTypeInit resourceTypeInit) {
		if (resourceTypeInit == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (resourceTypeInit.getCustomerId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"customerId\": ");

			sb.append(resourceTypeInit.getCustomerId());
		}

		if (resourceTypeInit.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(resourceTypeInit.getId());
		}

		if (resourceTypeInit.getResourceTypes() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"resourceTypes\": ");

			sb.append("[");

			for (int i = 0; i < resourceTypeInit.getResourceTypes().length;
				 i++) {

				sb.append(
					String.valueOf(resourceTypeInit.getResourceTypes()[i]));

				if ((i + 1) < resourceTypeInit.getResourceTypes().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ResourceTypeInitJSONParser resourceTypeInitJSONParser =
			new ResourceTypeInitJSONParser();

		return resourceTypeInitJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ResourceTypeInit resourceTypeInit) {
		if (resourceTypeInit == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (resourceTypeInit.getCustomerId() == null) {
			map.put("customerId", null);
		}
		else {
			map.put(
				"customerId", String.valueOf(resourceTypeInit.getCustomerId()));
		}

		if (resourceTypeInit.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(resourceTypeInit.getId()));
		}

		if (resourceTypeInit.getResourceTypes() == null) {
			map.put("resourceTypes", null);
		}
		else {
			map.put(
				"resourceTypes",
				String.valueOf(resourceTypeInit.getResourceTypes()));
		}

		return map;
	}

	public static class ResourceTypeInitJSONParser
		extends BaseJSONParser<ResourceTypeInit> {

		@Override
		protected ResourceTypeInit createDTO() {
			return new ResourceTypeInit();
		}

		@Override
		protected ResourceTypeInit[] createDTOArray(int size) {
			return new ResourceTypeInit[size];
		}

		@Override
		protected void setField(
			ResourceTypeInit resourceTypeInit, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "customerId")) {
				if (jsonParserFieldValue != null) {
					resourceTypeInit.setCustomerId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					resourceTypeInit.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "resourceTypes")) {
				if (jsonParserFieldValue != null) {
					resourceTypeInit.setResourceTypes(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ResourceTypeSerDes.toDTO((String)object)
						).toArray(
							size -> new ResourceType[size]
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