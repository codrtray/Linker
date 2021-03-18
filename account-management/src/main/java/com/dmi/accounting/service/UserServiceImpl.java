package com.dmi.accounting.service;

import com.dmi.accounting.data.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final Map<String, UserDto> integerUserDtoMap = new HashMap<>();

    @Override
    public Optional<String> createUser(UserDto userDto) {
        String newKey = UUID.randomUUID().toString();
        log.trace("New user key is {}", newKey);
        integerUserDtoMap.put(newKey, userDto);
        return Optional.of(newKey);
    }

    @Override
    public Optional<UserDto> getUser(String id) {
        UserDto userDto = integerUserDtoMap.get(id);
        return Optional.ofNullable(userDto);
    }
}
