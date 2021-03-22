package com.dmi.linker.service;

import com.dmi.linker.model.TaskResponse;

import java.util.Optional;

public interface TaskService {
    Optional<TaskResponse> getTask(String taskId, Boolean additionalInfo);
}
