package com.swork.notification.rest.client.serdes.v2_0;

import com.swork.notification.rest.client.dto.v2_0.Notification;
import com.swork.notification.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class NotificationSerDes {

	public static Notification toDTO(String json) {
		NotificationJSONParser notificationJSONParser =
			new NotificationJSONParser();

		return notificationJSONParser.parseToDTO(json);
	}

	public static Notification[] toDTOs(String json) {
		NotificationJSONParser notificationJSONParser =
			new NotificationJSONParser();

		return notificationJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Notification notification) {
		if (notification == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (notification.getCategory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"category\": ");

			sb.append("\"");

			sb.append(_escape(notification.getCategory()));

			sb.append("\"");
		}

		if (notification.getCreateDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(notification.getCreateDate()));

			sb.append("\"");
		}

		if (notification.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(notification.getDescription()));

			sb.append("\"");
		}

		if (notification.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(notification.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (notification.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(notification.getId());
		}

		if (notification.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(notification.getName()));

			sb.append("\"");
		}

		if (notification.getReceiverId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receiverId\": ");

			sb.append(notification.getReceiverId());
		}

		if (notification.getReceiverName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"receiverName\": ");

			sb.append("\"");

			sb.append(_escape(notification.getReceiverName()));

			sb.append("\"");
		}

		if (notification.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(notification.getStatus());

			sb.append("\"");
		}

		if (notification.getSubjectId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subjectId\": ");

			sb.append(notification.getSubjectId());
		}

		if (notification.getSubjectName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subjectName\": ");

			sb.append("\"");

			sb.append(_escape(notification.getSubjectName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		NotificationJSONParser notificationJSONParser =
			new NotificationJSONParser();

		return notificationJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Notification notification) {
		if (notification == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (notification.getCategory() == null) {
			map.put("category", null);
		}
		else {
			map.put("category", String.valueOf(notification.getCategory()));
		}

		if (notification.getCreateDate() == null) {
			map.put("createDate", null);
		}
		else {
			map.put(
				"createDate",
				liferayToJSONDateFormat.format(notification.getCreateDate()));
		}

		if (notification.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put(
				"description", String.valueOf(notification.getDescription()));
		}

		if (notification.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(notification.getExternalReferenceCode()));
		}

		if (notification.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(notification.getId()));
		}

		if (notification.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(notification.getName()));
		}

		if (notification.getReceiverId() == null) {
			map.put("receiverId", null);
		}
		else {
			map.put("receiverId", String.valueOf(notification.getReceiverId()));
		}

		if (notification.getReceiverName() == null) {
			map.put("receiverName", null);
		}
		else {
			map.put(
				"receiverName", String.valueOf(notification.getReceiverName()));
		}

		if (notification.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(notification.getStatus()));
		}

		if (notification.getSubjectId() == null) {
			map.put("subjectId", null);
		}
		else {
			map.put("subjectId", String.valueOf(notification.getSubjectId()));
		}

		if (notification.getSubjectName() == null) {
			map.put("subjectName", null);
		}
		else {
			map.put(
				"subjectName", String.valueOf(notification.getSubjectName()));
		}

		return map;
	}

	public static class NotificationJSONParser
		extends BaseJSONParser<Notification> {

		@Override
		protected Notification createDTO() {
			return new Notification();
		}

		@Override
		protected Notification[] createDTOArray(int size) {
			return new Notification[size];
		}

		@Override
		protected void setField(
			Notification notification, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "category")) {
				if (jsonParserFieldValue != null) {
					notification.setCategory((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createDate")) {
				if (jsonParserFieldValue != null) {
					notification.setCreateDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					notification.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					notification.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					notification.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					notification.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "receiverId")) {
				if (jsonParserFieldValue != null) {
					notification.setReceiverId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "receiverName")) {
				if (jsonParserFieldValue != null) {
					notification.setReceiverName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					notification.setStatus(
						Notification.Status.create(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "subjectId")) {
				if (jsonParserFieldValue != null) {
					notification.setSubjectId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "subjectName")) {
				if (jsonParserFieldValue != null) {
					notification.setSubjectName((String)jsonParserFieldValue);
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