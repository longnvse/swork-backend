package com.swork.common.file.rest.client.serdes.v2_0;

import com.swork.common.file.rest.client.dto.v2_0.FileRes;
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
public class FileResSerDes {

	public static FileRes toDTO(String json) {
		FileResJSONParser fileResJSONParser = new FileResJSONParser();

		return fileResJSONParser.parseToDTO(json);
	}

	public static FileRes[] toDTOs(String json) {
		FileResJSONParser fileResJSONParser = new FileResJSONParser();

		return fileResJSONParser.parseToDTOs(json);
	}

	public static String toJSON(FileRes fileRes) {
		if (fileRes == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (fileRes.getFileName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileName\": ");

			sb.append("\"");

			sb.append(_escape(fileRes.getFileName()));

			sb.append("\"");
		}

		if (fileRes.getFileSize() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileSize\": ");

			sb.append("\"");

			sb.append(_escape(fileRes.getFileSize()));

			sb.append("\"");
		}

		if (fileRes.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(fileRes.getId());
		}

		if (fileRes.getMetadata() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"metadata\": ");

			sb.append(String.valueOf(fileRes.getMetadata()));
		}

		if (fileRes.getMimeType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mimeType\": ");

			sb.append("\"");

			sb.append(_escape(fileRes.getMimeType()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		FileResJSONParser fileResJSONParser = new FileResJSONParser();

		return fileResJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(FileRes fileRes) {
		if (fileRes == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (fileRes.getFileName() == null) {
			map.put("fileName", null);
		}
		else {
			map.put("fileName", String.valueOf(fileRes.getFileName()));
		}

		if (fileRes.getFileSize() == null) {
			map.put("fileSize", null);
		}
		else {
			map.put("fileSize", String.valueOf(fileRes.getFileSize()));
		}

		if (fileRes.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(fileRes.getId()));
		}

		if (fileRes.getMetadata() == null) {
			map.put("metadata", null);
		}
		else {
			map.put("metadata", String.valueOf(fileRes.getMetadata()));
		}

		if (fileRes.getMimeType() == null) {
			map.put("mimeType", null);
		}
		else {
			map.put("mimeType", String.valueOf(fileRes.getMimeType()));
		}

		return map;
	}

	public static class FileResJSONParser extends BaseJSONParser<FileRes> {

		@Override
		protected FileRes createDTO() {
			return new FileRes();
		}

		@Override
		protected FileRes[] createDTOArray(int size) {
			return new FileRes[size];
		}

		@Override
		protected void setField(
			FileRes fileRes, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "fileName")) {
				if (jsonParserFieldValue != null) {
					fileRes.setFileName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileSize")) {
				if (jsonParserFieldValue != null) {
					fileRes.setFileSize((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					fileRes.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "metadata")) {
				if (jsonParserFieldValue != null) {
					fileRes.setMetadata(
						MetadataSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mimeType")) {
				if (jsonParserFieldValue != null) {
					fileRes.setMimeType((String)jsonParserFieldValue);
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