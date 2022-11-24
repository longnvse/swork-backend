package com.swork.core.resource.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.core.resource.rest.dto.v1_0.Team;
import com.swork.core.resource.rest.internal.mapper.TeamMapper;
import com.swork.core.resource.service.constant.SearchFields;
import com.swork.core.resource.service.mapper.model.TeamMapperModel;
import com.swork.core.resource.service.model.TeamEntry;
import com.swork.core.resource.service.service.TeamEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

@Component(immediate = true, service = TeamService.class)
public class TeamService {

    public Page<Team> getTeamPages(long businessId,
                                   Long projectId,
                                   Long phaseId,
                                   String search,
                                   Filter filter,
                                   Pagination pagination,
                                   Sort[] sorts,
                                   ServiceContext serviceContext) throws Exception {

        if (Validator.isNull(sorts) || sorts.length == GetterUtil.DEFAULT_INTEGER) {
            sorts = new Sort[]{new Sort(SearchFields.getCreatorDateSortable(SearchFields.CREATE_DATE), true)};
        }

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                    TermFilter businessIdFilter =
                            new TermFilter(SearchFields.BUSINESS_ID, String.valueOf(businessId));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();
                    booleanFilter.add(businessIdFilter, BooleanClauseOccur.MUST);

                    if (Validator.isNotNull(projectId)) {
                        TermFilter projectIdIdFilter =
                                new TermFilter(SearchFields.PROJECT_ID, String.valueOf(projectId));

                        booleanFilter.add(projectIdIdFilter, BooleanClauseOccur.MUST);
                    }

                    if (Validator.isNotNull(phaseId)) {
                        TermFilter phaseIdIdFilter =
                                new TermFilter(SearchFields.PHASE_ID, String.valueOf(phaseId));

                        booleanFilter.add(phaseIdIdFilter, BooleanClauseOccur.MUST);
                    }
                },
                filter,
                TeamEntry.class.getName(),
                search,
                pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK
                ),
                searchContext -> {
                    searchContext.setCompanyId(serviceContext.getCompanyId());

                    if (Validator.isNotNull(search)) {
                        searchContext.setKeywords(search);
                    }
                },
                sorts,
                document -> {
                    long id = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapEntryToDTO(
                            localService.getTeamEntry(id)
                    );
                }
        );

    }

    public Team postTeam(long businessId,
                         long creatorId,
                         Team dto,
                         ServiceContext serviceContext) {
        TeamMapperModel model = mapper.mapDTOToMapperModel(dto);

        TeamEntry entry =
                localService.addTeamEntry(businessId, creatorId, model, serviceContext);

        return mapper.mapEntryToDTO(entry);
    }

    public Team putTeam(long creatorId,
                        long teamId,
                        Team dto,
                        ServiceContext serviceContext) {
        TeamMapperModel model = mapper.mapDTOToMapperModel(dto);

        TeamEntry entry =
                localService.updateTeamEntry(creatorId, teamId, model, serviceContext);

        return mapper.mapEntryToDTO(entry);
    }

    public Team getTeam(long teamId) {

        TeamEntry entry =
                localService.fetchTeamEntry(teamId);

        return mapper.mapEntryToDTO(entry);
    }

    public void deleteTeam(long teamId) throws PortalException {
        localService.deleteTeamEntry(teamId);
    }


    @Reference
    private TeamMapper mapper;

    @Reference
    private TeamEntryLocalService localService;
}
