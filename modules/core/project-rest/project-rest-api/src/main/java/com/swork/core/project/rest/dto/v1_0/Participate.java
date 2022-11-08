package com.swork.core.project.rest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
@GraphQLName(description = "Project Participates", value = "Participate")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Participate")
public class Participate implements Serializable {

	public static Participate toDTO(String json) {
		return ObjectMapperUtil.readValue(Participate.class, json);
	}

	public static Participate unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Participate.class, json);
	}

	@Schema
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long id;

	@Schema
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	@JsonIgnore
	public void setMemberId(
		UnsafeSupplier<Long, Exception> memberIdUnsafeSupplier) {

		try {
			memberId = memberIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long memberId;

	@Schema
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@JsonIgnore
	public void setMemberName(
		UnsafeSupplier<String, Exception> memberNameUnsafeSupplier) {

		try {
			memberName = memberNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String memberName;

	@Schema
	public String getMemberReferenceCode() {
		return memberReferenceCode;
	}

	public void setMemberReferenceCode(String memberReferenceCode) {
		this.memberReferenceCode = memberReferenceCode;
	}

	@JsonIgnore
	public void setMemberReferenceCode(
		UnsafeSupplier<String, Exception> memberReferenceCodeUnsafeSupplier) {

		try {
			memberReferenceCode = memberReferenceCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String memberReferenceCode;

	@Schema
	@Valid
	public MemberType getMemberType() {
		return memberType;
	}

	@JsonIgnore
	public String getMemberTypeAsString() {
		if (memberType == null) {
			return null;
		}

		return memberType.toString();
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	@JsonIgnore
	public void setMemberType(
		UnsafeSupplier<MemberType, Exception> memberTypeUnsafeSupplier) {

		try {
			memberType = memberTypeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected MemberType memberType;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Participate)) {
			return false;
		}

		Participate participate = (Participate)object;

		return Objects.equals(toString(), participate.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (memberId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberId\": ");

			sb.append(memberId);
		}

		if (memberName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberName\": ");

			sb.append("\"");

			sb.append(_escape(memberName));

			sb.append("\"");
		}

		if (memberReferenceCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(memberReferenceCode));

			sb.append("\"");
		}

		if (memberType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memberType\": ");

			sb.append("\"");

			sb.append(memberType);

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.swork.core.project.rest.dto.v1_0.Participate",
		name = "x-class-name"
	)
	public String xClassName;

	@GraphQLName("MemberType")
	public static enum MemberType {

		ACCOUNT("account"), DEPARTMENT("department");

		@JsonCreator
		public static MemberType create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (MemberType memberType : values()) {
				if (Objects.equals(memberType.getValue(), value)) {
					return memberType;
				}
			}

			throw new IllegalArgumentException("Invalid enum value: " + value);
		}

		@JsonValue
		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private MemberType(String value) {
			_value = value;
		}

		private final String _value;

	}

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}