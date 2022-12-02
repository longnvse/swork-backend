package com.swork.core.project.service.internal.retriever;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.aggregation.AggregationResult;
import com.liferay.portal.search.aggregation.Aggregations;
import com.liferay.portal.search.aggregation.bucket.Bucket;
import com.liferay.portal.search.aggregation.bucket.TermsAggregation;
import com.liferay.portal.search.aggregation.bucket.TermsAggregationResult;
import com.liferay.portal.search.aggregation.metrics.SumAggregation;
import com.liferay.portal.search.aggregation.metrics.SumAggregationResult;
import com.liferay.portal.search.query.*;
import com.liferay.portal.search.searcher.*;
import com.liferay.portal.search.sort.FieldSort;
import com.liferay.portal.search.sort.SortOrder;
import com.liferay.portal.search.sort.Sorts;
import com.swork.core.project.service.constant.SearchFields;
import com.swork.core.project.service.mapper.DashboardMapper;
import com.swork.core.project.service.mapper.model.ChartMapperModel;
import com.swork.core.project.service.retriever.DashboardRetriever;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component(
        scope = ServiceScope.PROTOTYPE, service = DashboardRetriever.class
)
public class DashboardRetrieverImpl implements DashboardRetriever {
    private static final String[] STATUS_KEY =
            {"pending", "doing", "unevaluated", "evaluated", "approved", "inactive", "denied"};
    private static final String THU = "THU";
    private static final String TU = "TAM_UNG";
    private static final String CHI = "CHI";
    private static final String COUNTS = "counts";
    private final Calendar calendar = Calendar.getInstance();
    DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("yyyyMMdd");
    DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("yyyyMM");
    DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy");

    @Override
    public List<ChartMapperModel> getStatusTask(long businessId, long projectId) {

        SearchResponse searchResponse = searcher.search(
                getSearchRequestStatus(businessId, projectId));

        Map<String, AggregationResult> aggregationResultsMap =
                searchResponse.getAggregationResultsMap();

        AggregationResult aggregationResult = aggregationResultsMap.get(SearchFields.STATUS);

        TermsAggregationResult termsAggregationResult = (TermsAggregationResult) aggregationResult;

        Collection<Bucket> buckets = termsAggregationResult.getBuckets();

        HashMap<String, Long> keyValueStatus = new HashMap<>();

        Arrays.stream(STATUS_KEY).forEach(s -> keyValueStatus.put(s, GetterUtil.DEFAULT_LONG));

        buckets.forEach(bucket -> keyValueStatus.put(bucket.getKey(), bucket.getDocCount()));

        return mapper.mapStatusTask(keyValueStatus);

    }

    @Override
    public List<ChartMapperModel> getTeamInOut(long businessId, long projectId) {
        Long budget = getBudget(businessId, projectId);

        HashMap<String, Double> hashMapThu = getThuChi(businessId, projectId, THU);

        HashMap<String, Double> hashMapChi = getThuChi(businessId, projectId, CHI);

        return mapper.mapTeam(hashMapThu, hashMapChi, budget);
    }

    @Override
    public Map<String, Double> getProjectResource(long businessId, long projectId) {
        Long budget = getBudget(businessId, projectId);


        Double thu = getValueByTypeResource(businessId, projectId, THU);
        Double tu = getValueByTypeResource(businessId, projectId, TU);
        Double chi = getValueByTypeResource(businessId, projectId, CHI);

        TreeMap<String, Double> keyValue = new TreeMap<>();

        if (budget == 0) {
            keyValue.put("NS", GetterUtil.DEFAULT_DOUBLE);
            keyValue.put("Thu", GetterUtil.DEFAULT_DOUBLE);
            keyValue.put("Chi", GetterUtil.DEFAULT_DOUBLE);
            keyValue.put("Tu", GetterUtil.DEFAULT_DOUBLE);
        } else {
            keyValue.put("NS", budget + thu - (tu + chi));
            keyValue.put("Thu", thu);
            keyValue.put("Chi", chi);
            keyValue.put("Tu", tu);

        }

        return keyValue;

    }

    @Override
    public ChartMapperModel getBurnDownTask(long businessId,
                                            long projectId,
                                            String status,
                                            Boolean checkStatus) {
        Long startDate = getDate(businessId, projectId, SearchFields.START_DATE_SORT);
        Long endDate = getDate(businessId, projectId, SearchFields.END_DATE_SORT);

        if (Validator.isNull(startDate) && Validator.isNull(endDate)) {
            return new ChartMapperModel();
        }
        if (startDate == 0 && endDate == 0)
            return new ChartMapperModel();

        calendar.setTimeInMillis(startDate);
        Date dateStart = calendar.getTime();
        calendar.setTimeInMillis(endDate);
        Date dateEnd = calendar.getTime();

        LocalDate startDateCalculate =
                Instant.ofEpochMilli(startDate)
                        .atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDateCalculate =
                Instant.ofEpochMilli(endDate)
                        .atZone(ZoneId.systemDefault()).toLocalDate();

        String startDateRange = startDateCalculate.format(formatterDay);
        String endDateRange = endDateCalculate.format(formatterDay);

        if (!endDateCalculate.isBefore(LocalDate.now())) {
            endDateCalculate = LocalDate.now();
            endDateRange = LocalDate.now().format(formatterDay);
        }


        Long dateDiff = TimeUnit.MILLISECONDS.toDays(
                dateEnd.getTime() - dateStart.getTime()) + 1;
        String buketIndex = getBuketIndex(dateDiff, checkStatus);

        SearchResponse searchResponse = searcher.search(
                getSearchRequestBurnDown(businessId, projectId, buketIndex,
                        status, checkStatus, startDateRange, endDateRange));

        Map<String, AggregationResult> aggregationResultsMap =
                searchResponse.getAggregationResultsMap();

        AggregationResult aggregationResult = aggregationResultsMap.get("obj");

        TermsAggregationResult termsAggregationResult = (TermsAggregationResult) aggregationResult;

        Collection<Bucket> buckets = termsAggregationResult.getBuckets();

        TreeMap<String, Long> treeMap = new TreeMap<>();
        getBuketIndexHashMap(dateDiff, startDateCalculate, endDateCalculate, treeMap);

        buckets.forEach(bucket -> treeMap.put(bucket.getKey(), bucket.getDocCount()));

        return mapper.mapChartMapperModelNew(treeMap, getUnit(dateDiff));

    }

    private String getBuketIndex(Long dateDiff, Boolean checkStatus) {
        if (dateDiff <= 31) {
            return Boolean.TRUE.equals(checkStatus) ? SearchFields.YEAR_MONTH_DAY_ACTUAL_TIME_SORT : SearchFields.YEAR_MONTH_DAY_START_DATE_SORT;
        } else if (dateDiff <= 93) {
            return Boolean.TRUE.equals(checkStatus) ? SearchFields.YEAR_MONTH_WEEK_ACTUAL_TIME_SORT : SearchFields.YEAR_MONTH_WEEK_START_DATE_SORT;
        } else if (dateDiff <= 372) {
            return Boolean.TRUE.equals(checkStatus) ? SearchFields.YEAR_MONTH_ACTUAL_TIME_SORT : SearchFields.YEAR_MONTH_SORT;
        } else if (dateDiff <= 1860) {
            return Boolean.TRUE.equals(checkStatus) ? SearchFields.YEAR_MONTH_PRECIOUS_ACTUAL_TIME_SORT : SearchFields.YEAR_MONTH_PRECIOUS_START_DATE_SORT;
        } else {
            return Boolean.TRUE.equals(checkStatus) ? SearchFields.YEAR_ACTUAL_TIME_SORT : SearchFields.YEAR_SORT;
        }
    }

    private void getBuketIndexHashMap(Long dateDiff,
                                      LocalDate startDate,
                                      LocalDate endDate,
                                      TreeMap<String, Long> treeMap) {

        if (dateDiff <= 31) {
            for (int i = 0; i < dateDiff; i++) {
                treeMap.put(startDate.plusDays(i).format(formatterDay), 0L);
            }
        } else if (dateDiff <= 93) {

            calendar.setTime(Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            Date dateEnd = calendar.getTime();

            calendar.setTime(Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            Date dateStart = calendar.getTime();
            LocalDate dateStartLocal = dateStart.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            calendar.setTime(Date.from(dateStartLocal.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            int weeks = 0;
            while (calendar.getTime().before(dateEnd)) {
                calendar.add(Calendar.WEEK_OF_YEAR, 1);
                weeks++;
            }

            for (int i = 0; i < weeks; i++) {

                LocalDate startDateTemp = startDate.plusDays(i * 7L);
                calendar.setTime(Date.from(startDateTemp.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                treeMap.put(calendar.get(Calendar.YEAR) +
                                String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR))
                        , 0L);
            }

        } else if (dateDiff <= 372) {

            List<LocalDate> diff = startDate.withDayOfMonth(1)
                    .datesUntil(endDate.plusDays(1))
                    .filter(e -> e.getDayOfMonth() == 1)
                    .collect(Collectors.toList());

            diff.forEach(localDate -> treeMap.put(localDate.format(formatterMonth), GetterUtil.DEFAULT_LONG));

        } else if (dateDiff <= 1860) {

            List<LocalDate> diff = startDate.withDayOfMonth(1)
                    .datesUntil(endDate.plusDays(1))
                    .filter(e -> e.getDayOfMonth() == 1)
                    .collect(Collectors.toList());

            diff.forEach(localDate -> {
                calendar.setTime(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                treeMap.put(String.valueOf(calendar.get(Calendar.YEAR) +
                        String.valueOf(calendar.get(Calendar.MONTH) / 3 + 1)), GetterUtil.DEFAULT_LONG);
            });

        } else {

            List<LocalDate> diff = startDate.withDayOfYear(1)
                    .datesUntil(endDate.plusDays(1))
                    .filter(e -> e.getDayOfYear() == 1)
                    .collect(Collectors.toList());

            diff.forEach(localDate -> treeMap.put(localDate.format(formatterYear), GetterUtil.DEFAULT_LONG));
        }
    }

    private String getUnit(Long dateDiff) {
        if (dateDiff <= 31) {
            return "day";
        } else if (dateDiff <= 93) {
            return "week";
        } else if (dateDiff <= 372) {
            return "month";
        } else if (dateDiff <= 1860) {
            return "precious";
        } else {
            return "year";
        }
    }

    private SearchRequest getSearchRequestBurnDown(long businessId,
                                                   Long projectId,
                                                   String bucketIndex,
                                                   String status,
                                                   Boolean checkStatus,
                                                   String startDateRange,
                                                   String endDateRange) {

        SearchRequestBuilder searchRequestBuilder =
                searchRequestBuilderFactory.builder();

        MatchQuery matchQueryCustomer = queries.match(SearchFields.BUSINESS_ID, businessId);
        MatchQuery matchQueryProjectId = queries.match(SearchFields.PROJECT_ID, projectId);

        BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQueryCustomer, matchQueryProjectId);

        if (Boolean.TRUE.equals(checkStatus)) {
            MatchQuery matchQueryStatus = queries.match("status", status);

            RangeTermQuery rangeTermQuery = queries.rangeTerm(
                    "yearMonthDayActualTime",
                    Boolean.TRUE,
                    Boolean.TRUE,
                    startDateRange,
                    endDateRange);

            query.addMustQueryClauses(matchQueryStatus, rangeTermQuery);
        } else {
            RangeTermQuery rangeTermQuery = queries.rangeTerm(
                    "yearMonthDayStartDate",
                    Boolean.TRUE,
                    Boolean.TRUE,
                    startDateRange,
                    endDateRange);
            query.addMustQueryClauses(rangeTermQuery);
        }

        FieldSort fieldSortChild = sorts.field(
                bucketIndex,
                SortOrder.DESC);

        TermsAggregation termsAggregationIndex = aggregations.terms("obj", bucketIndex);

        termsAggregationIndex.setSize(1000000000);

        searchRequestBuilder
                .entryClassNames(SearchFields.WORK_INDEXER_CLASS)
                .emptySearchEnabled(true)
                .highlightEnabled(false)
                .query(query)
                .size(0)
                .sorts(fieldSortChild)
                .addAggregation(termsAggregationIndex)
                .withSearchContext(this::populateSearchContext);

        return searchRequestBuilder.build();
    }

    private SearchRequest getSearchRequestStatus(long businessId,
                                                 Long projectId) {

        SearchRequestBuilder searchRequestBuilder =
                searchRequestBuilderFactory.builder();

        MatchQuery matchQueryBusiness = queries.match(SearchFields.BUSINESS_ID, businessId);
        MatchQuery matchQueryProject = queries.match(SearchFields.PROJECT_ID, projectId);

        TermsQuery termsQueryStatus = queries.terms(SearchFields.STATUS_SORT);

        Stream<String> streamStatusKey = Arrays.stream(STATUS_KEY).distinct();

        termsQueryStatus.addValues(streamStatusKey.map(String::valueOf).toArray(Object[]::new));

        BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQueryBusiness, matchQueryProject, termsQueryStatus);

        TermsAggregation termsAggregation = aggregations.terms(SearchFields.STATUS, SearchFields.STATUS_SORT);

        termsAggregation.setSize(10);

        searchRequestBuilder
                .entryClassNames(SearchFields.WORK_INDEXER_CLASS)
                .emptySearchEnabled(true)
                .highlightEnabled(false)
                .query(query)
                .addAggregation(termsAggregation)
                .size(0)
                .withSearchContext(this::populateSearchContext);

        return searchRequestBuilder.build();
    }

    private HashMap<String, Double> getThuChi(long businessId,
                                              Long projectId,
                                              String typeResource) {

        SearchResponse searchResponse = searcher.search(
                getSearchRequestTeamByTypeResource(
                        businessId,
                        projectId,
                        typeResource));

        Map<String, AggregationResult> aggregationResultsMap =
                searchResponse.getAggregationResultsMap();

        AggregationResult aggregationResult = aggregationResultsMap.get(SearchFields.TEAMS);

        TermsAggregationResult termsAggregationResult = (TermsAggregationResult) aggregationResult;

        Collection<Bucket> buckets = termsAggregationResult.getBuckets();

        HashMap<String, Double> hashMap = new HashMap<>();

        buckets.forEach(bucket -> {

            AggregationResult aggregationResult1 = bucket.getChildAggregationResult(COUNTS);
            SumAggregationResult sumAggregationResult = (SumAggregationResult) aggregationResult1;

            hashMap.put(bucket.getKey(), sumAggregationResult.getValue());

        });

        return hashMap;

    }

    private Long getDate(long businessId,
                         long projectId,
                         String indexDate) {

        SearchResponse searchResponse = searcher.search(
                getSearchRequestDate(businessId, projectId, indexDate));

        Map<String, AggregationResult> aggregationResultsMap =
                searchResponse.getAggregationResultsMap();

        AggregationResult aggregationResult = aggregationResultsMap.get("date");

        TermsAggregationResult termsAggregationResult = (TermsAggregationResult) aggregationResult;

        Collection<Bucket> buckets = termsAggregationResult.getBuckets();

        AtomicReference<Long> longDate = new AtomicReference<>(0L);

        buckets.forEach(bucket -> {
            AggregationResult aggregationResult1 = bucket.getChildAggregationResult(COUNTS);
            SumAggregationResult sumAggregationResult = (SumAggregationResult) aggregationResult1;

            longDate.set((long) sumAggregationResult.getValue());

        });

        return longDate.get();
    }

    private SearchRequest getSearchRequestTeamByTypeResource(long businessId,
                                                             Long projectId,
                                                             String typeResource) {

        SearchRequestBuilder searchRequestBuilder =
                searchRequestBuilderFactory.builder();

        MatchQuery matchQueryCustomer = queries.match(SearchFields.BUSINESS_ID, businessId);

        MatchQuery matchQueryTypeResource = queries.match(SearchFields.TYPE_RESOURCE, typeResource.toLowerCase());

        MatchQuery matchQueryProject = queries.match(SearchFields.PROJECT_ID, projectId);

        BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQueryCustomer, matchQueryProject, matchQueryTypeResource);

        TermsAggregation termsAggregation = aggregations.terms(SearchFields.TEAMS, SearchFields.TEAM_ID_SORT);

        SumAggregation sumAggregation = aggregations.sum(COUNTS, SearchFields.TOTAL_AMOUNT_SORT);

        termsAggregation.addChildrenAggregations(sumAggregation);

        termsAggregation.setSize(100000);

        searchRequestBuilder
                .entryClassNames(SearchFields.RESOURCE_ENTRY_INDEXER_CLASS)
                .emptySearchEnabled(true)
                .highlightEnabled(false)
                .query(query)
                .addAggregation(termsAggregation)
                .size(0)
                .withSearchContext(this::populateSearchContext);

        return searchRequestBuilder.build();
    }

    private Double getValueByTypeResource(long businessId,
                                          Long projectId,
                                          String typeResource) {

        SearchResponse searchResponse = searcher.search(
                getSearchRequest(businessId, projectId, typeResource));

        Map<String, AggregationResult> aggregationResultsMap =
                searchResponse.getAggregationResultsMap();

        AggregationResult aggregationResult = aggregationResultsMap.get("resources");

        TermsAggregationResult termsAggregationResult = (TermsAggregationResult) aggregationResult;

        Collection<Bucket> buckets = termsAggregationResult.getBuckets();

        AtomicReference<Double> value = new AtomicReference<>(0D);

        buckets.forEach(bucket -> {

            AggregationResult aggregationResult1 = bucket.getChildAggregationResult(COUNTS);
            SumAggregationResult sumAggregationResult = (SumAggregationResult) aggregationResult1;

            value.set(sumAggregationResult.getValue());

        });

        return value.get();

    }

    private SearchRequest getSearchRequest(long businessId,
                                           long projectId,
                                           String typeResource) {

        SearchRequestBuilder searchRequestBuilder =
                searchRequestBuilderFactory.builder();

        MatchQuery matchQueryBusiness = queries.match(SearchFields.BUSINESS_ID, businessId);

        MatchQuery matchQueryIndex = queries.match(SearchFields.PROJECT_ID, projectId);
        MatchQuery matchQueryTypeResource = queries.match(SearchFields.TYPE_RESOURCE, typeResource.toLowerCase());

        BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQueryBusiness, matchQueryIndex, matchQueryTypeResource);

        TermsAggregation termsAggregation = aggregations.terms("resources", Field.COMPANY_ID);

        SumAggregation sumAggregation = aggregations.sum(COUNTS, SearchFields.TOTAL_AMOUNT_SORT);
        termsAggregation.addChildrenAggregations(sumAggregation);

        termsAggregation.setSize(1000000000);

        searchRequestBuilder
                .entryClassNames(SearchFields.RESOURCE_ENTRY_INDEXER_CLASS)
                .emptySearchEnabled(true)
                .highlightEnabled(false)
                .query(query)
                .size(0)
                .addAggregation(termsAggregation)
                .withSearchContext(this::populateSearchContext);

        return searchRequestBuilder.build();
    }

    private SearchRequest getSearchRequestDate(long businessId,
                                               long projectId,
                                               String indexDate) {

        SearchRequestBuilder searchRequestBuilder = searchRequestBuilderFactory.builder();

        MatchQuery matchQueryCustomer = queries.match(SearchFields.BUSINESS_ID, businessId);
        MatchQuery matchQueryProject = queries.match(Field.ENTRY_CLASS_PK, projectId);

        BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQueryCustomer, matchQueryProject);

        TermsAggregation termsAggregation = aggregations.terms("date", indexDate);
        SumAggregation sumAggregation = aggregations.sum(COUNTS, indexDate);
        termsAggregation.addChildrenAggregations(sumAggregation);

        searchRequestBuilder
                .entryClassNames(SearchFields.PROJECT_INDEXER_CLASS)
                .emptySearchEnabled(true)
                .highlightEnabled(false)
                .query(query)
                .size(10)
                .addAggregation(termsAggregation)
                .withSearchContext(this::populateSearchContext);

        return searchRequestBuilder.build();
    }

    private Long getBudget(long businessId,
                           long projectId) {

        SearchResponse searchResponse = searcher.search(
                getSearchRequestBudget(businessId, projectId));

        Map<String, AggregationResult> aggregationResultsMap =
                searchResponse.getAggregationResultsMap();

        AggregationResult aggregationResult = aggregationResultsMap.get("id");

        TermsAggregationResult termsAggregationResult = (TermsAggregationResult) aggregationResult;

        Collection<Bucket> buckets = termsAggregationResult.getBuckets();

        AtomicReference<Long> along = new AtomicReference<>(GetterUtil.DEFAULT_LONG);

        buckets.forEach(bucket -> {

            AggregationResult aggregationResult1 = bucket.getChildAggregationResult("budget");
            SumAggregationResult sumAggregationResult = (SumAggregationResult) aggregationResult1;

            along.set((long) sumAggregationResult.getValue());

        });

        return along.get();
    }

    private SearchRequest getSearchRequestBudget(long businessId,
                                                 long projectId) {

        SearchRequestBuilder searchRequestBuilder =
                searchRequestBuilderFactory.builder();

        MatchQuery matchQueryCustomer = queries.match(SearchFields.BUSINESS_ID, businessId);
        MatchQuery matchQueryProject = queries.match(Field.ENTRY_CLASS_PK, projectId);

        BooleanQuery query = queries.booleanQuery();

        query.addMustQueryClauses(matchQueryCustomer, matchQueryProject);

        TermsAggregation termsAggregation = aggregations.terms("id", Field.ENTRY_CLASS_PK);

        SumAggregation sumAggregation = aggregations.sum(SearchFields.BUDGET, SearchFields.BUDGET_SORT);
        termsAggregation.addChildrenAggregations(sumAggregation);

        searchRequestBuilder
                .entryClassNames(SearchFields.PROJECT_INDEXER_CLASS)
                .emptySearchEnabled(true)
                .highlightEnabled(false)
                .query(query)
                .size(10)
                .addAggregation(termsAggregation)
                .withSearchContext(this::populateSearchContext);

        return searchRequestBuilder.build();
    }

    private void populateSearchContext(SearchContext searchContext) {
        searchContext.setCompanyId(CompanyThreadLocal.getCompanyId());
    }

    @Reference
    protected Queries queries;
    @Reference
    private Aggregations aggregations;
    @Reference
    private Searcher searcher;
    @Reference
    private Sorts sorts;
    @Reference
    private SearchRequestBuilderFactory searchRequestBuilderFactory;
    @Reference
    private DashboardMapper mapper;
}
