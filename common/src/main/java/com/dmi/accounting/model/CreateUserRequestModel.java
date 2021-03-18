package com.dmi.accounting.model;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter @Setter
public class CreateUserRequestModel {
    @NotBlank(message = "Name must not be blank")
    private String fullname;
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, message = "Password must be more 8 characters")
    private String password;

    @Size(min = 1)
    @NotNull
    private Set<String> groups;
}
