package org.launchcode.liftoff_kcb_backend.mapper;

import org.launchcode.liftoff_kcb_backend.dto.BusinessDTO;
import org.launchcode.liftoff_kcb_backend.dto.BusinessInfo;
import org.launchcode.liftoff_kcb_backend.model.Business;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BusinessMapper {
    BusinessDTO modelToDto(Business business);

    Business dtoToModel(BusinessDTO businessDTO);

    BusinessInfo modelToInfo(Business business);

    Business infoToModel(BusinessInfo businessInfo);

    Collection<BusinessDTO> modelsToDtos(Collection<Business> businesses);

    Collection<BusinessInfo> modelsToInfos(Collection<Business> businesses);
}
