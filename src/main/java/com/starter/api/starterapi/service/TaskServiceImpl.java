package com.starter.api.starterapi.service;

import com.starter.api.starterapi.model.TaskDto;
import com.starter.api.starterapi.model.TaskEntity;
import com.starter.api.starterapi.repository.TaskRepository;
import com.starter.api.starterapi.repository.UserRepository;
import com.starter.api.starterapi.util.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public Mono<TaskDto> saveTasks(TaskDto taskDto) {

      var user =  userRepository.findById(taskDto.userId())
              .orElseThrow(() -> new RuntimeException("User not found"));

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(taskDto.title());
        taskEntity.setDescription(taskDto.description());
        taskEntity.setStatus(Status.CREATE.toString());
        taskEntity.setUser(user);
        taskEntity.setCreatedAt(LocalDateTime.now());
        taskEntity.setDueDate(LocalDateTime.now());

        return Mono.fromCallable(() -> taskRepository.save(taskEntity))
                .map(entity -> new TaskDto(entity.getTitle(),
                         entity.getDescription(),
                        entity.getStatus(),entity.getDueDate(),
                        entity.getCreatedAt(),
                        entity.getUpdatedAt(),
                        entity.getId()));
    }
}
