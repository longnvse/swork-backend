package com.swork.core.phase.rest.test.mockdata;


import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.swork.core.phase.service.model.PhaseManageEntry;

import java.io.Serializable;
import java.util.Map;

public class PhaseManageEntryMockData implements PhaseManageEntry {
    private long phaseManageId;
    private long phaseId;
    private long accountId;

    @Override
    public long getPrimaryKey() {
        return 0;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {

    }

    public long getPhaseManageId() {
        return phaseManageId;
    }

    public void setPhaseManageId(long phaseManageId) {
        this.phaseManageId = phaseManageId;
    }

    public long getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(long phaseId) {
        this.phaseId = phaseId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public PhaseManageEntry cloneWithOriginalValues() {
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
    public CacheModel<PhaseManageEntry> toCacheModel() {
        return null;
    }

    @Override
    public PhaseManageEntry toEscapedModel() {
        return null;
    }

    @Override
    public PhaseManageEntry toUnescapedModel() {
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
    public int compareTo(PhaseManageEntry o) {
        return 0;
    }
}
