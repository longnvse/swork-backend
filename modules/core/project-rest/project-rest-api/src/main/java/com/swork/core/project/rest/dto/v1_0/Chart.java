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

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
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
@GraphQLName(description = "Present Employee chart of object", value = "Chart")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Chart")
public class Chart implements Serializable {

	public static Chart toDTO(String json) {
		return ObjectMapperUtil.readValue(Chart.class, json);
	}

	public static Chart unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Chart.class, json);
	}

	@Schema
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@JsonIgnore
	public void setDate(UnsafeSupplier<Date, Exception> dateUnsafeSupplier) {
		try {
			date = dateUnsafeSupplier.get();
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
	protected Date date;

	@Schema
	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	@JsonIgnore
	public void setObj(UnsafeSupplier<String, Exception> objUnsafeSupplier) {
		try {
			obj = objUnsafeSupplier.get();
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
	protected String obj;

	@Schema
	public Long getSum() {
		return sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}

	@JsonIgnore
	public void setSum(UnsafeSupplier<Long, Exception> sumUnsafeSupplier) {
		try {
			sum = sumUnsafeSupplier.get();
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
	protected Long sum;

	@Schema
	public Double getSumDouble() {
		return sumDouble;
	}

	public void setSumDouble(Double sumDouble) {
		this.sumDouble = sumDouble;
	}

	@JsonIgnore
	public void setSumDouble(
		UnsafeSupplier<Double, Exception> sumDoubleUnsafeSupplier) {

		try {
			sumDouble = sumDoubleUnsafeSupplier.get();
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
	protected Double sumDouble;

	@Schema
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@JsonIgnore
	public void setUnit(UnsafeSupplier<String, Exception> unitUnsafeSupplier) {
		try {
			unit = unitUnsafeSupplier.get();
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
	protected String unit;

	@Schema
	public Double[] getValueArrayDoubles() {
		return valueArrayDoubles;
	}

	public void setValueArrayDoubles(Double[] valueArrayDoubles) {
		this.valueArrayDoubles = valueArrayDoubles;
	}

	@JsonIgnore
	public void setValueArrayDoubles(
		UnsafeSupplier<Double[], Exception> valueArrayDoublesUnsafeSupplier) {

		try {
			valueArrayDoubles = valueArrayDoublesUnsafeSupplier.get();
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
	protected Double[] valueArrayDoubles;

	@Schema
	@Valid
	public ValueArrayString[] getValueArrayStrings() {
		return valueArrayStrings;
	}

	public void setValueArrayStrings(ValueArrayString[] valueArrayStrings) {
		this.valueArrayStrings = valueArrayStrings;
	}

	@JsonIgnore
	public void setValueArrayStrings(
		UnsafeSupplier<ValueArrayString[], Exception>
			valueArrayStringsUnsafeSupplier) {

		try {
			valueArrayStrings = valueArrayStringsUnsafeSupplier.get();
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
	protected ValueArrayString[] valueArrayStrings;

	@Schema
	public Long[] getValueArrays() {
		return valueArrays;
	}

	public void setValueArrays(Long[] valueArrays) {
		this.valueArrays = valueArrays;
	}

	@JsonIgnore
	public void setValueArrays(
		UnsafeSupplier<Long[], Exception> valueArraysUnsafeSupplier) {

		try {
			valueArrays = valueArraysUnsafeSupplier.get();
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
	protected Long[] valueArrays;

	@Schema
	@Valid
	public ValueChart[] getValueCharts() {
		return valueCharts;
	}

	public void setValueCharts(ValueChart[] valueCharts) {
		this.valueCharts = valueCharts;
	}

	@JsonIgnore
	public void setValueCharts(
		UnsafeSupplier<ValueChart[], Exception> valueChartsUnsafeSupplier) {

		try {
			valueCharts = valueChartsUnsafeSupplier.get();
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
	protected ValueChart[] valueCharts;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Chart)) {
			return false;
		}

		Chart chart = (Chart)object;

		return Objects.equals(toString(), chart.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (date != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(date));

			sb.append("\"");
		}

		if (obj != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"obj\": ");

			sb.append("\"");

			sb.append(_escape(obj));

			sb.append("\"");
		}

		if (sum != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sum\": ");

			sb.append(sum);
		}

		if (sumDouble != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sumDouble\": ");

			sb.append(sumDouble);
		}

		if (unit != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"unit\": ");

			sb.append("\"");

			sb.append(_escape(unit));

			sb.append("\"");
		}

		if (valueArrayDoubles != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valueArrayDoubles\": ");

			sb.append("[");

			for (int i = 0; i < valueArrayDoubles.length; i++) {
				sb.append(valueArrayDoubles[i]);

				if ((i + 1) < valueArrayDoubles.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (valueArrayStrings != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valueArrayStrings\": ");

			sb.append("[");

			for (int i = 0; i < valueArrayStrings.length; i++) {
				sb.append(String.valueOf(valueArrayStrings[i]));

				if ((i + 1) < valueArrayStrings.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (valueArrays != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valueArrays\": ");

			sb.append("[");

			for (int i = 0; i < valueArrays.length; i++) {
				sb.append(valueArrays[i]);

				if ((i + 1) < valueArrays.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (valueCharts != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valueCharts\": ");

			sb.append("[");

			for (int i = 0; i < valueCharts.length; i++) {
				sb.append(String.valueOf(valueCharts[i]));

				if ((i + 1) < valueCharts.length) {
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
		defaultValue = "com.swork.core.project.rest.dto.v1_0.Chart",
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