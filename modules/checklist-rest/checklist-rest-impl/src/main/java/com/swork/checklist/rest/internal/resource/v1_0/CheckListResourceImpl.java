package com.swork.checklist.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.swork.checklist.rest.dto.v1_0.CheckList;
import com.swork.checklist.rest.internal.service.CheckListService;
import com.swork.checklist.rest.internal.validator.CheckListValidator;
import com.swork.checklist.rest.resource.v1_0.CheckListResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author adm
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/check-list.properties",
	scope = ServiceScope.PROTOTYPE, service = CheckListResource.class
)
public class CheckListResourceImpl extends BaseCheckListResourceImpl {
	@Override
	public Page<CheckList> getChecklists() throws Exception {
		return service.getCheckListPages();
	}

	@Override
	public CheckList postCheckList(CheckList checkList) throws Exception {
		checkListValidator.validatorForPostChecklist(checkList);
		return service.postCheckList(contextUser.getUserId(),checkList,getServiceContext());
	}

	@Override
	public void deleteCheckList(Long cid) throws Exception {
		checkListValidator.validatorChecklistIsExists(cid);
		service.deleteCheckList(cid);
	}

	@Override
	public CheckList updateCheckList(Long cid, CheckList checkList) throws Exception {
		checkListValidator.validatorForPutChecklist(cid,checkList);
		return service.updateCheckList(contextUser.getUserId(),cid,checkList,getServiceContext());
	}

	@Override
	public CheckList getCheckListById(Long cid) throws Exception {
		checkListValidator.validatorChecklistIsExists(cid);
		return service.getCheckListById(cid);
	}


	public ServiceContext getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(contextUser.getUserId());
		serviceContext.setScopeGroupId(contextUser.getGroupId());

		return serviceContext;
	}

	@Reference
	CheckListService service;

	@Reference
	CheckListValidator checkListValidator;
}