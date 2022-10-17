package com.swork.checklist.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.checklist.service.constant.SearchField;
import com.swork.checklist.service.model.ChecklistEntry;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = SearchField.INDEXER,
        service = ModelDocumentContributor.class
)
public class CheckListEntryModelDocumentContributor implements ModelDocumentContributor<ChecklistEntry> {
    @Override
    public void contribute(Document document, ChecklistEntry baseModel) {

        document.addText(SearchField.NAME, baseModel.getName());
        document.addKeywordSortable(SearchField.NAME, baseModel.getName());

        document.addNumber(SearchField.TASK_ID, baseModel.getTaskId());
        document.addNumberSortable(SearchField.TASK_ID, baseModel.getTaskId());

        document.addKeyword(SearchField.STATUS, baseModel.getStatus());
        document.addKeywordSortable(SearchField.STATUS, baseModel.getStatus());


    }
}
