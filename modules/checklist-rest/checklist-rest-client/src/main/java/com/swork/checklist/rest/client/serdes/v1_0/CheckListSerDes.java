package com.swork.checklist.rest.client.serdes.v1_0;

import com.swork.checklist.rest.client.dto.v1_0.CheckList;
import com.swork.checklist.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author adm
 * @generated
 */
@Generated("")
public class CheckListSerDes {

	public static CheckList toDTO(String json) {
		CheckListJSONParser checkListJSONParser = new CheckListJSONParser();

		return checkListJSONParser.parseToDTO(json);
	}

	public static CheckList[] toDTOs(String json) {
		CheckListJSONParser checkListJSONParser = new CheckListJSONParser();

		return checkListJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CheckList checkList) {
		if (checkList == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (checkList.getCheckListId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"checkListId\": ");

			sb.append(checkList.getCheckListId());
		}

		if (checkList.getEndDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"endDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(checkList.getEndDate()));

			sb.append("\"");
		}

		if (checkList.getHandlers() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"handlers\": ");

			sb.append("[");

			for (int i = 0; i < checkList.getHandlers().length; i++) {
				sb.append(checkList.getHandlers()[i]);

				if ((i + 1) < checkList.getHandlers().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (checkList.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(checkList.getName()));

			sb.append("\"");
		}

		if (checkList.getStartDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(checkList.getStartDate()));

			sb.append("\"");
		}

		if (checkList.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append(checkList.getStatus());
		}

		if (checkList.getTaskId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"taskId\": ");

			sb.append(checkList.getTaskId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CheckListJSONParser checkListJSONParser = new CheckListJSONParser();

		return checkListJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(CheckList checkList) {
		if (checkList == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (checkList.getCheckListId() == null) {
			map.put("checkListId", null);
		}
		else {
			map.put("checkListId", String.valueOf(checkList.getCheckListId()));
		}

		if (checkList.getEndDate() == null) {
			map.put("endDate", null);
		}
		else {
			map.put(
				"endDate",
				liferayToJSONDateFormat.format(checkList.getEndDate()));
		}

		if (checkList.getHandlers() == null) {
			map.put("handlers", null);
		}
		else {
			map.put("handlers", String.valueOf(checkList.getHandlers()));
		}

		if (checkList.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(checkList.getName()));
		}

		if (checkList.getStartDate() == null) {
			map.put("startDate", null);
		}
		else {
			map.put(
				"startDate",
				liferayToJSONDateFormat.format(checkList.getStartDate()));
		}

		if (checkList.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(checkList.getStatus()));
		}

		if (checkList.getTaskId() == null) {
			map.put("taskId", null);
		}
		else {
			map.put("taskId", String.valueOf(checkList.getTaskId()));
		}

		return map;
	}

	public static class CheckListJSONParser extends BaseJSONParser<CheckList> {

		@Override
		protected CheckList createDTO() {
			return new CheckList();
		}

		@Override
		protected CheckList[] createDTOArray(int size) {
			return new CheckList[size];
		}

		@Override
		protected void setField(
			CheckList checkList, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "checkListId")) {
				if (jsonParserFieldValue != null) {
					checkList.setCheckListId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "endDate")) {
				if (jsonParserFieldValue != null) {
					checkList.setEndDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "handlers")) {
				if (jsonParserFieldValue != null) {
					checkList.setHandlers(
						toLongs((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					checkList.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "startDate")) {
				if (jsonParserFieldValue != null) {
					checkList.setStartDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					checkList.setStatus((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "taskId")) {
				if (jsonParserFieldValue != null) {
					checkList.setTaskId(
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