package com.dmi.linker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {
    private String name;
    private String description;
    private String pageId;
}
