package com.swork.account.rest.client.serdes.v1_0;

import com.swork.account.rest.client.dto.v1_0.PermissionDetail;
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
public class PermissionDetailSerDes {

	public static PermissionDetail toDTO(String json) {
		PermissionDetailJSONParser permissionDetailJSONParser =
			new PermissionDetailJSONParser();

		return permissionDetailJSONParser.parseToDTO(json);
	}

	public static PermissionDetail[] toDTOs(String json) {
		PermissionDetailJSONParser permissionDetailJSONParser =
			new PermissionDetailJSONParser();

		return permissionDetailJSONParser.parseToDTOs(json);
	}

	public static String toJSON(PermissionDetail permissionDetail) {
		if (permissionDetail == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (permissionDetail.getActionCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actionCode\": ");

			sb.append("\"");

			sb.append(_escape(permissionDetail.getActionCode()));

			sb.append("\"");
		}

		if (permissionDetail.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(permissionDetail.getId());
		}

		if (permissionDetail.getPermissionId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"permissionId\": ");

			sb.append(permissionDetail.getPermissionId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PermissionDetailJSONParser permissionDetailJSONParser =
			new PermissionDetailJSONParser();

		return permissionDetailJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(PermissionDetail permissionDetail) {
		if (permissionDetail == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (permissionDetail.getActionCode() == null) {
			map.put("actionCode", null);
		}
		else {
			map.put(
				"actionCode", String.valueOf(permissionDetail.getActionCode()));
		}

		if (permissionDetail.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(permissionDetail.getId()));
		}

		if (permissionDetail.getPermissionId() == null) {
			map.put("permissionId", null);
		}
		else {
			map.put(
				"permissionId",
				String.valueOf(permissionDetail.getPermissionId()));
		}

		return map;
	}

	public static class PermissionDetailJSONParser
		extends BaseJSONParser<PermissionDetail> {

		@Override
		protected PermissionDetail createDTO() {
			return new PermissionDetail();
		}

		@Override
		protected PermissionDetail[] createDTOArray(int size) {
			return new PermissionDetail[size];
		}

		@Override
		protected void setField(
			PermissionDetail permissionDetail, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "actionCode")) {
				if (jsonParserFieldValue != null) {
					permissionDetail.setActionCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					permissionDetail.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "permissionId")) {
				if (jsonParserFieldValue != null) {
					permissionDetail.setPermissionId(
						Long.valueOf((String)jsonParserFieldValue));
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