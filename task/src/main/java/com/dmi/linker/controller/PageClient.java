package com.dmi.linker.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "page-ws", fallback = PageClientFallback.class)
public interface PageClient {

    @GetMapping("/page/{id}")
    String getPageByTask(@PathVariable(value = "id") String taskId);
}
