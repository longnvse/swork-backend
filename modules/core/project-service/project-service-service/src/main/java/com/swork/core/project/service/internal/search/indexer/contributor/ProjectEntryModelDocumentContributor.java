package com.swork.core.project.service.internal.search.indexer.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.common.util.api.CommonUtil;
import com.swork.core.project.service.constant.SearchFields;
import com.swork.core.project.service.model.ProjectEntry;
import com.swork.core.project.service.model.ProjectMemberEntry;
import com.swork.core.project.service.model.ProjectMemberEntryModel;
import com.swork.core.project.service.service.ProjectMemberEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Component(
        immediate = true,
        property = SearchFields.PROJECT_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class ProjectEntryModelDocumentContributor
        implements ModelDocumentContributor<ProjectEntry> {

    private final Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

    private static final String ACCOUNT = "account";
    private static final String DEPARTMENT = "department";
    private static final String HANDLE = "handle";
    private static final String PARTICIPATE = "participate";
    private static final String MANAGE = "manage";

    @Override
    public void contribute(Document document, ProjectEntry baseModel) {
        document.addKeyword(SearchFields.BUSINESS_ID, baseModel.getBusinessId());
        document.addKeyword(SearchFields.CREATOR_ID, baseModel.getAccountId());

        document.addKeyword(SearchFields.EXTERNAL_REFERENCE_CODE, baseModel.getExternalReferenceCode());
        document.addKeywordSortable(SearchFields.EXTERNAL_REFERENCE_CODE, baseModel.getExternalReferenceCode());

        document.addKeyword(SearchFields.PROJECT_CODE, baseModel.getCode());
        document.addKeywordSortable(SearchFields.PROJECT_CODE, baseModel.getCode());

        document.addKeyword(SearchFields.PROJECT_NAME, baseModel.getName());
        document.addKeywordSortable(SearchFields.PROJECT_NAME, baseModel.getName());

        document.addKeyword(Field.NAME, baseModel.getName() + StringPool.SPACE +
                commonUtil.vnNormalize(baseModel.getName()));
        document.addKeywordSortable(Field.NAME, baseModel.getName() + StringPool.SPACE +
                commonUtil.vnNormalize(baseModel.getName()));

        document.addNumber(SearchFields.BUDGET, BigDecimal.valueOf(baseModel.getBudget()));
        document.addNumberSortable(SearchFields.BUDGET, BigDecimal.valueOf(baseModel.getBudget()));
        document.addKeywordSortable(SearchFields.BUDGET, String.valueOf(baseModel.getBudget()));

        document.addKeyword(SearchFields.DESCRIPTION, baseModel.getDescription());
        document.addKeywordSortable(SearchFields.DESCRIPTION, baseModel.getDescription());

        document.addDate(SearchFields.START_DATE, baseModel.getStartDate());
        document.addDateSortable(SearchFields.START_DATE, baseModel.getStartDate());

        document.addDate(SearchFields.END_DATE, baseModel.getEndDate());
        document.addDateSortable(SearchFields.END_DATE, baseModel.getEndDate());

        document.addKeyword(SearchFields.PROJECT_MANAGE,
                getMemberIdsByType(baseModel.getProjectId(), ACCOUNT, MANAGE));
        document.addKeywordSortable(SearchFields.PROJECT_MANAGE,
                getMemberIdsByType(baseModel.getProjectId(), ACCOUNT, MANAGE));
        document.addKeyword(SearchFields.STATUS, baseModel.getStatus());
        document.addKeywordSortable(SearchFields.STATUS, baseModel.getStatus());

        document.addKeyword(SearchFields.PROJECT_HANDLE_ACCOUNT,
                getMemberIdsByType(baseModel.getProjectId(), ACCOUNT, HANDLE));
        document.addKeywordSortable(SearchFields.PROJECT_HANDLE_ACCOUNT,
                getMemberIdsByType(baseModel.getProjectId(), ACCOUNT, HANDLE));
        document.addKeyword(SearchFields.PROJECT_HANDLE_DEPARTMENT,
                getMemberIdsByType(baseModel.getProjectId(), DEPARTMENT, HANDLE));
        document.addKeywordSortable(SearchFields.PROJECT_HANDLE_DEPARTMENT,
                getMemberIdsByType(baseModel.getProjectId(), DEPARTMENT, HANDLE));
        document.addKeyword(SearchFields.PROJECT_PARTICIPATE_ACCOUNT,
                getMemberIdsByType(baseModel.getProjectId(), ACCOUNT, PARTICIPATE));
        document.addKeywordSortable(SearchFields.PROJECT_PARTICIPATE_ACCOUNT,
                getMemberIdsByType(baseModel.getProjectId(), ACCOUNT, PARTICIPATE));
        document.addKeyword(SearchFields.PROJECT_PARTICIPATE_DEPARTMENT,
                getMemberIdsByType(baseModel.getProjectId(), DEPARTMENT, PARTICIPATE));
        document.addKeywordSortable(SearchFields.PROJECT_PARTICIPATE_DEPARTMENT,
                getMemberIdsByType(baseModel.getProjectId(), DEPARTMENT, PARTICIPATE));

        document.addDate(SearchFields.ACTUAL_TIME, baseModel.getActualEndDate());
        document.addDateSortable(SearchFields.ACTUAL_TIME, baseModel.getActualEndDate());

        if (Validator.isNotNull(baseModel.getStartDate())) {
            cal.setTime(baseModel.getStartDate());
            document.addNumber(SearchFields.YEAR_START_DATE, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));
            document.addNumberSortable(SearchFields.YEAR_START_DATE, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));
        }

        if (Validator.isNotNull(baseModel.getActualEndDate())) {
            cal.setTime(baseModel.getActualEndDate());
            document.addNumber(SearchFields.YEAR_ACTUAL_TIME, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));
            document.addNumberSortable(SearchFields.YEAR_ACTUAL_TIME, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));
        }

        if (Validator.isNotNull(baseModel.getEndDate())) {
            document.addKeyword(SearchFields.YEAR_MONTH_END_DATE, sdf.format(baseModel.getEndDate()));
            document.addKeywordSortable(SearchFields.YEAR_MONTH_END_DATE, sdf.format(baseModel.getEndDate()));
        }

        document.addNumber(SearchFields.PROGRESS, baseModel.getProgress());
        document.addNumberSortable(SearchFields.PROGRESS, baseModel.getProgress());
    }

    private String getMemberIdsByType(long projectId, String memberType, String type) {
        List<ProjectMemberEntry> projectMemberEntries =
                projectMemberEntryLocalService.findByP_MT_T(projectId, memberType, type);

        return Arrays.toString(projectMemberEntries
                .stream()
                .mapToLong(ProjectMemberEntryModel::getMemberId)
                .boxed()
                .toArray(Long[]::new));
    }

    @Reference
    private ProjectMemberEntryLocalService projectMemberEntryLocalService;
    @Reference
    private CommonUtil commonUtil;
}
