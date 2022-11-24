package com.swork.core.resource.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.common.util.api.CommonUtil;
import com.swork.core.resource.service.constant.SearchFields;
import com.swork.core.resource.service.model.ResourceTypeEntry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.RESOURCE_TYPE_ENTRY_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class ResourceTypeEntryModelDocumentContributor
        implements ModelDocumentContributor<ResourceTypeEntry> {

    @Override
    public void contribute(Document document, ResourceTypeEntry baseModel) {

        document.addKeyword(SearchFields.BUSINESS_ID, baseModel.getBusinessId());
        document.addKeyword(SearchFields.CREATOR_ID, baseModel.getAccountId());

        document.addText(SearchFields.NAME, baseModel.getName());
        document.addKeywordSortable(SearchFields.NAME, commonUtil.vnNormalize(baseModel.getName()));

        document.addText(SearchFields.UNIT, baseModel.getUnit());
        document.addKeywordSortable(SearchFields.UNIT, baseModel.getUnit());

        document.addNumber(SearchFields.PARENT_ID, baseModel.getParentId());
        document.addNumberSortable(SearchFields.PARENT_ID, baseModel.getParentId());

        document.addKeyword(SearchFields.RESOURCE_TYPE_NAME, baseModel.getName());
        document.addKeywordSortable(SearchFields.RESOURCE_TYPE_NAME, baseModel.getName());

    }

    @Reference
    private CommonUtil commonUtil;
}
