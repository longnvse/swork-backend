package com.swork.core.work.rest.client.dto.v1_0;

import com.swork.core.work.rest.client.function.UnsafeSupplier;
import com.swork.core.work.rest.client.serdes.v1_0.ParticipateSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author longnv
 * @generated
 */
@Generated("")
public class Participate implements Cloneable, Serializable {

	public static Participate toDTO(String json) {
		return ParticipateSerDes.toDTO(json);
	}

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

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public void setMemberId(
		UnsafeSupplier<Long, Exception> memberIdUnsafeSupplier) {

		try {
			memberId = memberIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long memberId;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setMemberName(
		UnsafeSupplier<String, Exception> memberNameUnsafeSupplier) {

		try {
			memberName = memberNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String memberName;

	public String getMemberReferenceCode() {
		return memberReferenceCode;
	}

	public void setMemberReferenceCode(String memberReferenceCode) {
		this.memberReferenceCode = memberReferenceCode;
	}

	public void setMemberReferenceCode(
		UnsafeSupplier<String, Exception> memberReferenceCodeUnsafeSupplier) {

		try {
			memberReferenceCode = memberReferenceCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String memberReferenceCode;

	public Type getType() {
		return type;
	}

	public String getTypeAsString() {
		if (type == null) {
			return null;
		}

		return type.toString();
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setType(UnsafeSupplier<Type, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Type type;

	@Override
	public Participate clone() throws CloneNotSupportedException {
		return (Participate)super.clone();
	}

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
		return ParticipateSerDes.toJSON(this);
	}

	public static enum Type {

		ACCOUNT("account"), DEPARTMENT("department");

		public static Type create(String value) {
			for (Type type : values()) {
				if (Objects.equals(type.getValue(), value) ||
					Objects.equals(type.name(), value)) {

					return type;
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

		private Type(String value) {
			_value = value;
		}

		private final String _value;

	}

}