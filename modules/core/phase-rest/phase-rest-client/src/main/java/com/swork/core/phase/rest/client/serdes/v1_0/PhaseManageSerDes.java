package com.swork.core.phase.rest.client.serdes.v1_0;

import com.swork.core.phase.rest.client.dto.v1_0.PhaseManage;
import com.swork.core.phase.rest.client.json.BaseJSONParser;

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
public class PhaseManageSerDes {

	public static PhaseManage toDTO(String json) {
		PhaseManageJSONParser phaseManageJSONParser =
			new PhaseManageJSONParser();

		return phaseManageJSONParser.parseToDTO(json);
	}

	public static PhaseManage[] toDTOs(String json) {
		PhaseManageJSONParser phaseManageJSONParser =
			new PhaseManageJSONParser();

		return phaseManageJSONParser.parseToDTOs(json);
	}

	public static String toJSON(PhaseManage phaseManage) {
		if (phaseManage == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (phaseManage.getAccountId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountId\": ");

			sb.append(phaseManage.getAccountId());
		}

		if (phaseManage.getAccountName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountName\": ");

			sb.append("\"");

			sb.append(_escape(phaseManage.getAccountName()));

			sb.append("\"");
		}

		if (phaseManage.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(phaseManage.getId());
		}

		if (phaseManage.getPhaseId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phaseId\": ");

			sb.append(phaseManage.getPhaseId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PhaseManageJSONParser phaseManageJSONParser =
			new PhaseManageJSONParser();

		return phaseManageJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(PhaseManage phaseManage) {
		if (phaseManage == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (phaseManage.getAccountId() == null) {
			map.put("accountId", null);
		}
		else {
			map.put("accountId", String.valueOf(phaseManage.getAccountId()));
		}

		if (phaseManage.getAccountName() == null) {
			map.put("accountName", null);
		}
		else {
			map.put(
				"accountName", String.valueOf(phaseManage.getAccountName()));
		}

		if (phaseManage.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(phaseManage.getId()));
		}

		if (phaseManage.getPhaseId() == null) {
			map.put("phaseId", null);
		}
		else {
			map.put("phaseId", String.valueOf(phaseManage.getPhaseId()));
		}

		return map;
	}

	public static class PhaseManageJSONParser
		extends BaseJSONParser<PhaseManage> {

		@Override
		protected PhaseManage createDTO() {
			return new PhaseManage();
		}

		@Override
		protected PhaseManage[] createDTOArray(int size) {
			return new PhaseManage[size];
		}

		@Override
		protected void setField(
			PhaseManage phaseManage, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "accountId")) {
				if (jsonParserFieldValue != null) {
					phaseManage.setAccountId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "accountName")) {
				if (jsonParserFieldValue != null) {
					phaseManage.setAccountName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					phaseManage.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phaseId")) {
				if (jsonParserFieldValue != null) {
					phaseManage.setPhaseId(
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