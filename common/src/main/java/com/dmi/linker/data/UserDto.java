package com.dmi.linker.data;

import lombok.*;

import java.util.Set;

@Value
public class UserDto {
    String fullname;
    String email;
    String password;
    Set<GroupDto> groups;
}
