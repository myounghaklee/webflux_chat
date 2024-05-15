package com.fastcampus.flow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserQueueService {

    private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    //대기열 등록
    public Mono<?> registerWaitQueue(final Long userId){
        //redis sortedset
        //-key : userId
        // - value : unix timestamp
        
    }
}
