package com.dmi.linker.mapper;

import com.dmi.linker.data.GroupDto;
import com.dmi.linker.data.UserDto;
import com.dmi.linker.model.CreateUserRequestModel;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class CreateUserMapper {
    public UserDto toUserDto(CreateUserRequestModel createUserRequestModel) {
        Set<String> groups = createUserRequestModel.getGroups();
        Set<GroupDto> groupDtos = new HashSet<>();
        for (String group : groups) {
            groupDtos.add(new GroupDto(group));
        }
        return new UserDto(createUserRequestModel.getFullname(),
                createUserRequestModel.getEmail(),
                createUserRequestModel.getPassword(),
                groupDtos);
    }
}
