package com.dmi.linker.service;

import com.dmi.linker.data.UserDto;

import java.util.Optional;

public interface UserService {
    Optional<String> createUser(UserDto userDto);
    Optional<UserDto> getUser(String id);

    boolean deleteUserById(String id);
}
