package com.swork.core.phase.service.internal.search.indexer.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.common.util.api.CommonUtil;
import com.swork.core.phase.service.constant.ClassIndex;
import com.swork.core.phase.service.constant.SearchFields;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.model.PhaseManageEntry;
import com.swork.core.phase.service.model.PhaseManageEntryModel;
import com.swork.core.phase.service.service.PhaseManageEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        immediate = true,
        property = ClassIndex.PHASE_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class PhaseEntryModelDocumentContributor
        implements ModelDocumentContributor<PhaseEntry> {

    @Override
    public void contribute(Document document, PhaseEntry baseModel) {
        document.addKeyword(SearchFields.BUSINESS_ID, baseModel.getBusinessId());
        document.addKeyword(SearchFields.CREATOR_ID, baseModel.getCreatorId());
        document.addKeyword(SearchFields.EXTERNAL_REFERENCE_CODE, baseModel.getExternalReferenceCode());
        document.addKeywordSortable(SearchFields.EXTERNAL_REFERENCE_CODE, baseModel.getExternalReferenceCode());

        document.addKeyword(SearchFields.STATUS, baseModel.getStatus());
        document.addKeywordSortable(SearchFields.STATUS, baseModel.getStatus());

        document.addKeyword(SearchFields.PHASE_NAME, baseModel.getPhaseName() + StringPool.SPACE +
                commonUtil.vnNormalize(baseModel.getPhaseName()));
        document.addKeywordSortable(SearchFields.PHASE_NAME, baseModel.getPhaseName() + StringPool.SPACE +
                commonUtil.vnNormalize(baseModel.getPhaseName()));

        document.addKeyword(SearchFields.DESCRIPTION, baseModel.getDescription());
        document.addKeywordSortable(SearchFields.DESCRIPTION, baseModel.getDescription());

        document.addNumber(SearchFields.PROJECT_ID, baseModel.getProjectId());
        document.addNumberSortable(SearchFields.PROJECT_ID, baseModel.getProjectId());

        document.addDate(SearchFields.START_DATE, baseModel.getStartDate());
        document.addDateSortable(SearchFields.START_DATE, baseModel.getStartDate());

        document.addDate(SearchFields.END_DATE, baseModel.getEndDate());
        document.addDateSortable(SearchFields.END_DATE, baseModel.getEndDate());

        document.addKeyword(SearchFields.PHASE_MANAGE, getManageIds(baseModel.getPhaseId()));

        document.addKeyword(Field.NAME, baseModel.getPhaseName() + StringPool.SPACE +
                commonUtil.vnNormalize(baseModel.getPhaseName()));
        document.addKeywordSortable(Field.NAME, baseModel.getPhaseName() + StringPool.SPACE +
                commonUtil.vnNormalize(baseModel.getPhaseName()));
    }

    private Long[] getManageIds(long phaseId) {

        List<PhaseManageEntry> phaseManageEntries =
                phaseManageEntryLocalService.findByPhaseId(phaseId);

        if (!phaseManageEntries.isEmpty()) {
            return phaseManageEntries
                    .stream()
                    .map(PhaseManageEntryModel::getAccountId)
                    .toArray(Long[]::new);
        }
        return new Long[0];
    }

    @Reference
    private PhaseManageEntryLocalService phaseManageEntryLocalService;
    @Reference
    private CommonUtil commonUtil;
}
