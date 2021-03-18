package com.dmi.accounting.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter @Getter
public class UserResponseModel {
    private String fullname;
    private String email;
    private Set<String> groups;
}
