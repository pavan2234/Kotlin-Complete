package com.example

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0"){
        install(ContentNegotiation){
            json()
        }
        //module()
        Routing()
    }.start(wait = true)
}