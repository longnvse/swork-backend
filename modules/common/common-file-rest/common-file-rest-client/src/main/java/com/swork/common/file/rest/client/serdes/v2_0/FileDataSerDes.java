package com.swork.common.file.rest.client.serdes.v2_0;

import com.swork.common.file.rest.client.dto.v2_0.FileData;
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
public class FileDataSerDes {

	public static FileData toDTO(String json) {
		FileDataJSONParser fileDataJSONParser = new FileDataJSONParser();

		return fileDataJSONParser.parseToDTO(json);
	}

	public static FileData[] toDTOs(String json) {
		FileDataJSONParser fileDataJSONParser = new FileDataJSONParser();

		return fileDataJSONParser.parseToDTOs(json);
	}

	public static String toJSON(FileData fileData) {
		if (fileData == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (fileData.getData() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"data\": ");

			sb.append("\"");

			sb.append(_escape(fileData.getData()));

			sb.append("\"");
		}

		if (fileData.getDocumentType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"documentType\": ");

			sb.append("\"");

			sb.append(_escape(fileData.getDocumentType()));

			sb.append("\"");
		}

		if (fileData.getFileType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileType\": ");

			sb.append("\"");

			sb.append(_escape(fileData.getFileType()));

			sb.append("\"");
		}

		if (fileData.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(fileData.getId());
		}

		if (fileData.getKey() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"key\": ");

			sb.append("\"");

			sb.append(_escape(fileData.getKey()));

			sb.append("\"");
		}

		if (fileData.getSize() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"size\": ");

			sb.append(fileData.getSize());
		}

		if (fileData.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(fileData.getTitle()));

			sb.append("\"");
		}

		if (fileData.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(_escape(fileData.getType()));

			sb.append("\"");
		}

		if (fileData.getUrl() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"url\": ");

			sb.append("\"");

			sb.append(_escape(fileData.getUrl()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		FileDataJSONParser fileDataJSONParser = new FileDataJSONParser();

		return fileDataJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(FileData fileData) {
		if (fileData == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (fileData.getData() == null) {
			map.put("data", null);
		}
		else {
			map.put("data", String.valueOf(fileData.getData()));
		}

		if (fileData.getDocumentType() == null) {
			map.put("documentType", null);
		}
		else {
			map.put("documentType", String.valueOf(fileData.getDocumentType()));
		}

		if (fileData.getFileType() == null) {
			map.put("fileType", null);
		}
		else {
			map.put("fileType", String.valueOf(fileData.getFileType()));
		}

		if (fileData.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(fileData.getId()));
		}

		if (fileData.getKey() == null) {
			map.put("key", null);
		}
		else {
			map.put("key", String.valueOf(fileData.getKey()));
		}

		if (fileData.getSize() == null) {
			map.put("size", null);
		}
		else {
			map.put("size", String.valueOf(fileData.getSize()));
		}

		if (fileData.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(fileData.getTitle()));
		}

		if (fileData.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(fileData.getType()));
		}

		if (fileData.getUrl() == null) {
			map.put("url", null);
		}
		else {
			map.put("url", String.valueOf(fileData.getUrl()));
		}

		return map;
	}

	public static class FileDataJSONParser extends BaseJSONParser<FileData> {

		@Override
		protected FileData createDTO() {
			return new FileData();
		}

		@Override
		protected FileData[] createDTOArray(int size) {
			return new FileData[size];
		}

		@Override
		protected void setField(
			FileData fileData, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "data")) {
				if (jsonParserFieldValue != null) {
					fileData.setData((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "documentType")) {
				if (jsonParserFieldValue != null) {
					fileData.setDocumentType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileType")) {
				if (jsonParserFieldValue != null) {
					fileData.setFileType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					fileData.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "key")) {
				if (jsonParserFieldValue != null) {
					fileData.setKey((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "size")) {
				if (jsonParserFieldValue != null) {
					fileData.setSize(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					fileData.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					fileData.setType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "url")) {
				if (jsonParserFieldValue != null) {
					fileData.setUrl((String)jsonParserFieldValue);
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