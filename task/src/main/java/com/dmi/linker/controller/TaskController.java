package com.dmi.linker.controller;

import com.dmi.linker.configuration.TestConfData;
import com.dmi.linker.model.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private final TestConfData testConfData;

    @Autowired
    public TaskController(TestConfData testConfData) {
        this.testConfData = testConfData;
    }

    @PostMapping
    public String createTask() {
        return "Task created";
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getTasks(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "10") int limit,
                                                       @RequestParam(value = "sort", required = false) String sort) {

        final var objects = new ArrayList<TaskResponse>();
        objects.add(new TaskResponse(testConfData.getTest(), UUID.randomUUID().toString()));
        objects.add(new TaskResponse("task2", UUID.randomUUID().toString()));
        return ResponseEntity.ok(objects);

    }


}
