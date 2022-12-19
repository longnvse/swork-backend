package com.swork.core.project.rest.test.mockdata;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.account.service.model.AccountEntry;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class AccountEntryMockData implements AccountEntry {

    private String fullName;

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
    public long getAccountId() {
        return 0;
    }

    @Override
    public void setAccountId(long accountId) {

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
    public Date getCreateDate() {
        return null;
    }

    @Override
    public void setCreateDate(Date createDate) {

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

    @Override
    public long getCreatorId() {
        return 0;
    }

    @Override
    public void setCreatorId(long creatorId) {

    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public void setUsername(String username) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getPhoneNumber() {
        return null;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {

    }

    @Override
    public Date getDateOfBirth() {
        return null;
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public void setAddress(String address) {

    }

    @Override
    public Long getDepartmentId() {
        return null;
    }

    @Override
    public void setDepartmentId(Long departmentId) {

    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public void setStatus(String status) {

    }

    @Override
    public Long getBusinessId() {
        return null;
    }

    @Override
    public void setBusinessId(Long businessId) {

    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public AccountEntry cloneWithOriginalValues() {
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
    public CacheModel<AccountEntry> toCacheModel() {
        return null;
    }

    @Override
    public AccountEntry toEscapedModel() {
        return null;
    }

    @Override
    public AccountEntry toUnescapedModel() {
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
    public int compareTo(AccountEntry o) {
        return 0;
    }
}
