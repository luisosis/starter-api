package com.starter.api.starterapi.service;

import com.starter.api.starterapi.model.TaskDto;
import reactor.core.publisher.Mono;

public interface TaskService {

    Mono<TaskDto> saveTasks(TaskDto taskDto);

    Mono<TaskDto> updateTask(Long idTask, String status);
}
