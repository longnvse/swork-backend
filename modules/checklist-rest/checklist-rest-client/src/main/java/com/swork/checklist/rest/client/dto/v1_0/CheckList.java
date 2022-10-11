package com.swork.checklist.rest.client.dto.v1_0;

import com.swork.checklist.rest.client.function.UnsafeSupplier;
import com.swork.checklist.rest.client.serdes.v1_0.CheckListSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author adm
 * @generated
 */
@Generated("")
public class CheckList implements Cloneable, Serializable {

	public static CheckList toDTO(String json) {
		return CheckListSerDes.toDTO(json);
	}

	public Long getCheckListId() {
		return checkListId;
	}

	public void setCheckListId(Long checkListId) {
		this.checkListId = checkListId;
	}

	public void setCheckListId(
		UnsafeSupplier<Long, Exception> checkListIdUnsafeSupplier) {

		try {
			checkListId = checkListIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long checkListId;

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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<Boolean, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean status;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public void setTaskId(
		UnsafeSupplier<Long, Exception> taskIdUnsafeSupplier) {

		try {
			taskId = taskIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long taskId;

	@Override
	public CheckList clone() throws CloneNotSupportedException {
		return (CheckList)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CheckList)) {
			return false;
		}

		CheckList checkList = (CheckList)object;

		return Objects.equals(toString(), checkList.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CheckListSerDes.toJSON(this);
	}

}