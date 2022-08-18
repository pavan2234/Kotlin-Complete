package com.example.plugins

import com.example.routes.ReservationRouting
import io.ktor.server.application.*

fun Application.configureRouting() {

    ReservationRouting()
}
