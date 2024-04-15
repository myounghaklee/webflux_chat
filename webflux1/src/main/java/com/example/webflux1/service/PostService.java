package com.example.webflux1.service;

import com.example.webflux1.client.PostClient;
import com.example.webflux1.controller.PostController;
import com.example.webflux1.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService  {
    private final PostClient postClient;

    public Mono<PostResponse> getPostContent(Long id){
        return (Mono<PostResponse>) postClient.getPost(id);
    }

    public Flux<PostResponse> getMultiplePostContent(List<Long> idList) {
        return Flux.fromIterable(idList)
                .flatMap(this::getPostContent);
    }
}
