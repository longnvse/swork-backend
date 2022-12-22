package com.swork.account.rest.client.serdes.v1_0;

import com.swork.account.rest.client.dto.v1_0.Account;
import com.swork.account.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class AccountSerDes {

	public static Account toDTO(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToDTO(json);
	}

	public static Account[] toDTOs(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Account account) {
		if (account == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (account.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(account.getAddress()));

			sb.append("\"");
		}

		if (account.getAvatar() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"avatar\": ");

			sb.append("\"");

			sb.append(_escape(account.getAvatar()));

			sb.append("\"");
		}

		if (account.getCreateDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(account.getCreateDate()));

			sb.append("\"");
		}

		if (account.getDateOfBirth() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateOfBirth\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(account.getDateOfBirth()));

			sb.append("\"");
		}

		if (account.getDepartmentName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"departmentName\": ");

			sb.append("\"");

			sb.append(_escape(account.getDepartmentName()));

			sb.append("\"");
		}

		if (account.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(account.getEmail()));

			sb.append("\"");
		}

		if (account.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(account.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (account.getFullName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fullName\": ");

			sb.append("\"");

			sb.append(_escape(account.getFullName()));

			sb.append("\"");
		}

		if (account.getGender() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"gender\": ");

			sb.append(account.getGender());
		}

		if (account.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(account.getId());
		}

		if (account.getPhoneNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phoneNumber\": ");

			sb.append("\"");

			sb.append(_escape(account.getPhoneNumber()));

			sb.append("\"");
		}

		if (account.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(account.getStatus());

			sb.append("\"");
		}

		if (account.getUsername() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"username\": ");

			sb.append("\"");

			sb.append(_escape(account.getUsername()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Account account) {
		if (account == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (account.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put("address", String.valueOf(account.getAddress()));
		}

		if (account.getAvatar() == null) {
			map.put("avatar", null);
		}
		else {
			map.put("avatar", String.valueOf(account.getAvatar()));
		}

		if (account.getCreateDate() == null) {
			map.put("createDate", null);
		}
		else {
			map.put(
				"createDate",
				liferayToJSONDateFormat.format(account.getCreateDate()));
		}

		if (account.getDateOfBirth() == null) {
			map.put("dateOfBirth", null);
		}
		else {
			map.put(
				"dateOfBirth",
				liferayToJSONDateFormat.format(account.getDateOfBirth()));
		}

		if (account.getDepartmentName() == null) {
			map.put("departmentName", null);
		}
		else {
			map.put(
				"departmentName", String.valueOf(account.getDepartmentName()));
		}

		if (account.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(account.getEmail()));
		}

		if (account.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(account.getExternalReferenceCode()));
		}

		if (account.getFullName() == null) {
			map.put("fullName", null);
		}
		else {
			map.put("fullName", String.valueOf(account.getFullName()));
		}

		if (account.getGender() == null) {
			map.put("gender", null);
		}
		else {
			map.put("gender", String.valueOf(account.getGender()));
		}

		if (account.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(account.getId()));
		}

		if (account.getPhoneNumber() == null) {
			map.put("phoneNumber", null);
		}
		else {
			map.put("phoneNumber", String.valueOf(account.getPhoneNumber()));
		}

		if (account.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(account.getStatus()));
		}

		if (account.getUsername() == null) {
			map.put("username", null);
		}
		else {
			map.put("username", String.valueOf(account.getUsername()));
		}

		return map;
	}

	public static class AccountJSONParser extends BaseJSONParser<Account> {

		@Override
		protected Account createDTO() {
			return new Account();
		}

		@Override
		protected Account[] createDTOArray(int size) {
			return new Account[size];
		}

		@Override
		protected void setField(
			Account account, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					account.setAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "avatar")) {
				if (jsonParserFieldValue != null) {
					account.setAvatar((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createDate")) {
				if (jsonParserFieldValue != null) {
					account.setCreateDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateOfBirth")) {
				if (jsonParserFieldValue != null) {
					account.setDateOfBirth(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "departmentName")) {
				if (jsonParserFieldValue != null) {
					account.setDepartmentName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					account.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					account.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fullName")) {
				if (jsonParserFieldValue != null) {
					account.setFullName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "gender")) {
				if (jsonParserFieldValue != null) {
					account.setGender((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					account.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phoneNumber")) {
				if (jsonParserFieldValue != null) {
					account.setPhoneNumber((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					account.setStatus(
						Account.Status.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "username")) {
				if (jsonParserFieldValue != null) {
					account.setUsername((String)jsonParserFieldValue);
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