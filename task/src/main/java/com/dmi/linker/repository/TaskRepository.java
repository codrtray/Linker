package com.dmi.linker.repository;

import com.dmi.linker.entity.Task;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
