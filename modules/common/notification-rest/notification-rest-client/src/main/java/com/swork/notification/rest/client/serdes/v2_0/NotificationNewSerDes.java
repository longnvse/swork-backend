package com.swork.notification.rest.client.serdes.v2_0;

import com.swork.notification.rest.client.dto.v2_0.NotificationNew;
import com.swork.notification.rest.client.json.BaseJSONParser;

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
public class NotificationNewSerDes {

	public static NotificationNew toDTO(String json) {
		NotificationNewJSONParser notificationNewJSONParser =
			new NotificationNewJSONParser();

		return notificationNewJSONParser.parseToDTO(json);
	}

	public static NotificationNew[] toDTOs(String json) {
		NotificationNewJSONParser notificationNewJSONParser =
			new NotificationNewJSONParser();

		return notificationNewJSONParser.parseToDTOs(json);
	}

	public static String toJSON(NotificationNew notificationNew) {
		if (notificationNew == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (notificationNew.getCount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"count\": ");

			sb.append(notificationNew.getCount());
		}

		if (notificationNew.getTotalTime() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalTime\": ");

			sb.append("\"");

			sb.append(_escape(notificationNew.getTotalTime()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		NotificationNewJSONParser notificationNewJSONParser =
			new NotificationNewJSONParser();

		return notificationNewJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(NotificationNew notificationNew) {
		if (notificationNew == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (notificationNew.getCount() == null) {
			map.put("count", null);
		}
		else {
			map.put("count", String.valueOf(notificationNew.getCount()));
		}

		if (notificationNew.getTotalTime() == null) {
			map.put("totalTime", null);
		}
		else {
			map.put(
				"totalTime", String.valueOf(notificationNew.getTotalTime()));
		}

		return map;
	}

	public static class NotificationNewJSONParser
		extends BaseJSONParser<NotificationNew> {

		@Override
		protected NotificationNew createDTO() {
			return new NotificationNew();
		}

		@Override
		protected NotificationNew[] createDTOArray(int size) {
			return new NotificationNew[size];
		}

		@Override
		protected void setField(
			NotificationNew notificationNew, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "count")) {
				if (jsonParserFieldValue != null) {
					notificationNew.setCount(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalTime")) {
				if (jsonParserFieldValue != null) {
					notificationNew.setTotalTime((String)jsonParserFieldValue);
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