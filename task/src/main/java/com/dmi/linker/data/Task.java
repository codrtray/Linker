package com.dmi.linker.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
@Getter @Setter
@NoArgsConstructor
public class Task {
    private Long id;
    private String name;
    private String description;
    private String taskId;
    private String parentId;

    @Id
    public Long getId() {
        return id;
    }
}
