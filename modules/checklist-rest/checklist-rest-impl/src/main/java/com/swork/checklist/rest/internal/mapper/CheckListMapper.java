package com.swork.checklist.rest.internal.mapper;

import com.swork.checklist.rest.dto.v1_0.CheckList;
import com.swork.checklist.service.mapper.model.ChecklistMapperModel;
import com.swork.checklist.service.model.ChecklistEntry;
import com.swork.checklist.service.model.ChecklistHandlerEntry;
import com.swork.checklist.service.model.ChecklistHandlerEntryModel;
import com.swork.checklist.service.service.ChecklistHandlerEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        service = CheckListMapper.class
)
public class CheckListMapper {
    public CheckList mapDTOFromEntry(ChecklistEntry from) {
        CheckList to = new CheckList();

        to.setCheckListId(from.getChecklistId());
        to.setName(from.getName());
        to.setTaskId(from.getTaskId());
        to.setStatus(from.getStatus());
        to.setStartDate(from.getStartDate());
        to.setEndDate(from.getEndDate());

        List<ChecklistHandlerEntry> handlers=checklistHandlerEntryLocalService.getByCheckListId(to.getCheckListId());
        to.setHandlers(handlers.stream().mapToLong(ChecklistHandlerEntryModel::getAccId).boxed().toArray(Long[]::new));
        return to;
    }

    public List<CheckList> mapDTOFromEntries(List<ChecklistEntry> from) {
        return from
                .stream()
                .map(this::mapDTOFromEntry)
                .collect(Collectors.toList());
    }

    public ChecklistMapperModel mapMapperModelFromDTO(CheckList from) {
        ChecklistMapperModel to = new ChecklistMapperModel();

        to.setName(from.getName());
        to.setTaskId(from.getTaskId());
        to.setStatus(from.getStatus());
        to.setStartDate(from.getStartDate());
        to.setEndDate(from.getEndDate());
        to.setHandlers(from.getHandlers());
        return to;
    }

    @Reference
    ChecklistHandlerEntryLocalService checklistHandlerEntryLocalService;
}
