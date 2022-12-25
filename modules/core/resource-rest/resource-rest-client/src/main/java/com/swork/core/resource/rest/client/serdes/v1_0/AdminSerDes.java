package com.swork.core.resource.rest.client.serdes.v1_0;

import com.swork.core.resource.rest.client.dto.v1_0.Admin;
import com.swork.core.resource.rest.client.json.BaseJSONParser;

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
public class AdminSerDes {

	public static Admin toDTO(String json) {
		AdminJSONParser adminJSONParser = new AdminJSONParser();

		return adminJSONParser.parseToDTO(json);
	}

	public static Admin[] toDTOs(String json) {
		AdminJSONParser adminJSONParser = new AdminJSONParser();

		return adminJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Admin admin) {
		if (admin == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (admin.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(admin.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (admin.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(admin.getId());
		}

		if (admin.getMemberId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberId\": ");

			sb.append(admin.getMemberId());
		}

		if (admin.getMemberName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberName\": ");

			sb.append("\"");

			sb.append(_escape(admin.getMemberName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AdminJSONParser adminJSONParser = new AdminJSONParser();

		return adminJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Admin admin) {
		if (admin == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (admin.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(admin.getExternalReferenceCode()));
		}

		if (admin.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(admin.getId()));
		}

		if (admin.getMemberId() == null) {
			map.put("memberId", null);
		}
		else {
			map.put("memberId", String.valueOf(admin.getMemberId()));
		}

		if (admin.getMemberName() == null) {
			map.put("memberName", null);
		}
		else {
			map.put("memberName", String.valueOf(admin.getMemberName()));
		}

		return map;
	}

	public static class AdminJSONParser extends BaseJSONParser<Admin> {

		@Override
		protected Admin createDTO() {
			return new Admin();
		}

		@Override
		protected Admin[] createDTOArray(int size) {
			return new Admin[size];
		}

		@Override
		protected void setField(
			Admin admin, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "externalReferenceCode")) {
				if (jsonParserFieldValue != null) {
					admin.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					admin.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "memberId")) {
				if (jsonParserFieldValue != null) {
					admin.setMemberId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "memberName")) {
				if (jsonParserFieldValue != null) {
					admin.setMemberName((String)jsonParserFieldValue);
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