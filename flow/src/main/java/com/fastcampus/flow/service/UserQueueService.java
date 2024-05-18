package com.fastcampus.flow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserQueueService {

    private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    //대기열 등록
    public Mono<Long> registerWaitQueue(final Long userId) {
        //redis sortedset
        //-key : userId
        // - value : unix timestamp
        var unixTimeStamp = Instant.now().getEpochSecond();
        return reactiveRedisTemplate.opsForZSet().add("user-queue", userId.toString(), unixTimeStamp)
                .filter(i -> i)
                .switchIfEmpty(Mono.error(new Exception("already register user...")))
                .flatMap(i -> reactiveRedisTemplate.opsForZSet().rank("user-queue", userId.toString()))
                .map(i -> i >= 0 ? i + 1 : i);

    }
}
