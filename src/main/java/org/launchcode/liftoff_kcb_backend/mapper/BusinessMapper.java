package org.launchcode.liftoff_kcb_backend.mapper;

import org.launchcode.liftoff_kcb_backend.dto.BusinessDTO;
import org.launchcode.liftoff_kcb_backend.model.Business;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusinessMapper {
    BusinessMapper INSTANCE = Mappers.getMapper(BusinessMapper.class);
    BusinessDTO modelToDto(Business business);
    Business dtoToModel(BusinessDTO businessDTO);
}
