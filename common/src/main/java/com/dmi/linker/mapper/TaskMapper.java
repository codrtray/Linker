package com.dmi.linker.mapper;

import com.dmi.linker.entity.Task;
import com.dmi.linker.model.TaskResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskResponse taskToTaskResponse(Task task);
}
