package com.swork.account.rest.client.serdes.v1_0;

import com.swork.account.rest.client.dto.v1_0.Metadata;
import com.swork.account.rest.client.json.BaseJSONParser;

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
public class MetadataSerDes {

	public static Metadata toDTO(String json) {
		MetadataJSONParser metadataJSONParser = new MetadataJSONParser();

		return metadataJSONParser.parseToDTO(json);
	}

	public static Metadata[] toDTOs(String json) {
		MetadataJSONParser metadataJSONParser = new MetadataJSONParser();

		return metadataJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Metadata metadata) {
		if (metadata == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (metadata.getAppId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"appId\": ");

			sb.append("\"");

			sb.append(_escape(metadata.getAppId()));

			sb.append("\"");
		}

		if (metadata.getModuleId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"moduleId\": ");

			sb.append("\"");

			sb.append(_escape(metadata.getModuleId()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		MetadataJSONParser metadataJSONParser = new MetadataJSONParser();

		return metadataJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Metadata metadata) {
		if (metadata == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (metadata.getAppId() == null) {
			map.put("appId", null);
		}
		else {
			map.put("appId", String.valueOf(metadata.getAppId()));
		}

		if (metadata.getModuleId() == null) {
			map.put("moduleId", null);
		}
		else {
			map.put("moduleId", String.valueOf(metadata.getModuleId()));
		}

		return map;
	}

	public static class MetadataJSONParser extends BaseJSONParser<Metadata> {

		@Override
		protected Metadata createDTO() {
			return new Metadata();
		}

		@Override
		protected Metadata[] createDTOArray(int size) {
			return new Metadata[size];
		}

		@Override
		protected void setField(
			Metadata metadata, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "appId")) {
				if (jsonParserFieldValue != null) {
					metadata.setAppId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "moduleId")) {
				if (jsonParserFieldValue != null) {
					metadata.setModuleId((String)jsonParserFieldValue);
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