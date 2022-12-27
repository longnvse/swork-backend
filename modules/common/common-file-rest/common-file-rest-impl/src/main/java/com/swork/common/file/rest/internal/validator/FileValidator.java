package com.swork.common.file.rest.internal.validator;

import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.swork.common.exception.model.SW_BadRequestException;
import com.swork.common.file.rest.internal.service.LanguageService;
import com.swork.common.file.rest.internal.util.LanguageKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = FileValidator.class
)
public class FileValidator {
    public static final long MAX_SIZE_FILE = 10485760;

    public void validateForPostFile(MultipartBody multipartBody) throws SW_BadRequestException {
        long fileSize = multipartBody.getBinaryFile("file").getSize();

        if (fileSize <= MAX_SIZE_FILE) {
            return;
        }

        throw new SW_BadRequestException(languageService.getMessage(LanguageKeys.FILE_INVALID_SIZE));

    }

    @Reference
    LanguageService languageService;
}
