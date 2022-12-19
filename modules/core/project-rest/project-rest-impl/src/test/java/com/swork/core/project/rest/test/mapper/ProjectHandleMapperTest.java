package com.swork.core.project.rest.test.mapper;

import com.liferay.petra.string.StringPool;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.model.AccountEntryWrapper;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.core.project.rest.dto.v1_0.Handle;
import com.swork.core.project.rest.internal.mapper.ProjectHandleMapper;
import com.swork.core.project.rest.test.mockdata.HandleMockDataUtil;
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

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProjectHandleMapperTest {
    @Mock
    private AccountEntryLocalService accountEntryLocalService;
    @InjectMocks
    private ProjectHandleMapper projectHandleMapper;


    @Test
    public void testMapDTOFromEntry(){
        ProjectMemberEntry projectMemberEntry=new ProjectMemberEntryWrapper(new ProjectMemberEntryMockData());
        projectMemberEntry.setProjectMemberId(1L);
        projectMemberEntry.setMemberId(1L);
        projectMemberEntry.setMemberType(Handle.MemberType.ACCOUNT.getValue());
        projectMemberEntry.setMemberReferenceCode(("ABC"));
        Handle handle=projectHandleMapper.mapDTOFromEntry(projectMemberEntry);
        assertEquals(projectMemberEntry.getProjectMemberId(),(long) handle.getId());
        assertEquals(projectMemberEntry.getMemberReferenceCode(),handle.getMemberReferenceCode());
    }

    @Test
    public void testMapHandleFromDTO(){
        Handle handle= HandleMockDataUtil.buildHandle();
        ProjectMemberMapperModel projectMemberMapperModel=projectHandleMapper.mapHandleFromDTO(handle);
        assertEquals((long)handle.getMemberId(), projectMemberMapperModel.getMemberId());
        assertEquals(handle.getMemberType().getValue(), projectMemberMapperModel.getMemberType());
    }

//    @Test
//    public void testMapHandlesFromDTO(){
//        Handle[] handles=new Handle[1];
//        handles[0]=HandleMockDataUtil.buildHandle();
//        ProjectMembersMapperModel projectMembersMapperModel=projectHandleMapper.mapHandlesFromDTO(1l,handles);
//        assertEquals((long)handles[0].getMemberId(), projectMembersMapperModel.get(0).getMemberId());
//    }

}
