package com.starter.api.starterapi.service;

import com.starter.api.starterapi.mapper.UserMapper;
import com.starter.api.starterapi.model.UserDto;
import com.starter.api.starterapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Flux<UserDto> getAllUsers() {
        log.debug("Fetching get all users");
        return Flux.fromIterable(userRepository.findAll()
                .stream()
                .map(userMapper::toApi)
                .collect(Collectors.toList()));
    }

    @Override
    public Mono<UserDto> createUser(UserDto user) {
        log.debug("Creating user: {}", user);
        return Mono.fromCallable(() -> userMapper.toApi(
                userRepository.save(userMapper.toEntity(user))));
    }
}
