package com.swork.core.resource.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import com.swork.common.util.api.CommonUtil;
import com.swork.core.resource.rest.dto.v1_0.Team;
import com.swork.core.resource.rest.internal.odata.v1_0.TeamEntityModel;
import com.swork.core.resource.rest.internal.service.TeamService;
import com.swork.core.resource.rest.internal.validator.TeamValidator;
import com.swork.core.resource.rest.resource.v1_0.TeamResource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @author Long Hip
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/team.properties",
        scope = ServiceScope.PROTOTYPE, service = TeamResource.class
)
public class TeamResourceImpl extends BaseTeamResourceImpl {
    private final EntityModel entityModel = new TeamEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
        return entityModel;
    }

    @Override
    public Page<Team> getTeamPages(Long projectId, Long phaseId, String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
        if (Validator.isNotNull(search)) {
            search = commonUtil.vnNormalize(search);
        }

        return service.getTeamPages(
                getUserToken().getBusinessId(),
                projectId,
                phaseId,
                search,
                filter,
                pagination,
                sorts,
                getServiceContext()
        );
    }

    @Override
    public Team postTeam(Team team) throws Exception {
        validator.validateForAdd(
                getUserToken().getBusinessId(),
                team
        );

        return service.postTeam(
                getUserToken().getBusinessId(),
                getUserToken().getAccountId(),
                team,
                getServiceContext()
        );
    }

    @Override
    public void deleteTeam(Long teamId) throws Exception {
        validator.validateForDelete(
                getUserToken().getBusinessId(),
                teamId
        );

        service.deleteTeam(teamId);
    }

    @Override
    public Team getTeam(Long teamId) throws Exception {
        validator.validateExist(teamId);

        return service.getTeam(teamId);
    }

    @Override
    public Team putTeam(Long teamId, Team team) throws Exception {
        validator.validateForUpdate(
                getUserToken().getBusinessId(),
                teamId,
                team
        );

        return service.putTeam(
                getUserToken().getAccountId(),
                teamId,
                team,
                getServiceContext()
        );
    }

    public ServiceContext getServiceContext() {

        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());

        return serviceContext;
    }

    private UserTokenModel getUserToken() {
        return tokenHelper.getUserToken(contextHttpServletRequest);
    }

    @Reference
    private CommonTokenHelper tokenHelper;

    @Reference
    private TeamService service;

    @Reference
    private CommonUtil commonUtil;

    @Reference
    private TeamValidator validator;
}