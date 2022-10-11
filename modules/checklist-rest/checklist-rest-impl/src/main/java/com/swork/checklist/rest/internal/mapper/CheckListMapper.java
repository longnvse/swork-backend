package com.swork.checklist.rest.internal.mapper;

import com.swork.checklist.rest.dto.v1_0.CheckList;
import com.swork.checklist.service.model.ChecklistEntry;
import org.osgi.service.component.annotations.Component;

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

        return to;
    }

    public List<CheckList> mapDTOFromEntries(List<ChecklistEntry> from) {
        return from
                .stream()
                .map(this::mapDTOFromEntry)
                .collect(Collectors.toList());
    }
}
