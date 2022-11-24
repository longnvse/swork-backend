package com.swork.core.resource.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.common.util.api.CommonUtil;
import com.swork.core.resource.service.constant.SearchFields;
import com.swork.core.resource.service.model.TeamEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component(
        immediate = true,
        property = SearchFields.TEAM_ENTRY_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class TeamEntryModelDocumentContributor
        implements ModelDocumentContributor<TeamEntry> {

    private final Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

    @Override
    public void contribute(Document document, TeamEntry baseModel) {
        document.addKeyword(SearchFields.BUSINESS_ID, baseModel.getBusinessId());
        document.addKeyword(SearchFields.CREATOR_ID, baseModel.getAccountId());

        document.addText(SearchFields.NAME, baseModel.getName());
        document.addKeywordSortable(SearchFields.NAME, commonUtil.vnNormalize(baseModel.getName()));

        document.addNumber(SearchFields.PHASE_ID, baseModel.getPhaseId());
        document.addNumberSortable(SearchFields.PHASE_ID, baseModel.getPhaseId());

        document.addNumber(SearchFields.PROJECT_ID, baseModel.getProjectId());
        document.addNumberSortable(SearchFields.PROJECT_ID, baseModel.getProjectId());

        document.addKeyword(SearchFields.TEAM_NAME, baseModel.getName());
        document.addKeywordSortable(SearchFields.TEAM_NAME, baseModel.getName());

        document.addText(SearchFields.IS_ACTIVE, GetterUtil.getString(baseModel.getIsActive()));
        document.addKeywordSortable(SearchFields.IS_ACTIVE, baseModel.getIsActive());

        cal.setTime(baseModel.getCreateDate());
        document.addNumber(SearchFields.MONTH, Long.parseLong(String.valueOf(cal.get(Calendar.MONTH) + 1)));
        document.addNumberSortable(SearchFields.MONTH, Long.parseLong(String.valueOf(cal.get(Calendar.MONTH) + 1)));
        document.addNumber(SearchFields.YEAR, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));
        document.addNumberSortable(SearchFields.YEAR, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));

        document.addKeyword(SearchFields.YEAR_MONTH, sdf.format(baseModel.getCreateDate()));
        document.addKeywordSortable(SearchFields.YEAR_MONTH, sdf.format(baseModel.getCreateDate()));

        document.addNumber(SearchFields.TOTAL_INCOMING, baseModel.getTotalIncoming());
        document.addNumberSortable(SearchFields.TOTAL_INCOMING, baseModel.getTotalIncoming());

        document.addNumber(SearchFields.TOTAL_SPENDING, baseModel.getTotalSpending());
        document.addNumberSortable(SearchFields.TOTAL_SPENDING, baseModel.getTotalSpending());
    }

    @Reference
    private CommonUtil commonUtil;
}
