package com.swork.core.work.rest.client.dto.v1_0;

import com.swork.core.work.rest.client.function.UnsafeSupplier;
import com.swork.core.work.rest.client.serdes.v1_0.WorkSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author longnv
 * @generated
 */
@Generated("")
public class Work implements Cloneable, Serializable {

	public static Work toDTO(String json) {
		return WorkSerDes.toDTO(json);
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public void setActualEndDate(
		UnsafeSupplier<Date, Exception> actualEndDateUnsafeSupplier) {

		try {
			actualEndDate = actualEndDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date actualEndDate;

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public void setActualStartDate(
		UnsafeSupplier<Date, Exception> actualStartDateUnsafeSupplier) {

		try {
			actualStartDate = actualStartDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date actualStartDate;

	public Integer getAttachNumber() {
		return attachNumber;
	}

	public void setAttachNumber(Integer attachNumber) {
		this.attachNumber = attachNumber;
	}

	public void setAttachNumber(
		UnsafeSupplier<Integer, Exception> attachNumberUnsafeSupplier) {

		try {
			attachNumber = attachNumberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer attachNumber;

	public Integer getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
	}

	public void setCommentNumber(
		UnsafeSupplier<Integer, Exception> commentNumberUnsafeSupplier) {

		try {
			commentNumber = commentNumberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer commentNumber;

	public Double getComplete() {
		return complete;
	}

	public void setComplete(Double complete) {
		this.complete = complete;
	}

	public void setComplete(
		UnsafeSupplier<Double, Exception> completeUnsafeSupplier) {

		try {
			complete = completeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double complete;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setCreateDate(
		UnsafeSupplier<Date, Exception> createDateUnsafeSupplier) {

		try {
			createDate = createDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date createDate;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String description;

	public String getDescriptionProgress() {
		return descriptionProgress;
	}

	public void setDescriptionProgress(String descriptionProgress) {
		this.descriptionProgress = descriptionProgress;
	}

	public void setDescriptionProgress(
		UnsafeSupplier<String, Exception> descriptionProgressUnsafeSupplier) {

		try {
			descriptionProgress = descriptionProgressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String descriptionProgress;

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

	public String getExternalReferenceCode() {
		return externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		this.externalReferenceCode = externalReferenceCode;
	}

	public void setExternalReferenceCode(
		UnsafeSupplier<String, Exception> externalReferenceCodeUnsafeSupplier) {

		try {
			externalReferenceCode = externalReferenceCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String externalReferenceCode;

	public Handle[] getHandles() {
		return handles;
	}

	public void setHandles(Handle[] handles) {
		this.handles = handles;
	}

	public void setHandles(
		UnsafeSupplier<Handle[], Exception> handlesUnsafeSupplier) {

		try {
			handles = handlesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Handle[] handles;

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

	public Double getIncompleteAmount() {
		return incompleteAmount;
	}

	public void setIncompleteAmount(Double incompleteAmount) {
		this.incompleteAmount = incompleteAmount;
	}

	public void setIncompleteAmount(
		UnsafeSupplier<Double, Exception> incompleteAmountUnsafeSupplier) {

		try {
			incompleteAmount = incompleteAmountUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double incompleteAmount;

	public Manage[] getManages() {
		return manages;
	}

	public void setManages(Manage[] manages) {
		this.manages = manages;
	}

	public void setManages(
		UnsafeSupplier<Manage[], Exception> managesUnsafeSupplier) {

		try {
			manages = managesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Manage[] manages;

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setModifiedDate(
		UnsafeSupplier<Date, Exception> modifiedDateUnsafeSupplier) {

		try {
			modifiedDate = modifiedDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date modifiedDate;

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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public void setParentName(
		UnsafeSupplier<String, Exception> parentNameUnsafeSupplier) {

		try {
			parentName = parentNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String parentName;

	public ParentStatus getParentStatus() {
		return parentStatus;
	}

	public String getParentStatusAsString() {
		if (parentStatus == null) {
			return null;
		}

		return parentStatus.toString();
	}

	public void setParentStatus(ParentStatus parentStatus) {
		this.parentStatus = parentStatus;
	}

	public void setParentStatus(
		UnsafeSupplier<ParentStatus, Exception> parentStatusUnsafeSupplier) {

		try {
			parentStatus = parentStatusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected ParentStatus parentStatus;

	public Participate[] getParticipates() {
		return participates;
	}

	public void setParticipates(Participate[] participates) {
		this.participates = participates;
	}

	public void setParticipates(
		UnsafeSupplier<Participate[], Exception> participatesUnsafeSupplier) {

		try {
			participates = participatesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Participate[] participates;

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public void setPercentage(
		UnsafeSupplier<Double, Exception> percentageUnsafeSupplier) {

		try {
			percentage = percentageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double percentage;

	public Long getPhaseId() {
		return phaseId;
	}

	public void setPhaseId(Long phaseId) {
		this.phaseId = phaseId;
	}

	public void setPhaseId(
		UnsafeSupplier<Long, Exception> phaseIdUnsafeSupplier) {

		try {
			phaseId = phaseIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long phaseId;

	public String getPhaseName() {
		return phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	public void setPhaseName(
		UnsafeSupplier<String, Exception> phaseNameUnsafeSupplier) {

		try {
			phaseName = phaseNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String phaseName;

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

	public ProgressType getProgressType() {
		return progressType;
	}

	public String getProgressTypeAsString() {
		if (progressType == null) {
			return null;
		}

		return progressType.toString();
	}

	public void setProgressType(ProgressType progressType) {
		this.progressType = progressType;
	}

	public void setProgressType(
		UnsafeSupplier<ProgressType, Exception> progressTypeUnsafeSupplier) {

		try {
			progressType = progressTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected ProgressType progressType;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public void setProjectId(
		UnsafeSupplier<Long, Exception> projectIdUnsafeSupplier) {

		try {
			projectId = projectIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long projectId;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectName(
		UnsafeSupplier<String, Exception> projectNameUnsafeSupplier) {

		try {
			projectName = projectNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String projectName;

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

	public Status getStatus() {
		return status;
	}

	public String getStatusAsString() {
		if (status == null) {
			return null;
		}

		return status.toString();
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<Status, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Status status;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setUnit(UnsafeSupplier<String, Exception> unitUnsafeSupplier) {
		try {
			unit = unitUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String unit;

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
	public Work clone() throws CloneNotSupportedException {
		return (Work)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Work)) {
			return false;
		}

		Work work = (Work)object;

		return Objects.equals(toString(), work.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return WorkSerDes.toJSON(this);
	}

	public static enum ParentStatus {

		PENDING("pending"), ACTIVE("active"), COMPLETED("completed"),
		INACTIVE("inactive"), DENIED("denied");

		public static ParentStatus create(String value) {
			for (ParentStatus parentStatus : values()) {
				if (Objects.equals(parentStatus.getValue(), value) ||
					Objects.equals(parentStatus.name(), value)) {

					return parentStatus;
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

		private ParentStatus(String value) {
			_value = value;
		}

		private final String _value;

	}

	public static enum ProgressType {

		MANUAL("manual"), BY_CHECKLIST("byChecklist"), BY_AMOUNT("byAmount"),
		BY_PROPORTION("byProportion");

		public static ProgressType create(String value) {
			for (ProgressType progressType : values()) {
				if (Objects.equals(progressType.getValue(), value) ||
					Objects.equals(progressType.name(), value)) {

					return progressType;
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

		private ProgressType(String value) {
			_value = value;
		}

		private final String _value;

	}

	public static enum Status {

		PENDING("pending"), ACTIVE("active"), COMPLETED("completed"),
		INACTIVE("inactive"), DENIED("denied");

		public static Status create(String value) {
			for (Status status : values()) {
				if (Objects.equals(status.getValue(), value) ||
					Objects.equals(status.name(), value)) {

					return status;
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

		private Status(String value) {
			_value = value;
		}

		private final String _value;

	}

}