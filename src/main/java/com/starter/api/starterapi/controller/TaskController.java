package com.starter.api.starterapi.controller;

import com.starter.api.starterapi.model.TaskDto;
import com.starter.api.starterapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/save")
    public Mono<TaskDto> saveTask(@RequestBody TaskDto taskDto) {
        return taskService.saveTasks(taskDto);
    }

    @PutMapping
    public Mono<TaskDto> update(@RequestBody TaskDto taskDto) {

        return null;
    }
}
