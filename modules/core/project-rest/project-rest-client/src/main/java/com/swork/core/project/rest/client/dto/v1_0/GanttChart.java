package com.swork.core.project.rest.client.dto.v1_0;

import com.swork.core.project.rest.client.function.UnsafeSupplier;
import com.swork.core.project.rest.client.serdes.v1_0.GanttChartSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class GanttChart implements Cloneable, Serializable {

	public static GanttChart toDTO(String json) {
		return GanttChartSerDes.toDTO(json);
	}

	public Phase[] getPhases() {
		return phases;
	}

	public void setPhases(Phase[] phases) {
		this.phases = phases;
	}

	public void setPhases(
		UnsafeSupplier<Phase[], Exception> phasesUnsafeSupplier) {

		try {
			phases = phasesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Phase[] phases;

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
	public GanttChart clone() throws CloneNotSupportedException {
		return (GanttChart)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GanttChart)) {
			return false;
		}

		GanttChart ganttChart = (GanttChart)object;

		return Objects.equals(toString(), ganttChart.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return GanttChartSerDes.toJSON(this);
	}

}