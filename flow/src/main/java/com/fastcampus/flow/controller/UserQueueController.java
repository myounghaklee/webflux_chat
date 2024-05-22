package com.fastcampus.flow.controller;

import com.fastcampus.flow.dto.AllowUserResponse;
import com.fastcampus.flow.dto.AllowedUserResponse;
import com.fastcampus.flow.dto.RegisterUserResponse;
import com.fastcampus.flow.service.UserQueueService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/queue")
public class UserQueueController {
    private static UserQueueService userQueueService;

    @PostMapping("")
    public Mono<RegisterUserResponse> reqisterUser(@RequestParam(name = "queue", defaultValue = "default") String queue,
                                                   @RequestParam(name = "user_id") Long userId) {
        return userQueueService.registerWaitQueue(queue, userId)
                .map(RegisterUserResponse::new);
    }

    @PostMapping("/allow")
    public Mono<AllowUserResponse> allowUser(@RequestParam(name = "queue", defaultValue = "default") String queue,
                                             @RequestParam(name = "user_id") Long count) {
        return userQueueService.allowUser(queue, count)
                .map(allowed -> new AllowUserResponse(count, allowed));
    }

    @GetMapping("/allow")
    public Mono<AllowedUserResponse> isAllowedUser(@RequestParam(name = "queue", defaultValue = "default") String queue,
                                             @RequestParam(name = "user_id") Long userId) {
        return userQueueService.isAllowed(queue, userId)
                .map(AllowedUserResponse::new);
    }

}
