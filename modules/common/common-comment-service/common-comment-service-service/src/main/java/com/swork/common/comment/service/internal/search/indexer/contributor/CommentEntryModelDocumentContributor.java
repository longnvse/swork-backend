package com.swork.common.comment.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.common.comment.service.constant.SearchFields;
import com.swork.common.comment.service.model.CommentEntry;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = SearchFields.COMMENT_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class CommentEntryModelDocumentContributor
        implements ModelDocumentContributor<CommentEntry> {
    @Override
    public void contribute(Document document, CommentEntry baseModel) {
        document.addKeyword(SearchFields.BUSINESS_ID, baseModel.getBusinessId());
        document.addKeyword(SearchFields.CREATOR_ID, baseModel.getAccountId());

        document.addText(SearchFields.CONTENT, baseModel.getContent());
        document.addTextSortable(SearchFields.CONTENT, baseModel.getContent());

        document.addKeyword(SearchFields.PARENT_ID, baseModel.getParentId());
        document.addKeyword(SearchFields.CLASS_PK_ID, baseModel.getClassPkId());

        document.addText(SearchFields.CLASS_PK_NAME, baseModel.getClassPKName());
        document.addTextSortable(SearchFields.CLASS_PK_NAME, baseModel.getClassPKName());

    }
}
