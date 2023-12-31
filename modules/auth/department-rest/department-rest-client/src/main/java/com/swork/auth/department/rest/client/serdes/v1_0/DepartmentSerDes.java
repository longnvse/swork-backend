package com.swork.auth.department.rest.client.serdes.v1_0;

import com.swork.auth.department.rest.client.dto.v1_0.Department;
import com.swork.auth.department.rest.client.dto.v1_0.Member;
import com.swork.auth.department.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class DepartmentSerDes {

	public static Department toDTO(String json) {
		DepartmentJSONParser departmentJSONParser = new DepartmentJSONParser();

		return departmentJSONParser.parseToDTO(json);
	}

	public static Department[] toDTOs(String json) {
		DepartmentJSONParser departmentJSONParser = new DepartmentJSONParser();

		return departmentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Department department) {
		if (department == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (department.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(department.getId());
		}

		if (department.getMembers() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"members\": ");

			sb.append("[");

			for (int i = 0; i < department.getMembers().length; i++) {
				sb.append(String.valueOf(department.getMembers()[i]));

				if ((i + 1) < department.getMembers().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (department.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(department.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DepartmentJSONParser departmentJSONParser = new DepartmentJSONParser();

		return departmentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Department department) {
		if (department == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (department.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(department.getId()));
		}

		if (department.getMembers() == null) {
			map.put("members", null);
		}
		else {
			map.put("members", String.valueOf(department.getMembers()));
		}

		if (department.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(department.getName()));
		}

		return map;
	}

	public static class DepartmentJSONParser
		extends BaseJSONParser<Department> {

		@Override
		protected Department createDTO() {
			return new Department();
		}

		@Override
		protected Department[] createDTOArray(int size) {
			return new Department[size];
		}

		@Override
		protected void setField(
			Department department, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					department.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "members")) {
				if (jsonParserFieldValue != null) {
					department.setMembers(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> MemberSerDes.toDTO((String)object)
						).toArray(
							size -> new Member[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					department.setName((String)jsonParserFieldValue);
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