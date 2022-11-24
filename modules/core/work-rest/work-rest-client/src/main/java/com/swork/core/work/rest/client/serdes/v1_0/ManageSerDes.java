package com.swork.core.work.rest.client.serdes.v1_0;

import com.swork.core.work.rest.client.dto.v1_0.Manage;
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
public class ManageSerDes {

	public static Manage toDTO(String json) {
		ManageJSONParser manageJSONParser = new ManageJSONParser();

		return manageJSONParser.parseToDTO(json);
	}

	public static Manage[] toDTOs(String json) {
		ManageJSONParser manageJSONParser = new ManageJSONParser();

		return manageJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Manage manage) {
		if (manage == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (manage.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(manage.getId());
		}

		if (manage.getMemberId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberId\": ");

			sb.append(manage.getMemberId());
		}

		if (manage.getMemberName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberName\": ");

			sb.append("\"");

			sb.append(_escape(manage.getMemberName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ManageJSONParser manageJSONParser = new ManageJSONParser();

		return manageJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Manage manage) {
		if (manage == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (manage.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(manage.getId()));
		}

		if (manage.getMemberId() == null) {
			map.put("memberId", null);
		}
		else {
			map.put("memberId", String.valueOf(manage.getMemberId()));
		}

		if (manage.getMemberName() == null) {
			map.put("memberName", null);
		}
		else {
			map.put("memberName", String.valueOf(manage.getMemberName()));
		}

		return map;
	}

	public static class ManageJSONParser extends BaseJSONParser<Manage> {

		@Override
		protected Manage createDTO() {
			return new Manage();
		}

		@Override
		protected Manage[] createDTOArray(int size) {
			return new Manage[size];
		}

		@Override
		protected void setField(
			Manage manage, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					manage.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "memberId")) {
				if (jsonParserFieldValue != null) {
					manage.setMemberId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "memberName")) {
				if (jsonParserFieldValue != null) {
					manage.setMemberName((String)jsonParserFieldValue);
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