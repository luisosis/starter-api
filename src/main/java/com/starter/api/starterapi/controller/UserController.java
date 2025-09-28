package com.starter.api.starterapi.controller;

import com.starter.api.starterapi.model.UserDto;
import com.starter.api.starterapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public Flux<UserDto> getAllUsers() {
        log.info("getAllUsers init");
        return userService.getAllUsers()
                .doOnNext(userDto -> log.debug("User fetched: {}", userDto));
    }

    @PostMapping
    public Mono<UserDto> createUser(@RequestBody UserDto user) {
        log.info("createUser with email: {}", user.email());
        return userService.createUser(user)
                .doOnSuccess(userDto -> log.info("user create sucessfully {}", user))
                .doOnError(throwable -> log.error("Error creating user", throwable));
    }
}
