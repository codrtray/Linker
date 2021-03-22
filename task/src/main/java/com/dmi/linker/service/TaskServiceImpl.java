package com.dmi.linker.service;

import com.dmi.linker.controller.PageClient;
import com.dmi.linker.exception.AppException;
import com.dmi.linker.mapper.TaskMapper;
import com.dmi.linker.model.TaskResponse;
import com.dmi.linker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final PageClient pageClient;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, PageClient pageClient, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.pageClient = pageClient;
        this.taskMapper = taskMapper;
    }

    @Override
    public Optional<TaskResponse> getTask(String taskId, Boolean additionalInfo) {
        final var tasksOptional = taskRepository.findByTaskId(taskId);
        if (tasksOptional.isEmpty() || tasksOptional.get().size() == 0) {
            return Optional.empty();
        }
        final var tasks = tasksOptional.get();
        if (tasks.size() > 1) {
            throw new AppException("Too many tasks!");
        }
        final var taskResponse = taskMapper.taskToTaskResponse(tasks.get(0));
        if (additionalInfo) {
            taskResponse.setPageId(pageClient.getPageByTask(taskId));
        }
        return Optional.of(taskResponse);
    }

}
