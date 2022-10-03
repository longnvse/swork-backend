package com.swork.account.service.internal.search.indexer.contributor;

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.swork.account.service.constant.SearchFields;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.ACCOUNT_INDEXER_CLASS,
        service = ModelIndexerWriterContributor.class
)
public class AccountEntryModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<AccountEntry> {

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (AccountEntry entry) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(entry)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        accountEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(AccountEntry baseModel) {
        return baseModel.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
