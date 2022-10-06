package com.example.plugins

import com.example.routing.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    busrouting()
    collegerouting()
    companyrouting()
    locationrouting()
    personalrouting()
    placementrouting()
}
