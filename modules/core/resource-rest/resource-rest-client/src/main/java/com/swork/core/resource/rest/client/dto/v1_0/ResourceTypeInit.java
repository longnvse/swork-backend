package com.swork.core.resource.rest.client.dto.v1_0;

import com.swork.core.resource.rest.client.function.UnsafeSupplier;
import com.swork.core.resource.rest.client.serdes.v1_0.ResourceTypeInitSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class ResourceTypeInit implements Cloneable, Serializable {

	public static ResourceTypeInit toDTO(String json) {
		return ResourceTypeInitSerDes.toDTO(json);
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCustomerId(
		UnsafeSupplier<Long, Exception> customerIdUnsafeSupplier) {

		try {
			customerId = customerIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long customerId;

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

	public ResourceType[] getResourceTypes() {
		return resourceTypes;
	}

	public void setResourceTypes(ResourceType[] resourceTypes) {
		this.resourceTypes = resourceTypes;
	}

	public void setResourceTypes(
		UnsafeSupplier<ResourceType[], Exception> resourceTypesUnsafeSupplier) {

		try {
			resourceTypes = resourceTypesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected ResourceType[] resourceTypes;

	@Override
	public ResourceTypeInit clone() throws CloneNotSupportedException {
		return (ResourceTypeInit)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ResourceTypeInit)) {
			return false;
		}

		ResourceTypeInit resourceTypeInit = (ResourceTypeInit)object;

		return Objects.equals(toString(), resourceTypeInit.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ResourceTypeInitSerDes.toJSON(this);
	}

}