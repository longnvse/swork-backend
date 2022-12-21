package com.swork.notification.service.internal.search.result.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.swork.notification.service.constant.ClasIndex;
import com.swork.notification.service.constant.SearchFields;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = ClasIndex.NOTIFICATION_INDEXER_CLASS,
        service = ModelSummaryContributor.class
)
public class NotificationEntryModelSummaryContributor implements ModelSummaryContributor {

    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        Summary summary = new Summary(
                document.get(Field.NAME),
                document.get(SearchFields.DESCRIPTION));

        summary.setMaxContentLength(200);

        return summary;
    }
}
