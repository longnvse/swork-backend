package com.swork.account.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.account.service.constant.SearchFields;
import com.swork.account.service.model.AccountEntry;
import com.swork.common.util.api.CommonUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.ACCOUNT_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class AccountEntryModelDocumentContributor
        implements ModelDocumentContributor<AccountEntry> {

    @Override
    public void contribute(Document document, AccountEntry baseModel) {
        document.addNumber(SearchFields.BUSINESS_ID, baseModel.getBusinessId());
        document.addText(Field.USER_NAME, baseModel.getUsername());
        document.addText(SearchFields.FULL_NAME, baseModel.getFullName());
        document.addTextSortable(SearchFields.FULL_NAME, baseModel.getFullName());
        document.addText(Field.NAME, commonUtil.vnNormalize(baseModel.getFullName()));
        document.addTextSortable(Field.NAME, commonUtil.vnNormalize(baseModel.getFullName()));
    }

    @Reference
    CommonUtil commonUtil;
}
