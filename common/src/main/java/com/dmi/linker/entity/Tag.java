package com.dmi.linker.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tag")
@Getter
@Setter
@NoArgsConstructor
public class Tag {

    protected long id;

    @Column(nullable = false, length = 30)
    private String name;
    @Column(length = 36)
    private String parentId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_generator")
    @SequenceGenerator(name = "tag_generator", sequenceName = "tag_seq", allocationSize = 10)
    @Column(name = "id", updatable = false, nullable = false)
    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag that = (Tag) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
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
