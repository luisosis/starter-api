package com.starter.api.starterapi.model;

import java.time.LocalDateTime;

public record TaskDto(
        String title, String description, String status,LocalDateTime dueDate,
        LocalDateTime createdAt, LocalDateTime updatedAt, Long userId) {
}
