package com.example

import io.ktor.server.engine.*
import io.ktor.server.tomcat.*
import com.example.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Tomcat, port = 8080, host = "0.0.0.0") {
    install(ContentNegotiation){
        json()
    }
        //configureRouting()
        Printing()

    }.start(wait = true)
}
