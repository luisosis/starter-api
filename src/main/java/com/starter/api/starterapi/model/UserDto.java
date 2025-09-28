package com.starter.api.starterapi.model;

import java.time.LocalDateTime;

public record UserDto(String name, String email, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
