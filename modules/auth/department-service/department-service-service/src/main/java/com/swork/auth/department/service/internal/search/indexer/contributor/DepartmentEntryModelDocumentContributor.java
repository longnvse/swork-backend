package com.swork.auth.department.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.auth.department.service.constant.SearchField;
import com.swork.auth.department.service.model.DepartmentEntry;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = SearchField.INDEXER,
        service = ModelDocumentContributor.class
)
public class DepartmentEntryModelDocumentContributor implements ModelDocumentContributor<DepartmentEntry> {
    @Override
    public void contribute(Document document, DepartmentEntry baseModel) {

        document.addText(SearchField.NAME, baseModel.getName());
        document.addKeywordSortable(SearchField.NAME, baseModel.getName());

//        document.addNumber(SearchField.BUSINESS_ID, baseModel.getBusinessId());
//        document.addKeywordSortable(SearchField.BUSINESS_ID, baseModel.getBusinessId());



    }
}
