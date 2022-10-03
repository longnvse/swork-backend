package com.swork.rest.client.serdes.v1_0;

import com.swork.rest.client.dto.v1_0.Pet;
import com.swork.rest.client.json.BaseJSONParser;

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
public class PetSerDes {

	public static Pet toDTO(String json) {
		PetJSONParser petJSONParser = new PetJSONParser();

		return petJSONParser.parseToDTO(json);
	}

	public static Pet[] toDTOs(String json) {
		PetJSONParser petJSONParser = new PetJSONParser();

		return petJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Pet pet) {
		if (pet == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (pet.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(pet.getId());
		}

		if (pet.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(pet.getName()));

			sb.append("\"");
		}

		if (pet.getPrice() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"price\": ");

			sb.append(pet.getPrice());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PetJSONParser petJSONParser = new PetJSONParser();

		return petJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Pet pet) {
		if (pet == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (pet.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(pet.getId()));
		}

		if (pet.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(pet.getName()));
		}

		if (pet.getPrice() == null) {
			map.put("price", null);
		}
		else {
			map.put("price", String.valueOf(pet.getPrice()));
		}

		return map;
	}

	public static class PetJSONParser extends BaseJSONParser<Pet> {

		@Override
		protected Pet createDTO() {
			return new Pet();
		}

		@Override
		protected Pet[] createDTOArray(int size) {
			return new Pet[size];
		}

		@Override
		protected void setField(
			Pet pet, String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					pet.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					pet.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "price")) {
				if (jsonParserFieldValue != null) {
					pet.setPrice(Long.valueOf((String)jsonParserFieldValue));
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