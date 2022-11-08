package com.swork.core.project.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import com.swork.core.project.rest.dto.v1_0.Project;
import com.swork.core.project.rest.internal.odata.v1_0.ProjectEntryModel;
import com.swork.core.project.rest.internal.service.ProjectService;
import com.swork.core.project.rest.internal.validator.ProjectValidator;
import com.swork.core.project.rest.resource.v1_0.ProjectResource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Date;

/**
 * @author Long Hip
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/project.properties",
		scope = ServiceScope.PROTOTYPE, service = ProjectResource.class
)
public class ProjectResourceImpl extends BaseProjectResourceImpl {
	private final ProjectEntryModel projectEntryModel = new ProjectEntryModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		return projectEntryModel;
	}

	@Override
	public Page<Project> getProjectsPage(String type, String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		return service.getProjectPages(
				getUserToken().getBusinessId(),
				search,
				filter,
				pagination,
				sorts,
				getServiceContext()
		);
	}

	@Override
	public Project postProject(Project project) throws Exception {
		validator.validatorProjectForAdd(
				getUserToken().getBusinessId(),
				project
		);

		return service.postProject(
				getUserToken().getBusinessId(),
				getUserToken().getAccountId(),
				project,
				getServiceContext()
		);
	}

	@Override
	public void deleteProject(Long projectId) throws Exception {
		validator.validatorProjectIsExists(projectId);
		validator.validatorDeleteProject(projectId);

		service.deleteProject(projectId);
	}

	@Override
	public Project getProject(Long projectId) throws Exception {
		validator.validatorProjectIsExists(projectId);

		return service.getProject(projectId);
	}

	@Override
	public Project putProject(Long projectId, Project project) throws Exception {
		validator.validatorProjectForUpdate(
				getUserToken().getBusinessId(),
				projectId,
				project);

		return service.putProject(
				getUserToken().getAccountId(),
				projectId,
				project,
				getServiceContext());
	}

	@Override
	public void approvalProject(Long projectId, String status) throws Exception {
		validator.validatorProjectIsExists(projectId);

		service.approvalProject(
				getUserToken().getAccountId(),
				projectId,
				status,
				getServiceContext());
	}

	@Override
	public void updateDescriptionProject(Long projectId, String description) throws Exception {
		validator.validatorProjectIsExists(projectId);

		service.updateDescription(
				getUserToken().getAccountId(),
				projectId,
				description,
				getServiceContext());
	}

	@Override
	public void updateDateProject(Long projectId, Date startDate, Date endDate) throws Exception {
		validator.validatorProjectIsExists(projectId);

		service.updateDate(
				getUserToken().getAccountId(),
				projectId,
				startDate,
				endDate,
				getServiceContext());
	}

	@Override
	public void updateActualDateProject(Long projectId, Date actualStartDate, Date actualEndDate) throws Exception {
		validator.validatorProjectIsExists(projectId);

		service.updateActualDate(
				getUserToken().getAccountId(),
				projectId,
				actualStartDate,
				actualEndDate,
				getServiceContext());
	}

	@Override
	public void updateMemberProject(Long projectId, Project project) throws SW_NoSuchEntryException {
		validator.validatorProjectIsExists(projectId);

		service.updateMember(
				getUserToken().getAccountId(),
				projectId,
				project,
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
	private ProjectService service;

	@Reference
	private ProjectValidator validator;
}