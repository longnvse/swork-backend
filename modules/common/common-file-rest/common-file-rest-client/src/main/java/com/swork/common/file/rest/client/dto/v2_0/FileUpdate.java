package com.swork.common.file.rest.client.dto.v2_0;

import com.swork.common.file.rest.client.function.UnsafeSupplier;
import com.swork.common.file.rest.client.serdes.v2_0.FileUpdateSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author ninhvv
 * @generated
 */
@Generated("")
public class FileUpdate implements Cloneable, Serializable {

	public static FileUpdate toDTO(String json) {
		return FileUpdateSerDes.toDTO(json);
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public void setSize(UnsafeSupplier<Long, Exception> sizeUnsafeSupplier) {
		try {
			size = sizeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long size;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUrl(UnsafeSupplier<String, Exception> urlUnsafeSupplier) {
		try {
			url = urlUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String url;

	@Override
	public FileUpdate clone() throws CloneNotSupportedException {
		return (FileUpdate)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FileUpdate)) {
			return false;
		}

		FileUpdate fileUpdate = (FileUpdate)object;

		return Objects.equals(toString(), fileUpdate.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return FileUpdateSerDes.toJSON(this);
	}

}