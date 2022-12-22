package com.swork.account.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.dto.v1_0.ChangePassword;
import com.swork.account.rest.dto.v1_0.ResetPassword;
import com.swork.account.rest.internal.odata.v1_0.AccountEntityModel;
import com.swork.account.rest.internal.service.AccountService;
import com.swork.account.rest.internal.validator.AccountValidator;
import com.swork.account.rest.resource.v1_0.AccountResource;
import com.swork.common.file.helper.api.CommonFileHelper;
import com.swork.common.token.helper.api.CommonTokenHelper;
import com.swork.common.token.model.UserTokenModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

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
                getThemeDisplay(),
                getServiceContext()
        );
    }

    @Override
    public Account postAccount(Account account) throws PortalException {
        validator.validatorForPostAccount(account);

        return service.addAccount(
                getUserToken().getAccountId(),
                getUserToken().getBusinessId(),
                account,
                getThemeDisplay(),
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

        return service.getAccount(accountId, getThemeDisplay());
    }

    @Override
    public Account putAccount(Long accountId, Account account) throws PortalException {
        validator.validatorForPutAccount(accountId, account);

        return service.updateAccount(
                getUserToken().getAccountId(),
                accountId,
                account,
                getThemeDisplay(),
                getServiceContext()
        );
    }

    @Override
    public Account getAccountInfo() throws PortalException {
        return service.getAccount(
                getUserToken().getAccountId(),
                getThemeDisplay()
        );
    }

    @Override
    public void patchAccountPassword(ChangePassword changePassword) throws Exception {
        validator.validateForChangePassword(
                getUserToken().getAccountId(),
                changePassword
        );

        service.changePassword(
                getUserToken().getAccountId(),
                changePassword,
                getServiceContext()
        );
    }

    @Override
    public void putAccountInfo(Account account) throws Exception {
        validator.validatorForPutAccount(
                getUserToken().getAccountId(),
                account
        );

        service.updateAccount(
                getUserToken().getAccountId(),
                getUserToken().getAccountId(),
                account,
                getThemeDisplay(),
                getServiceContext()
        );
    }

    @Override
    public void resetPassword(ResetPassword resetPassword) throws Exception {
        validator.validateForResetPassword(resetPassword);

        service.resetPassword(resetPassword);
    }

    @Override
    public void approvalAccount(Long accountId, String status) throws Exception {
        validator.validatorAccountIsExists(accountId);

        service.approvalAccount(accountId, status, getServiceContext());
    }


    @Override
    public Response updateAvatar(MultipartBody multipartBody) throws Exception {
        validator.validateForUpdateAvatar(multipartBody);

        String urlPreview = service.updateAvatar(
                getUserToken().getBusinessId(),
                getUserToken().getAccountId(),
                multipartBody,
                getThemeDisplay(),
                getServiceContext()
        );

        return Response.ok(urlPreview).build();
    }

    @Override
    public Page<Account> getListAccount(@NotNull Long[] accountIds) throws Exception {
        return service.getListAccount(accountIds, getThemeDisplay());
    }

    public ThemeDisplay getThemeDisplay() {
        return commonFileHelper.getThemeDisplay(contextHttpServletRequest);
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
    private CommonFileHelper commonFileHelper;

    @Reference
    private AccountService service;

    @Reference
    private AccountValidator validator;

}