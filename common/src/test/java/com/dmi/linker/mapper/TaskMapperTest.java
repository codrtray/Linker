package com.dmi.linker.mapper;

import com.dmi.linker.entity.Task;
import com.dmi.linker.model.TaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

class TaskMapperTest {

    private TaskMapper taskMapper;

    @BeforeEach
    void  init() {
        taskMapper = new TaskMapperImpl();
    }

    @DisplayName("test task mapper")
    @ParameterizedTest
    @CsvSource({
            "task1, description1",
            "task2, description2"
    })
    void taskMapperTest(ArgumentsAccessor argumentsAccessor) {

        final var task = getTask(argumentsAccessor);
        final var expectedTaskResponse = getTaskResponse(argumentsAccessor);

        final var actualTaskResponse = taskMapper.taskToTaskResponse(task);
        assertThat(expectedTaskResponse, samePropertyValuesAs(actualTaskResponse));
    }

    private Task getTask(ArgumentsAccessor argumentsAccessor) {
        final var task = new Task();
        task.setName(argumentsAccessor.getString(0));
        task.setDescription(argumentsAccessor.getString(1));
        return task;
    }
    private TaskResponse getTaskResponse(ArgumentsAccessor argumentsAccessor) {
        final var taskResponse = new TaskResponse();
        taskResponse.setName(argumentsAccessor.getString(0));
        taskResponse.setDescription(argumentsAccessor.getString(1));
        return taskResponse;
    }
}