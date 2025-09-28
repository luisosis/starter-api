package com.starter.api.starterapi.service;

import com.starter.api.starterapi.model.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<UserDto> getAllUsers();

    Mono<UserDto> createUser(UserDto user);
}
