package com.swork.common.file.rest.client.dto.v2_0;

import com.swork.common.file.rest.client.function.UnsafeSupplier;
import com.swork.common.file.rest.client.serdes.v2_0.DocumentBriefSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author ninhvv
 * @generated
 */
@Generated("")
public class DocumentBrief implements Cloneable, Serializable {

	public static DocumentBrief toDTO(String json) {
		return DocumentBriefSerDes.toDTO(json);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCategory(
		UnsafeSupplier<String, Exception> categoryUnsafeSupplier) {

		try {
			category = categoryUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String category;

	public DocumentBrief[] getDocumentBriefs() {
		return documentBriefs;
	}

	public void setDocumentBriefs(DocumentBrief[] documentBriefs) {
		this.documentBriefs = documentBriefs;
	}

	public void setDocumentBriefs(
		UnsafeSupplier<DocumentBrief[], Exception>
			documentBriefsUnsafeSupplier) {

		try {
			documentBriefs = documentBriefsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected DocumentBrief[] documentBriefs;

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

	@Override
	public DocumentBrief clone() throws CloneNotSupportedException {
		return (DocumentBrief)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentBrief)) {
			return false;
		}

		DocumentBrief documentBrief = (DocumentBrief)object;

		return Objects.equals(toString(), documentBrief.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return DocumentBriefSerDes.toJSON(this);
	}

}