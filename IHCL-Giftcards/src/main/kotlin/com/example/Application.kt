package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.repositaries.GiftInfo
import com.example.routes.GiftCardConfigureRoute
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation){
            json()
        }
        GiftInfo()
        GiftCardConfigureRoute()
        configureRouting()
    }.start(wait = true)
}
