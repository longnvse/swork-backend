package com.swork.core.resource.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.core.resource.service.constant.SearchFields;
import com.swork.core.resource.service.model.ResourceEntry;
import org.osgi.service.component.annotations.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component(
        immediate = true,
        property = SearchFields.RESOURCE_ENTRY_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class ResourceEntryModelDocumentContributor
        implements ModelDocumentContributor<ResourceEntry> {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
    private final Calendar cal = Calendar.getInstance();

    private static final String THU = "THU";
    private static final String CHI = "CHI";
    private static final String TAM_UNG = "TAM_UNG";

    @Override
    public void contribute(Document document, ResourceEntry baseModel) {

        document.addKeyword(SearchFields.BUSINESS_ID, baseModel.getBusinessId());
        document.addKeyword(SearchFields.CREATOR_ID, baseModel.getAccountId());

        document.addNumber(SearchFields.WORK_ID, baseModel.getWorkId());
        document.addNumberSortable(SearchFields.WORK_ID, baseModel.getWorkId());
        document.addNumber(SearchFields.PHASE_ID, baseModel.getPhaseId());
        document.addNumberSortable(SearchFields.PHASE_ID, baseModel.getPhaseId());
        document.addNumber(SearchFields.PROJECT_ID, baseModel.getProjectId());
        document.addNumberSortable(SearchFields.PROJECT_ID, baseModel.getProjectId());
        document.addNumber(SearchFields.TEAM_ID, baseModel.getTeamId());
        document.addNumberSortable(SearchFields.TEAM_ID, baseModel.getTeamId());
        document.addNumber(SearchFields.QUANTITY, baseModel.getQuantity());
        document.addNumberSortable(SearchFields.QUANTITY, baseModel.getQuantity());
        document.addKeyword(SearchFields.UNIT, baseModel.getUnit());
        document.addKeywordSortable(SearchFields.UNIT, baseModel.getUnit());
        document.addText(SearchFields.RESOURCE_TYPE_NAME, baseModel.getResourceTypeName());
        document.addKeywordSortable(SearchFields.RESOURCE_TYPE_NAME, baseModel.getResourceTypeName());
        document.addText(SearchFields.TEAM_NAME, baseModel.getTeamName());
        document.addKeywordSortable(SearchFields.TEAM_NAME, baseModel.getTeamName());

        document.addText(SearchFields.TYPE_RESOURCE, getTypeResource(baseModel));
        document.addTextSortable(SearchFields.TYPE_RESOURCE, getTypeResource(baseModel));

        cal.setTime(baseModel.getCreateDate());
        document.addNumber(SearchFields.MONTH, Long.parseLong(String.valueOf(cal.get(Calendar.MONTH) + 1)));
        document.addNumberSortable(SearchFields.MONTH, Long.parseLong(String.valueOf(cal.get(Calendar.MONTH) + 1)));
        document.addNumber(SearchFields.YEAR, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));
        document.addNumberSortable(SearchFields.YEAR, Long.parseLong(String.valueOf(cal.get(Calendar.YEAR))));

        document.addKeyword(SearchFields.YEAR_MONTH, sdf.format(baseModel.getCreateDate()));
        document.addKeywordSortable(SearchFields.YEAR_MONTH, sdf.format(baseModel.getCreateDate()));

        document.addDate(SearchFields.DATE_RESOURCE, baseModel.getDateResource());
        document.addDateSortable(SearchFields.DATE_RESOURCE, baseModel.getDateResource());

        document.addNumber(SearchFields.TOTAL_AMOUNT, baseModel.getTotalAmount());
        document.addNumberSortable(SearchFields.TOTAL_AMOUNT, baseModel.getTotalAmount());
    }

    private String getTypeResource(ResourceEntry resourceEntry) {
        String resourceTypeName = GetterUtil.getString(resourceEntry.getResourceTypeName()).toLowerCase();

        if (resourceTypeName.contains(THU.toLowerCase())) {
            return THU;
        }

        if (resourceTypeName.contains("tạm ứng")) {
            return TAM_UNG;
        }

        return CHI;
    }
}
