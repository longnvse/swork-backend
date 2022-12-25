package com.swork.common.file.internal.search.indexer.contributor;

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.swork.common.file.constant.SearchFields;
import com.swork.common.file.model.FileManagerEntry;
import com.swork.common.file.service.FileManagerEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.FILE_MANAGER_INDEXER_CLASS,
        service = ModelIndexerWriterContributor.class
)
public class FileManagerEntryModelIndexerWriterContributor implements ModelIndexerWriterContributor<FileManagerEntry> {
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod(
                (FileManagerEntry entry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(entry)));

    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        fileManagerEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(FileManagerEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private FileManagerEntryLocalService fileManagerEntryLocalService;
}
