package com.swork.account.rest.internal.mapper;

import com.swork.account.rest.dto.v1_0.PermissionDetail;
import com.swork.account.service.model.PermissionDetailEntry;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component(immediate = true, service = PermissionDetailMapper.class)
public class PermissionDetailMapper {
    public PermissionDetail mapDTOFromEntry(PermissionDetailEntry from) {
        PermissionDetail to = new PermissionDetail();

       to.setId(from.getId());
       to.setPermissionId(from.getPermissionId());
       to.setActionCode(from.getActionCode());
       return to;
    }


    public List<PermissionDetail> mapDTOFromEntries(List<PermissionDetailEntry> from) {
        return from
                .stream()
                .map(this::mapDTOFromEntry)
                .collect(Collectors.toList());
    }
}