package com.swork.core.resource.rest.internal.validator;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.swork.common.exception.model.SW_DataInputException;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import com.swork.core.resource.rest.dto.v1_0.Resource;
import com.swork.core.resource.rest.internal.service.LanguageService;
import com.swork.core.resource.rest.internal.util.LanguageKeys;
import com.swork.core.resource.service.model.ResourceEntry;
import com.swork.core.resource.service.service.ResourceEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ResourceValidator.class)
public class ResourceValidator {
    public void validateForAdd(Resource dto)
            throws
            SW_FieldRequiredException,
            SW_NoSuchEntryException, SW_DataInputException {

        validateRequiredFields(dto);
        validateForExistObjectGroup(dto);

        validateForNegativeNumber(
                GetterUtil.getLong(dto.getQuantity()),
                LanguageKeys.RESOURCE_TASK_QUANTITY_NOT_NEGATIVE);

        validateForNegativeNumber(
                GetterUtil.getLong(dto.getTotalAmount()),
                LanguageKeys.RESOURCE_TASK_TOTAL_MONEY_NOT_NEGATIVE);
    }

    public void validateExist(long resourceId) throws SW_NoSuchEntryException {
        ResourceEntry entry = localService.fetchResourceEntry(resourceId);

        if (Validator.isNotNull(entry)) {
            return;
        }

        throw new SW_NoSuchEntryException(languageService.getMessage(LanguageKeys.RESOURCE_TASK_ENTRY_DOES_NOT_EXIST));

    }

    public void validateForExistObjectGroup(Resource resource) throws SW_NoSuchEntryException {
        if (Validator.isNotNull(resource.getTeamId())) {
            teamValidator.validateExist(resource.getTeamId());
        }
    }

    private void validateRequiredFields(Resource resource) throws SW_FieldRequiredException {

        isNotPopulated(
                resource.getResourceTypeName(),
                languageService.getMessage(LanguageKeys.RESOURCE_TASK_RESOURCE_TYPE_NAME_IS_REQUIRED));
    }

    private void validateForNegativeNumber(long number, String key) throws SW_DataInputException {
        if (number < 0) {
            throw new SW_DataInputException(languageService.getMessage(key));
        }
    }

    private void isNotPopulated(Object value,
                                String errorMsgKey) throws SW_FieldRequiredException {

        if (Validator.isNull(value)) {
            throw new SW_FieldRequiredException(languageService.getMessage(errorMsgKey));
        }
    }

    @Reference
    private ResourceEntryLocalService localService;
    @Reference
    private TeamValidator teamValidator;
    @Reference
    private LanguageService languageService;
}
