package com.swork.core.resource.rest.internal.mapper;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.resource.rest.dto.v1_0.Admin;
import com.swork.core.resource.rest.dto.v1_0.Member;
import com.swork.core.resource.service.mapper.model.TeamMemberMapperModel;
import com.swork.core.resource.service.mapper.model.TeamMembersMapperModel;
import com.swork.core.resource.service.model.TeamMemberEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.List;

@Component(
        immediate = true,
        service = TeamMemberMapper.class
)
public class TeamMemberMapper {
    public TeamMemberMapperModel mapDTOToMapperModel(Member from) {
        return mapTeamMemberMapperModel(GetterUtil.getLong(from.getMemberId()), from.getMemberName());
    }

    public TeamMemberMapperModel mapDTOToMapperModel(Admin from) {
        return mapTeamMemberMapperModel(GetterUtil.getLong(from.getMemberId()), from.getMemberName());
    }


    private TeamMemberMapperModel mapTeamMemberMapperModel(Long memberId, String memberName) {
        TeamMemberMapperModel to = new TeamMemberMapperModel();

        to.setMemberId(memberId);

        if (memberId == 0) {
            to.setMemberName(memberName);
        } else {
            AccountEntry entry =
                    accountEntryLocalService.fetchAccountEntry(memberId);

            if (Validator.isNotNull(entry)) {
                to.setMemberName(GetterUtil.getString(entry.getFullName(), memberName));
            }
        }

        return to;
    }

    public TeamMembersMapperModel mapDTOToMapperModels(Member[] from) {
        if (!Validator.isNotNull(from)) {
            return new TeamMembersMapperModel();
        }

        return Arrays
                .stream(from)
                .map(this::mapDTOToMapperModel)
                .collect(
                        TeamMembersMapperModel::new,
                        TeamMembersMapperModel::add,
                        TeamMembersMapperModel::addAll
                );
    }

    public TeamMembersMapperModel mapDTOToMapperModels(Admin[] from) {
        if (!Validator.isNotNull(from)) {
            return new TeamMembersMapperModel();
        }

        return Arrays
                .stream(from)
                .map(this::mapDTOToMapperModel)
                .collect(
                        TeamMembersMapperModel::new,
                        TeamMembersMapperModel::add,
                        TeamMembersMapperModel::addAll
                );
    }

    public Member mapEntryToMember(TeamMemberEntry from) {
        Member to = new Member();

        to.setId(from.getTeamMemberId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setMemberId(from.getMemberId());
        to.setMemberName(from.getMemberName());

        return to;
    }

    public Admin mapEntryToAdmin(TeamMemberEntry from) {
        Admin to = new Admin();

        to.setId(from.getTeamMemberId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setMemberId(from.getMemberId());
        to.setMemberName(from.getMemberName());

        return to;
    }

    public Member[] mapEntriesToMembers(List<TeamMemberEntry> entries) {
        return entries.stream().map(this::mapEntryToMember).toArray(Member[]::new);
    }

    public Admin[] mapEntriesToAdmins(List<TeamMemberEntry> entries) {
        return entries.stream().map(this::mapEntryToAdmin).toArray(Admin[]::new);
    }


    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
