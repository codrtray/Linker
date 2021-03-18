package com.dmi.accounting.mapper;

import com.dmi.accounting.data.GroupDto;
import com.dmi.accounting.data.UserDto;
import com.dmi.accounting.model.UserResponseModel;
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
