package org.launchcode.liftoff_kcb_backend.mapper;

import org.launchcode.liftoff_kcb_backend.dto.RoleDto;
import org.launchcode.liftoff_kcb_backend.dto.RolesDTO;
import org.launchcode.liftoff_kcb_backend.model.Role;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {


    RoleDto modelToDto(Role role);

    Role dtoToModel(RoleDto roleDto);

    default RolesDTO toDto(Set<Role> roles) {
        RolesDTO rolesDTO = new RolesDTO();
        rolesDTO.setRoles(roles);
        return rolesDTO;
    }

//    Set<Role> toEntity(RolesDTO rolesDTO);


}
