package com.example.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.karateroute(){
    routing {
        get("/helloworld") {
            call.respondText("Hello World")
        }
    }
}
