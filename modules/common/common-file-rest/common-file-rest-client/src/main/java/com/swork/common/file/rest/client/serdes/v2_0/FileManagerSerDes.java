package com.swork.common.file.rest.client.serdes.v2_0;

import com.swork.common.file.rest.client.dto.v2_0.FileManager;
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
public class FileManagerSerDes {

	public static FileManager toDTO(String json) {
		FileManagerJSONParser fileManagerJSONParser =
			new FileManagerJSONParser();

		return fileManagerJSONParser.parseToDTO(json);
	}

	public static FileManager[] toDTOs(String json) {
		FileManagerJSONParser fileManagerJSONParser =
			new FileManagerJSONParser();

		return fileManagerJSONParser.parseToDTOs(json);
	}

	public static String toJSON(FileManager fileManager) {
		if (fileManager == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (fileManager.getFileId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileId\": ");

			sb.append(fileManager.getFileId());
		}

		if (fileManager.getFileName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileName\": ");

			sb.append("\"");

			sb.append(_escape(fileManager.getFileName()));

			sb.append("\"");
		}

		if (fileManager.getFileSize() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileSize\": ");

			sb.append("\"");

			sb.append(_escape(fileManager.getFileSize()));

			sb.append("\"");
		}

		if (fileManager.getFileType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileType\": ");

			sb.append("\"");

			sb.append(_escape(fileManager.getFileType()));

			sb.append("\"");
		}

		if (fileManager.getMetadata() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"metadata\": ");

			sb.append(String.valueOf(fileManager.getMetadata()));
		}

		if (fileManager.getMineType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mineType\": ");

			sb.append("\"");

			sb.append(_escape(fileManager.getMineType()));

			sb.append("\"");
		}

		if (fileManager.getParentCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentCode\": ");

			sb.append("\"");

			sb.append(_escape(fileManager.getParentCode()));

			sb.append("\"");
		}

		if (fileManager.getPkType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"pkType\": ");

			sb.append("\"");

			sb.append(_escape(fileManager.getPkType()));

			sb.append("\"");
		}

		if (fileManager.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(_escape(fileManager.getType()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		FileManagerJSONParser fileManagerJSONParser =
			new FileManagerJSONParser();

		return fileManagerJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(FileManager fileManager) {
		if (fileManager == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (fileManager.getFileId() == null) {
			map.put("fileId", null);
		}
		else {
			map.put("fileId", String.valueOf(fileManager.getFileId()));
		}

		if (fileManager.getFileName() == null) {
			map.put("fileName", null);
		}
		else {
			map.put("fileName", String.valueOf(fileManager.getFileName()));
		}

		if (fileManager.getFileSize() == null) {
			map.put("fileSize", null);
		}
		else {
			map.put("fileSize", String.valueOf(fileManager.getFileSize()));
		}

		if (fileManager.getFileType() == null) {
			map.put("fileType", null);
		}
		else {
			map.put("fileType", String.valueOf(fileManager.getFileType()));
		}

		if (fileManager.getMetadata() == null) {
			map.put("metadata", null);
		}
		else {
			map.put("metadata", String.valueOf(fileManager.getMetadata()));
		}

		if (fileManager.getMineType() == null) {
			map.put("mineType", null);
		}
		else {
			map.put("mineType", String.valueOf(fileManager.getMineType()));
		}

		if (fileManager.getParentCode() == null) {
			map.put("parentCode", null);
		}
		else {
			map.put("parentCode", String.valueOf(fileManager.getParentCode()));
		}

		if (fileManager.getPkType() == null) {
			map.put("pkType", null);
		}
		else {
			map.put("pkType", String.valueOf(fileManager.getPkType()));
		}

		if (fileManager.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(fileManager.getType()));
		}

		return map;
	}

	public static class FileManagerJSONParser
		extends BaseJSONParser<FileManager> {

		@Override
		protected FileManager createDTO() {
			return new FileManager();
		}

		@Override
		protected FileManager[] createDTOArray(int size) {
			return new FileManager[size];
		}

		@Override
		protected void setField(
			FileManager fileManager, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "fileId")) {
				if (jsonParserFieldValue != null) {
					fileManager.setFileId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileName")) {
				if (jsonParserFieldValue != null) {
					fileManager.setFileName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileSize")) {
				if (jsonParserFieldValue != null) {
					fileManager.setFileSize((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileType")) {
				if (jsonParserFieldValue != null) {
					fileManager.setFileType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "metadata")) {
				if (jsonParserFieldValue != null) {
					fileManager.setMetadata(
						MetadataSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mineType")) {
				if (jsonParserFieldValue != null) {
					fileManager.setMineType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentCode")) {
				if (jsonParserFieldValue != null) {
					fileManager.setParentCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "pkType")) {
				if (jsonParserFieldValue != null) {
					fileManager.setPkType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					fileManager.setType((String)jsonParserFieldValue);
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