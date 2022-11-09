package com.swork.core.phase.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import com.swork.core.phase.rest.dto.v1_0.Phase;
import com.swork.core.phase.rest.internal.odata.v1_0.PhaseEntryModel;
import com.swork.core.phase.rest.internal.service.PhaseService;
import com.swork.core.phase.rest.internal.validator.PhaseValidator;
import com.swork.core.phase.rest.resource.v1_0.PhaseResource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Date;

/**
 * @author Long Hip
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/phase.properties",
		scope = ServiceScope.PROTOTYPE, service = PhaseResource.class
)
public class PhaseResourceImpl extends BasePhaseResourceImpl {
	private final PhaseEntryModel phaseEntryModel = new PhaseEntryModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		return phaseEntryModel;
	}

	@Override
	public Page<Phase> getPhasesPage(Long projectId, Date startDate, Date endDate, String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		return phaseService.getPhaseByProject(
				getUserToken().getBusinessId(),
				projectId,
				startDate,
				endDate,
				search,
				filter,
				pagination,
				sorts,
				getServiceContext()
		);
	}

	@Override
	public void postPhase(Long projectId, Phase phase) throws Exception {
		phaseValidator.validatorForAdd(
				getUserToken().getBusinessId(),
				phase
		);

		phaseService.postPhase(
				getUserToken().getBusinessId(),
				getUserToken().getAccountId(),
				phase,
				getServiceContext()
		);
	}

	@Override
	public void deletePhase(Long phaseId) throws Exception {
		phaseValidator.validateForExist(phaseId);

		phaseService.deletePhase(phaseId);
	}

	@Override
	public Phase getPhase(Long phaseId) throws Exception {
		phaseValidator.validateForExist(phaseId);

		return phaseService.getPhase(phaseId);
	}

	@Override
	public void putPhase(Long phaseId, Phase phase) throws Exception {
		phaseValidator.validatorForUpdate(
				getUserToken().getBusinessId(),
				phaseId,
				phase
		);

		phaseService.putPhase(
				getUserToken().getAccountId(),
				phaseId,
				phase,
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
	private PhaseService phaseService;
	@Reference
	private PhaseValidator phaseValidator;
}