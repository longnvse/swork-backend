package com.swork.common.comment.service.internal.search.indexer.contributor;

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.swork.common.comment.service.constant.SearchFields;
import com.swork.common.comment.service.model.CommentEntry;
import com.swork.common.comment.service.service.CommentEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.COMMENT_INDEXER_CLASS,
        service = ModelIndexerWriterContributor.class
)
public class CommentEntryModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<CommentEntry> {


    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod(
                (CommentEntry entry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(entry)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        commentEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(CommentEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private CommentEntryLocalService commentEntryLocalService;
}
