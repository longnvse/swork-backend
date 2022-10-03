package com.swork.rest.internal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.swork.rest.dto.v1_0.Pet;
import com.swork.rest.internal.mapper.PetMapper;
import com.swork.service.model.PetEntry;
import com.swork.service.service.PetEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        immediate = true,
        service = PetService.class
)
public class PetService {

    public Page<Pet> getPetPages() {
        List<PetEntry> petEntries = petEntryLocalService.getPetEntries(-1, -1);
        List<Pet> pets = mapper.mapDTOFromEntries(petEntries);
        return Page.of(pets, Pagination.of(1, pets.size()), pets.size());
    }

    public Pet postPet(long userId,
                       Pet pet,
                       ServiceContext serviceContext) {
        PetEntry petEntry = petEntryLocalService.addPetEntry(userId, pet.getName(), pet.getPrice(), serviceContext);

        return mapper.mapDTOFromEntry(petEntry);
    }

    public void deletePet(long petId) throws PortalException {
        petEntryLocalService.deletePetEntry(petId);
    }

    public Pet updatePet(long userId,
                         long petId,
                         Pet pet,
                         ServiceContext serviceContext) {
        PetEntry petEntry = petEntryLocalService.updatePetEntry(
                userId,
                petId,
                pet.getName(),
                pet.getPrice(),
                serviceContext
        );

        return mapper.mapDTOFromEntry(petEntry);
    }

    @Reference
    PetEntryLocalService petEntryLocalService;
    @Reference
    PetMapper mapper;

}
