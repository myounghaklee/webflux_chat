package com.example.webflux1.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableR2dbcRepositories
@EnableR2dbcAuditing
public class R2dbcConfig implements ApplicationListener<ApplicationReadyEvent> {

    private final DatabaseClient databaseClient;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        //reactor : publisher, subscriber
        databaseClient.sql("SELECT 1").fetch().one()
                .subscribe(
                        success -> {
                            log.info("Initilaize Success");
                        },
                        error -> {
                            log.error("Fail to initialize r2dbc");
                        }
                );

    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
