package com.swork.checklist.service.internal.search.result.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.swork.checklist.service.constant.SearchField;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = SearchField.INDEXER,
        service = ModelSummaryContributor.class
)
//class nay chua dung
public class CheckListModelSummaryContributor implements ModelSummaryContributor {

    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        Summary summary = new Summary(
                document.get(Field.NAME),
                document.get(SearchField.NAME));

        summary.setMaxContentLength(200);

        return summary;
    }
}
