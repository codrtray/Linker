package com.dmi.linker.mapper;

import com.dmi.linker.data.GroupDto;
import com.dmi.linker.data.UserDto;
import com.dmi.linker.model.UserResponseModel;
import org.mapstruct.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserDtoMapper {
    public UserResponseModel toUserDto(UserDto userDto) {

        UserResponseModel userResponseModel = new UserResponseModel();
        userResponseModel.setEmail(userDto.getEmail());
        userResponseModel.setFullname(userDto.getFullname());

        Set<String> groups = userDto.getGroups().stream()
                .map(GroupDto::getName)
                .collect(Collectors.toSet());

        userResponseModel.setGroups(groups);

        return userResponseModel;
    }
}
