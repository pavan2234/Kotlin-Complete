package com.example

import com.example.route.configureCustomerRouting
import com.org.db.DatabaseFactory
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.engine.*
import io.ktor.server.netty.* import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8089, host = "0.0.0.0") {
       install(ContentNegotiation){
           json()
       }
        DatabaseFactory.init()
        /*configureRouting()
        configureReservationsRouting()*/
        configureCustomerRouting()
    }.start(wait = true)
}
