package com.swork.common.file.rest.client.serdes.v2_0;

import com.swork.common.file.rest.client.dto.v2_0.FileUpdate;
import com.swork.common.file.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author ninhvv
 * @generated
 */
@Generated("")
public class FileUpdateSerDes {

	public static FileUpdate toDTO(String json) {
		FileUpdateJSONParser fileUpdateJSONParser = new FileUpdateJSONParser();

		return fileUpdateJSONParser.parseToDTO(json);
	}

	public static FileUpdate[] toDTOs(String json) {
		FileUpdateJSONParser fileUpdateJSONParser = new FileUpdateJSONParser();

		return fileUpdateJSONParser.parseToDTOs(json);
	}

	public static String toJSON(FileUpdate fileUpdate) {
		if (fileUpdate == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (fileUpdate.getSize() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"size\": ");

			sb.append(fileUpdate.getSize());
		}

		if (fileUpdate.getUrl() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"url\": ");

			sb.append("\"");

			sb.append(_escape(fileUpdate.getUrl()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		FileUpdateJSONParser fileUpdateJSONParser = new FileUpdateJSONParser();

		return fileUpdateJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(FileUpdate fileUpdate) {
		if (fileUpdate == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (fileUpdate.getSize() == null) {
			map.put("size", null);
		}
		else {
			map.put("size", String.valueOf(fileUpdate.getSize()));
		}

		if (fileUpdate.getUrl() == null) {
			map.put("url", null);
		}
		else {
			map.put("url", String.valueOf(fileUpdate.getUrl()));
		}

		return map;
	}

	public static class FileUpdateJSONParser
		extends BaseJSONParser<FileUpdate> {

		@Override
		protected FileUpdate createDTO() {
			return new FileUpdate();
		}

		@Override
		protected FileUpdate[] createDTOArray(int size) {
			return new FileUpdate[size];
		}

		@Override
		protected void setField(
			FileUpdate fileUpdate, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "size")) {
				if (jsonParserFieldValue != null) {
					fileUpdate.setSize(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "url")) {
				if (jsonParserFieldValue != null) {
					fileUpdate.setUrl((String)jsonParserFieldValue);
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