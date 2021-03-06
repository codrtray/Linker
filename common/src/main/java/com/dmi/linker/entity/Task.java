package com.dmi.linker.entity;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Getter @Setter
@NoArgsConstructor
public class Task {

    private Long id;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(nullable = false, unique = true, length = 36)
    @NaturalId
    private String taskId;

    @Column
    private String parentId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_generator")
    @SequenceGenerator(name="task_generator", sequenceName = "task_seq", allocationSize=10)
    @Column(name = "id", updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equal(taskId, task.taskId);
    }

    @Override
    public int hashCode() {
        if (name != null) {
            final var hashCode = name.hashCode();
            return (int) (hashCode ^ (hashCode >>> 4));
        } else {
            return 0;
        }
    }
}
