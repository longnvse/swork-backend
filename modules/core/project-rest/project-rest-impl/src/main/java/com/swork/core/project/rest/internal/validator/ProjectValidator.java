package com.swork.core.project.rest.internal.validator;

import com.liferay.portal.kernel.util.Validator;
import com.swork.common.exception.model.SW_BadRequestException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import com.swork.core.project.rest.dto.v1_0.Project;
import com.swork.core.project.rest.internal.service.LanguageService;
import com.swork.core.project.rest.internal.util.CommonConstant;
import com.swork.core.project.rest.internal.util.LanguageKeys;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = ProjectValidator.class
)
public class ProjectValidator {

    public void validatorProjectForAdd(long businessId,
                                       Project project) throws SW_BadRequestException {

        validatorMaxLength(project);
        validatorNameAndCode(businessId, project);
        validatorDate(project);
        validatorBudget(project);
    }

    public void validatorProjectForUpdate(long businessId,
                                          long projectId,
                                          Project project) throws SW_BadRequestException {

        validatorMaxLength(project);
        validatorNameAndCodeUpdate(businessId, projectId, project);
        validatorDate(project);
        validatorBudget(project);
        validatorStatusForUpdate(projectId);
    }

    public void validatorProjectIsExists(long projectId) throws SW_NoSuchEntryException {

        ProjectEntry entry = projectEntryLocalService
                .fetchProjectEntry(projectId);

        if (Validator.isNotNull(entry)) {
            return;
        }

        throw new SW_NoSuchEntryException(
                languageService.getMessage("project.not.found"));
    }

    public void validatorDeleteProject(long projectId) throws SW_NoSuchEntryException {

        ProjectEntry entry = projectEntryLocalService.fetchProjectEntry(projectId);

        if (entry.getStatus().equals(Project.Status.DENIED.toString())) {
            return;
        }

        throw new SW_NoSuchEntryException(
                languageService.getMessage("project.delete"));
    }

    private void validatorDate(Project project) throws SW_BadRequestException {

        if (Validator.isNotNull(project.getStartDate()) &&
                Validator.isNotNull(project.getEndDate()) &&
                project.getStartDate().after(project.getEndDate())) {

                throw new SW_BadRequestException(
                        languageService.getMessage(LanguageKeys.START_DATE_AFTER_END_DATE));
        }
    }

    public void validatorActualDate(Project project) throws SW_BadRequestException {

        if (Validator.isNotNull(project.getActualStartDate()) &&
                Validator.isNotNull(project.getActualEndDate()) &&
                project.getActualStartDate().after(project.getActualEndDate())) {
            throw new SW_BadRequestException(
                    languageService.getMessage(LanguageKeys.START_DATE_AFTER_END_DATE));
        }
    }

    private void validatorBudget(Project project) throws SW_BadRequestException {

        if (Validator.isNotNull(project.getBudget())) {

            if (project.getBudget() < 0) {
                throw new SW_BadRequestException(
                        languageService.getMessage(LanguageKeys.BUDGET_LESS_THAN_ZERO));
            } else if (project.getBudget() > CommonConstant.MAX_BUDGET) {
                throw new SW_BadRequestException(
                        languageService.getMessage(LanguageKeys.BUDGET_TOO_BIG));
            }
        }
    }

    private void validatorNameAndCode(long businessId,
                                      Project project) throws SW_BadRequestException {


        if (Validator.isNotNull(project.getName())) {
            ProjectEntry entry =
                    projectEntryLocalService.getByName(businessId, project.getName().trim());

            if (Validator.isNotNull(entry)) {
                throw new SW_BadRequestException(
                        languageService.getMessage(LanguageKeys.NAME_IS_USED));
            }
        }
        if (Validator.isNotNull(project.getCode())) {
            ProjectEntry entry =
                    projectEntryLocalService.getByCode(businessId, project.getCode().trim());

            if (Validator.isNotNull(entry)) {
                throw new SW_BadRequestException(
                        languageService.getMessage(LanguageKeys.CODE_IS_USED));
            }
        }
    }

    private void validatorNameAndCodeUpdate(long businessId,
                                            long projectId,
                                            Project project) throws SW_BadRequestException {


        if (Validator.isNotNull(project.getName())) {
            ProjectEntry entry =
                    projectEntryLocalService.getByName(businessId, project.getName().trim());

            if (Validator.isNotNull(entry) && entry.getProjectId() != projectId) {
                throw new SW_BadRequestException(
                        languageService.getMessage(LanguageKeys.NAME_IS_USED));
            }
        }
        if (Validator.isNotNull(project.getCode())) {
            ProjectEntry entry =
                    projectEntryLocalService.getByCode(businessId, project.getCode().trim());

            if (Validator.isNotNull(entry) && entry.getProjectId() != projectId) {
                throw new SW_BadRequestException(
                        languageService.getMessage(LanguageKeys.CODE_IS_USED));
            }
        }
    }

    private void validatorMaxLength(Project project) throws SW_BadRequestException {

        if (Validator.isNotNull(project.getName()) &&
                project.getName().length() >= CommonConstant.MAX_LENGTH_NAME) {
            throw new SW_BadRequestException(
                    languageService.getMessage(LanguageKeys.NAME_PROJECT_TOO_LONG));
        }

        if (Validator.isNotNull(project.getDescription()) &&
                project.getDescription().length() >= CommonConstant.MAX_LENGTH_DESCRIPTION) {
            throw new SW_BadRequestException(
                    languageService.getMessage(LanguageKeys.DESCRIPTION_PROJECT_TOO_LONG));
        }
    }

    public void validatorStatusForUpdate(long projectId) throws SW_BadRequestException {

        ProjectEntry projectEntry = projectEntryLocalService.fetchProjectEntry(projectId);

        if (Validator.isNotNull(projectEntry)) {
            switch (Project.Status.create(projectEntry.getStatus())) {
                case APPROVED:
                case INACTIVE:
                case DENIED:
                    throw new SW_BadRequestException(
                            languageService.getMessage(LanguageKeys.PROJECT_CANNOT_UPDATE));
                default:
                    break;
            }
        }
    }


    @Reference
    private LanguageService languageService;
    @Reference
    private ProjectEntryLocalService projectEntryLocalService;

}
