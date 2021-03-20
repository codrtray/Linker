package com.dmi.linker.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class LoginUser {
    @NotBlank(message = "Pass username")
    private String fullname;
    private String password;
}
