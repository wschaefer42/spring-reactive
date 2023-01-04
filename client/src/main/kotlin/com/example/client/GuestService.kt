package com.example.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@Service
class GuestService {
    @Autowired
    lateinit var webClient: WebClient

    fun getAll(): Flux<Guest> = webClient.get()
        .uri("/guests")
        .retrieve()
        .bodyToFlux(Guest::class.java)
}