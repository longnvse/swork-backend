package com.swork.common.file.internal.search.indexer.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.swork.common.file.constant.SearchFields;
import com.swork.common.file.model.FileManagerEntry;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = SearchFields.FILE_MANAGER_INDEXER_CLASS,
        service = ModelDocumentContributor.class
)
public class FileManagerEntryModelDocumentContributor implements ModelDocumentContributor<FileManagerEntry> {

    @Override
    public void contribute(Document document, FileManagerEntry baseModel) {

        document.addNumber(SearchFields.BUSINESS_ID, baseModel.getBusinessId());
        document.addKeyword(SearchFields.CREATOR_ID, baseModel.getAccountId());
        document.addKeyword(SearchFields.PROJECT_ID, baseModel.getProjectId());
        document.addKeyword(SearchFields.PHASE_ID, baseModel.getPhaseId());
        document.addKeyword(SearchFields.WORK_ID, baseModel.getWorkId());
        document.addKeyword(SearchFields.MODULE_ID, baseModel.getModuleId());
        document.addKeyword(SearchFields.APP_ID, baseModel.getAppId());

        document.addNumber(SearchFields.FILE_ID, baseModel.getFileId());
        document.addNumberSortable(SearchFields.FILE_ID, baseModel.getFileId());

        document.addKeyword(SearchFields.FILE_TYPE, baseModel.getFileType());
        document.addKeywordSortable(SearchFields.FILE_TYPE, baseModel.getFileType());

        document.addKeyword(SearchFields.FILE_NAME, baseModel.getFileName());
        document.addKeywordSortable(SearchFields.FILE_NAME, baseModel.getFileName());
    }
}
