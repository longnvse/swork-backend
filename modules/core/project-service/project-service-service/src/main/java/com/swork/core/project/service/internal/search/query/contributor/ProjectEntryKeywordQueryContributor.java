package com.swork.core.project.service.internal.search.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.swork.core.project.service.constant.SearchFields;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchFields.PROJECT_INDEXER_CLASS,
        service = KeywordQueryContributor.class
)
public class ProjectEntryKeywordQueryContributor implements KeywordQueryContributor {

    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.ENTRY_CLASS_PK, false);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.PROJECT_NAME, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.NAME, true);

    }

    @Reference
    protected QueryHelper queryHelper;
}
