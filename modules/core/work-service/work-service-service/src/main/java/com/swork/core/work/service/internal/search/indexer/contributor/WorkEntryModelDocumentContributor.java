package com.swork.core.work.service.internal.search.indexer.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.common.util.api.CommonUtil;
import com.swork.core.project.service.constant.Type;
import com.swork.core.work.service.constant.SearchFields;
import com.swork.core.work.service.model.WorkEntry;
import com.swork.core.work.service.model.WorkMemberEntry;
import com.swork.core.work.service.model.WorkMemberEntryModel;
import com.swork.core.work.service.service.WorkMemberEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Component(
        immediate = true,
        property = SearchFields.WORK_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class WorkEntryModelDocumentContributor
        implements ModelDocumentContributor<WorkEntry> {
    private final Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
    private static final String ACCOUNT = "account";
    private static final String DEPARTMENT = "department";

    @Override
    public void contribute(Document document, WorkEntry baseModel) {
        document.addKeyword(SearchFields.BUSINESS_ID, baseModel.getBusinessId());
        document.addKeyword(SearchFields.CREATOR_ID, baseModel.getAccountId());
        document.addKeyword(SearchFields.PARENT_ID, baseModel.getParentId());
        document.addKeyword(SearchFields.PROJECT_ID, baseModel.getProjectId());
        document.addKeyword(SearchFields.PHASE_ID, baseModel.getPhaseId());

        document.addKeyword(SearchFields.EXTERNAL_REFERENCE_CODE, baseModel.getExternalReferenceCode());
        document.addKeywordSortable(SearchFields.EXTERNAL_REFERENCE_CODE, baseModel.getExternalReferenceCode());

        document.addKeyword(SearchFields.WORK_NAME, baseModel.getName());
        document.addKeywordSortable(SearchFields.WORK_NAME, baseModel.getName());

        document.addKeyword(Field.NAME, baseModel.getName() + StringPool.SPACE +
                commonUtil.vnNormalize(baseModel.getName()));
        document.addKeywordSortable(Field.NAME, baseModel.getName() + StringPool.SPACE +
                commonUtil.vnNormalize(baseModel.getName()));

        document.addKeyword(SearchFields.DESCRIPTION, baseModel.getDescription());
        document.addKeywordSortable(SearchFields.DESCRIPTION, baseModel.getDescription());

        document.addDate(SearchFields.START_DATE, baseModel.getStartDate());
        document.addDateSortable(SearchFields.START_DATE, baseModel.getStartDate());

        document.addDate(SearchFields.END_DATE, baseModel.getEndDate());
        document.addDateSortable(SearchFields.END_DATE, baseModel.getEndDate());

        document.addKeyword(SearchFields.WORK_MANAGE,
                getMemberIdsByType(baseModel.getWorkId(), ACCOUNT, Type.MANAGE.getValue()));

        document.addKeyword(SearchFields.STATUS, baseModel.getStatus());
        document.addKeywordSortable(SearchFields.STATUS, baseModel.getStatus());

        document.addKeyword(SearchFields.WORK_HANDLE_ACCOUNT,
                getMemberIdsByType(baseModel.getWorkId(), ACCOUNT, Type.HANDLE.getValue()));
        document.addKeyword(SearchFields.WORK_HANDLE_DEPARTMENT,
                getMemberIdsByType(baseModel.getWorkId(), DEPARTMENT, Type.HANDLE.getValue()));

        document.addKeyword(SearchFields.WORK_PARTICIPATE_ACCOUNT,
                getMemberIdsByType(baseModel.getWorkId(), ACCOUNT, Type.PARTICIPATE.getValue()));
        document.addKeyword(SearchFields.WORK_PARTICIPATE_DEPARTMENT,
                getMemberIdsByType(baseModel.getWorkId(), DEPARTMENT, Type.PARTICIPATE.getValue()));

        document.addDate(SearchFields.ACTUAL_START_DATE, baseModel.getActualEndDate());
        document.addDateSortable(SearchFields.ACTUAL_START_DATE, baseModel.getActualEndDate());

        if (Validator.isNotNull(baseModel.getStartDate())) {
            cal.setTime(baseModel.getStartDate());
            document.addNumber(SearchFields.YEAR_START_DATE, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));
            document.addNumberSortable(SearchFields.YEAR_START_DATE, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));
        }

        if (Validator.isNotNull(baseModel.getActualEndDate())) {
            cal.setTime(baseModel.getActualEndDate());
            document.addNumber(SearchFields.YEAR_ACTUAL_START_DATE, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));
            document.addNumberSortable(SearchFields.YEAR_ACTUAL_START_DATE, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));
        }

        if (Validator.isNotNull(baseModel.getEndDate())) {
            document.addKeyword(SearchFields.YEAR_MONTH_END_DATE, sdf.format(baseModel.getEndDate()));
            document.addKeywordSortable(SearchFields.YEAR_MONTH_END_DATE, sdf.format(baseModel.getEndDate()));
        }

        document.addNumber(SearchFields.PROGRESS, baseModel.getProgress());
        document.addNumberSortable(SearchFields.PROGRESS, baseModel.getProgress());
    }

    private Long[] getMemberIdsByType(long workId, String memberType, String type) {
        List<WorkMemberEntry> workMemberEntries =
                workMemberEntryLocalService.findByW_MT_T(workId, memberType, type);

        return workMemberEntries
                .stream()
                .mapToLong(WorkMemberEntryModel::getMemberId)
                .boxed()
                .toArray(Long[]::new);
    }

    @Reference
    private WorkMemberEntryLocalService workMemberEntryLocalService;
    @Reference
    private CommonUtil commonUtil;
}
