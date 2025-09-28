package com.starter.api.starterapi.repository;

import com.starter.api.starterapi.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
