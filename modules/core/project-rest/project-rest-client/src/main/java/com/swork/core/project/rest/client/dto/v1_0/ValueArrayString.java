package com.swork.core.project.rest.client.dto.v1_0;

import com.swork.core.project.rest.client.function.UnsafeSupplier;
import com.swork.core.project.rest.client.serdes.v1_0.ValueArrayStringSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class ValueArrayString implements Cloneable, Serializable {

	public static ValueArrayString toDTO(String json) {
		return ValueArrayStringSerDes.toDTO(json);
	}

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

	@Override
	public ValueArrayString clone() throws CloneNotSupportedException {
		return (ValueArrayString)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ValueArrayString)) {
			return false;
		}

		ValueArrayString valueArrayString = (ValueArrayString)object;

		return Objects.equals(toString(), valueArrayString.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ValueArrayStringSerDes.toJSON(this);
	}

}