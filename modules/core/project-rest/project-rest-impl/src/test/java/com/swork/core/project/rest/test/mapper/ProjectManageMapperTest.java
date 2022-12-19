package com.swork.core.project.rest.test.mapper;

import com.liferay.petra.string.StringPool;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.model.AccountEntryWrapper;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.project.rest.dto.v1_0.Handle;
import com.swork.core.project.rest.dto.v1_0.Manage;
import com.swork.core.project.rest.internal.mapper.ProjectManageMapper;
import com.swork.core.project.rest.test.mockdata.AccountEntryMockData;
import com.swork.core.project.rest.test.mockdata.ManageMockDataUtil;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProjectManageMapperTest {
    @Mock
    private AccountEntryLocalService accountEntryLocalService;
    @InjectMocks
    private ProjectManageMapper projectManageMapper;
    @Test
    public void testMapModelFromDTO(){
        Manage manage= ManageMockDataUtil.buildManage();
        ProjectMemberMapperModel projectMemberMapperModel=projectManageMapper.mapModelFromDTO(manage);
        assertEquals((long) manage.getMemberId(),projectMemberMapperModel.getMemberId());
        assertEquals(Handle.MemberType.ACCOUNT.getValue(),projectMemberMapperModel.getMemberType());
    }

    @Test
    public void testMapDTOFromEntry(){
        ProjectMemberEntry projectMemberEntry=new ProjectMemberEntryWrapper(new ProjectMemberEntryMockData());
        projectMemberEntry.setProjectId(1L);
        projectMemberEntry.setMemberType(Handle.MemberType.ACCOUNT.getValue());
        Manage manage=projectManageMapper.mapDTOFromEntry(projectMemberEntry);
        assertEquals( projectMemberEntry.getProjectMemberId(),(long) manage.getId());
        assertEquals( projectMemberEntry.getMemberId(),(long) manage.getMemberId());
    }

    @Test
    public void testMapModelsFromDTO(){
        Manage[] manages=new Manage[1];
        manages[0]=ManageMockDataUtil.buildManage();
        ProjectMembersMapperModel projectMembersMapperModel=projectManageMapper.mapModelsFromDTO(manages);
        assertEquals(projectMembersMapperModel.get(0).getMemberId(),(long) manages[0].getMemberId());
    }

    @Test
    public void testMapModelFromEntries(){
        List<ProjectMemberEntry> projectMemberEntries= new ArrayList<>();

        ProjectMemberEntry projectMemberEntry=new ProjectMemberEntryWrapper(new ProjectMemberEntryMockData());
        projectMemberEntry.setProjectId(1L);
        projectMemberEntry.setMemberType(Handle.MemberType.ACCOUNT.getValue());
        projectMemberEntries.add(projectMemberEntry);
        Manage[] manages=projectManageMapper.mapModelFromEntries(projectMemberEntries);
        assertEquals(projectMemberEntries.get(0).getProjectMemberId(),(long) manages[0].getId());
        assertEquals(projectMemberEntries.get(0).getMemberId(),(long) manages[0].getMemberId());
    }

    @Test
    public void testGetNameByIdWhenFetchAccountNull(){
        when(accountEntryLocalService.fetchAccountEntry(anyLong())).thenReturn(null);
        String result=projectManageMapper.getNameById(anyLong());
        assertEquals(StringPool.BLANK,result);
    }

    @Test
    public void testGetNameByIdWhenFetchAccountNotNull(){
        AccountEntry accountEntry=new AccountEntryWrapper(new AccountEntryMockData());
        accountEntry.setFullName("Nguyen Quoc Dong");
        when(accountEntryLocalService.fetchAccountEntry(anyLong())).thenReturn(accountEntry);
        String result=projectManageMapper.getNameById(anyLong());
        assertEquals(accountEntry.getFullName(),result);
    }
}
