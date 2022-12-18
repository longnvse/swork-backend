package com.swork.common.comment.service.internal.search.result.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.swork.common.comment.service.constant.SearchFields;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = SearchFields.COMMENT_INDEXER_CLASS,
        service = ModelSummaryContributor.class
)
public class CommentEntryModelSummaryContributor implements ModelSummaryContributor {
    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        Summary summary = new Summary(
                document.get(SearchFields.CREATOR_ID),
                document.get(SearchFields.CONTENT));

        summary.setMaxContentLength(200);

        return summary;
    }
}
