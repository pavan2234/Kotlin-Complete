package com.techouts

import configureGraphQL
import io.ktor.server.engine.*
import io.ktor.server.tomcat.*
import com.techouts.plugins.configureRouting
import com.techouts.plugins.configureSerialization
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*

fun main() {
    embeddedServer(Tomcat, port = 9091, host = "localhost") {/*
        install(ContentNegotiation){
            json()
        }*/
       // configureRouting()
        //configureSerialization()
        configureGraphQL()
    }.start(wait = true)
}
