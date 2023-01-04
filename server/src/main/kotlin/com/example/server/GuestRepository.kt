package com.example.server

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface GuestRepository : ReactiveCrudRepository<Guest, Long> {
    @Query("SELECT * FROM guest WHERE name = :name")
    fun findByName(name: String): Mono<Guest>
}