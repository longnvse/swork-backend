package com.swork.core.resource.rest.client.dto.v1_0;

import com.swork.core.resource.rest.client.function.UnsafeSupplier;
import com.swork.core.resource.rest.client.serdes.v1_0.TeamSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@Generated("")
public class Team implements Cloneable, Serializable {

	public static Team toDTO(String json) {
		return TeamSerDes.toDTO(json);
	}

	public Admin[] getAdmins() {
		return admins;
	}

	public void setAdmins(Admin[] admins) {
		this.admins = admins;
	}

	public void setAdmins(
		UnsafeSupplier<Admin[], Exception> adminsUnsafeSupplier) {

		try {
			admins = adminsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Admin[] admins;

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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setCreator(
		UnsafeSupplier<String, Exception> creatorUnsafeSupplier) {

		try {
			creator = creatorUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String creator;

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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsActive(
		UnsafeSupplier<Boolean, Exception> isActiveUnsafeSupplier) {

		try {
			isActive = isActiveUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isActive;

	public Member[] getMembers() {
		return members;
	}

	public void setMembers(Member[] members) {
		this.members = members;
	}

	public void setMembers(
		UnsafeSupplier<Member[], Exception> membersUnsafeSupplier) {

		try {
			members = membersUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Member[] members;

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

	public Integer getQuantityMember() {
		return quantityMember;
	}

	public void setQuantityMember(Integer quantityMember) {
		this.quantityMember = quantityMember;
	}

	public void setQuantityMember(
		UnsafeSupplier<Integer, Exception> quantityMemberUnsafeSupplier) {

		try {
			quantityMember = quantityMemberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer quantityMember;

	public Resource[] getResources() {
		return resources;
	}

	public void setResources(Resource[] resources) {
		this.resources = resources;
	}

	public void setResources(
		UnsafeSupplier<Resource[], Exception> resourcesUnsafeSupplier) {

		try {
			resources = resourcesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Resource[] resources;

	public Long getTotalIncoming() {
		return totalIncoming;
	}

	public void setTotalIncoming(Long totalIncoming) {
		this.totalIncoming = totalIncoming;
	}

	public void setTotalIncoming(
		UnsafeSupplier<Long, Exception> totalIncomingUnsafeSupplier) {

		try {
			totalIncoming = totalIncomingUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long totalIncoming;

	public Long getTotalSpending() {
		return totalSpending;
	}

	public void setTotalSpending(Long totalSpending) {
		this.totalSpending = totalSpending;
	}

	public void setTotalSpending(
		UnsafeSupplier<Long, Exception> totalSpendingUnsafeSupplier) {

		try {
			totalSpending = totalSpendingUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long totalSpending;

	@Override
	public Team clone() throws CloneNotSupportedException {
		return (Team)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Team)) {
			return false;
		}

		Team team = (Team)object;

		return Objects.equals(toString(), team.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return TeamSerDes.toJSON(this);
	}

}