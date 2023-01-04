package com.example.client

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import java.util.logging.Logger

@Configuration
class AppSetup {
    @Bean
    fun webClient(): WebClient = WebClient.create("http://localhost:8099")

    @Bean
    fun logger(): Logger = Logger.getLogger("client")
}