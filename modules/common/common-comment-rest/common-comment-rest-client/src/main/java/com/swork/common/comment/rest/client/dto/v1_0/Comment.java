package com.swork.common.comment.rest.client.dto.v1_0;

import com.swork.common.comment.rest.client.function.UnsafeSupplier;
import com.swork.common.comment.rest.client.serdes.v1_0.CommentSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Comment implements Cloneable, Serializable {

	public static Comment toDTO(String json) {
		return CommentSerDes.toDTO(json);
	}

	public Long getClassPkId() {
		return classPkId;
	}

	public void setClassPkId(Long classPkId) {
		this.classPkId = classPkId;
	}

	public void setClassPkId(
		UnsafeSupplier<Long, Exception> classPkIdUnsafeSupplier) {

		try {
			classPkId = classPkIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long classPkId;

	public ClassPkName getClassPkName() {
		return classPkName;
	}

	public String getClassPkNameAsString() {
		if (classPkName == null) {
			return null;
		}

		return classPkName.toString();
	}

	public void setClassPkName(ClassPkName classPkName) {
		this.classPkName = classPkName;
	}

	public void setClassPkName(
		UnsafeSupplier<ClassPkName, Exception> classPkNameUnsafeSupplier) {

		try {
			classPkName = classPkNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected ClassPkName classPkName;

	public Comment[] getComments() {
		return comments;
	}

	public void setComments(Comment[] comments) {
		this.comments = comments;
	}

	public void setComments(
		UnsafeSupplier<Comment[], Exception> commentsUnsafeSupplier) {

		try {
			comments = commentsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Comment[] comments;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setContent(
		UnsafeSupplier<String, Exception> contentUnsafeSupplier) {

		try {
			content = contentUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String content;

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setParentId(
		UnsafeSupplier<Long, Exception> parentIdUnsafeSupplier) {

		try {
			parentId = parentIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long parentId;

	@Override
	public Comment clone() throws CloneNotSupportedException {
		return (Comment)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Comment)) {
			return false;
		}

		Comment comment = (Comment)object;

		return Objects.equals(toString(), comment.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CommentSerDes.toJSON(this);
	}

	public static enum ClassPkName {

		PROJECT("project"), PHASE("phase"), WORK("work");

		public static ClassPkName create(String value) {
			for (ClassPkName classPkName : values()) {
				if (Objects.equals(classPkName.getValue(), value) ||
					Objects.equals(classPkName.name(), value)) {

					return classPkName;
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

		private ClassPkName(String value) {
			_value = value;
		}

		private final String _value;

	}

}