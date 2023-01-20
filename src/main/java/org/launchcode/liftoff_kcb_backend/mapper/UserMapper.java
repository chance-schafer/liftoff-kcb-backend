package org.launchcode.liftoff_kcb_backend.mapper;

import org.launchcode.liftoff_kcb_backend.dto.UserDTO;
import org.launchcode.liftoff_kcb_backend.dto.UserInfo;
import org.launchcode.liftoff_kcb_backend.model.User;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO modelToDto(User user);

    User dtoToModel(UserDTO userDTO);

    UserInfo modelToInfo(User user);

    User infoToModel(UserInfo userInfo);

    Collection<UserDTO> modelsToDtos(Collection<User> users);

    Collection<UserInfo> modelsToInfos(Collection<User> users);
}
