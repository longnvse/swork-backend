package com.swork.notification.rest.client.dto.v2_0;

import com.swork.notification.rest.client.function.UnsafeSupplier;
import com.swork.notification.rest.client.serdes.v2_0.NotificationNewSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author longnv
 * @generated
 */
@Generated("")
public class NotificationNew implements Cloneable, Serializable {

	public static NotificationNew toDTO(String json) {
		return NotificationNewSerDes.toDTO(json);
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setCount(
		UnsafeSupplier<Integer, Exception> countUnsafeSupplier) {

		try {
			count = countUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer count;

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public void setTotalTime(
		UnsafeSupplier<String, Exception> totalTimeUnsafeSupplier) {

		try {
			totalTime = totalTimeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String totalTime;

	@Override
	public NotificationNew clone() throws CloneNotSupportedException {
		return (NotificationNew)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NotificationNew)) {
			return false;
		}

		NotificationNew notificationNew = (NotificationNew)object;

		return Objects.equals(toString(), notificationNew.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return NotificationNewSerDes.toJSON(this);
	}

}