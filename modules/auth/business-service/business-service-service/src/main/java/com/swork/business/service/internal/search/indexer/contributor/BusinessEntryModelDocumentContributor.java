package com.swork.business.service.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.business.service.constant.SearchField;
import com.swork.business.service.model.BusinessEntry;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = SearchField.INDEXER,
        service = ModelDocumentContributor.class
)
public class BusinessEntryModelDocumentContributor implements ModelDocumentContributor<BusinessEntry> {
    @Override
    public void contribute(Document document, BusinessEntry baseModel) {

        document.addText(SearchField.NAME, baseModel.getName());
        document.addKeywordSortable(SearchField.NAME, baseModel.getName());

        document.addText(SearchField.EMAIL, baseModel.getEmail());
        document.addKeywordSortable(SearchField.EMAIL, baseModel.getEmail());

        document.addText(SearchField.BUSINESS_ADDRESS, baseModel.getBusinessAddress());
        document.addKeywordSortable(SearchField.BUSINESS_ADDRESS, baseModel.getBusinessAddress());

        document.addText(SearchField.PHONE_NUMBER, baseModel.getPhoneNumber());
        document.addKeywordSortable(SearchField.PHONE_NUMBER, baseModel.getPhoneNumber());

        document.addText(SearchField.CUSTOMER_NAME, baseModel.getCustomerName());
        document.addKeywordSortable(SearchField.CUSTOMER_NAME, baseModel.getCustomerName());

        document.addText(SearchField.FIELD_OPERATIONS, baseModel.getFieldOperations());
        document.addKeywordSortable(SearchField.FIELD_OPERATIONS, baseModel.getFieldOperations());

        document.addKeywordSortable(SearchField.STATUS, baseModel.getStatus());
    }
}
