package com.dmi.accounting.controller;

import com.dmi.accounting.data.UserDto;
import com.dmi.accounting.exception.UserNotFoundException;
import com.dmi.accounting.mapper.CreateUserMapper;
import com.dmi.accounting.mapper.UserDtoMapper;
import com.dmi.accounting.model.CreateUserRequestModel;
import com.dmi.accounting.model.UserResponseModel;
import com.dmi.accounting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final CreateUserMapper createUserMapper;
    private final UserDtoMapper userDtoMapper;
    private final UserService userService;

    @Autowired
    public UserController(CreateUserMapper createUserMapper, UserDtoMapper userDtoMapper,
                          UserService userService) {
        this.createUserMapper = createUserMapper;
        this.userDtoMapper = userDtoMapper;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseModel> getUser(@PathVariable String id) {
        Optional<UserDto> user = userService.getUser(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("User with id:%s is not found", id));
        }
        UserResponseModel userResponseModel = userDtoMapper.toUserDto(user.get());
        return ResponseEntity.ok(userResponseModel);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody CreateUserRequestModel createUserRequestModel) {

        UserDto userDto = createUserMapper.toUserDto(createUserRequestModel);
        Optional<String> userId = userService.createUser(userDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userId.orElse("null")).toUri();
        return ResponseEntity.created(location).build();
    }
}