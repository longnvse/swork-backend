package com.swork.core.phase.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.DateRangeTermFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.common.util.api.CommonUtil;
import com.swork.core.phase.rest.dto.v1_0.Phase;
import com.swork.core.phase.rest.internal.mapper.PhaseMapper;
import com.swork.core.phase.service.constant.SearchFields;
import com.swork.core.phase.service.mapper.model.PhaseMapperModel;
import com.swork.core.phase.service.model.PhaseEntry;
import com.swork.core.phase.service.service.PhaseEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

@Component(
        immediate = true,
        service = PhaseService.class
)
public class PhaseService {

    private static final String PATTERN = "yyyyMMddHHmmss";

    public Page<Phase> getPhasePage(long businessId,
                                    String search,
                                    Filter filter,
                                    Pagination pagination,
                                    Sort[] sorts,
                                    ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {

                    TermFilter customerIdFilter =
                            new TermFilter(SearchFields.BUSINESS_ID, String.valueOf(businessId));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(customerIdFilter, BooleanClauseOccur.MUST);
                },
                filter,
                PhaseEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long phaseId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return phaseMapper.mapDTOFromEntry(
                            phaseEntryLocalService
                                    .getPhaseEntry(phaseId));
                });
    }

    public PhaseEntry postPhase(long customerId,
                                long creatorId,
                                Phase phase,
                                ServiceContext serviceContext) {

        PhaseMapperModel phaseMapperModel = phaseMapper.mapModelFromDto(phase);


        return phaseEntryLocalService.addPhase(customerId, creatorId, phaseMapperModel, serviceContext);
    }

    public void putPhase(long creatorId,
                         long phaseId,
                         Phase phase,
                         ServiceContext serviceContext) throws PortalException {

        PhaseMapperModel phaseMapperModel = phaseMapper.mapModelFromDto(phase);

        phaseEntryLocalService.updatePhase(creatorId, phaseId, phaseMapperModel, serviceContext);
    }

    public Phase getPhase(long phaseId) {

        return phaseMapper
                .mapDTOFromEntry(
                        phaseEntryLocalService.fetchPhaseEntry(phaseId));
    }

    public void deletePhase(long phaseId) throws PortalException {

        phaseEntryLocalService.deletePhaseEntry(phaseId);
    }

    public Page<Phase> getPhaseByProject(long businessId,
                                         Long projectId,
                                         Date startDate,
                                         Date endDate,
                                         String search,
                                         Filter filter,
                                         Pagination pagination,
                                         Sort[] sorts,
                                         ServiceContext serviceContext) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {

                    TermFilter customerIdFilter =
                            new TermFilter(SearchFields.BUSINESS_ID, String.valueOf(businessId));
                    TermFilter projectIdFilter =
                            new TermFilter(SearchFields.PROJECT_ID, String.valueOf(projectId));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(customerIdFilter, BooleanClauseOccur.MUST);
                    booleanFilter.add(projectIdFilter, BooleanClauseOccur.MUST);

                    if (Validator.isNotNull(startDate) && Validator.isNotNull(endDate)) {
                        DateRangeTermFilter startDateFilter =
                                new DateRangeTermFilter(
                                        SearchFields.START_DATE,
                                        true,
                                        true,
                                        sdf.format(commonUtil.getStartOfDate(startDate)),
                                        sdf.format(commonUtil.getEndOfDate(endDate)));
                        DateRangeTermFilter endDateFilter =
                                new DateRangeTermFilter(
                                        SearchFields.END_DATE,
                                        true,
                                        true,
                                        sdf.format(commonUtil.getStartOfDate(startDate)),
                                        sdf.format(commonUtil.getEndOfDate(endDate)));

                        booleanFilter.add(startDateFilter, BooleanClauseOccur.MUST);
                        booleanFilter.add(endDateFilter, BooleanClauseOccur.MUST);
                    }

                },
                filter,
                PhaseEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long phaseId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return phaseMapper.mapDTOFromEntry(
                            phaseEntryLocalService
                                    .getPhaseEntry(phaseId));
                });
    }

    public void updateDate(long creatorId,
                           long phaseId,
                           Date startDate,
                           Date endDate,
                           ServiceContext serviceContext) {
        phaseEntryLocalService.updateDate(
                creatorId,
                phaseId,
                startDate,
                endDate,
                serviceContext
        );
    }

    @Reference
    private PhaseEntryLocalService phaseEntryLocalService;
    @Reference
    private PhaseMapper phaseMapper;
    @Reference
    private CommonUtil commonUtil;
}
