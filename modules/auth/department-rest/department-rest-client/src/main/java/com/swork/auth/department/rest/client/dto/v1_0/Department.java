package com.swork.auth.department.rest.client.dto.v1_0;

import com.swork.auth.department.rest.client.function.UnsafeSupplier;
import com.swork.auth.department.rest.client.serdes.v1_0.DepartmentSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Department implements Cloneable, Serializable {

	public static Department toDTO(String json) {
		return DepartmentSerDes.toDTO(json);
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public void setBusinessId(
		UnsafeSupplier<Long, Exception> businessIdUnsafeSupplier) {

		try {
			businessId = businessIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long businessId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	@Override
	public Department clone() throws CloneNotSupportedException {
		return (Department)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Department)) {
			return false;
		}

		Department department = (Department)object;

		return Objects.equals(toString(), department.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return DepartmentSerDes.toJSON(this);
	}

}