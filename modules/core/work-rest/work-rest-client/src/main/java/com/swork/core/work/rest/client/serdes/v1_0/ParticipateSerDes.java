package com.swork.core.work.rest.client.serdes.v1_0;

import com.swork.core.work.rest.client.dto.v1_0.Participate;
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
public class ParticipateSerDes {

	public static Participate toDTO(String json) {
		ParticipateJSONParser participateJSONParser =
			new ParticipateJSONParser();

		return participateJSONParser.parseToDTO(json);
	}

	public static Participate[] toDTOs(String json) {
		ParticipateJSONParser participateJSONParser =
			new ParticipateJSONParser();

		return participateJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Participate participate) {
		if (participate == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (participate.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(participate.getId());
		}

		if (participate.getMemberId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberId\": ");

			sb.append(participate.getMemberId());
		}

		if (participate.getMemberName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberName\": ");

			sb.append("\"");

			sb.append(_escape(participate.getMemberName()));

			sb.append("\"");
		}

		if (participate.getMemberReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(participate.getMemberReferenceCode()));

			sb.append("\"");
		}

		if (participate.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(participate.getType());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ParticipateJSONParser participateJSONParser =
			new ParticipateJSONParser();

		return participateJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Participate participate) {
		if (participate == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (participate.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(participate.getId()));
		}

		if (participate.getMemberId() == null) {
			map.put("memberId", null);
		}
		else {
			map.put("memberId", String.valueOf(participate.getMemberId()));
		}

		if (participate.getMemberName() == null) {
			map.put("memberName", null);
		}
		else {
			map.put("memberName", String.valueOf(participate.getMemberName()));
		}

		if (participate.getMemberReferenceCode() == null) {
			map.put("memberReferenceCode", null);
		}
		else {
			map.put(
				"memberReferenceCode",
				String.valueOf(participate.getMemberReferenceCode()));
		}

		if (participate.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(participate.getType()));
		}

		return map;
	}

	public static class ParticipateJSONParser
		extends BaseJSONParser<Participate> {

		@Override
		protected Participate createDTO() {
			return new Participate();
		}

		@Override
		protected Participate[] createDTOArray(int size) {
			return new Participate[size];
		}

		@Override
		protected void setField(
			Participate participate, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					participate.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "memberId")) {
				if (jsonParserFieldValue != null) {
					participate.setMemberId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "memberName")) {
				if (jsonParserFieldValue != null) {
					participate.setMemberName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "memberReferenceCode")) {

				if (jsonParserFieldValue != null) {
					participate.setMemberReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					participate.setType(
						Participate.Type.create((String)jsonParserFieldValue));
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