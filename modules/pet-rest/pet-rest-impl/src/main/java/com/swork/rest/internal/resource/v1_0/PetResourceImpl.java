package com.swork.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.swork.rest.dto.v1_0.Pet;
import com.swork.rest.internal.service.PetService;
import com.swork.rest.resource.v1_0.PetResource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Long Hip
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/pet.properties",
        scope = ServiceScope.PROTOTYPE, service = PetResource.class
)
public class PetResourceImpl extends BasePetResourceImpl {
    @Override
    public Page<Pet> getPets() {
        return service.getPetPages();
    }

    @Override
    public void deletePet(Long petId) throws PortalException {
        service.deletePet(petId);
    }

    @Override
    public Pet putPet(Long petId, Pet pet) {
        return service.updatePet(
                contextUser.getUserId(),
                petId,
                pet,
                getServiceContext()
        );
    }

    @Override
    public Pet postPet(Pet pet) {
        return service.postPet(
                contextUser.getUserId(),
                pet,
                getServiceContext()
        );
    }

    public ServiceContext getServiceContext() {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(contextCompany.getCompanyId());
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());

        return serviceContext;
    }

    @Reference
    PetService service;
}