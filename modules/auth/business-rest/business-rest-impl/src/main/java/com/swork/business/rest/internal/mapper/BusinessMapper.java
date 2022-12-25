package com.swork.business.rest.internal.mapper;

import com.swork.business.rest.dto.v1_0.Business;
import com.swork.business.service.mapper.model.BusinessMapperModel;
import com.swork.business.service.model.BusinessEntry;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        service = BusinessMapper.class
)
public class BusinessMapper {
    public BusinessMapperModel mapMapperModelFromDTO(Business from) {
        BusinessMapperModel to = new BusinessMapperModel();

        to.setName(from.getName());
        to.setCustomerName(from.getCustomerName());
        to.setPhoneNumber(from.getPhoneNumber());
        to.setEmail(from.getEmail());
        to.setBusinessAddress(from.getBusinessAddress());
        to.setFieldOperations(from.getFieldOperations());

        return to;
    }

    public Business mapDTOFromEntry(BusinessEntry from) {
        Business to = new Business();

        to.setId(from.getBusinessId());
        to.setExternalReferenceCode(from.getExternalReferenceCode());
        to.setName(from.getName());
        to.setCustomerName(from.getCustomerName());
        to.setPhoneNumber(from.getPhoneNumber());
        to.setEmail(from.getEmail());
        to.setBusinessAddress(from.getBusinessAddress());
        to.setFieldOperations(from.getFieldOperations());
        to.setStatus(Business.Status.create(from.getStatus()));

        return to;
    }
}
