package com.swork.business.rest.client.dto.v1_0;

import com.swork.business.rest.client.function.UnsafeSupplier;
import com.swork.business.rest.client.serdes.v1_0.BusinessSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Business implements Cloneable, Serializable {

	public static Business toDTO(String json) {
		return BusinessSerDes.toDTO(json);
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public void setBusinessAddress(
		UnsafeSupplier<String, Exception> businessAddressUnsafeSupplier) {

		try {
			businessAddress = businessAddressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String businessAddress;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerName(
		UnsafeSupplier<String, Exception> customerNameUnsafeSupplier) {

		try {
			customerName = customerNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String customerName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail(
		UnsafeSupplier<String, Exception> emailUnsafeSupplier) {

		try {
			email = emailUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String email;

	public String getExternalReferenceCode() {
		return externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		this.externalReferenceCode = externalReferenceCode;
	}

	public void setExternalReferenceCode(
		UnsafeSupplier<String, Exception> externalReferenceCodeUnsafeSupplier) {

		try {
			externalReferenceCode = externalReferenceCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String externalReferenceCode;

	public String getFieldOperations() {
		return fieldOperations;
	}

	public void setFieldOperations(String fieldOperations) {
		this.fieldOperations = fieldOperations;
	}

	public void setFieldOperations(
		UnsafeSupplier<String, Exception> fieldOperationsUnsafeSupplier) {

		try {
			fieldOperations = fieldOperationsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fieldOperations;

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

	public String getLogoId() {
		return logoId;
	}

	public void setLogoId(String logoId) {
		this.logoId = logoId;
	}

	public void setLogoId(
		UnsafeSupplier<String, Exception> logoIdUnsafeSupplier) {

		try {
			logoId = logoIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String logoId;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPhoneNumber(
		UnsafeSupplier<String, Exception> phoneNumberUnsafeSupplier) {

		try {
			phoneNumber = phoneNumberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String phoneNumber;

	public Status getStatus() {
		return status;
	}

	public String getStatusAsString() {
		if (status == null) {
			return null;
		}

		return status.toString();
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<Status, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Status status;

	@Override
	public Business clone() throws CloneNotSupportedException {
		return (Business)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Business)) {
			return false;
		}

		Business business = (Business)object;

		return Objects.equals(toString(), business.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return BusinessSerDes.toJSON(this);
	}

	public static enum Status {

		PENDING("pending"), APPROVED("approved");

		public static Status create(String value) {
			for (Status status : values()) {
				if (Objects.equals(status.getValue(), value) ||
					Objects.equals(status.name(), value)) {

					return status;
				}
			}

			return null;
		}

		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Status(String value) {
			_value = value;
		}

		private final String _value;

	}

}