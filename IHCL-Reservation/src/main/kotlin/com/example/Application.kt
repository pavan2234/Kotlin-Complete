package com.example

import com.example.Repositories.ReservationInserting
import com.example.Routes.ReservationRouting
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation){
            json()
        }
        ReservationInserting()
        ReservationRouting()
    }.start(wait = true)
}
