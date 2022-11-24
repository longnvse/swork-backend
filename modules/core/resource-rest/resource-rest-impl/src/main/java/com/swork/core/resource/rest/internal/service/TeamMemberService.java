package com.swork.core.resource.rest.internal.service;

import com.swork.core.resource.rest.dto.v1_0.Admin;
import com.swork.core.resource.rest.dto.v1_0.Member;
import com.swork.core.resource.rest.internal.mapper.TeamMemberMapper;
import com.swork.core.resource.service.service.TeamMemberEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = TeamMemberService.class)
public class TeamMemberService {

    public Member[] getMembersByTeamId(long teamId) {
        return mapper.mapEntriesToMembers(localService.getMembersByTeamId(teamId));
    }

    public Admin[] getAdminsByTeamId(long teamId) {
        return mapper.mapEntriesToAdmins(localService.getAdminsByTeamId(teamId));
    }

    @Reference
    private TeamMemberEntryLocalService localService;

    @Reference
    private TeamMemberMapper mapper;
}
