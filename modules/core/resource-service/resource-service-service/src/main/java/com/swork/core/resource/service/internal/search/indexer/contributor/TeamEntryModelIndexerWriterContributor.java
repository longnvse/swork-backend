package com.swork.core.resource.service.internal.search.indexer.contributor;

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.swork.core.resource.service.constant.SearchFields;
import com.swork.core.resource.service.model.TeamEntry;
import com.swork.core.resource.service.service.TeamEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.TEAM_ENTRY_INDEXER_CLASS,
        service = ModelIndexerWriterContributor.class
)
public class TeamEntryModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<TeamEntry> {

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (TeamEntry entry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(entry)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        teamEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(TeamEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private TeamEntryLocalService teamEntryLocalService;
}
