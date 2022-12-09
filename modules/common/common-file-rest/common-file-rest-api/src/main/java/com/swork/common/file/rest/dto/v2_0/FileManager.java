package com.swork.common.file.rest.dto.v2_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author longnv
 * @generated
 */
@Generated("")
@GraphQLName(description = "upload file", value = "FileManager")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "FileManager")
public class FileManager implements Serializable {

	public static FileManager toDTO(String json) {
		return ObjectMapperUtil.readValue(FileManager.class, json);
	}

	public static FileManager unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(FileManager.class, json);
	}

	@Schema(description = "id of the file in the dlfileentry table.")
	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	@JsonIgnore
	public void setFileId(
		UnsafeSupplier<Long, Exception> fileIdUnsafeSupplier) {

		try {
			fileId = fileIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "id of the file in the dlfileentry table.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long fileId;

	@Schema
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@JsonIgnore
	public void setFileName(
		UnsafeSupplier<String, Exception> fileNameUnsafeSupplier) {

		try {
			fileName = fileNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String fileName;

	@Schema
	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	@JsonIgnore
	public void setFileSize(
		UnsafeSupplier<String, Exception> fileSizeUnsafeSupplier) {

		try {
			fileSize = fileSizeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String fileSize;

	@Schema
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@JsonIgnore
	public void setFileType(
		UnsafeSupplier<String, Exception> fileTypeUnsafeSupplier) {

		try {
			fileType = fileTypeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String fileType;

	@Schema
	@Valid
	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	@JsonIgnore
	public void setMetadata(
		UnsafeSupplier<Metadata, Exception> metadataUnsafeSupplier) {

		try {
			metadata = metadataUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Metadata metadata;

	@Schema
	public String getMineType() {
		return mineType;
	}

	public void setMineType(String mineType) {
		this.mineType = mineType;
	}

	@JsonIgnore
	public void setMineType(
		UnsafeSupplier<String, Exception> mineTypeUnsafeSupplier) {

		try {
			mineType = mineTypeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String mineType;

	@Schema
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	@JsonIgnore
	public void setParentCode(
		UnsafeSupplier<String, Exception> parentCodeUnsafeSupplier) {

		try {
			parentCode = parentCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String parentCode;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (fileId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileId\": ");

			sb.append(fileId);
		}

		if (fileName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileName\": ");

			sb.append("\"");

			sb.append(_escape(fileName));

			sb.append("\"");
		}

		if (fileSize != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileSize\": ");

			sb.append("\"");

			sb.append(_escape(fileSize));

			sb.append("\"");
		}

		if (fileType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileType\": ");

			sb.append("\"");

			sb.append(_escape(fileType));

			sb.append("\"");
		}

		if (metadata != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"metadata\": ");

			sb.append(String.valueOf(metadata));
		}

		if (mineType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mineType\": ");

			sb.append("\"");

			sb.append(_escape(mineType));

			sb.append("\"");
		}

		if (parentCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentCode\": ");

			sb.append("\"");

			sb.append(_escape(parentCode));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.swork.common.file.rest.dto.v2_0.FileManager",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}