package com.swork.core.work.rest.internal.validator;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.common.exception.model.SW_BadRequestException;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import com.swork.common.util.api.CommonUtil;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.service.PhaseEntryLocalService;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import com.swork.core.work.rest.dto.v1_0.Work;
import com.swork.core.work.rest.internal.service.LanguageService;
import com.swork.core.work.rest.internal.util.LanguageKeys;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.service.WorkEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

@Component(immediate = true, service = WorkValidator.class)
public class WorkValidator {

    public void validateForAdd(long businessId,
                               Work work) throws SW_FieldRequiredException, SW_BadRequestException, SW_NoSuchEntryException {
        validateForFieldRequire(work);
        validateForExistParent(work);
        validateExistName(businessId, work);
        validateDateInRangeParent(work);
    }

    public void validateForUpdate(long businessId,
                                  long workId,
                                  Work work) throws SW_FieldRequiredException, SW_BadRequestException, SW_NoSuchEntryException {
        validateForFieldRequire(work);
        validateForExist(workId);
        validateForExistParent(work);
        validateExistNameForUpdate(businessId, workId, work);
        validateDateInRangeParent(work);
    }

    public void validateForDelete(long businessId,
                                  long workId) throws SW_BadRequestException, SW_NoSuchEntryException {
        validateForExist(workId);

        validateStatusForDelete(workId);

        validateParentWorkForDelete(businessId, workId);
    }

    private void validateParentWorkForDelete(long businessId,
                                             long workId) throws SW_BadRequestException {
        List<WorkEntry> workEntries = localService.findByParentId(businessId, workId);

        if (workEntries.isEmpty()) {
            return;
        }

        throw new SW_BadRequestException(languageService.getMessage(LanguageKeys.WORK_NOT_FOUND));
    }

    private void validateStatusForDelete(long workId) throws SW_BadRequestException {
        WorkEntry workEntry = localService.fetchWorkEntry(workId);
        if (workEntry.getStatus().equals(Work.Status.DENIED.getValue()) || workEntry.getStatus().equals(Work.Status.PENDING.getValue())) {
            return;
        }

        throw new SW_BadRequestException(languageService.getMessage(LanguageKeys.WORK_CANNOT_DELETE));
    }

    public void validateForExist(long workId) throws SW_NoSuchEntryException {
        WorkEntry workEntry = localService.fetchWorkEntry(workId);

        if (Validator.isNotNull(workEntry)) {
            return;
        }

        throw new SW_NoSuchEntryException(languageService.getMessage(LanguageKeys.WORK_NOT_FOUND));
    }

    private void validateForExistParent(Work work) throws SW_NoSuchEntryException {
        if (Validator.isNotNull(work.getParentId())) {
            WorkEntry workEntry = localService.fetchWorkEntry(work.getParentId());

            if (Validator.isNull(workEntry)) {
                throw new SW_NoSuchEntryException(languageService.getMessage(LanguageKeys.WORK_PARENT_NOT_FOUND));
            }
        }

        if (Validator.isNotNull(work.getPhaseId())) {
            PhaseEntry phaseEntry = phaseEntryLocalService.fetchPhaseEntry(work.getPhaseId());
            if (Validator.isNull(phaseEntry)) {
                throw new SW_NoSuchEntryException(languageService.getMessage(LanguageKeys.WORK_PHASE_NOT_FOUND));
            }
        }

        if (Validator.isNotNull(work.getProjectId())) {
            ProjectEntry projectEntry = projectEntryLocalService.fetchProjectEntry(work.getProjectId());
            if (Validator.isNull(projectEntry)) {
                throw new SW_NoSuchEntryException(languageService.getMessage(LanguageKeys.WORK_PROJECT_NOT_FOUND));
            }
        }
    }

    private void validateExistName(long businessId,
                                   Work work) throws SW_BadRequestException {
        WorkEntry workEntry = localService.findByPID_Name(
                businessId,
                GetterUtil.getLong(work.getParentId()),
                work.getName());

        if (Validator.isNotNull(workEntry)) {
            throw new SW_BadRequestException(languageService.getMessage(LanguageKeys.NAME_EXIST_IN_PARENT));
        }

        if (Validator.isNotNull(work.getProjectId())) {
            workEntry = localService.findByP_Name(
                    GetterUtil.getLong(work.getProjectId()),
                    work.getName()
            );

            if (Validator.isNotNull(workEntry)) {
                throw new SW_BadRequestException(languageService.getMessage(LanguageKeys.NAME_EXIST_IN_PROJECT));
            }
        }
    }

    private void validateExistNameForUpdate(long businessId,
                                            long workId,
                                            Work work) throws SW_BadRequestException {
        WorkEntry workEntry = localService.fetchWorkEntry(workId);

        if (workEntry.getName().equals(work.getName())) {
            return;
        }

        validateExistName(businessId, work);
    }

    private void validateDateInRangeParent(Work work) throws SW_BadRequestException {
        if (Validator.isNotNull(work.getParentId())) {
            WorkEntry workEntry = localService.fetchWorkEntry(work.getParentId());
            validateRangeDate(
                    commonUtil.getStartOfDate(workEntry.getStartDate()),
                    commonUtil.getEndOfDate(workEntry.getEndDate()),
                    work.getStartDate(),
                    work.getEndDate(),
                    LanguageKeys.OUT_OF_DATE_PARENT
            );
        }

        if (Validator.isNotNull(work.getPhaseId())) {
            PhaseEntry phaseEntry = phaseEntryLocalService.fetchPhaseEntry(work.getPhaseId());

            validateRangeDate(
                    commonUtil.getStartOfDate(phaseEntry.getStartDate()),
                    commonUtil.getEndOfDate(phaseEntry.getEndDate()),
                    work.getStartDate(),
                    work.getEndDate(),
                    LanguageKeys.OUT_OF_DATE_PHASE
            );
        }

        if (Validator.isNotNull(work.getProjectId())) {
            ProjectEntry projectEntry = projectEntryLocalService.fetchProjectEntry(work.getProjectId());

            validateRangeDate(
                    commonUtil.getStartOfDate(projectEntry.getStartDate()),
                    commonUtil.getEndOfDate(projectEntry.getEndDate()),
                    work.getStartDate(),
                    work.getEndDate(),
                    LanguageKeys.OUT_OF_DATE_PROJECT
            );
        }
    }

    private void validateRangeDate(Date rangeStartDate,
                                   Date rangeEndDate,
                                   Date startDate,
                                   Date endDate,
                                   String errorMsgKey) throws SW_BadRequestException {
        if (startDate.before(rangeStartDate) || endDate.after(rangeEndDate)) {
            throw new SW_BadRequestException(languageService.getMessage(errorMsgKey));
        }
    }

    private void validateForFieldRequire(Work work) throws SW_FieldRequiredException, SW_BadRequestException {
        isNotPopulated(work.getName(), LanguageKeys.NAME_REQUIRED);
        isNotPopulated(work.getStartDate(), LanguageKeys.START_DATE_REQUIRED);
        isNotPopulated(work.getEndDate(), LanguageKeys.PROGRESS_TYPE_REQUIRED);

        validateWorkDate(work);

    }

    private void validateWorkDate(Work work) throws SW_BadRequestException {
        if (!work.getStartDate().after(work.getEndDate())) {
            return;
        }

        throw new SW_BadRequestException(languageService.getMessage(LanguageKeys.INVALID_DATE));
    }

    private void isNotPopulated(String value,
                                String errorMsgKey) throws SW_FieldRequiredException {

        if (null == value || value.trim().isBlank()) {
            throw new SW_FieldRequiredException(languageService.getMessage(errorMsgKey));
        }
    }

    private void isNotPopulated(Object value,
                                String errorMsgKey) throws SW_FieldRequiredException {

        if (Validator.isNull(value)) {
            throw new SW_FieldRequiredException(languageService.getMessage(errorMsgKey));
        }
    }

    @Reference
    private LanguageService languageService;
    @Reference
    private CommonUtil commonUtil;

    @Reference
    private ProjectEntryLocalService projectEntryLocalService;
    @Reference
    private PhaseEntryLocalService phaseEntryLocalService;
    @Reference
    private WorkEntryLocalService localService;
}
