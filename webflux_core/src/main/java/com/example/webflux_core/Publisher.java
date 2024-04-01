package com.example.webflux_core;

import reactor.core.publisher.Flux;

public class Publisher {

    public Flux<Integer> startFlux(){
        return Flux.range(1, 10).log();
    }
}
