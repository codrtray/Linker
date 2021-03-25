package com.dmi.linker.controller;

import org.springframework.stereotype.Component;

@Component
public class PageClientFallback implements PageClient {
    @Override
    public String getPageByTask(String taskId) {
        return "Page not found";
    }
}
