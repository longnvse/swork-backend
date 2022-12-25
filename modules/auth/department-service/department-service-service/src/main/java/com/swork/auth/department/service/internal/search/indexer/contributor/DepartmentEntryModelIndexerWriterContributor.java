package com.swork.auth.department.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.swork.auth.department.service.constant.SearchField;
import com.swork.auth.department.service.model.DepartmentEntry;
import com.swork.auth.department.service.service.DepartmentEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchField.INDEXER,
        service = ModelIndexerWriterContributor.class
)
public class DepartmentEntryModelIndexerWriterContributor implements ModelIndexerWriterContributor<DepartmentEntry> {

    @Override
    public IndexerWriterMode getIndexerWriterMode(DepartmentEntry baseModel) {
        return IndexerWriterMode.UPDATE;
    }

    @Override
    public void modelIndexed(DepartmentEntry baseModel) {
        ModelIndexerWriterContributor.super.modelIndexed(baseModel);
    }

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod((DepartmentEntry departmentEntry) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(departmentEntry);

            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(departmentEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(DepartmentEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    private DepartmentEntryLocalService departmentEntryLocalService;

    @Reference
    private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}
