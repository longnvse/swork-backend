package com.swork.core.resource.rest.internal.validator;

import com.liferay.portal.kernel.util.Validator;
import com.swork.common.exception.model.SW_FieldDuplicateException;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import com.swork.core.resource.rest.dto.v1_0.ResourceType;
import com.swork.core.resource.rest.internal.service.LanguageService;
import com.swork.core.resource.rest.internal.util.LanguageKeys;
import com.swork.core.resource.service.model.ResourceTypeEntry;
import com.swork.core.resource.service.service.ResourceTypeEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ResourceTypeValidator.class)
public class ResourceTypeValidator {
    public void validateForAdd(long businessId,
                               ResourceType dto)
            throws
            SW_FieldRequiredException,
            SW_FieldDuplicateException {

        validateRequiredFields(dto);

        validateDuplicateForAdd(businessId, dto);
    }

    public void validateForUpdate(long businessId,
                                  long resourceTypeId,
                                  ResourceType dto)
            throws SW_FieldRequiredException,
            SW_NoSuchEntryException,
            SW_FieldDuplicateException {

        validateExist(resourceTypeId);

        validateRequiredFields(dto);

        validateDuplicateForUpdate(businessId, resourceTypeId, dto);
    }

    public void validateExist(long resourceTypeId) throws SW_NoSuchEntryException {

        ResourceTypeEntry entry = localService.fetchResourceTypeEntry(resourceTypeId);

        if (Validator.isNotNull(entry)) {
            return;
        }

        throw new SW_NoSuchEntryException(
                languageService.getMessage(
                        LanguageKeys.RESOURCE_TYPE_ENTRY_DOES_NOT_EXIST));
    }

    private void validateDuplicateForAdd(long businessId,
                                         ResourceType dto) throws SW_FieldDuplicateException {
        validateNameDuplicateForAdd(businessId, dto.getName());
    }

    private void validateDuplicateForUpdate(long businessId,
                                            long resourceTypeId,
                                            ResourceType dto) throws SW_FieldDuplicateException {
        validateNameDuplicateForUpdate(businessId, resourceTypeId, dto.getName());
    }

    private void validateNameDuplicateForAdd(long businessId,
                                             String name) throws SW_FieldDuplicateException {
        ResourceTypeEntry entry =
                localService.findByName(businessId, name);

        if (Validator.isNotNull(entry)) {
            throw new SW_FieldDuplicateException(
                    languageService.getMessage(
                            LanguageKeys.RESOURCE_TYPE_NAME_DUPLICATED));
        }
    }

    private void validateNameDuplicateForUpdate(long businessId,
                                                long resourceTypeId,
                                                String name) throws SW_FieldDuplicateException {
        ResourceTypeEntry entry =
                localService.findByName(businessId, name);

        if (Validator.isNull(entry)) return;

        if (resourceTypeId == entry.getResourceTypeId()) return;

        throw new SW_FieldDuplicateException(
                languageService.getMessage(
                        LanguageKeys.RESOURCE_TYPE_NAME_DUPLICATED));
    }

    private void validateRequiredFields(ResourceType dto) throws SW_FieldRequiredException {
        isNotPopulated(
                dto.getName(),
                languageService.getMessage(LanguageKeys.RESOURCE_TYPE_NAME_IS_REQUIRED));

    }

    private void isNotPopulated(String value,
                                String errorMsgKey) throws SW_FieldRequiredException {

        if (null == value || value.trim().isBlank()) {
            throw new SW_FieldRequiredException(languageService.getMessage(errorMsgKey));
        }
    }

    @Reference
    private ResourceTypeEntryLocalService localService;
    @Reference
    private LanguageService languageService;
}
