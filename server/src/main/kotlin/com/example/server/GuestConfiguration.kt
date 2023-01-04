package com.example.server

import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.kotlin.core.publisher.switchIfEmpty

@Configuration
class GuestConfiguration {
    @Autowired
    lateinit var logger: Logger

    @Bean
    fun databaseInitialization(guestRepository: GuestRepository): ApplicationRunner {
        return ApplicationRunner {
            logger.info("initialize guestbook table")
            val guests = listOf(
                Guest("Roger Federer", "Basel", "I am the best tennis player"),
                Guest("Julius Cesar", "Rom", "I am the greatest military general ever"),
                Guest("Paul McCarney", "London", "I was the Beatles"),
                Guest("Charlie Chaplin", "Geneva", "I was a great artist"))
            for (guest in guests) {
                guestRepository.findByName(guest.name).switchIfEmpty {
                    guestRepository.save(guest)
                }.subscribe {
                    logger.info("add new guest %$guest")
                }
            }
        }
    }
}