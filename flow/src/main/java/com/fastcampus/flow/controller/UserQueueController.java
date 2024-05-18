package com.fastcampus.flow.controller;

import com.fastcampus.flow.dto.RegisterUserResponse;
import com.fastcampus.flow.service.UserQueueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/queue")
public class UserQueueController {
    private static UserQueueService userQueueService;

    @PostMapping("")
    public Mono<RegisterUserResponse> reqisterUser(@RequestParam(name = "user_id")Long userId){
        return userQueueService.registerWaitQueue(userId)
                .map(RegisterUserResponse::new);
    }


}
