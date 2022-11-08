package com.swork.core.project.rest.client.dto.v1_0;

import com.swork.core.project.rest.client.function.UnsafeSupplier;
import com.swork.core.project.rest.client.serdes.v1_0.HandleSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Handle implements Cloneable, Serializable {

	public static Handle toDTO(String json) {
		return HandleSerDes.toDTO(json);
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

	public MemberType getMemberType() {
		return memberType;
	}

	public String getMemberTypeAsString() {
		if (memberType == null) {
			return null;
		}

		return memberType.toString();
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	public void setMemberType(
		UnsafeSupplier<MemberType, Exception> memberTypeUnsafeSupplier) {

		try {
			memberType = memberTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected MemberType memberType;

	@Override
	public Handle clone() throws CloneNotSupportedException {
		return (Handle)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Handle)) {
			return false;
		}

		Handle handle = (Handle)object;

		return Objects.equals(toString(), handle.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return HandleSerDes.toJSON(this);
	}

	public static enum MemberType {

		ACCOUNT("account"), DEPARTMENT("department");

		public static MemberType create(String value) {
			for (MemberType memberType : values()) {
				if (Objects.equals(memberType.getValue(), value) ||
					Objects.equals(memberType.name(), value)) {

					return memberType;
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

		private MemberType(String value) {
			_value = value;
		}

		private final String _value;

	}

}