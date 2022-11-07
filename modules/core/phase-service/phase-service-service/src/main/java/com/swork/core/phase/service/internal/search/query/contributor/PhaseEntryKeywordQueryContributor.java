package com.swork.core.phase.service.internal.search.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.swork.core.phase.service.constant.ClassIndex;
import com.swork.core.phase.service.constant.SearchFields;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = ClassIndex.PHASE_INDEXER_CLASS,
        service = KeywordQueryContributor.class
)
public class PhaseEntryKeywordQueryContributor implements KeywordQueryContributor {


    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.ENTRY_CLASS_PK, false);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, SearchFields.PHASE_NAME, true);
    }

    @Reference
    protected QueryHelper queryHelper;
}

