package com.swork.business.rest.test.mockdata;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.business.service.model.BusinessEntry;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class BusinessEntryMockData implements BusinessEntry {
    private long businessId;
    private String customerName;
    private String phoneNumber;
    private String email;
    private String businessAddress;
    private String name;
    private String fieldOperations;
    private Long logoId;
    private String status;

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

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
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
    public String getUserName() {
        return null;
    }

    @Override
    public void setUserName(String userName) {

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldOperations() {
        return fieldOperations;
    }

    public void setFieldOperations(String fieldOperations) {
        this.fieldOperations = fieldOperations;
    }

    public Long getLogoId() {
        return logoId;
    }

    @Override
    public void setLogoId(Long logoId) {

    }

    public void setLogoId(long logoId) {
        this.logoId = logoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public BusinessEntry cloneWithOriginalValues() {
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
    public CacheModel<BusinessEntry> toCacheModel() {
        return null;
    }

    @Override
    public BusinessEntry toEscapedModel() {
        return null;
    }

    @Override
    public BusinessEntry toUnescapedModel() {
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
    public int compareTo(BusinessEntry o) {
        return 0;
    }
}
