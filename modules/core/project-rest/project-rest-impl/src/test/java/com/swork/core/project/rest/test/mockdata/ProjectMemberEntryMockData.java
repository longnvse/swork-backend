package com.swork.core.project.rest.test.mockdata;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.core.project.service.model.ProjectMemberEntry;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ProjectMemberEntryMockData implements ProjectMemberEntry {
    private long projectId;
    private long memberId;
    private String memberType;
    private String memberReferenceCode;
    private String type;

    @Override
    public long getPrimaryKey() {
        return 0;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {

    }

    @Override
    public long getProjectMemberId() {
        return 0;
    }

    @Override
    public void setProjectMemberId(long projectMemberId) {

    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberReferenceCode() {
        return memberReferenceCode;
    }

    public void setMemberReferenceCode(String memberReferenceCode) {
        this.memberReferenceCode = memberReferenceCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public ProjectMemberEntry cloneWithOriginalValues() {
        return null;
    }

    @Override
    public Map<String, Function<ProjectMemberEntry, Object>> getAttributeGetterFunctions() {
        return ProjectMemberEntry.super.getAttributeGetterFunctions();
    }

    @Override
    public Map<String, BiConsumer<ProjectMemberEntry, Object>> getAttributeSetterBiConsumers() {
        return ProjectMemberEntry.super.getAttributeSetterBiConsumers();
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return null;
    }

    @Override
    public Class<?> getModelClass() {
        return null;
    }

    @Override
    public String getModelClassName() {
        return null;
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        return null;
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return null;
    }

    @Override
    public boolean isCachedModel() {
        return false;
    }

    @Override
    public boolean isEntityCacheEnabled() {
        return false;
    }

    @Override
    public boolean isEscapedModel() {
        return false;
    }

    @Override
    public boolean isFinderCacheEnabled() {
        return false;
    }

    @Override
    public boolean isNew() {
        return false;
    }

    @Override
    public void resetOriginalValues() {

    }

    @Override
    public void setCachedModel(boolean cachedModel) {

    }

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel) {

    }

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {

    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {

    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {

    }

    @Override
    public void setNew(boolean n) {

    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {

    }

    @Override
    public CacheModel<ProjectMemberEntry> toCacheModel() {
        return null;
    }

    @Override
    public ProjectMemberEntry toEscapedModel() {
        return null;
    }

    @Override
    public ProjectMemberEntry toUnescapedModel() {
        return null;
    }

    @Override
    public String toXmlString() {
        return null;
    }

    @Override
    public void persist() {

    }

    @Override
    public int compareTo(ProjectMemberEntry o) {
        return 0;
    }
}
