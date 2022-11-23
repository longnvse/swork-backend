package com.swork.common.file.rest.client.dto.v2_0;

import com.swork.common.file.rest.client.function.UnsafeSupplier;
import com.swork.common.file.rest.client.serdes.v2_0.MetadataSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author ninhvv
 * @generated
 */
@Generated("")
public class Metadata implements Cloneable, Serializable {

	public static Metadata toDTO(String json) {
		return MetadataSerDes.toDTO(json);
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setAppId(
		UnsafeSupplier<String, Exception> appIdUnsafeSupplier) {

		try {
			appId = appIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String appId;

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public void setModuleId(
		UnsafeSupplier<String, Exception> moduleIdUnsafeSupplier) {

		try {
			moduleId = moduleIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String moduleId;

	@Override
	public Metadata clone() throws CloneNotSupportedException {
		return (Metadata)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Metadata)) {
			return false;
		}

		Metadata metadata = (Metadata)object;

		return Objects.equals(toString(), metadata.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return MetadataSerDes.toJSON(this);
	}

}