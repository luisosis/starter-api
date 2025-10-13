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

    @PutMapping("/{id}/status")
    public Mono<TaskDto> update(@PathVariable Long id, @RequestParam String status) {

        return taskService.updateTask(id, status);
    }
}
