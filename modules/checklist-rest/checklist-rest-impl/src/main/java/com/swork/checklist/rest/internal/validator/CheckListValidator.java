package com.swork.checklist.rest.internal.validator;

import com.liferay.portal.kernel.util.Validator;
import com.swork.checklist.rest.dto.v1_0.CheckList;
import com.swork.checklist.service.model.ChecklistEntry;
import com.swork.checklist.service.service.ChecklistEntryLocalService;
import com.swork.common.exception.model.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component(
        immediate = true,
        service = CheckListValidator.class
)
public class CheckListValidator {
//    public static final String VALID_DATE_REGEX = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";

    public void validatorForPostChecklist(CheckList checkList) throws SW_DataInputException, SW_FieldRequiredException, SW_NameDuplicateException {
        validatorFieldsForUpdateCheckList(checkList);
        validatorNameIsExist(checkList.getName());
    }

    private void validatorRegexField(String value,
                                     String pattern,
                                     String errorMsg) throws SW_DataInputException {
        Pattern pt = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pt.matcher(value);

        if (matcher.find()) return;

        throw new SW_DataInputException(errorMsg);
    }

    public void validatorForPutChecklist(long cid, CheckList checkList) throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException, SW_NoSuchEntryException, SW_NameDuplicateException {

        validatorChecklistIsExists(cid);

        validatorFieldsForUpdateCheckList(checkList);

        validatorNameIsExist(checkList.getName());
    }


    private void validatorFieldsForUpdateCheckList(CheckList checkList) throws SW_FieldRequiredException, SW_DataInputException {

        validateRequireField(checkList);
//        validatorRegexField(checkList.getStartDate(),
//                VALID_DATE_REGEX,
//                "Start date wrong format");
//        validatorRegexField(checkList.getEndDate(),
//                VALID_DATE_REGEX,
//                "End date wrong format");

    }

    public void validatorChecklistIsExists(long cid) throws SW_NoSuchEntryException {

        ChecklistEntry checklistEntry = checklistEntryLocalService.fetchChecklistEntry(cid);

        if (checklistEntry != null) return;

        throw new SW_NoSuchEntryException("không tồn tại");
    }

    public void validateRequireField(CheckList checkList) throws SW_FieldRequiredException {
        isNotPopulated(checkList.getName(), "Name can not be empty");
        isNotPopulated(checkList.getStartDate().toString(),"Startdate can not be empty");
        isNotPopulated(checkList.getEndDate().toString(),"Enddate can not be empty");
    }

    private void validatorNameIsExist(String value) throws SW_NameDuplicateException {
        ChecklistEntry checklistEntry = checklistEntryLocalService.findByName(value);

        if (Validator.isNull(checklistEntry)) return;
        throw new SW_NameDuplicateException("Tên đã được sử dụng");
    }

    private void isNotPopulated(String value, String errorMsgKey) throws SW_FieldRequiredException {

        if (null == value || value.trim().isEmpty()) {
            throw new SW_FieldRequiredException(errorMsgKey);
        }
    }

    @Reference
    private ChecklistEntryLocalService checklistEntryLocalService;

}
