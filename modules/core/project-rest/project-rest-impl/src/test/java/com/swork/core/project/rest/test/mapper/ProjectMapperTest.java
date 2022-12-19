package com.swork.core.project.rest.test.mapper;

import com.swork.core.project.rest.dto.v1_0.Project;
import com.swork.core.project.rest.internal.mapper.ProjectHandleMapper;
import com.swork.core.project.rest.internal.mapper.ProjectManageMapper;
import com.swork.core.project.rest.internal.mapper.ProjectMapper;
import com.swork.core.project.rest.internal.mapper.ProjectParticipateMapper;
import com.swork.core.project.rest.test.mockdata.ProjectEntryMockData;
import com.swork.core.project.rest.test.mockdata.ProjectMockDataUtil;
import com.swork.core.project.service.mapper.model.ProjectMapperModel;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.model.ProjectEntryWrapper;
import com.swork.core.project.service.service.ProjectMemberEntryLocalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProjectMapperTest {
    @Mock
    private ProjectHandleMapper projectHandleMapper;
    @Mock
    private ProjectManageMapper projectManageMapper;
    @Mock
    private ProjectParticipateMapper projectParticipateMapper;

    @Mock
    private ProjectMemberEntryLocalService memberEntryLocalService;
    @InjectMocks
    private ProjectMapper projectMapper;
    @Test
    public void testMapModelFromDTO(){
        Project project= ProjectMockDataUtil.buildProject();
        ProjectMapperModel projectMapperModel=projectMapper.mapModelFromDTO(1L,project);
        assertEquals(project.getBudget(),projectMapperModel.getBudget());
        assertEquals(project.getExternalReferenceCode(),projectMapperModel.getExternalReferenceCode());
        assertEquals(project.getDescription(),projectMapperModel.getDescription());
        assertEquals(project.getName(),projectMapperModel.getName());
        assertEquals(project.getCode(),projectMapperModel.getCode());
        assertEquals(project.getStartDate(),projectMapperModel.getStartDate());
        assertEquals(project.getEndDate(),projectMapperModel.getEndDate());
        assertEquals(project.getActualStartDate(),projectMapperModel.getActualStartDate());
        assertEquals(project.getActualEndDate(),projectMapperModel.getActualEndDate());
        assertEquals(project.getProgressType(),projectMapperModel.getProgressType());
    }

    @Test
    public void testMapDTOFromEntry(){
        ProjectEntry projectEntry=new ProjectEntryWrapper(new ProjectEntryMockData());
        projectEntry.setProjectId(1L);
        projectEntry.setName("Project A");
        projectEntry.setCode("ABC");
        projectEntry.setBudget(1L);
        projectEntry.setStartDate(new Date(2003,01,02));
        projectEntry.setEndDate(new Date(2005,01,03));
        projectEntry.setDescription("Description");
        projectEntry.setStatus(Project.Status.INACTIVE.getValue());
        Project project=projectMapper.mapDTOFromEntry(projectEntry);
        assertEquals(projectEntry.getProjectId(),(long)project.getId());
        assertEquals(projectEntry.getName(),project.getName());
        assertEquals(projectEntry.getCode(),project.getCode());
        assertEquals(projectEntry.getBudget(),(long)project.getBudget());
        assertEquals(projectEntry.getStartDate(),project.getStartDate());
        assertEquals(projectEntry.getEndDate(),project.getEndDate());
        assertEquals(projectEntry.getDescription(),project.getDescription());
        assertEquals(projectEntry.getStatus(),project.getStatus().toString());
    }
}
