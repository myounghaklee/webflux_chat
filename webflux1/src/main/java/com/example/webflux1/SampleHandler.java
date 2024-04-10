package com.example.webflux1;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class SampleHandler {
    public Mono<ServerResponse> getString(ServerRequest request){
        return ServerResponse.ok().bodyValue("hello, functional endpoint");
    }
}
