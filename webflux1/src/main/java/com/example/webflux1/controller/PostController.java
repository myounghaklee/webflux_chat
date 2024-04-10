package com.example.webflux1.controller;

import com.example.webflux1.dto.PostResponse;
import com.example.webflux1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public Mono<PostResponse> getPostContent(@PathVariable Long id){
        return postService.getPostContent(id);
    }

    @GetMapping("/search")
    public Flux<PostResponse> getMultiPostContents(@RequestParam(name = "ids") List<Long> idList){
        return postService.getMultiplePostContent(idList);
    }
}
