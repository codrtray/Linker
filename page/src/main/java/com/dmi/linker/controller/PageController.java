package com.dmi.linker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page")
@Slf4j
public class PageController {

    @GetMapping("/{id}")
    public String getPage(@PathVariable String id) {
        log.info("distributed tracing, page service");
        return id;
    }
}
