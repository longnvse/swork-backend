package com.swork.rest.client.dto.v1_0;

import com.swork.rest.client.function.UnsafeSupplier;
import com.swork.rest.client.serdes.v1_0.PetSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Pet implements Cloneable, Serializable {

	public static Pet toDTO(String json) {
		return PetSerDes.toDTO(json);
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public void setPrice(UnsafeSupplier<Long, Exception> priceUnsafeSupplier) {
		try {
			price = priceUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long price;

	@Override
	public Pet clone() throws CloneNotSupportedException {
		return (Pet)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Pet)) {
			return false;
		}

		Pet pet = (Pet)object;

		return Objects.equals(toString(), pet.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return PetSerDes.toJSON(this);
	}

}