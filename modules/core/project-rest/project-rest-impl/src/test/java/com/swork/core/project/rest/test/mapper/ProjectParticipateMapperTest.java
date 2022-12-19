package com.swork.core.project.rest.test.mapper;

import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.model.AccountEntryWrapper;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.project.rest.dto.v1_0.Participate;
import com.swork.core.project.rest.internal.mapper.ProjectHandleMapper;
import com.swork.core.project.rest.internal.mapper.ProjectParticipateMapper;
import com.swork.core.project.rest.test.mockdata.AccountEntryMockData;
import com.swork.core.project.rest.test.mockdata.ParticipateMockDataUtil;
import com.swork.core.project.rest.test.mockdata.ProjectMemberEntryMockData;
import com.swork.core.project.service.mapper.model.ProjectMemberMapperModel;
import com.swork.core.project.service.mapper.model.ProjectMembersMapperModel;
import com.swork.core.project.service.model.ProjectMemberEntry;
import com.swork.core.project.service.model.ProjectMemberEntryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProjectParticipateMapperTest {
    @Mock
    private ProjectHandleMapper projectHandleMapper;
    @Mock
    private AccountEntryLocalService accountEntryLocalService;
    @InjectMocks
    private ProjectParticipateMapper projectParticipateMapper;
    @Test
    public void testMapDTOFromEntry(){
        ProjectMemberEntry projectMemberEntry=new ProjectMemberEntryWrapper(new ProjectMemberEntryMockData());
        projectMemberEntry.setProjectId(1L);
        projectMemberEntry.setMemberId(1L);
        projectMemberEntry.setMemberReferenceCode("ABC");
        projectMemberEntry.setMemberType("account");
        Participate participate=projectParticipateMapper.mapDTOFromEntry(projectMemberEntry);
        assertEquals( projectMemberEntry.getProjectMemberId(),(long) participate.getId());
        assertEquals( projectMemberEntry.getMemberId(),(long) participate.getMemberId());
        assertEquals( projectMemberEntry.getMemberReferenceCode(),participate.getMemberReferenceCode());
        assertEquals( Participate.MemberType.ACCOUNT,participate.getMemberType());
    }

    @Test
    public void testMapModelFromDTO(){
        Participate participate= ParticipateMockDataUtil.buildParticipate();
        ProjectMemberMapperModel projectMemberMapperModel=projectParticipateMapper.mapModelFromDTO(participate);
        assertEquals((long) participate.getMemberId(),projectMemberMapperModel.getMemberId());
        assertEquals("account",projectMemberMapperModel.getMemberType());
        assertEquals(participate.getMemberReferenceCode(),projectMemberMapperModel.getMemberReferenceCode());
    }

//    @Test
//    public void testMapModelsFromDTO(){
//        Participate[] participates=new Participate[1];
//        participates[0]=ParticipateMockDataUtil.buildParticipate();
//        ProjectMembersMapperModel projectMembersMapperModel=projectParticipateMapper.mapModelsFromDTO(1L,participates);
//        assertEquals((long) participates[0].getMemberId(), projectMembersMapperModel.get(0).getMemberId());
//        assertEquals("account", projectMembersMapperModel.get(0).getMemberType());
//        assertEquals(participates[0].getMemberReferenceCode(), projectMembersMapperModel.get(0).getMemberReferenceCode());
//    }

    @Test
    public void testMapDTOFromEntries(){
        List<ProjectMemberEntry> projectMemberEntries=new ArrayList<>();
        ProjectMemberEntry projectMemberEntry=new ProjectMemberEntryWrapper(new ProjectMemberEntryMockData());
        projectMemberEntry.setProjectId(1L);
        projectMemberEntry.setMemberId(1L);
        projectMemberEntry.setMemberReferenceCode("ABC");
        projectMemberEntry.setMemberType("account");
        projectMemberEntries.add(projectMemberEntry);

        Participate[] participates=projectParticipateMapper.mapDTOFromEntries(projectMemberEntries);
        assertEquals( projectMemberEntries.get(0).getProjectMemberId(),(long) participates[0].getId());
        assertEquals( projectMemberEntries.get(0).getMemberId(),(long) participates[0].getMemberId());
        assertEquals( projectMemberEntries.get(0).getMemberReferenceCode(),participates[0].getMemberReferenceCode());
        assertEquals( Participate.MemberType.ACCOUNT,participates[0].getMemberType());
    }

    @Test
    public void testMapMemberFromExtWhenFetchNotNull(){
        AccountEntry accountEntry=new AccountEntryWrapper(new AccountEntryMockData());
        accountEntry.setAccountId(1L);
        when(accountEntryLocalService
                .fetchAccountEntryByExternalReferenceCode(anyLong(), anyString())).thenReturn(accountEntry);
        Participate participate=projectParticipateMapper.mapMemberFromExt(1L,"ABC");
        assertEquals(accountEntry.getAccountId(),(long) participate.getMemberId());
        assertEquals(Participate.MemberType.ACCOUNT,participate.getMemberType());
        assertEquals("ABC", participate.getMemberReferenceCode());
    }

    @Test
    public void testMapMemberFromExtWhenFetchNull(){
        when(accountEntryLocalService
                .fetchAccountEntryByExternalReferenceCode(anyLong(), anyString())).thenReturn(null);
        Participate participate=projectParticipateMapper.mapMemberFromExt(1L,"ABC");
        assertEquals("ABC", participate.getMemberReferenceCode());
    }
}
