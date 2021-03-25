package com.dmi.linker.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {
    @GetMapping("/sample")
//    @Retry(name = "sample", fallbackMethod = "fallbackMethod")
    @CircuitBreaker(name = "sample2", fallbackMethod = "fallbackMethod")
    public String sampleApi() {
        log.info("Sample api call");
        final var forEntity = new RestTemplate()
                .getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return forEntity.getBody();
    }

    public String fallbackMethod(Exception e) {
        return "fallback result";
    }



}
