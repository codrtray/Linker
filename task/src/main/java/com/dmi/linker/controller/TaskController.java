package com.dmi.linker.controller;

import com.dmi.linker.model.TaskResponse;
import com.dmi.linker.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public String createTask() {
        return "Task created";
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable(value = "id") String taskId,
                                                @RequestParam(required = false, defaultValue = "false") boolean addinfo) {

        final var task = taskService.getTask(taskId, addinfo);

        if (task.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(task.get());
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getTasks(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "limit", defaultValue = "10") int limit,
                                                       @RequestParam(value = "sort", required = false) String sort) {

        final var objects = new ArrayList<TaskResponse>();
//        objects.add(new TaskResponse(testConfData.getTest(), UUID.randomUUID().toString()));
//        objects.add(new TaskResponse("task2", UUID.randomUUID().toString()));
        return ResponseEntity.ok(objects);

    }


}
