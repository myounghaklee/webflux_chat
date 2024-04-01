package com.example.webflux_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebfluxCoreApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebfluxCoreApplication.class, args);
        var publisher = new Publisher();
        publisher.startFlux().subscribe(i-> System.out.println(i));
    }

}
