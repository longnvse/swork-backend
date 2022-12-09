package com.swork.common.file.internal.search.result.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.swork.common.file.constant.SearchField;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = SearchField.FILE_MANAGER_INDEXER_CLASS,
        service = ModelSummaryContributor.class
)
public class FileManagerEntryModelSummaryContributor implements ModelSummaryContributor {
    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        Summary summary = new Summary(
                document.get(SearchField.CUSTOMER_ID),
                document.get(SearchField.FILE_ID));

        summary.setMaxContentLength(200);

        return summary;
    }
}
