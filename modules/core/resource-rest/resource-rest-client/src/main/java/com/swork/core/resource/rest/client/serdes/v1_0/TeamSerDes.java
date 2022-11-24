package com.swork.core.resource.rest.client.serdes.v1_0;

import com.swork.core.resource.rest.client.dto.v1_0.Admin;
import com.swork.core.resource.rest.client.dto.v1_0.Member;
import com.swork.core.resource.rest.client.dto.v1_0.Resource;
import com.swork.core.resource.rest.client.dto.v1_0.Team;
import com.swork.core.resource.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class TeamSerDes {

	public static Team toDTO(String json) {
		TeamJSONParser teamJSONParser = new TeamJSONParser();

		return teamJSONParser.parseToDTO(json);
	}

	public static Team[] toDTOs(String json) {
		TeamJSONParser teamJSONParser = new TeamJSONParser();

		return teamJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Team team) {
		if (team == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (team.getAdmins() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"admins\": ");

			sb.append("[");

			for (int i = 0; i < team.getAdmins().length; i++) {
				sb.append(String.valueOf(team.getAdmins()[i]));

				if ((i + 1) < team.getAdmins().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (team.getCreateDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(team.getCreateDate()));

			sb.append("\"");
		}

		if (team.getCreator() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append("\"");

			sb.append(_escape(team.getCreator()));

			sb.append("\"");
		}

		if (team.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(team.getDescription()));

			sb.append("\"");
		}

		if (team.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(team.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (team.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(team.getId());
		}

		if (team.getIsActive() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isActive\": ");

			sb.append(team.getIsActive());
		}

		if (team.getMembers() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"members\": ");

			sb.append("[");

			for (int i = 0; i < team.getMembers().length; i++) {
				sb.append(String.valueOf(team.getMembers()[i]));

				if ((i + 1) < team.getMembers().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (team.getModifiedDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(team.getModifiedDate()));

			sb.append("\"");
		}

		if (team.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(team.getName()));

			sb.append("\"");
		}

		if (team.getPhaseId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phaseId\": ");

			sb.append(team.getPhaseId());
		}

		if (team.getPhaseName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phaseName\": ");

			sb.append("\"");

			sb.append(_escape(team.getPhaseName()));

			sb.append("\"");
		}

		if (team.getProjectId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectId\": ");

			sb.append(team.getProjectId());
		}

		if (team.getProjectName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectName\": ");

			sb.append("\"");

			sb.append(_escape(team.getProjectName()));

			sb.append("\"");
		}

		if (team.getQuantityMember() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"quantityMember\": ");

			sb.append(team.getQuantityMember());
		}

		if (team.getResources() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"resources\": ");

			sb.append("[");

			for (int i = 0; i < team.getResources().length; i++) {
				sb.append(String.valueOf(team.getResources()[i]));

				if ((i + 1) < team.getResources().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (team.getTotalIncoming() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalIncoming\": ");

			sb.append(team.getTotalIncoming());
		}

		if (team.getTotalSpending() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalSpending\": ");

			sb.append(team.getTotalSpending());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TeamJSONParser teamJSONParser = new TeamJSONParser();

		return teamJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Team team) {
		if (team == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (team.getAdmins() == null) {
			map.put("admins", null);
		}
		else {
			map.put("admins", String.valueOf(team.getAdmins()));
		}

		if (team.getCreateDate() == null) {
			map.put("createDate", null);
		}
		else {
			map.put(
				"createDate",
				liferayToJSONDateFormat.format(team.getCreateDate()));
		}

		if (team.getCreator() == null) {
			map.put("creator", null);
		}
		else {
			map.put("creator", String.valueOf(team.getCreator()));
		}

		if (team.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(team.getDescription()));
		}

		if (team.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(team.getExternalReferenceCode()));
		}

		if (team.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(team.getId()));
		}

		if (team.getIsActive() == null) {
			map.put("isActive", null);
		}
		else {
			map.put("isActive", String.valueOf(team.getIsActive()));
		}

		if (team.getMembers() == null) {
			map.put("members", null);
		}
		else {
			map.put("members", String.valueOf(team.getMembers()));
		}

		if (team.getModifiedDate() == null) {
			map.put("modifiedDate", null);
		}
		else {
			map.put(
				"modifiedDate",
				liferayToJSONDateFormat.format(team.getModifiedDate()));
		}

		if (team.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(team.getName()));
		}

		if (team.getPhaseId() == null) {
			map.put("phaseId", null);
		}
		else {
			map.put("phaseId", String.valueOf(team.getPhaseId()));
		}

		if (team.getPhaseName() == null) {
			map.put("phaseName", null);
		}
		else {
			map.put("phaseName", String.valueOf(team.getPhaseName()));
		}

		if (team.getProjectId() == null) {
			map.put("projectId", null);
		}
		else {
			map.put("projectId", String.valueOf(team.getProjectId()));
		}

		if (team.getProjectName() == null) {
			map.put("projectName", null);
		}
		else {
			map.put("projectName", String.valueOf(team.getProjectName()));
		}

		if (team.getQuantityMember() == null) {
			map.put("quantityMember", null);
		}
		else {
			map.put("quantityMember", String.valueOf(team.getQuantityMember()));
		}

		if (team.getResources() == null) {
			map.put("resources", null);
		}
		else {
			map.put("resources", String.valueOf(team.getResources()));
		}

		if (team.getTotalIncoming() == null) {
			map.put("totalIncoming", null);
		}
		else {
			map.put("totalIncoming", String.valueOf(team.getTotalIncoming()));
		}

		if (team.getTotalSpending() == null) {
			map.put("totalSpending", null);
		}
		else {
			map.put("totalSpending", String.valueOf(team.getTotalSpending()));
		}

		return map;
	}

	public static class TeamJSONParser extends BaseJSONParser<Team> {

		@Override
		protected Team createDTO() {
			return new Team();
		}

		@Override
		protected Team[] createDTOArray(int size) {
			return new Team[size];
		}

		@Override
		protected void setField(
			Team team, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "admins")) {
				if (jsonParserFieldValue != null) {
					team.setAdmins(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> AdminSerDes.toDTO((String)object)
						).toArray(
							size -> new Admin[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createDate")) {
				if (jsonParserFieldValue != null) {
					team.setCreateDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creator")) {
				if (jsonParserFieldValue != null) {
					team.setCreator((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					team.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					team.setExternalReferenceCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					team.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isActive")) {
				if (jsonParserFieldValue != null) {
					team.setIsActive((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "members")) {
				if (jsonParserFieldValue != null) {
					team.setMembers(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> MemberSerDes.toDTO((String)object)
						).toArray(
							size -> new Member[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "modifiedDate")) {
				if (jsonParserFieldValue != null) {
					team.setModifiedDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					team.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phaseId")) {
				if (jsonParserFieldValue != null) {
					team.setPhaseId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phaseName")) {
				if (jsonParserFieldValue != null) {
					team.setPhaseName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectId")) {
				if (jsonParserFieldValue != null) {
					team.setProjectId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectName")) {
				if (jsonParserFieldValue != null) {
					team.setProjectName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "quantityMember")) {
				if (jsonParserFieldValue != null) {
					team.setQuantityMember(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "resources")) {
				if (jsonParserFieldValue != null) {
					team.setResources(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ResourceSerDes.toDTO((String)object)
						).toArray(
							size -> new Resource[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalIncoming")) {
				if (jsonParserFieldValue != null) {
					team.setTotalIncoming(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalSpending")) {
				if (jsonParserFieldValue != null) {
					team.setTotalSpending(
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