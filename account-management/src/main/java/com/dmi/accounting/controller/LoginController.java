package com.dmi.accounting.controller;

import com.dmi.accounting.model.LoginUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @PostMapping(value = "/login")
    public void loginUser(@Valid @RequestBody LoginUser loingUser) {

    }
}
