package com.swork.core.phase.rest.internal.validator;

import com.liferay.portal.kernel.util.Validator;
import com.swork.common.exception.model.SW_BadRequestException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import com.swork.core.phase.rest.dto.v1_0.Phase;
import com.swork.core.phase.rest.internal.service.LanguageService;
import com.swork.core.phase.rest.internal.util.LanguageKeys;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.service.PhaseEntryLocalService;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.service.ProjectEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Component(
        immediate = true,
        service = PhaseValidator.class
)
public class PhaseValidator {

    private static final String PATTERN = "dd/MM/yyyy";
    private static final int MAX_LENGTH_NAME = 100;
    private static final int MAX_LENGTH_DESCRIPTION = 500;

    public void validatorForAdd(long businessId,
                                Phase phase) throws SW_BadRequestException, ParseException {

        validatorMaxLength(phase);
        validatorNameForAdd(businessId, phase);
        validatorTime(phase);
    }

    public void validatorForUpdate(long businessId,
                                   long phaseId,
                                   Phase phase) throws SW_BadRequestException, ParseException {

        validatorMaxLength(phase);
        validatorNameForUpdate(businessId, phaseId, phase);
        validatorTime(phase);
    }

    public void validatorTime(Phase phase) throws SW_BadRequestException, ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        validatorStartDateForAdd(phase);

        ProjectEntry projectEntry =
                projectEntryLocalService.fetchProjectEntry(phase.getProjectId());

        if (Validator.isNotNull(projectEntry)) {
            if (Validator.isNotNull(projectEntry.getStartDate()) &&
                    Validator.isNotNull(projectEntry.getEndDate())) {
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                if (Validator.isNotNull(phase.getStartDate()) &&
                        Validator.isNotNull(phase.getEndDate())) {

                    String startPhaseString = sdf.format(phase.getStartDate());
                    Date startPhase = sdf.parse(startPhaseString);

                    String endPhaseString = sdf.format(phase.getEndDate());
                    Date endPhase = sdf.parse(endPhaseString);

                    String startProjectString = sdf.format(projectEntry.getStartDate());
                    Date startProject = sdf.parse(startProjectString);

                    String endProjectString = sdf.format(projectEntry.getEndDate());
                    Date endProject = sdf.parse(endProjectString);

                    if (startPhase.compareTo(startProject) >= 0 && startPhase.compareTo(endProject) <= 0) {
                        if (endPhase.compareTo(endProject) <= 0) {
                            atomicBoolean.set(Boolean.TRUE);
                        }
                    }
                }

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
                String startDate = simpleDateFormat.format(projectEntry.getStartDate());
                String endDate = simpleDateFormat.format(projectEntry.getEndDate());

                if (!atomicBoolean.get()) {
                    throw new SW_BadRequestException(
                            languageService
                                    .getMessage(LanguageKeys.PHASE_IS_OUT_OF_PROJECT) +
                                    " (" + startDate + " - " + endDate + ")"
                    );
                }
            }
        }
    }

    private void validatorNameForAdd(long businessId,
                                     Phase phase) throws SW_BadRequestException {


        if (Validator.isNotNull(phase.getName())) {

            PhaseEntry entry =
                    phaseEntryLocalService.getByPhaseName(businessId, phase.getProjectId(), phase.getName().trim());

            if (Validator.isNotNull(entry)) {
                throw new SW_BadRequestException(
                        languageService.getMessage(LanguageKeys.NAME_PHASE_IS_USED));
            }
        }
    }

    private void validatorNameForUpdate(long businessId,
                                        long phaseId,
                                        Phase phase) throws SW_BadRequestException {


        if (Validator.isNotNull(phase.getName())) {
            PhaseEntry entry =
                    phaseEntryLocalService.getByPhaseName(businessId, phase.getProjectId(), phase.getName().trim());

            if (Validator.isNotNull(entry) && !Objects.equals(entry.getPhaseId(), phaseId)) {
                throw new SW_BadRequestException(
                        languageService.getMessage(LanguageKeys.NAME_PHASE_IS_USED));
            }
        }
    }

    private void validatorMaxLength(Phase phase) throws SW_BadRequestException {

        if (phase.getName().length() >= MAX_LENGTH_NAME) {
            throw new SW_BadRequestException(
                    languageService.getMessage(LanguageKeys.NAME_PHASE_TOO_LONG));
        }

        if (Validator.isNotNull(phase.getDescription()) &&
                phase.getDescription().length() >= MAX_LENGTH_DESCRIPTION) {
            throw new SW_BadRequestException(
                    languageService.getMessage(LanguageKeys.DESCRIPTION_PHASE_TOO_LONG));
        }
    }

    private void validatorStartDateForAdd(Phase phase) throws SW_BadRequestException {

        if (phase.getStartDate().after(phase.getEndDate())) {
            throw new SW_BadRequestException(
                    languageService.getMessage(LanguageKeys.START_DATE_AFTER_END_DATE));
        }
    }

    public void validateForExist(long phaseId) throws SW_NoSuchEntryException {
        PhaseEntry entry = phaseEntryLocalService.fetchPhaseEntry(phaseId);

        if (Validator.isNotNull(entry)) {
            return;
        }

        throw new SW_NoSuchEntryException(languageService.getMessage(LanguageKeys.PHASE_NOT_FOUND));
    }

    @Reference
    private LanguageService languageService;
    @Reference
    private ProjectEntryLocalService projectEntryLocalService;
    @Reference
    private PhaseEntryLocalService phaseEntryLocalService;
}
