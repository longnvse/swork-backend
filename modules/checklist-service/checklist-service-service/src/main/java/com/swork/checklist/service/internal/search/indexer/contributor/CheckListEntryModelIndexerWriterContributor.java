package com.swork.checklist.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import com.swork.checklist.service.constant.SearchField;
import com.swork.checklist.service.model.ChecklistEntry;
import com.swork.checklist.service.service.ChecklistEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchField.INDEXER,
        service = ModelIndexerWriterContributor.class
)
public class CheckListEntryModelIndexerWriterContributor implements ModelIndexerWriterContributor<ChecklistEntry> {

    @Override
    public IndexerWriterMode getIndexerWriterMode(ChecklistEntry baseModel) {
        return IndexerWriterMode.UPDATE;
    }

    @Override
    public void modelIndexed(ChecklistEntry baseModel) {
        ModelIndexerWriterContributor.super.modelIndexed(baseModel);
    }

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod((ChecklistEntry checklistEntry) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(checklistEntry);

            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(checklistEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(ChecklistEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    private ChecklistEntryLocalService checklistEntryLocalService;

    @Reference
    private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}
