package com.swork.core.work.rest.client.serdes.v1_0;

import com.swork.core.work.rest.client.dto.v1_0.Handle;
import com.swork.core.work.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author longnv
 * @generated
 */
@Generated("")
public class HandleSerDes {

	public static Handle toDTO(String json) {
		HandleJSONParser handleJSONParser = new HandleJSONParser();

		return handleJSONParser.parseToDTO(json);
	}

	public static Handle[] toDTOs(String json) {
		HandleJSONParser handleJSONParser = new HandleJSONParser();

		return handleJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Handle handle) {
		if (handle == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (handle.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(handle.getId());
		}

		if (handle.getMemberId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberId\": ");

			sb.append(handle.getMemberId());
		}

		if (handle.getMemberName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberName\": ");

			sb.append("\"");

			sb.append(_escape(handle.getMemberName()));

			sb.append("\"");
		}

		if (handle.getMemberReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(handle.getMemberReferenceCode()));

			sb.append("\"");
		}

		if (handle.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(handle.getType());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		HandleJSONParser handleJSONParser = new HandleJSONParser();

		return handleJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Handle handle) {
		if (handle == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (handle.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(handle.getId()));
		}

		if (handle.getMemberId() == null) {
			map.put("memberId", null);
		}
		else {
			map.put("memberId", String.valueOf(handle.getMemberId()));
		}

		if (handle.getMemberName() == null) {
			map.put("memberName", null);
		}
		else {
			map.put("memberName", String.valueOf(handle.getMemberName()));
		}

		if (handle.getMemberReferenceCode() == null) {
			map.put("memberReferenceCode", null);
		}
		else {
			map.put(
				"memberReferenceCode",
				String.valueOf(handle.getMemberReferenceCode()));
		}

		if (handle.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(handle.getType()));
		}

		return map;
	}

	public static class HandleJSONParser extends BaseJSONParser<Handle> {

		@Override
		protected Handle createDTO() {
			return new Handle();
		}

		@Override
		protected Handle[] createDTOArray(int size) {
			return new Handle[size];
		}

		@Override
		protected void setField(
			Handle handle, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					handle.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "memberId")) {
				if (jsonParserFieldValue != null) {
					handle.setMemberId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "memberName")) {
				if (jsonParserFieldValue != null) {
					handle.setMemberName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "memberReferenceCode")) {

				if (jsonParserFieldValue != null) {
					handle.setMemberReferenceCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					handle.setType(
						Handle.Type.create((String)jsonParserFieldValue));
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