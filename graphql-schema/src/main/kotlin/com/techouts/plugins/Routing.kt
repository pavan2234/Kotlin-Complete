package com.techouts.plugins

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*


fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
