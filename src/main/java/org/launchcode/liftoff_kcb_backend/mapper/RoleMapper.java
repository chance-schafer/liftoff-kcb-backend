package org.launchcode.liftoff_kcb_backend.mapper;

import org.launchcode.liftoff_kcb_backend.dto.BusinessDTO;
import org.launchcode.liftoff_kcb_backend.dto.BusinessInfo;
import org.launchcode.liftoff_kcb_backend.dto.RoleDto;
import org.launchcode.liftoff_kcb_backend.model.Business;
import org.launchcode.liftoff_kcb_backend.model.Role;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto modelToDto(Role role);
    Role dtoToModel(RoleDto roleDto);
    Collection<RoleDto> modelsToDtos(Collection<Role> roles);
    Collection<Role> dtosToModels(Collection<RoleDto> roleDtos);

}
