package com.example.server

import org.springframework.data.annotation.Id

data class Guest (
    var name: String,
    var town: String,
    var message: String,
    @Id
    var id: Long = 0) {
    override fun toString(): String {
        return "Guest{$id, $name, $town, $message}"
    }
}