package com.example.server

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/guests")
class GuestResource(val guestRepository: GuestRepository) {
    @GetMapping
    fun getAll(): Flux<Guest> {
        return guestRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id")id: Long): Mono<Guest> {
        return guestRepository.findById(id)
    }
}