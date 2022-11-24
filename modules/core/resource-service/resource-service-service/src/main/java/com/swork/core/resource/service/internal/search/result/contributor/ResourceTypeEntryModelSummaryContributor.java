package com.swork.core.resource.service.internal.search.result.contributor;


import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.swork.core.resource.service.constant.SearchFields;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = SearchFields.RESOURCE_TYPE_ENTRY_INDEXER_CLASS,
        service = ModelSummaryContributor.class
)
public class ResourceTypeEntryModelSummaryContributor implements ModelSummaryContributor {

    @Override
    public Summary getSummary(Document document,
                              Locale locale,
                              String snippet) {

        Summary summary = new Summary(
                document.get(SearchFields.NAME),
                document.get(SearchFields.UNIT));

        summary.setMaxContentLength(200);

        return summary;
    }
}
