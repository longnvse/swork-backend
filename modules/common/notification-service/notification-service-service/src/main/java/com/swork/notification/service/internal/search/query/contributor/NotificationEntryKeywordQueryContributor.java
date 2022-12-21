package com.swork.notification.service.internal.search.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.swork.notification.service.constant.ClasIndex;
import com.swork.notification.service.constant.SearchFields;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = ClasIndex.NOTIFICATION_INDEXER_CLASS,
        service = KeywordQueryContributor.class
)
public class NotificationEntryKeywordQueryContributor implements KeywordQueryContributor {

    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {

        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.ENTRY_CLASS_PK, false);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.CATEGORY, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.NAME, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.DESCRIPTION, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.TIME, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.DO_ENTRY_ID, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.TASK_INSTANCE_ID, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.RECEIVER_ID, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.CREATOR_ID, true);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.STATUS, true);
    }

    @Reference
    protected QueryHelper queryHelper;
}
