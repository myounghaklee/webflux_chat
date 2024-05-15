package com.fastcampus.flow.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/queue")
public class UserQueueController {
    private final UserQueueService userQueueService;

    @PostMapping("")
    public Mono<?> reqisterUser(@RequestParam(name = "user_id")Long userId){
        return userQueueService.regisetWaitQueue(userId);''
    }


}
