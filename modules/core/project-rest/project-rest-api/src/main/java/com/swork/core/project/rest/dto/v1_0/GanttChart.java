package com.swork.core.project.rest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@GraphQLName("GanttChart")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "GanttChart")
public class GanttChart implements Serializable {

	public static GanttChart toDTO(String json) {
		return ObjectMapperUtil.readValue(GanttChart.class, json);
	}

	public static GanttChart unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(GanttChart.class, json);
	}

	@Schema
	@Valid
	public Phase[] getPhases() {
		return phases;
	}

	public void setPhases(Phase[] phases) {
		this.phases = phases;
	}

	@JsonIgnore
	public void setPhases(
		UnsafeSupplier<Phase[], Exception> phasesUnsafeSupplier) {

		try {
			phases = phasesUnsafeSupplier.get();
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
	protected Phase[] phases;

	@Schema
	@Valid
	public Work[] getWorks() {
		return works;
	}

	public void setWorks(Work[] works) {
		this.works = works;
	}

	@JsonIgnore
	public void setWorks(
		UnsafeSupplier<Work[], Exception> worksUnsafeSupplier) {

		try {
			works = worksUnsafeSupplier.get();
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
	protected Work[] works;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GanttChart)) {
			return false;
		}

		GanttChart ganttChart = (GanttChart)object;

		return Objects.equals(toString(), ganttChart.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (phases != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phases\": ");

			sb.append("[");

			for (int i = 0; i < phases.length; i++) {
				sb.append(String.valueOf(phases[i]));

				if ((i + 1) < phases.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (works != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"works\": ");

			sb.append("[");

			for (int i = 0; i < works.length; i++) {
				sb.append(String.valueOf(works[i]));

				if ((i + 1) < works.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.swork.core.project.rest.dto.v1_0.GanttChart",
		name = "x-class-name"
	)
	public String xClassName;

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