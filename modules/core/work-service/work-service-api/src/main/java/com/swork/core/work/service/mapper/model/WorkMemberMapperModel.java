package com.swork.core.work.service.mapper.model;

public class WorkMemberMapperModel {
    private String memberType;
    private long memberId;
    private String memberReferenceCode;


    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getMemberReferenceCode() {
        return memberReferenceCode;
    }

    public void setMemberReferenceCode(String memberReferenceCode) {
        this.memberReferenceCode = memberReferenceCode;
    }
}
