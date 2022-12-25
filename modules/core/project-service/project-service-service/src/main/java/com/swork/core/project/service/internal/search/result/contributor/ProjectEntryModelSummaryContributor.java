package com.swork.core.project.service.internal.search.result.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.swork.core.project.service.constant.SearchFields;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = SearchFields.PROJECT_INDEXER_CLASS,
        service = ModelSummaryContributor.class
)
public class ProjectEntryModelSummaryContributor implements ModelSummaryContributor {
    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        Summary summary = new Summary(
                document.get(Field.NAME),
                document.get(SearchFields.PROJECT_NAME));

        summary.setMaxContentLength(200);

        return summary;
    }
}
