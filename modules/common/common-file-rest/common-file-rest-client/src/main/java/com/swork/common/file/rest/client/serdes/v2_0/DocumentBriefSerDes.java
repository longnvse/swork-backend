package com.swork.common.file.rest.client.serdes.v2_0;

import com.swork.common.file.rest.client.dto.v2_0.DocumentBrief;
import com.swork.common.file.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author ninhvv
 * @generated
 */
@Generated("")
public class DocumentBriefSerDes {

	public static DocumentBrief toDTO(String json) {
		DocumentBriefJSONParser documentBriefJSONParser =
			new DocumentBriefJSONParser();

		return documentBriefJSONParser.parseToDTO(json);
	}

	public static DocumentBrief[] toDTOs(String json) {
		DocumentBriefJSONParser documentBriefJSONParser =
			new DocumentBriefJSONParser();

		return documentBriefJSONParser.parseToDTOs(json);
	}

	public static String toJSON(DocumentBrief documentBrief) {
		if (documentBrief == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (documentBrief.getCategory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"category\": ");

			sb.append("\"");

			sb.append(_escape(documentBrief.getCategory()));

			sb.append("\"");
		}

		if (documentBrief.getDocumentBriefs() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"documentBriefs\": ");

			sb.append("[");

			for (int i = 0; i < documentBrief.getDocumentBriefs().length; i++) {
				sb.append(String.valueOf(documentBrief.getDocumentBriefs()[i]));

				if ((i + 1) < documentBrief.getDocumentBriefs().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (documentBrief.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(documentBrief.getId());
		}

		if (documentBrief.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(documentBrief.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DocumentBriefJSONParser documentBriefJSONParser =
			new DocumentBriefJSONParser();

		return documentBriefJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(DocumentBrief documentBrief) {
		if (documentBrief == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (documentBrief.getCategory() == null) {
			map.put("category", null);
		}
		else {
			map.put("category", String.valueOf(documentBrief.getCategory()));
		}

		if (documentBrief.getDocumentBriefs() == null) {
			map.put("documentBriefs", null);
		}
		else {
			map.put(
				"documentBriefs",
				String.valueOf(documentBrief.getDocumentBriefs()));
		}

		if (documentBrief.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(documentBrief.getId()));
		}

		if (documentBrief.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(documentBrief.getName()));
		}

		return map;
	}

	public static class DocumentBriefJSONParser
		extends BaseJSONParser<DocumentBrief> {

		@Override
		protected DocumentBrief createDTO() {
			return new DocumentBrief();
		}

		@Override
		protected DocumentBrief[] createDTOArray(int size) {
			return new DocumentBrief[size];
		}

		@Override
		protected void setField(
			DocumentBrief documentBrief, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "category")) {
				if (jsonParserFieldValue != null) {
					documentBrief.setCategory((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "documentBriefs")) {
				if (jsonParserFieldValue != null) {
					documentBrief.setDocumentBriefs(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> DocumentBriefSerDes.toDTO((String)object)
						).toArray(
							size -> new DocumentBrief[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					documentBrief.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					documentBrief.setName((String)jsonParserFieldValue);
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