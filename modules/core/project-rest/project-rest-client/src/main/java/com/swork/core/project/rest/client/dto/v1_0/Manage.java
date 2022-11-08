package com.swork.core.project.rest.client.dto.v1_0;

import com.swork.core.project.rest.client.function.UnsafeSupplier;
import com.swork.core.project.rest.client.serdes.v1_0.ManageSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Manage implements Cloneable, Serializable {

	public static Manage toDTO(String json) {
		return ManageSerDes.toDTO(json);
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

	@Override
	public Manage clone() throws CloneNotSupportedException {
		return (Manage)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Manage)) {
			return false;
		}

		Manage manage = (Manage)object;

		return Objects.equals(toString(), manage.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ManageSerDes.toJSON(this);
	}

}