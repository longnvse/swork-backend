package com.swork.checklist.service.internal.search.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.swork.checklist.service.constant.SearchField;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = SearchField.INDEXER,
        service = KeywordQueryContributor.class
)
public class CheckListEntryKeywordQueryContributor implements KeywordQueryContributor {

    @Reference
    QueryHelper queryHelper;

    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();


        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.NAME, false
        );
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.TASK_ID, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchField.STATUS, true);

    }
}
