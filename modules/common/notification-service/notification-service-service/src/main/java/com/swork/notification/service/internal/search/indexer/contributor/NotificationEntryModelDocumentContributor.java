package com.swork.notification.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.notification.service.constant.ClasIndex;
import com.swork.notification.service.constant.SearchFields;
import com.swork.notification.service.model.NotificationEntry;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = ClasIndex.NOTIFICATION_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class NotificationEntryModelDocumentContributor implements ModelDocumentContributor<NotificationEntry> {

    @Override
    public void contribute(Document document, NotificationEntry baseModel) {

        document.addKeyword(SearchFields.CATEGORY, baseModel.getCategory());
        document.addKeywordSortable(SearchFields.CATEGORY, baseModel.getCategory());

        document.addKeyword(Field.NAME, baseModel.getName());
        document.addKeywordSortable(Field.NAME,  baseModel.getName());

        document.addKeyword(SearchFields.DESCRIPTION, baseModel.getDescription());
        document.addKeywordSortable(SearchFields.DESCRIPTION,  baseModel.getDescription());

        document.addDate(SearchFields.TIME,baseModel.getCreateDate());
        document.addDateSortable(SearchFields.TIME,baseModel.getCreateDate());

        document.addNumber(SearchFields.RECEIVER_ID,baseModel.getReceiverId());
        document.addNumberSortable(SearchFields.RECEIVER_ID,baseModel.getReceiverId());

        document.addKeyword(SearchFields.STATUS, baseModel.getStatus());
        document.addKeywordSortable(SearchFields.STATUS,  baseModel.getStatus());

        document.addNumber(SearchFields.SUBJECT_ID,baseModel.getSubjectId());
        document.addNumberSortable(SearchFields.SUBJECT_ID,baseModel.getSubjectId());
    }
}
