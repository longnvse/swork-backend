package com.swork.core.project.rest.client.dto.v1_0;

import com.swork.core.project.rest.client.function.UnsafeSupplier;
import com.swork.core.project.rest.client.serdes.v1_0.ChartSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Chart implements Cloneable, Serializable {

	public static Chart toDTO(String json) {
		return ChartSerDes.toDTO(json);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDate(UnsafeSupplier<Date, Exception> dateUnsafeSupplier) {
		try {
			date = dateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date date;

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public void setObj(UnsafeSupplier<String, Exception> objUnsafeSupplier) {
		try {
			obj = objUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String obj;

	public Long getSum() {
		return sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}

	public void setSum(UnsafeSupplier<Long, Exception> sumUnsafeSupplier) {
		try {
			sum = sumUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long sum;

	public Double getSumDouble() {
		return sumDouble;
	}

	public void setSumDouble(Double sumDouble) {
		this.sumDouble = sumDouble;
	}

	public void setSumDouble(
		UnsafeSupplier<Double, Exception> sumDoubleUnsafeSupplier) {

		try {
			sumDouble = sumDoubleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double sumDouble;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setUnit(UnsafeSupplier<String, Exception> unitUnsafeSupplier) {
		try {
			unit = unitUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String unit;

	public Double[] getValueArrayDoubles() {
		return valueArrayDoubles;
	}

	public void setValueArrayDoubles(Double[] valueArrayDoubles) {
		this.valueArrayDoubles = valueArrayDoubles;
	}

	public void setValueArrayDoubles(
		UnsafeSupplier<Double[], Exception> valueArrayDoublesUnsafeSupplier) {

		try {
			valueArrayDoubles = valueArrayDoublesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double[] valueArrayDoubles;

	public ValueArrayString[] getValueArrayStrings() {
		return valueArrayStrings;
	}

	public void setValueArrayStrings(ValueArrayString[] valueArrayStrings) {
		this.valueArrayStrings = valueArrayStrings;
	}

	public void setValueArrayStrings(
		UnsafeSupplier<ValueArrayString[], Exception>
			valueArrayStringsUnsafeSupplier) {

		try {
			valueArrayStrings = valueArrayStringsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected ValueArrayString[] valueArrayStrings;

	public Long[] getValueArrays() {
		return valueArrays;
	}

	public void setValueArrays(Long[] valueArrays) {
		this.valueArrays = valueArrays;
	}

	public void setValueArrays(
		UnsafeSupplier<Long[], Exception> valueArraysUnsafeSupplier) {

		try {
			valueArrays = valueArraysUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long[] valueArrays;

	public ValueChart[] getValueCharts() {
		return valueCharts;
	}

	public void setValueCharts(ValueChart[] valueCharts) {
		this.valueCharts = valueCharts;
	}

	public void setValueCharts(
		UnsafeSupplier<ValueChart[], Exception> valueChartsUnsafeSupplier) {

		try {
			valueCharts = valueChartsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected ValueChart[] valueCharts;

	@Override
	public Chart clone() throws CloneNotSupportedException {
		return (Chart)super.clone();
	}

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
		return ChartSerDes.toJSON(this);
	}

}