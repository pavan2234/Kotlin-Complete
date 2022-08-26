package com.example.plugins

import com.example.routes.karateroute
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    karateroute()

}
