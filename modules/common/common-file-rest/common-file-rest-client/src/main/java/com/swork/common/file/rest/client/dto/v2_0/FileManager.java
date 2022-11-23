package com.swork.common.file.rest.client.dto.v2_0;

import com.swork.common.file.rest.client.function.UnsafeSupplier;
import com.swork.common.file.rest.client.serdes.v2_0.FileManagerSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author ninhvv
 * @generated
 */
@Generated("")
public class FileManager implements Cloneable, Serializable {

	public static FileManager toDTO(String json) {
		return FileManagerSerDes.toDTO(json);
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public void setFileId(
		UnsafeSupplier<Long, Exception> fileIdUnsafeSupplier) {

		try {
			fileId = fileIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long fileId;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileName(
		UnsafeSupplier<String, Exception> fileNameUnsafeSupplier) {

		try {
			fileName = fileNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fileName;

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public void setFileSize(
		UnsafeSupplier<String, Exception> fileSizeUnsafeSupplier) {

		try {
			fileSize = fileSizeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fileSize;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setFileType(
		UnsafeSupplier<String, Exception> fileTypeUnsafeSupplier) {

		try {
			fileType = fileTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fileType;

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public void setMetadata(
		UnsafeSupplier<Metadata, Exception> metadataUnsafeSupplier) {

		try {
			metadata = metadataUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Metadata metadata;

	public String getMineType() {
		return mineType;
	}

	public void setMineType(String mineType) {
		this.mineType = mineType;
	}

	public void setMineType(
		UnsafeSupplier<String, Exception> mineTypeUnsafeSupplier) {

		try {
			mineType = mineTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String mineType;

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public void setParentCode(
		UnsafeSupplier<String, Exception> parentCodeUnsafeSupplier) {

		try {
			parentCode = parentCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String parentCode;

	public String getPkType() {
		return pkType;
	}

	public void setPkType(String pkType) {
		this.pkType = pkType;
	}

	public void setPkType(
		UnsafeSupplier<String, Exception> pkTypeUnsafeSupplier) {

		try {
			pkType = pkTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String pkType;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setType(UnsafeSupplier<String, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String type;

	@Override
	public FileManager clone() throws CloneNotSupportedException {
		return (FileManager)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FileManager)) {
			return false;
		}

		FileManager fileManager = (FileManager)object;

		return Objects.equals(toString(), fileManager.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return FileManagerSerDes.toJSON(this);
	}

}