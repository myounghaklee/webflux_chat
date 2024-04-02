package com.example.webflux_core;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Operator1Test {

    private Operator1 operator1 = new Operator1();
    @Test
    void fluxMap(){
        StepVerifier.create(operator1.fluxMap())
                .expectNext(2,4,6,8,10,12,14,16,18,20)
                .verifyComplete();
    }

}