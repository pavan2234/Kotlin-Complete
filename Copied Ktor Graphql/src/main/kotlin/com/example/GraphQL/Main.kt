package com.example.GraphQL

import com.apurebase.kgraphql.GraphQL
import com.example.plugins.Printing
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.tomcat.*

fun main() {
    embeddedServer(Tomcat, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation){
            json()
        }


    }.start(wait = true)
}