package com.swork.account.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.internal.odata.v1_0.AccountEntityModel;
import com.swork.account.rest.internal.service.AccountService;
import com.swork.account.rest.internal.validator.AccountValidator;
import com.swork.account.rest.resource.v1_0.AccountResource;
import com.swork.common.exception.model.SW_DataInputException;
import com.swork.common.exception.model.SW_FieldDuplicateException;
import com.swork.common.exception.model.SW_FieldRequiredException;
import com.swork.common.exception.model.SW_NoSuchEntryException;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @author Long Hip
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/account.properties",
        scope = ServiceScope.PROTOTYPE, service = AccountResource.class
)
public class AccountResourceImpl extends BaseAccountResourceImpl {
    private final EntityModel entityModel = new AccountEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
        return entityModel;
    }

    @Override
    public Page<Account> getAccountsPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
        return service.getAccountsPage(
                getUserToken().getBusinessId(),
                search,
                filter,
                pagination,
                sorts,
                getServiceContext()
        );
    }

    @Override
    public Account postAccount(Account account) throws SW_DataInputException, SW_FieldDuplicateException, SW_FieldRequiredException {
        validator.validatorForPostAccount(account);

        return service.addAccount(
                getUserToken().getAccountId(),
                getUserToken().getBusinessId(),
                account,
                getServiceContext()
        );
    }

    @Override
    public void deleteAccount(Long accountId) throws PortalException {
        validator.validateForDelete(accountId);

        service.deleteAccount(accountId);
    }

    @Override
    public Account getAccount(Long accountId) throws Exception {
        validator.validatorAccountIsExists(accountId);

        return service.getAccount(accountId);
    }

    @Override
    public Account putAccount(Long accountId, Account account) throws SW_DataInputException, SW_NoSuchEntryException, SW_FieldDuplicateException, SW_FieldRequiredException {
        validator.validatorForPutAccount(accountId, account);

        return service.updateAccount(
                getUserToken().getAccountId(),
                accountId,
                account,
                getServiceContext()
        );
    }

    @Override
    public void approvalAccount(Long accountId, String status) throws Exception {
        validator.validatorAccountIsExists(accountId);

        service.approvalAccount(accountId, status, getServiceContext());
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
    private AccountService service;

    @Reference
    private AccountValidator validator;

}