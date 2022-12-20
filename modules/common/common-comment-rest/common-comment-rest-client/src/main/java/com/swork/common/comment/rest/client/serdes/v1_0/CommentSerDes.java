package com.swork.common.comment.rest.client.serdes.v1_0;

import com.swork.common.comment.rest.client.dto.v1_0.Comment;
import com.swork.common.comment.rest.client.json.BaseJSONParser;

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
public class CommentSerDes {

	public static Comment toDTO(String json) {
		CommentJSONParser commentJSONParser = new CommentJSONParser();

		return commentJSONParser.parseToDTO(json);
	}

	public static Comment[] toDTOs(String json) {
		CommentJSONParser commentJSONParser = new CommentJSONParser();

		return commentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Comment comment) {
		if (comment == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (comment.getClassPkId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPkId\": ");

			sb.append(comment.getClassPkId());
		}

		if (comment.getClassPkName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPkName\": ");

			sb.append("\"");

			sb.append(comment.getClassPkName());

			sb.append("\"");
		}

		if (comment.getComments() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"comments\": ");

			sb.append("[");

			for (int i = 0; i < comment.getComments().length; i++) {
				sb.append(String.valueOf(comment.getComments()[i]));

				if ((i + 1) < comment.getComments().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (comment.getContent() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"content\": ");

			sb.append("\"");

			sb.append(_escape(comment.getContent()));

			sb.append("\"");
		}

		if (comment.getCreatorId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorId\": ");

			sb.append(comment.getCreatorId());
		}

		if (comment.getCreatorName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creatorName\": ");

			sb.append("\"");

			sb.append(_escape(comment.getCreatorName()));

			sb.append("\"");
		}

		if (comment.getDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(comment.getDate()));

			sb.append("\"");
		}

		if (comment.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(comment.getId());
		}

		if (comment.getParentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append(comment.getParentId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CommentJSONParser commentJSONParser = new CommentJSONParser();

		return commentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Comment comment) {
		if (comment == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (comment.getClassPkId() == null) {
			map.put("classPkId", null);
		}
		else {
			map.put("classPkId", String.valueOf(comment.getClassPkId()));
		}

		if (comment.getClassPkName() == null) {
			map.put("classPkName", null);
		}
		else {
			map.put("classPkName", String.valueOf(comment.getClassPkName()));
		}

		if (comment.getComments() == null) {
			map.put("comments", null);
		}
		else {
			map.put("comments", String.valueOf(comment.getComments()));
		}

		if (comment.getContent() == null) {
			map.put("content", null);
		}
		else {
			map.put("content", String.valueOf(comment.getContent()));
		}

		if (comment.getCreatorId() == null) {
			map.put("creatorId", null);
		}
		else {
			map.put("creatorId", String.valueOf(comment.getCreatorId()));
		}

		if (comment.getCreatorName() == null) {
			map.put("creatorName", null);
		}
		else {
			map.put("creatorName", String.valueOf(comment.getCreatorName()));
		}

		if (comment.getDate() == null) {
			map.put("date", null);
		}
		else {
			map.put("date", liferayToJSONDateFormat.format(comment.getDate()));
		}

		if (comment.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(comment.getId()));
		}

		if (comment.getParentId() == null) {
			map.put("parentId", null);
		}
		else {
			map.put("parentId", String.valueOf(comment.getParentId()));
		}

		return map;
	}

	public static class CommentJSONParser extends BaseJSONParser<Comment> {

		@Override
		protected Comment createDTO() {
			return new Comment();
		}

		@Override
		protected Comment[] createDTOArray(int size) {
			return new Comment[size];
		}

		@Override
		protected void setField(
			Comment comment, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "classPkId")) {
				if (jsonParserFieldValue != null) {
					comment.setClassPkId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "classPkName")) {
				if (jsonParserFieldValue != null) {
					comment.setClassPkName(
						Comment.ClassPkName.create(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "comments")) {
				if (jsonParserFieldValue != null) {
					comment.setComments(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> CommentSerDes.toDTO((String)object)
						).toArray(
							size -> new Comment[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "content")) {
				if (jsonParserFieldValue != null) {
					comment.setContent((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creatorId")) {
				if (jsonParserFieldValue != null) {
					comment.setCreatorId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creatorName")) {
				if (jsonParserFieldValue != null) {
					comment.setCreatorName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "date")) {
				if (jsonParserFieldValue != null) {
					comment.setDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					comment.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parentId")) {
				if (jsonParserFieldValue != null) {
					comment.setParentId(
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