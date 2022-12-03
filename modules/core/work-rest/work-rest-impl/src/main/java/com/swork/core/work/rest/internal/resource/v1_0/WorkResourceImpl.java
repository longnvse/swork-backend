package com.swork.core.work.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import com.swork.core.work.rest.dto.v1_0.Work;
import com.swork.core.work.rest.internal.odata.v1_0.WorkEntryModel;
import com.swork.core.work.rest.internal.service.WorkService;
import com.swork.core.work.rest.internal.validator.WorkValidator;
import com.swork.core.work.rest.resource.v1_0.WorkResource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @author longnv
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/work.properties",
		scope = ServiceScope.PROTOTYPE, service = WorkResource.class
)
public class WorkResourceImpl extends BaseWorkResourceImpl {
	private final WorkEntryModel workEntryModel = new WorkEntryModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		return workEntryModel;
	}

	@Override
	public Page<Work> getWorksPage(String search, Long projectId, Long phaseId, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		return service.getWorkPages(
				getUserToken().getBusinessId(),
				projectId,
				phaseId,
				search,
				filter,
				pagination,
				sorts,
				getServiceContext());
	}



	@Override
	public Work postWork(Work work) throws Exception {
		validator.validateForAdd(
				getUserToken().getBusinessId(),
				work
		);

		return service.postWork(
				getUserToken().getBusinessId(),
				getUserToken().getAccountId(),
				work,
				getServiceContext()
		);
	}

	@Override
	public void deleteWork(Long workId) throws Exception {
		validator.validateForDelete(
				getUserToken().getBusinessId(),
				workId
		);

		service.deleteWork(workId);
	}

	@Override
	public Work getWork(Long workId) throws Exception {
		validator.validateForExist(workId);

		return service.getWork(workId);
	}

	@Override
	public Work putWork(Long workId, Work work) throws Exception {
		validator.validateForUpdate(
				getUserToken().getBusinessId(),
				workId,
				work
		);

		return service.putWork(
				getUserToken().getAccountId(),
				workId,
				work,
				getServiceContext()
		);
	}

	@Override
	public void putReportAmount(Long workId, Double completeAmount) {
		service.reportProgressByAmount(
				getUserToken().getAccountId(),
				workId,
				completeAmount,
				getServiceContext()
		);
	}

	@Override
	public void updateStatus(Long workId, String status) throws Exception {
		validator.validateForExist(workId);

		service.updateStatus(
				getUserToken().getAccountId(),
				workId,
				status,
				getServiceContext());

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
	private WorkService service;

	@Reference
	private WorkValidator validator;
}