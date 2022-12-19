package com.swork.core.project.rest.test.validator;

import com.liferay.portal.kernel.exception.PortalException;
import com.swork.common.exception.model.SW_BadRequestException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import com.swork.core.project.rest.dto.v1_0.Project;
import com.swork.core.project.rest.internal.service.LanguageService;
import com.swork.core.project.rest.internal.util.CommonConstant;
import com.swork.core.project.rest.internal.validator.ProjectValidator;
import com.swork.core.project.rest.test.mockdata.ProjectEntryMockData;
import com.swork.core.project.rest.test.mockdata.ProjectMockDataUtil;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.model.ProjectEntryWrapper;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProjectValidatorTest {
    @Mock
    private LanguageService _languageService;
    @Mock
    private ProjectEntryLocalService projectEntryLocalService;
    @Rule
    public ExpectedException expected = ExpectedException.none();
    @InjectMocks
    private ProjectValidator projectValidator;

    @Test
    public void testValidatorProjectForAddWhenNameTooLong() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        project.setName("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForAdd(1L, project);
    }

    @Test
    public void testValidatorProjectForAddWhenDescriptionTooLong() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        project.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForAdd(1L, project);
    }

    @Test
    public void testValidatorProjectForAddWhenNameIsUse() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        ProjectEntry projectEntry = new ProjectEntryWrapper(new ProjectEntryMockData());
        when(projectEntryLocalService.getByName(anyLong(), anyString())).thenReturn(projectEntry);
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForAdd(1L, project);
    }

    @Test
    public void testValidatorProjectForAddWhenCodeIsUse() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        ProjectEntry projectEntry = new ProjectEntryWrapper(new ProjectEntryMockData());
        when(projectEntryLocalService.getByCode(anyLong(), anyString())).thenReturn(projectEntry);
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForAdd(1L, project);
    }

    @Test
    public void testValidatorProjectForAddWhenStartDateAfterEndDate() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        project.setStartDate(new Date(2003, 02, 01));
        project.setEndDate(new Date(2000, 01, 01));
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForAdd(1L, project);
    }

    @Test
    public void testValidatorProjectForAddWhenBudgetIsNegativeNumber() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        project.setBudget(-1L);
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForAdd(1L, project);
    }

    @Test
    public void testValidatorProjectForAddWhenBudgetIsTooBig() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        project.setBudget(200000000000000L);
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForAdd(1L, project);
    }

    @Test
    public void testValidatorProjectUpdateAddWhenNameTooLong() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        project.setName("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForUpdate(1L, 1L, project);
    }

    @Test
    public void testValidatorProjectForUpdateWhenDescriptionTooLong() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        project.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForUpdate(1L, 1L, project);
    }

    @Test
    public void testValidatorProjectForUpdateWhenNameIsUse() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        ProjectEntry projectEntry = new ProjectEntryWrapper(new ProjectEntryMockData());
        when(projectEntryLocalService.getByName(anyLong(), anyString())).thenReturn(projectEntry);
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForUpdate(1L, 1L, project);
    }

    @Test
    public void testValidatorProjectForUpdateWhenCodeIsUse() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        ProjectEntry projectEntry = new ProjectEntryWrapper(new ProjectEntryMockData());
        when(projectEntryLocalService.getByCode(anyLong(), anyString())).thenReturn(projectEntry);
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForUpdate(1L, 1L, project);
    }

    @Test
    public void testValidatorProjectForUpdateWhenStartDateAfterEndDate() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        project.setStartDate(new Date(2003, 02, 01));
        project.setEndDate(new Date(2000, 01, 01));
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForUpdate(1L, 1L, project);
    }

    @Test
    public void testValidatorProjectForUpdateWhenBudgetIsNegativeNumber() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        project.setBudget(-1L);
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForUpdate(1L, 1L, project);
    }

    @Test
    public void testValidatorProjectForUpdateWhenBudgetIsTooBig() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        project.setBudget(200000000000000L);
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForUpdate(1L, 1L, project);
    }

    @Test
    public void testValidatorProjectForUpdateWhenStatus() throws SW_BadRequestException {
        Project project = ProjectMockDataUtil.buildProject();
        ProjectEntry projectEntry = new ProjectEntryWrapper(new ProjectEntryMockData());
        projectEntry.setStatus(Project.Status.APPROVED.getValue());
        when(projectEntryLocalService.fetchProjectEntry(anyLong())).thenReturn(projectEntry);
        expected.expect(PortalException.class);
        projectValidator.validatorProjectForUpdate(1L, 1L, project);
    }

    @Test
    public void testValidatorProjectIsExists() throws SW_BadRequestException, SW_NoSuchEntryException {
        when(projectEntryLocalService
                .fetchProjectEntry(anyLong())).thenReturn(null);
        expected.expect(PortalException.class);
        projectValidator.validatorProjectIsExists(1L);
    }
}
