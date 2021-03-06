package com.dmi.linker;

import com.dmi.linker.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties
@EnableFeignClients
@Slf4j
public class TaskApplication {

    @Autowired
    private Environment env;

    @Autowired
    private TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void outputMessage() {
        log.info(env.getProperty("user.dir"));
    }
}
