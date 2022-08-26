package com.example

import com.example.DatabaseConfiguration.DatabaseConnection
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 9090, host = "0.0.0.0") {
        install(ContentNegotiation){
            gson()
        }
        DatabaseConnection.init()
        configureRouting()
    }.start(wait = true)
}