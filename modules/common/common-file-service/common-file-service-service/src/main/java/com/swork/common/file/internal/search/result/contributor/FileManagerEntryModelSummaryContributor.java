package com.swork.common.file.internal.search.result.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.swork.common.file.constant.SearchFields;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = SearchFields.FILE_MANAGER_INDEXER_CLASS,
        service = ModelSummaryContributor.class
)
public class FileManagerEntryModelSummaryContributor implements ModelSummaryContributor {
    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        Summary summary = new Summary(
                document.get(SearchFields.BUSINESS_ID),
                document.get(SearchFields.FILE_ID));

        summary.setMaxContentLength(200);

        return summary;
    }
}
