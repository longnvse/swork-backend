package com.swork.core.resource.rest.internal.validator;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.common.exception.model.SW_BadRequestException;
import com.swork.common.exception.model.SW_FieldDuplicateException;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import com.swork.core.resource.rest.dto.v1_0.Team;
import com.swork.core.resource.rest.internal.service.LanguageService;
import com.swork.core.resource.rest.internal.util.LanguageKeys;
import com.swork.core.resource.service.model.ResourceEntry;
import com.swork.core.resource.service.model.TeamEntry;
import com.swork.core.resource.service.service.ResourceEntryLocalServiceUtil;
import com.swork.core.resource.service.service.TeamEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(immediate = true, service = TeamValidator.class)
public class TeamValidator {

    public void validateForAdd(long businessId,
                               Team dto)
            throws
            SW_FieldRequiredException,
            SW_FieldDuplicateException {

        validateRequiredFields(dto);

        validateDuplicateForAdd(businessId, dto);
    }

    public void validateForUpdate(long businessId,
                                  long teamId,
                                  Team dto)
            throws
            SW_FieldRequiredException,
            SW_FieldDuplicateException, SW_NoSuchEntryException {

        validateExist(teamId);

        validateRequiredFields(dto);

        checkNameDuplicateForUpdate(businessId, teamId, dto);
    }

    public void validateForDelete(long businessId,
                                  long teamId) throws SW_NoSuchEntryException, SW_BadRequestException {
        validateExist(teamId);
        validateDeleteWhenHasResource(businessId, teamId);
    }

    private void validateDeleteWhenHasResource(long businessId,
                                               long teamId) throws SW_BadRequestException {
        List<ResourceEntry> entries = ResourceEntryLocalServiceUtil.getByObjectGroupId(businessId, teamId);

        if (entries.isEmpty()) {
            return;
        }

        throw new SW_BadRequestException(languageService.getMessage(LanguageKeys.TEAM_CANNOT_DELETE_WHEN_HAS_RESOURCE));
    }

    private void validateDuplicateForAdd(long businessId, Team dto) throws SW_FieldDuplicateException {
        checkNameDuplication(businessId, dto);
    }

    private void checkNameDuplicateForUpdate(long businessId, long teamId, Team dto) throws SW_FieldDuplicateException {
        TeamEntry entry = objectGroupTaskEntryLocalService.fetchTeamEntry(teamId);

        if (entry.getName().equals(dto.getName().trim().replaceAll("\\s+", " "))) {
            return;
        }

        checkNameDuplication(businessId, dto);
    }

    public void checkNameDuplication(long businessId,
                                     Team objectGroupTask) throws SW_FieldDuplicateException {
        TeamEntry entry = null;
        long phaseId = GetterUtil.getLong(objectGroupTask.getPhaseId());
        long projectId = GetterUtil.getLong(objectGroupTask.getProjectId());


        if (phaseId != GetterUtil.DEFAULT_LONG) {
            entry = objectGroupTaskEntryLocalService.findNameByPhaseId(
                    businessId,
                    objectGroupTask.getName(),
                    phaseId);
        } else if (projectId != GetterUtil.DEFAULT_LONG) {
            entry = objectGroupTaskEntryLocalService.findNameByProjectId(
                    businessId,
                    objectGroupTask.getName(),
                    projectId
            );
        }

        if (Validator.isNull(entry)) {
            return;
        }

        throw new SW_FieldDuplicateException(
                languageService.getMessage(
                        LanguageKeys.TEAM_NAME_DUPLICATED));
    }

    public void validateExist(long teamId) throws SW_NoSuchEntryException {
        TeamEntry entry = objectGroupTaskEntryLocalService.fetchTeamEntry(teamId);

        if (Validator.isNotNull(entry)) {
            return;
        }

        throw new SW_NoSuchEntryException(languageService.getMessage(LanguageKeys.TEAM_ENTRY_DOES_NOT_EXIST));
    }

    private void validateRequiredFields(Team dto) throws SW_FieldRequiredException {
        isNotPopulated(
                dto.getName(),
                languageService.getMessage(LanguageKeys.TEAM_NAME_IS_REQUIRED));
    }

    private void isNotPopulated(String value,
                                String errorMsgKey) throws SW_FieldRequiredException {

        if (null == value || value.trim().isBlank()) {
            throw new SW_FieldRequiredException(languageService.getMessage(errorMsgKey));
        }
    }

    @Reference
    private TeamEntryLocalService objectGroupTaskEntryLocalService;
    @Reference
    private LanguageService languageService;


}
