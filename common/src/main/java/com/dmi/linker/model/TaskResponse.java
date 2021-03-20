package com.dmi.linker.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TaskResponse {
    private String name;
    private String taskId;
}
