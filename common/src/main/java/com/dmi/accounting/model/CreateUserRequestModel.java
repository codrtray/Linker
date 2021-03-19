package com.dmi.accounting.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter @Setter
@ApiModel(description = "All details about the user.")
public class CreateUserRequestModel {
    @NotBlank(message = "Name must not be blank")
    @ApiModelProperty(notes = "Pass first name and last name")
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
