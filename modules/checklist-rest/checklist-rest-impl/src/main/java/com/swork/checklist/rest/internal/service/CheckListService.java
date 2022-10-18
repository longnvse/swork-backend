package com.swork.checklist.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.checklist.rest.dto.v1_0.CheckList;
import com.swork.checklist.rest.internal.mapper.CheckListMapper;
import com.swork.checklist.service.model.ChecklistEntry;
import com.swork.checklist.service.service.ChecklistEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        immediate = true,
        service = CheckListService.class
)
public class CheckListService {

    public Page<CheckList> getCheckListPages() {
        List<ChecklistEntry> checklistEntries = checklistEntryLocalService.getChecklistEntries(-1, -1);
        List<CheckList> pets = mapper.mapDTOFromEntries(checklistEntries);
        return Page.of(pets, Pagination.of(1, pets.size()), pets.size());
    }

    public CheckList postCheckList(long userId,
                       CheckList checkList,
                       ServiceContext serviceContext) {
        ChecklistEntry checklistEntry = checklistEntryLocalService.addCheckListEntry(userId, checkList.getName(), checkList.getTaskId(),checkList.getStatus(), serviceContext);

        return mapper.mapDTOFromEntry(checklistEntry);
    }

    public void deleteCheckList(long cid) throws PortalException {
        checklistEntryLocalService.deleteChecklistEntry(cid);
    }

    public CheckList updateCheckList(long userId,
                         long cid,
                         CheckList checkList,
                         ServiceContext serviceContext) {
        ChecklistEntry checklistEntry = checklistEntryLocalService.updateCheckListEntry(
                userId,
                cid,
                checkList.getName(),
                checkList.getTaskId(),
                checkList.getStatus(),
                serviceContext
        );

        return mapper.mapDTOFromEntry(checklistEntry);
    }
    public CheckList updateCheckListStatusById(long userId,long cid,Boolean status,ServiceContext serviceContext){
//        ChecklistEntry checklistEntry= checklistEntryLocalService.chan
        return null;
    }

    public CheckList getCheckListById(long cid) throws PortalException {
        ChecklistEntry checklistEntry=checklistEntryLocalService.getChecklistEntry(cid);
        return mapper.mapDTOFromEntry(checklistEntry);
    }





    @Reference
    ChecklistEntryLocalService checklistEntryLocalService;
    @Reference
    CheckListMapper mapper;

}
