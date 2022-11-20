package com.swork.auth.department.rest.test.mockdata;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.auth.department.service.model.DepartmentEntry;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class DepartmentEntryMockData implements DepartmentEntry {
    private long departmentID;
    private long businessId;
    private String name;

    public long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(long departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public long getPrimaryKey() {
        return 0;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {

    }

    @Override
    public String getUuid() {
        return null;
    }

    @Override
    public void setUuid(String uuid) {

    }

    @Override
    public String getExternalReferenceCode() {
        return null;
    }

    @Override
    public void setExternalReferenceCode(String externalReferenceCode) {

    }

    @Override
    public long getDepartmentId() {
        return 0;
    }

    @Override
    public void setDepartmentId(long departmentId) {

    }

    @Override
    public long getGroupId() {
        return 0;
    }

    @Override
    public void setGroupId(long groupId) {

    }

    @Override
    public long getCompanyId() {
        return 0;
    }

    @Override
    public void setCompanyId(long companyId) {

    }

    @Override
    public long getAccountId() {
        return 0;
    }

    @Override
    public void setAccountId(long accountId) {

    }

    @Override
    public Date getCreateDate() {
        return null;
    }

    @Override
    public void setCreateDate(Date createDate) {

    }

    @Override
    public long getModifiedId() {
        return 0;
    }

    @Override
    public void setModifiedId(long modifiedId) {

    }

    @Override
    public Date getModifiedDate() {
        return null;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return null;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {

    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public DepartmentEntry cloneWithOriginalValues() {
        return null;
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
    public CacheModel<DepartmentEntry> toCacheModel() {
        return null;
    }

    @Override
    public DepartmentEntry toEscapedModel() {
        return null;
    }

    @Override
    public DepartmentEntry toUnescapedModel() {
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
    public int compareTo(DepartmentEntry o) {
        return 0;
    }
}
