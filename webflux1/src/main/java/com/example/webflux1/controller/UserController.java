package com.example.webflux1.controller;

import com.example.webflux1.dto.UserCreateRequest;
import com.example.webflux1.dto.UserResponse;
import com.example.webflux1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public Mono<?> craeteUser(@RequestBody UserCreateRequest userCreateRequest){
        return userService.create(userCreateRequest.getName() , userCreateRequest.getEmail())
                .map(UserResponse::of);
    }

    @GetMapping
    public Flux<UserResponse> findAllUsers(){
        return userService.findAll()
                .map(UserResponse::of);
    }

    @GetMapping("/{id}")
    public Mono<UserResponse> findUser(@PathVariable Long id){
        return userService.findById(id)
                .map(UserResponse::of);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<?>> deleteUser(@PathVariable Long id){
        return userService.deleteById(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }


}
