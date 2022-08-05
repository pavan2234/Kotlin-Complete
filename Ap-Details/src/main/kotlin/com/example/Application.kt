package com.example

import com.example.Practice.MobleRepo
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.repositaries.*
import com.example.routes.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8088, host = "0.0.0.0") {
        install(ContentNegotiation){
            json(Json{ ignoreUnknownKeys = true })
        }
        configureRouting()
        AddressConfigureRepo()
        VehicleConfigureRepo()
        NomineeConfigureRepo()
        OrderConfigureRepo()
        Prev_PolicieConfigureRepo()
        QuoteConfigureRepo()
        Vehicle_DerivedConfigureRepo()
        customerConfigure()
        ConfigureVehicleRoute()
        ConfigureCustomerRoute()
        ConfigureAddressRoute()
        ConfigureNomineRoute()
        ConfigureOrderRoute()
        ConfigurePrev_PolicyRoute()
        ConfigureQuoteRoute()
        ConfigureVehicle_DerivedRoute()
        MobleRepo()
    }.start(wait = true)
}
