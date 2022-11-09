package com.swork.business.rest.internal.service;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.account.service.service.AccountEntryLocalService;
import com.swork.business.rest.dto.v1_0.Business;
import com.swork.business.rest.internal.mapper.BusinessMapper;
import com.swork.business.service.mapper.model.BusinessMapperModel;
import com.swork.business.service.model.BusinessEntry;
import com.swork.business.service.service.BusinessEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

@Component(immediate = true, service = BusinessService.class)
public class BusinessService {

    public Business postBusiness(long creatorId,
                                 Business business,
                                 ServiceContext serviceContext) {

        BusinessMapperModel customerMapperModel = mapper.mapMapperModelFromDTO(business);

        BusinessEntry businessEntry = localService.addBusinessEntry(creatorId, customerMapperModel, serviceContext);

        accountEntryLocalService.addAccountEntry(
                GetterUtil.DEFAULT_LONG,
                businessEntry.getBusinessId(),
                StringPool.BLANK,
                PwdGenerator.getPassword(12),
                "Admin",
                null,
                businessEntry.getEmail(),
                businessEntry.getPhoneNumber(),
                businessEntry.getBusinessAddress(),
                serviceContext
        );


        return mapper.mapDTOFromEntry(businessEntry);
    }

    public Business putBusiness(
            long modifiedId,
            long businessId,
            Business business,
            ServiceContext serviceContext) {

        BusinessMapperModel customerMapperModel = mapper.mapMapperModelFromDTO(business);

        BusinessEntry businessEntry = localService.
                updateBusinessEntry(
                        modifiedId,
                        businessId,
                        customerMapperModel,
                        serviceContext);

        return mapper.mapDTOFromEntry(businessEntry);
    }

    public Business getBusiness(long businessId) throws PortalException {

        BusinessEntry businessEntry = localService.getBusinessEntry(businessId);

        return mapper.mapDTOFromEntry(businessEntry);
    }

    public void deleteBusiness(long businessId) throws PortalException {
        localService.deleteBusinessEntry(businessId);
    }

    public void approvalBusiness(long creatorId,
                                 long businessId,
                                 String status,
                                 ServiceContext serviceContext) {
        localService.updateStatus(creatorId, businessId, status, serviceContext);
    }


    public Page<Business> getBusinessPages(String search,
                                           Filter filter,
                                           Pagination pagination,
                                           Sort[] sorts,
                                           ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                },
                filter,
                BusinessEntry.class.getName(),
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
                    long businessId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapDTOFromEntry(
                            localService.getBusinessEntry(businessId));
                }
        );
    }

    @Reference
    private BusinessEntryLocalService localService;

    @Reference
    private BusinessMapper mapper;

    @Reference
    private AccountEntryLocalService accountEntryLocalService;
}
