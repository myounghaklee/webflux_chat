package com.example.webflux1.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PostClient {
    private final WebClient webClient;
    private final String url = "http://127.09.0.1:8090";

    public Mono<?> getPost(Long id){
        String uriString  = UriComponentsBuilder.fromHttpUrl(url)
                .path("/posts/%d".formatted(id))
                .buildAndExpand()
                .toUriString();

        webClient.get()
                .uri(uriString)
                .retrieve()
                .bodyToMono();
    }
}
