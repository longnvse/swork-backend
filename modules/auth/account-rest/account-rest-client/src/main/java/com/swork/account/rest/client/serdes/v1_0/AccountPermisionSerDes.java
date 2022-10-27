package com.swork.account.rest.client.serdes.v1_0;

import com.swork.account.rest.client.dto.v1_0.AccountPermision;
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
public class AccountPermisionSerDes {

	public static AccountPermision toDTO(String json) {
		AccountPermisionJSONParser accountPermisionJSONParser =
			new AccountPermisionJSONParser();

		return accountPermisionJSONParser.parseToDTO(json);
	}

	public static AccountPermision[] toDTOs(String json) {
		AccountPermisionJSONParser accountPermisionJSONParser =
			new AccountPermisionJSONParser();

		return accountPermisionJSONParser.parseToDTOs(json);
	}

	public static String toJSON(AccountPermision accountPermision) {
		if (accountPermision == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (accountPermision.getAccountId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountId\": ");

			sb.append(accountPermision.getAccountId());
		}

		if (accountPermision.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(accountPermision.getId());
		}

		if (accountPermision.getPermisionId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"permisionId\": ");

			sb.append(accountPermision.getPermisionId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AccountPermisionJSONParser accountPermisionJSONParser =
			new AccountPermisionJSONParser();

		return accountPermisionJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(AccountPermision accountPermision) {
		if (accountPermision == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (accountPermision.getAccountId() == null) {
			map.put("accountId", null);
		}
		else {
			map.put(
				"accountId", String.valueOf(accountPermision.getAccountId()));
		}

		if (accountPermision.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(accountPermision.getId()));
		}

		if (accountPermision.getPermisionId() == null) {
			map.put("permisionId", null);
		}
		else {
			map.put(
				"permisionId",
				String.valueOf(accountPermision.getPermisionId()));
		}

		return map;
	}

	public static class AccountPermisionJSONParser
		extends BaseJSONParser<AccountPermision> {

		@Override
		protected AccountPermision createDTO() {
			return new AccountPermision();
		}

		@Override
		protected AccountPermision[] createDTOArray(int size) {
			return new AccountPermision[size];
		}

		@Override
		protected void setField(
			AccountPermision accountPermision, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "accountId")) {
				if (jsonParserFieldValue != null) {
					accountPermision.setAccountId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					accountPermision.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "permisionId")) {
				if (jsonParserFieldValue != null) {
					accountPermision.setPermisionId(
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