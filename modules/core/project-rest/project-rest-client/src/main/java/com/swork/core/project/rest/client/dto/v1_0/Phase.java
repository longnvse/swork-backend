package com.swork.core.project.rest.client.dto.v1_0;

import com.swork.core.project.rest.client.function.UnsafeSupplier;
import com.swork.core.project.rest.client.serdes.v1_0.PhaseSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Phase implements Cloneable, Serializable {

	public static Phase toDTO(String json) {
		return PhaseSerDes.toDTO(json);
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setEndDate(
		UnsafeSupplier<Date, Exception> endDateUnsafeSupplier) {

		try {
			endDate = endDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date endDate;

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

	public Long getProgress() {
		return progress;
	}

	public void setProgress(Long progress) {
		this.progress = progress;
	}

	public void setProgress(
		UnsafeSupplier<Long, Exception> progressUnsafeSupplier) {

		try {
			progress = progressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long progress;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setStartDate(
		UnsafeSupplier<Date, Exception> startDateUnsafeSupplier) {

		try {
			startDate = startDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date startDate;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<String, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String status;

	public Work[] getWorks() {
		return works;
	}

	public void setWorks(Work[] works) {
		this.works = works;
	}

	public void setWorks(
		UnsafeSupplier<Work[], Exception> worksUnsafeSupplier) {

		try {
			works = worksUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Work[] works;

	@Override
	public Phase clone() throws CloneNotSupportedException {
		return (Phase)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Phase)) {
			return false;
		}

		Phase phase = (Phase)object;

		return Objects.equals(toString(), phase.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return PhaseSerDes.toJSON(this);
	}

}