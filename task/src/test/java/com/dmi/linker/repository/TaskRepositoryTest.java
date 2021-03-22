package com.dmi.linker.repository;

import com.dmi.linker.entity.Task;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@ActiveProfiles("test")
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void saveTask() {
        final Session currentSession = entityManager.unwrap(Session.class);
        final var saved = taskRepository.save(createTask());
        taskRepository.flush();
        entityManager.detach(saved);
        final var gottenTask = currentSession.get(Task.class, saved.getId());

        assertNotSame(saved, gottenTask);
        assertThat(gottenTask, samePropertyValuesAs(saved));
    }

    private Task createTask() {
        final var task = new Task();
        task.setName("name1");
        task.setDescription("Description1");
        task.setTaskId(UUID.randomUUID().toString());
        task.setParentId(null);
        return task;
    }
}