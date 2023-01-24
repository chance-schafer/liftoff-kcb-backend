package org.launchcode.liftoff_kcb_backend.mapper;

import org.launchcode.liftoff_kcb_backend.dto.OwnerTypeDto;
import org.launchcode.liftoff_kcb_backend.model.OwnerType;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface OwnerTypeMapper {

    OwnerTypeDto modelToDto(OwnerType ownerType);
    OwnerType dtoToModel(OwnerTypeDto ownerTypeDto);

    Set<OwnerTypeDto> modelsToDtos(Set<OwnerType> ownerTypes);
    Set<OwnerType> dtosToModels(Set<OwnerTypeDto> ownerTypeDtos);
}
