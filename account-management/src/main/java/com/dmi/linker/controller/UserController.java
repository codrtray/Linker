package com.dmi.linker.controller;

import com.dmi.linker.data.UserDto;
import com.dmi.linker.exception.UserNotFoundException;
import com.dmi.linker.mapper.CreateUserMapper;
import com.dmi.linker.mapper.UserDtoMapper;
import com.dmi.linker.model.CreateUserRequestModel;
import com.dmi.linker.model.UserResponseModel;
import com.dmi.linker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final CreateUserMapper createUserMapper;
    private final UserDtoMapper userDtoMapper;
    private final UserService userService;
    private final MessageSource messageSource;

    @Autowired
    public UserController(CreateUserMapper createUserMapper, UserDtoMapper userDtoMapper,
                          UserService userService, MessageSource messageSource) {
        this.createUserMapper = createUserMapper;
        this.userDtoMapper = userDtoMapper;
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public ResponseEntity<?> retrieveAllUsers() {
        return ResponseEntity.ok("It is ok");
    }

    @GetMapping("/{id}")
    public EntityModel<UserResponseModel> getUser(@PathVariable String id) {
        Optional<UserDto> user = userService.getUser(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("User with id:%s is not found", id));
        }
        UserResponseModel userResponseModel = userDtoMapper.toUserDto(user.get());

        EntityModel<UserResponseModel> resource = EntityModel.of(userResponseModel);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserRequestModel requestModel) {

        UserDto userDto = createUserMapper.toUserDto(requestModel);
        Optional<String> userId = userService.createUser(userDto);

        String message = messageSource.getMessage("user-is-created", null, LocaleContextHolder.getLocale());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userId.orElse("null")).toUri();
        return ResponseEntity.created(location).body(message);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        boolean isUserDeleted = userService.deleteUserById(id);
        if (!isUserDeleted) {
            throw new UserNotFoundException("User is not deleted");
        }
    }
}
