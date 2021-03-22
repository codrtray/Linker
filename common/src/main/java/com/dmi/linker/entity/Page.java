package com.dmi.linker.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "page")
@Getter
@Setter
@NoArgsConstructor
public class Page {

    protected long id;

    @NaturalId
    @Column(length = 36)
    private String pageId;
    @Column(length = 2048, nullable = false)
    private String url;
    @Column
    private OffsetDateTime created;
    @Column(length = 36)
    private String taskId;
    @Column(length = 36)
    private String noteId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "page_generator")
    @SequenceGenerator(name = "page_generator", sequenceName = "page_seq", allocationSize = 10)
    @Column(name = "id", updatable = false, nullable = false)
    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page that = (Page) o;

        if (id != that.id) return false;
        return taskId != null ? taskId.equals(that.taskId) : that.taskId == null;
    }

    @Override
    public int hashCode() {
        if (taskId != null) {
            final var hashCode = taskId.hashCode();
            return (int) (hashCode ^ (hashCode >>> 4));
        } else {
            return 0;
        }
    }
}
