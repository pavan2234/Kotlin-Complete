package com.example

import io.ktor.server.engine.*
import configureGraphQL
import io.ktor.server.tomcat.*

fun main() {
    embeddedServer(Tomcat, port = 8084, host = "0.0.0.0") {
        configureGraphQL()

    }.start(wait = true)
}
