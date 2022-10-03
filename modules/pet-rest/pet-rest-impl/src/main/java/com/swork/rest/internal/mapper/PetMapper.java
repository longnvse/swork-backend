package com.swork.rest.internal.mapper;

import com.swork.rest.dto.v1_0.Pet;
import com.swork.service.model.PetEntry;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        service = PetMapper.class
)
public class PetMapper {
    public Pet mapDTOFromEntry(PetEntry from) {
        Pet to = new Pet();

        to.setId(from.getPetId());
        to.setName(from.getName());
        to.setPrice(from.getPrice());

        return to;
    }

    public List<Pet> mapDTOFromEntries(List<PetEntry> from) {
        return from
                .stream()
                .map(this::mapDTOFromEntry)
                .collect(Collectors.toList());
    }
}
