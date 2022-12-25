package com.swork.business.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.swork.business.service.constant.SearchField;
import com.swork.business.service.model.BusinessEntry;
import com.swork.business.service.service.BusinessEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchField.INDEXER,
        service = ModelIndexerWriterContributor.class
)
public class BusinessEntryModelIndexerWriterContributor implements ModelIndexerWriterContributor<BusinessEntry> {

    @Override
    public IndexerWriterMode getIndexerWriterMode(BusinessEntry baseModel) {
        return IndexerWriterMode.UPDATE;
    }

    @Override
    public void modelIndexed(BusinessEntry baseModel) {
        ModelIndexerWriterContributor.super.modelIndexed(baseModel);
    }

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod((BusinessEntry customerEntry) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(customerEntry);

            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(businessEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(BusinessEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    private BusinessEntryLocalService businessEntryLocalService;

    @Reference
    private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}
