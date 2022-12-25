package com.swork.core.resource.service.mapper.model;

import com.liferay.portal.kernel.util.GetterUtil;

public class TeamMemberMapperModel {
    Long memberId;
    String memberName;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = GetterUtil.getLong(memberId);
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
