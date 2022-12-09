package com.swork.common.file.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.common.file.constant.SearchField;
import com.swork.common.file.model.FileManagerEntry;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = SearchField.FILE_MANAGER_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class FileManagerEntryModelDocumentContributor implements ModelDocumentContributor<FileManagerEntry> {

    @Override
    public void contribute(Document document, FileManagerEntry baseModel) {

        document.addNumber(SearchField.CUSTOMER_ID, baseModel.getCustomerId());
        document.addNumberSortable(SearchField.CUSTOMER_ID, baseModel.getCustomerId());
        document.addNumber(SearchField.FILE_ID, baseModel.getFileId());
        document.addNumberSortable(SearchField.FILE_ID, baseModel.getFileId());

        document.addKeyword(SearchField.PARENT_CODE, baseModel.getParentCode());
        document.addKeywordSortable(SearchField.PARENT_CODE, baseModel.getParentCode());

        document.addKeyword(SearchField.FILE_TYPE, baseModel.getFileType());
        document.addKeywordSortable(SearchField.FILE_TYPE, baseModel.getFileType());


        document.addKeyword(SearchField.PK_TYPE, baseModel.getPkType());
        document.addKeywordSortable(SearchField.PK_TYPE, baseModel.getPkType());

        document.addKeyword(SearchField.FILE_NAME, baseModel.getFileName());
        document.addKeywordSortable(SearchField.FILE_NAME, baseModel.getFileName());

        document.addKeyword(SearchField.FILE_SIZE, baseModel.getFileSize());
        document.addKeywordSortable(SearchField.FILE_SIZE, baseModel.getFileSize());

    }


}
