package com.swork.core.phase.service.internal.search.indexer.contributor;

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.swork.core.phase.service.constant.ClassIndex;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.service.PhaseEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = ClassIndex.PHASE_INDEXER_CLASS,
        service = ModelIndexerWriterContributor.class
)
public class PhaseEntryModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<PhaseEntry> {


    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod(
                (PhaseEntry entry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(entry)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        phaseEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(PhaseEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private PhaseEntryLocalService phaseEntryLocalService;
}
