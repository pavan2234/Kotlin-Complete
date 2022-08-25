package com.example

import com.example.DatabaseConfiguration.DatabaseConnection
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import org.ktorm.database.Database

fun main() {
    embeddedServer(Netty, port = 8095, host = "0.0.0.0") {
        install(ContentNegotiation){
            json()
        }
        DatabaseConnection.init()
        configureRouting()
    }.start(wait = true)
}