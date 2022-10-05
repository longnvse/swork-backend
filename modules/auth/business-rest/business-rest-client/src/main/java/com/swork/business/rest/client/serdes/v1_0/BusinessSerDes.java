package com.swork.business.rest.client.serdes.v1_0;

import com.swork.business.rest.client.dto.v1_0.Business;
import com.swork.business.rest.client.json.BaseJSONParser;

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
public class BusinessSerDes {

	public static Business toDTO(String json) {
		BusinessJSONParser businessJSONParser = new BusinessJSONParser();

		return businessJSONParser.parseToDTO(json);
	}

	public static Business[] toDTOs(String json) {
		BusinessJSONParser businessJSONParser = new BusinessJSONParser();

		return businessJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Business business) {
		if (business == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (business.getBusinessAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"businessAddress\": ");

			sb.append("\"");

			sb.append(_escape(business.getBusinessAddress()));

			sb.append("\"");
		}

		if (business.getCustomerName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"customerName\": ");

			sb.append("\"");

			sb.append(_escape(business.getCustomerName()));

			sb.append("\"");
		}

		if (business.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(business.getEmail()));

			sb.append("\"");
		}

		if (business.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(business.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (business.getFieldOperations() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fieldOperations\": ");

			sb.append("\"");

			sb.append(_escape(business.getFieldOperations()));

			sb.append("\"");
		}

		if (business.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(business.getId());
		}

		if (business.getLogoId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"logoId\": ");

			sb.append("\"");

			sb.append(_escape(business.getLogoId()));

			sb.append("\"");
		}

		if (business.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(business.getName()));

			sb.append("\"");
		}

		if (business.getPhoneNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phoneNumber\": ");

			sb.append("\"");

			sb.append(_escape(business.getPhoneNumber()));

			sb.append("\"");
		}

		if (business.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(business.getStatus());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		BusinessJSONParser businessJSONParser = new BusinessJSONParser();

		return businessJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Business business) {
		if (business == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (business.getBusinessAddress() == null) {
			map.put("businessAddress", null);
		}
		else {
			map.put(
				"businessAddress",
				String.valueOf(business.getBusinessAddress()));
		}

		if (business.getCustomerName() == null) {
			map.put("customerName", null);
		}
		else {
			map.put("customerName", String.valueOf(business.getCustomerName()));
		}

		if (business.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(business.getEmail()));
		}

		if (business.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(business.getExternalReferenceCode()));
		}

		if (business.getFieldOperations() == null) {
			map.put("fieldOperations", null);
		}
		else {
			map.put(
				"fieldOperations",
				String.valueOf(business.getFieldOperations()));
		}

		if (business.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(business.getId()));
		}

		if (business.getLogoId() == null) {
			map.put("logoId", null);
		}
		else {
			map.put("logoId", String.valueOf(business.getLogoId()));
		}

		if (business.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(business.getName()));
		}

		if (business.getPhoneNumber() == null) {
			map.put("phoneNumber", null);
		}
		else {
			map.put("phoneNumber", String.valueOf(business.getPhoneNumber()));
		}

		if (business.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(business.getStatus()));
		}

		return map;
	}

	public static class BusinessJSONParser extends BaseJSONParser<Business> {

		@Override
		protected Business createDTO() {
			return new Business();
		}

		@Override
		protected Business[] createDTOArray(int size) {
			return new Business[size];
		}

		@Override
		protected void setField(
			Business business, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "businessAddress")) {
				if (jsonParserFieldValue != null) {
					business.setBusinessAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "customerName")) {
				if (jsonParserFieldValue != null) {
					business.setCustomerName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					business.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					business.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fieldOperations")) {
				if (jsonParserFieldValue != null) {
					business.setFieldOperations((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					business.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "logoId")) {
				if (jsonParserFieldValue != null) {
					business.setLogoId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					business.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phoneNumber")) {
				if (jsonParserFieldValue != null) {
					business.setPhoneNumber((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					business.setStatus(
						Business.Status.create((String)jsonParserFieldValue));
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