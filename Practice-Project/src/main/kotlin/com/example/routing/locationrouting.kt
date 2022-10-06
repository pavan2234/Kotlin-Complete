package com.example.routing

import com.example.model.companyDTO
import com.example.model.locationDTO
import com.example.service.companyservice
import com.example.service.locationservice
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.locationrouting() {
    val locationserv = locationservice()
    routing {
        route("/api/route/college") {
            post("/saveLocationDetails") {
                val params = call.receive<locationDTO>()
                locationserv.saveLocatioDetails(params)
                call.respond("Data Inserted")
            }
            get("/getLocationDetails") {
                call.respond(locationserv.getLocationDetails())
            }
        }
    }
}