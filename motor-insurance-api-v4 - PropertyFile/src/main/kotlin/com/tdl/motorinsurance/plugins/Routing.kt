package com.tdl.plugins

import com.tdl.motorinsurance.routings.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    configureNomineeRouting()
    configureCustomerRouting()
    configureAddressRouting()
    configurePrev_PolicyRouting()
    configureQuoteRouting()
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
