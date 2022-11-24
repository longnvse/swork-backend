package com.swork.core.resource.service.internal.search.retriever;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.aggregation.AggregationResult;
import com.liferay.portal.search.aggregation.Aggregations;
import com.liferay.portal.search.aggregation.bucket.Bucket;
import com.liferay.portal.search.aggregation.bucket.TermsAggregation;
import com.liferay.portal.search.aggregation.bucket.TermsAggregationResult;
import com.liferay.portal.search.aggregation.metrics.SumAggregation;
import com.liferay.portal.search.aggregation.metrics.SumAggregationResult;
import com.liferay.portal.search.query.MatchQuery;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.query.TermsQuery;
import com.liferay.portal.search.searcher.*;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.core.resource.service.constant.SearchFields;
import com.swork.core.resource.service.internal.search.retriever.mapper.ResourceRetrieverMapper;
import com.swork.core.resource.service.mapper.model.ResourceMapperModel;
import com.swork.core.resource.service.model.ResourceEntry;
import com.swork.core.resource.service.model.ResourceTypeEntry;
import com.swork.core.resource.service.model.TeamEntry;
import com.swork.core.resource.service.retriever.ResourceRetriever;
import com.swork.core.resource.service.service.TeamMemberEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component(
        scope = ServiceScope.PROTOTYPE, service = ResourceRetriever.class
)
public class ResourceRetrieverImpl implements ResourceRetriever {
    @Override
    public Set<Long> setOfResourceTypeByParentId(long customerId,
                                                 Long taskId,
                                                 Long phaseId,
                                                 Long projectId,
                                                 ServiceContext serviceContext) throws ParseException, SearchException {
        SearchContext searchContext = new SearchContext();

        searchContext.setCompanyId(serviceContext.getCompanyId());
        searchContext.setSorts(new Sort(Field.NAME, Sort.STRING_TYPE, false));

        BooleanQuery booleanQuery = buildQuery(customerId, taskId, phaseId, projectId);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return Arrays
                .stream(hits.getDocs())
                .mapToLong(value -> GetterUtil.getLong(value.get(SearchFields.RESOURCE_TYPE_ID)))
                .boxed()
                .collect(Collectors.toSet());
    }

    @Override
    public Document[] getByResourceTypeIdAndParentId(long customerId,
                                                     long resourceTypeId,
                                                     Long taskId,
                                                     Long phaseId,
                                                     Long projectId, ServiceContext serviceContext) throws SearchException {
        SearchContext searchContext = new SearchContext();

        searchContext.setCompanyId(serviceContext.getCompanyId());
        searchContext.setSorts(new Sort(Field.NAME, Sort.STRING_TYPE, false));

        BooleanQuery booleanQuery = buildQuery(customerId, resourceTypeId, taskId, phaseId, projectId);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return hits.getDocs();
    }

    private BooleanQuery buildQuery(long customerId,
                                    Long taskId,
                                    Long phaseId,
                                    Long projectId) {
        TermFilter customerFilter = new TermFilter(SearchFields.BUSINESS_ID, Long.toString(customerId));

        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(customerFilter, BooleanClauseOccur.MUST);

        return buildBooleanQueryByParentId(booleanFilter, taskId, phaseId, projectId);
    }

    private BooleanQuery buildQuery(long customerId,
                                    long resourceTypeId,
                                    Long taskId,
                                    Long phaseId,
                                    Long projectId) {
        TermFilter customerFilter = new TermFilter(SearchFields.BUSINESS_ID, Long.toString(customerId));
        TermFilter resourceTypeFilter = new TermFilter(SearchFields.RESOURCE_TYPE_ID, Long.toString(resourceTypeId));

        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(customerFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(resourceTypeFilter, BooleanClauseOccur.MUST);

        return buildBooleanQueryByParentId(booleanFilter, taskId, phaseId, projectId);
    }

    private BooleanQuery buildBooleanQueryByParentId(BooleanFilter booleanFilter,
                                                     Long taskId,
                                                     Long phaseId,
                                                     Long projectId) {
        BooleanQuery booleanQuery = new BooleanQueryImpl();
        booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, ResourceEntry.class.getName());
        booleanQuery.setPreBooleanFilter(booleanFilter);

        if (GetterUtil.getLong(taskId) != 0) {
            booleanQuery.addRequiredTerm(SearchFields.WORK_ID, taskId);
        }

        if (GetterUtil.getLong(phaseId) != 0) {
            booleanQuery.addRequiredTerm(SearchFields.PHASE_ID, phaseId);
        }

        if (GetterUtil.getLong(projectId) != 0) {
            booleanQuery.addRequiredTerm(SearchFields.PROJECT_ID, projectId);
        }

        return booleanQuery;
    }

    @Override
    public List<ResourceMapperModel> getResourceByProjectOrPhase(long customerId, Long projectId,
                                                                 Long phaseId, String search,
                                                                 Filter filter, Pagination pagination,
                                                                 Sort[] sorts, ServiceContext serviceContext) throws SearchException, ParseException {

        return mapper.mapResourceMapperModelToElastic(
                searchTasks(
                        serviceContext.getCompanyId(),
                        customerId,
                        getLong(projectId, phaseId),
                        getIndexNameResource(projectId, phaseId),
                        getAllTaskByParent(customerId, getLong(projectId, phaseId),
                                getIndexName(projectId, phaseId), SearchFields.TASK_INDEXER_CLASS),
                        Validator.isNotNull(projectId) ? getAllChildPhase(customerId, projectId) : null,
                        search,
                        filter,
                        sorts,
                        pagination.getStartPosition(),
                        pagination.getEndPosition()));
    }

    @Override
    public int countTasks(long companyId, long customerId, Long projectId,
                          Long phaseId, String keyword, Filter filter) throws SearchException, ParseException {


        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(companyId);
        searchContext.setStart(0);
        searchContext.setEnd(1);

        BooleanQuery booleanQuery = buildQueryForAll(customerId, getLong(projectId, phaseId),
                getIndexNameResource(projectId, phaseId),
                getAllTaskByParent(customerId, getLong(projectId, phaseId),
                        getIndexName(projectId, phaseId), SearchFields.TASK_INDEXER_CLASS),
                Validator.isNotNull(projectId) ? getAllChildPhase(customerId, projectId) : null
                , keyword, filter);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return hits.getLength();
    }

    public Document[] searchTasks(long companyId,
                                  long customerId,
                                  Long id,
                                  String indexName,
                                  String[] taskIds,
                                  String[] phaseIds,
                                  String keyword,
                                  Filter filter,
                                  Sort[] sort,
                                  int start,
                                  int end) throws SearchException, ParseException {

        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(companyId);
        searchContext.setStart(start);
        searchContext.setEnd(end);

        if (sort != null) searchContext.setSorts(sort);
        else
            searchContext.setSorts(new Sort("createDate_sortable", true));

        BooleanQuery booleanQuery = buildQueryForAll(customerId, id, indexName, taskIds, phaseIds, keyword, filter);

        Hits hits = IndexSearcherHelperUtil.search(searchContext, booleanQuery);

        return hits.getDocs();
    }

    private BooleanQuery buildQueryForAll(long customerId,
                                          Long id,
                                          String indexName,
                                          String[] taskIds,
                                          String[] phaseIds,
                                          String keyword,
                                          Filter filter) throws ParseException {


        TermFilter customerFilter = new TermFilter(
                SearchFields.BUSINESS_ID, Long.toString(customerId));
        TermFilter classNameFilter = new TermFilter(
                Field.ENTRY_CLASS_NAME, ResourceEntry.class.getName());


        BooleanFilter booleanFilter = new BooleanFilter();

        booleanFilter.add(customerFilter, BooleanClauseOccur.MUST);
        booleanFilter.add(classNameFilter, BooleanClauseOccur.MUST);

        if (Validator.isNotNull(filter)) {
            BooleanFilter statusFilter = new BooleanFilter();

            statusFilter.add(filter, BooleanClauseOccur.SHOULD);

            booleanFilter.add(statusFilter, BooleanClauseOccur.MUST);
        }

        BooleanQuery searchName = new BooleanQueryImpl();

        searchName.addTerm(Field.NAME,
                StringUtil.quote(Validator.isNotNull(keyword) ?
                        keyword : StringPool.BLANK, StringPool.PERCENT), true);

        BooleanQuery query = new BooleanQueryImpl();

        if (taskIds.length > 1000) {

            int lengthTask = taskIds.length;

            int loop = (int) Math.ceil((double) lengthTask / 1000);

            for (int i = 0; i < loop; i++) {
                query.addTerms(new String[]{
                                SearchFields.WORK_ID},
                        Arrays.toString(Arrays.copyOfRange(taskIds, i * 1000, i * 1000 + 1000)));
            }

        } else {
            query.addTerms(new String[]{
                            SearchFields.WORK_ID},
                    Arrays.toString(taskIds));
        }


        if (Validator.isNotNull(phaseIds)) {
            query.addTerms(new String[]{
                            SearchFields.PHASE_ID},
                    Arrays.toString(phaseIds));
        }

        query.addTerms(new String[]{
                indexName}, String.valueOf(id));

        if (Validator.isNotNull(keyword)) {
            query.add(searchName, BooleanClauseOccur.MUST);
        }

        query.setPreBooleanFilter(booleanFilter);

        return query;
    }

    @Override
    public Long ValueResourceType(long customerId, Long projectId, Long phaseId, String code, Boolean checkStatus) {

        List<String> resourceList = getAllResourceByCode(customerId, code);
        SearchResponse searchResponse = searcher.search(
                getSearchRequest(customerId, getLong(projectId, phaseId),
                        resourceList.toArray(new String[0]),
                        getIndexNameResource(projectId, phaseId),
                        getAllTaskByParent(customerId, getLong(projectId, phaseId),
                                getIndexName(projectId, phaseId), SearchFields.TASK_INDEXER_CLASS),
                        getAllChildPhase(customerId, projectId),
                        checkStatus));

        Map<String, AggregationResult> aggregationResultsMap =
                searchResponse.getAggregationResultsMap();

        AggregationResult aggregationResult = aggregationResultsMap.get("resourceTypes");

        TermsAggregationResult termsAggregationResult = (TermsAggregationResult) aggregationResult;

        Collection<Bucket> buckets = termsAggregationResult.getBuckets();

        AtomicReference<Long> along = new AtomicReference<>(0L);

        buckets.forEach(bucket -> {

            AggregationResult aggregationResult1 = bucket.getChildAggregationResult("counts");
            SumAggregationResult sumAggregationResult = (SumAggregationResult) aggregationResult1;

            along.updateAndGet(v -> v + (long) sumAggregationResult.getValue());
        });

        return along.get();

    }

    private SearchRequest getSearchRequest(long customerId,
                                           Long id,
                                           String[] resourceTypeIds,
                                           String indexName,
                                           String[] taskIds,
                                           String[] phaseIds,
                                           Boolean checkStatus) {

        SearchRequestBuilder searchRequestBuilder =
                searchRequestBuilderFactory.builder();

        MatchQuery matchQueryCustomer = queries.match(SearchFields.BUSINESS_ID, customerId);

        com.liferay.portal.search.query.BooleanQuery query1 = queries.booleanQuery();

        MatchQuery matchQueryId = queries.match(indexName, id);

        TermsQuery termsQuery = queries.terms(SearchFields.WORK_ID);

        Stream<String> stream = Arrays.stream(taskIds).distinct();

        termsQuery.addValues(
                stream.map(
                        String::valueOf
                ).toArray(
                        Object[]::new
                ));

        TermsQuery termsQueryPhase = queries.terms(SearchFields.PHASE_ID);

        Stream<String> streamPhase = Arrays.stream(phaseIds).distinct();

        termsQueryPhase.addValues(
                streamPhase.map(
                        String::valueOf
                ).toArray(
                        Object[]::new
                ));

        query1.addShouldQueryClauses(matchQueryId, termsQuery, termsQueryPhase);

        com.liferay.portal.search.query.BooleanQuery query = queries.booleanQuery();

        TermsQuery termsQueryResource = queries.terms(SearchFields.RESOURCE_TYPE_ID);

        Stream<String> streamResource = Arrays.stream(resourceTypeIds).distinct();

        termsQueryResource.addValues(
                streamResource.map(
                        String::valueOf
                ).toArray(
                        Object[]::new
                ));

        if (Boolean.TRUE.equals(checkStatus)) {
            query.addMustQueryClauses(termsQueryResource);
        } else {
            query.addMustNotQueryClauses(termsQueryResource);
        }

        query.addMustQueryClauses(matchQueryCustomer, query1);

        TermsAggregation termsAggregation = aggregations.terms("resourceTypes",
                SearchFields.RESOURCE_TYPE_ID + "_Number_sortable");

        SumAggregation sumAggregation = aggregations.sum("counts",
                SearchFields.TOTAL_AMOUNT + "_Number_sortable");

        termsAggregation.setSize(1000000000);
        termsAggregation.addChildrenAggregations(sumAggregation);

        searchRequestBuilder.entryClassNames(
                ResourceEntry.class.getName()
        ).emptySearchEnabled(
                true
        ).highlightEnabled(
                false
        ).query(query
        ).size(
                0
        ).addAggregation(
                termsAggregation
        ).withSearchContext(
                this::_populateSearchContext
        );

        return searchRequestBuilder.build();
    }

    @Override
    public Long ValueObjectGroup(long customerId, Long projectId, Long phaseId) {

        SearchResponse searchResponse = searcher.search(
                getSearchRequest(customerId, getLong(projectId, phaseId),
                        getIndexNameResource(projectId, phaseId),
                        getAllTaskByParent(customerId, getLong(projectId, phaseId),
                                getIndexName(projectId, phaseId), SearchFields.TASK_INDEXER_CLASS)));

        Map<String, AggregationResult> aggregationResultsMap =
                searchResponse.getAggregationResultsMap();

        AggregationResult aggregationResult = aggregationResultsMap.get("Ids");

        TermsAggregationResult termsAggregationResult = (TermsAggregationResult) aggregationResult;

        Collection<Bucket> buckets = termsAggregationResult.getBuckets();

        AtomicReference<Long> along = new AtomicReference<>(0L);

        buckets.forEach(bucket -> along.set(along.get() +
                localService.getMembersByTeamId(Long.parseLong(bucket.getKey())).size()));

        return along.get();

    }

    private SearchRequest getSearchRequest(long customerId,
                                           Long id,
                                           String indexName,
                                           String[] taskIds) {

        SearchRequestBuilder searchRequestBuilder =
                searchRequestBuilderFactory.builder();

        MatchQuery matchQueryCustomer = queries.match(SearchFields.BUSINESS_ID, customerId);

        com.liferay.portal.search.query.BooleanQuery query1 = queries.booleanQuery();

        MatchQuery matchQueryId = queries.match(indexName, id);

        TermsQuery termsQuery = queries.terms(SearchFields.WORK_ID);

        Stream<String> stream = Arrays.stream(taskIds).distinct();

        termsQuery.addValues(
                stream.map(
                        String::valueOf
                ).toArray(
                        Object[]::new
                ));

        query1.addShouldQueryClauses(matchQueryId, termsQuery);
        com.liferay.portal.search.query.BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQueryCustomer, query1);

        TermsAggregation termsAggregation = aggregations.terms("Ids", Field.ENTRY_CLASS_PK);

        termsAggregation.setSize(1000000000);

        searchRequestBuilder.entryClassNames(
                TeamEntry.class.getName()
        ).emptySearchEnabled(
                true
        ).highlightEnabled(
                false
        ).query(query
        ).size(
                0
        ).addAggregation(
                termsAggregation
        ).withSearchContext(
                this::_populateSearchContext
        );

        return searchRequestBuilder.build();
    }

    private List<String> getAllResourceByCode(long customerId, String code) {
        SearchResponse searchResponse = searcher.search(
                getSearchRequestResourceByCode(customerId, code));

        Map<String, AggregationResult> aggregationResultsMap =
                searchResponse.getAggregationResultsMap();

        AggregationResult aggregationResult = aggregationResultsMap.get("codes");

        TermsAggregationResult termsAggregationResult = (TermsAggregationResult) aggregationResult;

        Collection<Bucket> buckets = termsAggregationResult.getBuckets();

        List<String> along = new ArrayList<>();

        buckets.forEach(bucket -> along.add(bucket.getKey()));

        return along;
    }

    private SearchRequest getSearchRequestResourceByCode(long customerId, String code) {

        SearchRequestBuilder searchRequestBuilder =
                searchRequestBuilderFactory.builder();

        MatchQuery matchQueryCustomer = queries.match(SearchFields.BUSINESS_ID, customerId);
        MatchQuery matchQueryCode = queries.match(SearchFields.CODE, code.toLowerCase());

        com.liferay.portal.search.query.BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQueryCustomer, matchQueryCode);

        TermsAggregation termsAggregation = aggregations.terms("codes", Field.ENTRY_CLASS_PK);

        termsAggregation.setSize(1000000000);

        searchRequestBuilder.entryClassNames(
                ResourceTypeEntry.class.getName()
        ).emptySearchEnabled(
                true
        ).highlightEnabled(
                false
        ).query(query
        ).size(
                0
        ).addAggregation(
                termsAggregation
        ).withSearchContext(
                this::_populateSearchContext
        );

        return searchRequestBuilder.build();
    }

    private String[] getAllTaskByParent(long customerId,
                                        Long id,
                                        String indexName,
                                        String entryClassName) {

        SearchResponse searchResponse = searcher.search(
                _getSearchRequest(customerId, id, indexName, entryClassName));

        Map<String, AggregationResult> aggregationResultsMap =
                searchResponse.getAggregationResultsMap();

        AggregationResult aggregationResult = aggregationResultsMap.get("Ids");

        TermsAggregationResult termsAggregationResult = (TermsAggregationResult) aggregationResult;

        Collection<Bucket> buckets = termsAggregationResult.getBuckets();

        List<String> stringList = new ArrayList<>();

        buckets.forEach(bucket -> stringList.add(bucket.getKey()));

        return stringList.toArray(new String[0]);
    }

    private SearchRequest _getSearchRequest(long customerId,
                                            Long id,
                                            String indexName,
                                            String entryClassName) {

        SearchRequestBuilder searchRequestBuilder =
                searchRequestBuilderFactory.builder();

        MatchQuery matchQueryCustomer = queries.match(SearchFields.BUSINESS_ID, customerId);
        MatchQuery matchQueryId = queries.match(indexName, id);

        com.liferay.portal.search.query.BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQueryCustomer, matchQueryId);

        TermsAggregation termsAggregation = aggregations.terms("Ids", Field.ENTRY_CLASS_PK);

        termsAggregation.setSize(1000000000);

        searchRequestBuilder.entryClassNames(
                entryClassName
        ).emptySearchEnabled(
                true
        ).highlightEnabled(
                false
        ).query(query
        ).size(
                0
        ).addAggregation(
                termsAggregation
        ).withSearchContext(
                this::_populateSearchContext
        );

        return searchRequestBuilder.build();
    }

    private String[] getAllChildPhase(long customerId, Long projectId) {

        SearchResponse searchResponse = searcher.search(
                _getSearchRequestPhase(customerId,
                        projectId));

        Map<String, AggregationResult> aggregationResultsMap =
                searchResponse.getAggregationResultsMap();

        AggregationResult aggregationResult = aggregationResultsMap.get("phaseIds");

        TermsAggregationResult termsAggregationResult = (TermsAggregationResult) aggregationResult;

        Collection<Bucket> buckets = termsAggregationResult.getBuckets();

        List<String> stringList = new ArrayList<>();

        buckets.forEach(bucket -> stringList.add(bucket.getKey()));


        return stringList.toArray(new String[0]);
    }

    private SearchRequest _getSearchRequestPhase(long customerId, Long projectId) {

        SearchRequestBuilder searchRequestBuilder =
                searchRequestBuilderFactory.builder();

        MatchQuery matchQueryCustomer = queries.match(SearchFields.BUSINESS_ID, customerId);
        MatchQuery matchQueryProjectId = queries.match(SearchFields.PROJECT_ID,
                Validator.isNotNull(projectId) ? projectId : "null");

        com.liferay.portal.search.query.BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQueryCustomer, matchQueryProjectId);

        TermsAggregation termsAggregation = aggregations.terms("phaseIds", Field.ENTRY_CLASS_PK);

        termsAggregation.setSize(1000000000);

        searchRequestBuilder.entryClassNames(
                SearchFields.PHASE_INDEXER_CLASS
        ).emptySearchEnabled(
                true
        ).highlightEnabled(
                false
        ).query(query
        ).size(
                0
        ).addAggregation(
                termsAggregation
        ).withSearchContext(
                this::_populateSearchContext
        );

        return searchRequestBuilder.build();
    }


    private void _populateSearchContext(
            SearchContext searchContext) {

        searchContext.setCompanyId(CompanyThreadLocal.getCompanyId());

    }

    private Long getLong(Long projectId, Long phaseId) {

        if (Validator.isNotNull(projectId)) {
            return projectId;
        } else if (Validator.isNotNull(phaseId)) {
            return phaseId;
        }
        return null;
    }

    private String getIndexName(Long projectId, Long phaseId) {
        if (Validator.isNotNull(projectId)) {
            return "project";
        } else if (Validator.isNotNull(phaseId)) {
            return "phase";
        }
        return null;
    }

    private String getIndexNameResource(Long projectId, Long phaseId) {
        if (Validator.isNotNull(projectId)) {
            return SearchFields.PROJECT_ID;
        } else if (Validator.isNotNull(phaseId)) {
            return SearchFields.PHASE_ID;
        }
        return null;
    }

    @Reference
    protected Queries queries;

    @Reference
    private Aggregations aggregations;

    @Reference
    private Searcher searcher;
    @Reference
    private SearchRequestBuilderFactory searchRequestBuilderFactory;

    @Reference
    private ResourceRetrieverMapper mapper;

    @Reference
    private TeamMemberEntryLocalService localService;

}
