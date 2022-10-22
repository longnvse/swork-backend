package com.swork.checklist.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.swork.checklist.rest.dto.v1_0.CheckList;
import com.swork.checklist.rest.internal.mapper.CheckListMapper;
import com.swork.checklist.service.mapper.model.ChecklistMapperModel;
import com.swork.checklist.service.model.ChecklistEntry;
import com.swork.checklist.service.service.ChecklistEntryLocalService;
import com.swork.checklist.service.service.ChecklistHandlerEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

@Component(
        immediate = true,
        service = CheckListService.class
)
public class CheckListService {

    public Page<CheckList> getCheckListPages() {
        List<ChecklistEntry> checklistEntries = checklistEntryLocalService.getChecklistEntries(-1, -1);
        List<CheckList> checkLists = mapper.mapDTOFromEntries(checklistEntries);
        return Page.of(checkLists, Pagination.of(1, checkLists.size()), checkLists.size());
    }

    public CheckList postCheckList(long userId,
                                   CheckList checkList,
                                   ServiceContext serviceContext) throws ParseException {
        ChecklistMapperModel model = mapper.mapMapperModelFromDTO(checkList);
        ChecklistEntry checklistEntry = checklistEntryLocalService.addCheckListEntry(userId, model, serviceContext);
        return mapper.mapDTOFromEntry(checklistEntry);
    }

    public void deleteCheckList(long cid) throws PortalException {
        checklistHandlerEntryLocalService.deleteByChecklistId(cid);
        checklistEntryLocalService.deleteChecklistEntry(cid);
    }

    public CheckList updateCheckList(long userId,
                                     long cid,
                                     CheckList checkList,
                                     ServiceContext serviceContext) {
        ChecklistMapperModel model = mapper.mapMapperModelFromDTO(checkList);
        ChecklistEntry checklistEntry = checklistEntryLocalService.updateCheckListEntry(
                userId,
                cid,
                model,
                serviceContext
        );

        return mapper.mapDTOFromEntry(checklistEntry);
    }

    public CheckList updateCheckListStatusById(long userId, long cid, Boolean status, ServiceContext serviceContext) {
        ChecklistEntry checklistEntry = checklistEntryLocalService.changeStatus(userId, cid, status, serviceContext);
        return mapper.mapDTOFromEntry(checklistEntry);
    }

    public CheckList getCheckListById(long cid) throws PortalException {
        ChecklistEntry checklistEntry = checklistEntryLocalService.getChecklistEntry(cid);
        return mapper.mapDTOFromEntry(checklistEntry);
    }

    public Page<CheckList> getChecklistPages(String search,
                                           Filter filter,
                                           Pagination pagination,
                                           Sort[] sorts,
                                           ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                },
                filter,
                ChecklistEntry.class.getName(),
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
                sorts
                ,
                document -> {
                    long checklistId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

                    return mapper.mapDTOFromEntry(
                            checklistEntryLocalService.getChecklistEntry(checklistId));
                }
        );
    }

    @Reference
    ChecklistHandlerEntryLocalService checklistHandlerEntryLocalService;
    @Reference
    ChecklistEntryLocalService checklistEntryLocalService;
    @Reference
    CheckListMapper mapper;

}
