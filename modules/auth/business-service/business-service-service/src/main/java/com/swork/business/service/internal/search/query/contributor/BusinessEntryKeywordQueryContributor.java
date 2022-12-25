package com.swork.business.service.internal.search.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.swork.business.service.constant.SearchField;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchField.INDEXER,
        service = KeywordQueryContributor.class
)
public class BusinessEntryKeywordQueryContributor implements KeywordQueryContributor {

    @Reference
    QueryHelper queryHelper;

    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.FIELD_OPERATIONS, false);
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.NAME, true);
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.BUSINESS_ADDRESS, false);
    }
}
