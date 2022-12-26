package com.swork.core.work.rest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
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
@GraphQLName(description = "Work Model", value = "Work")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Work")
public class Work implements Serializable {

	public static Work toDTO(String json) {
		return ObjectMapperUtil.readValue(Work.class, json);
	}

	public static Work unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Work.class, json);
	}

	@Schema
	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	@JsonIgnore
	public void setActualEndDate(
		UnsafeSupplier<Date, Exception> actualEndDateUnsafeSupplier) {

		try {
			actualEndDate = actualEndDateUnsafeSupplier.get();
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
	protected Date actualEndDate;

	@Schema
	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	@JsonIgnore
	public void setActualStartDate(
		UnsafeSupplier<Date, Exception> actualStartDateUnsafeSupplier) {

		try {
			actualStartDate = actualStartDateUnsafeSupplier.get();
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
	protected Date actualStartDate;

	@Schema
	public Integer getAttachNumber() {
		return attachNumber;
	}

	public void setAttachNumber(Integer attachNumber) {
		this.attachNumber = attachNumber;
	}

	@JsonIgnore
	public void setAttachNumber(
		UnsafeSupplier<Integer, Exception> attachNumberUnsafeSupplier) {

		try {
			attachNumber = attachNumberUnsafeSupplier.get();
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
	protected Integer attachNumber;

	@Schema
	public Integer getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
	}

	@JsonIgnore
	public void setCommentNumber(
		UnsafeSupplier<Integer, Exception> commentNumberUnsafeSupplier) {

		try {
			commentNumber = commentNumberUnsafeSupplier.get();
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
	protected Integer commentNumber;

	@Schema
	public Double getComplete() {
		return complete;
	}

	public void setComplete(Double complete) {
		this.complete = complete;
	}

	@JsonIgnore
	public void setComplete(
		UnsafeSupplier<Double, Exception> completeUnsafeSupplier) {

		try {
			complete = completeUnsafeSupplier.get();
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
	protected Double complete;

	@Schema
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@JsonIgnore
	public void setCreateDate(
		UnsafeSupplier<Date, Exception> createDateUnsafeSupplier) {

		try {
			createDate = createDateUnsafeSupplier.get();
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
	protected Date createDate;

	@Schema
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
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
	protected String description;

	@Schema
	public String getDescriptionProgress() {
		return descriptionProgress;
	}

	public void setDescriptionProgress(String descriptionProgress) {
		this.descriptionProgress = descriptionProgress;
	}

	@JsonIgnore
	public void setDescriptionProgress(
		UnsafeSupplier<String, Exception> descriptionProgressUnsafeSupplier) {

		try {
			descriptionProgress = descriptionProgressUnsafeSupplier.get();
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
	protected String descriptionProgress;

	@Schema
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@JsonIgnore
	public void setEndDate(
		UnsafeSupplier<Date, Exception> endDateUnsafeSupplier) {

		try {
			endDate = endDateUnsafeSupplier.get();
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
	protected Date endDate;

	@Schema
	public String getExternalReferenceCode() {
		return externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		this.externalReferenceCode = externalReferenceCode;
	}

	@JsonIgnore
	public void setExternalReferenceCode(
		UnsafeSupplier<String, Exception> externalReferenceCodeUnsafeSupplier) {

		try {
			externalReferenceCode = externalReferenceCodeUnsafeSupplier.get();
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
	protected String externalReferenceCode;

	@Schema
	@Valid
	public Handle[] getHandles() {
		return handles;
	}

	public void setHandles(Handle[] handles) {
		this.handles = handles;
	}

	@JsonIgnore
	public void setHandles(
		UnsafeSupplier<Handle[], Exception> handlesUnsafeSupplier) {

		try {
			handles = handlesUnsafeSupplier.get();
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
	protected Handle[] handles;

	@Schema
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
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
	protected Long id;

	@Schema
	public Double getIncompleteAmount() {
		return incompleteAmount;
	}

	public void setIncompleteAmount(Double incompleteAmount) {
		this.incompleteAmount = incompleteAmount;
	}

	@JsonIgnore
	public void setIncompleteAmount(
		UnsafeSupplier<Double, Exception> incompleteAmountUnsafeSupplier) {

		try {
			incompleteAmount = incompleteAmountUnsafeSupplier.get();
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
	protected Double incompleteAmount;

	@Schema
	@Valid
	public Manage[] getManages() {
		return manages;
	}

	public void setManages(Manage[] manages) {
		this.manages = manages;
	}

	@JsonIgnore
	public void setManages(
		UnsafeSupplier<Manage[], Exception> managesUnsafeSupplier) {

		try {
			manages = managesUnsafeSupplier.get();
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
	protected Manage[] manages;

	@Schema
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@JsonIgnore
	public void setModifiedDate(
		UnsafeSupplier<Date, Exception> modifiedDateUnsafeSupplier) {

		try {
			modifiedDate = modifiedDateUnsafeSupplier.get();
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
	protected Date modifiedDate;

	@Schema
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
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
	protected String name;

	@Schema
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@JsonIgnore
	public void setParentId(
		UnsafeSupplier<Long, Exception> parentIdUnsafeSupplier) {

		try {
			parentId = parentIdUnsafeSupplier.get();
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
	protected Long parentId;

	@Schema
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@JsonIgnore
	public void setParentName(
		UnsafeSupplier<String, Exception> parentNameUnsafeSupplier) {

		try {
			parentName = parentNameUnsafeSupplier.get();
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
	protected String parentName;

	@Schema
	@Valid
	public ParentStatus getParentStatus() {
		return parentStatus;
	}

	@JsonIgnore
	public String getParentStatusAsString() {
		if (parentStatus == null) {
			return null;
		}

		return parentStatus.toString();
	}

	public void setParentStatus(ParentStatus parentStatus) {
		this.parentStatus = parentStatus;
	}

	@JsonIgnore
	public void setParentStatus(
		UnsafeSupplier<ParentStatus, Exception> parentStatusUnsafeSupplier) {

		try {
			parentStatus = parentStatusUnsafeSupplier.get();
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
	protected ParentStatus parentStatus;

	@Schema
	@Valid
	public Participate[] getParticipates() {
		return participates;
	}

	public void setParticipates(Participate[] participates) {
		this.participates = participates;
	}

	@JsonIgnore
	public void setParticipates(
		UnsafeSupplier<Participate[], Exception> participatesUnsafeSupplier) {

		try {
			participates = participatesUnsafeSupplier.get();
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
	protected Participate[] participates;

	@Schema
	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	@JsonIgnore
	public void setPercentage(
		UnsafeSupplier<Double, Exception> percentageUnsafeSupplier) {

		try {
			percentage = percentageUnsafeSupplier.get();
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
	protected Double percentage;

	@Schema
	public Long getPhaseId() {
		return phaseId;
	}

	public void setPhaseId(Long phaseId) {
		this.phaseId = phaseId;
	}

	@JsonIgnore
	public void setPhaseId(
		UnsafeSupplier<Long, Exception> phaseIdUnsafeSupplier) {

		try {
			phaseId = phaseIdUnsafeSupplier.get();
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
	protected Long phaseId;

	@Schema
	public String getPhaseName() {
		return phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	@JsonIgnore
	public void setPhaseName(
		UnsafeSupplier<String, Exception> phaseNameUnsafeSupplier) {

		try {
			phaseName = phaseNameUnsafeSupplier.get();
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
	protected String phaseName;

	@Schema
	public Long getProgress() {
		return progress;
	}

	public void setProgress(Long progress) {
		this.progress = progress;
	}

	@JsonIgnore
	public void setProgress(
		UnsafeSupplier<Long, Exception> progressUnsafeSupplier) {

		try {
			progress = progressUnsafeSupplier.get();
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
	protected Long progress;

	@Schema
	@Valid
	public ProgressType getProgressType() {
		return progressType;
	}

	@JsonIgnore
	public String getProgressTypeAsString() {
		if (progressType == null) {
			return null;
		}

		return progressType.toString();
	}

	public void setProgressType(ProgressType progressType) {
		this.progressType = progressType;
	}

	@JsonIgnore
	public void setProgressType(
		UnsafeSupplier<ProgressType, Exception> progressTypeUnsafeSupplier) {

		try {
			progressType = progressTypeUnsafeSupplier.get();
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
	protected ProgressType progressType;

	@Schema
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@JsonIgnore
	public void setProjectId(
		UnsafeSupplier<Long, Exception> projectIdUnsafeSupplier) {

		try {
			projectId = projectIdUnsafeSupplier.get();
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
	protected Long projectId;

	@Schema
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@JsonIgnore
	public void setProjectName(
		UnsafeSupplier<String, Exception> projectNameUnsafeSupplier) {

		try {
			projectName = projectNameUnsafeSupplier.get();
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
	protected String projectName;

	@Schema
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@JsonIgnore
	public void setStartDate(
		UnsafeSupplier<Date, Exception> startDateUnsafeSupplier) {

		try {
			startDate = startDateUnsafeSupplier.get();
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
	protected Date startDate;

	@Schema
	@Valid
	public Status getStatus() {
		return status;
	}

	@JsonIgnore
	public String getStatusAsString() {
		if (status == null) {
			return null;
		}

		return status.toString();
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonIgnore
	public void setStatus(
		UnsafeSupplier<Status, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
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
	protected Status status;

	@Schema
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@JsonIgnore
	public void setUnit(UnsafeSupplier<String, Exception> unitUnsafeSupplier) {
		try {
			unit = unitUnsafeSupplier.get();
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
	protected String unit;

	@Schema
	@Valid
	public Work[] getWorks() {
		return works;
	}

	public void setWorks(Work[] works) {
		this.works = works;
	}

	@JsonIgnore
	public void setWorks(
		UnsafeSupplier<Work[], Exception> worksUnsafeSupplier) {

		try {
			works = worksUnsafeSupplier.get();
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
	protected Work[] works;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (actualEndDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actualEndDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(actualEndDate));

			sb.append("\"");
		}

		if (actualStartDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actualStartDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(actualStartDate));

			sb.append("\"");
		}

		if (attachNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"attachNumber\": ");

			sb.append(attachNumber);
		}

		if (commentNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commentNumber\": ");

			sb.append(commentNumber);
		}

		if (complete != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"complete\": ");

			sb.append(complete);
		}

		if (createDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(createDate));

			sb.append("\"");
		}

		if (description != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(description));

			sb.append("\"");
		}

		if (descriptionProgress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"descriptionProgress\": ");

			sb.append("\"");

			sb.append(_escape(descriptionProgress));

			sb.append("\"");
		}

		if (endDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"endDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(endDate));

			sb.append("\"");
		}

		if (externalReferenceCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(externalReferenceCode));

			sb.append("\"");
		}

		if (handles != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"handles\": ");

			sb.append("[");

			for (int i = 0; i < handles.length; i++) {
				sb.append(String.valueOf(handles[i]));

				if ((i + 1) < handles.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (incompleteAmount != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"incompleteAmount\": ");

			sb.append(incompleteAmount);
		}

		if (manages != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"manages\": ");

			sb.append("[");

			for (int i = 0; i < manages.length; i++) {
				sb.append(String.valueOf(manages[i]));

				if ((i + 1) < manages.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (modifiedDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(modifiedDate));

			sb.append("\"");
		}

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		if (parentId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentId\": ");

			sb.append(parentId);
		}

		if (parentName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentName\": ");

			sb.append("\"");

			sb.append(_escape(parentName));

			sb.append("\"");
		}

		if (parentStatus != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parentStatus\": ");

			sb.append("\"");

			sb.append(parentStatus);

			sb.append("\"");
		}

		if (participates != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"participates\": ");

			sb.append("[");

			for (int i = 0; i < participates.length; i++) {
				sb.append(String.valueOf(participates[i]));

				if ((i + 1) < participates.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (percentage != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"percentage\": ");

			sb.append(percentage);
		}

		if (phaseId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phaseId\": ");

			sb.append(phaseId);
		}

		if (phaseName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phaseName\": ");

			sb.append("\"");

			sb.append(_escape(phaseName));

			sb.append("\"");
		}

		if (progress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progress\": ");

			sb.append(progress);
		}

		if (progressType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progressType\": ");

			sb.append("\"");

			sb.append(progressType);

			sb.append("\"");
		}

		if (projectId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectId\": ");

			sb.append(projectId);
		}

		if (projectName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectName\": ");

			sb.append("\"");

			sb.append(_escape(projectName));

			sb.append("\"");
		}

		if (startDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(startDate));

			sb.append("\"");
		}

		if (status != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(status);

			sb.append("\"");
		}

		if (unit != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"unit\": ");

			sb.append("\"");

			sb.append(_escape(unit));

			sb.append("\"");
		}

		if (works != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"works\": ");

			sb.append("[");

			for (int i = 0; i < works.length; i++) {
				sb.append(String.valueOf(works[i]));

				if ((i + 1) < works.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.swork.core.work.rest.dto.v1_0.Work",
		name = "x-class-name"
	)
	public String xClassName;

	@GraphQLName("ParentStatus")
	public static enum ParentStatus {

		PENDING("pending"), ACTIVE("active"), COMPLETED("completed"),
		INACTIVE("inactive"), DENIED("denied");

		@JsonCreator
		public static ParentStatus create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (ParentStatus parentStatus : values()) {
				if (Objects.equals(parentStatus.getValue(), value)) {
					return parentStatus;
				}
			}

			throw new IllegalArgumentException("Invalid enum value: " + value);
		}

		@JsonValue
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

	@GraphQLName("ProgressType")
	public static enum ProgressType {

		MANUAL("manual"), BY_CHECKLIST("byChecklist"), BY_AMOUNT("byAmount"),
		BY_PROPORTION("byProportion");

		@JsonCreator
		public static ProgressType create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (ProgressType progressType : values()) {
				if (Objects.equals(progressType.getValue(), value)) {
					return progressType;
				}
			}

			throw new IllegalArgumentException("Invalid enum value: " + value);
		}

		@JsonValue
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

	@GraphQLName("Status")
	public static enum Status {

		PENDING("pending"), ACTIVE("active"), COMPLETED("completed"),
		INACTIVE("inactive"), DENIED("denied");

		@JsonCreator
		public static Status create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (Status status : values()) {
				if (Objects.equals(status.getValue(), value)) {
					return status;
				}
			}

			throw new IllegalArgumentException("Invalid enum value: " + value);
		}

		@JsonValue
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