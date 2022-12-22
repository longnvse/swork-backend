package com.swork.account.rest.internal.service;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.account.rest.dto.v1_0.Account;
import com.swork.account.rest.dto.v1_0.ChangePassword;
import com.swork.account.rest.dto.v1_0.Metadata;
import com.swork.account.rest.dto.v1_0.ResetPassword;
import com.swork.account.rest.internal.mapper.AccountMapper;
import com.swork.account.service.constant.SearchFields;
import com.swork.account.service.model.AccountEntry;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.common.file.helper.api.CommonFileHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component(immediate = true, service = AccountService.class)
public class AccountService {

    public Page<Account> getAccountsPage(long businessId,
                                         String search,
                                         Filter filter,
                                         Pagination pagination,
                                         Sort[] sorts,
                                         ThemeDisplay themeDisplay,
                                         ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                    TermFilter businessIdFilter =
                            new TermFilter(SearchFields.BUSINESS_ID, String.valueOf(businessId));

                    TermFilter creatorIdFilter =
                            new TermFilter(SearchFields.CREATOR_ID, String.valueOf(GetterUtil.DEFAULT_LONG));

                    BooleanFilter booleanFilter =
                            booleanQuery.getPreBooleanFilter();

                    booleanFilter.add(businessIdFilter, BooleanClauseOccur.MUST);
                    booleanFilter.add(creatorIdFilter, BooleanClauseOccur.MUST_NOT);
                },
                filter,
                AccountEntry.class.getName(),
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
                    long accountId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapDTOFromEntry(
                            localService.getAccountEntry(accountId), themeDisplay);
                });
    }

    public Page<Account> getListAccount(Long[] accountIds, ThemeDisplay themeDisplay) {
        List<Account> accounts = Arrays.stream(accountIds).map(accountId -> {
            try {
                return getAccount(accountId, themeDisplay);
            } catch (PortalException e) {
                return new Account();
            }
        }).collect(Collectors.toList());

        return Page.of(accounts, Pagination.of(1, accounts.size()), accounts.size());
    }

    public Account addAccount(long creatorId,
                              long businessId,
                              Account account,
                              ThemeDisplay themeDisplay,
                              ServiceContext serviceContext) throws PortalException {

        AccountEntry entry =
                localService.addAccountEntry(
                        creatorId,
                        businessId,
                        account.getUsername(),
                        PwdGenerator.getPassword(12),
                        account.getFullName(),
                        account.getDateOfBirth(),
                        account.getGender(),
                        account.getEmail(),
                        account.getPhoneNumber(),
                        account.getAddress(),
                        serviceContext);

        return mapper.mapDTOFromEntry(entry, themeDisplay);
    }

    public void deleteAccount(long accountId) throws PortalException {
        localService.deleteAccountEntry(accountId);
    }

    public Account updateAccount(long creatorId,
                                 long accountId,
                                 Account account,
                                 ThemeDisplay themeDisplay,
                                 ServiceContext serviceContext) throws PortalException {

        AccountEntry entry =
                localService.updateAccountEntry(
                        creatorId,
                        accountId,
                        account.getFullName(),
                        account.getDateOfBirth(),
                        account.getEmail(),
                        account.getPhoneNumber(),
                        account.getAddress(),
                        account.getGender(),
                        serviceContext);

        return mapper.mapDTOFromEntry(entry, themeDisplay);
    }

    public Account getAccount(long accountId, ThemeDisplay themeDisplay) throws PortalException {
        AccountEntry entry =
                localService.getAccountEntry(accountId);

        return mapper.mapDTOFromEntry(entry, themeDisplay);
    }

    public void changePassword(long accountId,
                               ChangePassword changePassword,
                               ServiceContext serviceContext) {
        localService.changePassword(
                accountId,
                changePassword.getNewPassword(),
                serviceContext
        );
    }

    public void resetPassword(ResetPassword resetPassword) {
        AccountEntry accountEntry = localService.resetPassword(resetPassword.getEmail());

        mailService.sendMail(accountEntry);
    }

    public void approvalAccount(long accountId, String status, ServiceContext serviceContext) {
        localService.updateStatus(accountId, status, serviceContext);
    }

    private static final String METADATA_KEY = "metadata";

    public String updateAvatar(long businessId,
                               long accountId,
                               MultipartBody multipartBody,
                               ThemeDisplay themeDisplay,
                               ServiceContext serviceContext) throws IOException, PortalException {
        Metadata metadata = multipartBody.getValueAsInstance(METADATA_KEY, Metadata.class);

        FileEntry fileEntry = commonFileHelper.uploadFile(
                serviceContext.getScopeGroupId(),
                businessId,
                String.valueOf(businessId),
                metadata.getModuleId(),
                metadata.getAppId(),
                multipartBody,
                serviceContext);

        AccountEntry accountEntry = localService.fetchAccountEntry(accountId);

        if (GetterUtil.getLong(accountEntry.getAvatar()) != GetterUtil.DEFAULT_LONG) {
            DLAppLocalServiceUtil.deleteFileEntry(accountEntry.getAvatar());
        }

        localService.updateAvatar(
                accountId,
                fileEntry.getFileEntryId(),
                serviceContext
        );

        return commonFileHelper.getPreviewUrl(fileEntry.getFileEntryId(), themeDisplay);
    }

    @Reference
    private AccountMapper mapper;
    @Reference
    private AccountEntryLocalService localService;
    @Reference
    private MailService mailService;
    @Reference
    private CommonFileHelper commonFileHelper;
}
